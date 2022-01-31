package com.tencent.qqmini.proxyimpl;

import amcx;
import amcy;
import bdsx;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;

class MiniAppProxyImpl$9
  implements Runnable
{
  MiniAppProxyImpl$9(MiniAppProxyImpl paramMiniAppProxyImpl, String paramString, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    amcx localamcx = amcy.a();
    if ((localamcx != null) && (localamcx.a() != null) && (localamcx.a().contains(this.val$eventName))) {
      bdsx.a(this.val$miniAppInfo, this.val$eventName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.9
 * JD-Core Version:    0.7.0.1
 */