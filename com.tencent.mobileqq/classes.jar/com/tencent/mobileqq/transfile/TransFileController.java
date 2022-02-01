package com.tencent.mobileqq.transfile;

import QQService.StreamData;
import QQService.StreamInfo;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import axjk;
import azjj;
import azjk;
import azkc;
import bdnl;
import bhbx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class TransFileController
  extends BaseTransFileController
{
  public static final boolean CLIENT_PERMIT_PRE_CONN = false;
  public static final String KEY_USE_PRE_CONN = "key_pre_conn";
  public static final String TAG = "Q.richmedia.TransFileController";
  public static final String VALUE_USE_PRE_CONN = "use";
  public static HashSet<Integer> nearByFileType = new HashSet();
  ArrayList<String> lastPasueKeys = new ArrayList();
  ArrayList<String> lastPasueKeysForShortVideo = new ArrayList();
  public QQAppInterface mApp;
  public ConcurrentHashMap<String, byte[]> sigMap = new ConcurrentHashMap(20);
  
  static
  {
    nearByFileType.add(Integer.valueOf(8));
    nearByFileType.add(Integer.valueOf(64));
    nearByFileType.add(Integer.valueOf(22));
    nearByFileType.add(Integer.valueOf(21));
    nearByFileType.add(Integer.valueOf(34));
    nearByFileType.add(Integer.valueOf(35));
    nearByFileType.add(Integer.valueOf(36));
    nearByFileType.add(Integer.valueOf(37));
    nearByFileType.add(Integer.valueOf(38));
    nearByFileType.add(Integer.valueOf(48));
    nearByFileType.add(Integer.valueOf(23));
    nearByFileType.add(Integer.valueOf(39));
    nearByFileType.add(Integer.valueOf(40));
    nearByFileType.add(Integer.valueOf(41));
    nearByFileType.add(Integer.valueOf(50));
    nearByFileType.add(Integer.valueOf(51));
    nearByFileType.add(Integer.valueOf(56));
  }
  
  public TransFileController() {}
  
  public TransFileController(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
    }
    this.mApp = paramQQAppInterface;
  }
  
  public static String getProperty(String paramString)
  {
    try
    {
      paramString = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getString(paramString, null);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private boolean isJsPtt(IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIHttpCommunicatorListener != null) {
      if (!(paramIHttpCommunicatorListener instanceof JSPttUploadProcessor))
      {
        bool1 = bool2;
        if (!(paramIHttpCommunicatorListener instanceof JSPttDownloadProcessor)) {}
      }
      else
      {
        paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
        bool1 = bool2;
        if (paramIHttpCommunicatorListener.getFileStatus() != 1003L)
        {
          bool1 = bool2;
          if (paramIHttpCommunicatorListener.getLastFileStatus() != 2003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean isPALongMsg(IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIHttpCommunicatorListener != null)
    {
      bool1 = bool2;
      if ((paramIHttpCommunicatorListener instanceof StructLongMessageDownloadProcessor))
      {
        bool1 = bool2;
        if (((BaseTransProcessor)paramIHttpCommunicatorListener).getFileStatus() != 2003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean isSendingPic(IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIHttpCommunicatorListener != null) {
      if (!(paramIHttpCommunicatorListener instanceof C2CPicUploadProcessor))
      {
        bool1 = bool2;
        if (!(paramIHttpCommunicatorListener instanceof GroupPicUploadProcessor)) {}
      }
      else
      {
        paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
        bool1 = bool2;
        if (paramIHttpCommunicatorListener.getFileStatus() != 1003L)
        {
          bool1 = bool2;
          if (paramIHttpCommunicatorListener.getLastFileStatus() != 1003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean isVoiceTextTask(IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIHttpCommunicatorListener != null)
    {
      bool1 = bool2;
      if ((paramIHttpCommunicatorListener instanceof PttSliceUploadProcessor))
      {
        bool1 = bool2;
        if (((BaseTransProcessor)paramIHttpCommunicatorListener).getFileStatus() != 1003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static String makeReceiveKey(TransferRequest paramTransferRequest)
  {
    return makeReceiveKey(paramTransferRequest.mMd5, paramTransferRequest.mServerPath, paramTransferRequest.mFileType);
  }
  
  public static String makeReceiveKey(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!"null".equals(paramString1)) && (!"".equals(paramString1))) {
      return paramString1 + "_" + paramInt;
    }
    return paramString2 + "_" + paramInt;
  }
  
  public static void setProperty(String paramString1, String paramString2)
  {
    try
    {
      PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putString(paramString1, paramString2).commit();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void startDownloadProcessor(TransferRequest paramTransferRequest, BaseTransProcessor paramBaseTransProcessor, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = "sync ";
      if (paramBoolean) {
        this.mApp.getPicPreDownloader().a(paramString);
      }
      ??? = (IHttpCommunicatorListener)this.processorMap.get(paramString);
      if (??? == null) {
        break label420;
      }
      if (!(??? instanceof BaseDownloadProcessor)) {}
    }
    label420:
    do
    {
      do
      {
        long l;
        TransferRequest localTransferRequest;
        do
        {
          synchronized ((BaseDownloadProcessor)???)
          {
            l = ((BaseDownloadProcessor)???).getFileStatus();
            localTransferRequest = ((BaseDownloadProcessor)???).getTransferRequest();
            RichMediaUtil.log(paramTransferRequest.mUinType, paramTransferRequest.mIsUp, paramTransferRequest.mFileType, String.valueOf(paramTransferRequest.mUniseq), str + "startDownloadProcessor", "status:" + l + ",key:" + paramString);
            if ((l == -1L) || (l == 2002L) || (l == 2001L))
            {
              paramTransferRequest.mResult = localTransferRequest.mResult;
              if (paramTransferRequest.mDownCallBack != null) {
                ((BaseDownloadProcessor)???).mDownCallBacks.add(paramTransferRequest.mDownCallBack);
              }
              if (paramBoolean) {
                synLockWait(paramTransferRequest, (BaseTransProcessor)???);
              }
            }
            for (;;)
            {
              return;
              str = "aync ";
              break;
              if ((l == 2004L) || (l == 2005L))
              {
                if (paramBaseTransProcessor == null) {
                  continue;
                }
                this.processorMap.put(paramString, paramBaseTransProcessor);
                paramBaseTransProcessor.setKey(paramString);
                if (paramBaseTransProcessor.checkParam() != 0) {
                  continue;
                }
                azkc.a(this.mApp, paramTransferRequest);
                paramBaseTransProcessor.start();
                if (!paramBoolean) {
                  continue;
                }
                try
                {
                  RichMediaUtil.log(paramTransferRequest.mUinType, paramTransferRequest.mIsUp, paramTransferRequest.mFileType, String.valueOf(paramTransferRequest.mUniseq), "callwait", "");
                  ???.wait();
                }
                catch (InterruptedException paramTransferRequest)
                {
                  paramTransferRequest.printStackTrace();
                }
              }
            }
          }
        } while (l != 2003L);
        paramTransferRequest.mResult = localTransferRequest.mResult;
        if (paramTransferRequest.mDownCallBack != null)
        {
          paramBaseTransProcessor = new azjk();
          paramBaseTransProcessor.a = 0;
          paramBaseTransProcessor.b = paramTransferRequest.mOutFilePath;
          paramBaseTransProcessor.jdField_c_of_type_JavaLangString = paramTransferRequest.mMd5;
          paramBaseTransProcessor.jdField_c_of_type_Int = paramTransferRequest.mFileType;
          paramBaseTransProcessor.d = paramTransferRequest.mDownMode;
          paramTransferRequest.mDownCallBack.a(paramBaseTransProcessor);
        }
        return;
        RichMediaUtil.log(paramTransferRequest.mUinType, paramTransferRequest.mIsUp, paramTransferRequest.mFileType, String.valueOf(paramTransferRequest.mUniseq), str + "startDownloadProcessor", "firs time ,key:" + paramString);
        this.processorMap.put(paramString, paramBaseTransProcessor);
        paramBaseTransProcessor.setKey(paramString);
      } while (paramBaseTransProcessor.checkParam() != 0);
      azkc.a(this.mApp, paramTransferRequest);
      paramBaseTransProcessor.start();
    } while (!paramBoolean);
    try
    {
      synLockWait(paramTransferRequest, paramBaseTransProcessor);
      return;
    }
    finally {}
  }
  
  private void synLockWait(TransferRequest paramTransferRequest, BaseTransProcessor paramBaseTransProcessor)
  {
    try
    {
      if (paramTransferRequest.mResult.mResult == -2)
      {
        RichMediaUtil.log(paramTransferRequest.mUinType, paramTransferRequest.mIsUp, paramTransferRequest.mFileType, String.valueOf(paramTransferRequest.mUniseq), "callwait", "");
        paramBaseTransProcessor.wait();
        RichMediaUtil.log(paramTransferRequest.mUinType, paramTransferRequest.mIsUp, paramTransferRequest.mFileType, String.valueOf(paramTransferRequest.mUniseq), "waitfin", "");
      }
      return;
    }
    catch (InterruptedException paramTransferRequest)
    {
      paramTransferRequest.printStackTrace();
    }
  }
  
  public void addProcessor(String paramString, IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    this.processorMap.put(paramString, paramIHttpCommunicatorListener);
  }
  
  public void cancelJsPttTask(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.processorMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (isJsPtt((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin)) && (paramLong == ((BaseTransProcessor)localObject).mUiRequest.mUniseq))
          {
            ((BaseTransProcessor)localObject).cancel();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel JSPTT:" + ((BaseTransProcessor)localObject).mUiRequest.mUniseq);
            }
          }
        }
      }
    }
  }
  
  public void cancelPALongMsgTask(String paramString, long paramLong)
  {
    Iterator localIterator = this.processorMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if (isPALongMsg((IHttpCommunicatorListener)localObject))
      {
        ThreadManager.getSubThreadHandler().removeCallbacks((StructLongMessageDownloadProcessor)localObject);
        localObject = (BaseTransProcessor)localObject;
        if ((paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin)) && (paramLong == ((BaseTransProcessor)localObject).mUiRequest.mUniseq))
        {
          ((BaseTransProcessor)localObject).cancel();
          if (QLog.isColorLevel()) {
            QLog.d("cancelpic", 2, "cancel PALongMsg:" + ((BaseTransProcessor)localObject).mUiRequest.mUniseq);
          }
        }
      }
    }
  }
  
  public void cancelPicDownload(MessageForPic paramMessageForPic, int paramInt)
  {
    paramMessageForPic = findProcessor(makeReceiveKey(paramMessageForPic.md5, paramMessageForPic.uuid, paramInt));
    if ((paramMessageForPic != null) && ((paramMessageForPic instanceof BaseTransProcessor))) {
      ((BaseTransProcessor)paramMessageForPic).cancel();
    }
  }
  
  public void cancelSendingPic(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.processorMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (isSendingPic((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin)) && (paramLong == ((BaseTransProcessor)localObject).mUiRequest.mUniseq))
          {
            ((BaseTransProcessor)localObject).cancel();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((BaseTransProcessor)localObject).mUiRequest.mUniseq);
            }
          }
        }
      }
    }
  }
  
  public void cancelSendingPics(String paramString, TransFileController.OnCancelListener paramOnCancelListener)
  {
    if (paramString == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Iterator localIterator = this.processorMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (isSendingPic((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin)) && (((BaseTransProcessor)localObject).isPause()))
          {
            ((BaseTransProcessor)localObject).cancel();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((BaseTransProcessor)localObject).mUiRequest.mUniseq);
            }
            if (((BaseTransProcessor)localObject).mUiRequest.mRec != null) {
              localArrayList.add(((BaseTransProcessor)localObject).mUiRequest.mRec);
            }
          }
        }
      }
    } while (paramOnCancelListener == null);
    paramOnCancelListener.onCancel(localArrayList);
  }
  
  public void cancelVoiceTextTask(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.processorMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (isVoiceTextTask((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin)) && (paramLong == ((BaseTransProcessor)localObject).mUiRequest.mUniseq))
          {
            ((BaseTransProcessor)localObject).cancel();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "PttSliceUploadProcessor cancelVoiceTextTask:" + ((BaseTransProcessor)localObject).mUiRequest.mUniseq);
            }
          }
        }
      }
    }
  }
  
  public boolean containsProcessor(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if (!this.processorMap.isEmpty()) {
      return this.processorMap.containsKey(paramString1);
    }
    return false;
  }
  
  public void destroy()
  {
    long l;
    if (this.mWorking.get()) {
      l = System.currentTimeMillis();
    }
    synchronized (this.mWorking)
    {
      this.mWorking.set(false);
      this.mApp.getHttpCommunicatort().close();
      stopCurrentWork();
      this.mApp = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.TransFileController", 2, "destroy transfilecontroller:" + this + " elapsed:" + (System.currentTimeMillis() - l));
      }
      return;
    }
  }
  
  public TransferResult downloadPic(TransferRequest paramTransferRequest)
  {
    paramTransferRequest.mIsUp = false;
    paramTransferRequest.mResult = new TransferResult();
    if (this.mWorking.get()) {}
    for (;;)
    {
      synchronized (this.mWorking)
      {
        Object localObject1;
        if ((!this.mWorking.get()) || (this.mApp == null))
        {
          localObject1 = paramTransferRequest.mResult;
          ((TransferResult)localObject1).mResult = -1;
          ((TransferResult)localObject1).mErrCode = 9366L;
          ((TransferResult)localObject1).mErrDesc = "transfilecontroller closed";
          paramTransferRequest = paramTransferRequest.mResult;
          return paramTransferRequest;
        }
        try
        {
          if (paramTransferRequest.mFileType == 131076)
          {
            localObject1 = new UrlDownloader(this, paramTransferRequest);
            startDownloadProcessor(paramTransferRequest, (BaseTransProcessor)localObject1, makeReceiveKey(paramTransferRequest), false);
            return paramTransferRequest.mResult;
          }
          if ((paramTransferRequest.mUinType == 1) || (paramTransferRequest.mUinType == 3000))
          {
            localObject1 = new GroupPicDownloadProcessor(this, paramTransferRequest);
            continue;
            paramTransferRequest = finally;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          localObject2 = paramTransferRequest.mResult;
          ((TransferResult)localObject2).mResult = -1;
          ((TransferResult)localObject2).mErrCode = 9366L;
          ((TransferResult)localObject2).mErrDesc = "transfilecontroller closed";
          paramTransferRequest = paramTransferRequest.mResult;
          return paramTransferRequest;
        }
      }
      Object localObject2 = new C2CPicDownloadProcessor(this, paramTransferRequest);
      continue;
      localObject2 = paramTransferRequest.mResult;
      ((TransferResult)localObject2).mResult = -1;
      ((TransferResult)localObject2).mErrCode = 9366L;
      ((TransferResult)localObject2).mErrDesc = "transfilecontroller closed";
    }
  }
  
  public TransferResult downloadPicSync(TransferRequest paramTransferRequest)
  {
    paramTransferRequest.mIsUp = false;
    paramTransferRequest.mResult = new TransferResult();
    Object localObject;
    if (this.mWorking.get()) {
      if (paramTransferRequest.mFileType == 131076)
      {
        localObject = new UrlDownloader(this, paramTransferRequest);
        startDownloadProcessor(paramTransferRequest, (BaseTransProcessor)localObject, makeReceiveKey(paramTransferRequest), true);
      }
    }
    for (;;)
    {
      return paramTransferRequest.mResult;
      if ((paramTransferRequest.mUinType == 1) || (paramTransferRequest.mUinType == 3000))
      {
        localObject = new GroupPicDownloadProcessor(this, paramTransferRequest);
        break;
      }
      localObject = new C2CPicDownloadProcessor(this, paramTransferRequest);
      break;
      localObject = paramTransferRequest.mResult;
      ((TransferResult)localObject).mResult = -1;
      ((TransferResult)localObject).mErrCode = 9366L;
      ((TransferResult)localObject).mErrDesc = "transfilecontroller closed";
    }
  }
  
  public BaseTransProcessor findPauseRawSendC2CProCessor(String paramString, long paramLong)
  {
    paramString = findProcessor(paramString + paramLong);
    if ((paramString != null) && ((paramString instanceof BaseTransProcessor)))
    {
      paramString = (BaseTransProcessor)paramString;
      if ((paramString.mIsRawPic) && (paramString.mIsPause)) {
        return paramString;
      }
    }
    return null;
  }
  
  public IHttpCommunicatorListener findProcessor(String paramString)
  {
    if (!this.processorMap.isEmpty()) {
      return (IHttpCommunicatorListener)this.processorMap.get(paramString);
    }
    return null;
  }
  
  public IHttpCommunicatorListener findProcessor(String paramString1, String paramString2, long paramLong)
  {
    return findProcessor(paramString1, paramLong);
  }
  
  public int findProcessorFileStatus(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if ((!this.processorMap.isEmpty()) && (this.processorMap.containsKey(paramString1)))
    {
      paramString1 = (IHttpCommunicatorListener)this.processorMap.get(paramString1);
      if ((paramString1 instanceof BaseTransProcessor)) {
        return (int)((BaseTransProcessor)paramString1).getFileStatus();
      }
    }
    return -1;
  }
  
  public int findProcessorProgress(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if ((!this.processorMap.isEmpty()) && (this.processorMap.containsKey(paramString1)))
    {
      paramString1 = (IHttpCommunicatorListener)this.processorMap.get(paramString1);
      if ((paramString1 instanceof BaseTransProcessor)) {
        return ((BaseTransProcessor)paramString1).getProgress();
      }
    }
    return 0;
  }
  
  public BaseTransProcessor getC2CDownProcessor(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest.mFileType == 2) {
      return new C2CPttDownloadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 32) {
      return new JSPttDownloadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 33) {
      return new PAAudioPttDownloadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.mFileType == 6) || (paramTransferRequest.mFileType == 7) || (paramTransferRequest.mFileType == 17) || (paramTransferRequest.mFileType == 18) || (paramTransferRequest.mFileType == 9) || (paramTransferRequest.mFileType == 16)) {
      return new ShortVideoDownloadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.mFileType == 1) || (paramTransferRequest.mFileType == 65537) || (paramTransferRequest.mFileType == 131075)) {
      return new C2CPicDownloadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 131079) {
      return new StructLongMessageDownloadProcessor(this, paramTransferRequest);
    }
    return null;
  }
  
  public BaseTransProcessor getC2CProcessor(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest.mIsUp) {
      return getC2CUpProcessor(paramTransferRequest);
    }
    return getC2CDownProcessor(paramTransferRequest);
  }
  
  public BaseTransProcessor getC2CUpProcessor(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest.mFileType == 2) {
      return new C2CPttUploadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 32) {
      return new JSPttUploadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.mFileType == 6) || (paramTransferRequest.mFileType == 17) || (paramTransferRequest.mFileType == 9)) {
      return new ShortVideoUploadProcessor(this, paramTransferRequest);
    }
    if (nearByFileType.contains(Integer.valueOf(paramTransferRequest.mFileType))) {
      return new NearbyPeoplePhotoUploadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 20) {
      return new ShortVideoForwardProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 24) {
      return new BDHCommonUploadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.mFileType == 196609) || (paramTransferRequest.mFileType == 196610) || (paramTransferRequest.mFileType == 327681)) {
      return new StoryUploadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mBusiType == 1045) {
      return new C2CQzonePicUploadProcessor(this, paramTransferRequest);
    }
    return new C2CPicUploadProcessor(this, paramTransferRequest);
  }
  
  public BaseTransProcessor getHotChatProcessor(TransferRequest paramTransferRequest)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PttShow", 2, "getProcessor UIN_TYPE_HOTCHAT_TOPIC  isUp = " + paramTransferRequest.mIsUp);
    }
    if (paramTransferRequest.mIsUp) {
      return new GroupPicUploadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 2) {
      return new GroupPttDownloadProcessor(this, paramTransferRequest);
    }
    return null;
  }
  
  public BaseTransProcessor getProcessor(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, paramTransferRequest.toString());
    }
    if (paramTransferRequest.mFileType == 131078)
    {
      if (paramTransferRequest.mIsUp) {
        return new MultiMsgUpProcessor(this, paramTransferRequest);
      }
      return new MultiMsgDownloadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 262153)
    {
      if (paramTransferRequest.mIsUp) {
        return new ScribblePicUploadProcessor(this, paramTransferRequest);
      }
      return new ScribblePicDownloadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 327689) {
      return new LightVideoUploadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 327696) {
      return new PttSliceUploadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 66) {
      return new ShareToWXUploadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.mFileType == 52) && (paramTransferRequest.mIsUp)) {
      return new ForwardSdkShareProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mUinType == 1026) {
      return getHotChatProcessor(paramTransferRequest);
    }
    if ((paramTransferRequest.mUinType == 1) || (paramTransferRequest.mUinType == 3000)) {
      return getTroopProcessor(paramTransferRequest);
    }
    return getC2CProcessor(paramTransferRequest);
  }
  
  public BaseTransProcessor getTroopProcessor(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest.mIsUp)
    {
      if ((paramTransferRequest.mFileType == 6) || (paramTransferRequest.mFileType == 17) || (paramTransferRequest.mFileType == 9)) {
        return new ShortVideoUploadProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.mFileType == 20) {
        return new ShortVideoForwardProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.mFileType == 55) {
        return new TroopEffectsPicUploadProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.mBusiType == 1045) {
        return new GroupQzonePicUploadProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.mFileType == 2) {
        return new GroupPttUploadProcessor(this, paramTransferRequest);
      }
      return new GroupPicUploadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.mFileType == 2) {
      return new GroupPttDownloadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.mFileType == 1) || (paramTransferRequest.mFileType == 65537) || (paramTransferRequest.mFileType == 131075)) {
      return new GroupPicDownloadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.mFileType == 6) || (paramTransferRequest.mFileType == 7) || (paramTransferRequest.mFileType == 17) || (paramTransferRequest.mFileType == 18) || (paramTransferRequest.mFileType == 9) || (paramTransferRequest.mFileType == 16)) {
      return new ShortVideoDownloadProcessor(this, paramTransferRequest);
    }
    return null;
  }
  
  public boolean initAllPSProcessorEnterAioTime(long paramLong)
  {
    Iterator localIterator = this.processorMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof BaseUploadProcessor))) {
        break label175;
      }
      localObject = (BaseUploadProcessor)localObject;
      if ((((BaseUploadProcessor)localObject).mUiRequest == null) || (!((BaseUploadProcessor)localObject).mUiRequest.mIsPresend)) {
        break label175;
      }
      ((BaseUploadProcessor)localObject).mEnterAioTime = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicReport", 2, "initAllPSProcessorEnterAioTime ,Processor:" + localObject + ",time = " + paramLong);
      }
      bool = true;
    }
    label175:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicReport", 2, "initAllPSProcessorEnterAioTime result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean isMutiSendingPics(String paramString)
  {
    if (paramString == null) {}
    label90:
    label91:
    for (;;)
    {
      return false;
      Iterator localIterator = this.processorMap.entrySet().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        IHttpCommunicatorListener localIHttpCommunicatorListener = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if ((!isSendingPic(localIHttpCommunicatorListener)) || (!paramString.equals(((BaseTransProcessor)localIHttpCommunicatorListener).mUiRequest.mPeerUin))) {
          break label90;
        }
        i += 1;
      }
      for (;;)
      {
        break;
        if (i <= 1) {
          break label91;
        }
        return true;
      }
    }
  }
  
  public String makeKey(String paramString, long paramLong)
  {
    return paramString + paramLong;
  }
  
  public void onReceiveStreamAction(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, long paramLong4, ptt_reserve.ReserveStruct paramReserveStruct)
  {
    Object localObject2 = bdnl.a(paramStreamInfo.iMsgId, 1);
    long l1 = paramStreamInfo.lFromUIN;
    long l2 = paramStreamInfo.lToUIN;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = BuddyTransfileProcessor.getTransferFilePath(String.valueOf(l2), null, 2, null);
      int i = bhbx.a(paramStreamInfo.pttFormat);
      localObject2 = MessageForPtt.getLocalFilePath(i, (String)localObject1);
      bdnl.a(this.mApp, i, (String)localObject2, 1, paramStreamInfo.iMsgId);
      bdnl.a((String)localObject2, (short)paramStreamInfo.msgSeq);
      bdnl.b((String)localObject2, paramStreamInfo.random);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richmedia.TransFileController", 2, "onReceiveStreamAction  key is:" + (String)localObject2 + ",msgSeq is:" + paramStreamInfo.msgSeq + ",random is:" + paramStreamInfo.random);
        localObject1 = localObject2;
      }
    }
    localObject2 = new Bundle();
    im_msg_body.GeneralFlags localGeneralFlags = new im_msg_body.GeneralFlags();
    try
    {
      localGeneralFlags.mergeFrom(paramReserveStruct.bytes_general_flags.get().toByteArray());
      ((Bundle)localObject2).putInt("DiyTextId", localGeneralFlags.uint32_bubble_diy_text_id.get());
      ((Bundle)localObject2).putInt("DiyPendantId", (int)paramLong4);
      receiveStreamPtt(String.valueOf(l1), (String)localObject1, -1000L, paramStreamInfo, paramStreamData, paramLong1, paramLong2, paramLong3, (Bundle)localObject2);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramReserveStruct)
    {
      for (;;)
      {
        QLog.e("Q.richmedia.TransFileController", 1, "pb merge failed.", paramReserveStruct);
      }
    }
  }
  
  public boolean pauseAllRawSend()
  {
    this.lastPasueKeys.clear();
    Iterator localIterator = this.processorMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof BaseTransProcessor))) {
        break label178;
      }
      localObject = (BaseTransProcessor)localObject;
      if ((!((BaseTransProcessor)localObject).mIsRawPic) || (((BaseTransProcessor)localObject).mIsPause)) {
        break label178;
      }
      ((BaseTransProcessor)localObject).pause();
      if (((BaseTransProcessor)localObject).getKey() != null) {
        this.lastPasueKeys.add(((BaseTransProcessor)localObject).getKey());
      }
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend key:" + ((BaseTransProcessor)localObject).getKey());
      }
      bool = true;
    }
    label178:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean pauseAllShortVideoReceive()
  {
    Iterator localIterator = this.processorMap.entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof BaseTransProcessor))) {
        break label211;
      }
      localObject = (BaseTransProcessor)localObject;
      if ((!((BaseTransProcessor)localObject).mIsShortVideoReceive) || (((BaseTransProcessor)localObject).mIsPause)) {
        break label211;
      }
      ((BaseTransProcessor)localObject).pause();
      if (((BaseTransProcessor)localObject).getKey() != null) {
        this.lastPasueKeysForShortVideo.add(((BaseTransProcessor)localObject).getKey());
      }
      localStringBuilder.append(((BaseTransProcessor)localObject).getKey());
      localStringBuilder.append(",");
      bool = true;
    }
    label211:
    for (;;)
    {
      break;
      if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
        QLog.d("short_video", 2, "pauseAllShortVideoReceive key:" + localStringBuilder);
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoReceive result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean pauseAllShortVideoSend()
  {
    Iterator localIterator = this.processorMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof BaseTransProcessor))) {
        break label171;
      }
      localObject = (BaseTransProcessor)localObject;
      if ((!((BaseTransProcessor)localObject).mIsShortVideoSend) || (((BaseTransProcessor)localObject).mIsPause)) {
        break label171;
      }
      ((BaseTransProcessor)localObject).pause();
      if (((BaseTransProcessor)localObject).getKey() != null) {
        this.lastPasueKeysForShortVideo.add(((BaseTransProcessor)localObject).getKey());
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend key:" + ((BaseTransProcessor)localObject).getKey());
      }
      bool = true;
    }
    label171:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend result:" + bool);
      }
      return bool;
    }
  }
  
  /* Error */
  public boolean pauseReceivingShortVideo(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 76	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   9: aload_1
    //   10: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: lload_2
    //   14: invokevirtual 250	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 218	com/tencent/mobileqq/transfile/TransFileController:processorMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 455	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   29: ifeq +31 -> 60
    //   32: aload_0
    //   33: getfield 218	com/tencent/mobileqq/transfile/TransFileController:processorMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: aload_1
    //   37: invokevirtual 222	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 550	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 835	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:pause	()V
    //   52: iconst_1
    //   53: istore 4
    //   55: aload_0
    //   56: monitorexit
    //   57: iload 4
    //   59: ireturn
    //   60: iconst_0
    //   61: istore 4
    //   63: goto -8 -> 55
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	TransFileController
    //   0	71	1	paramString	String
    //   0	71	2	paramLong	long
    //   53	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	44	66	finally
    //   48	52	66	finally
  }
  
  public boolean pauseSendingPics(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Iterator localIterator = this.processorMap.entrySet().iterator();
    boolean bool1;
    for (boolean bool2 = false; localIterator.hasNext(); bool2 = bool1)
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      bool1 = bool2;
      if (isSendingPic((IHttpCommunicatorListener)localObject))
      {
        localObject = (BaseTransProcessor)localObject;
        bool1 = bool2;
        if (paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin))
        {
          bool1 = bool2;
          if (!((BaseTransProcessor)localObject).mIsPause)
          {
            ((BaseTransProcessor)localObject).pause();
            bool2 = true;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("cancelpic", 2, "pause pic:" + ((BaseTransProcessor)localObject).mUiRequest.mUniseq);
              bool1 = bool2;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  /* Error */
  public boolean pauseSendingShortVideo(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore 4
    //   5: new 76	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: lload_2
    //   17: invokevirtual 250	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: astore_1
    //   24: aload_0
    //   25: getfield 218	com/tencent/mobileqq/transfile/TransFileController:processorMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   28: aload_1
    //   29: invokevirtual 455	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   32: ifeq +36 -> 68
    //   35: aload_0
    //   36: getfield 218	com/tencent/mobileqq/transfile/TransFileController:processorMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   39: aload_1
    //   40: invokevirtual 222	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 224	com/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +17 -> 65
    //   51: aload_1
    //   52: instanceof 567
    //   55: ifeq +18 -> 73
    //   58: aload_1
    //   59: checkcast 567	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor
    //   62: invokevirtual 840	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:pause	()V
    //   65: iconst_1
    //   66: istore 4
    //   68: aload_0
    //   69: monitorexit
    //   70: iload 4
    //   72: ireturn
    //   73: aload_1
    //   74: instanceof 578
    //   77: ifeq -12 -> 65
    //   80: aload_1
    //   81: checkcast 578	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor
    //   84: invokevirtual 841	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:pause	()V
    //   87: goto -22 -> 65
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	TransFileController
    //   0	95	1	paramString	String
    //   0	95	2	paramLong	long
    //   3	68	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	24	90	finally
    //   24	47	90	finally
    //   51	65	90	finally
    //   73	87	90	finally
  }
  
  public boolean receiveStreamPtt(String paramString1, String paramString2, long paramLong1, StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong2, long paramLong3, long paramLong4, Bundle paramBundle)
  {
    if (!this.processorMap.containsKey(paramString1 + paramString2 + paramLong1))
    {
      if (this.mApp != null)
      {
        BuddyTransfileProcessor localBuddyTransfileProcessor = new BuddyTransfileProcessor(paramString1, paramString2, false, null, null, 2, -1, false, this, paramLong1);
        localBuddyTransfileProcessor.setId(paramLong1);
        localBuddyTransfileProcessor.getFileMsg().filePath = paramString2;
        localBuddyTransfileProcessor.setKey(paramString1 + paramString2 + paramLong1);
        this.processorMap.put(paramString1 + paramString2 + paramLong1, localBuddyTransfileProcessor);
        localBuddyTransfileProcessor.startReceiveOneStreamPack(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (BuddyTransfileProcessor)findProcessor(paramString1 + paramString2 + paramLong1);
    if (paramString1 != null) {
      paramString1.startReceiveOneStreamPack(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
    }
    return false;
  }
  
  public void removeProcessorByPeerUin(String paramString, int paramInt)
  {
    Iterator localIterator = getKeySetClone(this.processorMap).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      IHttpCommunicatorListener localIHttpCommunicatorListener = (IHttpCommunicatorListener)this.processorMap.get(str);
      switch (paramInt)
      {
      case 1: 
      case 2: 
      default: 
        break;
      case 0: 
        if (((localIHttpCommunicatorListener instanceof BuddyTransfileProcessor)) && (paramString.equals(((BuddyTransfileProcessor)localIHttpCommunicatorListener).file.mUin)))
        {
          ((BaseTransProcessor)localIHttpCommunicatorListener).stop();
          this.processorMap.remove(str);
        }
        break;
      }
    }
  }
  
  public void resumeLastRawSend()
  {
    if (QLog.isColorLevel()) {
      QLog.d("raw_photo", 2, "resumeLastRawSend keys size:" + this.lastPasueKeys.size());
    }
    Iterator localIterator = this.lastPasueKeys.iterator();
    while (localIterator.hasNext()) {
      resumeRawSend((String)localIterator.next());
    }
  }
  
  public void resumeLastShortVideoTransfer()
  {
    if (QLog.isColorLevel()) {
      QLog.d("short_video", 2, "resumeLastShortVideoSend keys size:" + this.lastPasueKeysForShortVideo.size());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.lastPasueKeysForShortVideo.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = findProcessor((String)localIterator.next());
      if ((localObject != null) && ((localObject instanceof BaseTransProcessor)))
      {
        localObject = (BaseTransProcessor)localObject;
        if (((BaseTransProcessor)localObject).mIsPause)
        {
          ((BaseTransProcessor)localObject).resume();
          localStringBuilder.append(((BaseTransProcessor)localObject).getKey());
          localStringBuilder.append(",");
        }
      }
    }
    if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
      QLog.d("short_video", 2, "resumeLastShortVideoSend , key: " + localStringBuilder);
    }
    this.lastPasueKeysForShortVideo.clear();
  }
  
  public void resumePendingPics(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.processorMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (isSendingPic((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin)) && (((BaseTransProcessor)localObject).mIsPause))
          {
            ((BaseTransProcessor)localObject).resume();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "resume pic:" + ((BaseTransProcessor)localObject).mUiRequest.mUniseq);
            }
          }
        }
      }
    }
  }
  
  public boolean resumeRawSend(String paramString)
  {
    paramString = findProcessor(paramString);
    if ((paramString != null) && ((paramString instanceof BaseTransProcessor)))
    {
      paramString = (BaseTransProcessor)paramString;
      if ((paramString.mIsRawPic) && (paramString.mIsPause))
      {
        paramString.resume();
        if (QLog.isColorLevel()) {
          QLog.d("raw_photo", 2, "resumeRawSend ,key:" + paramString.getKey());
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean resumeRawSend(String paramString1, String paramString2)
  {
    return resumeRawSend(paramString1 + paramString2);
  }
  
  public boolean resumeSendingShortVideo(String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        paramString = paramString + paramLong;
        if (this.processorMap.containsKey(paramString))
        {
          paramString = (IHttpCommunicatorListener)this.processorMap.get(paramString);
          if (((paramString instanceof ShortVideoUploadProcessor)) && (((ShortVideoUploadProcessor)paramString).isPause()))
          {
            ((ShortVideoUploadProcessor)paramString).resume();
            bool = true;
            return bool;
          }
        }
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
      boolean bool = false;
    }
  }
  
  public boolean sendStreamPtt(String paramString1, String paramString2, long paramLong1, short paramShort, int paramInt1, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    if (!this.processorMap.containsKey(paramString1 + paramLong1))
    {
      if (this.mApp != null)
      {
        paramString2 = new BuddyTransfileProcessor(paramString1, paramString2, true, null, null, 2, -1, false, this, paramLong1);
        paramString2.setId(paramLong1);
        paramString2.createStreamThreadPool();
        paramString2.setKey(paramString1 + paramLong1);
        this.processorMap.put(paramString1 + paramLong1, paramString2);
        paramString2.startSendOneStreamPack(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (BuddyTransfileProcessor)findProcessor(paramString1, paramString2, paramLong1);
    if (paramString1 != null) {
      paramString1.startSendOneStreamPack(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
    }
    return false;
  }
  
  public void startForwardPicTransfer(long paramLong1, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2)
  {
    String str = paramString2 + paramLong1;
    if (this.processorMap.containsKey(str))
    {
      IHttpCommunicatorListener localIHttpCommunicatorListener = findProcessor(paramString2, paramLong1);
      if ((localIHttpCommunicatorListener instanceof ForwardImageProcessor)) {
        ((ForwardImageProcessor)localIHttpCommunicatorListener).stopListening();
      }
    }
    paramString1 = new ForwardImageProcessor(paramLong1, paramString1, paramQQAppInterface, paramInt1, paramString2, paramString3, paramString4, paramString5, paramLong2, paramInt2);
    this.processorMap.put(str, paramString1);
  }
  
  public boolean stopDownloadShortVideo(String paramString, long paramLong)
  {
    paramString = paramString + paramLong;
    if (this.processorMap.containsKey(paramString))
    {
      IHttpCommunicatorListener localIHttpCommunicatorListener = (IHttpCommunicatorListener)this.processorMap.get(paramString);
      if ((localIHttpCommunicatorListener instanceof ShortVideoDownloadProcessor))
      {
        ((ShortVideoDownloadProcessor)localIHttpCommunicatorListener).pause();
        this.processorMap.remove(paramString);
        return true;
      }
    }
    return false;
  }
  
  public boolean stopReceiveStreamPtt(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramString2 + paramLong;
    if (this.processorMap.containsKey(paramString1))
    {
      paramString2 = (BuddyTransfileProcessor)this.processorMap.get(paramString1);
      if (paramString2 != null) {
        paramString2.stop();
      }
      this.processorMap.remove(paramString1);
      return true;
    }
    return false;
  }
  
  public void stopRevokedRichMediaMsgTransfer(ChatMessage paramChatMessage)
  {
    Object localObject = this.mApp;
    if ((paramChatMessage instanceof MessageForPtt)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramChatMessage instanceof MessageForShortVideo)) {
              break;
            }
            paramChatMessage = (MessageForShortVideo)paramChatMessage;
            ((QQAppInterface)localObject).getTransFileController().stopDownloadShortVideo(paramChatMessage.frienduin, paramChatMessage.uniseq);
          } while (paramChatMessage.busiType != 0);
          localObject = (axjk)((QQAppInterface)localObject).getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
        } while (!((axjk)localObject).a(paramChatMessage));
        ((axjk)localObject).b(paramChatMessage, 0L, 0, 256);
        return;
      } while (!(paramChatMessage instanceof MessageForPic));
      paramChatMessage = (MessageForPic)paramChatMessage;
      cancelPicDownload(paramChatMessage, 131075);
      cancelPicDownload(paramChatMessage, 1);
      cancelPicDownload(paramChatMessage, 131075);
      localObject = (axjk)((QQAppInterface)localObject).getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
    } while (!((axjk)localObject).a(paramChatMessage));
    ((axjk)localObject).b(paramChatMessage, 0L, 0, 24);
  }
  
  public boolean stopSendStreamPtt(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if (this.processorMap.containsKey(paramString1))
    {
      paramString2 = (BuddyTransfileProcessor)this.processorMap.get(paramString1);
      if (paramString2 != null) {
        paramString2.stop();
      }
      this.processorMap.remove(paramString1);
      return true;
    }
    return false;
  }
  
  public boolean stopSendingShortVideo(String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        paramString = paramString + paramLong;
        if (this.processorMap.containsKey(paramString))
        {
          IHttpCommunicatorListener localIHttpCommunicatorListener = (IHttpCommunicatorListener)this.processorMap.get(paramString);
          if (localIHttpCommunicatorListener != null)
          {
            if ((localIHttpCommunicatorListener instanceof ShortVideoUploadProcessor)) {
              ((ShortVideoUploadProcessor)localIHttpCommunicatorListener).pause();
            }
          }
          else
          {
            this.processorMap.remove(paramString);
            bool = true;
            return bool;
          }
          if (!(localIHttpCommunicatorListener instanceof ShortVideoForwardProcessor)) {
            continue;
          }
          ((ShortVideoForwardProcessor)localIHttpCommunicatorListener).pause();
          continue;
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  public boolean transferAsync(TransferRequest paramTransferRequest)
  {
    try
    {
      boolean bool = super.transferAsync(paramTransferRequest);
      return bool;
    }
    finally
    {
      paramTransferRequest = finally;
      throw paramTransferRequest;
    }
  }
  
  public boolean transferAsync(TransferRequest paramTransferRequest, MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = transferAsync(paramTransferRequest);
      return bool;
    }
    finally
    {
      paramTransferRequest = finally;
      throw paramTransferRequest;
    }
  }
  
  public void uploadPortraitByBDH(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    ThreadManager.postImmediately(new TransFileController.1(this, paramString, paramIntent, paramQQAppInterface), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransFileController
 * JD-Core Version:    0.7.0.1
 */