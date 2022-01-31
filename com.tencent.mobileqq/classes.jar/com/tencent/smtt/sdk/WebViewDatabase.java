package com.tencent.smtt.sdk;

import android.content.Context;

public class WebViewDatabase
{
  protected static final String LOGTAG = "webviewdatabase";
  private static WebViewDatabase mInstance;
  private Context mContext;
  
  protected WebViewDatabase(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private static WebViewDatabase createInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new WebViewDatabase(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public static WebViewDatabase getInstance(Context paramContext)
  {
    return createInstance(paramContext);
  }
  
  public void clearFormData()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().webViewDatabaseClearFormData(this.mContext);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.mContext).clearFormData();
  }
  
  public void clearHttpAuthUsernamePassword()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().webViewDatabaseClearHttpAuthUsernamePassword(this.mContext);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.mContext).clearHttpAuthUsernamePassword();
  }
  
  @Deprecated
  public void clearUsernamePassword()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().webViewDatabaseClearUsernamePassword(this.mContext);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.mContext).clearUsernamePassword();
  }
  
  public boolean hasFormData()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().webViewDatabaseHasFormData(this.mContext);
    }
    return android.webkit.WebViewDatabase.getInstance(this.mContext).hasFormData();
  }
  
  public boolean hasHttpAuthUsernamePassword()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().webViewDatabaseHasHttpAuthUsernamePassword(this.mContext);
    }
    return android.webkit.WebViewDatabase.getInstance(this.mContext).hasHttpAuthUsernamePassword();
  }
  
  @Deprecated
  public boolean hasUsernamePassword()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().webViewDatabaseHasUsernamePassword(this.mContext);
    }
    return android.webkit.WebViewDatabase.getInstance(this.mContext).hasUsernamePassword();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebViewDatabase
 * JD-Core Version:    0.7.0.1
 */