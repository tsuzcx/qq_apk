package com.tencent.mobileqq.pttlogic.api.impl;

import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloadStrategy;
import com.tencent.mobileqq.ptt.temp.api.IPttTempApi;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader.IPreDownloadStrategy;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PttDownExtraInfo;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class PTTPreDownloaderImpl
  implements IPTTPreDownloader
{
  private static final int MSG_ADDR_PROVIDER_CHANDED = 3;
  private static final int MSG_DOWNLOAD_FINISH = 2;
  private static final int MSG_PLAY_PTT = 1;
  private static final int MSG_RECEIVED_PTT = 0;
  private static final int MSG_VIEW_PTT = 4;
  private static final int PER_TYPE_MAX_DOWNLOADING_COUNT = 3;
  static final String TAG = "PTTPreDownloader";
  private boolean mAddrProviderReady;
  AppRuntime mApp;
  private final PTTPreDownloaderImpl.CacheInfo mC2CCache = new PTTPreDownloaderImpl.CacheInfo();
  private boolean mDestroy = false;
  private final PTTPreDownloaderImpl.CacheInfo mDissCache = new PTTPreDownloaderImpl.CacheInfo();
  private final PTTPreDownloaderImpl.CacheInfo mGrpCache = new PTTPreDownloaderImpl.CacheInfo();
  private final WeakReferenceHandler mHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
  private IPTTPreDownloader.IPreDownloadStrategy mStrategy;
  
  private void cancelCache(PTTPreDownloaderImpl.CacheInfo paramCacheInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTTPreDownloader", 2, "cancelCache");
    }
    int i = 0;
    while (i < paramCacheInfo.jdField_a_of_type_JavaUtilArrayList.size())
    {
      MessageForPtt localMessageForPtt = (MessageForPtt)paramCacheInfo.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.mStrategy.b(localMessageForPtt))
      {
        long l;
        if (localMessageForPtt.extFlag == -1L) {
          l = localMessageForPtt.extFlag;
        } else {
          l = localMessageForPtt.extFlag & 0xFFFFFFFC;
        }
        localMessageForPtt.extFlag = l;
        localMessageForPtt.serial();
        ((IPttTempApi)QRoute.api(IPttTempApi.class)).updateMsgContentByUniseq(this.mApp, localMessageForPtt.frienduin, localMessageForPtt.istroop, localMessageForPtt.uniseq, localMessageForPtt.msgData);
      }
      i += 1;
    }
  }
  
  private PTTPreDownloaderImpl.CacheInfo getCache(MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt.istroop == 0) {
      return this.mC2CCache;
    }
    if (paramMessageForPtt.istroop == 1) {
      return this.mGrpCache;
    }
    if (paramMessageForPtt.istroop == 3000) {
      return this.mDissCache;
    }
    return null;
  }
  
  private void handleAddrReady(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleAddrReady:");
      localStringBuilder.append(paramBoolean);
      QLog.d("PTTPreDownloader", 4, localStringBuilder.toString());
    }
    this.mAddrProviderReady = paramBoolean;
    if (this.mAddrProviderReady)
    {
      startDownloadCache(this.mC2CCache);
      startDownloadCache(this.mGrpCache);
      startDownloadCache(this.mDissCache);
    }
  }
  
  private void handleDownloadFinish(boolean paramBoolean, int paramInt, MessageForPtt paramMessageForPtt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleDownloadFinish uin:");
      localStringBuilder.append(paramMessageForPtt.frienduin);
      localStringBuilder.append(", seq:");
      localStringBuilder.append(paramMessageForPtt.uniseq);
      localStringBuilder.append(", sucess:");
      localStringBuilder.append(paramBoolean);
      QLog.d("PTTPreDownloader", 2, localStringBuilder.toString());
    }
    if ((paramMessageForPtt.extFlag > 0L) && ((paramMessageForPtt.extFlag & 1L) > 0L)) {
      if (paramBoolean)
      {
        this.mStrategy.b(paramMessageForPtt);
      }
      else if (((paramMessageForPtt.extFlag & 0x2) == 0L) && (this.mStrategy.a(paramMessageForPtt, 3)))
      {
        long l;
        if (paramMessageForPtt.extFlag == -1L) {
          l = paramMessageForPtt.extFlag;
        } else {
          l = paramMessageForPtt.extFlag & 0xFFFFFFFC;
        }
        paramMessageForPtt.extFlag = l;
        paramMessageForPtt.serial();
        ((IPttTempApi)QRoute.api(IPttTempApi.class)).updateMsgContentByUniseq(this.mApp, paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      }
    }
    paramMessageForPtt = getCache(paramMessageForPtt);
    if (paramMessageForPtt != null)
    {
      paramMessageForPtt.jdField_a_of_type_Int -= 1;
      if (paramMessageForPtt.jdField_a_of_type_Int < 0) {
        paramMessageForPtt.jdField_a_of_type_Int = 0;
      }
      startDownloadCache(paramMessageForPtt);
    }
  }
  
  private boolean handlePlayPTT(MessageForPtt paramMessageForPtt)
  {
    return true;
  }
  
  private boolean handleReceivedPTT(MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt.istroop == 1) && (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopMask(this.mApp, paramMessageForPtt.frienduin) != 1)) {
      return true;
    }
    if (((IPttTempApi)QRoute.api(IPttTempApi.class)).isHotChat(this.mApp, paramMessageForPtt.frienduin)) {
      return true;
    }
    int i = ((IPttUtils)QRoute.api(IPttUtils.class)).getReceivedPTTStatus((AppInterface)this.mApp, paramMessageForPtt);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleReceivedPTT uin:");
      ((StringBuilder)localObject).append(paramMessageForPtt.frienduin);
      ((StringBuilder)localObject).append(", seq:");
      ((StringBuilder)localObject).append(paramMessageForPtt.uniseq);
      ((StringBuilder)localObject).append(", status:");
      ((StringBuilder)localObject).append(i);
      QLog.d("PTTPreDownloader", 2, ((StringBuilder)localObject).toString());
    }
    if ((i == 0) || (i == -1))
    {
      localObject = getCache(paramMessageForPtt);
      if (localObject != null) {
        if (this.mAddrProviderReady)
        {
          if ((((PTTPreDownloaderImpl.CacheInfo)localObject).jdField_a_of_type_Int < 3) && (this.mStrategy.a(paramMessageForPtt)))
          {
            if (!startDownload(paramMessageForPtt))
            {
              if (this.mStrategy.b(paramMessageForPtt))
              {
                long l;
                if (paramMessageForPtt.extFlag == -1L) {
                  l = paramMessageForPtt.extFlag;
                } else {
                  l = paramMessageForPtt.extFlag & 0xFFFFFFFC;
                }
                paramMessageForPtt.extFlag = l;
                paramMessageForPtt.serial();
                ((IPttTempApi)QRoute.api(IPttTempApi.class)).updateMsgContentByUniseq(this.mApp, paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
              }
            }
            else {
              ((PTTPreDownloaderImpl.CacheInfo)localObject).jdField_a_of_type_Int += 1;
            }
          }
          else
          {
            i = ((PTTPreDownloaderImpl.CacheInfo)localObject).jdField_a_of_type_JavaUtilArrayList.size();
            localObject.getClass();
            if (i + 1 < 99) {
              ((PTTPreDownloaderImpl.CacheInfo)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramMessageForPtt);
            }
          }
          if (paramMessageForPtt.voiceChangeFlag == 1)
          {
            localObject = this.mApp;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramMessageForPtt.istroop);
            ReportController.b((AppRuntime)localObject, "CliOper", "", "", "changevoice", "0X8006F7D", 0, 0, localStringBuilder.toString(), "", "", "");
            return true;
          }
        }
        else
        {
          i = ((PTTPreDownloaderImpl.CacheInfo)localObject).jdField_a_of_type_JavaUtilArrayList.size();
          localObject.getClass();
          if (i + 1 < 99) {
            ((PTTPreDownloaderImpl.CacheInfo)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramMessageForPtt);
          }
        }
      }
    }
    return true;
  }
  
  private boolean handleViewPTT(MessageForPtt paramMessageForPtt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleViewPTT uin:");
      localStringBuilder.append(paramMessageForPtt.frienduin);
      localStringBuilder.append(", seq:");
      localStringBuilder.append(paramMessageForPtt.uniseq);
      QLog.d("PTTPreDownloader", 2, localStringBuilder.toString());
    }
    if (this.mStrategy.a(paramMessageForPtt, 1))
    {
      long l2 = paramMessageForPtt.extFlag;
      long l1 = 2L;
      if (l2 != -1L) {
        l1 = 0x2 | paramMessageForPtt.extFlag;
      }
      paramMessageForPtt.extFlag = l1;
      paramMessageForPtt.serial();
      ((IPttTempApi)QRoute.api(IPttTempApi.class)).updateMsgContentByUniseq(this.mApp, paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    }
    return true;
  }
  
  private void setStrategy(IPTTPreDownloader.IPreDownloadStrategy paramIPreDownloadStrategy)
  {
    this.mStrategy = paramIPreDownloadStrategy;
  }
  
  private boolean startDownload(MessageForPtt paramMessageForPtt)
  {
    int i = ((IPttUtils)QRoute.api(IPttUtils.class)).getReceivedPTTStatus((AppInterface)this.mApp, paramMessageForPtt);
    boolean bool2 = false;
    boolean bool1;
    if (i != 0)
    {
      bool1 = bool2;
      if (i != -1) {}
    }
    else
    {
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.mSelfUin = this.mApp.getAccount();
      localTransferRequest.mPeerUin = paramMessageForPtt.frienduin;
      localTransferRequest.mUinType = paramMessageForPtt.istroop;
      localTransferRequest.mFileType = 2;
      localTransferRequest.mUniseq = paramMessageForPtt.uniseq;
      localTransferRequest.mIsUp = false;
      localTransferRequest.mServerPath = paramMessageForPtt.urlAtServer;
      localTransferRequest.mOutFilePath = paramMessageForPtt.getLocalFilePath();
      if ((!paramMessageForPtt.isSendFromOtherTerminal()) && (!paramMessageForPtt.isSend())) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      localTransferRequest.mIsSelfSend = bool1;
      localTransferRequest.mMd5 = paramMessageForPtt.md5;
      localTransferRequest.mGroupFileID = paramMessageForPtt.groupFileID;
      localTransferRequest.mGroupFileKeyStr = paramMessageForPtt.groupFileKeyStr;
      localTransferRequest.mDbRecVersion = paramMessageForPtt.subVersion;
      localTransferRequest.mRec = paramMessageForPtt;
      localTransferRequest.mDownMode = 1;
      localTransferRequest.mExtraObj = new TransferRequest.PttDownExtraInfo(6, 0);
      try
      {
        bool1 = ((ITransFileController)this.mApp.getRuntimeService(ITransFileController.class, "all")).transferAsync(localTransferRequest);
      }
      catch (Exception localException)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startDownload  exception=");
          localStringBuilder2.append(localException.getMessage());
          QLog.d("PTTPreDownloader", 2, localStringBuilder2.toString());
          bool1 = bool2;
        }
      }
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("startDownload uin:");
      localStringBuilder1.append(paramMessageForPtt.frienduin);
      localStringBuilder1.append(", seq:");
      localStringBuilder1.append(paramMessageForPtt.uniseq);
      localStringBuilder1.append(", doIt:");
      localStringBuilder1.append(bool1);
      QLog.d("PTTPreDownloader", 4, localStringBuilder1.toString());
    }
    return bool1;
  }
  
  private boolean startDownloadCache(PTTPreDownloaderImpl.CacheInfo paramCacheInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTTPreDownloader", 2, "startDownloadCache");
    }
    for (;;)
    {
      boolean bool = false;
      label17:
      MessageForPtt localMessageForPtt;
      if ((paramCacheInfo.jdField_a_of_type_Int < 3) && (paramCacheInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localMessageForPtt = (MessageForPtt)paramCacheInfo.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (this.mStrategy.a(localMessageForPtt)) {
          if (!startDownload(localMessageForPtt)) {
            if (this.mStrategy.b(localMessageForPtt))
            {
              long l;
              if (localMessageForPtt.extFlag == -1L) {
                l = localMessageForPtt.extFlag;
              } else {
                l = localMessageForPtt.extFlag & 0xFFFFFFFC;
              }
              localMessageForPtt.extFlag = l;
            }
          }
        }
      }
      try
      {
        localMessageForPtt.serial();
        label127:
        ((IPttTempApi)QRoute.api(IPttTempApi.class)).updateMsgContentByUniseq(this.mApp, localMessageForPtt.frienduin, localMessageForPtt.istroop, localMessageForPtt.uniseq, localMessageForPtt.msgData);
        paramCacheInfo.jdField_a_of_type_JavaUtilArrayList.remove(0);
        continue;
        paramCacheInfo.jdField_a_of_type_Int += 1;
        paramCacheInfo.jdField_a_of_type_JavaUtilArrayList.remove(0);
        bool = true;
        break label17;
        return bool;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        break label127;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.mDestroy) {
      return true;
    }
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        boolean bool2 = false;
        boolean bool1 = false;
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return true;
            }
            handleViewPTT((MessageForPtt)paramMessage.obj);
            return true;
          }
          if (paramMessage.arg1 != 0) {
            bool1 = true;
          }
          handleAddrReady(bool1);
          return true;
        }
        bool1 = bool2;
        if (paramMessage.arg1 != 0) {
          bool1 = true;
        }
        handleDownloadFinish(bool1, paramMessage.arg2, (MessageForPtt)paramMessage.obj);
        return true;
      }
      handlePlayPTT((MessageForPtt)paramMessage.obj);
      return true;
    }
    handleReceivedPTT((MessageForPtt)paramMessage.obj);
    return true;
  }
  
  public void onAddrProviderReady(boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    setStrategy(new PTTPreDownloadStrategy(this.mApp, this.mHandler));
  }
  
  public void onDestroy()
  {
    this.mDestroy = true;
    this.mHandler.removeMessages(0);
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(2);
    this.mHandler.removeMessages(3);
    this.mHandler.removeMessages(4);
    cancelCache(this.mC2CCache);
    cancelCache(this.mGrpCache);
    cancelCache(this.mDissCache);
    this.mStrategy.a();
  }
  
  public void onDownloadFinish(boolean paramBoolean, int paramInt, TransferRequest.PttDownExtraInfo paramPttDownExtraInfo, MessageForPtt paramMessageForPtt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean onPlayPTT(MessageForPtt paramMessageForPtt)
  {
    return true;
  }
  
  public boolean onReceivedPTTMsg(MessageForPtt paramMessageForPtt)
  {
    this.mHandler.obtainMessage(0, paramMessageForPtt).sendToTarget();
    return true;
  }
  
  public boolean onViewPTT(MessageForPtt paramMessageForPtt)
  {
    boolean bool = paramMessageForPtt.isSendFromLocal();
    long l = 2L;
    int i;
    if ((bool) || (paramMessageForPtt.getPttStreamFlag() == 10001) || (paramMessageForPtt.extFlag == -1L) || ((paramMessageForPtt.extFlag & 0x2) > 0L) || (paramMessageForPtt.fileSize <= 0L)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      return true;
    }
    if (paramMessageForPtt.extFlag != -1L) {
      l = 0x2 | paramMessageForPtt.extFlag;
    }
    paramMessageForPtt.extFlag = l;
    this.mHandler.obtainMessage(4, paramMessageForPtt).sendToTarget();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.impl.PTTPreDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */