package com.tencent.timi.game.base;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.router.ServiceCenter;

public class TimiGameBaseActivity
  extends QBaseActivity
{
  private FrameLayout a;
  private TimiGamePageLoadingView b;
  
  public void a()
  {
    a(2131917232);
  }
  
  public void a(int paramInt)
  {
    a(getString(paramInt));
  }
  
  public void a(String paramString)
  {
    String str = paramString;
    if (paramString.isEmpty()) {
      str = getString(2131917232);
    }
    if (this.b == null)
    {
      this.b = new TimiGamePageLoadingView(this);
      paramString = new FrameLayout.LayoutParams(-1, -1);
      this.a.addView(this.b, paramString);
    }
    this.b.setHintText(str);
    this.b.a();
  }
  
  public void b()
  {
    TimiGamePageLoadingView localTimiGamePageLoadingView = this.b;
    if (localTimiGamePageLoadingView != null) {
      localTimiGamePageLoadingView.b();
    }
  }
  
  protected void beforeDoOnCreate()
  {
    super.beforeDoOnCreate();
    LayoutInflater.from(this).setFactory2(((IniterService)ServiceCenter.a(IniterService.class)).a());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void setContentView(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    ViewGroup localViewGroup = (ViewGroup)findViewById(16908290);
    setContentView(LayoutInflater.from(this).inflate(paramInt, localViewGroup, false), localLayoutParams);
  }
  
  public void setContentView(View paramView)
  {
    setContentView(paramView, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void setContentView(@NonNull View paramView, @NonNull ViewGroup.LayoutParams paramLayoutParams)
  {
    paramLayoutParams = (FrameLayout.LayoutParams)paramLayoutParams;
    this.a = ((FrameLayout)findViewById(16908290));
    this.a.addView(paramView, paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.base.TimiGameBaseActivity
 * JD-Core Version:    0.7.0.1
 */