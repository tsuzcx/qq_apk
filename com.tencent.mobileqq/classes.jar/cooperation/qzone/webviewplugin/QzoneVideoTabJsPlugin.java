package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.util.QZonePermission;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneVideoTabJsPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  public static final String NAMESPACE = "Qzone";
  private String TAG = QzoneVideoTabJsPlugin.class.getSimpleName();
  private String getProxyCallback;
  
  private void downloadVideo(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("url");
      this.parentPlugin.mRuntime.b().getHandler(QzoneVideoTabJsPlugin.class).post(new QzoneVideoTabJsPlugin.5(this, paramString));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e(this.TAG, 1, paramString, new Object[0]);
    }
  }
  
  private void getLocalProxyUrl(String paramString)
  {
    try
    {
      Object localObject1 = this.TAG;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getLocalProxyUrl. json=");
      ((StringBuilder)localObject2).append(paramString);
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).getJSONArray("playList");
      localObject1 = ((JSONObject)localObject1).getString("callback");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.getProxyCallback = ((String)localObject1);
      }
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        ((ArrayList)localObject1).add(paramString.getJSONObject(i).getString("url"));
        ((ArrayList)localObject2).add(paramString.getJSONObject(i).getString("vid"));
        i += 1;
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        this.parentPlugin.mRuntime.b().getHandler(QzoneVideoTabJsPlugin.class).post(new QzoneVideoTabJsPlugin.2(this, (ArrayList)localObject1, (ArrayList)localObject2));
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static Activity getRealActivity(Activity paramActivity)
  {
    if (paramActivity == null) {
      return null;
    }
    Activity localActivity = paramActivity;
    if ((paramActivity instanceof BasePluginActivity)) {
      localActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    return localActivity;
  }
  
  private void setPlayState(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("state");
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        localArrayList1.add(localJSONObject.getString("url"));
        localArrayList2.add(localJSONObject.getString("state"));
        i += 1;
      }
      if (localArrayList1.size() > 0)
      {
        this.parentPlugin.mRuntime.b().getHandler(QzoneVideoTabJsPlugin.class).post(new QzoneVideoTabJsPlugin.3(this, localArrayList1, localArrayList2));
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void stopAll()
  {
    this.parentPlugin.mRuntime.b().getHandler(QzoneVideoTabJsPlugin.class).post(new QzoneVideoTabJsPlugin.4(this));
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("Qzone")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if (("videoProxyGetLocalProxyURL".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
      {
        RemoteHandleManager.getInstance().addWebEventListener(this);
        getLocalProxyUrl(paramVarArgs[0]);
        return true;
      }
      if (("videoProxySetPlayState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
      {
        RemoteHandleManager.getInstance().addWebEventListener(this);
        setPlayState(paramVarArgs[0]);
        return true;
      }
      if ("videoProxyStopAll".equals(paramString3))
      {
        RemoteHandleManager.getInstance().addWebEventListener(this);
        stopAll();
        return true;
      }
      if ("videoProxySaveVideoToAlbum".equals(paramString3))
      {
        paramJsBridgeListener = this.parentPlugin.mRuntime.d();
        if ((paramJsBridgeListener != null) && (QZonePermission.requestStoragePermission(paramJsBridgeListener, new QzoneVideoTabJsPlugin.1(this, paramVarArgs, paramJsBridgeListener), 1))) {
          downloadVideo(paramVarArgs[0]);
        }
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    RemoteHandleManager.getInstance().removeWebEventListener(this);
    super.onDestroy();
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (!paramBundle.containsKey("data")) {
        return;
      }
      Object localObject = paramBundle.getBundle("data");
      if (localObject == null)
      {
        QLog.e(this.TAG, 1, "call js function,bundle is empty");
        return;
      }
      if ("cmd.videoGetLocalProxyUrl".equals(paramString))
      {
        paramBundle = ((Bundle)localObject).getStringArrayList("param.videoLocalUrls");
        localObject = ((Bundle)localObject).getStringArrayList("param.videoId");
        paramString = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        if ((paramBundle != null) && (localObject != null)) {}
        try
        {
          if (paramBundle.size() == ((ArrayList)localObject).size())
          {
            int i = 0;
            while (i < paramBundle.size())
            {
              String str = (String)paramBundle.get(i);
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("vid", ((ArrayList)localObject).get(i));
              localJSONObject.put("url", str);
              localJSONArray.put(localJSONObject);
              i += 1;
            }
          }
          paramString.put("proxyList", localJSONArray);
        }
        catch (JSONException paramBundle)
        {
          QLog.w(this.TAG, 2, "getLocalProxyUrl result is invalid.", paramBundle);
        }
        paramBundle = this.TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getLocalProxyUrl result=");
        ((StringBuilder)localObject).append(paramString);
        QLog.i(paramBundle, 1, ((StringBuilder)localObject).toString());
        if (!TextUtils.isEmpty(this.getProxyCallback)) {
          this.parentPlugin.callJs(this.getProxyCallback, new String[] { paramString.toString() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin
 * JD-Core Version:    0.7.0.1
 */