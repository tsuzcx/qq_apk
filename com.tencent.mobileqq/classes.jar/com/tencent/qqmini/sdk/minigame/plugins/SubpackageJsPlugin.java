package com.tencent.qqmini.sdk.minigame.plugins;

import android.text.TextUtils;
import beka;
import bekg;
import bevc;
import bevi;
import bewt;
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
  
  public String createLoadSubPackageTask(beka parambeka)
  {
    try
    {
      localObject = new JSONObject(parambeka.b);
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
          return bekg.b(parambeka.a, (JSONObject)localObject).toString();
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
      bevc localbevc = bevi.a().a();
      if (localbevc != null)
      {
        bewt.a().i("SubpackageJsPlugin", "start loadSubPackage:" + localJSONObject + ", gameId:" + localbevc.d + ", gameName:" + localbevc.c);
        localbevc.a(localJSONObject, new SubpackageJsPlugin.1(this, localJSONObject, i, parambeka));
        localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("loadTaskId", i);
          return bekg.a(parambeka.a, localJSONObject).toString();
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
    return bekg.a(parambeka.a, null, "found no miniGamePkg error").toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.SubpackageJsPlugin
 * JD-Core Version:    0.7.0.1
 */