package com.tencent.qqmini.nativePlugins;

import alud;
import android.content.Intent;
import android.text.TextUtils;
import awgf;
import awgg;
import bglv;
import bgok;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import org.json.JSONObject;

public class GroupPlugin
  extends BaseJsPlugin
{
  public static final String GROUP_GETMULTIMEMLIST = "getMultiMemList";
  public static final String TAG = "GroupPlugin";
  
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
  
  private void gotoSelectMembers(bgok parambgok, String paramString1, int paramInt, String paramString2)
  {
    MiniAppController.getInstance().setActivityResultListener(new GroupPlugin.1(this, parambgok));
    BaseActivity localBaseActivity = (BaseActivity)this.mMiniAppContext.a();
    if ((TroopInfo)localBaseActivity.getAppInterface().getEntityManagerFactory().createEntityManager().a(TroopInfo.class, paramString1) != null)
    {
      gotoSelectMembers(paramInt, paramString2, localBaseActivity, paramString1);
      return;
    }
    parambgok.a(alud.a(2131705746));
  }
  
  public void getMultiMemList(bgok parambgok)
  {
    Object localObject = null;
    int j = 0;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(parambgok.b).optJSONObject("data").optJSONObject("data");
        if (localJSONObject != null) {
          continue;
        }
        str = null;
      }
      catch (Exception parambgok)
      {
        JSONObject localJSONObject;
        String str;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("GroupPlugin", 2, "===>onInvoke exception", parambgok);
        return;
        parambgok.a(alud.a(2131705747));
        return;
        if (localJSONObject != null) {
          continue;
        }
        int i = 0;
        if (localJSONObject != null) {
          continue;
        }
        if (localJSONObject != null) {
          continue;
        }
        continue;
      }
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (j < 1) || (j > 3))
      {
        parambgok.a(alud.a(2131705748));
        return;
        str = localJSONObject.optString("title");
        continue;
        i = localJSONObject.optInt("limitNum", 1);
        continue;
        localObject = localJSONObject.optString("listId");
        continue;
        j = localJSONObject.optInt("type");
      }
      else if (j == 1)
      {
        gotoSelectMembers(parambgok, (String)localObject, i, str);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.GroupPlugin
 * JD-Core Version:    0.7.0.1
 */