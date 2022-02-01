package com.tencent.qqmini.sdk.plugins.engine;

import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.AuthDialog;

class BaseJsPluginEngine$1
  implements DialogInterface.OnDismissListener
{
  BaseJsPluginEngine$1(BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (AuthDialog)paramDialogInterface;
    Object localObject = paramDialogInterface.getData();
    boolean bool2 = paramDialogInterface.isConfirm();
    boolean bool3 = paramDialogInterface.isRefuse();
    boolean bool1;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    byte[] arrayOfByte;
    INTERFACE.StGetUserSettingRsp localStGetUserSettingRsp;
    if (localObject != null)
    {
      bool1 = ((Bundle)localObject).getBoolean("key_once_sub_cb_maintain");
      if ("requestSubscribeSystemMessage".equals(((Bundle)localObject).getString("key_event_name"))) {
        bool1 = true;
      }
      bool4 = ((Bundle)localObject).getBoolean("key_once_sub_cb1");
      bool5 = ((Bundle)localObject).getBoolean("key_once_sub_cb2");
      bool6 = ((Bundle)localObject).getBoolean("key_once_sub_cb3");
      arrayOfByte = ((Bundle)localObject).getByteArray("key_once_sub_rsp_data");
      localStGetUserSettingRsp = new INTERFACE.StGetUserSettingRsp();
      if (arrayOfByte == null) {}
    }
    try
    {
      localStGetUserSettingRsp.mergeFrom(arrayOfByte);
      if (localStGetUserSettingRsp.setting != null)
      {
        localObject = ((Bundle)localObject).getString("key_setting_item");
        BaseJsPluginEngine.access$000(this.this$0, (String)localObject, bool1, bool4, bool5, bool6, bool2, bool3, localStGetUserSettingRsp);
        if (!bool2) {
          break label193;
        }
        paramDialogInterface.reportAuthDialogClickTo4239();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("JsPluginEngine[AuthGuard]", "onceSubDismissListner - rsp.mergeFrom(onceSubRspByteArr) get a Throwable", localThrowable);
        continue;
        this.this$0.onceSubMsgCallbackFail(BaseJsPluginEngine.access$100(this.this$0), "Request list fail", 10002);
      }
      label193:
      paramDialogInterface.reportAuthDialogCancelTo4239();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.1
 * JD-Core Version:    0.7.0.1
 */