package com.tencent.mobileqq.mini.out.nativePlugins;

import android.content.Intent;
import android.text.TextUtils;
import anvx;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class GroupPlugin
  implements NativePlugin
{
  public static final String GROUP_GETMULTIMEMLIST = "getMultiMemList";
  public static final String TAG = "GroupPlugin";
  NativePlugin.JSContext mJsContext;
  GroupPlugin.MyActivityResultListener myActivityResultListener;
  
  private static void gotoSelectMembers(int paramInt, String paramString1, BaseActivity paramBaseActivity, String paramString2)
  {
    Intent localIntent = new Intent(paramBaseActivity, SelectMemberActivity.class);
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
    paramBaseActivity.startActivityForResult(localIntent, 10);
    paramBaseActivity.overridePendingTransition(2130771997, 0);
  }
  
  private void gotoSelectMembers(String paramString1, int paramInt, String paramString2)
  {
    NativePlugin.JSContext localJSContext = this.mJsContext;
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
    localJSContext.evaluateCallback(false, new JSONObject(), anvx.a(2131704835));
  }
  
  public void onDestroy()
  {
    if (this.myActivityResultListener != null) {
      MiniAppController.getInstance().removeActivityResultListener(this.myActivityResultListener);
    }
  }
  
  public void onInvoke(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    Object localObject = null;
    int j = 0;
    if (paramJSContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GroupPlugin", 2, "onInvoke jsContext is null return");
      }
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        this.mJsContext = paramJSContext;
        if (QLog.isColorLevel()) {
          QLog.w("GroupPlugin", 2, paramJSONObject.toString());
        }
        if (!"getMultiMemList".equals(paramJSONObject.optString("api_name"))) {
          break;
        }
        localJSONObject = paramJSONObject.optJSONObject("data");
        if (localJSONObject != null) {
          break label135;
        }
        paramJSONObject = null;
      }
      catch (Exception paramJSONObject) {}
      label135:
      label146:
      int i;
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (j < 1) || (j > 3))
      {
        paramJSContext.evaluateCallback(false, new JSONObject(), anvx.a(2131704837));
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("GroupPlugin", 2, "===>onInvoke exception", paramJSONObject);
        return;
        paramJSONObject = localJSONObject.optString("title");
        break label217;
        i = localJSONObject.optInt("limitNum", 1);
        break label224;
        label158:
        localObject = localJSONObject.optString("listId");
      }
      label217:
      label224:
      while (localJSONObject != null)
      {
        j = localJSONObject.optInt("type");
        break;
        if (j == 1)
        {
          gotoSelectMembers((String)localObject, i, paramJSONObject);
          return;
        }
        paramJSContext.evaluateCallback(false, new JSONObject(), anvx.a(2131704836));
        return;
        if (localJSONObject != null) {
          break label146;
        }
        i = 0;
        if (localJSONObject != null) {
          break label158;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.GroupPlugin
 * JD-Core Version:    0.7.0.1
 */