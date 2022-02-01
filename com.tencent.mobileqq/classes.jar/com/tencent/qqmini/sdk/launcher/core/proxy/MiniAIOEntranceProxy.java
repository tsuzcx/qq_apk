package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.content.Context;
import android.widget.RelativeLayout;

public abstract class MiniAIOEntranceProxy
  extends RelativeLayout
{
  public MiniAIOEntranceProxy(Context paramContext)
  {
    super(paramContext);
  }
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void setMiniAIOStyle(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.MiniAIOEntranceProxy
 * JD-Core Version:    0.7.0.1
 */