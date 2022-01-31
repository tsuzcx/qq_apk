package com.tencent.qqmini.sdk.minigame.plugins;

import android.text.TextUtils;
import bgok;
import bgop;
import bgxw;
import bgyu;
import bgza;
import bhaj;
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
  
  public String createLoadSubPackageTask(bgok parambgok)
  {
    try
    {
      localObject1 = new JSONObject(parambgok.b);
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
          return bgop.b(parambgok.a, (JSONObject)localObject1).toString();
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
      Object localObject2 = bgxw.a(this.mMiniAppContext);
      if (localObject2 != null) {
        localObject2 = ((bgza)localObject2).a();
      }
      for (;;)
      {
        if (localObject2 != null)
        {
          bhaj.a().i("SubpackageJsPlugin", "start loadSubPackage:" + localJSONObject + ", gameId:" + ((bgyu)localObject2).appId + ", gameName:" + ((bgyu)localObject2).apkgName);
          ((bgyu)localObject2).a(this.mMiniAppInfo, localJSONObject, new SubpackageJsPlugin.1(this, localJSONObject, i, parambgok));
          localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("loadTaskId", i);
            return bgop.a(parambgok.a, localJSONObject).toString();
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
    return bgop.a(parambgok.a, null, "found no miniGamePkg error").toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.SubpackageJsPlugin
 * JD-Core Version:    0.7.0.1
 */