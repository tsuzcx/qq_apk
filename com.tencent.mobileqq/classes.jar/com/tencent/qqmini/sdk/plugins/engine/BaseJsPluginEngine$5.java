package com.tencent.qqmini.sdk.plugins.engine;

import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IRequestPermissionsResultListener;

class BaseJsPluginEngine$5
  implements IRequestPermissionsResultListener
{
  BaseJsPluginEngine$5(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString1, String paramString2, String paramString3, RequestEvent paramRequestEvent) {}
  
  public boolean doOnRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 0;
    if (paramInt != 9527) {}
    do
    {
      return false;
      ActivityResultManager.g().removeRequestPermissionResultListener(this);
    } while ((paramArrayOfString == null) || (paramArrayOfString.length == 0));
    if (paramArrayOfString[0].equals(this.val$systemPermission))
    {
      paramInt = i;
      if (paramArrayOfInt[0] == 0) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        break label128;
      }
      QMLog.d("JsPluginEngine[AuthGuard]", "request system permission user granted");
      paramArrayOfString = BaseJsPluginEngine.access$200(this.val$event, this.val$jsonParams);
      BaseJsPluginEngine.access$400(this.this$0, paramArrayOfString, true);
      if (!"authorize".equals(this.val$req.event)) {
        break label113;
      }
      BaseJsPluginEngine.access$800(this.this$0, this.val$req);
    }
    for (;;)
    {
      return true;
      label113:
      this.this$0.dispatchRequestEvent(this.val$req);
      continue;
      label128:
      QMLog.d("JsPluginEngine[AuthGuard]", "request system permission user denied");
      this.val$req.fail("system permission denied");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.5
 * JD-Core Version:    0.7.0.1
 */