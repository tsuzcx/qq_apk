package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CanvasJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_DRAW_CANVAS = "drawCanvas";
  private static final String EVENT_GET_INAGE_DATA = "canvasGetImageData";
  private static final String EVENT_MEASURE_TEXT = "measureText";
  public static final String EVENT_PUT_IMAGE_DATA = "canvasPutImageData";
  private static final String EVENT_TO_TEMP_FILE_PATH = "canvasToTempFilePath";
  public static final String TAG = "[mini] CanvasJsPlugin";
  Set<String> eventMap = new HashSet();
  
  public CanvasJsPlugin()
  {
    this.eventMap.add("drawCanvas");
    this.eventMap.add("measureText");
    this.eventMap.add("canvasToTempFilePath");
    this.eventMap.add("canvasGetImageData");
    this.eventMap.add("canvasPutImageData");
  }
  
  private void callback(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString1, String paramString2)
  {
    if ((paramJsRuntime != null) && (paramJSONObject != null)) {
      paramJsRuntime.evaluateCallbackJs(paramInt, JSONUtil.append(paramJSONObject, "errMsg", paramString1 + ":" + paramString2).toString());
    }
  }
  
  private void callbackComplete(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString)
  {
    callback(paramJsRuntime, paramJSONObject, paramInt, paramString, "complete");
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] CanvasJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    if ("drawCanvas".equals(paramString1)) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = new JSONObject(paramString2);
        int i = ((JSONObject)localObject1).optInt("canvasId");
        boolean bool1 = ((JSONObject)localObject1).optBoolean("reserve", false);
        boolean bool2 = ((JSONObject)localObject1).optBoolean("useHardwareAccelerate");
        localObject1 = ((JSONObject)localObject1).optJSONArray("actions");
        localObject2 = ((AppBrandRuntime)this.jsPluginEngine.appBrandRuntime).pageContainer.getCurrentWebviewContainer();
        if (localObject2 != null)
        {
          ((WebviewContainer)localObject2).drawCanvas(i, bool1, bool2, (JSONArray)localObject1, paramString1, paramInt);
          localObject1 = ApiUtil.wrapCallbackOk(paramString1, null);
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((JSONObject)localObject1).toString();
          ((WebviewContainer)localObject2).appBrandRuntime.serviceRuntime.evaluateCallbackJs(paramInt, (String)localObject1);
        }
      }
      catch (JSONException localJSONException1)
      {
        Object localObject1;
        localJSONException1.printStackTrace();
        continue;
      }
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      localObject1 = "";
      continue;
      if ("measureText".equals(paramString1))
      {
        try
        {
          JSONObject localJSONObject1 = new JSONObject(paramString2);
          localObject2 = new Paint(1);
          String str = localJSONObject1.optString("fontFamily");
          if ("normal".equals(localJSONObject1.optString("fontStyle"))) {
            ((Paint)localObject2).setTypeface(Typeface.create(str, 0));
          }
          str = localJSONObject1.optString("text");
          ((Paint)localObject2).setTextSize(localJSONObject1.optInt("fontSize"));
          float f = ((Paint)localObject2).measureText(str);
          localJSONObject1 = new JSONObject();
          try
          {
            localJSONObject1.put("width", f);
            localJSONObject1 = ApiUtil.wrapCallbackOk(paramString1, localJSONObject1);
            callbackComplete(paramJsRuntime, localJSONObject1, paramInt, paramString1);
            return localJSONObject1.toString();
          }
          catch (JSONException localJSONException3)
          {
            for (;;)
            {
              localJSONException3.printStackTrace();
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
      else
      {
        WebviewContainer localWebviewContainer;
        if ("canvasToTempFilePath".equals(paramString1))
        {
          localWebviewContainer = ((AppBrandRuntime)this.jsPluginEngine.appBrandRuntime).pageContainer.getCurrentWebviewContainer();
          if (localWebviewContainer != null) {
            try
            {
              JSONObject localJSONObject2 = new JSONObject(paramString2);
              localWebviewContainer.saveCanvasFile(localJSONObject2.optInt("canvasId"), paramString1, paramInt, localJSONObject2);
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
              localWebviewContainer.callbackJsEventFail(paramString1, null, paramInt);
            }
          }
        }
        else if ("canvasGetImageData".equals(paramString1))
        {
          localWebviewContainer = ((AppBrandRuntime)this.jsPluginEngine.appBrandRuntime).pageContainer.getCurrentWebviewContainer();
          if (localWebviewContainer != null) {
            try
            {
              JSONObject localJSONObject3 = new JSONObject(paramString2);
              localWebviewContainer.getImageData(localJSONObject3.optInt("canvasId"), paramString1, paramInt, localJSONObject3);
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
              localWebviewContainer.callbackJsEventFail(paramString1, null, paramInt);
            }
          }
        }
        else if ("canvasPutImageData".equals(paramString1))
        {
          localWebviewContainer = ((AppBrandRuntime)this.jsPluginEngine.appBrandRuntime).pageContainer.getCurrentWebviewContainer();
          if (localWebviewContainer != null) {
            try
            {
              JSONObject localJSONObject4 = new JSONObject(paramString2);
              localWebviewContainer.putImageData(localJSONObject4.optInt("canvasId"), paramString1, paramInt, localJSONObject4);
            }
            catch (Exception localException3)
            {
              localException3.printStackTrace();
              localWebviewContainer.callbackJsEventFail(paramString1, null, paramInt);
            }
          }
        }
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.CanvasJsPlugin
 * JD-Core Version:    0.7.0.1
 */