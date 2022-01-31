package com.tencent.qqmini.sdk.minigame.plugins;

import android.text.TextUtils;
import beka;
import bekj;
import belh;
import besl;
import beut;
import bevc;
import bevi;
import bevj;
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
    if (belh.a(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = bevi.a().a();
      if (localObject == null) {
        continue;
      }
      try
      {
        localObject = ((bevc)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("navigateToMiniProgramAppIdList");
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
  
  public String getLaunchOptionsSync(beka parambeka)
  {
    Object localObject2 = null;
    bevj localbevj = bevi.a().a();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (TextUtils.isEmpty(localbevj.c))
      {
        localObject1 = null;
        localJSONObject2.put("appId", localObject1);
        if (!TextUtils.isEmpty(localbevj.b)) {
          break label175;
        }
        localObject1 = null;
        label63:
        localJSONObject2.put("extraData", localObject1);
        localJSONObject1.put("scene", bekj.a(localbevj.jdField_a_of_type_Int));
        localJSONObject1.put("query", localbevj.jdField_a_of_type_OrgJsonJSONObject);
        if (!TextUtils.isEmpty(localbevj.jdField_a_of_type_JavaLangString)) {
          break label184;
        }
      }
      label175:
      label184:
      for (Object localObject1 = localObject2;; localObject1 = localbevj.jdField_a_of_type_JavaLangString)
      {
        localJSONObject1.put("shareTicket", localObject1);
        localJSONObject1.put("referrerInfo", localJSONObject2);
        localJSONObject1.put("extendData", bevi.a().f());
        localJSONObject1.put("entryDataHash", localbevj.d);
        return localJSONObject1.toString();
        localObject1 = localbevj.c;
        break;
        localObject1 = localbevj.b;
        break label63;
      }
      return parambeka.b();
    }
    catch (JSONException localJSONException)
    {
      besl.d("GameDataJsPlugin", "API_GET_LAUNCH_OPTIONS_SYNC exception: ", localJSONException);
    }
  }
  
  public void getOpenDataUserInfo(beka parambeka)
  {
    try
    {
      Object localObject = new JSONObject(parambeka.b);
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
        this.mChannelProxy.getUserInfoOpenData(bevi.a().a(), (String)localObject, arrayOfString, new GameDataJsPlugin.1(this, parambeka));
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      parambeka.b();
      besl.d("GameDataJsPlugin", "handle event:" + parambeka.jdField_a_of_type_JavaLangString + " error , ", localJSONException);
    }
  }
  
  public String navigateToMiniProgramConfig(beka parambeka)
  {
    try
    {
      boolean bool = checkNavigationAppIdListForMiniGame(new JSONObject(parambeka.b).optString("appId"));
      parambeka = new JSONObject();
      try
      {
        parambeka.put("inList", bool);
        besl.a("GameDataJsPlugin", "navigateToMiniProgramConfig, callJs jsonObject = " + parambeka);
        return parambeka.toString();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          besl.d("GameDataJsPlugin", localJSONException.getMessage(), localJSONException);
          localJSONException.printStackTrace();
        }
      }
      return "";
    }
    catch (JSONException parambeka)
    {
      besl.d("GameDataJsPlugin", parambeka.getMessage(), parambeka);
      parambeka.printStackTrace();
    }
  }
  
  public boolean onInterceptJsEvent(beka parambeka)
  {
    if (!this.mIsMiniGame) {
      return true;
    }
    return super.onInterceptJsEvent(parambeka);
  }
  
  public void recordOffLineResourceState(beka parambeka)
  {
    try
    {
      boolean bool = new JSONObject(parambeka.b).optBoolean("isComplete", false);
      beut.a(bevi.a().a(), bool);
      parambeka.a();
      return;
    }
    catch (Throwable parambeka)
    {
      besl.d("GameDataJsPlugin", parambeka.getMessage(), parambeka);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.GameDataJsPlugin
 * JD-Core Version:    0.7.0.1
 */