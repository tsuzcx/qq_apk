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
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.musicpendant.Base64;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qcircle.api.IToastUtil;
import com.tencent.mobileqq.qcircle.api.util.PhotoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.LbsDataV2.GpsInfo;
import java.io.File;
import org.json.JSONArray;
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
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1))
    {
      RFLog.e("QCircleJsPlugin", RFLog.CLR, "args is null");
      bool = false;
    }
    return bool;
  }
  
  private void getGpsInfo(String paramString)
  {
    Object localObject1 = this.mRuntime.a();
    if ((localObject1 == null) || (((Activity)localObject1).isFinishing()) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return;
        localObject1 = ((Activity)localObject1).getIntent();
      } while (localObject1 == null);
      localObject1 = ((Intent)localObject1).getExtras();
    } while (localObject1 == null);
    Object localObject2 = (LbsDataV2.GpsInfo)((Bundle)localObject1).getParcelable(((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).KEY_GPS_INFO());
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
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("lat", ((LbsDataV2.GpsInfo)localObject1).lat);
      localJSONObject.put("lon", ((LbsDataV2.GpsInfo)localObject1).lon);
      localJSONObject.put("alt", ((LbsDataV2.GpsInfo)localObject1).alt);
      ((JSONObject)localObject2).put("gpsInfo", localJSONObject);
      label162:
      callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
      return;
    }
    catch (Exception localException)
    {
      break label162;
    }
  }
  
  private void getLabel(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing()) || (TextUtils.isEmpty(paramString))) {
      RFLog.e("QCircleJsPlugin", RFLog.USR, "getLabel activity is null");
    }
    do
    {
      do
      {
        return;
        localObject = ((Activity)localObject).getIntent();
      } while (localObject == null);
      localObject = ((Intent)localObject).getExtras();
    } while (localObject == null);
    callJs(paramString, new String[] { ((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).labelToJson((Bundle)localObject) });
  }
  
  private QCircleHybirdFragment getQCircleHybirdFragment()
  {
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      return (QCircleHybirdFragment)this.mRuntime.a();
    }
    return null;
  }
  
  private void handleBase64ToPics(String paramString)
  {
    Object localObject1 = new QCircleJsPlugin.SafeJsonObject(this, paramString);
    paramString = ((QCircleJsPlugin.SafeJsonObject)localObject1).getString("callback");
    localObject1 = ((QCircleJsPlugin.SafeJsonObject)localObject1).optJSONArray("images");
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < ((JSONArray)localObject1).length())
    {
      Object localObject2 = ((JSONArray)localObject1).getJSONObject(i).getString("image");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject2 = Base64.a(localObject2.split(",")[1]);
        localObject2 = BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length);
        JSONObject localJSONObject = new JSONObject();
        if (localObject2 != null)
        {
          String str1 = System.currentTimeMillis() + ".jpeg";
          String str2 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE);
          File localFile = new File(str2);
          if (!localFile.exists()) {
            localFile.mkdirs();
          }
          str1 = str2 + str1;
          if (PhotoUtils.a((Bitmap)localObject2, str1, Bitmap.CompressFormat.JPEG, 100, true))
          {
            localJSONObject.put("path", str1);
            localJSONArray.put(localJSONObject);
            RFLog.i("QCircleJsPlugin", RFLog.USR, "handleBase64ToPics... file save success:" + str1);
          }
          else
          {
            RFLog.e("QCircleJsPlugin", RFLog.USR, "handleBase64ToPics... file save failed:" + str1);
          }
        }
      }
    }
    RFLog.i("QCircleJsPlugin", RFLog.USR, "handleBase64ToPics... list:" + localJSONArray.toString());
    callJs("window." + paramString + "({result:" + localJSONArray.toString() + "})");
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
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.a()).a(paramString);
    }
  }
  
  private void handleTitleBarStyle(String paramString)
  {
    paramString = new QCircleJsPlugin.SafeJsonObject(this, paramString);
    int i;
    if (paramString.has("titleTextColor"))
    {
      i = ((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).getColorFromJSON(paramString, "titleTextColor");
      paramString = getQCircleHybirdFragment();
      if (paramString != null)
      {
        if (i != -1) {
          break label57;
        }
        paramString.resetTitleBarTextColor();
      }
    }
    return;
    label57:
    paramString.setTitleBarTextColor(i | 0xFF000000);
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
    if (("getLabel".equals(paramString)) && (checkArgsValid(paramArrayOfString))) {
      getLabel(new JSONObject(paramArrayOfString[0]).optString("callback"));
    }
    do
    {
      do
      {
        return;
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
      } while ((("reportReadMessage".equals(paramString)) && (checkArgsValid(paramArrayOfString))) || (("isQCircleActive".equals(paramString)) && (checkArgsValid(paramArrayOfString))));
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
    } while ((!"chargeStatusCallback".equals(paramString)) || (!checkArgsValid(paramArrayOfString)));
    handleChargeStatus(paramArrayOfString[0]);
  }
  
  private void reportReadMessage(String paramString)
  {
    int i = new QCircleJsPlugin.SafeJsonObject(this, paramString).getInt("createTime");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment)))
    {
      RFLog.d("QCircleJsPlugin", RFLog.USR, "reportReadMessage createTime" + i);
      ((QCircleHybirdFragment)this.mRuntime.a()).a(i);
    }
  }
  
  private void setLabel(String paramString1, String paramString2)
  {
    Object localObject = this.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      RFLog.e("QCircleJsPlugin", RFLog.USR, "setLabel activity is null");
    }
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent();
      localIntent.putExtras(((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).jsonToLabel(localIntent.getExtras(), paramString1));
      ((Activity)localObject).setResult(-1, localIntent);
    } while (TextUtils.isEmpty(paramString2));
    localObject = localIntent.getStringExtra(((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).KEY_PARSE_DATA_ERROR_MSG());
    paramString1 = "{\"ret\":0, \"msg\":\"sucess\"}";
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString1 = "{\"ret\":-1, \"msg\":\"" + (String)localObject + "\"}";
    }
    callJs(paramString2, new String[] { paramString1 });
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("qcircle".equals(paramString2))
    {
      RFLog.i("QCircleJsPlugin", RFLog.CLR, "handleJsRequest:" + paramString1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.hybird.QCircleJsPlugin
 * JD-Core Version:    0.7.0.1
 */