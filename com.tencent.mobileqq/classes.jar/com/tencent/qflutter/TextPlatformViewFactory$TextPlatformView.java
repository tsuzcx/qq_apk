package com.tencent.qflutter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import io.flutter.plugin.platform.PlatformView;

class TextPlatformViewFactory$TextPlatformView
  implements PlatformView
{
  private TextView platformTv;
  
  public TextPlatformViewFactory$TextPlatformView(Context paramContext)
  {
    this.platformTv = new TextView(paramContext);
    this.platformTv.setText("PlatformView Demo");
  }
  
  public void dispose() {}
  
  public View getView()
  {
    return this.platformTv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qflutter.TextPlatformViewFactory.TextPlatformView
 * JD-Core Version:    0.7.0.1
 */