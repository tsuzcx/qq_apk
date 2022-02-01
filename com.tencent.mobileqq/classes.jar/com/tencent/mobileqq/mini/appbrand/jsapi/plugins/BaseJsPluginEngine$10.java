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
import java.util.Collection;
import java.util.List;

class BaseJsPluginEngine$10
  implements DialogInterface.OnDismissListener
{
  BaseJsPluginEngine$10(BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (AuthDialog)paramDialogInterface;
    Object localObject1 = paramDialogInterface.getData();
    boolean bool2 = paramDialogInterface.isConfirm();
    boolean bool3 = paramDialogInterface.isRefuse();
    Object localObject3;
    String str;
    boolean bool1;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    if (localObject1 != null)
    {
      localObject3 = ((Bundle)localObject1).getString("key_event_name");
      ((Bundle)localObject1).getString("key_params");
      ((Bundle)localObject1).getInt("key_callback_id");
      str = ((Bundle)localObject1).getString("key_setting_item");
      bool1 = ((Bundle)localObject1).getBoolean("key_once_sub_cb_maintain");
      bool4 = ((Bundle)localObject1).getBoolean("key_once_sub_cb1");
      bool5 = ((Bundle)localObject1).getBoolean("key_once_sub_cb2");
      bool6 = ((Bundle)localObject1).getBoolean("key_once_sub_cb3");
      if (!"requestSubscribeSystemMessage".equals(localObject3)) {
        break label888;
      }
      bool1 = true;
    }
    label282:
    label740:
    label883:
    label888:
    for (;;)
    {
      Object localObject2 = ((Bundle)localObject1).getByteArray("key_once_sub_rsp_data");
      localObject1 = new INTERFACE.StGetUserSettingRsp();
      if (localObject2 != null) {}
      Object localObject4;
      ArrayList localArrayList;
      int i;
      INTERFACE.StSubscribeMessage localStSubscribeMessage1;
      try
      {
        ((INTERFACE.StGetUserSettingRsp)localObject1).mergeFrom((byte[])localObject2);
        if (((INTERFACE.StGetUserSettingRsp)localObject1).setting == null) {
          break label852;
        }
        localObject4 = ((INTERFACE.StGetUserSettingRsp)localObject1).setting.subItems.get();
        localObject1 = new ArrayList();
        localArrayList = new ArrayList();
        localObject2 = new ArrayList();
        i = 0;
        for (;;)
        {
          if (i >= ((List)localObject4).size()) {
            break label282;
          }
          localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)((List)localObject4).get(i);
          if (localStSubscribeMessage1.authState.get() != 0) {
            break;
          }
          ((List)localObject1).add(localStSubscribeMessage1);
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
        this.this$0.uiHandler.obtainMessage(1);
        localObject3 = new BaseJsPluginEngine.10.1(this, bool2, (String)localObject3, (List)localObject4, (List)localObject1, localArrayList, bool3);
        if (!bool2) {
          break label740;
        }
      }
      switch (((List)localObject1).size())
      {
      default: 
        localArrayList = new ArrayList();
        localArrayList.addAll((Collection)localObject1);
        localArrayList.addAll(localThrowable);
        this.this$0.authorizeCenter.updateOnceSubMsgSetting(str, true, localArrayList, (MiniAppCmdInterface)localObject3);
        if ((localArrayList.size() > 0) && ("setting.sysMsgSubscribed".equals(str))) {
          this.this$0.authorizeCenter.updateIsSysSubMsgMaintain(true);
        }
        break;
      }
      for (;;)
      {
        if (!bool2) {
          break label883;
        }
        paramDialogInterface.reportAuthDialogClickTo4239();
        return;
        localObject4 = (INTERFACE.StSubscribeMessage)((List)localObject1).get(0);
        if (BaseJsPluginEngine.access$600(this.this$0, bool1, bool4, (INTERFACE.StSubscribeMessage)localObject4)) {
          break;
        }
        ((List)localObject1).remove(localObject4);
        localArrayList.add(localObject4);
        break;
        localObject4 = (INTERFACE.StSubscribeMessage)((List)localObject1).get(0);
        localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)((List)localObject1).get(1);
        if (!BaseJsPluginEngine.access$600(this.this$0, bool1, bool4, (INTERFACE.StSubscribeMessage)localObject4))
        {
          ((List)localObject1).remove(localObject4);
          localArrayList.add(localObject4);
        }
        if (BaseJsPluginEngine.access$600(this.this$0, bool1, bool5, localStSubscribeMessage1)) {
          break;
        }
        ((List)localObject1).remove(localStSubscribeMessage1);
        localArrayList.add(localStSubscribeMessage1);
        break;
        localObject4 = (INTERFACE.StSubscribeMessage)((List)localObject1).get(0);
        localStSubscribeMessage1 = (INTERFACE.StSubscribeMessage)((List)localObject1).get(1);
        INTERFACE.StSubscribeMessage localStSubscribeMessage2 = (INTERFACE.StSubscribeMessage)((List)localObject1).get(2);
        if (!BaseJsPluginEngine.access$600(this.this$0, bool1, bool4, (INTERFACE.StSubscribeMessage)localObject4))
        {
          ((List)localObject1).remove(localObject4);
          localArrayList.add(localObject4);
        }
        if (!BaseJsPluginEngine.access$600(this.this$0, bool1, bool5, localStSubscribeMessage1))
        {
          ((List)localObject1).remove(localStSubscribeMessage1);
          localArrayList.add(localStSubscribeMessage1);
        }
        if (BaseJsPluginEngine.access$600(this.this$0, bool1, bool6, localStSubscribeMessage2)) {
          break;
        }
        ((List)localObject1).remove(localStSubscribeMessage2);
        localArrayList.add(localStSubscribeMessage2);
        break;
        if (bool3)
        {
          if (bool1)
          {
            i = 0;
            while (i < ((List)localObject1).size())
            {
              ((INTERFACE.StSubscribeMessage)((List)localObject1).get(i)).authState.set(2);
              i += 1;
            }
            this.this$0.authorizeCenter.updateOnceSubMsgSetting(str, false, (List)localObject1, (MiniAppCmdInterface)localObject3);
          }
          for (;;)
          {
            if (!"setting.sysMsgSubscribed".equals(str)) {
              break label838;
            }
            this.this$0.authorizeCenter.updateIsSysSubMsgMaintain(true);
            break;
            ((MiniAppCmdInterface)localObject3).onCmdListener(true, null);
          }
        }
        else
        {
          ((MiniAppCmdInterface)localObject3).onCmdListener(true, null);
          continue;
          this.this$0.subscribeMsgCallbackFail(BaseJsPluginEngine.access$400(this.this$0), (String)localObject3, "Request list fail", 10002, BaseJsPluginEngine.access$500(this.this$0));
        }
      }
      paramDialogInterface.reportAuthDialogCancelTo4239();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.10
 * JD-Core Version:    0.7.0.1
 */