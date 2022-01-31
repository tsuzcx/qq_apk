package com.tencent.qqmini.sdk.minigame.plugins;

import android.text.TextUtils;
import bekr;
import bela;
import bely;
import betc;
import bevk;
import bevt;
import bevz;
import bewa;
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
    if (bely.a(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = bevz.a().a();
      if (localObject == null) {
        continue;
      }
      try
      {
        localObject = ((bevt)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("navigateToMiniProgramAppIdList");
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
  
  public String getLaunchOptionsSync(bekr parambekr)
  {
    Object localObject2 = null;
    bewa localbewa = bevz.a().a();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (TextUtils.isEmpty(localbewa.c))
      {
        localObject1 = null;
        localJSONObject2.put("appId", localObject1);
        if (!TextUtils.isEmpty(localbewa.b)) {
          break label175;
        }
        localObject1 = null;
        label63:
        localJSONObject2.put("extraData", localObject1);
        localJSONObject1.put("scene", bela.a(localbewa.jdField_a_of_type_Int));
        localJSONObject1.put("query", localbewa.jdField_a_of_type_OrgJsonJSONObject);
        if (!TextUtils.isEmpty(localbewa.jdField_a_of_type_JavaLangString)) {
          break label184;
        }
      }
      label175:
      label184:
      for (Object localObject1 = localObject2;; localObject1 = localbewa.jdField_a_of_type_JavaLangString)
      {
        localJSONObject1.put("shareTicket", localObject1);
        localJSONObject1.put("referrerInfo", localJSONObject2);
        localJSONObject1.put("extendData", bevz.a().f());
        localJSONObject1.put("entryDataHash", localbewa.d);
        return localJSONObject1.toString();
        localObject1 = localbewa.c;
        break;
        localObject1 = localbewa.b;
        break label63;
      }
      return parambekr.b();
    }
    catch (JSONException localJSONException)
    {
      betc.d("GameDataJsPlugin", "API_GET_LAUNCH_OPTIONS_SYNC exception: ", localJSONException);
    }
  }
  
  public void getOpenDataUserInfo(bekr parambekr)
  {
    try
    {
      Object localObject = new JSONObject(parambekr.b);
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
        this.mChannelProxy.getUserInfoOpenData(bevz.a().a(), (String)localObject, arrayOfString, new GameDataJsPlugin.1(this, parambekr));
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      parambekr.b();
      betc.d("GameDataJsPlugin", "handle event:" + parambekr.jdField_a_of_type_JavaLangString + " error , ", localJSONException);
    }
  }
  
  public String navigateToMiniProgramConfig(bekr parambekr)
  {
    try
    {
      boolean bool = checkNavigationAppIdListForMiniGame(new JSONObject(parambekr.b).optString("appId"));
      parambekr = new JSONObject();
      try
      {
        parambekr.put("inList", bool);
        betc.a("GameDataJsPlugin", "navigateToMiniProgramConfig, callJs jsonObject = " + parambekr);
        return parambekr.toString();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          betc.d("GameDataJsPlugin", localJSONException.getMessage(), localJSONException);
          localJSONException.printStackTrace();
        }
      }
      return "";
    }
    catch (JSONException parambekr)
    {
      betc.d("GameDataJsPlugin", parambekr.getMessage(), parambekr);
      parambekr.printStackTrace();
    }
  }
  
  public boolean onInterceptJsEvent(bekr parambekr)
  {
    if (!this.mIsMiniGame) {
      return true;
    }
    return super.onInterceptJsEvent(parambekr);
  }
  
  public void recordOffLineResourceState(bekr parambekr)
  {
    try
    {
      boolean bool = new JSONObject(parambekr.b).optBoolean("isComplete", false);
      bevk.a(bevz.a().a(), bool);
      parambekr.a();
      return;
    }
    catch (Throwable parambekr)
    {
      betc.d("GameDataJsPlugin", parambekr.getMessage(), parambekr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.GameDataJsPlugin
 * JD-Core Version:    0.7.0.1
 */