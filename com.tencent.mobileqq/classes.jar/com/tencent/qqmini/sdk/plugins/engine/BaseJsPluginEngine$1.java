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
    Object localObject2 = paramDialogInterface.getData();
    boolean bool2 = paramDialogInterface.isConfirm();
    boolean bool3 = paramDialogInterface.isRefuse();
    if (localObject2 != null)
    {
      boolean bool1 = ((Bundle)localObject2).getBoolean("key_once_sub_cb_maintain");
      if ("requestSubscribeSystemMessage".equals(((Bundle)localObject2).getString("key_event_name"))) {
        bool1 = true;
      }
      boolean bool4 = ((Bundle)localObject2).getBoolean("key_once_sub_cb1");
      boolean bool5 = ((Bundle)localObject2).getBoolean("key_once_sub_cb2");
      boolean bool6 = ((Bundle)localObject2).getBoolean("key_once_sub_cb3");
      byte[] arrayOfByte = ((Bundle)localObject2).getByteArray("key_once_sub_rsp_data");
      Object localObject1 = new INTERFACE.StGetUserSettingRsp();
      if (arrayOfByte != null) {
        try
        {
          ((INTERFACE.StGetUserSettingRsp)localObject1).mergeFrom(arrayOfByte);
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("JsPluginEngine[AuthGuard]", "onceSubDismissListner - rsp.mergeFrom(onceSubRspByteArr) get a Throwable", localThrowable);
        }
      }
      if (((INTERFACE.StGetUserSettingRsp)localObject1).setting != null)
      {
        localObject2 = ((Bundle)localObject2).getString("key_setting_item");
        BaseJsPluginEngine.access$000(this.this$0, (String)localObject2, bool1, bool4, bool5, bool6, bool2, bool3, (INTERFACE.StGetUserSettingRsp)localObject1);
      }
      else
      {
        localObject1 = this.this$0;
        ((BaseJsPluginEngine)localObject1).onceSubMsgCallbackFail(BaseJsPluginEngine.access$100((BaseJsPluginEngine)localObject1), "Request list fail", 10002);
      }
    }
    if (bool2)
    {
      paramDialogInterface.reportAuthDialogClickTo4239();
      return;
    }
    paramDialogInterface.reportAuthDialogCancelTo4239();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.1
 * JD-Core Version:    0.7.0.1
 */