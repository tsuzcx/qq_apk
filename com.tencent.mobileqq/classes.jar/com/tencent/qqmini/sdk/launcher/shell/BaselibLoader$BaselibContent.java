package com.tencent.qqmini.sdk.launcher.shell;

import android.text.TextUtils;

public class BaselibLoader$BaselibContent
{
  public String miniappWebviewStr;
  public String pageFrameStr;
  public String waConsoleJsStr;
  public String waRemoteDebugStr;
  public String waServiceJsStr;
  public String waServicePath;
  public String waWebviewJsStr;
  public String waWorkerStr;
  
  public BaselibContent clone()
  {
    BaselibContent localBaselibContent = new BaselibContent();
    localBaselibContent.waWebviewJsStr = this.waWebviewJsStr;
    localBaselibContent.waServiceJsStr = this.waServiceJsStr;
    localBaselibContent.waConsoleJsStr = this.waConsoleJsStr;
    localBaselibContent.waRemoteDebugStr = this.waRemoteDebugStr;
    localBaselibContent.miniappWebviewStr = this.miniappWebviewStr;
    localBaselibContent.waWorkerStr = this.waWorkerStr;
    localBaselibContent.pageFrameStr = this.pageFrameStr;
    localBaselibContent.waServicePath = this.waServicePath;
    return localBaselibContent;
  }
  
  public boolean isBaseLibInited()
  {
    return (!TextUtils.isEmpty(this.waServiceJsStr)) && (!TextUtils.isEmpty(this.waWebviewJsStr)) && (!TextUtils.isEmpty(this.waConsoleJsStr)) && (!TextUtils.isEmpty(this.waRemoteDebugStr)) && (!TextUtils.isEmpty(this.miniappWebviewStr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent
 * JD-Core Version:    0.7.0.1
 */