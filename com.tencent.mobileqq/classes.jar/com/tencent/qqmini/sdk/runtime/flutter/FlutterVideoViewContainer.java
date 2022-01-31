package com.tencent.qqmini.sdk.runtime.flutter;

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
  private SurfaceFlutterVideoView a;
  
  public FlutterVideoViewContainer(@NonNull Context paramContext, Map<String, Object> paramMap)
  {
    super(paramContext);
    this.a = new SurfaceFlutterVideoView(paramContext, paramMap);
    addView(this.a, -1, -1);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void onStatus(IQflutterVideoView.StatusCallBack paramStatusCallBack)
  {
    this.a.onStatus(paramStatusCallBack);
  }
  
  public void operate(Map<String, Object> paramMap)
  {
    this.a.operate(paramMap);
  }
  
  public void update(Map<String, Object> paramMap)
  {
    this.a.update(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.flutter.FlutterVideoViewContainer
 * JD-Core Version:    0.7.0.1
 */