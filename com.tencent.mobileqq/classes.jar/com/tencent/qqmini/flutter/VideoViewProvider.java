package com.tencent.qqmini.flutter;

import android.content.Context;
import android.view.Surface;
import android.view.View;
import com.qflutter.video.QflutterVideoViewSource.Provider;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Map;

public class VideoViewProvider
  implements QflutterVideoViewSource.Provider
{
  public View getView(Context paramContext, int paramInt, Surface paramSurface, Map<String, Object> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getView");
    if (paramMap != null) {
      paramSurface = paramMap.toString();
    } else {
      paramSurface = "";
    }
    localStringBuilder.append(paramSurface);
    QMLog.e("QFVideoView", localStringBuilder.toString());
    paramMap.put("autoplay", Boolean.valueOf(true));
    return new FlutterVideoViewContainer(paramContext, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.flutter.VideoViewProvider
 * JD-Core Version:    0.7.0.1
 */