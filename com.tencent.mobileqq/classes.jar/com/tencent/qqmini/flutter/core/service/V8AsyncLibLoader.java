package com.tencent.qqmini.flutter.core.service;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.SoLoaderOption;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import com.tencent.qqmini.v8rt.engine.LibLoader;
import java.io.File;

public class V8AsyncLibLoader
  implements LibLoader
{
  public static final String LOG_TAG = "V8JsLoader";
  
  public boolean loadSo()
  {
    if (AppLoaderFactory.g().getCommonManager() == null)
    {
      QMLog.i("V8JsLoader", "tissueEnv is null");
      return false;
    }
    Object localObject1 = AppLoaderFactory.g().getCommonManager().getTissueSoPath();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QMLog.i("V8JsLoader", "libsDir is empty");
      return false;
    }
    try
    {
      System.loadLibrary("v8jni");
      Object localObject2 = (ChannelProxy)AppLoaderFactory.g().getProxyManager().get(ChannelProxy.class);
      if ((localObject2 != null) && (((ChannelProxy)localObject2).getTissueSoLoaderOption() != null)) {
        ((ChannelProxy)localObject2).getTissueSoLoaderOption().onBeforeLoadSo();
      }
      localObject1 = new File((String)localObject1, "libtv8rt.so");
      if ((((File)localObject1).isFile()) && (((File)localObject1).canRead()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("libtv8rt len:");
        ((StringBuilder)localObject2).append(((File)localObject1).length());
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(((File)localObject1).getPath());
        ((StringBuilder)localObject2).append(" classloader:");
        ((StringBuilder)localObject2).append(getClass().getClassLoader());
        QMLog.i("V8JsLoader", ((StringBuilder)localObject2).toString());
        System.load(((File)localObject1).getAbsolutePath());
        return true;
      }
      throw new UnsatisfiedLinkError("libtv8rt.so is broken");
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("V8JsLoader", "errload", localThrowable);
      localThrowable.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.service.V8AsyncLibLoader
 * JD-Core Version:    0.7.0.1
 */