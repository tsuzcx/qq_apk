package com.tencent.mobileqq.olympic.activity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class OlympicToolBaseActivity
  extends AbsBaseWebViewActivity
{
  private static final String TAG = "ScanBaseActivity";
  public AppInterface app;
  public QQAppInterface qqApp;
  public OlympicToolAppInterface toolApp;
  
  private Drawable getIconDrawable(String paramString, int paramInt)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestHeight = AIOUtils.b(55.0F, getResources());
    localURLDrawableOptions.mRequestWidth = AIOUtils.b(55.0F, getResources());
    localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(paramInt);
    localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      return paramString;
    }
    catch (Exception paramString)
    {
      label58:
      break label58;
    }
    return localURLDrawableOptions.mLoadingDrawable;
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
    super.doOnCreate(paramBundle);
    updateAppRuntime();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public String getModuleId()
  {
    if ("ScanTorchActivity".equals(getClass().getSimpleName())) {
      return "module_olympic";
    }
    return super.getModuleId();
  }
  
  public void launchOcr() {}
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    updateAppRuntime();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void updateAppRuntime()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      this.qqApp = ((QQAppInterface)localAppRuntime);
      this.app = this.qqApp;
      return;
    }
    if ((localAppRuntime instanceof OlympicToolAppInterface))
    {
      this.toolApp = ((OlympicToolAppInterface)localAppRuntime);
      this.app = this.toolApp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity
 * JD-Core Version:    0.7.0.1
 */