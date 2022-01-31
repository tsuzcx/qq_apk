package com.tencent.qqmini.sdk.minigame.plugins;

import android.text.TextUtils;
import bekr;
import bekx;
import bevt;
import bevz;
import bexk;
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
  
  public String createLoadSubPackageTask(bekr parambekr)
  {
    try
    {
      localObject = new JSONObject(parambekr.b);
      i = this.subpackageTaskId.getAndIncrement();
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("name", null);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label103;
        }
        localObject = new JSONObject();
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
          Object localObject;
          ((JSONObject)localObject).put("loadTaskId", i);
          ((JSONObject)localObject).put("state", "fail");
          return bekx.b(parambekr.a, (JSONObject)localObject).toString();
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
      bevt localbevt = bevz.a().a();
      if (localbevt != null)
      {
        bexk.a().i("SubpackageJsPlugin", "start loadSubPackage:" + localJSONObject + ", gameId:" + localbevt.d + ", gameName:" + localbevt.c);
        localbevt.a(localJSONObject, new SubpackageJsPlugin.1(this, localJSONObject, i, parambekr));
        localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("loadTaskId", i);
          return bekx.a(parambekr.a, localJSONObject).toString();
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
    return bekx.a(parambekr.a, null, "found no miniGamePkg error").toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.SubpackageJsPlugin
 * JD-Core Version:    0.7.0.1
 */