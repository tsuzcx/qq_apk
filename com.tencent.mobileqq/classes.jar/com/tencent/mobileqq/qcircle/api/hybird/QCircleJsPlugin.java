package com.tencent.mobileqq.qcircle.api.hybird;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.music.api.IAEMusicClipDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.musicpendant.Base64;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qcircle.api.IToastUtil;
import com.tencent.mobileqq.qcircle.api.util.PhotoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qzone.LbsDataV2.GpsInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QCircleJsPlugin
  extends WebViewPlugin
{
  public static final String PLUGIN_NAMESPACE = "qcircle";
  private static final String TAG = "QCircleJsPlugin";
  private static volatile QCircleJsPlugin sQCircleJsPlugin;
  
  public QCircleJsPlugin()
  {
    this.mPluginNameSpace = "qcircle";
  }
  
  private boolean checkArgsValid(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length >= 1)) {
      return true;
    }
    QLog.e("QCircleJsPlugin", 2, "args is null");
    return false;
  }
  
  private void getDisableRightInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QCircleJsPlugin", 1, "getDisableRightInfo callback is null");
      return;
    }
    Object localObject = this.mRuntime.d().getIntent().getBundleExtra("disableRightInfo");
    String str1 = ((Bundle)localObject).getString("disableUinId");
    String str2 = ((Bundle)localObject).getString("disableGroupId");
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("uinlist", str1);
      ((JSONObject)localObject).put("groupid", str2);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDisableRightInfo  jsonObject = ");
    localStringBuilder.append(localObject);
    QLog.i("QCircleJsPlugin", 1, localStringBuilder.toString());
    callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
  }
  
  private void getGpsInfo(String paramString)
  {
    Object localObject1 = this.mRuntime.d();
    Object localObject2;
    if ((localObject1 != null) && (!((Activity)localObject1).isFinishing()))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject1 = ((Activity)localObject1).getIntent();
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((Intent)localObject1).getExtras();
      if (localObject1 == null) {
        return;
      }
      localObject2 = (LbsDataV2.GpsInfo)((Bundle)localObject1).getParcelable(((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).keyGpsInfo());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LbsDataV2.GpsInfo();
        ((LbsDataV2.GpsInfo)localObject1).lat = 0;
        ((LbsDataV2.GpsInfo)localObject1).lon = 0;
        ((LbsDataV2.GpsInfo)localObject1).alt = 0;
        ((LbsDataV2.GpsInfo)localObject1).gpsType = 0;
      }
      localObject2 = new JSONObject();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("lat", ((LbsDataV2.GpsInfo)localObject1).lat);
      localJSONObject.put("lon", ((LbsDataV2.GpsInfo)localObject1).lon);
      localJSONObject.put("alt", ((LbsDataV2.GpsInfo)localObject1).alt);
      ((JSONObject)localObject2).put("gpsInfo", localJSONObject);
      label164:
      callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
      return;
    }
    catch (Exception localException)
    {
      break label164;
    }
  }
  
  private void getLabel(String paramString)
  {
    Object localObject = this.mRuntime.d();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = ((Activity)localObject).getIntent();
      if (localObject == null) {
        return;
      }
      localObject = ((Intent)localObject).getExtras();
      if (localObject == null) {
        return;
      }
      callJs(paramString, new String[] { ((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).labelToJson((Bundle)localObject) });
      return;
    }
    QLog.e("QCircleJsPlugin", 1, "getLabel activity is null");
  }
  
  private QCircleHybirdFragment getQCircleHybirdFragment()
  {
    if ((this.mRuntime != null) && ((this.mRuntime.f() instanceof QCircleHybirdFragment))) {
      return (QCircleHybirdFragment)this.mRuntime.f();
    }
    return null;
  }
  
  private void getTongSessionId(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QCircleJsPlugin", 1, "getTongSessionId callback is null");
      return;
    }
    String str = QCircleNativeSessionManager.g().getSession();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("session_id", str);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTongSessionId  session_id = ");
    localStringBuilder.append(str);
    QLog.i("QCircleJsPlugin", 1, localStringBuilder.toString());
    callJs(paramString, new String[] { localJSONObject.toString() });
  }
  
  private void handleBase64ToPics(String paramString)
  {
    Object localObject1 = new QCircleJsPlugin.SafeJsonObject(this, paramString);
    paramString = ((QCircleJsPlugin.SafeJsonObject)localObject1).getString("callback");
    Object localObject2 = ((QCircleJsPlugin.SafeJsonObject)localObject1).optJSONArray("images");
    localObject1 = new JSONArray();
    int i = 0;
    while (i < ((JSONArray)localObject2).length())
    {
      Object localObject3 = ((JSONArray)localObject2).getJSONObject(i).getString("image");
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject3 = Base64.b(localObject3.split(",")[1]);
        localObject3 = BitmapFactory.decodeByteArray((byte[])localObject3, 0, localObject3.length);
        JSONObject localJSONObject = new JSONObject();
        if (localObject3 != null)
        {
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(System.currentTimeMillis());
          ((StringBuilder)localObject4).append(".jpeg");
          localObject4 = ((StringBuilder)localObject4).toString();
          String str = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE);
          Object localObject5 = new File(str);
          if (!((File)localObject5).exists()) {
            ((File)localObject5).mkdirs();
          }
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(str);
          ((StringBuilder)localObject5).append((String)localObject4);
          localObject4 = ((StringBuilder)localObject5).toString();
          if (PhotoUtils.a((Bitmap)localObject3, (String)localObject4, Bitmap.CompressFormat.JPEG, 100, true))
          {
            localJSONObject.put("path", localObject4);
            ((JSONArray)localObject1).put(localJSONObject);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handleBase64ToPics... file save success:");
            ((StringBuilder)localObject3).append((String)localObject4);
            QLog.i("QCircleJsPlugin", 1, ((StringBuilder)localObject3).toString());
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handleBase64ToPics... file save failed:");
            ((StringBuilder)localObject3).append((String)localObject4);
            QLog.e("QCircleJsPlugin", 1, ((StringBuilder)localObject3).toString());
          }
        }
      }
      i += 1;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("handleBase64ToPics... list:");
    ((StringBuilder)localObject2).append(((JSONArray)localObject1).toString());
    QLog.i("QCircleJsPlugin", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("window.");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("({result:");
    ((StringBuilder)localObject2).append(((JSONArray)localObject1).toString());
    ((StringBuilder)localObject2).append("})");
    callJs(((StringBuilder)localObject2).toString());
  }
  
  private void handleCacheMusicEvent(String paramString)
  {
    if (this.mRuntime != null)
    {
      Intent localIntent = new Intent();
      paramString = new QCircleJsPlugin.SafeJsonObject(this, paramString);
      localIntent.setAction("action_dispatch_music_event");
      localIntent.putExtra("event", "kTribeDownloadMusic");
      localIntent.putExtra("data", paramString.toString());
      BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    }
  }
  
  private void handleChargeStatus(String paramString)
  {
    Object localObject = new QCircleJsPlugin.SafeJsonObject(this, paramString);
    paramString = ((QCircleJsPlugin.SafeJsonObject)localObject).getString("status");
    int i = ((QCircleJsPlugin.SafeJsonObject)localObject).getInt("balance");
    localObject = ((QCircleJsPlugin.SafeJsonObject)localObject).getString("uin");
    if ("success".equals(paramString))
    {
      ((IToastUtil)QRoute.api(IToastUtil.class)).determineShowByCode(1L, BaseApplicationImpl.getContext(), 2, "充值成功", 0);
      paramString = new Intent();
      paramString.setAction("action_update_native_balance");
      paramString.putExtra("balance", i);
      paramString.putExtra("uin", (String)localObject);
      BaseApplicationImpl.getApplication().sendBroadcast(paramString);
    }
  }
  
  private void handleClipMusicEvent(String paramString)
  {
    if (this.mRuntime != null)
    {
      paramString = new QCircleJsPlugin.SafeJsonObject(this, paramString);
      Activity localActivity = this.mRuntime.d();
      ((IAEMusicClipDialog)QRoute.api(IAEMusicClipDialog.class)).showMusicClipDialogOnWebView(paramString, localActivity);
    }
  }
  
  private void handleConfirmSchoolName(String paramString)
  {
    paramString = new QCircleJsPlugin.SafeJsonObject(this, paramString).getString("schoolName");
    if ((this.mRuntime != null) && (((this.mRuntime.f() instanceof QCircleHybirdFragment)) || ((this.mRuntime.f() instanceof QQTranslucentBrowserActivity.QQTranslucentBrowserFragment))))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action_confirm_school_name");
      localIntent.putExtra("schoolName", paramString);
      BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
      if (this.mRuntime.d() != null) {
        this.mRuntime.d().finish();
      }
    }
  }
  
  private void handleDisableSetRightInfo(String paramString)
  {
    Object localObject = new QCircleJsPlugin.SafeJsonObject(this, paramString);
    paramString = ((QCircleJsPlugin.SafeJsonObject)localObject).optString("uinlist");
    String str1 = ((QCircleJsPlugin.SafeJsonObject)localObject).optString("groupid");
    String str2 = ((QCircleJsPlugin.SafeJsonObject)localObject).optString("nickname");
    String str3 = ((QCircleJsPlugin.SafeJsonObject)localObject).optString("groupname");
    localObject = ((QCircleJsPlugin.SafeJsonObject)localObject).optString("uinnumber");
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("disableNickName", str2);
    localBundle.putString("disableGroupName", str3);
    localBundle.putString("disableUinId", paramString);
    localBundle.putString("disableGroupId", str1);
    localBundle.putString("disableUinNumber", (String)localObject);
    localIntent.putExtra("disableRightInfo", localBundle);
    localIntent.setAction("ACTION_USER_PUBLISH_DISABLE_INFO");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    if (this.mRuntime.d() != null) {
      this.mRuntime.d().finish();
    }
  }
  
  private void handleRefreshFeedList(String paramString)
  {
    paramString = new QCircleJsPlugin.SafeJsonObject(this, paramString).getString("page");
    if ((this.mRuntime != null) && ((this.mRuntime.f() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.f()).b(paramString);
    }
  }
  
  private void handleRefreshHippyPage(String paramString)
  {
    paramString = new QCircleJsPlugin.SafeJsonObject(this, paramString).getString("module");
    Intent localIntent = new Intent();
    localIntent.setAction("action_refresh_hippy_page");
    localIntent.putExtra("pageType", paramString);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  private void handleReloadMainPage(String paramString)
  {
    paramString = new QCircleJsPlugin.SafeJsonObject(this, paramString).getString("uin");
    if ((this.mRuntime != null) && (((this.mRuntime.f() instanceof QCircleHybirdFragment)) || ((this.mRuntime.f() instanceof QQTranslucentBrowserActivity.QQTranslucentBrowserFragment))))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action_reload_get_main_page");
      localIntent.putExtra("uin", paramString);
      BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    }
  }
  
  private void handleSelectMusicEvent(String paramString)
  {
    if (this.mRuntime != null)
    {
      paramString = new QCircleJsPlugin.SafeJsonObject(this, paramString);
      Activity localActivity = this.mRuntime.d();
      ((IAEMusicClipDialog)QRoute.api(IAEMusicClipDialog.class)).showMusicSelectLoadingOnWebView(paramString, localActivity);
    }
  }
  
  private void handleSetUserWearingMedal(String paramString)
  {
    if ((this.mRuntime != null) && ((this.mRuntime.f() instanceof QCircleHybirdFragment)))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action_user_wearing_medal_update");
      localIntent.putExtra("json", paramString);
      ((QCircleHybirdFragment)this.mRuntime.f()).a(localIntent);
    }
  }
  
  private void handleTitleBarStyle(String paramString)
  {
    paramString = new QCircleJsPlugin.SafeJsonObject(this, paramString);
    if (paramString.has("titleTextColor"))
    {
      int i = ((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).getColorFromJSON(paramString, "titleTextColor");
      paramString = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
      if ((paramString != null) && (paramString.g != null))
      {
        if (i == -1)
        {
          paramString.g.j();
          return;
        }
        paramString.g.d(i | 0xFF000000);
      }
    }
  }
  
  private void handleUpdateAuthInfo(String paramString)
  {
    paramString = new QCircleJsPlugin.SafeJsonObject(this, paramString);
    int i = paramString.optInt("tagtype");
    int j = paramString.optInt("status");
    paramString = paramString.optString("tagname");
    if ((this.mRuntime != null) && ((this.mRuntime.f() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.f()).a(i, j, paramString);
    }
  }
  
  private void handleUpdateNativeTagFollowState(String paramString)
  {
    if ((this.mRuntime != null) && ((this.mRuntime.f() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.f()).a();
    }
  }
  
  private void handleUpdateNativeUserFollowState(String paramString)
  {
    Object localObject = new QCircleJsPlugin.SafeJsonObject(this, paramString);
    paramString = ((QCircleJsPlugin.SafeJsonObject)localObject).getString("uin");
    int i = ((QCircleJsPlugin.SafeJsonObject)localObject).getInt("type");
    int j = ((QCircleJsPlugin.SafeJsonObject)localObject).optInt("isDoubly");
    localObject = ((QCircleJsPlugin.SafeJsonObject)localObject).optString("nick");
    if ((this.mRuntime != null) && ((this.mRuntime.f() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.f()).a(paramString, i, j, (String)localObject);
    }
  }
  
  private void parseJsBridge(String paramString, String[] paramArrayOfString)
  {
    if (("getLabel".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      getLabel(new JSONObject(paramArrayOfString[0]).optString("callback"));
      return;
    }
    if (("setLabel".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      paramString = new JSONObject(paramArrayOfString[0]);
      setLabel(paramArrayOfString[0], paramString.optString("callback"));
      return;
    }
    if (("getGpsInfo".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      getGpsInfo(new JSONObject(paramArrayOfString[0]).optString("callback"));
      return;
    }
    if (("reloadhomepage".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      handleReloadMainPage(paramArrayOfString[0]);
      return;
    }
    if (("reportReadMessage".equals(paramString)) && (checkArgsValid(paramArrayOfString))) {
      return;
    }
    if (("isQCircleActive".equals(paramString)) && (checkArgsValid(paramArrayOfString))) {
      return;
    }
    if (("updateUserFollowState".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      handleUpdateNativeUserFollowState(paramArrayOfString[0]);
      return;
    }
    if (("updateTagFollowState".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      handleUpdateNativeTagFollowState(paramArrayOfString[0]);
      return;
    }
    if (("authrefreshpage".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      handleUpdateAuthInfo(paramArrayOfString[0]);
      return;
    }
    if (("refreshFeedList".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      handleRefreshFeedList(paramArrayOfString[0]);
      return;
    }
    if (("refreshHippyPage".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      handleRefreshHippyPage(paramArrayOfString[0]);
      return;
    }
    if (("saveimage".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      handleBase64ToPics(paramArrayOfString[0]);
      return;
    }
    if (("setTitleBarStyle".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      handleTitleBarStyle(paramArrayOfString[0]);
      return;
    }
    if (("chargeStatusCallback".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      handleChargeStatus(paramArrayOfString[0]);
      return;
    }
    if (("getQCircleSessionID".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      getTongSessionId(new JSONObject(paramArrayOfString[0]).optString("callback"));
      return;
    }
    if (("setUserWearingMedal".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      handleSetUserWearingMedal(paramArrayOfString[0]);
      return;
    }
    if (("confirmSchoolName".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      handleConfirmSchoolName(paramArrayOfString[0]);
      return;
    }
    if (("kTribeSelectMusic".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      handleSelectMusicEvent(paramArrayOfString[0]);
      return;
    }
    if (("kTribeClipsMusic".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      handleClipMusicEvent(paramArrayOfString[0]);
      return;
    }
    if (("kTribeDownloadMusic".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      handleCacheMusicEvent(paramArrayOfString[0]);
      return;
    }
    if (("getRightInfo".equals(paramString)) && (checkArgsValid(paramArrayOfString)))
    {
      getDisableRightInfo(new JSONObject(paramArrayOfString[0]).optString("callback"));
      return;
    }
    if (("setRightInfo".equals(paramString)) && (checkArgsValid(paramArrayOfString))) {
      handleDisableSetRightInfo(paramArrayOfString[0]);
    }
  }
  
  private void reportReadMessage(String paramString)
  {
    int i = new QCircleJsPlugin.SafeJsonObject(this, paramString).getInt("createTime");
    if ((this.mRuntime != null) && ((this.mRuntime.f() instanceof QCircleHybirdFragment)))
    {
      paramString = new StringBuilder();
      paramString.append("reportReadMessage createTime");
      paramString.append(i);
      QLog.d("QCircleJsPlugin", 1, paramString.toString());
      ((QCircleHybirdFragment)this.mRuntime.f()).a(i);
    }
  }
  
  private void setLabel(String paramString1, String paramString2)
  {
    Object localObject = this.mRuntime.d();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).jsonToLabel(localIntent.getExtras(), paramString1));
      ((Activity)localObject).setResult(-1, localIntent);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = localIntent.getStringExtra(((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).keyParseDataErrorMsg());
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("{\"ret\":-1, \"msg\":\"");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("\"}");
          paramString1 = ((StringBuilder)localObject).toString();
        }
        else
        {
          paramString1 = "{\"ret\":0, \"msg\":\"sucess\"}";
        }
        callJs(paramString2, new String[] { paramString1 });
      }
      return;
    }
    QLog.e("QCircleJsPlugin", 1, "setLabel activity is null");
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("qcircle".equals(paramString2))
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest:");
      paramJsBridgeListener.append(paramString1);
      QLog.i("QCircleJsPlugin", 2, paramJsBridgeListener.toString());
      try
      {
        parseJsBridge(paramString3, paramVarArgs);
      }
      catch (Exception paramJsBridgeListener)
      {
        QLog.d("QCircleJsPlugin", 2, paramJsBridgeListener, new Object[0]);
      }
      return true;
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.hybird.QCircleJsPlugin
 * JD-Core Version:    0.7.0.1
 */