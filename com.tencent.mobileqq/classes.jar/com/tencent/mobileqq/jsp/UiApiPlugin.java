package com.tencent.mobileqq.jsp;

import aefk;
import aefl;
import aefm;
import aefn;
import aefo;
import aefp;
import aefq;
import aefr;
import aefs;
import aeft;
import aefu;
import aefx;
import aega;
import aegb;
import aegc;
import aegd;
import aege;
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
import com.tencent.mobileqq.app.ThreadManagerV2;
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
    this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new aefk(this);
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
    paramArrayOfString.setObserver(new aefl(paramActivity));
    paramAppInterface.startServlet(paramArrayOfString);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (QQUtils.a(paramActivity, new String[] { paramString1 }))
    {
      QQToast.a(paramActivity, 2131435281, 0).b(paramActivity.getResources().getDimensionPixelSize(2131558448));
      paramActivity = a("-4", null, "createShortcut exsit!", paramString3);
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -2, "", "", "", "");
      callJs(paramString5, new String[] { paramActivity });
      return;
    }
    ThreadManagerV2.executeOnNetWorkThread(new aefu(this, paramActivity, paramString4, paramString1, paramString2, paramString3, paramString5));
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      try
      {
        paramString2 = BitmapFactory.decodeResource(paramContext.getResources(), 2130839210);
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
    jdField_c_of_type_AndroidContentBroadcastReceiver = new aegd(this);
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
      n = 2130841484;
    }
    do
    {
      return n;
      if ("2".equals(paramString)) {
        return 2130841483;
      }
      if ("3".equals(paramString)) {
        return 2130839166;
      }
      if ("4".equals(paramString)) {
        return 2130838576;
      }
      if ("5".equals(paramString)) {
        return 2130841518;
      }
      if ("7".equals(paramString))
      {
        if (paramBoolean) {
          return 2130840582;
        }
        return 2130840585;
      }
      if ("8".equals(paramString))
      {
        if (paramBoolean) {
          return 2130845976;
        }
        return 2130845980;
      }
      if ("9".equals(paramString)) {
        return 2130838294;
      }
      if ("10".equals(paramString)) {
        return 2130846045;
      }
    } while (!"11".equals(paramString));
    return 2130846044;
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
    aefn localaefn = null;
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
        localRelativeLayout = (RelativeLayout)localActivity.findViewById(2131363261);
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
          Drawable localDrawable = localActivity.getResources().getDrawable(2130842226);
          localObject = localDrawable;
          if (!TextUtils.isEmpty(paramString))
          {
            localaefn = new aefn(this, paramString);
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
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localaefn);
        this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localActivity.getResources().getDrawable(2130846133));
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localaefn);
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
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131362700);
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
    Object localObject1 = null;
    int n = 0;
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    Object localObject2;
    JSONObject localJSONObject2;
    String str2;
    JSONObject localJSONObject1;
    for (;;)
    {
      return;
      localObject2 = this.mRuntime.a();
      if (localObject2 != null) {}
      try
      {
        localJSONObject2 = new JSONObject(paramString);
        str2 = localJSONObject2.optString("url");
        if (!paramBoolean) {
          break;
        }
        localJSONObject1 = localJSONObject2;
        if ((!TextUtils.isEmpty(str2)) && (localJSONObject1 != null) && (localJSONObject1.has("style")))
        {
          paramString = (String)localObject1;
          if (!localActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
          {
            paramString = (String)localObject1;
            if (!localActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity"))
            {
              paramString = (String)localObject1;
              if (!localJSONObject1.optBoolean("useNewConfig", false)) {
                paramString = localActivity.getIntent().getExtras();
              }
            }
          }
          if (paramString != null) {
            break label457;
          }
          localObject1 = new Bundle();
          if (((Bundle)localObject1).containsKey("startOpenPageTime")) {
            ((Bundle)localObject1).putLong("startOpenPageTime", System.currentTimeMillis());
          }
          n = localJSONObject1.optInt("style");
          if (!Boolean.valueOf(localJSONObject2.optBoolean("is_native", true)).booleanValue()) {
            break label1626;
          }
          PluginJumpManager.getInstance().updateConfig(this.mRuntime.a());
          PluginJumpManager.getInstance().loadConfig();
          if (!(localActivity instanceof BaseActivity)) {
            break label675;
          }
          if (PluginJumpManager.getInstance().openView(localActivity, str2, String.valueOf(n))) {}
        }
      }
      catch (Exception paramString)
      {
        label258:
        label284:
        QLog.e("UiApiPlugin", 1, "convert json exception", paramString);
        label390:
        return;
      }
    }
    switch (localJSONObject1.optInt("navigationBarStyle"))
    {
    }
    for (;;)
    {
      ((Bundle)localObject1).putBoolean("hide_title_left_arrow", localJSONObject1.optBoolean("hideLeftArrow", false));
      n = localJSONObject1.optInt("target");
      if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
      {
        paramString = new Intent(((BasePluginActivity)localActivity).getOutActivity(), QQBrowserActivity.class);
        paramString.putExtras((Bundle)localObject1);
        paramString.putExtra("url", str2);
        paramString.setFlags(0);
        if (n == 1) {
          paramString.putExtra("articalChannelId", 0);
        }
        localActivity.startActivityForResult(paramString, 100);
      }
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
        for (;;)
        {
          label457:
          String str1;
          try
          {
            localObject1 = Uri.parse(((WebView)localObject2).getUrl());
            if ((localObject1 == null) || (!((Uri)localObject1).isHierarchical())) {
              break label1618;
            }
            bool = "1".equals(((Uri)localObject1).getQueryParameter("__iscomic"));
            paramBoolean = "1".equals(((Uri)localObject1).getQueryParameter("__useCampusNotice"));
            if ((bool) && (!paramBoolean))
            {
              paramString.remove("uintype");
              QLog.d("UiApiPlugin", 1, "remove campus notice");
            }
            localObject1 = paramString;
            if (!paramString.containsKey("insertPluginsArray")) {
              break;
            }
            localObject2 = paramString.get("insertPluginsArray");
            localObject1 = paramString;
            if (!(localObject2 instanceof String[])) {
              break;
            }
            localObject2 = (String[])localObject2;
            localObject1 = paramString;
            if (n >= localObject2.length) {
              break;
            }
            if ("gdtReportPlugin".equals(localObject2[n])) {
              localObject2[n] = null;
            }
            n += 1;
            continue;
          }
          catch (Exception localException)
          {
            QLog.e("UiApiPlugin", 1, "open url exception", localException);
            str1 = paramString;
          }
          label675:
          if (!PluginJumpManager.getInstance().openView(localActivity, str2, String.valueOf(n))) {
            break label1626;
          }
          return;
          str1.putBoolean("hide_more_button", false);
          str1.putBoolean("hide_operation_bar", true);
          break label258;
          str1.putBoolean("hide_more_button", true);
          str1.putBoolean("hide_operation_bar", true);
          break label258;
          str1.putBoolean("hide_more_button", false);
          str1.putBoolean("hide_operation_bar", false);
          str1.putString("webStyle", "");
          break label258;
          str1.putBoolean("hide_more_button", true);
          str1.putBoolean("hide_operation_bar", false);
          str1.putString("webStyle", "");
          break label258;
          str1.putBoolean("hide_left_button", true);
          str1.putBoolean("show_right_close_button", true);
          break label258;
          str1.putBoolean("isTransparentTitleAndClickable", true);
          break label284;
          if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity"))
          {
            paramString = new Intent(localActivity, QQBrowserActivity.class);
            paramString.putExtras(str1);
            paramString.putExtra("url", str2);
            paramString.setFlags(0);
            localActivity.startActivityForResult(paramString, 100);
            break label390;
          }
          if ((localActivity.getClass().getName().equalsIgnoreCase("com.qqcomic.activity.fragment.VipComicWebFragmentActivity")) || (localActivity.getClass().getName().equalsIgnoreCase("com.qqcomic.activity.media.VipComicMediaPlayActivity")))
          {
            paramString = new Intent();
            str1.remove("activityNoTitle");
            paramString.putExtras(str1);
            paramString.putExtra("url", str2);
            paramString.setFlags(0);
            if (VipComicHelper.a(str2, paramString))
            {
              paramString.setClassName("com.qqcomic", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
              localActivity.startActivityForResult(paramString, 100);
              break label390;
            }
            VipComicHelper.a(localActivity, paramString, 100);
            break label390;
          }
          if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.QQH5BrowserActivity"))
          {
            paramString = new Intent(localActivity, QQBrowserActivity.class);
            paramString.putExtras(str1);
            paramString.putExtra("url", str2);
            paramString.setFlags(0);
            localActivity.startActivityForResult(paramString, 100);
            break label390;
          }
          if (localActivity.getClass().getName().equalsIgnoreCase("com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity"))
          {
            paramString = new Intent(localActivity, QQBrowserActivity.class);
            str1.remove("isFullScreen");
            str1.remove("isTransparentTitle");
            paramString.putExtras(str1);
            paramString.putExtra("url", str2);
            paramString.setFlags(0);
            localActivity.startActivityForResult(paramString, 100);
            break label390;
          }
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
              str1.putBoolean("isOpeningQunApp", localJSONObject1.optBoolean("isOpeningQunApp"));
              str1.putInt("appid", localJSONObject1.optInt("appid"));
              localJSONObject2 = localJSONObject1.optJSONObject("extraParams");
              if (localJSONObject2 != null)
              {
                str1.putString("extraParams", localJSONObject2.toString());
                str1.putInt("troopid", localJSONObject2.optInt("gc"));
              }
            }
            paramString.putExtra("startOpenPageTime", System.currentTimeMillis());
            paramString.putExtras(str1);
            paramString.putExtra("url", str2);
            paramString.setFlags(0);
            if (n == 1) {
              paramString.putExtra("articalChannelId", 0);
            }
            if (!VipComicHelper.a(str2, paramString)) {
              break label1597;
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
              str1.remove("click_time");
              str1.remove("available_memory");
            }
            else if (localJSONObject1.optBoolean("QzoneUseQQBrowser", false))
            {
              paramString = new Intent(localActivity, QQBrowserActivity.class);
              str1.remove("isTransparentTitle");
              str1.remove("hide_more_button");
              str1.remove("hide_left_button");
            }
            else
            {
              paramString = new Intent(localActivity, localActivity.getClass());
            }
          }
          label1597:
          localActivity.startActivityForResult(paramString, 100);
          break label390;
          localActivity.overridePendingTransition(2131034380, 0);
          return;
          label1618:
          paramBoolean = false;
          boolean bool = false;
        }
        label1626:
        switch (n)
        {
        }
        break label258;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      a(paramJSONObject, null, new aefo(this, paramJSONObject));
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
    SearchUtils.a(this.mRuntime.a(), paramString, str2, (List)localObject, paramJSONObject, localRect, new aegb(this, str1));
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
      this.jdField_b_of_type_AndroidViewView = localActivity.findViewById(2131366764);
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
      this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(new aefm(this));
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
      localView = ((Activity)localObject).findViewById(2131363261);
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
        ((TranslateAnimation)localObject).setAnimationListener(new aefs(this, localView, localView.getTop() - n, localView.getBottom() - n));
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
      ((TranslateAnimation)localObject).setAnimationListener(new aeft(this, localView, localView.getTop() + n, n + localView.getBottom()));
      localView.setVisibility(0);
      localView.startAnimation((Animation)localObject);
      this.jdField_d_of_type_Boolean = false;
      return;
    }
  }
  
  protected void a(byte[] paramArrayOfByte, String paramString)
  {
    paramString = AppConstants.aK + "diskcache/Image_" + paramString;
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
        if (SharedPreUtils.v(this.mRuntime.a(), this.mRuntime.a().getCurrentAccountUin())) {
          TroopPicEffectsEditActivity.a(this.mRuntime.a(), paramString1, paramString1);
        }
        for (;;)
        {
          return true;
          SharedPreUtils.C(this.mRuntime.a(), this.mRuntime.a().getCurrentAccountUin());
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
    QRUtils.a(1, 2131435496);
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
          this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131558949) - localActivity.getResources().getDimensionPixelSize(2131558953), localActivity.getResources().getDimensionPixelSize(2131558954));
        }
      }
      else
      {
        Drawable localDrawable = localActivity.getResources().getDrawable(2130838688);
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
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(localActivity, localArrayList, new aefp(this, paramJSONObject, localActivity));
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131558949) - localActivity.getResources().getDimensionPixelSize(2131558953), localActivity.getResources().getDimensionPixelSize(2131558954));
      return;
      int n = 0;
      while (n < localJSONArray.length())
      {
        Object localObject2 = localJSONArray.optJSONObject(n);
        PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
        localMenuItem.jdField_a_of_type_Int = Integer.parseInt(((JSONObject)localObject2).optString("id"));
        localMenuItem.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("itemContent");
        localMenuItem.jdField_c_of_type_JavaLangString = localMenuItem.jdField_a_of_type_JavaLangString;
        localMenuItem.jdField_b_of_type_Int = 2130846450;
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
    ((TextView)localObject1).setText(2131434953);
    ((TextView)localObject1).setBackgroundResource(2130846351);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setMaxWidth(DisplayUtil.a((Context)localObject3, 100.0F));
    ((TextView)localObject1).setMinWidth(DisplayUtil.a((Context)localObject3, 52.0F));
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setTextColor(((Context)localObject3).getResources().getColor(2131494216));
    ((TextView)localObject1).setTextSize(1, 17.0F);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, DisplayUtil.a((Context)localObject3, 36.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131362700);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((TextView)localObject1).setOnClickListener(this);
    Object localObject2 = (RelativeLayout)((Activity)localObject2).findViewById(2131363261);
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
    jdField_a_of_type_AndroidContentBroadcastReceiver = new aegc(this);
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
      this.jdField_b_of_type_AndroidAppProgressDialog = new ProgressDialog((Context)localObject1, 2131624516);
      this.jdField_b_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_b_of_type_AndroidAppProgressDialog.show();
      this.jdField_b_of_type_AndroidAppProgressDialog.setContentView(2130969178);
      ((TextView)this.jdField_b_of_type_AndroidAppProgressDialog.findViewById(2131363418)).setText("正在发送");
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
    ((DownloaderFactory)this.mRuntime.a().getManager(46)).a(1).a((DownloadTask)localObject2, new aefx(this, paramString), (Bundle)localObject1);
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
        localObject = (TextView)((Activity)localObject).findViewById(2131363262);
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
        jdField_b_of_type_AndroidContentBroadcastReceiver = new aege(this);
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
        localObject1 = AppConstants.aK + "diskcache/Image_" + MD5Utils.d(str);
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
    ((DownloaderFactory)this.mRuntime.a().getManager(46)).a(1).a((DownloadTask)localObject2, new aega(this, str, paramString), (Bundle)localObject1);
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
      localWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aefq(this, localActivity, (String)localObject1, (String)localObject2));
      localObject1 = (RelativeLayout)localActivity.findViewById(2131363261);
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
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new aefr(this, localActivity, str1, str2));
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
      ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131362700);
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
                      localObject2 = (TextView)paramString.findViewById(2131363447);
                      if ((localObject2 == null) || (((TextView)localObject2).getVisibility() != 0) || (!paramString.getString(2131434953).equals(((TextView)localObject2).getText()))) {
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
    //   3: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +15387 -> 15393
    //   9: aload_0
    //   10: aload 4
    //   12: aload_1
    //   13: invokevirtual 2029	com/tencent/mobileqq/jsp/UiApiPlugin:addOpenApiListenerIfNeeded	(Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   16: ldc_w 2031
    //   19: aload 4
    //   21: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: ifeq +199 -> 223
    //   27: aload 5
    //   29: arraylength
    //   30: ifle +193 -> 223
    //   33: new 110	org/json/JSONObject
    //   36: dup
    //   37: aload 5
    //   39: iconst_0
    //   40: aaload
    //   41: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   50: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   53: astore 4
    //   55: aload 5
    //   57: ldc_w 2033
    //   60: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: astore_1
    //   64: aload 5
    //   66: ldc_w 2035
    //   69: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_2
    //   73: aload 5
    //   75: ldc 151
    //   77: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_3
    //   81: aload 5
    //   83: ldc_w 1205
    //   86: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 5
    //   91: aload 4
    //   93: ifnull +91 -> 184
    //   96: aload_1
    //   97: invokestatic 2040	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   100: ifeq +84 -> 184
    //   103: aload_2
    //   104: invokestatic 2040	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   107: ifeq +77 -> 184
    //   110: new 126	android/content/Intent
    //   113: dup
    //   114: aload 4
    //   116: ldc_w 2042
    //   119: invokespecial 730	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   122: astore 4
    //   124: aload 4
    //   126: ldc_w 1483
    //   129: aload_1
    //   130: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   133: pop
    //   134: aload 4
    //   136: ldc_w 2035
    //   139: aload_2
    //   140: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   143: pop
    //   144: ldc_w 2044
    //   147: aload_3
    //   148: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifeq +25 -> 176
    //   154: aload 4
    //   156: ldc_w 2046
    //   159: bipush 8
    //   161: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   164: pop
    //   165: aload 4
    //   167: ldc_w 1205
    //   170: aload 5
    //   172: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   175: pop
    //   176: aload_0
    //   177: aload 4
    //   179: bipush 9
    //   181: invokevirtual 1414	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   184: iconst_1
    //   185: ireturn
    //   186: astore_1
    //   187: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq -6 -> 184
    //   193: ldc_w 2048
    //   196: iconst_2
    //   197: new 524	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 2050
    //   207: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_1
    //   211: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: goto -36 -> 184
    //   223: ldc_w 2052
    //   226: aload 4
    //   228: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +164 -> 395
    //   234: aload 5
    //   236: arraylength
    //   237: ifle +158 -> 395
    //   240: new 110	org/json/JSONObject
    //   243: dup
    //   244: aload 5
    //   246: iconst_0
    //   247: aaload
    //   248: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   251: astore_2
    //   252: aload_2
    //   253: ldc_w 1166
    //   256: invokevirtual 2056	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   259: lstore 10
    //   261: aload_2
    //   262: ldc_w 2058
    //   265: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   268: istore 6
    //   270: aload_2
    //   271: ldc_w 2060
    //   274: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   277: astore_1
    //   278: aload_2
    //   279: ldc_w 1205
    //   282: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   285: astore_2
    //   286: aload_0
    //   287: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   290: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   293: new 524	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   300: lload 10
    //   302: invokevirtual 2063	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   305: ldc_w 362
    //   308: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: bipush 9
    //   316: invokestatic 2068	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/Intent;
    //   319: astore_3
    //   320: aload_3
    //   321: ldc_w 2070
    //   324: aload_1
    //   325: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   328: pop
    //   329: aload_3
    //   330: ldc_w 2072
    //   333: iload 6
    //   335: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   338: pop
    //   339: aload_3
    //   340: ldc_w 1205
    //   343: aload_2
    //   344: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   347: pop
    //   348: aload_0
    //   349: aload_3
    //   350: bipush 8
    //   352: invokevirtual 1414	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   355: goto -171 -> 184
    //   358: astore_1
    //   359: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq -178 -> 184
    //   365: ldc_w 2048
    //   368: iconst_2
    //   369: new 524	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 2074
    //   379: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_1
    //   383: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: goto -208 -> 184
    //   395: ldc_w 2076
    //   398: aload 4
    //   400: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   403: ifeq +293 -> 696
    //   406: aload 5
    //   408: arraylength
    //   409: ifle +287 -> 696
    //   412: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   415: ifeq +30 -> 445
    //   418: ldc 196
    //   420: iconst_2
    //   421: new 524	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 2081
    //   431: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 5
    //   436: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 2083	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload_0
    //   446: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   449: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
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
    //   467: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   470: astore_2
    //   471: aload_2
    //   472: ldc_w 1258
    //   475: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   478: astore_3
    //   479: aload_2
    //   480: ldc 161
    //   482: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   485: tableswitch	default:+14959 -> 15444, 0:+23->508, 1:+177->662
    //   509: ldc_w 2085
    //   512: iconst_1
    //   513: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   516: istore 8
    //   518: aload_3
    //   519: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   522: ifne -338 -> 184
    //   525: iconst_2
    //   526: istore 7
    //   528: iload 7
    //   530: istore 6
    //   532: iload 8
    //   534: tableswitch	default:+14913 -> 15447, 0:+103->637, 1:+109->643, 2:+115->649, 3:+121->655, 4:+42->576, 5:+42->576, 6:+103->637
    //   577: iload 6
    //   579: aload_3
    //   580: iconst_0
    //   581: invokestatic 1760	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   584: aload_1
    //   585: invokevirtual 400	android/content/Context:getResources	()Landroid/content/res/Resources;
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
    //   611: new 524	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   618: ldc_w 2087
    //   621: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload_1
    //   625: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   663: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   666: ifne -482 -> 184
    //   669: aload_1
    //   670: iconst_0
    //   671: aload_3
    //   672: iconst_0
    //   673: invokestatic 1760	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   676: iconst_0
    //   677: invokevirtual 2089	com/tencent/mobileqq/widget/QQToast:a	(I)Landroid/widget/Toast;
    //   680: astore_1
    //   681: aload_1
    //   682: bipush 23
    //   684: iconst_0
    //   685: iconst_0
    //   686: invokevirtual 2094	android/widget/Toast:setGravity	(III)V
    //   689: aload_1
    //   690: invokevirtual 2095	android/widget/Toast:show	()V
    //   693: goto -509 -> 184
    //   696: ldc_w 2097
    //   699: aload 4
    //   701: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   704: ifeq +109 -> 813
    //   707: new 110	org/json/JSONObject
    //   710: dup
    //   711: aload 5
    //   713: iconst_0
    //   714: aaload
    //   715: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   718: ldc_w 2099
    //   721: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   724: astore_1
    //   725: aload_1
    //   726: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   729: ifeq +5 -> 734
    //   732: iconst_1
    //   733: ireturn
    //   734: aload_0
    //   735: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   738: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   741: astore_2
    //   742: new 126	android/content/Intent
    //   745: dup
    //   746: aload_2
    //   747: ldc_w 2015
    //   750: invokespecial 730	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   753: aconst_null
    //   754: invokestatic 2020	com/tencent/mobileqq/activity/aio/AIOUtils:a	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   757: astore_3
    //   758: aload_3
    //   759: ldc_w 2101
    //   762: aload_1
    //   763: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   766: pop
    //   767: aload_3
    //   768: ldc_w 1079
    //   771: iconst_1
    //   772: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   775: pop
    //   776: aload_3
    //   777: ldc_w 2103
    //   780: iconst_1
    //   781: invokevirtual 463	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   784: pop
    //   785: aload_2
    //   786: aload_3
    //   787: invokevirtual 746	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   790: goto -606 -> 184
    //   793: astore_1
    //   794: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   797: ifeq -613 -> 184
    //   800: ldc 196
    //   802: iconst_2
    //   803: ldc_w 2105
    //   806: aload_1
    //   807: invokestatic 2107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   810: goto -626 -> 184
    //   813: ldc_w 2109
    //   816: aload 4
    //   818: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   821: ifeq +225 -> 1046
    //   824: new 110	org/json/JSONObject
    //   827: dup
    //   828: aload 5
    //   830: iconst_0
    //   831: aaload
    //   832: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   835: astore_3
    //   836: aload_3
    //   837: ldc_w 2099
    //   840: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   843: astore 4
    //   845: aload 4
    //   847: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   850: ifeq +5 -> 855
    //   853: iconst_1
    //   854: ireturn
    //   855: aload_3
    //   856: ldc_w 2111
    //   859: ldc_w 2113
    //   862: invokevirtual 2116	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   865: astore 5
    //   867: aload_3
    //   868: ldc_w 2118
    //   871: ldc_w 2120
    //   874: invokevirtual 2116	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   877: astore 14
    //   879: aload_0
    //   880: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   883: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   886: astore_1
    //   887: new 126	android/content/Intent
    //   890: dup
    //   891: aload_1
    //   892: ldc_w 2015
    //   895: invokespecial 730	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   898: aconst_null
    //   899: invokestatic 2020	com/tencent/mobileqq/activity/aio/AIOUtils:a	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   902: astore_2
    //   903: aload_2
    //   904: ldc_w 2101
    //   907: aload 4
    //   909: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   912: pop
    //   913: aload_2
    //   914: ldc_w 1079
    //   917: iconst_1
    //   918: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   921: pop
    //   922: aload_2
    //   923: ldc_w 2111
    //   926: aload 5
    //   928: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   931: pop
    //   932: aload_2
    //   933: ldc_w 2118
    //   936: aload 14
    //   938: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   941: pop
    //   942: aload_3
    //   943: ldc 161
    //   945: iconst_0
    //   946: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   949: istore 6
    //   951: iload 6
    //   953: iconst_1
    //   954: if_icmpne +65 -> 1019
    //   957: aload_3
    //   958: ldc_w 2122
    //   961: invokevirtual 844	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   964: astore_3
    //   965: aload_3
    //   966: ifnull +15 -> 981
    //   969: aload_2
    //   970: ldc_w 2124
    //   973: aload_3
    //   974: invokevirtual 2125	org/json/JSONArray:toString	()Ljava/lang/String;
    //   977: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   980: pop
    //   981: aload_2
    //   982: ldc_w 2127
    //   985: iload 6
    //   987: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   990: pop
    //   991: aload_1
    //   992: aload_2
    //   993: invokevirtual 746	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   996: goto -812 -> 184
    //   999: astore_1
    //   1000: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1003: ifeq -819 -> 184
    //   1006: ldc 196
    //   1008: iconst_2
    //   1009: ldc_w 2129
    //   1012: aload_1
    //   1013: invokestatic 2107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1016: goto -832 -> 184
    //   1019: iload 6
    //   1021: iconst_2
    //   1022: if_icmpne -41 -> 981
    //   1025: aload_2
    //   1026: ldc_w 2131
    //   1029: aload_3
    //   1030: ldc_w 2122
    //   1033: ldc_w 2133
    //   1036: invokevirtual 2116	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1039: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1042: pop
    //   1043: goto -62 -> 981
    //   1046: ldc_w 2135
    //   1049: aload 4
    //   1051: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1054: ifeq +50 -> 1104
    //   1057: new 110	org/json/JSONObject
    //   1060: dup
    //   1061: aload 5
    //   1063: iconst_0
    //   1064: aaload
    //   1065: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1068: ldc_w 1258
    //   1071: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1074: astore_1
    //   1075: aload_1
    //   1076: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1079: ifne -895 -> 184
    //   1082: aload_0
    //   1083: aload_0
    //   1084: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1087: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1090: aload_1
    //   1091: invokestatic 2140	com/tencent/mobileqq/maproam/Utils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/app/ProgressDialog;
    //   1094: putfield 2142	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1097: goto -913 -> 184
    //   1100: astore_1
    //   1101: goto -917 -> 184
    //   1104: ldc_w 2144
    //   1107: aload 4
    //   1109: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1112: ifeq +52 -> 1164
    //   1115: aload_0
    //   1116: getfield 2142	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1119: ifnull -935 -> 184
    //   1122: aload_0
    //   1123: getfield 2142	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1126: invokevirtual 2145	android/app/ProgressDialog:isShowing	()Z
    //   1129: ifeq -945 -> 184
    //   1132: aload_0
    //   1133: getfield 2142	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1136: invokevirtual 1793	android/app/ProgressDialog:dismiss	()V
    //   1139: aload_0
    //   1140: aconst_null
    //   1141: putfield 2142	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1144: goto -960 -> 184
    //   1147: astore_1
    //   1148: aload_0
    //   1149: aconst_null
    //   1150: putfield 2142	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1153: goto -969 -> 184
    //   1156: astore_1
    //   1157: aload_0
    //   1158: aconst_null
    //   1159: putfield 2142	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   1162: aload_1
    //   1163: athrow
    //   1164: ldc_w 2147
    //   1167: aload 4
    //   1169: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1172: ifeq +41 -> 1213
    //   1175: aload 5
    //   1177: arraylength
    //   1178: iconst_1
    //   1179: if_icmpne -995 -> 184
    //   1182: aload_1
    //   1183: getfield 2150	com/tencent/mobileqq/webview/swift/JsBridgeListener:jdField_a_of_type_Boolean	Z
    //   1186: ifeq +15 -> 1201
    //   1189: aload_0
    //   1190: aload 5
    //   1192: iconst_0
    //   1193: aaload
    //   1194: iconst_1
    //   1195: invokevirtual 2152	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Z)V
    //   1198: goto -1014 -> 184
    //   1201: aload_0
    //   1202: aload 5
    //   1204: iconst_0
    //   1205: aaload
    //   1206: iconst_0
    //   1207: invokevirtual 2152	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Z)V
    //   1210: goto -1026 -> 184
    //   1213: ldc_w 2154
    //   1216: aload 4
    //   1218: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1221: ifeq +50 -> 1271
    //   1224: aload_0
    //   1225: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1228: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1231: instanceof 2156
    //   1234: ifeq +26 -> 1260
    //   1237: aload_1
    //   1238: aload_0
    //   1239: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1242: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1245: checkcast 2156	mqq/app/AppActivity
    //   1248: invokevirtual 2159	mqq/app/AppActivity:isResume	()Z
    //   1251: invokestatic 982	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1254: invokevirtual 2162	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1257: goto -1073 -> 184
    //   1260: aload_1
    //   1261: iconst_0
    //   1262: invokestatic 982	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1265: invokevirtual 2162	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1268: goto -1084 -> 184
    //   1271: ldc_w 2164
    //   1274: aload 4
    //   1276: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   1298: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1301: aload_1
    //   1302: aconst_null
    //   1303: invokevirtual 1200	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Landroid/view/View$OnClickListener;)V
    //   1306: goto -1122 -> 184
    //   1309: astore_1
    //   1310: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1313: ifeq -1129 -> 184
    //   1316: ldc 196
    //   1318: iconst_2
    //   1319: ldc_w 2166
    //   1322: aload_1
    //   1323: invokestatic 2107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1326: goto -1142 -> 184
    //   1329: ldc_w 2168
    //   1332: aload 4
    //   1334: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1337: ifeq +90 -> 1427
    //   1340: aload 5
    //   1342: arraylength
    //   1343: iconst_1
    //   1344: if_icmpne +83 -> 1427
    //   1347: aload_0
    //   1348: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1351: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1354: astore_2
    //   1355: aload_2
    //   1356: ifnull +14098 -> 15454
    //   1359: aload_2
    //   1360: invokevirtual 658	android/app/Activity:isFinishing	()Z
    //   1363: ifeq +6 -> 1369
    //   1366: goto +14088 -> 15454
    //   1369: new 110	org/json/JSONObject
    //   1372: dup
    //   1373: aload 5
    //   1375: iconst_0
    //   1376: aaload
    //   1377: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1380: astore_2
    //   1381: aload_0
    //   1382: aload_2
    //   1383: ldc_w 2170
    //   1386: invokevirtual 1045	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1389: invokevirtual 2172	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1392: aload_0
    //   1393: aload_2
    //   1394: ldc_w 2174
    //   1397: invokevirtual 1045	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1400: aload_1
    //   1401: invokevirtual 2176	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1404: goto -1220 -> 184
    //   1407: astore_1
    //   1408: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1411: ifeq -1227 -> 184
    //   1414: ldc 196
    //   1416: iconst_2
    //   1417: ldc_w 2178
    //   1420: aload_1
    //   1421: invokestatic 2107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1424: goto -1240 -> 184
    //   1427: ldc_w 2180
    //   1430: aload 4
    //   1432: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1435: ifeq +71 -> 1506
    //   1438: aload 5
    //   1440: arraylength
    //   1441: iconst_1
    //   1442: if_icmpne +64 -> 1506
    //   1445: aload_0
    //   1446: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1449: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1452: astore_2
    //   1453: aload_2
    //   1454: ifnull +14002 -> 15456
    //   1457: aload_2
    //   1458: invokevirtual 658	android/app/Activity:isFinishing	()Z
    //   1461: ifeq +6 -> 1467
    //   1464: goto +13992 -> 15456
    //   1467: aload_0
    //   1468: new 110	org/json/JSONObject
    //   1471: dup
    //   1472: aload 5
    //   1474: iconst_0
    //   1475: aaload
    //   1476: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1479: aload_1
    //   1480: invokevirtual 2176	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1483: goto -1299 -> 184
    //   1486: astore_1
    //   1487: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1490: ifeq -1306 -> 184
    //   1493: ldc 196
    //   1495: iconst_2
    //   1496: ldc_w 2182
    //   1499: aload_1
    //   1500: invokestatic 2107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1503: goto -1319 -> 184
    //   1506: ldc_w 2184
    //   1509: aload 4
    //   1511: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1514: ifeq +109 -> 1623
    //   1517: aload 5
    //   1519: arraylength
    //   1520: iconst_1
    //   1521: if_icmpne +102 -> 1623
    //   1524: aload_0
    //   1525: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1528: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1531: astore_1
    //   1532: aload_1
    //   1533: ifnull +13925 -> 15458
    //   1536: aload_1
    //   1537: invokevirtual 658	android/app/Activity:isFinishing	()Z
    //   1540: ifeq +6 -> 1546
    //   1543: goto +13915 -> 15458
    //   1546: new 110	org/json/JSONObject
    //   1549: dup
    //   1550: aload 5
    //   1552: iconst_0
    //   1553: aaload
    //   1554: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1557: astore_1
    //   1558: aload_1
    //   1559: ldc_w 2186
    //   1562: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1565: istore 6
    //   1567: aload_1
    //   1568: ldc_w 2188
    //   1571: invokevirtual 1159	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1574: istore 12
    //   1576: aload_1
    //   1577: ldc_w 1205
    //   1580: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1583: astore_2
    //   1584: aload_0
    //   1585: iload 6
    //   1587: iload 12
    //   1589: aload_1
    //   1590: ldc_w 2190
    //   1593: invokevirtual 1159	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1596: aload_2
    //   1597: invokevirtual 2192	com/tencent/mobileqq/jsp/UiApiPlugin:a	(IZZLjava/lang/String;)V
    //   1600: goto -1416 -> 184
    //   1603: astore_1
    //   1604: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1607: ifeq -1423 -> 184
    //   1610: ldc 196
    //   1612: iconst_2
    //   1613: ldc_w 2182
    //   1616: aload_1
    //   1617: invokestatic 2107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1620: goto -1436 -> 184
    //   1623: ldc_w 1961
    //   1626: aload 4
    //   1628: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1631: ifeq +70 -> 1701
    //   1634: aload 5
    //   1636: arraylength
    //   1637: iconst_1
    //   1638: if_icmpne +63 -> 1701
    //   1641: aload_0
    //   1642: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1645: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1648: astore_1
    //   1649: aload_1
    //   1650: ifnull +13810 -> 15460
    //   1653: aload_1
    //   1654: invokevirtual 658	android/app/Activity:isFinishing	()Z
    //   1657: ifeq +6 -> 1663
    //   1660: goto +13800 -> 15460
    //   1663: aload_0
    //   1664: new 110	org/json/JSONObject
    //   1667: dup
    //   1668: aload 5
    //   1670: iconst_0
    //   1671: aaload
    //   1672: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1675: invokevirtual 2172	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1678: goto -1494 -> 184
    //   1681: astore_1
    //   1682: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1685: ifeq -1501 -> 184
    //   1688: ldc 196
    //   1690: iconst_2
    //   1691: ldc_w 2194
    //   1694: aload_1
    //   1695: invokestatic 2107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1698: goto -1514 -> 184
    //   1701: ldc_w 2196
    //   1704: aload 4
    //   1706: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1709: ifeq +83 -> 1792
    //   1712: aload 5
    //   1714: arraylength
    //   1715: iconst_1
    //   1716: if_icmpne +76 -> 1792
    //   1719: aload_0
    //   1720: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1723: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1726: astore_1
    //   1727: aload_1
    //   1728: ifnull +13734 -> 15462
    //   1731: aload_1
    //   1732: invokevirtual 658	android/app/Activity:isFinishing	()Z
    //   1735: ifeq +6 -> 1741
    //   1738: goto +13724 -> 15462
    //   1741: aload_0
    //   1742: new 110	org/json/JSONObject
    //   1745: dup
    //   1746: aload 5
    //   1748: iconst_0
    //   1749: aaload
    //   1750: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1753: invokevirtual 2198	com/tencent/mobileqq/jsp/UiApiPlugin:d	(Lorg/json/JSONObject;)V
    //   1756: goto -1572 -> 184
    //   1759: astore_1
    //   1760: ldc 196
    //   1762: iconst_1
    //   1763: new 524	java/lang/StringBuilder
    //   1766: dup
    //   1767: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   1770: ldc_w 2200
    //   1773: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1776: aload_1
    //   1777: invokestatic 2203	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1780: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1783: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1786: invokestatic 535	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1789: goto -1605 -> 184
    //   1792: ldc_w 558
    //   1795: aload 4
    //   1797: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1800: ifeq +21 -> 1821
    //   1803: aload 5
    //   1805: arraylength
    //   1806: iconst_1
    //   1807: if_icmpne +14 -> 1821
    //   1810: aload_0
    //   1811: aload 5
    //   1813: iconst_0
    //   1814: aaload
    //   1815: invokevirtual 2205	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;)V
    //   1818: goto -1634 -> 184
    //   1821: ldc_w 2207
    //   1824: aload 4
    //   1826: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   1847: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1850: astore_2
    //   1851: aload_2
    //   1852: ldc_w 2209
    //   1855: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1858: astore_1
    //   1859: aload_0
    //   1860: aload_2
    //   1861: ldc_w 1205
    //   1864: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1867: putfield 2210	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1870: aload_0
    //   1871: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1874: invokevirtual 931	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1877: ifnonnull +5 -> 1882
    //   1880: iconst_1
    //   1881: ireturn
    //   1882: aload_0
    //   1883: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1886: invokevirtual 931	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1889: invokevirtual 2213	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   1892: astore_2
    //   1893: new 126	android/content/Intent
    //   1896: dup
    //   1897: aload_0
    //   1898: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1901: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1904: ldc_w 2215
    //   1907: invokespecial 730	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1910: ldc 151
    //   1912: ldc_w 364
    //   1915: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1918: astore_3
    //   1919: aload_1
    //   1920: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1923: ifeq +48 -> 1971
    //   1926: aload_0
    //   1927: getfield 2210	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1930: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1933: ifeq +38 -> 1971
    //   1936: aload_3
    //   1937: ldc_w 2217
    //   1940: iconst_1
    //   1941: invokevirtual 463	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1944: pop
    //   1945: aload_0
    //   1946: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1949: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1952: ifnonnull +5 -> 1957
    //   1955: iconst_1
    //   1956: ireturn
    //   1957: aload_0
    //   1958: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1961: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1964: aload_3
    //   1965: invokevirtual 746	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1968: goto -1784 -> 184
    //   1971: aload_3
    //   1972: ldc_w 2209
    //   1975: aload_1
    //   1976: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1979: ldc_w 2219
    //   1982: aload_2
    //   1983: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1986: ldc_w 2221
    //   1989: iconst_1
    //   1990: invokevirtual 463	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1993: pop
    //   1994: aload_0
    //   1995: aload_3
    //   1996: iconst_3
    //   1997: invokevirtual 1414	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2000: goto -1816 -> 184
    //   2003: ldc_w 2223
    //   2006: aload 4
    //   2008: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2029: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2032: astore 4
    //   2034: aload 4
    //   2036: ldc_w 2209
    //   2039: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2042: astore_1
    //   2043: aload 4
    //   2045: ldc_w 2225
    //   2048: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2051: astore_2
    //   2052: aload 4
    //   2054: ldc 161
    //   2056: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2059: astore_3
    //   2060: aload_0
    //   2061: aload 4
    //   2063: ldc_w 1205
    //   2066: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2069: putfield 2227	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2072: aload_0
    //   2073: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2076: invokevirtual 931	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   2079: ifnonnull +5 -> 2084
    //   2082: iconst_1
    //   2083: ireturn
    //   2084: aload_0
    //   2085: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2088: invokevirtual 931	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   2091: invokevirtual 2213	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   2094: astore 4
    //   2096: new 126	android/content/Intent
    //   2099: dup
    //   2100: aload_0
    //   2101: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2104: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2107: ldc_w 2229
    //   2110: invokespecial 730	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2113: ldc_w 2231
    //   2116: iconst_4
    //   2117: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2120: ldc_w 2232
    //   2123: invokevirtual 1154	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2126: astore 5
    //   2128: aload_1
    //   2129: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2132: ifeq +73 -> 2205
    //   2135: aload_0
    //   2136: getfield 2227	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2139: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2142: ifeq +63 -> 2205
    //   2145: aload_0
    //   2146: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2149: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2152: ifnonnull +5 -> 2157
    //   2155: iconst_1
    //   2156: ireturn
    //   2157: aload_0
    //   2158: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2161: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2164: aload 5
    //   2166: invokevirtual 746	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   2169: goto -1985 -> 184
    //   2172: astore_1
    //   2173: ldc 196
    //   2175: iconst_1
    //   2176: new 524	java/lang/StringBuilder
    //   2179: dup
    //   2180: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   2183: ldc_w 2234
    //   2186: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2189: aload_1
    //   2190: invokevirtual 888	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2193: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2196: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2199: invokestatic 535	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2202: goto -2018 -> 184
    //   2205: aload 5
    //   2207: ldc_w 2209
    //   2210: aload_1
    //   2211: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2214: ldc 161
    //   2216: aload_3
    //   2217: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2220: ldc_w 2225
    //   2223: aload_2
    //   2224: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2227: ldc_w 2219
    //   2230: aload 4
    //   2232: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2235: ldc_w 2221
    //   2238: iconst_1
    //   2239: invokevirtual 463	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2242: pop
    //   2243: aload_0
    //   2244: aload 5
    //   2246: bipush 17
    //   2248: invokevirtual 1414	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2251: goto -2067 -> 184
    //   2254: ldc_w 2236
    //   2257: aload 4
    //   2259: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2280: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2283: ldc_w 1205
    //   2286: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2289: astore_1
    //   2290: aload_0
    //   2291: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2294: aload_0
    //   2295: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2298: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2301: invokevirtual 615	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2304: astore_2
    //   2305: aload_2
    //   2306: ifnull +23 -> 2329
    //   2309: aload_2
    //   2310: instanceof 1538
    //   2313: ifeq +16 -> 2329
    //   2316: aload_2
    //   2317: checkcast 1538	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2320: invokeinterface 1541 1 0
    //   2325: aload_1
    //   2326: putfield 2239	com/tencent/biz/webviewplugin/Share:s	Ljava/lang/String;
    //   2329: aload_1
    //   2330: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2333: ifne -2149 -> 184
    //   2336: aload_0
    //   2337: iconst_2
    //   2338: invokevirtual 2240	com/tencent/mobileqq/jsp/UiApiPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   2341: checkcast 1221	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   2344: astore_1
    //   2345: aload_1
    //   2346: ifnull -2162 -> 184
    //   2349: aload_1
    //   2350: invokevirtual 2241	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:e	()V
    //   2353: goto -2169 -> 184
    //   2356: astore_1
    //   2357: aload_1
    //   2358: invokevirtual 2244	org/json/JSONException:printStackTrace	()V
    //   2361: goto -2177 -> 184
    //   2364: ldc_w 2246
    //   2367: aload 4
    //   2369: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2391: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2394: ldc_w 1205
    //   2397: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2400: putfield 1824	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2403: goto -2219 -> 184
    //   2406: astore_1
    //   2407: aload_1
    //   2408: invokevirtual 2244	org/json/JSONException:printStackTrace	()V
    //   2411: goto -2227 -> 184
    //   2414: ldc_w 2248
    //   2417: aload 4
    //   2419: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2440: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2443: ldc_w 1205
    //   2446: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2449: astore_1
    //   2450: aload_0
    //   2451: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2454: aload_0
    //   2455: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2458: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2461: invokevirtual 615	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2464: astore_2
    //   2465: aload_2
    //   2466: ifnull -2282 -> 184
    //   2469: aload_2
    //   2470: instanceof 1538
    //   2473: ifeq -2289 -> 184
    //   2476: aload_2
    //   2477: checkcast 1538	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2480: invokeinterface 1541 1 0
    //   2485: aload_1
    //   2486: invokevirtual 2249	com/tencent/biz/webviewplugin/Share:a	(Ljava/lang/String;)V
    //   2489: goto -2305 -> 184
    //   2492: astore_1
    //   2493: aload_1
    //   2494: invokevirtual 2244	org/json/JSONException:printStackTrace	()V
    //   2497: goto -2313 -> 184
    //   2500: ldc_w 2251
    //   2503: aload 4
    //   2505: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2526: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2529: ldc_w 1205
    //   2532: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2535: astore_1
    //   2536: aload_0
    //   2537: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2540: aload_0
    //   2541: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2544: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2547: invokevirtual 615	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2550: astore_2
    //   2551: aload_2
    //   2552: ifnull +23 -> 2575
    //   2555: aload_2
    //   2556: instanceof 1538
    //   2559: ifeq +16 -> 2575
    //   2562: aload_2
    //   2563: checkcast 1538	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2566: invokeinterface 1541 1 0
    //   2571: aload_1
    //   2572: putfield 2254	com/tencent/biz/webviewplugin/Share:o	Ljava/lang/String;
    //   2575: aconst_null
    //   2576: ldc_w 358
    //   2579: ldc_w 2256
    //   2582: ldc_w 362
    //   2585: ldc_w 2258
    //   2588: ldc_w 2258
    //   2591: iconst_0
    //   2592: iconst_0
    //   2593: ldc_w 362
    //   2596: ldc_w 362
    //   2599: ldc_w 362
    //   2602: ldc_w 362
    //   2605: invokestatic 755	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2608: goto -2424 -> 184
    //   2611: astore_1
    //   2612: aload_1
    //   2613: invokevirtual 2244	org/json/JSONException:printStackTrace	()V
    //   2616: goto -41 -> 2575
    //   2619: ldc_w 2260
    //   2622: aload 4
    //   2624: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2645: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2648: ldc_w 1205
    //   2651: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2654: astore_1
    //   2655: aload_0
    //   2656: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2659: aload_0
    //   2660: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2663: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2666: invokevirtual 615	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2669: astore_2
    //   2670: aload_2
    //   2671: ifnull +23 -> 2694
    //   2674: aload_2
    //   2675: instanceof 1538
    //   2678: ifeq +16 -> 2694
    //   2681: aload_2
    //   2682: checkcast 1538	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2685: invokeinterface 1541 1 0
    //   2690: aload_1
    //   2691: putfield 2263	com/tencent/biz/webviewplugin/Share:p	Ljava/lang/String;
    //   2694: aconst_null
    //   2695: ldc_w 358
    //   2698: ldc_w 2256
    //   2701: ldc_w 362
    //   2704: ldc_w 2265
    //   2707: ldc_w 2265
    //   2710: iconst_0
    //   2711: iconst_0
    //   2712: ldc_w 362
    //   2715: ldc_w 362
    //   2718: ldc_w 362
    //   2721: ldc_w 362
    //   2724: invokestatic 755	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2727: goto -2543 -> 184
    //   2730: astore_1
    //   2731: aload_1
    //   2732: invokevirtual 2244	org/json/JSONException:printStackTrace	()V
    //   2735: goto -41 -> 2694
    //   2738: ldc_w 2267
    //   2741: aload 4
    //   2743: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2764: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2767: ldc_w 1205
    //   2770: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2773: astore_1
    //   2774: aload_0
    //   2775: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2778: aload_0
    //   2779: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2782: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2785: invokevirtual 615	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2788: astore_2
    //   2789: aload_2
    //   2790: ifnull +23 -> 2813
    //   2793: aload_2
    //   2794: instanceof 1538
    //   2797: ifeq +16 -> 2813
    //   2800: aload_2
    //   2801: checkcast 1538	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2804: invokeinterface 1541 1 0
    //   2809: aload_1
    //   2810: putfield 2270	com/tencent/biz/webviewplugin/Share:q	Ljava/lang/String;
    //   2813: aconst_null
    //   2814: ldc_w 358
    //   2817: ldc_w 2256
    //   2820: ldc_w 362
    //   2823: ldc_w 2272
    //   2826: ldc_w 2272
    //   2829: iconst_0
    //   2830: iconst_0
    //   2831: ldc_w 362
    //   2834: ldc_w 362
    //   2837: ldc_w 362
    //   2840: ldc_w 362
    //   2843: invokestatic 755	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2846: goto -2662 -> 184
    //   2849: astore_1
    //   2850: aload_1
    //   2851: invokevirtual 2244	org/json/JSONException:printStackTrace	()V
    //   2854: goto -41 -> 2813
    //   2857: ldc_w 2274
    //   2860: aload 4
    //   2862: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2883: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2886: ldc_w 1205
    //   2889: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2892: astore_1
    //   2893: aload_0
    //   2894: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2897: aload_0
    //   2898: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2901: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2904: invokevirtual 615	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2907: astore_2
    //   2908: aload_2
    //   2909: ifnull +23 -> 2932
    //   2912: aload_2
    //   2913: instanceof 1538
    //   2916: ifeq +16 -> 2932
    //   2919: aload_2
    //   2920: checkcast 1538	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2923: invokeinterface 1541 1 0
    //   2928: aload_1
    //   2929: putfield 2277	com/tencent/biz/webviewplugin/Share:r	Ljava/lang/String;
    //   2932: aconst_null
    //   2933: ldc_w 358
    //   2936: ldc_w 2256
    //   2939: ldc_w 362
    //   2942: ldc_w 2279
    //   2945: ldc_w 2279
    //   2948: iconst_0
    //   2949: iconst_0
    //   2950: ldc_w 362
    //   2953: ldc_w 362
    //   2956: ldc_w 362
    //   2959: ldc_w 362
    //   2962: invokestatic 755	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2965: goto -2781 -> 184
    //   2968: astore_1
    //   2969: aload_1
    //   2970: invokevirtual 2244	org/json/JSONException:printStackTrace	()V
    //   2973: goto -41 -> 2932
    //   2976: ldc_w 2281
    //   2979: aload 4
    //   2981: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   3002: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3005: astore 5
    //   3007: aload_0
    //   3008: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3011: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3014: astore 4
    //   3016: aload 4
    //   3018: ifnull +12450 -> 15468
    //   3021: aload 4
    //   3023: invokevirtual 658	android/app/Activity:isFinishing	()Z
    //   3026: ifeq +6 -> 3032
    //   3029: goto +12439 -> 15468
    //   3032: aload 5
    //   3034: ldc_w 832
    //   3037: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3040: astore_1
    //   3041: aload 5
    //   3043: ldc_w 1258
    //   3046: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3049: astore 15
    //   3051: aload 5
    //   3053: ldc_w 2283
    //   3056: iconst_1
    //   3057: invokevirtual 953	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3060: istore 12
    //   3062: aload 5
    //   3064: ldc_w 2285
    //   3067: iconst_1
    //   3068: invokevirtual 953	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3071: istore 13
    //   3073: aload 5
    //   3075: ldc_w 2287
    //   3078: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3081: astore_2
    //   3082: aload 5
    //   3084: ldc_w 2289
    //   3087: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3090: astore_3
    //   3091: aload 5
    //   3093: ldc_w 1205
    //   3096: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3099: astore 5
    //   3101: aload 4
    //   3103: iconst_0
    //   3104: invokestatic 2294	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   3107: astore 14
    //   3109: aload 14
    //   3111: aload_1
    //   3112: invokevirtual 2300	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   3115: pop
    //   3116: aload 14
    //   3118: aload 15
    //   3120: invokevirtual 2304	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   3123: pop
    //   3124: new 2306	aefw
    //   3127: dup
    //   3128: aload_0
    //   3129: aload 5
    //   3131: invokespecial 2307	aefw:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   3134: astore 15
    //   3136: iload 13
    //   3138: ifeq +30 -> 3168
    //   3141: aload_3
    //   3142: astore_1
    //   3143: aload_3
    //   3144: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3147: ifeq +12 -> 3159
    //   3150: aload 4
    //   3152: ldc_w 2308
    //   3155: invokevirtual 1976	android/app/Activity:getString	(I)Ljava/lang/String;
    //   3158: astore_1
    //   3159: aload 14
    //   3161: aload_1
    //   3162: aload 15
    //   3164: invokevirtual 2312	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   3167: pop
    //   3168: iload 12
    //   3170: ifeq +30 -> 3200
    //   3173: aload_2
    //   3174: astore_1
    //   3175: aload_2
    //   3176: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3179: ifeq +12 -> 3191
    //   3182: aload 4
    //   3184: ldc_w 2313
    //   3187: invokevirtual 1976	android/app/Activity:getString	(I)Ljava/lang/String;
    //   3190: astore_1
    //   3191: aload 14
    //   3193: aload_1
    //   3194: aload 15
    //   3196: invokevirtual 2316	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   3199: pop
    //   3200: aload 5
    //   3202: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3205: ifne +18 -> 3223
    //   3208: aload 14
    //   3210: new 2318	aegf
    //   3213: dup
    //   3214: aload_0
    //   3215: aload 5
    //   3217: invokespecial 2319	aegf:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   3220: invokevirtual 2320	com/tencent/mobileqq/utils/QQCustomDialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   3223: aload 14
    //   3225: invokevirtual 2321	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   3228: goto -3044 -> 184
    //   3231: astore_1
    //   3232: goto -3048 -> 184
    //   3235: astore_1
    //   3236: aload_1
    //   3237: invokevirtual 2244	org/json/JSONException:printStackTrace	()V
    //   3240: goto -3056 -> 184
    //   3243: ldc_w 2323
    //   3246: aload 4
    //   3248: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   3269: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3272: astore_2
    //   3273: aload_2
    //   3274: ldc_w 2325
    //   3277: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3280: astore_3
    //   3281: aload_2
    //   3282: ldc_w 2327
    //   3285: invokevirtual 1045	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3288: astore_2
    //   3289: ldc_w 2329
    //   3292: aload_3
    //   3293: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3296: ifeq +106 -> 3402
    //   3299: aload_2
    //   3300: ldc_w 2033
    //   3303: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3306: astore_2
    //   3307: aload_2
    //   3308: invokestatic 2040	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3311: ifeq +66 -> 3377
    //   3314: new 126	android/content/Intent
    //   3317: dup
    //   3318: invokespecial 218	android/content/Intent:<init>	()V
    //   3321: astore_3
    //   3322: aload_3
    //   3323: getstatic 2332	cooperation/troop/TroopFileProxyActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3326: aload_2
    //   3327: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3330: pop
    //   3331: aload_0
    //   3332: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3335: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3338: aload_3
    //   3339: aload_0
    //   3340: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3343: invokevirtual 891	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   3346: invokevirtual 1463	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3349: invokestatic 2335	cooperation/troop/TroopFileProxyActivity:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)V
    //   3352: aload_1
    //   3353: ldc_w 2337
    //   3356: invokevirtual 2162	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3359: goto -3175 -> 184
    //   3362: astore_2
    //   3363: aload_2
    //   3364: invokevirtual 2244	org/json/JSONException:printStackTrace	()V
    //   3367: aload_1
    //   3368: ldc_w 2339
    //   3371: invokevirtual 2162	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3374: goto -3190 -> 184
    //   3377: aload_1
    //   3378: ldc_w 2339
    //   3381: invokevirtual 2162	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3384: goto -3200 -> 184
    //   3387: astore_2
    //   3388: aload_2
    //   3389: invokevirtual 2340	java/lang/Exception:printStackTrace	()V
    //   3392: aload_1
    //   3393: ldc_w 2339
    //   3396: invokevirtual 2162	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3399: goto -3215 -> 184
    //   3402: ldc_w 2342
    //   3405: aload_3
    //   3406: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3409: ifeq +71 -> 3480
    //   3412: aload_2
    //   3413: ldc_w 2033
    //   3416: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3419: astore_2
    //   3420: aload_2
    //   3421: invokestatic 2040	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3424: ifeq +46 -> 3470
    //   3427: invokestatic 2347	cooperation/qzone/QZoneHelper$UserInfo:a	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   3430: astore_3
    //   3431: aload_3
    //   3432: aload_0
    //   3433: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3436: invokevirtual 891	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   3439: invokevirtual 1463	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3442: putfield 2348	cooperation/qzone/QZoneHelper$UserInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3445: aload_0
    //   3446: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3449: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3452: aload_3
    //   3453: aload_2
    //   3454: aconst_null
    //   3455: iconst_0
    //   3456: iconst_0
    //   3457: invokestatic 2353	cooperation/qzone/QZoneHelper:a	(Landroid/app/Activity;Lcooperation/qzone/QZoneHelper$UserInfo;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   3460: aload_1
    //   3461: ldc_w 2337
    //   3464: invokevirtual 2162	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3467: goto -3283 -> 184
    //   3470: aload_1
    //   3471: ldc_w 2339
    //   3474: invokevirtual 2162	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3477: goto -3293 -> 184
    //   3480: ldc_w 2355
    //   3483: aload_3
    //   3484: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3487: ifeq +66 -> 3553
    //   3490: aload_0
    //   3491: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3494: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3497: astore_3
    //   3498: aload_2
    //   3499: ldc_w 2033
    //   3502: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3505: astore_2
    //   3506: aload_3
    //   3507: ifnull -3323 -> 184
    //   3510: aload_2
    //   3511: invokestatic 2040	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3514: ifeq -3330 -> 184
    //   3517: new 126	android/content/Intent
    //   3520: dup
    //   3521: aload_3
    //   3522: ldc_w 2357
    //   3525: invokespecial 730	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3528: astore 4
    //   3530: aload 4
    //   3532: ldc_w 1483
    //   3535: aload_2
    //   3536: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3539: pop
    //   3540: aload_3
    //   3541: aload 4
    //   3543: invokevirtual 746	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3546: aload_3
    //   3547: invokevirtual 232	android/app/Activity:finish	()V
    //   3550: goto -3366 -> 184
    //   3553: ldc_w 2359
    //   3556: aload_3
    //   3557: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3560: ifeq -3376 -> 184
    //   3563: aload_0
    //   3564: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3567: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3570: astore_3
    //   3571: aload_2
    //   3572: ldc_w 2033
    //   3575: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3578: astore 4
    //   3580: aload_2
    //   3581: ldc_w 2035
    //   3584: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3587: astore_2
    //   3588: aload_3
    //   3589: ifnull -3405 -> 184
    //   3592: aload 4
    //   3594: invokestatic 2040	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3597: ifeq -3413 -> 184
    //   3600: aload_2
    //   3601: invokestatic 2040	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3604: ifeq -3420 -> 184
    //   3607: new 126	android/content/Intent
    //   3610: dup
    //   3611: aload_3
    //   3612: ldc_w 2042
    //   3615: invokespecial 730	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3618: astore 5
    //   3620: aload 5
    //   3622: ldc_w 1483
    //   3625: aload 4
    //   3627: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3630: pop
    //   3631: aload 5
    //   3633: ldc_w 2035
    //   3636: aload_2
    //   3637: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3640: pop
    //   3641: aload_3
    //   3642: aload 5
    //   3644: invokevirtual 746	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3647: goto -3463 -> 184
    //   3650: ldc_w 2360
    //   3653: aload 4
    //   3655: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3658: ifeq +732 -> 4390
    //   3661: aload 5
    //   3663: arraylength
    //   3664: iconst_1
    //   3665: if_icmpne +725 -> 4390
    //   3668: aload_0
    //   3669: ldc_w 362
    //   3672: putfield 2362	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   3675: new 110	org/json/JSONObject
    //   3678: dup
    //   3679: aload 5
    //   3681: iconst_0
    //   3682: aaload
    //   3683: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3686: astore_1
    //   3687: aload_1
    //   3688: ifnull +684 -> 4372
    //   3691: aload_0
    //   3692: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3695: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3698: astore_3
    //   3699: aload_1
    //   3700: ldc_w 2364
    //   3703: ldc_w 2366
    //   3706: invokevirtual 2116	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3709: astore 14
    //   3711: aload_1
    //   3712: ldc_w 2209
    //   3715: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3718: astore 4
    //   3720: aload_1
    //   3721: ldc_w 1041
    //   3724: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3727: astore 15
    //   3729: aload_1
    //   3730: ldc_w 2368
    //   3733: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3736: astore 5
    //   3738: aload_1
    //   3739: ldc_w 1205
    //   3742: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3745: astore_2
    //   3746: aload_1
    //   3747: ldc_w 1031
    //   3750: iconst_m1
    //   3751: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3754: istore 6
    //   3756: new 110	org/json/JSONObject
    //   3759: dup
    //   3760: aload 15
    //   3762: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3765: astore_1
    //   3766: aload_0
    //   3767: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3770: invokevirtual 931	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   3773: astore 15
    //   3775: aload 15
    //   3777: ifnull +16 -> 3793
    //   3780: aload_1
    //   3781: ldc_w 2370
    //   3784: aload 15
    //   3786: invokevirtual 1061	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   3789: invokevirtual 167	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3792: pop
    //   3793: ldc_w 2372
    //   3796: aload 14
    //   3798: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3801: ifeq +164 -> 3965
    //   3804: new 792	android/os/Bundle
    //   3807: dup
    //   3808: invokespecial 793	android/os/Bundle:<init>	()V
    //   3811: astore_2
    //   3812: aload_2
    //   3813: ldc_w 1041
    //   3816: aload_1
    //   3817: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3820: invokevirtual 805	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3823: aload_2
    //   3824: ldc_w 2368
    //   3827: aload 5
    //   3829: invokevirtual 805	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3832: ldc_w 2374
    //   3835: aload 4
    //   3837: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3840: ifeq +95 -> 3935
    //   3843: new 2376	com/tencent/mobileqq/troop/activity/PublicCommentWindow
    //   3846: dup
    //   3847: aload_3
    //   3848: checkcast 2378	com/tencent/mobileqq/app/BaseActivity
    //   3851: aload_2
    //   3852: invokespecial 2381	com/tencent/mobileqq/troop/activity/PublicCommentWindow:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   3855: aload_3
    //   3856: invokevirtual 2383	com/tencent/mobileqq/troop/activity/PublicCommentWindow:a	(Landroid/app/Activity;)V
    //   3859: goto -3675 -> 184
    //   3862: astore_1
    //   3863: ldc_w 362
    //   3866: astore_2
    //   3867: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3870: ifeq +22 -> 3892
    //   3873: ldc 196
    //   3875: iconst_2
    //   3876: ldc_w 2385
    //   3879: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3882: ldc 196
    //   3884: iconst_2
    //   3885: aload_1
    //   3886: invokestatic 413	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3889: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3892: aload_2
    //   3893: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3896: ifne -3712 -> 184
    //   3899: aload_0
    //   3900: aload_2
    //   3901: iconst_1
    //   3902: anewarray 325	java/lang/String
    //   3905: dup
    //   3906: iconst_0
    //   3907: ldc_w 2387
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
    //   3935: ldc_w 2389
    //   3938: aload 4
    //   3940: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3943: ifeq -3759 -> 184
    //   3946: new 2391	com/tencent/mobileqq/troop/activity/TroopBarCommentWindow
    //   3949: dup
    //   3950: aload_3
    //   3951: checkcast 2378	com/tencent/mobileqq/app/BaseActivity
    //   3954: aload_2
    //   3955: invokespecial 2392	com/tencent/mobileqq/troop/activity/TroopBarCommentWindow:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   3958: aload_3
    //   3959: invokevirtual 2393	com/tencent/mobileqq/troop/activity/TroopBarCommentWindow:a	(Landroid/app/Activity;)V
    //   3962: goto -3778 -> 184
    //   3965: ldc_w 2366
    //   3968: aload 14
    //   3970: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3973: ifeq +289 -> 4262
    //   3976: new 126	android/content/Intent
    //   3979: dup
    //   3980: invokespecial 218	android/content/Intent:<init>	()V
    //   3983: astore 14
    //   3985: ldc_w 2395
    //   3988: aload 4
    //   3990: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3993: ifeq +119 -> 4112
    //   3996: aload 14
    //   3998: new 2397	android/content/ComponentName
    //   4001: dup
    //   4002: aload_0
    //   4003: invokevirtual 1575	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   4006: aload 4
    //   4008: invokespecial 2399	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4011: invokevirtual 2403	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4014: pop
    //   4015: aload 14
    //   4017: ldc_w 2405
    //   4020: invokestatic 968	java/lang/System:currentTimeMillis	()J
    //   4023: invokevirtual 1169	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   4026: pop
    //   4027: aload 14
    //   4029: ldc_w 1041
    //   4032: aload_1
    //   4033: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4036: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4039: pop
    //   4040: aload_0
    //   4041: aload 5
    //   4043: putfield 2362	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4046: aload 5
    //   4048: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4051: ifeq +166 -> 4217
    //   4054: aload_3
    //   4055: aload 14
    //   4057: invokevirtual 746	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   4060: goto +11410 -> 15470
    //   4063: ldc_w 2407
    //   4066: invokevirtual 139	java/lang/Class:getName	()Ljava/lang/String;
    //   4069: aload 4
    //   4071: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4074: ifeq -3890 -> 184
    //   4077: aload_0
    //   4078: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4081: ifnonnull +17 -> 4098
    //   4084: aload_0
    //   4085: invokestatic 1427	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4088: putfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4091: aload_0
    //   4092: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4095: invokevirtual 1428	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   4098: aload_0
    //   4099: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4102: invokevirtual 2409	com/tencent/biz/troop/TroopMemberApiClient:c	()V
    //   4105: goto -3921 -> 184
    //   4108: astore_1
    //   4109: goto -242 -> 3867
    //   4112: ldc_w 2411
    //   4115: aload 4
    //   4117: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4120: ifeq +78 -> 4198
    //   4123: aload 14
    //   4125: new 2397	android/content/ComponentName
    //   4128: dup
    //   4129: aload_3
    //   4130: aload 4
    //   4132: invokespecial 2399	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4135: invokevirtual 2403	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4138: pop
    //   4139: aload 14
    //   4141: ldc_w 2413
    //   4144: iconst_0
    //   4145: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   4148: pop
    //   4149: aload 14
    //   4151: ldc_w 959
    //   4154: invokestatic 968	java/lang/System:currentTimeMillis	()J
    //   4157: invokevirtual 1169	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   4160: pop
    //   4161: aload 14
    //   4163: getstatic 2417	cooperation/qqindividuality/QQIndividualityUtils:l	Ljava/lang/String;
    //   4166: iconst_1
    //   4167: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   4170: pop
    //   4171: aload 14
    //   4173: getstatic 2418	cooperation/qqindividuality/QQIndividualityUtils:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   4176: ldc_w 2420
    //   4179: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4182: pop
    //   4183: aload 14
    //   4185: getstatic 2421	cooperation/qqindividuality/QQIndividualityUtils:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4188: ldc_w 2209
    //   4191: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4194: pop
    //   4195: goto -168 -> 4027
    //   4198: aload 14
    //   4200: new 2397	android/content/ComponentName
    //   4203: dup
    //   4204: aload_3
    //   4205: aload 4
    //   4207: invokespecial 2399	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4210: invokevirtual 2403	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4213: pop
    //   4214: goto -187 -> 4027
    //   4217: aload_0
    //   4218: aload 14
    //   4220: iconst_4
    //   4221: invokevirtual 1414	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   4224: aload_2
    //   4225: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4228: ifne +11242 -> 15470
    //   4231: aload_0
    //   4232: aload_2
    //   4233: iconst_1
    //   4234: anewarray 325	java/lang/String
    //   4237: dup
    //   4238: iconst_0
    //   4239: ldc_w 556
    //   4242: aastore
    //   4243: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4246: goto +11224 -> 15470
    //   4249: aload_3
    //   4250: ldc_w 2422
    //   4253: ldc_w 2423
    //   4256: invokevirtual 1034	android/app/Activity:overridePendingTransition	(II)V
    //   4259: goto -196 -> 4063
    //   4262: ldc_w 2425
    //   4265: aload 14
    //   4267: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4270: ifeq -4086 -> 184
    //   4273: aload 4
    //   4275: ldc_w 2427
    //   4278: invokevirtual 139	java/lang/Class:getName	()Ljava/lang/String;
    //   4281: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4284: ifeq -4100 -> 184
    //   4287: aload_1
    //   4288: ldc_w 2429
    //   4291: iconst_0
    //   4292: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4295: iconst_1
    //   4296: if_icmpne -4112 -> 184
    //   4299: aload_0
    //   4300: aload 5
    //   4302: putfield 2362	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4305: aload_1
    //   4306: ldc 151
    //   4308: ldc_w 362
    //   4311: invokevirtual 2116	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4314: astore_2
    //   4315: aload_0
    //   4316: aload_3
    //   4317: aload_0
    //   4318: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4321: invokevirtual 891	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   4324: aload_1
    //   4325: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4328: iconst_4
    //   4329: aload_2
    //   4330: invokestatic 2434	com/tencent/mobileqq/tribe/fragment/TribeEffectsCameraCaptureFragment:a	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;BLjava/lang/String;)V
    //   4333: aload_3
    //   4334: ldc_w 2422
    //   4337: ldc_w 2423
    //   4340: invokevirtual 1034	android/app/Activity:overridePendingTransition	(II)V
    //   4343: ldc_w 362
    //   4346: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4349: ifne -4165 -> 184
    //   4352: aload_0
    //   4353: ldc_w 362
    //   4356: iconst_1
    //   4357: anewarray 325	java/lang/String
    //   4360: dup
    //   4361: iconst_0
    //   4362: ldc_w 556
    //   4365: aastore
    //   4366: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4369: goto -4185 -> 184
    //   4372: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4375: ifeq -4191 -> 184
    //   4378: ldc 196
    //   4380: iconst_2
    //   4381: ldc_w 2436
    //   4384: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4387: goto -4203 -> 184
    //   4390: ldc_w 2438
    //   4393: aload 4
    //   4395: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4398: ifeq +1689 -> 6087
    //   4401: aload 5
    //   4403: arraylength
    //   4404: iconst_1
    //   4405: if_icmpne +1682 -> 6087
    //   4408: new 110	org/json/JSONObject
    //   4411: dup
    //   4412: aload 5
    //   4414: iconst_0
    //   4415: aaload
    //   4416: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4419: astore_2
    //   4420: aload_0
    //   4421: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4424: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   4427: astore_3
    //   4428: aload_3
    //   4429: instanceof 1019
    //   4432: ifne +5 -> 4437
    //   4435: iconst_1
    //   4436: ireturn
    //   4437: aload_0
    //   4438: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4441: invokevirtual 763	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   4444: astore 4
    //   4446: aload 4
    //   4448: ifnonnull +5 -> 4453
    //   4451: iconst_1
    //   4452: ireturn
    //   4453: aload_2
    //   4454: ldc_w 2440
    //   4457: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4460: ifeq +103 -> 4563
    //   4463: aload_2
    //   4464: ldc_w 2442
    //   4467: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4470: ifeq +93 -> 4563
    //   4473: aload_2
    //   4474: ldc_w 2442
    //   4477: invokevirtual 1159	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   4480: ifeq +83 -> 4563
    //   4483: aload_2
    //   4484: ldc_w 2440
    //   4487: invokestatic 2444	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   4490: istore 6
    //   4492: aload_0
    //   4493: iconst_2
    //   4494: invokespecial 1219	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   4497: checkcast 1221	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   4500: astore_1
    //   4501: aload_1
    //   4502: ifnull +25 -> 4527
    //   4505: aload_1
    //   4506: getfield 2445	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   4509: ifnull +18 -> 4527
    //   4512: aload_1
    //   4513: iload 6
    //   4515: putfield 2446	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_Int	I
    //   4518: aload_1
    //   4519: getfield 2445	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   4522: iload 6
    //   4524: invokevirtual 2447	android/view/View:setBackgroundColor	(I)V
    //   4527: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4530: ifeq +33 -> 4563
    //   4533: ldc 196
    //   4535: iconst_2
    //   4536: new 524	java/lang/StringBuilder
    //   4539: dup
    //   4540: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   4543: ldc_w 2449
    //   4546: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4549: iload 6
    //   4551: invokestatic 2452	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   4554: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4557: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4560: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4563: aload_2
    //   4564: ldc_w 2454
    //   4567: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4570: ifeq +71 -> 4641
    //   4573: aload_2
    //   4574: ldc_w 2454
    //   4577: invokevirtual 1159	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   4580: istore 12
    //   4582: iload 12
    //   4584: ifne +57 -> 4641
    //   4587: aload_0
    //   4588: iconst_2
    //   4589: invokespecial 1219	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   4592: checkcast 1221	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   4595: astore_1
    //   4596: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4599: ifeq +30 -> 4629
    //   4602: ldc 196
    //   4604: iconst_2
    //   4605: new 524	java/lang/StringBuilder
    //   4608: dup
    //   4609: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   4612: ldc_w 2456
    //   4615: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4618: iload 12
    //   4620: invokevirtual 2459	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4623: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4626: invokestatic 2083	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4629: aload_1
    //   4630: ifnull +11 -> 4641
    //   4633: aload_1
    //   4634: getfield 2462	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController	Lcom/tencent/mobileqq/widget/WebViewProgressBarController;
    //   4637: iconst_0
    //   4638: invokevirtual 2466	com/tencent/mobileqq/widget/WebViewProgressBarController:a	(Z)V
    //   4641: aload_2
    //   4642: ldc_w 2468
    //   4645: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4648: ifeq +70 -> 4718
    //   4651: aload_2
    //   4652: ldc_w 2468
    //   4655: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4658: istore 6
    //   4660: aload_3
    //   4661: ldc_w 1972
    //   4664: invokevirtual 663	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4667: checkcast 1693	android/widget/TextView
    //   4670: astore_1
    //   4671: aload_3
    //   4672: ldc_w 2469
    //   4675: invokevirtual 663	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4678: checkcast 641	android/widget/ImageView
    //   4681: astore 5
    //   4683: aload_1
    //   4684: ifnull +34 -> 4718
    //   4687: aload 5
    //   4689: ifnull +29 -> 4718
    //   4692: iload 6
    //   4694: iconst_1
    //   4695: if_icmpne +965 -> 5660
    //   4698: aload 5
    //   4700: invokevirtual 645	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   4703: ifnull +906 -> 5609
    //   4706: aload 5
    //   4708: iconst_0
    //   4709: invokevirtual 683	android/widget/ImageView:setVisibility	(I)V
    //   4712: aload_1
    //   4713: bipush 8
    //   4715: invokevirtual 2470	android/widget/TextView:setVisibility	(I)V
    //   4718: aload_2
    //   4719: ldc_w 2472
    //   4722: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4725: ifeq +24 -> 4749
    //   4728: aload_2
    //   4729: ldc_w 2472
    //   4732: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4735: iconst_1
    //   4736: if_icmpne +10759 -> 15495
    //   4739: iconst_1
    //   4740: istore 12
    //   4742: aload 4
    //   4744: iload 12
    //   4746: invokevirtual 2474	com/tencent/mobileqq/webview/swift/WebViewFragment:g	(Z)V
    //   4749: aload_2
    //   4750: ldc_w 2476
    //   4753: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4756: ifeq +132 -> 4888
    //   4759: aload_2
    //   4760: ldc_w 2478
    //   4763: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4766: ifeq +122 -> 4888
    //   4769: aload_2
    //   4770: ldc_w 2480
    //   4773: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4776: ifeq +112 -> 4888
    //   4779: aload_2
    //   4780: ldc_w 2482
    //   4783: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4786: ifeq +102 -> 4888
    //   4789: aload_2
    //   4790: ldc_w 2484
    //   4793: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4796: ifeq +92 -> 4888
    //   4799: aload_2
    //   4800: ldc_w 2476
    //   4803: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4806: astore_1
    //   4807: aload_2
    //   4808: ldc_w 2478
    //   4811: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4814: istore 6
    //   4816: aload_2
    //   4817: ldc_w 2480
    //   4820: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4823: istore 7
    //   4825: aload_2
    //   4826: ldc_w 2482
    //   4829: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4832: istore 8
    //   4834: aload_2
    //   4835: ldc_w 2484
    //   4838: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4841: istore 9
    //   4843: aload 4
    //   4845: getfield 2487	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4848: ifnull +40 -> 4888
    //   4851: aload 4
    //   4853: getfield 2487	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4856: getfield 2490	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   4859: instanceof 633
    //   4862: ifeq +26 -> 4888
    //   4865: aload 4
    //   4867: getfield 2487	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4870: getfield 2490	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   4873: checkcast 633	com/tencent/biz/ui/RefreshView
    //   4876: aload_1
    //   4877: iload 6
    //   4879: iload 7
    //   4881: iload 8
    //   4883: iload 9
    //   4885: invokevirtual 2493	com/tencent/biz/ui/RefreshView:a	(Ljava/lang/String;IIII)V
    //   4888: aload_2
    //   4889: ldc_w 2495
    //   4892: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4895: ifeq +48 -> 4943
    //   4898: aload_2
    //   4899: ldc_w 2495
    //   4902: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4905: astore_1
    //   4906: aload 4
    //   4908: getfield 2487	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4911: ifnull +32 -> 4943
    //   4914: aload 4
    //   4916: getfield 2487	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4919: getfield 2490	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   4922: instanceof 633
    //   4925: ifeq +18 -> 4943
    //   4928: aload 4
    //   4930: getfield 2487	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4933: getfield 2490	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   4936: checkcast 633	com/tencent/biz/ui/RefreshView
    //   4939: aload_1
    //   4940: invokevirtual 2496	com/tencent/biz/ui/RefreshView:a	(Ljava/lang/String;)V
    //   4943: aload 4
    //   4945: invokevirtual 2498	com/tencent/mobileqq/webview/swift/WebViewFragment:f	()Z
    //   4948: ifne +149 -> 5097
    //   4951: aload_2
    //   4952: ldc_w 2500
    //   4955: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4958: ifeq +139 -> 5097
    //   4961: aload_2
    //   4962: ldc_w 2500
    //   4965: invokestatic 2444	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   4968: istore 7
    //   4970: aload_3
    //   4971: ldc_w 659
    //   4974: invokevirtual 663	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4977: astore 5
    //   4979: aload 5
    //   4981: ifnull +116 -> 5097
    //   4984: aconst_null
    //   4985: astore_1
    //   4986: aload_0
    //   4987: invokevirtual 2502	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebProgressInterface;
    //   4990: ifnull +686 -> 5676
    //   4993: aload_0
    //   4994: invokevirtual 2502	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebProgressInterface;
    //   4997: invokeinterface 2505 1 0
    //   5002: astore_1
    //   5003: iload 7
    //   5005: iconst_m1
    //   5006: if_icmpne +747 -> 5753
    //   5009: aload 5
    //   5011: invokevirtual 2508	android/view/View:getPaddingTop	()I
    //   5014: istore 6
    //   5016: aload 5
    //   5018: invokevirtual 2511	android/view/View:getPaddingBottom	()I
    //   5021: istore 7
    //   5023: aload 5
    //   5025: invokevirtual 2514	android/view/View:getPaddingLeft	()I
    //   5028: istore 8
    //   5030: aload 5
    //   5032: invokevirtual 2517	android/view/View:getPaddingRight	()I
    //   5035: istore 9
    //   5037: aload 5
    //   5039: ldc_w 2518
    //   5042: invokevirtual 2519	android/view/View:setBackgroundResource	(I)V
    //   5045: aload 5
    //   5047: iload 8
    //   5049: iload 6
    //   5051: iload 9
    //   5053: iload 7
    //   5055: invokevirtual 2522	android/view/View:setPadding	(IIII)V
    //   5058: aload_1
    //   5059: ifnull +7 -> 5066
    //   5062: aload_1
    //   5063: invokevirtual 2525	com/tencent/mobileqq/widget/WebViewProgressBar:a	()V
    //   5066: aload 4
    //   5068: getfield 2527	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5071: ifnull +26 -> 5097
    //   5074: aload 4
    //   5076: invokevirtual 2529	com/tencent/mobileqq/webview/swift/WebViewFragment:d	()Z
    //   5079: ifeq +621 -> 5700
    //   5082: aload 4
    //   5084: getfield 2527	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5087: iconst_4
    //   5088: invokevirtual 629	android/view/View:setVisibility	(I)V
    //   5091: aload 4
    //   5093: iconst_0
    //   5094: invokevirtual 2531	com/tencent/mobileqq/webview/swift/WebViewFragment:i	(Z)V
    //   5097: aload_2
    //   5098: ldc_w 1215
    //   5101: iconst_m1
    //   5102: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5105: istore 6
    //   5107: aload_0
    //   5108: iconst_2
    //   5109: invokespecial 1219	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   5112: checkcast 1221	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   5115: astore_1
    //   5116: iload 6
    //   5118: iflt +98 -> 5216
    //   5121: aload_1
    //   5122: ifnull +94 -> 5216
    //   5125: aload_1
    //   5126: getfield 1224	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5129: astore 5
    //   5131: iconst_1
    //   5132: iload 6
    //   5134: if_icmpne +10367 -> 15501
    //   5137: iconst_1
    //   5138: istore 12
    //   5140: aload 5
    //   5142: iload 12
    //   5144: putfield 1229	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:w	Z
    //   5147: aload_0
    //   5148: getfield 1890	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5151: ifeq +23 -> 5174
    //   5154: aload_1
    //   5155: aload_1
    //   5156: getfield 2532	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   5159: getfield 1879	com/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   5162: iconst_0
    //   5163: aload_0
    //   5164: getfield 1890	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5167: aload_0
    //   5168: getfield 1890	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5171: invokevirtual 1893	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Landroid/view/View;ZII)V
    //   5174: aload_0
    //   5175: getfield 1903	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5178: ifeq +20 -> 5198
    //   5181: aload_1
    //   5182: aload_0
    //   5183: getfield 639	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   5186: iconst_0
    //   5187: aload_0
    //   5188: getfield 1903	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5191: aload_0
    //   5192: getfield 1903	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5195: invokevirtual 1893	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Landroid/view/View;ZII)V
    //   5198: aload_1
    //   5199: aload_1
    //   5200: getfield 2532	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   5203: getfield 1829	com/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   5206: iconst_1
    //   5207: ldc_w 2533
    //   5210: ldc_w 2534
    //   5213: invokevirtual 1893	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Landroid/view/View;ZII)V
    //   5216: aload_2
    //   5217: ldc_w 2536
    //   5220: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5223: ifeq +23 -> 5246
    //   5226: aload_2
    //   5227: ldc_w 2536
    //   5230: invokestatic 2444	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5233: istore 6
    //   5235: iload 6
    //   5237: iconst_m1
    //   5238: if_icmpne +744 -> 5982
    //   5241: aload 4
    //   5243: invokevirtual 2539	com/tencent/mobileqq/webview/swift/WebViewFragment:A	()V
    //   5246: aload_2
    //   5247: ldc_w 2541
    //   5250: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5253: ifeq +15 -> 5268
    //   5256: aload 4
    //   5258: aload_2
    //   5259: ldc_w 2541
    //   5262: invokevirtual 2544	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5265: invokevirtual 2545	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(Z)V
    //   5268: aload_2
    //   5269: ldc_w 2547
    //   5272: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5275: ifeq +27 -> 5302
    //   5278: aload_2
    //   5279: ldc_w 2547
    //   5282: invokevirtual 2544	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5285: ifeq +757 -> 6042
    //   5288: aload 4
    //   5290: aload 4
    //   5292: invokevirtual 2548	com/tencent/mobileqq/webview/swift/WebViewFragment:a	()J
    //   5295: ldc2_w 2549
    //   5298: land
    //   5299: invokevirtual 2552	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(J)V
    //   5302: aload_2
    //   5303: ldc_w 2554
    //   5306: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5309: ifeq +21 -> 5330
    //   5312: aload_2
    //   5313: ldc_w 2554
    //   5316: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5319: astore 4
    //   5321: aload_3
    //   5322: checkcast 1019	com/tencent/mobileqq/activity/QQBrowserActivity
    //   5325: aload 4
    //   5327: invokevirtual 2556	com/tencent/mobileqq/activity/QQBrowserActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   5330: aload_2
    //   5331: ldc_w 2558
    //   5334: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5337: ifeq +49 -> 5386
    //   5340: aload_2
    //   5341: ldc_w 2558
    //   5344: invokevirtual 1159	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   5347: istore 12
    //   5349: sipush 800
    //   5352: istore 6
    //   5354: aload_2
    //   5355: ldc_w 2560
    //   5358: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5361: ifeq +17 -> 5378
    //   5364: aload_2
    //   5365: ldc_w 2560
    //   5368: invokevirtual 2564	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   5371: ldc2_w 2565
    //   5374: dmul
    //   5375: d2i
    //   5376: istore 6
    //   5378: aload_0
    //   5379: iload 12
    //   5381: iload 6
    //   5383: invokevirtual 2568	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZI)V
    //   5386: aload_2
    //   5387: ldc_w 2570
    //   5390: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5393: ifeq +44 -> 5437
    //   5396: aload_2
    //   5397: ldc_w 2570
    //   5400: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5403: istore 6
    //   5405: aload_1
    //   5406: ifnull +31 -> 5437
    //   5409: iload 6
    //   5411: ifne +648 -> 6059
    //   5414: aload_1
    //   5415: getfield 1224	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5418: iconst_0
    //   5419: putfield 2571	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:jdField_c_of_type_Boolean	Z
    //   5422: aload_1
    //   5423: getfield 1224	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5426: iconst_1
    //   5427: invokestatic 982	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5430: putfield 2574	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:a	Ljava/lang/Boolean;
    //   5433: aload_1
    //   5434: invokevirtual 2576	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:g	()V
    //   5437: aload_2
    //   5438: ldc_w 2578
    //   5441: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5444: ifeq +26 -> 5470
    //   5447: aload_2
    //   5448: ldc_w 2578
    //   5451: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5454: istore 6
    //   5456: aload_1
    //   5457: ifnull +13 -> 5470
    //   5460: iload 6
    //   5462: iconst_1
    //   5463: if_icmpne +7 -> 5470
    //   5466: aload_1
    //   5467: invokevirtual 2580	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:f	()V
    //   5470: aload_2
    //   5471: ldc_w 2582
    //   5474: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5477: ifeq +18 -> 5495
    //   5480: aload_2
    //   5481: ldc_w 2582
    //   5484: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5487: iconst_1
    //   5488: if_icmpne +7 -> 5495
    //   5491: aload_1
    //   5492: invokevirtual 2580	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:f	()V
    //   5495: aload_2
    //   5496: ldc_w 2584
    //   5499: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5502: ifeq +23 -> 5525
    //   5505: aload_2
    //   5506: ldc_w 2584
    //   5509: iconst_0
    //   5510: invokevirtual 953	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5513: istore 12
    //   5515: aload_1
    //   5516: ifnull +9 -> 5525
    //   5519: aload_1
    //   5520: iload 12
    //   5522: invokevirtual 2585	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:b	(Z)V
    //   5525: aload_2
    //   5526: ldc_w 2587
    //   5529: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5532: ifeq -5348 -> 184
    //   5535: aload_2
    //   5536: ldc_w 2587
    //   5539: iconst_0
    //   5540: invokevirtual 953	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5543: istore 12
    //   5545: aload_1
    //   5546: ifnull -5362 -> 184
    //   5549: aload_1
    //   5550: getfield 2532	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   5553: getfield 2588	com/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5556: getfield 2590	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:j	Z
    //   5559: iload 12
    //   5561: if_icmpeq -5377 -> 184
    //   5564: aload_1
    //   5565: iload 12
    //   5567: invokevirtual 2592	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:c	(Z)V
    //   5570: goto -5386 -> 184
    //   5573: astore_1
    //   5574: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5577: ifeq -5393 -> 184
    //   5580: ldc 196
    //   5582: iconst_4
    //   5583: new 524	java/lang/StringBuilder
    //   5586: dup
    //   5587: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   5590: ldc_w 2594
    //   5593: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5596: aload_1
    //   5597: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5600: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5603: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5606: goto -5422 -> 184
    //   5609: aload 5
    //   5611: bipush 8
    //   5613: invokevirtual 683	android/widget/ImageView:setVisibility	(I)V
    //   5616: aload_1
    //   5617: iconst_0
    //   5618: invokevirtual 2470	android/widget/TextView:setVisibility	(I)V
    //   5621: goto -903 -> 4718
    //   5624: astore_1
    //   5625: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5628: ifeq -5444 -> 184
    //   5631: ldc 196
    //   5633: iconst_4
    //   5634: new 524	java/lang/StringBuilder
    //   5637: dup
    //   5638: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   5641: ldc_w 2594
    //   5644: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5647: aload_1
    //   5648: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5651: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5654: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5657: goto -5473 -> 184
    //   5660: aload_1
    //   5661: bipush 8
    //   5663: invokevirtual 2470	android/widget/TextView:setVisibility	(I)V
    //   5666: aload 5
    //   5668: bipush 8
    //   5670: invokevirtual 683	android/widget/ImageView:setVisibility	(I)V
    //   5673: goto -955 -> 4718
    //   5676: aload_0
    //   5677: iconst_2
    //   5678: invokespecial 1219	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   5681: checkcast 1221	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   5684: astore 14
    //   5686: aload 14
    //   5688: ifnull -685 -> 5003
    //   5691: aload 14
    //   5693: getfield 2597	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar	Lcom/tencent/mobileqq/widget/WebViewProgressBar;
    //   5696: astore_1
    //   5697: goto -694 -> 5003
    //   5700: iconst_0
    //   5701: invokestatic 2601	com/tencent/mobileqq/theme/ThemeUtil:isDefaultOrDIYTheme	(Z)Z
    //   5704: ifeq +26 -> 5730
    //   5707: aload 4
    //   5709: getfield 2527	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5712: ldc_w 2602
    //   5715: invokevirtual 2519	android/view/View:setBackgroundResource	(I)V
    //   5718: aload 4
    //   5720: getfield 2527	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5723: iconst_0
    //   5724: invokevirtual 629	android/view/View:setVisibility	(I)V
    //   5727: goto -636 -> 5091
    //   5730: aload 4
    //   5732: getfield 2527	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5735: invokestatic 497	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5738: invokevirtual 2603	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   5741: ldc_w 2604
    //   5744: invokevirtual 1723	android/content/res/Resources:getColor	(I)I
    //   5747: invokevirtual 2447	android/view/View:setBackgroundColor	(I)V
    //   5750: goto -32 -> 5718
    //   5753: aload 5
    //   5755: iconst_0
    //   5756: invokevirtual 2519	android/view/View:setBackgroundResource	(I)V
    //   5759: ldc_w 1302
    //   5762: istore 6
    //   5764: aload_2
    //   5765: ldc_w 2606
    //   5768: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5771: ifeq +15 -> 5786
    //   5774: aload_2
    //   5775: ldc_w 2606
    //   5778: invokestatic 2444	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5781: bipush 24
    //   5783: ishl
    //   5784: istore 6
    //   5786: iload 7
    //   5788: iload 6
    //   5790: ior
    //   5791: istore 8
    //   5793: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5796: ifeq +61 -> 5857
    //   5799: ldc 196
    //   5801: iconst_2
    //   5802: new 524	java/lang/StringBuilder
    //   5805: dup
    //   5806: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   5809: ldc_w 2608
    //   5812: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5815: iload 6
    //   5817: invokestatic 2452	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5820: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5823: ldc_w 2610
    //   5826: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5829: iload 7
    //   5831: invokestatic 2452	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5834: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5837: ldc_w 2612
    //   5840: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5843: iload 8
    //   5845: invokestatic 2452	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5848: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5851: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5854: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5857: aload 5
    //   5859: iload 8
    //   5861: invokevirtual 2447	android/view/View:setBackgroundColor	(I)V
    //   5864: aload_1
    //   5865: ifnull +13 -> 5878
    //   5868: aload_1
    //   5869: ldc_w 1302
    //   5872: iload 7
    //   5874: ior
    //   5875: invokevirtual 2615	com/tencent/mobileqq/widget/WebViewProgressBar:setCustomColor	(I)V
    //   5878: aload 4
    //   5880: invokevirtual 2529	com/tencent/mobileqq/webview/swift/WebViewFragment:d	()Z
    //   5883: ifeq +28 -> 5911
    //   5886: aload 4
    //   5888: getfield 2527	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5891: ifnonnull +60 -> 5951
    //   5894: aload 4
    //   5896: iconst_1
    //   5897: invokevirtual 2617	com/tencent/mobileqq/webview/swift/WebViewFragment:j	(Z)V
    //   5900: aload 4
    //   5902: iconst_1
    //   5903: invokevirtual 2619	com/tencent/mobileqq/webview/swift/WebViewFragment:k	(Z)V
    //   5906: aload 4
    //   5908: invokevirtual 2621	com/tencent/mobileqq/webview/swift/WebViewFragment:y	()V
    //   5911: aload 4
    //   5913: getfield 2527	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5916: ifnull -819 -> 5097
    //   5919: aload_2
    //   5920: ldc_w 2623
    //   5923: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5926: ifeq +37 -> 5963
    //   5929: aload_2
    //   5930: ldc_w 2623
    //   5933: invokestatic 2444	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5936: istore 6
    //   5938: aload 4
    //   5940: getfield 2527	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5943: iload 6
    //   5945: invokevirtual 2447	android/view/View:setBackgroundColor	(I)V
    //   5948: goto -851 -> 5097
    //   5951: aload 4
    //   5953: getfield 2527	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5956: iconst_0
    //   5957: invokevirtual 629	android/view/View:setVisibility	(I)V
    //   5960: goto -49 -> 5911
    //   5963: aload 4
    //   5965: getfield 2527	com/tencent/mobileqq/webview/swift/WebViewFragment:d	Landroid/view/View;
    //   5968: iload 8
    //   5970: invokevirtual 2447	android/view/View:setBackgroundColor	(I)V
    //   5973: aload 4
    //   5975: iconst_1
    //   5976: invokevirtual 2531	com/tencent/mobileqq/webview/swift/WebViewFragment:i	(Z)V
    //   5979: goto -882 -> 5097
    //   5982: aload 4
    //   5984: ldc_w 1302
    //   5987: iload 6
    //   5989: ior
    //   5990: invokevirtual 2625	com/tencent/mobileqq/webview/swift/WebViewFragment:c	(I)V
    //   5993: aload_2
    //   5994: ldc_w 2627
    //   5997: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6000: ifeq +9507 -> 15507
    //   6003: aload_2
    //   6004: ldc_w 2627
    //   6007: invokestatic 2444	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6010: istore 7
    //   6012: iload 7
    //   6014: iconst_m1
    //   6015: if_icmpeq +9492 -> 15507
    //   6018: ldc_w 1302
    //   6021: iload 7
    //   6023: ior
    //   6024: istore 6
    //   6026: aload 4
    //   6028: iload 6
    //   6030: invokevirtual 2629	com/tencent/mobileqq/webview/swift/WebViewFragment:d	(I)V
    //   6033: aload_0
    //   6034: iload 6
    //   6036: invokevirtual 2631	com/tencent/mobileqq/jsp/UiApiPlugin:a	(I)V
    //   6039: goto -793 -> 5246
    //   6042: aload 4
    //   6044: aload 4
    //   6046: invokevirtual 2548	com/tencent/mobileqq/webview/swift/WebViewFragment:a	()J
    //   6049: ldc2_w 1981
    //   6052: lor
    //   6053: invokevirtual 2552	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(J)V
    //   6056: goto -754 -> 5302
    //   6059: iload 6
    //   6061: iconst_1
    //   6062: if_icmpne -629 -> 5433
    //   6065: aload_1
    //   6066: getfield 1224	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   6069: iconst_1
    //   6070: putfield 2571	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:jdField_c_of_type_Boolean	Z
    //   6073: aload_1
    //   6074: getfield 1224	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   6077: iconst_0
    //   6078: invokestatic 982	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6081: putfield 2574	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:a	Ljava/lang/Boolean;
    //   6084: goto -651 -> 5433
    //   6087: ldc_w 2633
    //   6090: aload 4
    //   6092: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6095: ifeq +484 -> 6579
    //   6098: aload 5
    //   6100: arraylength
    //   6101: iconst_1
    //   6102: if_icmpgt +477 -> 6579
    //   6105: new 110	org/json/JSONObject
    //   6108: dup
    //   6109: aload 5
    //   6111: iconst_0
    //   6112: aaload
    //   6113: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6116: astore_1
    //   6117: aload_0
    //   6118: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6121: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   6124: instanceof 1019
    //   6127: ifne +5 -> 6132
    //   6130: iconst_1
    //   6131: ireturn
    //   6132: new 2635	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo
    //   6135: dup
    //   6136: invokespecial 2636	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:<init>	()V
    //   6139: astore_2
    //   6140: aload_1
    //   6141: ldc_w 2638
    //   6144: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6147: ifeq +18 -> 6165
    //   6150: aload_2
    //   6151: aload_1
    //   6152: ldc_w 2638
    //   6155: invokestatic 2444	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6158: ldc_w 1302
    //   6161: ior
    //   6162: putfield 2639	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_Int	I
    //   6165: aload_1
    //   6166: ldc_w 1205
    //   6169: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6172: ifeq +14 -> 6186
    //   6175: aload_2
    //   6176: aload_1
    //   6177: ldc_w 1205
    //   6180: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6183: putfield 2640	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6186: aload_1
    //   6187: ldc_w 2642
    //   6190: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6193: ifeq +176 -> 6369
    //   6196: aload_2
    //   6197: new 1276	java/util/ArrayList
    //   6200: dup
    //   6201: invokespecial 1590	java/util/ArrayList:<init>	()V
    //   6204: putfield 2645	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6207: aload_1
    //   6208: ldc_w 2642
    //   6211: invokevirtual 844	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6214: astore_3
    //   6215: aload_3
    //   6216: invokevirtual 859	org/json/JSONArray:length	()I
    //   6219: istore 7
    //   6221: iconst_0
    //   6222: istore 6
    //   6224: iload 6
    //   6226: iload 7
    //   6228: if_icmpge +141 -> 6369
    //   6231: aload_3
    //   6232: iload 6
    //   6234: invokevirtual 2648	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6237: astore 4
    //   6239: new 2650	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton
    //   6242: dup
    //   6243: invokespecial 2651	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:<init>	()V
    //   6246: astore 5
    //   6248: aload 4
    //   6250: ldc_w 1258
    //   6253: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6256: ifeq +16 -> 6272
    //   6259: aload 5
    //   6261: aload 4
    //   6263: ldc_w 1258
    //   6266: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6269: putfield 2652	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6272: aload 4
    //   6274: ldc_w 1642
    //   6277: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6280: ifeq +16 -> 6296
    //   6283: aload 5
    //   6285: aload 4
    //   6287: ldc_w 1642
    //   6290: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6293: putfield 2653	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_a_of_type_Int	I
    //   6296: aload 4
    //   6298: ldc_w 2655
    //   6301: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6304: ifeq +16 -> 6320
    //   6307: aload 5
    //   6309: aload 4
    //   6311: ldc_w 2655
    //   6314: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6317: putfield 2656	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6320: aload 4
    //   6322: ldc_w 1260
    //   6325: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6328: ifeq +20 -> 6348
    //   6331: aload 5
    //   6333: aload 4
    //   6335: ldc_w 1260
    //   6338: invokestatic 2444	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6341: ldc_w 1302
    //   6344: ior
    //   6345: putfield 2657	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_b_of_type_Int	I
    //   6348: aload_2
    //   6349: getfield 2645	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6352: aload 5
    //   6354: invokeinterface 1687 2 0
    //   6359: pop
    //   6360: iload 6
    //   6362: iconst_1
    //   6363: iadd
    //   6364: istore 6
    //   6366: goto -142 -> 6224
    //   6369: aload_1
    //   6370: ldc_w 2659
    //   6373: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6376: ifeq +78 -> 6454
    //   6379: aload_2
    //   6380: new 1276	java/util/ArrayList
    //   6383: dup
    //   6384: invokespecial 1590	java/util/ArrayList:<init>	()V
    //   6387: putfield 2661	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:b	Ljava/util/List;
    //   6390: aload_1
    //   6391: ldc_w 2659
    //   6394: invokevirtual 844	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6397: astore_1
    //   6398: aload_1
    //   6399: invokevirtual 859	org/json/JSONArray:length	()I
    //   6402: istore 7
    //   6404: iconst_0
    //   6405: istore 6
    //   6407: iload 6
    //   6409: iload 7
    //   6411: if_icmpge +43 -> 6454
    //   6414: aload_1
    //   6415: iload 6
    //   6417: invokevirtual 2648	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6420: ldc 157
    //   6422: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6425: ifeq +9093 -> 15518
    //   6428: aload_1
    //   6429: iload 6
    //   6431: invokevirtual 2648	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6434: ldc 157
    //   6436: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6439: astore_3
    //   6440: aload_2
    //   6441: getfield 2661	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:b	Ljava/util/List;
    //   6444: aload_3
    //   6445: invokeinterface 1687 2 0
    //   6450: pop
    //   6451: goto +9067 -> 15518
    //   6454: aload_0
    //   6455: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6458: invokevirtual 931	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   6461: astore_1
    //   6462: aload_1
    //   6463: ifnull +8976 -> 15439
    //   6466: aload_1
    //   6467: invokevirtual 2664	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   6470: astore_1
    //   6471: aload_1
    //   6472: ifnull +8967 -> 15439
    //   6475: aload_1
    //   6476: ldc_w 2666
    //   6479: invokevirtual 2671	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   6482: astore_1
    //   6483: aload_1
    //   6484: ifnull +8955 -> 15439
    //   6487: aload_1
    //   6488: instanceof 171
    //   6491: ifeq +8948 -> 15439
    //   6494: aload_1
    //   6495: checkcast 171	com/tencent/biz/webviewplugin/PubAccountUIPlugin
    //   6498: astore_1
    //   6499: aload_1
    //   6500: ifnull -6316 -> 184
    //   6503: aload_1
    //   6504: aload_2
    //   6505: invokevirtual 2674	com/tencent/biz/webviewplugin/PubAccountUIPlugin:a	(Lcom/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo;)V
    //   6508: aload_2
    //   6509: getfield 2640	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6512: ifnull -6328 -> 184
    //   6515: aload_1
    //   6516: invokestatic 2676	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lcom/tencent/biz/webviewplugin/PubAccountUIPlugin;)Ljava/lang/String;
    //   6519: astore_1
    //   6520: aload_1
    //   6521: ifnull -6337 -> 184
    //   6524: aload_0
    //   6525: aload_2
    //   6526: getfield 2640	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6529: iconst_1
    //   6530: anewarray 325	java/lang/String
    //   6533: dup
    //   6534: iconst_0
    //   6535: aload_1
    //   6536: aastore
    //   6537: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   6540: goto -6356 -> 184
    //   6543: astore_1
    //   6544: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6547: ifeq -6363 -> 184
    //   6550: ldc 196
    //   6552: iconst_4
    //   6553: new 524	java/lang/StringBuilder
    //   6556: dup
    //   6557: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   6560: ldc_w 2678
    //   6563: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6566: aload_1
    //   6567: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6570: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6573: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6576: goto -6392 -> 184
    //   6579: ldc_w 2680
    //   6582: aload 4
    //   6584: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6587: ifeq +176 -> 6763
    //   6590: aload 5
    //   6592: arraylength
    //   6593: iconst_1
    //   6594: if_icmpgt +169 -> 6763
    //   6597: new 110	org/json/JSONObject
    //   6600: dup
    //   6601: aload 5
    //   6603: iconst_0
    //   6604: aaload
    //   6605: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6608: astore_1
    //   6609: aload_0
    //   6610: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6613: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   6616: instanceof 1019
    //   6619: ifne +5 -> 6624
    //   6622: iconst_1
    //   6623: ireturn
    //   6624: aload_1
    //   6625: ldc_w 2681
    //   6628: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6631: ifeq -6447 -> 184
    //   6634: aload_1
    //   6635: ldc_w 2681
    //   6638: invokevirtual 1159	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   6641: istore 12
    //   6643: aload_1
    //   6644: ldc_w 2683
    //   6647: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6650: ifeq +8783 -> 15433
    //   6653: aload_1
    //   6654: ldc_w 2683
    //   6657: invokevirtual 2564	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   6660: ldc2_w 2565
    //   6663: dmul
    //   6664: d2i
    //   6665: istore 6
    //   6667: aload_0
    //   6668: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6671: invokevirtual 931	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   6674: astore_1
    //   6675: aload_1
    //   6676: ifnull +8752 -> 15428
    //   6679: aload_1
    //   6680: invokevirtual 2664	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   6683: astore_1
    //   6684: aload_1
    //   6685: ifnull +8743 -> 15428
    //   6688: aload_1
    //   6689: ldc_w 2666
    //   6692: invokevirtual 2671	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   6695: astore_1
    //   6696: aload_1
    //   6697: ifnull +8731 -> 15428
    //   6700: aload_1
    //   6701: instanceof 171
    //   6704: ifeq +8724 -> 15428
    //   6707: aload_1
    //   6708: checkcast 171	com/tencent/biz/webviewplugin/PubAccountUIPlugin
    //   6711: astore_1
    //   6712: aload_1
    //   6713: ifnull -6529 -> 184
    //   6716: aload_1
    //   6717: iload 12
    //   6719: iload 6
    //   6721: invokevirtual 2684	com/tencent/biz/webviewplugin/PubAccountUIPlugin:a	(ZI)V
    //   6724: goto -6540 -> 184
    //   6727: astore_1
    //   6728: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6731: ifeq -6547 -> 184
    //   6734: ldc 196
    //   6736: iconst_4
    //   6737: new 524	java/lang/StringBuilder
    //   6740: dup
    //   6741: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   6744: ldc_w 2686
    //   6747: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6750: aload_1
    //   6751: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6754: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6757: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6760: goto -6576 -> 184
    //   6763: ldc_w 2688
    //   6766: aload 4
    //   6768: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6771: ifeq +226 -> 6997
    //   6774: aload 5
    //   6776: arraylength
    //   6777: iconst_1
    //   6778: if_icmpgt +219 -> 6997
    //   6781: new 110	org/json/JSONObject
    //   6784: dup
    //   6785: aload 5
    //   6787: iconst_0
    //   6788: aaload
    //   6789: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6792: astore_1
    //   6793: aload_0
    //   6794: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6797: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   6800: instanceof 1019
    //   6803: ifne +5 -> 6808
    //   6806: iconst_1
    //   6807: ireturn
    //   6808: new 2650	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton
    //   6811: dup
    //   6812: invokespecial 2651	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:<init>	()V
    //   6815: astore_2
    //   6816: aload_1
    //   6817: ldc_w 1258
    //   6820: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6823: ifeq +14 -> 6837
    //   6826: aload_2
    //   6827: aload_1
    //   6828: ldc_w 1258
    //   6831: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6834: putfield 2652	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6837: aload_1
    //   6838: ldc_w 1642
    //   6841: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6844: ifeq +14 -> 6858
    //   6847: aload_2
    //   6848: aload_1
    //   6849: ldc_w 1642
    //   6852: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6855: putfield 2653	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_a_of_type_Int	I
    //   6858: aload_1
    //   6859: ldc_w 2655
    //   6862: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6865: ifeq +14 -> 6879
    //   6868: aload_2
    //   6869: aload_1
    //   6870: ldc_w 2655
    //   6873: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6876: putfield 2656	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6879: aload_1
    //   6880: ldc_w 1260
    //   6883: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6886: ifeq +18 -> 6904
    //   6889: aload_2
    //   6890: aload_1
    //   6891: ldc_w 1260
    //   6894: invokestatic 2444	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6897: ldc_w 1302
    //   6900: ior
    //   6901: putfield 2657	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_b_of_type_Int	I
    //   6904: aload_0
    //   6905: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6908: invokevirtual 931	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   6911: astore_1
    //   6912: aload_1
    //   6913: ifnull +8510 -> 15423
    //   6916: aload_1
    //   6917: invokevirtual 2664	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   6920: astore_1
    //   6921: aload_1
    //   6922: ifnull +8501 -> 15423
    //   6925: aload_1
    //   6926: ldc_w 2666
    //   6929: invokevirtual 2671	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   6932: astore_1
    //   6933: aload_1
    //   6934: ifnull +8489 -> 15423
    //   6937: aload_1
    //   6938: instanceof 171
    //   6941: ifeq +8482 -> 15423
    //   6944: aload_1
    //   6945: checkcast 171	com/tencent/biz/webviewplugin/PubAccountUIPlugin
    //   6948: astore_1
    //   6949: aload_1
    //   6950: ifnull -6766 -> 184
    //   6953: aload_1
    //   6954: aload_2
    //   6955: invokevirtual 2691	com/tencent/biz/webviewplugin/PubAccountUIPlugin:a	(Lcom/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton;)V
    //   6958: goto -6774 -> 184
    //   6961: astore_1
    //   6962: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6965: ifeq -6781 -> 184
    //   6968: ldc 196
    //   6970: iconst_4
    //   6971: new 524	java/lang/StringBuilder
    //   6974: dup
    //   6975: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   6978: ldc_w 2693
    //   6981: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6984: aload_1
    //   6985: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6988: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6991: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6994: goto -6810 -> 184
    //   6997: ldc_w 2695
    //   7000: aload 4
    //   7002: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7005: ifeq +110 -> 7115
    //   7008: aload 5
    //   7010: arraylength
    //   7011: iconst_1
    //   7012: if_icmpgt +103 -> 7115
    //   7015: aload 5
    //   7017: arraylength
    //   7018: iconst_1
    //   7019: if_icmpne +22 -> 7041
    //   7022: new 110	org/json/JSONObject
    //   7025: dup
    //   7026: aload 5
    //   7028: iconst_0
    //   7029: aaload
    //   7030: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7033: ldc_w 2697
    //   7036: iconst_0
    //   7037: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7040: pop
    //   7041: aload_0
    //   7042: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7045: aload_0
    //   7046: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7049: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   7052: invokevirtual 615	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   7055: astore_1
    //   7056: aload_1
    //   7057: ifnull -6873 -> 184
    //   7060: aload_1
    //   7061: instanceof 2699
    //   7064: ifeq -6880 -> 184
    //   7067: aload_1
    //   7068: checkcast 2699	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebUiMethodInterface
    //   7071: invokeinterface 2701 1 0
    //   7076: goto -6892 -> 184
    //   7079: astore_1
    //   7080: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7083: ifeq -6899 -> 184
    //   7086: ldc 196
    //   7088: iconst_4
    //   7089: new 524	java/lang/StringBuilder
    //   7092: dup
    //   7093: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   7096: ldc_w 2703
    //   7099: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7102: aload_1
    //   7103: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7106: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7109: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7112: goto -6928 -> 184
    //   7115: ldc_w 2705
    //   7118: aload 4
    //   7120: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7123: ifeq +195 -> 7318
    //   7126: aload 5
    //   7128: arraylength
    //   7129: iconst_1
    //   7130: if_icmpne +188 -> 7318
    //   7133: new 110	org/json/JSONObject
    //   7136: dup
    //   7137: aload 5
    //   7139: iconst_0
    //   7140: aaload
    //   7141: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7144: astore_1
    //   7145: aload_1
    //   7146: ldc_w 1522
    //   7149: iconst_0
    //   7150: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7153: istore 6
    //   7155: aload_1
    //   7156: ldc_w 1529
    //   7159: iconst_0
    //   7160: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7163: istore 7
    //   7165: aload_1
    //   7166: ldc_w 1524
    //   7169: iconst_0
    //   7170: invokevirtual 953	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   7173: istore 12
    //   7175: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7178: ifeq +48 -> 7226
    //   7181: ldc 196
    //   7183: iconst_2
    //   7184: new 524	java/lang/StringBuilder
    //   7187: dup
    //   7188: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   7191: ldc_w 2707
    //   7194: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7197: aload_1
    //   7198: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7201: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7204: ldc_w 2709
    //   7207: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7210: aload_0
    //   7211: getfield 98	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   7214: invokevirtual 766	java/lang/Object:toString	()Ljava/lang/String;
    //   7217: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7220: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7223: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7226: invokestatic 287	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7229: new 126	android/content/Intent
    //   7232: dup
    //   7233: ldc_w 1741
    //   7236: invokespecial 131	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   7239: ldc_w 1522
    //   7242: iload 6
    //   7244: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7247: ldc_w 1524
    //   7250: iload 12
    //   7252: invokevirtual 463	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7255: ldc_w 1529
    //   7258: iload 7
    //   7260: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7263: ldc_w 1531
    //   7266: aload_0
    //   7267: getfield 87	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Int	I
    //   7270: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7273: ldc_w 1743
    //   7276: invokevirtual 2714	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   7279: goto -7095 -> 184
    //   7282: astore_1
    //   7283: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7286: ifeq -7102 -> 184
    //   7289: ldc 196
    //   7291: iconst_4
    //   7292: new 524	java/lang/StringBuilder
    //   7295: dup
    //   7296: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   7299: ldc_w 2716
    //   7302: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7305: aload_1
    //   7306: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7309: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7312: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7315: goto -7131 -> 184
    //   7318: ldc_w 2718
    //   7321: aload 4
    //   7323: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7326: ifeq +258 -> 7584
    //   7329: aload 5
    //   7331: arraylength
    //   7332: iconst_1
    //   7333: if_icmpne +251 -> 7584
    //   7336: aload_0
    //   7337: aconst_null
    //   7338: putfield 2720	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   7341: new 110	org/json/JSONObject
    //   7344: dup
    //   7345: aload 5
    //   7347: iconst_0
    //   7348: aaload
    //   7349: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7352: astore_3
    //   7353: aload_3
    //   7354: ldc_w 1160
    //   7357: invokevirtual 2056	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   7360: lstore 10
    //   7362: aload_3
    //   7363: ldc_w 2722
    //   7366: bipush 13
    //   7368: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7371: istore 6
    //   7373: aload_3
    //   7374: ldc_w 2724
    //   7377: iconst_0
    //   7378: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7381: istore 7
    //   7383: aload_3
    //   7384: ldc_w 1205
    //   7387: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7390: astore_1
    //   7391: aload_0
    //   7392: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7395: invokevirtual 891	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   7398: astore_2
    //   7399: aload_2
    //   7400: ifnull +10 -> 7410
    //   7403: aload_2
    //   7404: invokevirtual 2727	com/tencent/common/app/AppInterface:isLogin	()Z
    //   7407: ifne +20 -> 7427
    //   7410: aload_0
    //   7411: aload_1
    //   7412: iconst_1
    //   7413: anewarray 325	java/lang/String
    //   7416: dup
    //   7417: iconst_0
    //   7418: ldc_w 2729
    //   7421: aastore
    //   7422: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7425: iconst_1
    //   7426: ireturn
    //   7427: aload_3
    //   7428: ldc_w 2101
    //   7431: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7434: astore_3
    //   7435: aload_3
    //   7436: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7439: ifne +31 -> 7470
    //   7442: aload_3
    //   7443: aload_2
    //   7444: invokevirtual 894	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   7447: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7450: ifne +20 -> 7470
    //   7453: aload_0
    //   7454: aload_1
    //   7455: iconst_1
    //   7456: anewarray 325	java/lang/String
    //   7459: dup
    //   7460: iconst_0
    //   7461: ldc_w 2731
    //   7464: aastore
    //   7465: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7468: iconst_1
    //   7469: ireturn
    //   7470: aload_0
    //   7471: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7474: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   7477: astore_2
    //   7478: aload_2
    //   7479: ifnull -7295 -> 184
    //   7482: aload_0
    //   7483: aload_1
    //   7484: putfield 2720	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   7487: new 126	android/content/Intent
    //   7490: dup
    //   7491: aload_2
    //   7492: ldc_w 2733
    //   7495: invokespecial 730	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   7498: astore_1
    //   7499: aload_1
    //   7500: ldc_w 795
    //   7503: bipush 16
    //   7505: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7508: pop
    //   7509: aload_1
    //   7510: ldc_w 2722
    //   7513: iload 6
    //   7515: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7518: pop
    //   7519: aload_1
    //   7520: ldc_w 1160
    //   7523: lload 10
    //   7525: invokevirtual 1169	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   7528: pop
    //   7529: aload_1
    //   7530: ldc_w 2724
    //   7533: iload 7
    //   7535: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7538: pop
    //   7539: aload_0
    //   7540: aload_1
    //   7541: iconst_5
    //   7542: invokevirtual 1414	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   7545: goto -7361 -> 184
    //   7548: astore_1
    //   7549: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7552: ifeq -7368 -> 184
    //   7555: ldc 196
    //   7557: iconst_4
    //   7558: new 524	java/lang/StringBuilder
    //   7561: dup
    //   7562: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   7565: ldc_w 2735
    //   7568: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7571: aload_1
    //   7572: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7575: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7578: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7581: goto -7397 -> 184
    //   7584: ldc_w 2737
    //   7587: aload 4
    //   7589: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7592: ifeq +269 -> 7861
    //   7595: aload 5
    //   7597: arraylength
    //   7598: iconst_1
    //   7599: if_icmpne +262 -> 7861
    //   7602: aload_0
    //   7603: aconst_null
    //   7604: putfield 2362	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   7607: new 110	org/json/JSONObject
    //   7610: dup
    //   7611: aload 5
    //   7613: iconst_0
    //   7614: aaload
    //   7615: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7618: astore_3
    //   7619: aload_0
    //   7620: aload_3
    //   7621: ldc_w 2101
    //   7624: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7627: putfield 2739	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   7630: aload_3
    //   7631: ldc_w 2741
    //   7634: iconst_0
    //   7635: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7638: istore 6
    //   7640: aload_0
    //   7641: aload_3
    //   7642: ldc_w 2743
    //   7645: iconst_0
    //   7646: invokevirtual 953	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   7649: putfield 2745	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Boolean	Z
    //   7652: aload_3
    //   7653: ldc_w 1205
    //   7656: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7659: astore_1
    //   7660: aload_0
    //   7661: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7664: invokevirtual 891	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   7667: astore_2
    //   7668: aload_2
    //   7669: ifnull +10 -> 7679
    //   7672: aload_2
    //   7673: invokevirtual 2727	com/tencent/common/app/AppInterface:isLogin	()Z
    //   7676: ifne +20 -> 7696
    //   7679: aload_0
    //   7680: aload_1
    //   7681: iconst_1
    //   7682: anewarray 325	java/lang/String
    //   7685: dup
    //   7686: iconst_0
    //   7687: ldc_w 2747
    //   7690: aastore
    //   7691: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7694: iconst_1
    //   7695: ireturn
    //   7696: aload_0
    //   7697: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7700: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   7703: astore_2
    //   7704: aload_2
    //   7705: ifnull -7521 -> 184
    //   7708: iload 6
    //   7710: ifne -7526 -> 184
    //   7713: aload_3
    //   7714: ldc_w 832
    //   7717: aload_2
    //   7718: ldc_w 2748
    //   7721: invokevirtual 1976	android/app/Activity:getString	(I)Ljava/lang/String;
    //   7724: invokevirtual 2116	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7727: astore_3
    //   7728: aload_0
    //   7729: aload_1
    //   7730: putfield 2362	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   7733: aload_0
    //   7734: getfield 2745	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Boolean	Z
    //   7737: ifeq +101 -> 7838
    //   7740: new 126	android/content/Intent
    //   7743: dup
    //   7744: aload_2
    //   7745: ldc_w 2750
    //   7748: invokespecial 730	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   7751: astore_1
    //   7752: aload_1
    //   7753: ldc_w 2752
    //   7756: iconst_1
    //   7757: invokevirtual 463	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7760: pop
    //   7761: aload_1
    //   7762: ldc_w 2754
    //   7765: aload_0
    //   7766: getfield 2739	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   7769: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7772: pop
    //   7773: aload_1
    //   7774: ldc_w 2756
    //   7777: aload_3
    //   7778: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7781: pop
    //   7782: aload_0
    //   7783: aload_1
    //   7784: bipush 7
    //   7786: invokevirtual 1414	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   7789: aload_2
    //   7790: ldc_w 2757
    //   7793: ldc_w 2758
    //   7796: invokevirtual 1034	android/app/Activity:overridePendingTransition	(II)V
    //   7799: goto -7615 -> 184
    //   7802: astore_1
    //   7803: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7806: ifeq -7622 -> 184
    //   7809: ldc 196
    //   7811: iconst_4
    //   7812: new 524	java/lang/StringBuilder
    //   7815: dup
    //   7816: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   7819: ldc_w 2760
    //   7822: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7825: aload_1
    //   7826: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7829: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7832: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7835: goto -7651 -> 184
    //   7838: aload_2
    //   7839: aload_0
    //   7840: getfield 2739	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   7843: bipush 14
    //   7845: invokestatic 2068	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/Intent;
    //   7848: astore_1
    //   7849: aload_1
    //   7850: ldc_w 2762
    //   7853: aload_3
    //   7854: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7857: pop
    //   7858: goto -76 -> 7782
    //   7861: ldc_w 2764
    //   7864: aload 4
    //   7866: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7869: ifeq +120 -> 7989
    //   7872: aload 5
    //   7874: arraylength
    //   7875: iconst_1
    //   7876: if_icmpne +113 -> 7989
    //   7879: new 110	org/json/JSONObject
    //   7882: dup
    //   7883: aload 5
    //   7885: iconst_0
    //   7886: aaload
    //   7887: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7890: astore_1
    //   7891: aload_1
    //   7892: ldc_w 2766
    //   7895: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7898: ifeq -7714 -> 184
    //   7901: aload_1
    //   7902: ldc_w 2766
    //   7905: invokevirtual 2544	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   7908: istore 12
    //   7910: aload_0
    //   7911: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7914: invokevirtual 931	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7917: invokevirtual 2767	com/tencent/biz/pubaccount/CustomWebView:getParent	()Landroid/view/ViewParent;
    //   7920: checkcast 626	android/view/View
    //   7923: astore_1
    //   7924: aload_1
    //   7925: instanceof 633
    //   7928: ifne +5 -> 7933
    //   7931: iconst_1
    //   7932: ireturn
    //   7933: aload_0
    //   7934: aload_1
    //   7935: checkcast 633	com/tencent/biz/ui/RefreshView
    //   7938: putfield 631	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   7941: aload_0
    //   7942: getfield 631	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   7945: iload 12
    //   7947: invokevirtual 2768	com/tencent/biz/ui/RefreshView:a	(Z)V
    //   7950: goto -7766 -> 184
    //   7953: astore_1
    //   7954: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7957: ifeq -7773 -> 184
    //   7960: ldc 196
    //   7962: iconst_4
    //   7963: new 524	java/lang/StringBuilder
    //   7966: dup
    //   7967: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   7970: ldc_w 2770
    //   7973: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7976: aload_1
    //   7977: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7980: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7983: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7986: goto -7802 -> 184
    //   7989: ldc_w 2772
    //   7992: aload 4
    //   7994: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7997: ifeq +443 -> 8440
    //   8000: aload 5
    //   8002: arraylength
    //   8003: iconst_1
    //   8004: if_icmpne +436 -> 8440
    //   8007: aconst_null
    //   8008: astore 4
    //   8010: aconst_null
    //   8011: astore_3
    //   8012: iconst_1
    //   8013: istore 7
    //   8015: aload_3
    //   8016: astore_2
    //   8017: aload 4
    //   8019: astore_1
    //   8020: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8023: ifeq +37 -> 8060
    //   8026: aload_3
    //   8027: astore_2
    //   8028: aload 4
    //   8030: astore_1
    //   8031: ldc 196
    //   8033: iconst_1
    //   8034: new 524	java/lang/StringBuilder
    //   8037: dup
    //   8038: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   8041: ldc_w 2774
    //   8044: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8047: aload 5
    //   8049: iconst_0
    //   8050: aaload
    //   8051: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8054: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8057: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8060: aload_3
    //   8061: astore_2
    //   8062: aload 4
    //   8064: astore_1
    //   8065: new 110	org/json/JSONObject
    //   8068: dup
    //   8069: aload 5
    //   8071: iconst_0
    //   8072: aaload
    //   8073: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8076: astore 15
    //   8078: aload_3
    //   8079: astore_2
    //   8080: aload 4
    //   8082: astore_1
    //   8083: aload 15
    //   8085: ldc_w 832
    //   8088: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8091: astore 5
    //   8093: aload_3
    //   8094: astore_2
    //   8095: aload 4
    //   8097: astore_1
    //   8098: aload 15
    //   8100: ldc_w 2655
    //   8103: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8106: astore 14
    //   8108: aload_3
    //   8109: astore_2
    //   8110: aload 4
    //   8112: astore_1
    //   8113: aload 15
    //   8115: ldc_w 1205
    //   8118: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8121: astore_3
    //   8122: iload 7
    //   8124: istore 6
    //   8126: aload_3
    //   8127: astore_2
    //   8128: aload_3
    //   8129: astore_1
    //   8130: aload 5
    //   8132: invokevirtual 2775	java/lang/String:length	()I
    //   8135: ifle +71 -> 8206
    //   8138: aload_3
    //   8139: astore_2
    //   8140: aload_3
    //   8141: astore_1
    //   8142: aload_0
    //   8143: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8146: invokevirtual 763	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   8149: astore 4
    //   8151: aload 4
    //   8153: ifnull +219 -> 8372
    //   8156: aload_3
    //   8157: astore_2
    //   8158: aload_3
    //   8159: astore_1
    //   8160: aload 4
    //   8162: getfield 2776	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   8165: ifnull +207 -> 8372
    //   8168: aload_3
    //   8169: astore_2
    //   8170: aload_3
    //   8171: astore_1
    //   8172: aload 4
    //   8174: getfield 2776	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   8177: getfield 2779	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:B	Z
    //   8180: ifeq +75 -> 8255
    //   8183: aload_3
    //   8184: astore_2
    //   8185: aload_3
    //   8186: astore_1
    //   8187: aload 4
    //   8189: aload 5
    //   8191: iconst_m1
    //   8192: aload 14
    //   8194: ldc_w 2781
    //   8197: invokevirtual 139	java/lang/Class:getName	()Ljava/lang/String;
    //   8200: invokevirtual 2784	com/tencent/mobileqq/webview/swift/WebViewFragment:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   8203: iconst_0
    //   8204: istore 6
    //   8206: aload_3
    //   8207: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8210: ifne -8026 -> 184
    //   8213: aload_0
    //   8214: aload_3
    //   8215: iconst_1
    //   8216: anewarray 325	java/lang/String
    //   8219: dup
    //   8220: iconst_0
    //   8221: new 524	java/lang/StringBuilder
    //   8224: dup
    //   8225: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   8228: ldc_w 2786
    //   8231: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8234: iload 6
    //   8236: invokevirtual 924	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8239: ldc_w 1256
    //   8242: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8245: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8248: aastore
    //   8249: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8252: goto -8068 -> 184
    //   8255: aload_3
    //   8256: astore_2
    //   8257: aload_3
    //   8258: astore_1
    //   8259: aload 4
    //   8261: getfield 2776	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   8264: getfield 2788	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:A	Z
    //   8267: ifeq -64 -> 8203
    //   8270: aload_3
    //   8271: astore_2
    //   8272: aload_3
    //   8273: astore_1
    //   8274: new 792	android/os/Bundle
    //   8277: dup
    //   8278: invokespecial 793	android/os/Bundle:<init>	()V
    //   8281: astore 14
    //   8283: aload_3
    //   8284: astore_2
    //   8285: aload_3
    //   8286: astore_1
    //   8287: aload 14
    //   8289: ldc_w 2790
    //   8292: aload 5
    //   8294: invokevirtual 805	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   8297: aload_3
    //   8298: astore_2
    //   8299: aload_3
    //   8300: astore_1
    //   8301: aload 4
    //   8303: aload 14
    //   8305: invokevirtual 2792	com/tencent/mobileqq/webview/swift/WebViewFragment:d	(Landroid/os/Bundle;)V
    //   8308: goto -105 -> 8203
    //   8311: astore_3
    //   8312: aload_2
    //   8313: astore_1
    //   8314: ldc 196
    //   8316: iconst_1
    //   8317: ldc_w 2794
    //   8320: aload_3
    //   8321: invokestatic 1039	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8324: aload_2
    //   8325: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8328: ifne -8144 -> 184
    //   8331: aload_0
    //   8332: aload_2
    //   8333: iconst_1
    //   8334: anewarray 325	java/lang/String
    //   8337: dup
    //   8338: iconst_0
    //   8339: new 524	java/lang/StringBuilder
    //   8342: dup
    //   8343: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   8346: ldc_w 2786
    //   8349: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8352: iconst_1
    //   8353: invokevirtual 924	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8356: ldc_w 1256
    //   8359: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8362: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8365: aastore
    //   8366: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8369: goto -8185 -> 184
    //   8372: aload_3
    //   8373: astore_2
    //   8374: aload_3
    //   8375: astore_1
    //   8376: ldc 196
    //   8378: iconst_1
    //   8379: ldc_w 2796
    //   8382: invokestatic 535	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8385: iload 7
    //   8387: istore 6
    //   8389: goto -183 -> 8206
    //   8392: astore_2
    //   8393: aload_1
    //   8394: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8397: ifne +41 -> 8438
    //   8400: aload_0
    //   8401: aload_1
    //   8402: iconst_1
    //   8403: anewarray 325	java/lang/String
    //   8406: dup
    //   8407: iconst_0
    //   8408: new 524	java/lang/StringBuilder
    //   8411: dup
    //   8412: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   8415: ldc_w 2786
    //   8418: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8421: iconst_1
    //   8422: invokevirtual 924	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8425: ldc_w 1256
    //   8428: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8431: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8434: aastore
    //   8435: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8438: aload_2
    //   8439: athrow
    //   8440: ldc_w 1289
    //   8443: aload 4
    //   8445: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8448: ifeq +245 -> 8693
    //   8451: aload 5
    //   8453: arraylength
    //   8454: iconst_1
    //   8455: if_icmpne +238 -> 8693
    //   8458: new 110	org/json/JSONObject
    //   8461: dup
    //   8462: aload 5
    //   8464: iconst_0
    //   8465: aaload
    //   8466: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8469: astore_1
    //   8470: aload_1
    //   8471: ldc_w 2766
    //   8474: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8477: ifeq +105 -> 8582
    //   8480: aload_1
    //   8481: ldc_w 2766
    //   8484: invokevirtual 2544	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   8487: istore 13
    //   8489: iconst_0
    //   8490: istore 12
    //   8492: ldc_w 2798
    //   8495: aload_1
    //   8496: ldc 151
    //   8498: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8501: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8504: ifeq +6 -> 8510
    //   8507: iconst_1
    //   8508: istore 12
    //   8510: iload 13
    //   8512: aload_0
    //   8513: getfield 2800	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_Boolean	Z
    //   8516: if_icmpeq -8332 -> 184
    //   8519: iload 13
    //   8521: ifeq +54 -> 8575
    //   8524: aload_0
    //   8525: iload 12
    //   8527: invokevirtual 2801	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Z)V
    //   8530: aload_0
    //   8531: iload 13
    //   8533: putfield 2800	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_Boolean	Z
    //   8536: goto -8352 -> 184
    //   8539: astore_1
    //   8540: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   8543: ifeq -8359 -> 184
    //   8546: ldc 196
    //   8548: iconst_4
    //   8549: new 524	java/lang/StringBuilder
    //   8552: dup
    //   8553: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   8556: ldc_w 2770
    //   8559: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8562: aload_1
    //   8563: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8566: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8569: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8572: goto -8388 -> 184
    //   8575: aload_0
    //   8576: invokevirtual 2802	com/tencent/mobileqq/jsp/UiApiPlugin:a	()V
    //   8579: goto -49 -> 8530
    //   8582: aload_1
    //   8583: ldc_w 2804
    //   8586: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8589: ifeq -8405 -> 184
    //   8592: aload_0
    //   8593: getfield 1297	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   8596: ifeq -8412 -> 184
    //   8599: aload_0
    //   8600: iconst_0
    //   8601: putfield 1297	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   8604: aload_1
    //   8605: ldc_w 2804
    //   8608: invokevirtual 2544	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   8611: istore 12
    //   8613: invokestatic 287	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8616: invokevirtual 2805	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   8619: astore_2
    //   8620: iload 12
    //   8622: ifeq +44 -> 8666
    //   8625: aload_0
    //   8626: getfield 1301	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiIPullRefreshHeader	Lcom/tencent/biz/ui/IPullRefreshHeader;
    //   8629: iconst_0
    //   8630: aload_1
    //   8631: ldc_w 1258
    //   8634: aload_2
    //   8635: ldc_w 2806
    //   8638: invokevirtual 2807	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   8641: invokevirtual 2116	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8644: invokeinterface 2810 3 0
    //   8649: aload_0
    //   8650: getfield 631	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8653: ifnull -8469 -> 184
    //   8656: aload_0
    //   8657: getfield 631	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8660: invokevirtual 2811	com/tencent/biz/ui/RefreshView:c	()V
    //   8663: goto -8479 -> 184
    //   8666: aload_0
    //   8667: getfield 1301	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiIPullRefreshHeader	Lcom/tencent/biz/ui/IPullRefreshHeader;
    //   8670: iconst_1
    //   8671: aload_1
    //   8672: ldc_w 1258
    //   8675: aload_2
    //   8676: ldc_w 2812
    //   8679: invokevirtual 2807	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   8682: invokevirtual 2116	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8685: invokeinterface 2810 3 0
    //   8690: goto -41 -> 8649
    //   8693: ldc_w 2814
    //   8696: aload 4
    //   8698: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8701: ifeq +192 -> 8893
    //   8704: aload 5
    //   8706: arraylength
    //   8707: iconst_1
    //   8708: if_icmpne +185 -> 8893
    //   8711: new 110	org/json/JSONObject
    //   8714: dup
    //   8715: aload 5
    //   8717: iconst_0
    //   8718: aaload
    //   8719: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8722: astore_2
    //   8723: aload_2
    //   8724: ldc_w 2816
    //   8727: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8730: istore 6
    //   8732: aload_2
    //   8733: ldc 157
    //   8735: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8738: astore_1
    //   8739: aload_2
    //   8740: ldc 204
    //   8742: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8745: istore 7
    //   8747: aload_0
    //   8748: aload_2
    //   8749: ldc_w 1205
    //   8752: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8755: putfield 2362	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8758: new 126	android/content/Intent
    //   8761: dup
    //   8762: getstatic 2820	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   8765: ldc_w 2822
    //   8768: invokespecial 730	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   8771: astore_2
    //   8772: aload_2
    //   8773: ldc_w 2824
    //   8776: iload 6
    //   8778: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8781: pop
    //   8782: aload_2
    //   8783: ldc_w 2826
    //   8786: aload_1
    //   8787: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8790: pop
    //   8791: aload_2
    //   8792: ldc_w 2828
    //   8795: iload 7
    //   8797: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8800: pop
    //   8801: aload_2
    //   8802: ldc_w 2830
    //   8805: bipush 6
    //   8807: invokevirtual 2833	android/content/Intent:putExtra	(Ljava/lang/String;B)Landroid/content/Intent;
    //   8810: pop
    //   8811: aload_0
    //   8812: aload_2
    //   8813: bipush 6
    //   8815: invokevirtual 1414	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   8818: goto -8634 -> 184
    //   8821: astore_1
    //   8822: aload_1
    //   8823: invokevirtual 2244	org/json/JSONException:printStackTrace	()V
    //   8826: aload_0
    //   8827: getfield 2362	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8830: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8833: ifne -8649 -> 184
    //   8836: aload_0
    //   8837: aload_0
    //   8838: getfield 2362	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8841: iconst_1
    //   8842: anewarray 325	java/lang/String
    //   8845: dup
    //   8846: iconst_0
    //   8847: ldc_w 2835
    //   8850: aastore
    //   8851: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8854: goto -8670 -> 184
    //   8857: astore_1
    //   8858: aload_1
    //   8859: invokevirtual 2340	java/lang/Exception:printStackTrace	()V
    //   8862: aload_0
    //   8863: getfield 2362	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8866: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8869: ifne -8685 -> 184
    //   8872: aload_0
    //   8873: aload_0
    //   8874: getfield 2362	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8877: iconst_1
    //   8878: anewarray 325	java/lang/String
    //   8881: dup
    //   8882: iconst_0
    //   8883: ldc_w 2835
    //   8886: aastore
    //   8887: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8890: goto -8706 -> 184
    //   8893: ldc_w 2837
    //   8896: aload 4
    //   8898: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8901: ifeq +250 -> 9151
    //   8904: aload_0
    //   8905: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8908: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   8911: astore_1
    //   8912: aload_0
    //   8913: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8916: invokevirtual 891	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   8919: astore_2
    //   8920: aload_1
    //   8921: ifnull -8737 -> 184
    //   8924: aload_2
    //   8925: ifnull -8741 -> 184
    //   8928: aconst_null
    //   8929: astore_2
    //   8930: aload_2
    //   8931: astore_1
    //   8932: new 110	org/json/JSONObject
    //   8935: dup
    //   8936: aload 5
    //   8938: iconst_0
    //   8939: aaload
    //   8940: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8943: astore_3
    //   8944: aload_2
    //   8945: astore_1
    //   8946: aload_3
    //   8947: ldc_w 1205
    //   8950: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8953: astore_2
    //   8954: aload_2
    //   8955: astore_1
    //   8956: aload_3
    //   8957: ldc_w 2101
    //   8960: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   8963: invokestatic 2841	com/tencent/mobileqq/nearby/NearbyURLSafeUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   8966: astore 4
    //   8968: aload_2
    //   8969: astore_1
    //   8970: aload_3
    //   8971: ldc_w 2843
    //   8974: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8977: astore 5
    //   8979: aload_2
    //   8980: astore_1
    //   8981: aload_3
    //   8982: ldc_w 2845
    //   8985: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   8988: istore 7
    //   8990: iconst_0
    //   8991: istore 6
    //   8993: aload_2
    //   8994: astore_1
    //   8995: aload_3
    //   8996: ldc_w 2847
    //   8999: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   9002: ifeq +14 -> 9016
    //   9005: aload_2
    //   9006: astore_1
    //   9007: aload_3
    //   9008: ldc_w 2847
    //   9011: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   9014: istore 6
    //   9016: aload_2
    //   9017: astore_1
    //   9018: new 792	android/os/Bundle
    //   9021: dup
    //   9022: invokespecial 793	android/os/Bundle:<init>	()V
    //   9025: astore_3
    //   9026: aload_2
    //   9027: astore_1
    //   9028: aload_3
    //   9029: ldc_w 2101
    //   9032: aload 4
    //   9034: invokevirtual 805	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9037: aload 5
    //   9039: ifnull +14 -> 9053
    //   9042: aload_2
    //   9043: astore_1
    //   9044: aload_3
    //   9045: ldc_w 2843
    //   9048: aload 5
    //   9050: invokevirtual 805	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9053: aload_2
    //   9054: astore_1
    //   9055: aload_3
    //   9056: ldc_w 2849
    //   9059: iload 7
    //   9061: invokevirtual 799	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9064: aload_2
    //   9065: astore_1
    //   9066: aload_3
    //   9067: ldc_w 2851
    //   9070: ldc_w 2837
    //   9073: invokevirtual 805	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9076: aload_2
    //   9077: astore_1
    //   9078: aload_3
    //   9079: ldc_w 2847
    //   9082: iload 6
    //   9084: invokevirtual 799	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9087: aload_2
    //   9088: astore_1
    //   9089: ldc_w 2853
    //   9092: aload_2
    //   9093: aload_0
    //   9094: getfield 94	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   9097: getfield 2858	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   9100: aload_3
    //   9101: invokestatic 2863	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   9104: astore_3
    //   9105: aload_2
    //   9106: astore_1
    //   9107: invokestatic 2868	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   9110: aload_3
    //   9111: invokevirtual 2870	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   9114: goto -8930 -> 184
    //   9117: astore_2
    //   9118: aload_1
    //   9119: ifnull -8935 -> 184
    //   9122: aload_0
    //   9123: aload_1
    //   9124: iconst_1
    //   9125: anewarray 325	java/lang/String
    //   9128: dup
    //   9129: iconst_0
    //   9130: ldc_w 2872
    //   9133: iconst_1
    //   9134: anewarray 765	java/lang/Object
    //   9137: dup
    //   9138: iconst_0
    //   9139: aload_2
    //   9140: aastore
    //   9141: invokestatic 772	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9144: aastore
    //   9145: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9148: goto -8964 -> 184
    //   9151: ldc_w 2874
    //   9154: aload 4
    //   9156: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9159: ifeq +403 -> 9562
    //   9162: aload_0
    //   9163: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9166: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   9169: astore_1
    //   9170: aload_0
    //   9171: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9174: invokevirtual 891	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   9177: astore_2
    //   9178: aload_1
    //   9179: ifnull -8995 -> 184
    //   9182: aload_2
    //   9183: ifnull -8999 -> 184
    //   9186: aconst_null
    //   9187: astore_2
    //   9188: aconst_null
    //   9189: astore 4
    //   9191: aload_2
    //   9192: astore_1
    //   9193: new 110	org/json/JSONObject
    //   9196: dup
    //   9197: aload 5
    //   9199: iconst_0
    //   9200: aaload
    //   9201: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9204: astore 14
    //   9206: aload_2
    //   9207: astore_1
    //   9208: aload 14
    //   9210: ldc_w 1205
    //   9213: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9216: astore_3
    //   9217: aload_3
    //   9218: astore_1
    //   9219: aload 14
    //   9221: ldc_w 2101
    //   9224: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9227: invokestatic 2841	com/tencent/mobileqq/nearby/NearbyURLSafeUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9230: astore_2
    //   9231: aload_3
    //   9232: astore_1
    //   9233: aload 14
    //   9235: ldc_w 2099
    //   9238: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9241: astore 5
    //   9243: aload_3
    //   9244: astore_1
    //   9245: aload 14
    //   9247: ldc_w 2876
    //   9250: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9253: astore 15
    //   9255: iconst_0
    //   9256: istore 12
    //   9258: aload_3
    //   9259: astore_1
    //   9260: aload 5
    //   9262: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9265: ifne +6155 -> 15420
    //   9268: iconst_1
    //   9269: istore 12
    //   9271: aload 5
    //   9273: astore_2
    //   9274: aload_3
    //   9275: astore_1
    //   9276: aload 14
    //   9278: ldc_w 2843
    //   9281: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9284: astore 5
    //   9286: aload_3
    //   9287: astore_1
    //   9288: aload 14
    //   9290: ldc_w 2845
    //   9293: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9296: istore 6
    //   9298: aload_3
    //   9299: astore_1
    //   9300: aload 14
    //   9302: ldc_w 2878
    //   9305: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9308: istore 7
    //   9310: aload_3
    //   9311: astore_1
    //   9312: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9315: ifeq +35 -> 9350
    //   9318: aload_3
    //   9319: astore_1
    //   9320: ldc 196
    //   9322: iconst_2
    //   9323: new 524	java/lang/StringBuilder
    //   9326: dup
    //   9327: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   9330: ldc_w 2880
    //   9333: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9336: aload 14
    //   9338: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   9341: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9344: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9347: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9350: aload_3
    //   9351: astore_1
    //   9352: aload_2
    //   9353: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9356: ifne +178 -> 9534
    //   9359: aload_3
    //   9360: astore_1
    //   9361: new 792	android/os/Bundle
    //   9364: dup
    //   9365: invokespecial 793	android/os/Bundle:<init>	()V
    //   9368: astore 14
    //   9370: aload_3
    //   9371: astore_1
    //   9372: aload 14
    //   9374: ldc_w 2845
    //   9377: iload 6
    //   9379: invokevirtual 799	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9382: aload_3
    //   9383: astore_1
    //   9384: aload 14
    //   9386: ldc_w 2101
    //   9389: aload_2
    //   9390: invokevirtual 805	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9393: aload_3
    //   9394: astore_1
    //   9395: aload 14
    //   9397: ldc_w 2882
    //   9400: iload 12
    //   9402: invokevirtual 1015	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   9405: aload_3
    //   9406: astore_1
    //   9407: aload 14
    //   9409: ldc_w 2851
    //   9412: ldc_w 2874
    //   9415: invokevirtual 805	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9418: aload_3
    //   9419: astore_1
    //   9420: aload 14
    //   9422: ldc_w 2878
    //   9425: iload 7
    //   9427: invokevirtual 799	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9430: aload_3
    //   9431: astore_1
    //   9432: aload 5
    //   9434: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9437: ifne +15 -> 9452
    //   9440: aload_3
    //   9441: astore_1
    //   9442: aload 14
    //   9444: ldc_w 2843
    //   9447: aload 5
    //   9449: invokevirtual 805	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9452: aload_3
    //   9453: astore_1
    //   9454: aload 15
    //   9456: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9459: ifne +15 -> 9474
    //   9462: aload_3
    //   9463: astore_1
    //   9464: aload 14
    //   9466: ldc_w 2876
    //   9469: aload 15
    //   9471: invokevirtual 805	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9474: aload_3
    //   9475: astore_1
    //   9476: ldc_w 2853
    //   9479: aload_3
    //   9480: aload_0
    //   9481: getfield 94	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   9484: getfield 2858	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   9487: aload 14
    //   9489: invokestatic 2863	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   9492: astore_2
    //   9493: aload_3
    //   9494: astore_1
    //   9495: invokestatic 2868	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   9498: aload_2
    //   9499: invokevirtual 2870	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   9502: aload_3
    //   9503: astore_1
    //   9504: aload 4
    //   9506: astore_2
    //   9507: aload_2
    //   9508: ifnull -9324 -> 184
    //   9511: aload_1
    //   9512: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9515: ifne -9331 -> 184
    //   9518: aload_0
    //   9519: aload_1
    //   9520: iconst_1
    //   9521: anewarray 325	java/lang/String
    //   9524: dup
    //   9525: iconst_0
    //   9526: aload_2
    //   9527: aastore
    //   9528: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9531: goto -9347 -> 184
    //   9534: ldc_w 2884
    //   9537: astore_2
    //   9538: aload_3
    //   9539: astore_1
    //   9540: goto -33 -> 9507
    //   9543: astore_2
    //   9544: ldc_w 2872
    //   9547: iconst_1
    //   9548: anewarray 765	java/lang/Object
    //   9551: dup
    //   9552: iconst_0
    //   9553: aload_2
    //   9554: aastore
    //   9555: invokestatic 772	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9558: astore_2
    //   9559: goto -52 -> 9507
    //   9562: ldc_w 2886
    //   9565: aload 4
    //   9567: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9570: ifeq +196 -> 9766
    //   9573: aconst_null
    //   9574: astore_2
    //   9575: aload_2
    //   9576: astore_1
    //   9577: new 110	org/json/JSONObject
    //   9580: dup
    //   9581: aload 5
    //   9583: iconst_0
    //   9584: aaload
    //   9585: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9588: astore_3
    //   9589: aload_2
    //   9590: astore_1
    //   9591: aload_3
    //   9592: ldc_w 1205
    //   9595: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9598: astore_2
    //   9599: aload_2
    //   9600: astore_1
    //   9601: aload_3
    //   9602: ldc_w 2766
    //   9605: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   9608: ifeq -9424 -> 184
    //   9611: aload_2
    //   9612: astore_1
    //   9613: aload_3
    //   9614: ldc_w 2766
    //   9617: invokevirtual 1159	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   9620: istore 12
    //   9622: aload_2
    //   9623: astore_1
    //   9624: aload_0
    //   9625: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9628: aload_0
    //   9629: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9632: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   9635: invokevirtual 615	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   9638: astore_3
    //   9639: aload_3
    //   9640: ifnull +83 -> 9723
    //   9643: aload_2
    //   9644: astore_1
    //   9645: aload_3
    //   9646: instanceof 2888
    //   9649: ifeq +74 -> 9723
    //   9652: aload_2
    //   9653: astore_1
    //   9654: aload_3
    //   9655: checkcast 2888	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebEventInterface
    //   9658: astore_3
    //   9659: iload 12
    //   9661: ifne +56 -> 9717
    //   9664: iconst_1
    //   9665: istore 12
    //   9667: aload_2
    //   9668: astore_1
    //   9669: aload_3
    //   9670: iload 12
    //   9672: invokeinterface 2889 2 0
    //   9677: goto -9493 -> 184
    //   9680: astore_2
    //   9681: aload_1
    //   9682: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9685: ifne -9501 -> 184
    //   9688: aload_0
    //   9689: aload_1
    //   9690: iconst_1
    //   9691: anewarray 325	java/lang/String
    //   9694: dup
    //   9695: iconst_0
    //   9696: ldc_w 2872
    //   9699: iconst_1
    //   9700: anewarray 765	java/lang/Object
    //   9703: dup
    //   9704: iconst_0
    //   9705: aload_2
    //   9706: aastore
    //   9707: invokestatic 772	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9710: aastore
    //   9711: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9714: goto -9530 -> 184
    //   9717: iconst_0
    //   9718: istore 12
    //   9720: goto -53 -> 9667
    //   9723: aload_2
    //   9724: astore_1
    //   9725: aload_0
    //   9726: iconst_m1
    //   9727: invokespecial 1219	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   9730: checkcast 2891	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting
    //   9733: astore_3
    //   9734: aload_3
    //   9735: ifnull -9551 -> 184
    //   9738: iload 12
    //   9740: ifne +20 -> 9760
    //   9743: iconst_1
    //   9744: istore 12
    //   9746: aload_2
    //   9747: astore_1
    //   9748: aload_3
    //   9749: ldc_w 2893
    //   9752: iload 12
    //   9754: invokevirtual 2894	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting:a	(Ljava/lang/String;Z)V
    //   9757: goto -9573 -> 184
    //   9760: iconst_0
    //   9761: istore 12
    //   9763: goto -17 -> 9746
    //   9766: ldc_w 2896
    //   9769: aload 4
    //   9771: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9774: ifeq +196 -> 9970
    //   9777: aconst_null
    //   9778: astore_2
    //   9779: aload_2
    //   9780: astore_1
    //   9781: new 110	org/json/JSONObject
    //   9784: dup
    //   9785: aload 5
    //   9787: iconst_0
    //   9788: aaload
    //   9789: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9792: astore_3
    //   9793: aload_2
    //   9794: astore_1
    //   9795: aload_3
    //   9796: ldc_w 1205
    //   9799: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9802: astore_2
    //   9803: aload_2
    //   9804: astore_1
    //   9805: aload_3
    //   9806: ldc_w 2766
    //   9809: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   9812: ifeq -9628 -> 184
    //   9815: aload_2
    //   9816: astore_1
    //   9817: aload_3
    //   9818: ldc_w 2766
    //   9821: invokevirtual 1159	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   9824: istore 12
    //   9826: aload_2
    //   9827: astore_1
    //   9828: aload_0
    //   9829: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9832: aload_0
    //   9833: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9836: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   9839: invokevirtual 615	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   9842: astore_3
    //   9843: aload_3
    //   9844: ifnull +83 -> 9927
    //   9847: aload_2
    //   9848: astore_1
    //   9849: aload_3
    //   9850: instanceof 2888
    //   9853: ifeq +74 -> 9927
    //   9856: aload_2
    //   9857: astore_1
    //   9858: aload_3
    //   9859: checkcast 2888	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebEventInterface
    //   9862: astore_3
    //   9863: iload 12
    //   9865: ifne +56 -> 9921
    //   9868: iconst_1
    //   9869: istore 12
    //   9871: aload_2
    //   9872: astore_1
    //   9873: aload_3
    //   9874: iload 12
    //   9876: invokeinterface 2897 2 0
    //   9881: goto -9697 -> 184
    //   9884: astore_2
    //   9885: aload_1
    //   9886: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9889: ifne -9705 -> 184
    //   9892: aload_0
    //   9893: aload_1
    //   9894: iconst_1
    //   9895: anewarray 325	java/lang/String
    //   9898: dup
    //   9899: iconst_0
    //   9900: ldc_w 2872
    //   9903: iconst_1
    //   9904: anewarray 765	java/lang/Object
    //   9907: dup
    //   9908: iconst_0
    //   9909: aload_2
    //   9910: aastore
    //   9911: invokestatic 772	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9914: aastore
    //   9915: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9918: goto -9734 -> 184
    //   9921: iconst_0
    //   9922: istore 12
    //   9924: goto -53 -> 9871
    //   9927: aload_2
    //   9928: astore_1
    //   9929: aload_0
    //   9930: iconst_m1
    //   9931: invokespecial 1219	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   9934: checkcast 2891	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting
    //   9937: astore_3
    //   9938: aload_3
    //   9939: ifnull -9755 -> 184
    //   9942: iload 12
    //   9944: ifne +20 -> 9964
    //   9947: iconst_1
    //   9948: istore 12
    //   9950: aload_2
    //   9951: astore_1
    //   9952: aload_3
    //   9953: ldc_w 2899
    //   9956: iload 12
    //   9958: invokevirtual 2894	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting:a	(Ljava/lang/String;Z)V
    //   9961: goto -9777 -> 184
    //   9964: iconst_0
    //   9965: istore 12
    //   9967: goto -17 -> 9950
    //   9970: ldc_w 2901
    //   9973: aload 4
    //   9975: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9978: ifeq +221 -> 10199
    //   9981: aload_0
    //   9982: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9985: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   9988: astore 14
    //   9990: aload_0
    //   9991: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9994: invokevirtual 891	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   9997: astore_1
    //   9998: aload 14
    //   10000: ifnull -9816 -> 184
    //   10003: aload_1
    //   10004: ifnull -9820 -> 184
    //   10007: aconst_null
    //   10008: astore_1
    //   10009: aconst_null
    //   10010: astore 4
    //   10012: new 110	org/json/JSONObject
    //   10015: dup
    //   10016: aload 5
    //   10018: iconst_0
    //   10019: aaload
    //   10020: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10023: astore_3
    //   10024: aload_3
    //   10025: ldc_w 1205
    //   10028: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10031: astore_2
    //   10032: aload_2
    //   10033: astore_1
    //   10034: aload_3
    //   10035: ifnull +155 -> 10190
    //   10038: new 792	android/os/Bundle
    //   10041: dup
    //   10042: invokespecial 793	android/os/Bundle:<init>	()V
    //   10045: astore 5
    //   10047: aload 5
    //   10049: ldc_w 2903
    //   10052: aload_3
    //   10053: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   10056: invokevirtual 805	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   10059: aload 14
    //   10061: invokevirtual 940	java/lang/Object:getClass	()Ljava/lang/Class;
    //   10064: invokevirtual 139	java/lang/Class:getName	()Ljava/lang/String;
    //   10067: ldc_w 2905
    //   10070: invokevirtual 945	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   10073: istore 12
    //   10075: aload 4
    //   10077: astore_2
    //   10078: aload_1
    //   10079: astore_3
    //   10080: iload 12
    //   10082: ifeq +41 -> 10123
    //   10085: aconst_null
    //   10086: aload 14
    //   10088: new 110	org/json/JSONObject
    //   10091: dup
    //   10092: aload 5
    //   10094: ldc_w 2903
    //   10097: invokevirtual 2906	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10100: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10103: ldc_w 2908
    //   10106: ldc_w 362
    //   10109: invokevirtual 2116	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10112: invokestatic 2912	com/tencent/biz/pubaccount/subscript/SubscriptUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   10115: invokestatic 2917	com/tencent/biz/pubaccount/util/PublicAccountUtil:a	(Landroid/content/Intent;Landroid/content/Context;Ljava/lang/String;)V
    //   10118: aload_1
    //   10119: astore_3
    //   10120: aload 4
    //   10122: astore_2
    //   10123: aload_2
    //   10124: ifnull -9940 -> 184
    //   10127: aload_3
    //   10128: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10131: ifne -9947 -> 184
    //   10134: aload_0
    //   10135: aload_3
    //   10136: iconst_1
    //   10137: anewarray 325	java/lang/String
    //   10140: dup
    //   10141: iconst_0
    //   10142: aload_2
    //   10143: aastore
    //   10144: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10147: goto -9963 -> 184
    //   10150: astore_2
    //   10151: ldc 196
    //   10153: iconst_2
    //   10154: ldc_w 2919
    //   10157: aload_2
    //   10158: invokestatic 2107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   10161: aload 4
    //   10163: astore_2
    //   10164: aload_1
    //   10165: astore_3
    //   10166: goto -43 -> 10123
    //   10169: astore_2
    //   10170: ldc_w 2872
    //   10173: iconst_1
    //   10174: anewarray 765	java/lang/Object
    //   10177: dup
    //   10178: iconst_0
    //   10179: aload_2
    //   10180: aastore
    //   10181: invokestatic 772	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10184: astore_2
    //   10185: aload_1
    //   10186: astore_3
    //   10187: goto -64 -> 10123
    //   10190: ldc_w 2884
    //   10193: astore_2
    //   10194: aload_1
    //   10195: astore_3
    //   10196: goto -73 -> 10123
    //   10199: ldc_w 2921
    //   10202: aload 4
    //   10204: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10207: ifeq +330 -> 10537
    //   10210: aconst_null
    //   10211: ldc_w 358
    //   10214: ldc_w 360
    //   10217: ldc_w 362
    //   10220: ldc_w 364
    //   10223: ldc_w 2923
    //   10226: iconst_0
    //   10227: iconst_1
    //   10228: iconst_0
    //   10229: aload 5
    //   10231: iconst_0
    //   10232: aaload
    //   10233: ldc_w 362
    //   10236: ldc_w 362
    //   10239: ldc_w 362
    //   10242: invokestatic 371	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   10245: aload_0
    //   10246: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10249: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   10252: astore 14
    //   10254: aload_0
    //   10255: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10258: invokevirtual 891	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   10261: astore_1
    //   10262: aload 14
    //   10264: ifnull -10080 -> 184
    //   10267: aload_1
    //   10268: ifnull -10084 -> 184
    //   10271: aconst_null
    //   10272: astore_3
    //   10273: aconst_null
    //   10274: astore 4
    //   10276: aload 4
    //   10278: astore_1
    //   10279: aload_3
    //   10280: astore_2
    //   10281: new 110	org/json/JSONObject
    //   10284: dup
    //   10285: aload 5
    //   10287: iconst_0
    //   10288: aaload
    //   10289: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10292: astore 5
    //   10294: aload 4
    //   10296: astore_1
    //   10297: aload_3
    //   10298: astore_2
    //   10299: aload 5
    //   10301: ldc_w 1205
    //   10304: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10307: astore_3
    //   10308: aload 4
    //   10310: astore_1
    //   10311: aload_3
    //   10312: astore_2
    //   10313: aload 5
    //   10315: ldc 210
    //   10317: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10320: astore 4
    //   10322: aload 4
    //   10324: astore_1
    //   10325: aload_3
    //   10326: astore_2
    //   10327: aload 5
    //   10329: ldc_w 2851
    //   10332: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10335: astore 15
    //   10337: aload 4
    //   10339: astore_1
    //   10340: aload_3
    //   10341: astore_2
    //   10342: aload 5
    //   10344: ldc 185
    //   10346: invokevirtual 1045	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   10349: astore 5
    //   10351: aload 4
    //   10353: astore_1
    //   10354: aload_3
    //   10355: astore_2
    //   10356: ldc_w 364
    //   10359: aload 15
    //   10361: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10364: ifeq +5049 -> 15413
    //   10367: aload 5
    //   10369: ifnull +5044 -> 15413
    //   10372: aload 4
    //   10374: astore_1
    //   10375: aload_3
    //   10376: astore_2
    //   10377: aload 5
    //   10379: ldc_w 832
    //   10382: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10385: astore 15
    //   10387: aload 4
    //   10389: astore_1
    //   10390: aload_3
    //   10391: astore_2
    //   10392: aload 5
    //   10394: ldc_w 2655
    //   10397: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10400: astore 16
    //   10402: aload 4
    //   10404: astore_1
    //   10405: aload_3
    //   10406: astore_2
    //   10407: aload 5
    //   10409: ldc 157
    //   10411: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10414: astore 5
    //   10416: aload 4
    //   10418: astore_1
    //   10419: aload_3
    //   10420: astore_2
    //   10421: aload 15
    //   10423: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10426: ifne +67 -> 10493
    //   10429: aload 4
    //   10431: astore_1
    //   10432: aload_3
    //   10433: astore_2
    //   10434: aload 5
    //   10436: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10439: ifne +54 -> 10493
    //   10442: aload 4
    //   10444: astore_1
    //   10445: aload_3
    //   10446: astore_2
    //   10447: aload_0
    //   10448: aload 14
    //   10450: aload 15
    //   10452: aload 16
    //   10454: aload 4
    //   10456: aload 5
    //   10458: aload_3
    //   10459: invokespecial 2925	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   10462: aconst_null
    //   10463: astore_1
    //   10464: aload_3
    //   10465: astore_2
    //   10466: aload_1
    //   10467: ifnull -10283 -> 184
    //   10470: aload_2
    //   10471: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10474: ifne -10290 -> 184
    //   10477: aload_0
    //   10478: aload_2
    //   10479: iconst_1
    //   10480: anewarray 325	java/lang/String
    //   10483: dup
    //   10484: iconst_0
    //   10485: aload_1
    //   10486: aastore
    //   10487: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10490: goto -10306 -> 184
    //   10493: aload 4
    //   10495: astore_1
    //   10496: aload_3
    //   10497: astore_2
    //   10498: ldc_w 2387
    //   10501: aconst_null
    //   10502: ldc_w 2927
    //   10505: aload 4
    //   10507: invokestatic 356	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10510: astore 4
    //   10512: aload 4
    //   10514: astore_1
    //   10515: aload_3
    //   10516: astore_2
    //   10517: goto -51 -> 10466
    //   10520: astore_3
    //   10521: ldc_w 2929
    //   10524: aconst_null
    //   10525: aload_3
    //   10526: invokevirtual 532	java/lang/Exception:toString	()Ljava/lang/String;
    //   10529: aload_1
    //   10530: invokestatic 356	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10533: astore_1
    //   10534: goto -68 -> 10466
    //   10537: ldc_w 2931
    //   10540: aload 4
    //   10542: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10545: ifeq +295 -> 10840
    //   10548: aload 5
    //   10550: arraylength
    //   10551: ifle +289 -> 10840
    //   10554: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10557: ifeq +33 -> 10590
    //   10560: ldc_w 2933
    //   10563: iconst_2
    //   10564: new 524	java/lang/StringBuilder
    //   10567: dup
    //   10568: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   10571: ldc_w 2935
    //   10574: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10577: aload 5
    //   10579: iconst_0
    //   10580: aaload
    //   10581: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10584: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10587: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10590: new 110	org/json/JSONObject
    //   10593: dup
    //   10594: aload 5
    //   10596: iconst_0
    //   10597: aaload
    //   10598: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10601: ldc 157
    //   10603: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10606: astore_3
    //   10607: aload_3
    //   10608: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10611: ifne -10427 -> 184
    //   10614: aload_3
    //   10615: ldc_w 2937
    //   10618: invokevirtual 2941	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   10621: astore_1
    //   10622: new 1963	java/util/HashMap
    //   10625: dup
    //   10626: invokespecial 2942	java/util/HashMap:<init>	()V
    //   10629: astore_2
    //   10630: aload_1
    //   10631: arraylength
    //   10632: iconst_1
    //   10633: if_icmple -10449 -> 184
    //   10636: aload_1
    //   10637: iconst_1
    //   10638: aaload
    //   10639: ldc_w 2944
    //   10642: invokevirtual 2941	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   10645: astore_1
    //   10646: iconst_0
    //   10647: istore 6
    //   10649: aload_1
    //   10650: arraylength
    //   10651: istore 7
    //   10653: iload 6
    //   10655: iload 7
    //   10657: if_icmpge +49 -> 10706
    //   10660: aload_1
    //   10661: iload 6
    //   10663: aaload
    //   10664: bipush 61
    //   10666: invokevirtual 2947	java/lang/String:indexOf	(I)I
    //   10669: istore 8
    //   10671: iload 8
    //   10673: iconst_m1
    //   10674: if_icmpeq +4853 -> 15527
    //   10677: aload_2
    //   10678: aload_1
    //   10679: iload 6
    //   10681: aaload
    //   10682: iconst_0
    //   10683: iload 8
    //   10685: invokevirtual 2951	java/lang/String:substring	(II)Ljava/lang/String;
    //   10688: aload_1
    //   10689: iload 6
    //   10691: aaload
    //   10692: iload 8
    //   10694: iconst_1
    //   10695: iadd
    //   10696: invokevirtual 2953	java/lang/String:substring	(I)Ljava/lang/String;
    //   10699: invokevirtual 2956	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   10702: pop
    //   10703: goto +4824 -> 15527
    //   10706: aload_3
    //   10707: ldc_w 1487
    //   10710: invokevirtual 1490	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   10713: ifeq +102 -> 10815
    //   10716: aload_2
    //   10717: ldc_w 1166
    //   10720: invokevirtual 2957	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10723: checkcast 325	java/lang/String
    //   10726: astore_1
    //   10727: aload_2
    //   10728: ldc 161
    //   10730: invokevirtual 2957	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10733: checkcast 325	java/lang/String
    //   10736: astore_2
    //   10737: aload_0
    //   10738: aload_1
    //   10739: aload_2
    //   10740: aload_3
    //   10741: invokevirtual 2959	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   10744: ifne -10560 -> 184
    //   10747: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10750: ifeq +13 -> 10763
    //   10753: ldc_w 2933
    //   10756: iconst_2
    //   10757: ldc_w 2147
    //   10760: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10763: aload_0
    //   10764: aload 5
    //   10766: iconst_0
    //   10767: aaload
    //   10768: iconst_0
    //   10769: invokevirtual 2152	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Z)V
    //   10772: goto -10588 -> 184
    //   10775: astore_1
    //   10776: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10779: ifeq -10595 -> 184
    //   10782: ldc_w 2933
    //   10785: iconst_2
    //   10786: new 524	java/lang/StringBuilder
    //   10789: dup
    //   10790: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   10793: ldc_w 2961
    //   10796: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10799: aload 5
    //   10801: iconst_0
    //   10802: aaload
    //   10803: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10806: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10809: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10812: goto -10628 -> 184
    //   10815: aload_2
    //   10816: ldc_w 2754
    //   10819: invokevirtual 2957	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10822: checkcast 325	java/lang/String
    //   10825: astore_1
    //   10826: aload_2
    //   10827: ldc_w 2963
    //   10830: invokevirtual 2957	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10833: checkcast 325	java/lang/String
    //   10836: astore_2
    //   10837: goto -100 -> 10737
    //   10840: ldc_w 2965
    //   10843: aload 4
    //   10845: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10848: ifeq +66 -> 10914
    //   10851: aload 5
    //   10853: arraylength
    //   10854: ifle +60 -> 10914
    //   10857: aload_0
    //   10858: new 110	org/json/JSONObject
    //   10861: dup
    //   10862: aload 5
    //   10864: iconst_0
    //   10865: aaload
    //   10866: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10869: invokevirtual 2967	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;)V
    //   10872: goto -10688 -> 184
    //   10875: astore_1
    //   10876: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10879: ifeq -10695 -> 184
    //   10882: ldc 196
    //   10884: iconst_2
    //   10885: new 524	java/lang/StringBuilder
    //   10888: dup
    //   10889: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   10892: ldc_w 2969
    //   10895: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10898: aload 5
    //   10900: iconst_0
    //   10901: aaload
    //   10902: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10905: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10908: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10911: goto -10727 -> 184
    //   10914: ldc_w 2971
    //   10917: aload 4
    //   10919: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10922: ifeq +10 -> 10932
    //   10925: aload_0
    //   10926: invokevirtual 2972	com/tencent/mobileqq/jsp/UiApiPlugin:b	()V
    //   10929: goto -10745 -> 184
    //   10932: ldc_w 2974
    //   10935: aload 4
    //   10937: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10940: ifeq +72 -> 11012
    //   10943: aload 5
    //   10945: arraylength
    //   10946: ifle +66 -> 11012
    //   10949: aload_0
    //   10950: new 110	org/json/JSONObject
    //   10953: dup
    //   10954: aload 5
    //   10956: iconst_0
    //   10957: aaload
    //   10958: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10961: ldc_w 1205
    //   10964: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10967: invokevirtual 2975	com/tencent/mobileqq/jsp/UiApiPlugin:b	(Ljava/lang/String;)V
    //   10970: goto -10786 -> 184
    //   10973: astore_1
    //   10974: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10977: ifeq -10793 -> 184
    //   10980: ldc 196
    //   10982: iconst_2
    //   10983: new 524	java/lang/StringBuilder
    //   10986: dup
    //   10987: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   10990: ldc_w 2977
    //   10993: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10996: aload 5
    //   10998: iconst_0
    //   10999: aaload
    //   11000: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11003: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11006: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11009: goto -10825 -> 184
    //   11012: ldc_w 2979
    //   11015: aload 4
    //   11017: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11020: ifeq +112 -> 11132
    //   11023: new 110	org/json/JSONObject
    //   11026: dup
    //   11027: aload 5
    //   11029: iconst_0
    //   11030: aaload
    //   11031: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11034: astore_1
    //   11035: aload_0
    //   11036: invokevirtual 1967	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   11039: astore_2
    //   11040: aload_2
    //   11041: ifnull -10857 -> 184
    //   11044: aload_2
    //   11045: aload_1
    //   11046: invokeinterface 2980 2 0
    //   11051: goto -10867 -> 184
    //   11054: astore_1
    //   11055: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11058: ifeq -10874 -> 184
    //   11061: ldc 196
    //   11063: iconst_2
    //   11064: new 524	java/lang/StringBuilder
    //   11067: dup
    //   11068: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   11071: ldc_w 2982
    //   11074: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11077: aload_1
    //   11078: invokevirtual 2983	org/json/JSONException:toString	()Ljava/lang/String;
    //   11081: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11084: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11087: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11090: goto -10906 -> 184
    //   11093: astore_1
    //   11094: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11097: ifeq -10913 -> 184
    //   11100: ldc 196
    //   11102: iconst_2
    //   11103: new 524	java/lang/StringBuilder
    //   11106: dup
    //   11107: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   11110: ldc_w 2982
    //   11113: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11116: aload_1
    //   11117: invokevirtual 532	java/lang/Exception:toString	()Ljava/lang/String;
    //   11120: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11123: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11126: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11129: goto -10945 -> 184
    //   11132: ldc_w 2985
    //   11135: aload 4
    //   11137: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11140: ifeq +194 -> 11334
    //   11143: aload 5
    //   11145: arraylength
    //   11146: ifle +188 -> 11334
    //   11149: new 110	org/json/JSONObject
    //   11152: dup
    //   11153: aload 5
    //   11155: iconst_0
    //   11156: aaload
    //   11157: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11160: ldc_w 1205
    //   11163: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11166: astore_1
    //   11167: aload_1
    //   11168: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11171: ifeq +14 -> 11185
    //   11174: ldc 196
    //   11176: iconst_1
    //   11177: ldc_w 2987
    //   11180: invokestatic 535	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11183: iconst_1
    //   11184: ireturn
    //   11185: new 110	org/json/JSONObject
    //   11188: dup
    //   11189: invokespecial 159	org/json/JSONObject:<init>	()V
    //   11192: astore_2
    //   11193: new 110	org/json/JSONObject
    //   11196: dup
    //   11197: invokespecial 159	org/json/JSONObject:<init>	()V
    //   11200: astore_3
    //   11201: aload_0
    //   11202: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11205: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   11208: invokevirtual 340	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   11211: ldc_w 341
    //   11214: invokevirtual 347	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   11217: istore 7
    //   11219: iload 7
    //   11221: istore 6
    //   11223: invokestatic 1323	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   11226: iconst_1
    //   11227: if_icmpne +18 -> 11245
    //   11230: iload 7
    //   11232: aload_0
    //   11233: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11236: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   11239: invokestatic 1324	com/tencent/widget/immersive/ImmersiveUtils:a	(Landroid/content/Context;)I
    //   11242: iadd
    //   11243: istore 6
    //   11245: aload_3
    //   11246: ldc_w 1270
    //   11249: iload 6
    //   11251: invokevirtual 183	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11254: pop
    //   11255: aload_2
    //   11256: ldc_w 1252
    //   11259: iconst_0
    //   11260: invokevirtual 183	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11263: pop
    //   11264: aload_2
    //   11265: ldc 208
    //   11267: ldc_w 2989
    //   11270: invokevirtual 167	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   11273: pop
    //   11274: aload_2
    //   11275: ldc 185
    //   11277: aload_3
    //   11278: invokevirtual 167	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   11281: pop
    //   11282: aload_0
    //   11283: aload_1
    //   11284: iconst_1
    //   11285: anewarray 325	java/lang/String
    //   11288: dup
    //   11289: iconst_0
    //   11290: aload_2
    //   11291: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   11294: aastore
    //   11295: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11298: goto -11114 -> 184
    //   11301: astore_1
    //   11302: ldc 196
    //   11304: iconst_1
    //   11305: new 524	java/lang/StringBuilder
    //   11308: dup
    //   11309: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   11312: ldc_w 2991
    //   11315: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11318: aload_1
    //   11319: invokestatic 2203	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   11322: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11325: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11328: invokestatic 535	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11331: goto -11147 -> 184
    //   11334: ldc_w 2993
    //   11337: aload 4
    //   11339: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11342: ifeq +78 -> 11420
    //   11345: new 110	org/json/JSONObject
    //   11348: dup
    //   11349: aload 5
    //   11351: iconst_0
    //   11352: aaload
    //   11353: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11356: astore_1
    //   11357: aload_1
    //   11358: ldc_w 1166
    //   11361: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11364: astore_2
    //   11365: aload_0
    //   11366: aload_1
    //   11367: ldc_w 1205
    //   11370: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11373: putfield 2995	com/tencent/mobileqq/jsp/UiApiPlugin:m	Ljava/lang/String;
    //   11376: aload_0
    //   11377: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11380: ifnonnull +17 -> 11397
    //   11383: aload_0
    //   11384: invokestatic 1427	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11387: putfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11390: aload_0
    //   11391: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11394: invokevirtual 1428	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   11397: aload_0
    //   11398: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11401: aload_2
    //   11402: new 2997	aegg
    //   11405: dup
    //   11406: aload_0
    //   11407: aload_2
    //   11408: invokespecial 2998	aegg:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   11411: invokevirtual 3001	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/String;Lcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   11414: goto -11230 -> 184
    //   11417: astore_1
    //   11418: iconst_1
    //   11419: ireturn
    //   11420: ldc_w 3003
    //   11423: aload 4
    //   11425: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11428: ifeq +441 -> 11869
    //   11431: aload 5
    //   11433: arraylength
    //   11434: iconst_1
    //   11435: if_icmpne +434 -> 11869
    //   11438: new 110	org/json/JSONObject
    //   11441: dup
    //   11442: aload 5
    //   11444: iconst_0
    //   11445: aaload
    //   11446: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11449: astore_3
    //   11450: aload_3
    //   11451: ldc_w 3005
    //   11454: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11457: astore 4
    //   11459: aload_3
    //   11460: ldc_w 3007
    //   11463: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11466: astore_1
    //   11467: aload_1
    //   11468: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11471: ifeq +22 -> 11493
    //   11474: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11477: ifeq +4059 -> 15536
    //   11480: ldc_w 3009
    //   11483: iconst_2
    //   11484: ldc_w 3011
    //   11487: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11490: goto +4046 -> 15536
    //   11493: aload_0
    //   11494: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11497: invokevirtual 931	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   11500: astore_2
    //   11501: aload_2
    //   11502: ifnull +10 -> 11512
    //   11505: aload_2
    //   11506: invokevirtual 3014	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   11509: ifnonnull +22 -> 11531
    //   11512: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11515: ifeq +4023 -> 15538
    //   11518: ldc_w 3009
    //   11521: iconst_2
    //   11522: ldc_w 3016
    //   11525: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11528: goto +4010 -> 15538
    //   11531: aload_2
    //   11532: invokevirtual 3014	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   11535: getfield 3019	com/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo:jdField_a_of_type_Int	I
    //   11538: invokestatic 1536	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11541: astore_2
    //   11542: aload_3
    //   11543: ldc_w 2741
    //   11546: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   11549: istore 6
    //   11551: iload 6
    //   11553: iconst_1
    //   11554: if_icmpne +226 -> 11780
    //   11557: new 3021	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   11560: dup
    //   11561: invokespecial 3022	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   11564: astore_3
    //   11565: aload_3
    //   11566: getfield 3025	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11569: sipush 1814
    //   11572: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   11575: aload_3
    //   11576: getfield 3028	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11579: bipush 48
    //   11581: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   11584: aload_1
    //   11585: invokevirtual 3031	java/lang/String:getBytes	()[B
    //   11588: arraylength
    //   11589: bipush 6
    //   11591: iadd
    //   11592: invokestatic 3037	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   11595: astore 4
    //   11597: aload 4
    //   11599: aload_2
    //   11600: invokevirtual 1990	java/lang/Integer:intValue	()I
    //   11603: invokevirtual 3039	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   11606: pop
    //   11607: aload 4
    //   11609: aload_1
    //   11610: invokevirtual 3031	java/lang/String:getBytes	()[B
    //   11613: arraylength
    //   11614: i2s
    //   11615: invokevirtual 3043	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   11618: pop
    //   11619: aload 4
    //   11621: aload_1
    //   11622: invokevirtual 3031	java/lang/String:getBytes	()[B
    //   11625: invokevirtual 3046	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   11628: pop
    //   11629: aload_3
    //   11630: getfield 3050	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11633: aload 4
    //   11635: invokevirtual 3053	java/nio/ByteBuffer:array	()[B
    //   11638: invokestatic 3059	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11641: invokevirtual 3064	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   11644: new 281	mqq/app/NewIntent
    //   11647: dup
    //   11648: aload_0
    //   11649: invokevirtual 1575	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   11652: ldc_w 289
    //   11655: invokespecial 292	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   11658: astore_2
    //   11659: new 792	android/os/Bundle
    //   11662: dup
    //   11663: invokespecial 793	android/os/Bundle:<init>	()V
    //   11666: astore 4
    //   11668: aload 4
    //   11670: ldc_w 3007
    //   11673: aload_1
    //   11674: invokevirtual 805	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   11677: aload_2
    //   11678: aload 4
    //   11680: invokevirtual 3065	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   11683: pop
    //   11684: aload_2
    //   11685: ldc_w 297
    //   11688: ldc_w 3067
    //   11691: invokevirtual 300	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11694: pop
    //   11695: aload_2
    //   11696: ldc 185
    //   11698: aload_3
    //   11699: invokevirtual 3068	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   11702: invokevirtual 307	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   11705: pop
    //   11706: aload_2
    //   11707: ldc_w 3070
    //   11710: iconst_1
    //   11711: invokevirtual 3071	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11714: pop
    //   11715: aload_2
    //   11716: new 3073	aegh
    //   11719: dup
    //   11720: aload_0
    //   11721: invokespecial 3074	aegh:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   11724: invokevirtual 316	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   11727: aload_0
    //   11728: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11731: invokevirtual 891	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   11734: aload_2
    //   11735: invokevirtual 322	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   11738: goto -11554 -> 184
    //   11741: astore_1
    //   11742: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11745: ifeq -11561 -> 184
    //   11748: ldc 196
    //   11750: iconst_2
    //   11751: new 524	java/lang/StringBuilder
    //   11754: dup
    //   11755: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   11758: ldc_w 3076
    //   11761: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11764: aload 5
    //   11766: iconst_0
    //   11767: aaload
    //   11768: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11771: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11774: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11777: goto -11593 -> 184
    //   11780: iload 6
    //   11782: ifne -11598 -> 184
    //   11785: aload_0
    //   11786: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11789: ifnonnull +17 -> 11806
    //   11792: aload_0
    //   11793: invokestatic 1427	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11796: putfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11799: aload_0
    //   11800: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11803: invokevirtual 1428	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   11806: aload_0
    //   11807: getfield 79	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   11810: aload_2
    //   11811: aload_1
    //   11812: aload 4
    //   11814: new 3078	aegi
    //   11817: dup
    //   11818: aload_0
    //   11819: aload_2
    //   11820: aload_1
    //   11821: invokespecial 3081	aegi:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;)V
    //   11824: invokevirtual 3084	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   11827: goto -11643 -> 184
    //   11830: astore_1
    //   11831: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11834: ifeq -11650 -> 184
    //   11837: ldc 196
    //   11839: iconst_2
    //   11840: new 524	java/lang/StringBuilder
    //   11843: dup
    //   11844: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   11847: ldc_w 3086
    //   11850: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11853: aload 5
    //   11855: iconst_0
    //   11856: aaload
    //   11857: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11860: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11863: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11866: goto -11682 -> 184
    //   11869: ldc_w 3088
    //   11872: aload 4
    //   11874: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11877: ifeq +455 -> 12332
    //   11880: aload 5
    //   11882: arraylength
    //   11883: iconst_1
    //   11884: if_icmpne +448 -> 12332
    //   11887: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11890: ifeq +33 -> 11923
    //   11893: ldc_w 3009
    //   11896: iconst_2
    //   11897: new 524	java/lang/StringBuilder
    //   11900: dup
    //   11901: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   11904: ldc_w 3090
    //   11907: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11910: aload 5
    //   11912: iconst_0
    //   11913: aaload
    //   11914: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11917: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11920: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11923: new 110	org/json/JSONObject
    //   11926: dup
    //   11927: aload 5
    //   11929: iconst_0
    //   11930: aaload
    //   11931: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11934: astore_3
    //   11935: aload_3
    //   11936: ldc_w 3005
    //   11939: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11942: astore_1
    //   11943: aload_3
    //   11944: ldc_w 3007
    //   11947: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11950: astore_2
    //   11951: aload_3
    //   11952: ldc_w 3092
    //   11955: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11958: astore_3
    //   11959: aload_2
    //   11960: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11963: ifne +10 -> 11973
    //   11966: aload_3
    //   11967: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11970: ifeq +49 -> 12019
    //   11973: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11976: ifeq +3564 -> 15540
    //   11979: ldc_w 3009
    //   11982: iconst_2
    //   11983: new 524	java/lang/StringBuilder
    //   11986: dup
    //   11987: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   11990: ldc_w 3094
    //   11993: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11996: aload_3
    //   11997: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12000: ldc_w 3096
    //   12003: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12006: aload_2
    //   12007: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12010: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12013: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12016: goto +3524 -> 15540
    //   12019: aload_0
    //   12020: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   12023: invokevirtual 931	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   12026: astore 4
    //   12028: aload 4
    //   12030: ifnull +11 -> 12041
    //   12033: aload 4
    //   12035: invokevirtual 3014	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   12038: ifnonnull +22 -> 12060
    //   12041: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12044: ifeq +3498 -> 15542
    //   12047: ldc_w 3009
    //   12050: iconst_2
    //   12051: ldc_w 3098
    //   12054: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12057: goto +3485 -> 15542
    //   12060: aload 4
    //   12062: invokevirtual 3014	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   12065: getfield 3019	com/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo:jdField_a_of_type_Int	I
    //   12068: invokestatic 1536	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12071: astore 4
    //   12073: new 3021	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   12076: dup
    //   12077: invokespecial 3022	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   12080: astore 14
    //   12082: aload 14
    //   12084: getfield 3025	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12087: sipush 1814
    //   12090: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12093: aload 14
    //   12095: getfield 3028	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12098: bipush 48
    //   12100: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12103: aload_3
    //   12104: invokevirtual 3031	java/lang/String:getBytes	()[B
    //   12107: arraylength
    //   12108: bipush 6
    //   12110: iadd
    //   12111: invokestatic 3037	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   12114: astore 15
    //   12116: aload 15
    //   12118: aload 4
    //   12120: invokevirtual 1990	java/lang/Integer:intValue	()I
    //   12123: invokevirtual 3039	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   12126: pop
    //   12127: aload 15
    //   12129: aload_3
    //   12130: invokevirtual 3031	java/lang/String:getBytes	()[B
    //   12133: arraylength
    //   12134: i2s
    //   12135: invokevirtual 3043	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   12138: pop
    //   12139: aload 15
    //   12141: aload_3
    //   12142: invokevirtual 3031	java/lang/String:getBytes	()[B
    //   12145: invokevirtual 3046	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   12148: pop
    //   12149: aload 14
    //   12151: getfield 3050	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12154: aload 15
    //   12156: invokevirtual 3053	java/nio/ByteBuffer:array	()[B
    //   12159: invokestatic 3059	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12162: invokevirtual 3064	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   12165: new 281	mqq/app/NewIntent
    //   12168: dup
    //   12169: aload_0
    //   12170: invokevirtual 1575	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   12173: ldc_w 289
    //   12176: invokespecial 292	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12179: astore_3
    //   12180: aload_3
    //   12181: new 792	android/os/Bundle
    //   12184: dup
    //   12185: invokespecial 793	android/os/Bundle:<init>	()V
    //   12188: invokevirtual 3065	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   12191: pop
    //   12192: aload_3
    //   12193: ldc_w 297
    //   12196: ldc_w 3067
    //   12199: invokevirtual 300	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12202: pop
    //   12203: aload_3
    //   12204: ldc 185
    //   12206: aload 14
    //   12208: invokevirtual 3068	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   12211: invokevirtual 307	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   12214: pop
    //   12215: aload_3
    //   12216: ldc_w 3070
    //   12219: iconst_1
    //   12220: invokevirtual 3071	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12223: pop
    //   12224: aload_3
    //   12225: new 3100	aegj
    //   12228: dup
    //   12229: aload_0
    //   12230: aload 4
    //   12232: aload_2
    //   12233: aload_1
    //   12234: invokespecial 3103	aegj:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V
    //   12237: invokevirtual 316	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   12240: aload_0
    //   12241: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   12244: invokevirtual 891	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   12247: aload_3
    //   12248: invokevirtual 322	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   12251: goto -12067 -> 184
    //   12254: astore_1
    //   12255: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12258: ifeq -12074 -> 184
    //   12261: ldc 196
    //   12263: iconst_2
    //   12264: new 524	java/lang/StringBuilder
    //   12267: dup
    //   12268: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   12271: ldc_w 3076
    //   12274: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12277: aload 5
    //   12279: iconst_0
    //   12280: aaload
    //   12281: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12284: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12287: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12290: goto -12106 -> 184
    //   12293: astore_1
    //   12294: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12297: ifeq -12113 -> 184
    //   12300: ldc 196
    //   12302: iconst_2
    //   12303: new 524	java/lang/StringBuilder
    //   12306: dup
    //   12307: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   12310: ldc_w 3086
    //   12313: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12316: aload 5
    //   12318: iconst_0
    //   12319: aaload
    //   12320: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12323: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12326: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12329: goto -12145 -> 184
    //   12332: ldc_w 3105
    //   12335: aload 4
    //   12337: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12340: ifeq +200 -> 12540
    //   12343: aload_0
    //   12344: new 110	org/json/JSONObject
    //   12347: dup
    //   12348: aload 5
    //   12350: iconst_0
    //   12351: aaload
    //   12352: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12355: ldc_w 1205
    //   12358: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   12361: putfield 2362	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12364: aload_0
    //   12365: invokevirtual 1967	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   12368: astore_1
    //   12369: aload_1
    //   12370: ifnull -12186 -> 184
    //   12373: aload_1
    //   12374: invokeinterface 3107 1 0
    //   12379: istore 6
    //   12381: aload_0
    //   12382: aload_0
    //   12383: getfield 2362	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12386: iconst_1
    //   12387: anewarray 325	java/lang/String
    //   12390: dup
    //   12391: iconst_0
    //   12392: new 524	java/lang/StringBuilder
    //   12395: dup
    //   12396: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   12399: ldc_w 3109
    //   12402: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12405: iload 6
    //   12407: invokevirtual 924	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12410: ldc_w 1256
    //   12413: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12416: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12419: aastore
    //   12420: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12423: goto -12239 -> 184
    //   12426: astore_1
    //   12427: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12430: ifeq -12246 -> 184
    //   12433: aload_0
    //   12434: aload_0
    //   12435: getfield 2362	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12438: iconst_1
    //   12439: anewarray 325	java/lang/String
    //   12442: dup
    //   12443: iconst_0
    //   12444: ldc_w 3111
    //   12447: aastore
    //   12448: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12451: ldc 196
    //   12453: iconst_2
    //   12454: new 524	java/lang/StringBuilder
    //   12457: dup
    //   12458: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   12461: ldc_w 3113
    //   12464: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12467: aload_1
    //   12468: invokevirtual 2983	org/json/JSONException:toString	()Ljava/lang/String;
    //   12471: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12474: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12477: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12480: goto -12296 -> 184
    //   12483: astore_1
    //   12484: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12487: ifeq -12303 -> 184
    //   12490: aload_0
    //   12491: aload_0
    //   12492: getfield 2362	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12495: iconst_1
    //   12496: anewarray 325	java/lang/String
    //   12499: dup
    //   12500: iconst_0
    //   12501: ldc_w 3111
    //   12504: aastore
    //   12505: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12508: ldc 196
    //   12510: iconst_2
    //   12511: new 524	java/lang/StringBuilder
    //   12514: dup
    //   12515: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   12518: ldc_w 3113
    //   12521: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12524: aload_1
    //   12525: invokevirtual 532	java/lang/Exception:toString	()Ljava/lang/String;
    //   12528: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12531: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12534: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12537: goto -12353 -> 184
    //   12540: ldc_w 3115
    //   12543: aload 4
    //   12545: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12548: ifeq +135 -> 12683
    //   12551: aload 5
    //   12553: arraylength
    //   12554: iconst_1
    //   12555: if_icmpgt +128 -> 12683
    //   12558: ldc_w 362
    //   12561: astore_1
    //   12562: aload 5
    //   12564: arraylength
    //   12565: iconst_1
    //   12566: if_icmpne +2838 -> 15404
    //   12569: new 110	org/json/JSONObject
    //   12572: dup
    //   12573: aload 5
    //   12575: iconst_0
    //   12576: aaload
    //   12577: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12580: astore_3
    //   12581: aload_3
    //   12582: ldc_w 832
    //   12585: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   12588: astore_2
    //   12589: aload_2
    //   12590: astore_1
    //   12591: aload_3
    //   12592: ldc_w 1207
    //   12595: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   12598: ifeq +2806 -> 15404
    //   12601: aload_3
    //   12602: ldc_w 1207
    //   12605: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   12608: astore_1
    //   12609: aload_0
    //   12610: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   12613: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   12616: astore_3
    //   12617: aload_3
    //   12618: ifnull -12434 -> 184
    //   12621: aload_3
    //   12622: instanceof 1150
    //   12625: ifeq -12441 -> 184
    //   12628: aload_3
    //   12629: checkcast 1150	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   12632: invokevirtual 3117	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   12635: checkcast 3119	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   12638: iconst_0
    //   12639: aload_2
    //   12640: aload_1
    //   12641: invokevirtual 3122	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:a	(ZLjava/lang/String;Ljava/lang/String;)V
    //   12644: goto -12460 -> 184
    //   12647: astore_1
    //   12648: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   12651: ifeq -12467 -> 184
    //   12654: ldc 196
    //   12656: iconst_4
    //   12657: new 524	java/lang/StringBuilder
    //   12660: dup
    //   12661: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   12664: ldc_w 3124
    //   12667: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12670: aload_1
    //   12671: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12674: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12677: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12680: goto -12496 -> 184
    //   12683: ldc_w 3126
    //   12686: aload 4
    //   12688: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12691: ifeq +256 -> 12947
    //   12694: aload 5
    //   12696: arraylength
    //   12697: iconst_1
    //   12698: if_icmpgt +249 -> 12947
    //   12701: aload 5
    //   12703: arraylength
    //   12704: iconst_1
    //   12705: if_icmpne -12521 -> 184
    //   12708: new 110	org/json/JSONObject
    //   12711: dup
    //   12712: aload 5
    //   12714: iconst_0
    //   12715: aaload
    //   12716: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12719: astore_1
    //   12720: aload_1
    //   12721: ldc_w 2766
    //   12724: iconst_m1
    //   12725: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   12728: istore 6
    //   12730: aload_1
    //   12731: ldc_w 2849
    //   12734: iconst_m1
    //   12735: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   12738: istore 7
    //   12740: aload_0
    //   12741: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   12744: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   12747: astore_1
    //   12748: aload_1
    //   12749: ifnull -12565 -> 184
    //   12752: aload_1
    //   12753: instanceof 1150
    //   12756: ifeq -12572 -> 184
    //   12759: aload_1
    //   12760: checkcast 1150	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   12763: invokevirtual 3117	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   12766: checkcast 3119	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   12769: astore_1
    //   12770: aload_1
    //   12771: ifnull -12587 -> 184
    //   12774: iload 7
    //   12776: iconst_1
    //   12777: if_icmpne +134 -> 12911
    //   12780: aload_1
    //   12781: iconst_0
    //   12782: putfield 3127	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   12785: aload_1
    //   12786: iconst_1
    //   12787: invokevirtual 3128	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:c	(Z)V
    //   12790: iload 6
    //   12792: iconst_1
    //   12793: if_icmpne +136 -> 12929
    //   12796: aload_1
    //   12797: iconst_0
    //   12798: putfield 3127	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   12801: aload_1
    //   12802: iconst_1
    //   12803: invokevirtual 3129	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:d	(Z)V
    //   12806: goto -12622 -> 184
    //   12809: astore_1
    //   12810: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   12813: ifeq -12629 -> 184
    //   12816: ldc 196
    //   12818: iconst_4
    //   12819: new 524	java/lang/StringBuilder
    //   12822: dup
    //   12823: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   12826: ldc_w 3131
    //   12829: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12832: aload_1
    //   12833: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12836: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12839: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12842: goto -12658 -> 184
    //   12845: astore_2
    //   12846: ldc 196
    //   12848: iconst_1
    //   12849: new 524	java/lang/StringBuilder
    //   12852: dup
    //   12853: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   12856: ldc_w 3133
    //   12859: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12862: aload_2
    //   12863: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12866: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12869: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12872: iconst_m1
    //   12873: istore 6
    //   12875: goto -145 -> 12730
    //   12878: astore_1
    //   12879: iconst_m1
    //   12880: istore 7
    //   12882: ldc 196
    //   12884: iconst_1
    //   12885: new 524	java/lang/StringBuilder
    //   12888: dup
    //   12889: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   12892: ldc_w 3135
    //   12895: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12898: aload_1
    //   12899: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12902: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12905: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12908: goto -168 -> 12740
    //   12911: iload 7
    //   12913: ifne -123 -> 12790
    //   12916: aload_1
    //   12917: iconst_1
    //   12918: putfield 3127	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   12921: aload_1
    //   12922: iconst_0
    //   12923: invokevirtual 3128	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:c	(Z)V
    //   12926: goto -136 -> 12790
    //   12929: iload 6
    //   12931: ifne -12747 -> 184
    //   12934: aload_1
    //   12935: iconst_1
    //   12936: putfield 3127	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   12939: aload_1
    //   12940: iconst_0
    //   12941: invokevirtual 3129	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:d	(Z)V
    //   12944: goto -12760 -> 184
    //   12947: ldc_w 3137
    //   12950: aload 4
    //   12952: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12955: ifeq +168 -> 13123
    //   12958: aload 5
    //   12960: arraylength
    //   12961: iconst_1
    //   12962: if_icmpgt +161 -> 13123
    //   12965: aload 5
    //   12967: arraylength
    //   12968: iconst_1
    //   12969: if_icmpne -12785 -> 184
    //   12972: aload 5
    //   12974: arraylength
    //   12975: iconst_1
    //   12976: if_icmpne -12792 -> 184
    //   12979: new 110	org/json/JSONObject
    //   12982: dup
    //   12983: aload 5
    //   12985: iconst_0
    //   12986: aaload
    //   12987: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12990: ldc_w 3139
    //   12993: invokevirtual 118	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   12996: astore_1
    //   12997: aload_0
    //   12998: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13001: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13004: astore_2
    //   13005: aload_2
    //   13006: ifnull -12822 -> 184
    //   13009: aload_2
    //   13010: instanceof 1150
    //   13013: ifeq -12829 -> 184
    //   13016: aload_2
    //   13017: checkcast 1150	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13020: invokevirtual 3117	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13023: checkcast 3119	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13026: astore_3
    //   13027: ldc_w 564
    //   13030: aload_1
    //   13031: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13034: ifeq +61 -> 13095
    //   13037: aload_2
    //   13038: ldc_w 3141
    //   13041: invokevirtual 3144	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13044: checkcast 3146	android/view/inputmethod/InputMethodManager
    //   13047: aload_3
    //   13048: invokevirtual 3147	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   13051: iconst_0
    //   13052: invokevirtual 3151	android/view/inputmethod/InputMethodManager:showSoftInput	(Landroid/view/View;I)Z
    //   13055: pop
    //   13056: goto -12872 -> 184
    //   13059: astore_1
    //   13060: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13063: ifeq -12879 -> 184
    //   13066: ldc 196
    //   13068: iconst_4
    //   13069: new 524	java/lang/StringBuilder
    //   13072: dup
    //   13073: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   13076: ldc_w 3153
    //   13079: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13082: aload_1
    //   13083: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13086: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13089: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13092: goto -12908 -> 184
    //   13095: aload_2
    //   13096: ldc_w 3141
    //   13099: invokevirtual 3144	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13102: checkcast 3146	android/view/inputmethod/InputMethodManager
    //   13105: aload_2
    //   13106: invokevirtual 3157	android/app/Activity:getWindow	()Landroid/view/Window;
    //   13109: invokevirtual 3162	android/view/Window:getDecorView	()Landroid/view/View;
    //   13112: invokevirtual 3166	android/view/View:getWindowToken	()Landroid/os/IBinder;
    //   13115: iconst_0
    //   13116: invokevirtual 3170	android/view/inputmethod/InputMethodManager:hideSoftInputFromWindow	(Landroid/os/IBinder;I)Z
    //   13119: pop
    //   13120: goto -12936 -> 184
    //   13123: ldc_w 3172
    //   13126: aload 4
    //   13128: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13131: ifeq +96 -> 13227
    //   13134: aload 5
    //   13136: arraylength
    //   13137: iconst_1
    //   13138: if_icmpgt +89 -> 13227
    //   13141: aload 5
    //   13143: arraylength
    //   13144: iconst_1
    //   13145: if_icmpne -12961 -> 184
    //   13148: new 110	org/json/JSONObject
    //   13151: dup
    //   13152: aload 5
    //   13154: iconst_0
    //   13155: aaload
    //   13156: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13159: ldc_w 1205
    //   13162: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13165: astore_1
    //   13166: aload_1
    //   13167: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13170: ifne -12986 -> 184
    //   13173: aload_0
    //   13174: aload_1
    //   13175: iconst_1
    //   13176: anewarray 325	java/lang/String
    //   13179: dup
    //   13180: iconst_0
    //   13181: ldc_w 3174
    //   13184: aastore
    //   13185: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13188: goto -13004 -> 184
    //   13191: astore_1
    //   13192: invokestatic 2079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13195: ifeq -13011 -> 184
    //   13198: ldc 196
    //   13200: iconst_4
    //   13201: new 524	java/lang/StringBuilder
    //   13204: dup
    //   13205: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   13208: ldc_w 3176
    //   13211: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13214: aload_1
    //   13215: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13218: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13221: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13224: goto -13040 -> 184
    //   13227: ldc_w 3178
    //   13230: aload 4
    //   13232: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13235: ifeq +114 -> 13349
    //   13238: aload 5
    //   13240: arraylength
    //   13241: ifle +108 -> 13349
    //   13244: new 110	org/json/JSONObject
    //   13247: dup
    //   13248: aload 5
    //   13250: iconst_0
    //   13251: aaload
    //   13252: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13255: astore_3
    //   13256: aload_0
    //   13257: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13260: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13263: astore_1
    //   13264: aload_0
    //   13265: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13268: invokevirtual 891	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   13271: astore_2
    //   13272: aload_3
    //   13273: ldc_w 2101
    //   13276: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13279: astore_3
    //   13280: aload_3
    //   13281: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13284: ifne -13100 -> 184
    //   13287: aload_1
    //   13288: ifnull -13104 -> 184
    //   13291: aload_2
    //   13292: ifnull -13108 -> 184
    //   13295: aload_1
    //   13296: new 3180	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   13299: dup
    //   13300: aload_3
    //   13301: bipush 90
    //   13303: invokespecial 3182	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   13306: invokestatic 3187	com/tencent/mobileqq/activity/ProfileActivity:b	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)V
    //   13309: goto -13125 -> 184
    //   13312: astore_1
    //   13313: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13316: ifeq -13132 -> 184
    //   13319: ldc_w 2048
    //   13322: iconst_2
    //   13323: new 524	java/lang/StringBuilder
    //   13326: dup
    //   13327: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   13330: ldc_w 3189
    //   13333: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13336: aload_1
    //   13337: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13340: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13343: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13346: goto -13162 -> 184
    //   13349: ldc_w 3191
    //   13352: aload 4
    //   13354: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13357: ifeq +96 -> 13453
    //   13360: aload 5
    //   13362: arraylength
    //   13363: ifle +90 -> 13453
    //   13366: new 110	org/json/JSONObject
    //   13369: dup
    //   13370: aload 5
    //   13372: iconst_0
    //   13373: aaload
    //   13374: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13377: ldc_w 3193
    //   13380: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13383: istore 6
    //   13385: aload_0
    //   13386: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13389: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13392: astore_1
    //   13393: aload_1
    //   13394: ifnull -13210 -> 184
    //   13397: aload_1
    //   13398: instanceof 1150
    //   13401: ifeq -13217 -> 184
    //   13404: aload_1
    //   13405: checkcast 1150	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13408: iload 6
    //   13410: invokevirtual 3194	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:a	(I)V
    //   13413: goto -13229 -> 184
    //   13416: astore_1
    //   13417: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13420: ifeq -13236 -> 184
    //   13423: ldc_w 2048
    //   13426: iconst_2
    //   13427: new 524	java/lang/StringBuilder
    //   13430: dup
    //   13431: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   13434: ldc_w 3196
    //   13437: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13440: aload_1
    //   13441: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13444: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13447: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13450: goto -13266 -> 184
    //   13453: ldc_w 3198
    //   13456: aload 4
    //   13458: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13461: ifeq +267 -> 13728
    //   13464: aload 5
    //   13466: arraylength
    //   13467: ifle +261 -> 13728
    //   13470: new 110	org/json/JSONObject
    //   13473: dup
    //   13474: aload 5
    //   13476: iconst_0
    //   13477: aaload
    //   13478: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13481: astore_3
    //   13482: aload_3
    //   13483: ldc_w 3200
    //   13486: iconst_0
    //   13487: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13490: iconst_1
    //   13491: if_icmpne +176 -> 13667
    //   13494: iconst_1
    //   13495: istore 12
    //   13497: aload_3
    //   13498: ldc_w 3202
    //   13501: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13504: istore 6
    //   13506: aload_3
    //   13507: ldc_w 3204
    //   13510: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13513: istore 7
    //   13515: aload_3
    //   13516: ldc_w 3206
    //   13519: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13522: istore 8
    //   13524: aload_3
    //   13525: ldc_w 3208
    //   13528: iconst_1
    //   13529: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13532: iconst_1
    //   13533: if_icmpne +140 -> 13673
    //   13536: iconst_1
    //   13537: istore 13
    //   13539: aload_3
    //   13540: ldc_w 3210
    //   13543: aconst_null
    //   13544: invokevirtual 2116	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   13547: astore_1
    //   13548: aload_3
    //   13549: ldc_w 3212
    //   13552: aconst_null
    //   13553: invokevirtual 2116	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   13556: astore_2
    //   13557: aload_3
    //   13558: ldc_w 1205
    //   13561: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13564: astore_3
    //   13565: aload_0
    //   13566: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13569: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13572: astore 5
    //   13574: aload_0
    //   13575: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13578: invokevirtual 763	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13581: astore 4
    //   13583: aload_0
    //   13584: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13587: aload 5
    //   13589: invokevirtual 615	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   13592: astore 5
    //   13594: aload 4
    //   13596: ifnull +83 -> 13679
    //   13599: aload 4
    //   13601: getfield 2487	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   13604: ifnull +75 -> 13679
    //   13607: aload 4
    //   13609: getfield 2487	com/tencent/mobileqq/webview/swift/WebViewFragment:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   13612: iload 12
    //   13614: iload 6
    //   13616: iload 7
    //   13618: iload 8
    //   13620: iload 13
    //   13622: aload_1
    //   13623: aload_2
    //   13624: aload_3
    //   13625: invokevirtual 3215	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(ZIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   13628: goto -13444 -> 184
    //   13631: astore_1
    //   13632: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13635: ifeq -13451 -> 184
    //   13638: ldc 196
    //   13640: iconst_2
    //   13641: new 524	java/lang/StringBuilder
    //   13644: dup
    //   13645: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   13648: ldc_w 3217
    //   13651: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13654: aload_1
    //   13655: invokevirtual 1929	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13658: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13661: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13664: goto -13480 -> 184
    //   13667: iconst_0
    //   13668: istore 12
    //   13670: goto -173 -> 13497
    //   13673: iconst_0
    //   13674: istore 13
    //   13676: goto -137 -> 13539
    //   13679: aload 5
    //   13681: ifnull -13497 -> 184
    //   13684: aload 5
    //   13686: instanceof 1243
    //   13689: ifeq -13505 -> 184
    //   13692: aload 5
    //   13694: checkcast 1243	com/tencent/mobileqq/webviewplugin/WebUiUtils$VipComicUiInterface
    //   13697: iload 12
    //   13699: iload 6
    //   13701: iload 7
    //   13703: iload 8
    //   13705: iload 13
    //   13707: aload_1
    //   13708: aload_2
    //   13709: aload_3
    //   13710: aload_0
    //   13711: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13714: invokevirtual 931	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   13717: invokevirtual 1246	java/lang/Object:hashCode	()I
    //   13720: invokeinterface 3220 10 0
    //   13725: goto -13541 -> 184
    //   13728: ldc_w 3222
    //   13731: aload 4
    //   13733: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13736: ifeq +162 -> 13898
    //   13739: aload 5
    //   13741: arraylength
    //   13742: ifle +156 -> 13898
    //   13745: new 110	org/json/JSONObject
    //   13748: dup
    //   13749: aload 5
    //   13751: iconst_0
    //   13752: aaload
    //   13753: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13756: ldc_w 2851
    //   13759: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13762: istore 6
    //   13764: aload_0
    //   13765: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13768: invokevirtual 931	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   13771: astore_2
    //   13772: aload_2
    //   13773: ifnull -13589 -> 184
    //   13776: iload 6
    //   13778: ifne +24 -> 13802
    //   13781: aload_2
    //   13782: invokevirtual 3225	com/tencent/biz/pubaccount/CustomWebView:reload	()V
    //   13785: goto -13601 -> 184
    //   13788: astore_1
    //   13789: ldc 196
    //   13791: iconst_2
    //   13792: ldc_w 3227
    //   13795: aload_1
    //   13796: invokestatic 1039	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13799: goto -13615 -> 184
    //   13802: aload_0
    //   13803: iconst_4
    //   13804: invokevirtual 2240	com/tencent/mobileqq/jsp/UiApiPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   13807: checkcast 3229	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler
    //   13810: astore_1
    //   13811: aload_1
    //   13812: ifnull -13628 -> 184
    //   13815: aload_2
    //   13816: invokevirtual 3232	com/tencent/biz/pubaccount/CustomWebView:getOriginalUrl	()Ljava/lang/String;
    //   13819: astore_2
    //   13820: aload_1
    //   13821: getfield 3235	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:a	Lcom/tencent/biz/webviewplugin/Share;
    //   13824: ifnonnull +28 -> 13852
    //   13827: aload_1
    //   13828: new 1543	com/tencent/biz/webviewplugin/Share
    //   13831: dup
    //   13832: aload_0
    //   13833: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13836: invokevirtual 891	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   13839: aload_0
    //   13840: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13843: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13846: invokespecial 3238	com/tencent/biz/webviewplugin/Share:<init>	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;)V
    //   13849: putfield 3235	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:a	Lcom/tencent/biz/webviewplugin/Share;
    //   13852: iload 6
    //   13854: iconst_1
    //   13855: if_icmpne +20 -> 13875
    //   13858: aload_1
    //   13859: bipush 6
    //   13861: aload_2
    //   13862: new 792	android/os/Bundle
    //   13865: dup
    //   13866: invokespecial 793	android/os/Bundle:<init>	()V
    //   13869: invokevirtual 3241	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:a	(ILjava/lang/String;Landroid/os/Bundle;)V
    //   13872: goto -13688 -> 184
    //   13875: iload 6
    //   13877: iconst_2
    //   13878: if_icmpne -13694 -> 184
    //   13881: aload_1
    //   13882: bipush 11
    //   13884: aload_2
    //   13885: new 792	android/os/Bundle
    //   13888: dup
    //   13889: invokespecial 793	android/os/Bundle:<init>	()V
    //   13892: invokevirtual 3241	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:a	(ILjava/lang/String;Landroid/os/Bundle;)V
    //   13895: goto -13711 -> 184
    //   13898: ldc_w 3243
    //   13901: aload 4
    //   13903: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13906: ifeq +62 -> 13968
    //   13909: new 126	android/content/Intent
    //   13912: dup
    //   13913: aload_0
    //   13914: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13917: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13920: ldc_w 3245
    //   13923: invokespecial 730	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   13926: astore_1
    //   13927: aload_1
    //   13928: ldc_w 3247
    //   13931: aload 5
    //   13933: iconst_0
    //   13934: aaload
    //   13935: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   13938: pop
    //   13939: aload_0
    //   13940: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13943: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13946: aload_1
    //   13947: sipush 11533
    //   13950: invokevirtual 1029	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   13953: aload_0
    //   13954: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13957: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13960: iconst_0
    //   13961: iconst_0
    //   13962: invokevirtual 1034	android/app/Activity:overridePendingTransition	(II)V
    //   13965: goto -13781 -> 184
    //   13968: ldc_w 3249
    //   13971: aload 4
    //   13973: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13976: ifeq +177 -> 14153
    //   13979: new 110	org/json/JSONObject
    //   13982: dup
    //   13983: aload 5
    //   13985: iconst_0
    //   13986: aaload
    //   13987: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13990: astore_2
    //   13991: aload_2
    //   13992: ldc 157
    //   13994: ldc_w 362
    //   13997: invokevirtual 2116	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14000: astore_1
    //   14001: aload_0
    //   14002: aload_2
    //   14003: ldc_w 1205
    //   14006: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14009: putfield 2011	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   14012: aload_1
    //   14013: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14016: ifeq +65 -> 14081
    //   14019: new 110	org/json/JSONObject
    //   14022: dup
    //   14023: invokespecial 159	org/json/JSONObject:<init>	()V
    //   14026: astore_1
    //   14027: aload_1
    //   14028: ldc 204
    //   14030: iconst_m1
    //   14031: invokevirtual 183	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14034: pop
    //   14035: aload_1
    //   14036: ldc 185
    //   14038: ldc_w 362
    //   14041: invokevirtual 167	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   14044: pop
    //   14045: aload_0
    //   14046: aload_0
    //   14047: getfield 2011	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   14050: iconst_1
    //   14051: anewarray 325	java/lang/String
    //   14054: dup
    //   14055: iconst_0
    //   14056: aload_1
    //   14057: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14060: aastore
    //   14061: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14064: goto -13880 -> 184
    //   14067: astore_1
    //   14068: ldc 196
    //   14070: iconst_1
    //   14071: ldc_w 3251
    //   14074: aload_1
    //   14075: invokestatic 1039	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14078: goto -13894 -> 184
    //   14081: aload_2
    //   14082: ldc_w 3253
    //   14085: iconst_0
    //   14086: invokevirtual 849	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   14089: istore 6
    //   14091: new 126	android/content/Intent
    //   14094: dup
    //   14095: invokespecial 218	android/content/Intent:<init>	()V
    //   14098: astore_2
    //   14099: iload 6
    //   14101: ifne +38 -> 14139
    //   14104: aload_2
    //   14105: invokestatic 497	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   14108: ldc_w 1019
    //   14111: invokevirtual 3257	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   14114: pop
    //   14115: aload_2
    //   14116: ldc 157
    //   14118: aload_1
    //   14119: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14122: pop
    //   14123: aload_0
    //   14124: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14127: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14130: aload_2
    //   14131: bipush 14
    //   14133: invokevirtual 1029	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   14136: goto -13952 -> 184
    //   14139: aload_2
    //   14140: invokestatic 497	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   14143: ldc_w 3259
    //   14146: invokevirtual 3257	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   14149: pop
    //   14150: goto -35 -> 14115
    //   14153: ldc_w 3261
    //   14156: aload 4
    //   14158: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14161: ifeq +61 -> 14222
    //   14164: new 110	org/json/JSONObject
    //   14167: dup
    //   14168: aload 5
    //   14170: iconst_0
    //   14171: aaload
    //   14172: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14175: ldc 185
    //   14177: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14180: astore_1
    //   14181: aload_0
    //   14182: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14185: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14188: iconst_m1
    //   14189: new 126	android/content/Intent
    //   14192: dup
    //   14193: invokespecial 218	android/content/Intent:<init>	()V
    //   14196: ldc 185
    //   14198: aload_1
    //   14199: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14202: invokevirtual 229	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   14205: goto -14021 -> 184
    //   14208: astore_1
    //   14209: ldc 196
    //   14211: iconst_1
    //   14212: ldc_w 3263
    //   14215: aload_1
    //   14216: invokestatic 1039	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14219: goto -14035 -> 184
    //   14222: ldc_w 3265
    //   14225: aload 4
    //   14227: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14230: ifne -14046 -> 184
    //   14233: ldc_w 3267
    //   14236: aload 4
    //   14238: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14241: ifeq +99 -> 14340
    //   14244: new 110	org/json/JSONObject
    //   14247: dup
    //   14248: aload 5
    //   14250: iconst_0
    //   14251: aaload
    //   14252: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14255: astore_2
    //   14256: aload_2
    //   14257: ldc_w 1205
    //   14260: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14263: astore_1
    //   14264: aload_2
    //   14265: ldc_w 2849
    //   14268: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14271: iconst_0
    //   14272: iconst_0
    //   14273: invokestatic 3272	com/tencent/mobileqq/vip/CUKingCardHelper:a	(Ljava/lang/String;ZZ)Lcom/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo;
    //   14276: astore_2
    //   14277: new 110	org/json/JSONObject
    //   14280: dup
    //   14281: invokespecial 159	org/json/JSONObject:<init>	()V
    //   14284: astore_3
    //   14285: aload_3
    //   14286: ldc 204
    //   14288: aload_2
    //   14289: getfield 3275	com/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo:jdField_a_of_type_Int	I
    //   14292: invokevirtual 183	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14295: pop
    //   14296: aload_3
    //   14297: ldc 157
    //   14299: aload_2
    //   14300: getfield 3276	com/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14303: invokevirtual 167	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   14306: pop
    //   14307: aload_0
    //   14308: aload_1
    //   14309: iconst_1
    //   14310: anewarray 325	java/lang/String
    //   14313: dup
    //   14314: iconst_0
    //   14315: aload_3
    //   14316: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14319: aastore
    //   14320: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14323: goto -14139 -> 184
    //   14326: astore_1
    //   14327: ldc 196
    //   14329: iconst_1
    //   14330: ldc_w 3278
    //   14333: aload_1
    //   14334: invokestatic 1039	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14337: goto -14153 -> 184
    //   14340: ldc_w 3280
    //   14343: aload 4
    //   14345: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14348: ifeq +221 -> 14569
    //   14351: new 110	org/json/JSONObject
    //   14354: dup
    //   14355: aload 5
    //   14357: iconst_0
    //   14358: aaload
    //   14359: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14362: astore_2
    //   14363: aload_2
    //   14364: ldc_w 1205
    //   14367: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14370: astore_1
    //   14371: aload_2
    //   14372: ldc 161
    //   14374: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14377: istore 6
    //   14379: aload_2
    //   14380: ldc_w 2849
    //   14383: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14386: astore_2
    //   14387: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14390: ifeq +40 -> 14430
    //   14393: ldc 196
    //   14395: iconst_2
    //   14396: new 524	java/lang/StringBuilder
    //   14399: dup
    //   14400: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   14403: ldc_w 3282
    //   14406: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14409: iload 6
    //   14411: invokevirtual 924	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14414: ldc_w 3284
    //   14417: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14420: aload_2
    //   14421: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14424: invokevirtual 533	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14427: invokestatic 2083	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14430: aload_2
    //   14431: iconst_0
    //   14432: iconst_1
    //   14433: invokestatic 3272	com/tencent/mobileqq/vip/CUKingCardHelper:a	(Ljava/lang/String;ZZ)Lcom/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo;
    //   14436: astore_3
    //   14437: new 110	org/json/JSONObject
    //   14440: dup
    //   14441: invokespecial 159	org/json/JSONObject:<init>	()V
    //   14444: astore 4
    //   14446: aload_3
    //   14447: getfield 3275	com/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo:jdField_a_of_type_Int	I
    //   14450: iconst_1
    //   14451: if_icmpne +46 -> 14497
    //   14454: aload 4
    //   14456: ldc 204
    //   14458: iconst_2
    //   14459: invokevirtual 183	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14462: pop
    //   14463: aload_0
    //   14464: aload_1
    //   14465: iconst_1
    //   14466: anewarray 325	java/lang/String
    //   14469: dup
    //   14470: iconst_0
    //   14471: aload 4
    //   14473: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14476: aastore
    //   14477: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14480: goto -14296 -> 184
    //   14483: astore_1
    //   14484: ldc 196
    //   14486: iconst_1
    //   14487: ldc_w 3286
    //   14490: aload_1
    //   14491: invokestatic 1039	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14494: goto -14310 -> 184
    //   14497: aload_3
    //   14498: getfield 3275	com/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo:jdField_a_of_type_Int	I
    //   14501: iconst_4
    //   14502: if_icmpne +32 -> 14534
    //   14505: aload 4
    //   14507: ldc 204
    //   14509: iconst_0
    //   14510: invokevirtual 183	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14513: pop
    //   14514: aload_0
    //   14515: aload_1
    //   14516: iconst_1
    //   14517: anewarray 325	java/lang/String
    //   14520: dup
    //   14521: iconst_0
    //   14522: aload 4
    //   14524: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14527: aastore
    //   14528: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14531: goto -14347 -> 184
    //   14534: new 3288	com/tencent/mobileqq/vip/CUKingCardDialog
    //   14537: dup
    //   14538: aload_0
    //   14539: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14542: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14545: aload_0
    //   14546: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14549: invokevirtual 931	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   14552: aload_1
    //   14553: iload 6
    //   14555: aload_2
    //   14556: aload_3
    //   14557: getfield 3275	com/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo:jdField_a_of_type_Int	I
    //   14560: invokespecial 3291	com/tencent/mobileqq/vip/CUKingCardDialog:<init>	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Ljava/lang/String;ILjava/lang/String;I)V
    //   14563: invokevirtual 3292	com/tencent/mobileqq/vip/CUKingCardDialog:show	()V
    //   14566: goto -14382 -> 184
    //   14569: ldc_w 3294
    //   14572: aload 4
    //   14574: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14577: ifeq +93 -> 14670
    //   14580: new 110	org/json/JSONObject
    //   14583: dup
    //   14584: aload 5
    //   14586: iconst_0
    //   14587: aaload
    //   14588: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14591: astore_2
    //   14592: aload_2
    //   14593: ldc_w 1205
    //   14596: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14599: astore_1
    //   14600: aload_2
    //   14601: ldc_w 2849
    //   14604: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14607: astore_2
    //   14608: new 110	org/json/JSONObject
    //   14611: dup
    //   14612: invokespecial 159	org/json/JSONObject:<init>	()V
    //   14615: astore_3
    //   14616: aload_3
    //   14617: ldc 204
    //   14619: invokestatic 3295	com/tencent/mobileqq/vip/CUKingCardHelper:a	()I
    //   14622: invokevirtual 183	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14625: pop
    //   14626: aload_3
    //   14627: ldc 157
    //   14629: aload_2
    //   14630: invokestatic 3296	com/tencent/mobileqq/vip/CUKingCardHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   14633: invokevirtual 167	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   14636: pop
    //   14637: aload_0
    //   14638: aload_1
    //   14639: iconst_1
    //   14640: anewarray 325	java/lang/String
    //   14643: dup
    //   14644: iconst_0
    //   14645: aload_3
    //   14646: invokevirtual 188	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14649: aastore
    //   14650: invokevirtual 375	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14653: goto -14469 -> 184
    //   14656: astore_1
    //   14657: ldc 196
    //   14659: iconst_1
    //   14660: ldc_w 3278
    //   14663: aload_1
    //   14664: invokestatic 1039	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14667: goto -14483 -> 184
    //   14670: ldc_w 3298
    //   14673: aload 4
    //   14675: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14678: ifeq +128 -> 14806
    //   14681: new 110	org/json/JSONObject
    //   14684: dup
    //   14685: aload 5
    //   14687: iconst_0
    //   14688: aaload
    //   14689: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14692: astore_1
    //   14693: aload_1
    //   14694: ldc_w 2766
    //   14697: invokevirtual 2544	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   14700: istore 12
    //   14702: aload_1
    //   14703: ldc_w 3300
    //   14706: invokevirtual 1045	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   14709: astore_1
    //   14710: aload_1
    //   14711: ifnull -14527 -> 184
    //   14714: aload_1
    //   14715: ldc_w 1262
    //   14718: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   14721: istore 6
    //   14723: aload_1
    //   14724: ldc_w 1264
    //   14727: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   14730: istore 7
    //   14732: new 1266	android/graphics/Rect
    //   14735: dup
    //   14736: iload 6
    //   14738: iload 7
    //   14740: aload_1
    //   14741: ldc_w 1268
    //   14744: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   14747: iload 6
    //   14749: iadd
    //   14750: aload_1
    //   14751: ldc_w 1270
    //   14754: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   14757: iload 7
    //   14759: iadd
    //   14760: invokespecial 1272	android/graphics/Rect:<init>	(IIII)V
    //   14763: astore_1
    //   14764: aload_0
    //   14765: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14768: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14771: astore_2
    //   14772: aload_2
    //   14773: instanceof 1178
    //   14776: ifeq -14592 -> 184
    //   14779: aload_2
    //   14780: checkcast 1178	com/tencent/biz/pubaccount/ecshopassit/EcshopWebActivity
    //   14783: aload_1
    //   14784: iload 12
    //   14786: invokevirtual 3303	com/tencent/biz/pubaccount/ecshopassit/EcshopWebActivity:a	(Landroid/graphics/Rect;Z)V
    //   14789: goto -14605 -> 184
    //   14792: astore_1
    //   14793: ldc 196
    //   14795: iconst_1
    //   14796: ldc_w 3305
    //   14799: aload_1
    //   14800: invokestatic 1039	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14803: goto -14619 -> 184
    //   14806: ldc_w 3307
    //   14809: aload 4
    //   14811: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14814: ifeq +56 -> 14870
    //   14817: new 110	org/json/JSONObject
    //   14820: dup
    //   14821: aload 5
    //   14823: iconst_0
    //   14824: aaload
    //   14825: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14828: astore_1
    //   14829: aload_1
    //   14830: ifnonnull +21 -> 14851
    //   14833: iconst_1
    //   14834: ireturn
    //   14835: astore_1
    //   14836: ldc 196
    //   14838: iconst_1
    //   14839: ldc_w 3309
    //   14842: aload_1
    //   14843: invokestatic 1039	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14846: aconst_null
    //   14847: astore_1
    //   14848: goto -19 -> 14829
    //   14851: invokestatic 3315	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   14854: new 3317	aegl
    //   14857: dup
    //   14858: aload_0
    //   14859: aload_1
    //   14860: invokespecial 3318	aegl:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Lorg/json/JSONObject;)V
    //   14863: invokevirtual 3324	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   14866: pop
    //   14867: goto -14683 -> 184
    //   14870: ldc_w 3326
    //   14873: aload 4
    //   14875: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14878: ifeq +117 -> 14995
    //   14881: new 110	org/json/JSONObject
    //   14884: dup
    //   14885: aload 5
    //   14887: iconst_0
    //   14888: aaload
    //   14889: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14892: astore_1
    //   14893: aload_0
    //   14894: aload_1
    //   14895: ldc_w 1205
    //   14898: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14901: putfield 3328	com/tencent/mobileqq/jsp/UiApiPlugin:j	Ljava/lang/String;
    //   14904: aload_1
    //   14905: ldc_w 3007
    //   14908: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14911: astore_2
    //   14912: aload_1
    //   14913: ldc_w 3330
    //   14916: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14919: astore_3
    //   14920: aload_1
    //   14921: ldc_w 3332
    //   14924: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14927: astore 4
    //   14929: aload_1
    //   14930: ldc_w 3334
    //   14933: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14936: astore 5
    //   14938: aload_1
    //   14939: ldc_w 3336
    //   14942: invokevirtual 974	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14945: istore 6
    //   14947: aload_0
    //   14948: aload_0
    //   14949: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14952: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14955: iconst_3
    //   14956: aload_2
    //   14957: aload_3
    //   14958: sipush 3016
    //   14961: iload 6
    //   14963: aload 4
    //   14965: aload 5
    //   14967: aconst_null
    //   14968: aconst_null
    //   14969: aconst_null
    //   14970: invokestatic 3341	com/tencent/mobileqq/activity/AddFriendLogicActivity:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14973: bipush 16
    //   14975: invokevirtual 1414	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   14978: goto -14794 -> 184
    //   14981: astore_1
    //   14982: ldc 196
    //   14984: iconst_1
    //   14985: ldc_w 3343
    //   14988: aload_1
    //   14989: invokestatic 1039	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14992: goto -14808 -> 184
    //   14995: ldc_w 3345
    //   14998: aload 4
    //   15000: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15003: ifeq +172 -> 15175
    //   15006: new 110	org/json/JSONObject
    //   15009: dup
    //   15010: aload 5
    //   15012: iconst_0
    //   15013: aaload
    //   15014: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15017: astore_3
    //   15018: aload_3
    //   15019: ldc_w 3347
    //   15022: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15025: astore_1
    //   15026: aload_3
    //   15027: ldc_w 1842
    //   15030: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15033: astore_2
    //   15034: aload_3
    //   15035: ldc_w 1855
    //   15038: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15041: astore_3
    //   15042: aload_1
    //   15043: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15046: ifne +66 -> 15112
    //   15049: new 787	java/io/File
    //   15052: dup
    //   15053: aload_1
    //   15054: invokespecial 1392	java/io/File:<init>	(Ljava/lang/String;)V
    //   15057: astore_1
    //   15058: aload_1
    //   15059: invokevirtual 1792	java/io/File:exists	()Z
    //   15062: ifne +42 -> 15104
    //   15065: aload_0
    //   15066: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15069: invokevirtual 891	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   15072: invokevirtual 1755	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   15075: iconst_1
    //   15076: ldc_w 3349
    //   15079: iconst_0
    //   15080: invokestatic 1760	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   15083: invokevirtual 1763	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   15086: pop
    //   15087: goto -14903 -> 184
    //   15090: astore_1
    //   15091: ldc 196
    //   15093: iconst_1
    //   15094: ldc_w 3351
    //   15097: aload_1
    //   15098: invokestatic 1039	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15101: goto -14917 -> 184
    //   15104: aload_0
    //   15105: aload_1
    //   15106: invokevirtual 1394	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/io/File;)V
    //   15109: goto -14925 -> 184
    //   15112: aload_2
    //   15113: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15116: ifne +19 -> 15135
    //   15119: aload_0
    //   15120: aload_2
    //   15121: iconst_0
    //   15122: invokestatic 1851	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   15125: aload_2
    //   15126: invokestatic 1845	com/tencent/open/base/MD5Utils:d	(Ljava/lang/String;)Ljava/lang/String;
    //   15129: invokevirtual 3353	com/tencent/mobileqq/jsp/UiApiPlugin:a	([BLjava/lang/String;)V
    //   15132: goto -14948 -> 184
    //   15135: aload_3
    //   15136: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15139: ifne +11 -> 15150
    //   15142: aload_0
    //   15143: aload_3
    //   15144: invokevirtual 3355	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Ljava/lang/String;)V
    //   15147: goto -14963 -> 184
    //   15150: aload_0
    //   15151: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15154: invokevirtual 891	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   15157: invokevirtual 1755	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   15160: iconst_1
    //   15161: ldc_w 1757
    //   15164: iconst_0
    //   15165: invokestatic 1760	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   15168: invokevirtual 1763	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   15171: pop
    //   15172: goto -14988 -> 184
    //   15175: ldc_w 3357
    //   15178: aload 4
    //   15180: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15183: ifeq +44 -> 15227
    //   15186: aload_0
    //   15187: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15190: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   15193: iconst_m1
    //   15194: new 126	android/content/Intent
    //   15197: dup
    //   15198: invokespecial 218	android/content/Intent:<init>	()V
    //   15201: ldc_w 3359
    //   15204: aload 5
    //   15206: iconst_0
    //   15207: aaload
    //   15208: invokevirtual 155	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   15211: invokevirtual 229	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   15214: aload_0
    //   15215: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15218: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   15221: invokevirtual 232	android/app/Activity:finish	()V
    //   15224: goto -15040 -> 184
    //   15227: ldc_w 3361
    //   15230: aload 4
    //   15232: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15235: ifeq +13 -> 15248
    //   15238: aload_0
    //   15239: aload 5
    //   15241: iconst_0
    //   15242: aaload
    //   15243: invokevirtual 3363	com/tencent/mobileqq/jsp/UiApiPlugin:d	(Ljava/lang/String;)V
    //   15246: iconst_1
    //   15247: ireturn
    //   15248: ldc_w 3365
    //   15251: aload 4
    //   15253: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15256: ifeq +27 -> 15283
    //   15259: aload_0
    //   15260: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15263: invokevirtual 763	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   15266: astore_1
    //   15267: aload_1
    //   15268: instanceof 3367
    //   15271: ifeq +10 -> 15281
    //   15274: aload_1
    //   15275: checkcast 3367	com/tencent/mobileqq/now/enter/NowFestivalWebViewFragment
    //   15278: invokevirtual 3368	com/tencent/mobileqq/now/enter/NowFestivalWebViewFragment:f	()V
    //   15281: iconst_1
    //   15282: ireturn
    //   15283: ldc_w 3370
    //   15286: aload 4
    //   15288: invokevirtual 568	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15291: ifeq -15107 -> 184
    //   15294: aload 5
    //   15296: arraylength
    //   15297: iconst_1
    //   15298: if_icmpne -15114 -> 184
    //   15301: new 110	org/json/JSONObject
    //   15304: dup
    //   15305: aload 5
    //   15307: iconst_0
    //   15308: aaload
    //   15309: invokespecial 827	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15312: astore_1
    //   15313: aload_1
    //   15314: ldc_w 1205
    //   15317: invokevirtual 835	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15320: astore_2
    //   15321: new 3372	com/tencent/mobileqq/troop/widget/TroopPickerViewHelper
    //   15324: dup
    //   15325: aload_1
    //   15326: ldc_w 3374
    //   15329: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15332: aload_1
    //   15333: ldc_w 3376
    //   15336: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15339: aload_1
    //   15340: ldc_w 3378
    //   15343: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15346: aload_1
    //   15347: ldc_w 3380
    //   15350: invokevirtual 114	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15353: aload_1
    //   15354: ldc_w 3382
    //   15357: invokevirtual 2056	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   15360: invokespecial 3385	com/tencent/mobileqq/troop/widget/TroopPickerViewHelper:<init>	(IIIIJ)V
    //   15363: aload_0
    //   15364: getfield 601	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15367: invokevirtual 606	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   15370: new 3387	aego
    //   15373: dup
    //   15374: aload_0
    //   15375: aload_2
    //   15376: invokespecial 3388	aego:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   15379: invokevirtual 3391	com/tencent/mobileqq/troop/widget/TroopPickerViewHelper:a	(Landroid/app/Activity;Lcom/tencent/mobileqq/troop/widget/TroopPickerViewHelper$OnConfirmListener;)V
    //   15382: goto -15198 -> 184
    //   15385: astore_1
    //   15386: aload_1
    //   15387: invokevirtual 2244	org/json/JSONException:printStackTrace	()V
    //   15390: goto -15206 -> 184
    //   15393: iconst_0
    //   15394: ireturn
    //   15395: astore_2
    //   15396: goto -5226 -> 10170
    //   15399: astore 15
    //   15401: goto -11608 -> 3793
    //   15404: aload_1
    //   15405: astore_2
    //   15406: ldc_w 362
    //   15409: astore_1
    //   15410: goto -2801 -> 12609
    //   15413: aconst_null
    //   15414: astore_1
    //   15415: aload_3
    //   15416: astore_2
    //   15417: goto -4951 -> 10466
    //   15420: goto -6146 -> 9274
    //   15423: aconst_null
    //   15424: astore_1
    //   15425: goto -8476 -> 6949
    //   15428: aconst_null
    //   15429: astore_1
    //   15430: goto -8718 -> 6712
    //   15433: iconst_0
    //   15434: istore 6
    //   15436: goto -8769 -> 6667
    //   15439: aconst_null
    //   15440: astore_1
    //   15441: goto -8942 -> 6499
    //   15444: goto -15260 -> 184
    //   15447: iload 7
    //   15449: istore 6
    //   15451: goto -14875 -> 576
    //   15454: iconst_1
    //   15455: ireturn
    //   15456: iconst_1
    //   15457: ireturn
    //   15458: iconst_1
    //   15459: ireturn
    //   15460: iconst_1
    //   15461: ireturn
    //   15462: iconst_1
    //   15463: ireturn
    //   15464: astore_1
    //   15465: goto -15281 -> 184
    //   15468: iconst_1
    //   15469: ireturn
    //   15470: iload 6
    //   15472: tableswitch	default:+20 -> 15492, 1001:+-11223->4249
    //   15493: <illegal opcode>
    //   15494: dup_x2
    //   15495: iconst_0
    //   15496: istore 12
    //   15498: goto -10756 -> 4742
    //   15501: iconst_0
    //   15502: istore 12
    //   15504: goto -10364 -> 5140
    //   15507: iload 6
    //   15509: ldc_w 1302
    //   15512: ior
    //   15513: istore 6
    //   15515: goto -9489 -> 6026
    //   15518: iload 6
    //   15520: iconst_1
    //   15521: iadd
    //   15522: istore 6
    //   15524: goto -9117 -> 6407
    //   15527: iload 6
    //   15529: iconst_1
    //   15530: iadd
    //   15531: istore 6
    //   15533: goto -4880 -> 10653
    //   15536: iconst_1
    //   15537: ireturn
    //   15538: iconst_1
    //   15539: ireturn
    //   15540: iconst_1
    //   15541: ireturn
    //   15542: iconst_1
    //   15543: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	15544	0	this	UiApiPlugin
    //   0	15544	1	paramJsBridgeListener	JsBridgeListener
    //   0	15544	2	paramString1	String
    //   0	15544	3	paramString2	String
    //   0	15544	4	paramString3	String
    //   0	15544	5	paramVarArgs	String[]
    //   268	15264	6	n	int
    //   526	14922	7	i1	int
    //   516	13188	8	i2	int
    //   4841	211	9	i3	int
    //   259	7265	10	l1	long
    //   1574	13929	12	bool1	boolean
    //   3071	10635	13	bool2	boolean
    //   877	11330	14	localObject1	Object
    //   3049	9106	15	localObject2	Object
    //   15399	1	15	localJSONException	JSONException
    //   10400	53	16	str	String
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
    //   4408	4435	5573	org/json/JSONException
    //   4437	4446	5573	org/json/JSONException
    //   4453	4501	5573	org/json/JSONException
    //   4505	4527	5573	org/json/JSONException
    //   4527	4563	5573	org/json/JSONException
    //   4563	4582	5573	org/json/JSONException
    //   4587	4629	5573	org/json/JSONException
    //   4633	4641	5573	org/json/JSONException
    //   4641	4683	5573	org/json/JSONException
    //   4698	4718	5573	org/json/JSONException
    //   4718	4739	5573	org/json/JSONException
    //   4742	4749	5573	org/json/JSONException
    //   4749	4888	5573	org/json/JSONException
    //   4888	4943	5573	org/json/JSONException
    //   4943	4979	5573	org/json/JSONException
    //   4986	5003	5573	org/json/JSONException
    //   5009	5058	5573	org/json/JSONException
    //   5062	5066	5573	org/json/JSONException
    //   5066	5091	5573	org/json/JSONException
    //   5091	5097	5573	org/json/JSONException
    //   5097	5116	5573	org/json/JSONException
    //   5125	5131	5573	org/json/JSONException
    //   5140	5174	5573	org/json/JSONException
    //   5174	5198	5573	org/json/JSONException
    //   5198	5216	5573	org/json/JSONException
    //   5216	5235	5573	org/json/JSONException
    //   5241	5246	5573	org/json/JSONException
    //   5246	5268	5573	org/json/JSONException
    //   5268	5302	5573	org/json/JSONException
    //   5302	5330	5573	org/json/JSONException
    //   5330	5349	5573	org/json/JSONException
    //   5354	5378	5573	org/json/JSONException
    //   5378	5386	5573	org/json/JSONException
    //   5386	5405	5573	org/json/JSONException
    //   5414	5433	5573	org/json/JSONException
    //   5433	5437	5573	org/json/JSONException
    //   5437	5456	5573	org/json/JSONException
    //   5466	5470	5573	org/json/JSONException
    //   5470	5495	5573	org/json/JSONException
    //   5495	5515	5573	org/json/JSONException
    //   5519	5525	5573	org/json/JSONException
    //   5525	5545	5573	org/json/JSONException
    //   5549	5570	5573	org/json/JSONException
    //   5609	5621	5573	org/json/JSONException
    //   5660	5673	5573	org/json/JSONException
    //   5676	5686	5573	org/json/JSONException
    //   5691	5697	5573	org/json/JSONException
    //   5700	5718	5573	org/json/JSONException
    //   5718	5727	5573	org/json/JSONException
    //   5730	5750	5573	org/json/JSONException
    //   5753	5759	5573	org/json/JSONException
    //   5764	5786	5573	org/json/JSONException
    //   5793	5857	5573	org/json/JSONException
    //   5857	5864	5573	org/json/JSONException
    //   5868	5878	5573	org/json/JSONException
    //   5878	5911	5573	org/json/JSONException
    //   5911	5948	5573	org/json/JSONException
    //   5951	5960	5573	org/json/JSONException
    //   5963	5979	5573	org/json/JSONException
    //   5982	6012	5573	org/json/JSONException
    //   6026	6039	5573	org/json/JSONException
    //   6042	6056	5573	org/json/JSONException
    //   6065	6084	5573	org/json/JSONException
    //   4408	4435	5624	java/lang/Exception
    //   4437	4446	5624	java/lang/Exception
    //   4453	4501	5624	java/lang/Exception
    //   4505	4527	5624	java/lang/Exception
    //   4527	4563	5624	java/lang/Exception
    //   4563	4582	5624	java/lang/Exception
    //   4587	4629	5624	java/lang/Exception
    //   4633	4641	5624	java/lang/Exception
    //   4641	4683	5624	java/lang/Exception
    //   4698	4718	5624	java/lang/Exception
    //   4718	4739	5624	java/lang/Exception
    //   4742	4749	5624	java/lang/Exception
    //   4749	4888	5624	java/lang/Exception
    //   4888	4943	5624	java/lang/Exception
    //   4943	4979	5624	java/lang/Exception
    //   4986	5003	5624	java/lang/Exception
    //   5009	5058	5624	java/lang/Exception
    //   5062	5066	5624	java/lang/Exception
    //   5066	5091	5624	java/lang/Exception
    //   5091	5097	5624	java/lang/Exception
    //   5097	5116	5624	java/lang/Exception
    //   5125	5131	5624	java/lang/Exception
    //   5140	5174	5624	java/lang/Exception
    //   5174	5198	5624	java/lang/Exception
    //   5198	5216	5624	java/lang/Exception
    //   5216	5235	5624	java/lang/Exception
    //   5241	5246	5624	java/lang/Exception
    //   5246	5268	5624	java/lang/Exception
    //   5268	5302	5624	java/lang/Exception
    //   5302	5330	5624	java/lang/Exception
    //   5330	5349	5624	java/lang/Exception
    //   5354	5378	5624	java/lang/Exception
    //   5378	5386	5624	java/lang/Exception
    //   5386	5405	5624	java/lang/Exception
    //   5414	5433	5624	java/lang/Exception
    //   5433	5437	5624	java/lang/Exception
    //   5437	5456	5624	java/lang/Exception
    //   5466	5470	5624	java/lang/Exception
    //   5470	5495	5624	java/lang/Exception
    //   5495	5515	5624	java/lang/Exception
    //   5519	5525	5624	java/lang/Exception
    //   5525	5545	5624	java/lang/Exception
    //   5549	5570	5624	java/lang/Exception
    //   5609	5621	5624	java/lang/Exception
    //   5660	5673	5624	java/lang/Exception
    //   5676	5686	5624	java/lang/Exception
    //   5691	5697	5624	java/lang/Exception
    //   5700	5718	5624	java/lang/Exception
    //   5718	5727	5624	java/lang/Exception
    //   5730	5750	5624	java/lang/Exception
    //   5753	5759	5624	java/lang/Exception
    //   5764	5786	5624	java/lang/Exception
    //   5793	5857	5624	java/lang/Exception
    //   5857	5864	5624	java/lang/Exception
    //   5868	5878	5624	java/lang/Exception
    //   5878	5911	5624	java/lang/Exception
    //   5911	5948	5624	java/lang/Exception
    //   5951	5960	5624	java/lang/Exception
    //   5963	5979	5624	java/lang/Exception
    //   5982	6012	5624	java/lang/Exception
    //   6026	6039	5624	java/lang/Exception
    //   6042	6056	5624	java/lang/Exception
    //   6065	6084	5624	java/lang/Exception
    //   6105	6130	6543	org/json/JSONException
    //   6132	6165	6543	org/json/JSONException
    //   6165	6186	6543	org/json/JSONException
    //   6186	6221	6543	org/json/JSONException
    //   6231	6272	6543	org/json/JSONException
    //   6272	6296	6543	org/json/JSONException
    //   6296	6320	6543	org/json/JSONException
    //   6320	6348	6543	org/json/JSONException
    //   6348	6360	6543	org/json/JSONException
    //   6369	6404	6543	org/json/JSONException
    //   6414	6451	6543	org/json/JSONException
    //   6454	6462	6543	org/json/JSONException
    //   6466	6471	6543	org/json/JSONException
    //   6475	6483	6543	org/json/JSONException
    //   6487	6499	6543	org/json/JSONException
    //   6503	6520	6543	org/json/JSONException
    //   6524	6540	6543	org/json/JSONException
    //   6597	6622	6727	org/json/JSONException
    //   6624	6667	6727	org/json/JSONException
    //   6667	6675	6727	org/json/JSONException
    //   6679	6684	6727	org/json/JSONException
    //   6688	6696	6727	org/json/JSONException
    //   6700	6712	6727	org/json/JSONException
    //   6716	6724	6727	org/json/JSONException
    //   6781	6806	6961	org/json/JSONException
    //   6808	6837	6961	org/json/JSONException
    //   6837	6858	6961	org/json/JSONException
    //   6858	6879	6961	org/json/JSONException
    //   6879	6904	6961	org/json/JSONException
    //   6904	6912	6961	org/json/JSONException
    //   6916	6921	6961	org/json/JSONException
    //   6925	6933	6961	org/json/JSONException
    //   6937	6949	6961	org/json/JSONException
    //   6953	6958	6961	org/json/JSONException
    //   7015	7041	7079	org/json/JSONException
    //   7041	7056	7079	org/json/JSONException
    //   7060	7076	7079	org/json/JSONException
    //   7133	7226	7282	org/json/JSONException
    //   7226	7279	7282	org/json/JSONException
    //   7336	7399	7548	org/json/JSONException
    //   7403	7410	7548	org/json/JSONException
    //   7410	7425	7548	org/json/JSONException
    //   7427	7468	7548	org/json/JSONException
    //   7470	7478	7548	org/json/JSONException
    //   7482	7545	7548	org/json/JSONException
    //   7602	7668	7802	org/json/JSONException
    //   7672	7679	7802	org/json/JSONException
    //   7679	7694	7802	org/json/JSONException
    //   7696	7704	7802	org/json/JSONException
    //   7713	7782	7802	org/json/JSONException
    //   7782	7799	7802	org/json/JSONException
    //   7838	7858	7802	org/json/JSONException
    //   7879	7931	7953	org/json/JSONException
    //   7933	7950	7953	org/json/JSONException
    //   8020	8026	8311	org/json/JSONException
    //   8031	8060	8311	org/json/JSONException
    //   8065	8078	8311	org/json/JSONException
    //   8083	8093	8311	org/json/JSONException
    //   8098	8108	8311	org/json/JSONException
    //   8113	8122	8311	org/json/JSONException
    //   8130	8138	8311	org/json/JSONException
    //   8142	8151	8311	org/json/JSONException
    //   8160	8168	8311	org/json/JSONException
    //   8172	8183	8311	org/json/JSONException
    //   8187	8203	8311	org/json/JSONException
    //   8259	8270	8311	org/json/JSONException
    //   8274	8283	8311	org/json/JSONException
    //   8287	8297	8311	org/json/JSONException
    //   8301	8308	8311	org/json/JSONException
    //   8376	8385	8311	org/json/JSONException
    //   8020	8026	8392	finally
    //   8031	8060	8392	finally
    //   8065	8078	8392	finally
    //   8083	8093	8392	finally
    //   8098	8108	8392	finally
    //   8113	8122	8392	finally
    //   8130	8138	8392	finally
    //   8142	8151	8392	finally
    //   8160	8168	8392	finally
    //   8172	8183	8392	finally
    //   8187	8203	8392	finally
    //   8259	8270	8392	finally
    //   8274	8283	8392	finally
    //   8287	8297	8392	finally
    //   8301	8308	8392	finally
    //   8314	8324	8392	finally
    //   8376	8385	8392	finally
    //   8458	8489	8539	org/json/JSONException
    //   8492	8507	8539	org/json/JSONException
    //   8510	8519	8539	org/json/JSONException
    //   8524	8530	8539	org/json/JSONException
    //   8530	8536	8539	org/json/JSONException
    //   8575	8579	8539	org/json/JSONException
    //   8582	8620	8539	org/json/JSONException
    //   8625	8649	8539	org/json/JSONException
    //   8649	8663	8539	org/json/JSONException
    //   8666	8690	8539	org/json/JSONException
    //   8711	8818	8821	org/json/JSONException
    //   8711	8818	8857	java/lang/Exception
    //   8932	8944	9117	java/lang/Exception
    //   8946	8954	9117	java/lang/Exception
    //   8956	8968	9117	java/lang/Exception
    //   8970	8979	9117	java/lang/Exception
    //   8981	8990	9117	java/lang/Exception
    //   8995	9005	9117	java/lang/Exception
    //   9007	9016	9117	java/lang/Exception
    //   9018	9026	9117	java/lang/Exception
    //   9028	9037	9117	java/lang/Exception
    //   9044	9053	9117	java/lang/Exception
    //   9055	9064	9117	java/lang/Exception
    //   9066	9076	9117	java/lang/Exception
    //   9078	9087	9117	java/lang/Exception
    //   9089	9105	9117	java/lang/Exception
    //   9107	9114	9117	java/lang/Exception
    //   9193	9206	9543	java/lang/Exception
    //   9208	9217	9543	java/lang/Exception
    //   9219	9231	9543	java/lang/Exception
    //   9233	9243	9543	java/lang/Exception
    //   9245	9255	9543	java/lang/Exception
    //   9260	9268	9543	java/lang/Exception
    //   9276	9286	9543	java/lang/Exception
    //   9288	9298	9543	java/lang/Exception
    //   9300	9310	9543	java/lang/Exception
    //   9312	9318	9543	java/lang/Exception
    //   9320	9350	9543	java/lang/Exception
    //   9352	9359	9543	java/lang/Exception
    //   9361	9370	9543	java/lang/Exception
    //   9372	9382	9543	java/lang/Exception
    //   9384	9393	9543	java/lang/Exception
    //   9395	9405	9543	java/lang/Exception
    //   9407	9418	9543	java/lang/Exception
    //   9420	9430	9543	java/lang/Exception
    //   9432	9440	9543	java/lang/Exception
    //   9442	9452	9543	java/lang/Exception
    //   9454	9462	9543	java/lang/Exception
    //   9464	9474	9543	java/lang/Exception
    //   9476	9493	9543	java/lang/Exception
    //   9495	9502	9543	java/lang/Exception
    //   9577	9589	9680	java/lang/Exception
    //   9591	9599	9680	java/lang/Exception
    //   9601	9611	9680	java/lang/Exception
    //   9613	9622	9680	java/lang/Exception
    //   9624	9639	9680	java/lang/Exception
    //   9645	9652	9680	java/lang/Exception
    //   9654	9659	9680	java/lang/Exception
    //   9669	9677	9680	java/lang/Exception
    //   9725	9734	9680	java/lang/Exception
    //   9748	9757	9680	java/lang/Exception
    //   9781	9793	9884	java/lang/Exception
    //   9795	9803	9884	java/lang/Exception
    //   9805	9815	9884	java/lang/Exception
    //   9817	9826	9884	java/lang/Exception
    //   9828	9843	9884	java/lang/Exception
    //   9849	9856	9884	java/lang/Exception
    //   9858	9863	9884	java/lang/Exception
    //   9873	9881	9884	java/lang/Exception
    //   9929	9938	9884	java/lang/Exception
    //   9952	9961	9884	java/lang/Exception
    //   10085	10118	10150	java/lang/Exception
    //   10038	10075	10169	java/lang/Exception
    //   10151	10161	10169	java/lang/Exception
    //   10281	10294	10520	java/lang/Exception
    //   10299	10308	10520	java/lang/Exception
    //   10313	10322	10520	java/lang/Exception
    //   10327	10337	10520	java/lang/Exception
    //   10342	10351	10520	java/lang/Exception
    //   10356	10367	10520	java/lang/Exception
    //   10377	10387	10520	java/lang/Exception
    //   10392	10402	10520	java/lang/Exception
    //   10407	10416	10520	java/lang/Exception
    //   10421	10429	10520	java/lang/Exception
    //   10434	10442	10520	java/lang/Exception
    //   10447	10462	10520	java/lang/Exception
    //   10498	10512	10520	java/lang/Exception
    //   10590	10646	10775	org/json/JSONException
    //   10649	10653	10775	org/json/JSONException
    //   10660	10671	10775	org/json/JSONException
    //   10677	10703	10775	org/json/JSONException
    //   10706	10737	10775	org/json/JSONException
    //   10737	10763	10775	org/json/JSONException
    //   10763	10772	10775	org/json/JSONException
    //   10815	10837	10775	org/json/JSONException
    //   10857	10872	10875	org/json/JSONException
    //   10949	10970	10973	org/json/JSONException
    //   11023	11040	11054	org/json/JSONException
    //   11044	11051	11054	org/json/JSONException
    //   11023	11040	11093	java/lang/Exception
    //   11044	11051	11093	java/lang/Exception
    //   11149	11183	11301	java/lang/Exception
    //   11185	11219	11301	java/lang/Exception
    //   11223	11245	11301	java/lang/Exception
    //   11245	11298	11301	java/lang/Exception
    //   11345	11397	11417	java/lang/Exception
    //   11397	11414	11417	java/lang/Exception
    //   11438	11490	11741	org/json/JSONException
    //   11493	11501	11741	org/json/JSONException
    //   11505	11512	11741	org/json/JSONException
    //   11512	11528	11741	org/json/JSONException
    //   11531	11551	11741	org/json/JSONException
    //   11557	11738	11741	org/json/JSONException
    //   11785	11806	11741	org/json/JSONException
    //   11806	11827	11741	org/json/JSONException
    //   11438	11490	11830	java/lang/Exception
    //   11493	11501	11830	java/lang/Exception
    //   11505	11512	11830	java/lang/Exception
    //   11512	11528	11830	java/lang/Exception
    //   11531	11551	11830	java/lang/Exception
    //   11557	11738	11830	java/lang/Exception
    //   11785	11806	11830	java/lang/Exception
    //   11806	11827	11830	java/lang/Exception
    //   11923	11973	12254	org/json/JSONException
    //   11973	12016	12254	org/json/JSONException
    //   12019	12028	12254	org/json/JSONException
    //   12033	12041	12254	org/json/JSONException
    //   12041	12057	12254	org/json/JSONException
    //   12060	12251	12254	org/json/JSONException
    //   11923	11973	12293	java/lang/Exception
    //   11973	12016	12293	java/lang/Exception
    //   12019	12028	12293	java/lang/Exception
    //   12033	12041	12293	java/lang/Exception
    //   12041	12057	12293	java/lang/Exception
    //   12060	12251	12293	java/lang/Exception
    //   12343	12369	12426	org/json/JSONException
    //   12373	12423	12426	org/json/JSONException
    //   12343	12369	12483	java/lang/Exception
    //   12373	12423	12483	java/lang/Exception
    //   12562	12589	12647	org/json/JSONException
    //   12591	12609	12647	org/json/JSONException
    //   12609	12617	12647	org/json/JSONException
    //   12621	12644	12647	org/json/JSONException
    //   12701	12720	12809	org/json/JSONException
    //   12720	12730	12809	org/json/JSONException
    //   12730	12740	12809	org/json/JSONException
    //   12740	12748	12809	org/json/JSONException
    //   12752	12770	12809	org/json/JSONException
    //   12780	12790	12809	org/json/JSONException
    //   12796	12806	12809	org/json/JSONException
    //   12846	12872	12809	org/json/JSONException
    //   12882	12908	12809	org/json/JSONException
    //   12916	12926	12809	org/json/JSONException
    //   12934	12944	12809	org/json/JSONException
    //   12720	12730	12845	java/lang/Exception
    //   12730	12740	12878	java/lang/Exception
    //   12965	13005	13059	org/json/JSONException
    //   13009	13056	13059	org/json/JSONException
    //   13095	13120	13059	org/json/JSONException
    //   13148	13188	13191	org/json/JSONException
    //   13244	13287	13312	org/json/JSONException
    //   13295	13309	13312	org/json/JSONException
    //   13366	13393	13416	org/json/JSONException
    //   13397	13413	13416	org/json/JSONException
    //   13470	13494	13631	org/json/JSONException
    //   13497	13536	13631	org/json/JSONException
    //   13539	13594	13631	org/json/JSONException
    //   13599	13628	13631	org/json/JSONException
    //   13684	13725	13631	org/json/JSONException
    //   13745	13772	13788	org/json/JSONException
    //   13781	13785	13788	org/json/JSONException
    //   13802	13811	13788	org/json/JSONException
    //   13815	13852	13788	org/json/JSONException
    //   13858	13872	13788	org/json/JSONException
    //   13881	13895	13788	org/json/JSONException
    //   13979	14064	14067	java/lang/Exception
    //   14081	14099	14067	java/lang/Exception
    //   14104	14115	14067	java/lang/Exception
    //   14115	14136	14067	java/lang/Exception
    //   14139	14150	14067	java/lang/Exception
    //   14164	14205	14208	java/lang/Exception
    //   14244	14323	14326	java/lang/Exception
    //   14351	14430	14483	java/lang/Exception
    //   14430	14480	14483	java/lang/Exception
    //   14497	14531	14483	java/lang/Exception
    //   14534	14566	14483	java/lang/Exception
    //   14580	14653	14656	java/lang/Exception
    //   14681	14710	14792	java/lang/Exception
    //   14714	14789	14792	java/lang/Exception
    //   14817	14829	14835	java/lang/Exception
    //   14881	14978	14981	java/lang/Exception
    //   15006	15087	15090	java/lang/Exception
    //   15104	15109	15090	java/lang/Exception
    //   15112	15132	15090	java/lang/Exception
    //   15135	15147	15090	java/lang/Exception
    //   15150	15172	15090	java/lang/Exception
    //   15301	15382	15385	org/json/JSONException
    //   10012	10032	15395	java/lang/Exception
    //   3766	3775	15399	org/json/JSONException
    //   3780	3793	15399	org/json/JSONException
    //   1839	1880	15464	org/json/JSONException
    //   1882	1955	15464	org/json/JSONException
    //   1957	1968	15464	org/json/JSONException
    //   1971	2000	15464	org/json/JSONException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin
 * JD-Core Version:    0.7.0.1
 */