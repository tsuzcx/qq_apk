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
    boolean bool1 = paramDialogInterface.isConfirm();
    boolean bool2 = paramDialogInterface.isRefuse();
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    if (localObject != null)
    {
      bool3 = ((Bundle)localObject).getBoolean("key_once_sub_cb_maintain");
      bool4 = ((Bundle)localObject).getBoolean("key_once_sub_cb1");
      bool5 = ((Bundle)localObject).getBoolean("key_once_sub_cb2");
      bool6 = ((Bundle)localObject).getBoolean("key_once_sub_cb3");
      localObject = ((Bundle)localObject).getByteArray("key_once_sub_rsp_data");
      paramDialogInterface = new INTERFACE.StGetUserSettingRsp();
      if (localObject == null) {}
    }
    try
    {
      paramDialogInterface.mergeFrom((byte[])localObject);
      if (paramDialogInterface.setting != null)
      {
        BaseJsPluginEngine.access$000(this.this$0, bool3, bool4, bool5, bool6, bool1, bool2, paramDialogInterface);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("JsPluginEngine[AuthGuard]", "onceSubDismissListner - rsp.mergeFrom(onceSubRspByteArr) get a Throwable", localThrowable);
      }
      this.this$0.onceSubMsgCallbackFail(BaseJsPluginEngine.access$100(this.this$0), "Request list fail", 10002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.1
 * JD-Core Version:    0.7.0.1
 */