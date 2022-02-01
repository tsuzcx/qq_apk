package com.tencent.mobileqq.kandian.glue.video.report;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity.Builder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class VideoDTReport
{
  private static Map<Integer, VideoEntity> a = new HashMap();
  
  public static void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper != null)
    {
      VideoReport.unbindVideoPlayerInfo(paramVideoPlayerWrapper);
      a.remove(paramVideoPlayerWrapper);
    }
  }
  
  public static void a(VideoPlayerWrapper paramVideoPlayerWrapper, String paramString)
  {
    if (paramVideoPlayerWrapper != null)
    {
      VideoEntity localVideoEntity = (VideoEntity)a.get(Integer.valueOf(paramVideoPlayerWrapper.hashCode()));
      if (localVideoEntity != null)
      {
        localVideoEntity.getVideoCustomParams().put("backend_info", d(paramString));
        localVideoEntity.getVideoCustomParams().put("is_short", Integer.valueOf(c(paramString)));
        VideoReport.updateVideoPlayerInfo(paramVideoPlayerWrapper, localVideoEntity);
      }
    }
  }
  
  public static void a(IPlayer paramIPlayer)
  {
    if (paramIPlayer != null)
    {
      VideoReport.unbindVideoPlayerInfo(paramIPlayer);
      a.remove(paramIPlayer);
    }
  }
  
  public static void a(Object paramObject, VideoPlayerWrapper paramVideoPlayerWrapper, VideoDTReport.Builder paramBuilder)
  {
    if (paramVideoPlayerWrapper != null)
    {
      paramVideoPlayerWrapper.a(VideoDTReport.Builder.a(paramBuilder));
      a(paramObject, paramVideoPlayerWrapper, paramBuilder);
    }
  }
  
  public static void a(Object paramObject, IPlayer paramIPlayer, VideoDTReport.Builder paramBuilder)
  {
    if (paramIPlayer != null)
    {
      paramIPlayer.a(VideoDTReport.Builder.a(paramBuilder));
      a(paramObject, paramIPlayer, paramBuilder);
    }
  }
  
  private static void a(Object paramObject1, Object paramObject2, VideoDTReport.Builder paramBuilder)
  {
    paramObject1 = new VideoEntity.Builder().setContentId(VideoDTReport.Builder.a(paramBuilder)).setPage(paramObject1);
    int i = VideoDTReport.Builder.d(paramBuilder);
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    paramObject1 = paramObject1.ignoreReport(bool).setContentType(VideoDTReport.Builder.d(paramBuilder)).setVideoDuration((int)VideoDTReport.Builder.c(paramBuilder)).addCustomParams(paramBuilder.a()).bizReady(VideoDTReport.Builder.b(paramBuilder)).setIdentifier(VideoDTReport.Builder.a(paramBuilder)).build();
    a.put(Integer.valueOf(paramObject2.hashCode()), paramObject1);
    VideoReport.bindVideoPlayerInfo(paramObject2, paramObject1);
  }
  
  private static int c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("short_v");
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private static String d(String paramString)
  {
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.report.VideoDTReport
 * JD-Core Version:    0.7.0.1
 */