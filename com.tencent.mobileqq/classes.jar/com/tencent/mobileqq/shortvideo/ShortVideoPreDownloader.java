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
  public static long b = 86400000L;
  QQAppInterface a;
  public Map<String, Integer> c = Collections.synchronizedMap(new HashMap());
  List<ShortVideoReq> d = Collections.synchronizedList(new LinkedList());
  List<ShortVideoReq> e = Collections.synchronizedList(new LinkedList());
  List<ShortVideoReq> f = Collections.synchronizedList(new LinkedList());
  List<ShortVideoReq> g = Collections.synchronizedList(new LinkedList());
  UiCallBack h;
  AtomicBoolean i = new AtomicBoolean(true);
  public AtomicInteger j = new AtomicInteger(0);
  PriorityBlockingQueue<ShortVideoReq> k = new PriorityBlockingQueue();
  public PriorityBlockingQueue<ShortVideoReq> l = new PriorityBlockingQueue();
  public AtomicInteger m = new AtomicInteger();
  Handler n = null;
  Runnable o = new ShortVideoPreDownloader.2(this);
  
  public ShortVideoPreDownloader(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.h = new ShortVideoPreDownloader.1(this);
  }
  
  private String a(long paramLong, List<ShortVideoReq> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ShortVideoReq localShortVideoReq = (ShortVideoReq)paramList.next();
      if ((localShortVideoReq.j != null) && (localShortVideoReq.j.uniseq == paramLong))
      {
        this.d.remove(localShortVideoReq);
        return localShortVideoReq.c;
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
    int i1 = ((IPicPreDownload)paramQQAppInterface.getRuntimeService(IPicPreDownload.class, "")).calcUinType(paramQQAppInterface, paramMessageForShortVideo.istroop, paramMessageForShortVideo.frienduin);
    if ((i1 == 0) || (i1 == 1))
    {
      int i2 = paramQQAppInterface.getTroopMask(paramMessageForShortVideo.frienduin);
      if ((i2 == 2) || (i2 == 3)) {
        break label114;
      }
      if (i2 == 4) {
        return false;
      }
    }
    if (i1 == 2)
    {
      DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      if (localDiscussionManager != null)
      {
        paramQQAppInterface = localDiscussionManager.b(paramMessageForShortVideo.frienduin, paramQQAppInterface.getCurrentAccountUin());
        if ((paramQQAppInterface != null) && ((paramQQAppInterface.flag & 0x1) != 0)) {
          return false;
        }
      }
    }
    return true;
    label114:
    return false;
  }
  
  protected String a(long paramLong)
  {
    String str = a(paramLong, this.d);
    if (str != null) {
      return str;
    }
    str = a(paramLong, this.f);
    if (str != null) {
      return str;
    }
    str = a(paramLong, this.g);
    if (str != null) {
      return str;
    }
    str = a(paramLong, this.e);
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
        if (paramInt != 5)
        {
          if (paramInt != 6)
          {
            if (paramInt != 7) {
              return null;
            }
            return this.l;
          }
          return this.d;
        }
        return this.e;
      }
      return this.f;
    }
    return this.g;
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mIsPreDownloaderOpen=");
    ((StringBuilder)localObject).append(this.i.get());
    a("off", ((StringBuilder)localObject).toString());
    this.i.set(false);
    localObject = this.n;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(this.o);
    } else {
      this.n = new Handler(ThreadManager.getSubThreadLooper());
    }
    this.n.postDelayed(this.o, 60000L);
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
    if ((!bool) && (b(paramMessageForShortVideo))) {
      c(paramMessageForShortVideo);
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
    if (c(paramMessageForShortVideo, paramInt))
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
      localObject = MultiMsgManager.a().d();
      if (localObject != null)
      {
        i1 = ((SessionInfo)localObject).a;
        localObject = ((SessionInfo)localObject).b;
      }
      else
      {
        i1 = paramMessageForShortVideo.istroop;
        localObject = paramMessageForShortVideo.frienduin;
      }
    }
    else
    {
      i1 = paramMessageForShortVideo.istroop;
      localObject = paramMessageForShortVideo.frienduin;
    }
    int i1 = BasePicPreDownloadUtils.a();
    int i2 = this.a.getTroopMask((String)localObject);
    if ((i1 != 0) && (i2 == 2))
    {
      a("add", "MSG_FILTER_NUM, no need to pre download short video");
      return;
    }
    b(paramMessageForShortVideo, paramInt);
  }
  
  protected void a(ShortVideoReq paramShortVideoReq)
  {
    ShortVideoBusiManager.a(paramShortVideoReq, this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("launchRequest:");
      localStringBuilder.append(paramShortVideoReq.j.busiType);
      QLog.d("ShortVideoPreDownloader", 2, localStringBuilder.toString());
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
      localAtomicInteger = this.j;
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
    int i1;
    if ((paramMessageForShortVideo.istroop == 0) && (paramMessageForShortVideo.msgtype == -2071)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i1 == 0) && (System.currentTimeMillis() - paramMessageForShortVideo.time * 1000L > b))
    {
      a("isNeedPredownload", "out of validity, no need to pre download");
      return false;
    }
    int i2 = BasePicPreDownloadUtils.a();
    if (i1 != 0)
    {
      if ((i2 != 0) && (i2 != 1))
      {
        paramMessageForShortVideo = new StringBuilder();
        paramMessageForShortVideo.append("Not Wifi or 4G, networkType=");
        paramMessageForShortVideo.append(i2);
        paramMessageForShortVideo.append(", no need to predownload for lightvideo");
        a("isNeedPredownload", paramMessageForShortVideo.toString());
        return false;
      }
    }
    else if (i2 != 0)
    {
      paramMessageForShortVideo = new StringBuilder();
      paramMessageForShortVideo.append("Not Wifi, networkType=");
      paramMessageForShortVideo.append(i2);
      paramMessageForShortVideo.append(", no need to predownload");
      a("isNeedPredownload", paramMessageForShortVideo.toString());
      return false;
    }
    return a(this.a, paramMessageForShortVideo);
  }
  
  public void b()
  {
    this.i.set(true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShortVideoPreDownloader is on, mIsPreDownloaderOpen=");
    localStringBuilder.append(this.i.get());
    a("on", localStringBuilder.toString());
    c();
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
    ShortVideoReq localShortVideoReq = SVBusiUtil.a(this.a, paramMessageForShortVideo, 2);
    if (localShortVideoReq == null) {
      return;
    }
    StringBuilder localStringBuilder = null;
    QQAppInterface localQQAppInterface = this.a;
    localObject = "";
    int i1 = ((IPicPreDownload)localQQAppInterface.getRuntimeService(IPicPreDownload.class, "")).calcUinType(this.a, paramMessageForShortVideo.istroop, paramMessageForShortVideo.frienduin);
    if (paramInt == 6)
    {
      paramMessageForShortVideo = this.d;
      localShortVideoReq.k = 6;
      if (i1 != 2)
      {
        if (i1 != 3) {
          localShortVideoReq.l = 2;
        } else {
          localShortVideoReq.l = 5;
        }
      }
      else {
        localShortVideoReq.l = 3;
      }
      localObject = "AIORequests";
    }
    else
    {
      paramMessageForShortVideo = localStringBuilder;
      if (paramInt == 1) {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            paramMessageForShortVideo = this.g;
            localShortVideoReq.k = 2;
            localShortVideoReq.l = localShortVideoReq.k;
            localObject = "GroupRequests";
          }
          else
          {
            paramMessageForShortVideo = this.e;
            localShortVideoReq.k = 5;
            localShortVideoReq.l = localShortVideoReq.k;
            localObject = "C2CRequests";
          }
        }
        else
        {
          paramMessageForShortVideo = this.f;
          localShortVideoReq.k = 3;
          localShortVideoReq.l = localShortVideoReq.k;
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
      this.c.put(localShortVideoReq.e.a, Integer.valueOf(localShortVideoReq.k));
    }
    paramInt = this.m.get();
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
  
  public boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    int i1 = paramMessageForShortVideo.videoFileStatus;
    boolean bool1 = false;
    if (i1 == 5002)
    {
      a("isNeedPredownloadThumb", "short video has expired");
      return false;
    }
    if (System.currentTimeMillis() - paramMessageForShortVideo.time * 1000L > b)
    {
      a("isNeedPredownloadThumb", "out of validity, no need to pre download");
      return false;
    }
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131892713), "qqsetting_auto_receive_pic_key", true);
    if ((NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) && (!bool2)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if ((((IPicPreDownload)this.a.getRuntimeService(IPicPreDownload.class)).getPreDownSwitch()) || (i1 != 0)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void c()
  {
    a("consumeShortVideo", null);
    if (!this.i.get())
    {
      Logger.a("PIC_TAG_PRELOAD", "consume", "!mIsPreDownloaderOpen.get() failed");
      return;
    }
    int i1 = this.m.get();
    if (i1 >= 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlingNum(");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(") >= MAX_HANDLING_THREADS(");
      ((StringBuilder)localObject).append(1);
      ((StringBuilder)localObject).append(")");
      a("consumeShortVideo", ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = e();
    if (localObject != null)
    {
      if (((ShortVideoReq)localObject).e == null)
      {
        a("consumeShortVideo", "req.downinfo == null");
        return;
      }
      this.c.remove(((ShortVideoReq)localObject).e.a);
      this.l.add(localObject);
      ((ShortVideoReq)localObject).l = ((ShortVideoReq)localObject).k;
      ((ShortVideoReq)localObject).k = 7;
      this.c.put(((ShortVideoReq)localObject).e.a, Integer.valueOf(7));
      this.m.addAndGet(1);
      ((ShortVideoReq)localObject).i = this.h;
      ThreadManager.post(new ShortVideoPreDownloader.4(this, (ShortVideoReq)localObject), 5, null, false);
    }
  }
  
  void c(MessageForShortVideo paramMessageForShortVideo)
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
    localShortVideoDownloadInfo.p = ((String)localObject);
    if (paramMessageForShortVideo.istroop == 0) {
      localShortVideoDownloadInfo.q = 1002;
    } else if (paramMessageForShortVideo.istroop == 3000) {
      localShortVideoDownloadInfo.q = 1006;
    } else if (paramMessageForShortVideo.istroop == 1) {
      localShortVideoDownloadInfo.q = 1004;
    } else if (paramMessageForShortVideo.istroop == 10014) {
      localShortVideoDownloadInfo.q = 1008;
    }
    localShortVideoDownloadInfo.r = 2;
    localObject = this.a.getMessageFacade();
    if ((((QQMessageFacade)localObject).n()) && (((QQMessageFacade)localObject).l().equals(paramMessageForShortVideo.frienduin))) {
      localShortVideoDownloadInfo.s = 2;
    } else {
      localShortVideoDownloadInfo.s = 1;
    }
    localShortVideoReq.a(localShortVideoDownloadInfo);
    localShortVideoReq.a(paramMessageForShortVideo);
    int i1 = BasePicPreDownloadUtils.a();
    if ((!((IPicPreDownload)this.a.getRuntimeService(IPicPreDownload.class)).isScreenOn()) && (i1 != 0))
    {
      paramMessageForShortVideo = new StringBuilder();
      paramMessageForShortVideo.append("screenOFF, no preDownload, networkType: ");
      paramMessageForShortVideo.append(i1);
      a("consumeShortVideoThumb", paramMessageForShortVideo.toString());
      this.k.add(localShortVideoReq);
      return;
    }
    ThreadManager.post(new ShortVideoPreDownloader.3(this, localShortVideoDownloadInfo, paramMessageForShortVideo, localShortVideoReq), 5, null, false);
  }
  
  boolean c(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("uuid=");
    ((StringBuilder)localObject1).append(paramMessageForShortVideo.uuid);
    ((StringBuilder)localObject1).append(" uniseq=");
    ((StringBuilder)localObject1).append(paramMessageForShortVideo.uniseq);
    ((StringBuilder)localObject1).append(" priority=");
    ((StringBuilder)localObject1).append(paramInt);
    a("filter", ((StringBuilder)localObject1).toString());
    Integer localInteger = (Integer)this.c.get(paramMessageForShortVideo.uuid);
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
        if (((ShortVideoReq)localObject2).e.g == paramMessageForShortVideo.uniseq)
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
          ((ShortVideoReq)localObject1).l = ((ShortVideoReq)localObject1).k;
          ((ShortVideoReq)localObject1).k = paramInt;
          localCollection.remove(localObject1);
          ((Collection)localObject2).add(localObject1);
          this.c.put(paramMessageForShortVideo.uuid, Integer.valueOf(paramInt));
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
  
  public void d()
  {
    a("consumeAllThumbsInPendingQueue", null);
    int i1 = BasePicPreDownloadUtils.a();
    if ((!((IPicPreDownload)this.a.getRuntimeService(IPicPreDownload.class)).isScreenOn()) && (i1 != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("screenOFF, no preDownload, networkType: ");
      localStringBuilder.append(i1);
      a("consumeAllThumbsInPendingQueue", localStringBuilder.toString());
      return;
    }
    ThreadManager.post(new ShortVideoPreDownloader.5(this), 5, null, false);
  }
  
  public void d(MessageForShortVideo paramMessageForShortVideo)
  {
    paramMessageForShortVideo = a(paramMessageForShortVideo.uniseq);
    if (paramMessageForShortVideo != null) {
      this.c.remove(paramMessageForShortVideo);
    }
  }
  
  ShortVideoReq e()
  {
    synchronized (this.d)
    {
      int i1 = this.d.size();
      Object localObject1;
      if (i1 > 0)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        localObject1 = this.d;
        i1 -= 1;
        localObject1 = (ShortVideoReq)((List)localObject1).get(i1);
        this.d.remove(i1);
        return localObject1;
      }
      synchronized (this.e)
      {
        i1 = this.e.size();
        if (i1 > 0)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          localObject1 = this.e;
          i1 -= 1;
          localObject1 = (ShortVideoReq)((List)localObject1).get(i1);
          this.e.remove(i1);
          return localObject1;
        }
        synchronized (this.f)
        {
          i1 = this.f.size();
          if (i1 > 0)
          {
            a("getShortVideoRequest", "get a short video request from DiscussionRequests");
            localObject1 = this.f;
            i1 -= 1;
            localObject1 = (ShortVideoReq)((List)localObject1).get(i1);
            this.f.remove(i1);
            return localObject1;
          }
          synchronized (this.g)
          {
            i1 = this.g.size();
            if (i1 > 0)
            {
              a("getShortVideoRequest", "get a short video request from GroupRequests");
              localObject1 = this.g;
              i1 -= 1;
              localObject1 = (ShortVideoReq)((List)localObject1).get(i1);
              this.g.remove(i1);
              return localObject1;
            }
            a("getShortVideoRequest", "cannot get any request");
            return null;
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    a("onDestroy", null);
    Handler localHandler = this.n;
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.o);
      this.n = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader
 * JD-Core Version:    0.7.0.1
 */