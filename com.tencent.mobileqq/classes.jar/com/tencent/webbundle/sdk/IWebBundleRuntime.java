package com.tencent.webbundle.sdk;

import android.content.Context;
import org.jetbrains.annotations.NotNull;

public abstract class IWebBundleRuntime
{
  private Context context;
  
  public IWebBundleRuntime(@NotNull Context paramContext)
  {
    this.context = paramContext;
  }
  
  @NotNull
  public abstract IWebBundleWebView createWebView(@NotNull Context paramContext);
  
  public void destroy()
  {
    this.context = null;
  }
  
  public final Context getContext()
  {
    return this.context;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.webbundle.sdk.IWebBundleRuntime
 * JD-Core Version:    0.7.0.1
 */