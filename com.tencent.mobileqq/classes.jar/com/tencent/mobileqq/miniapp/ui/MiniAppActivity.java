package com.tencent.mobileqq.miniapp.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.miniapp.MiniAppEvent;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.miniapp.MiniAppManager;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;

public class MiniAppActivity
  extends BaseActivity
{
  protected String a;
  protected int b;
  public MiniAppInfo c;
  private MiniAppBaseFragment d;
  
  public void a(MiniAppBaseFragment paramMiniAppBaseFragment)
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.replace(2131433667, paramMiniAppBaseFragment);
    localFragmentTransaction.commit();
    this.d = paramMiniAppBaseFragment;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131624032);
    paramBundle = getIntent().getExtras();
    Object localObject = new MiniAppLoadingFragment();
    ((MiniAppLoadingFragment)localObject).setArguments(paramBundle);
    a((MiniAppBaseFragment)localObject);
    MiniAppManager.a();
    this.a = getIntent().getStringExtra("key_appid");
    this.b = getIntent().getIntExtra("key_appType", 0);
    paramBundle = (MiniAppOptions)getIntent().getParcelableExtra("key_options");
    localObject = new MiniAppEvent();
    ((MiniAppEvent)localObject).c = 2;
    ((MiniAppEvent)localObject).b = true;
    ((MiniAppEvent)localObject).e = new Object[] { this, this.a, Integer.valueOf(this.b), paramBundle };
    StoryDispatcher.a().dispatch("MiniAppManager", (Dispatcher.Dispatchable)localObject);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    MiniAppEvent localMiniAppEvent = new MiniAppEvent();
    localMiniAppEvent.c = 3;
    localMiniAppEvent.b = true;
    localMiniAppEvent.e = new Object[] { this.a, Integer.valueOf(this.b) };
    StoryDispatcher.a().dispatch("MiniAppManager", localMiniAppEvent);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    moveTaskToBack(true);
    overridePendingTransition(2130772435, 2130772007);
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.ui.MiniAppActivity
 * JD-Core Version:    0.7.0.1
 */