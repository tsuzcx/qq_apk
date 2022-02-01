package com.tencent.mobileqq.pic;

import amrp;
import amtr;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import awcm;
import aycu;
import aycy;
import aycz;
import ayde;
import aydj;
import aydl;
import aydq;
import ayds;
import aydy;
import ayee;
import ayek;
import bfti;
import bkkh;
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
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.ChatImageDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
  public static boolean a;
  private static boolean b;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private aydy jdField_a_of_type_Aydy;
  public ayee a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PicPreDownloaderCore jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore;
  private LinkedBlockingQueue<MessageForStructing> jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue = new LinkedBlockingQueue(100);
  private PriorityBlockingQueue<ayds> jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public PicPreDownloader(QQAppInterface paramQQAppInterface)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new PicPreDownloader.ScreenBroadcastReceiver(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_Ayee = new ayee();
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore = new PicPreDownloaderCore(this, this.jdField_a_of_type_Ayee);
    ThreadManager.excute(new PicPreDownloader.1(this, paramQQAppInterface), 64, null, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aydy = ((aydy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73));
    ayde.a("PIC_TAG_PRELOAD", "onInit", "Finished");
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.hasThumbFile()) {}
    ayds localayds;
    for (;;)
    {
      return;
      if ((bfti.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {}
      for (int i = 1; i == 0; i = 0)
      {
        this.jdField_a_of_type_Aydy.a(paramMessageForPic);
        localayds = aydj.a(5, 1536, 2);
        aydl localaydl = paramMessageForPic.getPicDownloadInfo();
        if (localaydl != null) {
          localaydl.h = 1;
        }
        localayds.a(paramMessageForPic, localaydl);
        i = aydq.a();
        if ((jdField_a_of_type_Boolean) || (i == 0)) {
          break label151;
        }
        ayde.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
        this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localayds);
        return;
      }
    }
    label151:
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(new PicPreDownloader.5(this, localayds), "consumeThumb", localayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    ayde.a("PIC_TAG_PRELOAD", "run picReq thumb", "uniseq:" + paramMessageForPic.uniseq + ",subMsgId:" + paramMessageForPic.subMsgId);
  }
  
  private void a(MessageForPic paramMessageForPic, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(new PicPreDownloader.3(this, paramMessageForPic, paramInt1, paramInt2), "productAsync", paramMessageForPic);
  }
  
  private void a(MessageForPic paramMessageForPic, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if ((paramMessageForPic.path == null) && (paramMessageForPic.uuid == null) && (paramMessageForPic.md5 == null))
    {
      ayde.a("PIC_TAG_PRELOAD", "add", "pic.path == null && pic.uuid == null && pic.md5 == null");
      a(paramMessageForPic, -3);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(paramMessageForPic, paramInt2))
    {
      ayde.a("PIC_TAG_PRELOAD", "filter", "skip uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + "priority:" + paramInt2);
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
      paramBoolean1 = aycz.a(paramMessageForPic, false, paramInt2);
      if (!paramBoolean2)
      {
        paramInt1 = i;
        if (!paramBoolean1) {}
      }
      else
      {
        paramInt1 = 1;
      }
      if ((paramInt3 == 1) || (paramBoolean1)) {
        break label260;
      }
      ayde.a("PIC_TAG_PRELOAD", "add", "The troop is num troop");
      a(paramMessageForPic, -7);
    }
    label384:
    for (;;)
    {
      ayde.a("PIC_TAG_PRELOAD", "add", "FINISH uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + ",priority:" + paramInt2);
      return;
      label260:
      if (this.jdField_a_of_type_Ayee.a(paramMessageForPic))
      {
        if ((a(paramMessageForPic, paramInt2)) && (paramInt1 != 0))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.b()) {
            d();
          }
          for (;;)
          {
            if ((!paramMessageForPic.checkGif()) || (paramMessageForPic.isSendFromLocal()) || (paramInt2 != 5) || (paramMessageForPic.hasThumbFile())) {
              break label384;
            }
            ayde.a("PIC_TAG_PRELOAD", "addBigPicRequest", "not hasThumbFile,download thumb,uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt2);
            a(paramMessageForPic);
            break;
            ayde.a("PIC_TAG_PRELOAD", "add", "handling queue full");
          }
        }
      }
      else {
        a(paramMessageForPic, -6);
      }
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != 0) && (paramInt3 == 2))
    {
      ayde.a("PIC_TAG_PRELOAD", "add", "add struct msg to queue, num group skip, uniseq:" + paramMessageForStructing.uniseq + "priority:" + paramInt2);
      return;
    }
    if ((!jdField_a_of_type_Boolean) && (paramInt1 != 0)) {
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.add(paramMessageForStructing);
        ayde.a("PIC_TAG_PRELOAD", "structMsg-screenOFF", "no preDownload,networkType:" + paramInt1);
        return;
      }
      catch (Exception paramMessageForStructing)
      {
        for (;;)
        {
          ayde.a("PIC_TAG_PRELOAD", "structMsg-screenOFF", "no preDownload exception happened,networkType:" + paramInt1);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(new PicPreDownloader.4(this, paramMessageForStructing), "addToQueue-MessageForStruct", paramMessageForStructing);
    ayde.a("PIC_TAG_PRELOAD", "structMsg-add ", "finish preDownload uniseq:" + paramMessageForStructing.uniseq + ",");
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    int i = aydq.a();
    ayde.a("PIC_TAG_PRELOAD", "setMessageRecordNetworkType", "network=" + i);
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
  
  private void a(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      c(paramMessageRecord, paramInt1, paramInt2);
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
    } while ((!(paramMessageRecord instanceof MessageForStructing)) || (!ayek.jdField_a_of_type_Boolean));
    c(paramMessageRecord, paramInt1, paramInt2);
  }
  
  private boolean a(MessageForPic paramMessageForPic, int paramInt)
  {
    if (paramMessageForPic.hasBigFile())
    {
      ayde.a("PIC_TAG_PRELOAD", "addBigPicRequest", "hasBigFile, uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the big picture already exists");
      }
      aydq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic);
    }
    do
    {
      return false;
      if (((!amtr.a(paramMessageForPic)) && (!amrp.a(paramMessageForPic))) || (AbsDownloader.getFlashPicFile(URLDrawableHelper.getURL(paramMessageForPic, 1, null).toString()) == null)) {
        break;
      }
      ayde.a("PIC_TAG_PRELOAD", "addBigPicRequest", "hasFlashPicFile, uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the picture already exists");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "real download a big picture");
    }
    ayde.a("PIC_TAG_PRELOAD", "addBigPicRequest", " START uniseq:" + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority:" + paramInt);
    if (aydq.a() == 0) {}
    for (int i = 1536;; i = 1537)
    {
      ayds localayds = aydj.a(6, i, 2);
      aydl localaydl = paramMessageForPic.getPicDownloadInfo();
      if (localaydl != null)
      {
        localaydl.h = 1;
        localaydl.e = "chatimg";
      }
      localayds.a(paramMessageForPic, localaydl);
      i = aydq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin);
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(localayds, i, paramInt);
      ayde.a("PIC_TAG_PRELOAD", "addBigPicRequest", "END uniseq:" + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority: " + paramInt);
      return true;
    }
  }
  
  private void b(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    int n = 0;
    if ((paramMessageRecord instanceof MessageForPic)) {
      ayde.a("PIC_TAG_PRELOAD", "add", "START uniseq:" + ((MessageForPic)paramMessageRecord).uniseq + ", suMsgId:" + ((MessageForPic)paramMessageRecord).subMsgId + ", priority:" + paramInt2);
    }
    Object localObject;
    int i;
    int j;
    int k;
    if ((paramMessageRecord.isMultiMsg) && (!paramMessageRecord.isSend()))
    {
      localObject = awcm.a().a();
      if (localObject != null)
      {
        i = ((SessionInfo)localObject).curType;
        localObject = ((SessionInfo)localObject).curFriendUin;
        i = aydq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject);
        j = aydq.a();
        k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask((String)localObject);
        localObject = this.jdField_a_of_type_Ayee.a(i, j);
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
        ayde.a("PIC_TAG_PRELOAD", "add", "preDownThumb=" + bool + " preDownBig=" + n);
        if (!(paramMessageRecord instanceof MessageForPic)) {
          break label276;
        }
        a((MessageForPic)paramMessageRecord, paramInt1, paramInt2, k, bool, n);
      }
    }
    label276:
    while (!(paramMessageRecord instanceof MessageForStructing))
    {
      return;
      i = paramMessageRecord.istroop;
      localObject = paramMessageRecord.frienduin;
      break;
      i = paramMessageRecord.istroop;
      localObject = paramMessageRecord.frienduin;
      break;
    }
    a((MessageForStructing)paramMessageRecord, j, paramInt2, k);
  }
  
  private boolean b()
  {
    return aycu.jdField_a_of_type_Boolean;
  }
  
  private void c(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (paramMessageRecord.isSendFromLocal())
    {
      ayde.a("PIC_TAG_PRELOAD", "add", "MessageRecord isSendFromLocal");
      return;
    }
    b(paramMessageRecord, paramInt1, paramInt2);
  }
  
  private boolean c()
  {
    boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694557), "qqsetting_auto_receive_pic_key", true);
    return (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) || (bool);
  }
  
  private void e()
  {
    ayde.a("PIC_TAG_PRELOAD", "consumeThumb", "START");
    int i = aydq.a();
    if ((!jdField_a_of_type_Boolean) && (i != 0))
    {
      ayde.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (ayds)((Iterator)localObject2).next();
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(new PicPreDownloader.6(this, (ayds)localObject1), "consumeAllThumbsInPendingQueue-thumbPendingQueue", ((ayds)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
      if (((ayds)localObject1).jdField_a_of_type_Aydl == null) {
        break label255;
      }
    }
    label255:
    for (Object localObject1 = "uniseq:" + ((ayds)localObject1).jdField_a_of_type_Aydl.jdField_a_of_type_Long;; localObject1 = "")
    {
      ayde.a("PIC_TAG_PRELOAD", "run picReq thumb", (String)localObject1);
      break;
      this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
      localObject1 = this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageForStructing)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(new PicPreDownloader.7(this, (MessageForStructing)localObject2), "consumeAllThumbsInPendingQueue-structMsgPendingQueue", (MessageRecord)localObject2);
          ayde.a("PIC_TAG_PRELOAD", "structMsg-add ", "finish struct msg preDownload,  uniseq =" + ((MessageForStructing)localObject2).uniseq);
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.clear();
      ayde.a("PIC_TAG_PRELOAD", "consumeThumb", "END");
      return;
    }
  }
  
  public int a(MessageForPic paramMessageForPic)
  {
    return this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(paramMessageForPic);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.b();
  }
  
  public void a(ayds paramayds, aycy paramaycy)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(paramayds))
    {
      if ((paramaycy == null) || (paramaycy.b == null)) {
        break label72;
      }
      paramayds = paramayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      if ((paramayds == null) || (paramayds.size != 0L)) {
        break label72;
      }
      if (!aycz.a(paramayds)) {}
    }
    else
    {
      return;
    }
    long l = new File(paramaycy.b).length();
    this.jdField_a_of_type_Ayee.a(paramayds, l);
    label72:
    d();
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    a(paramMessageForPic);
    if ((aycu.c != 2L) && (aycu.c != 0L))
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
    ayde.a("PIC_TAG_PRELOAD", "setNotPreDownloadReason", "Reason=" + paramInt);
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
    if ((aycu.c != 2L) && (aycu.c != 0L))
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
    }
    Object localObject;
    do
    {
      return;
      if ((aycu.c != 1L) && (aycu.c != 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): PicAuDownTimePoint is not DOWNLOAD_POINT_MSG or DOWNLOAD_POINT_ALL");
        }
        a(paramMessageRecord, -2);
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      if ((!((QQMessageFacade)localObject).isChatting()) || (!((QQMessageFacade)localObject).getCurrChatUin().equals(paramMessageRecord.frienduin))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "The AIO is opening, does not need to preDownload the thumb picture");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): ");
    }
    if ((paramMessageRecord instanceof MessageForPic))
    {
      localObject = (MessageForPic)paramMessageRecord;
      ((MessageForPic)localObject).getReportInfo().b = aydq.a();
      ((MessageForPic)localObject).getReportInfo().jdField_a_of_type_Long = System.currentTimeMillis();
      ((MessageForPic)localObject).getReportInfo().jdField_a_of_type_Int = 0;
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
    boolean bool2 = false;
    ayde.a("PIC_TAG_PRELOAD", "consume", "START");
    if (!this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a()) {
      ayde.a("PIC_TAG_PRELOAD", "consume", "!mIsPicPreloadSuitable.get() failed");
    }
    ayds localayds;
    int j;
    Map localMap;
    int i;
    Collection localCollection;
    do
    {
      do
      {
        do
        {
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.b())
          {
            ayde.a("PIC_TAG_PRELOAD", "consume", "handlingNum.get() >= MAX_HANDLING_THREADS");
            return;
          }
          localayds = this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(false);
          boolean bool1 = bool2;
          if (localayds != null)
          {
            bool1 = bool2;
            if (localayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
            {
              bool1 = bool2;
              if (localayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbWidthHeightDP != null)
              {
                bool1 = localayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbWidthHeightDP.useCustomSize();
                ayde.a("PIC_TAG_PRELOAD", "consume", "isBigImage=" + bool1);
              }
            }
          }
          j = aydq.a();
          if ((!jdField_a_of_type_Boolean) && (j != 0) && (!bool1))
          {
            ayde.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + j);
            return;
          }
          localayds = this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(true);
          if (localayds == null) {
            break label740;
          }
          if (localayds.jdField_a_of_type_Aydl == null)
          {
            ayde.b("PIC_TAG_PRELOAD", "consume", "picReq.downInfo == null");
            a(localayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -4);
            return;
          }
          localMap = this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a;
          localMap.remove(localayds.jdField_a_of_type_Aydl.g);
          i = aydq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localayds.jdField_a_of_type_Aydl.b, localayds.jdField_a_of_type_Aydl.c);
          int k = this.jdField_a_of_type_Ayee.a(localayds.jdField_a_of_type_Aydl.d, i, j, bkkh.a(localayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType), localayds.e);
          a(localayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, k);
          if (k >= 0) {
            break;
          }
          ayde.a("PIC_TAG_PRELOAD", "consume", "overLimit uinType=" + i + " networkType=" + j);
        } while (aycz.a(localayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic));
        localCollection = this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(localayds.e);
      } while (localCollection == null);
      localCollection.add(localayds);
      localMap.put(localayds.jdField_a_of_type_Aydl.g, Integer.valueOf(localayds.e));
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.e();
      return;
      if ((localayds.jdField_a_of_type_Int != 6) || (aycz.a(localayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic)) || (this.jdField_a_of_type_Ayee.a(i, j)[1] != 0)) {
        break;
      }
      ayde.a("PIC_TAG_PRELOAD", "consume", "Network changed, put the picReq back to list, uinType:" + localayds.jdField_a_of_type_Aydl.b + ", networkType:" + j + ", uniseq:" + localayds.jdField_a_of_type_Aydl.jdField_a_of_type_Long);
      localCollection = this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(localayds.e);
    } while (localCollection == null);
    localCollection.add(localayds);
    localMap.put(localayds.jdField_a_of_type_Aydl.g, Integer.valueOf(localayds.e));
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.e();
    return;
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(localayds);
    if ((localayds.jdField_a_of_type_Int == 6) && (!aycz.a(localayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic)) && (!new File(localayds.jdField_a_of_type_Aydl.c()).exists()))
    {
      this.jdField_a_of_type_Ayee.a(localayds.jdField_a_of_type_Aydl.d, j);
      i = -2147483648;
      if (localayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
        i = aydq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, localayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin);
      }
      this.jdField_a_of_type_Aydy.b(j, i);
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloaderCore.a(new PicPreDownloader.8(this, localayds), "consume", localayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    label740:
    ayde.a("PIC_TAG_PRELOAD", "consume", "END");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader
 * JD-Core Version:    0.7.0.1
 */