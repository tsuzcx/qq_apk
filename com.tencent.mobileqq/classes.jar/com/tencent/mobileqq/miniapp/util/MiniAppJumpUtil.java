package com.tencent.mobileqq.miniapp.util;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.miniapp.MiniAppManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class MiniAppJumpUtil
{
  public static MiniAppJumpUtil.JumpParam a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = Uri.parse(paramString);
    if (!paramString.isHierarchical()) {
      return null;
    }
    paramString = paramString.getQueryParameter("_appinfo");
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = Base64.decode(paramString, 10);
        if (paramString == null)
        {
          if (!QLog.isColorLevel()) {
            break label154;
          }
          QLog.i("miniAppJump", 2, "appinfo decode error 2");
          return null;
        }
        paramString = new JSONObject(new String(paramString, "UTF-8"));
        MiniAppJumpUtil.JumpParam localJumpParam = new MiniAppJumpUtil.JumpParam();
        localJumpParam.a = paramString.getInt("type");
        localJumpParam.b = paramString.getString("appid");
        localJumpParam.c = paramString.optString("pageName");
        localJumpParam.e = paramString.optInt("from");
        localJumpParam.d = paramString.optJSONObject("param");
        return localJumpParam;
      }
      catch (Exception paramString)
      {
        QLog.e("miniAppJump", 1, "parse miniapp jump url error", paramString);
      }
    } else {
      return null;
    }
    label154:
    return null;
  }
  
  public static boolean a(Activity paramActivity, MiniAppJumpUtil.JumpParam paramJumpParam, Bundle paramBundle)
  {
    if (paramJumpParam == null) {
      return false;
    }
    if (paramJumpParam.a == 4) {
      return false;
    }
    if (paramJumpParam.a == 3)
    {
      MiniAppManager.a(paramActivity, paramJumpParam.b, paramJumpParam.a, null);
      return true;
    }
    return false;
  }
  
  public static boolean a(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    return a(paramActivity, a(paramString), paramBundle);
  }
  
  public static boolean a(BaseActivity paramBaseActivity, String paramString, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    QQAppInterface localQQAppInterface = paramBaseActivity.app;
    localBundle.putString("uin", localQQAppInterface.getCurrentAccountUin());
    if (paramMessageRecord.istroop == 1)
    {
      localBundle.putString("gc", paramMessageRecord.frienduin);
      if ((!TroopUtils.a(localQQAppInterface, paramMessageRecord.frienduin, localQQAppInterface.getCurrentUin())) && (!((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(localQQAppInterface, paramMessageRecord.frienduin, localQQAppInterface.getCurrentUin()))) {
        bool = false;
      } else {
        bool = true;
      }
      localBundle.putBoolean("isAdmin", bool);
    }
    paramString = a(paramString);
    boolean bool = a(paramBaseActivity, paramString, localBundle);
    if ((paramString != null) && (bool) && ((paramMessageRecord instanceof MessageForGrayTips)) && (paramString.a == 4) && (paramString.b.equals("101474665")))
    {
      if (paramString.e == 1)
      {
        ReportController.b(localQQAppInterface, "dc00899", "Grp_idol", "", "idol_follow", "follow_suc_clk", 0, 0, paramMessageRecord.frienduin, "", "", "");
        return bool;
      }
      if (paramString.e == 2) {
        TroopReportor.a("Grp_idol", "Grp_AIO", "clk_renwu", 0, 0, new String[] { paramMessageRecord.frienduin });
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.util.MiniAppJumpUtil
 * JD-Core Version:    0.7.0.1
 */