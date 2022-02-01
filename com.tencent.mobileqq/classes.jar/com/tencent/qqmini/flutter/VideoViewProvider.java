package com.tencent.qqmini.flutter;

import android.content.Context;
import android.view.Surface;
import android.view.View;
import com.qflutter.video.QflutterVideoViewSource.Provider;
import com.tencent.qqmini.flutter.core.page.tissue.TissuePageContainer;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Map;

public class VideoViewProvider
  implements QflutterVideoViewSource.Provider
{
  public View getView(Context paramContext, int paramInt, Surface paramSurface, Map<String, Object> paramMap)
  {
    if ("getView" + paramMap != null) {}
    for (paramContext = paramMap.toString();; paramContext = "")
    {
      QMLog.e("QFVideoView", paramContext);
      paramMap.get("videoPlayerId");
      paramMap.put("autoplay", Boolean.valueOf(true));
      return new FlutterVideoViewContainer(TissuePageContainer.activity, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.VideoViewProvider
 * JD-Core Version:    0.7.0.1
 */