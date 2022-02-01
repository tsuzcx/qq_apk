package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.remote.logic.WebEventListener;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class QzoneRecommedPhotoJsPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  public static final String KEY_RECOMM_CHAT_CACHE_PHOTO = "recommendChatCachePhoto_on";
  private static final String LOG_TAG = "QzoneRecommedPhotoJsPlugin";
  private static final int MEDIA_TYPE_GIF = 3;
  private ConcurrentHashMap<String, String> callbackMap = new ConcurrentHashMap();
  
  private void callJsBridge(String paramString, Bundle paramBundle, QzoneRecommedPhotoJsPlugin.OnCallJsBridge paramOnCallJsBridge)
  {
    Bundle localBundle;
    if ((paramBundle != null) && (paramOnCallJsBridge != null))
    {
      localBundle = getResultBundle(paramBundle, paramString);
      if (localBundle != null) {
        paramBundle = new JSONObject();
      }
    }
    try
    {
      paramOnCallJsBridge.setData(paramBundle, localBundle);
      if (paramString != null) {
        this.parentPlugin.callJs(paramString, new String[] { paramBundle.toString() });
      }
      return;
    }
    catch (Throwable paramOnCallJsBridge)
    {
      for (;;)
      {
        QLog.e("QzoneRecommedPhotoJsPlugin", 1, "onCallJsBridge.setData error", paramOnCallJsBridge);
      }
    }
  }
  
  private void errorCallBack(String paramString)
  {
    if (paramString == null) {
      return;
    }
    QLog.w("QzoneRecommedPhotoJsPlugin", 1, "errorCallBack error");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", -1);
      this.parentPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "errorCallBack error", paramString);
    }
  }
  
  private String getBase64(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return QzoneDynamicAlbumPlugin.encodeBase64File(paramString, 200, 200, true);
    }
    return "";
  }
  
  private Bundle getResultBundle(Bundle paramBundle, String paramString)
  {
    if (paramBundle.containsKey("data")) {
      try
      {
        paramBundle = paramBundle.getBundle("data");
        if (paramBundle == null) {
          QLog.e("QzoneRecommedPhotoJsPlugin", 1, "call js function,bundle is empty");
        }
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        QLog.w("QzoneRecommedPhotoJsPlugin", 1, "onWebEvent error", paramBundle);
        errorCallBack(paramString);
      }
    }
    for (;;)
    {
      return null;
      errorCallBack(paramString);
    }
  }
  
  private void handleForwardToRecommedPhoto(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("photoEventID");
      Intent localIntent = new Intent("action_enter_to_qzone_recommend_photo");
      localIntent.putExtra("param.formSchemeToRecommend", true);
      localIntent.putExtra("param.photoUnikey", paramString);
      QZoneHelper.forwardToQzoneTransluentActivity(this.parentPlugin.mRuntime.a(), QZoneHelper.UserInfo.getInstance(), localIntent, 0);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleForwardToRecommedPhoto error", paramString);
    }
  }
  
  private void handleGetEventVideoAlbumState(String paramString)
  {
    handleRunnable("cmd.getEventVideoAlbumState", paramString, new QzoneRecommedPhotoJsPlugin.1(this), true);
  }
  
  private void handleGetQuickMakeDynamicStatus(String paramString)
  {
    handleRunnable("cmd.getQuickMakeDynamicStatus", paramString, new QzoneRecommedPhotoJsPlugin.4(this), true);
  }
  
  private void handleGetRecommendphoto(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      if (!TextUtils.isEmpty(paramString))
      {
        this.callbackMap.put("cmd.getRecommedPhoto", paramString);
        this.parentPlugin.mRuntime.a().getHandler(QzoneVideoTabJsPlugin.class).post(new QzoneRecommedPhotoJsPlugin.2(this));
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleGetRecommendphoto error", paramString);
    }
  }
  
  private void handleGetShouldScanPhotoEventState(String paramString)
  {
    handleRunnable("cmd.getLocalPhotoSwitcher", paramString, new QzoneRecommedPhotoJsPlugin.3(this), true);
  }
  
  private void handleRunnable(String paramString1, String paramString2, Runnable paramRunnable, boolean paramBoolean)
  {
    try
    {
      String str = new JSONObject(paramString2).optString("callback");
      if ((paramBoolean) && (TextUtils.isEmpty(str))) {
        return;
      }
      if (!TextUtils.isEmpty(paramString1)) {
        this.callbackMap.put(paramString1, str);
      }
      this.parentPlugin.mRuntime.a().getHandler(QzoneVideoTabJsPlugin.class).post(paramRunnable);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleRunnable error" + paramString2, paramString1);
    }
  }
  
  private void handleSetEventVideoAlbumState(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("event_video_album_state", paramString.optString("event_video_album_state"));
      RemoteHandleManager.getInstance().getSender().setEventVideoAlbumState(localBundle);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleSetEventVideoAlbumState error", paramString);
    }
  }
  
  private void handleSetQuickMakeDynamicStatus(String paramString)
  {
    handleRunnable("cmd.setQuickMakeDynamicStatus", paramString, new QzoneRecommedPhotoJsPlugin.5(this, paramString), false);
  }
  
  private void handleSetShouldScanPhotoEventState(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("recommend_on", paramString.optString("recommend_on"));
      localBundle.putString("recommendPush_on", paramString.optString("recommendPush_on"));
      localBundle.putString("recommendChatCachePhoto_on", paramString.optString("recommendChatCachePhoto_on"));
      RemoteHandleManager.getInstance().getSender().setLocalPhotoSwitcher(localBundle);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleSetShouldScanPhotoEventState error", paramString);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("getEventVideoAlbumState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      RemoteHandleManager.getInstance().addWebEventListener(this);
      handleGetEventVideoAlbumState(paramVarArgs[0]);
      return true;
    }
    if (("setEventVideoAlbumState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      handleSetEventVideoAlbumState(paramVarArgs[0]);
      return true;
    }
    if (("getRecommendPhotoEvent".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      RemoteHandleManager.getInstance().addWebEventListener(this);
      handleGetRecommendphoto(paramVarArgs[0]);
      return true;
    }
    if (("enterPhotoEventDetail".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      handleForwardToRecommedPhoto(paramVarArgs[0]);
      return true;
    }
    if (("setShouldScanPhotoEventState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      handleSetShouldScanPhotoEventState(paramVarArgs[0]);
      return true;
    }
    if (("getShouldScanPhotoEventState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      RemoteHandleManager.getInstance().addWebEventListener(this);
      handleGetShouldScanPhotoEventState(paramVarArgs[0]);
      return true;
    }
    if (("getQuickMakeDynamicStatus".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      RemoteHandleManager.getInstance().addWebEventListener(this);
      handleGetQuickMakeDynamicStatus(paramVarArgs[0]);
      return true;
    }
    if (("setQuickMakeDynamicStatus".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      handleSetQuickMakeDynamicStatus(paramVarArgs[0]);
      return true;
    }
    return false;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    Object localObject1;
    do
    {
      return;
      str = (String)this.callbackMap.get(paramString);
      if (!"cmd.getRecommedPhoto".equals(paramString)) {
        break;
      }
      localObject1 = getResultBundle(paramBundle, str);
    } while (localObject1 == null);
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject();
        paramString.put("code", 0);
        paramString.put("photoEventID", ((Bundle)localObject1).getString("photoEventID"));
        paramString.put("title", ((Bundle)localObject1).getString("title"));
        paramString.put("time", ((Bundle)localObject1).getString("time"));
        paramString.put("mediaCount", ((Bundle)localObject1).getInt("mediaCount"));
        paramBundle = ((Bundle)localObject1).getIntegerArrayList("dataType");
        localObject1 = ((Bundle)localObject1).getStringArrayList("dataPath");
        JSONArray localJSONArray = new JSONArray();
        if ((paramBundle != null) && (paramBundle.size() > 0) && (localObject1 != null) && (((ArrayList)localObject1).size() > 0) && (paramBundle.size() == ((ArrayList)localObject1).size()))
        {
          i = 0;
          if (i < paramBundle.size())
          {
            Object localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("imageData", "data:image/jpg;base64," + getBase64((String)((ArrayList)localObject1).get(i)));
            ((JSONObject)localObject2).put("type", paramBundle.get(i));
            localJSONArray.put(localObject2);
            if (((Integer)paramBundle.get(i)).intValue() != 3) {
              break label444;
            }
            localObject2 = new File((String)((ArrayList)localObject1).get(i));
            if (!((File)localObject2).exists()) {
              break label444;
            }
            ((File)localObject2).delete();
            break label444;
          }
          paramString.put("thumbInfos", localJSONArray);
          if (str == null) {
            break;
          }
          this.parentPlugin.callJs(str, new String[] { paramString.toString() });
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.w("QzoneRecommedPhotoJsPlugin", 1, "onWebEvent error", paramString);
        return;
      }
      errorCallBack(str);
      return;
      if ("cmd.getLocalPhotoSwitcher".equals(paramString))
      {
        callJsBridge(str, paramBundle, new QzoneRecommedPhotoJsPlugin.6(this));
        return;
      }
      if ("cmd.getQuickMakeDynamicStatus".equals(paramString))
      {
        callJsBridge(str, paramBundle, new QzoneRecommedPhotoJsPlugin.7(this));
        return;
      }
      if (!"cmd.getEventVideoAlbumState".equals(paramString)) {
        break;
      }
      callJsBridge(str, paramBundle, new QzoneRecommedPhotoJsPlugin.8(this));
      return;
      label444:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin
 * JD-Core Version:    0.7.0.1
 */