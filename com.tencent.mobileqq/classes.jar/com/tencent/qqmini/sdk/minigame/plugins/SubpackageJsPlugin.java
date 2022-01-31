package com.tencent.qqmini.sdk.minigame.plugins;

import android.text.TextUtils;
import bgkd;
import bgki;
import bgtp;
import bgun;
import bgut;
import bgwc;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class SubpackageJsPlugin
  extends BaseJsPlugin
{
  public static final String API_CREATE_LOAD_SUBPACKAGE_TASK = "createLoadSubPackageTask";
  public static final String EVENT_ON_LOAD_SUBPACKAGE_TASK_STATE_CHANGE = "onLoadSubPackageTaskStateChange";
  private static final String TAG = "SubpackageJsPlugin";
  private AtomicInteger subpackageTaskId = new AtomicInteger(0);
  
  public String createLoadSubPackageTask(bgkd parambgkd)
  {
    try
    {
      localObject1 = new JSONObject(parambgkd.b);
      i = this.subpackageTaskId.getAndIncrement();
      if (localObject1 != null)
      {
        localObject1 = ((JSONObject)localObject1).optString("name", null);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label103;
        }
        localObject1 = new JSONObject();
      }
    }
    catch (Throwable localThrowable)
    {
      int i;
      JSONObject localJSONObject;
      try
      {
        for (;;)
        {
          Object localObject1;
          ((JSONObject)localObject1).put("loadTaskId", i);
          ((JSONObject)localObject1).put("state", "fail");
          return bgki.b(parambgkd.a, (JSONObject)localObject1).toString();
          localThrowable = localThrowable;
          localJSONObject = new JSONObject();
        }
        localJSONObject = null;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
        }
      }
      label103:
      Object localObject2 = bgtp.a(this.mMiniAppContext);
      if (localObject2 != null) {
        localObject2 = ((bgut)localObject2).a();
      }
      for (;;)
      {
        if (localObject2 != null)
        {
          bgwc.a().i("SubpackageJsPlugin", "start loadSubPackage:" + localJSONObject + ", gameId:" + ((bgun)localObject2).appId + ", gameName:" + ((bgun)localObject2).apkgName);
          ((bgun)localObject2).a(this.mMiniAppInfo, localJSONObject, new SubpackageJsPlugin.1(this, localJSONObject, i, parambgkd));
          localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("loadTaskId", i);
            return bgki.a(parambgkd.a, localJSONObject).toString();
            localObject2 = null;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              localJSONException2.printStackTrace();
            }
          }
        }
      }
    }
    return bgki.a(parambgkd.a, null, "found no miniGamePkg error").toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.SubpackageJsPlugin
 * JD-Core Version:    0.7.0.1
 */