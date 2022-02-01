package com.tencent.mobileqq.confess;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
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
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.campuscircle.CampusCircleIpcClient;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
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
import com.tencent.mobileqq.webview.swift.WebViewProvider;
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
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfessPlugin
  extends WebViewPlugin
{
  private int jdField_a_of_type_Int = -2147483648;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog = null;
  INonMainProcAvatarLoader jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader;
  protected ConfessPlugin.ChooseFriendReceiver a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  Runnable jdField_a_of_type_JavaLangRunnable = new ConfessPlugin.6(this);
  String jdField_a_of_type_JavaLangString;
  JSONObject jdField_a_of_type_OrgJsonJSONObject = null;
  private Runnable b;
  protected String b;
  String c;
  String d;
  
  public ConfessPlugin()
  {
    this.jdField_b_of_type_JavaLangRunnable = new ConfessPlugin.4(this);
    this.mPluginNameSpace = "sayHonest";
  }
  
  private Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void a()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void a(int paramInt)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPlugin", 2, String.format("setRightBtnMaxLen %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    TextView localTextView = (TextView)localActivity.findViewById(2131369233);
    if (localTextView == null) {
      return;
    }
    if (this.jdField_a_of_type_Int == -2147483648) {
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_Int = localTextView.getMaxWidth();
      } else {
        this.jdField_a_of_type_Int = AIOUtils.b(100.0F, localActivity.getResources());
      }
    }
    if (paramInt == 0)
    {
      localTextView.setMaxWidth(this.jdField_a_of_type_Int);
      return;
    }
    if (paramInt > 0) {
      localTextView.setMaxWidth(AIOUtils.b(paramInt, localActivity.getResources()));
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new ConfessPlugin.3(this, paramInt1, paramInt2));
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
      if ((localWebUiBaseInterface instanceof WebUiUtils.WebShareInterface))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((Share)((WebUiUtils.WebShareInterface)localWebUiBaseInterface).getShare()).a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299168));
    }
  }
  
  private void a(AppInterface paramAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString2 = QZoneHelper.UserInfo.getInstance();
    paramString2.qzone_uin = paramAppInterface.getCurrentAccountUin();
    paramString2.nickname = ConfessShareHelper.a(paramAppInterface);
    paramAppInterface = this.mRuntime.a(paramActivity);
    int i;
    if ((paramAppInterface instanceof WebViewPluginContainer)) {
      i = ((WebViewPluginContainer)paramAppInterface).switchRequestCode(this, (byte)11);
    } else {
      i = 11;
    }
    QZoneHelper.forwardToPublishMood(paramActivity, paramString2, paramString1, paramActivity.getString(2131692105), "", i);
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
    paramString2.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696401, new Object[] { str }));
    paramString2.putExtra("flag", 0);
    paramString2.putExtra("compatible_text", ConfessMsgUtil.jdField_a_of_type_JavaLangString);
    paramString2.putExtra("req_type", 1);
    paramString2.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
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
    Object localObject = this.mRuntime.a();
    if ((localObject != null) && (localActivity != null))
    {
      int k = paramJSONObject.optInt("chatType");
      int m = paramJSONObject.optInt("topicId");
      String str2 = paramJSONObject.optString("confess");
      String str3 = paramJSONObject.optString("confessorNick");
      String str4 = paramJSONObject.optString("nick_name");
      int n = paramJSONObject.optInt("confessorSex");
      String str1 = paramJSONObject.optString("callback");
      String str5 = NearbyURLSafeUtil.b(paramJSONObject.optString("confessorUin"));
      String str6 = NearbyURLSafeUtil.b(paramJSONObject.optString("toUin"));
      int i = paramJSONObject.optInt("bg_type");
      long l = paramJSONObject.optLong("confessTime");
      paramJSONObject = ((AppInterface)localObject).getCurrentAccountUin();
      int j;
      if ((!TextUtils.equals(paramJSONObject, str6)) && (ChatActivityUtils.a(str6)) && (ChatActivityUtils.a(str5)) && (Friends.isValidUin(str6)) && (Friends.isValidUin(str5)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
      {
        if (k == 0)
        {
          paramJSONObject = new Intent(localActivity, ChatActivity.class);
          paramJSONObject.putExtra("open_chat_from_frd_rec_confess", true);
          paramJSONObject.putExtra("key_confess_topicid", m);
          paramJSONObject.putExtra("key_confess_desc", str2);
          paramJSONObject.putExtra("key_confessor_uin", str5);
          paramJSONObject.putExtra("key_confessor_nick", str3);
          paramJSONObject.putExtra("key_confessor_sex", n);
          paramJSONObject.putExtra("key_confess_bg_type", i);
          paramJSONObject.putExtra("key_confess_rec_nick_name", str4);
          paramJSONObject.putExtra("key_confess_rec_uin", str6);
          paramJSONObject.putExtra("key_confess_time", l);
          paramJSONObject.putExtra("uin", str6);
          paramJSONObject.putExtra("uintype", 0);
          localActivity.startActivity(paramJSONObject);
        }
        for (;;)
        {
          paramJSONObject = str1;
          break label561;
          if (TextUtils.equals(str5, str6)) {
            break;
          }
          j = i;
          if (TextUtils.equals(str5, paramJSONObject)) {
            break;
          }
          if (!TextUtils.isEmpty(str1))
          {
            callJs(str1, new String[] { "undefined chat type" });
            paramJSONObject = str1;
            i = j;
            break label561;
          }
        }
        j = 1033;
        if (TextUtils.equals(str6, str5)) {
          j = 1034;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("open_chat_from_rec_confess", true);
        ((Bundle)localObject).putInt("key_confess_topicid", m);
        ((Bundle)localObject).putString("key_confess_desc", str2);
        ((Bundle)localObject).putString("key_confessor_uin", str5);
        ((Bundle)localObject).putString("key_confessor_nick", str3);
        ((Bundle)localObject).putInt("key_confessor_sex", n);
        ((Bundle)localObject).putLong("key_confess_time", l);
        paramJSONObject = str1;
        ConfessMsgUtil.a(localActivity, str6, j, m, str3, (Bundle)localObject);
        j = i;
      }
      else
      {
        j = i;
        paramJSONObject = str1;
        if (!TextUtils.isEmpty(str1))
        {
          paramJSONObject = str1;
          callJs(paramJSONObject, new String[] { "invalidate params" });
          break label561;
        }
      }
      i = j;
      label561:
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessPlugin", 4, String.format(Locale.getDefault(), "handleOpenConfessAIO [chatType: %s, topicId: %s, confess: %s, confessorNick: %s, confessorUin: %s, confessorSex: %s, confessorTime:%l,  nick_name: %s, toUin: %s, bg_type: %s, callback: %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), str2, str3, str5, Integer.valueOf(n), Long.valueOf(l), str4, str6, Integer.valueOf(i), paramJSONObject }));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPlugin", 2, "handleOpenConfessAIO app is null  or activity is null!");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShareConfessCallback success:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" mShareMsgCallback=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("ConfessPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      if (paramBoolean) {
        localObject = "{'retCode': 0}";
      } else {
        localObject = "{'retCode': 1}";
      }
      callJs(str, new String[] { localObject });
    }
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.mRuntime.a(), 1);
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a();
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a(new ConfessPlugin.2(this));
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a(paramString, true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preLoadQQSelfHeaderBitmap ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a());
      QLog.i("ConfessPlugin", 4, localStringBuilder.toString());
    }
    return paramString != this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a();
  }
  
  private boolean a(String paramString, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Context localContext = a();
    if (localContext == null) {
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("param_groupcode", paramString);
    localIntent.putExtra("param_type", 1);
    localIntent.putExtra("param_subtype", 1);
    localIntent.putExtra("param_is_troop_admin", paramBoolean);
    localIntent.putExtra("param_done_button_wording", localContext.getString(2131692486));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", localContext.getString(2131696061));
    localIntent.putExtra("param_max", 100);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(localContext, localIntent);
    return true;
  }
  
  private void b()
  {
    try
    {
      Object localObject = (WebViewFragment)this.mRuntime.a();
      if (localObject == null) {
        return;
      }
      TextView localTextView = ((WebViewFragment)localObject).getSwiftTitleUI().a;
      localObject = ((WebViewFragment)localObject).getSwiftTitleUI().c;
      ConfessPlugin.1 local1 = new ConfessPlugin.1(this);
      if (localTextView != null) {
        localTextView.setOnTouchListener(local1);
      }
      if (localObject != null)
      {
        ((TextView)localObject).setOnTouchListener(local1);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ConfessPlugin", 1, "setTitleTextClickEffective exception e = ", localException);
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    Activity localActivity = this.mRuntime.a();
    if ((this.mRuntime.a() != null) && (localActivity != null))
    {
      String str1 = "";
      String str2 = NearbyURLSafeUtil.b(paramJSONObject.optString("groupUin", ""));
      int i = paramJSONObject.optInt("chatType");
      int j = paramJSONObject.optInt("topicId");
      String str5 = NearbyURLSafeUtil.b(paramJSONObject.optString("confessorUin", ""));
      String str3 = NearbyURLSafeUtil.b(paramJSONObject.optString("toUin", ""));
      String str6 = paramJSONObject.optString("topic");
      int k = paramJSONObject.optInt("confessorSex");
      String str4 = paramJSONObject.optString("confessToNick");
      long l = paramJSONObject.optLong("confessTime");
      int m = paramJSONObject.optInt("confessToNickType");
      if (paramJSONObject.has("confessorNick")) {
        str1 = paramJSONObject.optString("confessorNick");
      }
      paramJSONObject = paramJSONObject.optString("callback");
      if (((!ChatActivityUtils.a(str3)) || (!ChatActivityUtils.a(str5)) || (TextUtils.isEmpty(str6)) || (TextUtils.isEmpty(str4)) || (i != 0)) && (!TextUtils.isEmpty(paramJSONObject))) {
        callJs(paramJSONObject, new String[] { "invalidate params" });
      }
      if (i == 0)
      {
        paramJSONObject = AIOUtils.a(new Intent(localActivity, SplashActivity.class), null);
        paramJSONObject.putExtra("open_chat_from_group_rec_confess", true);
        paramJSONObject.putExtra("key_confess_topicid", j);
        paramJSONObject.putExtra("key_confess_desc", str6);
        paramJSONObject.putExtra("key_confessor_uin", str5);
        if (TextUtils.isEmpty(str1))
        {
          if (k == 1) {
            i = 2131702599;
          } else {
            i = 2131702602;
          }
          str1 = HardCodeUtil.a(i);
        }
        paramJSONObject.putExtra("key_confessor_nick", str1);
        paramJSONObject.putExtra("key_confessor_sex", k);
        paramJSONObject.putExtra("key_confess_bg_type", j % 4);
        paramJSONObject.putExtra("key_confess_rec_nick_name", str4);
        paramJSONObject.putExtra("key_confess_rec_uin", str3);
        paramJSONObject.putExtra("key_confess_time", l);
        paramJSONObject.putExtra("key_confess_rec_nick_type", m);
        paramJSONObject.putExtra("uin", str2);
        paramJSONObject.putExtra("uintype", 1);
        localActivity.startActivity(paramJSONObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPlugin", 2, "handleOpenConfessAIO app is null  or activity is null!");
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    Activity localActivity = this.mRuntime.a();
    Object localObject = this.mRuntime.a();
    if ((localObject != null) && (localActivity != null))
    {
      String str5 = ((AppInterface)localObject).getCurrentAccountUin();
      int i;
      if (paramJSONObject.has("chatType")) {
        i = paramJSONObject.optInt("chatType");
      } else {
        i = 0;
      }
      int j;
      if (paramJSONObject.has("topicId")) {
        j = paramJSONObject.optInt("topicId");
      } else {
        j = 0;
      }
      boolean bool = paramJSONObject.has("confess");
      String str4 = "";
      if (bool) {
        localObject = paramJSONObject.optString("confess");
      } else {
        localObject = "";
      }
      int k;
      if (paramJSONObject.has("confessNum")) {
        k = paramJSONObject.optInt("confessNum");
      } else {
        k = 0;
      }
      int m;
      if (paramJSONObject.has("gender")) {
        m = paramJSONObject.optInt("gender");
      } else {
        m = 0;
      }
      String str1;
      if (paramJSONObject.has("callback")) {
        str1 = paramJSONObject.optString("callback");
      } else {
        str1 = "";
      }
      String str2;
      if (paramJSONObject.has("toUin")) {
        str2 = paramJSONObject.optString("toUin");
      } else {
        str2 = "";
      }
      String str3;
      if (paramJSONObject.has("fromEncodeUin")) {
        str3 = NearbyURLSafeUtil.b(paramJSONObject.optString("fromEncodeUin"));
      } else {
        str3 = "";
      }
      int n;
      if (paramJSONObject.has("bg_type")) {
        n = paramJSONObject.optInt("bg_type");
      } else {
        n = 0;
      }
      if (paramJSONObject.has("confessorNick")) {
        str4 = paramJSONObject.optString("confessorNick");
      }
      int i1;
      if (paramJSONObject.has("confessorSex")) {
        i1 = paramJSONObject.optInt("confessorSex");
      } else {
        i1 = 0;
      }
      long l;
      if (paramJSONObject.has("confessTime")) {
        l = paramJSONObject.optLong("confessTime");
      } else {
        l = 0L;
      }
      if ((TextUtils.equals(str5, str2)) || (!ChatActivityUtils.a(str2)) || (!Friends.isValidUin(str2)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ConfessPlugin", 2, "handleOpenConfessRankAIO invalidate params");
        }
        if (!TextUtils.isEmpty(str1)) {
          callJs(str1, new String[] { "invalidate params" });
        }
      }
      if ((TextUtils.equals(str3, str2)) && (!TextUtils.isEmpty(str1))) {
        callJs(str1, new String[] { "invalidate params confessorUin = toUin" });
      }
      paramJSONObject = new Intent(localActivity, ChatActivity.class);
      paramJSONObject.putExtra("open_chat_from_frd_rec_confess", true);
      paramJSONObject.putExtra("open_chat_from_frd_rank_confess", true);
      paramJSONObject.putExtra("key_confess_topicid", j);
      paramJSONObject.putExtra("key_confessor_uin", str3);
      paramJSONObject.putExtra("key_confess_desc", (String)localObject);
      paramJSONObject.putExtra("key_confessor_friend_sex", m);
      paramJSONObject.putExtra("key_confessor_nick", str4);
      paramJSONObject.putExtra("key_confessor_num", k);
      paramJSONObject.putExtra("key_confess_bg_type", n);
      paramJSONObject.putExtra("key_confess_rec_uin", str2);
      paramJSONObject.putExtra("key_confessor_sex", i1);
      paramJSONObject.putExtra("key_confess_time", l);
      paramJSONObject.putExtra("uin", str2);
      paramJSONObject.putExtra("uintype", 0);
      localActivity.startActivity(paramJSONObject);
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessPlugin", 4, String.format(Locale.getDefault(), "handleOpenConfessRankAIO [chatType: %s, topicId: %s, confess: %s, toUin: %s, friendSex: %s , confessorSex: %s ,bg_type: %s, callback: %s, confessNum: %s, confessorUin: %s, confessorNick: %s, confessTime : %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject, str2, Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(n), str1, Integer.valueOf(k), str3, str4, Long.valueOf(l) }));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPlugin", 2, "handleOpenConfessRankAIO app is null  or activity is null!");
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    Activity localActivity = this.mRuntime.a();
    if ((this.mRuntime.a() != null) && (localActivity != null))
    {
      boolean bool = paramJSONObject.has("url");
      String str2 = "";
      String str1;
      if (bool) {
        str1 = paramJSONObject.optString("url");
      } else {
        str1 = "";
      }
      if (paramJSONObject.has("callback")) {
        str2 = paramJSONObject.optString("callback");
      }
      if (TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ConfessPlugin", 2, "handleOpenGroupConfess invalidate url");
        }
        if (!TextUtils.isEmpty(str2)) {
          callJs(str2, new String[] { "invalidate url" });
        }
        return;
      }
      paramJSONObject = new Intent(localActivity, QQBrowserActivity.class);
      paramJSONObject.putExtra("url", str1);
      paramJSONObject.setFlags(603979776);
      localActivity.startActivity(paramJSONObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPlugin", 2, "handleOpenGroupConfess app is null  or activity is null!");
    }
  }
  
  private void e(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleShareConfessMessage data:");
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append(" mLastShareData:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_OrgJsonJSONObject);
      QLog.i("ConfessPlugin", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_OrgJsonJSONObject;
    int j = 0;
    if (localObject != null)
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localObject != null)
    {
      ((QQProgressDialog)localObject).c(2131693895);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
    if ((i != 0) && (i != 1) && (i != 2) && (i != 3))
    {
      a();
      a(false);
      a(0, 2131719009);
      return;
    }
    if ((i == 2) || (i == 3))
    {
      if (!WXShareHelper.a().a()) {
        i = 2131720478;
      } else if (!WXShareHelper.a().b()) {
        i = 2131720479;
      } else {
        i = -1;
      }
      if (i != -1)
      {
        a();
        a(false);
        a(1, i);
        return;
      }
    }
    i = j;
    boolean bool;
    if (k != 0) {
      bool = a(this.mRuntime.a().getCurrentAccountUin()) ^ true;
    }
    if (!bool)
    {
      f(paramJSONObject);
      this.jdField_a_of_type_OrgJsonJSONObject = null;
      return;
    }
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    ThreadManager.getUIHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
  }
  
  private void f(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("processShare data:");
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append(" mHeaderLoader:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader);
      QLog.i("ConfessPlugin", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramJSONObject.optString("title");
    String str1 = paramJSONObject.optString("desc");
    int i = paramJSONObject.optInt("share_type");
    String str2 = paramJSONObject.optString("share_url");
    int j = paramJSONObject.optInt("type");
    int k = paramJSONObject.optInt("bg_type");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("confesses");
    String str3 = paramJSONObject.optString("sourceName");
    int m = paramJSONObject.optInt("serviceID");
    boolean bool = paramJSONObject.optBoolean("back");
    ThreadManager.postImmediately(new ConfessPlugin.5(this, k, i, j, (String)localObject, str1, str2, localJSONArray, paramJSONObject.optString("sourceUrl"), paramJSONObject.optString("sourceIconUrl"), str3, m, bool), null, true);
  }
  
  private void g(JSONObject paramJSONObject)
  {
    Object localObject1 = a();
    if ((localObject1 != null) && (paramJSONObject != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      String str2 = paramJSONObject.optString("title", HardCodeUtil.a(2131702601));
      paramJSONObject = paramJSONObject.optJSONObject("confirm");
      String str1 = "";
      boolean bool;
      if (paramJSONObject != null)
      {
        str1 = paramJSONObject.optString("title");
        paramJSONObject = paramJSONObject.optString("content");
        bool = true;
      }
      else
      {
        paramJSONObject = "";
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("chooseFriends needConfirm: ");
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append(" confirmTitle: ");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(" confirmContent: ");
        ((StringBuilder)localObject2).append(paramJSONObject);
        QLog.i("ConfessPlugin", 2, ((StringBuilder)localObject2).toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin$ChooseFriendReceiver == null) {
        this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin$ChooseFriendReceiver = new ConfessPlugin.ChooseFriendReceiver(this, new Handler());
      }
      Parcel localParcel = Parcel.obtain();
      this.jdField_a_of_type_ComTencentMobileqqConfessConfessPlugin$ChooseFriendReceiver.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      Object localObject2 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      localObject1 = new Intent((Context)localObject1, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtra("forward_type", 15);
      ((Intent)localObject1).putExtra("only_single_selection", true);
      ((Intent)localObject1).putExtra("choose_friend_title", str2);
      ((Intent)localObject1).putExtra("choose_friend_is_qqfriends", true);
      ((Intent)localObject1).putExtra("choose_friend_callback", (Parcelable)localObject2);
      ((Intent)localObject1).putExtra("choose_friend_isForConfess", true);
      if (bool)
      {
        ((Intent)localObject1).putExtra("choose_friend_needConfirm", bool);
        ((Intent)localObject1).putExtra("choose_friend_confirmTitle", str1);
        ((Intent)localObject1).putExtra("choose_friend_confirmContent", paramJSONObject);
      }
      super.startActivityForResult((Intent)localObject1, (byte)12);
      return;
    }
    a(null, null);
  }
  
  protected void a(List<String> paramList1, List<String> paramList2)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((paramList1 != null) && (paramList2 != null))
        {
          int i = 0;
          if ((i < paramList1.size()) && (i < paramList2.size()))
          {
            if (!TextUtils.isEmpty((CharSequence)paramList1.get(i)))
            {
              String str = (String)paramList1.get(i);
              boolean bool = TextUtils.isEmpty((CharSequence)paramList2.get(i));
              if (bool) {
                break label278;
              }
              paramList1 = (String)paramList2.get(i);
              paramList2 = new JSONObject();
              paramList2.put("uin", str);
              paramList2.put("name", paramList1);
              if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
                break label284;
              }
              paramList1 = this.mRuntime.a().getCurrentAccountUin();
              ReportController.b(null, "dc00898", "", "", "0X80092F7", "0X80092F7", 0, 0, "", "", paramList1, str);
              paramList1 = paramList2;
              continue;
            }
            i += 1;
            continue;
          }
        }
        paramList1 = null;
        if (paramList1 != null)
        {
          localJSONObject.put("retCode", 0);
          localJSONObject.put("friend", paramList1);
        }
        else
        {
          localJSONObject.put("retCode", -1);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ConfessPlugin", 2, localJSONObject.toString());
        }
        a(this.jdField_b_of_type_JavaLangString, localJSONObject.toString());
        this.jdField_b_of_type_JavaLangString = null;
        return;
      }
      catch (JSONException paramList1)
      {
        paramList1.printStackTrace();
        return;
      }
      label278:
      paramList1 = "";
      continue;
      label284:
      paramList1 = "";
    }
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934593L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfessPlugin", 1, "EVENT_LOAD_START");
      }
      QLog.e("ConfessPlugin", 1, "EVENT_LOAD_START");
    }
    else if (paramLong == 8589934594L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfessPlugin", 1, "EVENT_LOAD_FINISH");
      }
    }
    else if (paramLong == 8589934595L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfessPlugin", 1, "EVENT_LOAD_ERROR");
      }
    }
    else if (paramLong == 8589934597L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfessPlugin", 1, "EVENT_ACTIVITY_PAUSE");
      }
    }
    else if ((paramLong == 2L) && (QLog.isColorLevel()))
    {
      QLog.d("ConfessPlugin", 1, "KEY_EVENT_ACTIVITY_RESUME");
    }
    return super.handleEvent(paramString, paramLong, paramMap);
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
          e(new JSONObject(paramVarArgs[0]));
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          a(false);
          QLog.e("ConfessPlugin", 1, "shareConfessMessage exception e = ", paramJsBridgeListener);
          return true;
        }
      }
      if ("openConfessAIO".equals(paramString3))
      {
        try
        {
          a(new JSONObject(paramVarArgs[0]));
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("ConfessPlugin", 1, "openConfessAIO exception e = ", paramJsBridgeListener);
        }
      }
      else
      {
        int i;
        if ("setFirstOpen".equals(paramString3))
        {
          try
          {
            paramJsBridgeListener = this.mRuntime.a().getAccount();
            i = new JSONObject(paramVarArgs[0]).optInt("value");
            ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramJsBridgeListener, "confess_first_open", Integer.valueOf(i));
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.e("ConfessPlugin", 1, "METHOD_SET_FIRST_OPEN exception e = ", paramJsBridgeListener);
          }
        }
        else if ("getFirstOpen".equals(paramString3))
        {
          try
          {
            paramJsBridgeListener = this.mRuntime.a().getAccount();
            paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
            i = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramJsBridgeListener, "confess_first_open", Integer.valueOf(0))).intValue();
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("value", i);
            callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.e("ConfessPlugin", 1, "METHOD_GET_FIRST_OPEN exception e = ", paramJsBridgeListener);
          }
        }
        else if ("clearRedPoint".equals(paramString3))
        {
          try
          {
            CampusCircleIpcClient.a().a("frd_rec_confess");
            callJs(new JSONObject(paramVarArgs[0]).optString("callback"), new String[] { "" });
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.e("ConfessPlugin", 1, "METHOD_CLEAR_FRD_REC exception e = ", paramJsBridgeListener);
          }
        }
        else if ("setrightbtn_maxlen".equals(paramString3))
        {
          try
          {
            a(new JSONObject(paramVarArgs[0]).optInt("limit", 0));
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.e("ConfessPlugin", 1, "METHOD_SETRIGHTBTN_MAXLEN exception e = ", paramJsBridgeListener);
          }
        }
        else if ("hideReport".equals(paramString3))
        {
          try
          {
            paramJsBridgeListener = this.mRuntime.a();
            if (paramJsBridgeListener == null) {
              break label930;
            }
            paramJsBridgeListener = (SwiftBrowserShareMenuHandler)paramJsBridgeListener.getComponentProvider().a(4);
            if (paramJsBridgeListener == null) {
              break label930;
            }
            paramJsBridgeListener.b = false;
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.e("ConfessPlugin", 1, "METHOD_HIDE_REPORT exception e = ", paramJsBridgeListener);
          }
        }
        else if ("titleTextClickEffective".equals(paramString3))
        {
          b();
        }
        else if ("openGroupAIO".equals(paramString3))
        {
          try
          {
            b(new JSONObject(paramVarArgs[0]));
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.e("ConfessPlugin", 1, "METHOD_SETRIGHTBTN_MAXLEN exception e = ", paramJsBridgeListener);
          }
        }
        else if ("getFriendInfo".equals(paramString3))
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            this.jdField_b_of_type_JavaLangString = paramJsBridgeListener.optString("callback");
            g(paramJsBridgeListener);
          }
          catch (Exception paramJsBridgeListener)
          {
            a(null, null);
            QLog.e("ConfessPlugin", 1, "METHOD_GET_FRIEND_INFO exception e = ", paramJsBridgeListener);
          }
        }
        else
        {
          if ("inviteMemberToGroup".equals(paramString3)) {
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              paramJsBridgeListener = paramString1.getString("troopUin");
              paramString1 = paramString1.optString("callback");
              if (TextUtils.isEmpty(paramJsBridgeListener)) {
                return false;
              }
              this.c = NearbyURLSafeUtil.b(paramJsBridgeListener);
              this.d = paramString1;
              if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
                a(this.mRuntime.a());
              }
              if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693895);
                if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
                  this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
                }
              }
              ThreadManager.postImmediately(this.jdField_a_of_type_JavaLangRunnable, null, true);
              return true;
            }
            catch (Exception paramJsBridgeListener)
            {
              QLog.e("ConfessPlugin", 1, "METHOD_INVITE_TROOP_MEMBERS exception e = ", paramJsBridgeListener);
              return true;
            }
          }
          if ("openConfessRankAIO".equals(paramString3))
          {
            try
            {
              c(new JSONObject(paramVarArgs[0]));
            }
            catch (Exception paramJsBridgeListener)
            {
              QLog.e("ConfessPlugin", 1, "OpenConfessRankAIO exception e = ", paramJsBridgeListener);
            }
          }
          else if ("openGroupConfess".equals(paramString3))
          {
            try
            {
              d(new JSONObject(paramVarArgs[0]));
            }
            catch (Exception paramJsBridgeListener)
            {
              QLog.e("ConfessPlugin", 1, "openGroupConfess exception e = ", paramJsBridgeListener);
            }
          }
          else if ("updateConfessSwitch".equals(paramString3))
          {
            try
            {
              i = new JSONObject(paramVarArgs[0]).optInt("switchValue");
            }
            catch (Exception paramJsBridgeListener)
            {
              QLog.e("ConfessPlugin", 1, "updateConfessSwitch exception e = ", paramJsBridgeListener);
              i = 0;
            }
            CampusCircleIpcClient.a().a(i);
          }
        }
      }
      label930:
      return false;
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onActivityResult requestCode=");
      paramIntent.append(paramByte);
      paramIntent.append("  resultCode=");
      paramIntent.append(paramInt);
      paramIntent.append(" mShareMsgCallback=");
      paramIntent.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("ConfessPlugin", 2, paramIntent.toString());
    }
    a();
    if ((paramByte != 10) && (paramByte != 11))
    {
      if ((paramByte == 12) && (paramInt == 0) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
        a(null, null);
      }
    }
    else
    {
      boolean bool;
      if (paramInt == -1) {
        bool = true;
      } else {
        bool = false;
      }
      a(bool);
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
    INonMainProcAvatarLoader localINonMainProcAvatarLoader = this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader;
    if (localINonMainProcAvatarLoader != null)
    {
      localINonMainProcAvatarLoader.b();
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader = null;
    }
    a();
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin
 * JD-Core Version:    0.7.0.1
 */