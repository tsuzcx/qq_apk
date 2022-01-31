package com.tencent.mobileqq.confess;

import abkz;
import abla;
import ablb;
import ablc;
import abld;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader;
import com.tencent.mobileqq.campuscircle.CampusCircleIpcClient;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.Locale;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConfessPlugin
  extends WebViewPlugin
{
  private int jdField_a_of_type_Int = -2147483648;
  public NonMainAppHeadLoader a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public WXShareHelper.WXShareListener a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ablc(this);
  String jdField_a_of_type_JavaLangString;
  public JSONObject a;
  
  public ConfessPlugin()
  {
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    this.mPluginNameSpace = "sayHonest";
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void a(int paramInt)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    TextView localTextView;
    label89:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ConfessPlugin", 2, String.format("setRightBtnMaxLen %d", new Object[] { Integer.valueOf(paramInt) }));
      }
      localTextView = (TextView)localActivity.findViewById(2131363410);
      if (this.jdField_a_of_type_Int == -2147483648) {
        if (Build.VERSION.SDK_INT < 16) {
          break label89;
        }
      }
      for (this.jdField_a_of_type_Int = localTextView.getMaxWidth(); paramInt == 0; this.jdField_a_of_type_Int = AIOUtils.a(100.0F, localActivity.getResources()))
      {
        localTextView.setMaxWidth(this.jdField_a_of_type_Int);
        return;
      }
    } while (paramInt <= 0);
    localTextView.setMaxWidth(AIOUtils.a(paramInt, localActivity.getResources()));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new ablb(this, paramInt1, paramInt2));
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
      if ((localWebUiBaseInterface instanceof WebUiUtils.WebShareInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((WebUiUtils.WebShareInterface)localWebUiBaseInterface).a().a();
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131558448));
  }
  
  private void a(AppInterface paramAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i = 11;
    paramString2 = QZoneHelper.UserInfo.a();
    paramString2.jdField_a_of_type_JavaLangString = paramAppInterface.getCurrentAccountUin();
    paramString2.b = ConfessShareHelper.a(paramAppInterface);
    paramAppInterface = this.mRuntime.a(paramActivity);
    if ((paramAppInterface instanceof WebViewPluginContainer)) {
      i = ((WebViewPluginContainer)paramAppInterface).a(this, (byte)11);
    }
    QZoneHelper.a(paramActivity, paramString2, paramString1, paramActivity.getString(2131429952), "", i);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, boolean paramBoolean)
  {
    String str = paramString2;
    if (paramString2 != null)
    {
      str = paramString2;
      if (paramString2.length() > 30) {
        str = ConfessShareHelper.a(paramString2, 30);
      }
    }
    paramString2 = new Intent();
    paramString2.setClass(this.mRuntime.a(), ForwardRecentActivity.class);
    paramString2.putExtra("isWebCompShare", true);
    paramString2.putExtra("key_flag_from_plugin", true);
    paramString2.putExtra("pluginName", "web_share");
    paramString2.putExtra("title", str);
    paramString2.putExtra("desc", paramString8);
    paramString2.putExtra("detail_url", paramString3);
    paramString2.putExtra("shareQQType", 13);
    paramString2.putExtra("forward_type", 1001);
    paramString2.putExtra("req_share_id", -1L);
    paramString2.putExtra("pkg_name", "com.tencent.mobileqq");
    paramString2.putExtra("image_url_remote", paramString1);
    paramString2.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131430100, new Object[] { str }));
    paramString2.putExtra("flag", 0);
    paramString2.putExtra("compatible_text", " [坦白说]请使用最新版本手机QQ体验新功能。");
    paramString2.putExtra("req_type", 1);
    paramString2.putExtra("openerProc", MobileQQ.getMobileQQ().getProcessName());
    paramString2.putExtra("k_back", paramBoolean);
    paramString2.putExtra("new_share_service_id", paramString5);
    paramString2.putExtra("app_name", paramString4);
    paramString2.putExtra("struct_share_key_source_url", paramString6);
    paramString2.putExtra("struct_share_key_source_action", "web");
    paramString2.putExtra("struct_share_key_source_icon", paramString7);
    paramString2.putExtra("stuctmsg_bytes", StructMsgFactory.a(paramString2.getExtras()).getBytes());
    paramString2.putExtra("title_max_line", 2);
    startActivityForResult(paramString2, (byte)10);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    Activity localActivity = this.mRuntime.a();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface == null) || (localActivity == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("ConfessPlugin", 2, "handleOpenConfessAIO app is null  or activity is null!");
      }
    }
    for (;;)
    {
      return;
      int j = paramJSONObject.optInt("chatType");
      int k = paramJSONObject.optInt("topicId");
      String str1 = paramJSONObject.optString("confess");
      String str2 = paramJSONObject.optString("confessorNick");
      String str3 = paramJSONObject.optString("nick_name");
      int m = paramJSONObject.optInt("confessorSex");
      String str4 = paramJSONObject.optString("callback");
      String str5 = NearbyURLSafeUtil.b(paramJSONObject.optString("confessorUin"));
      String str6 = NearbyURLSafeUtil.b(paramJSONObject.optString("toUin"));
      int n = paramJSONObject.optInt("bg_type");
      long l = paramJSONObject.optLong("confessTime");
      paramJSONObject = localAppInterface.getCurrentAccountUin();
      if ((TextUtils.equals(paramJSONObject, str6)) || (!ChatActivityUtils.a(str6)) || (!ChatActivityUtils.a(str5)) || (!Friends.isValidUin(str6)) || (!Friends.isValidUin(str5)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
        if (!TextUtils.isEmpty(str4)) {
          callJs(str4, new String[] { "invalidate params" });
        }
      }
      while (QLog.isDevelopLevel())
      {
        QLog.i("ConfessPlugin", 4, String.format(Locale.getDefault(), "handleOpenConfessAIO [chatType: %s, topicId: %s, confess: %s, confessorNick: %s, confessorUin: %s, confessorSex: %s, confessorTime:%l,  nick_name: %s, toUin: %s, bg_type: %s, callback: %s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), str1, str2, str5, Integer.valueOf(m), Long.valueOf(l), str3, str6, Integer.valueOf(n), str4 }));
        return;
        if (j == 0)
        {
          paramJSONObject = new Intent(localActivity, ChatActivity.class);
          paramJSONObject.putExtra("open_chat_from_frd_rec_confess", true);
          paramJSONObject.putExtra("key_confess_topicid", k);
          paramJSONObject.putExtra("key_confess_desc", str1);
          paramJSONObject.putExtra("key_confessor_uin", str5);
          paramJSONObject.putExtra("key_confessor_nick", str2);
          paramJSONObject.putExtra("key_confessor_sex", m);
          paramJSONObject.putExtra("key_confess_bg_type", n);
          paramJSONObject.putExtra("key_confess_rec_nick_name", str3);
          paramJSONObject.putExtra("key_confess_rec_uin", str6);
          paramJSONObject.putExtra("key_confess_time", l);
          paramJSONObject.putExtra("uin", str6);
          paramJSONObject.putExtra("uintype", 0);
          localActivity.startActivity(paramJSONObject);
        }
        else if ((TextUtils.equals(str5, str6)) || (TextUtils.equals(str5, paramJSONObject)))
        {
          int i = 1033;
          if (TextUtils.equals(str6, str5)) {
            i = 1034;
          }
          paramJSONObject = new Bundle();
          paramJSONObject.putBoolean("open_chat_from_rec_confess", true);
          paramJSONObject.putInt("key_confess_topicid", k);
          paramJSONObject.putString("key_confess_desc", str1);
          paramJSONObject.putString("key_confessor_uin", str5);
          paramJSONObject.putString("key_confessor_nick", str2);
          paramJSONObject.putInt("key_confessor_sex", m);
          paramJSONObject.putLong("key_confess_time", l);
          ConfessMsgUtil.a(localActivity, str6, i, k, str2, paramJSONObject);
        }
        else if (!TextUtils.isEmpty(str4))
        {
          callJs(str4, new String[] { "undefined chat type" });
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfessPlugin", 2, "onShareConfessCallback success:" + paramBoolean + " mShareMsgCallback=" + this.jdField_a_of_type_JavaLangString);
    }
    String str2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      str2 = this.jdField_a_of_type_JavaLangString;
      if (!paramBoolean) {
        break label82;
      }
    }
    label82:
    for (String str1 = "{'retCode': 0}";; str1 = "{'retCode': 1}")
    {
      callJs(str2, new String[] { str1 });
      return;
    }
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader = new NonMainAppHeadLoader(this.mRuntime.a(), 1);
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a();
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a(new abla(this));
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a(paramString, true);
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPlugin", 4, "preLoadQQSelfHeaderBitmap " + paramString + this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a);
    }
    return paramString != this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a;
  }
  
  private void b()
  {
    try
    {
      Object localObject = this.mRuntime.a();
      TextView localTextView = ((WebViewFragment)localObject).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a;
      localObject = ((WebViewFragment)localObject).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c;
      abkz localabkz = new abkz(this);
      if (localTextView != null) {
        localTextView.setOnTouchListener(localabkz);
      }
      if (localObject != null) {
        ((TextView)localObject).setOnTouchListener(localabkz);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ConfessPlugin", 1, "setTitleTextClickEffective exception e = ", localException);
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPlugin", 4, "handleShareConfessMessage data:" + paramJSONObject + " mLastShareData:" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if (this.jdField_a_of_type_OrgJsonJSONObject != null)
    {
      a();
      a(false);
      return;
    }
    int i = paramJSONObject.optInt("share_type");
    int k = paramJSONObject.optInt("type");
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("callback");
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      a(this.mRuntime.a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435466);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
    if ((i != 0) && (i != 1) && (i != 2) && (i != 3))
    {
      a();
      a(false);
      a(0, 2131435286);
      return;
    }
    if ((i == 2) || (i == 3)) {
      if (!WXShareHelper.a().a()) {
        i = 2131435302;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        a();
        a(false);
        a(1, i);
        return;
        if (!WXShareHelper.a().b()) {
          i = 2131435303;
        }
      }
      else
      {
        if (k != 0) {
          if (!a(this.mRuntime.a().getCurrentAccountUin())) {
            i = j;
          }
        }
        for (;;)
        {
          if (i == 0)
          {
            c(paramJSONObject);
            this.jdField_a_of_type_OrgJsonJSONObject = null;
            return;
            i = 0;
          }
          else
          {
            this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
            ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
            return;
            i = 0;
          }
        }
      }
      i = -1;
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPlugin", 4, "processShare data:" + paramJSONObject + " mHeaderLoader:" + this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader);
    }
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("desc");
    int i = paramJSONObject.optInt("share_type");
    String str3 = paramJSONObject.optString("share_url");
    int j = paramJSONObject.optInt("type");
    int k = paramJSONObject.optInt("bg_type");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("confesses");
    String str4 = paramJSONObject.optString("sourceName");
    int m = paramJSONObject.optInt("serviceID");
    boolean bool = paramJSONObject.optBoolean("back");
    ThreadManager.postImmediately(new abld(this, k, i, j, str1, str2, str3, localJSONArray, paramJSONObject.optString("sourceUrl"), paramJSONObject.optString("sourceIconUrl"), str4, m, bool), null, true);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfessPlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if ("sayHonest".equals(paramString2))
    {
      if ("shareConfessMessage".equals(paramString3))
      {
        this.jdField_a_of_type_JavaLangString = null;
        try
        {
          b(new JSONObject(paramVarArgs[0]));
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          for (;;)
          {
            a(false);
            QLog.e("ConfessPlugin", 1, "shareConfessMessage exception e = ", paramJsBridgeListener);
          }
        }
      }
      if ("openConfessAIO".equals(paramString3)) {
        try
        {
          a(new JSONObject(paramVarArgs[0]));
          return false;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("ConfessPlugin", 1, "openConfessAIO exception e = ", paramJsBridgeListener);
          return false;
        }
      }
      if ("setFirstOpen".equals(paramString3)) {
        try
        {
          NearbySPUtil.a(this.mRuntime.a().getAccount(), "confess_first_open", Integer.valueOf(new JSONObject(paramVarArgs[0]).optInt("value")));
          return false;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("ConfessPlugin", 1, "METHOD_SET_FIRST_OPEN exception e = ", paramJsBridgeListener);
          return false;
        }
      }
      if ("getFirstOpen".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = this.mRuntime.a().getAccount();
          paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
          int i = ((Integer)NearbySPUtil.a(paramJsBridgeListener, "confess_first_open", Integer.valueOf(0))).intValue();
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("value", i);
          callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
          return false;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("ConfessPlugin", 1, "METHOD_GET_FIRST_OPEN exception e = ", paramJsBridgeListener);
          return false;
        }
      }
      if ("clearRedPoint".equals(paramString3)) {
        try
        {
          CampusCircleIpcClient.a().a("frd_rec_confess");
          callJs(new JSONObject(paramVarArgs[0]).optString("callback"), new String[] { "" });
          return false;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("ConfessPlugin", 1, "METHOD_CLEAR_FRD_REC exception e = ", paramJsBridgeListener);
          return false;
        }
      }
      if ("setrightbtn_maxlen".equals(paramString3)) {
        try
        {
          a(new JSONObject(paramVarArgs[0]).optInt("limit", 0));
          return false;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("ConfessPlugin", 1, "METHOD_SETRIGHTBTN_MAXLEN exception e = ", paramJsBridgeListener);
          return false;
        }
      }
      if ("hideReport".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = (SwiftBrowserShareMenuHandler)this.mRuntime.a().jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4);
          if (paramJsBridgeListener != null) {
            paramJsBridgeListener.b = false;
          }
          return false;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("ConfessPlugin", 1, "METHOD_HIDE_REPORT exception e = ", paramJsBridgeListener);
          return false;
        }
      }
      if ("titleTextClickEffective".equals(paramString3))
      {
        b();
        return false;
      }
    }
    else
    {
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ConfessPlugin", 2, "onActivityResult requestCode=" + paramByte + "  resultCode=" + paramInt + " mShareMsgCallback=" + this.jdField_a_of_type_JavaLangString);
    }
    a();
    if ((paramByte == 10) || (paramByte == 11)) {
      if (paramInt != -1) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.b();
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader = null;
    }
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin
 * JD-Core Version:    0.7.0.1
 */