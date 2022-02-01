package com.tencent.qqmini.sdk.core;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;

public class BaseRuntimeImpl$BaselibProvider
{
  private BaselibLoader.BaselibContent mBaselibContent;
  
  public BaseRuntimeImpl$BaselibProvider(BaseRuntimeImpl paramBaseRuntimeImpl) {}
  
  public String getBasePageFrameStr()
  {
    BaselibLoader.BaselibContent localBaselibContent = this.mBaselibContent;
    if ((localBaselibContent != null) && (!TextUtils.isEmpty(localBaselibContent.pageFrameStr))) {
      return this.mBaselibContent.pageFrameStr;
    }
    return "<!DOCTYPE html><html lang=\"zh-CN\"><head><meta charset=\"UTF-8\" /><meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\" /><meta http-equiv=\"Content-Security-Policy\" content=\"script-src 'self' 'unsafe-inline' 'unsafe-eval'\"><link rel=\"icon\" href=\"data:image/ico;base64,aWNv\"><script></script></head><body><div></div></body></html>";
  }
  
  public BaselibLoader.BaselibContent getBaselibContent()
  {
    return this.mBaselibContent;
  }
  
  public void setBaseLib(BaselibLoader.BaselibContent paramBaselibContent)
  {
    this.mBaselibContent = paramBaselibContent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.BaseRuntimeImpl.BaselibProvider
 * JD-Core Version:    0.7.0.1
 */