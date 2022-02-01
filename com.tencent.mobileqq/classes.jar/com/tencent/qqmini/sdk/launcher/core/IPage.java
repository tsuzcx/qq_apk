package com.tencent.qqmini.sdk.launcher.core;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import org.json.JSONObject;

public abstract interface IPage
{
  public abstract String dispatchEventToNativeView(NativeViewRequestEvent paramNativeViewRequestEvent);
  
  public abstract void dispatchEventToWebView(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public abstract boolean doDispatchKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract ICapsuleButton getCapsuleButton();
  
  public abstract int getNaviBarTextStyle();
  
  public abstract int getNaviBarVisibility();
  
  public abstract AppPageInfo getPageInfo(int paramInt);
  
  public abstract String getPageOrientation();
  
  public abstract int getTabBarVisibility();
  
  public abstract void hideSoftInput(View paramView);
  
  public abstract boolean operateCustomButton(String paramString, long paramLong, JSONObject paramJSONObject, View.OnClickListener paramOnClickListener);
  
  public abstract boolean operateFloatDragAd(String paramString, FloatDragAdInfo paramFloatDragAdInfo);
  
  public abstract boolean operatePendantAd(String paramString, PendantAdInfo paramPendantAdInfo);
  
  public abstract boolean setMiniAIOEntranceVisible(boolean paramBoolean, JSONObject paramJSONObject);
  
  public abstract void setNaviVisibility(int paramInt);
  
  public abstract void setTabBarVisibility(int paramInt);
  
  public abstract boolean toggleDebugPanel();
  
  public abstract boolean toggleMonitorPanel();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.IPage
 * JD-Core Version:    0.7.0.1
 */