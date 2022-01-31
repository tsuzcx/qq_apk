package com.tencent.qqmini.sdk.minigame.plugins;

import android.text.TextUtils;
import bdfz;
import bdhe;
import bdnw;
import bdpp;
import bdpy;
import bdqa;
import bdqb;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GameDataJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "GameDataJsPlugin";
  private ChannelProxy mChannelProxy;
  
  private static boolean checkNavigationAppIdListForMiniGame(String paramString)
  {
    if (bdhe.a(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = bdqa.a().a();
      if (localObject == null) {
        continue;
      }
      try
      {
        localObject = ((bdpy)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("navigateToMiniProgramAppIdList");
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
  
  public String getLaunchOptionsSync(bdfz parambdfz)
  {
    Object localObject2 = null;
    bdqb localbdqb = bdqa.a().a();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (TextUtils.isEmpty(localbdqb.c))
      {
        localObject1 = null;
        localJSONObject2.put("appId", localObject1);
        if (!TextUtils.isEmpty(localbdqb.b)) {
          break label172;
        }
        localObject1 = null;
        label63:
        localJSONObject2.put("extraData", localObject1);
        localJSONObject1.put("scene", localbdqb.jdField_a_of_type_Int);
        localJSONObject1.put("query", localbdqb.jdField_a_of_type_OrgJsonJSONObject);
        if (!TextUtils.isEmpty(localbdqb.jdField_a_of_type_JavaLangString)) {
          break label181;
        }
      }
      label172:
      label181:
      for (Object localObject1 = localObject2;; localObject1 = localbdqb.jdField_a_of_type_JavaLangString)
      {
        localJSONObject1.put("shareTicket", localObject1);
        localJSONObject1.put("referrerInfo", localJSONObject2);
        localJSONObject1.put("extendData", bdqa.a().f());
        localJSONObject1.put("entryDataHash", localbdqb.d);
        return localJSONObject1.toString();
        localObject1 = localbdqb.c;
        break;
        localObject1 = localbdqb.b;
        break label63;
      }
      return parambdfz.b();
    }
    catch (JSONException localJSONException)
    {
      bdnw.d("GameDataJsPlugin", "API_GET_LAUNCH_OPTIONS_SYNC exception: ", localJSONException);
    }
  }
  
  public void getOpenDataUserInfo(bdfz parambdfz)
  {
    try
    {
      Object localObject = new JSONObject(parambdfz.b);
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
        this.mChannelProxy.getUserInfoOpenData(bdqa.a().a(), (String)localObject, arrayOfString, new GameDataJsPlugin.1(this, parambdfz));
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      parambdfz.b();
      bdnw.d("GameDataJsPlugin", "handle event:" + parambdfz.jdField_a_of_type_JavaLangString + " error , ", localJSONException);
    }
  }
  
  public String navigateToMiniProgramConfig(bdfz parambdfz)
  {
    try
    {
      boolean bool = checkNavigationAppIdListForMiniGame(new JSONObject(parambdfz.b).optString("appId"));
      parambdfz = new JSONObject();
      try
      {
        parambdfz.put("inList", bool);
        bdnw.a("GameDataJsPlugin", "navigateToMiniProgramConfig, callJs jsonObject = " + parambdfz);
        return parambdfz.toString();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          bdnw.d("GameDataJsPlugin", localJSONException.getMessage(), localJSONException);
          localJSONException.printStackTrace();
        }
      }
      return "";
    }
    catch (JSONException parambdfz)
    {
      bdnw.d("GameDataJsPlugin", parambdfz.getMessage(), parambdfz);
      parambdfz.printStackTrace();
    }
  }
  
  public boolean onInterceptJsEvent(bdfz parambdfz)
  {
    if (!this.mIsMiniGame) {
      return true;
    }
    return super.onInterceptJsEvent(parambdfz);
  }
  
  public void recordOffLineResourceState(bdfz parambdfz)
  {
    try
    {
      boolean bool = new JSONObject(parambdfz.b).optBoolean("isComplete", false);
      bdpp.a(bdqa.a().a(), bool);
      parambdfz.a();
      return;
    }
    catch (Throwable parambdfz)
    {
      bdnw.d("GameDataJsPlugin", parambdfz.getMessage(), parambdfz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.GameDataJsPlugin
 * JD-Core Version:    0.7.0.1
 */