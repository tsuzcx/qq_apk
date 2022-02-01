package com.tencent.qqmini.flutter;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import com.qflutter.video.IQflutterVideoView;
import com.qflutter.video.IQflutterVideoView.StatusCallBack;
import java.util.Map;

public class FlutterVideoViewContainer
  extends FrameLayout
  implements IQflutterVideoView
{
  private SurfaceFlutterVideoView videoView;
  
  public FlutterVideoViewContainer(@NonNull Context paramContext, Map<String, Object> paramMap)
  {
    super(paramContext);
    this.videoView = new SurfaceFlutterVideoView(paramContext, paramMap);
    addView(this.videoView, -1, -1);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void onStatus(IQflutterVideoView.StatusCallBack paramStatusCallBack)
  {
    this.videoView.onStatus(paramStatusCallBack);
  }
  
  public void operate(Map<String, Object> paramMap)
  {
    this.videoView.operate(paramMap);
  }
  
  public void update(Map<String, Object> paramMap)
  {
    this.videoView.update(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.flutter.FlutterVideoViewContainer
 * JD-Core Version:    0.7.0.1
 */