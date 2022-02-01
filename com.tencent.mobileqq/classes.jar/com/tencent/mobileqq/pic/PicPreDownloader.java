package com.tencent.mobileqq.pic;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import anlk;
import annq;
import awwm;
import aywz;
import ayxi;
import ayxn;
import ayxp;
import ayxu;
import ayxv;
import ayxx;
import ayyd;
import ayyj;
import ayyp;
import bdsh;
import bdtr;
import bdzi;
import bdzx;
import bgjz;
import bgnt;
import bley;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
import mqq.os.MqqHandler;

public class PicPreDownloader
  implements Manager
{
  public static boolean a;
  public static boolean b;
  volatile int jdField_a_of_type_Int = 0;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  ayyd jdField_a_of_type_Ayyd;
  public ayyj a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Runnable jdField_a_of_type_JavaLangRunnable = new PicPreDownloader.1(this);
  List<ayxx> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  public Map<String, Integer> a;
  ConcurrentLinkedQueue<PicPreDownloader.PicPreDownRunner> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  LinkedBlockingQueue<MessageForStructing> jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue = new LinkedBlockingQueue(100);
  PriorityBlockingQueue<ayxx> jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public AtomicInteger a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  List<ayxx> b;
  public PriorityBlockingQueue<ayxx> b;
  List<ayxx> c = Collections.synchronizedList(new LinkedList());
  List<ayxx> d = Collections.synchronizedList(new LinkedList());
  
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
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ayxv(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_Ayyj = new ayyj();
    ThreadManager.post(new PicPreDownloader.2(this, paramQQAppInterface), 5, null, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ayyd = ((ayyd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73));
    ayxi.a("PIC_TAG_PRELOAD", "onInit", "Finished");
  }
  
  private void a(MessageForPic paramMessageForPic, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramMessageForPic.path == null) && (paramMessageForPic.uuid == null) && (paramMessageForPic.md5 == null))
    {
      ayxi.a("PIC_TAG_PRELOAD", "add", "pic.path == null && pic.uuid == null && pic.md5 == null");
      a(paramMessageForPic, -3);
      return;
    }
    if (a(paramMessageForPic, paramInt2))
    {
      ayxi.a("PIC_TAG_PRELOAD", "filter", "skip uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + "priority:" + paramInt2);
      return;
    }
    if (paramBoolean1) {
      a(paramMessageForPic);
    }
    if ((paramInt1 & 0x2) == 2)
    {
      if (paramInt3 == 1) {
        break label188;
      }
      ayxi.a("PIC_TAG_PRELOAD", "add", "The troop is not MSG_FILTER_VALUE.MSG_FILTER_OPEN");
      a(paramMessageForPic, -7);
    }
    label314:
    for (;;)
    {
      ayxi.a("PIC_TAG_PRELOAD", "add", "FINISH uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + ",priority:" + paramInt2);
      return;
      label188:
      if (this.jdField_a_of_type_Ayyj.a(paramMessageForPic))
      {
        if ((b(paramMessageForPic, paramInt2)) && (paramBoolean2))
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 1) {
            f();
          }
          for (;;)
          {
            if ((!paramMessageForPic.checkGif()) || (paramMessageForPic.isSendFromLocal()) || (paramInt2 != 5) || (paramMessageForPic.hasThumbFile())) {
              break label314;
            }
            ayxi.a("PIC_TAG_PRELOAD", "addBigPicRequest", "not hasThumbFile,download thumb,uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt2);
            a(paramMessageForPic);
            break;
            ayxi.a("PIC_TAG_PRELOAD", "add", "handlingNum.get() >= MAX_HANDLING_THREADS");
          }
        }
      }
      else {
        a(paramMessageForPic, -6);
      }
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing, int paramInt)
  {
    if ((!jdField_a_of_type_Boolean) && (paramInt != 0)) {
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.add(paramMessageForStructing);
        ayxi.a("PIC_TAG_PRELOAD", "structMsg-screenOFF", "no preDownload,networkType:" + paramInt);
        return;
      }
      catch (Exception paramMessageForStructing)
      {
        for (;;)
        {
          ayxi.a("PIC_TAG_PRELOAD", "structMsg-screenOFF", "no preDownload exception happened,networkType:" + paramInt);
        }
      }
    }
    String str = "addToQuene-MessageForStructing" + ", msgSeq = " + paramMessageForStructing.shmsgseq;
    a(new PicPreDownloader.PicPreDownRunner(this, new PicPreDownloader.6(this, paramMessageForStructing), str));
    ayxi.a("PIC_TAG_PRELOAD", "structMsg-add ", "finish preDownload uniseq =" + paramMessageForStructing.uniseq);
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
          ayxx localayxx = (ayxx)localIterator.next();
          if (paramMessageForPic.subMsgId == localayxx.jdField_a_of_type_Ayxp.jdField_g_of_type_Int)
          {
            ayxi.a("PIC_TAG_PRELOAD", "getPriority", "uuid: " + paramMessageForPic.uuid + " subMsgId: " + paramMessageForPic.subMsgId);
            int i = localInteger.intValue();
            return i;
          }
        }
      }
      finally {}
    }
    return -1;
  }
  
  ayxx a()
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      ayxx localayxx1;
      if (i > 0)
      {
        ayxi.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from AIORequests");
        localayxx1 = (ayxx)this.jdField_a_of_type_JavaUtilList.get(i - 1);
        this.jdField_a_of_type_JavaUtilList.remove(i - 1);
        return localayxx1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          ayxi.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from C2CRequests");
          localayxx1 = (ayxx)this.jdField_b_of_type_JavaUtilList.get(i - 1);
          this.jdField_b_of_type_JavaUtilList.remove(i - 1);
          return localayxx1;
        }
      }
    }
    synchronized (this.c)
    {
      i = this.c.size();
      if (i > 0)
      {
        ayxi.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from DiscussionRequests");
        ayxx localayxx2 = (ayxx)this.c.get(i - 1);
        this.c.remove(i - 1);
        return localayxx2;
      }
    }
    synchronized (this.d)
    {
      i = this.d.size();
      if (i > 0)
      {
        ayxi.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from GroupRequests");
        ayxx localayxx3 = (ayxx)this.d.get(i - 1);
        this.d.remove(i - 1);
        return localayxx3;
      }
    }
    ayxi.a("PIC_TAG_PRELOAD", "getPicRequest", "cannot get any request");
    return null;
  }
  
  ayxx a(String paramString, Collection<ayxx> paramCollection)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramCollection.iterator();
        if (localIterator.hasNext())
        {
          ayxx localayxx = (ayxx)localIterator.next();
          if (localayxx.jdField_a_of_type_Ayxp == null) {
            continue;
          }
          if (localayxx.jdField_a_of_type_Ayxp.jdField_e_of_type_Int == 1)
          {
            bool = true;
            int i = bdzx.a(localayxx.jdField_a_of_type_Ayxp.jdField_e_of_type_JavaLangString, bool);
            String str = bdzi.a(localayxx.jdField_a_of_type_Ayxp.f, localayxx.jdField_a_of_type_Ayxp.jdField_g_of_type_JavaLangString, i);
            if ((paramString == null) || (!paramString.equals(str))) {
              continue;
            }
            paramCollection.remove(localayxx);
            this.jdField_a_of_type_JavaUtilMap.remove(localayxx.jdField_a_of_type_Ayxp.jdField_g_of_type_JavaLangString);
            a(localayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -5);
            return localayxx;
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
  
  Collection<ayxx> a(int paramInt)
  {
    ayxi.a("PIC_TAG_PRELOAD", "getRequestsByPriority", "priority=" + paramInt);
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
    ayxi.a("PIC_TAG_PRELOAD", "picPreDownloadOff", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
    }
  }
  
  void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.hasThumbFile()) {}
    ayxx localayxx;
    for (;;)
    {
      return;
      if ((bgjz.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {}
      for (int i = 1; i == 0; i = 0)
      {
        this.jdField_a_of_type_Ayyd.a(paramMessageForPic);
        localayxx = ayxn.a(5, 1536, 2);
        localObject = paramMessageForPic.getPicDownloadInfo();
        if (localObject != null) {
          ((ayxp)localObject).h = 1;
        }
        localayxx.a(paramMessageForPic, (ayxp)localObject);
        i = ayxu.a();
        if ((jdField_a_of_type_Boolean) || (i == 0)) {
          break label152;
        }
        ayxi.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
        this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localayxx);
        return;
      }
    }
    label152:
    String str = "consumeThumb";
    Object localObject = str;
    if (localayxx != null)
    {
      localObject = str;
      if (localayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
        localObject = "consumeThumb" + ", msgSeq = " + localayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.shmsgseq;
      }
    }
    a(new PicPreDownloader.PicPreDownRunner(this, new PicPreDownloader.7(this, localayxx), (String)localObject));
    ayxi.a("PIC_TAG_PRELOAD", "run picreq thumb", "uniseq:" + paramMessageForPic.uniseq + ",subMsgId:" + paramMessageForPic.subMsgId);
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    a(paramMessageForPic);
    if ((aywz.c != 2L) && (aywz.c != 0L))
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
    if ((this.jdField_a_of_type_Ayyj instanceof ayyj)) {
      this.jdField_a_of_type_Ayyj.a(paramMessageForPic, paramLong);
    }
  }
  
  void a(MessageRecord paramMessageRecord)
  {
    int i = ayxu.a();
    ayxi.a("PIC_TAG_PRELOAD", "setMessageRecordNetworkType", "network=" + i);
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
    ayxi.a("PIC_TAG_PRELOAD", "setNotPredownloadReason", "Reson=" + paramInt);
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
    } while ((!(paramMessageRecord instanceof MessageForStructing)) || (!ayyp.jdField_a_of_type_Boolean));
    c(paramMessageRecord, paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    ayxx localayxx = a(paramString, this.jdField_a_of_type_JavaUtilList);
    if (localayxx != null)
    {
      ayxi.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localayxx.jdField_a_of_type_Ayxp.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localayxx.jdField_a_of_type_Int);
      return;
    }
    localayxx = a(paramString, this.jdField_b_of_type_JavaUtilList);
    if (localayxx != null)
    {
      ayxi.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localayxx.jdField_a_of_type_Ayxp.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localayxx.jdField_a_of_type_Int);
      return;
    }
    localayxx = a(paramString, this.c);
    if (localayxx != null)
    {
      ayxi.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localayxx.jdField_a_of_type_Ayxp.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localayxx.jdField_a_of_type_Int);
      return;
    }
    localayxx = a(paramString, this.d);
    if (localayxx != null)
    {
      ayxi.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localayxx.jdField_a_of_type_Ayxp.jdField_a_of_type_Long + ",key:" + paramString + ",cmd:" + localayxx.jdField_a_of_type_Int);
      return;
    }
    ayxi.a("PIC_TAG_PRELOAD", "", "drop", "Cannot be found in the request stacks");
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694401), "qqsetting_auto_receive_pic_key", true);
    if ((bgnt.b(BaseApplication.getContext()) == 1) || (bool2)) {}
    for (int i = 1;; i = 0)
    {
      if ((aywz.jdField_a_of_type_Boolean) || (i != 0)) {
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
      ayxi.a("PIC_TAG_PRELOAD", "filter", "uuid=" + paramMessageForPic.uuid + ", priority=" + paramInt + ", cannot be found in the PriorityMap");
      return bool2;
    }
    Collection localCollection = a(localInteger.intValue());
    ayxi.a("PIC_TAG_PRELOAD", "filter", "priority: " + paramInt + ", uniseq: " + paramMessageForPic.uniseq + ", subMsgId:" + paramMessageForPic.subMsgId);
    if (localCollection == null)
    {
      ayxi.a("PIC_TAG_PRELOAD", "filter", "originalRequests == null");
      return false;
    }
    Object localObject1 = null;
    label334:
    for (;;)
    {
      try
      {
        Iterator localIterator = localCollection.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (ayxx)localIterator.next();
          if (paramMessageForPic.subMsgId != ((ayxx)localObject2).jdField_a_of_type_Ayxp.jdField_g_of_type_Int) {
            break label334;
          }
          bool1 = true;
          localObject1 = localObject2;
          break label334;
        }
        if ((!bool1) || (paramInt <= localInteger.intValue()))
        {
          ayxi.a("PIC_TAG_PRELOAD", "filter", "No need to update the picReq");
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
      ayxi.a("PIC_TAG_PRELOAD", "filter", "update the picReq");
      return bool1;
    }
  }
  
  ayxx b()
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      ayxx localayxx1;
      if (i > 0)
      {
        ayxi.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from AIORequests");
        localayxx1 = (ayxx)this.jdField_a_of_type_JavaUtilList.get(i - 1);
        return localayxx1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          ayxi.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from C2CRequests");
          localayxx1 = (ayxx)this.jdField_b_of_type_JavaUtilList.get(i - 1);
          return localayxx1;
        }
      }
    }
    synchronized (this.c)
    {
      i = this.c.size();
      if (i > 0)
      {
        ayxi.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from DiscussionRequests");
        ayxx localayxx2 = (ayxx)this.c.get(i - 1);
        return localayxx2;
      }
    }
    synchronized (this.d)
    {
      i = this.d.size();
      if (i > 0)
      {
        ayxi.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from GroupRequests");
        ayxx localayxx3 = (ayxx)this.d.get(i - 1);
        return localayxx3;
      }
    }
    ayxi.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "cannot get any request");
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    ayxi.a("PIC_TAG_PRELOAD", "picPreDownloadOn", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    f();
  }
  
  public void b(MessageForPic paramMessageForPic, int paramInt)
  {
    a(paramMessageForPic);
    if ((aywz.c != 2L) && (aywz.c != 0L))
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
      if ((aywz.c != 1L) && (aywz.c != 0L))
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
      ((MessageForPic)localObject).getReportInfo().b = ayxu.a();
      ((MessageForPic)localObject).getReportInfo().jdField_a_of_type_Long = System.currentTimeMillis();
      ((MessageForPic)localObject).getReportInfo().jdField_a_of_type_Int = 0;
    }
    a(paramMessageRecord, paramInt, 1);
    bdtr.a(paramMessageRecord);
  }
  
  void b(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    int n = 0;
    if ((paramMessageRecord instanceof MessageForPic)) {
      ayxi.a("PIC_TAG_PRELOAD", "add", "START uniseq:" + ((MessageForPic)paramMessageRecord).uniseq + ",suMsgId:" + ((MessageForPic)paramMessageRecord).subMsgId + ",priority:" + paramInt2);
    }
    Object localObject;
    int i;
    int j;
    int k;
    if ((paramMessageRecord.isMultiMsg) && (!paramMessageRecord.isSend()))
    {
      localObject = awwm.a().a();
      if (localObject != null)
      {
        i = ((SessionInfo)localObject).jdField_a_of_type_Int;
        localObject = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
        i = ayxu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject);
        j = ayxu.a();
        k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject);
        if ((j == 0) || (k != 2)) {
          break label240;
        }
        if ((paramMessageRecord instanceof MessageForPic)) {
          ayxi.a("PIC_TAG_PRELOAD", "add", "num group skip, uniseq:" + paramMessageRecord.uniseq + ",suMsgId:" + ((MessageForPic)paramMessageRecord).subMsgId + "priority:" + paramInt2);
        }
      }
    }
    label240:
    do
    {
      return;
      i = paramMessageRecord.istroop;
      localObject = paramMessageRecord.frienduin;
      break;
      i = paramMessageRecord.istroop;
      localObject = paramMessageRecord.frienduin;
      break;
      localObject = this.jdField_a_of_type_Ayyj.a(i, j);
      int m = n;
      boolean bool;
      if (localObject[0] != 0)
      {
        m = n;
        if ((paramInt1 & 0x1) == 1) {
          bool = true;
        }
      }
      n = localObject[1];
      ayxi.a("PIC_TAG_PRELOAD", "add", "preDownThumb=" + bool + " preDownBig=" + n);
      if ((paramMessageRecord instanceof MessageForPic))
      {
        a((MessageForPic)paramMessageRecord, paramInt1, paramInt2, k, bool, n);
        return;
      }
    } while (!(paramMessageRecord instanceof MessageForStructing));
    a((MessageForStructing)paramMessageRecord, j);
  }
  
  boolean b(MessageForPic paramMessageForPic, int paramInt)
  {
    if (paramMessageForPic.hasBigFile())
    {
      ayxi.a("PIC_TAG_PRELOAD", "addBigPicRequest", "hasBigFile, uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the big picture already exists");
      }
      ayxu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic);
    }
    do
    {
      return false;
      if (((!annq.a(paramMessageForPic)) && (!anlk.a(paramMessageForPic))) || (bdsh.b(bdzx.a(paramMessageForPic, 1, null).toString()) == null)) {
        break;
      }
      ayxi.a("PIC_TAG_PRELOAD", "addBigPicRequest", "hasFlashPicFile, uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the picture already exists");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "real download a big picture");
    }
    ayxi.a("PIC_TAG_PRELOAD", "addBigPicRequest", " START uniseq: " + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority:" + paramInt);
    int i;
    ayxx localayxx;
    Object localObject;
    List localList;
    if (ayxu.a() == 0)
    {
      i = 1536;
      localayxx = ayxn.a(6, i, 2);
      localObject = paramMessageForPic.getPicDownloadInfo();
      if (localObject != null)
      {
        ((ayxp)localObject).h = 1;
        ((ayxp)localObject).jdField_e_of_type_JavaLangString = "chatimg";
      }
      localayxx.a(paramMessageForPic, (ayxp)localObject);
      localList = null;
      localObject = "";
      i = ayxu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin);
      if (paramInt != 5) {
        break label517;
      }
      localList = this.jdField_a_of_type_JavaUtilList;
      localayxx.jdField_e_of_type_Int = 5;
      localObject = "AIORequests";
      switch (i)
      {
      default: 
        localayxx.f = 2;
      }
    }
    for (;;)
    {
      if (localList != null)
      {
        ayxi.a("PIC_TAG_PRELOAD", "addBigPicRequest", "successfully to add the pic request to " + (String)localObject);
        localList.add(localayxx);
        d();
        this.jdField_a_of_type_JavaUtilMap.put(localayxx.jdField_a_of_type_Ayxp.jdField_g_of_type_JavaLangString, Integer.valueOf(localayxx.jdField_e_of_type_Int));
      }
      ayxi.a("PIC_TAG_PRELOAD", "addBigPicRequest", "END uniseq: " + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority: " + paramInt);
      return true;
      i = 1537;
      break;
      localayxx.f = 4;
      continue;
      localayxx.f = 3;
      continue;
      label517:
      if (paramInt == 1) {
        switch (i)
        {
        default: 
          localList = this.d;
          localayxx.jdField_e_of_type_Int = 2;
          localayxx.f = localayxx.jdField_e_of_type_Int;
          localObject = "GroupRequests";
          break;
        case 3: 
          localList = this.jdField_b_of_type_JavaUtilList;
          localayxx.jdField_e_of_type_Int = 4;
          localayxx.f = localayxx.jdField_e_of_type_Int;
          localObject = "C2CRequests";
          break;
        case 2: 
          localList = this.c;
          localayxx.jdField_e_of_type_Int = 3;
          localayxx.f = localayxx.jdField_e_of_type_Int;
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
      ayxi.a("PIC_TAG_PRELOAD", "add", "MessageRecord isSendFromLocal");
      return;
    }
    b(paramMessageRecord, paramInt1, paramInt2);
  }
  
  void d()
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() + this.c.size() + this.d.size() > this.jdField_a_of_type_Ayyj.a.longValue()) {
      localObject1 = null;
    }
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.d.size() > 0)
        {
          localObject1 = (ayxx)this.d.remove(0);
          if (localObject1 != null)
          {
            this.jdField_a_of_type_JavaUtilMap.remove(((ayxx)localObject1).jdField_a_of_type_Ayxp.jdField_g_of_type_JavaLangString);
            localObject1 = this.jdField_a_of_type_Ayyj;
            ((ayyj)localObject1).N += 1L;
            ayxi.a("PIC_TAG_PRELOAD", "checkRequestListSize", "over max request list size: " + this.jdField_a_of_type_Ayyj.a + ", remove a request");
          }
          return;
        }
        synchronized (this.c)
        {
          if (this.c.size() > 0) {
            localObject1 = (ayxx)this.c.remove(0);
          }
        }
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
          ayxx localayxx1 = (ayxx)this.jdField_b_of_type_JavaUtilList.remove(0);
        }
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          ayxx localayxx2 = (ayxx)this.jdField_a_of_type_JavaUtilList.remove(0);
        }
      }
    }
  }
  
  void e()
  {
    ayxi.a("PIC_TAG_PRELOAD", "consumeThumb", "START");
    int i = ayxu.a();
    if ((!jdField_a_of_type_Boolean) && (i != 0))
    {
      ayxi.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
      return;
    }
    Object localObject3 = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    ayxx localayxx;
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localayxx = (ayxx)((Iterator)localObject3).next();
      localObject2 = "consumeAllThumbsInPendingQueue-thumbPendingQueue";
      localObject1 = localObject2;
      if (localayxx != null)
      {
        localObject1 = localObject2;
        if (localayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
          localObject1 = "consumeAllThumbsInPendingQueue-thumbPendingQueue" + ", msgSeq = " + localayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.shmsgseq;
        }
      }
      a(new PicPreDownloader.PicPreDownRunner(this, new PicPreDownloader.8(this, localayxx), (String)localObject1));
      if (localayxx.jdField_a_of_type_Ayxp == null) {
        break label356;
      }
    }
    label356:
    for (Object localObject1 = "uniseq:" + localayxx.jdField_a_of_type_Ayxp.jdField_a_of_type_Long;; localObject1 = "")
    {
      ayxi.a("PIC_TAG_PRELOAD", "run picreq thumb", (String)localObject1);
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
          ayxi.a("PIC_TAG_PRELOAD", "structMsg-add ", "finish MessageForStructing preDownload uniseq =" + ((MessageForStructing)localObject2).uniseq);
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.clear();
      ayxi.a("PIC_TAG_PRELOAD", "consumeThumb", "END");
      return;
    }
  }
  
  public void f()
  {
    ayxi.a("PIC_TAG_PRELOAD", "consume", "START");
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      ayxi.a("PIC_TAG_PRELOAD", "consume", "!mIsPicPreloadSuitable.get() failed");
    }
    int k;
    ayxx localayxx;
    int i;
    int j;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 1)
        {
          ayxi.a("PIC_TAG_PRELOAD", "consume", "handlingNum.get() >= MAX_HANDLING_THREADS");
          return;
        }
        localObject = b();
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((ayxx)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
          {
            bool1 = bool2;
            if (((ayxx)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbWidthHeightDP != null)
            {
              bool1 = ((ayxx)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbWidthHeightDP.useCustomSize();
              ayxi.a("PIC_TAG_PRELOAD", "consume", "isBigImage=" + bool1);
            }
          }
        }
        k = ayxu.a();
        if ((!jdField_a_of_type_Boolean) && (k != 0) && (!bool1))
        {
          ayxi.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + k + ",isBigImage=" + bool1);
          return;
        }
        localayxx = a();
        if (localayxx == null) {
          break label910;
        }
        if (localayxx.jdField_a_of_type_Ayxp == null)
        {
          ayxi.b("PIC_TAG_PRELOAD", "consume", "picReq.downinfo == null");
          a(localayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -4);
          return;
        }
        this.jdField_a_of_type_JavaUtilMap.remove(localayxx.jdField_a_of_type_Ayxp.jdField_g_of_type_JavaLangString);
        i = ayxu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localayxx.jdField_a_of_type_Ayxp.b, localayxx.jdField_a_of_type_Ayxp.c);
        j = this.jdField_a_of_type_Ayyj.a(localayxx.jdField_a_of_type_Ayxp.d, i, k, bley.a(localayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType));
        a(localayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, j);
        if (j >= 0) {
          break;
        }
        ayxi.a("PIC_TAG_PRELOAD", "consume", "overLimit and put request back to list, uinType=" + i + " networkType=" + k);
        localObject = a(localayxx.jdField_e_of_type_Int);
      } while (localObject == null);
      ((Collection)localObject).add(localayxx);
      this.jdField_a_of_type_JavaUtilMap.put(localayxx.jdField_a_of_type_Ayxp.jdField_g_of_type_JavaLangString, Integer.valueOf(localayxx.jdField_e_of_type_Int));
      d();
      return;
      if ((localayxx.jdField_a_of_type_Int != 6) || (this.jdField_a_of_type_Ayyj.a(i, k)[1] != 0)) {
        break;
      }
      ayxi.a("PIC_TAG_PRELOAD", "consume", "Network changed, put the picReq back to list, uintype:" + localayxx.jdField_a_of_type_Ayxp.b + ", networkType:" + k + ", uniseq:" + localayxx.jdField_a_of_type_Ayxp.jdField_a_of_type_Long);
      localObject = a(localayxx.jdField_e_of_type_Int);
    } while (localObject == null);
    ((Collection)localObject).add(localayxx);
    this.jdField_a_of_type_JavaUtilMap.put(localayxx.jdField_a_of_type_Ayxp.jdField_g_of_type_JavaLangString, Integer.valueOf(localayxx.jdField_e_of_type_Int));
    d();
    return;
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localayxx);
    localayxx.f = localayxx.jdField_e_of_type_Int;
    localayxx.jdField_e_of_type_Int = 6;
    this.jdField_a_of_type_JavaUtilMap.put(localayxx.jdField_a_of_type_Ayxp.jdField_g_of_type_JavaLangString, Integer.valueOf(6));
    if (localayxx.jdField_a_of_type_Int == 6) {}
    for (Object localObject = " big";; localObject = " thumb")
    {
      ayxi.a("PIC_TAG_PRELOAD", "run picreq" + (String)localObject, "uniseq:" + localayxx.jdField_a_of_type_Ayxp.jdField_a_of_type_Long + "subMsgId:" + localayxx.jdField_a_of_type_Ayxp.jdField_g_of_type_Int + ",priority:" + localayxx.jdField_e_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      if ((localayxx.jdField_a_of_type_Int == 6) && (!new File(localayxx.jdField_a_of_type_Ayxp.c()).exists()))
      {
        this.jdField_a_of_type_Ayyj.a(localayxx.jdField_a_of_type_Ayxp.d, k);
        j = -2147483648;
        i = j;
        if (localayxx != null)
        {
          i = j;
          if (localayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
            i = ayxu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, localayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin);
          }
        }
        this.jdField_a_of_type_Ayyd.b(k, i);
      }
      String str = "consume";
      localObject = str;
      if (localayxx != null)
      {
        localObject = str;
        if (localayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
          localObject = "consume" + ", msgSeq = " + localayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.shmsgseq;
        }
      }
      a(new PicPreDownloader.PicPreDownRunner(this, new PicPreDownloader.10(this, localayxx), (String)localObject));
      label910:
      ayxi.a("PIC_TAG_PRELOAD", "consume", "END");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader
 * JD-Core Version:    0.7.0.1
 */