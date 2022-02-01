package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.ICommandListenr;

class ChannelProxyImpl$15
  implements FFmpegExecuteResponseCallback
{
  ChannelProxyImpl$15(ChannelProxyImpl paramChannelProxyImpl, ChannelProxy.ICommandListenr paramICommandListenr) {}
  
  public void onFailure(String paramString)
  {
    ChannelProxy.ICommandListenr localICommandListenr = this.a;
    if (localICommandListenr != null) {
      localICommandListenr.onFailure(paramString);
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    ChannelProxy.ICommandListenr localICommandListenr = this.a;
    if (localICommandListenr != null) {
      localICommandListenr.onFinish(paramBoolean);
    }
  }
  
  public void onProgress(String paramString)
  {
    ChannelProxy.ICommandListenr localICommandListenr = this.a;
    if (localICommandListenr != null) {
      localICommandListenr.onProgress(paramString);
    }
  }
  
  public void onStart()
  {
    ChannelProxy.ICommandListenr localICommandListenr = this.a;
    if (localICommandListenr != null) {
      localICommandListenr.onStart();
    }
  }
  
  public void onSuccess(String paramString)
  {
    ChannelProxy.ICommandListenr localICommandListenr = this.a;
    if (localICommandListenr != null) {
      localICommandListenr.onSuccess(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.15
 * JD-Core Version:    0.7.0.1
 */