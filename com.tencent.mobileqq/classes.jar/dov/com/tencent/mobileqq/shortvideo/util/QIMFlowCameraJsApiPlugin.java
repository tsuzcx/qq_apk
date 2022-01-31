package dov.com.tencent.mobileqq.shortvideo.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aoyz;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMJSPreFlowCameraActivity;
import dov.com.tencent.mobileqq.shortvideo.util.videoconverter.ShortVideoTravellerManager.TravellerVideoItem;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QIMFlowCameraJsApiPlugin
  extends WebViewPlugin
{
  private Client.onRemoteRespObserver a = new aoyz(this);
  
  public QIMFlowCameraJsApiPlugin()
  {
    this.mPluginNameSpace = "qim_flowCamera_open";
  }
  
  public JSONArray a(ArrayList paramArrayList)
  {
    ShortVideoTravellerManager.TravellerVideoItem localTravellerVideoItem = null;
    Object localObject = localTravellerVideoItem;
    if (paramArrayList != null)
    {
      localObject = localTravellerVideoItem;
      if (paramArrayList.size() > 0)
      {
        localObject = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localTravellerVideoItem = (ShortVideoTravellerManager.TravellerVideoItem)paramArrayList.next();
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("video_id", localTravellerVideoItem.video_id);
            localJSONObject.put("url", localTravellerVideoItem.url);
            localJSONObject.put("name", localTravellerVideoItem.name);
            ((JSONArray)localObject).put(localJSONObject);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    return localObject;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFlowCameraJsApiPlugin", 2, "Call QIMFlowCameraJsApiPlugin handleJsRequest, url" + paramString1 + " pkgName:" + paramString2);
    }
    if ((paramString1 == null) || (!"qim_flowCamera_open".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
    if (paramJsBridgeListener == null) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMFlowCameraJsApiPlugin", 2, "handleJsRequest JSON = " + paramJsBridgeListener.toString());
    }
    paramJsBridgeListener = paramJsBridgeListener.optString("callback");
    if (TextUtils.isEmpty(paramJsBridgeListener))
    {
      QLog.e("QIMFlowCameraJsApiPlugin", 1, "callback id is null, so return");
      return true;
    }
    if ("qim_flowCamera_open".equals(paramString2))
    {
      if ("startCamera".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMFlowCameraJsApiPlugin", 2, "Call QIMCamera Api startQIMCameraActivity");
        }
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          for (;;)
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              if (QLog.isColorLevel()) {
                QLog.d("QIMFlowCameraJsApiPlugin", 2, "startQIMCameraActivity= " + paramJsBridgeListener.toString());
              }
              paramString1 = paramJsBridgeListener.optString("videoId", null);
              if (!TextUtils.isEmpty(paramString1))
              {
                paramJsBridgeListener = this.mRuntime.a();
                paramString2 = new Intent(paramJsBridgeListener, QIMJSPreFlowCameraActivity.class);
                paramString2.putExtra("videoId", paramString1);
                paramJsBridgeListener.startActivity(paramString2);
              }
              else
              {
                i = paramJsBridgeListener.optInt("firsttab", -1);
                if (-1 != i)
                {
                  paramString1 = this.mRuntime.a();
                  int j = paramJsBridgeListener.optInt("secondtab", 0);
                  paramString2 = paramJsBridgeListener.optString("itemid", "");
                  int k = paramJsBridgeListener.optInt("type", 0);
                  int m = paramJsBridgeListener.optInt("st", FlowCameraConstant.d);
                  paramString3 = paramJsBridgeListener.optString("succUrl", "");
                  paramVarArgs = paramJsBridgeListener.optString("failedUrl", "");
                  Intent localIntent = new Intent(paramString1, QIMJSPreFlowCameraActivity.class);
                  localIntent.putExtra("type", k);
                  localIntent.putExtra("firsttab", i);
                  localIntent.putExtra("secondtab", j);
                  localIntent.putExtra("itemid", paramString2);
                  localIntent.putExtra("WebSceneType", m);
                  if (paramJsBridgeListener.optInt("camera", 1) == 1)
                  {
                    i = 2;
                    localIntent.putExtra("direction", i);
                    localIntent.putExtra("succUrl", paramString3);
                    localIntent.putExtra("failedUrl", paramVarArgs);
                    paramString1.startActivity(localIntent);
                  }
                }
              }
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
            int i = 1;
          }
        }
      }
      else if ("getDemoVideoList".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMFlowCameraJsApiPlugin", 2, "QIM_GET_DEMO_VIDEO_LIST");
        }
        paramJsBridgeListener = DataFactory.a("get_traveller_video_list", paramJsBridgeListener, this.a.key, null);
        WebIPCOperator.a().a(paramJsBridgeListener);
      }
      else if ("downloadVideo".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMFlowCameraJsApiPlugin", 2, "QIM_DOWNLOAD_VIDEO");
        }
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]).optString("videoId");
            if (TextUtils.isEmpty(paramString1)) {
              break label636;
            }
            paramString2 = new Bundle();
            paramString2.putString("videoId", paramString1);
            paramJsBridgeListener = DataFactory.a("download_video_from_web", paramJsBridgeListener, this.a.key, paramString2);
            WebIPCOperator.a().a(paramJsBridgeListener);
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
    }
    else {
      return false;
    }
    label636:
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    WebIPCOperator.a().a(this.a);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    WebIPCOperator.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.QIMFlowCameraJsApiPlugin
 * JD-Core Version:    0.7.0.1
 */