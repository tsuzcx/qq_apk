package com.tencent.mobileqq.mini.appbrand.ui;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;

class CapsuleButton$3
  implements EIPCResultCallback
{
  CapsuleButton$3(CapsuleButton paramCapsuleButton, ApkgInfo paramApkgInfo) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    CapsuleButton.access$100(this.this$0).removeCallbacksAndMessages(Integer.valueOf(1000));
    if (paramEIPCResult != null)
    {
      QLog.d("CapsuleButton", 1, "onMoreClick onCallback code : " + paramEIPCResult.code);
      if (paramEIPCResult.code == 0)
      {
        paramEIPCResult = paramEIPCResult.data;
        int i = paramEIPCResult.getInt("topType");
        paramEIPCResult = paramEIPCResult.getIntegerArrayList("backHomeSceneList");
        if ((paramEIPCResult != null) && (paramEIPCResult.size() > 0))
        {
          CapsuleButton.access$200(this.this$0).clear();
          CapsuleButton.access$200(this.this$0).addAll(paramEIPCResult);
        }
        if (this.val$apkgInfo != null) {
          this.val$apkgInfo.appConfig.config.topType = i;
        }
      }
    }
    AppBrandTask.runTaskOnUiThread(new CapsuleButton.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.3
 * JD-Core Version:    0.7.0.1
 */