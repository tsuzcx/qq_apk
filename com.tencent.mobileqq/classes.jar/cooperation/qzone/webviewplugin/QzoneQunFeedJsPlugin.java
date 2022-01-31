package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import ankw;
import ankx;
import anky;
import ankz;
import anla;
import anlb;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.util.NetworkState;
import java.util.HashMap;
import org.json.JSONObject;

public class QzoneQunFeedJsPlugin
  extends QzoneInternalWebViewPlugin
{
  private static String jdField_a_of_type_JavaLangString = "";
  Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ankw(this);
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {}
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    } while (localCustomWebView == null);
    localCustomWebView.c("window.QZQunRedPointInterface.onReceive({data:" + paramInt + "});");
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if (paramBoolean) {
      return;
    }
    if (paramInt2 > 0)
    {
      String str = "";
      if (paramInt1 > 0)
      {
        str = String.format(localActivity.getString(2131432614), new Object[] { Integer.valueOf(paramInt1) }) + "，";
        str = str + paramString + "目录下，";
      }
      paramString = str + String.format(localActivity.getString(2131432615), new Object[] { Integer.valueOf(paramInt2) });
      DialogUtil.a(localActivity, 232).setMessage(paramString).setNegativeButton(2131432612, new anlb(this)).show();
      return;
    }
    ToastUtil.a().a(localActivity.getString(2131432613) + paramString + "目录下。");
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new QzoneQunFeedJsPlugin.LoadingDialog(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a());
      this.jdField_a_of_type_AndroidAppDialog.setTitle(2131432611);
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
    }
    this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new anla(this, paramString));
    this.jdField_a_of_type_AndroidAppDialog.show();
    RemoteHandleManager.a().a().d(paramString);
  }
  
  private void a(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunDetailDelete ");
    }
    try
    {
      paramVarArgs = new Intent("cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().sendBroadcast(paramVarArgs);
      return;
    }
    catch (Exception paramVarArgs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunDetailDelete exception:" + paramVarArgs);
    }
  }
  
  private boolean a()
  {
    return SDCardMountMonitorReceiver.a().a();
  }
  
  private void b()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.qq.syncQunMsg");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.w("QzoneQunFeedJsPlugin", 1, "registerUnreadMsgReceiver----", localException);
    }
  }
  
  private void b(String paramString)
  {
    RemoteHandleManager.a().a().e(paramString);
  }
  
  private void b(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunJumpDetail " + paramVarArgs[0]);
      }
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]).getString("url");
        Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), QQBrowserDelegationActivity.class);
        localIntent.putExtra("url", paramVarArgs);
        localIntent.putExtra("fromQZone", true);
        localIntent.putExtra("injectrecommend", true);
        if (WebViewPluginFactory.a.containsKey("Qzone")) {
          localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
        }
        localIntent.putExtra("source_name", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getString(2131432890));
        localIntent.setData(Uri.parse(paramVarArgs));
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.startActivityForResult(localIntent, (byte)0);
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunJumpDetail,decode param error");
  }
  
  private void c(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneQunFeedJsPlugin", 4, "handleStartQunRedPointNotify " + paramVarArgs[0]);
      }
      try
      {
        int i = new JSONObject(paramVarArgs[0]).getInt("groupCode");
        i = DBUtils.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getAccount(), "troop_photo_message", String.valueOf(i));
        if (QLog.isDevelopLevel()) {
          QLog.d("QzoneQunFeedJsPlugin", 4, "handleStartQunRedPointNotify data=" + i);
        }
        a(i);
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleStartQunRedPointNotify,decode param error");
  }
  
  private void d(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleEndQunRedPointNotify");
    }
  }
  
  private void e(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleHideTopicComment");
    }
  }
  
  private void f(String... paramVarArgs)
  {
    int i = 1;
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleGroupUploadPhoto " + paramVarArgs[0]);
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      int j = ((JSONObject)localObject).getInt("groupCode");
      paramVarArgs = ((JSONObject)localObject).optString("albumid");
      localObject = ((JSONObject)localObject).optString("albumname");
      String str = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getAccount();
      if (!TextUtils.isEmpty(paramVarArgs)) {
        i = 2;
      }
      QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), str, i, 1, j, "", paramVarArgs, (String)localObject, 7001, 43);
      return;
    }
    catch (Exception paramVarArgs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleGroupUploadPhoto,decode param error");
    }
  }
  
  private void g(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunDownloadPhoto " + paramVarArgs[0]);
    }
    new Intent().putExtra("photos", paramVarArgs[0]);
    RemoteHandleManager.a().a(new ankx(this));
    if (!a())
    {
      ToastUtil.a().a("SD卡不存在，无法下载。");
      return;
    }
    if (!NetworkState.isNetSupport())
    {
      ToastUtil.a().a("无网络连接，无法下载。");
      return;
    }
    if (!NetworkState.isWifiConn())
    {
      Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      DialogUtil.a(localActivity, 230).setTitle(localActivity.getString(2131432610)).setMessage(localActivity.getString(2131432616)).setPositiveButton(localActivity.getString(2131432617), new ankz(this, paramVarArgs)).setNegativeButton(localActivity.getString(2131432618), new anky(this)).show();
      return;
    }
    a(paramVarArgs[0]);
  }
  
  private void h(String... paramVarArgs)
  {
    int i = 4;
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleGroupQuote " + paramVarArgs[0]);
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramVarArgs[0]);
        int j = ((JSONObject)localObject).getInt("groupCode");
        paramVarArgs = ((JSONObject)localObject).optString("albumid");
        localObject = ((JSONObject)localObject).optString("albumname");
        String str = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getAccount();
        if (TextUtils.isEmpty(paramVarArgs)) {
          break label154;
        }
        QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), str, i, 4, j, "", paramVarArgs, (String)localObject, 7001, 43);
        return;
      }
      catch (Exception paramVarArgs) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleGroupUploadPhoto,decode param error");
      return;
      label154:
      i = 3;
    }
  }
  
  private void i(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      for (;;)
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunDidPickAlbum " + paramVarArgs[0]);
        }
        try
        {
          Object localObject = new JSONObject(paramVarArgs[0]);
          paramVarArgs = ((JSONObject)localObject).getString("albumid");
          String str = ((JSONObject)localObject).optString("albumname");
          localObject = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("UploadPhoto.key_album_id", paramVarArgs);
          localBundle.putString("UploadPhoto.key_album_name", str);
          ((Intent)localObject).putExtras(localBundle);
          paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
          if ((paramVarArgs != null) && (!paramVarArgs.isFinishing()))
          {
            paramVarArgs.setResult(-1, (Intent)localObject);
            paramVarArgs.finish();
            return;
          }
        }
        catch (Exception paramVarArgs) {}
      }
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunDidPickAlbum,decode param error");
  }
  
  private void j(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunPickQzoneAlbum " + paramVarArgs[0]);
      }
      try
      {
        jdField_a_of_type_JavaLangString = new JSONObject(paramVarArgs[0]).getString("callback");
        paramVarArgs = new Bundle();
        paramVarArgs.putInt("key_personal_album_enter_model", 0);
        paramVarArgs.putBoolean("key_pass_result_by_bundle", true);
        QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
        localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getCurrentAccountUin();
        paramVarArgs.putBoolean("key_need_change_to_jpg", true);
        QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), localUserInfo, paramVarArgs, QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, 6));
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      SDCardMountMonitorReceiver.a().b();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    switch (paramByte)
    {
    }
    do
    {
      return;
    } while ((TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) || (paramIntent == null));
    String str1 = paramIntent.getStringExtra("key_selected_albuminfo.id");
    String str2 = paramIntent.getStringExtra("key_selected_albuminfo.name");
    String str3 = paramIntent.getStringExtra("key_selected_albuminfo.cover");
    paramByte = paramIntent.getIntExtra("key_selected_albuminfo.permission", 0);
    paramIntent = new StringBuilder();
    paramIntent.append("{albumid:\"").append(str1).append("\",albumname:\"").append(str2).append("\",albumcover:\"").append(str3).append("\",albumpermission:").append(paramByte).append("}");
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, paramIntent.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(jdField_a_of_type_JavaLangString, new String[] { paramIntent.toString() });
  }
  
  public void a(WebViewPlugin paramWebViewPlugin)
  {
    super.a(paramWebViewPlugin);
    b();
    SDCardMountMonitorReceiver.a().a();
    paramWebViewPlugin.mRuntime.a().setResult(50);
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if (paramString3.equalsIgnoreCase("StartQunRedPointNotify"))
    {
      c(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("EndQunRedPointNotify"))
    {
      d(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("GroupUploadPhoto"))
    {
      f(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunDownloadPhoto"))
    {
      g(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("GroupQuote"))
    {
      h(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunDidPickAlbum"))
    {
      i(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunPickQzoneAlbum"))
    {
      j(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("HideTopicComment"))
    {
      e(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunJumpDetail"))
    {
      b(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunDetailDelete"))
    {
      a(paramVarArgs);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin
 * JD-Core Version:    0.7.0.1
 */