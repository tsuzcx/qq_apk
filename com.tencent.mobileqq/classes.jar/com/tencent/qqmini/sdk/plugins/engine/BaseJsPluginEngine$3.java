package com.tencent.qqmini.sdk.plugins.engine;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qqmini.sdk.action.PhoneNumberAction.PhoneNumberActionCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.AuthDialog;
import java.util.Map;

class BaseJsPluginEngine$3
  implements DialogInterface.OnDismissListener
{
  BaseJsPluginEngine$3(BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AuthDialog localAuthDialog = (AuthDialog)paramDialogInterface;
    Object localObject2 = localAuthDialog.getData();
    int i;
    if (localObject2 != null)
    {
      paramDialogInterface = ((Bundle)localObject2).getString("key_event_name");
      localObject1 = ((Bundle)localObject2).getString("key_params");
      i = ((Bundle)localObject2).getInt("key_callback_id");
    }
    else
    {
      paramDialogInterface = null;
      localObject1 = paramDialogInterface;
      i = -1;
    }
    Object localObject1 = BaseJsPluginEngine.access$200(paramDialogInterface, (String)localObject1);
    boolean bool1 = localAuthDialog.isConfirm();
    boolean bool2 = localAuthDialog.isRefuse();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onDismiss eventName=");
    ((StringBuilder)localObject2).append(paramDialogInterface);
    ((StringBuilder)localObject2).append(",scopeName=");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(",isConfirm=");
    ((StringBuilder)localObject2).append(bool1);
    ((StringBuilder)localObject2).append(",isRefuse=");
    ((StringBuilder)localObject2).append(bool2);
    QMLog.d("JsPluginEngine[AuthGuard]", ((StringBuilder)localObject2).toString());
    paramDialogInterface = BaseJsPluginEngine.access$300(this.this$0).obtainMessage(1);
    if (bool1)
    {
      paramDialogInterface.arg1 = 1;
      BaseJsPluginEngine.access$400(this.this$0, (String)localObject1, true);
      localAuthDialog.reportAuthDialogClickTo4239();
    }
    else if (bool2)
    {
      paramDialogInterface.arg1 = 2;
      paramDialogInterface.obj = localObject1;
      BaseJsPluginEngine.access$400(this.this$0, (String)localObject1, false);
      localAuthDialog.reportAuthDialogCancelTo4239();
    }
    else
    {
      paramDialogInterface.arg1 = 3;
      paramDialogInterface.obj = localObject1;
      localAuthDialog.reportAuthDialogCancelTo4239();
    }
    if ((i != -1) && (BaseJsPluginEngine.access$500(this.this$0).containsKey(Integer.valueOf(i))))
    {
      localObject1 = (PhoneNumberAction.PhoneNumberActionCallback)BaseJsPluginEngine.access$500(this.this$0).remove(Integer.valueOf(i));
      if (localObject1 != null) {
        ((PhoneNumberAction.PhoneNumberActionCallback)localObject1).onGetAuthDialogRet(bool1, localAuthDialog.getSelectPhoneNumber());
      }
    }
    paramDialogInterface.sendToTarget();
    this.this$0.authDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.3
 * JD-Core Version:    0.7.0.1
 */