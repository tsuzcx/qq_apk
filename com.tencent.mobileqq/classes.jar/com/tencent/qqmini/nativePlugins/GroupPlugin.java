package com.tencent.qqmini.nativePlugins;

import alpo;
import android.content.Intent;
import android.text.TextUtils;
import awbw;
import awbx;
import bgho;
import bgkd;
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
  
  private void gotoSelectMembers(bgkd parambgkd, String paramString1, int paramInt, String paramString2)
  {
    MiniAppController.getInstance().setActivityResultListener(new GroupPlugin.1(this, parambgkd));
    BaseActivity localBaseActivity = (BaseActivity)this.mMiniAppContext.a();
    if ((TroopInfo)localBaseActivity.getAppInterface().getEntityManagerFactory().createEntityManager().a(TroopInfo.class, paramString1) != null)
    {
      gotoSelectMembers(paramInt, paramString2, localBaseActivity, paramString1);
      return;
    }
    parambgkd.a(alpo.a(2131705734));
  }
  
  public void getMultiMemList(bgkd parambgkd)
  {
    Object localObject = null;
    int j = 0;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(parambgkd.b).optJSONObject("data").optJSONObject("data");
        if (localJSONObject != null) {
          continue;
        }
        str = null;
      }
      catch (Exception parambgkd)
      {
        JSONObject localJSONObject;
        String str;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("GroupPlugin", 2, "===>onInvoke exception", parambgkd);
        return;
        parambgkd.a(alpo.a(2131705735));
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
        parambgkd.a(alpo.a(2131705736));
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
        gotoSelectMembers(parambgkd, (String)localObject, i, str);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.GroupPlugin
 * JD-Core Version:    0.7.0.1
 */