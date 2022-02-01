package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.widget.AuthDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

class BaseJsPluginEngine$10
  implements DialogInterface.OnDismissListener
{
  BaseJsPluginEngine$10(BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AuthDialog localAuthDialog = (AuthDialog)paramDialogInterface;
    Bundle localBundle = localAuthDialog.getData();
    JSONObject localJSONObject = localAuthDialog.getSelectPhoneNumber();
    Object localObject;
    int i;
    if (localBundle != null)
    {
      paramDialogInterface = localBundle.getString("key_event_name");
      localObject = localBundle.getString("key_params");
      i = localBundle.getInt("key_callback_id");
    }
    for (;;)
    {
      localObject = AuthorizeCenter.getScopeName(paramDialogInterface, (String)localObject);
      boolean bool1 = localAuthDialog.isConfirm();
      boolean bool2 = localAuthDialog.isRefuse();
      QLog.d("BaseJsPluginEngine", 2, "onDismiss eventName=" + paramDialogInterface + ",scopeName=" + (String)localObject + ",isConfirm=" + bool1 + ",isRefuse=" + bool2);
      paramDialogInterface = this.this$0.uiHandler.obtainMessage(1);
      if (bool1)
      {
        paramDialogInterface.arg1 = 1;
        this.this$0.authorizeCenter.setAuthorize((String)localObject, true);
      }
      for (;;)
      {
        if ((i != -1) && (BaseJsPluginEngine.access$700(this.this$0).containsKey(Integer.valueOf(i))))
        {
          localObject = (BaseJsPluginEngine.ReqGantApiPermissionCallback)BaseJsPluginEngine.access$700(this.this$0).remove(Integer.valueOf(i));
          if (localObject != null) {
            ((BaseJsPluginEngine.ReqGantApiPermissionCallback)localObject).onGrantApiPermission(paramDialogInterface.arg1, localJSONObject);
          }
        }
        paramDialogInterface.sendToTarget();
        this.this$0.authDialog = null;
        return;
        if (bool2)
        {
          paramDialogInterface.arg1 = 2;
          paramDialogInterface.obj = localObject;
          this.this$0.authorizeCenter.setAuthorize((String)localObject, false);
        }
        else
        {
          paramDialogInterface.arg1 = 3;
          paramDialogInterface.obj = localObject;
        }
      }
      i = -1;
      localObject = null;
      paramDialogInterface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.10
 * JD-Core Version:    0.7.0.1
 */