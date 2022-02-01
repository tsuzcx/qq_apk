package com.tencent.mobileqq.microapp.ext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.ipc.IComIPCUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class GameProxy
{
  public static final String TAG = "GameProxy";
  
  public static boolean startGameByMiniApp(Activity paramActivity, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      i = Integer.parseInt(paramString);
    }
    catch (Throwable paramString)
    {
      int i;
      label25:
      long l;
      boolean bool1;
      int j;
      int k;
      String str3;
      String str1;
      String str2;
      boolean bool2;
      int m;
      String str4;
      String str5;
      String str6;
      break label25;
    }
    i = -1;
    if (i == -1) {
      return false;
    }
    paramJSONObject = paramJSONObject.optJSONObject("extraData");
    paramString = paramJSONObject;
    if (paramJSONObject == null) {
      paramString = new JSONObject();
    }
    l = paramString.optLong("roomId");
    if (paramString.optInt("isCreator", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (paramString.has("gameMode")) {
      j = paramString.optInt("gameMode");
    } else {
      j = 1;
    }
    k = paramString.optInt("src");
    str3 = paramString.optString("gameParam");
    str1 = paramString.optString("friendUin");
    str2 = paramString.optString("friendOpenId");
    bool2 = paramString.optBoolean("isEnterAIO");
    paramJSONObject = str2;
    if (TextUtils.isEmpty(str2)) {
      paramJSONObject = str1;
    }
    str2 = paramString.optString("uinName");
    m = paramString.optInt("openTempAIOOnFinish");
    str4 = paramString.optString("tempAIOUin");
    str5 = paramString.optString("tempAIONickName");
    str6 = paramString.optString("gameName");
    if (bool2)
    {
      paramString = new Bundle();
      paramString.putString("uin", str1);
      paramString.putInt("uintype", 0);
      paramString.putString("troop_uin", "");
      paramString.putString("uinname", str2);
      paramString.putBoolean("launchApolloGame", true);
      paramString.putInt("gameId", i);
      paramString.putInt("gameMode", j);
      paramString.putString("openId", paramJSONObject);
      paramString.putString("gameParam", str3);
      paramString.putString("gameName", str6);
      paramString.putInt("src", k);
      paramString.putInt("enter", 3);
      paramJSONObject = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), new int[] { 2 });
      paramJSONObject.putExtras(paramString);
      paramActivity.startActivity(paramJSONObject);
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("[startApolloGame] openAIO:");
        paramActivity.append(paramString.toString());
        QLog.d("GameProxy", 2, paramActivity.toString());
      }
      return true;
    }
    paramActivity = new StartCheckParam(i, bool1, "luanch", l, 4, j, 0, 0, "", k, str6);
    paramActivity.mExtraStr = paramString.toString();
    paramActivity.extendJson = str3;
    paramActivity.mFriendUin = paramJSONObject;
    paramActivity.mTempAIONickName = str5;
    paramActivity.mTempAIOUin = str4;
    if (m == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramActivity.mOpenTempAIOOnFinish = bool1;
    if (paramActivity.src == 318) {
      paramActivity.disableMinGame = true;
    }
    ((IComIPCUtils)QRoute.api(IComIPCUtils.class)).startApolloGame(paramActivity);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.ext.GameProxy
 * JD-Core Version:    0.7.0.1
 */