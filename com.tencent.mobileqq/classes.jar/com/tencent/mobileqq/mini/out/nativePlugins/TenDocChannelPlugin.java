package com.tencent.mobileqq.mini.out.nativePlugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bdhn;
import bdhu;
import bdkv;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebView;
import eipc.EIPCClient;
import org.json.JSONException;
import org.json.JSONObject;

public class TenDocChannelPlugin
  implements NativePlugin
{
  private static final String ACTION_IMPORT = "openLocalFilesToImport";
  private static final String ACTION_OPEN_EXPORT = "openExportedFile";
  private static final String ACTION_START_EXPORT = "txDocsStartExport";
  public static final String PLUGIN_NAME = "tdoc_channel";
  public static final String TAG = "TenDocChannelPlugin";
  
  private void handleDownloadExportedFile(Activity paramActivity, String paramString)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        boolean bool = localJSONObject.optBoolean("success");
        String str = localJSONObject.optString("url");
        paramString = localJSONObject.optString("fileName");
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isSuccess", bool);
        localBundle.putString("url", str);
        localBundle.putString("fileName", paramString);
        if ((!(paramActivity instanceof TeamWorkDocEditBrowserActivity)) || (((TeamWorkDocEditBrowserActivity)paramActivity).getHostWebView() == null)) {
          break label203;
        }
        paramActivity = ((TeamWorkDocEditBrowserActivity)paramActivity).getHostWebView().getUrl();
        paramString = paramActivity;
        if (TextUtils.isEmpty(paramActivity)) {
          paramString = localJSONObject.optString("refer_url");
        }
        localBundle.putString("docUrl", paramString);
        localBundle.putString("cookie", CookieManager.getInstance().getCookie(str));
        localBundle.putBoolean("isMiniProgram", true);
        QIPCClientHelper.getInstance().getClient().callServer("TeamWorkModule", "action_download_export_file", localBundle);
      }
      catch (Exception paramActivity)
      {
        QLog.e("TenDocChannelPlugin", 1, "downloadExportedFile exception e = " + paramActivity.toString());
        continue;
      }
      finally {}
      return;
      label203:
      paramActivity = null;
    }
  }
  
  private void handleStartExportedFile(Activity paramActivity, String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("fileName");
      new Bundle().putString("fileName", paramString);
      bdhu.a(paramActivity, paramString, true);
      bdkv.a(null, "0X800A4B2");
      return;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        QLog.e("TenDocChannelPlugin", 1, "startExportedFile exception e = " + paramActivity.toString());
      }
    }
    finally {}
  }
  
  private void openFMActivityToImport(Activity paramActivity, String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("folderId");
      Intent localIntent = new Intent(paramActivity, FMActivity.class);
      localIntent.putExtra(bdhn.f, true);
      localIntent.addFlags(536870912);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("busiType", 9);
      localIntent.putExtra("peerType", 10006);
      localIntent.putExtra("enterfrom", 9);
      localIntent.putExtra("tab_tab_type", 7);
      localIntent.putExtra("only_show_local_tab", true);
      localIntent.putExtra(bdhn.g, paramString);
      localIntent.putExtra("smart_device_support_flag", 8);
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        QLog.e("TenDocChannelPlugin", 1, "openFMActivityToImport exception", paramActivity);
      }
    }
    finally {}
  }
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    paramJSONObject = paramJSONObject.optString("data");
    Object localObject;
    try
    {
      localObject = new JSONObject(paramJSONObject);
      paramJSONObject = ((JSONObject)localObject).getString("action");
      localObject = ((JSONObject)localObject).getString("data");
      if (TextUtils.equals(paramJSONObject, "openLocalFilesToImport"))
      {
        openFMActivityToImport(paramJSContext.getActivity(), (String)localObject);
        return;
      }
      if (TextUtils.equals(paramJSONObject, "txDocsStartExport"))
      {
        handleStartExportedFile(paramJSContext.getActivity(), (String)localObject);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("TenDocChannelPlugin", 1, "parse param failed", paramJSONObject);
      return;
    }
    if (TextUtils.equals(paramJSONObject, "openExportedFile")) {
      handleDownloadExportedFile(paramJSContext.getActivity(), (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TenDocChannelPlugin
 * JD-Core Version:    0.7.0.1
 */