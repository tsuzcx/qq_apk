package com.tencent.mobileqq.kandian.biz.dislike;

import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.plugin.PluginBaseActivity;

class RIJDislikeAnimation$1$1
  implements Runnable
{
  RIJDislikeAnimation$1$1(RIJDislikeAnimation.1 param1) {}
  
  public void run()
  {
    this.a.e.a(this.a.b);
    if ((this.a.e.a.a().A() instanceof BaseActivity)) {
      QQToast.makeText(this.a.e.a.a().A(), -1, this.a.e.a.a().A().getString(2131897938), 0).show(((BaseActivity)this.a.e.a.a().A()).getTitleBarHeight());
    } else if ((this.a.e.a.a().A() instanceof PluginBaseActivity)) {
      QQToast.makeText(this.a.e.a.a().A(), -1, this.a.e.a.a().A().getString(2131897938), 0).show(((PluginBaseActivity)this.a.e.a.a().A()).L());
    }
    this.a.e.a.a().v().a(this.a.c, this.a.b, this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeAnimation.1.1
 * JD-Core Version:    0.7.0.1
 */