package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;

class MiniAppProxyImpl$5
  implements EIPCResultCallback
{
  MiniAppProxyImpl$5(MiniAppProxyImpl paramMiniAppProxyImpl, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    MiniAppProxyImpl.access$600(this.this$0).removeCallbacksAndMessages(Integer.valueOf(1000));
    if (paramEIPCResult != null)
    {
      QLog.d("MiniAppProxyImpl", 1, "onMoreClick onCallback code : " + paramEIPCResult.code);
      if (paramEIPCResult.code == 0)
      {
        paramEIPCResult = paramEIPCResult.data;
        int i = paramEIPCResult.getInt("topType");
        paramEIPCResult = paramEIPCResult.getIntegerArrayList("backHomeSceneList");
        if ((paramEIPCResult != null) && (paramEIPCResult.size() > 0))
        {
          MiniAppProxyImpl.access$700(this.this$0).clear();
          MiniAppProxyImpl.access$700(this.this$0).addAll(paramEIPCResult);
        }
        if (this.val$miniAppInfo != null) {
          this.val$miniAppInfo.topType = i;
        }
      }
    }
    AppBrandTask.runTaskOnUiThread(new MiniAppProxyImpl.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */