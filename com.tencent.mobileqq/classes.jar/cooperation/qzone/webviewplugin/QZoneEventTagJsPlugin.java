package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.PublishEventTag;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.remote.logic.WebEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneEventTagJsPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  public static String ADDFRIENDS = "addfriends";
  public static final String DESC = "desc";
  public static final String ID = "id";
  public static final String JOIN_LIST = "joinList";
  public static final String PIC_URL = "picUrl";
  public static String PKG_NAME = "Qzone";
  private static final String TAG = "QZoneEventTagJsPlugin";
  public static final String TIME = "time";
  public static final String TITLE = "title";
  public static final String TRUNCATE_NUM = "truncateNum";
  public static final String UIN = "uin";
  private String callback;
  
  private void errorCallBack(String paramString)
  {
    if (paramString == null) {
      return;
    }
    QLog.w("QZoneEventTagJsPlugin", 1, "errorCallBack error");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", -1);
      this.parentPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QZoneEventTagJsPlugin", 1, "errorCallBack error", paramString);
    }
  }
  
  private void getHistoryEventTag(String paramString)
  {
    try
    {
      this.callback = new JSONObject(paramString).optString("callback");
      if (!TextUtils.isEmpty(this.callback))
      {
        RemoteHandleManager.getInstance().getSender().getHistoryEventTag();
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("QZoneEventTagJsPlugin", 1, "getHistoryEventTag error", paramString);
    }
  }
  
  private void openAddFriendActivity(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    try
    {
      paramWebViewPlugin = new JSONObject(paramArrayOfString[0]);
      long l = paramWebViewPlugin.getLong("uin");
      int i = paramWebViewPlugin.optInt("sourceId", 3011);
      int j = paramWebViewPlugin.optInt("subSourceId", 21);
      paramWebViewPlugin = paramPluginRuntime.d();
      paramPluginRuntime = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramWebViewPlugin, 1, String.valueOf(l), "", i, j, null, null, null, null, null);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(paramWebViewPlugin, paramPluginRuntime);
      return;
    }
    catch (JSONException paramWebViewPlugin)
    {
      paramWebViewPlugin.printStackTrace();
    }
  }
  
  private void selectEventTag(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new Bundle();
      paramString.putString("uin", ((JSONObject)localObject).optString("uin"));
      paramString.putString("time", ((JSONObject)localObject).optString("time"));
      paramString.putString("title", ((JSONObject)localObject).optString("title"));
      paramString.putString("picUrl", ((JSONObject)localObject).optString("picUrl"));
      paramString.putString("id", ((JSONObject)localObject).optString("id"));
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localObject = ((JSONObject)localObject).optJSONObject("joinList");
      if (localObject != null)
      {
        if (((JSONObject)localObject).has("names")) {
          localStringBuilder1.append(((JSONObject)localObject).optString("names"));
        }
        if (((JSONObject)localObject).has("middle"))
        {
          String str = ((JSONObject)localObject).optString("middle");
          localStringBuilder1.append(str);
          localStringBuilder2.append(str);
        }
        if (((JSONObject)localObject).has("suffix"))
        {
          localObject = ((JSONObject)localObject).optString("suffix");
          localStringBuilder1.append((String)localObject);
          localStringBuilder2.append((String)localObject);
        }
      }
      paramString.putString("desc", localStringBuilder1.toString());
      paramString.putString("truncateNum", localStringBuilder2.toString());
      RemoteHandleManager.getInstance().getSender().selectEventTag(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QZoneEventTagJsPlugin", 1, "selectHistoryEventTag error", paramString);
    }
  }
  
  private void setHistoryEventTag(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("list");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = paramString.optJSONObject(0);
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", paramString.optString("uin"));
        localBundle.putString("time", paramString.optString("time"));
        localBundle.putString("title", paramString.optString("title"));
        localBundle.putString("picUrl", paramString.optString("picUrl"));
        localBundle.putString("id", paramString.optString("id"));
        RemoteHandleManager.getInstance().getSender().setHistoryEventTagData(localBundle);
        return;
      }
      RemoteHandleManager.getInstance().getSender().setHistoryEventTagData(null);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QZoneEventTagJsPlugin", 1, "setHistoryEventTag error", paramString);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals(PKG_NAME)) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if (paramString3.equals(ADDFRIENDS))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          openAddFriendActivity(this.parentPlugin, this.parentPlugin.mRuntime, paramVarArgs);
        }
        return true;
      }
      if ("getHistoryEventTag".equals(paramString3))
      {
        RemoteHandleManager.getInstance().addWebEventListener(this);
        getHistoryEventTag(paramVarArgs[0]);
        return true;
      }
      if ("setHistoryEventTag".equals(paramString3))
      {
        setHistoryEventTag(paramVarArgs[0]);
        return true;
      }
      if ("selectEventTag".equals(paramString3))
      {
        selectEventTag(paramVarArgs[0]);
        return true;
      }
    }
    return false;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (!"cmd.getHistoryEventTag".equals(paramString)) {
        return;
      }
      if (paramBundle.containsKey("data"))
      {
        paramString = paramBundle.getBundle("data");
        if (paramString == null)
        {
          QLog.e("QZoneEventTagJsPlugin", 1, "call js function,bundle is empty");
          return;
        }
        try
        {
          paramBundle = paramString.getParcelableArrayList("event_tag");
          paramString = new JSONArray();
          paramBundle = paramBundle.iterator();
          while (paramBundle.hasNext())
          {
            PublishEventTag localPublishEventTag = (PublishEventTag)paramBundle.next();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("uin", localPublishEventTag.uin);
            localJSONObject.put("time", localPublishEventTag.time);
            localJSONObject.put("title", localPublishEventTag.title);
            localJSONObject.put("picUrl", localPublishEventTag.picUrl);
            localJSONObject.put("id", localPublishEventTag.id);
            paramString.put(localJSONObject);
          }
          paramBundle = new JSONObject();
          paramBundle.put("list", paramString);
          if (this.callback == null) {
            return;
          }
          this.parentPlugin.callJs(this.callback, new String[] { paramBundle.toString() });
          return;
        }
        catch (JSONException paramString)
        {
          QLog.e("QZoneEventTagJsPlugin", 1, "onWebEvent error", paramString);
          return;
        }
      }
      else
      {
        errorCallBack(this.callback);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneEventTagJsPlugin
 * JD-Core Version:    0.7.0.1
 */