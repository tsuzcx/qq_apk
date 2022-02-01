package com.tencent.mobileqq.pic;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.PicBusUtil;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.multimsg.api.IMultiMsg;
import com.tencent.mobileqq.multimsg.api.MultiMsgBean;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.impl.PicHelperImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.ChatImageDownloader;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import mqq.manager.Manager;

public class PicPreDownloader
  implements Manager
{
  public static boolean a = true;
  private static boolean b = false;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private PicPreDownloaderCore jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore;
  private PicStatisticsManager jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager;
  public PreDownloadStrategyBeta a;
  private LinkedBlockingQueue<MessageRecord> jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue = new LinkedBlockingQueue(100);
  private PriorityBlockingQueue<PicReq> jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  
  public PicPreDownloader(AppInterface paramAppInterface, PicStatisticsManager paramPicStatisticsManager)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new PicPreDownloader.ScreenBroadcastReceiver(paramAppInterface.getCurrentAccountUin());
    paramAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta = new PreDownloadStrategyBeta();
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore = new PicPreDownloaderCore(this, this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta);
    ThreadManager.excute(new PicPreDownloader.1(this, paramAppInterface, paramPicStatisticsManager), 64, null, true);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager = paramPicStatisticsManager;
    Logger.a("PIC_TAG_PRELOAD", "onInit", "Finished");
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    if (PicHelperImpl.hasThumbFile(paramMessageForPic)) {
      return;
    }
    if ((!ActionMsgUtil.a(paramMessageForPic.msgtype)) && (paramMessageForPic.msgtype != -3001) && (paramMessageForPic.msgtype != -30002) && (paramMessageForPic.msgtype != -30003)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.a(paramMessageForPic);
    Object localObject = PicBusiManager.a(5, 1536, 2);
    PicDownloadInfo localPicDownloadInfo = paramMessageForPic.getPicDownloadInfo();
    if (localPicDownloadInfo != null) {
      localPicDownloadInfo.h = 1;
    }
    ((PicReq)localObject).a(paramMessageForPic, localPicDownloadInfo);
    int i = PicPreDownloadUtils.a();
    if ((!jdField_a_of_type_Boolean) && (i != 0))
    {
      paramMessageForPic = new StringBuilder();
      paramMessageForPic.append("no preDownload,networkType:");
      paramMessageForPic.append(i);
      Logger.a("PIC_TAG_PRELOAD", "screenOFF", paramMessageForPic.toString());
      this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(new PicPreDownloader.5(this, (PicReq)localObject), "consumeThumb", ((PicReq)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uniseq:");
    ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
    ((StringBuilder)localObject).append(",subMsgId:");
    ((StringBuilder)localObject).append(paramMessageForPic.subMsgId);
    Logger.a("PIC_TAG_PRELOAD", "run picReq thumb", ((StringBuilder)localObject).toString());
  }
  
  private void a(MessageForPic paramMessageForPic, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(new PicPreDownloader.3(this, paramMessageForPic, paramInt1, paramInt2), "productAsync", paramMessageForPic);
  }
  
  private void a(MessageForPic paramMessageForPic, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramMessageForPic.path == null) && (paramMessageForPic.uuid == null) && (paramMessageForPic.md5 == null))
    {
      Logger.a("PIC_TAG_PRELOAD", "add", "pic.path == null && pic.uuid == null && pic.md5 == null");
      a(paramMessageForPic, -3);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(paramMessageForPic, paramInt2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("skip uniseq:");
      localStringBuilder.append(paramMessageForPic.uniseq);
      localStringBuilder.append(",suMsgId:");
      localStringBuilder.append(paramMessageForPic.subMsgId);
      localStringBuilder.append("priority:");
      localStringBuilder.append(paramInt2);
      Logger.a("PIC_TAG_PRELOAD", "filter", localStringBuilder.toString());
      return;
    }
    if ((paramBoolean1) && (paramInt3 != 2)) {
      a(paramMessageForPic);
    }
    if ((paramInt1 & 0x2) == 2)
    {
      if (!c())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG_PRELOAD", 2, "messageForPicAddToQueue, cannot preDownload big pic");
        }
        a(paramMessageForPic, -1);
        return;
      }
      paramInt1 = 0;
      paramBoolean1 = GIFPreDownloadLimit.a(paramMessageForPic, false, paramInt2);
      if ((paramBoolean2) || (paramBoolean1)) {
        paramInt1 = 1;
      }
      if ((paramInt3 != 1) && (!paramBoolean1))
      {
        Logger.a("PIC_TAG_PRELOAD", "add", "The troop is num troop");
        a(paramMessageForPic, -7);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(paramMessageForPic))
      {
        if ((a(paramMessageForPic, paramInt2)) && (paramInt1 != 0))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.b()) {
            d();
          } else {
            Logger.a("PIC_TAG_PRELOAD", "add", "handling queue full");
          }
          if ((paramMessageForPic.checkGif()) && (!paramMessageForPic.isSendFromLocal()) && (paramInt2 == 5) && (!PicHelperImpl.hasThumbFile(paramMessageForPic)))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("not hasThumbFile,download thumb,uniseq: ");
            localStringBuilder.append(paramMessageForPic.uniseq);
            localStringBuilder.append(", priority: ");
            localStringBuilder.append(paramInt2);
            Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", localStringBuilder.toString());
            a(paramMessageForPic);
          }
        }
      }
      else
      {
        a(paramMessageForPic, -6);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FINISH uniseq:");
    localStringBuilder.append(paramMessageForPic.uniseq);
    localStringBuilder.append(",suMsgId:");
    localStringBuilder.append(paramMessageForPic.subMsgId);
    localStringBuilder.append(",priority:");
    localStringBuilder.append(paramInt2);
    Logger.a("PIC_TAG_PRELOAD", "add", localStringBuilder.toString());
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    int i = PicPreDownloadUtils.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("network=");
    ((StringBuilder)localObject).append(i);
    Logger.a("PIC_TAG_PRELOAD", "setMessageRecordNetworkType", ((StringBuilder)localObject).toString());
    if ((paramMessageRecord instanceof MessageForPic))
    {
      ((MessageForPic)paramMessageRecord).preDownNetworkType = i;
      return;
    }
    if (((IMsgMixed)QRoute.api(IMsgMixed.class)).isMessageForMixedMsg(paramMessageRecord))
    {
      paramMessageRecord = ((IMsgMixed)QRoute.api(IMsgMixed.class)).getElementList(paramMessageRecord).iterator();
      while (paramMessageRecord.hasNext())
      {
        localObject = (MessageRecord)paramMessageRecord.next();
        if ((localObject instanceof MessageForPic)) {
          ((MessageForPic)localObject).preDownNetworkType = i;
        }
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      c(paramMessageRecord, paramInt1, paramInt2);
      return;
    }
    if (((IMsgMixed)QRoute.api(IMsgMixed.class)).isMessageForMixedMsg(paramMessageRecord))
    {
      List localList = ((IMsgMixed)QRoute.api(IMsgMixed.class)).getElementList(paramMessageRecord);
      int i = 0;
      while (i < localList.size())
      {
        Object localObject = (MessageRecord)localList.get(i);
        if ((localObject instanceof MessageForPic))
        {
          localObject = (MessageForPic)localObject;
          if (((MessageForPic)localObject).time == 0L) {
            ((IMsgMixed)QRoute.api(IMsgMixed.class)).copyBaseInfoFromMixedToPic((MessageForPic)localObject, paramMessageRecord);
          }
          c((MessageRecord)localObject, paramInt1, paramInt2);
        }
        i += 1;
      }
    }
    if (((IMsgStructing)QRoute.api(IMsgStructing.class)).isMessageForStructing(paramMessageRecord)) {
      c(paramMessageRecord, paramInt1, paramInt2);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != 0) && (paramInt3 == 2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("add struct msg to queue, num group skip, uniseq:");
      localStringBuilder.append(paramMessageRecord.uniseq);
      localStringBuilder.append("priority:");
      localStringBuilder.append(paramInt2);
      Logger.a("PIC_TAG_PRELOAD", "add", localStringBuilder.toString());
      return;
    }
    if ((!jdField_a_of_type_Boolean) && (paramInt1 != 0)) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.add(paramMessageRecord);
    }
    catch (Exception paramMessageRecord)
    {
      label88:
      break label88;
    }
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append("no preDownload exception happened,networkType:");
    paramMessageRecord.append(paramInt1);
    Logger.a("PIC_TAG_PRELOAD", "structMsg-screenOFF", paramMessageRecord.toString());
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append("no preDownload,networkType:");
    paramMessageRecord.append(paramInt1);
    Logger.a("PIC_TAG_PRELOAD", "structMsg-screenOFF", paramMessageRecord.toString());
    return;
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(new PicPreDownloader.4(this, paramMessageRecord), "addToQueue-MessageForStruct", paramMessageRecord);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("finish preDownload uniseq:");
    localStringBuilder.append(paramMessageRecord.uniseq);
    localStringBuilder.append(",");
    Logger.a("PIC_TAG_PRELOAD", "structMsg-add ", localStringBuilder.toString());
  }
  
  private boolean a(MessageForPic paramMessageForPic, int paramInt)
  {
    if (PicHelperImpl.hasBigFile(paramMessageForPic))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hasBigFile, uniseq: ");
      ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
      ((StringBuilder)localObject).append(", priority: ");
      ((StringBuilder)localObject).append(paramInt);
      Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", ((StringBuilder)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the big picture already exists");
      }
      PicPreDownloadUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMessageForPic);
      return false;
    }
    if ((FlashPicHelper.a(paramMessageForPic)) && (AbsDownloader.getFlashPicFile(((IPicHelper)QRoute.api(IPicHelper.class)).getURL(paramMessageForPic, 1, null).toString()) != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hasFlashPicFile, uniseq: ");
      ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
      ((StringBuilder)localObject).append(", priority: ");
      ((StringBuilder)localObject).append(paramInt);
      Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", ((StringBuilder)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the picture already exists");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "real download a big picture");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" START uniseq:");
    ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
    ((StringBuilder)localObject).append(", suMsgId: ");
    ((StringBuilder)localObject).append(paramMessageForPic.subMsgId);
    ((StringBuilder)localObject).append(", priority:");
    ((StringBuilder)localObject).append(paramInt);
    Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", ((StringBuilder)localObject).toString());
    if (PicPreDownloadUtils.a() == 0) {
      i = 1536;
    } else {
      i = 1537;
    }
    localObject = PicBusiManager.a(6, i, 2);
    PicDownloadInfo localPicDownloadInfo = paramMessageForPic.getPicDownloadInfo();
    if (localPicDownloadInfo != null)
    {
      localPicDownloadInfo.h = 1;
      localPicDownloadInfo.e = "chatimg";
    }
    ((PicReq)localObject).a(paramMessageForPic, localPicDownloadInfo);
    int i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin);
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a((PicReq)localObject, i, paramInt);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("END uniseq:");
    ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
    ((StringBuilder)localObject).append(", suMsgId: ");
    ((StringBuilder)localObject).append(paramMessageForPic.subMsgId);
    ((StringBuilder)localObject).append(", priority: ");
    ((StringBuilder)localObject).append(paramInt);
    Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", ((StringBuilder)localObject).toString());
    return true;
  }
  
  private void b(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    boolean bool2 = paramMessageRecord instanceof MessageForPic;
    if (bool2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("START uniseq:");
      MessageForPic localMessageForPic = (MessageForPic)paramMessageRecord;
      ((StringBuilder)localObject).append(localMessageForPic.uniseq);
      ((StringBuilder)localObject).append(", suMsgId:");
      ((StringBuilder)localObject).append(localMessageForPic.subMsgId);
      ((StringBuilder)localObject).append(", priority:");
      ((StringBuilder)localObject).append(paramInt2);
      Logger.a("PIC_TAG_PRELOAD", "add", ((StringBuilder)localObject).toString());
    }
    if ((paramMessageRecord.isMultiMsg) && (!paramMessageRecord.isSend()))
    {
      localObject = ((IMultiMsg)QRoute.api(IMultiMsg.class)).getMultiMsgValue();
      if (((MultiMsgBean)localObject).jdField_a_of_type_JavaLangObject != null)
      {
        i = ((MultiMsgBean)localObject).jdField_a_of_type_Int;
        localObject = ((MultiMsgBean)localObject).jdField_a_of_type_JavaLangString;
      }
      else
      {
        i = paramMessageRecord.istroop;
        localObject = paramMessageRecord.frienduin;
      }
    }
    else
    {
      i = paramMessageRecord.istroop;
      localObject = paramMessageRecord.frienduin;
    }
    int i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, i, (String)localObject);
    int j = PicPreDownloadUtils.a();
    int k = ((IConversationFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IConversationFacade.class, "")).getTroopMask((String)localObject);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(i, j);
    int n = 0;
    int m = n;
    boolean bool1;
    if (localObject[0] != 0)
    {
      m = n;
      if ((paramInt1 & 0x1) == 1) {
        bool1 = true;
      }
    }
    n = localObject[1];
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("preDownThumb=");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(" preDownBig=");
    ((StringBuilder)localObject).append(n);
    Logger.a("PIC_TAG_PRELOAD", "add", ((StringBuilder)localObject).toString());
    if (bool2)
    {
      a((MessageForPic)paramMessageRecord, paramInt1, paramInt2, k, bool1, n);
      return;
    }
    if (((IMsgStructing)QRoute.api(IMsgStructing.class)).isMessageForStructing(paramMessageRecord)) {
      a(paramMessageRecord, j, paramInt2, k);
    }
  }
  
  private boolean b()
  {
    return BaseStrategy.jdField_a_of_type_Boolean;
  }
  
  private void c(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (paramMessageRecord.isSendFromLocal())
    {
      Logger.a("PIC_TAG_PRELOAD", "add", "MessageRecord isSendFromLocal");
      return;
    }
    b(paramMessageRecord, paramInt1, paramInt2);
  }
  
  private boolean c()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = BaseApplication.getContext().getString(2131694986);
    boolean bool1 = true;
    boolean bool2 = SettingCloneUtil.readValue(localBaseApplication, null, str, "qqsetting_auto_receive_pic_key", true);
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1)
    {
      if (bool2) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private void e()
  {
    Logger.a("PIC_TAG_PRELOAD", "consumeThumb", "START");
    int i = PicPreDownloadUtils.a();
    if ((!jdField_a_of_type_Boolean) && (i != 0))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("no preDownload,networkType:");
      ((StringBuilder)localObject1).append(i);
      Logger.a("PIC_TAG_PRELOAD", "screenOFF", ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    StringBuilder localStringBuilder;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (PicReq)((Iterator)localObject2).next();
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(new PicPreDownloader.6(this, (PicReq)localObject1), "consumeAllThumbsInPendingQueue-thumbPendingQueue", ((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
      if (((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("uniseq:");
        localStringBuilder.append(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Long);
        localObject1 = localStringBuilder.toString();
      }
      else
      {
        localObject1 = "";
      }
      Logger.a("PIC_TAG_PRELOAD", "run picReq thumb", (String)localObject1);
    }
    this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
    Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(new PicPreDownloader.7(this, (MessageRecord)localObject2), "consumeAllThumbsInPendingQueue-structMsgPendingQueue", (MessageRecord)localObject2);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("finish struct msg preDownload,  uniseq =");
        localStringBuilder.append(((MessageRecord)localObject2).uniseq);
        Logger.a("PIC_TAG_PRELOAD", "structMsg-add ", localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.clear();
    Logger.a("PIC_TAG_PRELOAD", "consumeThumb", "END");
  }
  
  public int a(MessageForPic paramMessageForPic)
  {
    return this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(paramMessageForPic);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.b();
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    a(paramMessageForPic);
    if ((BaseStrategy.c != 2L) && (BaseStrategy.c != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIO(): PicAuDownTimePoint is not DOWNLOAD_POINT_AIO or DOWNLOAD_POINT_ALL");
      }
      a(paramMessageForPic, -2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIO(): ");
    }
    a(paramMessageForPic, paramInt, 5);
  }
  
  protected void a(MessageRecord paramMessageRecord, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Reason=");
    ((StringBuilder)localObject).append(paramInt);
    Logger.a("PIC_TAG_PRELOAD", "setNotPreDownloadReason", ((StringBuilder)localObject).toString());
    if ((paramMessageRecord instanceof MessageForPic))
    {
      ((MessageForPic)paramMessageRecord).mNotPredownloadReason = paramInt;
      return;
    }
    if (((IMsgMixed)QRoute.api(IMsgMixed.class)).isMessageForMixedMsg(paramMessageRecord))
    {
      paramMessageRecord = ((IMsgMixed)QRoute.api(IMsgMixed.class)).getElementList(paramMessageRecord).iterator();
      while (paramMessageRecord.hasNext())
      {
        localObject = (MessageRecord)paramMessageRecord.next();
        if ((localObject instanceof MessageForPic)) {
          ((MessageForPic)localObject).mNotPredownloadReason = paramInt;
        }
      }
    }
  }
  
  public void a(PicReq paramPicReq, DownCallBack.DownResult paramDownResult)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(paramPicReq))
    {
      if ((paramDownResult != null) && (paramDownResult.b != null))
      {
        paramPicReq = paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        if ((paramPicReq != null) && (paramPicReq.size == 0L))
        {
          if (GIFPreDownloadLimit.a(paramPicReq)) {
            return;
          }
          long l = new File(paramDownResult.b).length();
          this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(paramPicReq, l);
        }
      }
      d();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.c();
  }
  
  public void b(MessageForPic paramMessageForPic, int paramInt)
  {
    a(paramMessageForPic);
    if ((BaseStrategy.c != 2L) && (BaseStrategy.c != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIO(): PicAuDownTimePoint is not DOWNLOAD_POINT_AIO or DOWNLOAD_POINT_ALL");
      }
      a(paramMessageForPic, -2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIODynamicPic(): ");
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(new PicPreDownloader.2(this, paramMessageForPic, paramInt), "productFromAIODynamicPic", paramMessageForPic);
  }
  
  public void b(MessageRecord paramMessageRecord, int paramInt)
  {
    a(paramMessageRecord);
    if (!b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): cannot preDownload");
      }
      a(paramMessageRecord, -1);
      return;
    }
    if ((BaseStrategy.c != 1L) && (BaseStrategy.c != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): PicAuDownTimePoint is not DOWNLOAD_POINT_MSG or DOWNLOAD_POINT_ALL");
      }
      a(paramMessageRecord, -2);
      return;
    }
    if ((((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).isChatting()) && (((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).getCurrChatUin().equals(paramMessageRecord.frienduin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "The AIO is opening, does not need to preDownload the thumb picture");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): ");
    }
    if ((paramMessageRecord instanceof MessageForPic))
    {
      MessageForPic localMessageForPic = (MessageForPic)paramMessageRecord;
      localMessageForPic.getReportInfo().b = PicPreDownloadUtils.a();
      localMessageForPic.getReportInfo().jdField_a_of_type_Long = System.currentTimeMillis();
      localMessageForPic.getReportInfo().jdField_a_of_type_Int = 0;
    }
    a(paramMessageRecord, paramInt, 1);
    ChatImageDownloader.reportClientExist(paramMessageRecord);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.d();
  }
  
  public void d()
  {
    Logger.a("PIC_TAG_PRELOAD", "consume", "START");
    if (!this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a())
    {
      Logger.a("PIC_TAG_PRELOAD", "consume", "!mIsPicPreloadSuitable.get() failed");
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.b())
    {
      Logger.a("PIC_TAG_PRELOAD", "consume", "handlingNum.get() >= MAX_HANDLING_THREADS");
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore;
    boolean bool2 = false;
    localObject1 = ((PicPreDownloaderCore)localObject1).a(false);
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
      {
        bool1 = bool2;
        if (((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbWidthHeightDP != null)
        {
          bool1 = ((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbWidthHeightDP.useCustomSize();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("isBigImage=");
          ((StringBuilder)localObject1).append(bool1);
          Logger.a("PIC_TAG_PRELOAD", "consume", ((StringBuilder)localObject1).toString());
        }
      }
    }
    int j = PicPreDownloadUtils.a();
    if ((!jdField_a_of_type_Boolean) && (j != 0) && (!bool1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("no preDownload,networkType:");
      ((StringBuilder)localObject1).append(j);
      Logger.a("PIC_TAG_PRELOAD", "screenOFF", ((StringBuilder)localObject1).toString());
      return;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(true);
    if (localObject1 != null)
    {
      if (((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null)
      {
        Logger.b("PIC_TAG_PRELOAD", "consume", "picReq.downInfo == null");
        a(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -4);
        return;
      }
      Map localMap = this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a;
      localMap.remove(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g);
      int i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b, ((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.c);
      int k = this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.d, i, j, PicBusUtil.a(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType), ((PicReq)localObject1).e);
      a(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic, k);
      Object localObject2;
      if (k < 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("overLimit uinType=");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" networkType=");
        ((StringBuilder)localObject2).append(j);
        Logger.a("PIC_TAG_PRELOAD", "consume", ((StringBuilder)localObject2).toString());
        if (!GIFPreDownloadLimit.a(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(((PicReq)localObject1).e);
          if (localObject2 != null)
          {
            ((Collection)localObject2).add(localObject1);
            localMap.put(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g, Integer.valueOf(((PicReq)localObject1).e));
            this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.e();
          }
        }
        return;
      }
      if ((((PicReq)localObject1).jdField_a_of_type_Int == 6) && (!GIFPreDownloadLimit.a(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic)) && (this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(i, j)[1] == 0))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Network changed, put the picReq back to list, uinType:");
        ((StringBuilder)localObject2).append(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b);
        ((StringBuilder)localObject2).append(", networkType:");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(", uniseq:");
        ((StringBuilder)localObject2).append(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Long);
        Logger.a("PIC_TAG_PRELOAD", "consume", ((StringBuilder)localObject2).toString());
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(((PicReq)localObject1).e);
        if (localObject2 != null)
        {
          ((Collection)localObject2).add(localObject1);
          localMap.put(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g, Integer.valueOf(((PicReq)localObject1).e));
          this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.e();
        }
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a((PicReq)localObject1);
      if ((((PicReq)localObject1).jdField_a_of_type_Int == 6) && (!GIFPreDownloadLimit.a(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic)) && (!new File(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.c()).exists()))
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.d, j);
        i = -2147483648;
        if (((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
          i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, ((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin);
        }
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.b(j, i);
      }
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(new PicPreDownloader.8(this, (PicReq)localObject1), "consume", ((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    }
    Logger.a("PIC_TAG_PRELOAD", "consume", "END");
  }
  
  public void onDestroy()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroy, receiver:");
        localStringBuilder.append(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        QLog.d("PIC_TAG_PRELOAD", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, localException.getMessage());
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader
 * JD-Core Version:    0.7.0.1
 */