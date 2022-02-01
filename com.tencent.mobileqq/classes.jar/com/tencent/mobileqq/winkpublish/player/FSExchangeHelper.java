package com.tencent.mobileqq.winkpublish.player;

import android.net.Uri;
import android.util.LruCache;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.winkpublish.fs.request.FSUrlAdapterRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudMeta.StVideoUrl;
import java.util.Iterator;
import java.util.List;

public class FSExchangeHelper
{
  private static final FSExchangeHelper a = new FSExchangeHelper();
  private final LruCache<String, FeedCloudMeta.StVideo> b = new LruCache(100);
  private long c = 300000L;
  
  public static FSExchangeHelper a()
  {
    return a;
  }
  
  public static FeedCloudMeta.StVideoUrl a(List<FeedCloudMeta.StVideoUrl> paramList)
  {
    int i;
    if (!"0".equals(FSPlayer.a)) {
      i = 16;
    } else {
      i = 10;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FeedCloudMeta.StVideoUrl localStVideoUrl = (FeedCloudMeta.StVideoUrl)localIterator.next();
        if (localStVideoUrl.levelType.get() == i)
        {
          QLog.i("BaseVideoView_QCircleVideoUrlExchangeHelper", 1, String.format("getTargetLevelTypeUrl urls size:%d, targetLevelType:%d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(i) }));
          return localStVideoUrl;
        }
      }
    }
    QLog.i("BaseVideoView_QCircleVideoUrlExchangeHelper", 1, "getTargetLevelTypeUrl urls size 0");
    return null;
  }
  
  public void a(int paramInt, FeedCloudMeta.StVideo paramStVideo, FSExchangeHelper.VideoUrlAdapterCallBack paramVideoUrlAdapterCallBack)
  {
    if (paramStVideo != null)
    {
      if (paramVideoUrlAdapterCallBack == null) {
        return;
      }
      if (!a(paramStVideo))
      {
        QLog.i("BaseVideoView_QCircleVideoUrlExchangeHelper", 1, String.format("exchangeVideoUrl: valid callBack fileId:%s ,videoExchange url:%s", new Object[] { paramStVideo.fileId.get(), paramStVideo.playUrl.get() }));
        paramVideoUrlAdapterCallBack.a(paramStVideo, true);
        return;
      }
      Object localObject = (FeedCloudMeta.StVideo)this.b.get(paramStVideo.fileId.get());
      if ((localObject != null) && (((FeedCloudMeta.StVideo)localObject).playUrl.get().trim().length() > 0))
      {
        QLog.i("BaseVideoView_QCircleVideoUrlExchangeHelper", 1, String.format("exchangeVideoUrl: success hit Video Cache fileId:%s ,videoExchange url %s:", new Object[] { ((FeedCloudMeta.StVideo)localObject).fileId.get(), ((FeedCloudMeta.StVideo)localObject).playUrl.get() }));
        paramVideoUrlAdapterCallBack.a((FeedCloudMeta.StVideo)localObject, false);
        return;
      }
      localObject = new FSUrlAdapterRequest(paramStVideo);
      VSNetworkHelper.getInstance().sendRequest(paramInt, (BaseRequest)localObject, new FSExchangeHelper.1(this, paramStVideo, paramVideoUrlAdapterCallBack));
    }
  }
  
  public boolean a(FeedCloudMeta.StVideo paramStVideo)
  {
    if (paramStVideo == null) {
      return false;
    }
    try
    {
      paramStVideo = Uri.parse(paramStVideo.playUrl.get());
      if (paramStVideo.getQueryParameter("dis_t") != null)
      {
        long l2 = Long.valueOf(paramStVideo.getQueryParameter("dis_t")).longValue() * 1000L;
        long l1 = System.currentTimeMillis() - l2;
        QLog.d("BaseVideoView_QCircleVideoUrlExchangeHelper", 2, String.format("intervalTime:%d, disTime: %d, valid time:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(21600000L) }));
        l2 = this.c;
        if (l1 > 21600000L - l2) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramStVideo)
    {
      paramStVideo.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.FSExchangeHelper
 * JD-Core Version:    0.7.0.1
 */