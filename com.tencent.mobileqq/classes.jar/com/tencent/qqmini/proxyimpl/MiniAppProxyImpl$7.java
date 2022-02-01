package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class MiniAppProxyImpl$7
  implements MiniAppCmdInterface
{
  MiniAppProxyImpl$7(MiniAppProxyImpl paramMiniAppProxyImpl, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      AppBrandTask.runTaskOnUiThread(new MiniAppProxyImpl.7.1(this));
      QLog.d("MiniAppProxyImpl", 2, "sendSetUserAppTopRequest, success to set top");
      return;
    }
    QLog.e("MiniAppProxyImpl", 1, "sendSetUserAppTopRequest, fail to set top");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.7
 * JD-Core Version:    0.7.0.1
 */