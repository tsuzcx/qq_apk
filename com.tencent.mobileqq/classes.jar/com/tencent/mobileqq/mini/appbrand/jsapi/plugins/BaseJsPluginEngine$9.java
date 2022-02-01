package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.widget.AuthDialog;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class BaseJsPluginEngine$9
  implements DialogInterface.OnDismissListener
{
  BaseJsPluginEngine$9(BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (AuthDialog)paramDialogInterface;
    Object localObject1 = paramDialogInterface.getData();
    boolean bool1 = paramDialogInterface.isConfirm();
    boolean bool2 = paramDialogInterface.isRefuse();
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    Object localObject2;
    ArrayList localArrayList;
    int i;
    INTERFACE.StSubscribeMessage localStSubscribeMessage1;
    if (localObject1 != null)
    {
      ((Bundle)localObject1).getString("key_event_name");
      ((Bundle)localObject1).getString("key_params");
      ((Bundle)localObject1).getInt("key_callback_id");
      bool3 = ((Bundle)localObject1).getBoolean("key_once_sub_cb_maintain");
      bool4 = ((Bundle)localObject1).getBoolean("key_once_sub_cb1");
      bool5 = ((Bundle)localObject1).getBoolean("key_once_sub_cb2");
      bool6 = ((Bundle)localObject1).getBoolean("key_once_sub_cb3");
      localObject1 = ((Bundle)localObject1).getByteArray("key_once_sub_rsp_data");
      paramDialogInterface = new INTERFACE.StGetUserSettingRsp();
      if (localObject1 != null) {}
      try
      {
        paramDialogInterface.mergeFrom((byte[])localObject1);
        if (paramDialogInterface.setting == null) {
          break label736;
        }
        localObject2 = paramDialogInterface.setting.subItems.get();
        paramDialogInterface = new ArrayList();
        localArrayList = new ArrayList();
        localObject1 = new ArrayList();
        i = 0;
        for (;;)
        {
          if (i >= ((List)localObject2).size()) {
            break label254;
          }
          localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)((List)localObject2).get(i);
          if (localStSubscribeMessage1.authState.get() != 0) {
            break;
          }
          paramDialogInterface.add(localStSubscribeMessage1);
          i += 1;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("BaseJsPluginEngine", 1, "onceSubDismissListner - rsp.mergeFrom(onceSubRspByteArr) get a Throwable", localThrowable);
          continue;
          if (localStSubscribeMessage1.authState.get() == 1) {
            localThrowable.add(localStSubscribeMessage1);
          }
        }
        label254:
        this.this$0.uiHandler.obtainMessage(1);
        localObject2 = new BaseJsPluginEngine.9.1(this, bool1, (List)localObject2, paramDialogInterface, localArrayList, bool2);
        if (!bool1) {
          break label655;
        }
      }
      switch (paramDialogInterface.size())
      {
      }
    }
    for (;;)
    {
      localArrayList = new ArrayList();
      localArrayList.addAll(paramDialogInterface);
      localArrayList.addAll(localThrowable);
      this.this$0.authorizeCenter.updateOnceSubMsgSetting(true, localArrayList, (MiniAppCmdInterface)localObject2);
      return;
      localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)paramDialogInterface.get(0);
      if (!BaseJsPluginEngine.access$600(this.this$0, bool3, bool4, localStSubscribeMessage1))
      {
        paramDialogInterface.remove(localStSubscribeMessage1);
        localArrayList.add(localStSubscribeMessage1);
        continue;
        localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)paramDialogInterface.get(0);
        INTERFACE.StSubscribeMessage localStSubscribeMessage2 = (INTERFACE.StSubscribeMessage)paramDialogInterface.get(1);
        if (!BaseJsPluginEngine.access$600(this.this$0, bool3, bool4, localStSubscribeMessage1))
        {
          paramDialogInterface.remove(localStSubscribeMessage1);
          localArrayList.add(localStSubscribeMessage1);
        }
        if (!BaseJsPluginEngine.access$600(this.this$0, bool3, bool5, localStSubscribeMessage2))
        {
          paramDialogInterface.remove(localStSubscribeMessage2);
          localArrayList.add(localStSubscribeMessage2);
          continue;
          localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)paramDialogInterface.get(0);
          localStSubscribeMessage2 = (INTERFACE.StSubscribeMessage)paramDialogInterface.get(1);
          INTERFACE.StSubscribeMessage localStSubscribeMessage3 = (INTERFACE.StSubscribeMessage)paramDialogInterface.get(2);
          if (!BaseJsPluginEngine.access$600(this.this$0, bool3, bool4, localStSubscribeMessage1))
          {
            paramDialogInterface.remove(localStSubscribeMessage1);
            localArrayList.add(localStSubscribeMessage1);
          }
          if (!BaseJsPluginEngine.access$600(this.this$0, bool3, bool5, localStSubscribeMessage2))
          {
            paramDialogInterface.remove(localStSubscribeMessage2);
            localArrayList.add(localStSubscribeMessage2);
          }
          if (!BaseJsPluginEngine.access$600(this.this$0, bool3, bool6, localStSubscribeMessage3))
          {
            paramDialogInterface.remove(localStSubscribeMessage3);
            localArrayList.add(localStSubscribeMessage3);
          }
        }
      }
    }
    label655:
    if (bool2)
    {
      if (bool3)
      {
        i = 0;
        while (i < paramDialogInterface.size())
        {
          ((INTERFACE.StSubscribeMessage)paramDialogInterface.get(i)).authState.set(4);
          i += 1;
        }
        this.this$0.authorizeCenter.updateOnceSubMsgSetting(false, paramDialogInterface, (MiniAppCmdInterface)localObject2);
        return;
      }
      ((MiniAppCmdInterface)localObject2).onCmdListener(true, null);
      return;
    }
    ((MiniAppCmdInterface)localObject2).onCmdListener(true, null);
    return;
    label736:
    this.this$0.onceSubMsgCallbackFail(BaseJsPluginEngine.access$400(this.this$0), "Request list fail", 10002, BaseJsPluginEngine.access$500(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.9
 * JD-Core Version:    0.7.0.1
 */