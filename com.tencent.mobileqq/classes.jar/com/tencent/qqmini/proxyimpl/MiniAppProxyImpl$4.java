package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppProxyImpl$4
  implements MiniAppCmdInterface
{
  MiniAppProxyImpl$4(MiniAppProxyImpl paramMiniAppProxyImpl) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      QLog.d("MiniAppProxyImpl", 2, "sendSetUserAppTopRequest, success to set top");
      return;
    }
    QLog.e("MiniAppProxyImpl", 1, "sendSetUserAppTopRequest, fail to set top");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */