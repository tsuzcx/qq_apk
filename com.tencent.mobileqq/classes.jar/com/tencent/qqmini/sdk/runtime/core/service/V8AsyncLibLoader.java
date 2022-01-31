package com.tencent.qqmini.sdk.runtime.core.service;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.SoLoaderOption;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.tissue.TissueEnv;
import com.tencent.qqmini.sdk.core.tissue.TissueGlobal;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.tissue.v8rt.engine.LibLoader;
import java.io.File;

public class V8AsyncLibLoader
  implements LibLoader
{
  public static final String LOG_TAG = "V8JsLoader";
  
  public boolean loadSo()
  {
    if (TissueGlobal.tissueEnv == null)
    {
      QMLog.i("V8JsLoader", "tissueEnv is null");
      return false;
    }
    Object localObject = TissueGlobal.tissueEnv.getNativeLibDir();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QMLog.i("V8JsLoader", "libsDir is empty");
      return false;
    }
    try
    {
      System.loadLibrary("v8jni");
      ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if ((localChannelProxy != null) && (localChannelProxy.getTissueSoLoaderOption() != null)) {
        localChannelProxy.getTissueSoLoaderOption().onBeforeLoadSo();
      }
      localObject = new File((String)localObject, "libtv8rt.so");
      if ((!((File)localObject).isFile()) || (!((File)localObject).canRead())) {
        throw new UnsatisfiedLinkError("libtv8rt.so is broken");
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("V8JsLoader", "errload", localThrowable);
      localThrowable.printStackTrace();
      return false;
    }
    QMLog.i("V8JsLoader", "libtv8rt len:" + localThrowable.length() + "," + localThrowable.getPath());
    System.load(localThrowable.getAbsolutePath());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.service.V8AsyncLibLoader
 * JD-Core Version:    0.7.0.1
 */