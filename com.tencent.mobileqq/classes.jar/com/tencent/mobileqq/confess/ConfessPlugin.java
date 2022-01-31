package com.tencent.mobileqq.confess;

import abzg;
import abzh;
import abzi;
import abzj;
import abzk;
import abzn;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader;
import com.tencent.mobileqq.campuscircle.CampusCircleIpcClient;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.statistics.ReportController;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfessPlugin
  extends WebViewPlugin
{
  private int jdField_a_of_type_Int = -2147483648;
  public NonMainAppHeadLoader a;
  protected ConfessPlugin.ChooseFriendReceiver a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public WXShareHelper.WXShareListener a;
  Runnable jdField_a_of_type_JavaLangRunnable = new abzn(this);
  String jdField_a_of_type_JavaLangString;
  public JSONObject a;
  private Runnable b;
  protected String b;
  public String c;
  public String d;
  
  public ConfessPlugin()
  {
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    this.jdField_b_of_type_JavaLangRunnable = new abzj(this);
    this.mPluginNameSpace = "sayHonest";
  }
  
  private Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
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
      localTextView = (TextView)localActivity.findViewById(2131363447);
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
    ThreadManager.getUIHandler().post(new abzi(this, paramInt1, paramInt2));
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
    paramString2.jdField_b_of_type_JavaLangString = ConfessShareHelper.a(paramAppInterface);
    paramAppInterface = this.mRuntime.a(paramActivity);
    if ((paramAppInterface instanceof WebViewPluginContainer)) {
      i = ((WebViewPluginContainer)paramAppInterface).a(this, (byte)11);
    }
    QZoneHelper.a(paramActivity, paramString2, paramString1, paramActivity.getString(2131429970), "", i);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      super.callJs(paramString1, new String[] { paramString2 });
    }
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
    paramString2.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131430119, new Object[] { str }));
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
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a(new abzh(this));
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a(paramString, true);
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPlugin", 4, "preLoadQQSelfHeaderBitmap " + paramString + this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a);
    }
    return paramString != this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a;
  }
  
  private boolean a(String paramString, boolean paramBoolean, ArrayList paramArrayList)
  {
    Context localContext = a();
    if (localContext == null) {
      return false;
    }
    Intent localIntent = new Intent(localContext, SelectMemberActivity.class);
    localIntent.putExtra("param_groupcode", paramString);
    localIntent.putExtra("param_type", 1);
    localIntent.putExtra("param_subtype", 1);
    localIntent.putExtra("param_is_troop_admin", paramBoolean);
    localIntent.putExtra("param_done_button_wording", localContext.getString(2131434550));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", localContext.getString(2131430203));
    if (!paramBoolean) {
      localIntent.putExtra("param_max", 10);
    }
    localContext.startActivity(localIntent);
    return true;
  }
  
  private void b()
  {
    try
    {
      Object localObject = this.mRuntime.a();
      TextView localTextView = ((WebViewFragment)localObject).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a;
      localObject = ((WebViewFragment)localObject).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c;
      abzg localabzg = new abzg(this);
      if (localTextView != null) {
        localTextView.setOnTouchListener(localabzg);
      }
      if (localObject != null) {
        ((TextView)localObject).setOnTouchListener(localabzg);
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
    Activity localActivity = this.mRuntime.a();
    if ((this.mRuntime.a() == null) || (localActivity == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("ConfessPlugin", 2, "handleOpenConfessAIO app is null  or activity is null!");
      }
    }
    String str1;
    int i;
    int j;
    String str4;
    String str2;
    String str5;
    int k;
    String str3;
    long l;
    int m;
    do
    {
      return;
      str1 = NearbyURLSafeUtil.b(paramJSONObject.optString("groupUin", ""));
      i = paramJSONObject.optInt("chatType");
      j = paramJSONObject.optInt("topicId");
      str4 = NearbyURLSafeUtil.b(paramJSONObject.optString("confessorUin", ""));
      str2 = NearbyURLSafeUtil.b(paramJSONObject.optString("toUin", ""));
      str5 = paramJSONObject.optString("topic");
      k = paramJSONObject.optInt("confessorSex");
      str3 = paramJSONObject.optString("confessToNick");
      l = paramJSONObject.optLong("confessTime");
      m = paramJSONObject.optInt("confessToNickType");
      paramJSONObject = paramJSONObject.optString("callback");
      if (((!ChatActivityUtils.a(str2)) || (!ChatActivityUtils.a(str4)) || (TextUtils.isEmpty(str5)) || (TextUtils.isEmpty(str3)) || (i != 0)) && (!TextUtils.isEmpty(paramJSONObject))) {
        callJs(paramJSONObject, new String[] { "invalidate params" });
      }
    } while (i != 0);
    Intent localIntent = AIOUtils.a(new Intent(localActivity, SplashActivity.class), null);
    localIntent.putExtra("open_chat_from_group_rec_confess", true);
    localIntent.putExtra("key_confess_topicid", j);
    localIntent.putExtra("key_confess_desc", str5);
    localIntent.putExtra("key_confessor_uin", str4);
    if (k == 1) {}
    for (paramJSONObject = "一个女生";; paramJSONObject = "一个男生")
    {
      localIntent.putExtra("key_confessor_nick", paramJSONObject);
      localIntent.putExtra("key_confessor_sex", k);
      localIntent.putExtra("key_confess_bg_type", j % 4);
      localIntent.putExtra("key_confess_rec_nick_name", str3);
      localIntent.putExtra("key_confess_rec_uin", str2);
      localIntent.putExtra("key_confess_time", l);
      localIntent.putExtra("key_confess_rec_nick_type", m);
      localIntent.putExtra("uin", str1);
      localIntent.putExtra("uintype", 1);
      localActivity.startActivity(localIntent);
      return;
    }
  }
  
  private void c(JSONObject paramJSONObject)
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435499);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
    if ((i != 0) && (i != 1) && (i != 2) && (i != 3))
    {
      a();
      a(false);
      a(0, 2131435319);
      return;
    }
    if ((i == 2) || (i == 3)) {
      if (!WXShareHelper.a().a()) {
        i = 2131435335;
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
          i = 2131435336;
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
            d(paramJSONObject);
            this.jdField_a_of_type_OrgJsonJSONObject = null;
            return;
            i = 0;
          }
          else
          {
            this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
            ThreadManager.getUIHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
            return;
            i = 0;
          }
        }
      }
      i = -1;
    }
  }
  
  private void d(JSONObject paramJSONObject)
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
    ThreadManager.postImmediately(new abzk(this, k, i, j, str1, str2, str3, localJSONArray, paramJSONObject.optString("sourceUrl"), paramJSONObject.optString("sourceIconUrl"), str4, m, bool), null, true);
  }
  
  private void e(JSONObject paramJSONObject)
  {
    Object localObject = a();
    if ((localObject == null) || (paramJSONObject == null) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      a(null, null);
      return;
    }
    String str2 = paramJSONObject.optString("title", "选择我的好友");
    paramJSONObject = paramJSONObject.optJSONObject("confirm");
    String str1;
    boolean bool;
    if (paramJSONObject != null)
    {
      str1 = paramJSONObject.optString("title");
      paramJSONObject = paramJSONObject.optString("content");
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ConfessPlugin", 2, "chooseFriends needConfirm: " + bool + " confirmTitle: " + str1 + " confirmContent: " + paramJSONObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin$ChooseFriendReceiver == null) {
        this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin$ChooseFriendReceiver = new ConfessPlugin.ChooseFriendReceiver(this, new Handler());
      }
      Parcel localParcel = Parcel.obtain();
      this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin$ChooseFriendReceiver.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      ResultReceiver localResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      localObject = new Intent((Context)localObject, ForwardRecentActivity.class);
      ((Intent)localObject).putExtra("forward_type", 15);
      ((Intent)localObject).putExtra("choose_friend_title", str2);
      ((Intent)localObject).putExtra("choose_friend_is_qqfriends", true);
      ((Intent)localObject).putExtra("choose_friend_callback", localResultReceiver);
      ((Intent)localObject).putExtra("choose_friend_isForConfess", true);
      if (bool)
      {
        ((Intent)localObject).putExtra("choose_friend_needConfirm", bool);
        ((Intent)localObject).putExtra("choose_friend_confirmTitle", str1);
        ((Intent)localObject).putExtra("choose_friend_confirmContent", paramJSONObject);
      }
      super.startActivityForResult((Intent)localObject, (byte)12);
      return;
      str1 = "";
      bool = false;
      paramJSONObject = "";
    }
  }
  
  protected void a(List paramList1, List paramList2)
  {
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((paramList1 == null) || (paramList2 == null)) {
          break label272;
        }
        i = 0;
        if ((i >= paramList1.size()) || (i >= paramList2.size())) {
          break label272;
        }
        if (TextUtils.isEmpty((CharSequence)paramList1.get(i))) {
          break label277;
        }
        String str2 = (String)paramList1.get(i);
        if (!TextUtils.isEmpty((CharSequence)paramList2.get(i)))
        {
          paramList1 = (String)paramList2.get(i);
          paramList2 = new JSONObject();
          paramList2.put("uin", str2);
          paramList2.put("name", paramList1);
          String str1 = "";
          paramList1 = str1;
          if (this.mRuntime != null)
          {
            paramList1 = str1;
            if (this.mRuntime.a() != null) {
              paramList1 = this.mRuntime.a().getCurrentAccountUin();
            }
          }
          ReportController.b(null, "dc00898", "", "", "0X80092F7", "0X80092F7", 0, 0, "", "", paramList1, str2);
          paramList1 = paramList2;
          if (paramList1 != null)
          {
            localJSONObject.put("retCode", 0);
            localJSONObject.put("friend", paramList1);
            if (QLog.isColorLevel()) {
              QLog.i("ConfessPlugin", 2, localJSONObject.toString());
            }
            a(this.jdField_b_of_type_JavaLangString, localJSONObject.toString());
            this.jdField_b_of_type_JavaLangString = null;
            return;
          }
          localJSONObject.put("retCode", -1);
          continue;
        }
        paramList1 = "";
      }
      catch (JSONException paramList1)
      {
        paramList1.printStackTrace();
        return;
      }
      continue;
      label272:
      paramList1 = null;
      continue;
      label277:
      i += 1;
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("ConfessPlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if ("sayHonest".equals(paramString2)) {
      if ("shareConfessMessage".equals(paramString3)) {
        this.jdField_a_of_type_JavaLangString = null;
      }
    }
    for (;;)
    {
      try
      {
        c(new JSONObject(paramVarArgs[0]));
        bool = true;
        return bool;
      }
      catch (Exception paramJsBridgeListener)
      {
        a(false);
        QLog.e("ConfessPlugin", 1, "shareConfessMessage exception e = ", paramJsBridgeListener);
        continue;
      }
      if ("openConfessAIO".equals(paramString3))
      {
        try
        {
          a(new JSONObject(paramVarArgs[0]));
          bool = false;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("ConfessPlugin", 1, "openConfessAIO exception e = ", paramJsBridgeListener);
          bool = false;
        }
      }
      else if ("setFirstOpen".equals(paramString3))
      {
        try
        {
          NearbySPUtil.a(this.mRuntime.a().getAccount(), "confess_first_open", Integer.valueOf(new JSONObject(paramVarArgs[0]).optInt("value")));
          bool = false;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("ConfessPlugin", 1, "METHOD_SET_FIRST_OPEN exception e = ", paramJsBridgeListener);
          bool = false;
        }
      }
      else if ("getFirstOpen".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = this.mRuntime.a().getAccount();
          paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
          int i = ((Integer)NearbySPUtil.a(paramJsBridgeListener, "confess_first_open", Integer.valueOf(0))).intValue();
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("value", i);
          callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
          bool = false;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("ConfessPlugin", 1, "METHOD_GET_FIRST_OPEN exception e = ", paramJsBridgeListener);
          bool = false;
        }
      }
      else if ("clearRedPoint".equals(paramString3))
      {
        try
        {
          CampusCircleIpcClient.a().a("frd_rec_confess");
          callJs(new JSONObject(paramVarArgs[0]).optString("callback"), new String[] { "" });
          bool = false;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("ConfessPlugin", 1, "METHOD_CLEAR_FRD_REC exception e = ", paramJsBridgeListener);
          bool = false;
        }
      }
      else if ("setrightbtn_maxlen".equals(paramString3))
      {
        try
        {
          a(new JSONObject(paramVarArgs[0]).optInt("limit", 0));
          bool = false;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("ConfessPlugin", 1, "METHOD_SETRIGHTBTN_MAXLEN exception e = ", paramJsBridgeListener);
          bool = false;
        }
      }
      else if ("hideReport".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = (SwiftBrowserShareMenuHandler)this.mRuntime.a().jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4);
          if (paramJsBridgeListener != null) {
            paramJsBridgeListener.b = false;
          }
          bool = false;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("ConfessPlugin", 1, "METHOD_HIDE_REPORT exception e = ", paramJsBridgeListener);
          bool = false;
        }
      }
      else if ("titleTextClickEffective".equals(paramString3))
      {
        b();
        bool = false;
      }
      else if ("openGroupAIO".equals(paramString3))
      {
        try
        {
          b(new JSONObject(paramVarArgs[0]));
          bool = false;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("ConfessPlugin", 1, "METHOD_SETRIGHTBTN_MAXLEN exception e = ", paramJsBridgeListener);
          bool = false;
        }
      }
      else if ("getFriendInfo".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          if (paramJsBridgeListener != null) {}
          for (this.jdField_b_of_type_JavaLangString = paramJsBridgeListener.optString("callback");; this.jdField_b_of_type_JavaLangString = null)
          {
            e(paramJsBridgeListener);
            bool = false;
            break;
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          a(null, null);
          QLog.e("ConfessPlugin", 1, "METHOD_GET_FRIEND_INFO exception e = ", paramJsBridgeListener);
          bool = false;
        }
      }
      else if ("inviteMemberToGroup".equals(paramString3))
      {
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          if (paramString1 != null)
          {
            paramJsBridgeListener = paramString1.getString("troopUin");
            paramString1 = paramString1.optString("callback");
            if (TextUtils.isEmpty(paramJsBridgeListener)) {
              continue;
            }
            this.c = NearbyURLSafeUtil.b(paramJsBridgeListener);
            this.d = paramString1;
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
              a(this.mRuntime.a());
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435499);
              if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
              }
            }
            ThreadManager.postImmediately(this.jdField_a_of_type_JavaLangRunnable, null, true);
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          for (;;)
          {
            QLog.e("ConfessPlugin", 1, "METHOD_INVITE_TROOP_MEMBERS exception e = ", paramJsBridgeListener);
          }
        }
        bool = true;
        continue;
        bool = super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ConfessPlugin", 2, "onActivityResult requestCode=" + paramByte + "  resultCode=" + paramInt + " mShareMsgCallback=" + this.jdField_a_of_type_JavaLangString);
    }
    a();
    if ((paramByte == 10) || (paramByte == 11)) {
      if (paramInt == -1)
      {
        bool = true;
        a(bool);
      }
    }
    while ((paramByte != 12) || (paramInt != 0) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      for (;;)
      {
        return;
        boolean bool = false;
      }
    }
    a(null, null);
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
    a();
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin
 * JD-Core Version:    0.7.0.1
 */