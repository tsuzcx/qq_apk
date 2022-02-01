package com.tencent.qqmini.sdk.launcher.shell;

import android.content.Context;

public abstract class BaselibLoader
{
  public static final String TAG = "BaselibLoader";
  protected BaselibLoader.BaselibContent mBaselibContent;
  
  public BaselibLoader.BaselibContent getBaselib()
  {
    return this.mBaselibContent;
  }
  
  public boolean isBaseLibInit()
  {
    return (this.mBaselibContent != null) && (this.mBaselibContent.isBaseLibInited());
  }
  
  public abstract void loadBaselib(Context paramContext, BaselibLoader.OnLoadBaselibListener paramOnLoadBaselibListener);
  
  public void setBaselib(BaselibLoader.BaselibContent paramBaselibContent)
  {
    if ((paramBaselibContent != null) && (paramBaselibContent.isBaseLibInited())) {
      this.mBaselibContent = paramBaselibContent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.BaselibLoader
 * JD-Core Version:    0.7.0.1
 */