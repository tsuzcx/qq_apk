package com.tencent.mobileqq.vashealth;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.view.ISPlayerVideoView;

class HealthBusinessPlugin$14
  implements View.OnClickListener
{
  HealthBusinessPlugin$14(HealthBusinessPlugin paramHealthBusinessPlugin, HealthBusinessPlugin.SportVideoLayoutHolder paramSportVideoLayoutHolder, ISPlayerVideoView paramISPlayerVideoView, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if (!this.d.I)
    {
      this.a.g.setImageResource(2130842771);
      ((View)this.b).setOnTouchListener(new HealthBusinessPlugin.14.1(this));
      this.d.mRuntime.d().findViewById(2131444897).setVisibility(8);
      if (((ViewGroup)this.d.mRuntime.d().findViewById(16908290).getParent().getParent()).getChildAt(1) != null) {
        ((ViewGroup)this.d.mRuntime.d().findViewById(16908290).getParent().getParent()).getChildAt(1).setVisibility(8);
      }
      this.d.mRuntime.d().getWindow().setFlags(1024, 1024);
      this.d.mRuntime.d().setRequestedOrientation(0);
      this.d.mRuntime.d().getWindow().setFlags(1024, 1024);
      localObject1 = this.d;
      ((HealthBusinessPlugin)localObject1).G = ((HealthBusinessPlugin)localObject1).mRuntime.a().getScrollX();
      localObject1 = this.d;
      ((HealthBusinessPlugin)localObject1).H = ((HealthBusinessPlugin)localObject1).mRuntime.a().getScrollY();
      this.d.mRuntime.a().scrollTo(0, 0);
      this.d.mRuntime.a().setVisibility(8);
      this.d.q.scrollTo(0, 0);
      localObject1 = ((ViewGroup)this.b).getLayoutParams();
      this.d.C = ((ViewGroup.LayoutParams)localObject1).height;
      this.d.B = ((ViewGroup.LayoutParams)localObject1).width;
      ((ViewGroup.LayoutParams)localObject1).width = -1;
      ((ViewGroup.LayoutParams)localObject1).height = -1;
      localObject2 = this.d;
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localObject1;
      ((HealthBusinessPlugin)localObject2).j = localLayoutParams.topMargin;
      this.d.k = localLayoutParams.leftMargin;
      localLayoutParams.topMargin = 0;
      localLayoutParams.leftMargin = 0;
      i = this.d.mRuntime.d().getResources().getDisplayMetrics().widthPixels;
      int j = this.d.mRuntime.d().getResources().getDisplayMetrics().heightPixels;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("FullScreenWidth ScreenWidth:");
      ((StringBuilder)localObject2).append(i);
      QLog.d("HealthBusinessPlugin", 2, ((StringBuilder)localObject2).toString());
      localObject2 = (RelativeLayout.LayoutParams)this.d.q.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = j;
      this.d.q.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (FrameLayout.LayoutParams)this.c.getLayoutParams();
      this.d.D = ((FrameLayout.LayoutParams)localObject2).width;
      this.d.E = ((FrameLayout.LayoutParams)localObject2).height;
      this.d.F = ((FrameLayout.LayoutParams)localObject2).topMargin;
      ((FrameLayout.LayoutParams)localObject2).topMargin = 0;
      ((FrameLayout.LayoutParams)localObject2).width = j;
      ((FrameLayout.LayoutParams)localObject2).height = i;
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ViewGroup)this.b).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.d.I = true;
    }
    else
    {
      this.d.mRuntime.d().findViewById(2131444897).setVisibility(0);
      if (((ViewGroup)this.d.mRuntime.d().findViewById(16908290).getParent().getParent()).getChildAt(1) != null) {
        ((ViewGroup)this.d.mRuntime.d().findViewById(16908290).getParent().getParent()).getChildAt(1).setVisibility(0);
      }
      this.d.mRuntime.d().getWindow().setFlags(1024, 8);
      this.d.mRuntime.a().setVisibility(0);
      this.a.g.setImageResource(2130842770);
      ((View)this.b).setOnTouchListener(null);
      localObject1 = this.d.mRuntime.d().getWindow().getAttributes();
      this.d.mRuntime.d().setRequestedOrientation(1);
      ((WindowManager.LayoutParams)localObject1).flags &= 0xFFFFFBFF;
      this.d.mRuntime.d().getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
      this.d.mRuntime.d().getWindow().clearFlags(512);
      localObject1 = ((ViewGroup)this.b).getLayoutParams();
      localObject2 = (FrameLayout.LayoutParams)localObject1;
      ((FrameLayout.LayoutParams)localObject2).topMargin = this.d.j;
      ((FrameLayout.LayoutParams)localObject2).leftMargin = this.d.k;
      ((ViewGroup.LayoutParams)localObject1).height = this.d.C;
      ((ViewGroup.LayoutParams)localObject1).width = this.d.B;
      this.d.mRuntime.a().scrollTo(this.d.G, this.d.H);
      this.d.q.scrollTo(this.d.G, this.d.H + this.d.s.mTotalYoffset);
      i = this.d.mRuntime.d().getResources().getDisplayMetrics().widthPixels;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onBACKFullScreenWidth ScreenWidth:");
      ((StringBuilder)localObject2).append(i);
      QLog.d("HealthBusinessPlugin", 2, ((StringBuilder)localObject2).toString());
      localObject2 = (RelativeLayout.LayoutParams)this.d.q.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = i;
      this.d.q.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (FrameLayout.LayoutParams)this.c.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject2).width = this.d.D;
      ((FrameLayout.LayoutParams)localObject2).height = this.d.E;
      ((FrameLayout.LayoutParams)localObject2).topMargin = this.d.F;
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ViewGroup)this.b).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.d.I = false;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.14
 * JD-Core Version:    0.7.0.1
 */