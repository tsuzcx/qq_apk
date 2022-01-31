package com.tencent.mobileqq.jsp;

import adnb;
import adnc;
import adnd;
import adne;
import adnf;
import adng;
import adnh;
import adni;
import adnj;
import adnk;
import adnl;
import adnp;
import adnq;
import adnr;
import adns;
import adnt;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.biz.ui.IPullRefreshHeader;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.biz.webviewplugin.PubAccountUIPlugin;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QReaderUiInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.ReadInJoyUiInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.VipComicUiInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebProgressInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidEntry;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidReq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.comic.VipComicHelper;
import cooperation.comic.utils.QQComicPluginBridge;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.qzone.QzoneJumpQBrowserInterface;
import cooperation.readinjoy.ReadInJoyShareManager;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.BaseActivity;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UiApiPlugin
  extends WebViewPlugin
  implements DialogInterface.OnCancelListener, View.OnClickListener, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener
{
  public static volatile BroadcastReceiver a;
  public static ResultReceiver a;
  public static CopyOnWriteArrayList a;
  public static AtomicBoolean a;
  static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public static AtomicLong a;
  public static volatile BroadcastReceiver b;
  public static AtomicBoolean b;
  public static volatile BroadcastReceiver c;
  public static AtomicBoolean c;
  public int a;
  public ProgressDialog a;
  public View a;
  public ImageView a;
  public TroopMemberApiClient a;
  public IPullRefreshHeader a;
  public RefreshView a;
  public Client.onRemoteRespObserver a;
  public ActionSheet a;
  PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog = null;
  public String a;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  public boolean a;
  int b;
  public ProgressDialog b;
  public View b;
  public ImageView b;
  public String b;
  public boolean b;
  public int c;
  public ImageView c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  protected String e;
  public boolean e;
  public String f;
  public boolean f;
  public String g;
  public boolean g;
  public String h;
  public boolean h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  }
  
  public UiApiPlugin()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    this.jdField_b_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new adnb(this);
    this.jdField_c_of_type_Int = -1;
    this.mPluginNameSpace = "ui";
  }
  
  static int a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      n = paramJSONObject.getInt(paramString);
      return n;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        int n = Color.parseColor(paramJSONObject.getString(paramString));
        return n;
      }
      catch (Exception paramJSONObject) {}
    }
    return 0;
  }
  
  public static Intent a(Context paramContext, Map paramMap, String paramString1, String paramString2)
  {
    paramMap = new Intent("android.intent.action.MAIN");
    paramMap.setClassName(paramContext, ShortcutGuideActivity.class.getName());
    paramMap.addCategory("android.intent.category.LAUNCHER");
    paramMap.putExtra("from", paramString2);
    paramMap.putExtra("url", paramString1);
    return paramMap;
  }
  
  public static String a(PubAccountUIPlugin paramPubAccountUIPlugin)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramPubAccountUIPlugin != null) {}
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("type", "init");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isShowBottomBar", paramPubAccountUIPlugin.jdField_a_of_type_Boolean);
      localJSONObject.put("barHeight", paramPubAccountUIPlugin.jdField_a_of_type_Int);
      ((JSONObject)localObject1).put("data", localJSONObject);
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
    }
    catch (JSONException paramPubAccountUIPlugin)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.d("UiApiPlugin", 2, "getSetBottomBarCallBackResult json error!");
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramString1);
      if (paramString2 != null) {
        localJSONObject.put("resultData", paramString2);
      }
      if (paramString3 != null) {
        localJSONObject.put("message", paramString3);
      }
      if (paramString4 != null) {
        localJSONObject.put("extras", paramString4);
      }
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "getCallBackResult json error!");
      }
    }
    return "{\"result\":\"-1\",\"message\":\"getCallBackResult json error!\"}";
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, long paramLong, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i1 = paramArrayOfString.length;
    if ((i1 == 0) || (i1 != paramArrayOfInt.length) || (paramLong == -1L))
    {
      paramActivity.setResult(-1, new Intent().putExtra("ret", 4));
      paramActivity.finish();
      return;
    }
    GetOpenidProto.GetOpenidReq localGetOpenidReq = new GetOpenidProto.GetOpenidReq();
    localGetOpenidReq.appid.set(paramLong);
    int n = 0;
    if (n < i1)
    {
      GetOpenidProto.GetOpenidEntry localGetOpenidEntry = new GetOpenidProto.GetOpenidEntry();
      for (;;)
      {
        int i2;
        try
        {
          localGetOpenidEntry.id.set(Long.parseLong(paramArrayOfString[n], 10));
          i2 = paramArrayOfInt[n];
          if (i2 == 0)
          {
            localGetOpenidEntry.type.set(0);
            localGetOpenidReq.list.add(localGetOpenidEntry);
            n += 1;
          }
        }
        catch (NumberFormatException paramAppInterface)
        {
          paramActivity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin error"));
          paramActivity.finish();
          return;
        }
        if (i2 == 1)
        {
          localGetOpenidEntry.type.set(1);
        }
        else
        {
          if (i2 != 3000) {
            break label215;
          }
          localGetOpenidEntry.type.set(2);
        }
      }
      label215:
      paramActivity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin type error"));
      paramActivity.finish();
      return;
    }
    paramArrayOfString = new NewIntent(BaseApplicationImpl.getContext(), ProtoServlet.class);
    paramArrayOfString.setWithouLogin(true);
    paramArrayOfString.putExtra("cmd", "CommCompSvr.get_openid");
    paramArrayOfString.putExtra("data", localGetOpenidReq.toByteArray());
    paramArrayOfString.setObserver(new adnc(paramActivity));
    paramAppInterface.startServlet(paramArrayOfString);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (QQUtils.a(paramActivity, new String[] { paramString1 }))
    {
      QQToast.a(paramActivity, 2131435248, 0).b(paramActivity.getResources().getDimensionPixelSize(2131558448));
      paramString1 = a("-4", null, "createShortcut exsit!", paramString3);
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -2, "", "", "", "");
      callJs(paramString5, new String[] { paramString1 });
      return;
    }
    if (a(paramActivity, a(paramActivity, null, paramString4, "qqbrowser_float_shortcut"), paramString1, paramString2))
    {
      paramString1 = a("0", null, null, paramString3);
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, 0, "", "", "", "");
    }
    for (int n = 2131430688;; n = 2131430689)
    {
      QQToast.a(paramActivity, n, 0).b(paramActivity.getResources().getDimensionPixelSize(2131558448));
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_dialog_click", 0, 1, 0, "", "", "", "");
      break;
      paramString1 = a("-3", null, "createShortcut failed, iconUrl is invalide: " + paramString2, paramString3);
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -1, "", "", "", "");
    }
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      try
      {
        paramString2 = BitmapFactory.decodeResource(paramContext.getResources(), 2130839189);
        if (paramString2 != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "createShortcut.failed, icon is null.");
        }
        return false;
      }
      catch (OutOfMemoryError paramString2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(paramString2));
        }
        paramString2 = null;
        continue;
      }
      try
      {
        paramString2 = HttpUtil.a(paramContext, paramString2, "GET", null, null);
        if (paramString2 == null) {
          return false;
        }
      }
      catch (IOException paramString2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(paramString2));
          }
          paramString2 = null;
        }
        try
        {
          paramString2 = BitmapFactory.decodeByteArray(paramString2, 0, paramString2.length);
        }
        catch (OutOfMemoryError paramString2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(paramString2));
          }
          paramString2 = null;
        }
      }
    }
    Intent localIntent = new Intent();
    KapalaiAdapterUtil.a().a(paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString1);
    int n;
    if (paramString2 != null)
    {
      n = DisplayUtils.a(paramContext);
      paramIntent = paramString2;
      if (n != paramString2.getWidth()) {
        if (MobileIssueSettings.jdField_c_of_type_Boolean) {
          break label259;
        }
      }
    }
    label259:
    for (paramIntent = KapalaiAdapterUtil.a().a(paramString2, n);; paramIntent = Bitmap.createScaledBitmap(paramString2, n, n, false))
    {
      localIntent.putExtra("android.intent.extra.shortcut.ICON", paramIntent);
      localIntent.putExtra("duplicate", false);
      localIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
      paramContext.sendOrderedBroadcast(localIntent, null);
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "createShortcut.finish.");
      }
      return true;
    }
  }
  
  public static void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "unRegisterReceiver");
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    if ((jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver);
      jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if ((jdField_c_of_type_AndroidContentBroadcastReceiver != null) && (jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(jdField_c_of_type_AndroidContentBroadcastReceiver);
      jdField_c_of_type_AndroidContentBroadcastReceiver = null;
    }
    if ((jdField_b_of_type_AndroidContentBroadcastReceiver != null) && (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(jdField_b_of_type_AndroidContentBroadcastReceiver);
      jdField_b_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void g()
  {
    jdField_c_of_type_AndroidContentBroadcastReceiver = new adns(this);
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "initX5LogUploadReceiver!");
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("upload_x5_log");
      BaseApplicationImpl.getApplication().registerReceiver(jdField_c_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("UiApiPlugin", 1, "register receiver error:" + localException.toString());
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      if ((this.jdField_a_of_type_Boolean) && (paramInt == 0)) {
        callJs(this.jdField_b_of_type_JavaLangString, new String[] { "2", Integer.toString(paramInt) });
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { "0", Integer.toString(paramInt) });
      continue;
      callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(paramInt));
    }
  }
  
  public int a(String paramString, boolean paramBoolean)
  {
    int n = -1;
    if ("1".equals(paramString)) {
      n = 2130841420;
    }
    do
    {
      return n;
      if ("2".equals(paramString)) {
        return 2130841419;
      }
      if ("3".equals(paramString)) {
        return 2130839147;
      }
      if ("4".equals(paramString)) {
        return 2130838566;
      }
      if ("5".equals(paramString)) {
        return 2130841454;
      }
      if ("7".equals(paramString))
      {
        if (paramBoolean) {
          return 2130840561;
        }
        return 2130840564;
      }
      if ("8".equals(paramString))
      {
        if (paramBoolean) {
          return 2130845768;
        }
        return 2130845772;
      }
      if ("9".equals(paramString)) {
        return 2130838285;
      }
      if ("10".equals(paramString)) {
        return 2130845835;
      }
    } while (!"11".equals(paramString));
    return 2130845834;
  }
  
  public Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public WebUiUtils.WebProgressInterface a()
  {
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebProgressInterface))) {
      return (WebUiUtils.WebProgressInterface)localWebUiBaseInterface;
    }
    return null;
  }
  
  public WebUiUtils.WebTitleBarInterface a()
  {
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebTitleBarInterface))) {
      return (WebUiUtils.WebTitleBarInterface)localWebUiBaseInterface;
    }
    return null;
  }
  
  void a()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentBizUiRefreshView != null) {
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(null);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      Drawable localDrawable = this.jdField_c_of_type_AndroidWidgetImageView.getDrawable();
      if (localDrawable != null)
      {
        localDrawable = ImageUtil.a(localDrawable, paramInt);
        if (localDrawable != null) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Object localObject = null;
    adne localadne = null;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Activity localActivity = this.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    RelativeLayout localRelativeLayout;
    label200:
    do
    {
      do
      {
        return;
        localRelativeLayout = (RelativeLayout)localActivity.findViewById(2131363226);
        switch (paramInt)
        {
        }
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
            break label200;
          }
          if (paramBoolean2) {
            break;
          }
          localRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
          this.jdField_a_of_type_AndroidWidgetImageView = null;
          this.jdField_b_of_type_AndroidWidgetImageView = null;
          return;
          Drawable localDrawable = localActivity.getResources().getDrawable(2130842157);
          localObject = localDrawable;
          if (!TextUtils.isEmpty(paramString))
          {
            localadne = new adne(this, paramString);
            localObject = localDrawable;
          }
        }
      } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
      if (paramBoolean1) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localadne);
        this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localActivity.getResources().getDrawable(2130845923));
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localadne);
      paramString = new RelativeLayout(localActivity);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
      paramString.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(DisplayUtil.a(localBaseApplication, 8.0F), DisplayUtil.a(localBaseApplication, 8.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, DisplayUtil.a(localBaseApplication, 4.0F), DisplayUtil.a(localBaseApplication, 4.0F), 0);
      paramString.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(DisplayUtil.a(localBaseApplication, 36.0F), DisplayUtil.a(localBaseApplication, 36.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131362677);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, DisplayUtil.a(localBaseApplication, 4.0F), 0);
    } while (localRelativeLayout == null);
    localRelativeLayout.addView(paramString, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      if ("my_emoji_clk".equals(paramString2)) {
        if (("11".equals(paramString1)) && (paramActivity != null))
        {
          paramString2 = paramActivity.getIntent();
          Intent localIntent = new Intent(paramActivity, EmosmActivity.class);
          localIntent.putExtra("key_emojimall_detail_chat_type", paramString2.getIntExtra("key_emojimall_detail_chat_type", -1));
          localIntent.putExtra("key_emojimall_detail_chat_uin", paramString2.getStringExtra("key_emojimall_detail_chat_uin"));
          localIntent.putExtra("emojimall_src", paramString2.getIntExtra("emojimall_src", 1));
          paramActivity.startActivity(localIntent);
        }
      }
    }
    for (;;)
    {
      if ("10".equals(paramString1)) {
        ReportController.b(null, "CliOper", "", "", "ep_mall", "Clk_ep_search", 0, 0, "", "", "", "");
      }
      return;
      QLog.e("UiApiPlugin", 1, "handleDoubleRightBtnClickEvent, my_emoji_clk, activity = null or iconid != my dressup");
      continue;
      callJs(paramString2, new String[] { "" });
      continue;
      QLog.e("UiApiPlugin", 1, "handleDoubleRightBtnClickEvent, callback null, iconId=" + paramString1);
    }
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    paramContext = this.mRuntime.a();
    if ((paramContext == null) || (paramContext.isFinishing())) {
      break label19;
    }
    label19:
    while (this.mRuntime.a() == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
        break label118;
      }
    }
    label118:
    for (paramContext = this.jdField_a_of_type_JavaLangRefWeakReference.toString();; paramContext = "null")
    {
      QLog.d("UiApiPlugin", 2, String.format("plugin %s onReceiveNewMsg", new Object[] { paramContext }));
      paramContext = this.mRuntime.a();
      if ((paramContext.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI == null) || (paramContext.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_c_of_type_AndroidWidgetImageView == null) || (!paramContext.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c())) {
        break;
      }
      paramContext.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
  }
  
  public void a(File paramFile)
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    Object localObject = paramFile.getAbsolutePath();
    paramFile = new Bundle();
    paramFile.putInt("forward_type", 1);
    paramFile.putString("forward_urldrawable_thumb_url", (String)localObject);
    paramFile.putString("forward_filepath", (String)localObject);
    paramFile.putString("forward_extra", (String)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtras(paramFile);
    ForwardBaseOption.a(localActivity, (Intent)localObject, 18);
  }
  
  public void a(String paramString)
  {
    int i2 = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
      {
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        }
        if (paramString.equals(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          return;
        }
      }
      localObject1 = this.mRuntime.a();
    } while (localObject1 == null);
    for (;;)
    {
      int i4;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject1 = ActionSheet.a((Context)localObject1);
        Object localObject2 = localJSONObject.optString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((ActionSheet)localObject1).a((CharSequence)localObject2);
        }
        localObject2 = localJSONObject.optJSONArray("items");
        int i3 = localJSONObject.optInt("selected", -1);
        this.jdField_a_of_type_Boolean = false;
        String str = localJSONObject.optString("close");
        if (TextUtils.isEmpty(str)) {
          break label392;
        }
        this.jdField_a_of_type_Boolean = true;
        ((ActionSheet)localObject1).a(str, 3);
        n = 1;
        i1 = n;
        if (localObject2 != null)
        {
          i1 = n;
          if (((JSONArray)localObject2).length() > 0)
          {
            i4 = ((JSONArray)localObject2).length();
            i1 = i2;
            if (i3 >= 0)
            {
              i1 = i2;
              if (i3 < i4)
              {
                i1 = 0;
                if (i1 >= i4) {
                  break label403;
                }
                str = ((JSONArray)localObject2).getString(i1);
                if (i1 != i3) {
                  break label397;
                }
                bool = true;
                ((ActionSheet)localObject1).a(str, bool);
                i1 += 1;
                continue;
              }
            }
            if (i1 >= i4) {
              break label403;
            }
            ((ActionSheet)localObject1).c(((JSONArray)localObject2).getString(i1));
            i1 += 1;
            continue;
          }
        }
        localObject2 = localJSONObject.optString("cancel");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((ActionSheet)localObject1).d((CharSequence)localObject2);
        }
        ((ActionSheet)localObject1).a(this);
        ((ActionSheet)localObject1).a(this);
        ((ActionSheet)localObject1).setOnCancelListener(this);
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)localObject1);
        this.jdField_b_of_type_JavaLangString = localJSONObject.optString("onclick");
        this.jdField_a_of_type_Int = i1;
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("UiApiPlugin", 2, "showActionSheet error:" + paramString.getMessage());
      return;
      label392:
      int n = 0;
      continue;
      label397:
      boolean bool = false;
      continue;
      label403:
      int i1 = n + i4;
    }
  }
  
  protected final void a(String paramString1, String paramString2)
  {
    EntityManager localEntityManager = this.mRuntime.a().getEntityManagerFactory(this.mRuntime.a().getAccount()).createEntityManager();
    TroopInfo localTroopInfo = (TroopInfo)localEntityManager.a(TroopInfo.class, paramString1);
    localEntityManager.a();
    int n;
    if (localTroopInfo != null)
    {
      if (!localTroopInfo.isTroopOwner(this.mRuntime.a().getAccount())) {
        break label116;
      }
      n = 0;
    }
    for (;;)
    {
      ReportController.b(null, "P_CliOper", "Grp_flower", "", "mber", paramString2, 0, 0, paramString1, n + "", "", "");
      return;
      label116:
      if (localTroopInfo.isAdmin()) {
        n = 1;
      } else {
        n = 2;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    int n = 0;
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    for (;;)
    {
      return;
      if (this.mRuntime.a() != null) {
        try
        {
          JSONObject localJSONObject2 = new JSONObject(paramString);
          String str2 = localJSONObject2.optString("url");
          JSONObject localJSONObject1;
          if (paramBoolean)
          {
            localJSONObject1 = localJSONObject2;
            if ((TextUtils.isEmpty(str2)) || (localJSONObject1 == null) || (!localJSONObject1.has("style"))) {
              continue;
            }
            paramString = (String)localObject;
            if (!localActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
            {
              paramString = (String)localObject;
              if (!localActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity"))
              {
                paramString = (String)localObject;
                if (!localJSONObject1.optBoolean("useNewConfig", false)) {
                  paramString = localActivity.getIntent().getExtras();
                }
              }
            }
            if (paramString != null) {
              break label441;
            }
            localObject = new Bundle();
            label158:
            if (((Bundle)localObject).containsKey("startOpenPageTime")) {
              ((Bundle)localObject).putLong("startOpenPageTime", System.currentTimeMillis());
            }
            n = localJSONObject1.optInt("style");
            if (!Boolean.valueOf(localJSONObject2.optBoolean("is_native", true)).booleanValue()) {
              break label1432;
            }
            PluginJumpManager.getInstance().updateConfig(this.mRuntime.a());
            PluginJumpManager.getInstance().loadConfig();
            if (!(localActivity instanceof BaseActivity)) {
              break label533;
            }
            if (PluginJumpManager.getInstance().openView(localActivity, str2, String.valueOf(n))) {
              continue;
            }
            break label1432;
            label254:
            switch (localJSONObject1.optInt("navigationBarStyle"))
            {
            }
          }
          for (;;)
          {
            label280:
            ((Bundle)localObject).putBoolean("hide_title_left_arrow", localJSONObject1.optBoolean("hideLeftArrow", false));
            n = localJSONObject1.optInt("target");
            if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
            {
              paramString = new Intent(((BasePluginActivity)localActivity).getOutActivity(), QQBrowserActivity.class);
              paramString.putExtras((Bundle)localObject);
              paramString.putExtra("url", str2);
              paramString.setFlags(0);
              if (n == 1) {
                paramString.putExtra("articalChannelId", 0);
              }
              localActivity.startActivityForResult(paramString, 100);
            }
            for (;;)
            {
              for (;;)
              {
                switch (localJSONObject1.optInt("animation"))
                {
                case 0: 
                case 1: 
                  localActivity.overridePendingTransition(0, 0);
                  return;
                  localJSONObject1 = localJSONObject2.optJSONObject("options");
                  break;
                  paramString.remove("title");
                  paramString.remove("leftViewText");
                  paramString.remove("post_data");
                  paramString.remove("options");
                  paramString.remove("isOpeningQunApp");
                  paramString.remove("isTransparentTitleAndClickable");
                case 2: 
                  try
                  {
                    label441:
                    String[] arrayOfString = (String[])paramString.get("insertPluginsArray");
                    for (;;)
                    {
                      localObject = paramString;
                      if (n >= arrayOfString.length) {
                        break;
                      }
                      if ("gdtReportPlugin".equals(arrayOfString[n])) {
                        arrayOfString[n] = null;
                      }
                      n += 1;
                    }
                    label533:
                    if (!PluginJumpManager.getInstance().openView(localActivity, str2, String.valueOf(n))) {
                      break label1432;
                    }
                    return;
                  }
                  catch (Exception localException)
                  {
                    label1403:
                    String str1 = paramString;
                  }
                }
              }
              ((Bundle)localObject).putBoolean("hide_more_button", false);
              ((Bundle)localObject).putBoolean("hide_operation_bar", true);
              break label254;
              ((Bundle)localObject).putBoolean("hide_more_button", true);
              ((Bundle)localObject).putBoolean("hide_operation_bar", true);
              break label254;
              ((Bundle)localObject).putBoolean("hide_more_button", false);
              ((Bundle)localObject).putBoolean("hide_operation_bar", false);
              ((Bundle)localObject).putString("webStyle", "");
              break label254;
              ((Bundle)localObject).putBoolean("hide_more_button", true);
              ((Bundle)localObject).putBoolean("hide_operation_bar", false);
              ((Bundle)localObject).putString("webStyle", "");
              break label254;
              ((Bundle)localObject).putBoolean("hide_left_button", true);
              ((Bundle)localObject).putBoolean("show_right_close_button", true);
              break label254;
              ((Bundle)localObject).putBoolean("isTransparentTitleAndClickable", true);
              break label280;
              if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity"))
              {
                paramString = new Intent(localActivity, QQBrowserActivity.class);
                paramString.putExtras((Bundle)localObject);
                paramString.putExtra("url", str2);
                paramString.setFlags(0);
                localActivity.startActivityForResult(paramString, 100);
              }
              else if ((localActivity.getClass().getName().equalsIgnoreCase("com.qqcomic.activity.fragment.VipComicWebFragmentActivity")) || (localActivity.getClass().getName().equalsIgnoreCase("com.qqcomic.activity.media.VipComicMediaPlayActivity")))
              {
                paramString = new Intent();
                ((Bundle)localObject).remove("activityNoTitle");
                paramString.putExtras((Bundle)localObject);
                paramString.putExtra("url", str2);
                paramString.setFlags(0);
                if (VipComicHelper.a(str2, paramString))
                {
                  paramString.setClassName("com.qqcomic", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
                  localActivity.startActivityForResult(paramString, 100);
                }
                else
                {
                  VipComicHelper.a(localActivity, paramString, 100);
                }
              }
              else if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.QQH5BrowserActivity"))
              {
                paramString = new Intent(localActivity, QQBrowserActivity.class);
                paramString.putExtras((Bundle)localObject);
                paramString.putExtra("url", str2);
                paramString.setFlags(0);
                localActivity.startActivityForResult(paramString, 100);
              }
              else if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity"))
              {
                paramString = new Intent(localActivity, QQBrowserActivity.class);
                ((Bundle)localObject).remove("isFullScreen");
                ((Bundle)localObject).remove("isTransparentTitle");
                paramString.putExtras((Bundle)localObject);
                paramString.putExtra("url", str2);
                paramString.setFlags(0);
                localActivity.startActivityForResult(paramString, 100);
              }
              else
              {
                if (localJSONObject1.optBoolean("useApolloBrowser", false))
                {
                  ApolloUtil.a(localActivity, null, "other", str2, this.mRuntime.a());
                  return;
                }
                if (((localActivity instanceof ApolloFloatActivity)) || ((localActivity instanceof ApolloGameActivity)) || (localJSONObject1.optBoolean("useQQBrowser", false))) {
                  paramString = new Intent(localActivity, QQBrowserActivity.class);
                }
                for (;;)
                {
                  if (TeamWorkUtils.a(str2))
                  {
                    paramString = new Intent(localActivity, TeamWorkDocEditBrowserActivity.class);
                    paramString.addFlags(603979776);
                    paramString = TeamWorkDocEditBrowserActivity.a(paramString, str2, localActivity);
                  }
                  if (localJSONObject1.optBoolean("isOpeningQunApp"))
                  {
                    ((Bundle)localObject).putBoolean("isOpeningQunApp", localJSONObject1.optBoolean("isOpeningQunApp"));
                    ((Bundle)localObject).putInt("appid", localJSONObject1.optInt("appid"));
                    localJSONObject2 = localJSONObject1.optJSONObject("extraParams");
                    if (localJSONObject2 != null)
                    {
                      ((Bundle)localObject).putString("extraParams", localJSONObject2.toString());
                      ((Bundle)localObject).putInt("troopid", localJSONObject2.optInt("gc"));
                    }
                  }
                  paramString.putExtra("startOpenPageTime", System.currentTimeMillis());
                  paramString.putExtras((Bundle)localObject);
                  paramString.putExtra("url", str2);
                  paramString.setFlags(0);
                  if (n == 1) {
                    paramString.putExtra("articalChannelId", 0);
                  }
                  if (!VipComicHelper.a(str2, paramString)) {
                    break label1403;
                  }
                  paramString.setClassName("com.qqcomic", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
                  QQComicPluginBridge.a(localActivity, paramString, "com.qqcomic.activity.media.VipComicMediaPlayActivity", null);
                  break;
                  if ((localActivity instanceof QzoneJumpQBrowserInterface))
                  {
                    paramString = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
                  }
                  else if ((localActivity instanceof EcshopWebActivity))
                  {
                    paramString = new Intent(localActivity, BusinessBrowser.class);
                    paramString.putExtra("jump_from", 2);
                  }
                  else if ((localActivity instanceof ReadInJoyArticleDetailActivity))
                  {
                    paramString = new Intent(localActivity, ReadInJoyArticleDetailActivity.class);
                    ((Bundle)localObject).remove("click_time");
                    ((Bundle)localObject).remove("available_memory");
                  }
                  else
                  {
                    paramString = new Intent(localActivity, localActivity.getClass());
                  }
                }
                localActivity.startActivityForResult(paramString, 100);
              }
            }
            localActivity.overridePendingTransition(2131034380, 0);
            return;
            break label158;
            label1432:
            switch (n)
            {
            }
            break label254;
          }
          return;
        }
        catch (JSONException paramString) {}
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      a(paramJSONObject, null, new adnf(this, paramJSONObject));
    }
  }
  
  public void a(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener)
  {
    if (paramJSONObject != null) {
      a(paramJSONObject, paramJsBridgeListener, null);
    }
  }
  
  public void a(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    int n;
    String str1;
    String str2;
    String str3;
    boolean bool2;
    int i1;
    label148:
    do
    {
      do
      {
        return;
        n = paramJSONObject.optInt("iconID");
        str1 = paramJSONObject.optString("title");
        str2 = paramJSONObject.optString("callback");
        str3 = paramJSONObject.optString("color");
        bool2 = paramJSONObject.optBoolean("hidden");
        i1 = paramJSONObject.optInt("cornerID");
        if ((localActivity instanceof AbsBaseWebViewActivity))
        {
          int i2 = paramJSONObject.optInt("navIconUseDefault", -1);
          if (i2 >= 0)
          {
            paramJSONObject = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
            if (paramJSONObject != null)
            {
              paramJSONObject = paramJSONObject.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
              if (1 != i2) {
                break label148;
              }
            }
          }
          for (boolean bool1 = true;; bool1 = false)
          {
            paramJSONObject.w = bool1;
            ((AbsBaseWebViewActivity)localActivity).a(str2, str1, str3, bool2, n, i1, paramJsBridgeListener, paramOnClickListener);
            return;
          }
        }
        paramJSONObject = this.mRuntime.a(this.mRuntime.a());
        if ((paramJSONObject == null) || (!(paramJSONObject instanceof WebUiUtils.WebTitleBarInterface))) {
          break;
        }
      } while ((localActivity instanceof TeamWorkDocEditBrowserActivity));
      ((WebUiUtils.WebTitleBarInterface)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener);
      return;
      if ((paramJSONObject != null) && ((paramJSONObject instanceof WebUiUtils.QReaderUiInterface)))
      {
        ((WebUiUtils.QReaderUiInterface)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener);
        return;
      }
      if ((paramJSONObject != null) && ((paramJSONObject instanceof WebUiUtils.ReadInJoyUiInterface)))
      {
        ((WebUiUtils.ReadInJoyUiInterface)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener);
        return;
      }
    } while ((paramJSONObject == null) || (!(paramJSONObject instanceof WebUiUtils.VipComicUiInterface)));
    ((WebUiUtils.VipComicUiInterface)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener, this.mRuntime.a().hashCode());
  }
  
  public void a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    String str1 = paramJSONObject.optString("callback");
    if (paramString == null)
    {
      paramJSONObject = new JSONObject();
      try
      {
        paramJSONObject.put("code", paramInt);
        callJs(str1, new String[] { paramJSONObject.toString() });
        return;
      }
      catch (JSONException paramJSONObject)
      {
        callJs(str1, new String[] { "{\"code\":" + paramInt + "}" });
        return;
      }
    }
    String str2 = paramJSONObject.optString("text");
    Object localObject = paramJSONObject.optString("textColor");
    paramInt = paramJSONObject.optInt("x");
    int n = paramJSONObject.optInt("y");
    Rect localRect = new Rect(paramInt, n, paramJSONObject.optInt("width") + paramInt, paramJSONObject.optInt("height") + n);
    paramJSONObject = (JSONObject)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject = "#FF000000";
    }
    localObject = new ArrayList(1);
    ((ArrayList)localObject).add(str2);
    SearchUtils.a(this.mRuntime.a(), paramString, str2, (List)localObject, paramJSONObject, localRect, new adnq(this, str1));
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localObject == null) || (localActivity == null) || (localActivity.isFinishing())) {
      callJs4OpenApiIfNeeded("setPullDown", -100, "recode_failed_native_error");
    }
    do
    {
      return;
      localObject = (View)((WebView)localObject).getParent();
    } while (!(localObject instanceof RefreshView));
    this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)localObject);
    this.jdField_h_of_type_Boolean = false;
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView = localActivity.findViewById(2131366723);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader = this.jdField_a_of_type_ComTencentBizUiRefreshView.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader;
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.setHeaderBgColor(-16777216);
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setBackgroundColor(-16777216);
      }
      this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(new adnd(this));
      callJs4OpenApiIfNeeded("setPullDown", 0, "[]");
      return;
    }
    callJs4OpenApiIfNeeded("setPullDown", 0, "already initPullDown");
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    View localView;
    do
    {
      return;
      localView = ((Activity)localObject).findViewById(2131363226);
    } while (localView == null);
    if (ImmersiveUtils.isSupporImmersive() == 1) {}
    for (int n = ImmersiveUtils.a((Context)localObject) + 0;; n = 0)
    {
      localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      n += localView.getMeasuredHeight();
      if ((!this.jdField_d_of_type_Boolean) && (paramBoolean))
      {
        localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -n);
        ((TranslateAnimation)localObject).setDuration(paramInt);
        ((TranslateAnimation)localObject).setInterpolator(new LinearInterpolator());
        ((TranslateAnimation)localObject).setFillAfter(true);
        ((TranslateAnimation)localObject).setAnimationListener(new adnj(this, localView, localView.getTop() - n, localView.getBottom() - n));
        localView.startAnimation((Animation)localObject);
        this.jdField_d_of_type_Boolean = true;
        return;
      }
      if ((!this.jdField_d_of_type_Boolean) || (paramBoolean)) {
        break;
      }
      localObject = new TranslateAnimation(0.0F, 0.0F, -n, 0.0F);
      ((TranslateAnimation)localObject).setDuration(paramInt);
      ((TranslateAnimation)localObject).setInterpolator(new LinearInterpolator());
      ((TranslateAnimation)localObject).setFillAfter(true);
      ((TranslateAnimation)localObject).setAnimationListener(new adnk(this, localView, localView.getTop() + n, n + localView.getBottom()));
      localView.setVisibility(0);
      localView.startAnimation((Animation)localObject);
      this.jdField_d_of_type_Boolean = false;
      return;
    }
  }
  
  protected void a(byte[] paramArrayOfByte, String paramString)
  {
    paramString = AppConstants.aJ + "diskcache/Image_" + paramString;
    FileUtils.a(paramArrayOfByte, paramString);
    a(new File(paramString));
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      do
      {
        return false;
        if (paramString2.equals("g_appstore_myapp"))
        {
          QLog.d("UiApiPlugin", 1, "open troopApp manager error,TroopProxyActivity已在725下架");
          return true;
        }
      } while ((TextUtils.isEmpty(paramString1)) || (!paramString1.matches("\\d+")));
      if (paramString2.equals("g_flower"))
      {
        startActivityForResult(TroopGiftUtil.a(this.mRuntime.a(), paramString1, "web"), (byte)10);
        a(paramString1, "exp");
        return true;
      }
      if (paramString2.equals("g_proceeding")) {
        return true;
      }
      if (paramString2.equals("g_homework"))
      {
        if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
        {
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString1, paramString2);
        return true;
      }
      if (paramString2.equals("g_org"))
      {
        paramString1 = "mqqapi://group/openOrg?troopUin=" + paramString1;
        paramString2 = new Intent();
        paramString2.setData(Uri.parse(paramString1));
        paramString2.setAction("android.intent.action.VIEW");
        this.mRuntime.a().startActivity(paramString2);
        return true;
      }
      if (paramString2.equals("g_topic"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "g_topic ---------------");
        }
        return true;
      }
      if (paramString2.equals("g_approval"))
      {
        paramString2 = new Intent();
        paramString2.putExtra("ApprovalOpenParams.opentype", 1);
        paramString2.putExtra("ApprovalOpenParams.fromuin", paramString1);
        DingdongPluginHelper.a(this.mRuntime.a(), "com.dingdong.business.approval.activity.ApprovalSessionsActivity", paramString2, -1);
        return true;
      }
      if (paramString2.equals("g_troop_reward"))
      {
        if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
        {
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString1, paramString2);
        return true;
      }
      if (paramString2.equals("g_background"))
      {
        if (SharedPreUtils.s(this.mRuntime.a(), this.mRuntime.a().getCurrentAccountUin())) {
          TroopPicEffectsEditActivity.a(this.mRuntime.a(), paramString1, paramString1);
        }
        for (;;)
        {
          return true;
          SharedPreUtils.F(this.mRuntime.a(), this.mRuntime.a().getCurrentAccountUin());
          paramString2 = new Intent(this.mRuntime.a(), TroopPicEffectGuidePicActivity.class);
          paramString2.putExtra("friendUin", paramString1);
          paramString2.putExtra("troopUin", paramString1);
          paramString2.putExtra("isFromTroopApp", true);
          this.mRuntime.a().startActivity(paramString2);
        }
      }
    } while ((TextUtils.isEmpty(paramString3)) || (!paramString3.startsWith("mqqapi://groupopenapp/openapp")));
    if ("group_story".equals(paramString2))
    {
      paramString1 = TroopStoryUtil.a(null, paramString3, null);
      StoryReportor.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      paramString2 = new Intent(this.mRuntime.a(), JumpActivity.class);
      paramString2.setData(Uri.parse(paramString1));
      this.mRuntime.a().startActivity(paramString2);
      return true;
      paramString1 = paramString3;
      if ("group_album".equals(paramString2)) {
        paramString1 = paramString3.replace("$UNREADNUM$", "1");
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
  }
  
  public void b(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    int n;
    label170:
    label177:
    label247:
    do
    {
      do
      {
        boolean bool;
        int i2;
        do
        {
          int i1;
          do
          {
            do
            {
              return;
              n = paramIntent.getIntExtra("mode", 0);
              bool = paramIntent.getBooleanExtra("exclude", false);
              i1 = paramIntent.getIntExtra("number", 0);
              i2 = paramIntent.getIntExtra("sender", 0);
              if (QLog.isColorLevel()) {
                if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
                  break label170;
                }
              }
              for (paramContext = this.jdField_a_of_type_JavaLangRefWeakReference.toString();; paramContext = "null")
              {
                QLog.d("UiApiPlugin", 2, String.format("plugin %s (mSequence: %d): onReceive , mode: %d, exclude: %b, number: %d, sender: %d", new Object[] { paramContext, Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(n), Boolean.valueOf(bool), Integer.valueOf(i1), Integer.valueOf(i2) }));
                paramContext = this.mRuntime.a();
                if ((paramContext == null) || (paramContext.isFinishing())) {
                  break;
                }
                if (i1 <= 0) {
                  break label247;
                }
                if (i2 != this.jdField_b_of_type_Int) {
                  break label177;
                }
                if (bool) {
                  break;
                }
                paramContext.finish();
                return;
              }
              if ((this.jdField_b_of_type_Int < i2 - i1) || (this.jdField_b_of_type_Int >= i2)) {
                break;
              }
            } while ((n != 0) && (n != 2));
            paramContext.finish();
            return;
          } while ((this.jdField_b_of_type_Int <= i2) || (this.jdField_b_of_type_Int > i1 + i2) || ((n != 0) && (n != 1)));
          paramContext.finish();
          return;
          if (i2 != this.jdField_b_of_type_Int) {
            break;
          }
        } while (bool);
        paramContext.finish();
        return;
        if (i2 <= this.jdField_b_of_type_Int) {
          break;
        }
      } while ((n != 0) && (n != 2));
      paramContext.finish();
      return;
    } while ((n != 0) && (n != 1));
    paramContext.finish();
  }
  
  public void b(String paramString)
  {
    Object localObject = this.mRuntime.a(this.mRuntime.a());
    if ((localObject != null) && ((localObject instanceof WebUiUtils.WebShareInterface)))
    {
      localObject = ((WebUiUtils.WebShareInterface)localObject).a();
      Bundle localBundle = new Bundle();
      localBundle.putString("title", ((Share)localObject).b());
      localBundle.putString("desc", ((Share)localObject).c());
      localBundle.putString("detail_url", ((Share)localObject).a());
      localBundle.putString("cover_url", ((Share)localObject).e());
      localBundle.putInt("article_id", ((Share)localObject).a());
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(((Share)localObject).d());
      localBundle.putStringArrayList("image_url", localArrayList);
      localBundle.putString("source_name", ((Share)localObject).f());
      if (a() != null)
      {
        if (!ReadInJoyShareManager.a(this.mRuntime.a(), a(), localBundle, null, 0)) {
          break label189;
        }
        if (!TextUtils.isEmpty(paramString)) {
          callJs(paramString, new String[] { "true" });
        }
      }
    }
    return;
    label189:
    if (!TextUtils.isEmpty(paramString)) {
      callJs(paramString, new String[] { "false" });
    }
    QRUtils.a(1, 2131435463);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "showPopupMenu: context is null");
      }
    }
    Object localObject1;
    float f1;
    JSONArray localJSONArray;
    for (;;)
    {
      return;
      localObject1 = this.mRuntime.a(this.mRuntime.a());
      if ((localObject1 != null) && ((localObject1 instanceof WebUiUtils.WebTitleBarInterface))) {
        localObject1 = ((WebUiUtils.WebTitleBarInterface)localObject1).a();
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("UiApiPlugin", 2, "showPopupMenu: Can not get TitleBar");
          return;
          if ((localObject1 != null) && ((localObject1 instanceof WebUiUtils.QReaderUiInterface)))
          {
            localObject1 = ((WebUiUtils.QReaderUiInterface)localObject1).a();
          }
          else if ((localObject1 != null) && ((localObject1 instanceof WebUiUtils.VipComicUiInterface)))
          {
            localObject1 = ((WebUiUtils.VipComicUiInterface)localObject1).a(this.mRuntime.a().hashCode());
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("UiApiPlugin", 2, "showPopupMenu: activity has not implement WebUiMethodInterface");
            return;
          }
        }
      }
      f1 = localActivity.getResources().getDisplayMetrics().density;
      if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null)
      {
        if (!this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing()) {
          this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131558947) - localActivity.getResources().getDimensionPixelSize(2131558951), localActivity.getResources().getDimensionPixelSize(2131558952));
        }
      }
      else
      {
        Drawable localDrawable = localActivity.getResources().getDrawable(2130838676);
        try
        {
          localJSONArray = paramJSONObject.optJSONArray("list");
          if (localJSONArray == null)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("UiApiPlugin", 2, "showPopupMenu: list is null");
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("UiApiPlugin", 2, "showPopupMenu Exception: " + localException.getMessage());
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(localActivity, localArrayList, new adng(this, paramJSONObject, localActivity));
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131558947) - localActivity.getResources().getDimensionPixelSize(2131558951), localActivity.getResources().getDimensionPixelSize(2131558952));
      return;
      int n = 0;
      while (n < localJSONArray.length())
      {
        Object localObject2 = localJSONArray.optJSONObject(n);
        PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
        localMenuItem.jdField_a_of_type_Int = Integer.parseInt(((JSONObject)localObject2).optString("id"));
        localMenuItem.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("itemContent");
        localMenuItem.jdField_c_of_type_JavaLangString = localMenuItem.jdField_a_of_type_JavaLangString;
        localMenuItem.jdField_b_of_type_Int = 2130846240;
        localObject2 = ((JSONObject)localObject2).optString("itemUrl");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = ((int)(71.0F * f1));
          localURLDrawableOptions.mRequestHeight = ((int)(94.0F * f1));
          localURLDrawableOptions.mLoadingDrawable = localException;
          localURLDrawableOptions.mFailedDrawable = localException;
          localMenuItem.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        }
        localArrayList.add(localMenuItem);
        n += 1;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean == this.jdField_g_of_type_Boolean) {}
    do
    {
      return;
      if (!paramBoolean) {
        break label241;
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        break;
      }
      localObject3 = BaseApplicationImpl.getContext();
      localObject2 = this.mRuntime.a();
    } while ((localObject2 == null) || (((Activity)localObject2).isFinishing()));
    Object localObject1 = new TextView((Context)localObject2);
    ((TextView)localObject1).setText(2131434920);
    ((TextView)localObject1).setBackgroundResource(2130846141);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setMaxWidth(DisplayUtil.a((Context)localObject3, 100.0F));
    ((TextView)localObject1).setMinWidth(DisplayUtil.a((Context)localObject3, 52.0F));
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setTextColor(((Context)localObject3).getResources().getColor(2131494203));
    ((TextView)localObject1).setTextSize(1, 17.0F);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, DisplayUtil.a((Context)localObject3, 36.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131362677);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((TextView)localObject1).setOnClickListener(this);
    Object localObject2 = (RelativeLayout)((Activity)localObject2).findViewById(2131363226);
    if (localObject2 != null) {
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
    }
    this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
    label197:
    for (this.jdField_g_of_type_Boolean = true;; this.jdField_g_of_type_Boolean = false)
    {
      localObject1 = this.mRuntime.a();
      if ((localObject1 == null) || (((WebViewFragment)localObject1).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI == null)) {
        break;
      }
      ((WebViewFragment)localObject1).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.d(paramBoolean);
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      break label197;
      label241:
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  void c()
  {
    jdField_a_of_type_AndroidContentBroadcastReceiver = new adnr(this);
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "initExitWebViewReceiver!");
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE");
      BaseApplicationImpl.getApplication().registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("UiApiPlugin", 1, "register receiver error:" + localException.toString());
      }
    }
  }
  
  protected void c(String paramString)
  {
    Object localObject1 = this.mRuntime.a();
    if ((localObject1 == null) || (((Activity)localObject1).isFinishing())) {
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(this.mRuntime.a().getApplication(), 1, "分享失败，请稍后重试！", 0).a();
      return;
    }
    if (this.jdField_b_of_type_AndroidAppProgressDialog == null)
    {
      this.jdField_b_of_type_AndroidAppProgressDialog = new ProgressDialog((Context)localObject1, 2131624515);
      this.jdField_b_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_b_of_type_AndroidAppProgressDialog.show();
      this.jdField_b_of_type_AndroidAppProgressDialog.setContentView(2130969181);
      ((TextView)this.jdField_b_of_type_AndroidAppProgressDialog.findViewById(2131363381)).setText("正在发送");
    }
    for (;;)
    {
      localObject2 = new File(AbsDownloader.d(paramString));
      if (!((File)localObject2).exists()) {
        break;
      }
      this.jdField_b_of_type_AndroidAppProgressDialog.dismiss();
      a((File)localObject2);
      return;
      this.jdField_b_of_type_AndroidAppProgressDialog.show();
    }
    localObject1 = new Bundle();
    Object localObject2 = new DownloadTask(paramString, (File)localObject2);
    ((DownloadTask)localObject2).d = 60L;
    ((DownloaderFactory)this.mRuntime.a().getManager(46)).a(1).a((DownloadTask)localObject2, new adnl(this, paramString), (Bundle)localObject1);
  }
  
  public void c(JSONObject paramJSONObject)
  {
    Object localObject = this.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    while (paramJSONObject == null) {
      return;
    }
    String str = paramJSONObject.optString("title");
    WebUiBaseInterface localWebUiBaseInterface;
    if (!TextUtils.isEmpty(str))
    {
      localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
      if ((localWebUiBaseInterface == null) || (!(localWebUiBaseInterface instanceof WebUiUtils.VipComicUiInterface))) {
        break label101;
      }
      ((WebUiUtils.VipComicUiInterface)localWebUiBaseInterface).a(str, this.mRuntime.a().hashCode());
    }
    for (;;)
    {
      this.jdField_e_of_type_JavaLangString = paramJSONObject.optString("callback");
      return;
      label101:
      if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.QReaderUiInterface)))
      {
        ((WebUiUtils.QReaderUiInterface)localWebUiBaseInterface).b(str);
      }
      else if ((localWebUiBaseInterface instanceof WebViewFragment))
      {
        localObject = (WebViewFragment)localWebUiBaseInterface;
        if ((((WebViewFragment)localObject).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI != null) && (((WebViewFragment)localObject).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView != null)) {
          ((WebViewFragment)localObject).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        }
      }
      else
      {
        localObject = (TextView)((Activity)localObject).findViewById(2131363227);
        if (localObject != null) {
          ((TextView)localObject).setText(str);
        }
      }
    }
  }
  
  public void d()
  {
    if (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {}
    for (;;)
    {
      try
      {
        jdField_b_of_type_AndroidContentBroadcastReceiver = new adnt(this);
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "init sNewMsgReceiver!");
        }
      }
      catch (Exception localException2)
      {
        IntentFilter localIntentFilter;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("UiApiPlugin", 2, "error:" + localException2.toString());
      }
      try
      {
        localIntentFilter = new IntentFilter("com.tencent.msg.newmessage");
        BaseApplicationImpl.getApplication().registerReceiver(jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        return;
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("UiApiPlugin", 2, "register receiver error:" + localException1.toString());
          return;
        }
      }
    }
  }
  
  protected void d(String paramString)
  {
    String str;
    try
    {
      paramString = new JSONObject(paramString);
      str = paramString.optString("imageData");
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = AppConstants.aJ + "diskcache/Image_" + MD5Utils.d(str);
        FileUtils.a(Base64Util.decode(str, 0), (String)localObject1);
        a(paramString, (String)localObject1, 0);
        return;
      }
      str = paramString.optString("imageUrl");
      localObject1 = this.mRuntime.a();
      if ((localObject1 == null) || (((Activity)localObject1).isFinishing())) {
        return;
      }
      if (!AppNetConnInfo.isNetSupport())
      {
        a(paramString, null, -2);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("UiApiPlugin", 1, "mergeTextToImage exception e = ", paramString);
      return;
    }
    Object localObject2 = new File(AbsDownloader.d(str));
    if (((File)localObject2).exists())
    {
      a(paramString, AbsDownloader.d(str), 0);
      return;
    }
    Object localObject1 = new Bundle();
    localObject2 = new DownloadTask(str, (File)localObject2);
    ((DownloadTask)localObject2).d = 60L;
    ((DownloaderFactory)this.mRuntime.a().getManager(46)).a(1).a((DownloadTask)localObject2, new adnp(this, str, paramString), (Bundle)localObject1);
  }
  
  public void d(JSONObject paramJSONObject)
  {
    Activity localActivity;
    WebViewFragment localWebViewFragment;
    String str1;
    String str2;
    String str3;
    Object localObject1;
    Object localObject2;
    boolean bool;
    if (paramJSONObject != null)
    {
      localActivity = this.mRuntime.a();
      localWebViewFragment = this.mRuntime.a();
      if (localWebViewFragment == null) {
        break label439;
      }
      str1 = paramJSONObject.optString("iconID1");
      paramJSONObject.optString("schemeType1");
      str2 = paramJSONObject.optString("_sharedCallbackID1");
      str3 = paramJSONObject.optString("voiceStr1");
      localObject1 = paramJSONObject.optString("iconID2");
      paramJSONObject.optString("schemeType2");
      localObject2 = paramJSONObject.optString("_sharedCallbackID2");
      String str4 = paramJSONObject.optString("voiceStr2");
      localWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramJSONObject = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
      if ((paramJSONObject == null) || (!paramJSONObject.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.w) || ("1000".equals(ThemeUtil.getCurrentThemeId()))) {
        break label334;
      }
      bool = true;
      this.jdField_e_of_type_Int = a((String)localObject1, bool);
      if (paramJSONObject == null) {
        break label339;
      }
      paramJSONObject.a(localWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView, false, this.jdField_e_of_type_Int, this.jdField_e_of_type_Int);
      label181:
      localWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str4);
      localWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new adnh(this, localActivity, (String)localObject1, (String)localObject2));
      localObject1 = (RelativeLayout)localActivity.findViewById(2131363226);
      if (this.jdField_c_of_type_AndroidWidgetImageView == null) {
        break label357;
      }
      ((RelativeLayout)localObject1).removeView(this.jdField_c_of_type_AndroidWidgetImageView);
      label246:
      this.jdField_d_of_type_Int = a(str1, bool);
      if (paramJSONObject == null) {
        break label425;
      }
      paramJSONObject.a(this.jdField_c_of_type_AndroidWidgetImageView, false, this.jdField_d_of_type_Int, this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(str3);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new adni(this, localActivity, str1, str2));
      localWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.d(false);
      ((RelativeLayout)localObject1).addView(this.jdField_c_of_type_AndroidWidgetImageView);
      return;
      label334:
      bool = false;
      break;
      label339:
      localWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.jdField_e_of_type_Int);
      break label181;
      label357:
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131362677);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = DisplayUtil.a(localActivity.getApplicationContext(), 10.0F);
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label246;
      label425:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(this.jdField_d_of_type_Int);
    }
    label439:
    QLog.e("UiApiPlugin", 1, "setDoubleRightButton, not support " + localActivity);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.e();
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934593L) {
      this.jdField_e_of_type_JavaLangString = null;
    }
    label299:
    int i1;
    label613:
    do
    {
      int n;
      do
      {
        do
        {
          for (;;)
          {
            return false;
            if ((paramLong == 8589934597L) || (paramLong == 512L))
            {
              callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=true;d.dispatchEvent(e)}catch(err){}}(document);");
            }
            else if ((paramLong == 2L) || (paramLong == 256L))
            {
              callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=false;d.dispatchEvent(e)}catch(err){}}(document);");
            }
            else if (paramLong == 16L)
            {
              this.jdField_e_of_type_JavaLangString = null;
            }
            else
            {
              if ((paramLong != 8589934601L) && (paramLong != 8589934602L)) {
                break;
              }
              if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
              {
                callJs(this.jdField_e_of_type_JavaLangString, new String[] { "" });
                return true;
              }
              if ((this.mOpenApiListeners != null) && (this.mOpenApiListeners.containsKey("setLeftButton")))
              {
                callJs4OpenApiIfNeeded("setLeftButton", 0, "");
                return true;
              }
              if (paramLong == 8589934601L)
              {
                if (this.jdField_c_of_type_Int == -1)
                {
                  this.jdField_c_of_type_Int = 0;
                  paramString = this.mRuntime.a();
                  if ((paramString != null) && ((paramString instanceof QQBrowserActivity)))
                  {
                    Object localObject2 = paramString.getIntent();
                    localObject1 = a();
                    if ((localObject1 != null) && ((((WebUiUtils.WebTitleBarInterface)localObject1).a() & 0x200000) == 0L) && (!((Intent)localObject2).getBooleanExtra("show_right_close_button", false)))
                    {
                      localObject2 = (TextView)paramString.findViewById(2131363410);
                      if ((localObject2 == null) || (((TextView)localObject2).getVisibility() != 0) || (!paramString.getString(2131434920).equals(((TextView)localObject2).getText()))) {
                        break label299;
                      }
                    }
                  }
                }
                while (this.jdField_c_of_type_Int == 0)
                {
                  return false;
                  if ((((WebUiUtils.WebTitleBarInterface)localObject1).a() & 0x4) == 0L) {
                    this.jdField_c_of_type_Int = 1;
                  }
                }
                paramString = paramMap.get("target");
                if (!(paramString instanceof Integer)) {
                  return false;
                }
                n = ((Integer)paramString).intValue();
                if ((n != 1) && (n != 3)) {
                  return false;
                }
                paramString = this.mRuntime.a();
                if (paramString != null)
                {
                  n = paramString.copyBackForwardList().getCurrentIndex();
                  if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin", 2, "web history current index:" + n);
                  }
                  if (n > 1) {
                    b(true);
                  } else {
                    b(false);
                  }
                }
              }
            }
          }
        } while (paramLong != 8589934600L);
        n = ((Integer)paramMap.get("requestCode")).intValue();
        i1 = ((Integer)paramMap.get("resultCode")).intValue();
        if (n == 14) {
          for (;;)
          {
            try
            {
              localObject1 = new JSONObject();
              paramString = "";
              if (i1 == -1) {
                paramString = ((Intent)paramMap.get("data")).getStringExtra("data");
              }
              if (!TextUtils.isEmpty(paramString)) {
                break label613;
              }
              ((JSONObject)localObject1).put("result", -2);
              ((JSONObject)localObject1).put("data", "");
              callJs(this.jdField_h_of_type_JavaLangString, new String[] { ((JSONObject)localObject1).toString() });
            }
            catch (Exception paramString)
            {
              callJs(this.jdField_h_of_type_JavaLangString, new String[] { "" });
              QLog.e("UiApiPlugin", 1, "mOpenCustomWebViewCallback call back exception e = ", paramString);
            }
            break;
            ((JSONObject)localObject1).put("result", 0);
            ((JSONObject)localObject1).put("data", paramString);
          }
        }
      } while (n != 18);
      paramString = this.mRuntime.a();
    } while ((i1 != -1) || (paramString == null) || (paramString.isFinishing()));
    Object localObject1 = AIOUtils.a(new Intent(paramString, SplashActivity.class), null);
    paramMap = (Intent)paramMap.get("data");
    if (paramMap != null)
    {
      ((Intent)localObject1).putExtras(new Bundle(paramMap.getExtras()));
      paramString.startActivity((Intent)localObject1);
    }
    return true;
  }
  
  /* Error */
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 100
    //   2: aload_3
    //   3: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +15329 -> 15335
    //   9: aload_0
    //   10: aload 4
    //   12: aload_1
    //   13: invokevirtual 2008	com/tencent/mobileqq/jsp/UiApiPlugin:addOpenApiListenerIfNeeded	(Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   16: ldc_w 2010
    //   19: aload 4
    //   21: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: ifeq +199 -> 223
    //   27: aload 5
    //   29: arraylength
    //   30: ifle +193 -> 223
    //   33: new 110	org/json/JSONObject
    //   36: dup
    //   37: aload 5
    //   39: iconst_0
    //   40: aaload
    //   41: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   50: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   53: astore 4
    //   55: aload 5
    //   57: ldc_w 2012
    //   60: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: astore_1
    //   64: aload 5
    //   66: ldc_w 2014
    //   69: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_2
    //   73: aload 5
    //   75: ldc 151
    //   77: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_3
    //   81: aload 5
    //   83: ldc_w 1174
    //   86: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 5
    //   91: aload 4
    //   93: ifnull +91 -> 184
    //   96: aload_1
    //   97: invokestatic 2019	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   100: ifeq +84 -> 184
    //   103: aload_2
    //   104: invokestatic 2019	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   107: ifeq +77 -> 184
    //   110: new 126	android/content/Intent
    //   113: dup
    //   114: aload 4
    //   116: ldc_w 2021
    //   119: invokespecial 733	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   122: astore 4
    //   124: aload 4
    //   126: ldc_w 1460
    //   129: aload_1
    //   130: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   133: pop
    //   134: aload 4
    //   136: ldc_w 2014
    //   139: aload_2
    //   140: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   143: pop
    //   144: ldc_w 2023
    //   147: aload_3
    //   148: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifeq +25 -> 176
    //   154: aload 4
    //   156: ldc_w 2025
    //   159: bipush 8
    //   161: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   164: pop
    //   165: aload 4
    //   167: ldc_w 1174
    //   170: aload 5
    //   172: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   175: pop
    //   176: aload_0
    //   177: aload 4
    //   179: bipush 9
    //   181: invokevirtual 1385	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   184: iconst_1
    //   185: ireturn
    //   186: astore_1
    //   187: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq -6 -> 184
    //   193: ldc_w 2027
    //   196: iconst_2
    //   197: new 391	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 2029
    //   207: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_1
    //   211: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: goto -36 -> 184
    //   223: ldc_w 2031
    //   226: aload 4
    //   228: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +164 -> 395
    //   234: aload 5
    //   236: arraylength
    //   237: ifle +158 -> 395
    //   240: new 110	org/json/JSONObject
    //   243: dup
    //   244: aload 5
    //   246: iconst_0
    //   247: aaload
    //   248: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   251: astore_2
    //   252: aload_2
    //   253: ldc_w 1137
    //   256: invokevirtual 2035	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   259: lstore 10
    //   261: aload_2
    //   262: ldc_w 2037
    //   265: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   268: istore 6
    //   270: aload_2
    //   271: ldc_w 2039
    //   274: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   277: astore_1
    //   278: aload_2
    //   279: ldc_w 1174
    //   282: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   285: astore_2
    //   286: aload_0
    //   287: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   290: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   293: new 391	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   300: lload 10
    //   302: invokevirtual 2042	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   305: ldc_w 362
    //   308: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: bipush 9
    //   316: invokestatic 2047	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/Intent;
    //   319: astore_3
    //   320: aload_3
    //   321: ldc_w 2049
    //   324: aload_1
    //   325: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   328: pop
    //   329: aload_3
    //   330: ldc_w 2051
    //   333: iload 6
    //   335: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   338: pop
    //   339: aload_3
    //   340: ldc_w 1174
    //   343: aload_2
    //   344: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   347: pop
    //   348: aload_0
    //   349: aload_3
    //   350: bipush 8
    //   352: invokevirtual 1385	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   355: goto -171 -> 184
    //   358: astore_1
    //   359: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq -178 -> 184
    //   365: ldc_w 2027
    //   368: iconst_2
    //   369: new 391	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 2053
    //   379: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_1
    //   383: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: goto -208 -> 184
    //   395: ldc_w 2055
    //   398: aload 4
    //   400: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   403: ifeq +293 -> 696
    //   406: aload 5
    //   408: arraylength
    //   409: ifle +287 -> 696
    //   412: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   415: ifeq +30 -> 445
    //   418: ldc 196
    //   420: iconst_2
    //   421: new 391	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 2060
    //   431: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 5
    //   436: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 2062	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload_0
    //   446: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   449: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   452: astore_1
    //   453: aload_1
    //   454: ifnonnull +5 -> 459
    //   457: iconst_1
    //   458: ireturn
    //   459: new 110	org/json/JSONObject
    //   462: dup
    //   463: aload 5
    //   465: iconst_0
    //   466: aaload
    //   467: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   470: astore_2
    //   471: aload_2
    //   472: ldc_w 1227
    //   475: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   478: astore_3
    //   479: aload_2
    //   480: ldc 161
    //   482: invokevirtual 977	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   485: tableswitch	default:+14901 -> 15386, 0:+23->508, 1:+177->662
    //   509: ldc_w 2064
    //   512: iconst_1
    //   513: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   516: istore 8
    //   518: aload_3
    //   519: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   522: ifne -338 -> 184
    //   525: iconst_2
    //   526: istore 7
    //   528: iload 7
    //   530: istore 6
    //   532: iload 8
    //   534: tableswitch	default:+14855 -> 15389, 0:+103->637, 1:+109->643, 2:+115->649, 3:+121->655, 4:+42->576, 5:+42->576, 6:+103->637
    //   577: iload 6
    //   579: aload_3
    //   580: iconst_0
    //   581: invokestatic 1736	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   584: aload_1
    //   585: invokevirtual 413	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   588: ldc_w 341
    //   591: invokevirtual 347	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   594: invokevirtual 350	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   597: pop
    //   598: goto -414 -> 184
    //   601: astore_1
    //   602: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   605: ifeq -421 -> 184
    //   608: ldc 196
    //   610: iconst_2
    //   611: new 391	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   618: ldc_w 2066
    //   621: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload_1
    //   625: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   634: goto -450 -> 184
    //   637: iconst_0
    //   638: istore 6
    //   640: goto -64 -> 576
    //   643: iconst_2
    //   644: istore 6
    //   646: goto -70 -> 576
    //   649: iconst_1
    //   650: istore 6
    //   652: goto -76 -> 576
    //   655: bipush 6
    //   657: istore 6
    //   659: goto -83 -> 576
    //   662: aload_3
    //   663: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   666: ifne -482 -> 184
    //   669: aload_1
    //   670: iconst_0
    //   671: aload_3
    //   672: iconst_0
    //   673: invokestatic 1736	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   676: iconst_0
    //   677: invokevirtual 2068	com/tencent/mobileqq/widget/QQToast:a	(I)Landroid/widget/Toast;
    //   680: astore_1
    //   681: aload_1
    //   682: bipush 23
    //   684: iconst_0
    //   685: iconst_0
    //   686: invokevirtual 2073	android/widget/Toast:setGravity	(III)V
    //   689: aload_1
    //   690: invokevirtual 2074	android/widget/Toast:show	()V
    //   693: goto -509 -> 184
    //   696: ldc_w 2076
    //   699: aload 4
    //   701: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   704: ifeq +109 -> 813
    //   707: new 110	org/json/JSONObject
    //   710: dup
    //   711: aload 5
    //   713: iconst_0
    //   714: aaload
    //   715: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   718: ldc_w 2078
    //   721: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   724: astore_1
    //   725: aload_1
    //   726: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   729: ifeq +5 -> 734
    //   732: iconst_1
    //   733: ireturn
    //   734: aload_0
    //   735: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   738: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   741: astore_2
    //   742: new 126	android/content/Intent
    //   745: dup
    //   746: aload_2
    //   747: ldc_w 1994
    //   750: invokespecial 733	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   753: aconst_null
    //   754: invokestatic 1999	com/tencent/mobileqq/activity/aio/AIOUtils:a	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   757: astore_3
    //   758: aload_3
    //   759: ldc_w 2080
    //   762: aload_1
    //   763: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   766: pop
    //   767: aload_3
    //   768: ldc_w 2082
    //   771: iconst_1
    //   772: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   775: pop
    //   776: aload_3
    //   777: ldc_w 2084
    //   780: iconst_1
    //   781: invokevirtual 476	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   784: pop
    //   785: aload_2
    //   786: aload_3
    //   787: invokevirtual 749	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   790: goto -606 -> 184
    //   793: astore_1
    //   794: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   797: ifeq -613 -> 184
    //   800: ldc 196
    //   802: iconst_2
    //   803: ldc_w 2086
    //   806: aload_1
    //   807: invokestatic 2088	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   810: goto -626 -> 184
    //   813: ldc_w 2090
    //   816: aload 4
    //   818: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   821: ifeq +225 -> 1046
    //   824: new 110	org/json/JSONObject
    //   827: dup
    //   828: aload 5
    //   830: iconst_0
    //   831: aaload
    //   832: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   835: astore_3
    //   836: aload_3
    //   837: ldc_w 2078
    //   840: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   843: astore 4
    //   845: aload 4
    //   847: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   850: ifeq +5 -> 855
    //   853: iconst_1
    //   854: ireturn
    //   855: aload_3
    //   856: ldc_w 2092
    //   859: ldc_w 2094
    //   862: invokevirtual 2097	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   865: astore 5
    //   867: aload_3
    //   868: ldc_w 2099
    //   871: ldc_w 2101
    //   874: invokevirtual 2097	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   877: astore 14
    //   879: aload_0
    //   880: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   883: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   886: astore_1
    //   887: new 126	android/content/Intent
    //   890: dup
    //   891: aload_1
    //   892: ldc_w 1994
    //   895: invokespecial 733	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   898: aconst_null
    //   899: invokestatic 1999	com/tencent/mobileqq/activity/aio/AIOUtils:a	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   902: astore_2
    //   903: aload_2
    //   904: ldc_w 2080
    //   907: aload 4
    //   909: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   912: pop
    //   913: aload_2
    //   914: ldc_w 2082
    //   917: iconst_1
    //   918: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   921: pop
    //   922: aload_2
    //   923: ldc_w 2092
    //   926: aload 5
    //   928: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   931: pop
    //   932: aload_2
    //   933: ldc_w 2099
    //   936: aload 14
    //   938: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   941: pop
    //   942: aload_3
    //   943: ldc 161
    //   945: iconst_0
    //   946: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   949: istore 6
    //   951: iload 6
    //   953: iconst_1
    //   954: if_icmpne +65 -> 1019
    //   957: aload_3
    //   958: ldc_w 2103
    //   961: invokevirtual 847	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   964: astore_3
    //   965: aload_3
    //   966: ifnull +15 -> 981
    //   969: aload_2
    //   970: ldc_w 2105
    //   973: aload_3
    //   974: invokevirtual 2106	org/json/JSONArray:toString	()Ljava/lang/String;
    //   977: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   980: pop
    //   981: aload_2
    //   982: ldc_w 2108
    //   985: iload 6
    //   987: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   990: pop
    //   991: aload_1
    //   992: aload_2
    //   993: invokevirtual 749	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   996: goto -812 -> 184
    //   999: astore_1
    //   1000: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1003: ifeq -819 -> 184
    //   1006: ldc 196
    //   1008: iconst_2
    //   1009: ldc_w 2110
    //   1012: aload_1
    //   1013: invokestatic 2088	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1016: goto -832 -> 184
    //   1019: iload 6
    //   1021: iconst_2
    //   1022: if_icmpne -41 -> 981
    //   1025: aload_2
    //   1026: ldc_w 2112
    //   1029: aload_3
    //   1030: ldc_w 2103
    //   1033: ldc_w 2114
    //   1036: invokevirtual 2097	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1039: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1042: pop
    //   1043: goto -62 -> 981
    //   1046: ldc_w 2116
    //   1049: aload 4
    //   1051: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1054: ifeq +50 -> 1104
    //   1057: new 110	org/json/JSONObject
    //   1060: dup
    //   1061: aload 5
    //   1063: iconst_0
    //   1064: aaload
    //   1065: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1068: ldc_w 1227
    //   1071: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1074: astore_1
    //   1075: aload_1
    //   1076: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1079: ifne -895 -> 184
    //   1082: aload_0
    //   1083: aload_0
    //   1084: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1087: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1090: aload_1
    //   1091: invokestatic 2121	com/tencent/mobileqq/maproam/Utils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/app/ProgressDialog;
    //   1094: putfield 2123	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1097: goto -913 -> 184
    //   1100: astore_1
    //   1101: goto -917 -> 184
    //   1104: ldc_w 2125
    //   1107: aload 4
    //   1109: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1112: ifeq +52 -> 1164
    //   1115: aload_0
    //   1116: getfield 2123	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1119: ifnull -935 -> 184
    //   1122: aload_0
    //   1123: getfield 2123	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1126: invokevirtual 2126	android/app/ProgressDialog:isShowing	()Z
    //   1129: ifeq -945 -> 184
    //   1132: aload_0
    //   1133: getfield 2123	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1136: invokevirtual 1769	android/app/ProgressDialog:dismiss	()V
    //   1139: aload_0
    //   1140: aconst_null
    //   1141: putfield 2123	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1144: goto -960 -> 184
    //   1147: astore_1
    //   1148: aload_0
    //   1149: aconst_null
    //   1150: putfield 2123	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1153: goto -969 -> 184
    //   1156: astore_1
    //   1157: aload_0
    //   1158: aconst_null
    //   1159: putfield 2123	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1162: aload_1
    //   1163: athrow
    //   1164: ldc_w 2128
    //   1167: aload 4
    //   1169: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1172: ifeq +41 -> 1213
    //   1175: aload 5
    //   1177: arraylength
    //   1178: iconst_1
    //   1179: if_icmpne -995 -> 184
    //   1182: aload_1
    //   1183: getfield 2131	com/tencent/mobileqq/webview/swift/JsBridgeListener:jdField_a_of_type_Boolean	Z
    //   1186: ifeq +15 -> 1201
    //   1189: aload_0
    //   1190: aload 5
    //   1192: iconst_0
    //   1193: aaload
    //   1194: iconst_1
    //   1195: invokevirtual 2133	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Z)V
    //   1198: goto -1014 -> 184
    //   1201: aload_0
    //   1202: aload 5
    //   1204: iconst_0
    //   1205: aaload
    //   1206: iconst_0
    //   1207: invokevirtual 2133	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Z)V
    //   1210: goto -1026 -> 184
    //   1213: ldc_w 2135
    //   1216: aload 4
    //   1218: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1221: ifeq +50 -> 1271
    //   1224: aload_0
    //   1225: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1228: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1231: instanceof 2137
    //   1234: ifeq +26 -> 1260
    //   1237: aload_1
    //   1238: aload_0
    //   1239: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1242: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1245: checkcast 2137	mqq/app/AppActivity
    //   1248: invokevirtual 2140	mqq/app/AppActivity:isResume	()Z
    //   1251: invokestatic 985	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1254: invokevirtual 2143	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1257: goto -1073 -> 184
    //   1260: aload_1
    //   1261: iconst_0
    //   1262: invokestatic 985	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1265: invokevirtual 2143	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1268: goto -1084 -> 184
    //   1271: ldc_w 2145
    //   1274: aload 4
    //   1276: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1279: ifeq +50 -> 1329
    //   1282: aload 5
    //   1284: arraylength
    //   1285: iconst_1
    //   1286: if_icmpne +43 -> 1329
    //   1289: aload_0
    //   1290: new 110	org/json/JSONObject
    //   1293: dup
    //   1294: aload 5
    //   1296: iconst_0
    //   1297: aaload
    //   1298: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1301: aload_1
    //   1302: aconst_null
    //   1303: invokevirtual 1169	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Landroid/view/View$OnClickListener;)V
    //   1306: goto -1122 -> 184
    //   1309: astore_1
    //   1310: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1313: ifeq -1129 -> 184
    //   1316: ldc 196
    //   1318: iconst_2
    //   1319: ldc_w 2147
    //   1322: aload_1
    //   1323: invokestatic 2088	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1326: goto -1142 -> 184
    //   1329: ldc_w 2149
    //   1332: aload 4
    //   1334: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1337: ifeq +90 -> 1427
    //   1340: aload 5
    //   1342: arraylength
    //   1343: iconst_1
    //   1344: if_icmpne +83 -> 1427
    //   1347: aload_0
    //   1348: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1351: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1354: astore_2
    //   1355: aload_2
    //   1356: ifnull +14040 -> 15396
    //   1359: aload_2
    //   1360: invokevirtual 661	android/app/Activity:isFinishing	()Z
    //   1363: ifeq +6 -> 1369
    //   1366: goto +14030 -> 15396
    //   1369: new 110	org/json/JSONObject
    //   1372: dup
    //   1373: aload 5
    //   1375: iconst_0
    //   1376: aaload
    //   1377: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1380: astore_2
    //   1381: aload_0
    //   1382: aload_2
    //   1383: ldc_w 2151
    //   1386: invokevirtual 1043	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1389: invokevirtual 2153	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1392: aload_0
    //   1393: aload_2
    //   1394: ldc_w 2155
    //   1397: invokevirtual 1043	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1400: aload_1
    //   1401: invokevirtual 2157	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1404: goto -1220 -> 184
    //   1407: astore_1
    //   1408: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1411: ifeq -1227 -> 184
    //   1414: ldc 196
    //   1416: iconst_2
    //   1417: ldc_w 2159
    //   1420: aload_1
    //   1421: invokestatic 2088	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1424: goto -1240 -> 184
    //   1427: ldc_w 2161
    //   1430: aload 4
    //   1432: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1435: ifeq +71 -> 1506
    //   1438: aload 5
    //   1440: arraylength
    //   1441: iconst_1
    //   1442: if_icmpne +64 -> 1506
    //   1445: aload_0
    //   1446: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1449: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1452: astore_2
    //   1453: aload_2
    //   1454: ifnull +13944 -> 15398
    //   1457: aload_2
    //   1458: invokevirtual 661	android/app/Activity:isFinishing	()Z
    //   1461: ifeq +6 -> 1467
    //   1464: goto +13934 -> 15398
    //   1467: aload_0
    //   1468: new 110	org/json/JSONObject
    //   1471: dup
    //   1472: aload 5
    //   1474: iconst_0
    //   1475: aaload
    //   1476: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1479: aload_1
    //   1480: invokevirtual 2157	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1483: goto -1299 -> 184
    //   1486: astore_1
    //   1487: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1490: ifeq -1306 -> 184
    //   1493: ldc 196
    //   1495: iconst_2
    //   1496: ldc_w 2163
    //   1499: aload_1
    //   1500: invokestatic 2088	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1503: goto -1319 -> 184
    //   1506: ldc_w 2165
    //   1509: aload 4
    //   1511: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1514: ifeq +109 -> 1623
    //   1517: aload 5
    //   1519: arraylength
    //   1520: iconst_1
    //   1521: if_icmpne +102 -> 1623
    //   1524: aload_0
    //   1525: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1528: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1531: astore_1
    //   1532: aload_1
    //   1533: ifnull +13867 -> 15400
    //   1536: aload_1
    //   1537: invokevirtual 661	android/app/Activity:isFinishing	()Z
    //   1540: ifeq +6 -> 1546
    //   1543: goto +13857 -> 15400
    //   1546: new 110	org/json/JSONObject
    //   1549: dup
    //   1550: aload 5
    //   1552: iconst_0
    //   1553: aaload
    //   1554: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1557: astore_1
    //   1558: aload_1
    //   1559: ldc_w 2167
    //   1562: invokevirtual 977	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1565: istore 6
    //   1567: aload_1
    //   1568: ldc_w 2169
    //   1571: invokevirtual 1130	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1574: istore 12
    //   1576: aload_1
    //   1577: ldc_w 1174
    //   1580: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1583: astore_2
    //   1584: aload_0
    //   1585: iload 6
    //   1587: iload 12
    //   1589: aload_1
    //   1590: ldc_w 2171
    //   1593: invokevirtual 1130	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1596: aload_2
    //   1597: invokevirtual 2173	com/tencent/mobileqq/jsp/UiApiPlugin:a	(IZZLjava/lang/String;)V
    //   1600: goto -1416 -> 184
    //   1603: astore_1
    //   1604: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1607: ifeq -1423 -> 184
    //   1610: ldc 196
    //   1612: iconst_2
    //   1613: ldc_w 2163
    //   1616: aload_1
    //   1617: invokestatic 2088	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1620: goto -1436 -> 184
    //   1623: ldc_w 1940
    //   1626: aload 4
    //   1628: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1631: ifeq +70 -> 1701
    //   1634: aload 5
    //   1636: arraylength
    //   1637: iconst_1
    //   1638: if_icmpne +63 -> 1701
    //   1641: aload_0
    //   1642: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1645: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1648: astore_1
    //   1649: aload_1
    //   1650: ifnull +13752 -> 15402
    //   1653: aload_1
    //   1654: invokevirtual 661	android/app/Activity:isFinishing	()Z
    //   1657: ifeq +6 -> 1663
    //   1660: goto +13742 -> 15402
    //   1663: aload_0
    //   1664: new 110	org/json/JSONObject
    //   1667: dup
    //   1668: aload 5
    //   1670: iconst_0
    //   1671: aaload
    //   1672: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1675: invokevirtual 2153	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1678: goto -1494 -> 184
    //   1681: astore_1
    //   1682: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1685: ifeq -1501 -> 184
    //   1688: ldc 196
    //   1690: iconst_2
    //   1691: ldc_w 2175
    //   1694: aload_1
    //   1695: invokestatic 2088	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1698: goto -1514 -> 184
    //   1701: ldc_w 2177
    //   1704: aload 4
    //   1706: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1709: ifeq +83 -> 1792
    //   1712: aload 5
    //   1714: arraylength
    //   1715: iconst_1
    //   1716: if_icmpne +76 -> 1792
    //   1719: aload_0
    //   1720: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1723: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1726: astore_1
    //   1727: aload_1
    //   1728: ifnull +13676 -> 15404
    //   1731: aload_1
    //   1732: invokevirtual 661	android/app/Activity:isFinishing	()Z
    //   1735: ifeq +6 -> 1741
    //   1738: goto +13666 -> 15404
    //   1741: aload_0
    //   1742: new 110	org/json/JSONObject
    //   1745: dup
    //   1746: aload 5
    //   1748: iconst_0
    //   1749: aaload
    //   1750: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1753: invokevirtual 2179	com/tencent/mobileqq/jsp/UiApiPlugin:d	(Lorg/json/JSONObject;)V
    //   1756: goto -1572 -> 184
    //   1759: astore_1
    //   1760: ldc 196
    //   1762: iconst_1
    //   1763: new 391	java/lang/StringBuilder
    //   1766: dup
    //   1767: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   1770: ldc_w 2181
    //   1773: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1776: aload_1
    //   1777: invokestatic 2184	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1780: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1783: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1786: invokestatic 540	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1789: goto -1605 -> 184
    //   1792: ldc_w 561
    //   1795: aload 4
    //   1797: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1800: ifeq +21 -> 1821
    //   1803: aload 5
    //   1805: arraylength
    //   1806: iconst_1
    //   1807: if_icmpne +14 -> 1821
    //   1810: aload_0
    //   1811: aload 5
    //   1813: iconst_0
    //   1814: aaload
    //   1815: invokevirtual 2186	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;)V
    //   1818: goto -1634 -> 184
    //   1821: ldc_w 2188
    //   1824: aload 4
    //   1826: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1829: ifeq +174 -> 2003
    //   1832: aload 5
    //   1834: arraylength
    //   1835: iconst_1
    //   1836: if_icmpne +167 -> 2003
    //   1839: new 110	org/json/JSONObject
    //   1842: dup
    //   1843: aload 5
    //   1845: iconst_0
    //   1846: aaload
    //   1847: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1850: astore_2
    //   1851: aload_2
    //   1852: ldc_w 2190
    //   1855: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1858: astore_1
    //   1859: aload_0
    //   1860: aload_2
    //   1861: ldc_w 1174
    //   1864: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1867: putfield 2191	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1870: aload_0
    //   1871: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1874: invokevirtual 934	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1877: ifnonnull +5 -> 1882
    //   1880: iconst_1
    //   1881: ireturn
    //   1882: aload_0
    //   1883: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1886: invokevirtual 934	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1889: invokevirtual 2196	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   1892: astore_2
    //   1893: new 126	android/content/Intent
    //   1896: dup
    //   1897: aload_0
    //   1898: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1901: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1904: ldc_w 2198
    //   1907: invokespecial 733	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1910: ldc 151
    //   1912: ldc_w 364
    //   1915: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1918: astore_3
    //   1919: aload_1
    //   1920: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1923: ifeq +48 -> 1971
    //   1926: aload_0
    //   1927: getfield 2191	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1930: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1933: ifeq +38 -> 1971
    //   1936: aload_3
    //   1937: ldc_w 2200
    //   1940: iconst_1
    //   1941: invokevirtual 476	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1944: pop
    //   1945: aload_0
    //   1946: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1949: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1952: ifnonnull +5 -> 1957
    //   1955: iconst_1
    //   1956: ireturn
    //   1957: aload_0
    //   1958: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1961: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1964: aload_3
    //   1965: invokevirtual 749	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1968: goto -1784 -> 184
    //   1971: aload_3
    //   1972: ldc_w 2190
    //   1975: aload_1
    //   1976: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1979: ldc_w 2202
    //   1982: aload_2
    //   1983: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1986: ldc_w 2204
    //   1989: iconst_1
    //   1990: invokevirtual 476	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1993: pop
    //   1994: aload_0
    //   1995: aload_3
    //   1996: iconst_3
    //   1997: invokevirtual 1385	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2000: goto -1816 -> 184
    //   2003: ldc_w 2206
    //   2006: aload 4
    //   2008: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2011: ifeq +243 -> 2254
    //   2014: aload 5
    //   2016: arraylength
    //   2017: iconst_1
    //   2018: if_icmpne +236 -> 2254
    //   2021: new 110	org/json/JSONObject
    //   2024: dup
    //   2025: aload 5
    //   2027: iconst_0
    //   2028: aaload
    //   2029: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2032: astore 4
    //   2034: aload 4
    //   2036: ldc_w 2190
    //   2039: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2042: astore_1
    //   2043: aload 4
    //   2045: ldc_w 2208
    //   2048: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2051: astore_2
    //   2052: aload 4
    //   2054: ldc 161
    //   2056: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2059: astore_3
    //   2060: aload_0
    //   2061: aload 4
    //   2063: ldc_w 1174
    //   2066: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2069: putfield 2210	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2072: aload_0
    //   2073: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2076: invokevirtual 934	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   2079: ifnonnull +5 -> 2084
    //   2082: iconst_1
    //   2083: ireturn
    //   2084: aload_0
    //   2085: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2088: invokevirtual 934	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   2091: invokevirtual 2196	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   2094: astore 4
    //   2096: new 126	android/content/Intent
    //   2099: dup
    //   2100: aload_0
    //   2101: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2104: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2107: ldc_w 2212
    //   2110: invokespecial 733	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2113: ldc_w 2214
    //   2116: iconst_4
    //   2117: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2120: ldc_w 2215
    //   2123: invokevirtual 1125	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2126: astore 5
    //   2128: aload_1
    //   2129: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2132: ifeq +73 -> 2205
    //   2135: aload_0
    //   2136: getfield 2210	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2139: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2142: ifeq +63 -> 2205
    //   2145: aload_0
    //   2146: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2149: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2152: ifnonnull +5 -> 2157
    //   2155: iconst_1
    //   2156: ireturn
    //   2157: aload_0
    //   2158: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2161: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2164: aload 5
    //   2166: invokevirtual 749	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   2169: goto -1985 -> 184
    //   2172: astore_1
    //   2173: ldc 196
    //   2175: iconst_1
    //   2176: new 391	java/lang/StringBuilder
    //   2179: dup
    //   2180: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   2183: ldc_w 2217
    //   2186: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2189: aload_1
    //   2190: invokevirtual 891	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2193: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2196: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2199: invokestatic 540	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2202: goto -2018 -> 184
    //   2205: aload 5
    //   2207: ldc_w 2190
    //   2210: aload_1
    //   2211: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2214: ldc 161
    //   2216: aload_3
    //   2217: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2220: ldc_w 2208
    //   2223: aload_2
    //   2224: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2227: ldc_w 2202
    //   2230: aload 4
    //   2232: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2235: ldc_w 2204
    //   2238: iconst_1
    //   2239: invokevirtual 476	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2242: pop
    //   2243: aload_0
    //   2244: aload 5
    //   2246: bipush 17
    //   2248: invokevirtual 1385	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2251: goto -2067 -> 184
    //   2254: ldc_w 2219
    //   2257: aload 4
    //   2259: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2262: ifeq +102 -> 2364
    //   2265: aload 5
    //   2267: arraylength
    //   2268: iconst_1
    //   2269: if_icmpne +95 -> 2364
    //   2272: new 110	org/json/JSONObject
    //   2275: dup
    //   2276: aload 5
    //   2278: iconst_0
    //   2279: aaload
    //   2280: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2283: ldc_w 1174
    //   2286: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2289: astore_1
    //   2290: aload_0
    //   2291: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2294: aload_0
    //   2295: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2298: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2301: invokevirtual 618	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2304: astore_2
    //   2305: aload_2
    //   2306: ifnull +23 -> 2329
    //   2309: aload_2
    //   2310: instanceof 1515
    //   2313: ifeq +16 -> 2329
    //   2316: aload_2
    //   2317: checkcast 1515	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2320: invokeinterface 1518 1 0
    //   2325: aload_1
    //   2326: putfield 2222	com/tencent/biz/webviewplugin/Share:q	Ljava/lang/String;
    //   2329: aload_1
    //   2330: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2333: ifne -2149 -> 184
    //   2336: aload_0
    //   2337: iconst_2
    //   2338: invokevirtual 2223	com/tencent/mobileqq/jsp/UiApiPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   2341: checkcast 1190	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   2344: astore_1
    //   2345: aload_1
    //   2346: ifnull -2162 -> 184
    //   2349: aload_1
    //   2350: invokevirtual 2224	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:e	()V
    //   2353: goto -2169 -> 184
    //   2356: astore_1
    //   2357: aload_1
    //   2358: invokevirtual 2227	org/json/JSONException:printStackTrace	()V
    //   2361: goto -2177 -> 184
    //   2364: ldc_w 2229
    //   2367: aload 4
    //   2369: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2372: ifeq +42 -> 2414
    //   2375: aload 5
    //   2377: arraylength
    //   2378: iconst_1
    //   2379: if_icmpne +35 -> 2414
    //   2382: aload_0
    //   2383: new 110	org/json/JSONObject
    //   2386: dup
    //   2387: aload 5
    //   2389: iconst_0
    //   2390: aaload
    //   2391: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2394: ldc_w 1174
    //   2397: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2400: putfield 1800	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2403: goto -2219 -> 184
    //   2406: astore_1
    //   2407: aload_1
    //   2408: invokevirtual 2227	org/json/JSONException:printStackTrace	()V
    //   2411: goto -2227 -> 184
    //   2414: ldc_w 2231
    //   2417: aload 4
    //   2419: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2422: ifeq +78 -> 2500
    //   2425: aload 5
    //   2427: arraylength
    //   2428: iconst_1
    //   2429: if_icmpne +71 -> 2500
    //   2432: new 110	org/json/JSONObject
    //   2435: dup
    //   2436: aload 5
    //   2438: iconst_0
    //   2439: aaload
    //   2440: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2443: ldc_w 1174
    //   2446: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2449: astore_1
    //   2450: aload_0
    //   2451: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2454: aload_0
    //   2455: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2458: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2461: invokevirtual 618	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2464: astore_2
    //   2465: aload_2
    //   2466: ifnull -2282 -> 184
    //   2469: aload_2
    //   2470: instanceof 1515
    //   2473: ifeq -2289 -> 184
    //   2476: aload_2
    //   2477: checkcast 1515	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2480: invokeinterface 1518 1 0
    //   2485: aload_1
    //   2486: invokevirtual 2232	com/tencent/biz/webviewplugin/Share:a	(Ljava/lang/String;)V
    //   2489: goto -2305 -> 184
    //   2492: astore_1
    //   2493: aload_1
    //   2494: invokevirtual 2227	org/json/JSONException:printStackTrace	()V
    //   2497: goto -2313 -> 184
    //   2500: ldc_w 2234
    //   2503: aload 4
    //   2505: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2508: ifeq +111 -> 2619
    //   2511: aload 5
    //   2513: arraylength
    //   2514: iconst_1
    //   2515: if_icmpne +104 -> 2619
    //   2518: new 110	org/json/JSONObject
    //   2521: dup
    //   2522: aload 5
    //   2524: iconst_0
    //   2525: aaload
    //   2526: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2529: ldc_w 1174
    //   2532: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2535: astore_1
    //   2536: aload_0
    //   2537: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2540: aload_0
    //   2541: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2544: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2547: invokevirtual 618	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2550: astore_2
    //   2551: aload_2
    //   2552: ifnull +23 -> 2575
    //   2555: aload_2
    //   2556: instanceof 1515
    //   2559: ifeq +16 -> 2575
    //   2562: aload_2
    //   2563: checkcast 1515	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2566: invokeinterface 1518 1 0
    //   2571: aload_1
    //   2572: putfield 2236	com/tencent/biz/webviewplugin/Share:m	Ljava/lang/String;
    //   2575: aconst_null
    //   2576: ldc_w 358
    //   2579: ldc_w 2238
    //   2582: ldc_w 362
    //   2585: ldc_w 2240
    //   2588: ldc_w 2240
    //   2591: iconst_0
    //   2592: iconst_0
    //   2593: ldc_w 362
    //   2596: ldc_w 362
    //   2599: ldc_w 362
    //   2602: ldc_w 362
    //   2605: invokestatic 758	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2608: goto -2424 -> 184
    //   2611: astore_1
    //   2612: aload_1
    //   2613: invokevirtual 2227	org/json/JSONException:printStackTrace	()V
    //   2616: goto -41 -> 2575
    //   2619: ldc_w 2242
    //   2622: aload 4
    //   2624: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2627: ifeq +111 -> 2738
    //   2630: aload 5
    //   2632: arraylength
    //   2633: iconst_1
    //   2634: if_icmpne +104 -> 2738
    //   2637: new 110	org/json/JSONObject
    //   2640: dup
    //   2641: aload 5
    //   2643: iconst_0
    //   2644: aaload
    //   2645: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2648: ldc_w 1174
    //   2651: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2654: astore_1
    //   2655: aload_0
    //   2656: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2659: aload_0
    //   2660: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2663: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2666: invokevirtual 618	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2669: astore_2
    //   2670: aload_2
    //   2671: ifnull +23 -> 2694
    //   2674: aload_2
    //   2675: instanceof 1515
    //   2678: ifeq +16 -> 2694
    //   2681: aload_2
    //   2682: checkcast 1515	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2685: invokeinterface 1518 1 0
    //   2690: aload_1
    //   2691: putfield 2245	com/tencent/biz/webviewplugin/Share:n	Ljava/lang/String;
    //   2694: aconst_null
    //   2695: ldc_w 358
    //   2698: ldc_w 2238
    //   2701: ldc_w 362
    //   2704: ldc_w 2247
    //   2707: ldc_w 2247
    //   2710: iconst_0
    //   2711: iconst_0
    //   2712: ldc_w 362
    //   2715: ldc_w 362
    //   2718: ldc_w 362
    //   2721: ldc_w 362
    //   2724: invokestatic 758	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2727: goto -2543 -> 184
    //   2730: astore_1
    //   2731: aload_1
    //   2732: invokevirtual 2227	org/json/JSONException:printStackTrace	()V
    //   2735: goto -41 -> 2694
    //   2738: ldc_w 2249
    //   2741: aload 4
    //   2743: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2746: ifeq +111 -> 2857
    //   2749: aload 5
    //   2751: arraylength
    //   2752: iconst_1
    //   2753: if_icmpne +104 -> 2857
    //   2756: new 110	org/json/JSONObject
    //   2759: dup
    //   2760: aload 5
    //   2762: iconst_0
    //   2763: aaload
    //   2764: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2767: ldc_w 1174
    //   2770: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2773: astore_1
    //   2774: aload_0
    //   2775: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2778: aload_0
    //   2779: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2782: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2785: invokevirtual 618	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2788: astore_2
    //   2789: aload_2
    //   2790: ifnull +23 -> 2813
    //   2793: aload_2
    //   2794: instanceof 1515
    //   2797: ifeq +16 -> 2813
    //   2800: aload_2
    //   2801: checkcast 1515	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2804: invokeinterface 1518 1 0
    //   2809: aload_1
    //   2810: putfield 2252	com/tencent/biz/webviewplugin/Share:o	Ljava/lang/String;
    //   2813: aconst_null
    //   2814: ldc_w 358
    //   2817: ldc_w 2238
    //   2820: ldc_w 362
    //   2823: ldc_w 2254
    //   2826: ldc_w 2254
    //   2829: iconst_0
    //   2830: iconst_0
    //   2831: ldc_w 362
    //   2834: ldc_w 362
    //   2837: ldc_w 362
    //   2840: ldc_w 362
    //   2843: invokestatic 758	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2846: goto -2662 -> 184
    //   2849: astore_1
    //   2850: aload_1
    //   2851: invokevirtual 2227	org/json/JSONException:printStackTrace	()V
    //   2854: goto -41 -> 2813
    //   2857: ldc_w 2256
    //   2860: aload 4
    //   2862: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2865: ifeq +111 -> 2976
    //   2868: aload 5
    //   2870: arraylength
    //   2871: iconst_1
    //   2872: if_icmpne +104 -> 2976
    //   2875: new 110	org/json/JSONObject
    //   2878: dup
    //   2879: aload 5
    //   2881: iconst_0
    //   2882: aaload
    //   2883: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2886: ldc_w 1174
    //   2889: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2892: astore_1
    //   2893: aload_0
    //   2894: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2897: aload_0
    //   2898: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2901: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2904: invokevirtual 618	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2907: astore_2
    //   2908: aload_2
    //   2909: ifnull +23 -> 2932
    //   2912: aload_2
    //   2913: instanceof 1515
    //   2916: ifeq +16 -> 2932
    //   2919: aload_2
    //   2920: checkcast 1515	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2923: invokeinterface 1518 1 0
    //   2928: aload_1
    //   2929: putfield 2259	com/tencent/biz/webviewplugin/Share:p	Ljava/lang/String;
    //   2932: aconst_null
    //   2933: ldc_w 358
    //   2936: ldc_w 2238
    //   2939: ldc_w 362
    //   2942: ldc_w 2261
    //   2945: ldc_w 2261
    //   2948: iconst_0
    //   2949: iconst_0
    //   2950: ldc_w 362
    //   2953: ldc_w 362
    //   2956: ldc_w 362
    //   2959: ldc_w 362
    //   2962: invokestatic 758	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2965: goto -2781 -> 184
    //   2968: astore_1
    //   2969: aload_1
    //   2970: invokevirtual 2227	org/json/JSONException:printStackTrace	()V
    //   2973: goto -41 -> 2932
    //   2976: ldc_w 2263
    //   2979: aload 4
    //   2981: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2984: ifeq +259 -> 3243
    //   2987: aload 5
    //   2989: arraylength
    //   2990: iconst_1
    //   2991: if_icmpne +252 -> 3243
    //   2994: new 110	org/json/JSONObject
    //   2997: dup
    //   2998: aload 5
    //   3000: iconst_0
    //   3001: aaload
    //   3002: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3005: astore 5
    //   3007: aload_0
    //   3008: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3011: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3014: astore 4
    //   3016: aload 4
    //   3018: ifnull +12392 -> 15410
    //   3021: aload 4
    //   3023: invokevirtual 661	android/app/Activity:isFinishing	()Z
    //   3026: ifeq +6 -> 3032
    //   3029: goto +12381 -> 15410
    //   3032: aload 5
    //   3034: ldc_w 835
    //   3037: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3040: astore_1
    //   3041: aload 5
    //   3043: ldc_w 1227
    //   3046: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3049: astore 15
    //   3051: aload 5
    //   3053: ldc_w 2265
    //   3056: iconst_1
    //   3057: invokevirtual 956	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3060: istore 12
    //   3062: aload 5
    //   3064: ldc_w 2267
    //   3067: iconst_1
    //   3068: invokevirtual 956	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3071: istore 13
    //   3073: aload 5
    //   3075: ldc_w 2269
    //   3078: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3081: astore_2
    //   3082: aload 5
    //   3084: ldc_w 2271
    //   3087: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3090: astore_3
    //   3091: aload 5
    //   3093: ldc_w 1174
    //   3096: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3099: astore 5
    //   3101: aload 4
    //   3103: iconst_0
    //   3104: invokestatic 2276	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   3107: astore 14
    //   3109: aload 14
    //   3111: aload_1
    //   3112: invokevirtual 2282	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   3115: pop
    //   3116: aload 14
    //   3118: aload 15
    //   3120: invokevirtual 2286	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   3123: pop
    //   3124: new 2288	adno
    //   3127: dup
    //   3128: aload_0
    //   3129: aload 5
    //   3131: invokespecial 2289	adno:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   3134: astore 15
    //   3136: iload 13
    //   3138: ifeq +30 -> 3168
    //   3141: aload_3
    //   3142: astore_1
    //   3143: aload_3
    //   3144: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3147: ifeq +12 -> 3159
    //   3150: aload 4
    //   3152: ldc_w 2290
    //   3155: invokevirtual 1955	android/app/Activity:getString	(I)Ljava/lang/String;
    //   3158: astore_1
    //   3159: aload 14
    //   3161: aload_1
    //   3162: aload 15
    //   3164: invokevirtual 2294	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   3167: pop
    //   3168: iload 12
    //   3170: ifeq +30 -> 3200
    //   3173: aload_2
    //   3174: astore_1
    //   3175: aload_2
    //   3176: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3179: ifeq +12 -> 3191
    //   3182: aload 4
    //   3184: ldc_w 2295
    //   3187: invokevirtual 1955	android/app/Activity:getString	(I)Ljava/lang/String;
    //   3190: astore_1
    //   3191: aload 14
    //   3193: aload_1
    //   3194: aload 15
    //   3196: invokevirtual 2298	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   3199: pop
    //   3200: aload 5
    //   3202: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3205: ifne +18 -> 3223
    //   3208: aload 14
    //   3210: new 2300	adnu
    //   3213: dup
    //   3214: aload_0
    //   3215: aload 5
    //   3217: invokespecial 2301	adnu:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   3220: invokevirtual 2302	com/tencent/mobileqq/utils/QQCustomDialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   3223: aload 14
    //   3225: invokevirtual 2303	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   3228: goto -3044 -> 184
    //   3231: astore_1
    //   3232: goto -3048 -> 184
    //   3235: astore_1
    //   3236: aload_1
    //   3237: invokevirtual 2227	org/json/JSONException:printStackTrace	()V
    //   3240: goto -3056 -> 184
    //   3243: ldc_w 2305
    //   3246: aload 4
    //   3248: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3251: ifeq +399 -> 3650
    //   3254: aload 5
    //   3256: arraylength
    //   3257: iconst_1
    //   3258: if_icmpne +392 -> 3650
    //   3261: new 110	org/json/JSONObject
    //   3264: dup
    //   3265: aload 5
    //   3267: iconst_0
    //   3268: aaload
    //   3269: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3272: astore_2
    //   3273: aload_2
    //   3274: ldc_w 2307
    //   3277: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3280: astore_3
    //   3281: aload_2
    //   3282: ldc_w 2309
    //   3285: invokevirtual 1043	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3288: astore_2
    //   3289: ldc_w 2311
    //   3292: aload_3
    //   3293: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3296: ifeq +106 -> 3402
    //   3299: aload_2
    //   3300: ldc_w 2012
    //   3303: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3306: astore_2
    //   3307: aload_2
    //   3308: invokestatic 2019	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3311: ifeq +66 -> 3377
    //   3314: new 126	android/content/Intent
    //   3317: dup
    //   3318: invokespecial 218	android/content/Intent:<init>	()V
    //   3321: astore_3
    //   3322: aload_3
    //   3323: getstatic 2314	cooperation/troop/TroopFileProxyActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3326: aload_2
    //   3327: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3330: pop
    //   3331: aload_0
    //   3332: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3335: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3338: aload_3
    //   3339: aload_0
    //   3340: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3343: invokevirtual 894	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   3346: invokevirtual 1440	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3349: invokestatic 2317	cooperation/troop/TroopFileProxyActivity:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)V
    //   3352: aload_1
    //   3353: ldc_w 2319
    //   3356: invokevirtual 2143	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3359: goto -3175 -> 184
    //   3362: astore_2
    //   3363: aload_2
    //   3364: invokevirtual 2227	org/json/JSONException:printStackTrace	()V
    //   3367: aload_1
    //   3368: ldc_w 2321
    //   3371: invokevirtual 2143	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3374: goto -3190 -> 184
    //   3377: aload_1
    //   3378: ldc_w 2321
    //   3381: invokevirtual 2143	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3384: goto -3200 -> 184
    //   3387: astore_2
    //   3388: aload_2
    //   3389: invokevirtual 2322	java/lang/Exception:printStackTrace	()V
    //   3392: aload_1
    //   3393: ldc_w 2321
    //   3396: invokevirtual 2143	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3399: goto -3215 -> 184
    //   3402: ldc_w 2324
    //   3405: aload_3
    //   3406: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3409: ifeq +71 -> 3480
    //   3412: aload_2
    //   3413: ldc_w 2012
    //   3416: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3419: astore_2
    //   3420: aload_2
    //   3421: invokestatic 2019	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3424: ifeq +46 -> 3470
    //   3427: invokestatic 2329	cooperation/qzone/QZoneHelper$UserInfo:a	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   3430: astore_3
    //   3431: aload_3
    //   3432: aload_0
    //   3433: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3436: invokevirtual 894	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   3439: invokevirtual 1440	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3442: putfield 2330	cooperation/qzone/QZoneHelper$UserInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3445: aload_0
    //   3446: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3449: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3452: aload_3
    //   3453: aload_2
    //   3454: aconst_null
    //   3455: iconst_0
    //   3456: iconst_0
    //   3457: invokestatic 2335	cooperation/qzone/QZoneHelper:a	(Landroid/app/Activity;Lcooperation/qzone/QZoneHelper$UserInfo;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   3460: aload_1
    //   3461: ldc_w 2319
    //   3464: invokevirtual 2143	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3467: goto -3283 -> 184
    //   3470: aload_1
    //   3471: ldc_w 2321
    //   3474: invokevirtual 2143	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3477: goto -3293 -> 184
    //   3480: ldc_w 2337
    //   3483: aload_3
    //   3484: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3487: ifeq +66 -> 3553
    //   3490: aload_0
    //   3491: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3494: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3497: astore_3
    //   3498: aload_2
    //   3499: ldc_w 2012
    //   3502: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3505: astore_2
    //   3506: aload_3
    //   3507: ifnull -3323 -> 184
    //   3510: aload_2
    //   3511: invokestatic 2019	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3514: ifeq -3330 -> 184
    //   3517: new 126	android/content/Intent
    //   3520: dup
    //   3521: aload_3
    //   3522: ldc_w 2339
    //   3525: invokespecial 733	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3528: astore 4
    //   3530: aload 4
    //   3532: ldc_w 1460
    //   3535: aload_2
    //   3536: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3539: pop
    //   3540: aload_3
    //   3541: aload 4
    //   3543: invokevirtual 749	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3546: aload_3
    //   3547: invokevirtual 232	android/app/Activity:finish	()V
    //   3550: goto -3366 -> 184
    //   3553: ldc_w 2341
    //   3556: aload_3
    //   3557: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3560: ifeq -3376 -> 184
    //   3563: aload_0
    //   3564: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3567: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3570: astore_3
    //   3571: aload_2
    //   3572: ldc_w 2012
    //   3575: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3578: astore 4
    //   3580: aload_2
    //   3581: ldc_w 2014
    //   3584: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3587: astore_2
    //   3588: aload_3
    //   3589: ifnull -3405 -> 184
    //   3592: aload 4
    //   3594: invokestatic 2019	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3597: ifeq -3413 -> 184
    //   3600: aload_2
    //   3601: invokestatic 2019	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3604: ifeq -3420 -> 184
    //   3607: new 126	android/content/Intent
    //   3610: dup
    //   3611: aload_3
    //   3612: ldc_w 2021
    //   3615: invokespecial 733	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3618: astore 5
    //   3620: aload 5
    //   3622: ldc_w 1460
    //   3625: aload 4
    //   3627: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3630: pop
    //   3631: aload 5
    //   3633: ldc_w 2014
    //   3636: aload_2
    //   3637: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3640: pop
    //   3641: aload_3
    //   3642: aload 5
    //   3644: invokevirtual 749	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3647: goto -3463 -> 184
    //   3650: ldc_w 2342
    //   3653: aload 4
    //   3655: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3658: ifeq +732 -> 4390
    //   3661: aload 5
    //   3663: arraylength
    //   3664: iconst_1
    //   3665: if_icmpne +725 -> 4390
    //   3668: aload_0
    //   3669: ldc_w 362
    //   3672: putfield 2344	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   3675: new 110	org/json/JSONObject
    //   3678: dup
    //   3679: aload 5
    //   3681: iconst_0
    //   3682: aaload
    //   3683: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3686: astore_1
    //   3687: aload_1
    //   3688: ifnull +684 -> 4372
    //   3691: aload_0
    //   3692: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3695: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3698: astore_3
    //   3699: aload_1
    //   3700: ldc_w 2346
    //   3703: ldc_w 2348
    //   3706: invokevirtual 2097	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3709: astore 14
    //   3711: aload_1
    //   3712: ldc_w 2190
    //   3715: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3718: astore 4
    //   3720: aload_1
    //   3721: ldc_w 1039
    //   3724: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3727: astore 15
    //   3729: aload_1
    //   3730: ldc_w 2350
    //   3733: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3736: astore 5
    //   3738: aload_1
    //   3739: ldc_w 1174
    //   3742: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3745: astore_2
    //   3746: aload_1
    //   3747: ldc_w 1034
    //   3750: iconst_m1
    //   3751: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3754: istore 6
    //   3756: new 110	org/json/JSONObject
    //   3759: dup
    //   3760: aload 15
    //   3762: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3765: astore_1
    //   3766: aload_0
    //   3767: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3770: invokevirtual 934	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   3773: astore 15
    //   3775: aload 15
    //   3777: ifnull +16 -> 3793
    //   3780: aload_1
    //   3781: ldc_w 2352
    //   3784: aload 15
    //   3786: invokevirtual 2353	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   3789: invokevirtual 167	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3792: pop
    //   3793: ldc_w 2355
    //   3796: aload 14
    //   3798: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3801: ifeq +164 -> 3965
    //   3804: new 795	android/os/Bundle
    //   3807: dup
    //   3808: invokespecial 796	android/os/Bundle:<init>	()V
    //   3811: astore_2
    //   3812: aload_2
    //   3813: ldc_w 1039
    //   3816: aload_1
    //   3817: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3820: invokevirtual 808	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3823: aload_2
    //   3824: ldc_w 2350
    //   3827: aload 5
    //   3829: invokevirtual 808	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3832: ldc_w 2357
    //   3835: aload 4
    //   3837: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3840: ifeq +95 -> 3935
    //   3843: new 2359	com/tencent/mobileqq/troop/activity/PublicCommentWindow
    //   3846: dup
    //   3847: aload_3
    //   3848: checkcast 2361	com/tencent/mobileqq/app/BaseActivity
    //   3851: aload_2
    //   3852: invokespecial 2364	com/tencent/mobileqq/troop/activity/PublicCommentWindow:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   3855: aload_3
    //   3856: invokevirtual 2366	com/tencent/mobileqq/troop/activity/PublicCommentWindow:a	(Landroid/app/Activity;)V
    //   3859: goto -3675 -> 184
    //   3862: astore_1
    //   3863: ldc_w 362
    //   3866: astore_2
    //   3867: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3870: ifeq +22 -> 3892
    //   3873: ldc 196
    //   3875: iconst_2
    //   3876: ldc_w 2368
    //   3879: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3882: ldc 196
    //   3884: iconst_2
    //   3885: aload_1
    //   3886: invokestatic 426	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3889: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3892: aload_2
    //   3893: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3896: ifne -3712 -> 184
    //   3899: aload_0
    //   3900: aload_2
    //   3901: iconst_1
    //   3902: anewarray 325	java/lang/String
    //   3905: dup
    //   3906: iconst_0
    //   3907: ldc_w 2370
    //   3910: aastore
    //   3911: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3914: goto -3730 -> 184
    //   3917: astore_1
    //   3918: aconst_null
    //   3919: astore_1
    //   3920: goto -233 -> 3687
    //   3923: astore_1
    //   3924: new 110	org/json/JSONObject
    //   3927: dup
    //   3928: invokespecial 159	org/json/JSONObject:<init>	()V
    //   3931: astore_1
    //   3932: goto -166 -> 3766
    //   3935: ldc_w 2372
    //   3938: aload 4
    //   3940: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3943: ifeq -3759 -> 184
    //   3946: new 2374	com/tencent/mobileqq/troop/activity/TroopBarCommentWindow
    //   3949: dup
    //   3950: aload_3
    //   3951: checkcast 2361	com/tencent/mobileqq/app/BaseActivity
    //   3954: aload_2
    //   3955: invokespecial 2375	com/tencent/mobileqq/troop/activity/TroopBarCommentWindow:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   3958: aload_3
    //   3959: invokevirtual 2376	com/tencent/mobileqq/troop/activity/TroopBarCommentWindow:a	(Landroid/app/Activity;)V
    //   3962: goto -3778 -> 184
    //   3965: ldc_w 2348
    //   3968: aload 14
    //   3970: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3973: ifeq +289 -> 4262
    //   3976: new 126	android/content/Intent
    //   3979: dup
    //   3980: invokespecial 218	android/content/Intent:<init>	()V
    //   3983: astore 14
    //   3985: ldc_w 2378
    //   3988: aload 4
    //   3990: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3993: ifeq +119 -> 4112
    //   3996: aload 14
    //   3998: new 2380	android/content/ComponentName
    //   4001: dup
    //   4002: aload_0
    //   4003: invokevirtual 1552	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   4006: aload 4
    //   4008: invokespecial 2382	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4011: invokevirtual 2386	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4014: pop
    //   4015: aload 14
    //   4017: ldc_w 2388
    //   4020: invokestatic 971	java/lang/System:currentTimeMillis	()J
    //   4023: invokevirtual 1140	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   4026: pop
    //   4027: aload 14
    //   4029: ldc_w 1039
    //   4032: aload_1
    //   4033: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4036: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4039: pop
    //   4040: aload_0
    //   4041: aload 5
    //   4043: putfield 2344	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4046: aload 5
    //   4048: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4051: ifeq +166 -> 4217
    //   4054: aload_3
    //   4055: aload 14
    //   4057: invokevirtual 749	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   4060: goto +11352 -> 15412
    //   4063: ldc_w 2390
    //   4066: invokevirtual 139	java/lang/Class:getName	()Ljava/lang/String;
    //   4069: aload 4
    //   4071: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4074: ifeq -3890 -> 184
    //   4077: aload_0
    //   4078: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4081: ifnonnull +17 -> 4098
    //   4084: aload_0
    //   4085: invokestatic 1398	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4088: putfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4091: aload_0
    //   4092: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4095: invokevirtual 1399	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   4098: aload_0
    //   4099: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4102: invokevirtual 2392	com/tencent/biz/troop/TroopMemberApiClient:c	()V
    //   4105: goto -3921 -> 184
    //   4108: astore_1
    //   4109: goto -242 -> 3867
    //   4112: ldc_w 2394
    //   4115: aload 4
    //   4117: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4120: ifeq +78 -> 4198
    //   4123: aload 14
    //   4125: new 2380	android/content/ComponentName
    //   4128: dup
    //   4129: aload_3
    //   4130: aload 4
    //   4132: invokespecial 2382	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4135: invokevirtual 2386	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4138: pop
    //   4139: aload 14
    //   4141: ldc_w 2396
    //   4144: iconst_0
    //   4145: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   4148: pop
    //   4149: aload 14
    //   4151: ldc_w 962
    //   4154: invokestatic 971	java/lang/System:currentTimeMillis	()J
    //   4157: invokevirtual 1140	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   4160: pop
    //   4161: aload 14
    //   4163: getstatic 2400	cooperation/qqindividuality/QQIndividualityUtils:l	Ljava/lang/String;
    //   4166: iconst_1
    //   4167: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   4170: pop
    //   4171: aload 14
    //   4173: getstatic 2401	cooperation/qqindividuality/QQIndividualityUtils:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   4176: ldc_w 2403
    //   4179: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4182: pop
    //   4183: aload 14
    //   4185: getstatic 2404	cooperation/qqindividuality/QQIndividualityUtils:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4188: ldc_w 2190
    //   4191: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4194: pop
    //   4195: goto -168 -> 4027
    //   4198: aload 14
    //   4200: new 2380	android/content/ComponentName
    //   4203: dup
    //   4204: aload_3
    //   4205: aload 4
    //   4207: invokespecial 2382	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4210: invokevirtual 2386	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4213: pop
    //   4214: goto -187 -> 4027
    //   4217: aload_0
    //   4218: aload 14
    //   4220: iconst_4
    //   4221: invokevirtual 1385	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   4224: aload_2
    //   4225: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4228: ifne +11184 -> 15412
    //   4231: aload_0
    //   4232: aload_2
    //   4233: iconst_1
    //   4234: anewarray 325	java/lang/String
    //   4237: dup
    //   4238: iconst_0
    //   4239: ldc_w 384
    //   4242: aastore
    //   4243: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4246: goto +11166 -> 15412
    //   4249: aload_3
    //   4250: ldc_w 2405
    //   4253: ldc_w 2406
    //   4256: invokevirtual 1037	android/app/Activity:overridePendingTransition	(II)V
    //   4259: goto -196 -> 4063
    //   4262: ldc_w 2408
    //   4265: aload 14
    //   4267: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4270: ifeq -4086 -> 184
    //   4273: aload 4
    //   4275: ldc_w 2410
    //   4278: invokevirtual 139	java/lang/Class:getName	()Ljava/lang/String;
    //   4281: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4284: ifeq -4100 -> 184
    //   4287: aload_1
    //   4288: ldc_w 2412
    //   4291: iconst_0
    //   4292: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4295: iconst_1
    //   4296: if_icmpne -4112 -> 184
    //   4299: aload_0
    //   4300: aload 5
    //   4302: putfield 2344	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4305: aload_1
    //   4306: ldc 151
    //   4308: ldc_w 362
    //   4311: invokevirtual 2097	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4314: astore_2
    //   4315: aload_0
    //   4316: aload_3
    //   4317: aload_0
    //   4318: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4321: invokevirtual 894	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   4324: aload_1
    //   4325: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4328: iconst_4
    //   4329: aload_2
    //   4330: invokestatic 2417	com/tencent/mobileqq/tribe/fragment/TribeEffectsCameraCaptureFragment:a	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;BLjava/lang/String;)V
    //   4333: aload_3
    //   4334: ldc_w 2405
    //   4337: ldc_w 2406
    //   4340: invokevirtual 1037	android/app/Activity:overridePendingTransition	(II)V
    //   4343: ldc_w 362
    //   4346: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4349: ifne -4165 -> 184
    //   4352: aload_0
    //   4353: ldc_w 362
    //   4356: iconst_1
    //   4357: anewarray 325	java/lang/String
    //   4360: dup
    //   4361: iconst_0
    //   4362: ldc_w 384
    //   4365: aastore
    //   4366: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4369: goto -4185 -> 184
    //   4372: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4375: ifeq -4191 -> 184
    //   4378: ldc 196
    //   4380: iconst_2
    //   4381: ldc_w 2419
    //   4384: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4387: goto -4203 -> 184
    //   4390: ldc_w 2421
    //   4393: aload 4
    //   4395: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4398: ifeq +1631 -> 6029
    //   4401: aload 5
    //   4403: arraylength
    //   4404: iconst_1
    //   4405: if_icmpne +1624 -> 6029
    //   4408: new 110	org/json/JSONObject
    //   4411: dup
    //   4412: aload 5
    //   4414: iconst_0
    //   4415: aaload
    //   4416: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4419: astore_2
    //   4420: aload_0
    //   4421: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4424: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   4427: astore_3
    //   4428: aload_3
    //   4429: instanceof 1022
    //   4432: ifne +5 -> 4437
    //   4435: iconst_1
    //   4436: ireturn
    //   4437: aload_0
    //   4438: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4441: invokevirtual 766	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   4444: astore 4
    //   4446: aload 4
    //   4448: ifnonnull +5 -> 4453
    //   4451: iconst_1
    //   4452: ireturn
    //   4453: aload_2
    //   4454: ldc_w 2423
    //   4457: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4460: ifeq +103 -> 4563
    //   4463: aload_2
    //   4464: ldc_w 2425
    //   4467: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4470: ifeq +93 -> 4563
    //   4473: aload_2
    //   4474: ldc_w 2425
    //   4477: invokevirtual 1130	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   4480: ifeq +83 -> 4563
    //   4483: aload_2
    //   4484: ldc_w 2423
    //   4487: invokestatic 2427	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   4490: istore 6
    //   4492: aload_0
    //   4493: iconst_2
    //   4494: invokespecial 1188	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   4497: checkcast 1190	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   4500: astore_1
    //   4501: aload_1
    //   4502: ifnull +25 -> 4527
    //   4505: aload_1
    //   4506: getfield 2428	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   4509: ifnull +18 -> 4527
    //   4512: aload_1
    //   4513: iload 6
    //   4515: putfield 2429	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_Int	I
    //   4518: aload_1
    //   4519: getfield 2428	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   4522: iload 6
    //   4524: invokevirtual 2430	android/view/View:setBackgroundColor	(I)V
    //   4527: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4530: ifeq +33 -> 4563
    //   4533: ldc 196
    //   4535: iconst_2
    //   4536: new 391	java/lang/StringBuilder
    //   4539: dup
    //   4540: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   4543: ldc_w 2432
    //   4546: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4549: iload 6
    //   4551: invokestatic 2435	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   4554: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4557: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4560: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4563: aload_2
    //   4564: ldc_w 2437
    //   4567: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4570: ifeq +71 -> 4641
    //   4573: aload_2
    //   4574: ldc_w 2437
    //   4577: invokevirtual 1130	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   4580: istore 12
    //   4582: iload 12
    //   4584: ifne +57 -> 4641
    //   4587: aload_0
    //   4588: iconst_2
    //   4589: invokespecial 1188	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   4592: checkcast 1190	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   4595: astore_1
    //   4596: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4599: ifeq +30 -> 4629
    //   4602: ldc 196
    //   4604: iconst_2
    //   4605: new 391	java/lang/StringBuilder
    //   4608: dup
    //   4609: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   4612: ldc_w 2439
    //   4615: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4618: iload 12
    //   4620: invokevirtual 2442	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4623: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4626: invokestatic 2062	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4629: aload_1
    //   4630: ifnull +11 -> 4641
    //   4633: aload_1
    //   4634: getfield 2445	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController	Lcom/tencent/mobileqq/widget/WebViewProgressBarController;
    //   4637: iconst_0
    //   4638: invokevirtual 2449	com/tencent/mobileqq/widget/WebViewProgressBarController:a	(Z)V
    //   4641: aload_2
    //   4642: ldc_w 2451
    //   4645: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4648: ifeq +70 -> 4718
    //   4651: aload_2
    //   4652: ldc_w 2451
    //   4655: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4658: istore 6
    //   4660: aload_3
    //   4661: ldc_w 1951
    //   4664: invokevirtual 666	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4667: checkcast 1669	android/widget/TextView
    //   4670: astore_1
    //   4671: aload_3
    //   4672: ldc_w 2452
    //   4675: invokevirtual 666	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4678: checkcast 644	android/widget/ImageView
    //   4681: astore 5
    //   4683: aload_1
    //   4684: ifnull +34 -> 4718
    //   4687: aload 5
    //   4689: ifnull +29 -> 4718
    //   4692: iload 6
    //   4694: iconst_1
    //   4695: if_icmpne +907 -> 5602
    //   4698: aload 5
    //   4700: invokevirtual 648	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   4703: ifnull +848 -> 5551
    //   4706: aload 5
    //   4708: iconst_0
    //   4709: invokevirtual 686	android/widget/ImageView:setVisibility	(I)V
    //   4712: aload_1
    //   4713: bipush 8
    //   4715: invokevirtual 2453	android/widget/TextView:setVisibility	(I)V
    //   4718: aload_2
    //   4719: ldc_w 2455
    //   4722: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4725: ifeq +24 -> 4749
    //   4728: aload_2
    //   4729: ldc_w 2455
    //   4732: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4735: iconst_1
    //   4736: if_icmpne +10699 -> 15435
    //   4739: iconst_1
    //   4740: istore 12
    //   4742: aload 4
    //   4744: iload 12
    //   4746: invokevirtual 2457	com/tencent/mobileqq/webview/swift/WebViewFragment:g	(Z)V
    //   4749: aload_2
    //   4750: ldc_w 2459
    //   4753: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4756: ifeq +132 -> 4888
    //   4759: aload_2
    //   4760: ldc_w 2461
    //   4763: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4766: ifeq +122 -> 4888
    //   4769: aload_2
    //   4770: ldc_w 2463
    //   4773: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4776: ifeq +112 -> 4888
    //   4779: aload_2
    //   4780: ldc_w 2465
    //   4783: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4786: ifeq +102 -> 4888
    //   4789: aload_2
    //   4790: ldc_w 2467
    //   4793: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4796: ifeq +92 -> 4888
    //   4799: aload_2
    //   4800: ldc_w 2459
    //   4803: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4806: astore_1
    //   4807: aload_2
    //   4808: ldc_w 2461
    //   4811: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4814: istore 6
    //   4816: aload_2
    //   4817: ldc_w 2463
    //   4820: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4823: istore 7
    //   4825: aload_2
    //   4826: ldc_w 2465
    //   4829: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4832: istore 8
    //   4834: aload_2
    //   4835: ldc_w 2467
    //   4838: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4841: istore 9
    //   4843: aload 4
    //   4845: getfield 2470	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4848: ifnull +40 -> 4888
    //   4851: aload 4
    //   4853: getfield 2470	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4856: getfield 2473	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   4859: instanceof 636
    //   4862: ifeq +26 -> 4888
    //   4865: aload 4
    //   4867: getfield 2470	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4870: getfield 2473	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   4873: checkcast 636	com/tencent/biz/ui/RefreshView
    //   4876: aload_1
    //   4877: iload 6
    //   4879: iload 7
    //   4881: iload 8
    //   4883: iload 9
    //   4885: invokevirtual 2476	com/tencent/biz/ui/RefreshView:a	(Ljava/lang/String;IIII)V
    //   4888: aload_2
    //   4889: ldc_w 2478
    //   4892: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4895: ifeq +48 -> 4943
    //   4898: aload_2
    //   4899: ldc_w 2478
    //   4902: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4905: astore_1
    //   4906: aload 4
    //   4908: getfield 2470	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4911: ifnull +32 -> 4943
    //   4914: aload 4
    //   4916: getfield 2470	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4919: getfield 2473	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   4922: instanceof 636
    //   4925: ifeq +18 -> 4943
    //   4928: aload 4
    //   4930: getfield 2470	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4933: getfield 2473	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   4936: checkcast 636	com/tencent/biz/ui/RefreshView
    //   4939: aload_1
    //   4940: invokevirtual 2479	com/tencent/biz/ui/RefreshView:a	(Ljava/lang/String;)V
    //   4943: aload 4
    //   4945: invokevirtual 2481	com/tencent/mobileqq/webview/swift/WebViewFragment:f	()Z
    //   4948: ifne +149 -> 5097
    //   4951: aload_2
    //   4952: ldc_w 2483
    //   4955: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4958: ifeq +139 -> 5097
    //   4961: aload_2
    //   4962: ldc_w 2483
    //   4965: invokestatic 2427	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   4968: istore 7
    //   4970: aload_3
    //   4971: ldc_w 662
    //   4974: invokevirtual 666	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4977: astore 5
    //   4979: aload 5
    //   4981: ifnull +116 -> 5097
    //   4984: aconst_null
    //   4985: astore_1
    //   4986: aload_0
    //   4987: invokevirtual 2485	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebProgressInterface;
    //   4990: ifnull +628 -> 5618
    //   4993: aload_0
    //   4994: invokevirtual 2485	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebProgressInterface;
    //   4997: invokeinterface 2488 1 0
    //   5002: astore_1
    //   5003: iload 7
    //   5005: iconst_m1
    //   5006: if_icmpne +689 -> 5695
    //   5009: aload 5
    //   5011: invokevirtual 2491	android/view/View:getPaddingTop	()I
    //   5014: istore 6
    //   5016: aload 5
    //   5018: invokevirtual 2494	android/view/View:getPaddingBottom	()I
    //   5021: istore 7
    //   5023: aload 5
    //   5025: invokevirtual 2497	android/view/View:getPaddingLeft	()I
    //   5028: istore 8
    //   5030: aload 5
    //   5032: invokevirtual 2500	android/view/View:getPaddingRight	()I
    //   5035: istore 9
    //   5037: aload 5
    //   5039: ldc_w 2501
    //   5042: invokevirtual 2502	android/view/View:setBackgroundResource	(I)V
    //   5045: aload 5
    //   5047: iload 8
    //   5049: iload 6
    //   5051: iload 9
    //   5053: iload 7
    //   5055: invokevirtual 2505	android/view/View:setPadding	(IIII)V
    //   5058: aload_1
    //   5059: ifnull +7 -> 5066
    //   5062: aload_1
    //   5063: invokevirtual 2508	com/tencent/mobileqq/widget/WebViewProgressBar:a	()V
    //   5066: aload 4
    //   5068: getfield 2510	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5071: ifnull +26 -> 5097
    //   5074: aload 4
    //   5076: invokevirtual 2512	com/tencent/mobileqq/webview/swift/WebViewFragment:d	()Z
    //   5079: ifeq +563 -> 5642
    //   5082: aload 4
    //   5084: getfield 2510	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5087: iconst_4
    //   5088: invokevirtual 632	android/view/View:setVisibility	(I)V
    //   5091: aload 4
    //   5093: iconst_0
    //   5094: invokevirtual 2514	com/tencent/mobileqq/webview/swift/WebViewFragment:i	(Z)V
    //   5097: aload_2
    //   5098: ldc_w 1184
    //   5101: iconst_m1
    //   5102: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5105: istore 6
    //   5107: aload_0
    //   5108: iconst_2
    //   5109: invokespecial 1188	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   5112: checkcast 1190	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   5115: astore_1
    //   5116: iload 6
    //   5118: iflt +98 -> 5216
    //   5121: aload_1
    //   5122: ifnull +94 -> 5216
    //   5125: aload_1
    //   5126: getfield 1193	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5129: astore 5
    //   5131: iconst_1
    //   5132: iload 6
    //   5134: if_icmpne +10307 -> 15441
    //   5137: iconst_1
    //   5138: istore 12
    //   5140: aload 5
    //   5142: iload 12
    //   5144: putfield 1198	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:w	Z
    //   5147: aload_0
    //   5148: getfield 1869	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5151: ifeq +23 -> 5174
    //   5154: aload_1
    //   5155: aload_1
    //   5156: getfield 2515	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   5159: getfield 1858	com/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   5162: iconst_0
    //   5163: aload_0
    //   5164: getfield 1869	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5167: aload_0
    //   5168: getfield 1869	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5171: invokevirtual 1872	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Landroid/view/View;ZII)V
    //   5174: aload_0
    //   5175: getfield 1882	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5178: ifeq +20 -> 5198
    //   5181: aload_1
    //   5182: aload_0
    //   5183: getfield 642	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   5186: iconst_0
    //   5187: aload_0
    //   5188: getfield 1882	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5191: aload_0
    //   5192: getfield 1882	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5195: invokevirtual 1872	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Landroid/view/View;ZII)V
    //   5198: aload_1
    //   5199: aload_1
    //   5200: getfield 2515	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   5203: getfield 1805	com/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   5206: iconst_1
    //   5207: ldc_w 2516
    //   5210: ldc_w 2517
    //   5213: invokevirtual 1872	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Landroid/view/View;ZII)V
    //   5216: aload_2
    //   5217: ldc_w 2519
    //   5220: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5223: ifeq +23 -> 5246
    //   5226: aload_2
    //   5227: ldc_w 2519
    //   5230: invokestatic 2427	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5233: istore 6
    //   5235: iload 6
    //   5237: iconst_m1
    //   5238: if_icmpne +686 -> 5924
    //   5241: aload 4
    //   5243: invokevirtual 2522	com/tencent/mobileqq/webview/swift/WebViewFragment:B	()V
    //   5246: aload_2
    //   5247: ldc_w 2524
    //   5250: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5253: ifeq +15 -> 5268
    //   5256: aload 4
    //   5258: aload_2
    //   5259: ldc_w 2524
    //   5262: invokevirtual 2527	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5265: invokevirtual 2528	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(Z)V
    //   5268: aload_2
    //   5269: ldc_w 2530
    //   5272: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5275: ifeq +27 -> 5302
    //   5278: aload_2
    //   5279: ldc_w 2530
    //   5282: invokevirtual 2527	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5285: ifeq +699 -> 5984
    //   5288: aload 4
    //   5290: aload 4
    //   5292: invokevirtual 2531	com/tencent/mobileqq/webview/swift/WebViewFragment:a	()J
    //   5295: ldc2_w 2532
    //   5298: land
    //   5299: invokevirtual 2535	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(J)V
    //   5302: aload_2
    //   5303: ldc_w 2537
    //   5306: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5309: ifeq +21 -> 5330
    //   5312: aload_2
    //   5313: ldc_w 2537
    //   5316: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5319: astore 4
    //   5321: aload_3
    //   5322: checkcast 1022	com/tencent/mobileqq/activity/QQBrowserActivity
    //   5325: aload 4
    //   5327: invokevirtual 2539	com/tencent/mobileqq/activity/QQBrowserActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   5330: aload_2
    //   5331: ldc_w 2541
    //   5334: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5337: ifeq +49 -> 5386
    //   5340: aload_2
    //   5341: ldc_w 2541
    //   5344: invokevirtual 1130	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   5347: istore 12
    //   5349: sipush 800
    //   5352: istore 6
    //   5354: aload_2
    //   5355: ldc_w 2543
    //   5358: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5361: ifeq +17 -> 5378
    //   5364: aload_2
    //   5365: ldc_w 2543
    //   5368: invokevirtual 2547	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   5371: ldc2_w 2548
    //   5374: dmul
    //   5375: d2i
    //   5376: istore 6
    //   5378: aload_0
    //   5379: iload 12
    //   5381: iload 6
    //   5383: invokevirtual 2551	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZI)V
    //   5386: aload_2
    //   5387: ldc_w 2553
    //   5390: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5393: ifeq +44 -> 5437
    //   5396: aload_2
    //   5397: ldc_w 2553
    //   5400: invokevirtual 977	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5403: istore 6
    //   5405: aload_1
    //   5406: ifnull +31 -> 5437
    //   5409: iload 6
    //   5411: ifne +590 -> 6001
    //   5414: aload_1
    //   5415: getfield 1193	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5418: iconst_0
    //   5419: putfield 2554	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:jdField_c_of_type_Boolean	Z
    //   5422: aload_1
    //   5423: getfield 1193	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5426: iconst_1
    //   5427: invokestatic 985	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5430: putfield 2557	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:a	Ljava/lang/Boolean;
    //   5433: aload_1
    //   5434: invokevirtual 2559	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:f	()V
    //   5437: aload_2
    //   5438: ldc_w 2561
    //   5441: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5444: ifeq +23 -> 5467
    //   5447: aload_2
    //   5448: ldc_w 2561
    //   5451: iconst_0
    //   5452: invokevirtual 956	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5455: istore 12
    //   5457: aload_1
    //   5458: ifnull +9 -> 5467
    //   5461: aload_1
    //   5462: iload 12
    //   5464: invokevirtual 2562	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:b	(Z)V
    //   5467: aload_2
    //   5468: ldc_w 2564
    //   5471: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5474: ifeq -5290 -> 184
    //   5477: aload_2
    //   5478: ldc_w 2564
    //   5481: iconst_0
    //   5482: invokevirtual 956	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5485: istore 12
    //   5487: aload_1
    //   5488: ifnull -5304 -> 184
    //   5491: aload_1
    //   5492: getfield 2515	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   5495: getfield 2565	com/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5498: getfield 2567	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:j	Z
    //   5501: iload 12
    //   5503: if_icmpeq -5319 -> 184
    //   5506: aload_1
    //   5507: iload 12
    //   5509: invokevirtual 2569	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:c	(Z)V
    //   5512: goto -5328 -> 184
    //   5515: astore_1
    //   5516: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5519: ifeq -5335 -> 184
    //   5522: ldc 196
    //   5524: iconst_4
    //   5525: new 391	java/lang/StringBuilder
    //   5528: dup
    //   5529: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   5532: ldc_w 2571
    //   5535: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5538: aload_1
    //   5539: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5542: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5545: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5548: goto -5364 -> 184
    //   5551: aload 5
    //   5553: bipush 8
    //   5555: invokevirtual 686	android/widget/ImageView:setVisibility	(I)V
    //   5558: aload_1
    //   5559: iconst_0
    //   5560: invokevirtual 2453	android/widget/TextView:setVisibility	(I)V
    //   5563: goto -845 -> 4718
    //   5566: astore_1
    //   5567: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5570: ifeq -5386 -> 184
    //   5573: ldc 196
    //   5575: iconst_4
    //   5576: new 391	java/lang/StringBuilder
    //   5579: dup
    //   5580: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   5583: ldc_w 2571
    //   5586: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5589: aload_1
    //   5590: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5593: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5596: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5599: goto -5415 -> 184
    //   5602: aload_1
    //   5603: bipush 8
    //   5605: invokevirtual 2453	android/widget/TextView:setVisibility	(I)V
    //   5608: aload 5
    //   5610: bipush 8
    //   5612: invokevirtual 686	android/widget/ImageView:setVisibility	(I)V
    //   5615: goto -897 -> 4718
    //   5618: aload_0
    //   5619: iconst_2
    //   5620: invokespecial 1188	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   5623: checkcast 1190	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   5626: astore 14
    //   5628: aload 14
    //   5630: ifnull -627 -> 5003
    //   5633: aload 14
    //   5635: getfield 2574	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar	Lcom/tencent/mobileqq/widget/WebViewProgressBar;
    //   5638: astore_1
    //   5639: goto -636 -> 5003
    //   5642: iconst_0
    //   5643: invokestatic 2578	com/tencent/mobileqq/theme/ThemeUtil:isDefaultOrDIYTheme	(Z)Z
    //   5646: ifeq +26 -> 5672
    //   5649: aload 4
    //   5651: getfield 2510	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5654: ldc_w 2579
    //   5657: invokevirtual 2502	android/view/View:setBackgroundResource	(I)V
    //   5660: aload 4
    //   5662: getfield 2510	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5665: iconst_0
    //   5666: invokevirtual 632	android/view/View:setVisibility	(I)V
    //   5669: goto -578 -> 5091
    //   5672: aload 4
    //   5674: getfield 2510	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5677: invokestatic 510	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5680: invokevirtual 2580	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   5683: ldc_w 2581
    //   5686: invokevirtual 1699	android/content/res/Resources:getColor	(I)I
    //   5689: invokevirtual 2430	android/view/View:setBackgroundColor	(I)V
    //   5692: goto -32 -> 5660
    //   5695: aload 5
    //   5697: iconst_0
    //   5698: invokevirtual 2502	android/view/View:setBackgroundResource	(I)V
    //   5701: ldc_w 1273
    //   5704: istore 6
    //   5706: aload_2
    //   5707: ldc_w 2583
    //   5710: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5713: ifeq +15 -> 5728
    //   5716: aload_2
    //   5717: ldc_w 2583
    //   5720: invokestatic 2427	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5723: bipush 24
    //   5725: ishl
    //   5726: istore 6
    //   5728: iload 7
    //   5730: iload 6
    //   5732: ior
    //   5733: istore 8
    //   5735: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5738: ifeq +61 -> 5799
    //   5741: ldc 196
    //   5743: iconst_2
    //   5744: new 391	java/lang/StringBuilder
    //   5747: dup
    //   5748: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   5751: ldc_w 2585
    //   5754: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5757: iload 6
    //   5759: invokestatic 2435	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5762: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5765: ldc_w 2587
    //   5768: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5771: iload 7
    //   5773: invokestatic 2435	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5776: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5779: ldc_w 2589
    //   5782: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5785: iload 8
    //   5787: invokestatic 2435	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5790: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5793: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5796: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5799: aload 5
    //   5801: iload 8
    //   5803: invokevirtual 2430	android/view/View:setBackgroundColor	(I)V
    //   5806: aload_1
    //   5807: ifnull +13 -> 5820
    //   5810: aload_1
    //   5811: ldc_w 1273
    //   5814: iload 7
    //   5816: ior
    //   5817: invokevirtual 2592	com/tencent/mobileqq/widget/WebViewProgressBar:setCustomColor	(I)V
    //   5820: aload 4
    //   5822: invokevirtual 2512	com/tencent/mobileqq/webview/swift/WebViewFragment:d	()Z
    //   5825: ifeq +28 -> 5853
    //   5828: aload 4
    //   5830: getfield 2510	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5833: ifnonnull +60 -> 5893
    //   5836: aload 4
    //   5838: iconst_1
    //   5839: invokevirtual 2594	com/tencent/mobileqq/webview/swift/WebViewFragment:j	(Z)V
    //   5842: aload 4
    //   5844: iconst_1
    //   5845: invokevirtual 2596	com/tencent/mobileqq/webview/swift/WebViewFragment:k	(Z)V
    //   5848: aload 4
    //   5850: invokevirtual 2599	com/tencent/mobileqq/webview/swift/WebViewFragment:z	()V
    //   5853: aload 4
    //   5855: getfield 2510	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5858: ifnull -761 -> 5097
    //   5861: aload_2
    //   5862: ldc_w 2601
    //   5865: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5868: ifeq +37 -> 5905
    //   5871: aload_2
    //   5872: ldc_w 2601
    //   5875: invokestatic 2427	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5878: istore 6
    //   5880: aload 4
    //   5882: getfield 2510	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5885: iload 6
    //   5887: invokevirtual 2430	android/view/View:setBackgroundColor	(I)V
    //   5890: goto -793 -> 5097
    //   5893: aload 4
    //   5895: getfield 2510	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5898: iconst_0
    //   5899: invokevirtual 632	android/view/View:setVisibility	(I)V
    //   5902: goto -49 -> 5853
    //   5905: aload 4
    //   5907: getfield 2510	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5910: iload 8
    //   5912: invokevirtual 2430	android/view/View:setBackgroundColor	(I)V
    //   5915: aload 4
    //   5917: iconst_1
    //   5918: invokevirtual 2514	com/tencent/mobileqq/webview/swift/WebViewFragment:i	(Z)V
    //   5921: goto -824 -> 5097
    //   5924: aload 4
    //   5926: ldc_w 1273
    //   5929: iload 6
    //   5931: ior
    //   5932: invokevirtual 2603	com/tencent/mobileqq/webview/swift/WebViewFragment:c	(I)V
    //   5935: aload_2
    //   5936: ldc_w 2605
    //   5939: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5942: ifeq +9505 -> 15447
    //   5945: aload_2
    //   5946: ldc_w 2605
    //   5949: invokestatic 2427	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5952: istore 7
    //   5954: iload 7
    //   5956: iconst_m1
    //   5957: if_icmpeq +9490 -> 15447
    //   5960: ldc_w 1273
    //   5963: iload 7
    //   5965: ior
    //   5966: istore 6
    //   5968: aload 4
    //   5970: iload 6
    //   5972: invokevirtual 2607	com/tencent/mobileqq/webview/swift/WebViewFragment:d	(I)V
    //   5975: aload_0
    //   5976: iload 6
    //   5978: invokevirtual 2609	com/tencent/mobileqq/jsp/UiApiPlugin:a	(I)V
    //   5981: goto -735 -> 5246
    //   5984: aload 4
    //   5986: aload 4
    //   5988: invokevirtual 2531	com/tencent/mobileqq/webview/swift/WebViewFragment:a	()J
    //   5991: ldc2_w 1960
    //   5994: lor
    //   5995: invokevirtual 2535	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(J)V
    //   5998: goto -696 -> 5302
    //   6001: iload 6
    //   6003: iconst_1
    //   6004: if_icmpne -571 -> 5433
    //   6007: aload_1
    //   6008: getfield 1193	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   6011: iconst_1
    //   6012: putfield 2554	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:jdField_c_of_type_Boolean	Z
    //   6015: aload_1
    //   6016: getfield 1193	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   6019: iconst_0
    //   6020: invokestatic 985	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6023: putfield 2557	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:a	Ljava/lang/Boolean;
    //   6026: goto -593 -> 5433
    //   6029: ldc_w 2611
    //   6032: aload 4
    //   6034: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6037: ifeq +484 -> 6521
    //   6040: aload 5
    //   6042: arraylength
    //   6043: iconst_1
    //   6044: if_icmpgt +477 -> 6521
    //   6047: new 110	org/json/JSONObject
    //   6050: dup
    //   6051: aload 5
    //   6053: iconst_0
    //   6054: aaload
    //   6055: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6058: astore_1
    //   6059: aload_0
    //   6060: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6063: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   6066: instanceof 1022
    //   6069: ifne +5 -> 6074
    //   6072: iconst_1
    //   6073: ireturn
    //   6074: new 2613	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo
    //   6077: dup
    //   6078: invokespecial 2614	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:<init>	()V
    //   6081: astore_2
    //   6082: aload_1
    //   6083: ldc_w 2616
    //   6086: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6089: ifeq +18 -> 6107
    //   6092: aload_2
    //   6093: aload_1
    //   6094: ldc_w 2616
    //   6097: invokestatic 2427	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6100: ldc_w 1273
    //   6103: ior
    //   6104: putfield 2617	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_Int	I
    //   6107: aload_1
    //   6108: ldc_w 1174
    //   6111: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6114: ifeq +14 -> 6128
    //   6117: aload_2
    //   6118: aload_1
    //   6119: ldc_w 1174
    //   6122: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6125: putfield 2618	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6128: aload_1
    //   6129: ldc_w 2620
    //   6132: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6135: ifeq +176 -> 6311
    //   6138: aload_2
    //   6139: new 1245	java/util/ArrayList
    //   6142: dup
    //   6143: invokespecial 1567	java/util/ArrayList:<init>	()V
    //   6146: putfield 2623	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6149: aload_1
    //   6150: ldc_w 2620
    //   6153: invokevirtual 847	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6156: astore_3
    //   6157: aload_3
    //   6158: invokevirtual 862	org/json/JSONArray:length	()I
    //   6161: istore 7
    //   6163: iconst_0
    //   6164: istore 6
    //   6166: iload 6
    //   6168: iload 7
    //   6170: if_icmpge +141 -> 6311
    //   6173: aload_3
    //   6174: iload 6
    //   6176: invokevirtual 2626	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6179: astore 4
    //   6181: new 2628	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton
    //   6184: dup
    //   6185: invokespecial 2629	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:<init>	()V
    //   6188: astore 5
    //   6190: aload 4
    //   6192: ldc_w 1227
    //   6195: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6198: ifeq +16 -> 6214
    //   6201: aload 5
    //   6203: aload 4
    //   6205: ldc_w 1227
    //   6208: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6211: putfield 2630	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6214: aload 4
    //   6216: ldc_w 1618
    //   6219: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6222: ifeq +16 -> 6238
    //   6225: aload 5
    //   6227: aload 4
    //   6229: ldc_w 1618
    //   6232: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6235: putfield 2631	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_a_of_type_Int	I
    //   6238: aload 4
    //   6240: ldc_w 2633
    //   6243: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6246: ifeq +16 -> 6262
    //   6249: aload 5
    //   6251: aload 4
    //   6253: ldc_w 2633
    //   6256: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6259: putfield 2634	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6262: aload 4
    //   6264: ldc_w 1229
    //   6267: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6270: ifeq +20 -> 6290
    //   6273: aload 5
    //   6275: aload 4
    //   6277: ldc_w 1229
    //   6280: invokestatic 2427	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6283: ldc_w 1273
    //   6286: ior
    //   6287: putfield 2635	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_b_of_type_Int	I
    //   6290: aload_2
    //   6291: getfield 2623	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6294: aload 5
    //   6296: invokeinterface 1663 2 0
    //   6301: pop
    //   6302: iload 6
    //   6304: iconst_1
    //   6305: iadd
    //   6306: istore 6
    //   6308: goto -142 -> 6166
    //   6311: aload_1
    //   6312: ldc_w 2637
    //   6315: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6318: ifeq +78 -> 6396
    //   6321: aload_2
    //   6322: new 1245	java/util/ArrayList
    //   6325: dup
    //   6326: invokespecial 1567	java/util/ArrayList:<init>	()V
    //   6329: putfield 2639	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:b	Ljava/util/List;
    //   6332: aload_1
    //   6333: ldc_w 2637
    //   6336: invokevirtual 847	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6339: astore_1
    //   6340: aload_1
    //   6341: invokevirtual 862	org/json/JSONArray:length	()I
    //   6344: istore 7
    //   6346: iconst_0
    //   6347: istore 6
    //   6349: iload 6
    //   6351: iload 7
    //   6353: if_icmpge +43 -> 6396
    //   6356: aload_1
    //   6357: iload 6
    //   6359: invokevirtual 2626	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6362: ldc 157
    //   6364: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6367: ifeq +9091 -> 15458
    //   6370: aload_1
    //   6371: iload 6
    //   6373: invokevirtual 2626	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6376: ldc 157
    //   6378: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6381: astore_3
    //   6382: aload_2
    //   6383: getfield 2639	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:b	Ljava/util/List;
    //   6386: aload_3
    //   6387: invokeinterface 1663 2 0
    //   6392: pop
    //   6393: goto +9065 -> 15458
    //   6396: aload_0
    //   6397: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6400: invokevirtual 934	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   6403: astore_1
    //   6404: aload_1
    //   6405: ifnull +8976 -> 15381
    //   6408: aload_1
    //   6409: invokevirtual 2642	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   6412: astore_1
    //   6413: aload_1
    //   6414: ifnull +8967 -> 15381
    //   6417: aload_1
    //   6418: ldc_w 2644
    //   6421: invokevirtual 2649	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   6424: astore_1
    //   6425: aload_1
    //   6426: ifnull +8955 -> 15381
    //   6429: aload_1
    //   6430: instanceof 171
    //   6433: ifeq +8948 -> 15381
    //   6436: aload_1
    //   6437: checkcast 171	com/tencent/biz/webviewplugin/PubAccountUIPlugin
    //   6440: astore_1
    //   6441: aload_1
    //   6442: ifnull -6258 -> 184
    //   6445: aload_1
    //   6446: aload_2
    //   6447: invokevirtual 2652	com/tencent/biz/webviewplugin/PubAccountUIPlugin:a	(Lcom/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo;)V
    //   6450: aload_2
    //   6451: getfield 2618	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6454: ifnull -6270 -> 184
    //   6457: aload_1
    //   6458: invokestatic 2654	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lcom/tencent/biz/webviewplugin/PubAccountUIPlugin;)Ljava/lang/String;
    //   6461: astore_1
    //   6462: aload_1
    //   6463: ifnull -6279 -> 184
    //   6466: aload_0
    //   6467: aload_2
    //   6468: getfield 2618	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6471: iconst_1
    //   6472: anewarray 325	java/lang/String
    //   6475: dup
    //   6476: iconst_0
    //   6477: aload_1
    //   6478: aastore
    //   6479: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   6482: goto -6298 -> 184
    //   6485: astore_1
    //   6486: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6489: ifeq -6305 -> 184
    //   6492: ldc 196
    //   6494: iconst_4
    //   6495: new 391	java/lang/StringBuilder
    //   6498: dup
    //   6499: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   6502: ldc_w 2656
    //   6505: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6508: aload_1
    //   6509: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6512: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6515: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6518: goto -6334 -> 184
    //   6521: ldc_w 2658
    //   6524: aload 4
    //   6526: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6529: ifeq +176 -> 6705
    //   6532: aload 5
    //   6534: arraylength
    //   6535: iconst_1
    //   6536: if_icmpgt +169 -> 6705
    //   6539: new 110	org/json/JSONObject
    //   6542: dup
    //   6543: aload 5
    //   6545: iconst_0
    //   6546: aaload
    //   6547: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6550: astore_1
    //   6551: aload_0
    //   6552: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6555: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   6558: instanceof 1022
    //   6561: ifne +5 -> 6566
    //   6564: iconst_1
    //   6565: ireturn
    //   6566: aload_1
    //   6567: ldc_w 2659
    //   6570: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6573: ifeq -6389 -> 184
    //   6576: aload_1
    //   6577: ldc_w 2659
    //   6580: invokevirtual 1130	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   6583: istore 12
    //   6585: aload_1
    //   6586: ldc_w 2661
    //   6589: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6592: ifeq +8783 -> 15375
    //   6595: aload_1
    //   6596: ldc_w 2661
    //   6599: invokevirtual 2547	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   6602: ldc2_w 2548
    //   6605: dmul
    //   6606: d2i
    //   6607: istore 6
    //   6609: aload_0
    //   6610: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6613: invokevirtual 934	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   6616: astore_1
    //   6617: aload_1
    //   6618: ifnull +8752 -> 15370
    //   6621: aload_1
    //   6622: invokevirtual 2642	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   6625: astore_1
    //   6626: aload_1
    //   6627: ifnull +8743 -> 15370
    //   6630: aload_1
    //   6631: ldc_w 2644
    //   6634: invokevirtual 2649	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   6637: astore_1
    //   6638: aload_1
    //   6639: ifnull +8731 -> 15370
    //   6642: aload_1
    //   6643: instanceof 171
    //   6646: ifeq +8724 -> 15370
    //   6649: aload_1
    //   6650: checkcast 171	com/tencent/biz/webviewplugin/PubAccountUIPlugin
    //   6653: astore_1
    //   6654: aload_1
    //   6655: ifnull -6471 -> 184
    //   6658: aload_1
    //   6659: iload 12
    //   6661: iload 6
    //   6663: invokevirtual 2662	com/tencent/biz/webviewplugin/PubAccountUIPlugin:a	(ZI)V
    //   6666: goto -6482 -> 184
    //   6669: astore_1
    //   6670: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6673: ifeq -6489 -> 184
    //   6676: ldc 196
    //   6678: iconst_4
    //   6679: new 391	java/lang/StringBuilder
    //   6682: dup
    //   6683: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   6686: ldc_w 2664
    //   6689: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6692: aload_1
    //   6693: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6696: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6699: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6702: goto -6518 -> 184
    //   6705: ldc_w 2666
    //   6708: aload 4
    //   6710: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6713: ifeq +226 -> 6939
    //   6716: aload 5
    //   6718: arraylength
    //   6719: iconst_1
    //   6720: if_icmpgt +219 -> 6939
    //   6723: new 110	org/json/JSONObject
    //   6726: dup
    //   6727: aload 5
    //   6729: iconst_0
    //   6730: aaload
    //   6731: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6734: astore_1
    //   6735: aload_0
    //   6736: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6739: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   6742: instanceof 1022
    //   6745: ifne +5 -> 6750
    //   6748: iconst_1
    //   6749: ireturn
    //   6750: new 2628	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton
    //   6753: dup
    //   6754: invokespecial 2629	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:<init>	()V
    //   6757: astore_2
    //   6758: aload_1
    //   6759: ldc_w 1227
    //   6762: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6765: ifeq +14 -> 6779
    //   6768: aload_2
    //   6769: aload_1
    //   6770: ldc_w 1227
    //   6773: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6776: putfield 2630	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6779: aload_1
    //   6780: ldc_w 1618
    //   6783: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6786: ifeq +14 -> 6800
    //   6789: aload_2
    //   6790: aload_1
    //   6791: ldc_w 1618
    //   6794: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6797: putfield 2631	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_a_of_type_Int	I
    //   6800: aload_1
    //   6801: ldc_w 2633
    //   6804: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6807: ifeq +14 -> 6821
    //   6810: aload_2
    //   6811: aload_1
    //   6812: ldc_w 2633
    //   6815: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6818: putfield 2634	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6821: aload_1
    //   6822: ldc_w 1229
    //   6825: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6828: ifeq +18 -> 6846
    //   6831: aload_2
    //   6832: aload_1
    //   6833: ldc_w 1229
    //   6836: invokestatic 2427	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6839: ldc_w 1273
    //   6842: ior
    //   6843: putfield 2635	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_b_of_type_Int	I
    //   6846: aload_0
    //   6847: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6850: invokevirtual 934	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   6853: astore_1
    //   6854: aload_1
    //   6855: ifnull +8510 -> 15365
    //   6858: aload_1
    //   6859: invokevirtual 2642	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   6862: astore_1
    //   6863: aload_1
    //   6864: ifnull +8501 -> 15365
    //   6867: aload_1
    //   6868: ldc_w 2644
    //   6871: invokevirtual 2649	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   6874: astore_1
    //   6875: aload_1
    //   6876: ifnull +8489 -> 15365
    //   6879: aload_1
    //   6880: instanceof 171
    //   6883: ifeq +8482 -> 15365
    //   6886: aload_1
    //   6887: checkcast 171	com/tencent/biz/webviewplugin/PubAccountUIPlugin
    //   6890: astore_1
    //   6891: aload_1
    //   6892: ifnull -6708 -> 184
    //   6895: aload_1
    //   6896: aload_2
    //   6897: invokevirtual 2669	com/tencent/biz/webviewplugin/PubAccountUIPlugin:a	(Lcom/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton;)V
    //   6900: goto -6716 -> 184
    //   6903: astore_1
    //   6904: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6907: ifeq -6723 -> 184
    //   6910: ldc 196
    //   6912: iconst_4
    //   6913: new 391	java/lang/StringBuilder
    //   6916: dup
    //   6917: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   6920: ldc_w 2671
    //   6923: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6926: aload_1
    //   6927: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6930: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6933: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6936: goto -6752 -> 184
    //   6939: ldc_w 2673
    //   6942: aload 4
    //   6944: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6947: ifeq +110 -> 7057
    //   6950: aload 5
    //   6952: arraylength
    //   6953: iconst_1
    //   6954: if_icmpgt +103 -> 7057
    //   6957: aload 5
    //   6959: arraylength
    //   6960: iconst_1
    //   6961: if_icmpne +22 -> 6983
    //   6964: new 110	org/json/JSONObject
    //   6967: dup
    //   6968: aload 5
    //   6970: iconst_0
    //   6971: aaload
    //   6972: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6975: ldc_w 2675
    //   6978: iconst_0
    //   6979: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   6982: pop
    //   6983: aload_0
    //   6984: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6987: aload_0
    //   6988: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6991: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   6994: invokevirtual 618	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   6997: astore_1
    //   6998: aload_1
    //   6999: ifnull -6815 -> 184
    //   7002: aload_1
    //   7003: instanceof 2677
    //   7006: ifeq -6822 -> 184
    //   7009: aload_1
    //   7010: checkcast 2677	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebUiMethodInterface
    //   7013: invokeinterface 2679 1 0
    //   7018: goto -6834 -> 184
    //   7021: astore_1
    //   7022: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7025: ifeq -6841 -> 184
    //   7028: ldc 196
    //   7030: iconst_4
    //   7031: new 391	java/lang/StringBuilder
    //   7034: dup
    //   7035: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   7038: ldc_w 2681
    //   7041: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7044: aload_1
    //   7045: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7048: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7051: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7054: goto -6870 -> 184
    //   7057: ldc_w 2683
    //   7060: aload 4
    //   7062: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7065: ifeq +195 -> 7260
    //   7068: aload 5
    //   7070: arraylength
    //   7071: iconst_1
    //   7072: if_icmpne +188 -> 7260
    //   7075: new 110	org/json/JSONObject
    //   7078: dup
    //   7079: aload 5
    //   7081: iconst_0
    //   7082: aaload
    //   7083: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7086: astore_1
    //   7087: aload_1
    //   7088: ldc_w 1499
    //   7091: iconst_0
    //   7092: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7095: istore 6
    //   7097: aload_1
    //   7098: ldc_w 1506
    //   7101: iconst_0
    //   7102: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7105: istore 7
    //   7107: aload_1
    //   7108: ldc_w 1501
    //   7111: iconst_0
    //   7112: invokevirtual 956	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   7115: istore 12
    //   7117: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7120: ifeq +48 -> 7168
    //   7123: ldc 196
    //   7125: iconst_2
    //   7126: new 391	java/lang/StringBuilder
    //   7129: dup
    //   7130: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   7133: ldc_w 2685
    //   7136: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7139: aload_1
    //   7140: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7143: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7146: ldc_w 2687
    //   7149: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7152: aload_0
    //   7153: getfield 98	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   7156: invokevirtual 769	java/lang/Object:toString	()Ljava/lang/String;
    //   7159: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7162: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7165: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7168: invokestatic 287	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7171: new 126	android/content/Intent
    //   7174: dup
    //   7175: ldc_w 1717
    //   7178: invokespecial 131	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   7181: ldc_w 1499
    //   7184: iload 6
    //   7186: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7189: ldc_w 1501
    //   7192: iload 12
    //   7194: invokevirtual 476	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7197: ldc_w 1506
    //   7200: iload 7
    //   7202: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7205: ldc_w 1508
    //   7208: aload_0
    //   7209: getfield 87	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Int	I
    //   7212: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7215: ldc_w 1719
    //   7218: invokevirtual 2692	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   7221: goto -7037 -> 184
    //   7224: astore_1
    //   7225: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7228: ifeq -7044 -> 184
    //   7231: ldc 196
    //   7233: iconst_4
    //   7234: new 391	java/lang/StringBuilder
    //   7237: dup
    //   7238: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   7241: ldc_w 2694
    //   7244: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7247: aload_1
    //   7248: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7251: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7254: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7257: goto -7073 -> 184
    //   7260: ldc_w 2696
    //   7263: aload 4
    //   7265: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7268: ifeq +258 -> 7526
    //   7271: aload 5
    //   7273: arraylength
    //   7274: iconst_1
    //   7275: if_icmpne +251 -> 7526
    //   7278: aload_0
    //   7279: aconst_null
    //   7280: putfield 2698	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   7283: new 110	org/json/JSONObject
    //   7286: dup
    //   7287: aload 5
    //   7289: iconst_0
    //   7290: aaload
    //   7291: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7294: astore_3
    //   7295: aload_3
    //   7296: ldc_w 1131
    //   7299: invokevirtual 2035	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   7302: lstore 10
    //   7304: aload_3
    //   7305: ldc_w 2700
    //   7308: bipush 13
    //   7310: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7313: istore 6
    //   7315: aload_3
    //   7316: ldc_w 2702
    //   7319: iconst_0
    //   7320: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7323: istore 7
    //   7325: aload_3
    //   7326: ldc_w 1174
    //   7329: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7332: astore_1
    //   7333: aload_0
    //   7334: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7337: invokevirtual 894	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   7340: astore_2
    //   7341: aload_2
    //   7342: ifnull +10 -> 7352
    //   7345: aload_2
    //   7346: invokevirtual 2705	com/tencent/common/app/AppInterface:isLogin	()Z
    //   7349: ifne +20 -> 7369
    //   7352: aload_0
    //   7353: aload_1
    //   7354: iconst_1
    //   7355: anewarray 325	java/lang/String
    //   7358: dup
    //   7359: iconst_0
    //   7360: ldc_w 2707
    //   7363: aastore
    //   7364: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7367: iconst_1
    //   7368: ireturn
    //   7369: aload_3
    //   7370: ldc_w 2080
    //   7373: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7376: astore_3
    //   7377: aload_3
    //   7378: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7381: ifne +31 -> 7412
    //   7384: aload_3
    //   7385: aload_2
    //   7386: invokevirtual 897	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   7389: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7392: ifne +20 -> 7412
    //   7395: aload_0
    //   7396: aload_1
    //   7397: iconst_1
    //   7398: anewarray 325	java/lang/String
    //   7401: dup
    //   7402: iconst_0
    //   7403: ldc_w 2709
    //   7406: aastore
    //   7407: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7410: iconst_1
    //   7411: ireturn
    //   7412: aload_0
    //   7413: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7416: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   7419: astore_2
    //   7420: aload_2
    //   7421: ifnull -7237 -> 184
    //   7424: aload_0
    //   7425: aload_1
    //   7426: putfield 2698	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   7429: new 126	android/content/Intent
    //   7432: dup
    //   7433: aload_2
    //   7434: ldc_w 2711
    //   7437: invokespecial 733	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   7440: astore_1
    //   7441: aload_1
    //   7442: ldc_w 798
    //   7445: bipush 16
    //   7447: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7450: pop
    //   7451: aload_1
    //   7452: ldc_w 2700
    //   7455: iload 6
    //   7457: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7460: pop
    //   7461: aload_1
    //   7462: ldc_w 1131
    //   7465: lload 10
    //   7467: invokevirtual 1140	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   7470: pop
    //   7471: aload_1
    //   7472: ldc_w 2702
    //   7475: iload 7
    //   7477: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7480: pop
    //   7481: aload_0
    //   7482: aload_1
    //   7483: iconst_5
    //   7484: invokevirtual 1385	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   7487: goto -7303 -> 184
    //   7490: astore_1
    //   7491: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7494: ifeq -7310 -> 184
    //   7497: ldc 196
    //   7499: iconst_4
    //   7500: new 391	java/lang/StringBuilder
    //   7503: dup
    //   7504: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   7507: ldc_w 2713
    //   7510: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7513: aload_1
    //   7514: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7517: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7520: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7523: goto -7339 -> 184
    //   7526: ldc_w 2715
    //   7529: aload 4
    //   7531: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7534: ifeq +269 -> 7803
    //   7537: aload 5
    //   7539: arraylength
    //   7540: iconst_1
    //   7541: if_icmpne +262 -> 7803
    //   7544: aload_0
    //   7545: aconst_null
    //   7546: putfield 2344	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   7549: new 110	org/json/JSONObject
    //   7552: dup
    //   7553: aload 5
    //   7555: iconst_0
    //   7556: aaload
    //   7557: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7560: astore_3
    //   7561: aload_0
    //   7562: aload_3
    //   7563: ldc_w 2080
    //   7566: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7569: putfield 2717	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   7572: aload_3
    //   7573: ldc_w 2719
    //   7576: iconst_0
    //   7577: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7580: istore 6
    //   7582: aload_0
    //   7583: aload_3
    //   7584: ldc_w 2721
    //   7587: iconst_0
    //   7588: invokevirtual 956	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   7591: putfield 2723	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Boolean	Z
    //   7594: aload_3
    //   7595: ldc_w 1174
    //   7598: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7601: astore_1
    //   7602: aload_0
    //   7603: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7606: invokevirtual 894	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   7609: astore_2
    //   7610: aload_2
    //   7611: ifnull +10 -> 7621
    //   7614: aload_2
    //   7615: invokevirtual 2705	com/tencent/common/app/AppInterface:isLogin	()Z
    //   7618: ifne +20 -> 7638
    //   7621: aload_0
    //   7622: aload_1
    //   7623: iconst_1
    //   7624: anewarray 325	java/lang/String
    //   7627: dup
    //   7628: iconst_0
    //   7629: ldc_w 2725
    //   7632: aastore
    //   7633: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7636: iconst_1
    //   7637: ireturn
    //   7638: aload_0
    //   7639: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7642: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   7645: astore_2
    //   7646: aload_2
    //   7647: ifnull -7463 -> 184
    //   7650: iload 6
    //   7652: ifne -7468 -> 184
    //   7655: aload_3
    //   7656: ldc_w 835
    //   7659: aload_2
    //   7660: ldc_w 2726
    //   7663: invokevirtual 1955	android/app/Activity:getString	(I)Ljava/lang/String;
    //   7666: invokevirtual 2097	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7669: astore_3
    //   7670: aload_0
    //   7671: aload_1
    //   7672: putfield 2344	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   7675: aload_0
    //   7676: getfield 2723	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Boolean	Z
    //   7679: ifeq +101 -> 7780
    //   7682: new 126	android/content/Intent
    //   7685: dup
    //   7686: aload_2
    //   7687: ldc_w 2728
    //   7690: invokespecial 733	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   7693: astore_1
    //   7694: aload_1
    //   7695: ldc_w 2730
    //   7698: iconst_1
    //   7699: invokevirtual 476	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7702: pop
    //   7703: aload_1
    //   7704: ldc_w 2732
    //   7707: aload_0
    //   7708: getfield 2717	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   7711: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7714: pop
    //   7715: aload_1
    //   7716: ldc_w 2734
    //   7719: aload_3
    //   7720: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7723: pop
    //   7724: aload_0
    //   7725: aload_1
    //   7726: bipush 7
    //   7728: invokevirtual 1385	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   7731: aload_2
    //   7732: ldc_w 2735
    //   7735: ldc_w 2736
    //   7738: invokevirtual 1037	android/app/Activity:overridePendingTransition	(II)V
    //   7741: goto -7557 -> 184
    //   7744: astore_1
    //   7745: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7748: ifeq -7564 -> 184
    //   7751: ldc 196
    //   7753: iconst_4
    //   7754: new 391	java/lang/StringBuilder
    //   7757: dup
    //   7758: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   7761: ldc_w 2738
    //   7764: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7767: aload_1
    //   7768: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7771: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7774: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7777: goto -7593 -> 184
    //   7780: aload_2
    //   7781: aload_0
    //   7782: getfield 2717	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   7785: bipush 14
    //   7787: invokestatic 2047	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/Intent;
    //   7790: astore_1
    //   7791: aload_1
    //   7792: ldc_w 2740
    //   7795: aload_3
    //   7796: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7799: pop
    //   7800: goto -76 -> 7724
    //   7803: ldc_w 2742
    //   7806: aload 4
    //   7808: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7811: ifeq +120 -> 7931
    //   7814: aload 5
    //   7816: arraylength
    //   7817: iconst_1
    //   7818: if_icmpne +113 -> 7931
    //   7821: new 110	org/json/JSONObject
    //   7824: dup
    //   7825: aload 5
    //   7827: iconst_0
    //   7828: aaload
    //   7829: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7832: astore_1
    //   7833: aload_1
    //   7834: ldc_w 2744
    //   7837: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7840: ifeq -7656 -> 184
    //   7843: aload_1
    //   7844: ldc_w 2744
    //   7847: invokevirtual 2527	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   7850: istore 12
    //   7852: aload_0
    //   7853: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7856: invokevirtual 934	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7859: invokevirtual 2745	com/tencent/biz/pubaccount/CustomWebView:getParent	()Landroid/view/ViewParent;
    //   7862: checkcast 629	android/view/View
    //   7865: astore_1
    //   7866: aload_1
    //   7867: instanceof 636
    //   7870: ifne +5 -> 7875
    //   7873: iconst_1
    //   7874: ireturn
    //   7875: aload_0
    //   7876: aload_1
    //   7877: checkcast 636	com/tencent/biz/ui/RefreshView
    //   7880: putfield 634	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   7883: aload_0
    //   7884: getfield 634	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   7887: iload 12
    //   7889: invokevirtual 2746	com/tencent/biz/ui/RefreshView:a	(Z)V
    //   7892: goto -7708 -> 184
    //   7895: astore_1
    //   7896: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7899: ifeq -7715 -> 184
    //   7902: ldc 196
    //   7904: iconst_4
    //   7905: new 391	java/lang/StringBuilder
    //   7908: dup
    //   7909: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   7912: ldc_w 2748
    //   7915: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7918: aload_1
    //   7919: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7922: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7925: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7928: goto -7744 -> 184
    //   7931: ldc_w 2750
    //   7934: aload 4
    //   7936: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7939: ifeq +443 -> 8382
    //   7942: aload 5
    //   7944: arraylength
    //   7945: iconst_1
    //   7946: if_icmpne +436 -> 8382
    //   7949: aconst_null
    //   7950: astore 4
    //   7952: aconst_null
    //   7953: astore_3
    //   7954: iconst_1
    //   7955: istore 7
    //   7957: aload_3
    //   7958: astore_2
    //   7959: aload 4
    //   7961: astore_1
    //   7962: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7965: ifeq +37 -> 8002
    //   7968: aload_3
    //   7969: astore_2
    //   7970: aload 4
    //   7972: astore_1
    //   7973: ldc 196
    //   7975: iconst_1
    //   7976: new 391	java/lang/StringBuilder
    //   7979: dup
    //   7980: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   7983: ldc_w 2752
    //   7986: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7989: aload 5
    //   7991: iconst_0
    //   7992: aaload
    //   7993: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7996: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7999: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8002: aload_3
    //   8003: astore_2
    //   8004: aload 4
    //   8006: astore_1
    //   8007: new 110	org/json/JSONObject
    //   8010: dup
    //   8011: aload 5
    //   8013: iconst_0
    //   8014: aaload
    //   8015: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8018: astore 15
    //   8020: aload_3
    //   8021: astore_2
    //   8022: aload 4
    //   8024: astore_1
    //   8025: aload 15
    //   8027: ldc_w 835
    //   8030: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8033: astore 5
    //   8035: aload_3
    //   8036: astore_2
    //   8037: aload 4
    //   8039: astore_1
    //   8040: aload 15
    //   8042: ldc_w 2633
    //   8045: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8048: astore 14
    //   8050: aload_3
    //   8051: astore_2
    //   8052: aload 4
    //   8054: astore_1
    //   8055: aload 15
    //   8057: ldc_w 1174
    //   8060: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8063: astore_3
    //   8064: iload 7
    //   8066: istore 6
    //   8068: aload_3
    //   8069: astore_2
    //   8070: aload_3
    //   8071: astore_1
    //   8072: aload 5
    //   8074: invokevirtual 2753	java/lang/String:length	()I
    //   8077: ifle +71 -> 8148
    //   8080: aload_3
    //   8081: astore_2
    //   8082: aload_3
    //   8083: astore_1
    //   8084: aload_0
    //   8085: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8088: invokevirtual 766	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   8091: astore 4
    //   8093: aload 4
    //   8095: ifnull +219 -> 8314
    //   8098: aload_3
    //   8099: astore_2
    //   8100: aload_3
    //   8101: astore_1
    //   8102: aload 4
    //   8104: getfield 2754	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   8107: ifnull +207 -> 8314
    //   8110: aload_3
    //   8111: astore_2
    //   8112: aload_3
    //   8113: astore_1
    //   8114: aload 4
    //   8116: getfield 2754	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   8119: getfield 2756	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:B	Z
    //   8122: ifeq +75 -> 8197
    //   8125: aload_3
    //   8126: astore_2
    //   8127: aload_3
    //   8128: astore_1
    //   8129: aload 4
    //   8131: aload 5
    //   8133: iconst_m1
    //   8134: aload 14
    //   8136: ldc_w 2758
    //   8139: invokevirtual 139	java/lang/Class:getName	()Ljava/lang/String;
    //   8142: invokevirtual 2761	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   8145: iconst_0
    //   8146: istore 6
    //   8148: aload_3
    //   8149: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8152: ifne -7968 -> 184
    //   8155: aload_0
    //   8156: aload_3
    //   8157: iconst_1
    //   8158: anewarray 325	java/lang/String
    //   8161: dup
    //   8162: iconst_0
    //   8163: new 391	java/lang/StringBuilder
    //   8166: dup
    //   8167: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   8170: ldc_w 2763
    //   8173: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8176: iload 6
    //   8178: invokevirtual 927	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8181: ldc_w 1225
    //   8184: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8187: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8190: aastore
    //   8191: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8194: goto -8010 -> 184
    //   8197: aload_3
    //   8198: astore_2
    //   8199: aload_3
    //   8200: astore_1
    //   8201: aload 4
    //   8203: getfield 2754	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   8206: getfield 2766	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:A	Z
    //   8209: ifeq -64 -> 8145
    //   8212: aload_3
    //   8213: astore_2
    //   8214: aload_3
    //   8215: astore_1
    //   8216: new 795	android/os/Bundle
    //   8219: dup
    //   8220: invokespecial 796	android/os/Bundle:<init>	()V
    //   8223: astore 14
    //   8225: aload_3
    //   8226: astore_2
    //   8227: aload_3
    //   8228: astore_1
    //   8229: aload 14
    //   8231: ldc_w 2768
    //   8234: aload 5
    //   8236: invokevirtual 808	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   8239: aload_3
    //   8240: astore_2
    //   8241: aload_3
    //   8242: astore_1
    //   8243: aload 4
    //   8245: aload 14
    //   8247: invokevirtual 2770	com/tencent/mobileqq/webview/swift/WebViewFragment:d	(Landroid/os/Bundle;)V
    //   8250: goto -105 -> 8145
    //   8253: astore_3
    //   8254: aload_2
    //   8255: astore_1
    //   8256: ldc 196
    //   8258: iconst_1
    //   8259: ldc_w 2772
    //   8262: aload_3
    //   8263: invokestatic 1836	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8266: aload_2
    //   8267: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8270: ifne -8086 -> 184
    //   8273: aload_0
    //   8274: aload_2
    //   8275: iconst_1
    //   8276: anewarray 325	java/lang/String
    //   8279: dup
    //   8280: iconst_0
    //   8281: new 391	java/lang/StringBuilder
    //   8284: dup
    //   8285: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   8288: ldc_w 2763
    //   8291: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8294: iconst_1
    //   8295: invokevirtual 927	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8298: ldc_w 1225
    //   8301: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8304: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8307: aastore
    //   8308: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8311: goto -8127 -> 184
    //   8314: aload_3
    //   8315: astore_2
    //   8316: aload_3
    //   8317: astore_1
    //   8318: ldc 196
    //   8320: iconst_1
    //   8321: ldc_w 2774
    //   8324: invokestatic 540	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8327: iload 7
    //   8329: istore 6
    //   8331: goto -183 -> 8148
    //   8334: astore_2
    //   8335: aload_1
    //   8336: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8339: ifne +41 -> 8380
    //   8342: aload_0
    //   8343: aload_1
    //   8344: iconst_1
    //   8345: anewarray 325	java/lang/String
    //   8348: dup
    //   8349: iconst_0
    //   8350: new 391	java/lang/StringBuilder
    //   8353: dup
    //   8354: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   8357: ldc_w 2763
    //   8360: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8363: iconst_1
    //   8364: invokevirtual 927	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8367: ldc_w 1225
    //   8370: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8373: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8376: aastore
    //   8377: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8380: aload_2
    //   8381: athrow
    //   8382: ldc_w 1258
    //   8385: aload 4
    //   8387: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8390: ifeq +245 -> 8635
    //   8393: aload 5
    //   8395: arraylength
    //   8396: iconst_1
    //   8397: if_icmpne +238 -> 8635
    //   8400: new 110	org/json/JSONObject
    //   8403: dup
    //   8404: aload 5
    //   8406: iconst_0
    //   8407: aaload
    //   8408: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8411: astore_1
    //   8412: aload_1
    //   8413: ldc_w 2744
    //   8416: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8419: ifeq +105 -> 8524
    //   8422: aload_1
    //   8423: ldc_w 2744
    //   8426: invokevirtual 2527	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   8429: istore 13
    //   8431: iconst_0
    //   8432: istore 12
    //   8434: ldc_w 2776
    //   8437: aload_1
    //   8438: ldc 151
    //   8440: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8443: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8446: ifeq +6 -> 8452
    //   8449: iconst_1
    //   8450: istore 12
    //   8452: iload 13
    //   8454: aload_0
    //   8455: getfield 2778	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_Boolean	Z
    //   8458: if_icmpeq -8274 -> 184
    //   8461: iload 13
    //   8463: ifeq +54 -> 8517
    //   8466: aload_0
    //   8467: iload 12
    //   8469: invokevirtual 2779	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Z)V
    //   8472: aload_0
    //   8473: iload 13
    //   8475: putfield 2778	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_Boolean	Z
    //   8478: goto -8294 -> 184
    //   8481: astore_1
    //   8482: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   8485: ifeq -8301 -> 184
    //   8488: ldc 196
    //   8490: iconst_4
    //   8491: new 391	java/lang/StringBuilder
    //   8494: dup
    //   8495: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   8498: ldc_w 2748
    //   8501: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8504: aload_1
    //   8505: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8508: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8511: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8514: goto -8330 -> 184
    //   8517: aload_0
    //   8518: invokevirtual 2780	com/tencent/mobileqq/jsp/UiApiPlugin:a	()V
    //   8521: goto -49 -> 8472
    //   8524: aload_1
    //   8525: ldc_w 2782
    //   8528: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8531: ifeq -8347 -> 184
    //   8534: aload_0
    //   8535: getfield 1268	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   8538: ifeq -8354 -> 184
    //   8541: aload_0
    //   8542: iconst_0
    //   8543: putfield 1268	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   8546: aload_1
    //   8547: ldc_w 2782
    //   8550: invokevirtual 2527	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   8553: istore 12
    //   8555: invokestatic 287	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8558: invokevirtual 2783	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   8561: astore_2
    //   8562: iload 12
    //   8564: ifeq +44 -> 8608
    //   8567: aload_0
    //   8568: getfield 1272	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiIPullRefreshHeader	Lcom/tencent/biz/ui/IPullRefreshHeader;
    //   8571: iconst_0
    //   8572: aload_1
    //   8573: ldc_w 1227
    //   8576: aload_2
    //   8577: ldc_w 2784
    //   8580: invokevirtual 2785	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   8583: invokevirtual 2097	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8586: invokeinterface 2788 3 0
    //   8591: aload_0
    //   8592: getfield 634	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8595: ifnull -8411 -> 184
    //   8598: aload_0
    //   8599: getfield 634	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8602: invokevirtual 2789	com/tencent/biz/ui/RefreshView:c	()V
    //   8605: goto -8421 -> 184
    //   8608: aload_0
    //   8609: getfield 1272	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiIPullRefreshHeader	Lcom/tencent/biz/ui/IPullRefreshHeader;
    //   8612: iconst_1
    //   8613: aload_1
    //   8614: ldc_w 1227
    //   8617: aload_2
    //   8618: ldc_w 2790
    //   8621: invokevirtual 2785	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   8624: invokevirtual 2097	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8627: invokeinterface 2788 3 0
    //   8632: goto -41 -> 8591
    //   8635: ldc_w 2792
    //   8638: aload 4
    //   8640: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8643: ifeq +192 -> 8835
    //   8646: aload 5
    //   8648: arraylength
    //   8649: iconst_1
    //   8650: if_icmpne +185 -> 8835
    //   8653: new 110	org/json/JSONObject
    //   8656: dup
    //   8657: aload 5
    //   8659: iconst_0
    //   8660: aaload
    //   8661: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8664: astore_2
    //   8665: aload_2
    //   8666: ldc_w 2794
    //   8669: invokevirtual 977	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8672: istore 6
    //   8674: aload_2
    //   8675: ldc 157
    //   8677: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8680: astore_1
    //   8681: aload_2
    //   8682: ldc 204
    //   8684: invokevirtual 977	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8687: istore 7
    //   8689: aload_0
    //   8690: aload_2
    //   8691: ldc_w 1174
    //   8694: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8697: putfield 2344	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8700: new 126	android/content/Intent
    //   8703: dup
    //   8704: getstatic 2798	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   8707: ldc_w 2800
    //   8710: invokespecial 733	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   8713: astore_2
    //   8714: aload_2
    //   8715: ldc_w 2802
    //   8718: iload 6
    //   8720: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8723: pop
    //   8724: aload_2
    //   8725: ldc_w 2804
    //   8728: aload_1
    //   8729: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8732: pop
    //   8733: aload_2
    //   8734: ldc_w 2806
    //   8737: iload 7
    //   8739: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8742: pop
    //   8743: aload_2
    //   8744: ldc_w 2808
    //   8747: bipush 6
    //   8749: invokevirtual 2811	android/content/Intent:putExtra	(Ljava/lang/String;B)Landroid/content/Intent;
    //   8752: pop
    //   8753: aload_0
    //   8754: aload_2
    //   8755: bipush 6
    //   8757: invokevirtual 1385	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   8760: goto -8576 -> 184
    //   8763: astore_1
    //   8764: aload_1
    //   8765: invokevirtual 2227	org/json/JSONException:printStackTrace	()V
    //   8768: aload_0
    //   8769: getfield 2344	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8772: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8775: ifne -8591 -> 184
    //   8778: aload_0
    //   8779: aload_0
    //   8780: getfield 2344	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8783: iconst_1
    //   8784: anewarray 325	java/lang/String
    //   8787: dup
    //   8788: iconst_0
    //   8789: ldc_w 2813
    //   8792: aastore
    //   8793: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8796: goto -8612 -> 184
    //   8799: astore_1
    //   8800: aload_1
    //   8801: invokevirtual 2322	java/lang/Exception:printStackTrace	()V
    //   8804: aload_0
    //   8805: getfield 2344	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8808: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8811: ifne -8627 -> 184
    //   8814: aload_0
    //   8815: aload_0
    //   8816: getfield 2344	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8819: iconst_1
    //   8820: anewarray 325	java/lang/String
    //   8823: dup
    //   8824: iconst_0
    //   8825: ldc_w 2813
    //   8828: aastore
    //   8829: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8832: goto -8648 -> 184
    //   8835: ldc_w 2815
    //   8838: aload 4
    //   8840: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8843: ifeq +250 -> 9093
    //   8846: aload_0
    //   8847: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8850: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   8853: astore_1
    //   8854: aload_0
    //   8855: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8858: invokevirtual 894	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   8861: astore_2
    //   8862: aload_1
    //   8863: ifnull -8679 -> 184
    //   8866: aload_2
    //   8867: ifnull -8683 -> 184
    //   8870: aconst_null
    //   8871: astore_2
    //   8872: aload_2
    //   8873: astore_1
    //   8874: new 110	org/json/JSONObject
    //   8877: dup
    //   8878: aload 5
    //   8880: iconst_0
    //   8881: aaload
    //   8882: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8885: astore_3
    //   8886: aload_2
    //   8887: astore_1
    //   8888: aload_3
    //   8889: ldc_w 1174
    //   8892: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8895: astore_2
    //   8896: aload_2
    //   8897: astore_1
    //   8898: aload_3
    //   8899: ldc_w 2080
    //   8902: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   8905: invokestatic 2819	com/tencent/mobileqq/nearby/NearbyURLSafeUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   8908: astore 4
    //   8910: aload_2
    //   8911: astore_1
    //   8912: aload_3
    //   8913: ldc_w 2821
    //   8916: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8919: astore 5
    //   8921: aload_2
    //   8922: astore_1
    //   8923: aload_3
    //   8924: ldc_w 2823
    //   8927: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   8930: istore 7
    //   8932: iconst_0
    //   8933: istore 6
    //   8935: aload_2
    //   8936: astore_1
    //   8937: aload_3
    //   8938: ldc_w 2825
    //   8941: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8944: ifeq +14 -> 8958
    //   8947: aload_2
    //   8948: astore_1
    //   8949: aload_3
    //   8950: ldc_w 2825
    //   8953: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   8956: istore 6
    //   8958: aload_2
    //   8959: astore_1
    //   8960: new 795	android/os/Bundle
    //   8963: dup
    //   8964: invokespecial 796	android/os/Bundle:<init>	()V
    //   8967: astore_3
    //   8968: aload_2
    //   8969: astore_1
    //   8970: aload_3
    //   8971: ldc_w 2080
    //   8974: aload 4
    //   8976: invokevirtual 808	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   8979: aload 5
    //   8981: ifnull +14 -> 8995
    //   8984: aload_2
    //   8985: astore_1
    //   8986: aload_3
    //   8987: ldc_w 2821
    //   8990: aload 5
    //   8992: invokevirtual 808	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   8995: aload_2
    //   8996: astore_1
    //   8997: aload_3
    //   8998: ldc_w 2827
    //   9001: iload 7
    //   9003: invokevirtual 802	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9006: aload_2
    //   9007: astore_1
    //   9008: aload_3
    //   9009: ldc_w 2829
    //   9012: ldc_w 2815
    //   9015: invokevirtual 808	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9018: aload_2
    //   9019: astore_1
    //   9020: aload_3
    //   9021: ldc_w 2825
    //   9024: iload 6
    //   9026: invokevirtual 802	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9029: aload_2
    //   9030: astore_1
    //   9031: ldc_w 2831
    //   9034: aload_2
    //   9035: aload_0
    //   9036: getfield 94	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   9039: getfield 2836	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   9042: aload_3
    //   9043: invokestatic 2841	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   9046: astore_3
    //   9047: aload_2
    //   9048: astore_1
    //   9049: invokestatic 2846	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   9052: aload_3
    //   9053: invokevirtual 2848	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   9056: goto -8872 -> 184
    //   9059: astore_2
    //   9060: aload_1
    //   9061: ifnull -8877 -> 184
    //   9064: aload_0
    //   9065: aload_1
    //   9066: iconst_1
    //   9067: anewarray 325	java/lang/String
    //   9070: dup
    //   9071: iconst_0
    //   9072: ldc_w 2850
    //   9075: iconst_1
    //   9076: anewarray 768	java/lang/Object
    //   9079: dup
    //   9080: iconst_0
    //   9081: aload_2
    //   9082: aastore
    //   9083: invokestatic 775	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9086: aastore
    //   9087: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9090: goto -8906 -> 184
    //   9093: ldc_w 2852
    //   9096: aload 4
    //   9098: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9101: ifeq +403 -> 9504
    //   9104: aload_0
    //   9105: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9108: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   9111: astore_1
    //   9112: aload_0
    //   9113: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9116: invokevirtual 894	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   9119: astore_2
    //   9120: aload_1
    //   9121: ifnull -8937 -> 184
    //   9124: aload_2
    //   9125: ifnull -8941 -> 184
    //   9128: aconst_null
    //   9129: astore_2
    //   9130: aconst_null
    //   9131: astore 4
    //   9133: aload_2
    //   9134: astore_1
    //   9135: new 110	org/json/JSONObject
    //   9138: dup
    //   9139: aload 5
    //   9141: iconst_0
    //   9142: aaload
    //   9143: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9146: astore 14
    //   9148: aload_2
    //   9149: astore_1
    //   9150: aload 14
    //   9152: ldc_w 1174
    //   9155: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9158: astore_3
    //   9159: aload_3
    //   9160: astore_1
    //   9161: aload 14
    //   9163: ldc_w 2080
    //   9166: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9169: invokestatic 2819	com/tencent/mobileqq/nearby/NearbyURLSafeUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9172: astore_2
    //   9173: aload_3
    //   9174: astore_1
    //   9175: aload 14
    //   9177: ldc_w 2078
    //   9180: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9183: astore 5
    //   9185: aload_3
    //   9186: astore_1
    //   9187: aload 14
    //   9189: ldc_w 2854
    //   9192: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9195: astore 15
    //   9197: iconst_0
    //   9198: istore 12
    //   9200: aload_3
    //   9201: astore_1
    //   9202: aload 5
    //   9204: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9207: ifne +6155 -> 15362
    //   9210: iconst_1
    //   9211: istore 12
    //   9213: aload 5
    //   9215: astore_2
    //   9216: aload_3
    //   9217: astore_1
    //   9218: aload 14
    //   9220: ldc_w 2821
    //   9223: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9226: astore 5
    //   9228: aload_3
    //   9229: astore_1
    //   9230: aload 14
    //   9232: ldc_w 2823
    //   9235: invokevirtual 977	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9238: istore 6
    //   9240: aload_3
    //   9241: astore_1
    //   9242: aload 14
    //   9244: ldc_w 2856
    //   9247: invokevirtual 977	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9250: istore 7
    //   9252: aload_3
    //   9253: astore_1
    //   9254: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9257: ifeq +35 -> 9292
    //   9260: aload_3
    //   9261: astore_1
    //   9262: ldc 196
    //   9264: iconst_2
    //   9265: new 391	java/lang/StringBuilder
    //   9268: dup
    //   9269: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   9272: ldc_w 2858
    //   9275: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9278: aload 14
    //   9280: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   9283: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9286: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9289: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9292: aload_3
    //   9293: astore_1
    //   9294: aload_2
    //   9295: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9298: ifne +178 -> 9476
    //   9301: aload_3
    //   9302: astore_1
    //   9303: new 795	android/os/Bundle
    //   9306: dup
    //   9307: invokespecial 796	android/os/Bundle:<init>	()V
    //   9310: astore 14
    //   9312: aload_3
    //   9313: astore_1
    //   9314: aload 14
    //   9316: ldc_w 2823
    //   9319: iload 6
    //   9321: invokevirtual 802	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9324: aload_3
    //   9325: astore_1
    //   9326: aload 14
    //   9328: ldc_w 2080
    //   9331: aload_2
    //   9332: invokevirtual 808	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9335: aload_3
    //   9336: astore_1
    //   9337: aload 14
    //   9339: ldc_w 2860
    //   9342: iload 12
    //   9344: invokevirtual 1018	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   9347: aload_3
    //   9348: astore_1
    //   9349: aload 14
    //   9351: ldc_w 2829
    //   9354: ldc_w 2852
    //   9357: invokevirtual 808	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9360: aload_3
    //   9361: astore_1
    //   9362: aload 14
    //   9364: ldc_w 2856
    //   9367: iload 7
    //   9369: invokevirtual 802	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9372: aload_3
    //   9373: astore_1
    //   9374: aload 5
    //   9376: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9379: ifne +15 -> 9394
    //   9382: aload_3
    //   9383: astore_1
    //   9384: aload 14
    //   9386: ldc_w 2821
    //   9389: aload 5
    //   9391: invokevirtual 808	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9394: aload_3
    //   9395: astore_1
    //   9396: aload 15
    //   9398: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9401: ifne +15 -> 9416
    //   9404: aload_3
    //   9405: astore_1
    //   9406: aload 14
    //   9408: ldc_w 2854
    //   9411: aload 15
    //   9413: invokevirtual 808	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9416: aload_3
    //   9417: astore_1
    //   9418: ldc_w 2831
    //   9421: aload_3
    //   9422: aload_0
    //   9423: getfield 94	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   9426: getfield 2836	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   9429: aload 14
    //   9431: invokestatic 2841	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   9434: astore_2
    //   9435: aload_3
    //   9436: astore_1
    //   9437: invokestatic 2846	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   9440: aload_2
    //   9441: invokevirtual 2848	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   9444: aload_3
    //   9445: astore_1
    //   9446: aload 4
    //   9448: astore_2
    //   9449: aload_2
    //   9450: ifnull -9266 -> 184
    //   9453: aload_1
    //   9454: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9457: ifne -9273 -> 184
    //   9460: aload_0
    //   9461: aload_1
    //   9462: iconst_1
    //   9463: anewarray 325	java/lang/String
    //   9466: dup
    //   9467: iconst_0
    //   9468: aload_2
    //   9469: aastore
    //   9470: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9473: goto -9289 -> 184
    //   9476: ldc_w 2862
    //   9479: astore_2
    //   9480: aload_3
    //   9481: astore_1
    //   9482: goto -33 -> 9449
    //   9485: astore_2
    //   9486: ldc_w 2850
    //   9489: iconst_1
    //   9490: anewarray 768	java/lang/Object
    //   9493: dup
    //   9494: iconst_0
    //   9495: aload_2
    //   9496: aastore
    //   9497: invokestatic 775	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9500: astore_2
    //   9501: goto -52 -> 9449
    //   9504: ldc_w 2864
    //   9507: aload 4
    //   9509: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9512: ifeq +196 -> 9708
    //   9515: aconst_null
    //   9516: astore_2
    //   9517: aload_2
    //   9518: astore_1
    //   9519: new 110	org/json/JSONObject
    //   9522: dup
    //   9523: aload 5
    //   9525: iconst_0
    //   9526: aaload
    //   9527: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9530: astore_3
    //   9531: aload_2
    //   9532: astore_1
    //   9533: aload_3
    //   9534: ldc_w 1174
    //   9537: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9540: astore_2
    //   9541: aload_2
    //   9542: astore_1
    //   9543: aload_3
    //   9544: ldc_w 2744
    //   9547: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   9550: ifeq -9366 -> 184
    //   9553: aload_2
    //   9554: astore_1
    //   9555: aload_3
    //   9556: ldc_w 2744
    //   9559: invokevirtual 1130	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   9562: istore 12
    //   9564: aload_2
    //   9565: astore_1
    //   9566: aload_0
    //   9567: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9570: aload_0
    //   9571: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9574: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   9577: invokevirtual 618	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   9580: astore_3
    //   9581: aload_3
    //   9582: ifnull +83 -> 9665
    //   9585: aload_2
    //   9586: astore_1
    //   9587: aload_3
    //   9588: instanceof 2866
    //   9591: ifeq +74 -> 9665
    //   9594: aload_2
    //   9595: astore_1
    //   9596: aload_3
    //   9597: checkcast 2866	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebEventInterface
    //   9600: astore_3
    //   9601: iload 12
    //   9603: ifne +56 -> 9659
    //   9606: iconst_1
    //   9607: istore 12
    //   9609: aload_2
    //   9610: astore_1
    //   9611: aload_3
    //   9612: iload 12
    //   9614: invokeinterface 2867 2 0
    //   9619: goto -9435 -> 184
    //   9622: astore_2
    //   9623: aload_1
    //   9624: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9627: ifne -9443 -> 184
    //   9630: aload_0
    //   9631: aload_1
    //   9632: iconst_1
    //   9633: anewarray 325	java/lang/String
    //   9636: dup
    //   9637: iconst_0
    //   9638: ldc_w 2850
    //   9641: iconst_1
    //   9642: anewarray 768	java/lang/Object
    //   9645: dup
    //   9646: iconst_0
    //   9647: aload_2
    //   9648: aastore
    //   9649: invokestatic 775	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9652: aastore
    //   9653: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9656: goto -9472 -> 184
    //   9659: iconst_0
    //   9660: istore 12
    //   9662: goto -53 -> 9609
    //   9665: aload_2
    //   9666: astore_1
    //   9667: aload_0
    //   9668: iconst_m1
    //   9669: invokespecial 1188	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   9672: checkcast 2869	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting
    //   9675: astore_3
    //   9676: aload_3
    //   9677: ifnull -9493 -> 184
    //   9680: iload 12
    //   9682: ifne +20 -> 9702
    //   9685: iconst_1
    //   9686: istore 12
    //   9688: aload_2
    //   9689: astore_1
    //   9690: aload_3
    //   9691: ldc_w 2871
    //   9694: iload 12
    //   9696: invokevirtual 2872	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting:a	(Ljava/lang/String;Z)V
    //   9699: goto -9515 -> 184
    //   9702: iconst_0
    //   9703: istore 12
    //   9705: goto -17 -> 9688
    //   9708: ldc_w 2874
    //   9711: aload 4
    //   9713: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9716: ifeq +196 -> 9912
    //   9719: aconst_null
    //   9720: astore_2
    //   9721: aload_2
    //   9722: astore_1
    //   9723: new 110	org/json/JSONObject
    //   9726: dup
    //   9727: aload 5
    //   9729: iconst_0
    //   9730: aaload
    //   9731: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9734: astore_3
    //   9735: aload_2
    //   9736: astore_1
    //   9737: aload_3
    //   9738: ldc_w 1174
    //   9741: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9744: astore_2
    //   9745: aload_2
    //   9746: astore_1
    //   9747: aload_3
    //   9748: ldc_w 2744
    //   9751: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   9754: ifeq -9570 -> 184
    //   9757: aload_2
    //   9758: astore_1
    //   9759: aload_3
    //   9760: ldc_w 2744
    //   9763: invokevirtual 1130	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   9766: istore 12
    //   9768: aload_2
    //   9769: astore_1
    //   9770: aload_0
    //   9771: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9774: aload_0
    //   9775: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9778: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   9781: invokevirtual 618	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   9784: astore_3
    //   9785: aload_3
    //   9786: ifnull +83 -> 9869
    //   9789: aload_2
    //   9790: astore_1
    //   9791: aload_3
    //   9792: instanceof 2866
    //   9795: ifeq +74 -> 9869
    //   9798: aload_2
    //   9799: astore_1
    //   9800: aload_3
    //   9801: checkcast 2866	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebEventInterface
    //   9804: astore_3
    //   9805: iload 12
    //   9807: ifne +56 -> 9863
    //   9810: iconst_1
    //   9811: istore 12
    //   9813: aload_2
    //   9814: astore_1
    //   9815: aload_3
    //   9816: iload 12
    //   9818: invokeinterface 2875 2 0
    //   9823: goto -9639 -> 184
    //   9826: astore_2
    //   9827: aload_1
    //   9828: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9831: ifne -9647 -> 184
    //   9834: aload_0
    //   9835: aload_1
    //   9836: iconst_1
    //   9837: anewarray 325	java/lang/String
    //   9840: dup
    //   9841: iconst_0
    //   9842: ldc_w 2850
    //   9845: iconst_1
    //   9846: anewarray 768	java/lang/Object
    //   9849: dup
    //   9850: iconst_0
    //   9851: aload_2
    //   9852: aastore
    //   9853: invokestatic 775	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9856: aastore
    //   9857: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9860: goto -9676 -> 184
    //   9863: iconst_0
    //   9864: istore 12
    //   9866: goto -53 -> 9813
    //   9869: aload_2
    //   9870: astore_1
    //   9871: aload_0
    //   9872: iconst_m1
    //   9873: invokespecial 1188	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   9876: checkcast 2869	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting
    //   9879: astore_3
    //   9880: aload_3
    //   9881: ifnull -9697 -> 184
    //   9884: iload 12
    //   9886: ifne +20 -> 9906
    //   9889: iconst_1
    //   9890: istore 12
    //   9892: aload_2
    //   9893: astore_1
    //   9894: aload_3
    //   9895: ldc_w 2877
    //   9898: iload 12
    //   9900: invokevirtual 2872	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting:a	(Ljava/lang/String;Z)V
    //   9903: goto -9719 -> 184
    //   9906: iconst_0
    //   9907: istore 12
    //   9909: goto -17 -> 9892
    //   9912: ldc_w 2879
    //   9915: aload 4
    //   9917: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9920: ifeq +221 -> 10141
    //   9923: aload_0
    //   9924: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9927: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   9930: astore 14
    //   9932: aload_0
    //   9933: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9936: invokevirtual 894	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   9939: astore_1
    //   9940: aload 14
    //   9942: ifnull -9758 -> 184
    //   9945: aload_1
    //   9946: ifnull -9762 -> 184
    //   9949: aconst_null
    //   9950: astore_1
    //   9951: aconst_null
    //   9952: astore 4
    //   9954: new 110	org/json/JSONObject
    //   9957: dup
    //   9958: aload 5
    //   9960: iconst_0
    //   9961: aaload
    //   9962: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9965: astore_3
    //   9966: aload_3
    //   9967: ldc_w 1174
    //   9970: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9973: astore_2
    //   9974: aload_2
    //   9975: astore_1
    //   9976: aload_3
    //   9977: ifnull +155 -> 10132
    //   9980: new 795	android/os/Bundle
    //   9983: dup
    //   9984: invokespecial 796	android/os/Bundle:<init>	()V
    //   9987: astore 5
    //   9989: aload 5
    //   9991: ldc_w 2881
    //   9994: aload_3
    //   9995: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   9998: invokevirtual 808	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   10001: aload 14
    //   10003: invokevirtual 943	java/lang/Object:getClass	()Ljava/lang/Class;
    //   10006: invokevirtual 139	java/lang/Class:getName	()Ljava/lang/String;
    //   10009: ldc_w 2883
    //   10012: invokevirtual 948	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   10015: istore 12
    //   10017: aload 4
    //   10019: astore_2
    //   10020: aload_1
    //   10021: astore_3
    //   10022: iload 12
    //   10024: ifeq +41 -> 10065
    //   10027: aconst_null
    //   10028: aload 14
    //   10030: new 110	org/json/JSONObject
    //   10033: dup
    //   10034: aload 5
    //   10036: ldc_w 2881
    //   10039: invokevirtual 2884	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10042: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10045: ldc_w 2886
    //   10048: ldc_w 362
    //   10051: invokevirtual 2097	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10054: invokestatic 2890	com/tencent/biz/pubaccount/subscript/SubscriptUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   10057: invokestatic 2895	com/tencent/biz/pubaccount/util/PublicAccountUtil:a	(Landroid/content/Intent;Landroid/content/Context;Ljava/lang/String;)V
    //   10060: aload_1
    //   10061: astore_3
    //   10062: aload 4
    //   10064: astore_2
    //   10065: aload_2
    //   10066: ifnull -9882 -> 184
    //   10069: aload_3
    //   10070: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10073: ifne -9889 -> 184
    //   10076: aload_0
    //   10077: aload_3
    //   10078: iconst_1
    //   10079: anewarray 325	java/lang/String
    //   10082: dup
    //   10083: iconst_0
    //   10084: aload_2
    //   10085: aastore
    //   10086: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10089: goto -9905 -> 184
    //   10092: astore_2
    //   10093: ldc 196
    //   10095: iconst_2
    //   10096: ldc_w 2897
    //   10099: aload_2
    //   10100: invokestatic 2088	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   10103: aload 4
    //   10105: astore_2
    //   10106: aload_1
    //   10107: astore_3
    //   10108: goto -43 -> 10065
    //   10111: astore_2
    //   10112: ldc_w 2850
    //   10115: iconst_1
    //   10116: anewarray 768	java/lang/Object
    //   10119: dup
    //   10120: iconst_0
    //   10121: aload_2
    //   10122: aastore
    //   10123: invokestatic 775	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10126: astore_2
    //   10127: aload_1
    //   10128: astore_3
    //   10129: goto -64 -> 10065
    //   10132: ldc_w 2862
    //   10135: astore_2
    //   10136: aload_1
    //   10137: astore_3
    //   10138: goto -73 -> 10065
    //   10141: ldc_w 2899
    //   10144: aload 4
    //   10146: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10149: ifeq +330 -> 10479
    //   10152: aconst_null
    //   10153: ldc_w 358
    //   10156: ldc_w 360
    //   10159: ldc_w 362
    //   10162: ldc_w 364
    //   10165: ldc_w 2901
    //   10168: iconst_0
    //   10169: iconst_1
    //   10170: iconst_0
    //   10171: aload 5
    //   10173: iconst_0
    //   10174: aaload
    //   10175: ldc_w 362
    //   10178: ldc_w 362
    //   10181: ldc_w 362
    //   10184: invokestatic 371	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   10187: aload_0
    //   10188: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10191: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   10194: astore 14
    //   10196: aload_0
    //   10197: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10200: invokevirtual 894	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   10203: astore_1
    //   10204: aload 14
    //   10206: ifnull -10022 -> 184
    //   10209: aload_1
    //   10210: ifnull -10026 -> 184
    //   10213: aconst_null
    //   10214: astore_3
    //   10215: aconst_null
    //   10216: astore 4
    //   10218: aload 4
    //   10220: astore_1
    //   10221: aload_3
    //   10222: astore_2
    //   10223: new 110	org/json/JSONObject
    //   10226: dup
    //   10227: aload 5
    //   10229: iconst_0
    //   10230: aaload
    //   10231: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10234: astore 5
    //   10236: aload 4
    //   10238: astore_1
    //   10239: aload_3
    //   10240: astore_2
    //   10241: aload 5
    //   10243: ldc_w 1174
    //   10246: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10249: astore_3
    //   10250: aload 4
    //   10252: astore_1
    //   10253: aload_3
    //   10254: astore_2
    //   10255: aload 5
    //   10257: ldc 210
    //   10259: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10262: astore 4
    //   10264: aload 4
    //   10266: astore_1
    //   10267: aload_3
    //   10268: astore_2
    //   10269: aload 5
    //   10271: ldc_w 2829
    //   10274: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10277: astore 15
    //   10279: aload 4
    //   10281: astore_1
    //   10282: aload_3
    //   10283: astore_2
    //   10284: aload 5
    //   10286: ldc 185
    //   10288: invokevirtual 1043	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   10291: astore 5
    //   10293: aload 4
    //   10295: astore_1
    //   10296: aload_3
    //   10297: astore_2
    //   10298: ldc_w 364
    //   10301: aload 15
    //   10303: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10306: ifeq +5049 -> 15355
    //   10309: aload 5
    //   10311: ifnull +5044 -> 15355
    //   10314: aload 4
    //   10316: astore_1
    //   10317: aload_3
    //   10318: astore_2
    //   10319: aload 5
    //   10321: ldc_w 835
    //   10324: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10327: astore 15
    //   10329: aload 4
    //   10331: astore_1
    //   10332: aload_3
    //   10333: astore_2
    //   10334: aload 5
    //   10336: ldc_w 2633
    //   10339: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10342: astore 16
    //   10344: aload 4
    //   10346: astore_1
    //   10347: aload_3
    //   10348: astore_2
    //   10349: aload 5
    //   10351: ldc 157
    //   10353: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10356: astore 5
    //   10358: aload 4
    //   10360: astore_1
    //   10361: aload_3
    //   10362: astore_2
    //   10363: aload 15
    //   10365: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10368: ifne +67 -> 10435
    //   10371: aload 4
    //   10373: astore_1
    //   10374: aload_3
    //   10375: astore_2
    //   10376: aload 5
    //   10378: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10381: ifne +54 -> 10435
    //   10384: aload 4
    //   10386: astore_1
    //   10387: aload_3
    //   10388: astore_2
    //   10389: aload_0
    //   10390: aload 14
    //   10392: aload 15
    //   10394: aload 16
    //   10396: aload 4
    //   10398: aload 5
    //   10400: aload_3
    //   10401: invokespecial 2903	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   10404: aconst_null
    //   10405: astore_1
    //   10406: aload_3
    //   10407: astore_2
    //   10408: aload_1
    //   10409: ifnull -10225 -> 184
    //   10412: aload_2
    //   10413: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10416: ifne -10232 -> 184
    //   10419: aload_0
    //   10420: aload_2
    //   10421: iconst_1
    //   10422: anewarray 325	java/lang/String
    //   10425: dup
    //   10426: iconst_0
    //   10427: aload_1
    //   10428: aastore
    //   10429: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10432: goto -10248 -> 184
    //   10435: aload 4
    //   10437: astore_1
    //   10438: aload_3
    //   10439: astore_2
    //   10440: ldc_w 2370
    //   10443: aconst_null
    //   10444: ldc_w 2905
    //   10447: aload 4
    //   10449: invokestatic 356	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10452: astore 4
    //   10454: aload 4
    //   10456: astore_1
    //   10457: aload_3
    //   10458: astore_2
    //   10459: goto -51 -> 10408
    //   10462: astore_3
    //   10463: ldc_w 2907
    //   10466: aconst_null
    //   10467: aload_3
    //   10468: invokevirtual 538	java/lang/Exception:toString	()Ljava/lang/String;
    //   10471: aload_1
    //   10472: invokestatic 356	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10475: astore_1
    //   10476: goto -68 -> 10408
    //   10479: ldc_w 2909
    //   10482: aload 4
    //   10484: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10487: ifeq +295 -> 10782
    //   10490: aload 5
    //   10492: arraylength
    //   10493: ifle +289 -> 10782
    //   10496: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10499: ifeq +33 -> 10532
    //   10502: ldc_w 2911
    //   10505: iconst_2
    //   10506: new 391	java/lang/StringBuilder
    //   10509: dup
    //   10510: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   10513: ldc_w 2913
    //   10516: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10519: aload 5
    //   10521: iconst_0
    //   10522: aaload
    //   10523: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10526: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10529: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10532: new 110	org/json/JSONObject
    //   10535: dup
    //   10536: aload 5
    //   10538: iconst_0
    //   10539: aaload
    //   10540: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10543: ldc 157
    //   10545: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10548: astore_3
    //   10549: aload_3
    //   10550: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10553: ifne -10369 -> 184
    //   10556: aload_3
    //   10557: ldc_w 2915
    //   10560: invokevirtual 2919	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   10563: astore_1
    //   10564: new 1942	java/util/HashMap
    //   10567: dup
    //   10568: invokespecial 2920	java/util/HashMap:<init>	()V
    //   10571: astore_2
    //   10572: aload_1
    //   10573: arraylength
    //   10574: iconst_1
    //   10575: if_icmple -10391 -> 184
    //   10578: aload_1
    //   10579: iconst_1
    //   10580: aaload
    //   10581: ldc_w 2922
    //   10584: invokevirtual 2919	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   10587: astore_1
    //   10588: iconst_0
    //   10589: istore 6
    //   10591: aload_1
    //   10592: arraylength
    //   10593: istore 7
    //   10595: iload 6
    //   10597: iload 7
    //   10599: if_icmpge +49 -> 10648
    //   10602: aload_1
    //   10603: iload 6
    //   10605: aaload
    //   10606: bipush 61
    //   10608: invokevirtual 2925	java/lang/String:indexOf	(I)I
    //   10611: istore 8
    //   10613: iload 8
    //   10615: iconst_m1
    //   10616: if_icmpeq +4851 -> 15467
    //   10619: aload_2
    //   10620: aload_1
    //   10621: iload 6
    //   10623: aaload
    //   10624: iconst_0
    //   10625: iload 8
    //   10627: invokevirtual 2929	java/lang/String:substring	(II)Ljava/lang/String;
    //   10630: aload_1
    //   10631: iload 6
    //   10633: aaload
    //   10634: iload 8
    //   10636: iconst_1
    //   10637: iadd
    //   10638: invokevirtual 2931	java/lang/String:substring	(I)Ljava/lang/String;
    //   10641: invokevirtual 2934	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   10644: pop
    //   10645: goto +4822 -> 15467
    //   10648: aload_3
    //   10649: ldc_w 1464
    //   10652: invokevirtual 1467	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   10655: ifeq +102 -> 10757
    //   10658: aload_2
    //   10659: ldc_w 1137
    //   10662: invokevirtual 2935	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10665: checkcast 325	java/lang/String
    //   10668: astore_1
    //   10669: aload_2
    //   10670: ldc 161
    //   10672: invokevirtual 2935	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10675: checkcast 325	java/lang/String
    //   10678: astore_2
    //   10679: aload_0
    //   10680: aload_1
    //   10681: aload_2
    //   10682: aload_3
    //   10683: invokevirtual 2937	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   10686: ifne -10502 -> 184
    //   10689: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10692: ifeq +13 -> 10705
    //   10695: ldc_w 2911
    //   10698: iconst_2
    //   10699: ldc_w 2128
    //   10702: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10705: aload_0
    //   10706: aload 5
    //   10708: iconst_0
    //   10709: aaload
    //   10710: iconst_0
    //   10711: invokevirtual 2133	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Z)V
    //   10714: goto -10530 -> 184
    //   10717: astore_1
    //   10718: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10721: ifeq -10537 -> 184
    //   10724: ldc_w 2911
    //   10727: iconst_2
    //   10728: new 391	java/lang/StringBuilder
    //   10731: dup
    //   10732: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   10735: ldc_w 2939
    //   10738: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10741: aload 5
    //   10743: iconst_0
    //   10744: aaload
    //   10745: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10748: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10751: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10754: goto -10570 -> 184
    //   10757: aload_2
    //   10758: ldc_w 2732
    //   10761: invokevirtual 2935	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10764: checkcast 325	java/lang/String
    //   10767: astore_1
    //   10768: aload_2
    //   10769: ldc_w 2941
    //   10772: invokevirtual 2935	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10775: checkcast 325	java/lang/String
    //   10778: astore_2
    //   10779: goto -100 -> 10679
    //   10782: ldc_w 2943
    //   10785: aload 4
    //   10787: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10790: ifeq +66 -> 10856
    //   10793: aload 5
    //   10795: arraylength
    //   10796: ifle +60 -> 10856
    //   10799: aload_0
    //   10800: new 110	org/json/JSONObject
    //   10803: dup
    //   10804: aload 5
    //   10806: iconst_0
    //   10807: aaload
    //   10808: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10811: invokevirtual 2945	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;)V
    //   10814: goto -10630 -> 184
    //   10817: astore_1
    //   10818: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10821: ifeq -10637 -> 184
    //   10824: ldc 196
    //   10826: iconst_2
    //   10827: new 391	java/lang/StringBuilder
    //   10830: dup
    //   10831: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   10834: ldc_w 2947
    //   10837: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10840: aload 5
    //   10842: iconst_0
    //   10843: aaload
    //   10844: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10847: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10850: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10853: goto -10669 -> 184
    //   10856: ldc_w 2949
    //   10859: aload 4
    //   10861: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10864: ifeq +10 -> 10874
    //   10867: aload_0
    //   10868: invokevirtual 2950	com/tencent/mobileqq/jsp/UiApiPlugin:b	()V
    //   10871: goto -10687 -> 184
    //   10874: ldc_w 2952
    //   10877: aload 4
    //   10879: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10882: ifeq +72 -> 10954
    //   10885: aload 5
    //   10887: arraylength
    //   10888: ifle +66 -> 10954
    //   10891: aload_0
    //   10892: new 110	org/json/JSONObject
    //   10895: dup
    //   10896: aload 5
    //   10898: iconst_0
    //   10899: aaload
    //   10900: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10903: ldc_w 1174
    //   10906: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10909: invokevirtual 2953	com/tencent/mobileqq/jsp/UiApiPlugin:b	(Ljava/lang/String;)V
    //   10912: goto -10728 -> 184
    //   10915: astore_1
    //   10916: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10919: ifeq -10735 -> 184
    //   10922: ldc 196
    //   10924: iconst_2
    //   10925: new 391	java/lang/StringBuilder
    //   10928: dup
    //   10929: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   10932: ldc_w 2955
    //   10935: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10938: aload 5
    //   10940: iconst_0
    //   10941: aaload
    //   10942: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10945: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10948: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10951: goto -10767 -> 184
    //   10954: ldc_w 2957
    //   10957: aload 4
    //   10959: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10962: ifeq +112 -> 11074
    //   10965: new 110	org/json/JSONObject
    //   10968: dup
    //   10969: aload 5
    //   10971: iconst_0
    //   10972: aaload
    //   10973: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10976: astore_1
    //   10977: aload_0
    //   10978: invokevirtual 1946	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   10981: astore_2
    //   10982: aload_2
    //   10983: ifnull -10799 -> 184
    //   10986: aload_2
    //   10987: aload_1
    //   10988: invokeinterface 2958 2 0
    //   10993: goto -10809 -> 184
    //   10996: astore_1
    //   10997: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11000: ifeq -10816 -> 184
    //   11003: ldc 196
    //   11005: iconst_2
    //   11006: new 391	java/lang/StringBuilder
    //   11009: dup
    //   11010: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   11013: ldc_w 2960
    //   11016: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11019: aload_1
    //   11020: invokevirtual 2961	org/json/JSONException:toString	()Ljava/lang/String;
    //   11023: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11026: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11029: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11032: goto -10848 -> 184
    //   11035: astore_1
    //   11036: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11039: ifeq -10855 -> 184
    //   11042: ldc 196
    //   11044: iconst_2
    //   11045: new 391	java/lang/StringBuilder
    //   11048: dup
    //   11049: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   11052: ldc_w 2960
    //   11055: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11058: aload_1
    //   11059: invokevirtual 538	java/lang/Exception:toString	()Ljava/lang/String;
    //   11062: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11065: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11068: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11071: goto -10887 -> 184
    //   11074: ldc_w 2963
    //   11077: aload 4
    //   11079: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11082: ifeq +194 -> 11276
    //   11085: aload 5
    //   11087: arraylength
    //   11088: ifle +188 -> 11276
    //   11091: new 110	org/json/JSONObject
    //   11094: dup
    //   11095: aload 5
    //   11097: iconst_0
    //   11098: aaload
    //   11099: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11102: ldc_w 1174
    //   11105: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11108: astore_1
    //   11109: aload_1
    //   11110: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11113: ifeq +14 -> 11127
    //   11116: ldc 196
    //   11118: iconst_1
    //   11119: ldc_w 2965
    //   11122: invokestatic 540	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11125: iconst_1
    //   11126: ireturn
    //   11127: new 110	org/json/JSONObject
    //   11130: dup
    //   11131: invokespecial 159	org/json/JSONObject:<init>	()V
    //   11134: astore_2
    //   11135: new 110	org/json/JSONObject
    //   11138: dup
    //   11139: invokespecial 159	org/json/JSONObject:<init>	()V
    //   11142: astore_3
    //   11143: aload_0
    //   11144: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11147: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   11150: invokevirtual 340	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   11153: ldc_w 341
    //   11156: invokevirtual 347	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   11159: istore 7
    //   11161: iload 7
    //   11163: istore 6
    //   11165: invokestatic 1294	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   11168: iconst_1
    //   11169: if_icmpne +18 -> 11187
    //   11172: iload 7
    //   11174: aload_0
    //   11175: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11178: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   11181: invokestatic 1295	com/tencent/widget/immersive/ImmersiveUtils:a	(Landroid/content/Context;)I
    //   11184: iadd
    //   11185: istore 6
    //   11187: aload_3
    //   11188: ldc_w 1239
    //   11191: iload 6
    //   11193: invokevirtual 183	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11196: pop
    //   11197: aload_2
    //   11198: ldc_w 1221
    //   11201: iconst_0
    //   11202: invokevirtual 183	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11205: pop
    //   11206: aload_2
    //   11207: ldc 208
    //   11209: ldc_w 2967
    //   11212: invokevirtual 167	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   11215: pop
    //   11216: aload_2
    //   11217: ldc 185
    //   11219: aload_3
    //   11220: invokevirtual 167	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   11223: pop
    //   11224: aload_0
    //   11225: aload_1
    //   11226: iconst_1
    //   11227: anewarray 325	java/lang/String
    //   11230: dup
    //   11231: iconst_0
    //   11232: aload_2
    //   11233: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   11236: aastore
    //   11237: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11240: goto -11056 -> 184
    //   11243: astore_1
    //   11244: ldc 196
    //   11246: iconst_1
    //   11247: new 391	java/lang/StringBuilder
    //   11250: dup
    //   11251: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   11254: ldc_w 2969
    //   11257: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11260: aload_1
    //   11261: invokestatic 2184	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   11264: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11267: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11270: invokestatic 540	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11273: goto -11089 -> 184
    //   11276: ldc_w 2971
    //   11279: aload 4
    //   11281: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11284: ifeq +78 -> 11362
    //   11287: new 110	org/json/JSONObject
    //   11290: dup
    //   11291: aload 5
    //   11293: iconst_0
    //   11294: aaload
    //   11295: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11298: astore_1
    //   11299: aload_1
    //   11300: ldc_w 1137
    //   11303: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11306: astore_2
    //   11307: aload_0
    //   11308: aload_1
    //   11309: ldc_w 1174
    //   11312: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11315: putfield 2972	com/tencent/mobileqq/jsp/UiApiPlugin:m	Ljava/lang/String;
    //   11318: aload_0
    //   11319: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11322: ifnonnull +17 -> 11339
    //   11325: aload_0
    //   11326: invokestatic 1398	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11329: putfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11332: aload_0
    //   11333: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11336: invokevirtual 1399	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   11339: aload_0
    //   11340: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11343: aload_2
    //   11344: new 2974	adnv
    //   11347: dup
    //   11348: aload_0
    //   11349: aload_2
    //   11350: invokespecial 2975	adnv:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   11353: invokevirtual 2978	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/String;Lcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   11356: goto -11172 -> 184
    //   11359: astore_1
    //   11360: iconst_1
    //   11361: ireturn
    //   11362: ldc_w 2980
    //   11365: aload 4
    //   11367: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11370: ifeq +441 -> 11811
    //   11373: aload 5
    //   11375: arraylength
    //   11376: iconst_1
    //   11377: if_icmpne +434 -> 11811
    //   11380: new 110	org/json/JSONObject
    //   11383: dup
    //   11384: aload 5
    //   11386: iconst_0
    //   11387: aaload
    //   11388: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11391: astore_3
    //   11392: aload_3
    //   11393: ldc_w 2982
    //   11396: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11399: astore 4
    //   11401: aload_3
    //   11402: ldc_w 2984
    //   11405: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11408: astore_1
    //   11409: aload_1
    //   11410: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11413: ifeq +22 -> 11435
    //   11416: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11419: ifeq +4057 -> 15476
    //   11422: ldc_w 2986
    //   11425: iconst_2
    //   11426: ldc_w 2988
    //   11429: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11432: goto +4044 -> 15476
    //   11435: aload_0
    //   11436: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11439: invokevirtual 934	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   11442: astore_2
    //   11443: aload_2
    //   11444: ifnull +10 -> 11454
    //   11447: aload_2
    //   11448: invokevirtual 2991	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   11451: ifnonnull +22 -> 11473
    //   11454: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11457: ifeq +4021 -> 15478
    //   11460: ldc_w 2986
    //   11463: iconst_2
    //   11464: ldc_w 2993
    //   11467: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11470: goto +4008 -> 15478
    //   11473: aload_2
    //   11474: invokevirtual 2991	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   11477: getfield 2996	com/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo:jdField_a_of_type_Int	I
    //   11480: invokestatic 1513	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11483: astore_2
    //   11484: aload_3
    //   11485: ldc_w 2719
    //   11488: invokevirtual 977	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   11491: istore 6
    //   11493: iload 6
    //   11495: iconst_1
    //   11496: if_icmpne +226 -> 11722
    //   11499: new 2998	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   11502: dup
    //   11503: invokespecial 2999	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   11506: astore_3
    //   11507: aload_3
    //   11508: getfield 3002	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11511: sipush 1814
    //   11514: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   11517: aload_3
    //   11518: getfield 3005	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11521: bipush 48
    //   11523: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   11526: aload_1
    //   11527: invokevirtual 3008	java/lang/String:getBytes	()[B
    //   11530: arraylength
    //   11531: bipush 6
    //   11533: iadd
    //   11534: invokestatic 3014	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   11537: astore 4
    //   11539: aload 4
    //   11541: aload_2
    //   11542: invokevirtual 1969	java/lang/Integer:intValue	()I
    //   11545: invokevirtual 3016	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   11548: pop
    //   11549: aload 4
    //   11551: aload_1
    //   11552: invokevirtual 3008	java/lang/String:getBytes	()[B
    //   11555: arraylength
    //   11556: i2s
    //   11557: invokevirtual 3020	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   11560: pop
    //   11561: aload 4
    //   11563: aload_1
    //   11564: invokevirtual 3008	java/lang/String:getBytes	()[B
    //   11567: invokevirtual 3023	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   11570: pop
    //   11571: aload_3
    //   11572: getfield 3027	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11575: aload 4
    //   11577: invokevirtual 3030	java/nio/ByteBuffer:array	()[B
    //   11580: invokestatic 3036	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11583: invokevirtual 3041	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   11586: new 281	mqq/app/NewIntent
    //   11589: dup
    //   11590: aload_0
    //   11591: invokevirtual 1552	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   11594: ldc_w 289
    //   11597: invokespecial 292	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   11600: astore_2
    //   11601: new 795	android/os/Bundle
    //   11604: dup
    //   11605: invokespecial 796	android/os/Bundle:<init>	()V
    //   11608: astore 4
    //   11610: aload 4
    //   11612: ldc_w 2984
    //   11615: aload_1
    //   11616: invokevirtual 808	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   11619: aload_2
    //   11620: aload 4
    //   11622: invokevirtual 3042	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   11625: pop
    //   11626: aload_2
    //   11627: ldc_w 297
    //   11630: ldc_w 3044
    //   11633: invokevirtual 300	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11636: pop
    //   11637: aload_2
    //   11638: ldc 185
    //   11640: aload_3
    //   11641: invokevirtual 3045	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   11644: invokevirtual 307	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   11647: pop
    //   11648: aload_2
    //   11649: ldc_w 3047
    //   11652: iconst_1
    //   11653: invokevirtual 3048	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11656: pop
    //   11657: aload_2
    //   11658: new 3050	adnw
    //   11661: dup
    //   11662: aload_0
    //   11663: invokespecial 3051	adnw:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   11666: invokevirtual 316	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   11669: aload_0
    //   11670: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11673: invokevirtual 894	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   11676: aload_2
    //   11677: invokevirtual 322	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   11680: goto -11496 -> 184
    //   11683: astore_1
    //   11684: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11687: ifeq -11503 -> 184
    //   11690: ldc 196
    //   11692: iconst_2
    //   11693: new 391	java/lang/StringBuilder
    //   11696: dup
    //   11697: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   11700: ldc_w 3053
    //   11703: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11706: aload 5
    //   11708: iconst_0
    //   11709: aaload
    //   11710: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11713: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11716: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11719: goto -11535 -> 184
    //   11722: iload 6
    //   11724: ifne -11540 -> 184
    //   11727: aload_0
    //   11728: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11731: ifnonnull +17 -> 11748
    //   11734: aload_0
    //   11735: invokestatic 1398	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11738: putfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11741: aload_0
    //   11742: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11745: invokevirtual 1399	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   11748: aload_0
    //   11749: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11752: aload_2
    //   11753: aload_1
    //   11754: aload 4
    //   11756: new 3055	adnx
    //   11759: dup
    //   11760: aload_0
    //   11761: aload_2
    //   11762: aload_1
    //   11763: invokespecial 3058	adnx:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;)V
    //   11766: invokevirtual 3061	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   11769: goto -11585 -> 184
    //   11772: astore_1
    //   11773: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11776: ifeq -11592 -> 184
    //   11779: ldc 196
    //   11781: iconst_2
    //   11782: new 391	java/lang/StringBuilder
    //   11785: dup
    //   11786: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   11789: ldc_w 3063
    //   11792: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11795: aload 5
    //   11797: iconst_0
    //   11798: aaload
    //   11799: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11802: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11805: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11808: goto -11624 -> 184
    //   11811: ldc_w 3065
    //   11814: aload 4
    //   11816: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11819: ifeq +455 -> 12274
    //   11822: aload 5
    //   11824: arraylength
    //   11825: iconst_1
    //   11826: if_icmpne +448 -> 12274
    //   11829: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11832: ifeq +33 -> 11865
    //   11835: ldc_w 2986
    //   11838: iconst_2
    //   11839: new 391	java/lang/StringBuilder
    //   11842: dup
    //   11843: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   11846: ldc_w 3067
    //   11849: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11852: aload 5
    //   11854: iconst_0
    //   11855: aaload
    //   11856: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11859: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11862: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11865: new 110	org/json/JSONObject
    //   11868: dup
    //   11869: aload 5
    //   11871: iconst_0
    //   11872: aaload
    //   11873: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11876: astore_3
    //   11877: aload_3
    //   11878: ldc_w 2982
    //   11881: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11884: astore_1
    //   11885: aload_3
    //   11886: ldc_w 2984
    //   11889: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11892: astore_2
    //   11893: aload_3
    //   11894: ldc_w 3069
    //   11897: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11900: astore_3
    //   11901: aload_2
    //   11902: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11905: ifne +10 -> 11915
    //   11908: aload_3
    //   11909: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11912: ifeq +49 -> 11961
    //   11915: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11918: ifeq +3562 -> 15480
    //   11921: ldc_w 2986
    //   11924: iconst_2
    //   11925: new 391	java/lang/StringBuilder
    //   11928: dup
    //   11929: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   11932: ldc_w 3071
    //   11935: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11938: aload_3
    //   11939: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11942: ldc_w 3073
    //   11945: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11948: aload_2
    //   11949: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11952: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11955: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11958: goto +3522 -> 15480
    //   11961: aload_0
    //   11962: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11965: invokevirtual 934	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   11968: astore 4
    //   11970: aload 4
    //   11972: ifnull +11 -> 11983
    //   11975: aload 4
    //   11977: invokevirtual 2991	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   11980: ifnonnull +22 -> 12002
    //   11983: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11986: ifeq +3496 -> 15482
    //   11989: ldc_w 2986
    //   11992: iconst_2
    //   11993: ldc_w 3075
    //   11996: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11999: goto +3483 -> 15482
    //   12002: aload 4
    //   12004: invokevirtual 2991	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   12007: getfield 2996	com/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo:jdField_a_of_type_Int	I
    //   12010: invokestatic 1513	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12013: astore 4
    //   12015: new 2998	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   12018: dup
    //   12019: invokespecial 2999	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   12022: astore 14
    //   12024: aload 14
    //   12026: getfield 3002	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12029: sipush 1814
    //   12032: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12035: aload 14
    //   12037: getfield 3005	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12040: bipush 48
    //   12042: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12045: aload_3
    //   12046: invokevirtual 3008	java/lang/String:getBytes	()[B
    //   12049: arraylength
    //   12050: bipush 6
    //   12052: iadd
    //   12053: invokestatic 3014	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   12056: astore 15
    //   12058: aload 15
    //   12060: aload 4
    //   12062: invokevirtual 1969	java/lang/Integer:intValue	()I
    //   12065: invokevirtual 3016	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   12068: pop
    //   12069: aload 15
    //   12071: aload_3
    //   12072: invokevirtual 3008	java/lang/String:getBytes	()[B
    //   12075: arraylength
    //   12076: i2s
    //   12077: invokevirtual 3020	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   12080: pop
    //   12081: aload 15
    //   12083: aload_3
    //   12084: invokevirtual 3008	java/lang/String:getBytes	()[B
    //   12087: invokevirtual 3023	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   12090: pop
    //   12091: aload 14
    //   12093: getfield 3027	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12096: aload 15
    //   12098: invokevirtual 3030	java/nio/ByteBuffer:array	()[B
    //   12101: invokestatic 3036	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12104: invokevirtual 3041	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   12107: new 281	mqq/app/NewIntent
    //   12110: dup
    //   12111: aload_0
    //   12112: invokevirtual 1552	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   12115: ldc_w 289
    //   12118: invokespecial 292	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12121: astore_3
    //   12122: aload_3
    //   12123: new 795	android/os/Bundle
    //   12126: dup
    //   12127: invokespecial 796	android/os/Bundle:<init>	()V
    //   12130: invokevirtual 3042	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   12133: pop
    //   12134: aload_3
    //   12135: ldc_w 297
    //   12138: ldc_w 3044
    //   12141: invokevirtual 300	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12144: pop
    //   12145: aload_3
    //   12146: ldc 185
    //   12148: aload 14
    //   12150: invokevirtual 3045	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   12153: invokevirtual 307	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   12156: pop
    //   12157: aload_3
    //   12158: ldc_w 3047
    //   12161: iconst_1
    //   12162: invokevirtual 3048	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12165: pop
    //   12166: aload_3
    //   12167: new 3077	adny
    //   12170: dup
    //   12171: aload_0
    //   12172: aload 4
    //   12174: aload_2
    //   12175: aload_1
    //   12176: invokespecial 3080	adny:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V
    //   12179: invokevirtual 316	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   12182: aload_0
    //   12183: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   12186: invokevirtual 894	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   12189: aload_3
    //   12190: invokevirtual 322	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   12193: goto -12009 -> 184
    //   12196: astore_1
    //   12197: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12200: ifeq -12016 -> 184
    //   12203: ldc 196
    //   12205: iconst_2
    //   12206: new 391	java/lang/StringBuilder
    //   12209: dup
    //   12210: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   12213: ldc_w 3053
    //   12216: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12219: aload 5
    //   12221: iconst_0
    //   12222: aaload
    //   12223: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12226: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12229: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12232: goto -12048 -> 184
    //   12235: astore_1
    //   12236: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12239: ifeq -12055 -> 184
    //   12242: ldc 196
    //   12244: iconst_2
    //   12245: new 391	java/lang/StringBuilder
    //   12248: dup
    //   12249: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   12252: ldc_w 3063
    //   12255: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12258: aload 5
    //   12260: iconst_0
    //   12261: aaload
    //   12262: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12265: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12268: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12271: goto -12087 -> 184
    //   12274: ldc_w 3082
    //   12277: aload 4
    //   12279: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12282: ifeq +200 -> 12482
    //   12285: aload_0
    //   12286: new 110	org/json/JSONObject
    //   12289: dup
    //   12290: aload 5
    //   12292: iconst_0
    //   12293: aaload
    //   12294: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12297: ldc_w 1174
    //   12300: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   12303: putfield 2344	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12306: aload_0
    //   12307: invokevirtual 1946	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   12310: astore_1
    //   12311: aload_1
    //   12312: ifnull -12128 -> 184
    //   12315: aload_1
    //   12316: invokeinterface 3084 1 0
    //   12321: istore 6
    //   12323: aload_0
    //   12324: aload_0
    //   12325: getfield 2344	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12328: iconst_1
    //   12329: anewarray 325	java/lang/String
    //   12332: dup
    //   12333: iconst_0
    //   12334: new 391	java/lang/StringBuilder
    //   12337: dup
    //   12338: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   12341: ldc_w 3086
    //   12344: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12347: iload 6
    //   12349: invokevirtual 927	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12352: ldc_w 1225
    //   12355: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12358: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12361: aastore
    //   12362: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12365: goto -12181 -> 184
    //   12368: astore_1
    //   12369: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12372: ifeq -12188 -> 184
    //   12375: aload_0
    //   12376: aload_0
    //   12377: getfield 2344	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12380: iconst_1
    //   12381: anewarray 325	java/lang/String
    //   12384: dup
    //   12385: iconst_0
    //   12386: ldc_w 3088
    //   12389: aastore
    //   12390: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12393: ldc 196
    //   12395: iconst_2
    //   12396: new 391	java/lang/StringBuilder
    //   12399: dup
    //   12400: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   12403: ldc_w 3090
    //   12406: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12409: aload_1
    //   12410: invokevirtual 2961	org/json/JSONException:toString	()Ljava/lang/String;
    //   12413: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12416: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12419: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12422: goto -12238 -> 184
    //   12425: astore_1
    //   12426: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12429: ifeq -12245 -> 184
    //   12432: aload_0
    //   12433: aload_0
    //   12434: getfield 2344	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12437: iconst_1
    //   12438: anewarray 325	java/lang/String
    //   12441: dup
    //   12442: iconst_0
    //   12443: ldc_w 3088
    //   12446: aastore
    //   12447: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12450: ldc 196
    //   12452: iconst_2
    //   12453: new 391	java/lang/StringBuilder
    //   12456: dup
    //   12457: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   12460: ldc_w 3090
    //   12463: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12466: aload_1
    //   12467: invokevirtual 538	java/lang/Exception:toString	()Ljava/lang/String;
    //   12470: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12473: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12476: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12479: goto -12295 -> 184
    //   12482: ldc_w 3092
    //   12485: aload 4
    //   12487: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12490: ifeq +135 -> 12625
    //   12493: aload 5
    //   12495: arraylength
    //   12496: iconst_1
    //   12497: if_icmpgt +128 -> 12625
    //   12500: ldc_w 362
    //   12503: astore_1
    //   12504: aload 5
    //   12506: arraylength
    //   12507: iconst_1
    //   12508: if_icmpne +2838 -> 15346
    //   12511: new 110	org/json/JSONObject
    //   12514: dup
    //   12515: aload 5
    //   12517: iconst_0
    //   12518: aaload
    //   12519: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12522: astore_3
    //   12523: aload_3
    //   12524: ldc_w 835
    //   12527: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   12530: astore_2
    //   12531: aload_2
    //   12532: astore_1
    //   12533: aload_3
    //   12534: ldc_w 1176
    //   12537: invokevirtual 939	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   12540: ifeq +2806 -> 15346
    //   12543: aload_3
    //   12544: ldc_w 1176
    //   12547: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   12550: astore_1
    //   12551: aload_0
    //   12552: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   12555: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   12558: astore_3
    //   12559: aload_3
    //   12560: ifnull -12376 -> 184
    //   12563: aload_3
    //   12564: instanceof 1121
    //   12567: ifeq -12383 -> 184
    //   12570: aload_3
    //   12571: checkcast 1121	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   12574: invokevirtual 3094	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   12577: checkcast 3096	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   12580: iconst_0
    //   12581: aload_2
    //   12582: aload_1
    //   12583: invokevirtual 3099	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:a	(ZLjava/lang/String;Ljava/lang/String;)V
    //   12586: goto -12402 -> 184
    //   12589: astore_1
    //   12590: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   12593: ifeq -12409 -> 184
    //   12596: ldc 196
    //   12598: iconst_4
    //   12599: new 391	java/lang/StringBuilder
    //   12602: dup
    //   12603: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   12606: ldc_w 3101
    //   12609: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12612: aload_1
    //   12613: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12616: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12619: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12622: goto -12438 -> 184
    //   12625: ldc_w 3103
    //   12628: aload 4
    //   12630: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12633: ifeq +256 -> 12889
    //   12636: aload 5
    //   12638: arraylength
    //   12639: iconst_1
    //   12640: if_icmpgt +249 -> 12889
    //   12643: aload 5
    //   12645: arraylength
    //   12646: iconst_1
    //   12647: if_icmpne -12463 -> 184
    //   12650: new 110	org/json/JSONObject
    //   12653: dup
    //   12654: aload 5
    //   12656: iconst_0
    //   12657: aaload
    //   12658: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12661: astore_1
    //   12662: aload_1
    //   12663: ldc_w 2744
    //   12666: iconst_m1
    //   12667: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   12670: istore 6
    //   12672: aload_1
    //   12673: ldc_w 2827
    //   12676: iconst_m1
    //   12677: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   12680: istore 7
    //   12682: aload_0
    //   12683: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   12686: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   12689: astore_1
    //   12690: aload_1
    //   12691: ifnull -12507 -> 184
    //   12694: aload_1
    //   12695: instanceof 1121
    //   12698: ifeq -12514 -> 184
    //   12701: aload_1
    //   12702: checkcast 1121	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   12705: invokevirtual 3094	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   12708: checkcast 3096	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   12711: astore_1
    //   12712: aload_1
    //   12713: ifnull -12529 -> 184
    //   12716: iload 7
    //   12718: iconst_1
    //   12719: if_icmpne +134 -> 12853
    //   12722: aload_1
    //   12723: iconst_0
    //   12724: putfield 3104	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   12727: aload_1
    //   12728: iconst_1
    //   12729: invokevirtual 3105	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:c	(Z)V
    //   12732: iload 6
    //   12734: iconst_1
    //   12735: if_icmpne +136 -> 12871
    //   12738: aload_1
    //   12739: iconst_0
    //   12740: putfield 3104	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   12743: aload_1
    //   12744: iconst_1
    //   12745: invokevirtual 3106	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:d	(Z)V
    //   12748: goto -12564 -> 184
    //   12751: astore_1
    //   12752: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   12755: ifeq -12571 -> 184
    //   12758: ldc 196
    //   12760: iconst_4
    //   12761: new 391	java/lang/StringBuilder
    //   12764: dup
    //   12765: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   12768: ldc_w 3108
    //   12771: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12774: aload_1
    //   12775: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12778: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12781: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12784: goto -12600 -> 184
    //   12787: astore_2
    //   12788: ldc 196
    //   12790: iconst_1
    //   12791: new 391	java/lang/StringBuilder
    //   12794: dup
    //   12795: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   12798: ldc_w 3110
    //   12801: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12804: aload_2
    //   12805: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12808: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12811: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12814: iconst_m1
    //   12815: istore 6
    //   12817: goto -145 -> 12672
    //   12820: astore_1
    //   12821: iconst_m1
    //   12822: istore 7
    //   12824: ldc 196
    //   12826: iconst_1
    //   12827: new 391	java/lang/StringBuilder
    //   12830: dup
    //   12831: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   12834: ldc_w 3112
    //   12837: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12840: aload_1
    //   12841: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12844: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12847: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12850: goto -168 -> 12682
    //   12853: iload 7
    //   12855: ifne -123 -> 12732
    //   12858: aload_1
    //   12859: iconst_1
    //   12860: putfield 3104	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   12863: aload_1
    //   12864: iconst_0
    //   12865: invokevirtual 3105	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:c	(Z)V
    //   12868: goto -136 -> 12732
    //   12871: iload 6
    //   12873: ifne -12689 -> 184
    //   12876: aload_1
    //   12877: iconst_1
    //   12878: putfield 3104	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   12881: aload_1
    //   12882: iconst_0
    //   12883: invokevirtual 3106	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:d	(Z)V
    //   12886: goto -12702 -> 184
    //   12889: ldc_w 3114
    //   12892: aload 4
    //   12894: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12897: ifeq +168 -> 13065
    //   12900: aload 5
    //   12902: arraylength
    //   12903: iconst_1
    //   12904: if_icmpgt +161 -> 13065
    //   12907: aload 5
    //   12909: arraylength
    //   12910: iconst_1
    //   12911: if_icmpne -12727 -> 184
    //   12914: aload 5
    //   12916: arraylength
    //   12917: iconst_1
    //   12918: if_icmpne -12734 -> 184
    //   12921: new 110	org/json/JSONObject
    //   12924: dup
    //   12925: aload 5
    //   12927: iconst_0
    //   12928: aaload
    //   12929: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12932: ldc_w 3116
    //   12935: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   12938: astore_1
    //   12939: aload_0
    //   12940: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   12943: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   12946: astore_2
    //   12947: aload_2
    //   12948: ifnull -12764 -> 184
    //   12951: aload_2
    //   12952: instanceof 1121
    //   12955: ifeq -12771 -> 184
    //   12958: aload_2
    //   12959: checkcast 1121	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   12962: invokevirtual 3094	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   12965: checkcast 3096	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   12968: astore_3
    //   12969: ldc_w 567
    //   12972: aload_1
    //   12973: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12976: ifeq +61 -> 13037
    //   12979: aload_2
    //   12980: ldc_w 3118
    //   12983: invokevirtual 3121	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   12986: checkcast 3123	android/view/inputmethod/InputMethodManager
    //   12989: aload_3
    //   12990: invokevirtual 3124	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   12993: iconst_0
    //   12994: invokevirtual 3128	android/view/inputmethod/InputMethodManager:showSoftInput	(Landroid/view/View;I)Z
    //   12997: pop
    //   12998: goto -12814 -> 184
    //   13001: astore_1
    //   13002: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13005: ifeq -12821 -> 184
    //   13008: ldc 196
    //   13010: iconst_4
    //   13011: new 391	java/lang/StringBuilder
    //   13014: dup
    //   13015: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   13018: ldc_w 3130
    //   13021: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13024: aload_1
    //   13025: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13028: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13031: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13034: goto -12850 -> 184
    //   13037: aload_2
    //   13038: ldc_w 3118
    //   13041: invokevirtual 3121	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13044: checkcast 3123	android/view/inputmethod/InputMethodManager
    //   13047: aload_2
    //   13048: invokevirtual 3134	android/app/Activity:getWindow	()Landroid/view/Window;
    //   13051: invokevirtual 3139	android/view/Window:getDecorView	()Landroid/view/View;
    //   13054: invokevirtual 3143	android/view/View:getWindowToken	()Landroid/os/IBinder;
    //   13057: iconst_0
    //   13058: invokevirtual 3147	android/view/inputmethod/InputMethodManager:hideSoftInputFromWindow	(Landroid/os/IBinder;I)Z
    //   13061: pop
    //   13062: goto -12878 -> 184
    //   13065: ldc_w 3149
    //   13068: aload 4
    //   13070: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13073: ifeq +96 -> 13169
    //   13076: aload 5
    //   13078: arraylength
    //   13079: iconst_1
    //   13080: if_icmpgt +89 -> 13169
    //   13083: aload 5
    //   13085: arraylength
    //   13086: iconst_1
    //   13087: if_icmpne -12903 -> 184
    //   13090: new 110	org/json/JSONObject
    //   13093: dup
    //   13094: aload 5
    //   13096: iconst_0
    //   13097: aaload
    //   13098: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13101: ldc_w 1174
    //   13104: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13107: astore_1
    //   13108: aload_1
    //   13109: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13112: ifne -12928 -> 184
    //   13115: aload_0
    //   13116: aload_1
    //   13117: iconst_1
    //   13118: anewarray 325	java/lang/String
    //   13121: dup
    //   13122: iconst_0
    //   13123: ldc_w 3151
    //   13126: aastore
    //   13127: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13130: goto -12946 -> 184
    //   13133: astore_1
    //   13134: invokestatic 2058	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13137: ifeq -12953 -> 184
    //   13140: ldc 196
    //   13142: iconst_4
    //   13143: new 391	java/lang/StringBuilder
    //   13146: dup
    //   13147: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   13150: ldc_w 3153
    //   13153: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13156: aload_1
    //   13157: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13160: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13163: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13166: goto -12982 -> 184
    //   13169: ldc_w 3155
    //   13172: aload 4
    //   13174: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13177: ifeq +114 -> 13291
    //   13180: aload 5
    //   13182: arraylength
    //   13183: ifle +108 -> 13291
    //   13186: new 110	org/json/JSONObject
    //   13189: dup
    //   13190: aload 5
    //   13192: iconst_0
    //   13193: aaload
    //   13194: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13197: astore_3
    //   13198: aload_0
    //   13199: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13202: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13205: astore_1
    //   13206: aload_0
    //   13207: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13210: invokevirtual 894	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   13213: astore_2
    //   13214: aload_3
    //   13215: ldc_w 2080
    //   13218: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13221: astore_3
    //   13222: aload_3
    //   13223: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13226: ifne -13042 -> 184
    //   13229: aload_1
    //   13230: ifnull -13046 -> 184
    //   13233: aload_2
    //   13234: ifnull -13050 -> 184
    //   13237: aload_1
    //   13238: new 3157	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   13241: dup
    //   13242: aload_3
    //   13243: bipush 90
    //   13245: invokespecial 3159	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   13248: invokestatic 3164	com/tencent/mobileqq/activity/ProfileActivity:b	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)V
    //   13251: goto -13067 -> 184
    //   13254: astore_1
    //   13255: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13258: ifeq -13074 -> 184
    //   13261: ldc_w 2027
    //   13264: iconst_2
    //   13265: new 391	java/lang/StringBuilder
    //   13268: dup
    //   13269: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   13272: ldc_w 3166
    //   13275: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13278: aload_1
    //   13279: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13282: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13285: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13288: goto -13104 -> 184
    //   13291: ldc_w 3168
    //   13294: aload 4
    //   13296: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13299: ifeq +96 -> 13395
    //   13302: aload 5
    //   13304: arraylength
    //   13305: ifle +90 -> 13395
    //   13308: new 110	org/json/JSONObject
    //   13311: dup
    //   13312: aload 5
    //   13314: iconst_0
    //   13315: aaload
    //   13316: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13319: ldc_w 3170
    //   13322: invokevirtual 977	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13325: istore 6
    //   13327: aload_0
    //   13328: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13331: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13334: astore_1
    //   13335: aload_1
    //   13336: ifnull -13152 -> 184
    //   13339: aload_1
    //   13340: instanceof 1121
    //   13343: ifeq -13159 -> 184
    //   13346: aload_1
    //   13347: checkcast 1121	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13350: iload 6
    //   13352: invokevirtual 3171	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:a	(I)V
    //   13355: goto -13171 -> 184
    //   13358: astore_1
    //   13359: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13362: ifeq -13178 -> 184
    //   13365: ldc_w 2027
    //   13368: iconst_2
    //   13369: new 391	java/lang/StringBuilder
    //   13372: dup
    //   13373: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   13376: ldc_w 3173
    //   13379: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13382: aload_1
    //   13383: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13386: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13389: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13392: goto -13208 -> 184
    //   13395: ldc_w 3175
    //   13398: aload 4
    //   13400: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13403: ifeq +267 -> 13670
    //   13406: aload 5
    //   13408: arraylength
    //   13409: ifle +261 -> 13670
    //   13412: new 110	org/json/JSONObject
    //   13415: dup
    //   13416: aload 5
    //   13418: iconst_0
    //   13419: aaload
    //   13420: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13423: astore_3
    //   13424: aload_3
    //   13425: ldc_w 3177
    //   13428: iconst_0
    //   13429: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13432: iconst_1
    //   13433: if_icmpne +176 -> 13609
    //   13436: iconst_1
    //   13437: istore 12
    //   13439: aload_3
    //   13440: ldc_w 3179
    //   13443: invokevirtual 977	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13446: istore 6
    //   13448: aload_3
    //   13449: ldc_w 3181
    //   13452: invokevirtual 977	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13455: istore 7
    //   13457: aload_3
    //   13458: ldc_w 3183
    //   13461: invokevirtual 977	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13464: istore 8
    //   13466: aload_3
    //   13467: ldc_w 3185
    //   13470: iconst_1
    //   13471: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13474: iconst_1
    //   13475: if_icmpne +140 -> 13615
    //   13478: iconst_1
    //   13479: istore 13
    //   13481: aload_3
    //   13482: ldc_w 3187
    //   13485: aconst_null
    //   13486: invokevirtual 2097	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   13489: astore_1
    //   13490: aload_3
    //   13491: ldc_w 3189
    //   13494: aconst_null
    //   13495: invokevirtual 2097	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   13498: astore_2
    //   13499: aload_3
    //   13500: ldc_w 1174
    //   13503: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13506: astore_3
    //   13507: aload_0
    //   13508: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13511: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13514: astore 5
    //   13516: aload_0
    //   13517: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13520: invokevirtual 766	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13523: astore 4
    //   13525: aload_0
    //   13526: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13529: aload 5
    //   13531: invokevirtual 618	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   13534: astore 5
    //   13536: aload 4
    //   13538: ifnull +83 -> 13621
    //   13541: aload 4
    //   13543: getfield 2470	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   13546: ifnull +75 -> 13621
    //   13549: aload 4
    //   13551: getfield 2470	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   13554: iload 12
    //   13556: iload 6
    //   13558: iload 7
    //   13560: iload 8
    //   13562: iload 13
    //   13564: aload_1
    //   13565: aload_2
    //   13566: aload_3
    //   13567: invokevirtual 3192	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(ZIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   13570: goto -13386 -> 184
    //   13573: astore_1
    //   13574: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13577: ifeq -13393 -> 184
    //   13580: ldc 196
    //   13582: iconst_2
    //   13583: new 391	java/lang/StringBuilder
    //   13586: dup
    //   13587: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   13590: ldc_w 3194
    //   13593: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13596: aload_1
    //   13597: invokevirtual 1908	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13600: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13603: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13606: goto -13422 -> 184
    //   13609: iconst_0
    //   13610: istore 12
    //   13612: goto -173 -> 13439
    //   13615: iconst_0
    //   13616: istore 13
    //   13618: goto -137 -> 13481
    //   13621: aload 5
    //   13623: ifnull -13439 -> 184
    //   13626: aload 5
    //   13628: instanceof 1212
    //   13631: ifeq -13447 -> 184
    //   13634: aload 5
    //   13636: checkcast 1212	com/tencent/mobileqq/webviewplugin/WebUiUtils$VipComicUiInterface
    //   13639: iload 12
    //   13641: iload 6
    //   13643: iload 7
    //   13645: iload 8
    //   13647: iload 13
    //   13649: aload_1
    //   13650: aload_2
    //   13651: aload_3
    //   13652: aload_0
    //   13653: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13656: invokevirtual 934	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   13659: invokevirtual 1215	java/lang/Object:hashCode	()I
    //   13662: invokeinterface 3197 10 0
    //   13667: goto -13483 -> 184
    //   13670: ldc_w 3199
    //   13673: aload 4
    //   13675: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13678: ifeq +162 -> 13840
    //   13681: aload 5
    //   13683: arraylength
    //   13684: ifle +156 -> 13840
    //   13687: new 110	org/json/JSONObject
    //   13690: dup
    //   13691: aload 5
    //   13693: iconst_0
    //   13694: aaload
    //   13695: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13698: ldc_w 2829
    //   13701: invokevirtual 977	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13704: istore 6
    //   13706: aload_0
    //   13707: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13710: invokevirtual 934	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   13713: astore_2
    //   13714: aload_2
    //   13715: ifnull -13531 -> 184
    //   13718: iload 6
    //   13720: ifne +24 -> 13744
    //   13723: aload_2
    //   13724: invokevirtual 3202	com/tencent/biz/pubaccount/CustomWebView:reload	()V
    //   13727: goto -13543 -> 184
    //   13730: astore_1
    //   13731: ldc 196
    //   13733: iconst_2
    //   13734: ldc_w 3204
    //   13737: aload_1
    //   13738: invokestatic 1836	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13741: goto -13557 -> 184
    //   13744: aload_0
    //   13745: iconst_4
    //   13746: invokevirtual 2223	com/tencent/mobileqq/jsp/UiApiPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   13749: checkcast 3206	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler
    //   13752: astore_1
    //   13753: aload_1
    //   13754: ifnull -13570 -> 184
    //   13757: aload_2
    //   13758: invokevirtual 3209	com/tencent/biz/pubaccount/CustomWebView:getOriginalUrl	()Ljava/lang/String;
    //   13761: astore_2
    //   13762: aload_1
    //   13763: getfield 3212	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:a	Lcom/tencent/biz/webviewplugin/Share;
    //   13766: ifnonnull +28 -> 13794
    //   13769: aload_1
    //   13770: new 1520	com/tencent/biz/webviewplugin/Share
    //   13773: dup
    //   13774: aload_0
    //   13775: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13778: invokevirtual 894	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   13781: aload_0
    //   13782: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13785: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13788: invokespecial 3215	com/tencent/biz/webviewplugin/Share:<init>	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;)V
    //   13791: putfield 3212	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:a	Lcom/tencent/biz/webviewplugin/Share;
    //   13794: iload 6
    //   13796: iconst_1
    //   13797: if_icmpne +20 -> 13817
    //   13800: aload_1
    //   13801: bipush 6
    //   13803: aload_2
    //   13804: new 795	android/os/Bundle
    //   13807: dup
    //   13808: invokespecial 796	android/os/Bundle:<init>	()V
    //   13811: invokevirtual 3218	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:a	(ILjava/lang/String;Landroid/os/Bundle;)V
    //   13814: goto -13630 -> 184
    //   13817: iload 6
    //   13819: iconst_2
    //   13820: if_icmpne -13636 -> 184
    //   13823: aload_1
    //   13824: bipush 11
    //   13826: aload_2
    //   13827: new 795	android/os/Bundle
    //   13830: dup
    //   13831: invokespecial 796	android/os/Bundle:<init>	()V
    //   13834: invokevirtual 3218	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:a	(ILjava/lang/String;Landroid/os/Bundle;)V
    //   13837: goto -13653 -> 184
    //   13840: ldc_w 3220
    //   13843: aload 4
    //   13845: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13848: ifeq +62 -> 13910
    //   13851: new 126	android/content/Intent
    //   13854: dup
    //   13855: aload_0
    //   13856: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13859: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13862: ldc_w 3222
    //   13865: invokespecial 733	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   13868: astore_1
    //   13869: aload_1
    //   13870: ldc_w 3224
    //   13873: aload 5
    //   13875: iconst_0
    //   13876: aaload
    //   13877: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   13880: pop
    //   13881: aload_0
    //   13882: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13885: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13888: aload_1
    //   13889: sipush 11533
    //   13892: invokevirtual 1032	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   13895: aload_0
    //   13896: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13899: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13902: iconst_0
    //   13903: iconst_0
    //   13904: invokevirtual 1037	android/app/Activity:overridePendingTransition	(II)V
    //   13907: goto -13723 -> 184
    //   13910: ldc_w 3226
    //   13913: aload 4
    //   13915: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13918: ifeq +177 -> 14095
    //   13921: new 110	org/json/JSONObject
    //   13924: dup
    //   13925: aload 5
    //   13927: iconst_0
    //   13928: aaload
    //   13929: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13932: astore_2
    //   13933: aload_2
    //   13934: ldc 157
    //   13936: ldc_w 362
    //   13939: invokevirtual 2097	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   13942: astore_1
    //   13943: aload_0
    //   13944: aload_2
    //   13945: ldc_w 1174
    //   13948: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13951: putfield 1990	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   13954: aload_1
    //   13955: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13958: ifeq +65 -> 14023
    //   13961: new 110	org/json/JSONObject
    //   13964: dup
    //   13965: invokespecial 159	org/json/JSONObject:<init>	()V
    //   13968: astore_1
    //   13969: aload_1
    //   13970: ldc 204
    //   13972: iconst_m1
    //   13973: invokevirtual 183	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   13976: pop
    //   13977: aload_1
    //   13978: ldc 185
    //   13980: ldc_w 362
    //   13983: invokevirtual 167	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   13986: pop
    //   13987: aload_0
    //   13988: aload_0
    //   13989: getfield 1990	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   13992: iconst_1
    //   13993: anewarray 325	java/lang/String
    //   13996: dup
    //   13997: iconst_0
    //   13998: aload_1
    //   13999: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14002: aastore
    //   14003: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14006: goto -13822 -> 184
    //   14009: astore_1
    //   14010: ldc 196
    //   14012: iconst_1
    //   14013: ldc_w 3228
    //   14016: aload_1
    //   14017: invokestatic 1836	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14020: goto -13836 -> 184
    //   14023: aload_2
    //   14024: ldc_w 3230
    //   14027: iconst_0
    //   14028: invokevirtual 852	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   14031: istore 6
    //   14033: new 126	android/content/Intent
    //   14036: dup
    //   14037: invokespecial 218	android/content/Intent:<init>	()V
    //   14040: astore_2
    //   14041: iload 6
    //   14043: ifne +38 -> 14081
    //   14046: aload_2
    //   14047: invokestatic 510	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   14050: ldc_w 1022
    //   14053: invokevirtual 3234	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   14056: pop
    //   14057: aload_2
    //   14058: ldc 157
    //   14060: aload_1
    //   14061: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14064: pop
    //   14065: aload_0
    //   14066: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14069: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14072: aload_2
    //   14073: bipush 14
    //   14075: invokevirtual 1032	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   14078: goto -13894 -> 184
    //   14081: aload_2
    //   14082: invokestatic 510	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   14085: ldc_w 3236
    //   14088: invokevirtual 3234	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   14091: pop
    //   14092: goto -35 -> 14057
    //   14095: ldc_w 3238
    //   14098: aload 4
    //   14100: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14103: ifeq +61 -> 14164
    //   14106: new 110	org/json/JSONObject
    //   14109: dup
    //   14110: aload 5
    //   14112: iconst_0
    //   14113: aaload
    //   14114: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14117: ldc 185
    //   14119: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14122: astore_1
    //   14123: aload_0
    //   14124: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14127: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14130: iconst_m1
    //   14131: new 126	android/content/Intent
    //   14134: dup
    //   14135: invokespecial 218	android/content/Intent:<init>	()V
    //   14138: ldc 185
    //   14140: aload_1
    //   14141: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14144: invokevirtual 229	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   14147: goto -13963 -> 184
    //   14150: astore_1
    //   14151: ldc 196
    //   14153: iconst_1
    //   14154: ldc_w 3240
    //   14157: aload_1
    //   14158: invokestatic 1836	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14161: goto -13977 -> 184
    //   14164: ldc_w 3242
    //   14167: aload 4
    //   14169: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14172: ifne -13988 -> 184
    //   14175: ldc_w 3244
    //   14178: aload 4
    //   14180: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14183: ifeq +99 -> 14282
    //   14186: new 110	org/json/JSONObject
    //   14189: dup
    //   14190: aload 5
    //   14192: iconst_0
    //   14193: aaload
    //   14194: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14197: astore_2
    //   14198: aload_2
    //   14199: ldc_w 1174
    //   14202: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14205: astore_1
    //   14206: aload_2
    //   14207: ldc_w 2827
    //   14210: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14213: iconst_0
    //   14214: iconst_0
    //   14215: invokestatic 3249	com/tencent/mobileqq/vip/CUKingCardHelper:a	(Ljava/lang/String;ZZ)Lcom/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo;
    //   14218: astore_2
    //   14219: new 110	org/json/JSONObject
    //   14222: dup
    //   14223: invokespecial 159	org/json/JSONObject:<init>	()V
    //   14226: astore_3
    //   14227: aload_3
    //   14228: ldc 204
    //   14230: aload_2
    //   14231: getfield 3252	com/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo:jdField_a_of_type_Int	I
    //   14234: invokevirtual 183	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14237: pop
    //   14238: aload_3
    //   14239: ldc 157
    //   14241: aload_2
    //   14242: getfield 3253	com/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14245: invokevirtual 167	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   14248: pop
    //   14249: aload_0
    //   14250: aload_1
    //   14251: iconst_1
    //   14252: anewarray 325	java/lang/String
    //   14255: dup
    //   14256: iconst_0
    //   14257: aload_3
    //   14258: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14261: aastore
    //   14262: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14265: goto -14081 -> 184
    //   14268: astore_1
    //   14269: ldc 196
    //   14271: iconst_1
    //   14272: ldc_w 3255
    //   14275: aload_1
    //   14276: invokestatic 1836	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14279: goto -14095 -> 184
    //   14282: ldc_w 3257
    //   14285: aload 4
    //   14287: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14290: ifeq +221 -> 14511
    //   14293: new 110	org/json/JSONObject
    //   14296: dup
    //   14297: aload 5
    //   14299: iconst_0
    //   14300: aaload
    //   14301: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14304: astore_2
    //   14305: aload_2
    //   14306: ldc_w 1174
    //   14309: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14312: astore_1
    //   14313: aload_2
    //   14314: ldc 161
    //   14316: invokevirtual 977	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14319: istore 6
    //   14321: aload_2
    //   14322: ldc_w 2827
    //   14325: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14328: astore_2
    //   14329: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14332: ifeq +40 -> 14372
    //   14335: ldc 196
    //   14337: iconst_2
    //   14338: new 391	java/lang/StringBuilder
    //   14341: dup
    //   14342: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   14345: ldc_w 3259
    //   14348: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14351: iload 6
    //   14353: invokevirtual 927	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14356: ldc_w 3261
    //   14359: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14362: aload_2
    //   14363: invokevirtual 398	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14366: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14369: invokestatic 2062	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14372: aload_2
    //   14373: iconst_0
    //   14374: iconst_1
    //   14375: invokestatic 3249	com/tencent/mobileqq/vip/CUKingCardHelper:a	(Ljava/lang/String;ZZ)Lcom/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo;
    //   14378: astore_3
    //   14379: new 110	org/json/JSONObject
    //   14382: dup
    //   14383: invokespecial 159	org/json/JSONObject:<init>	()V
    //   14386: astore 4
    //   14388: aload_3
    //   14389: getfield 3252	com/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo:jdField_a_of_type_Int	I
    //   14392: iconst_1
    //   14393: if_icmpne +46 -> 14439
    //   14396: aload 4
    //   14398: ldc 204
    //   14400: iconst_2
    //   14401: invokevirtual 183	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14404: pop
    //   14405: aload_0
    //   14406: aload_1
    //   14407: iconst_1
    //   14408: anewarray 325	java/lang/String
    //   14411: dup
    //   14412: iconst_0
    //   14413: aload 4
    //   14415: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14418: aastore
    //   14419: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14422: goto -14238 -> 184
    //   14425: astore_1
    //   14426: ldc 196
    //   14428: iconst_1
    //   14429: ldc_w 3263
    //   14432: aload_1
    //   14433: invokestatic 1836	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14436: goto -14252 -> 184
    //   14439: aload_3
    //   14440: getfield 3252	com/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo:jdField_a_of_type_Int	I
    //   14443: iconst_4
    //   14444: if_icmpne +32 -> 14476
    //   14447: aload 4
    //   14449: ldc 204
    //   14451: iconst_0
    //   14452: invokevirtual 183	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14455: pop
    //   14456: aload_0
    //   14457: aload_1
    //   14458: iconst_1
    //   14459: anewarray 325	java/lang/String
    //   14462: dup
    //   14463: iconst_0
    //   14464: aload 4
    //   14466: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14469: aastore
    //   14470: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14473: goto -14289 -> 184
    //   14476: new 3265	com/tencent/mobileqq/vip/CUKingCardDialog
    //   14479: dup
    //   14480: aload_0
    //   14481: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14484: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14487: aload_0
    //   14488: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14491: invokevirtual 934	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   14494: aload_1
    //   14495: iload 6
    //   14497: aload_2
    //   14498: aload_3
    //   14499: getfield 3252	com/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo:jdField_a_of_type_Int	I
    //   14502: invokespecial 3268	com/tencent/mobileqq/vip/CUKingCardDialog:<init>	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Ljava/lang/String;ILjava/lang/String;I)V
    //   14505: invokevirtual 3269	com/tencent/mobileqq/vip/CUKingCardDialog:show	()V
    //   14508: goto -14324 -> 184
    //   14511: ldc_w 3271
    //   14514: aload 4
    //   14516: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14519: ifeq +93 -> 14612
    //   14522: new 110	org/json/JSONObject
    //   14525: dup
    //   14526: aload 5
    //   14528: iconst_0
    //   14529: aaload
    //   14530: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14533: astore_2
    //   14534: aload_2
    //   14535: ldc_w 1174
    //   14538: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14541: astore_1
    //   14542: aload_2
    //   14543: ldc_w 2827
    //   14546: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14549: astore_2
    //   14550: new 110	org/json/JSONObject
    //   14553: dup
    //   14554: invokespecial 159	org/json/JSONObject:<init>	()V
    //   14557: astore_3
    //   14558: aload_3
    //   14559: ldc 204
    //   14561: invokestatic 3272	com/tencent/mobileqq/vip/CUKingCardHelper:a	()I
    //   14564: invokevirtual 183	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14567: pop
    //   14568: aload_3
    //   14569: ldc 157
    //   14571: aload_2
    //   14572: invokestatic 3273	com/tencent/mobileqq/vip/CUKingCardHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   14575: invokevirtual 167	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   14578: pop
    //   14579: aload_0
    //   14580: aload_1
    //   14581: iconst_1
    //   14582: anewarray 325	java/lang/String
    //   14585: dup
    //   14586: iconst_0
    //   14587: aload_3
    //   14588: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14591: aastore
    //   14592: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14595: goto -14411 -> 184
    //   14598: astore_1
    //   14599: ldc 196
    //   14601: iconst_1
    //   14602: ldc_w 3255
    //   14605: aload_1
    //   14606: invokestatic 1836	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14609: goto -14425 -> 184
    //   14612: ldc_w 3275
    //   14615: aload 4
    //   14617: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14620: ifeq +128 -> 14748
    //   14623: new 110	org/json/JSONObject
    //   14626: dup
    //   14627: aload 5
    //   14629: iconst_0
    //   14630: aaload
    //   14631: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14634: astore_1
    //   14635: aload_1
    //   14636: ldc_w 2744
    //   14639: invokevirtual 2527	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   14642: istore 12
    //   14644: aload_1
    //   14645: ldc_w 3277
    //   14648: invokevirtual 1043	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   14651: astore_1
    //   14652: aload_1
    //   14653: ifnull -14469 -> 184
    //   14656: aload_1
    //   14657: ldc_w 1231
    //   14660: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   14663: istore 6
    //   14665: aload_1
    //   14666: ldc_w 1233
    //   14669: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   14672: istore 7
    //   14674: new 1235	android/graphics/Rect
    //   14677: dup
    //   14678: iload 6
    //   14680: iload 7
    //   14682: aload_1
    //   14683: ldc_w 1237
    //   14686: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   14689: iload 6
    //   14691: iadd
    //   14692: aload_1
    //   14693: ldc_w 1239
    //   14696: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   14699: iload 7
    //   14701: iadd
    //   14702: invokespecial 1241	android/graphics/Rect:<init>	(IIII)V
    //   14705: astore_1
    //   14706: aload_0
    //   14707: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14710: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14713: astore_2
    //   14714: aload_2
    //   14715: instanceof 1149
    //   14718: ifeq -14534 -> 184
    //   14721: aload_2
    //   14722: checkcast 1149	com/tencent/biz/pubaccount/ecshopassit/EcshopWebActivity
    //   14725: aload_1
    //   14726: iload 12
    //   14728: invokevirtual 3280	com/tencent/biz/pubaccount/ecshopassit/EcshopWebActivity:a	(Landroid/graphics/Rect;Z)V
    //   14731: goto -14547 -> 184
    //   14734: astore_1
    //   14735: ldc 196
    //   14737: iconst_1
    //   14738: ldc_w 3282
    //   14741: aload_1
    //   14742: invokestatic 1836	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14745: goto -14561 -> 184
    //   14748: ldc_w 3284
    //   14751: aload 4
    //   14753: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14756: ifeq +56 -> 14812
    //   14759: new 110	org/json/JSONObject
    //   14762: dup
    //   14763: aload 5
    //   14765: iconst_0
    //   14766: aaload
    //   14767: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14770: astore_1
    //   14771: aload_1
    //   14772: ifnonnull +21 -> 14793
    //   14775: iconst_1
    //   14776: ireturn
    //   14777: astore_1
    //   14778: ldc 196
    //   14780: iconst_1
    //   14781: ldc_w 3286
    //   14784: aload_1
    //   14785: invokestatic 1836	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14788: aconst_null
    //   14789: astore_1
    //   14790: goto -19 -> 14771
    //   14793: invokestatic 3292	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   14796: new 3294	adoa
    //   14799: dup
    //   14800: aload_0
    //   14801: aload_1
    //   14802: invokespecial 3295	adoa:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Lorg/json/JSONObject;)V
    //   14805: invokevirtual 3301	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   14808: pop
    //   14809: goto -14625 -> 184
    //   14812: ldc_w 3303
    //   14815: aload 4
    //   14817: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14820: ifeq +117 -> 14937
    //   14823: new 110	org/json/JSONObject
    //   14826: dup
    //   14827: aload 5
    //   14829: iconst_0
    //   14830: aaload
    //   14831: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14834: astore_1
    //   14835: aload_0
    //   14836: aload_1
    //   14837: ldc_w 1174
    //   14840: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14843: putfield 3305	com/tencent/mobileqq/jsp/UiApiPlugin:j	Ljava/lang/String;
    //   14846: aload_1
    //   14847: ldc_w 2984
    //   14850: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14853: astore_2
    //   14854: aload_1
    //   14855: ldc_w 3307
    //   14858: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14861: astore_3
    //   14862: aload_1
    //   14863: ldc_w 3309
    //   14866: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14869: astore 4
    //   14871: aload_1
    //   14872: ldc_w 3311
    //   14875: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14878: astore 5
    //   14880: aload_1
    //   14881: ldc_w 3313
    //   14884: invokevirtual 977	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14887: istore 6
    //   14889: aload_0
    //   14890: aload_0
    //   14891: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14894: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14897: iconst_3
    //   14898: aload_2
    //   14899: aload_3
    //   14900: sipush 3016
    //   14903: iload 6
    //   14905: aload 4
    //   14907: aload 5
    //   14909: aconst_null
    //   14910: aconst_null
    //   14911: aconst_null
    //   14912: invokestatic 3318	com/tencent/mobileqq/activity/AddFriendLogicActivity:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14915: bipush 16
    //   14917: invokevirtual 1385	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   14920: goto -14736 -> 184
    //   14923: astore_1
    //   14924: ldc 196
    //   14926: iconst_1
    //   14927: ldc_w 3320
    //   14930: aload_1
    //   14931: invokestatic 1836	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14934: goto -14750 -> 184
    //   14937: ldc_w 3322
    //   14940: aload 4
    //   14942: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14945: ifeq +172 -> 15117
    //   14948: new 110	org/json/JSONObject
    //   14951: dup
    //   14952: aload 5
    //   14954: iconst_0
    //   14955: aaload
    //   14956: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14959: astore_3
    //   14960: aload_3
    //   14961: ldc_w 3324
    //   14964: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14967: astore_1
    //   14968: aload_3
    //   14969: ldc_w 1818
    //   14972: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14975: astore_2
    //   14976: aload_3
    //   14977: ldc_w 1831
    //   14980: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14983: astore_3
    //   14984: aload_1
    //   14985: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14988: ifne +66 -> 15054
    //   14991: new 790	java/io/File
    //   14994: dup
    //   14995: aload_1
    //   14996: invokespecial 1363	java/io/File:<init>	(Ljava/lang/String;)V
    //   14999: astore_1
    //   15000: aload_1
    //   15001: invokevirtual 1768	java/io/File:exists	()Z
    //   15004: ifne +42 -> 15046
    //   15007: aload_0
    //   15008: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15011: invokevirtual 894	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   15014: invokevirtual 1731	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   15017: iconst_1
    //   15018: ldc_w 3326
    //   15021: iconst_0
    //   15022: invokestatic 1736	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   15025: invokevirtual 1739	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   15028: pop
    //   15029: goto -14845 -> 184
    //   15032: astore_1
    //   15033: ldc 196
    //   15035: iconst_1
    //   15036: ldc_w 3328
    //   15039: aload_1
    //   15040: invokestatic 1836	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15043: goto -14859 -> 184
    //   15046: aload_0
    //   15047: aload_1
    //   15048: invokevirtual 1365	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/io/File;)V
    //   15051: goto -14867 -> 184
    //   15054: aload_2
    //   15055: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15058: ifne +19 -> 15077
    //   15061: aload_0
    //   15062: aload_2
    //   15063: iconst_0
    //   15064: invokestatic 1827	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   15067: aload_2
    //   15068: invokestatic 1821	com/tencent/open/base/MD5Utils:d	(Ljava/lang/String;)Ljava/lang/String;
    //   15071: invokevirtual 3330	com/tencent/mobileqq/jsp/UiApiPlugin:a	([BLjava/lang/String;)V
    //   15074: goto -14890 -> 184
    //   15077: aload_3
    //   15078: invokestatic 410	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15081: ifne +11 -> 15092
    //   15084: aload_0
    //   15085: aload_3
    //   15086: invokevirtual 3332	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Ljava/lang/String;)V
    //   15089: goto -14905 -> 184
    //   15092: aload_0
    //   15093: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15096: invokevirtual 894	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   15099: invokevirtual 1731	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   15102: iconst_1
    //   15103: ldc_w 1733
    //   15106: iconst_0
    //   15107: invokestatic 1736	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   15110: invokevirtual 1739	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   15113: pop
    //   15114: goto -14930 -> 184
    //   15117: ldc_w 3334
    //   15120: aload 4
    //   15122: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15125: ifeq +44 -> 15169
    //   15128: aload_0
    //   15129: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15132: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   15135: iconst_m1
    //   15136: new 126	android/content/Intent
    //   15139: dup
    //   15140: invokespecial 218	android/content/Intent:<init>	()V
    //   15143: ldc_w 3336
    //   15146: aload 5
    //   15148: iconst_0
    //   15149: aaload
    //   15150: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   15153: invokevirtual 229	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   15156: aload_0
    //   15157: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15160: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   15163: invokevirtual 232	android/app/Activity:finish	()V
    //   15166: goto -14982 -> 184
    //   15169: ldc_w 3338
    //   15172: aload 4
    //   15174: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15177: ifeq +13 -> 15190
    //   15180: aload_0
    //   15181: aload 5
    //   15183: iconst_0
    //   15184: aaload
    //   15185: invokevirtual 3340	com/tencent/mobileqq/jsp/UiApiPlugin:d	(Ljava/lang/String;)V
    //   15188: iconst_1
    //   15189: ireturn
    //   15190: ldc_w 3342
    //   15193: aload 4
    //   15195: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15198: ifeq +27 -> 15225
    //   15201: aload_0
    //   15202: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15205: invokevirtual 766	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   15208: astore_1
    //   15209: aload_1
    //   15210: instanceof 3344
    //   15213: ifeq +10 -> 15223
    //   15216: aload_1
    //   15217: checkcast 3344	com/tencent/mobileqq/now/enter/NowFestivalWebViewFragment
    //   15220: invokevirtual 3345	com/tencent/mobileqq/now/enter/NowFestivalWebViewFragment:f	()V
    //   15223: iconst_1
    //   15224: ireturn
    //   15225: ldc_w 3347
    //   15228: aload 4
    //   15230: invokevirtual 571	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15233: ifeq -15049 -> 184
    //   15236: aload 5
    //   15238: arraylength
    //   15239: iconst_1
    //   15240: if_icmpne -15056 -> 184
    //   15243: new 110	org/json/JSONObject
    //   15246: dup
    //   15247: aload 5
    //   15249: iconst_0
    //   15250: aaload
    //   15251: invokespecial 830	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15254: astore_1
    //   15255: aload_1
    //   15256: ldc_w 1174
    //   15259: invokevirtual 838	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15262: astore_2
    //   15263: new 3349	com/tencent/mobileqq/troop/widget/TroopPickerViewHelper
    //   15266: dup
    //   15267: aload_1
    //   15268: ldc_w 3351
    //   15271: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15274: aload_1
    //   15275: ldc_w 3353
    //   15278: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15281: aload_1
    //   15282: ldc_w 3355
    //   15285: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15288: aload_1
    //   15289: ldc_w 3357
    //   15292: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15295: aload_1
    //   15296: ldc_w 3359
    //   15299: invokevirtual 2035	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   15302: invokespecial 3362	com/tencent/mobileqq/troop/widget/TroopPickerViewHelper:<init>	(IIIIJ)V
    //   15305: aload_0
    //   15306: getfield 604	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15309: invokevirtual 609	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   15312: new 3364	adod
    //   15315: dup
    //   15316: aload_0
    //   15317: aload_2
    //   15318: invokespecial 3365	adod:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   15321: invokevirtual 3368	com/tencent/mobileqq/troop/widget/TroopPickerViewHelper:a	(Landroid/app/Activity;Lcom/tencent/mobileqq/troop/widget/TroopPickerViewHelper$OnConfirmListener;)V
    //   15324: goto -15140 -> 184
    //   15327: astore_1
    //   15328: aload_1
    //   15329: invokevirtual 2227	org/json/JSONException:printStackTrace	()V
    //   15332: goto -15148 -> 184
    //   15335: iconst_0
    //   15336: ireturn
    //   15337: astore_2
    //   15338: goto -5226 -> 10112
    //   15341: astore 15
    //   15343: goto -11550 -> 3793
    //   15346: aload_1
    //   15347: astore_2
    //   15348: ldc_w 362
    //   15351: astore_1
    //   15352: goto -2801 -> 12551
    //   15355: aconst_null
    //   15356: astore_1
    //   15357: aload_3
    //   15358: astore_2
    //   15359: goto -4951 -> 10408
    //   15362: goto -6146 -> 9216
    //   15365: aconst_null
    //   15366: astore_1
    //   15367: goto -8476 -> 6891
    //   15370: aconst_null
    //   15371: astore_1
    //   15372: goto -8718 -> 6654
    //   15375: iconst_0
    //   15376: istore 6
    //   15378: goto -8769 -> 6609
    //   15381: aconst_null
    //   15382: astore_1
    //   15383: goto -8942 -> 6441
    //   15386: goto -15202 -> 184
    //   15389: iload 7
    //   15391: istore 6
    //   15393: goto -14817 -> 576
    //   15396: iconst_1
    //   15397: ireturn
    //   15398: iconst_1
    //   15399: ireturn
    //   15400: iconst_1
    //   15401: ireturn
    //   15402: iconst_1
    //   15403: ireturn
    //   15404: iconst_1
    //   15405: ireturn
    //   15406: astore_1
    //   15407: goto -15223 -> 184
    //   15410: iconst_1
    //   15411: ireturn
    //   15412: iload 6
    //   15414: tableswitch	default:+18 -> 15432, 1001:+-11165->4249
    //   15433: <illegal opcode>
    //   15434: dcmpl
    //   15435: iconst_0
    //   15436: istore 12
    //   15438: goto -10696 -> 4742
    //   15441: iconst_0
    //   15442: istore 12
    //   15444: goto -10304 -> 5140
    //   15447: iload 6
    //   15449: ldc_w 1273
    //   15452: ior
    //   15453: istore 6
    //   15455: goto -9487 -> 5968
    //   15458: iload 6
    //   15460: iconst_1
    //   15461: iadd
    //   15462: istore 6
    //   15464: goto -9115 -> 6349
    //   15467: iload 6
    //   15469: iconst_1
    //   15470: iadd
    //   15471: istore 6
    //   15473: goto -4878 -> 10595
    //   15476: iconst_1
    //   15477: ireturn
    //   15478: iconst_1
    //   15479: ireturn
    //   15480: iconst_1
    //   15481: ireturn
    //   15482: iconst_1
    //   15483: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	15484	0	this	UiApiPlugin
    //   0	15484	1	paramJsBridgeListener	JsBridgeListener
    //   0	15484	2	paramString1	String
    //   0	15484	3	paramString2	String
    //   0	15484	4	paramString3	String
    //   0	15484	5	paramVarArgs	String[]
    //   268	15204	6	n	int
    //   526	14864	7	i1	int
    //   516	13130	8	i2	int
    //   4841	211	9	i3	int
    //   259	7207	10	l1	long
    //   1574	13869	12	bool1	boolean
    //   3071	10577	13	bool2	boolean
    //   877	11272	14	localObject1	Object
    //   3049	9048	15	localObject2	Object
    //   15341	1	15	localJSONException	JSONException
    //   10342	53	16	str	String
    // Exception table:
    //   from	to	target	type
    //   33	91	186	org/json/JSONException
    //   96	176	186	org/json/JSONException
    //   176	184	186	org/json/JSONException
    //   240	355	358	org/json/JSONException
    //   445	453	601	org/json/JSONException
    //   459	508	601	org/json/JSONException
    //   508	525	601	org/json/JSONException
    //   576	598	601	org/json/JSONException
    //   662	693	601	org/json/JSONException
    //   707	732	793	org/json/JSONException
    //   734	790	793	org/json/JSONException
    //   824	853	999	org/json/JSONException
    //   855	951	999	org/json/JSONException
    //   957	965	999	org/json/JSONException
    //   969	981	999	org/json/JSONException
    //   981	996	999	org/json/JSONException
    //   1025	1043	999	org/json/JSONException
    //   1057	1097	1100	org/json/JSONException
    //   1132	1139	1147	java/lang/Exception
    //   1132	1139	1156	finally
    //   1289	1306	1309	org/json/JSONException
    //   1347	1355	1407	org/json/JSONException
    //   1359	1366	1407	org/json/JSONException
    //   1369	1404	1407	org/json/JSONException
    //   1445	1453	1486	org/json/JSONException
    //   1457	1464	1486	org/json/JSONException
    //   1467	1483	1486	org/json/JSONException
    //   1524	1532	1603	org/json/JSONException
    //   1536	1543	1603	org/json/JSONException
    //   1546	1600	1603	org/json/JSONException
    //   1641	1649	1681	org/json/JSONException
    //   1653	1660	1681	org/json/JSONException
    //   1663	1678	1681	org/json/JSONException
    //   1719	1727	1759	java/lang/Exception
    //   1731	1738	1759	java/lang/Exception
    //   1741	1756	1759	java/lang/Exception
    //   2021	2082	2172	org/json/JSONException
    //   2084	2155	2172	org/json/JSONException
    //   2157	2169	2172	org/json/JSONException
    //   2205	2251	2172	org/json/JSONException
    //   2272	2305	2356	org/json/JSONException
    //   2309	2329	2356	org/json/JSONException
    //   2329	2345	2356	org/json/JSONException
    //   2349	2353	2356	org/json/JSONException
    //   2382	2403	2406	org/json/JSONException
    //   2432	2465	2492	org/json/JSONException
    //   2469	2489	2492	org/json/JSONException
    //   2518	2551	2611	org/json/JSONException
    //   2555	2575	2611	org/json/JSONException
    //   2637	2670	2730	org/json/JSONException
    //   2674	2694	2730	org/json/JSONException
    //   2756	2789	2849	org/json/JSONException
    //   2793	2813	2849	org/json/JSONException
    //   2875	2908	2968	org/json/JSONException
    //   2912	2932	2968	org/json/JSONException
    //   3223	3228	3231	java/lang/Exception
    //   2994	3016	3235	org/json/JSONException
    //   3021	3029	3235	org/json/JSONException
    //   3032	3136	3235	org/json/JSONException
    //   3143	3159	3235	org/json/JSONException
    //   3159	3168	3235	org/json/JSONException
    //   3175	3191	3235	org/json/JSONException
    //   3191	3200	3235	org/json/JSONException
    //   3200	3223	3235	org/json/JSONException
    //   3223	3228	3235	org/json/JSONException
    //   3261	3359	3362	org/json/JSONException
    //   3377	3384	3362	org/json/JSONException
    //   3402	3467	3362	org/json/JSONException
    //   3470	3477	3362	org/json/JSONException
    //   3480	3506	3362	org/json/JSONException
    //   3510	3550	3362	org/json/JSONException
    //   3553	3588	3362	org/json/JSONException
    //   3592	3647	3362	org/json/JSONException
    //   3261	3359	3387	java/lang/Exception
    //   3377	3384	3387	java/lang/Exception
    //   3402	3467	3387	java/lang/Exception
    //   3470	3477	3387	java/lang/Exception
    //   3480	3506	3387	java/lang/Exception
    //   3510	3550	3387	java/lang/Exception
    //   3553	3588	3387	java/lang/Exception
    //   3592	3647	3387	java/lang/Exception
    //   3691	3756	3862	java/lang/Exception
    //   3756	3766	3862	java/lang/Exception
    //   3766	3775	3862	java/lang/Exception
    //   3780	3793	3862	java/lang/Exception
    //   3793	3859	3862	java/lang/Exception
    //   3924	3932	3862	java/lang/Exception
    //   3935	3962	3862	java/lang/Exception
    //   3965	4027	3862	java/lang/Exception
    //   4027	4046	3862	java/lang/Exception
    //   4112	4195	3862	java/lang/Exception
    //   4198	4214	3862	java/lang/Exception
    //   4262	4369	3862	java/lang/Exception
    //   3675	3687	3917	org/json/JSONException
    //   3756	3766	3923	org/json/JSONException
    //   4046	4060	4108	java/lang/Exception
    //   4063	4098	4108	java/lang/Exception
    //   4098	4105	4108	java/lang/Exception
    //   4217	4246	4108	java/lang/Exception
    //   4249	4259	4108	java/lang/Exception
    //   4408	4435	5515	org/json/JSONException
    //   4437	4446	5515	org/json/JSONException
    //   4453	4501	5515	org/json/JSONException
    //   4505	4527	5515	org/json/JSONException
    //   4527	4563	5515	org/json/JSONException
    //   4563	4582	5515	org/json/JSONException
    //   4587	4629	5515	org/json/JSONException
    //   4633	4641	5515	org/json/JSONException
    //   4641	4683	5515	org/json/JSONException
    //   4698	4718	5515	org/json/JSONException
    //   4718	4739	5515	org/json/JSONException
    //   4742	4749	5515	org/json/JSONException
    //   4749	4888	5515	org/json/JSONException
    //   4888	4943	5515	org/json/JSONException
    //   4943	4979	5515	org/json/JSONException
    //   4986	5003	5515	org/json/JSONException
    //   5009	5058	5515	org/json/JSONException
    //   5062	5066	5515	org/json/JSONException
    //   5066	5091	5515	org/json/JSONException
    //   5091	5097	5515	org/json/JSONException
    //   5097	5116	5515	org/json/JSONException
    //   5125	5131	5515	org/json/JSONException
    //   5140	5174	5515	org/json/JSONException
    //   5174	5198	5515	org/json/JSONException
    //   5198	5216	5515	org/json/JSONException
    //   5216	5235	5515	org/json/JSONException
    //   5241	5246	5515	org/json/JSONException
    //   5246	5268	5515	org/json/JSONException
    //   5268	5302	5515	org/json/JSONException
    //   5302	5330	5515	org/json/JSONException
    //   5330	5349	5515	org/json/JSONException
    //   5354	5378	5515	org/json/JSONException
    //   5378	5386	5515	org/json/JSONException
    //   5386	5405	5515	org/json/JSONException
    //   5414	5433	5515	org/json/JSONException
    //   5433	5437	5515	org/json/JSONException
    //   5437	5457	5515	org/json/JSONException
    //   5461	5467	5515	org/json/JSONException
    //   5467	5487	5515	org/json/JSONException
    //   5491	5512	5515	org/json/JSONException
    //   5551	5563	5515	org/json/JSONException
    //   5602	5615	5515	org/json/JSONException
    //   5618	5628	5515	org/json/JSONException
    //   5633	5639	5515	org/json/JSONException
    //   5642	5660	5515	org/json/JSONException
    //   5660	5669	5515	org/json/JSONException
    //   5672	5692	5515	org/json/JSONException
    //   5695	5701	5515	org/json/JSONException
    //   5706	5728	5515	org/json/JSONException
    //   5735	5799	5515	org/json/JSONException
    //   5799	5806	5515	org/json/JSONException
    //   5810	5820	5515	org/json/JSONException
    //   5820	5853	5515	org/json/JSONException
    //   5853	5890	5515	org/json/JSONException
    //   5893	5902	5515	org/json/JSONException
    //   5905	5921	5515	org/json/JSONException
    //   5924	5954	5515	org/json/JSONException
    //   5968	5981	5515	org/json/JSONException
    //   5984	5998	5515	org/json/JSONException
    //   6007	6026	5515	org/json/JSONException
    //   4408	4435	5566	java/lang/Exception
    //   4437	4446	5566	java/lang/Exception
    //   4453	4501	5566	java/lang/Exception
    //   4505	4527	5566	java/lang/Exception
    //   4527	4563	5566	java/lang/Exception
    //   4563	4582	5566	java/lang/Exception
    //   4587	4629	5566	java/lang/Exception
    //   4633	4641	5566	java/lang/Exception
    //   4641	4683	5566	java/lang/Exception
    //   4698	4718	5566	java/lang/Exception
    //   4718	4739	5566	java/lang/Exception
    //   4742	4749	5566	java/lang/Exception
    //   4749	4888	5566	java/lang/Exception
    //   4888	4943	5566	java/lang/Exception
    //   4943	4979	5566	java/lang/Exception
    //   4986	5003	5566	java/lang/Exception
    //   5009	5058	5566	java/lang/Exception
    //   5062	5066	5566	java/lang/Exception
    //   5066	5091	5566	java/lang/Exception
    //   5091	5097	5566	java/lang/Exception
    //   5097	5116	5566	java/lang/Exception
    //   5125	5131	5566	java/lang/Exception
    //   5140	5174	5566	java/lang/Exception
    //   5174	5198	5566	java/lang/Exception
    //   5198	5216	5566	java/lang/Exception
    //   5216	5235	5566	java/lang/Exception
    //   5241	5246	5566	java/lang/Exception
    //   5246	5268	5566	java/lang/Exception
    //   5268	5302	5566	java/lang/Exception
    //   5302	5330	5566	java/lang/Exception
    //   5330	5349	5566	java/lang/Exception
    //   5354	5378	5566	java/lang/Exception
    //   5378	5386	5566	java/lang/Exception
    //   5386	5405	5566	java/lang/Exception
    //   5414	5433	5566	java/lang/Exception
    //   5433	5437	5566	java/lang/Exception
    //   5437	5457	5566	java/lang/Exception
    //   5461	5467	5566	java/lang/Exception
    //   5467	5487	5566	java/lang/Exception
    //   5491	5512	5566	java/lang/Exception
    //   5551	5563	5566	java/lang/Exception
    //   5602	5615	5566	java/lang/Exception
    //   5618	5628	5566	java/lang/Exception
    //   5633	5639	5566	java/lang/Exception
    //   5642	5660	5566	java/lang/Exception
    //   5660	5669	5566	java/lang/Exception
    //   5672	5692	5566	java/lang/Exception
    //   5695	5701	5566	java/lang/Exception
    //   5706	5728	5566	java/lang/Exception
    //   5735	5799	5566	java/lang/Exception
    //   5799	5806	5566	java/lang/Exception
    //   5810	5820	5566	java/lang/Exception
    //   5820	5853	5566	java/lang/Exception
    //   5853	5890	5566	java/lang/Exception
    //   5893	5902	5566	java/lang/Exception
    //   5905	5921	5566	java/lang/Exception
    //   5924	5954	5566	java/lang/Exception
    //   5968	5981	5566	java/lang/Exception
    //   5984	5998	5566	java/lang/Exception
    //   6007	6026	5566	java/lang/Exception
    //   6047	6072	6485	org/json/JSONException
    //   6074	6107	6485	org/json/JSONException
    //   6107	6128	6485	org/json/JSONException
    //   6128	6163	6485	org/json/JSONException
    //   6173	6214	6485	org/json/JSONException
    //   6214	6238	6485	org/json/JSONException
    //   6238	6262	6485	org/json/JSONException
    //   6262	6290	6485	org/json/JSONException
    //   6290	6302	6485	org/json/JSONException
    //   6311	6346	6485	org/json/JSONException
    //   6356	6393	6485	org/json/JSONException
    //   6396	6404	6485	org/json/JSONException
    //   6408	6413	6485	org/json/JSONException
    //   6417	6425	6485	org/json/JSONException
    //   6429	6441	6485	org/json/JSONException
    //   6445	6462	6485	org/json/JSONException
    //   6466	6482	6485	org/json/JSONException
    //   6539	6564	6669	org/json/JSONException
    //   6566	6609	6669	org/json/JSONException
    //   6609	6617	6669	org/json/JSONException
    //   6621	6626	6669	org/json/JSONException
    //   6630	6638	6669	org/json/JSONException
    //   6642	6654	6669	org/json/JSONException
    //   6658	6666	6669	org/json/JSONException
    //   6723	6748	6903	org/json/JSONException
    //   6750	6779	6903	org/json/JSONException
    //   6779	6800	6903	org/json/JSONException
    //   6800	6821	6903	org/json/JSONException
    //   6821	6846	6903	org/json/JSONException
    //   6846	6854	6903	org/json/JSONException
    //   6858	6863	6903	org/json/JSONException
    //   6867	6875	6903	org/json/JSONException
    //   6879	6891	6903	org/json/JSONException
    //   6895	6900	6903	org/json/JSONException
    //   6957	6983	7021	org/json/JSONException
    //   6983	6998	7021	org/json/JSONException
    //   7002	7018	7021	org/json/JSONException
    //   7075	7168	7224	org/json/JSONException
    //   7168	7221	7224	org/json/JSONException
    //   7278	7341	7490	org/json/JSONException
    //   7345	7352	7490	org/json/JSONException
    //   7352	7367	7490	org/json/JSONException
    //   7369	7410	7490	org/json/JSONException
    //   7412	7420	7490	org/json/JSONException
    //   7424	7487	7490	org/json/JSONException
    //   7544	7610	7744	org/json/JSONException
    //   7614	7621	7744	org/json/JSONException
    //   7621	7636	7744	org/json/JSONException
    //   7638	7646	7744	org/json/JSONException
    //   7655	7724	7744	org/json/JSONException
    //   7724	7741	7744	org/json/JSONException
    //   7780	7800	7744	org/json/JSONException
    //   7821	7873	7895	org/json/JSONException
    //   7875	7892	7895	org/json/JSONException
    //   7962	7968	8253	org/json/JSONException
    //   7973	8002	8253	org/json/JSONException
    //   8007	8020	8253	org/json/JSONException
    //   8025	8035	8253	org/json/JSONException
    //   8040	8050	8253	org/json/JSONException
    //   8055	8064	8253	org/json/JSONException
    //   8072	8080	8253	org/json/JSONException
    //   8084	8093	8253	org/json/JSONException
    //   8102	8110	8253	org/json/JSONException
    //   8114	8125	8253	org/json/JSONException
    //   8129	8145	8253	org/json/JSONException
    //   8201	8212	8253	org/json/JSONException
    //   8216	8225	8253	org/json/JSONException
    //   8229	8239	8253	org/json/JSONException
    //   8243	8250	8253	org/json/JSONException
    //   8318	8327	8253	org/json/JSONException
    //   7962	7968	8334	finally
    //   7973	8002	8334	finally
    //   8007	8020	8334	finally
    //   8025	8035	8334	finally
    //   8040	8050	8334	finally
    //   8055	8064	8334	finally
    //   8072	8080	8334	finally
    //   8084	8093	8334	finally
    //   8102	8110	8334	finally
    //   8114	8125	8334	finally
    //   8129	8145	8334	finally
    //   8201	8212	8334	finally
    //   8216	8225	8334	finally
    //   8229	8239	8334	finally
    //   8243	8250	8334	finally
    //   8256	8266	8334	finally
    //   8318	8327	8334	finally
    //   8400	8431	8481	org/json/JSONException
    //   8434	8449	8481	org/json/JSONException
    //   8452	8461	8481	org/json/JSONException
    //   8466	8472	8481	org/json/JSONException
    //   8472	8478	8481	org/json/JSONException
    //   8517	8521	8481	org/json/JSONException
    //   8524	8562	8481	org/json/JSONException
    //   8567	8591	8481	org/json/JSONException
    //   8591	8605	8481	org/json/JSONException
    //   8608	8632	8481	org/json/JSONException
    //   8653	8760	8763	org/json/JSONException
    //   8653	8760	8799	java/lang/Exception
    //   8874	8886	9059	java/lang/Exception
    //   8888	8896	9059	java/lang/Exception
    //   8898	8910	9059	java/lang/Exception
    //   8912	8921	9059	java/lang/Exception
    //   8923	8932	9059	java/lang/Exception
    //   8937	8947	9059	java/lang/Exception
    //   8949	8958	9059	java/lang/Exception
    //   8960	8968	9059	java/lang/Exception
    //   8970	8979	9059	java/lang/Exception
    //   8986	8995	9059	java/lang/Exception
    //   8997	9006	9059	java/lang/Exception
    //   9008	9018	9059	java/lang/Exception
    //   9020	9029	9059	java/lang/Exception
    //   9031	9047	9059	java/lang/Exception
    //   9049	9056	9059	java/lang/Exception
    //   9135	9148	9485	java/lang/Exception
    //   9150	9159	9485	java/lang/Exception
    //   9161	9173	9485	java/lang/Exception
    //   9175	9185	9485	java/lang/Exception
    //   9187	9197	9485	java/lang/Exception
    //   9202	9210	9485	java/lang/Exception
    //   9218	9228	9485	java/lang/Exception
    //   9230	9240	9485	java/lang/Exception
    //   9242	9252	9485	java/lang/Exception
    //   9254	9260	9485	java/lang/Exception
    //   9262	9292	9485	java/lang/Exception
    //   9294	9301	9485	java/lang/Exception
    //   9303	9312	9485	java/lang/Exception
    //   9314	9324	9485	java/lang/Exception
    //   9326	9335	9485	java/lang/Exception
    //   9337	9347	9485	java/lang/Exception
    //   9349	9360	9485	java/lang/Exception
    //   9362	9372	9485	java/lang/Exception
    //   9374	9382	9485	java/lang/Exception
    //   9384	9394	9485	java/lang/Exception
    //   9396	9404	9485	java/lang/Exception
    //   9406	9416	9485	java/lang/Exception
    //   9418	9435	9485	java/lang/Exception
    //   9437	9444	9485	java/lang/Exception
    //   9519	9531	9622	java/lang/Exception
    //   9533	9541	9622	java/lang/Exception
    //   9543	9553	9622	java/lang/Exception
    //   9555	9564	9622	java/lang/Exception
    //   9566	9581	9622	java/lang/Exception
    //   9587	9594	9622	java/lang/Exception
    //   9596	9601	9622	java/lang/Exception
    //   9611	9619	9622	java/lang/Exception
    //   9667	9676	9622	java/lang/Exception
    //   9690	9699	9622	java/lang/Exception
    //   9723	9735	9826	java/lang/Exception
    //   9737	9745	9826	java/lang/Exception
    //   9747	9757	9826	java/lang/Exception
    //   9759	9768	9826	java/lang/Exception
    //   9770	9785	9826	java/lang/Exception
    //   9791	9798	9826	java/lang/Exception
    //   9800	9805	9826	java/lang/Exception
    //   9815	9823	9826	java/lang/Exception
    //   9871	9880	9826	java/lang/Exception
    //   9894	9903	9826	java/lang/Exception
    //   10027	10060	10092	java/lang/Exception
    //   9980	10017	10111	java/lang/Exception
    //   10093	10103	10111	java/lang/Exception
    //   10223	10236	10462	java/lang/Exception
    //   10241	10250	10462	java/lang/Exception
    //   10255	10264	10462	java/lang/Exception
    //   10269	10279	10462	java/lang/Exception
    //   10284	10293	10462	java/lang/Exception
    //   10298	10309	10462	java/lang/Exception
    //   10319	10329	10462	java/lang/Exception
    //   10334	10344	10462	java/lang/Exception
    //   10349	10358	10462	java/lang/Exception
    //   10363	10371	10462	java/lang/Exception
    //   10376	10384	10462	java/lang/Exception
    //   10389	10404	10462	java/lang/Exception
    //   10440	10454	10462	java/lang/Exception
    //   10532	10588	10717	org/json/JSONException
    //   10591	10595	10717	org/json/JSONException
    //   10602	10613	10717	org/json/JSONException
    //   10619	10645	10717	org/json/JSONException
    //   10648	10679	10717	org/json/JSONException
    //   10679	10705	10717	org/json/JSONException
    //   10705	10714	10717	org/json/JSONException
    //   10757	10779	10717	org/json/JSONException
    //   10799	10814	10817	org/json/JSONException
    //   10891	10912	10915	org/json/JSONException
    //   10965	10982	10996	org/json/JSONException
    //   10986	10993	10996	org/json/JSONException
    //   10965	10982	11035	java/lang/Exception
    //   10986	10993	11035	java/lang/Exception
    //   11091	11125	11243	java/lang/Exception
    //   11127	11161	11243	java/lang/Exception
    //   11165	11187	11243	java/lang/Exception
    //   11187	11240	11243	java/lang/Exception
    //   11287	11339	11359	java/lang/Exception
    //   11339	11356	11359	java/lang/Exception
    //   11380	11432	11683	org/json/JSONException
    //   11435	11443	11683	org/json/JSONException
    //   11447	11454	11683	org/json/JSONException
    //   11454	11470	11683	org/json/JSONException
    //   11473	11493	11683	org/json/JSONException
    //   11499	11680	11683	org/json/JSONException
    //   11727	11748	11683	org/json/JSONException
    //   11748	11769	11683	org/json/JSONException
    //   11380	11432	11772	java/lang/Exception
    //   11435	11443	11772	java/lang/Exception
    //   11447	11454	11772	java/lang/Exception
    //   11454	11470	11772	java/lang/Exception
    //   11473	11493	11772	java/lang/Exception
    //   11499	11680	11772	java/lang/Exception
    //   11727	11748	11772	java/lang/Exception
    //   11748	11769	11772	java/lang/Exception
    //   11865	11915	12196	org/json/JSONException
    //   11915	11958	12196	org/json/JSONException
    //   11961	11970	12196	org/json/JSONException
    //   11975	11983	12196	org/json/JSONException
    //   11983	11999	12196	org/json/JSONException
    //   12002	12193	12196	org/json/JSONException
    //   11865	11915	12235	java/lang/Exception
    //   11915	11958	12235	java/lang/Exception
    //   11961	11970	12235	java/lang/Exception
    //   11975	11983	12235	java/lang/Exception
    //   11983	11999	12235	java/lang/Exception
    //   12002	12193	12235	java/lang/Exception
    //   12285	12311	12368	org/json/JSONException
    //   12315	12365	12368	org/json/JSONException
    //   12285	12311	12425	java/lang/Exception
    //   12315	12365	12425	java/lang/Exception
    //   12504	12531	12589	org/json/JSONException
    //   12533	12551	12589	org/json/JSONException
    //   12551	12559	12589	org/json/JSONException
    //   12563	12586	12589	org/json/JSONException
    //   12643	12662	12751	org/json/JSONException
    //   12662	12672	12751	org/json/JSONException
    //   12672	12682	12751	org/json/JSONException
    //   12682	12690	12751	org/json/JSONException
    //   12694	12712	12751	org/json/JSONException
    //   12722	12732	12751	org/json/JSONException
    //   12738	12748	12751	org/json/JSONException
    //   12788	12814	12751	org/json/JSONException
    //   12824	12850	12751	org/json/JSONException
    //   12858	12868	12751	org/json/JSONException
    //   12876	12886	12751	org/json/JSONException
    //   12662	12672	12787	java/lang/Exception
    //   12672	12682	12820	java/lang/Exception
    //   12907	12947	13001	org/json/JSONException
    //   12951	12998	13001	org/json/JSONException
    //   13037	13062	13001	org/json/JSONException
    //   13090	13130	13133	org/json/JSONException
    //   13186	13229	13254	org/json/JSONException
    //   13237	13251	13254	org/json/JSONException
    //   13308	13335	13358	org/json/JSONException
    //   13339	13355	13358	org/json/JSONException
    //   13412	13436	13573	org/json/JSONException
    //   13439	13478	13573	org/json/JSONException
    //   13481	13536	13573	org/json/JSONException
    //   13541	13570	13573	org/json/JSONException
    //   13626	13667	13573	org/json/JSONException
    //   13687	13714	13730	org/json/JSONException
    //   13723	13727	13730	org/json/JSONException
    //   13744	13753	13730	org/json/JSONException
    //   13757	13794	13730	org/json/JSONException
    //   13800	13814	13730	org/json/JSONException
    //   13823	13837	13730	org/json/JSONException
    //   13921	14006	14009	java/lang/Exception
    //   14023	14041	14009	java/lang/Exception
    //   14046	14057	14009	java/lang/Exception
    //   14057	14078	14009	java/lang/Exception
    //   14081	14092	14009	java/lang/Exception
    //   14106	14147	14150	java/lang/Exception
    //   14186	14265	14268	java/lang/Exception
    //   14293	14372	14425	java/lang/Exception
    //   14372	14422	14425	java/lang/Exception
    //   14439	14473	14425	java/lang/Exception
    //   14476	14508	14425	java/lang/Exception
    //   14522	14595	14598	java/lang/Exception
    //   14623	14652	14734	java/lang/Exception
    //   14656	14731	14734	java/lang/Exception
    //   14759	14771	14777	java/lang/Exception
    //   14823	14920	14923	java/lang/Exception
    //   14948	15029	15032	java/lang/Exception
    //   15046	15051	15032	java/lang/Exception
    //   15054	15074	15032	java/lang/Exception
    //   15077	15089	15032	java/lang/Exception
    //   15092	15114	15032	java/lang/Exception
    //   15243	15324	15327	org/json/JSONException
    //   9954	9974	15337	java/lang/Exception
    //   3766	3775	15341	org/json/JSONException
    //   3780	3793	15341	org/json/JSONException
    //   1839	1880	15406	org/json/JSONException
    //   1882	1955	15406	org/json/JSONException
    //   1957	1968	15406	org/json/JSONException
    //   1971	2000	15406	org/json/JSONException
  }
  
  public void onActivityReady()
  {
    if ((jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (QbSdk.getTbsVersion(this.mRuntime.a()) >= 44001)) {
      g();
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {}
    try
    {
      c();
      if ((jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (jdField_a_of_type_AndroidContentBroadcastReceiver != null))
      {
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_JavaLangRefWeakReference);
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "put current UiApiPlugin into sUiApiPluginReferences: " + this.jdField_a_of_type_JavaLangRefWeakReference.toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "error:" + localException.toString());
        }
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 13) {
      if (paramIntent != null) {}
    }
    Object localObject4;
    Object localObject3;
    label565:
    Object localObject2;
    int n;
    boolean bool1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      Object localObject1;
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return;
                              localObject1 = paramIntent.getStringExtra("result");
                              callJs(paramIntent.getStringExtra("callback"), new String[] { localObject1 });
                              return;
                              if (paramByte != 3) {
                                break;
                              }
                            } while (paramIntent == null);
                            localObject1 = paramIntent.getStringExtra("scanResult");
                            if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
                              break;
                            }
                            localObject4 = paramIntent.getStringExtra("callback_url");
                            localObject3 = paramIntent.getStringExtra("name");
                          } while ((TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty((CharSequence)localObject3)));
                          localObject4 = ((String)localObject4).split("#");
                          localStringBuilder = new StringBuilder(localObject4[0]);
                          if (localObject4[0].contains("?")) {}
                          for (paramIntent = "&";; paramIntent = "?")
                          {
                            paramIntent = localStringBuilder.append(paramIntent).append((String)localObject3).append("=").append(URLEncoder.encode((String)localObject1));
                            if (localObject4.length > 1) {
                              paramIntent.append("#").append(localObject4[1]);
                            }
                            if (this.mRuntime.a() == null) {
                              break;
                            }
                            this.mRuntime.a().loadUrl(paramIntent.toString());
                            return;
                          }
                          localObject3 = this.jdField_c_of_type_JavaLangString;
                          if (localObject1 == null) {}
                          for (paramIntent = "''";; paramIntent = Util.a((String)localObject1))
                          {
                            callJs((String)localObject3, new String[] { paramIntent });
                            return;
                          }
                          if (paramByte != 17) {
                            break;
                          }
                        } while (paramIntent == null);
                        paramInt = paramIntent.getIntExtra("ret_code", -1);
                        localObject3 = paramIntent.getStringExtra("ocr_result");
                        localObject4 = new JSONObject();
                        try
                        {
                          if (TextUtils.isEmpty((CharSequence)localObject3)) {
                            paramInt = -1;
                          }
                          ((JSONObject)localObject4).put("retCode", paramInt);
                          localObject1 = localObject3;
                          if (TextUtils.isEmpty((CharSequence)localObject3)) {
                            localObject1 = "";
                          }
                          ((JSONObject)localObject4).put("result", localObject1);
                        }
                        catch (JSONException localJSONException1)
                        {
                          for (;;)
                          {
                            localJSONException1.printStackTrace();
                            continue;
                            paramIntent = "?";
                          }
                          callJs(this.jdField_d_of_type_JavaLangString, new String[] { ((JSONObject)localObject4).toString() });
                          return;
                        }
                        if (QLog.isColorLevel()) {
                          QLog.i("UiApiPlugin", 2, "scanForOCR CODE_OCRCODE result: " + ((JSONObject)localObject4).toString());
                        }
                        if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
                          break label565;
                        }
                        localObject3 = paramIntent.getStringExtra("callback_url");
                        localObject1 = paramIntent.getStringExtra("name");
                      } while ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject1)));
                      localObject3 = ((String)localObject3).split("#");
                      StringBuilder localStringBuilder = new StringBuilder(localObject3[0]);
                      if (!localObject3[0].contains("?")) {
                        break;
                      }
                      paramIntent = "&";
                      paramIntent = localStringBuilder.append(paramIntent).append((String)localObject1).append("=").append(URLEncoder.encode(((JSONObject)localObject4).toString()));
                      if (localObject3.length > 1) {
                        paramIntent.append("#").append(localObject3[1]);
                      }
                    } while (this.mRuntime.a() == null);
                    this.mRuntime.a().loadUrl(paramIntent.toString());
                    return;
                    if (paramByte != 4) {
                      break;
                    }
                  } while (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString));
                  if (paramInt == -1)
                  {
                    if (paramIntent == null) {}
                    for (paramIntent = "";; paramIntent = paramIntent.getStringExtra("result"))
                    {
                      paramIntent = "{\"code\":0,\"data\":{\"retcode\":0,\"result\":" + paramIntent + "}}";
                      callJs(this.jdField_f_of_type_JavaLangString, new String[] { paramIntent });
                      return;
                    }
                  }
                  callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{\"code\":-1}" });
                  return;
                  if (paramByte != 5) {
                    break;
                  }
                } while (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString));
                if (paramInt == -1)
                {
                  paramInt = paramIntent.getIntExtra("ret", 4);
                  if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin", 2, "select contact ret:" + paramInt);
                  }
                  localObject2 = new JSONObject();
                  for (;;)
                  {
                    try
                    {
                      ((JSONObject)localObject2).put("ret", paramInt);
                      if (paramInt == 0)
                      {
                        localObject3 = paramIntent.getStringArrayExtra("openids");
                        paramIntent = paramIntent.getIntArrayExtra("types");
                        if ((localObject3 != null) && (paramIntent != null) && (localObject3.length == paramIntent.length))
                        {
                          n = localObject3.length;
                          localObject4 = new JSONArray();
                          paramInt = 0;
                          if (paramInt < n)
                          {
                            ((JSONArray)localObject4).put(new JSONObject().put("type", paramIntent[paramInt]).put("openID", localObject3[paramInt]));
                            paramInt += 1;
                            continue;
                          }
                          ((JSONObject)localObject2).put("contacts", localObject4);
                        }
                        callJs(this.jdField_g_of_type_JavaLangString, new String[] { ((JSONObject)localObject2).toString() });
                        return;
                      }
                    }
                    catch (JSONException paramIntent)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("UiApiPlugin", 2, "select contact result json exception", paramIntent);
                      }
                      callJs(this.jdField_g_of_type_JavaLangString, new String[] { "{\"ret\":4}" });
                      return;
                    }
                    ((JSONObject)localObject2).put("errMsg", paramIntent.getStringExtra("errMsg"));
                  }
                }
                callJs(this.jdField_g_of_type_JavaLangString, new String[] { "{\"ret\":3}" });
                return;
                if (paramByte != 7) {
                  break;
                }
              } while (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString));
              if (paramInt == -1)
              {
                paramInt = paramIntent.getIntExtra("ret", 0);
                if (QLog.isColorLevel()) {
                  QLog.d("UiApiPlugin", 2, "select Member ret:" + paramInt);
                }
                localObject2 = new JSONObject();
                for (;;)
                {
                  try
                  {
                    ((JSONObject)localObject2).put("ret", paramInt);
                    if (paramInt == 0)
                    {
                      ((JSONObject)localObject2).put("selectMore", this.jdField_b_of_type_Boolean);
                      ((JSONObject)localObject2).put("uin", this.k);
                      ((JSONObject)localObject2).put("uinType", "0");
                      localObject3 = new JSONArray();
                      if (this.jdField_b_of_type_Boolean)
                      {
                        paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
                        paramInt = 0;
                        if (paramInt < paramIntent.size())
                        {
                          localObject4 = (ResultRecord)paramIntent.get(paramInt);
                          ((JSONArray)localObject3).put(new JSONObject().put("memUin", ((ResultRecord)localObject4).jdField_a_of_type_JavaLangString).put("nick", ((ResultRecord)localObject4).jdField_b_of_type_JavaLangString));
                          paramInt += 1;
                          continue;
                        }
                      }
                      else
                      {
                        localObject4 = paramIntent.getStringExtra("member_uin");
                        paramIntent = paramIntent.getStringExtra("member_display_name");
                        ((JSONArray)localObject3).put(new JSONObject().put("memUin", localObject4).put("nick", paramIntent));
                      }
                      ((JSONObject)localObject2).put("selectUins", localObject3);
                      callJs(this.jdField_f_of_type_JavaLangString, new String[] { ((JSONObject)localObject2).toString() });
                      return;
                    }
                  }
                  catch (JSONException paramIntent)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("UiApiPlugin", 2, "select contact result json exception", paramIntent);
                    }
                    callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{\"ret\":3,\"errMsg\":\"Json Parse Error\"}" });
                    return;
                  }
                  ((JSONObject)localObject2).put("errMsg", paramIntent.getStringExtra("errMsg"));
                }
              }
              callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{\"ret\":1,\"errMsg\":\"User cancle\"}" });
              return;
              if (paramByte != 6) {
                break;
              }
            } while (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString));
            if (paramInt == -1)
            {
              callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{'retcode' : 0}" });
              return;
            }
            paramInt = paramIntent.getIntExtra("retCode", -1);
            callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{'retcode' : " + paramInt + "}" });
            return;
            if ((paramByte != 8) && (paramByte != 9)) {
              break;
            }
          } while ((paramInt != -1) || (paramIntent == null));
          bool1 = paramIntent.getBooleanExtra("key_troop_fee_notify_js_data_changed", false);
          paramIntent = paramIntent.getStringExtra("callback");
        } while (!bool1);
        callJs(paramIntent, new String[] { "{}" });
        return;
        if (paramByte != 10) {
          break;
        }
      } while ((paramInt != -1) && (paramIntent == null));
      TroopGiftUtil.a(this.mRuntime.a(), paramIntent, null);
      a(paramIntent.getStringExtra("troop_uin"), "send_page");
      return;
      if (paramByte != 11) {
        break label1898;
      }
      localObject2 = null;
      bool1 = false;
      if (paramIntent != null)
      {
        localObject2 = paramIntent.getStringExtra("callback");
        bool1 = paramIntent.getBooleanExtra("isOpenApi", false);
      }
      localObject3 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject2 = this.l;
      boolean bool2 = this.jdField_c_of_type_Boolean;
      bool1 = bool2;
      localObject3 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      bool1 = bool2;
      localObject3 = localObject2;
      if (bool2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("UiApiPlugin", 2, "groupOrganizationView no callback");
    return;
    this.l = null;
    this.jdField_c_of_type_Boolean = false;
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("UiApiPlugin", 2, "groupOrganization result intent=null");
      }
      if (bool1)
      {
        callJs4OpenApiIfNeeded("groupOrganizationView", -100, "{ret:4}");
        return;
      }
      callJs((String)localObject3, new String[] { "{ret:4}" });
      return;
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        n = paramIntent.getIntExtra("ret", 5);
        ((JSONObject)localObject2).put("ret", n);
        localObject4 = paramIntent.getStringExtra("errMsg");
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          ((JSONObject)localObject2).put("errMsg", localObject4);
        }
        if (n != 0) {
          break label2228;
        }
        paramIntent = paramIntent.getStringArrayExtra("result");
        localObject4 = new JSONArray();
        int i1 = paramIntent.length;
        paramInt = 0;
        if (paramInt < i1)
        {
          ((JSONArray)localObject4).put(paramIntent[paramInt]);
          paramInt += 1;
          continue;
        }
        ((JSONObject)localObject2).put("openIDArr", localObject4);
      }
      catch (JSONException paramIntent)
      {
        label1807:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("UiApiPlugin", 2, "groupOrganization error", paramIntent);
        if (!bool1) {
          break label1881;
        }
      }
      callJs4OpenApiIfNeeded("groupOrganizationView", paramInt, ((JSONObject)localObject2).toString());
      return;
      callJs4OpenApiIfNeeded("groupOrganizationView", -100, "{ret:4}");
      return;
      label1881:
      label1898:
      do
      {
        paramInt = -100;
        break label1807;
        do
        {
          callJs((String)localObject3, new String[] { ((JSONObject)localObject2).toString() });
          return;
          callJs((String)localObject3, new String[] { "{ret:4}" });
          return;
          if (paramByte == 12)
          {
            paramInt = paramIntent.getIntExtra("cGroupOption", -1);
            localObject2 = paramIntent.getStringExtra("troop_uin");
            if (paramIntent.getBooleanExtra("isSetFee", false)) {
              paramInt = 4;
            }
            for (;;)
            {
              paramIntent = new JSONObject();
              try
              {
                paramIntent.put("gc", localObject2);
                paramIntent.put("ret", 0);
                paramIntent.put("joinType", paramInt);
                callJs(this.m, new String[] { paramIntent.toString() });
                return;
                switch (paramInt)
                {
                default: 
                  paramInt = -1;
                  break;
                case 1: 
                  paramInt = 0;
                  break;
                case 2: 
                  paramInt = 1;
                  break;
                case 3: 
                  paramInt = 5;
                  break;
                case 4: 
                  paramInt = 3;
                  break;
                case 5: 
                  paramInt = 2;
                }
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  localJSONException2.printStackTrace();
                }
              }
            }
          }
          if (paramByte == 15)
          {
            if (TextUtils.isEmpty(this.i)) {
              break;
            }
            str = this.i;
            localObject3 = new StringBuilder().append("{'result' : ");
            if (paramInt == -1) {}
            for (paramIntent = "true";; paramIntent = "false")
            {
              callJs(str, new String[] { paramIntent + "}" });
              return;
            }
          }
          if ((paramByte != 16) || (TextUtils.isEmpty(this.j))) {
            break;
          }
          String str = this.j;
          localObject3 = new StringBuilder().append("{'result' : ");
          if (paramInt == -1) {}
          for (paramIntent = "true";; paramIntent = "false")
          {
            callJs(str, new String[] { paramIntent + "}" });
            return;
          }
        } while (!bool1);
      } while (n != 0);
      label2228:
      paramInt = 0;
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { "1", Integer.toString(this.jdField_a_of_type_Int) });
      return;
    }
    callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(this.jdField_a_of_type_Int));
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      paramView = this.mRuntime.a();
      if (paramView != null) {
        paramView.finish();
      }
    }
  }
  
  protected void onCreate()
  {
    WebIPCOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
  }
  
  protected void onDestroy()
  {
    if ((jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "remove current UiApiPlugin from sUiApiPluginReferences: " + this.jdField_a_of_type_JavaLangRefWeakReference.toString());
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(this.jdField_a_of_type_JavaLangRefWeakReference);
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    WebIPCOperator.a().b(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    super.onDestroy();
  }
  
  public void onDismiss()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { "1", Integer.toString(this.jdField_a_of_type_Int) });
      return;
    }
    callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin
 * JD-Core Version:    0.7.0.1
 */