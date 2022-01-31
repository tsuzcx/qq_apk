package com.tencent.qqmini.sdk.minigame.plugins;

import android.text.TextUtils;
import bgkd;
import bgkl;
import bglo;
import bgtp;
import bgud;
import bgun;
import bgut;
import bguu;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GameDataJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "GameDataJsPlugin";
  private ChannelProxy mChannelProxy;
  
  private boolean checkNavigationAppIdListForMiniGame(String paramString)
  {
    if (bglo.a(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = bgtp.a(this.mMiniAppContext).a();
      if (localObject == null) {
        continue;
      }
      try
      {
        localObject = ((bgun)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("navigateToMiniProgramAppIdList");
        int i = 0;
        while ((localObject != null) && (i < paramString.length()))
        {
          boolean bool = paramString.equals(((JSONArray)localObject).getString(i));
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public String getLaunchOptionsSync(bgkd parambgkd)
  {
    Object localObject2 = null;
    bgut localbgut = bgtp.a(this.mMiniAppContext);
    bguu localbguu = localbgut.a();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (TextUtils.isEmpty(localbguu.c))
      {
        localObject1 = null;
        localJSONObject2.put("appId", localObject1);
        if (!TextUtils.isEmpty(localbguu.b)) {
          break label182;
        }
        localObject1 = null;
        label71:
        localJSONObject2.put("extraData", localObject1);
        localJSONObject1.put("scene", bgkl.a(localbguu.jdField_a_of_type_Int));
        localJSONObject1.put("query", localbguu.jdField_a_of_type_OrgJsonJSONObject);
        if (!TextUtils.isEmpty(localbguu.jdField_a_of_type_JavaLangString)) {
          break label191;
        }
      }
      label182:
      label191:
      for (Object localObject1 = localObject2;; localObject1 = localbguu.jdField_a_of_type_JavaLangString)
      {
        localJSONObject1.put("shareTicket", localObject1);
        localJSONObject1.put("referrerInfo", localJSONObject2);
        localJSONObject1.put("extendData", localbgut.f());
        localJSONObject1.put("entryDataHash", localbguu.d);
        return localJSONObject1.toString();
        localObject1 = localbguu.c;
        break;
        localObject1 = localbguu.b;
        break label71;
      }
      return parambgkd.b();
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("GameDataJsPlugin", "API_GET_LAUNCH_OPTIONS_SYNC exception: ", localJSONException);
    }
  }
  
  public void getOpenDataUserInfo(bgkd parambgkd)
  {
    try
    {
      Object localObject = new JSONObject(parambgkd.b);
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("openIdList");
      localObject = ((JSONObject)localObject).optString("lang", "en");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        String[] arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < localJSONArray.length())
        {
          arrayOfString[i] = localJSONArray.getString(i);
          i += 1;
        }
        this.mChannelProxy.getUserInfoOpenData(this.mMiniAppInfo.appId, (String)localObject, arrayOfString, new GameDataJsPlugin.1(this, parambgkd));
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      parambgkd.b();
      QMLog.e("GameDataJsPlugin", "handle event:" + parambgkd.jdField_a_of_type_JavaLangString + " error , ", localJSONException);
    }
  }
  
  public String navigateToMiniProgramConfig(bgkd parambgkd)
  {
    try
    {
      boolean bool = checkNavigationAppIdListForMiniGame(new JSONObject(parambgkd.b).optString("appId"));
      parambgkd = new JSONObject();
      try
      {
        parambgkd.put("inList", bool);
        QMLog.d("GameDataJsPlugin", "navigateToMiniProgramConfig, callJs jsonObject = " + parambgkd);
        return parambgkd.toString();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QMLog.e("GameDataJsPlugin", localJSONException.getMessage(), localJSONException);
          localJSONException.printStackTrace();
        }
      }
      return "";
    }
    catch (JSONException parambgkd)
    {
      QMLog.e("GameDataJsPlugin", parambgkd.getMessage(), parambgkd);
      parambgkd.printStackTrace();
    }
  }
  
  public boolean onInterceptJsEvent(bgkd parambgkd)
  {
    if (!this.mIsMiniGame) {
      return true;
    }
    return super.onInterceptJsEvent(parambgkd);
  }
  
  public void recordOffLineResourceState(bgkd parambgkd)
  {
    try
    {
      boolean bool = new JSONObject(parambgkd.b).optBoolean("isComplete", false);
      bgud.a(this.mMiniAppInfo, bool);
      parambgkd.a();
      return;
    }
    catch (Throwable parambgkd)
    {
      QMLog.e("GameDataJsPlugin", parambgkd.getMessage(), parambgkd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.GameDataJsPlugin
 * JD-Core Version:    0.7.0.1
 */