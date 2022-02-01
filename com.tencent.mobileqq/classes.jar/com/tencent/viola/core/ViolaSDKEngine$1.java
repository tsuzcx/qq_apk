package com.tencent.viola.core;

import android.text.TextUtils;
import com.tencent.viola.utils.ViolaLogUtils;

final class ViolaSDKEngine$1
  implements Runnable
{
  ViolaSDKEngine$1(InitConfig paramInitConfig, ViolaSDKEngine.InitCallback paramInitCallback, String paramString) {}
  
  public void run()
  {
    System.currentTimeMillis();
    Object localObject = ViolaSDKManager.getInstance();
    InitConfig localInitConfig = this.val$config;
    if (localInitConfig != null) {
      ((ViolaSDKManager)localObject).setInitConfig(localInitConfig);
    }
    localInitConfig = this.val$config;
    if ((localInitConfig != null) && (!TextUtils.isEmpty(localInitConfig.getFrameworkLoaclPath())))
    {
      ((ViolaSDKManager)localObject).initScriptsFramework(this.val$config.getFrameworkLoaclPath(), this.val$initCallback, this.val$data);
      return;
    }
    localInitConfig = this.val$config;
    if ((localInitConfig != null) && (!TextUtils.isEmpty(localInitConfig.getFramework())))
    {
      ((ViolaSDKManager)localObject).initScriptsFrameworkString(this.val$config.getFramework(), this.val$initCallback, this.val$data);
      return;
    }
    localObject = this.val$initCallback;
    if (localObject != null) {
      ((ViolaSDKEngine.InitCallback)localObject).onFinish(100, 0L, " main js path is null");
    }
    ViolaLogUtils.e("ViolaSDKEngine", " main js path is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.core.ViolaSDKEngine.1
 * JD-Core Version:    0.7.0.1
 */