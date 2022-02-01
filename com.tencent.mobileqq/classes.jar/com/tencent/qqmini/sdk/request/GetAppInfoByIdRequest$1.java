package com.tencent.qqmini.sdk.request;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class GetAppInfoByIdRequest$1
  implements Runnable
{
  GetAppInfoByIdRequest$1(GetAppInfoByIdRequest paramGetAppInfoByIdRequest, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).notifyMiniAppInfo(0, this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetAppInfoByIdRequest.1
 * JD-Core Version:    0.7.0.1
 */