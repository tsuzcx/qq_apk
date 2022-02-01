package com.tencent.mobileqq.kandian.biz.share;

import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.plugin.PluginBaseActivity;

class VideoShareHelper$ReportDislikeAction$2$1$1
  implements Runnable
{
  VideoShareHelper$ReportDislikeAction$2$1$1(VideoShareHelper.ReportDislikeAction.2.1 param1) {}
  
  public void run()
  {
    VideoShareHelper.n(this.a.b.c.a).b(this.a.b.a);
    if ((VideoShareHelper.g(this.a.b.c.a) instanceof BaseActivity)) {
      QQToast.makeText(VideoShareHelper.g(this.a.b.c.a), -1, VideoShareHelper.g(this.a.b.c.a).getString(2131897938), 0).show(((BaseActivity)VideoShareHelper.g(this.a.b.c.a)).getTitleBarHeight());
    } else if ((VideoShareHelper.g(this.a.b.c.a) instanceof PluginBaseActivity)) {
      QQToast.makeText(VideoShareHelper.g(this.a.b.c.a), -1, VideoShareHelper.g(this.a.b.c.a).getString(2131897938), 0).show(((PluginBaseActivity)VideoShareHelper.g(this.a.b.c.a)).L());
    }
    VideoShareHelper.n(this.a.b.c.a).a(VideoShareHelper.o(this.a.b.c.a), this.a.b.a, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.ReportDislikeAction.2.1.1
 * JD-Core Version:    0.7.0.1
 */