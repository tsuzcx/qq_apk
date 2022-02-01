package com.tencent.mobileqq.flashshow.preload.coldboot;

import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.flashshow.api.IFlashShowRedPointService;
import com.tencent.mobileqq.flashshow.api.data.FSRedPointData;
import com.tencent.mobileqq.flashshow.api.events.FSRedPointUpdateEvent;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.mobileqq.flashshow.preload.FSVideoPreloadHelper;
import com.tencent.mobileqq.flashshow.request.feed.FSPreloadFeedRequest;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;

public class FSColdBootPreloadFeedManager
  implements SimpleEventReceiver
{
  private static final String TAG = "FSColdBootPreloadFeedManager";
  private static volatile FSColdBootPreloadFeedManager sInstance;
  private boolean mActivate;
  private String mAttachInfo;
  private volatile long mExpireTimeStamp = 0L;
  private boolean mIsLocked;
  private final FSVideoPreloadHelper mPreloadHelper = new FSVideoPreloadHelper(RFApplication.getApplication().hashCode());
  private FeedCloudMeta.StFeed mPreloadVideoFeed;
  private FSColdBootPreloadFeedManager.RedPointParam mRedPointParam = null;
  private FeedCloudRead.StGetFeedListRsp mRsp;
  
  private FSColdBootPreloadFeedManager()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void destroy()
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public static void doActivate()
  {
    getInstance().activate();
  }
  
  public static String doGetAttachInfo()
  {
    return getInstance().getAttachInfo();
  }
  
  public static boolean doGetIsAvailable()
  {
    return getInstance().isAvailable();
  }
  
  public static byte[] doGetPreloadRspData()
  {
    return getInstance().getRspData();
  }
  
  public static void doInactivate()
  {
    getInstance().inactivate();
  }
  
  public static void doInit()
  {
    getInstance();
  }
  
  public static void doPreload()
  {
    getInstance().preloadFeed();
  }
  
  private void doPreloadImage()
  {
    if (this.mPreloadVideoFeed == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doPreloadImage url:");
    ((StringBuilder)localObject).append(this.mPreloadVideoFeed.cover.picUrl.get());
    QLog.d("FSColdBootPreloadFeedManager", 1, ((StringBuilder)localObject).toString());
    localObject = new Option().setUrl(this.mPreloadVideoFeed.cover.picUrl.get());
    QCircleFeedPicLoader.g().loadImage((Option)localObject, null);
  }
  
  private void doPreloadVideo()
  {
    if (this.mPreloadVideoFeed == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doPreloadVideo url:");
    localStringBuilder.append(this.mPreloadVideoFeed.video.playUrl.get());
    QLog.d("FSColdBootPreloadFeedManager", 1, localStringBuilder.toString());
    this.mPreloadHelper.a(this.mPreloadVideoFeed);
  }
  
  public static void doUnlock()
  {
    getInstance().unlock();
  }
  
  public static FSColdBootPreloadFeedManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new FSColdBootPreloadFeedManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void handlePreloadFeedResponse(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedListRsp != null))
    {
      paramString = paramStGetFeedListRsp.vecFeed.get();
      if (paramString.size() > 0)
      {
        this.mPreloadVideoFeed = ((FeedCloudMeta.StFeed)paramString.get(0));
        this.mAttachInfo = paramStGetFeedListRsp.feedAttchInfo.get();
        this.mRsp = paramStGetFeedListRsp;
        parseExpireTimeStamp(paramStGetFeedListRsp);
        doPreloadImage();
        doPreloadVideo();
        return;
      }
      QLog.e("FSColdBootPreloadFeedManager", 1, "handlePreloadFeedResponse invalid data,reset");
      reset();
      return;
    }
    QLog.e("FSColdBootPreloadFeedManager", 1, new Object[] { "handlePreloadFeedResponse isSuc:", Boolean.valueOf(paramBoolean), ",retCode:", Long.valueOf(paramLong), ",errMsg:", paramString });
    reset();
  }
  
  private boolean hasPreloadData()
  {
    return (!isDataExpired()) && (!isDataConsumed());
  }
  
  private boolean isDataConsumed()
  {
    return this.mRsp == null;
  }
  
  private boolean isDataExpired()
  {
    return System.currentTimeMillis() > this.mExpireTimeStamp;
  }
  
  private void parseExpireTimeStamp(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    FSThreadUtils.d(new FSColdBootPreloadFeedManager.2(this, paramStGetFeedListRsp));
  }
  
  public static void releaseInstance()
  {
    if (sInstance != null) {
      try
      {
        if (sInstance != null)
        {
          sInstance.destroy();
          sInstance = null;
        }
        return;
      }
      finally {}
    }
  }
  
  private void reset()
  {
    this.mPreloadVideoFeed = null;
    this.mAttachInfo = null;
    this.mExpireTimeStamp = 0L;
    this.mRsp = null;
    this.mRedPointParam = null;
  }
  
  private void unlock()
  {
    this.mIsLocked = false;
  }
  
  public void activate()
  {
    this.mActivate = true;
  }
  
  public String getAttachInfo()
  {
    return this.mAttachInfo;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSRedPointUpdateEvent.class);
    return localArrayList;
  }
  
  public byte[] getRspData()
  {
    FeedCloudRead.StGetFeedListRsp localStGetFeedListRsp = this.mRsp;
    if (localStGetFeedListRsp != null) {
      return localStGetFeedListRsp.toByteArray();
    }
    return null;
  }
  
  public void inactivate()
  {
    this.mActivate = false;
    this.mIsLocked = true;
    reset();
  }
  
  public boolean isAvailable()
  {
    return (this.mActivate) && (hasPreloadData());
  }
  
  public boolean isLocked()
  {
    return this.mIsLocked;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof FSRedPointUpdateEvent)) && (((FSRedPointUpdateEvent)paramSimpleBaseEvent).mShowRedPoint)) {
      parseRedPointData(((IFlashShowRedPointService)QRoute.api(IFlashShowRedPointService.class)).getBottomRedPointInfo());
    }
  }
  
  public void parseRedPointData(FSRedPointData paramFSRedPointData)
  {
    if (paramFSRedPointData != null)
    {
      if (!paramFSRedPointData.hasRedPointInfo()) {
        return;
      }
      paramFSRedPointData = FSColdBootPreloadFeedManager.RedPointParam.a(paramFSRedPointData.getDisplayInfoJumpLink());
      FSColdBootPreloadFeedManager.RedPointParam localRedPointParam = this.mRedPointParam;
      if ((localRedPointParam == null) || (!localRedPointParam.equals(paramFSRedPointData)))
      {
        reset();
        this.mRedPointParam = paramFSRedPointData;
        preloadFeed();
        QLog.d("FSColdBootPreloadFeedManager", 1, "preloadFeed when receive red point data");
      }
    }
  }
  
  public void preloadFeed()
  {
    if (!FSConfig.r())
    {
      QLog.w("FSColdBootPreloadFeedManager", 1, "preload switch is close,direct return");
      return;
    }
    if (isLocked())
    {
      QLog.e("FSColdBootPreloadFeedManager", 1, "preload data is locked in use ,diretc return");
      return;
    }
    if (hasPreloadData())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("last preload video data remain,mExpireTimeStamp:");
      ((StringBuilder)localObject).append(this.mExpireTimeStamp);
      QLog.e("FSColdBootPreloadFeedManager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    VSNetworkHelper localVSNetworkHelper = VSNetworkHelper.getInstance();
    String str = this.mAttachInfo;
    Object localObject = this.mRedPointParam;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((FSColdBootPreloadFeedManager.RedPointParam)localObject).c;
    }
    localVSNetworkHelper.sendRequest(new FSPreloadFeedRequest(str, (String)localObject), new FSColdBootPreloadFeedManager.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.preload.coldboot.FSColdBootPreloadFeedManager
 * JD-Core Version:    0.7.0.1
 */