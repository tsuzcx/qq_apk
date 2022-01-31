package com.tencent.mobileqq.microapp.ext;

import aciy;
import agwb;
import aifg;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class GameProxy
{
  public static final String TAG = "GameProxy";
  
  public static void handleMiniAppBack(QQAppInterface paramQQAppInterface)
  {
    try
    {
      paramQQAppInterface = (aifg)paramQQAppInterface.getManager(153);
      if (paramQQAppInterface != null)
      {
        if (!paramQQAppInterface.i()) {
          return;
        }
        if ((!paramQQAppInterface.g()) && (!paramQQAppInterface.h()))
        {
          paramQQAppInterface.h = false;
          paramQQAppInterface = BaseApplicationImpl.getContext();
          Intent localIntent = new Intent(paramQQAppInterface, SplashActivity.class);
          localIntent.putExtra("fragment_id", 1);
          localIntent.putExtra("tab_index", MainFragment.b);
          localIntent.putExtra("fromApolloNewUser", 2);
          localIntent.setFlags(335609856);
          paramQQAppInterface.startActivity(localIntent);
          return;
        }
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static boolean startGameByMiniApp(Activity paramActivity, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    int i;
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {
      i = -1;
    }
    try
    {
      j = Integer.parseInt(paramString);
      i = j;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        int j;
        long l;
        boolean bool1;
        int k;
        String str2;
        int m;
        String str4;
        String str5;
        String str6;
        continue;
      }
    }
    if (i == -1) {
      return false;
    }
    paramString = paramJSONObject.optJSONObject("extraData");
    if (paramString == null)
    {
      paramString = new JSONObject();
      l = paramString.optLong("roomId");
      if (paramString.optInt("isCreator", 1) == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        j = 1;
        if (paramString.has("gameMode")) {
          j = paramString.optInt("gameMode");
        }
        k = paramString.optInt("src");
        str2 = paramString.optString("gameParam");
        String str1 = paramString.optString("friendUin");
        paramJSONObject = paramString.optString("friendOpenId");
        boolean bool2 = paramString.optBoolean("isEnterAIO");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          break label468;
        }
        paramJSONObject = str1;
        String str3 = paramString.optString("uinName");
        m = paramString.optInt("openTempAIOOnFinish");
        str4 = paramString.optString("tempAIOUin");
        str5 = paramString.optString("tempAIONickName");
        str6 = paramString.optString("gameName");
        if (!bool2) {
          break;
        }
        paramString = new Bundle();
        paramString.putString("uin", str1);
        paramString.putInt("uintype", 0);
        paramString.putString("troop_uin", "");
        paramString.putString("uinname", str3);
        paramString.putBoolean("launchApolloGame", true);
        paramString.putInt("gameId", i);
        paramString.putInt("gameMode", j);
        paramString.putString("openId", paramJSONObject);
        paramString.putString("gameParam", str2);
        paramString.putString("gameName", str6);
        paramString.putInt("src", k);
        paramString.putInt("enter", 3);
        paramJSONObject = aciy.a(new Intent(paramActivity, SplashActivity.class), new int[] { 2 });
        paramJSONObject.putExtras(paramString);
        paramActivity.startActivity(paramJSONObject);
        if (QLog.isColorLevel()) {
          QLog.d("GameProxy", 2, "[startApolloGame] openAIO:" + paramString.toString());
        }
        return true;
      }
      paramActivity = new CmGameStartChecker.StartCheckParam(i, bool1, "luanch", l, 4, j, 0, 0, "", k, str6);
      paramActivity.mExtraStr = paramString.toString();
      paramActivity.extendJson = str2;
      paramActivity.mFriendUin = paramJSONObject;
      paramActivity.mTempAIONickName = str5;
      paramActivity.mTempAIOUin = str4;
      if (m == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        paramActivity.mOpenTempAIOOnFinish = bool1;
        if (paramActivity.src == 318) {
          paramActivity.disableMinGame = true;
        }
        agwb.a(paramActivity);
        return true;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.ext.GameProxy
 * JD-Core Version:    0.7.0.1
 */