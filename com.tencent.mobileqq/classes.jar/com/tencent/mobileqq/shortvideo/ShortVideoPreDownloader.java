package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.BasePicPreDownloadUtils;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;

public class ShortVideoPreDownloader
  implements Manager
{
  public static long a = 86400000L;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  UiCallBack jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack;
  Runnable jdField_a_of_type_JavaLangRunnable = new ShortVideoPreDownloader.2(this);
  List<ShortVideoReq> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  public Map<String, Integer> a;
  PriorityBlockingQueue<ShortVideoReq> jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  public AtomicInteger a;
  List<ShortVideoReq> b;
  public PriorityBlockingQueue<ShortVideoReq> b;
  public AtomicInteger b;
  List<ShortVideoReq> c = Collections.synchronizedList(new LinkedList());
  List<ShortVideoReq> d = Collections.synchronizedList(new LinkedList());
  
  public ShortVideoPreDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack = new ShortVideoPreDownloader.1(this);
  }
  
  private String a(long paramLong, List<ShortVideoReq> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ShortVideoReq localShortVideoReq = (ShortVideoReq)paramList.next();
      if ((localShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (localShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq == paramLong))
      {
        this.jdField_a_of_type_JavaUtilList.remove(localShortVideoReq);
        return localShortVideoReq.jdField_a_of_type_JavaLangString;
      }
    }
    return null;
  }
  
  static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("(): ");
      paramString2.append(str);
      QLog.d("ShortVideoPreDownloader", 2, paramString2.toString());
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    int i = ((IPicPreDownload)paramQQAppInterface.getRuntimeService(IPicPreDownload.class, "")).calcUinType(paramQQAppInterface, paramMessageForShortVideo.istroop, paramMessageForShortVideo.frienduin);
    if ((i == 0) || (i == 1))
    {
      int j = paramQQAppInterface.getTroopMask(paramMessageForShortVideo.frienduin);
      if ((j == 2) || (j == 3)) {
        break label114;
      }
      if (j == 4) {
        return false;
      }
    }
    if (i == 2)
    {
      DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      if (localDiscussionManager != null)
      {
        paramQQAppInterface = localDiscussionManager.a(paramMessageForShortVideo.frienduin, paramQQAppInterface.getCurrentAccountUin());
        if ((paramQQAppInterface != null) && ((paramQQAppInterface.flag & 0x1) != 0)) {
          return false;
        }
      }
    }
    return true;
    label114:
    return false;
  }
  
  ShortVideoReq a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      Object localObject1;
      if (i > 0)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        localObject1 = this.jdField_a_of_type_JavaUtilList;
        i -= 1;
        localObject1 = (ShortVideoReq)((List)localObject1).get(i);
        this.jdField_a_of_type_JavaUtilList.remove(i);
        return localObject1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          localObject1 = this.jdField_b_of_type_JavaUtilList;
          i -= 1;
          localObject1 = (ShortVideoReq)((List)localObject1).get(i);
          this.jdField_b_of_type_JavaUtilList.remove(i);
          return localObject1;
        }
        synchronized (this.c)
        {
          i = this.c.size();
          if (i > 0)
          {
            a("getShortVideoRequest", "get a short video request from DiscussionRequests");
            localObject1 = this.c;
            i -= 1;
            localObject1 = (ShortVideoReq)((List)localObject1).get(i);
            this.c.remove(i);
            return localObject1;
          }
          synchronized (this.d)
          {
            i = this.d.size();
            if (i > 0)
            {
              a("getShortVideoRequest", "get a short video request from GroupRequests");
              localObject1 = this.d;
              i -= 1;
              localObject1 = (ShortVideoReq)((List)localObject1).get(i);
              this.d.remove(i);
              return localObject1;
            }
            a("getShortVideoRequest", "cannot get any request");
            return null;
          }
        }
      }
    }
  }
  
  protected String a(long paramLong)
  {
    String str = a(paramLong, this.jdField_a_of_type_JavaUtilList);
    if (str != null) {
      return str;
    }
    str = a(paramLong, this.c);
    if (str != null) {
      return str;
    }
    str = a(paramLong, this.d);
    if (str != null) {
      return str;
    }
    str = a(paramLong, this.jdField_b_of_type_JavaUtilList);
    if (str != null) {
      return str;
    }
    return null;
  }
  
  Collection<ShortVideoReq> a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("priority=");
    localStringBuilder.append(paramInt);
    a("getRequestsByPriority", localStringBuilder.toString());
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6) {
              return null;
            }
            return this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue;
          }
          return this.jdField_a_of_type_JavaUtilList;
        }
        return this.jdField_b_of_type_JavaUtilList;
      }
      return this.c;
    }
    return this.d;
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mIsPreDownloaderOpen=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    a("off", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    } else {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uniseq:");
    localStringBuilder.append(paramMessageForShortVideo.uniseq);
    localStringBuilder.append(", md5=");
    localStringBuilder.append(paramMessageForShortVideo.md5);
    a("productFromMsg", localStringBuilder.toString());
    boolean bool = a(paramMessageForShortVideo, false);
    if (bool) {
      a(paramMessageForShortVideo, 1);
    }
    if ((!bool) && (a(paramMessageForShortVideo))) {
      b(paramMessageForShortVideo);
    }
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uniseq=");
    ((StringBuilder)localObject).append(paramMessageForShortVideo.uniseq);
    ((StringBuilder)localObject).append(" md5=");
    ((StringBuilder)localObject).append(paramMessageForShortVideo.md5);
    ((StringBuilder)localObject).append(" priority=");
    ((StringBuilder)localObject).append(paramInt);
    a("add", ((StringBuilder)localObject).toString());
    if ((paramMessageForShortVideo.uuid == null) && (paramMessageForShortVideo.md5 == null))
    {
      a("add", "msg.uuid and md5 are null");
      return;
    }
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      a("add", "MessageRecord isSendFromLocal");
      return;
    }
    if (a(paramMessageForShortVideo, paramInt))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("skip uniseq:");
      ((StringBuilder)localObject).append(paramMessageForShortVideo.uniseq);
      ((StringBuilder)localObject).append("priority:");
      ((StringBuilder)localObject).append(paramInt);
      a("add", ((StringBuilder)localObject).toString());
      return;
    }
    if ((paramMessageForShortVideo.isMultiMsg) && (!paramMessageForShortVideo.isSend()))
    {
      localObject = MultiMsgManager.a().a();
      if (localObject != null)
      {
        i = ((SessionInfo)localObject).jdField_a_of_type_Int;
        localObject = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
      }
      else
      {
        i = paramMessageForShortVideo.istroop;
        localObject = paramMessageForShortVideo.frienduin;
      }
    }
    else
    {
      i = paramMessageForShortVideo.istroop;
      localObject = paramMessageForShortVideo.frienduin;
    }
    int i = BasePicPreDownloadUtils.a();
    int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask((String)localObject);
    if ((i != 0) && (j == 2))
    {
      a("add", "MSG_FILTER_NUM, no need to pre download short video");
      return;
    }
    b(paramMessageForShortVideo, paramInt);
  }
  
  protected void a(ShortVideoReq paramShortVideoReq)
  {
    ShortVideoBusiManager.a(paramShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("launchRequest:");
      localStringBuilder.append(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.busiType);
      QLog.d("ShortVideoPreDownloader", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a(MessageForShortVideo paramMessageForShortVideo)
  {
    int i = paramMessageForShortVideo.videoFileStatus;
    boolean bool1 = false;
    if (i == 5002)
    {
      a("isNeedPredownloadThumb", "short video has expired");
      return false;
    }
    if (System.currentTimeMillis() - paramMessageForShortVideo.time * 1000L > jdField_a_of_type_Long)
    {
      a("isNeedPredownloadThumb", "out of validity, no need to pre download");
      return false;
    }
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694986), "qqsetting_auto_receive_pic_key", true);
    if ((NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) && (!bool2)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((((IPicPreDownload)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPicPreDownload.class)).getPreDownSwitch()) || (i != 0)) {
      bool1 = true;
    }
    return bool1;
  }
  
  boolean a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("uuid=");
    ((StringBuilder)localObject1).append(paramMessageForShortVideo.uuid);
    ((StringBuilder)localObject1).append(" uniseq=");
    ((StringBuilder)localObject1).append(paramMessageForShortVideo.uniseq);
    ((StringBuilder)localObject1).append(" priority=");
    ((StringBuilder)localObject1).append(paramInt);
    a("filter", ((StringBuilder)localObject1).toString());
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForShortVideo.uuid);
    boolean bool = false;
    if (localInteger == null)
    {
      a("filter", "msg cannot be found in the PriorityMap");
      return false;
    }
    Collection localCollection = a(localInteger.intValue());
    if (localCollection == null)
    {
      a("filter", "originalRequests == null");
      return false;
    }
    localObject1 = null;
    try
    {
      Iterator localIterator = localCollection.iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (ShortVideoReq)localIterator.next();
        if (((ShortVideoReq)localObject2).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_Long == paramMessageForShortVideo.uniseq)
        {
          bool = true;
          localObject1 = localObject2;
        }
      }
      if ((bool) && (paramInt > localInteger.intValue()))
      {
        localObject2 = a(paramInt);
        if (localObject2 != null)
        {
          ((ShortVideoReq)localObject1).d = ((ShortVideoReq)localObject1).c;
          ((ShortVideoReq)localObject1).c = paramInt;
          localCollection.remove(localObject1);
          ((Collection)localObject2).add(localObject1);
          this.jdField_a_of_type_JavaUtilMap.put(paramMessageForShortVideo.uuid, Integer.valueOf(paramInt));
          a("filter", "Updated the short video request");
          return bool;
        }
      }
      else
      {
        a("filter", "No need to update the short video request");
      }
      return bool;
    }
    finally {}
    for (;;)
    {
      throw paramMessageForShortVideo;
    }
  }
  
  public boolean a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a("isNeedPredownload", "short video has expired");
      return false;
    }
    AtomicInteger localAtomicInteger;
    if (paramMessageForShortVideo.busiType == 0) {
      localAtomicInteger = ShortVideoUtils.getDefaultShortVideoStrategy();
    } else {
      localAtomicInteger = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
    }
    if ((!paramBoolean) && (localAtomicInteger.get() == 1))
    {
      a("isNeedPredownload", "isFromAIO=false and mIsNotPreDownloadEvenWhenEnterAIO=true");
      return false;
    }
    if (localAtomicInteger.get() == 2)
    {
      a("isNeedPredownload", "mIsNotPreDownloadEvenWhenEnterAIO=true");
      return false;
    }
    int i;
    if ((paramMessageForShortVideo.istroop == 0) && (paramMessageForShortVideo.msgtype == -2071)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (System.currentTimeMillis() - paramMessageForShortVideo.time * 1000L > jdField_a_of_type_Long))
    {
      a("isNeedPredownload", "out of validity, no need to pre download");
      return false;
    }
    int j = BasePicPreDownloadUtils.a();
    if (i != 0)
    {
      if ((j != 0) && (j != 1))
      {
        paramMessageForShortVideo = new StringBuilder();
        paramMessageForShortVideo.append("Not Wifi or 4G, networkType=");
        paramMessageForShortVideo.append(j);
        paramMessageForShortVideo.append(", no need to predownload for lightvideo");
        a("isNeedPredownload", paramMessageForShortVideo.toString());
        return false;
      }
    }
    else if (j != 0)
    {
      paramMessageForShortVideo = new StringBuilder();
      paramMessageForShortVideo.append("Not Wifi, networkType=");
      paramMessageForShortVideo.append(j);
      paramMessageForShortVideo.append(", no need to predownload");
      a("isNeedPredownload", paramMessageForShortVideo.toString());
      return false;
    }
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShortVideoPreDownloader is on, mIsPreDownloaderOpen=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    a("on", localStringBuilder.toString());
    c();
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo)
  {
    a("consumeShortVideoThumb", null);
    Object localObject = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (FileUtils.fileExistsAndNotEmpty((String)localObject))
    {
      paramMessageForShortVideo = new StringBuilder();
      paramMessageForShortVideo.append((String)localObject);
      paramMessageForShortVideo.append(" exists");
      a("consumeShortVideoThumb", paramMessageForShortVideo.toString());
      return;
    }
    ShortVideoReq localShortVideoReq = SVBusiUtil.a(2, paramMessageForShortVideo.busiType);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.b);
    localShortVideoDownloadInfo.i = ((String)localObject);
    if (paramMessageForShortVideo.istroop == 0) {
      localShortVideoDownloadInfo.e = 1002;
    } else if (paramMessageForShortVideo.istroop == 3000) {
      localShortVideoDownloadInfo.e = 1006;
    } else if (paramMessageForShortVideo.istroop == 1) {
      localShortVideoDownloadInfo.e = 1004;
    }
    localShortVideoDownloadInfo.f = 2;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if ((((QQMessageFacade)localObject).a()) && (((QQMessageFacade)localObject).a().equals(paramMessageForShortVideo.frienduin))) {
      localShortVideoDownloadInfo.g = 2;
    } else {
      localShortVideoDownloadInfo.g = 1;
    }
    localShortVideoReq.a(localShortVideoDownloadInfo);
    localShortVideoReq.a(paramMessageForShortVideo);
    int i = BasePicPreDownloadUtils.a();
    if ((!((IPicPreDownload)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPicPreDownload.class)).isScreenOn()) && (i != 0))
    {
      paramMessageForShortVideo = new StringBuilder();
      paramMessageForShortVideo.append("screenOFF, no preDownload, networkType: ");
      paramMessageForShortVideo.append(i);
      a("consumeShortVideoThumb", paramMessageForShortVideo.toString());
      this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localShortVideoReq);
      return;
    }
    ThreadManager.post(new ShortVideoPreDownloader.3(this, localShortVideoDownloadInfo, paramMessageForShortVideo, localShortVideoReq), 5, null, false);
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" START uniseq=");
    ((StringBuilder)localObject).append(paramMessageForShortVideo.uniseq);
    ((StringBuilder)localObject).append(", uuid=");
    ((StringBuilder)localObject).append(paramMessageForShortVideo.uuid);
    ((StringBuilder)localObject).append(", priority=");
    ((StringBuilder)localObject).append(paramInt);
    a("handleShortVideo", ((StringBuilder)localObject).toString());
    localObject = SVUtils.a(paramMessageForShortVideo, "mp4");
    if (FileUtils.fileExistsAndNotEmpty((String)localObject))
    {
      paramMessageForShortVideo = new StringBuilder();
      paramMessageForShortVideo.append("Video has already existed, path=");
      paramMessageForShortVideo.append((String)localObject);
      a("handleShortVideo", paramMessageForShortVideo.toString());
      return;
    }
    ShortVideoReq localShortVideoReq = SVBusiUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo, 2);
    if (localShortVideoReq == null) {
      return;
    }
    StringBuilder localStringBuilder = null;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = "";
    int i = ((IPicPreDownload)localQQAppInterface.getRuntimeService(IPicPreDownload.class, "")).calcUinType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo.istroop, paramMessageForShortVideo.frienduin);
    if (paramInt == 5)
    {
      paramMessageForShortVideo = this.jdField_a_of_type_JavaUtilList;
      localShortVideoReq.c = 5;
      if (i != 2)
      {
        if (i != 3) {
          localShortVideoReq.d = 2;
        } else {
          localShortVideoReq.d = 4;
        }
      }
      else {
        localShortVideoReq.d = 3;
      }
      localObject = "AIORequests";
    }
    else
    {
      paramMessageForShortVideo = localStringBuilder;
      if (paramInt == 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            paramMessageForShortVideo = this.d;
            localShortVideoReq.c = 2;
            localShortVideoReq.d = localShortVideoReq.c;
            localObject = "GroupRequests";
          }
          else
          {
            paramMessageForShortVideo = this.jdField_b_of_type_JavaUtilList;
            localShortVideoReq.c = 4;
            localShortVideoReq.d = localShortVideoReq.c;
            localObject = "C2CRequests";
          }
        }
        else
        {
          paramMessageForShortVideo = this.c;
          localShortVideoReq.c = 3;
          localShortVideoReq.d = localShortVideoReq.c;
          localObject = "DiscussionRequests";
        }
      }
    }
    if (paramMessageForShortVideo != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("successfully to add the short video request to ");
      localStringBuilder.append((String)localObject);
      a("handleShortVideo", localStringBuilder.toString());
      paramMessageForShortVideo.add(localShortVideoReq);
      this.jdField_a_of_type_JavaUtilMap.put(localShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(localShortVideoReq.c));
    }
    paramInt = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (paramInt < 1)
    {
      c();
      return;
    }
    paramMessageForShortVideo = new StringBuilder();
    paramMessageForShortVideo.append("mHandlingNum(");
    paramMessageForShortVideo.append(paramInt);
    paramMessageForShortVideo.append(") >= MAX_HANDLING_THREADS(");
    paramMessageForShortVideo.append(1);
    paramMessageForShortVideo.append(")");
    a("handleShortVideo", paramMessageForShortVideo.toString());
  }
  
  public void c()
  {
    a("consumeShortVideo", null);
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      Logger.a("PIC_TAG_PRELOAD", "consume", "!mIsPreDownloaderOpen.get() failed");
      return;
    }
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (i >= 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlingNum(");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(") >= MAX_HANDLING_THREADS(");
      ((StringBuilder)localObject).append(1);
      ((StringBuilder)localObject).append(")");
      a("consumeShortVideo", ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = a();
    if (localObject != null)
    {
      if (((ShortVideoReq)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo == null)
      {
        a("consumeShortVideo", "req.downinfo == null");
        return;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(((ShortVideoReq)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localObject);
      ((ShortVideoReq)localObject).d = ((ShortVideoReq)localObject).c;
      ((ShortVideoReq)localObject).c = 6;
      this.jdField_a_of_type_JavaUtilMap.put(((ShortVideoReq)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(6));
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      ((ShortVideoReq)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack = this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack;
      ThreadManager.post(new ShortVideoPreDownloader.4(this, (ShortVideoReq)localObject), 5, null, false);
    }
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo)
  {
    paramMessageForShortVideo = a(paramMessageForShortVideo.uniseq);
    if (paramMessageForShortVideo != null) {
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessageForShortVideo);
    }
  }
  
  public void d()
  {
    a("consumeAllThumbsInPendingQueue", null);
    int i = BasePicPreDownloadUtils.a();
    if ((!((IPicPreDownload)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPicPreDownload.class)).isScreenOn()) && (i != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("screenOFF, no preDownload, networkType: ");
      localStringBuilder.append(i);
      a("consumeAllThumbsInPendingQueue", localStringBuilder.toString());
      return;
    }
    ThreadManager.post(new ShortVideoPreDownloader.5(this), 5, null, false);
  }
  
  public void onDestroy()
  {
    a("onDestroy", null);
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader
 * JD-Core Version:    0.7.0.1
 */