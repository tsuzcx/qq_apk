package com.tencent.webbundle.sdk;

import android.content.Context;

class HybridIdleTaskHelper$PreloadWebBundleTask
  extends HybridIdleTaskHelper.IdleTask
{
  private String bizId;
  private Context context;
  
  public HybridIdleTaskHelper$PreloadWebBundleTask(Context paramContext, String paramString)
  {
    super(paramString.hashCode());
    this.context = paramContext;
    this.bizId = paramString;
  }
  
  public int run()
  {
    WebBundleManager.getInstance(this.bizId).preload(this.context);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.webbundle.sdk.HybridIdleTaskHelper.PreloadWebBundleTask
 * JD-Core Version:    0.7.0.1
 */