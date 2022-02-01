package com.tencent.qqmini.proxyimpl;

import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.ICommandListenr;

class ChannelProxyImpl$14
  implements FFmpegExecuteResponseCallback
{
  ChannelProxyImpl$14(ChannelProxyImpl paramChannelProxyImpl, ChannelProxy.ICommandListenr paramICommandListenr) {}
  
  public void onFailure(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyChannelProxy$ICommandListenr != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyChannelProxy$ICommandListenr.onFailure(paramString);
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyChannelProxy$ICommandListenr != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyChannelProxy$ICommandListenr.onFinish(paramBoolean);
    }
  }
  
  public void onProgress(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyChannelProxy$ICommandListenr != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyChannelProxy$ICommandListenr.onProgress(paramString);
    }
  }
  
  public void onStart()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyChannelProxy$ICommandListenr != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyChannelProxy$ICommandListenr.onStart();
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyChannelProxy$ICommandListenr != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyChannelProxy$ICommandListenr.onSuccess(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.14
 * JD-Core Version:    0.7.0.1
 */