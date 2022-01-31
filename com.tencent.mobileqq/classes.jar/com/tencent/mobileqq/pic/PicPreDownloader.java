package com.tencent.mobileqq.pic;

import ajwb;
import ajyi;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import asua;
import aumx;
import aung;
import aunl;
import aunn;
import auns;
import aunt;
import aunv;
import auob;
import auog;
import auom;
import ayoi;
import aypv;
import ayvx;
import aywm;
import bbbu;
import bbfj;
import bgky;
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
  auob jdField_a_of_type_Auob;
  public auog a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Runnable jdField_a_of_type_JavaLangRunnable = new PicPreDownloader.1(this);
  List<aunv> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  public Map<String, Integer> a;
  ConcurrentLinkedQueue<PicPreDownloader.PicPreDownRunner> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  LinkedBlockingQueue<MessageForStructing> jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue = new LinkedBlockingQueue(100);
  PriorityBlockingQueue<aunv> jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public AtomicInteger a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  List<aunv> b;
  public PriorityBlockingQueue<aunv> b;
  List<aunv> c = Collections.synchronizedList(new LinkedList());
  List<aunv> d = Collections.synchronizedList(new LinkedList());
  
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
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aunt(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_Auog = new auog();
    DeviceProfileManager.a(this.jdField_a_of_type_Auog);
    ThreadManager.post(new PicPreDownloader.2(this, paramQQAppInterface), 5, null, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Auob = ((auob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73));
    aung.a("PIC_TAG_PRELOAD", "onInit", "Finished");
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
          aunv localaunv = (aunv)localIterator.next();
          if (paramMessageForPic.subMsgId == localaunv.jdField_a_of_type_Aunn.jdField_g_of_type_Int)
          {
            aung.a("PIC_TAG_PRELOAD", "getPriority", "uuid: " + paramMessageForPic.uuid + " subMsgId: " + paramMessageForPic.subMsgId);
            int i = localInteger.intValue();
            return i;
          }
        }
      }
      finally {}
    }
    return -1;
  }
  
  aunv a()
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      aunv localaunv1;
      if (i > 0)
      {
        aung.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from AIORequests");
        localaunv1 = (aunv)this.jdField_a_of_type_JavaUtilList.get(i - 1);
        this.jdField_a_of_type_JavaUtilList.remove(i - 1);
        return localaunv1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          aung.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from C2CRequests");
          localaunv1 = (aunv)this.jdField_b_of_type_JavaUtilList.get(i - 1);
          this.jdField_b_of_type_JavaUtilList.remove(i - 1);
          return localaunv1;
        }
      }
    }
    synchronized (this.c)
    {
      i = this.c.size();
      if (i > 0)
      {
        aung.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from DiscussionRequests");
        aunv localaunv2 = (aunv)this.c.get(i - 1);
        this.c.remove(i - 1);
        return localaunv2;
      }
    }
    synchronized (this.d)
    {
      i = this.d.size();
      if (i > 0)
      {
        aung.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from GroupRequests");
        aunv localaunv3 = (aunv)this.d.get(i - 1);
        this.d.remove(i - 1);
        return localaunv3;
      }
    }
    aung.a("PIC_TAG_PRELOAD", "getPicRequest", "cannot get any request");
    return null;
  }
  
  aunv a(String paramString, Collection<aunv> paramCollection)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramCollection.iterator();
        if (localIterator.hasNext())
        {
          aunv localaunv = (aunv)localIterator.next();
          if (localaunv.jdField_a_of_type_Aunn == null) {
            continue;
          }
          if (localaunv.jdField_a_of_type_Aunn.jdField_e_of_type_Int == 1)
          {
            bool = true;
            int i = aywm.a(localaunv.jdField_a_of_type_Aunn.jdField_e_of_type_JavaLangString, bool);
            String str = ayvx.a(localaunv.jdField_a_of_type_Aunn.f, localaunv.jdField_a_of_type_Aunn.jdField_g_of_type_JavaLangString, i);
            if ((paramString == null) || (!paramString.equals(str))) {
              continue;
            }
            paramCollection.remove(localaunv);
            this.jdField_a_of_type_JavaUtilMap.remove(localaunv.jdField_a_of_type_Aunn.jdField_g_of_type_JavaLangString);
            a(localaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -5);
            return localaunv;
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
  
  Collection<aunv> a(int paramInt)
  {
    aung.a("PIC_TAG_PRELOAD", "getRequestsByPriority", "priority=" + paramInt);
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
    aung.a("PIC_TAG_PRELOAD", "picPreDownloadOff", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
    }
  }
  
  void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.hasThumbFile()) {}
    aunv localaunv;
    for (;;)
    {
      return;
      if ((bbbu.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {}
      for (int i = 1; i == 0; i = 0)
      {
        this.jdField_a_of_type_Auob.a(paramMessageForPic);
        localaunv = aunl.a(5, 1536, 2);
        localObject = paramMessageForPic.getPicDownloadInfo();
        if (localObject != null) {
          ((aunn)localObject).h = 1;
        }
        localaunv.a(paramMessageForPic, (aunn)localObject);
        i = auns.a();
        if ((jdField_a_of_type_Boolean) || (i == 0)) {
          break label152;
        }
        aung.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
        this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localaunv);
        return;
      }
    }
    label152:
    String str = "consumeThumb";
    Object localObject = str;
    if (localaunv != null)
    {
      localObject = str;
      if (localaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
        localObject = "consumeThumb" + ", msgSeq = " + localaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.shmsgseq;
      }
    }
    a(new PicPreDownloader.PicPreDownRunner(this, new PicPreDownloader.7(this, localaunv), (String)localObject));
    aung.a("PIC_TAG_PRELOAD", "run picreq thumb", "uniseq:" + paramMessageForPic.uniseq + ",subMsgId:" + paramMessageForPic.subMsgId);
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    a(paramMessageForPic);
    if ((aumx.d != 2L) && (aumx.d != 0L))
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
    if ((this.jdField_a_of_type_Auog instanceof auog)) {
      this.jdField_a_of_type_Auog.a(paramMessageForPic, paramLong);
    }
  }
  
  void a(MessageRecord paramMessageRecord)
  {
    int i = auns.a();
    aung.a("PIC_TAG_PRELOAD", "setMessageRecordNetworkType", "network=" + i);
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
    aung.a("PIC_TAG_PRELOAD", "setNotPredownloadReason", "Reson=" + paramInt);
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
    } while ((!(paramMessageRecord instanceof MessageForStructing)) || (!auom.jdField_a_of_type_Boolean));
    c(paramMessageRecord, paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    aunv localaunv = a(paramString, this.jdField_a_of_type_JavaUtilList);
    if (localaunv != null)
    {
      aung.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localaunv.jdField_a_of_type_Aunn.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localaunv.jdField_a_of_type_Int);
      return;
    }
    localaunv = a(paramString, this.jdField_b_of_type_JavaUtilList);
    if (localaunv != null)
    {
      aung.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localaunv.jdField_a_of_type_Aunn.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localaunv.jdField_a_of_type_Int);
      return;
    }
    localaunv = a(paramString, this.c);
    if (localaunv != null)
    {
      aung.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localaunv.jdField_a_of_type_Aunn.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localaunv.jdField_a_of_type_Int);
      return;
    }
    localaunv = a(paramString, this.d);
    if (localaunv != null)
    {
      aung.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localaunv.jdField_a_of_type_Aunn.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localaunv.jdField_a_of_type_Int);
      return;
    }
    aung.a("PIC_TAG_PRELOAD", "", "drop", "Cannot be found in the request stacks");
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131695322), "qqsetting_auto_receive_pic_key", true);
    if ((bbfj.b(BaseApplication.getContext()) == 1) || (bool2)) {}
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
      aung.a("PIC_TAG_PRELOAD", "filter", "uuid=" + paramMessageForPic.uuid + ", priority=" + paramInt + ", cannot be found in the PriorityMap");
      return bool2;
    }
    Collection localCollection = a(localInteger.intValue());
    aung.a("PIC_TAG_PRELOAD", "filter", "priority: " + paramInt + ", uniseq: " + paramMessageForPic.uniseq + ", subMsgId:" + paramMessageForPic.subMsgId);
    if (localCollection == null)
    {
      aung.a("PIC_TAG_PRELOAD", "filter", "originalRequests == null");
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
          localObject2 = (aunv)localIterator.next();
          if (paramMessageForPic.subMsgId != ((aunv)localObject2).jdField_a_of_type_Aunn.jdField_g_of_type_Int) {
            break label339;
          }
          bool1 = true;
          localObject1 = localObject2;
          break label339;
        }
        if ((!bool1) || (paramInt <= localInteger.intValue()))
        {
          aung.a("PIC_TAG_PRELOAD", "filter", "No need to update the picReq");
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
      aung.a("PIC_TAG_PRELOAD", "filter", "update the picReq");
      return bool1;
    }
  }
  
  aunv b()
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      aunv localaunv1;
      if (i > 0)
      {
        aung.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from AIORequests");
        localaunv1 = (aunv)this.jdField_a_of_type_JavaUtilList.get(i - 1);
        return localaunv1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          aung.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from C2CRequests");
          localaunv1 = (aunv)this.jdField_b_of_type_JavaUtilList.get(i - 1);
          return localaunv1;
        }
      }
    }
    synchronized (this.c)
    {
      i = this.c.size();
      if (i > 0)
      {
        aung.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from DiscussionRequests");
        aunv localaunv2 = (aunv)this.c.get(i - 1);
        return localaunv2;
      }
    }
    synchronized (this.d)
    {
      i = this.d.size();
      if (i > 0)
      {
        aung.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from GroupRequests");
        aunv localaunv3 = (aunv)this.d.get(i - 1);
        return localaunv3;
      }
    }
    aung.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "cannot get any request");
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    aung.a("PIC_TAG_PRELOAD", "picPreDownloadOn", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    f();
  }
  
  public void b(MessageForPic paramMessageForPic, int paramInt)
  {
    a(paramMessageForPic);
    if ((aumx.d != 2L) && (aumx.d != 0L))
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
      if ((aumx.d != 1L) && (aumx.d != 0L))
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
      ((MessageForPic)localObject).getReportInfo().b = auns.a();
      ((MessageForPic)localObject).getReportInfo().jdField_a_of_type_Long = System.currentTimeMillis();
      ((MessageForPic)localObject).getReportInfo().jdField_a_of_type_Int = 0;
    }
    a(paramMessageRecord, paramInt, 1);
    aypv.a(paramMessageRecord);
  }
  
  void b(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      aung.a("PIC_TAG_PRELOAD", "add", "START uniseq:" + ((MessageForPic)paramMessageRecord).uniseq + ",suMsgId:" + ((MessageForPic)paramMessageRecord).subMsgId + ",priority:" + paramInt2);
    }
    int i;
    int j;
    int k;
    if ((paramMessageRecord.isMultiMsg) && (!paramMessageRecord.isSend()))
    {
      localObject = asua.a().a();
      if (localObject != null)
      {
        i = ((SessionInfo)localObject).jdField_a_of_type_Int;
        localObject = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
        i = auns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject);
        j = auns.a();
        k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject);
        if ((j == 0) || (k != 2)) {
          break label243;
        }
        if ((paramMessageRecord instanceof MessageForPic)) {
          aung.a("PIC_TAG_PRELOAD", "add", "num group skip, uniseq:" + paramMessageRecord.uniseq + ",suMsgId:" + ((MessageForPic)paramMessageRecord).subMsgId + "priority:" + paramInt2);
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
        localObject = this.jdField_a_of_type_Auog.a(i, j);
        if ((localObject[0] != 0) && ((paramInt1 & 0x1) == 1)) {}
        int m;
        for (boolean bool = true;; bool = false)
        {
          m = localObject[1];
          aung.a("PIC_TAG_PRELOAD", "add", "preDownThumb=" + bool + " preDownBig=" + m);
          if (!(paramMessageRecord instanceof MessageForPic)) {
            break label693;
          }
          localObject = (MessageForPic)paramMessageRecord;
          if ((((MessageForPic)localObject).path != null) || (((MessageForPic)localObject).uuid != null) || (((MessageForPic)localObject).md5 != null)) {
            break;
          }
          aung.a("PIC_TAG_PRELOAD", "add", "pic.path == null && pic.uuid == null && pic.md5 == null");
          a(paramMessageRecord, -3);
          return;
        }
        if (a((MessageForPic)localObject, paramInt2))
        {
          aung.a("PIC_TAG_PRELOAD", "filter", "skip uniseq:" + ((MessageForPic)localObject).uniseq + ",suMsgId:" + ((MessageForPic)localObject).subMsgId + "priority:" + paramInt2);
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
          aung.a("PIC_TAG_PRELOAD", "add", "The troop is not MSG_FILTER_VALUE.MSG_FILTER_OPEN");
          a(paramMessageRecord, -7);
        }
        for (;;)
        {
          aung.a("PIC_TAG_PRELOAD", "add", "FINISH uniseq:" + ((MessageForPic)localObject).uniseq + ",suMsgId:" + ((MessageForPic)localObject).subMsgId + ",priority:" + paramInt2);
          return;
          if (this.jdField_a_of_type_Auog.a((MessageForPic)localObject))
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
                aung.a("PIC_TAG_PRELOAD", "addBigPicRequest", "not hasThumbFile,download thumb,uniseq: " + ((MessageForPic)localObject).uniseq + ", priority: " + paramInt2);
                a((MessageForPic)localObject);
                break;
                aung.a("PIC_TAG_PRELOAD", "add", "handlingNum.get() >= MAX_HANDLING_THREADS");
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
        aung.a("PIC_TAG_PRELOAD", "structMsg-screenOFF", "no preDownload,networkType:" + j);
        return;
      }
      catch (Exception paramMessageRecord)
      {
        for (;;)
        {
          aung.a("PIC_TAG_PRELOAD", "structMsg-screenOFF", "no preDownload exception happened,networkType:" + j);
        }
      }
    }
    Object localObject = "addToQuene-MessageForStructing" + ", msgSeq = " + paramMessageRecord.shmsgseq;
    a(new PicPreDownloader.PicPreDownRunner(this, new PicPreDownloader.6(this, paramMessageRecord), (String)localObject));
    aung.a("PIC_TAG_PRELOAD", "structMsg-add ", "finish preDownload uniseq =" + paramMessageRecord.uniseq);
  }
  
  boolean b(MessageForPic paramMessageForPic, int paramInt)
  {
    if (paramMessageForPic.hasBigFile())
    {
      aung.a("PIC_TAG_PRELOAD", "addBigPicRequest", "hasBigFile, uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the big picture already exists");
      }
      auns.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic);
    }
    do
    {
      return false;
      if (((!ajyi.a(paramMessageForPic)) && (!ajwb.a(paramMessageForPic))) || (ayoi.b(aywm.a(paramMessageForPic, 1, null).toString()) == null)) {
        break;
      }
      aung.a("PIC_TAG_PRELOAD", "addBigPicRequest", "hasFlashPicFile, uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the picture already exists");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "real download a big picture");
    }
    aung.a("PIC_TAG_PRELOAD", "addBigPicRequest", " START uniseq: " + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority:" + paramInt);
    int i;
    aunv localaunv;
    Object localObject;
    List localList;
    if (auns.a() == 0)
    {
      i = 1536;
      localaunv = aunl.a(6, i, 2);
      localObject = paramMessageForPic.getPicDownloadInfo();
      if (localObject != null)
      {
        ((aunn)localObject).h = 1;
        ((aunn)localObject).jdField_e_of_type_JavaLangString = "chatimg";
      }
      localaunv.a(paramMessageForPic, (aunn)localObject);
      localList = null;
      localObject = "";
      i = auns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin);
      if (paramInt != 5) {
        break label517;
      }
      localList = this.jdField_a_of_type_JavaUtilList;
      localaunv.jdField_e_of_type_Int = 5;
      localObject = "AIORequests";
      switch (i)
      {
      default: 
        localaunv.f = 2;
      }
    }
    for (;;)
    {
      if (localList != null)
      {
        aung.a("PIC_TAG_PRELOAD", "addBigPicRequest", "successfully to add the pic request to " + (String)localObject);
        localList.add(localaunv);
        d();
        this.jdField_a_of_type_JavaUtilMap.put(localaunv.jdField_a_of_type_Aunn.jdField_g_of_type_JavaLangString, Integer.valueOf(localaunv.jdField_e_of_type_Int));
      }
      aung.a("PIC_TAG_PRELOAD", "addBigPicRequest", "END uniseq: " + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority: " + paramInt);
      return true;
      i = 1537;
      break;
      localaunv.f = 4;
      continue;
      localaunv.f = 3;
      continue;
      label517:
      if (paramInt == 1) {
        switch (i)
        {
        default: 
          localList = this.d;
          localaunv.jdField_e_of_type_Int = 2;
          localaunv.f = localaunv.jdField_e_of_type_Int;
          localObject = "GroupRequests";
          break;
        case 3: 
          localList = this.jdField_b_of_type_JavaUtilList;
          localaunv.jdField_e_of_type_Int = 4;
          localaunv.f = localaunv.jdField_e_of_type_Int;
          localObject = "C2CRequests";
          break;
        case 2: 
          localList = this.c;
          localaunv.jdField_e_of_type_Int = 3;
          localaunv.f = localaunv.jdField_e_of_type_Int;
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
      aung.a("PIC_TAG_PRELOAD", "add", "MessageRecord isSendFromLocal");
      return;
    }
    b(paramMessageRecord, paramInt1, paramInt2);
  }
  
  void d()
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() + this.c.size() + this.d.size() > this.jdField_a_of_type_Auog.jdField_a_of_type_Int) {
      localObject1 = null;
    }
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.d.size() > 0)
        {
          localObject1 = (aunv)this.d.remove(0);
          if (localObject1 != null)
          {
            this.jdField_a_of_type_JavaUtilMap.remove(((aunv)localObject1).jdField_a_of_type_Aunn.jdField_g_of_type_JavaLangString);
            localObject1 = this.jdField_a_of_type_Auog;
            ((auog)localObject1).O += 1L;
            aung.a("PIC_TAG_PRELOAD", "checkRequestListSize", "over max request list size: " + this.jdField_a_of_type_Auog.jdField_a_of_type_Int + ", remove a request");
          }
          return;
        }
        synchronized (this.c)
        {
          if (this.c.size() > 0) {
            localObject1 = (aunv)this.c.remove(0);
          }
        }
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
          aunv localaunv1 = (aunv)this.jdField_b_of_type_JavaUtilList.remove(0);
        }
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          aunv localaunv2 = (aunv)this.jdField_a_of_type_JavaUtilList.remove(0);
        }
      }
    }
  }
  
  void e()
  {
    aung.a("PIC_TAG_PRELOAD", "consumeThumb", "START");
    int i = auns.a();
    if ((!jdField_a_of_type_Boolean) && (i != 0))
    {
      aung.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
      return;
    }
    Object localObject3 = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    aunv localaunv;
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localaunv = (aunv)((Iterator)localObject3).next();
      localObject2 = "consumeAllThumbsInPendingQueue-thumbPendingQueue";
      localObject1 = localObject2;
      if (localaunv != null)
      {
        localObject1 = localObject2;
        if (localaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
          localObject1 = "consumeAllThumbsInPendingQueue-thumbPendingQueue" + ", msgSeq = " + localaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.shmsgseq;
        }
      }
      a(new PicPreDownloader.PicPreDownRunner(this, new PicPreDownloader.8(this, localaunv), (String)localObject1));
      if (localaunv.jdField_a_of_type_Aunn == null) {
        break label356;
      }
    }
    label356:
    for (Object localObject1 = "uniseq:" + localaunv.jdField_a_of_type_Aunn.jdField_a_of_type_Long;; localObject1 = "")
    {
      aung.a("PIC_TAG_PRELOAD", "run picreq thumb", (String)localObject1);
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
          aung.a("PIC_TAG_PRELOAD", "structMsg-add ", "finish MessageForStructing preDownload uniseq =" + ((MessageForStructing)localObject2).uniseq);
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.clear();
      aung.a("PIC_TAG_PRELOAD", "consumeThumb", "END");
      return;
    }
  }
  
  public void f()
  {
    aung.a("PIC_TAG_PRELOAD", "consume", "START");
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      aung.a("PIC_TAG_PRELOAD", "consume", "!mIsPicPreloadSuitable.get() failed");
    }
    int k;
    aunv localaunv;
    int i;
    int j;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 1)
        {
          aung.a("PIC_TAG_PRELOAD", "consume", "handlingNum.get() >= MAX_HANDLING_THREADS");
          return;
        }
        localObject = b();
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((aunv)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
          {
            bool1 = bool2;
            if (((aunv)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbWidthHeightDP != null)
            {
              bool1 = ((aunv)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbWidthHeightDP.useCustomSize();
              aung.a("PIC_TAG_PRELOAD", "consume", "isBigImage=" + bool1);
            }
          }
        }
        k = auns.a();
        if ((!jdField_a_of_type_Boolean) && (k != 0) && (!bool1))
        {
          aung.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + k + ",isBigImage=" + bool1);
          return;
        }
        localaunv = a();
        if (localaunv == null) {
          break label911;
        }
        if (localaunv.jdField_a_of_type_Aunn == null)
        {
          aung.b("PIC_TAG_PRELOAD", "consume", "picReq.downinfo == null");
          a(localaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -4);
          return;
        }
        this.jdField_a_of_type_JavaUtilMap.remove(localaunv.jdField_a_of_type_Aunn.jdField_g_of_type_JavaLangString);
        i = auns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaunv.jdField_a_of_type_Aunn.b, localaunv.jdField_a_of_type_Aunn.c);
        j = this.jdField_a_of_type_Auog.a(localaunv.jdField_a_of_type_Aunn.d, i, k, bgky.a(localaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType));
        a(localaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, j);
        if (j >= 0) {
          break;
        }
        aung.a("PIC_TAG_PRELOAD", "consume", "overLimit and put request back to list, uinType=" + i + " networkType=" + k);
        localObject = a(localaunv.jdField_e_of_type_Int);
      } while (localObject == null);
      ((Collection)localObject).add(localaunv);
      this.jdField_a_of_type_JavaUtilMap.put(localaunv.jdField_a_of_type_Aunn.jdField_g_of_type_JavaLangString, Integer.valueOf(localaunv.jdField_e_of_type_Int));
      d();
      return;
      if ((localaunv.jdField_a_of_type_Int != 6) || (this.jdField_a_of_type_Auog.a(i, k)[1] != 0)) {
        break;
      }
      aung.a("PIC_TAG_PRELOAD", "consume", "Network changed, put the picReq back to list, uintype:" + localaunv.jdField_a_of_type_Aunn.b + ", networkType:" + k + ", uniseq:" + localaunv.jdField_a_of_type_Aunn.jdField_a_of_type_Long);
      localObject = a(localaunv.jdField_e_of_type_Int);
    } while (localObject == null);
    ((Collection)localObject).add(localaunv);
    this.jdField_a_of_type_JavaUtilMap.put(localaunv.jdField_a_of_type_Aunn.jdField_g_of_type_JavaLangString, Integer.valueOf(localaunv.jdField_e_of_type_Int));
    d();
    return;
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localaunv);
    localaunv.f = localaunv.jdField_e_of_type_Int;
    localaunv.jdField_e_of_type_Int = 6;
    this.jdField_a_of_type_JavaUtilMap.put(localaunv.jdField_a_of_type_Aunn.jdField_g_of_type_JavaLangString, Integer.valueOf(6));
    if (localaunv.jdField_a_of_type_Int == 6) {}
    for (Object localObject = " big";; localObject = " thumb")
    {
      aung.a("PIC_TAG_PRELOAD", "run picreq" + (String)localObject, "uniseq:" + localaunv.jdField_a_of_type_Aunn.jdField_a_of_type_Long + "subMsgId:" + localaunv.jdField_a_of_type_Aunn.jdField_g_of_type_Int + ",priority:" + localaunv.jdField_e_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      if ((localaunv.jdField_a_of_type_Int == 6) && (!new File(localaunv.jdField_a_of_type_Aunn.c()).exists()))
      {
        this.jdField_a_of_type_Auog.a(localaunv.jdField_a_of_type_Aunn.d, k);
        j = -2147483648;
        i = j;
        if (localaunv != null)
        {
          i = j;
          if (localaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
            i = auns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, localaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin);
          }
        }
        this.jdField_a_of_type_Auob.b(k, i);
      }
      String str = "consume";
      localObject = str;
      if (localaunv != null)
      {
        localObject = str;
        if (localaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
          localObject = "consume" + ", msgSeq = " + localaunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.shmsgseq;
        }
      }
      a(new PicPreDownloader.PicPreDownRunner(this, new PicPreDownloader.10(this, localaunv), (String)localObject));
      label911:
      aung.a("PIC_TAG_PRELOAD", "consume", "END");
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
    DeviceProfileManager.b(this.jdField_a_of_type_Auog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader
 * JD-Core Version:    0.7.0.1
 */