package com.tencent.mobileqq.kandian.base.video;

import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.Map;

public class VideoPlayUtils
{
  public static int a(int paramInt1, int paramInt2)
  {
    int j = paramInt2 * 1000;
    int i = 10000;
    if (j > 60000)
    {
      if ((paramInt1 <= j - 8000) && (paramInt1 >= 8000)) {
        i = paramInt1 - 8000;
      }
    }
    else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPreviewStartPosi(): forwardPosition=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", videoDuration=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" => previewStartPosi=");
      localStringBuilder.append(i);
      QLog.d("Q.readinjoy.video", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public static int a(ListView paramListView, int paramInt)
  {
    View localView = paramListView.getChildAt(paramInt + paramListView.getHeaderViewsCount() - paramListView.getFirstVisiblePosition());
    if (localView != null) {
      return localView.getBottom() - AIOUtils.b(175.0F, paramListView.getResources());
    }
    return 0;
  }
  
  public static long a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 <= 0) {
      return 0L;
    }
    return paramInt2 * 512 + paramInt1 * paramInt3 / paramInt2;
  }
  
  public static String a()
  {
    return "";
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " PLAY_STATE_UNKNOW ";
    case 8: 
      return "PLAY_STATE_DESTORY";
    case 7: 
      return " PLAY_STATE_COMPLETE ";
    case 6: 
      return " PLAY_STATE_ERROR ";
    case 5: 
      return " PLAY_STATE_PAUSED ";
    case 4: 
      return " PLAY_STATE_BUFFERING ";
    case 3: 
      return " PLAY_STATE_PLAYING ";
    case 2: 
      return " PLAY_STATE_PREPARED ";
    case 1: 
      return " PLAY_STATE_PREPARING ";
    }
    return " PLAY_STATE_IDLE ";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 123)
    {
      if (paramInt2 == 103)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131716079));
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("-");
        localStringBuilder.append(paramInt2);
        return localStringBuilder.toString();
      }
      if (paramInt2 == 108)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131718106));
        localStringBuilder.append(": ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("-");
        localStringBuilder.append(paramInt2);
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131716093));
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      return localStringBuilder.toString();
    }
    if (paramInt1 == 122)
    {
      if (paramInt2 == 204)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131716089));
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("-");
        localStringBuilder.append(paramInt2);
        return localStringBuilder.toString();
      }
      if (paramInt2 == 202)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131716082));
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("-");
        localStringBuilder.append(paramInt2);
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131716069));
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      return localStringBuilder.toString();
    }
    if (paramInt1 == 101)
    {
      if (paramInt2 == 80)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131716081));
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("-");
        localStringBuilder.append(paramInt2);
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131716071));
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131716077));
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  public static Map<String, String> a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    HashMap localHashMap = new HashMap();
    if (paramVideoPlayerWrapper != null)
    {
      localHashMap.put("param_url", paramVideoPlayerWrapper.b());
      localHashMap.put("param_bitrate", String.valueOf(paramVideoPlayerWrapper.a));
      localHashMap.put("param_duration", String.valueOf(paramVideoPlayerWrapper.b()));
      localHashMap.put("param_file_size", String.valueOf(paramVideoPlayerWrapper.d()));
      localHashMap.put("param_is265", String.valueOf(paramVideoPlayerWrapper.b));
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.VideoPlayUtils
 * JD-Core Version:    0.7.0.1
 */