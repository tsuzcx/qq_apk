package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;

class MiniAppProxyImpl$9
  implements EIPCResultCallback
{
  MiniAppProxyImpl$9(MiniAppProxyImpl paramMiniAppProxyImpl, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).removeCallbacksAndMessages(Integer.valueOf(1000));
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
          MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).clear();
          MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).addAll(paramEIPCResult);
        }
        if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) {
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.topType = i;
        }
      }
    }
    AppBrandTask.runTaskOnUiThread(new MiniAppProxyImpl.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.9
 * JD-Core Version:    0.7.0.1
 */