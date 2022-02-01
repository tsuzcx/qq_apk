package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import com.tencent.mobileqq.mini.tissue.TissueEnvImpl;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.proxy.IFlutterProxy;
import io.flutter.view.FlutterMain;

class ChannelProxyImpl$13
  implements IFlutterProxy
{
  ChannelProxyImpl$13(ChannelProxyImpl paramChannelProxyImpl) {}
  
  public void initFlutterRuntime(BaseRuntime paramBaseRuntime, Context paramContext)
  {
    try
    {
      FlutterMain.setNativeLibDir(TissueEnvImpl.getNativeLibDirInSubProgress());
      FlutterMain.startInitialization(paramContext.getApplicationContext());
      FlutterMain.ensureInitializationComplete(paramContext.getApplicationContext(), null);
      return;
    }
    catch (IllegalStateException paramBaseRuntime) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.13
 * JD-Core Version:    0.7.0.1
 */