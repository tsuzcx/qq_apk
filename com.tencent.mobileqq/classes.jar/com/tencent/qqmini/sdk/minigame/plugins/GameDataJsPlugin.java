package com.tencent.qqmini.sdk.minigame.plugins;

import android.text.TextUtils;
import bgok;
import bgos;
import bgpv;
import bgxw;
import bgyk;
import bgyu;
import bgza;
import bgzb;
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
    if (bgpv.a(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = bgxw.a(this.mMiniAppContext).a();
      if (localObject == null) {
        continue;
      }
      try
      {
        localObject = ((bgyu)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("navigateToMiniProgramAppIdList");
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
  
  public String getLaunchOptionsSync(bgok parambgok)
  {
    Object localObject2 = null;
    bgza localbgza = bgxw.a(this.mMiniAppContext);
    bgzb localbgzb = localbgza.a();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (TextUtils.isEmpty(localbgzb.c))
      {
        localObject1 = null;
        localJSONObject2.put("appId", localObject1);
        if (!TextUtils.isEmpty(localbgzb.b)) {
          break label182;
        }
        localObject1 = null;
        label71:
        localJSONObject2.put("extraData", localObject1);
        localJSONObject1.put("scene", bgos.a(localbgzb.jdField_a_of_type_Int));
        localJSONObject1.put("query", localbgzb.jdField_a_of_type_OrgJsonJSONObject);
        if (!TextUtils.isEmpty(localbgzb.jdField_a_of_type_JavaLangString)) {
          break label191;
        }
      }
      label182:
      label191:
      for (Object localObject1 = localObject2;; localObject1 = localbgzb.jdField_a_of_type_JavaLangString)
      {
        localJSONObject1.put("shareTicket", localObject1);
        localJSONObject1.put("referrerInfo", localJSONObject2);
        localJSONObject1.put("extendData", localbgza.f());
        localJSONObject1.put("entryDataHash", localbgzb.d);
        return localJSONObject1.toString();
        localObject1 = localbgzb.c;
        break;
        localObject1 = localbgzb.b;
        break label71;
      }
      return parambgok.b();
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("GameDataJsPlugin", "API_GET_LAUNCH_OPTIONS_SYNC exception: ", localJSONException);
    }
  }
  
  public void getOpenDataUserInfo(bgok parambgok)
  {
    try
    {
      Object localObject = new JSONObject(parambgok.b);
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
        this.mChannelProxy.getUserInfoOpenData(this.mMiniAppInfo.appId, (String)localObject, arrayOfString, new GameDataJsPlugin.1(this, parambgok));
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      parambgok.b();
      QMLog.e("GameDataJsPlugin", "handle event:" + parambgok.jdField_a_of_type_JavaLangString + " error , ", localJSONException);
    }
  }
  
  public String navigateToMiniProgramConfig(bgok parambgok)
  {
    try
    {
      boolean bool = checkNavigationAppIdListForMiniGame(new JSONObject(parambgok.b).optString("appId"));
      parambgok = new JSONObject();
      try
      {
        parambgok.put("inList", bool);
        QMLog.d("GameDataJsPlugin", "navigateToMiniProgramConfig, callJs jsonObject = " + parambgok);
        return parambgok.toString();
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
    catch (JSONException parambgok)
    {
      QMLog.e("GameDataJsPlugin", parambgok.getMessage(), parambgok);
      parambgok.printStackTrace();
    }
  }
  
  public boolean onInterceptJsEvent(bgok parambgok)
  {
    if (!this.mIsMiniGame) {
      return true;
    }
    return super.onInterceptJsEvent(parambgok);
  }
  
  public void recordOffLineResourceState(bgok parambgok)
  {
    try
    {
      boolean bool = new JSONObject(parambgok.b).optBoolean("isComplete", false);
      bgyk.a(this.mMiniAppInfo, bool);
      parambgok.a();
      return;
    }
    catch (Throwable parambgok)
    {
      QMLog.e("GameDataJsPlugin", parambgok.getMessage(), parambgok);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.GameDataJsPlugin
 * JD-Core Version:    0.7.0.1
 */