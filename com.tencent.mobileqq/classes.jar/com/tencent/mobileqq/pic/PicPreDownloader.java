package com.tencent.mobileqq.pic;

import agpm;
import agpn;
import agpo;
import agpp;
import agpq;
import agpr;
import agps;
import agpt;
import agpu;
import agpv;
import agpw;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.ChatImageDownloader;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;

public class PicPreDownloader
  implements Manager
{
  public static boolean a;
  public static boolean b;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public QQAppInterface a;
  PicStatisticsManager jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager;
  public PreDownloadStrategyBeta a;
  public List a;
  public Map a;
  Timer jdField_a_of_type_JavaUtilTimer;
  LinkedBlockingQueue jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue = new LinkedBlockingQueue(100);
  PriorityBlockingQueue jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  public AtomicBoolean a;
  public AtomicInteger a;
  public List b;
  public PriorityBlockingQueue b;
  public List c = Collections.synchronizedList(new LinkedList());
  public List d = Collections.synchronizedList(new LinkedList());
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public PicPreDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new agpw(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta = new PreDownloadStrategyBeta();
    DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta);
    ThreadManager.post(new agpm(this, paramQQAppInterface), 5, null, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager = ((PicStatisticsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(72));
    Logger.a("PIC_TAG_PRELOAD", "onInit", "Finished");
  }
  
  public int a(MessageForPic paramMessageForPic)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForPic.uuid);
    if (localInteger == null) {
      return -1;
    }
    Collection localCollection = a(localInteger.intValue());
    if (localCollection != null) {
      try
      {
        Iterator localIterator = localCollection.iterator();
        while (localIterator.hasNext())
        {
          PicReq localPicReq = (PicReq)localIterator.next();
          if (paramMessageForPic.subMsgId == localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_Int)
          {
            Logger.a("PIC_TAG_PRELOAD", "getPriority", "uuid: " + paramMessageForPic.uuid + " subMsgId: " + paramMessageForPic.subMsgId);
            int i = localInteger.intValue();
            return i;
          }
        }
      }
      finally {}
    }
    return -1;
  }
  
  PicReq a()
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      PicReq localPicReq1;
      if (i > 0)
      {
        Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from AIORequests");
        localPicReq1 = (PicReq)this.jdField_a_of_type_JavaUtilList.get(i - 1);
        this.jdField_a_of_type_JavaUtilList.remove(i - 1);
        return localPicReq1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from C2CRequests");
          localPicReq1 = (PicReq)this.jdField_b_of_type_JavaUtilList.get(i - 1);
          this.jdField_b_of_type_JavaUtilList.remove(i - 1);
          return localPicReq1;
        }
      }
    }
    synchronized (this.c)
    {
      i = this.c.size();
      if (i > 0)
      {
        Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from DiscussionRequests");
        PicReq localPicReq2 = (PicReq)this.c.get(i - 1);
        this.c.remove(i - 1);
        return localPicReq2;
      }
    }
    synchronized (this.d)
    {
      i = this.d.size();
      if (i > 0)
      {
        Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from GroupRequests");
        PicReq localPicReq3 = (PicReq)this.d.get(i - 1);
        this.d.remove(i - 1);
        return localPicReq3;
      }
    }
    Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "cannot get any request");
    return null;
  }
  
  PicReq a(String paramString, Collection paramCollection)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramCollection.iterator();
        if (localIterator.hasNext())
        {
          PicReq localPicReq = (PicReq)localIterator.next();
          if (localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null) {
            continue;
          }
          if (localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_Int == 1)
          {
            bool = true;
            int i = URLDrawableHelper.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_JavaLangString, bool);
            String str = TransFileController.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.f, localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString, i);
            if ((paramString == null) || (!paramString.equals(str))) {
              continue;
            }
            paramCollection.remove(localPicReq);
            this.jdField_a_of_type_JavaUtilMap.remove(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString);
            a(localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -5);
            return localPicReq;
          }
        }
        else
        {
          return null;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  Collection a(int paramInt)
  {
    Logger.a("PIC_TAG_PRELOAD", "getRequestsByPriority", "priority=" + paramInt);
    switch (paramInt)
    {
    default: 
      return null;
    case 6: 
      return this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue;
    case 5: 
      return this.jdField_a_of_type_JavaUtilList;
    case 4: 
      return this.jdField_b_of_type_JavaUtilList;
    case 3: 
      return this.c;
    }
    return this.d;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    Logger.a("PIC_TAG_PRELOAD", "picPreDownloadOff", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer.purge();
    }
    try
    {
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new agpo(this), 60000L);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.hasThumbFile()) {}
    PicReq localPicReq;
    for (;;)
    {
      return;
      if ((ActionMsgUtil.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {}
      for (int i = 1; i == 0; i = 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.a(paramMessageForPic);
        localPicReq = PicBusiManager.a(5, 1536, 2);
        PicDownloadInfo localPicDownloadInfo = paramMessageForPic.getPicDownloadInfo();
        if (localPicDownloadInfo != null) {
          localPicDownloadInfo.h = 1;
        }
        localPicReq.a(paramMessageForPic, localPicDownloadInfo);
        i = PicPreDownloadUtils.a();
        if ((jdField_a_of_type_Boolean) || (i == 0)) {
          break label153;
        }
        Logger.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
        this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localPicReq);
        return;
      }
    }
    label153:
    ThreadManager.post(new agpt(this, localPicReq), 5, null, false);
    Logger.a("PIC_TAG_PRELOAD", "run picreq thumb", "uniseq:" + paramMessageForPic.uniseq + ",subMsgId:" + paramMessageForPic.subMsgId);
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    a(paramMessageForPic);
    if ((BaseStrategy.d != 2L) && (BaseStrategy.d != 0L))
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
  
  void a(MessageForPic paramMessageForPic, int paramInt1, int paramInt2)
  {
    ThreadManager.post(new agpq(this, paramMessageForPic, paramInt1, paramInt2), 5, null, false);
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta instanceof PreDownloadStrategyBeta)) {
      this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(paramMessageForPic, paramLong);
    }
  }
  
  void a(MessageRecord paramMessageRecord)
  {
    int i = PicPreDownloadUtils.a();
    Logger.a("PIC_TAG_PRELOAD", "setMessageRecordNetworkType", "network=" + i);
    if ((paramMessageRecord instanceof MessageForPic)) {
      ((MessageForPic)paramMessageRecord).preDownNetworkType = i;
    }
    for (;;)
    {
      return;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = ((MessageForMixedMsg)paramMessageRecord).msgElemList.iterator();
        while (paramMessageRecord.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.next();
          if ((localMessageRecord instanceof MessageForPic)) {
            ((MessageForPic)localMessageRecord).preDownNetworkType = i;
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    Logger.a("PIC_TAG_PRELOAD", "setNotPredownloadReason", "Reson=" + paramInt);
    if ((paramMessageRecord instanceof MessageForPic)) {
      ((MessageForPic)paramMessageRecord).mNotPredownloadReason = paramInt;
    }
    for (;;)
    {
      return;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = ((MessageForMixedMsg)paramMessageRecord).msgElemList.iterator();
        while (paramMessageRecord.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.next();
          if ((localMessageRecord instanceof MessageForPic)) {
            ((MessageForPic)localMessageRecord).mNotPredownloadReason = paramInt;
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      c((MessageForPic)paramMessageRecord, paramInt1, paramInt2);
    }
    do
    {
      for (;;)
      {
        return;
        if (!(paramMessageRecord instanceof MessageForMixedMsg)) {
          break;
        }
        paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
        int i = 0;
        while (i < paramMessageRecord.msgElemList.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.msgElemList.get(i);
          if ((localMessageRecord instanceof MessageForPic))
          {
            MessageForPic localMessageForPic = (MessageForPic)localMessageRecord;
            if (localMessageForPic.time == 0L) {
              MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, paramMessageRecord);
            }
            c(localMessageForPic, paramInt1, paramInt2);
          }
          i += 1;
        }
      }
    } while ((!(paramMessageRecord instanceof MessageForStructing)) || (!StructMsgPicPreDelegate.jdField_a_of_type_Boolean));
    c(paramMessageRecord, paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    PicReq localPicReq = a(paramString, this.jdField_a_of_type_JavaUtilList);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localPicReq.jdField_a_of_type_Int);
      return;
    }
    localPicReq = a(paramString, this.jdField_b_of_type_JavaUtilList);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localPicReq.jdField_a_of_type_Int);
      return;
    }
    localPicReq = a(paramString, this.c);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localPicReq.jdField_a_of_type_Int);
      return;
    }
    localPicReq = a(paramString, this.d);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localPicReq.jdField_a_of_type_Int);
      return;
    }
    Logger.a("PIC_TAG_PRELOAD", "", "drop", "Cannot be found in the request stacks");
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131433586), "qqsetting_auto_receive_pic_key", true);
    if ((NetworkUtil.b(BaseApplication.getContext()) == 1) || (bool2)) {}
    for (int i = 1;; i = 0)
    {
      if (("1".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "UseLocalFlowSet"))) || (i != 0)) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  boolean a(MessageForPic paramMessageForPic, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForPic.uuid);
    if (localInteger == null)
    {
      Logger.a("PIC_TAG_PRELOAD", "filter", "uuid=" + paramMessageForPic.uuid + ", priority=" + paramInt + ", cannot be found in the PriorityMap");
      return bool2;
    }
    Collection localCollection = a(localInteger.intValue());
    Logger.a("PIC_TAG_PRELOAD", "filter", "priority: " + paramInt + ", uniseq: " + paramMessageForPic.uniseq + ", subMsgId:" + paramMessageForPic.subMsgId);
    if (localCollection == null)
    {
      Logger.a("PIC_TAG_PRELOAD", "filter", "originalRequests == null");
      return false;
    }
    Object localObject1 = null;
    label339:
    for (;;)
    {
      try
      {
        Iterator localIterator = localCollection.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (PicReq)localIterator.next();
          if (paramMessageForPic.subMsgId != ((PicReq)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_Int) {
            break label339;
          }
          bool1 = true;
          localObject1 = localObject2;
          break label339;
        }
        if ((!bool1) || (paramInt <= localInteger.intValue()))
        {
          Logger.a("PIC_TAG_PRELOAD", "filter", "No need to update the picReq");
          return bool1;
        }
      }
      finally {}
      Object localObject2 = a(paramInt);
      bool2 = bool1;
      if (localObject2 == null) {
        break;
      }
      localObject1.jdField_e_of_type_Int = localObject1.d;
      localObject1.d = paramInt;
      localCollection.remove(localObject1);
      ((Collection)localObject2).add(localObject1);
      this.jdField_a_of_type_JavaUtilMap.put(paramMessageForPic.uuid, Integer.valueOf(paramInt));
      Logger.a("PIC_TAG_PRELOAD", "filter", "update the picReq");
      return bool1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Logger.a("PIC_TAG_PRELOAD", "picPreDownloadOn", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    f();
  }
  
  public void b(MessageForPic paramMessageForPic, int paramInt)
  {
    a(paramMessageForPic);
    if ((BaseStrategy.d != 2L) && (BaseStrategy.d != 0L))
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
    ThreadManager.post(new agpp(this, paramMessageForPic, paramInt), 5, null, false);
  }
  
  public void b(MessageRecord paramMessageRecord, int paramInt)
  {
    a(paramMessageRecord);
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): cannot predownload");
      }
      a(paramMessageRecord, -1);
    }
    Object localObject;
    do
    {
      return;
      if ((BaseStrategy.d != 1L) && (BaseStrategy.d != 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): PicAuDownTimePoint is not DOWNLOAD_POINT_MSG or DOWNLOAD_POINT_ALL");
        }
        a(paramMessageRecord, -2);
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((!((QQMessageFacade)localObject).a()) || (!((QQMessageFacade)localObject).a().equals(paramMessageRecord.frienduin))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "The AIO is opening, does not need to predownload the thumb picture");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): ");
    }
    if ((paramMessageRecord instanceof MessageForPic))
    {
      localObject = (MessageForPic)paramMessageRecord;
      ((MessageForPic)localObject).getReportInfo().b = PicPreDownloadUtils.a();
      ((MessageForPic)localObject).getReportInfo().jdField_a_of_type_Long = System.currentTimeMillis();
      ((MessageForPic)localObject).getReportInfo().jdField_a_of_type_Int = 0;
    }
    a(paramMessageRecord, paramInt, 1);
    ChatImageDownloader.a(paramMessageRecord);
  }
  
  public void b(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      Logger.a("PIC_TAG_PRELOAD", "add", "START uniseq:" + ((MessageForPic)paramMessageRecord).uniseq + ",suMsgId:" + ((MessageForPic)paramMessageRecord).subMsgId + ",priority:" + paramInt2);
    }
    Object localObject;
    int i;
    int j;
    int k;
    if ((paramMessageRecord.isMultiMsg) && (!paramMessageRecord.isSend()))
    {
      localObject = MultiMsgManager.a().a();
      if (localObject != null)
      {
        i = ((SessionInfo)localObject).jdField_a_of_type_Int;
        localObject = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
        i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject);
        j = PicPreDownloadUtils.a();
        k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject);
        if ((j == 0) || (k != 2)) {
          break label243;
        }
        if ((paramMessageRecord instanceof MessageForPic)) {
          Logger.a("PIC_TAG_PRELOAD", "add", "num group skip, uniseq:" + paramMessageRecord.uniseq + ",suMsgId:" + ((MessageForPic)paramMessageRecord).subMsgId + "priority:" + paramInt2);
        }
      }
    }
    label243:
    do
    {
      do
      {
        return;
        i = paramMessageRecord.istroop;
        localObject = paramMessageRecord.frienduin;
        break;
        i = paramMessageRecord.istroop;
        localObject = paramMessageRecord.frienduin;
        break;
        localObject = this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(i, j);
        if ((localObject[0] != 0) && ((paramInt1 & 0x1) == 1)) {}
        int m;
        for (boolean bool = true;; bool = false)
        {
          m = localObject[1];
          Logger.a("PIC_TAG_PRELOAD", "add", "preDownThumb=" + bool + " preDownBig=" + m);
          if (!(paramMessageRecord instanceof MessageForPic)) {
            break label693;
          }
          localObject = (MessageForPic)paramMessageRecord;
          if ((((MessageForPic)localObject).path != null) || (((MessageForPic)localObject).uuid != null) || (((MessageForPic)localObject).md5 != null)) {
            break;
          }
          Logger.a("PIC_TAG_PRELOAD", "add", "pic.path == null && pic.uuid == null && pic.md5 == null");
          a(paramMessageRecord, -3);
          return;
        }
        if (a((MessageForPic)localObject, paramInt2))
        {
          Logger.a("PIC_TAG_PRELOAD", "filter", "skip uniseq:" + ((MessageForPic)localObject).uniseq + ",suMsgId:" + ((MessageForPic)localObject).subMsgId + "priority:" + paramInt2);
          return;
        }
        if (bool) {
          a((MessageForPic)localObject);
        }
        if ((paramInt1 & 0x2) == 2)
        {
          if (k == 1) {
            break label547;
          }
          Logger.a("PIC_TAG_PRELOAD", "add", "The troop is not MSG_FILTER_VALUE.MSG_FILTER_OPEN");
          a(paramMessageRecord, -7);
        }
        for (;;)
        {
          Logger.a("PIC_TAG_PRELOAD", "add", "FINISH uniseq:" + ((MessageForPic)localObject).uniseq + ",suMsgId:" + ((MessageForPic)localObject).subMsgId + ",priority:" + paramInt2);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a((MessageForPic)localObject))
          {
            if ((b((MessageForPic)localObject, paramInt2)) && (m != 0))
            {
              if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 1) {
                f();
              }
              for (;;)
              {
                if ((!((MessageForPic)localObject).checkGif()) || (((MessageForPic)localObject).isSendFromLocal()) || (paramInt2 != 5) || (((MessageForPic)localObject).hasThumbFile())) {
                  break label681;
                }
                Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", "not hasThumbFile,download thumb,uniseq: " + ((MessageForPic)localObject).uniseq + ", priority: " + paramInt2);
                a((MessageForPic)localObject);
                break;
                Logger.a("PIC_TAG_PRELOAD", "add", "handlingNum.get() >= MAX_HANDLING_THREADS");
              }
            }
          }
          else {
            a(paramMessageRecord, -6);
          }
        }
      } while (!(paramMessageRecord instanceof MessageForStructing));
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
    } while (paramMessageRecord == null);
    label547:
    label681:
    label693:
    if ((!jdField_a_of_type_Boolean) && (j != 0)) {
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.add(paramMessageRecord);
        Logger.a("PIC_TAG_PRELOAD", "structMsg-screenOFF", "no preDownload,networkType:" + j);
        return;
      }
      catch (Exception paramMessageRecord)
      {
        for (;;)
        {
          Logger.a("PIC_TAG_PRELOAD", "structMsg-screenOFF", "no preDownload exception happened,networkType:" + j);
        }
      }
    }
    ThreadManager.post(new agps(this, paramMessageRecord), 5, null, false);
    Logger.a("PIC_TAG_PRELOAD", "structMsg-add ", "finish preDownload uniseq =" + paramMessageRecord.uniseq);
  }
  
  boolean b(MessageForPic paramMessageForPic, int paramInt)
  {
    if (paramMessageForPic.hasBigFile())
    {
      Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", "hasBigFile, uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the big picture already exists");
      }
      PicPreDownloadUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic);
    }
    do
    {
      return false;
      if (((!HotChatHelper.a(paramMessageForPic)) && (!FlashPicHelper.a(paramMessageForPic))) || (AbsDownloader.b(URLDrawableHelper.a(paramMessageForPic, 1, null).toString()) == null)) {
        break;
      }
      Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", "hasFlashPicFile, uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the picture already exists");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "real download a big picture");
    }
    Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", " START uniseq: " + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority:" + paramInt);
    int i;
    PicReq localPicReq;
    Object localObject;
    List localList;
    if (PicPreDownloadUtils.a() == 0)
    {
      i = 1536;
      localPicReq = PicBusiManager.a(6, i, 2);
      localObject = paramMessageForPic.getPicDownloadInfo();
      if (localObject != null)
      {
        ((PicDownloadInfo)localObject).h = 1;
        ((PicDownloadInfo)localObject).jdField_e_of_type_JavaLangString = "chatimg";
      }
      localPicReq.a(paramMessageForPic, (PicDownloadInfo)localObject);
      localList = null;
      localObject = "";
      i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin);
      if (paramInt != 5) {
        break label517;
      }
      localList = this.jdField_a_of_type_JavaUtilList;
      localPicReq.d = 5;
      localObject = "AIORequests";
      switch (i)
      {
      default: 
        localPicReq.jdField_e_of_type_Int = 2;
      }
    }
    for (;;)
    {
      if (localList != null)
      {
        Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", "successfully to add the pic request to " + (String)localObject);
        localList.add(localPicReq);
        d();
        this.jdField_a_of_type_JavaUtilMap.put(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString, Integer.valueOf(localPicReq.d));
      }
      Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", "END uniseq: " + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority: " + paramInt);
      return true;
      i = 1537;
      break;
      localPicReq.jdField_e_of_type_Int = 4;
      continue;
      localPicReq.jdField_e_of_type_Int = 3;
      continue;
      label517:
      if (paramInt == 1) {
        switch (i)
        {
        default: 
          localList = this.d;
          localPicReq.d = 2;
          localPicReq.jdField_e_of_type_Int = localPicReq.d;
          localObject = "GroupRequests";
          break;
        case 3: 
          localList = this.jdField_b_of_type_JavaUtilList;
          localPicReq.d = 4;
          localPicReq.jdField_e_of_type_Int = localPicReq.d;
          localObject = "C2CRequests";
          break;
        case 2: 
          localList = this.c;
          localPicReq.d = 3;
          localPicReq.jdField_e_of_type_Int = localPicReq.d;
          localObject = "DiscussionRequests";
        }
      }
    }
  }
  
  public void c()
  {
    try
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): AIORequests size=" + i);
      }
      ThreadManager.post(new agpr(this, i), 5, null, false);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): exception=" + localException.getMessage());
    }
  }
  
  void c(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
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
  
  void d()
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() + this.c.size() + this.d.size() > this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.jdField_a_of_type_Int) {
      localObject1 = null;
    }
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.d.size() > 0)
        {
          localObject1 = (PicReq)this.d.remove(0);
          if (localObject1 != null)
          {
            this.jdField_a_of_type_JavaUtilMap.remove(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta;
            ((PreDownloadStrategyBeta)localObject1).O += 1L;
            Logger.a("PIC_TAG_PRELOAD", "checkRequestListSize", "over max request list size: " + this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.jdField_a_of_type_Int + ", remove a request");
          }
          return;
        }
        synchronized (this.c)
        {
          if (this.c.size() > 0) {
            localObject1 = (PicReq)this.c.remove(0);
          }
        }
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
          PicReq localPicReq1 = (PicReq)this.jdField_b_of_type_JavaUtilList.remove(0);
        }
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          PicReq localPicReq2 = (PicReq)this.jdField_a_of_type_JavaUtilList.remove(0);
        }
      }
    }
  }
  
  public void e()
  {
    Logger.a("PIC_TAG_PRELOAD", "consumeThumb", "START");
    int i = PicPreDownloadUtils.a();
    if ((!jdField_a_of_type_Boolean) && (i != 0))
    {
      Logger.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (PicReq)((Iterator)localObject2).next();
      ThreadManager.post(new agpu(this, (PicReq)localObject1), 5, null, false);
      if (((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null) {
        break label248;
      }
    }
    label248:
    for (Object localObject1 = "uniseq:" + ((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Long;; localObject1 = "")
    {
      Logger.a("PIC_TAG_PRELOAD", "run picreq thumb", (String)localObject1);
      break;
      this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
      localObject1 = this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageForStructing)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          ThreadManager.post(new agpv(this, (MessageForStructing)localObject2), 5, null, false);
          Logger.a("PIC_TAG_PRELOAD", "structMsg-add ", "finish MessageForStructing preDownload uniseq =" + ((MessageForStructing)localObject2).uniseq);
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.clear();
      Logger.a("PIC_TAG_PRELOAD", "consumeThumb", "END");
      return;
    }
  }
  
  public void f()
  {
    Logger.a("PIC_TAG_PRELOAD", "consume", "START");
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      Logger.a("PIC_TAG_PRELOAD", "consume", "!mIsPicPreloadSuitable.get() failed");
    }
    int k;
    PicReq localPicReq;
    int i;
    int j;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 1)
        {
          Logger.a("PIC_TAG_PRELOAD", "consume", "handlingNum.get() >= MAX_HANDLING_THREADS");
          return;
        }
        k = PicPreDownloadUtils.a();
        if ((!jdField_a_of_type_Boolean) && (k != 0))
        {
          Logger.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + k);
          return;
        }
        localPicReq = a();
        if (localPicReq == null) {
          break label739;
        }
        if (localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null)
        {
          Logger.b("PIC_TAG_PRELOAD", "consume", "picReq.downinfo == null");
          a(localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -4);
          return;
        }
        this.jdField_a_of_type_JavaUtilMap.remove(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString);
        i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b, localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.c);
        j = this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.d, i, k, PeakUtils.a(localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType));
        a(localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, j);
        if (j >= 0) {
          break;
        }
        Logger.a("PIC_TAG_PRELOAD", "consume", "overLimit and put request back to list, uinType=" + i + " networkType=" + k);
        localObject = a(localPicReq.d);
      } while (localObject == null);
      ((Collection)localObject).add(localPicReq);
      this.jdField_a_of_type_JavaUtilMap.put(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString, Integer.valueOf(localPicReq.d));
      d();
      return;
      if ((localPicReq.jdField_a_of_type_Int != 6) || (this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(i, k)[1] != 0)) {
        break;
      }
      Logger.a("PIC_TAG_PRELOAD", "consume", "Network changed, put the picReq back to list, uintype:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b + ", networkType:" + k + ", uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Long);
      localObject = a(localPicReq.d);
    } while (localObject == null);
    ((Collection)localObject).add(localPicReq);
    this.jdField_a_of_type_JavaUtilMap.put(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString, Integer.valueOf(localPicReq.d));
    d();
    return;
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localPicReq);
    localPicReq.jdField_e_of_type_Int = localPicReq.d;
    localPicReq.d = 6;
    this.jdField_a_of_type_JavaUtilMap.put(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_JavaLangString, Integer.valueOf(6));
    if (localPicReq.jdField_a_of_type_Int == 6) {}
    for (Object localObject = " big";; localObject = " thumb")
    {
      Logger.a("PIC_TAG_PRELOAD", "run picreq" + (String)localObject, "uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Long + "subMsgId:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_g_of_type_Int + ",priority:" + localPicReq.d);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      if ((localPicReq.jdField_a_of_type_Int == 6) && (!new File(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.c()).exists()))
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.d, k);
        j = -2147483648;
        i = j;
        if (localPicReq != null)
        {
          i = j;
          if (localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
            i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.b(k, i);
      }
      ThreadManager.post(new agpn(this, localPicReq), 5, null, false);
      label739:
      Logger.a("PIC_TAG_PRELOAD", "consume", "END");
      return;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "onDestroy, receiver:" + this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer.purge();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG_PRELOAD", 2, localException.getMessage());
        }
        localException.printStackTrace();
      }
    }
    DeviceProfileManager.b(this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader
 * JD-Core Version:    0.7.0.1
 */