package com.tencent.qqmini.nativePlugins;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class GroupPlugin
  extends BaseJsPlugin
{
  private static void a(int paramInt, String paramString1, BaseActivity paramBaseActivity, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_type", 1);
    localIntent.putExtra("param_from", 37);
    localIntent.putExtra("param_entrance", 37);
    localIntent.putExtra("param_only_troop_member", true);
    localIntent.putExtra("param_max", paramInt);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", paramString1);
    localIntent.putExtra("group_uin", paramString2);
    localIntent.putExtra("param_groupcode", paramString2);
    localIntent.putExtra("group_name", paramString1);
    localIntent.putExtra("param_exit_animation", 3);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(paramBaseActivity, localIntent, 20001);
    paramBaseActivity.overridePendingTransition(2130772014, 0);
  }
  
  private void a(RequestEvent paramRequestEvent, String paramString1, int paramInt, String paramString2)
  {
    ((IActivityResultManager)this.mMiniAppContext.getManager(IActivityResultManager.class)).addActivityResultListener(new GroupPlugin.1(this, paramRequestEvent));
    BaseActivity localBaseActivity = (BaseActivity)this.mMiniAppContext.getAttachedActivity();
    if ((TroopInfo)localBaseActivity.getAppInterface().getEntityManagerFactory().createEntityManager().find(TroopInfo.class, paramString1) != null)
    {
      a(paramInt, paramString2, localBaseActivity, paramString1);
      return;
    }
    paramRequestEvent.fail(HardCodeUtil.a(2131903339));
  }
  
  @JsEvent({"getMultiMemList"})
  public void getMultiMemList(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject(paramRequestEvent.jsonParams).optJSONObject("data");
      str2 = null;
      if (localJSONObject == null) {
        str1 = null;
      } else {
        str1 = localJSONObject.optString("title");
      }
    }
    catch (Exception paramRequestEvent)
    {
      String str2;
      String str1;
      if (!QLog.isColorLevel()) {
        break label151;
      }
      QLog.i("GroupPlugin", 2, "===>onInvoke exception", paramRequestEvent);
      return;
    }
    int i = localJSONObject.optInt("limitNum", 1);
    break label161;
    label56:
    str2 = localJSONObject.optString("listId");
    break label166;
    label68:
    int j = localJSONObject.optInt("type");
    for (;;)
    {
      if ((!TextUtils.isEmpty(str2)) && (j >= 1) && (j <= 3))
      {
        if (j == 1)
        {
          a(paramRequestEvent, str2, i, str1);
          return;
        }
        paramRequestEvent.fail(HardCodeUtil.a(2131903340));
        return;
      }
      paramRequestEvent.fail(HardCodeUtil.a(2131903341));
      return;
      label151:
      j = 0;
      if (localJSONObject != null) {
        break;
      }
      i = 0;
      label161:
      if (localJSONObject != null) {
        break label56;
      }
      label166:
      if (localJSONObject != null) {
        break label68;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.GroupPlugin
 * JD-Core Version:    0.7.0.1
 */