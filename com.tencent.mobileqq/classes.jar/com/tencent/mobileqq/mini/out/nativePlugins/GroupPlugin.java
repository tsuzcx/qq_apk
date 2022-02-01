package com.tencent.mobileqq.mini.out.nativePlugins;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class GroupPlugin
  implements NativePlugin
{
  public static final String GROUP_GETMULTIMEMLIST = "getMultiMemList";
  public static final String TAG = "GroupPlugin";
  JSContext mJsContext;
  GroupPlugin.MyActivityResultListener myActivityResultListener;
  
  private static void gotoSelectMembers(int paramInt, String paramString1, BaseActivity paramBaseActivity, String paramString2)
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
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(paramBaseActivity, localIntent, 10);
    paramBaseActivity.overridePendingTransition(2130772011, 0);
  }
  
  private void gotoSelectMembers(String paramString1, int paramInt, String paramString2)
  {
    JSContext localJSContext = this.mJsContext;
    if (localJSContext == null) {
      return;
    }
    if (this.myActivityResultListener == null) {
      this.myActivityResultListener = new GroupPlugin.MyActivityResultListener(this, null);
    }
    MiniAppController.getInstance().setActivityResultListener(this.myActivityResultListener);
    BaseActivity localBaseActivity = (BaseActivity)localJSContext.getActivity();
    if ((TroopInfo)localBaseActivity.getAppInterface().getEntityManagerFactory().createEntityManager().find(TroopInfo.class, paramString1) != null)
    {
      gotoSelectMembers(paramInt, paramString2, localBaseActivity, paramString1);
      return;
    }
    localJSContext.evaluateCallback(false, new JSONObject(), HardCodeUtil.a(2131705451));
  }
  
  public void onDestroy()
  {
    if (this.myActivityResultListener != null) {
      MiniAppController.getInstance().removeActivityResultListener(this.myActivityResultListener);
    }
  }
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    if (paramJSContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GroupPlugin", 2, "onInvoke jsContext is null return");
      }
      return;
    }
    JSONObject localJSONObject;
    try
    {
      this.mJsContext = paramJSContext;
      if (QLog.isColorLevel()) {
        QLog.w("GroupPlugin", 2, paramJSONObject.toString());
      }
      if (!"getMultiMemList".equals(paramJSONObject.optString("api_name"))) {
        break label213;
      }
      localJSONObject = paramJSONObject.optJSONObject("data");
      str = null;
      if (localJSONObject == null) {
        paramJSONObject = null;
      } else {
        paramJSONObject = localJSONObject.optString("title");
      }
    }
    catch (Exception paramJSONObject)
    {
      String str;
      if (!QLog.isColorLevel()) {
        break label213;
      }
      QLog.i("GroupPlugin", 2, "===>onInvoke exception", paramJSONObject);
    }
    int i = localJSONObject.optInt("limitNum", 1);
    break label221;
    label98:
    str = localJSONObject.optString("listId");
    label110:
    for (int j = localJSONObject.optInt("type");; j = 0)
    {
      if ((!TextUtils.isEmpty(str)) && (j >= 1) && (j <= 3))
      {
        if (j == 1)
        {
          gotoSelectMembers(str, i, paramJSONObject);
          return;
        }
        paramJSContext.evaluateCallback(false, new JSONObject(), HardCodeUtil.a(2131705452));
        return;
      }
      paramJSContext.evaluateCallback(false, new JSONObject(), HardCodeUtil.a(2131705453));
      return;
      return;
      if (localJSONObject != null) {
        break;
      }
      i = 0;
      if (localJSONObject != null) {
        break label98;
      }
      if (localJSONObject != null) {
        break label110;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.GroupPlugin
 * JD-Core Version:    0.7.0.1
 */