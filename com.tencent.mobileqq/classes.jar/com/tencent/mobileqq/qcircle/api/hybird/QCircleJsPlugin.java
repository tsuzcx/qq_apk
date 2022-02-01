package com.tencent.mobileqq.qcircle.api.hybird;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
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
    RFLog.e("QCircleJsPlugin", RFLog.CLR, "args is null");
    return false;
  }
  
  private void getGpsInfo(String paramString)
  {
    Object localObject1 = this.mRuntime.a();
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
      localObject2 = (LbsDataV2.GpsInfo)((Bundle)localObject1).getParcelable(((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).KEY_GPS_INFO());
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
    Object localObject = this.mRuntime.a();
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
    RFLog.e("QCircleJsPlugin", RFLog.USR, "getLabel activity is null");
  }
  
  private QCircleHybirdFragment getQCircleHybirdFragment()
  {
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      return (QCircleHybirdFragment)this.mRuntime.a();
    }
    return null;
  }
  
  private void getTongSessionId(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      RFLog.e("QCircleJsPlugin", RFLog.USR, "getTongSessionId callback is null");
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
        localObject3 = Base64.a(localObject3.split(",")[1]);
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
          int j;
          if (PhotoUtils.a((Bitmap)localObject3, (String)localObject4, Bitmap.CompressFormat.JPEG, 100, true))
          {
            localJSONObject.put("path", localObject4);
            ((JSONArray)localObject1).put(localJSONObject);
            j = RFLog.USR;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handleBase64ToPics... file save success:");
            ((StringBuilder)localObject3).append((String)localObject4);
            RFLog.i("QCircleJsPlugin", j, ((StringBuilder)localObject3).toString());
          }
          else
          {
            j = RFLog.USR;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handleBase64ToPics... file save failed:");
            ((StringBuilder)localObject3).append((String)localObject4);
            RFLog.e("QCircleJsPlugin", j, ((StringBuilder)localObject3).toString());
          }
        }
      }
      i += 1;
    }
    i = RFLog.USR;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("handleBase64ToPics... list:");
    ((StringBuilder)localObject2).append(((JSONArray)localObject1).toString());
    RFLog.i("QCircleJsPlugin", i, ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("window.");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("({result:");
    ((StringBuilder)localObject2).append(((JSONArray)localObject1).toString());
    ((StringBuilder)localObject2).append("})");
    callJs(((StringBuilder)localObject2).toString());
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
  
  private void handleConfirmSchoolName(String paramString)
  {
    paramString = new QCircleJsPlugin.SafeJsonObject(this, paramString).getString("schoolName");
    if ((this.mRuntime != null) && (((this.mRuntime.a() instanceof QCircleHybirdFragment)) || ((this.mRuntime.a() instanceof QQTranslucentBrowserActivity.QQTranslucentBrowserFragment))))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action_confirm_school_name");
      localIntent.putExtra("schoolName", paramString);
      BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().finish();
      }
    }
  }
  
  private void handleRefreshFeedList(String paramString)
  {
    paramString = new QCircleJsPlugin.SafeJsonObject(this, paramString).getString("page");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.a()).b(paramString);
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
    if ((this.mRuntime != null) && (((this.mRuntime.a() instanceof QCircleHybirdFragment)) || ((this.mRuntime.a() instanceof QQTranslucentBrowserActivity.QQTranslucentBrowserFragment))))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action_reload_get_main_page");
      localIntent.putExtra("uin", paramString);
      BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    }
  }
  
  private void handleSetUserWearingMedal(String paramString)
  {
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment)))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action_user_wearing_medal_update");
      localIntent.putExtra("json", paramString);
      ((QCircleHybirdFragment)this.mRuntime.a()).a(localIntent);
    }
  }
  
  private void handleTitleBarStyle(String paramString)
  {
    paramString = new QCircleJsPlugin.SafeJsonObject(this, paramString);
    if (paramString.has("titleTextColor"))
    {
      int i = ((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).getColorFromJSON(paramString, "titleTextColor");
      paramString = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
      if ((paramString != null) && (paramString.a != null))
      {
        if (i == -1)
        {
          paramString.a.h();
          return;
        }
        paramString.a.d(i | 0xFF000000);
      }
    }
  }
  
  private void handleUpdateAuthInfo(String paramString)
  {
    paramString = new QCircleJsPlugin.SafeJsonObject(this, paramString);
    int i = paramString.optInt("tagtype");
    int j = paramString.optInt("status");
    paramString = paramString.optString("tagname");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.a()).a(i, j, paramString);
    }
  }
  
  private void handleUpdateNativeTagFollowState(String paramString)
  {
    paramString = new QCircleJsPlugin.SafeJsonObject(this, paramString);
    String str = paramString.getString("tagId");
    int i = paramString.getInt("type");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.a()).a(str, i);
    }
  }
  
  private void handleUpdateNativeUserFollowState(String paramString)
  {
    Object localObject = new QCircleJsPlugin.SafeJsonObject(this, paramString);
    paramString = ((QCircleJsPlugin.SafeJsonObject)localObject).getString("uin");
    int i = ((QCircleJsPlugin.SafeJsonObject)localObject).getInt("type");
    int j = ((QCircleJsPlugin.SafeJsonObject)localObject).optInt("isDoubly");
    localObject = ((QCircleJsPlugin.SafeJsonObject)localObject).optString("nick");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.a()).a(paramString, i, j, (String)localObject);
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
    if (("confirmSchoolName".equals(paramString)) && (checkArgsValid(paramArrayOfString))) {
      handleConfirmSchoolName(paramArrayOfString[0]);
    }
  }
  
  private void reportReadMessage(String paramString)
  {
    int i = new QCircleJsPlugin.SafeJsonObject(this, paramString).getInt("createTime");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment)))
    {
      int j = RFLog.USR;
      paramString = new StringBuilder();
      paramString.append("reportReadMessage createTime");
      paramString.append(i);
      RFLog.d("QCircleJsPlugin", j, paramString.toString());
      ((QCircleHybirdFragment)this.mRuntime.a()).a(i);
    }
  }
  
  private void setLabel(String paramString1, String paramString2)
  {
    Object localObject = this.mRuntime.a();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).jsonToLabel(localIntent.getExtras(), paramString1));
      ((Activity)localObject).setResult(-1, localIntent);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = localIntent.getStringExtra(((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).KEY_PARSE_DATA_ERROR_MSG());
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
    RFLog.e("QCircleJsPlugin", RFLog.USR, "setLabel activity is null");
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("qcircle".equals(paramString2))
    {
      int i = RFLog.CLR;
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest:");
      paramJsBridgeListener.append(paramString1);
      RFLog.i("QCircleJsPlugin", i, paramJsBridgeListener.toString());
      try
      {
        parseJsBridge(paramString3, paramVarArgs);
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        RFLog.d("QCircleJsPlugin", RFLog.CLR, new Object[] { paramJsBridgeListener });
        return true;
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.hybird.QCircleJsPlugin
 * JD-Core Version:    0.7.0.1
 */