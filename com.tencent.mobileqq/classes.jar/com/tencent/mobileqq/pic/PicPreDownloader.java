package com.tencent.mobileqq.pic;

import ajhz;
import ajke;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import arxu;
import atox;
import atpg;
import atpl;
import atpn;
import atps;
import atpt;
import atpv;
import atqb;
import atqg;
import atqm;
import axoa;
import axpm;
import axvo;
import axwd;
import baac;
import badq;
import bfcq;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;

public class PicPreDownloader
  implements Manager
{
  public static boolean a;
  public static boolean b;
  volatile int jdField_a_of_type_Int = 0;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  atqb jdField_a_of_type_Atqb;
  public atqg a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Runnable jdField_a_of_type_JavaLangRunnable = new PicPreDownloader.1(this);
  List<atpv> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  public Map<String, Integer> a;
  ConcurrentLinkedQueue<PicPreDownloader.PicPreDownRunner> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  LinkedBlockingQueue<MessageForStructing> jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue = new LinkedBlockingQueue(100);
  PriorityBlockingQueue<atpv> jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public AtomicInteger a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  List<atpv> b;
  public PriorityBlockingQueue<atpv> b;
  List<atpv> c = Collections.synchronizedList(new LinkedList());
  List<atpv> d = Collections.synchronizedList(new LinkedList());
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public PicPreDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new atpt(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_Atqg = new atqg();
    DeviceProfileManager.a(this.jdField_a_of_type_Atqg);
    ThreadManager.post(new PicPreDownloader.2(this, paramQQAppInterface), 5, null, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Atqb = ((atqb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73));
    atpg.a("PIC_TAG_PRELOAD", "onInit", "Finished");
  }
  
  private void a(PicPreDownloader.PicPreDownRunner paramPicPreDownRunner)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramPicPreDownRunner);
    g();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Int < 3)
    {
      PicPreDownloader.PicPreDownRunner localPicPreDownRunner = (PicPreDownloader.PicPreDownRunner)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localPicPreDownRunner != null)
      {
        this.jdField_a_of_type_Int += 1;
        ThreadManager.excute(localPicPreDownRunner, 16, null, false);
      }
    }
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
          atpv localatpv = (atpv)localIterator.next();
          if (paramMessageForPic.subMsgId == localatpv.jdField_a_of_type_Atpn.jdField_g_of_type_Int)
          {
            atpg.a("PIC_TAG_PRELOAD", "getPriority", "uuid: " + paramMessageForPic.uuid + " subMsgId: " + paramMessageForPic.subMsgId);
            int i = localInteger.intValue();
            return i;
          }
        }
      }
      finally {}
    }
    return -1;
  }
  
  atpv a()
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      atpv localatpv1;
      if (i > 0)
      {
        atpg.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from AIORequests");
        localatpv1 = (atpv)this.jdField_a_of_type_JavaUtilList.get(i - 1);
        this.jdField_a_of_type_JavaUtilList.remove(i - 1);
        return localatpv1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          atpg.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from C2CRequests");
          localatpv1 = (atpv)this.jdField_b_of_type_JavaUtilList.get(i - 1);
          this.jdField_b_of_type_JavaUtilList.remove(i - 1);
          return localatpv1;
        }
      }
    }
    synchronized (this.c)
    {
      i = this.c.size();
      if (i > 0)
      {
        atpg.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from DiscussionRequests");
        atpv localatpv2 = (atpv)this.c.get(i - 1);
        this.c.remove(i - 1);
        return localatpv2;
      }
    }
    synchronized (this.d)
    {
      i = this.d.size();
      if (i > 0)
      {
        atpg.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from GroupRequests");
        atpv localatpv3 = (atpv)this.d.get(i - 1);
        this.d.remove(i - 1);
        return localatpv3;
      }
    }
    atpg.a("PIC_TAG_PRELOAD", "getPicRequest", "cannot get any request");
    return null;
  }
  
  atpv a(String paramString, Collection<atpv> paramCollection)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramCollection.iterator();
        if (localIterator.hasNext())
        {
          atpv localatpv = (atpv)localIterator.next();
          if (localatpv.jdField_a_of_type_Atpn == null) {
            continue;
          }
          if (localatpv.jdField_a_of_type_Atpn.jdField_e_of_type_Int == 1)
          {
            bool = true;
            int i = axwd.a(localatpv.jdField_a_of_type_Atpn.jdField_e_of_type_JavaLangString, bool);
            String str = axvo.a(localatpv.jdField_a_of_type_Atpn.f, localatpv.jdField_a_of_type_Atpn.jdField_g_of_type_JavaLangString, i);
            if ((paramString == null) || (!paramString.equals(str))) {
              continue;
            }
            paramCollection.remove(localatpv);
            this.jdField_a_of_type_JavaUtilMap.remove(localatpv.jdField_a_of_type_Atpn.jdField_g_of_type_JavaLangString);
            a(localatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -5);
            return localatpv;
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
  
  Collection<atpv> a(int paramInt)
  {
    atpg.a("PIC_TAG_PRELOAD", "getRequestsByPriority", "priority=" + paramInt);
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
    atpg.a("PIC_TAG_PRELOAD", "picPreDownloadOff", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
    }
  }
  
  void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.hasThumbFile()) {}
    atpv localatpv;
    for (;;)
    {
      return;
      if ((baac.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {}
      for (int i = 1; i == 0; i = 0)
      {
        this.jdField_a_of_type_Atqb.a(paramMessageForPic);
        localatpv = atpl.a(5, 1536, 2);
        localObject = paramMessageForPic.getPicDownloadInfo();
        if (localObject != null) {
          ((atpn)localObject).h = 1;
        }
        localatpv.a(paramMessageForPic, (atpn)localObject);
        i = atps.a();
        if ((jdField_a_of_type_Boolean) || (i == 0)) {
          break label152;
        }
        atpg.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
        this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localatpv);
        return;
      }
    }
    label152:
    String str = "consumeThumb";
    Object localObject = str;
    if (localatpv != null)
    {
      localObject = str;
      if (localatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
        localObject = "consumeThumb" + ", msgSeq = " + localatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.shmsgseq;
      }
    }
    a(new PicPreDownloader.PicPreDownRunner(this, new PicPreDownloader.7(this, localatpv), (String)localObject));
    atpg.a("PIC_TAG_PRELOAD", "run picreq thumb", "uniseq:" + paramMessageForPic.uniseq + ",subMsgId:" + paramMessageForPic.subMsgId);
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    a(paramMessageForPic);
    if ((atox.d != 2L) && (atox.d != 0L))
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
    String str = "productAysnc";
    if (paramMessageForPic != null) {
      str = "productAysnc" + ", msgSeq = " + paramMessageForPic.shmsgseq;
    }
    a(new PicPreDownloader.PicPreDownRunner(this, new PicPreDownloader.4(this, paramMessageForPic, paramInt1, paramInt2), str));
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong)
  {
    if ((this.jdField_a_of_type_Atqg instanceof atqg)) {
      this.jdField_a_of_type_Atqg.a(paramMessageForPic, paramLong);
    }
  }
  
  void a(MessageRecord paramMessageRecord)
  {
    int i = atps.a();
    atpg.a("PIC_TAG_PRELOAD", "setMessageRecordNetworkType", "network=" + i);
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
  
  void a(MessageRecord paramMessageRecord, int paramInt)
  {
    atpg.a("PIC_TAG_PRELOAD", "setNotPredownloadReason", "Reson=" + paramInt);
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
  
  void a(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
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
    } while ((!(paramMessageRecord instanceof MessageForStructing)) || (!atqm.jdField_a_of_type_Boolean));
    c(paramMessageRecord, paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    atpv localatpv = a(paramString, this.jdField_a_of_type_JavaUtilList);
    if (localatpv != null)
    {
      atpg.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localatpv.jdField_a_of_type_Atpn.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localatpv.jdField_a_of_type_Int);
      return;
    }
    localatpv = a(paramString, this.jdField_b_of_type_JavaUtilList);
    if (localatpv != null)
    {
      atpg.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localatpv.jdField_a_of_type_Atpn.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localatpv.jdField_a_of_type_Int);
      return;
    }
    localatpv = a(paramString, this.c);
    if (localatpv != null)
    {
      atpg.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localatpv.jdField_a_of_type_Atpn.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localatpv.jdField_a_of_type_Int);
      return;
    }
    localatpv = a(paramString, this.d);
    if (localatpv != null)
    {
      atpg.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localatpv.jdField_a_of_type_Atpn.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localatpv.jdField_a_of_type_Int);
      return;
    }
    atpg.a("PIC_TAG_PRELOAD", "", "drop", "Cannot be found in the request stacks");
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131629640), "qqsetting_auto_receive_pic_key", true);
    if ((badq.b(BaseApplication.getContext()) == 1) || (bool2)) {}
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
      atpg.a("PIC_TAG_PRELOAD", "filter", "uuid=" + paramMessageForPic.uuid + ", priority=" + paramInt + ", cannot be found in the PriorityMap");
      return bool2;
    }
    Collection localCollection = a(localInteger.intValue());
    atpg.a("PIC_TAG_PRELOAD", "filter", "priority: " + paramInt + ", uniseq: " + paramMessageForPic.uniseq + ", subMsgId:" + paramMessageForPic.subMsgId);
    if (localCollection == null)
    {
      atpg.a("PIC_TAG_PRELOAD", "filter", "originalRequests == null");
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
          localObject2 = (atpv)localIterator.next();
          if (paramMessageForPic.subMsgId != ((atpv)localObject2).jdField_a_of_type_Atpn.jdField_g_of_type_Int) {
            break label339;
          }
          bool1 = true;
          localObject1 = localObject2;
          break label339;
        }
        if ((!bool1) || (paramInt <= localInteger.intValue()))
        {
          atpg.a("PIC_TAG_PRELOAD", "filter", "No need to update the picReq");
          return bool1;
        }
      }
      finally {}
      Object localObject2 = a(paramInt);
      bool2 = bool1;
      if (localObject2 == null) {
        break;
      }
      localObject1.f = localObject1.jdField_e_of_type_Int;
      localObject1.jdField_e_of_type_Int = paramInt;
      localCollection.remove(localObject1);
      ((Collection)localObject2).add(localObject1);
      this.jdField_a_of_type_JavaUtilMap.put(paramMessageForPic.uuid, Integer.valueOf(paramInt));
      atpg.a("PIC_TAG_PRELOAD", "filter", "update the picReq");
      return bool1;
    }
  }
  
  atpv b()
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      atpv localatpv1;
      if (i > 0)
      {
        atpg.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from AIORequests");
        localatpv1 = (atpv)this.jdField_a_of_type_JavaUtilList.get(i - 1);
        return localatpv1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          atpg.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from C2CRequests");
          localatpv1 = (atpv)this.jdField_b_of_type_JavaUtilList.get(i - 1);
          return localatpv1;
        }
      }
    }
    synchronized (this.c)
    {
      i = this.c.size();
      if (i > 0)
      {
        atpg.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from DiscussionRequests");
        atpv localatpv2 = (atpv)this.c.get(i - 1);
        return localatpv2;
      }
    }
    synchronized (this.d)
    {
      i = this.d.size();
      if (i > 0)
      {
        atpg.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from GroupRequests");
        atpv localatpv3 = (atpv)this.d.get(i - 1);
        return localatpv3;
      }
    }
    atpg.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "cannot get any request");
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    atpg.a("PIC_TAG_PRELOAD", "picPreDownloadOn", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    f();
  }
  
  public void b(MessageForPic paramMessageForPic, int paramInt)
  {
    a(paramMessageForPic);
    if ((atox.d != 2L) && (atox.d != 0L))
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
    String str = "productFromAIODynamicPic";
    if (paramMessageForPic != null) {
      str = "productFromAIODynamicPic" + ", msgSeq = " + paramMessageForPic.shmsgseq;
    }
    a(new PicPreDownloader.PicPreDownRunner(this, new PicPreDownloader.3(this, paramMessageForPic, paramInt), str));
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
      if ((atox.d != 1L) && (atox.d != 0L))
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
      ((MessageForPic)localObject).getReportInfo().b = atps.a();
      ((MessageForPic)localObject).getReportInfo().jdField_a_of_type_Long = System.currentTimeMillis();
      ((MessageForPic)localObject).getReportInfo().jdField_a_of_type_Int = 0;
    }
    a(paramMessageRecord, paramInt, 1);
    axpm.a(paramMessageRecord);
  }
  
  void b(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      atpg.a("PIC_TAG_PRELOAD", "add", "START uniseq:" + ((MessageForPic)paramMessageRecord).uniseq + ",suMsgId:" + ((MessageForPic)paramMessageRecord).subMsgId + ",priority:" + paramInt2);
    }
    int i;
    int j;
    int k;
    if ((paramMessageRecord.isMultiMsg) && (!paramMessageRecord.isSend()))
    {
      localObject = arxu.a().a();
      if (localObject != null)
      {
        i = ((SessionInfo)localObject).jdField_a_of_type_Int;
        localObject = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
        i = atps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject);
        j = atps.a();
        k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject);
        if ((j == 0) || (k != 2)) {
          break label243;
        }
        if ((paramMessageRecord instanceof MessageForPic)) {
          atpg.a("PIC_TAG_PRELOAD", "add", "num group skip, uniseq:" + paramMessageRecord.uniseq + ",suMsgId:" + ((MessageForPic)paramMessageRecord).subMsgId + "priority:" + paramInt2);
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
        localObject = this.jdField_a_of_type_Atqg.a(i, j);
        if ((localObject[0] != 0) && ((paramInt1 & 0x1) == 1)) {}
        int m;
        for (boolean bool = true;; bool = false)
        {
          m = localObject[1];
          atpg.a("PIC_TAG_PRELOAD", "add", "preDownThumb=" + bool + " preDownBig=" + m);
          if (!(paramMessageRecord instanceof MessageForPic)) {
            break label693;
          }
          localObject = (MessageForPic)paramMessageRecord;
          if ((((MessageForPic)localObject).path != null) || (((MessageForPic)localObject).uuid != null) || (((MessageForPic)localObject).md5 != null)) {
            break;
          }
          atpg.a("PIC_TAG_PRELOAD", "add", "pic.path == null && pic.uuid == null && pic.md5 == null");
          a(paramMessageRecord, -3);
          return;
        }
        if (a((MessageForPic)localObject, paramInt2))
        {
          atpg.a("PIC_TAG_PRELOAD", "filter", "skip uniseq:" + ((MessageForPic)localObject).uniseq + ",suMsgId:" + ((MessageForPic)localObject).subMsgId + "priority:" + paramInt2);
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
          atpg.a("PIC_TAG_PRELOAD", "add", "The troop is not MSG_FILTER_VALUE.MSG_FILTER_OPEN");
          a(paramMessageRecord, -7);
        }
        for (;;)
        {
          atpg.a("PIC_TAG_PRELOAD", "add", "FINISH uniseq:" + ((MessageForPic)localObject).uniseq + ",suMsgId:" + ((MessageForPic)localObject).subMsgId + ",priority:" + paramInt2);
          return;
          if (this.jdField_a_of_type_Atqg.a((MessageForPic)localObject))
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
                atpg.a("PIC_TAG_PRELOAD", "addBigPicRequest", "not hasThumbFile,download thumb,uniseq: " + ((MessageForPic)localObject).uniseq + ", priority: " + paramInt2);
                a((MessageForPic)localObject);
                break;
                atpg.a("PIC_TAG_PRELOAD", "add", "handlingNum.get() >= MAX_HANDLING_THREADS");
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
        atpg.a("PIC_TAG_PRELOAD", "structMsg-screenOFF", "no preDownload,networkType:" + j);
        return;
      }
      catch (Exception paramMessageRecord)
      {
        for (;;)
        {
          atpg.a("PIC_TAG_PRELOAD", "structMsg-screenOFF", "no preDownload exception happened,networkType:" + j);
        }
      }
    }
    Object localObject = "addToQuene-MessageForStructing" + ", msgSeq = " + paramMessageRecord.shmsgseq;
    a(new PicPreDownloader.PicPreDownRunner(this, new PicPreDownloader.6(this, paramMessageRecord), (String)localObject));
    atpg.a("PIC_TAG_PRELOAD", "structMsg-add ", "finish preDownload uniseq =" + paramMessageRecord.uniseq);
  }
  
  boolean b(MessageForPic paramMessageForPic, int paramInt)
  {
    if (paramMessageForPic.hasBigFile())
    {
      atpg.a("PIC_TAG_PRELOAD", "addBigPicRequest", "hasBigFile, uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the big picture already exists");
      }
      atps.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic);
    }
    do
    {
      return false;
      if (((!ajke.a(paramMessageForPic)) && (!ajhz.a(paramMessageForPic))) || (axoa.b(axwd.a(paramMessageForPic, 1, null).toString()) == null)) {
        break;
      }
      atpg.a("PIC_TAG_PRELOAD", "addBigPicRequest", "hasFlashPicFile, uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the picture already exists");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "real download a big picture");
    }
    atpg.a("PIC_TAG_PRELOAD", "addBigPicRequest", " START uniseq: " + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority:" + paramInt);
    int i;
    atpv localatpv;
    Object localObject;
    List localList;
    if (atps.a() == 0)
    {
      i = 1536;
      localatpv = atpl.a(6, i, 2);
      localObject = paramMessageForPic.getPicDownloadInfo();
      if (localObject != null)
      {
        ((atpn)localObject).h = 1;
        ((atpn)localObject).jdField_e_of_type_JavaLangString = "chatimg";
      }
      localatpv.a(paramMessageForPic, (atpn)localObject);
      localList = null;
      localObject = "";
      i = atps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin);
      if (paramInt != 5) {
        break label517;
      }
      localList = this.jdField_a_of_type_JavaUtilList;
      localatpv.jdField_e_of_type_Int = 5;
      localObject = "AIORequests";
      switch (i)
      {
      default: 
        localatpv.f = 2;
      }
    }
    for (;;)
    {
      if (localList != null)
      {
        atpg.a("PIC_TAG_PRELOAD", "addBigPicRequest", "successfully to add the pic request to " + (String)localObject);
        localList.add(localatpv);
        d();
        this.jdField_a_of_type_JavaUtilMap.put(localatpv.jdField_a_of_type_Atpn.jdField_g_of_type_JavaLangString, Integer.valueOf(localatpv.jdField_e_of_type_Int));
      }
      atpg.a("PIC_TAG_PRELOAD", "addBigPicRequest", "END uniseq: " + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority: " + paramInt);
      return true;
      i = 1537;
      break;
      localatpv.f = 4;
      continue;
      localatpv.f = 3;
      continue;
      label517:
      if (paramInt == 1) {
        switch (i)
        {
        default: 
          localList = this.d;
          localatpv.jdField_e_of_type_Int = 2;
          localatpv.f = localatpv.jdField_e_of_type_Int;
          localObject = "GroupRequests";
          break;
        case 3: 
          localList = this.jdField_b_of_type_JavaUtilList;
          localatpv.jdField_e_of_type_Int = 4;
          localatpv.f = localatpv.jdField_e_of_type_Int;
          localObject = "C2CRequests";
          break;
        case 2: 
          localList = this.c;
          localatpv.jdField_e_of_type_Int = 3;
          localatpv.f = localatpv.jdField_e_of_type_Int;
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
      ThreadManager.post(new PicPreDownloader.5(this, i), 5, null, false);
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
      atpg.a("PIC_TAG_PRELOAD", "add", "MessageRecord isSendFromLocal");
      return;
    }
    b(paramMessageRecord, paramInt1, paramInt2);
  }
  
  void d()
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() + this.c.size() + this.d.size() > this.jdField_a_of_type_Atqg.jdField_a_of_type_Int) {
      localObject1 = null;
    }
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.d.size() > 0)
        {
          localObject1 = (atpv)this.d.remove(0);
          if (localObject1 != null)
          {
            this.jdField_a_of_type_JavaUtilMap.remove(((atpv)localObject1).jdField_a_of_type_Atpn.jdField_g_of_type_JavaLangString);
            localObject1 = this.jdField_a_of_type_Atqg;
            ((atqg)localObject1).O += 1L;
            atpg.a("PIC_TAG_PRELOAD", "checkRequestListSize", "over max request list size: " + this.jdField_a_of_type_Atqg.jdField_a_of_type_Int + ", remove a request");
          }
          return;
        }
        synchronized (this.c)
        {
          if (this.c.size() > 0) {
            localObject1 = (atpv)this.c.remove(0);
          }
        }
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
          atpv localatpv1 = (atpv)this.jdField_b_of_type_JavaUtilList.remove(0);
        }
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          atpv localatpv2 = (atpv)this.jdField_a_of_type_JavaUtilList.remove(0);
        }
      }
    }
  }
  
  void e()
  {
    atpg.a("PIC_TAG_PRELOAD", "consumeThumb", "START");
    int i = atps.a();
    if ((!jdField_a_of_type_Boolean) && (i != 0))
    {
      atpg.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
      return;
    }
    Object localObject3 = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    atpv localatpv;
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localatpv = (atpv)((Iterator)localObject3).next();
      localObject2 = "consumeAllThumbsInPendingQueue-thumbPendingQueue";
      localObject1 = localObject2;
      if (localatpv != null)
      {
        localObject1 = localObject2;
        if (localatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
          localObject1 = "consumeAllThumbsInPendingQueue-thumbPendingQueue" + ", msgSeq = " + localatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.shmsgseq;
        }
      }
      a(new PicPreDownloader.PicPreDownRunner(this, new PicPreDownloader.8(this, localatpv), (String)localObject1));
      if (localatpv.jdField_a_of_type_Atpn == null) {
        break label356;
      }
    }
    label356:
    for (Object localObject1 = "uniseq:" + localatpv.jdField_a_of_type_Atpn.jdField_a_of_type_Long;; localObject1 = "")
    {
      atpg.a("PIC_TAG_PRELOAD", "run picreq thumb", (String)localObject1);
      break;
      this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
      localObject1 = this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageForStructing)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject3 = "consumeAllThumbsInPendingQueue-structMsgPengdingQueue" + ", msgSeq = " + ((MessageForStructing)localObject2).shmsgseq;
          a(new PicPreDownloader.PicPreDownRunner(this, new PicPreDownloader.9(this, (MessageForStructing)localObject2), (String)localObject3));
          atpg.a("PIC_TAG_PRELOAD", "structMsg-add ", "finish MessageForStructing preDownload uniseq =" + ((MessageForStructing)localObject2).uniseq);
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.clear();
      atpg.a("PIC_TAG_PRELOAD", "consumeThumb", "END");
      return;
    }
  }
  
  public void f()
  {
    atpg.a("PIC_TAG_PRELOAD", "consume", "START");
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      atpg.a("PIC_TAG_PRELOAD", "consume", "!mIsPicPreloadSuitable.get() failed");
    }
    int k;
    atpv localatpv;
    int i;
    int j;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 1)
        {
          atpg.a("PIC_TAG_PRELOAD", "consume", "handlingNum.get() >= MAX_HANDLING_THREADS");
          return;
        }
        localObject = b();
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((atpv)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
          {
            bool1 = bool2;
            if (((atpv)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbWidthHeightDP != null)
            {
              bool1 = ((atpv)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbWidthHeightDP.useCustomSize();
              atpg.a("PIC_TAG_PRELOAD", "consume", "isBigImage=" + bool1);
            }
          }
        }
        k = atps.a();
        if ((!jdField_a_of_type_Boolean) && (k != 0) && (!bool1))
        {
          atpg.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + k + ",isBigImage=" + bool1);
          return;
        }
        localatpv = a();
        if (localatpv == null) {
          break label911;
        }
        if (localatpv.jdField_a_of_type_Atpn == null)
        {
          atpg.b("PIC_TAG_PRELOAD", "consume", "picReq.downinfo == null");
          a(localatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -4);
          return;
        }
        this.jdField_a_of_type_JavaUtilMap.remove(localatpv.jdField_a_of_type_Atpn.jdField_g_of_type_JavaLangString);
        i = atps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localatpv.jdField_a_of_type_Atpn.b, localatpv.jdField_a_of_type_Atpn.c);
        j = this.jdField_a_of_type_Atqg.a(localatpv.jdField_a_of_type_Atpn.d, i, k, bfcq.a(localatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType));
        a(localatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, j);
        if (j >= 0) {
          break;
        }
        atpg.a("PIC_TAG_PRELOAD", "consume", "overLimit and put request back to list, uinType=" + i + " networkType=" + k);
        localObject = a(localatpv.jdField_e_of_type_Int);
      } while (localObject == null);
      ((Collection)localObject).add(localatpv);
      this.jdField_a_of_type_JavaUtilMap.put(localatpv.jdField_a_of_type_Atpn.jdField_g_of_type_JavaLangString, Integer.valueOf(localatpv.jdField_e_of_type_Int));
      d();
      return;
      if ((localatpv.jdField_a_of_type_Int != 6) || (this.jdField_a_of_type_Atqg.a(i, k)[1] != 0)) {
        break;
      }
      atpg.a("PIC_TAG_PRELOAD", "consume", "Network changed, put the picReq back to list, uintype:" + localatpv.jdField_a_of_type_Atpn.b + ", networkType:" + k + ", uniseq:" + localatpv.jdField_a_of_type_Atpn.jdField_a_of_type_Long);
      localObject = a(localatpv.jdField_e_of_type_Int);
    } while (localObject == null);
    ((Collection)localObject).add(localatpv);
    this.jdField_a_of_type_JavaUtilMap.put(localatpv.jdField_a_of_type_Atpn.jdField_g_of_type_JavaLangString, Integer.valueOf(localatpv.jdField_e_of_type_Int));
    d();
    return;
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localatpv);
    localatpv.f = localatpv.jdField_e_of_type_Int;
    localatpv.jdField_e_of_type_Int = 6;
    this.jdField_a_of_type_JavaUtilMap.put(localatpv.jdField_a_of_type_Atpn.jdField_g_of_type_JavaLangString, Integer.valueOf(6));
    if (localatpv.jdField_a_of_type_Int == 6) {}
    for (Object localObject = " big";; localObject = " thumb")
    {
      atpg.a("PIC_TAG_PRELOAD", "run picreq" + (String)localObject, "uniseq:" + localatpv.jdField_a_of_type_Atpn.jdField_a_of_type_Long + "subMsgId:" + localatpv.jdField_a_of_type_Atpn.jdField_g_of_type_Int + ",priority:" + localatpv.jdField_e_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      if ((localatpv.jdField_a_of_type_Int == 6) && (!new File(localatpv.jdField_a_of_type_Atpn.c()).exists()))
      {
        this.jdField_a_of_type_Atqg.a(localatpv.jdField_a_of_type_Atpn.d, k);
        j = -2147483648;
        i = j;
        if (localatpv != null)
        {
          i = j;
          if (localatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
            i = atps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, localatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin);
          }
        }
        this.jdField_a_of_type_Atqb.b(k, i);
      }
      String str = "consume";
      localObject = str;
      if (localatpv != null)
      {
        localObject = str;
        if (localatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
          localObject = "consume" + ", msgSeq = " + localatpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.shmsgseq;
        }
      }
      a(new PicPreDownloader.PicPreDownRunner(this, new PicPreDownloader.10(this, localatpv), (String)localObject));
      label911:
      atpg.a("PIC_TAG_PRELOAD", "consume", "END");
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
      if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
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
    DeviceProfileManager.b(this.jdField_a_of_type_Atqg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader
 * JD-Core Version:    0.7.0.1
 */