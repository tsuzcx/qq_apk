package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;

final class MiniAppProxyImpl$3
  implements Action<Object>
{
  public Object perform(BaseRuntime paramBaseRuntime)
  {
    AppLoaderFactory.g().getAppBrandProxy().onAppDestroy(paramBaseRuntime.getMiniAppInfo(), (Bundle)null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */