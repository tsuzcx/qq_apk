package com.tencent.qqmini.sdk.core.plugins.engine;

import bgnk;
import bgnm;
import bgok;
import com.tencent.qqmini.sdk.log.QMLog;

class BaseJsPluginEngine$1
  implements bgnm
{
  BaseJsPluginEngine$1(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString1, String paramString2, String paramString3, bgok parambgok) {}
  
  public boolean doOnRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 0;
    if (paramInt != 9527) {}
    do
    {
      return false;
      bgnk.a().b(this);
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
      paramArrayOfString = BaseJsPluginEngine.access$000(this.val$event, this.val$jsonParams);
      BaseJsPluginEngine.access$100(this.this$0, paramArrayOfString, true);
      if (!"authorize".equals(this.val$req.a)) {
        break label113;
      }
      BaseJsPluginEngine.access$200(this.this$0, this.val$req);
    }
    for (;;)
    {
      return true;
      label113:
      this.this$0.dispatchRequestEvent(this.val$req);
      continue;
      label128:
      QMLog.d("JsPluginEngine[AuthGuard]", "request system permission user denied");
      this.val$req.a("system permission denied");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.BaseJsPluginEngine.1
 * JD-Core Version:    0.7.0.1
 */