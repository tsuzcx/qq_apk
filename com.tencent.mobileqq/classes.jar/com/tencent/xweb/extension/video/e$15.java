package com.tencent.xweb.extension.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.WebView;

class e$15
  implements View.OnClickListener
{
  e$15(e parame) {}
  
  public void onClick(View paramView)
  {
    e.b(this.a).evaluateJavascript("xwebVideoBridge.xwebToJS_Video_ExitFullscreen();", new e.15.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.extension.video.e.15
 * JD-Core Version:    0.7.0.1
 */