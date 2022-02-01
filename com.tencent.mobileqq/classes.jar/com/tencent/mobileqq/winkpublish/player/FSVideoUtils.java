package com.tencent.mobileqq.winkpublish.player;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.winkpublish.base.PublishBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudMeta.StVideoUrl;
import java.io.File;
import java.util.List;

public class FSVideoUtils
{
  private static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HostUIHelper.getInstance().getHostApplicationContext().getExternalCacheDir());
    localStringBuilder.append("/superplayer/170303102");
    a = localStringBuilder.toString();
  }
  
  public static SuperPlayerVideoInfo a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString2 == null)) {
      return SuperPlayerFactory.createVideoInfoForTVideo(30301, paramString1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = c(paramString2, paramString1);
      QLog.i("QCircleVideoUtils", 1, String.format("createSuperVideoInfo fileId:%s, url:%s", new Object[] { paramString1, paramString2 }));
      return SuperPlayerFactory.createVideoInfoForUrl(paramString2, 101, paramString1, "");
    }
    return null;
  }
  
  public static String a(FeedCloudMeta.StVideo paramStVideo)
  {
    if (b(paramStVideo.playUrl.get(), paramStVideo.fileId.get()))
    {
      QLog.i("QCircleVideoUtils", 1, "stop selectUrlByDownloadSpeed because of hit cache");
      return paramStVideo.playUrl.get();
    }
    long l = PublishBaseFragment.a.getCurrentPrediction();
    QLog.i("QCircleVideoUtils", 1, String.format("selectUrlByDownloadSpeed start, predictDownloadSpeed:%d", new Object[] { Long.valueOf(l) }));
    if (l < 500L)
    {
      FeedCloudMeta.StVideoUrl localStVideoUrl = FSExchangeHelper.a(paramStVideo.vecVideoUrl.get());
      if ((localStVideoUrl != null) && (!TextUtils.isEmpty(localStVideoUrl.playUrl.get())))
      {
        paramStVideo = new StringBuilder();
        paramStVideo.append("selectUrlByDownloadSpeed hit, url:");
        paramStVideo.append(localStVideoUrl.playUrl.get());
        QLog.i("QCircleVideoUtils", 1, paramStVideo.toString());
        return localStVideoUrl.playUrl.get();
      }
      QLog.i("QCircleVideoUtils", 1, "selectUrlByDownloadSpeed target url is null or empty");
    }
    QLog.i("QCircleVideoUtils", 1, "selectUrlByDownloadSpeed use original video url");
    return paramStVideo.playUrl.get();
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(String.format("/%s.mp4", new Object[] { c(paramString1, paramString2) }));
    return new File(localStringBuilder.toString()).exists();
  }
  
  private static String c(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)Uri.parse(paramString1).getPathSegments().get(0);
      if (paramString1.contains(".mp4"))
      {
        paramString1 = paramString1.substring(0, paramString1.indexOf(".mp4"));
        return paramString1;
      }
      return paramString2;
    }
    catch (Exception paramString1) {}
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.FSVideoUtils
 * JD-Core Version:    0.7.0.1
 */