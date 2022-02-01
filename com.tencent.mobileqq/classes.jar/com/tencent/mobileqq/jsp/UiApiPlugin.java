package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.biz.webviewplugin.PubAccountUIPlugin;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.comic.api.IQQComicHippyWebviewShareHelper;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.comic.api.IQQComicWebViewApi;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.INearbyActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentAladdinUtils;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManager;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManagerFactory;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IUiApiPlugin;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentEntranceUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.api.IReadInJoyAtlasCommentFragmentLauncher;
import com.tencent.mobileqq.kandian.biz.detail.api.IReadInJoyArticleDetailActivity;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import com.tencent.mobileqq.kandian.biz.share.api.IReadInJoyShareManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QReaderUiInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.ReadInJoyUiInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.VipComicUiInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebProgressInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebViewProviderInterface;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidEntry;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidReq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.share.CommonShareHelper;
import com.tencent.share.WebShare;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.ActionSheet.WatchDismissActions;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneJumpQBrowserInterface;
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
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UiApiPlugin
  extends WebViewPlugin
  implements DialogInterface.OnCancelListener, View.OnClickListener, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener, ActionSheet.WatchDismissActions
{
  public static volatile BroadcastReceiver a;
  public static ResultReceiver a;
  public static CopyOnWriteArrayList<WeakReference<UiApiPlugin>> a;
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
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  public RefreshView a;
  MiniMsgUser jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  public OnRemoteRespObserver a;
  private IRIJBiuAndCommentMixDataManager jdField_a_of_type_ComTencentMobileqqKandianBizCommentBiuAndCommentMixApiIRIJBiuAndCommentMixDataManager;
  protected QQCustomDialog a;
  public IPullRefreshHeader a;
  public ActionSheet a;
  PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog = null;
  public String a;
  WeakReference<UiApiPlugin> jdField_a_of_type_JavaLangRefWeakReference = null;
  public boolean a;
  int b;
  protected ProgressDialog b;
  public View b;
  public ImageView b;
  public String b;
  public boolean b;
  public int c;
  public ImageView c;
  public String c;
  public boolean c;
  public int d;
  public ImageView d;
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
    jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = null;
    jdField_b_of_type_AndroidContentBroadcastReceiver = null;
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_c_of_type_AndroidContentBroadcastReceiver = null;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  }
  
  public UiApiPlugin()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidAppProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver = new UiApiPlugin.1(this);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_c_of_type_Int = -1;
    this.jdField_g_of_type_Boolean = false;
    this.mPluginNameSpace = "ui";
  }
  
  private int a(int paramInt)
  {
    if (paramInt != 6)
    {
      if (paramInt != 13) {
        return -1;
      }
      return 2130850766;
    }
    return 2130843844;
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
      int n;
      label8:
      label19:
      break label8;
    }
    try
    {
      n = Color.parseColor(paramJSONObject.getString(paramString));
      return n;
    }
    catch (Exception paramJSONObject)
    {
      break label19;
    }
    return 0;
  }
  
  public static Intent a(Context paramContext, Map<String, Object> paramMap, String paramString1, String paramString2)
  {
    paramMap = new Intent("android.intent.action.MAIN");
    paramMap.setClassName(paramContext, ShortcutGuideActivity.class.getName());
    paramMap.addCategory("android.intent.category.LAUNCHER");
    paramMap.putExtra("from", paramString2);
    paramMap.putExtra("url", paramString1);
    return paramMap;
  }
  
  private IMiniMsgUnreadCallback a()
  {
    return new UiApiPlugin.33(this);
  }
  
  private MiniMsgUser.IMiniMsgActionCallback a()
  {
    return new UiApiPlugin.34(this);
  }
  
  private CommonShareHelper a()
  {
    if (this.mRuntime.a() != null)
    {
      Object localObject = this.mRuntime.a().getParent();
      if ((localObject instanceof IQQComicHippyWebviewShareHelper))
      {
        localObject = (IQQComicHippyWebviewShareHelper)localObject;
        if ((((IQQComicHippyWebviewShareHelper)localObject).getShareHelper() instanceof CommonShareHelper)) {
          return (CommonShareHelper)((IQQComicHippyWebviewShareHelper)localObject).getShareHelper();
        }
      }
    }
    return null;
  }
  
  private WebShare a()
  {
    CommonShareHelper localCommonShareHelper = a();
    if (localCommonShareHelper != null)
    {
      if (localCommonShareHelper.a() == null) {
        localCommonShareHelper.a(new WebShare(this.mRuntime.a(), this.mRuntime.a(), this.mRuntime.a()));
      }
      return localCommonShareHelper.a();
    }
    return null;
  }
  
  public static String a(PubAccountUIPlugin paramPubAccountUIPlugin)
  {
    if (paramPubAccountUIPlugin != null) {}
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("type", "init");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("isShowBottomBar", paramPubAccountUIPlugin.jdField_a_of_type_Boolean);
      localJSONObject2.put("barHeight", paramPubAccountUIPlugin.jdField_a_of_type_Int);
      localJSONObject1.put("data", localJSONObject2);
      paramPubAccountUIPlugin = localJSONObject1.toString();
      return paramPubAccountUIPlugin;
    }
    catch (JSONException paramPubAccountUIPlugin)
    {
      label69:
      break label69;
    }
    if (QLog.isColorLevel()) {
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
      label69:
      break label69;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "getCallBackResult json error!");
    }
    return "{\"result\":\"-1\",\"message\":\"getCallBackResult json error!\"}";
  }
  
  public static void a(Activity paramActivity, CustomWebView paramCustomWebView, AppInterface paramAppInterface, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramActivity == null) {
      return;
    }
    Object localObject4 = paramActivity.getIntent();
    if ((paramCustomWebView == null) && (!paramBoolean2)) {
      return;
    }
    JSONObject localJSONObject2;
    String str3;
    JSONObject localJSONObject1;
    String str2;
    Object localObject2;
    Object localObject1;
    label167:
    boolean bool2;
    boolean bool1;
    label399:
    int n;
    label548:
    label823:
    try
    {
      localJSONObject2 = new JSONObject(paramString);
      str3 = localJSONObject2.optString("url");
      if (paramBoolean1) {
        localJSONObject1 = localJSONObject2;
      } else {
        localJSONObject1 = localJSONObject2.optJSONObject("options");
      }
      if (localJSONObject1 != null) {
        paramString = localJSONObject1.optString("businessId", null);
      } else {
        paramString = null;
      }
      if (paramString != null) {
        str2 = paramString;
      } else if (localObject4 == null) {
        str2 = null;
      } else {
        str2 = ((Intent)localObject4).getStringExtra("big_brother_source_key");
      }
      if (localObject4 != null)
      {
        localObject2 = ((Intent)localObject4).getStringExtra("big_brother_ref_source_key");
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = ((Intent)localObject4).getStringExtra("big_brother_source_key");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label2657;
        }
        localObject4 = paramString;
        if (paramCustomWebView != null) {
          b(paramCustomWebView.getUrl(), str3);
        }
        bool2 = localJSONObject2.optBoolean("force_no_reload");
        if ((!TextUtils.isEmpty(str3)) && (localJSONObject1 != null) && (localJSONObject1.has("style")))
        {
          if ((!paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity")) && (!paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity")) && (!localJSONObject1.optBoolean("useNewConfig", false))) {
            paramString = paramActivity.getIntent().getExtras();
          } else {
            paramString = null;
          }
          if (paramString == null)
          {
            paramString = new Bundle();
          }
          else
          {
            paramString.remove("title");
            paramString.remove("leftViewText");
            paramString.remove("post_data");
            paramString.remove("options");
            paramString.remove("isOpeningQunApp");
            paramString.remove("isTransparentTitleAndClickable");
            a(paramString);
            if (paramCustomWebView == null) {
              break label2685;
            }
          }
        }
      }
    }
    catch (Exception paramActivity) {}
    try
    {
      localObject2 = Uri.parse(paramCustomWebView.getUrl());
      if ((localObject2 == null) || (!((Uri)localObject2).isHierarchical())) {
        break label2685;
      }
      localObject1 = paramString;
      try
      {
        bool1 = "1".equals(((Uri)localObject2).getQueryParameter("__iscomic"));
        localObject1 = paramString;
        paramBoolean1 = "1".equals(((Uri)localObject2).getQueryParameter("__useCampusNotice"));
        if ((bool1) && (!paramBoolean1))
        {
          localObject1 = paramString;
          paramString.remove("uintype");
          localObject1 = paramString;
          QLog.d("UiApiPlugin", 1, "remove campus notice");
        }
        localObject2 = paramString;
        localObject1 = paramString;
        if (paramString.containsKey("insertPluginsArray"))
        {
          localObject1 = paramString;
          Object localObject5 = paramString.get("insertPluginsArray");
          localObject2 = paramString;
          localObject1 = paramString;
          if ((localObject5 instanceof String[]))
          {
            localObject1 = paramString;
            localObject5 = (String[])localObject5;
            n = 0;
            for (;;)
            {
              localObject2 = paramString;
              localObject1 = paramString;
              if (n < localObject5.length) {
                try
                {
                  if ("gdtReportPlugin".equals(localObject5[n])) {
                    localObject5[n] = null;
                  }
                  n += 1;
                }
                catch (Exception localException1)
                {
                  break label548;
                }
              }
            }
          }
        }
        paramString = (String)localObject2;
      }
      catch (Exception paramString)
      {
        break label2672;
      }
    }
    catch (Exception localException2)
    {
      label2650:
      label2657:
      str1 = paramString;
      paramString = localException2;
      label2672:
      localObject3 = str1;
      str1 = paramString;
      paramString = localObject3;
      break label548;
    }
    QLog.e("UiApiPlugin", 1, "open url exception", localException1);
    for (;;)
    {
      if (paramString.containsKey("startOpenPageTime")) {
        paramString.putLong("startOpenPageTime", System.currentTimeMillis());
      }
      n = localJSONObject1.optInt("style");
      paramBoolean1 = str3.startsWith("https://y.qq.com/m/mqq/musicsearch/index.html");
      if ((paramBoolean1) && (str3.contains("entry=aio"))) {
        paramString.remove("hide_left_button");
      }
      try
      {
        if (Boolean.valueOf(localJSONObject2.optBoolean("is_native", true)).booleanValue())
        {
          PluginJumpManager.getInstance().updateConfig(paramAppInterface);
          PluginJumpManager.getInstance().loadConfig();
          paramBoolean1 = PluginJumpManager.getInstance().openView(paramActivity, str3, String.valueOf(n));
          if (paramBoolean1) {
            return;
          }
        }
        if (n != 0)
        {
          if (n != 1)
          {
            if (n != 2) {
              if (n != 3) {
                if (n != 4) {
                  break label823;
                }
              }
            }
            for (;;)
            {
              paramString.putBoolean("hide_left_button", true);
              paramString.putBoolean("show_right_close_button", true);
              break;
              paramString.putBoolean("hide_more_button", true);
              paramString.putBoolean("hide_operation_bar", false);
              paramString.putString("webStyle", "");
              continue;
              paramString.putBoolean("hide_more_button", false);
              paramString.putBoolean("hide_operation_bar", false);
              paramString.putString("webStyle", "");
            }
          }
          else
          {
            paramString.putBoolean("hide_more_button", true);
            paramString.putBoolean("hide_operation_bar", true);
          }
        }
        else
        {
          paramString.putBoolean("hide_more_button", false);
          paramString.putBoolean("hide_operation_bar", true);
        }
        if (localJSONObject1.optInt("navigationBarStyle") == 1) {
          paramString.putBoolean("isTransparentTitleAndClickable", true);
        }
        paramString.putBoolean("hide_title_left_arrow", localJSONObject1.optBoolean("hideLeftArrow", false));
        n = localJSONObject1.optInt("target");
        if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity"))
        {
          paramCustomWebView = new Intent(((BasePluginActivity)paramActivity).getOutActivity(), QQBrowserActivity.class);
          paramCustomWebView.putExtra("big_brother_source_key", str2);
          paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject4);
          paramCustomWebView.putExtras(paramString);
          paramCustomWebView.putExtra("url", str3);
          paramCustomWebView.setFlags(0);
          if (n == 1) {
            paramCustomWebView.putExtra("articalChannelId", 0);
          }
          paramActivity.startActivityForResult(paramCustomWebView, 100);
        }
        else if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity"))
        {
          paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
          paramCustomWebView.putExtra("big_brother_source_key", str2);
          paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject4);
          paramCustomWebView.putExtras(paramString);
          paramCustomWebView.putExtra("url", str3);
          paramCustomWebView.setFlags(0);
          paramActivity.startActivityForResult(paramCustomWebView, 100);
        }
        else if ((!paramActivity.getClass().getName().equalsIgnoreCase("com.qqcomic.activity.fragment.VipComicWebFragmentActivity")) && (!paramActivity.getClass().getName().equalsIgnoreCase("com.qqcomic.activity.media.VipComicMediaPlayActivity")))
        {
          if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.QQH5BrowserActivity"))
          {
            paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
            paramCustomWebView.putExtra("big_brother_source_key", str2);
            paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject4);
            paramCustomWebView.putExtras(paramString);
            paramCustomWebView.putExtra("url", str3);
            paramCustomWebView.setFlags(0);
            paramActivity.startActivityForResult(paramCustomWebView, 100);
          }
          else if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity"))
          {
            paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
            paramCustomWebView.putExtra("big_brother_source_key", str2);
            paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject4);
            paramString.remove("isFullScreen");
            paramString.remove("isTransparentTitle");
            paramCustomWebView.putExtras(paramString);
            paramCustomWebView.putExtra("url", str3);
            paramCustomWebView.setFlags(0);
            paramActivity.startActivityForResult(paramCustomWebView, 100);
          }
          else if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity"))
          {
            paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
            if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrl(str3)) {
              paramCustomWebView = TeamWorkDocEditBrowserActivity.a(new Intent(paramActivity, TeamWorkDocEditBrowserActivity.class), str3, paramActivity);
            }
            paramCustomWebView.putExtra("big_brother_source_key", str2);
            paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject4);
            paramCustomWebView.putExtras(paramString);
            paramCustomWebView.putExtra("url", str3);
            paramActivity.startActivityForResult(paramCustomWebView, 100);
          }
          else if (paramActivity.getClass().getName().equalsIgnoreCase("cooperation.qwallet.plugin.QWalletPluginProxyActivity"))
          {
            paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
            paramCustomWebView.putExtra("big_brother_source_key", str2);
            paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject4);
            paramCustomWebView.putExtras(paramString);
            paramCustomWebView.putExtra("url", str3);
            paramActivity.startActivityForResult(paramCustomWebView, 100);
          }
          else if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.microapp.appbrand.ui.AppBrandUI"))
          {
            paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
            paramCustomWebView.putExtra("big_brother_source_key", str2);
            paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject4);
            paramCustomWebView.putExtras(paramString);
            paramCustomWebView.putExtra("url", str3);
            paramActivity.startActivityForResult(paramCustomWebView, 100);
          }
          else if (paramActivity.getClass().getName().equalsIgnoreCase("cooperation.liveroom.LiveRoomProxyActivity"))
          {
            paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
            paramCustomWebView.putExtra("big_brother_source_key", str2);
            paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject4);
            paramCustomWebView.putExtras(paramString);
            paramCustomWebView.putExtra("url", str3);
            paramActivity.startActivityForResult(paramCustomWebView, 100);
          }
          else if ((paramActivity instanceof INearbyActivity))
          {
            paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
            paramCustomWebView.putExtra("big_brother_source_key", str2);
            paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject4);
            paramCustomWebView.putExtras(paramString);
            paramCustomWebView.putExtra("url", str3);
            paramActivity.startActivityForResult(paramCustomWebView, 100);
          }
          else if ((!"com.tencent.mobileqq.minigame.ui.GameActivity".equals(paramActivity.getClass().getName())) && (!"com.tencent.mobileqq.minigame.ui.GameActivity1".equals(paramActivity.getClass().getName())))
          {
            paramString.remove("BusinessFeedData");
            if (localJSONObject1.optBoolean("useApolloBrowser", false))
            {
              ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(paramActivity, null, "other", str3, paramAppInterface);
              return;
            }
            if ((!paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.apollo.store.ApolloFloatActivity")) && (!paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.apollo.store.ApolloGameActivity")) && (!localJSONObject1.optBoolean("useQQBrowser", false)))
            {
              if ((paramActivity instanceof QzoneJumpQBrowserInterface))
              {
                paramCustomWebView = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
              }
              else if ((paramActivity instanceof EcshopWebActivity))
              {
                paramCustomWebView = new Intent(paramActivity, BusinessBrowser.class);
                paramCustomWebView.putExtra("jump_from", 2);
              }
              else if ((paramActivity instanceof IReadInJoyArticleDetailActivity))
              {
                paramCustomWebView = ((IReadInJoyArticleDetailActivity)paramActivity).a(paramString);
              }
              else if ((paramActivity instanceof PublicFragmentActivityForTool))
              {
                paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
              }
              else if ((paramActivity instanceof QPublicFragmentActivityForTool))
              {
                paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
                ((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).processUiApiPluginOpenUrl((QPublicFragmentActivityForTool)paramActivity);
              }
              else if (localJSONObject1.optBoolean("QzoneUseQQBrowser", false))
              {
                paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
                paramCustomWebView.putExtra("big_brother_source_key", str2);
                paramString.remove("isTransparentTitle");
                paramString.remove("hide_more_button");
                paramString.remove("hide_left_button");
              }
              else if (localJSONObject1.optInt("transparent", 0) == 1)
              {
                paramCustomWebView = new Intent(paramActivity, QQTranslucentBrowserActivity.class);
              }
              else if (paramBoolean2)
              {
                paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
                paramCustomWebView.putExtra("big_brother_source_key", str2);
              }
              else
              {
                paramCustomWebView = new Intent(paramActivity, paramActivity.getClass());
                paramCustomWebView.putExtra("big_brother_source_key", str2);
              }
            }
            else
            {
              paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
              paramCustomWebView.putExtra("big_brother_source_key", "biz_src_zf_lmx");
            }
            if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrl(str3))
            {
              paramCustomWebView = new Intent(paramActivity, TeamWorkDocEditBrowserActivity.class);
              paramCustomWebView.addFlags(603979776);
              paramCustomWebView = TeamWorkDocEditBrowserActivity.a(paramCustomWebView, str3, paramActivity);
            }
            if (localJSONObject1.optBoolean("isOpeningQunApp"))
            {
              paramString.putBoolean("isOpeningQunApp", localJSONObject1.optBoolean("isOpeningQunApp"));
              paramString.putInt("appid", localJSONObject1.optInt("appid"));
              paramAppInterface = localJSONObject1.optJSONObject("extraParams");
              if (paramAppInterface != null)
              {
                paramString.putString("extraParams", paramAppInterface.toString());
                paramString.putInt("troopid", paramAppInterface.optInt("gc"));
              }
            }
            paramCustomWebView.putExtra("force_no_reload", bool2);
            paramCustomWebView.putExtra("startOpenPageTime", System.currentTimeMillis());
            paramCustomWebView.putExtras(paramString);
            paramCustomWebView.putExtra("big_brother_source_key", str2);
            paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject4);
            paramCustomWebView.putExtra("url", str3);
            paramCustomWebView.setFlags(0);
            if (n == 1) {
              paramCustomWebView.putExtra("articalChannelId", 0);
            }
            if (((IQQComicUtil)QRoute.api(IQQComicUtil.class)).isVideoUrl(str3, paramCustomWebView))
            {
              paramCustomWebView.setClassName("com.qqcomic", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
              ((IQQComicPluginUtil)QRoute.api(IQQComicPluginUtil.class)).launchPlugin(paramActivity, paramCustomWebView, "com.qqcomic.activity.media.VipComicMediaPlayActivity", null);
            }
            else if ((str3 != null) && (str3.startsWith("mqqapi://")) && (paramActivity != null))
            {
              paramCustomWebView = new Intent(paramActivity, JumpActivity.class);
              paramCustomWebView.setData(Uri.parse(str3));
              paramActivity.startActivity(paramCustomWebView);
            }
            else
            {
              paramActivity.startActivityForResult(paramCustomWebView, 100);
            }
          }
          else
          {
            paramAppInterface = new Intent(paramActivity, QQTranslucentBrowserActivity.class);
            paramAppInterface.putExtra("url", str3);
            paramAppInterface.putExtra("big_brother_source_key", str2);
            paramAppInterface.putExtra("big_brother_ref_source_key", (String)localObject4);
            paramString.putBoolean("hide_left_button", true);
            paramString.putBoolean("hide_more_button", true);
            paramAppInterface.putExtras(paramString);
            paramString = new StringBuilder();
            paramString.append("checkPayForFriendLogic startActivityForResult at ");
            paramString.append(System.currentTimeMillis());
            QLog.d("PayForFriendView", 1, paramString.toString());
            paramActivity.startActivityForResult(paramAppInterface, 3004);
            if (paramCustomWebView != null) {
              paramCustomWebView.callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=true;d.dispatchEvent(e)}catch(err){}}(document);");
            }
          }
        }
        else
        {
          paramCustomWebView = new Intent();
          paramCustomWebView.putExtra("big_brother_source_key", str2);
          paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject4);
          paramString.remove("activityNoTitle");
          paramCustomWebView.putExtras(paramString);
          paramCustomWebView.putExtra("url", str3);
          paramCustomWebView.setFlags(0);
          ((IQQComicWebViewApi)QRoute.api(IQQComicWebViewApi.class)).openComicWebView(paramActivity, str3, paramCustomWebView);
        }
        n = localJSONObject1.optInt("animation");
        if (n == 0) {
          break label2650;
        }
        if (n != 1)
        {
          if (n != 2) {
            return;
          }
          paramActivity.overridePendingTransition(2130772342, 0);
          return;
        }
        paramActivity.overridePendingTransition(0, 0);
        return;
      }
      catch (Exception paramActivity) {}
      QLog.e("UiApiPlugin", 1, "convert json exception", paramActivity);
      return;
      String str1 = null;
      break;
      localObject4 = str1;
      break label167;
      Object localObject3;
      label2685:
      paramBoolean1 = false;
      bool1 = false;
      break label399;
    }
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, long paramLong, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i1 = paramArrayOfString.length;
    GetOpenidProto.GetOpenidReq localGetOpenidReq;
    int n;
    if ((i1 != 0) && (i1 == paramArrayOfInt.length) && (paramLong != -1L))
    {
      localGetOpenidReq = new GetOpenidProto.GetOpenidReq();
      localGetOpenidReq.appid.set(paramLong);
      n = 0;
    }
    for (;;)
    {
      if (n >= i1) {
        break label228;
      }
      GetOpenidProto.GetOpenidEntry localGetOpenidEntry = new GetOpenidProto.GetOpenidEntry();
      try
      {
        localGetOpenidEntry.id.set(Long.parseLong(paramArrayOfString[n], 10));
        int i2 = paramArrayOfInt[n];
        if (i2 == 0)
        {
          localGetOpenidEntry.type.set(0);
        }
        else if (i2 == 1)
        {
          localGetOpenidEntry.type.set(1);
        }
        else
        {
          if (i2 != 3000) {
            break label162;
          }
          localGetOpenidEntry.type.set(2);
        }
        localGetOpenidReq.list.add(localGetOpenidEntry);
        n += 1;
        continue;
        label162:
        paramActivity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin type error"));
        paramActivity.finish();
        return;
      }
      catch (NumberFormatException paramAppInterface)
      {
        label195:
        break label195;
      }
    }
    paramActivity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin error"));
    paramActivity.finish();
    return;
    label228:
    paramArrayOfString = new NewIntent(BaseApplicationImpl.getContext(), ProtoServlet.class);
    paramArrayOfString.setWithouLogin(true);
    paramArrayOfString.putExtra("cmd", "CommCompSvr.get_openid");
    paramArrayOfString.putExtra("data", localGetOpenidReq.toByteArray());
    paramArrayOfString.setObserver(new UiApiPlugin.17(paramActivity));
    paramAppInterface.startServlet(paramArrayOfString);
    return;
    paramActivity.setResult(-1, new Intent().putExtra("ret", 4));
    paramActivity.finish();
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (QQUtils.a(paramActivity, new String[] { paramString1 }))
    {
      QQToast.a(paramActivity, 2131692087, 0).b(paramActivity.getResources().getDimensionPixelSize(2131299168));
      paramActivity = a("-4", null, "createShortcut exsit!", paramString3);
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -2, "", "", "", "");
      callJs(paramString5, new String[] { paramActivity });
      return;
    }
    ThreadManagerV2.excute(new UiApiPlugin.26(this, paramActivity, paramString4, paramString1, paramString2, paramString3, paramString5), 128, null, true);
  }
  
  /* Error */
  public static void a(Activity paramActivity, JSONObject paramJSONObject, android.content.DialogInterface.OnClickListener paramOnClickListener1, android.content.DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +240 -> 241
    //   4: aload_0
    //   5: invokevirtual 894	android/app/Activity:isFinishing	()Z
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: aload_1
    //   13: ldc_w 382
    //   16: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 11
    //   21: aload_1
    //   22: ldc_w 896
    //   25: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore 12
    //   30: aload_1
    //   31: ldc_w 898
    //   34: iconst_1
    //   35: invokevirtual 373	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   38: istore 5
    //   40: aload_1
    //   41: ldc_w 900
    //   44: iconst_1
    //   45: invokevirtual 373	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   48: istore 6
    //   50: aload_1
    //   51: ldc_w 902
    //   54: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 7
    //   59: aload_1
    //   60: ldc_w 904
    //   63: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore 8
    //   68: aload_1
    //   69: ldc_w 906
    //   72: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   75: astore 9
    //   77: aload_0
    //   78: iconst_0
    //   79: invokestatic 911	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   82: astore 10
    //   84: aload 10
    //   86: aload 11
    //   88: invokevirtual 917	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   91: pop
    //   92: aload 10
    //   94: aload 12
    //   96: invokevirtual 921	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   99: pop
    //   100: aload 10
    //   102: invokevirtual 925	com/tencent/mobileqq/utils/QQCustomDialog:getMessageTextView	()Landroid/widget/TextView;
    //   105: invokevirtual 931	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   108: astore_1
    //   109: aload_1
    //   110: instanceof 933
    //   113: ifeq +38 -> 151
    //   116: aload_1
    //   117: checkcast 933	android/view/ViewGroup$MarginLayoutParams
    //   120: ldc_w 934
    //   123: invokestatic 939	com/tencent/mobileqq/utils/ViewUtils:a	(F)I
    //   126: putfield 942	android/view/ViewGroup$MarginLayoutParams:leftMargin	I
    //   129: aload_1
    //   130: checkcast 933	android/view/ViewGroup$MarginLayoutParams
    //   133: ldc_w 934
    //   136: invokestatic 939	com/tencent/mobileqq/utils/ViewUtils:a	(F)I
    //   139: putfield 945	android/view/ViewGroup$MarginLayoutParams:rightMargin	I
    //   142: aload 10
    //   144: invokevirtual 925	com/tencent/mobileqq/utils/QQCustomDialog:getMessageTextView	()Landroid/widget/TextView;
    //   147: aload_1
    //   148: invokevirtual 949	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   151: iload 6
    //   153: ifeq +30 -> 183
    //   156: aload 8
    //   158: astore_1
    //   159: aload 8
    //   161: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifeq +11 -> 175
    //   167: aload_0
    //   168: ldc_w 950
    //   171: invokevirtual 952	android/app/Activity:getString	(I)Ljava/lang/String;
    //   174: astore_1
    //   175: aload 10
    //   177: aload_1
    //   178: aload_2
    //   179: invokevirtual 956	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   182: pop
    //   183: iload 5
    //   185: ifeq +30 -> 215
    //   188: aload 7
    //   190: astore_1
    //   191: aload 7
    //   193: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifeq +11 -> 207
    //   199: aload_0
    //   200: ldc_w 957
    //   203: invokevirtual 952	android/app/Activity:getString	(I)Ljava/lang/String;
    //   206: astore_1
    //   207: aload 10
    //   209: aload_1
    //   210: aload_3
    //   211: invokevirtual 960	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   214: pop
    //   215: aload 9
    //   217: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifne +10 -> 230
    //   223: aload 10
    //   225: aload 4
    //   227: invokevirtual 964	com/tencent/mobileqq/utils/QQCustomDialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   230: aload 10
    //   232: invokevirtual 967	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   235: return
    //   236: astore_0
    //   237: aload_0
    //   238: invokevirtual 970	java/lang/Exception:printStackTrace	()V
    //   241: return
    //   242: astore_0
    //   243: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramActivity	Activity
    //   0	244	1	paramJSONObject	JSONObject
    //   0	244	2	paramOnClickListener1	android.content.DialogInterface.OnClickListener
    //   0	244	3	paramOnClickListener2	android.content.DialogInterface.OnClickListener
    //   0	244	4	paramOnCancelListener	DialogInterface.OnCancelListener
    //   38	146	5	bool1	boolean
    //   48	104	6	bool2	boolean
    //   57	135	7	str1	String
    //   66	94	8	str2	String
    //   75	141	9	str3	String
    //   82	149	10	localQQCustomDialog	QQCustomDialog
    //   19	68	11	str4	String
    //   28	67	12	str5	String
    // Exception table:
    //   from	to	target	type
    //   4	11	236	java/lang/Exception
    //   12	151	236	java/lang/Exception
    //   159	175	236	java/lang/Exception
    //   175	183	236	java/lang/Exception
    //   191	207	236	java/lang/Exception
    //   207	215	236	java/lang/Exception
    //   215	230	236	java/lang/Exception
    //   230	235	242	java/lang/Exception
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showTips param:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("UiApiPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (paramContext == null) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localObject = paramString.optString("text");
        n = paramString.optInt("type");
        if (n != 0)
        {
          if (n != 1) {
            return;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramContext = QQToast.a(paramContext, 0, (CharSequence)localObject, 0).a(0);
            paramContext.setGravity(23, 0, 0);
            paramContext.show();
          }
        }
        else
        {
          int i1 = paramString.optInt("iconMode", 1);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            n = 6;
            if (i1 == 0) {
              break label239;
            }
            if (i1 == 1) {
              break label229;
            }
            if (i1 == 2) {
              break label234;
            }
            if (i1 != 3)
            {
              if (i1 == 6) {
                break label239;
              }
              break label229;
            }
            QQToast.a(paramContext, n, (CharSequence)localObject, 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
            return;
          }
        }
      }
      catch (JSONException paramContext)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("showTips error:");
          paramString.append(paramContext);
          QLog.d("UiApiPlugin", 2, paramString.toString());
        }
      }
      return;
      label229:
      int n = 2;
      continue;
      label234:
      n = 1;
      continue;
      label239:
      n = 0;
    }
  }
  
  private static void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.remove("openWithWebBundle");
      paramBundle.remove("real_url");
      paramBundle.remove("preload_url");
      paramBundle.remove("bundle_data");
    }
  }
  
  private void a(ImageView paramImageView1, ImageView paramImageView2, int paramInt)
  {
    if (paramInt != 0)
    {
      Object localObject = paramImageView2;
      if (paramImageView2 == null)
      {
        paramImageView2 = new ImageView(BaseApplicationImpl.getApplication());
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, paramImageView1.getId());
        ((RelativeLayout.LayoutParams)localObject).addRule(6, paramImageView1.getId());
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        paramImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = paramImageView2;
        if ((paramImageView1.getParent() instanceof RelativeLayout))
        {
          ((RelativeLayout)paramImageView1.getParent()).addView(paramImageView2);
          localObject = paramImageView2;
        }
      }
      paramInt = a(paramInt);
      if (paramInt > 0)
      {
        ((ImageView)localObject).setImageResource(paramInt);
        ((ImageView)localObject).setVisibility(0);
        return;
      }
      ((ImageView)localObject).setVisibility(8);
      return;
    }
    if (paramImageView2 != null) {
      paramImageView2.setVisibility(8);
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    if ((paramJSONObject != null) && (paramActivity != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showCommentEditorNew json is :");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.d("UiApiPlugin", 1, ((StringBuilder)localObject).toString());
      localObject = new String(Base64Util.decode(paramJSONObject.optString("placeholder", ""), 0));
      JSONArray localJSONArray = paramJSONObject.optJSONArray("defaultCommentAtLevel");
      int n = paramJSONObject.optInt("maxLength", 100);
      int i1 = paramJSONObject.optInt("commentType", 1);
      int i2 = paramJSONObject.optInt("sourceType", 1);
      int i3 = paramJSONObject.optInt("openAt", 0);
      boolean bool = paramJSONObject.optBoolean("canBiu", false);
      String str = new String(Base64Util.decode(paramJSONObject.optString("defaultTxt"), 0));
      Intent localIntent = new Intent();
      if (paramJSONObject.has("isPgcAuthor")) {
        localIntent.putExtra("comment_is_pgc_author", paramJSONObject.optBoolean("isPgcAuthor"));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("#showCommentEditorNew bridge isPgcAuthor = ");
      localStringBuilder.append(paramJSONObject.optBoolean("isPgcAuthor", false));
      QLog.d("UiApiPlugin", 2, localStringBuilder.toString());
      localIntent.putExtra("comment_type", true);
      localIntent.putExtra("comment_json_string", paramJSONObject.toString());
      localIntent.putExtra("arg_comment_placeholder", (String)localObject);
      localIntent.putExtra("arg_comment_default_txt", str);
      localIntent.putExtra("arg_comment_max_length", n);
      localIntent.putExtra("arg_comment_comment_type", i1);
      localIntent.putExtra("arg_comment_source_type", i2);
      localIntent.putExtra("arg_callback", paramString);
      localIntent.putExtra("arg_comment_open_at", i3);
      localIntent.putExtra("comment_can_biu", bool);
      localIntent.putExtra("public_fragment_window_feature", 1);
      if (localJSONArray != null) {
        localIntent.putExtra("arg_comment_default_comment_at", localJSONArray.toString());
      }
      ((IRIJCommentEntranceUtils)QRoute.api(IRIJCommentEntranceUtils.class)).startForResult(paramActivity, localIntent, 117);
      return;
    }
    QLog.d("UiApiPlugin", 1, "showCommentEditorNew null object");
  }
  
  public static void a(boolean paramBoolean, String paramString, CallCommentJs paramCallCommentJs)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("UiApiPlugin", 1, "webGetCommentAladdinConfig callback is null");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("webGetCommentAladdinConfig isFromMainProcess + ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("UiApiPlugin", 1, ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    if (paramBoolean)
    {
      paramBoolean = ((IRIJBiuAndCommentAladdinUtils)QRoute.api(IRIJBiuAndCommentAladdinUtils.class)).getBiuAndCommentSwitch();
      try
      {
        ((JSONObject)localObject).put("isGrayscaleUser", paramBoolean);
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("webGetCommentAladdinConfig error ");
        localStringBuilder2.append(localJSONException.getMessage());
        QLog.e("UiApiPlugin", 1, localStringBuilder2.toString());
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("webGetCommentAladdinConfig is ");
      localStringBuilder1.append(paramBoolean);
      QLog.e("UiApiPlugin", 1, localStringBuilder1.toString());
      paramCallCommentJs.a(paramString, (JSONObject)localObject);
      return;
    }
    QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_update_biu_and_comment_switch_action", new Bundle(), new UiApiPlugin.14((JSONObject)localObject, paramCallCommentJs, paramString));
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      try
      {
        paramString2 = BitmapFactory.decodeResource(paramContext.getResources(), 2130840405);
      }
      catch (OutOfMemoryError paramString2)
      {
        if (!QLog.isColorLevel()) {
          break label111;
        }
      }
      QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(paramString2));
    }
    else
    {
      try
      {
        paramString2 = HttpUtil.openUrlForByte(paramContext, paramString2, "GET", null, null);
      }
      catch (IOException paramString2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(paramString2));
        }
        paramString2 = null;
      }
      if (paramString2 == null) {
        return false;
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
      }
    }
    label111:
    paramString2 = null;
    Object localObject = paramString2;
    if (paramString2 != null)
    {
      int n = DisplayUtils.a(paramContext);
      localObject = paramString2;
      if (n != paramString2.getWidth()) {
        if (!MobileIssueSettings.jdField_c_of_type_Boolean) {
          localObject = KapalaiAdapterUtil.a().a(paramString2, n);
        } else {
          localObject = Bitmap.createScaledBitmap(paramString2, n, n, false);
        }
      }
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "createShortcut.failed, icon is null.");
      }
      return false;
    }
    KapalaiAdapterUtil.a().a(paramIntent);
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramString2 = (ShortcutManager)paramContext.getSystemService("shortcut");
      if ((paramString2 != null) && (paramString2.isRequestPinShortcutSupported()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QQ");
        localStringBuilder.append(paramString1);
        paramContext = new ShortcutInfo.Builder(paramContext, localStringBuilder.toString()).setIcon(Icon.createWithBitmap((Bitmap)localObject)).setShortLabel(paramString1).setIntent(paramIntent).build();
        try
        {
          paramString2.requestPinShortcut(paramContext, null);
          return true;
        }
        catch (Exception paramContext)
        {
          QLog.i("UiApiPlugin", 1, "requestPinShortcut exception", paramContext);
          return false;
        }
      }
    }
    paramString2 = new Intent();
    paramString2.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    paramString2.putExtra("android.intent.extra.shortcut.NAME", paramString1);
    paramString2.putExtra("android.intent.extra.shortcut.ICON", (Parcelable)localObject);
    paramString2.putExtra("duplicate", false);
    paramString2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
    paramContext.sendOrderedBroadcast(paramString2, null);
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "createShortcut.finish.");
    }
    return true;
  }
  
  private static void b(String paramString1, String paramString2)
  {
    if (((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("http:"))) || ((paramString2.startsWith("https:")) && (!TextUtils.isEmpty(paramString1)) && (paramString1.contains("h5costreport=1")))) {
      ThreadManager.getSubThreadHandler().post(new UiApiPlugin.16(paramString1, paramString2));
    }
  }
  
  public static void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "unRegisterReceiver");
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localCopyOnWriteArrayList != null) {
      localCopyOnWriteArrayList.clear();
    }
    if ((jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver);
      jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    else
    {
      QLog.i("UiApiPlugin", 1, "no need unregister sExitWebViewReceiver");
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
  
  private void f()
  {
    jdField_c_of_type_AndroidContentBroadcastReceiver = new UiApiPlugin.31(this);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("register receiver error:");
      localStringBuilder.append(localException.toString());
      QLog.e("UiApiPlugin", 1, localStringBuilder.toString());
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if ((this.jdField_a_of_type_Boolean) && (paramInt == 0)) {
        callJs(this.jdField_b_of_type_JavaLangString, new String[] { "2", Integer.toString(paramInt) });
      } else {
        callJs(this.jdField_b_of_type_JavaLangString, new String[] { "0", Integer.toString(paramInt) });
      }
    }
    else {
      callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(paramInt));
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
  
  public int a(String paramString, boolean paramBoolean)
  {
    if ("1".equals(paramString)) {
      return 2130844008;
    }
    if ("2".equals(paramString)) {
      return 2130844007;
    }
    if ("3".equals(paramString)) {
      return 2130840351;
    }
    if ("4".equals(paramString)) {
      return 2130839368;
    }
    if ("5".equals(paramString)) {
      return 2130844052;
    }
    if ("7".equals(paramString))
    {
      if (paramBoolean) {
        return 2130842612;
      }
      return 2130842615;
    }
    if ("8".equals(paramString))
    {
      if (paramBoolean) {
        return 2130850469;
      }
      return 2130850473;
    }
    if ("9".equals(paramString)) {
      return 2130838831;
    }
    if ("10".equals(paramString)) {
      return 2130850663;
    }
    if ("11".equals(paramString)) {
      return 2130850662;
    }
    if ("14".equals(paramString)) {
      return 2130850588;
    }
    if ("15".equals(paramString)) {
      return 2130850589;
    }
    if ("16".equals(paramString)) {
      return 2130841077;
    }
    return -1;
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
  
  public void a()
  {
    try
    {
      Activity localActivity = this.mRuntime.a();
      WebViewProvider localWebViewProvider = this.mRuntime.a();
      if ((localActivity != null) && (localWebViewProvider != null))
      {
        ((InputMethodManager)localActivity.getSystemService("input_method")).toggleSoftInput(2, 0);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("UiApiPlugin", 1, localException, new Object[0]);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      localObject = ((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        localObject = ImageUtil.a((Drawable)localObject, paramInt);
        if (localObject != null) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Object localObject2 = BaseApplicationImpl.getContext();
    Activity localActivity = this.mRuntime.a();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      RelativeLayout localRelativeLayout = (RelativeLayout)localActivity.findViewById(2131376636);
      if (paramInt != 1)
      {
        localObject1 = null;
        paramString = (String)localObject1;
      }
      else
      {
        localObject1 = localActivity.getResources().getDrawable(2130844778);
        if (!TextUtils.isEmpty(paramString)) {
          paramString = new UiApiPlugin.19(this, paramString);
        } else {
          paramString = null;
        }
      }
      ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localImageView != null)
      {
        if (!paramBoolean2)
        {
          localRelativeLayout.removeView(localImageView);
          this.jdField_a_of_type_AndroidWidgetImageView = null;
          this.jdField_b_of_type_AndroidWidgetImageView = null;
          return;
        }
        localObject2 = this.jdField_b_of_type_AndroidWidgetImageView;
        if (localObject2 != null)
        {
          if (paramBoolean1) {
            ((ImageView)localObject2).setVisibility(0);
          } else {
            ((ImageView)localObject2).setVisibility(8);
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramString);
          this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
        }
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localActivity.getResources().getDrawable(2130850766));
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramString);
      paramString = new RelativeLayout(localActivity);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13, -1);
      paramString.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout.LayoutParams(DisplayUtil.a((Context)localObject2, 8.0F), DisplayUtil.a((Context)localObject2, 8.0F));
      ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, DisplayUtil.a((Context)localObject2, 4.0F), DisplayUtil.a((Context)localObject2, 4.0F), 0);
      paramString.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout.LayoutParams(DisplayUtil.a((Context)localObject2, 36.0F), DisplayUtil.a((Context)localObject2, 36.0F));
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131376756);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, DisplayUtil.a((Context)localObject2, 4.0F), 0);
      if (localRelativeLayout != null) {
        localRelativeLayout.addView(paramString, (ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if ("my_emoji_clk".equals(paramString2))
      {
        if (("11".equals(paramString1)) && (paramActivity != null))
        {
          paramString2 = paramActivity.getIntent();
          paramActivity = new ActivityURIRequest(paramActivity, "/base/activity/EmosmActivity");
          paramActivity.extra().putInt("key_emojimall_detail_chat_type", paramString2.getIntExtra("key_emojimall_detail_chat_type", -1));
          paramActivity.extra().putString("key_emojimall_detail_chat_uin", paramString2.getStringExtra("key_emojimall_detail_chat_uin"));
          paramActivity.extra().putInt("emojimall_src", paramString2.getIntExtra("emojimall_src", 1));
          QRoute.startUri(paramActivity);
        }
        else
        {
          QLog.e("UiApiPlugin", 1, "handleDoubleRightBtnClickEvent, my_emoji_clk, activity = null or iconid != my dressup");
        }
      }
      else {
        callJs(paramString2, new String[] { "" });
      }
    }
    else
    {
      paramActivity = new StringBuilder();
      paramActivity.append("handleDoubleRightBtnClickEvent, callback null, iconId=");
      paramActivity.append(paramString1);
      QLog.e("UiApiPlugin", 1, paramActivity.toString());
    }
    if ("10".equals(paramString1)) {
      ReportController.b(null, "CliOper", "", "", "ep_mall", "Clk_ep_search", 0, 0, "", "", "", "");
    }
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    paramContext = this.mRuntime.a();
    if (paramContext != null)
    {
      if (paramContext.isFinishing()) {
        return;
      }
      if ((this.mRuntime.a() != null) && (QLog.isColorLevel()))
      {
        paramContext = this.jdField_a_of_type_JavaLangRefWeakReference;
        if (paramContext != null) {
          paramContext = paramContext.toString();
        } else {
          paramContext = "null";
        }
        QLog.d("UiApiPlugin", 2, String.format("plugin %s onReceiveNewMsg", new Object[] { paramContext }));
      }
    }
  }
  
  protected void a(File paramFile)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
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
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (localObject1 != null)
    {
      if (((ActionSheet)localObject1).isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      if (paramString.equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
      }
    }
    Object localObject2 = this.mRuntime.a();
    if (localObject2 == null) {
      return;
    }
    for (;;)
    {
      int i4;
      try
      {
        localObject1 = new JSONObject(paramString);
        localObject2 = ActionSheet.create((Context)localObject2);
        Object localObject3 = ((JSONObject)localObject1).optString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((ActionSheet)localObject2).setMainTitle((CharSequence)localObject3);
        }
        localObject3 = ((JSONObject)localObject1).optJSONArray("items");
        int i3 = ((JSONObject)localObject1).optInt("selected", -1);
        int i2 = 0;
        this.jdField_a_of_type_Boolean = false;
        String str = ((JSONObject)localObject1).optString("close");
        if (!TextUtils.isEmpty(str))
        {
          this.jdField_a_of_type_Boolean = true;
          ((ActionSheet)localObject2).addButton(str, 3);
          n = 1;
          i1 = n;
          if (localObject3 != null)
          {
            i1 = n;
            if (((JSONArray)localObject3).length() > 0)
            {
              i4 = ((JSONArray)localObject3).length();
              i1 = i2;
              if (i3 >= 0)
              {
                i1 = i2;
                if (i3 < i4)
                {
                  i1 = 0;
                  if (i1 >= i4) {
                    break label429;
                  }
                  str = ((JSONArray)localObject3).getString(i1);
                  if (i1 != i3) {
                    break label423;
                  }
                  bool = true;
                  ((ActionSheet)localObject2).addRadioButton(str, bool);
                  i1 += 1;
                  continue;
                }
              }
              if (i1 >= i4) {
                break label429;
              }
              ((ActionSheet)localObject2).addButton(((JSONArray)localObject3).getString(i1));
              i1 += 1;
              continue;
            }
          }
          localObject3 = ((JSONObject)localObject1).optString("cancel");
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((ActionSheet)localObject2).addCancelButton((CharSequence)localObject3);
          }
          ((ActionSheet)localObject2).setOnButtonClickListener(this);
          ((ActionSheet)localObject2).setOnDismissListener(this);
          ((ActionSheet)localObject2).setOnCancelListener(this);
          ((ActionSheet)localObject2).registerWatchDisMissActionListener(this);
          this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)localObject2);
          this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("onclick");
          this.jdField_a_of_type_Int = i1;
          this.jdField_a_of_type_JavaLangString = paramString;
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("showActionSheet error:");
          ((StringBuilder)localObject1).append(paramString.getMessage());
          QLog.d("UiApiPlugin", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      int n = 0;
      continue;
      label423:
      boolean bool = false;
      continue;
      label429:
      int i1 = n + i4;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      Object localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).optString("rowKey");
      ((JSONObject)localObject2).optString("articleId");
      ((JSONObject)localObject2).optBoolean("isAccountDerelict");
      ((JSONObject)localObject2).optLong("publisherUin");
      Object localObject1 = ((JSONObject)localObject2).optString("commentID");
      String str1 = ((JSONObject)localObject2).optString("subCommentID");
      Object localObject3 = ((JSONObject)localObject2).optString("isAwesome");
      Object localObject4 = ((JSONObject)localObject2).optString("onCommentSend");
      String str2 = ((JSONObject)localObject2).optString("onCommentLike");
      String str3 = ((JSONObject)localObject2).optString("onCommentDelete");
      String str4 = ((JSONObject)localObject2).optString("onPanelClose");
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("rowKey", paramString);
      ((Bundle)localObject2).putString("commentId", (String)localObject1);
      ((Bundle)localObject2).putString("subCommentId", str1);
      ((Bundle)localObject2).putString("isAwesome", (String)localObject3);
      ((Bundle)localObject2).putString("onCommentSend", (String)localObject4);
      ((Bundle)localObject2).putString("onCommentLike", str2);
      ((Bundle)localObject2).putString("onCommentDelete", str3);
      ((Bundle)localObject2).putString("onPanelClose", str4);
      ((Bundle)localObject2).putInt("seq", paramInt);
      localObject4 = new AnchorData();
      ((AnchorData)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject1);
      ((AnchorData)localObject4).jdField_b_of_type_JavaLangString = str1;
      ((AnchorData)localObject4).jdField_a_of_type_Boolean = "1".equals(localObject3);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("anchorData commentId:");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(" ,subCommentId :");
      ((StringBuilder)localObject3).append(str1);
      QLog.i("UiApiPlugin", 1, ((StringBuilder)localObject3).toString());
      try
      {
        localObject1 = (Activity)this.mRuntime.a().getContext();
        ((IReadInJoyAtlasCommentFragmentLauncher)QRoute.api(IReadInJoyAtlasCommentFragmentLauncher.class)).launch((Context)localObject1, paramString, null, null, null, (AnchorData)localObject4, false, false, (Bundle)localObject2);
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        return;
      }
    }
    catch (JSONException paramString) {}
    QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(paramString));
  }
  
  protected final void a(String paramString1, String paramString2)
  {
    Object localObject = this.mRuntime.a().getEntityManagerFactory(this.mRuntime.a().getAccount()).createEntityManager();
    TroopInfo localTroopInfo = (TroopInfo)((EntityManager)localObject).find(TroopInfo.class, paramString1);
    ((EntityManager)localObject).close();
    if (localTroopInfo != null)
    {
      int n;
      if (localTroopInfo.isTroopOwner(this.mRuntime.a().getAccount())) {
        n = 0;
      } else if (localTroopInfo.isAdmin()) {
        n = 1;
      } else {
        n = 2;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append("");
      ReportController.b(null, "P_CliOper", "Grp_flower", "", "mber", paramString2, 0, 0, paramString1, ((StringBuilder)localObject).toString(), "", "");
    }
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("action", paramString);
      localJSONObject.put("options", paramJSONObject);
      paramString = new StringBuilder();
      paramString.append("javascript:mqq.dispatchEvent(\"miniAIOEvent\",");
      paramString.append(localJSONObject.toString());
      paramString.append(");");
      callJs(paramString.toString());
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("UiApiPlugin", 1, paramString, new Object[0]);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      a(paramJSONObject, null, new UiApiPlugin.20(this, paramJSONObject));
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
    if (localActivity == null) {
      return;
    }
    int n = paramJSONObject.optInt("iconID");
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("callback");
    String str3 = paramJSONObject.optString("color");
    boolean bool2 = paramJSONObject.optBoolean("hidden");
    int i1 = paramJSONObject.optInt("cornerID");
    if ((localActivity instanceof AbsBaseWebViewActivity))
    {
      int i2 = paramJSONObject.optInt("navIconUseDefault", -1);
      if (i2 >= 0)
      {
        paramJSONObject = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
          boolean bool1 = true;
          if (1 != i2) {
            bool1 = false;
          }
          paramJSONObject.B = bool1;
        }
      }
      ((AbsBaseWebViewActivity)localActivity).setRightButton(str2, str1, str3, bool2, n, i1, paramJsBridgeListener, paramOnClickListener);
      return;
    }
    paramJSONObject = this.mRuntime.a(this.mRuntime.a());
    paramJsBridgeListener = this.mRuntime.a();
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.getWebTitleBarInterface() != null))
    {
      paramJsBridgeListener.getWebTitleBarInterface().a(str2, str1, str3, bool2, n, i1, paramOnClickListener, null);
      return;
    }
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
    if ((paramJSONObject != null) && ((paramJSONObject instanceof WebUiUtils.VipComicUiInterface))) {
      ((WebUiUtils.VipComicUiInterface)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener, this.mRuntime.a().hashCode());
    }
  }
  
  protected void a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    String str1 = paramJSONObject.optString("callback");
    if (paramString == null) {
      paramJSONObject = new JSONObject();
    }
    try
    {
      paramJSONObject.put("code", paramInt);
      callJs(str1, new String[] { paramJSONObject.toString() });
      return;
    }
    catch (JSONException paramJSONObject)
    {
      label48:
      String str2;
      Object localObject;
      int n;
      Rect localRect;
      break label48;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("{\"code\":");
    paramJSONObject.append(paramInt);
    paramJSONObject.append("}");
    callJs(str1, new String[] { paramJSONObject.toString() });
    return;
    str2 = paramJSONObject.optString("text");
    localObject = paramJSONObject.optString("textColor");
    paramInt = paramJSONObject.optInt("x");
    n = paramJSONObject.optInt("y");
    localRect = new Rect(paramInt, n, paramJSONObject.optInt("width") + paramInt, paramJSONObject.optInt("height") + n);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject = "#FF000000";
    } else {
      paramJSONObject = (JSONObject)localObject;
    }
    localObject = new ArrayList(1);
    ((ArrayList)localObject).add(str2);
    SearchUtil.a(this.mRuntime.a(), paramString, str2, (List)localObject, paramJSONObject, localRect, new UiApiPlugin.29(this, str1));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean == this.jdField_g_of_type_Boolean) {
      return;
    }
    if (paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null)
      {
        Object localObject3 = BaseApplicationImpl.getContext();
        Object localObject2 = this.mRuntime.a();
        if (localObject2 != null)
        {
          if (((Activity)localObject2).isFinishing()) {
            return;
          }
          localObject1 = new TextView((Context)localObject2);
          ((TextView)localObject1).setId(2131364715);
          ((TextView)localObject1).setText(2131690874);
          ((TextView)localObject1).setBackgroundResource(2130851075);
          ((TextView)localObject1).setGravity(17);
          ((TextView)localObject1).setIncludeFontPadding(false);
          ((TextView)localObject1).setMaxWidth(DisplayUtil.a((Context)localObject3, 100.0F));
          ((TextView)localObject1).setMinWidth(DisplayUtil.a((Context)localObject3, 52.0F));
          ((TextView)localObject1).setSingleLine();
          ((TextView)localObject1).setTextColor(((Context)localObject3).getResources().getColor(2131167050));
          ((TextView)localObject1).setTextSize(1, 17.0F);
          localObject3 = new RelativeLayout.LayoutParams(-2, DisplayUtil.a((Context)localObject3, 36.0F));
          ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131376756);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
          ((TextView)localObject1).setOnClickListener(this);
          localObject2 = (RelativeLayout)((Activity)localObject2).findViewById(2131376636);
          if (localObject2 != null) {
            ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          }
          this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
        }
      }
      else
      {
        ((View)localObject1).setVisibility(0);
      }
      this.jdField_g_of_type_Boolean = true;
    }
    else
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      this.jdField_g_of_type_Boolean = false;
    }
    Object localObject1 = (WebViewFragment)this.mRuntime.a();
    if ((localObject1 != null) && (((WebViewFragment)localObject1).getSwiftTitleUI() != null))
    {
      ((WebViewFragment)localObject1).getSwiftTitleUI().e(paramBoolean);
      ((WebViewFragment)localObject1).getSwiftTitleUI().jdField_g_of_type_Boolean = paramBoolean;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.mRuntime.a();
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      View localView = ((Activity)localObject).findViewById(2131376636);
      if (localView != null)
      {
        int n;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          n = ImmersiveUtils.getStatusBarHeight((Context)localObject) + 0;
        } else {
          n = 0;
        }
        localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        n += localView.getMeasuredHeight();
        if ((!this.jdField_d_of_type_Boolean) && (paramBoolean))
        {
          localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -n);
          ((TranslateAnimation)localObject).setDuration(paramInt);
          ((TranslateAnimation)localObject).setInterpolator(new LinearInterpolator());
          ((TranslateAnimation)localObject).setFillAfter(true);
          ((TranslateAnimation)localObject).setAnimationListener(new UiApiPlugin.24(this, localView, localView.getTop() - n, localView.getBottom() - n));
          localView.startAnimation((Animation)localObject);
          this.jdField_d_of_type_Boolean = true;
          return;
        }
        if ((this.jdField_d_of_type_Boolean) && (!paramBoolean))
        {
          localObject = new TranslateAnimation(0.0F, 0.0F, -n, 0.0F);
          ((TranslateAnimation)localObject).setDuration(paramInt);
          ((TranslateAnimation)localObject).setInterpolator(new LinearInterpolator());
          ((TranslateAnimation)localObject).setFillAfter(true);
          ((TranslateAnimation)localObject).setAnimationListener(new UiApiPlugin.25(this, localView, localView.getTop() + n, localView.getBottom() + n));
          localView.setVisibility(0);
          localView.startAnimation((Animation)localObject);
          this.jdField_d_of_type_Boolean = false;
        }
      }
    }
  }
  
  void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject2 = this.mRuntime.a();
    Object localObject1 = this.mRuntime.a();
    if ((localObject2 != null) && (localObject1 != null) && (!((Activity)localObject1).isFinishing()))
    {
      localObject2 = (View)((WebView)localObject2).getParent();
      if (!(localObject2 instanceof RefreshView)) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)localObject2);
      this.jdField_h_of_type_Boolean = false;
      if (!this.jdField_e_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidViewView = ((Activity)localObject1).findViewById(2131363810);
        localObject1 = this.jdField_b_of_type_AndroidViewView;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        this.jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader = this.jdField_a_of_type_ComTencentBizUiRefreshView.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader;
        if (paramBoolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.setHeaderBgColor(-16777216);
          this.jdField_a_of_type_ComTencentBizUiRefreshView.setBackgroundColor(-16777216);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.setHeaderBgColor(paramInt1);
          this.jdField_a_of_type_ComTencentBizUiRefreshView.setBackgroundColor(paramInt2);
        }
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(new UiApiPlugin.18(this));
        callJs4OpenApiIfNeeded("setPullDown", 0, "[]");
        return;
      }
      callJs4OpenApiIfNeeded("setPullDown", 0, "already initPullDown");
      return;
    }
    callJs4OpenApiIfNeeded("setPullDown", -100, "recode_failed_native_error");
  }
  
  protected void a(byte[] paramArrayOfByte, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("diskcache/Image_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    FileUtils.writeFile(paramArrayOfByte, paramString);
    a(new File(paramString));
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    if (paramString2.equals("g_appstore_myapp"))
    {
      QLog.d("UiApiPlugin", 1, "open troopApp manager error,TroopProxyActivity已在725下架");
      return true;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!paramString1.matches("\\d+")) {
        return false;
      }
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
        paramString2 = new StringBuilder();
        paramString2.append("mqqapi://group/openOrg?troopUin=");
        paramString2.append(paramString1);
        paramString1 = paramString2.toString();
        paramString2 = new Intent();
        paramString2.setData(Uri.parse(paramString1));
        paramString2.setAction("android.intent.action.VIEW");
        this.mRuntime.a().startActivity(paramString2);
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
        if (SharedPreUtils.m(this.mRuntime.a(), this.mRuntime.a().getCurrentAccountUin()))
        {
          TroopPicEffectsEditActivity.a(this.mRuntime.a(), paramString1, paramString1);
          return true;
        }
        SharedPreUtils.p(this.mRuntime.a(), this.mRuntime.a().getCurrentAccountUin());
        paramString2 = new Intent(this.mRuntime.a(), TroopPicEffectGuidePicActivity.class);
        paramString2.putExtra("friendUin", paramString1);
        paramString2.putExtra("troopUin", paramString1);
        paramString2.putExtra("isFromTroopApp", true);
        this.mRuntime.a().startActivity(paramString2);
        return true;
      }
      if ((!TextUtils.isEmpty(paramString3)) && (paramString3.startsWith("mqqapi://groupopenapp/openapp")))
      {
        if ("group_story".equals(paramString2))
        {
          paramString1 = TroopStoryUtil.a(null, paramString3, null);
          StoryReportor.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
        }
        else
        {
          paramString1 = paramString3;
          if ("group_album".equals(paramString2)) {
            paramString1 = paramString3.replace("$UNREADNUM$", "1");
          }
        }
        paramString2 = new Intent(this.mRuntime.a(), JumpActivity.class);
        paramString2.setData(Uri.parse(paramString1));
        this.mRuntime.a().startActivity(paramString2);
        return true;
      }
    }
    return false;
  }
  
  void b()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      Object localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.jdField_a_of_type_ComTencentBizUiRefreshView;
      if (localObject != null) {
        ((RefreshView)localObject).setOnRefreshListener(null);
      }
    }
  }
  
  public void b(int paramInt)
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = paramInt;
    localMiniMsgUserParam.accessType = 3;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.isNeedBackConversation = true;
    localMiniMsgUserParam.unreadCallback = a();
    localMiniMsgUserParam.actionCallback = a();
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "mini_msg uiApiPlugin initMiniMsgUser = ");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(this.mRuntime.a(), localMiniMsgUserParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
  }
  
  public void b(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    int n = paramIntent.getIntExtra("mode", 0);
    boolean bool = paramIntent.getBooleanExtra("exclude", false);
    int i2 = paramIntent.getIntExtra("number", 0);
    int i1 = paramIntent.getIntExtra("sender", 0);
    if (QLog.isColorLevel())
    {
      paramContext = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (paramContext != null) {
        paramContext = paramContext.toString();
      } else {
        paramContext = "null";
      }
      QLog.d("UiApiPlugin", 2, String.format("plugin %s (mSequence: %d): onReceive , mode: %d, exclude: %b, number: %d, sender: %d", new Object[] { paramContext, Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(n), Boolean.valueOf(bool), Integer.valueOf(i2), Integer.valueOf(i1) }));
    }
    paramContext = this.mRuntime.a();
    if (paramContext != null)
    {
      if (paramContext.isFinishing()) {
        return;
      }
      if (i2 > 0)
      {
        int i3 = this.jdField_b_of_type_Int;
        if (i1 == i3)
        {
          if (!bool) {
            paramContext.finish();
          }
        }
        else if ((i3 >= i1 - i2) && (i3 < i1))
        {
          if ((n == 0) || (n == 2)) {
            paramContext.finish();
          }
        }
        else
        {
          i3 = this.jdField_b_of_type_Int;
          if ((i3 > i1) && (i3 <= i1 + i2) && ((n == 0) || (n == 1))) {
            paramContext.finish();
          }
        }
      }
      else
      {
        i2 = this.jdField_b_of_type_Int;
        if (i1 == i2)
        {
          if (!bool) {
            paramContext.finish();
          }
        }
        else if (i1 > i2)
        {
          if ((n == 0) || (n == 2)) {
            paramContext.finish();
          }
        }
        else if ((n == 0) || (n == 1)) {
          paramContext.finish();
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = this.mRuntime.a(this.mRuntime.a());
    if ((localObject != null) && ((localObject instanceof WebUiUtils.WebShareInterface)))
    {
      localObject = (Share)((WebUiUtils.WebShareInterface)localObject).getShare();
      Bundle localBundle = new Bundle();
      localBundle.putString("title", ((Share)localObject).a());
      localBundle.putString("desc", ((Share)localObject).b());
      localBundle.putString("detail_url", ((Share)localObject).getShareUrl());
      localBundle.putString("cover_url", ((Share)localObject).d());
      localBundle.putInt("article_id", ((Share)localObject).a());
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(((Share)localObject).c());
      localBundle.putStringArrayList("image_url", localArrayList);
      localBundle.putString("source_name", ((Share)localObject).e());
      if (a() != null) {
        if (((IReadInJoyShareManager)QRoute.api(IReadInJoyShareManager.class)).jumpToReadInJoyShare(a(), localBundle, null, 0))
        {
          if (!TextUtils.isEmpty(paramString)) {
            callJs(paramString, new String[] { "true" });
          }
        }
        else
        {
          if (!TextUtils.isEmpty(paramString)) {
            callJs(paramString, new String[] { "false" });
          }
          QRUtils.a(1, 2131689486);
        }
      }
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "showPopupMenu: context is null");
      }
      return;
    }
    Object localObject1 = this.mRuntime.a(this.mRuntime.a());
    Object localObject2 = this.mRuntime.a();
    if ((localObject2 != null) && (((WebUiUtils.WebViewProviderInterface)localObject2).getWebTitleBarInterface() != null)) {
      localObject1 = ((WebUiUtils.WebViewProviderInterface)localObject2).getWebTitleBarInterface().b();
    }
    for (;;)
    {
      break;
      if ((localObject1 != null) && ((localObject1 instanceof WebUiUtils.QReaderUiInterface)))
      {
        localObject1 = ((WebUiUtils.QReaderUiInterface)localObject1).a();
      }
      else
      {
        if ((localObject1 == null) || (!(localObject1 instanceof WebUiUtils.VipComicUiInterface))) {
          break label592;
        }
        localObject1 = ((WebUiUtils.VipComicUiInterface)localObject1).a(this.mRuntime.a().hashCode());
      }
    }
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "showPopupMenu: Can not get TitleBar");
      }
      return;
    }
    float f1 = localActivity.getResources().getDisplayMetrics().density;
    localObject2 = this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
    if (localObject2 != null)
    {
      if (!((PopupMenuDialog)localObject2).isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131298902) - localActivity.getResources().getDimensionPixelSize(2131298898), localActivity.getResources().getDimensionPixelSize(2131298899));
      }
      return;
    }
    localObject2 = localActivity.getResources().getDrawable(2130839505);
    for (;;)
    {
      int n;
      try
      {
        localObject3 = paramJSONObject.optJSONArray("list");
        if (localObject3 != null) {
          break label610;
        }
        if (!QLog.isColorLevel()) {
          break label609;
        }
        QLog.d("UiApiPlugin", 2, "showPopupMenu: list is null");
        return;
      }
      catch (Exception localException)
      {
        Object localObject4;
        PopupMenuDialog.MenuItem localMenuItem;
        URLDrawable.URLDrawableOptions localURLDrawableOptions;
        if (!QLog.isColorLevel()) {
          continue;
        }
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("showPopupMenu Exception: ");
        ((StringBuilder)localObject3).append(localException.getMessage());
        QLog.e("UiApiPlugin", 2, ((StringBuilder)localObject3).toString());
        this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.build(localActivity, localArrayList, new UiApiPlugin.21(this, paramJSONObject, localActivity));
        this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131298902) - localActivity.getResources().getDimensionPixelSize(2131298898), localActivity.getResources().getDimensionPixelSize(2131298899));
        return;
      }
      if (n < ((JSONArray)localObject3).length())
      {
        localObject4 = ((JSONArray)localObject3).optJSONObject(n);
        localMenuItem = new PopupMenuDialog.MenuItem();
        localMenuItem.id = Integer.parseInt(((JSONObject)localObject4).optString("id"));
        localMenuItem.title = ((JSONObject)localObject4).optString("itemContent");
        localMenuItem.contentDescription = localMenuItem.title;
        localMenuItem.iconId = 2130851220;
        localObject4 = ((JSONObject)localObject4).optString("itemUrl");
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = ((int)(f1 * 71.0F));
          localURLDrawableOptions.mRequestHeight = ((int)(94.0F * f1));
          localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
          localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
          localMenuItem.netDrawable = URLDrawable.getDrawable((String)localObject4, localURLDrawableOptions);
        }
        localArrayList.add(localMenuItem);
        n += 1;
      }
      else
      {
        label592:
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "showPopupMenu: activity has not implement WebUiMethodInterface");
        }
        return;
        label609:
        return;
        label610:
        n = 0;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
  }
  
  protected void c(String paramString)
  {
    Object localObject1 = this.mRuntime.a();
    if (localObject1 != null)
    {
      if (((Activity)localObject1).isFinishing()) {
        return;
      }
      if (!AppNetConnInfo.isNetSupport())
      {
        QQToast.a(this.mRuntime.a().getApplication(), 1, HardCodeUtil.a(2131715630), 0).a();
        return;
      }
      Object localObject2 = this.jdField_b_of_type_AndroidAppProgressDialog;
      if (localObject2 == null)
      {
        this.jdField_b_of_type_AndroidAppProgressDialog = new ReportProgressDialog((Context)localObject1, 2131756189);
        this.jdField_b_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_b_of_type_AndroidAppProgressDialog.show();
        this.jdField_b_of_type_AndroidAppProgressDialog.setContentView(2131559561);
        ((TextView)this.jdField_b_of_type_AndroidAppProgressDialog.findViewById(2131372646)).setText(HardCodeUtil.a(2131715632));
      }
      else
      {
        ((ProgressDialog)localObject2).show();
      }
      localObject2 = new File(AbsDownloader.getFilePath(paramString));
      if (((File)localObject2).exists())
      {
        this.jdField_b_of_type_AndroidAppProgressDialog.dismiss();
        a((File)localObject2);
        return;
      }
      localObject1 = new Bundle();
      localObject2 = new DownloadTask(paramString, (File)localObject2);
      ((DownloadTask)localObject2).d = 60L;
      ((DownloaderFactory)this.mRuntime.a().getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).startDownload((DownloadTask)localObject2, new UiApiPlugin.27(this, paramString), (Bundle)localObject1);
    }
  }
  
  public void c(JSONObject paramJSONObject)
  {
    Object localObject2 = this.mRuntime.a();
    if (localObject2 != null)
    {
      if (((Activity)localObject2).isFinishing()) {
        return;
      }
      if (paramJSONObject != null)
      {
        Object localObject1 = paramJSONObject.optString("title");
        Object localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject3 = this.mRuntime.a(this.mRuntime.a());
          if ((localObject3 != null) && ((localObject3 instanceof WebUiUtils.VipComicUiInterface)))
          {
            ((WebUiUtils.VipComicUiInterface)localObject3).a((String)localObject1, this.mRuntime.a().hashCode());
          }
          else if ((localObject3 != null) && ((localObject3 instanceof WebUiUtils.QReaderUiInterface)))
          {
            ((WebUiUtils.QReaderUiInterface)localObject3).a((String)localObject1);
          }
          else if ((localObject3 instanceof WebViewFragment))
          {
            if (!SwiftWebViewUtils.a())
            {
              localObject2 = (WebViewFragment)localObject3;
              if ((((WebViewFragment)localObject2).getSwiftTitleUI() != null) && (((WebViewFragment)localObject2).getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView != null)) {
                ((WebViewFragment)localObject2).getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
              }
            }
          }
          else
          {
            localObject2 = (TextView)((Activity)localObject2).findViewById(2131369202);
            if (localObject2 != null) {
              ((TextView)localObject2).setText((CharSequence)localObject1);
            }
          }
        }
        paramJSONObject = paramJSONObject.optString("callback");
        try
        {
          localObject2 = this.mRuntime.a();
          if (localObject2 != null)
          {
            localObject1 = ((CustomWebView)localObject2).getPluginEngine();
            localObject2 = ((CustomWebView)localObject2).getUrl();
            if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject2)))
            {
              boolean bool = ((WebViewPluginEngine)localObject1).a().a((String)localObject2, "ui.setLeftCloseHandler");
              if (bool) {
                this.jdField_e_of_type_JavaLangString = paramJSONObject;
              }
              if (QLog.isColorLevel()) {
                QLog.d("UiApiPlugin", 2, new Object[] { "setLeftCloseHandler url:", localObject2, " hasRight:", Boolean.valueOf(bool) });
              }
            }
            localObject3 = new HashMap(2);
            if (localObject2 == null) {
              paramJSONObject = null;
            } else {
              paramJSONObject = Uri.parse((String)localObject2);
            }
            localObject2 = "";
            if (paramJSONObject == null) {
              localObject1 = "";
            } else {
              localObject1 = paramJSONObject.getHost();
            }
            ((HashMap)localObject3).put("host", localObject1);
            if (paramJSONObject == null) {
              paramJSONObject = (JSONObject)localObject2;
            } else {
              paramJSONObject = paramJSONObject.getPath();
            }
            ((HashMap)localObject3).put("path", paramJSONObject);
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication().getApplicationContext()).collectPerformance(null, "actWvCloseHandle", true, 0L, 0L, (HashMap)localObject3, null);
            return;
          }
        }
        catch (Exception paramJSONObject)
        {
          QLog.e("UiApiPlugin", 1, new Object[] { "e:", paramJSONObject.toString() });
        }
      }
    }
  }
  
  void d()
  {
    jdField_a_of_type_AndroidContentBroadcastReceiver = new UiApiPlugin.30(this);
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "initExitWebViewReceiver!");
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE");
      BaseApplicationImpl.getApplication().registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("register receiver error:");
      localStringBuilder.append(localException.toString());
      QLog.e("UiApiPlugin", 1, localStringBuilder.toString());
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    }
  }
  
  protected void d(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optString("imageData");
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
        ((StringBuilder)localObject1).append("diskcache/Image_");
        ((StringBuilder)localObject1).append(MD5Utils.toMD5(str));
        localObject1 = ((StringBuilder)localObject1).toString();
        FileUtils.writeFile(Base64Util.decode(str, 0), (String)localObject1);
        a(paramString, (String)localObject1, 0);
        return;
      }
      str = paramString.optString("imageUrl");
      Object localObject1 = this.mRuntime.a();
      if (localObject1 != null)
      {
        if (((Activity)localObject1).isFinishing()) {
          return;
        }
        if (!AppNetConnInfo.isNetSupport())
        {
          a(paramString, null, -2);
          return;
        }
        Object localObject2 = new File(AbsDownloader.getFilePath(str));
        if (((File)localObject2).exists())
        {
          a(paramString, AbsDownloader.getFilePath(str), 0);
          return;
        }
        localObject1 = new Bundle();
        localObject2 = new DownloadTask(str, (File)localObject2);
        ((DownloadTask)localObject2).d = 60L;
        ((DownloaderFactory)this.mRuntime.a().getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).startDownload((DownloadTask)localObject2, new UiApiPlugin.28(this, str, paramString), (Bundle)localObject1);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("UiApiPlugin", 1, "mergeTextToImage exception e = ", paramString);
    }
  }
  
  public void d(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      Activity localActivity = this.mRuntime.a();
      WebViewFragment localWebViewFragment = (WebViewFragment)this.mRuntime.a();
      boolean bool = true;
      if (localWebViewFragment != null)
      {
        String str1 = paramJSONObject.optString("iconID1");
        paramJSONObject.optString("schemeType1");
        String str2 = paramJSONObject.optString("_sharedCallbackID1");
        String str3 = paramJSONObject.optString("voiceStr1");
        int n = paramJSONObject.optInt("cornerID1");
        Object localObject1 = paramJSONObject.optString("iconID2");
        paramJSONObject.optString("schemeType2");
        Object localObject2 = paramJSONObject.optString("_sharedCallbackID2");
        String str4 = paramJSONObject.optString("voiceStr2");
        int i1 = paramJSONObject.optInt("cornerID2");
        localWebViewFragment.getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramJSONObject = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
        if ((paramJSONObject == null) || (!paramJSONObject.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.B) || ("1000".equals(ThemeUtil.getCurrentThemeId()))) {
          bool = false;
        }
        this.jdField_e_of_type_Int = a((String)localObject1, bool);
        if (paramJSONObject != null)
        {
          ImageView localImageView = localWebViewFragment.getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView;
          int i2 = this.jdField_e_of_type_Int;
          paramJSONObject.a(localImageView, false, i2, i2);
        }
        else
        {
          localWebViewFragment.getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.jdField_e_of_type_Int);
        }
        localWebViewFragment.getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str4);
        localWebViewFragment.getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new UiApiPlugin.22(this, localActivity, (String)localObject1, (String)localObject2));
        a(localWebViewFragment.getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView, localWebViewFragment.getSwiftTitleUI().jdField_b_of_type_AndroidWidgetImageView, i1);
        localObject1 = (RelativeLayout)localActivity.findViewById(2131376636);
        localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
        if (localObject2 != null)
        {
          ((RelativeLayout)localObject1).removeView((View)localObject2);
        }
        else
        {
          this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(localActivity);
          this.jdField_c_of_type_AndroidWidgetImageView.setId(2131378808);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131376756);
          ((RelativeLayout.LayoutParams)localObject2).addRule(15);
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = DisplayUtil.a(localActivity.getApplicationContext(), 10.0F);
          this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        this.jdField_d_of_type_Int = a(str1, bool);
        if (paramJSONObject != null)
        {
          localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
          i1 = this.jdField_d_of_type_Int;
          paramJSONObject.a((View)localObject2, false, i1, i1);
        }
        else
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(this.jdField_d_of_type_Int);
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(str3);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new UiApiPlugin.23(this, localActivity, str1, str2));
        localWebViewFragment.getSwiftTitleUI().e(false);
        ((RelativeLayout)localObject1).addView(this.jdField_c_of_type_AndroidWidgetImageView);
        a(this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_d_of_type_AndroidWidgetImageView, n);
        return;
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("setDoubleRightButton, not support ");
      paramJSONObject.append(localActivity);
      QLog.e("UiApiPlugin", 1, paramJSONObject.toString());
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8589935386L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934593L)
    {
      this.jdField_e_of_type_JavaLangString = null;
      return false;
    }
    int n;
    int i1;
    if ((paramLong != 8589934597L) && (paramLong != 512L)) {
      if ((paramLong != 2L) && (paramLong != 256L))
      {
        if (paramLong == 16L)
        {
          this.jdField_e_of_type_JavaLangString = null;
          return false;
        }
        if ((paramLong != 8589934601L) && (paramLong != 8589934602L)) {
          if (paramLong == 8589934600L)
          {
            n = ((Integer)paramMap.get("requestCode")).intValue();
            i1 = ((Integer)paramMap.get("resultCode")).intValue();
            if (n != 14) {}
          }
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = new JSONObject();
        if (i1 != -1) {
          break label792;
        }
        paramString = ((Intent)paramMap.get("data")).getStringExtra("data");
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool)
        {
          ((JSONObject)localObject1).put("result", -2);
          ((JSONObject)localObject1).put("data", "");
        }
        else
        {
          ((JSONObject)localObject1).put("result", 0);
          ((JSONObject)localObject1).put("data", paramString);
        }
        callJs(this.jdField_h_of_type_JavaLangString, new String[] { ((JSONObject)localObject1).toString() });
        return false;
      }
      catch (Exception paramString)
      {
        callJs(this.jdField_h_of_type_JavaLangString, new String[] { "" });
        QLog.e("UiApiPlugin", 1, "mOpenCustomWebViewCallback call back exception e = ", paramString);
        return false;
      }
      if (n == 18)
      {
        paramString = this.mRuntime.a();
        if ((i1 == -1) && (paramString != null) && (!paramString.isFinishing()))
        {
          localObject1 = AIOUtils.a(new Intent(paramString, SplashActivity.class), null);
          paramMap = (Intent)paramMap.get("data");
          if (paramMap != null)
          {
            ((Intent)localObject1).putExtras(new Bundle(paramMap.getExtras()));
            paramString.startActivity((Intent)localObject1);
          }
          return true;
          if ((paramLong == 8589934615L) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
          {
            callJs(this.jdField_e_of_type_JavaLangString, new String[] { "" });
            return true;
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
                  localObject1 = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
                  if ((localObject1 != null) && ((((SwiftBrowserUIStyleHandler)localObject1).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long & 0x200000) == 0L) && (!((Intent)localObject2).getBooleanExtra("show_right_close_button", false)))
                  {
                    localObject2 = (TextView)paramString.findViewById(2131369233);
                    if (((localObject2 == null) || (((TextView)localObject2).getVisibility() != 0) || (!paramString.getString(2131690874).equals(((TextView)localObject2).getText()))) && ((((SwiftBrowserUIStyleHandler)localObject1).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long & 0x4) == 0L)) {
                      this.jdField_c_of_type_Int = 1;
                    }
                  }
                }
              }
              if (this.jdField_c_of_type_Int == 0) {
                return false;
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
                if (QLog.isColorLevel())
                {
                  paramString = new StringBuilder();
                  paramString.append("web history current index:");
                  paramString.append(n);
                  QLog.d("UiApiPlugin", 2, paramString.toString());
                }
                if (n > 1)
                {
                  a(true);
                  return false;
                }
                a(false);
                return false;
                callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=false;d.dispatchEvent(e)}catch(err){}}(document);");
                return false;
                callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=true;d.dispatchEvent(e)}catch(err){}}(document);");
              }
            }
          }
        }
      }
      return false;
      label792:
      paramString = "";
    }
  }
  
  /* Error */
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 133
    //   2: aload_3
    //   3: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: istore 10
    //   8: iconst_0
    //   9: istore 6
    //   11: iconst_0
    //   12: invokestatic 475	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   15: astore_3
    //   16: iload 10
    //   18: ifeq +17954 -> 17972
    //   21: aload_0
    //   22: aload 4
    //   24: aload_1
    //   25: invokevirtual 2647	com/tencent/mobileqq/jsp/UiApiPlugin:addOpenApiListenerIfNeeded	(Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   28: ldc_w 2649
    //   31: aload 4
    //   33: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +210 -> 246
    //   39: aload 5
    //   41: arraylength
    //   42: ifle +204 -> 246
    //   45: new 146	org/json/JSONObject
    //   48: dup
    //   49: aload 5
    //   51: iconst_0
    //   52: aaload
    //   53: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   56: astore 5
    //   58: aload_0
    //   59: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   62: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   65: astore 4
    //   67: aload 5
    //   69: ldc_w 2651
    //   72: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   75: astore_1
    //   76: aload 5
    //   78: ldc_w 2653
    //   81: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_2
    //   85: aload 5
    //   87: ldc 187
    //   89: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore_3
    //   93: aload 5
    //   95: ldc_w 906
    //   98: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore 5
    //   103: aload 4
    //   105: ifnull +139 -> 244
    //   108: aload_1
    //   109: invokestatic 2658	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   112: ifeq +132 -> 244
    //   115: aload_2
    //   116: invokestatic 2658	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   119: ifeq +125 -> 244
    //   122: ldc_w 2660
    //   125: invokestatic 574	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   128: checkcast 2660	com/tencent/mobileqq/profilecard/api/IProfileCardApi
    //   131: aload 4
    //   133: aconst_null
    //   134: invokeinterface 2664 3 0
    //   139: astore 4
    //   141: aload 4
    //   143: ldc_w 2061
    //   146: aload_1
    //   147: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   150: pop
    //   151: aload 4
    //   153: ldc_w 2653
    //   156: aload_2
    //   157: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   160: pop
    //   161: ldc_w 2666
    //   164: aload_3
    //   165: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifeq +25 -> 193
    //   171: aload 4
    //   173: ldc_w 2668
    //   176: bipush 8
    //   178: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   181: pop
    //   182: aload 4
    //   184: ldc_w 906
    //   187: aload 5
    //   189: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   192: pop
    //   193: aload_0
    //   194: aload 4
    //   196: bipush 9
    //   198: invokevirtual 2014	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   201: goto +43 -> 244
    //   204: astore_1
    //   205: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +36 -> 244
    //   211: new 703	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   218: astore_2
    //   219: aload_2
    //   220: ldc_w 2670
    //   223: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload_2
    //   228: aload_1
    //   229: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: ldc_w 2672
    //   236: iconst_2
    //   237: aload_2
    //   238: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: iconst_1
    //   245: ireturn
    //   246: ldc_w 2674
    //   249: aload 4
    //   251: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   254: istore 10
    //   256: ldc_w 512
    //   259: astore_2
    //   260: iload 10
    //   262: ifeq +197 -> 459
    //   265: aload 5
    //   267: arraylength
    //   268: ifle +191 -> 459
    //   271: new 146	org/json/JSONObject
    //   274: dup
    //   275: aload 5
    //   277: iconst_0
    //   278: aaload
    //   279: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   282: astore_2
    //   283: aload_2
    //   284: ldc_w 667
    //   287: invokevirtual 2677	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   290: lstore 12
    //   292: aload_2
    //   293: ldc_w 2679
    //   296: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   299: istore 6
    //   301: aload_2
    //   302: ldc_w 2681
    //   305: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   308: astore_1
    //   309: aload_2
    //   310: ldc_w 906
    //   313: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   316: astore_2
    //   317: ldc_w 2683
    //   320: invokestatic 574	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   323: checkcast 2683	com/tencent/mobileqq/troop/utils/api/ITroopUtilsApi
    //   326: astore_3
    //   327: aload_0
    //   328: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   331: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   334: astore 4
    //   336: new 703	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   343: astore 5
    //   345: aload 5
    //   347: lload 12
    //   349: invokevirtual 713	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 5
    //   355: ldc_w 512
    //   358: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload_3
    //   363: aload 4
    //   365: aload 5
    //   367: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: bipush 9
    //   372: invokeinterface 2687 4 0
    //   377: astore_3
    //   378: aload_3
    //   379: ldc_w 2689
    //   382: aload_1
    //   383: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   386: pop
    //   387: aload_3
    //   388: ldc_w 2691
    //   391: iload 6
    //   393: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   396: pop
    //   397: aload_3
    //   398: ldc_w 906
    //   401: aload_2
    //   402: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   405: pop
    //   406: aload_0
    //   407: aload_3
    //   408: bipush 8
    //   410: invokevirtual 2014	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   413: goto -169 -> 244
    //   416: astore_1
    //   417: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   420: ifeq -176 -> 244
    //   423: new 703	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   430: astore_2
    //   431: aload_2
    //   432: ldc_w 2693
    //   435: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload_2
    //   440: aload_1
    //   441: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: ldc_w 2672
    //   448: iconst_2
    //   449: aload_2
    //   450: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: goto -212 -> 244
    //   459: ldc_w 2695
    //   462: aload 4
    //   464: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   467: ifeq +28 -> 495
    //   470: aload 5
    //   472: arraylength
    //   473: ifle +22 -> 495
    //   476: aload_0
    //   477: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   480: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   483: invokevirtual 1660	com/tencent/biz/pubaccount/CustomWebView:getContext	()Landroid/content/Context;
    //   486: aload 5
    //   488: iconst_0
    //   489: aaload
    //   490: invokestatic 2697	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   493: iconst_1
    //   494: ireturn
    //   495: ldc_w 2699
    //   498: aload 4
    //   500: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   503: ifeq +110 -> 613
    //   506: new 146	org/json/JSONObject
    //   509: dup
    //   510: aload 5
    //   512: iconst_0
    //   513: aaload
    //   514: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   517: ldc_w 2701
    //   520: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   523: astore_1
    //   524: aload_1
    //   525: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   528: ifeq +5 -> 533
    //   531: iconst_1
    //   532: ireturn
    //   533: aload_0
    //   534: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   537: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   540: astore_2
    //   541: new 162	android/content/Intent
    //   544: dup
    //   545: aload_2
    //   546: ldc_w 2592
    //   549: invokespecial 535	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   552: aconst_null
    //   553: invokestatic 2597	com/tencent/mobileqq/activity/aio/AIOUtils:a	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   556: astore_3
    //   557: aload_3
    //   558: ldc_w 2703
    //   561: aload_1
    //   562: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   565: pop
    //   566: aload_3
    //   567: ldc_w 420
    //   570: iconst_1
    //   571: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   574: pop
    //   575: aload_3
    //   576: ldc_w 2705
    //   579: iconst_1
    //   580: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   583: pop
    //   584: aload_2
    //   585: aload_3
    //   586: invokevirtual 701	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   589: goto -345 -> 244
    //   592: astore_1
    //   593: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   596: ifeq -352 -> 244
    //   599: ldc_w 283
    //   602: iconst_2
    //   603: ldc_w 2707
    //   606: aload_1
    //   607: invokestatic 2709	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   610: goto -366 -> 244
    //   613: ldc_w 2711
    //   616: aload 4
    //   618: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   621: ifeq +232 -> 853
    //   624: new 146	org/json/JSONObject
    //   627: dup
    //   628: aload 5
    //   630: iconst_0
    //   631: aaload
    //   632: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   635: astore_3
    //   636: aload_3
    //   637: ldc_w 2701
    //   640: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   643: astore 4
    //   645: aload 4
    //   647: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   650: ifeq +5 -> 655
    //   653: iconst_1
    //   654: ireturn
    //   655: aload_3
    //   656: ldc_w 2713
    //   659: ldc_w 2714
    //   662: invokestatic 2323	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   665: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   668: astore 5
    //   670: aload_3
    //   671: ldc_w 2716
    //   674: ldc_w 2718
    //   677: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   680: astore 14
    //   682: aload_0
    //   683: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   686: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   689: astore_1
    //   690: new 162	android/content/Intent
    //   693: dup
    //   694: aload_1
    //   695: ldc_w 2592
    //   698: invokespecial 535	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   701: aconst_null
    //   702: invokestatic 2597	com/tencent/mobileqq/activity/aio/AIOUtils:a	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   705: astore_2
    //   706: aload_2
    //   707: ldc_w 2703
    //   710: aload 4
    //   712: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   715: pop
    //   716: aload_2
    //   717: ldc_w 420
    //   720: iconst_1
    //   721: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   724: pop
    //   725: aload_2
    //   726: ldc_w 2713
    //   729: aload 5
    //   731: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   734: pop
    //   735: aload_2
    //   736: ldc_w 2716
    //   739: aload 14
    //   741: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   744: pop
    //   745: aload_3
    //   746: ldc 250
    //   748: iconst_0
    //   749: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   752: istore 6
    //   754: iload 6
    //   756: iconst_1
    //   757: if_icmpne +30 -> 787
    //   760: aload_3
    //   761: ldc_w 2720
    //   764: invokevirtual 1069	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   767: astore_3
    //   768: aload_3
    //   769: ifnull +45 -> 814
    //   772: aload_2
    //   773: ldc_w 2722
    //   776: aload_3
    //   777: invokevirtual 1117	org/json/JSONArray:toString	()Ljava/lang/String;
    //   780: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   783: pop
    //   784: goto +30 -> 814
    //   787: iload 6
    //   789: iconst_2
    //   790: if_icmpne +24 -> 814
    //   793: aload_2
    //   794: ldc_w 2724
    //   797: aload_3
    //   798: ldc_w 2720
    //   801: ldc_w 2725
    //   804: invokestatic 2323	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   807: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   810: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   813: pop
    //   814: aload_2
    //   815: ldc_w 2727
    //   818: iload 6
    //   820: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   823: pop
    //   824: aload_1
    //   825: aload_2
    //   826: invokevirtual 701	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   829: goto -585 -> 244
    //   832: astore_1
    //   833: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   836: ifeq -592 -> 244
    //   839: ldc_w 283
    //   842: iconst_2
    //   843: ldc_w 2729
    //   846: aload_1
    //   847: invokestatic 2709	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   850: goto -606 -> 244
    //   853: ldc_w 2731
    //   856: aload 4
    //   858: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   861: ifeq +46 -> 907
    //   864: new 146	org/json/JSONObject
    //   867: dup
    //   868: aload 5
    //   870: iconst_0
    //   871: aaload
    //   872: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   875: ldc_w 896
    //   878: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   881: astore_1
    //   882: aload_1
    //   883: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   886: ifne -642 -> 244
    //   889: aload_0
    //   890: aload_0
    //   891: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   894: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   897: aload_1
    //   898: invokestatic 2736	com/tencent/mobileqq/maproam/Utils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/app/ProgressDialog;
    //   901: putfield 2738	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   904: goto -660 -> 244
    //   907: ldc_w 2740
    //   910: aload 4
    //   912: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   915: ifeq +45 -> 960
    //   918: aload_0
    //   919: getfield 2738	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   922: astore_1
    //   923: aload_1
    //   924: ifnull -680 -> 244
    //   927: aload_1
    //   928: invokevirtual 2741	android/app/ProgressDialog:isShowing	()Z
    //   931: ifeq -687 -> 244
    //   934: aload_0
    //   935: getfield 2738	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   938: invokevirtual 2356	android/app/ProgressDialog:dismiss	()V
    //   941: goto +11 -> 952
    //   944: astore_1
    //   945: aload_0
    //   946: aconst_null
    //   947: putfield 2738	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   950: aload_1
    //   951: athrow
    //   952: aload_0
    //   953: aconst_null
    //   954: putfield 2738	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   957: goto -713 -> 244
    //   960: ldc_w 2743
    //   963: aload 4
    //   965: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   968: ifeq +83 -> 1051
    //   971: aload 5
    //   973: arraylength
    //   974: iconst_1
    //   975: if_icmpne -731 -> 244
    //   978: aload_1
    //   979: getfield 2746	com/tencent/mobileqq/webview/swift/JsBridgeListener:jdField_a_of_type_Boolean	Z
    //   982: ifeq +36 -> 1018
    //   985: aload_0
    //   986: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   989: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   992: aload_0
    //   993: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   996: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   999: aload_0
    //   1000: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1003: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1006: aload 5
    //   1008: iconst_0
    //   1009: aaload
    //   1010: iconst_1
    //   1011: iconst_0
    //   1012: invokestatic 2748	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;ZZ)V
    //   1015: goto -771 -> 244
    //   1018: aload_0
    //   1019: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1022: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1025: aload_0
    //   1026: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1029: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1032: aload_0
    //   1033: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1036: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1039: aload 5
    //   1041: iconst_0
    //   1042: aaload
    //   1043: iconst_0
    //   1044: iconst_0
    //   1045: invokestatic 2748	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;ZZ)V
    //   1048: goto -804 -> 244
    //   1051: ldc_w 2750
    //   1054: aload 4
    //   1056: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1059: ifeq +117 -> 1176
    //   1062: aload_0
    //   1063: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1066: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1069: instanceof 2752
    //   1072: ifeq +26 -> 1098
    //   1075: aload_1
    //   1076: aload_0
    //   1077: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1080: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1083: checkcast 2752	mqq/app/AppActivity
    //   1086: invokevirtual 2755	mqq/app/AppActivity:isResume	()Z
    //   1089: invokestatic 475	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1092: invokevirtual 2758	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1095: goto -851 -> 244
    //   1098: aload_0
    //   1099: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1102: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1105: instanceof 2760
    //   1108: ifeq +28 -> 1136
    //   1111: aload_1
    //   1112: aload_0
    //   1113: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1116: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1119: checkcast 2760	cooperation/qwallet/plugin/IActivity
    //   1122: invokeinterface 2761 1 0
    //   1127: invokestatic 475	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1130: invokevirtual 2758	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1133: goto -889 -> 244
    //   1136: aload_0
    //   1137: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1140: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1143: ifnonnull +25 -> 1168
    //   1146: invokestatic 2764	com/tencent/mobileqq/intervideo/yiqikan/TogetherWatchFloatingUtil:a	()Z
    //   1149: ifne +19 -> 1168
    //   1152: aload_1
    //   1153: invokestatic 2769	com/tencent/mobileqq/intervideo/yiqikan/WatchFloatingWindowController:a	()Lcom/tencent/mobileqq/intervideo/yiqikan/WatchFloatingWindowController;
    //   1156: invokevirtual 2770	com/tencent/mobileqq/intervideo/yiqikan/WatchFloatingWindowController:a	()Z
    //   1159: invokestatic 475	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1162: invokevirtual 2758	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1165: goto -921 -> 244
    //   1168: aload_1
    //   1169: aload_3
    //   1170: invokevirtual 2758	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1173: goto -929 -> 244
    //   1176: ldc_w 2772
    //   1179: aload 4
    //   1181: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1184: ifeq +51 -> 1235
    //   1187: aload 5
    //   1189: arraylength
    //   1190: iconst_1
    //   1191: if_icmpne +44 -> 1235
    //   1194: aload_0
    //   1195: new 146	org/json/JSONObject
    //   1198: dup
    //   1199: aload 5
    //   1201: iconst_0
    //   1202: aaload
    //   1203: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1206: aload_1
    //   1207: aconst_null
    //   1208: invokevirtual 1721	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Landroid/view/View$OnClickListener;)V
    //   1211: goto -967 -> 244
    //   1214: astore_1
    //   1215: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1218: ifeq -974 -> 244
    //   1221: ldc_w 283
    //   1224: iconst_2
    //   1225: ldc_w 2774
    //   1228: aload_1
    //   1229: invokestatic 2709	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1232: goto -988 -> 244
    //   1235: ldc_w 2776
    //   1238: aload 4
    //   1240: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1243: ifeq +122 -> 1365
    //   1246: aload 5
    //   1248: arraylength
    //   1249: iconst_1
    //   1250: if_icmpne +115 -> 1365
    //   1253: aload_0
    //   1254: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1257: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1260: astore_2
    //   1261: aload_2
    //   1262: ifnull +80 -> 1342
    //   1265: aload_2
    //   1266: invokevirtual 894	android/app/Activity:isFinishing	()Z
    //   1269: ifeq +5 -> 1274
    //   1272: iconst_1
    //   1273: ireturn
    //   1274: new 146	org/json/JSONObject
    //   1277: dup
    //   1278: aload 5
    //   1280: iconst_0
    //   1281: aaload
    //   1282: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1285: astore_2
    //   1286: aload_0
    //   1287: aload_2
    //   1288: ldc_w 2778
    //   1291: invokevirtual 318	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1294: invokevirtual 2780	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1297: aload_0
    //   1298: aload_2
    //   1299: ldc_w 2782
    //   1302: invokevirtual 318	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1305: aload_1
    //   1306: invokevirtual 2784	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1309: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1312: ifeq -1068 -> 244
    //   1315: ldc_w 283
    //   1318: iconst_2
    //   1319: iconst_2
    //   1320: anewarray 355	java/lang/Object
    //   1323: dup
    //   1324: iconst_0
    //   1325: ldc_w 2776
    //   1328: aastore
    //   1329: dup
    //   1330: iconst_1
    //   1331: aload_2
    //   1332: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1335: aastore
    //   1336: invokestatic 2424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1339: goto -1095 -> 244
    //   1342: iconst_1
    //   1343: ireturn
    //   1344: astore_1
    //   1345: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1348: ifeq -1104 -> 244
    //   1351: ldc_w 283
    //   1354: iconst_2
    //   1355: ldc_w 2786
    //   1358: aload_1
    //   1359: invokestatic 2709	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1362: goto -1118 -> 244
    //   1365: ldc_w 2787
    //   1368: aload 4
    //   1370: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1373: ifeq +73 -> 1446
    //   1376: aload 5
    //   1378: arraylength
    //   1379: iconst_1
    //   1380: if_icmpne +66 -> 1446
    //   1383: aload_0
    //   1384: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1387: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1390: astore_2
    //   1391: aload_2
    //   1392: ifnull +31 -> 1423
    //   1395: aload_2
    //   1396: invokevirtual 894	android/app/Activity:isFinishing	()Z
    //   1399: ifeq +5 -> 1404
    //   1402: iconst_1
    //   1403: ireturn
    //   1404: aload_0
    //   1405: new 146	org/json/JSONObject
    //   1408: dup
    //   1409: aload 5
    //   1411: iconst_0
    //   1412: aaload
    //   1413: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1416: aload_1
    //   1417: invokevirtual 2784	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1420: goto -1176 -> 244
    //   1423: iconst_1
    //   1424: ireturn
    //   1425: astore_1
    //   1426: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1429: ifeq -1185 -> 244
    //   1432: ldc_w 283
    //   1435: iconst_2
    //   1436: ldc_w 2789
    //   1439: aload_1
    //   1440: invokestatic 2709	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1443: goto -1199 -> 244
    //   1446: ldc_w 2791
    //   1449: aload 4
    //   1451: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1454: ifeq +111 -> 1565
    //   1457: aload 5
    //   1459: arraylength
    //   1460: iconst_1
    //   1461: if_icmpne +104 -> 1565
    //   1464: aload_0
    //   1465: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1468: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1471: astore_1
    //   1472: aload_1
    //   1473: ifnull +69 -> 1542
    //   1476: aload_1
    //   1477: invokevirtual 894	android/app/Activity:isFinishing	()Z
    //   1480: ifeq +5 -> 1485
    //   1483: iconst_1
    //   1484: ireturn
    //   1485: new 146	org/json/JSONObject
    //   1488: dup
    //   1489: aload 5
    //   1491: iconst_0
    //   1492: aaload
    //   1493: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1496: astore_1
    //   1497: aload_1
    //   1498: ldc_w 2793
    //   1501: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1504: istore 6
    //   1506: aload_1
    //   1507: ldc_w 2795
    //   1510: invokevirtual 348	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1513: istore 10
    //   1515: aload_1
    //   1516: ldc_w 906
    //   1519: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1522: astore_2
    //   1523: aload_0
    //   1524: iload 6
    //   1526: iload 10
    //   1528: aload_1
    //   1529: ldc_w 2797
    //   1532: invokevirtual 348	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1535: aload_2
    //   1536: invokevirtual 2799	com/tencent/mobileqq/jsp/UiApiPlugin:a	(IZZLjava/lang/String;)V
    //   1539: goto -1295 -> 244
    //   1542: iconst_1
    //   1543: ireturn
    //   1544: astore_1
    //   1545: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1548: ifeq -1304 -> 244
    //   1551: ldc_w 283
    //   1554: iconst_2
    //   1555: ldc_w 2789
    //   1558: aload_1
    //   1559: invokestatic 2709	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1562: goto -1318 -> 244
    //   1565: ldc_w 2607
    //   1568: aload 4
    //   1570: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1573: ifeq +72 -> 1645
    //   1576: aload 5
    //   1578: arraylength
    //   1579: iconst_1
    //   1580: if_icmpne +65 -> 1645
    //   1583: aload_0
    //   1584: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1587: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1590: astore_1
    //   1591: aload_1
    //   1592: ifnull +30 -> 1622
    //   1595: aload_1
    //   1596: invokevirtual 894	android/app/Activity:isFinishing	()Z
    //   1599: ifeq +5 -> 1604
    //   1602: iconst_1
    //   1603: ireturn
    //   1604: aload_0
    //   1605: new 146	org/json/JSONObject
    //   1608: dup
    //   1609: aload 5
    //   1611: iconst_0
    //   1612: aaload
    //   1613: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1616: invokevirtual 2780	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1619: goto -1375 -> 244
    //   1622: iconst_1
    //   1623: ireturn
    //   1624: astore_1
    //   1625: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1628: ifeq -1384 -> 244
    //   1631: ldc_w 283
    //   1634: iconst_2
    //   1635: ldc_w 2801
    //   1638: aload_1
    //   1639: invokestatic 2709	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1642: goto -1398 -> 244
    //   1645: ldc_w 2803
    //   1648: aload 4
    //   1650: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1653: ifeq +91 -> 1744
    //   1656: aload 5
    //   1658: arraylength
    //   1659: iconst_1
    //   1660: if_icmpne +84 -> 1744
    //   1663: aload_0
    //   1664: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1667: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1670: astore_1
    //   1671: aload_1
    //   1672: ifnull +30 -> 1702
    //   1675: aload_1
    //   1676: invokevirtual 894	android/app/Activity:isFinishing	()Z
    //   1679: ifeq +5 -> 1684
    //   1682: iconst_1
    //   1683: ireturn
    //   1684: aload_0
    //   1685: new 146	org/json/JSONObject
    //   1688: dup
    //   1689: aload 5
    //   1691: iconst_0
    //   1692: aaload
    //   1693: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1696: invokevirtual 2805	com/tencent/mobileqq/jsp/UiApiPlugin:d	(Lorg/json/JSONObject;)V
    //   1699: goto -1455 -> 244
    //   1702: iconst_1
    //   1703: ireturn
    //   1704: astore_1
    //   1705: new 703	java/lang/StringBuilder
    //   1708: dup
    //   1709: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   1712: astore_2
    //   1713: aload_2
    //   1714: ldc_w 2807
    //   1717: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1720: pop
    //   1721: aload_2
    //   1722: aload_1
    //   1723: invokestatic 2810	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1726: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1729: pop
    //   1730: ldc_w 283
    //   1733: iconst_1
    //   1734: aload_2
    //   1735: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1738: invokestatic 1130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1741: goto -1497 -> 244
    //   1744: ldc_w 1373
    //   1747: aload 4
    //   1749: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1752: ifeq +21 -> 1773
    //   1755: aload 5
    //   1757: arraylength
    //   1758: iconst_1
    //   1759: if_icmpne +14 -> 1773
    //   1762: aload_0
    //   1763: aload 5
    //   1765: iconst_0
    //   1766: aaload
    //   1767: invokevirtual 2811	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;)V
    //   1770: goto -1526 -> 244
    //   1773: ldc_w 2813
    //   1776: aload 4
    //   1778: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1781: ifeq +186 -> 1967
    //   1784: aload 5
    //   1786: arraylength
    //   1787: iconst_1
    //   1788: if_icmpne +179 -> 1967
    //   1791: new 146	org/json/JSONObject
    //   1794: dup
    //   1795: aload 5
    //   1797: iconst_0
    //   1798: aaload
    //   1799: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1802: astore_2
    //   1803: aload_2
    //   1804: ldc_w 2815
    //   1807: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1810: astore_1
    //   1811: aload_0
    //   1812: aload_2
    //   1813: ldc_w 906
    //   1816: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1819: putfield 2817	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1822: aload_0
    //   1823: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1826: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1829: ifnonnull +5 -> 1834
    //   1832: iconst_1
    //   1833: ireturn
    //   1834: aload_0
    //   1835: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1838: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1841: invokevirtual 339	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   1844: astore_3
    //   1845: new 162	android/content/Intent
    //   1848: dup
    //   1849: invokespecial 722	android/content/Intent:<init>	()V
    //   1852: ldc 187
    //   1854: ldc_w 869
    //   1857: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1860: astore_2
    //   1861: aload_1
    //   1862: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1865: ifeq +42 -> 1907
    //   1868: aload_0
    //   1869: getfield 2817	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1872: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1875: ifeq +32 -> 1907
    //   1878: aload_0
    //   1879: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1882: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1885: ifnonnull +5 -> 1890
    //   1888: iconst_1
    //   1889: ireturn
    //   1890: aload_0
    //   1891: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1894: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1897: aload_2
    //   1898: ldc_w 2819
    //   1901: invokestatic 2824	com/tencent/mobileqq/app/utils/RouteUtils:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V
    //   1904: goto -1660 -> 244
    //   1907: aload_2
    //   1908: ldc_w 2815
    //   1911: aload_1
    //   1912: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1915: ldc_w 2826
    //   1918: aload_3
    //   1919: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1922: ldc_w 2828
    //   1925: iconst_1
    //   1926: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1929: pop
    //   1930: ldc_w 2830
    //   1933: invokestatic 574	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1936: checkcast 2830	com/tencent/mobileqq/qrscan/api/IQRJumpApi
    //   1939: invokeinterface 2833 1 0
    //   1944: astore_1
    //   1945: aload_2
    //   1946: aload_0
    //   1947: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1950: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1953: aload_1
    //   1954: invokevirtual 2837	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1957: pop
    //   1958: aload_0
    //   1959: aload_2
    //   1960: iconst_3
    //   1961: invokevirtual 2014	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   1964: goto -1720 -> 244
    //   1967: ldc_w 2839
    //   1970: aload 4
    //   1972: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1975: ifeq +250 -> 2225
    //   1978: aload 5
    //   1980: arraylength
    //   1981: iconst_1
    //   1982: if_icmpne +243 -> 2225
    //   1985: new 146	org/json/JSONObject
    //   1988: dup
    //   1989: aload 5
    //   1991: iconst_0
    //   1992: aaload
    //   1993: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1996: astore 4
    //   1998: aload 4
    //   2000: ldc_w 2815
    //   2003: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2006: astore_1
    //   2007: aload 4
    //   2009: ldc_w 2841
    //   2012: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2015: astore_2
    //   2016: aload 4
    //   2018: ldc 250
    //   2020: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2023: astore_3
    //   2024: aload_0
    //   2025: aload 4
    //   2027: ldc_w 906
    //   2030: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2033: putfield 2843	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2036: aload_0
    //   2037: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2040: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   2043: ifnonnull +5 -> 2048
    //   2046: iconst_1
    //   2047: ireturn
    //   2048: aload_0
    //   2049: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2052: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   2055: invokevirtual 339	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   2058: astore 4
    //   2060: new 162	android/content/Intent
    //   2063: dup
    //   2064: aload_0
    //   2065: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2068: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2071: ldc_w 2845
    //   2074: invokespecial 535	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2077: ldc_w 2847
    //   2080: iconst_4
    //   2081: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2084: ldc_w 2848
    //   2087: invokevirtual 655	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2090: astore 5
    //   2092: aload_1
    //   2093: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2096: ifeq +40 -> 2136
    //   2099: aload_0
    //   2100: getfield 2843	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2103: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2106: ifeq +30 -> 2136
    //   2109: aload_0
    //   2110: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2113: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2116: ifnonnull +5 -> 2121
    //   2119: iconst_1
    //   2120: ireturn
    //   2121: aload_0
    //   2122: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2125: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2128: aload 5
    //   2130: invokevirtual 701	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   2133: goto -1889 -> 244
    //   2136: aload 5
    //   2138: ldc_w 2815
    //   2141: aload_1
    //   2142: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2145: ldc 250
    //   2147: aload_3
    //   2148: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2151: ldc_w 2841
    //   2154: aload_2
    //   2155: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2158: ldc_w 2826
    //   2161: aload 4
    //   2163: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2166: ldc_w 2828
    //   2169: iconst_1
    //   2170: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2173: pop
    //   2174: aload_0
    //   2175: aload 5
    //   2177: bipush 17
    //   2179: invokevirtual 2014	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2182: goto -1938 -> 244
    //   2185: astore_1
    //   2186: new 703	java/lang/StringBuilder
    //   2189: dup
    //   2190: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   2193: astore_2
    //   2194: aload_2
    //   2195: ldc_w 2850
    //   2198: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2201: pop
    //   2202: aload_2
    //   2203: aload_1
    //   2204: invokevirtual 1144	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2207: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2210: pop
    //   2211: ldc_w 283
    //   2214: iconst_1
    //   2215: aload_2
    //   2216: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2219: invokestatic 1130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2222: goto -1978 -> 244
    //   2225: ldc_w 2852
    //   2228: aload 4
    //   2230: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2233: ifeq +105 -> 2338
    //   2236: aload 5
    //   2238: arraylength
    //   2239: iconst_1
    //   2240: if_icmpne +98 -> 2338
    //   2243: new 146	org/json/JSONObject
    //   2246: dup
    //   2247: aload 5
    //   2249: iconst_0
    //   2250: aaload
    //   2251: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2254: ldc_w 906
    //   2257: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2260: astore_1
    //   2261: aload_0
    //   2262: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2265: aload_0
    //   2266: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2269: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2272: invokevirtual 1426	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2275: astore_2
    //   2276: aload_2
    //   2277: ifnull +26 -> 2303
    //   2280: aload_2
    //   2281: instanceof 2148
    //   2284: ifeq +19 -> 2303
    //   2287: aload_2
    //   2288: checkcast 2148	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2291: invokeinterface 2151 1 0
    //   2296: checkcast 2153	com/tencent/biz/webviewplugin/Share
    //   2299: aload_1
    //   2300: putfield 2855	com/tencent/biz/webviewplugin/Share:v	Ljava/lang/String;
    //   2303: aload_1
    //   2304: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2307: ifne -2063 -> 244
    //   2310: aload_0
    //   2311: iconst_2
    //   2312: invokevirtual 2856	com/tencent/mobileqq/jsp/UiApiPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   2315: checkcast 1740	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   2318: astore_1
    //   2319: aload_1
    //   2320: ifnull -2076 -> 244
    //   2323: aload_1
    //   2324: invokevirtual 2858	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:h	()V
    //   2327: goto -2083 -> 244
    //   2330: astore_1
    //   2331: aload_1
    //   2332: invokevirtual 2859	org/json/JSONException:printStackTrace	()V
    //   2335: goto -2091 -> 244
    //   2338: ldc_w 2861
    //   2341: aload 4
    //   2343: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2346: ifeq +42 -> 2388
    //   2349: aload 5
    //   2351: arraylength
    //   2352: iconst_1
    //   2353: if_icmpne +35 -> 2388
    //   2356: aload_0
    //   2357: new 146	org/json/JSONObject
    //   2360: dup
    //   2361: aload 5
    //   2363: iconst_0
    //   2364: aaload
    //   2365: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2368: ldc_w 906
    //   2371: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2374: putfield 98	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2377: goto -2133 -> 244
    //   2380: astore_1
    //   2381: aload_1
    //   2382: invokevirtual 2859	org/json/JSONException:printStackTrace	()V
    //   2385: goto -2141 -> 244
    //   2388: ldc_w 2863
    //   2391: aload 4
    //   2393: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2396: ifeq +92 -> 2488
    //   2399: aload 5
    //   2401: arraylength
    //   2402: iconst_1
    //   2403: if_icmpne +85 -> 2488
    //   2406: new 146	org/json/JSONObject
    //   2409: dup
    //   2410: aload 5
    //   2412: iconst_0
    //   2413: aaload
    //   2414: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2417: ldc_w 906
    //   2420: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2423: astore_1
    //   2424: aload_0
    //   2425: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2428: aload_0
    //   2429: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2432: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2435: invokevirtual 1426	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2438: astore_2
    //   2439: aload_2
    //   2440: ifnull +29 -> 2469
    //   2443: aload_2
    //   2444: instanceof 2148
    //   2447: ifeq +22 -> 2469
    //   2450: aload_2
    //   2451: checkcast 2148	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2454: invokeinterface 2151 1 0
    //   2459: checkcast 2153	com/tencent/biz/webviewplugin/Share
    //   2462: aload_1
    //   2463: invokevirtual 2864	com/tencent/biz/webviewplugin/Share:a	(Ljava/lang/String;)V
    //   2466: goto -2222 -> 244
    //   2469: aload_0
    //   2470: invokespecial 2865	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/share/WebShare;
    //   2473: aload_1
    //   2474: invokevirtual 2866	com/tencent/share/WebShare:a	(Ljava/lang/String;)V
    //   2477: goto -2233 -> 244
    //   2480: astore_1
    //   2481: aload_1
    //   2482: invokevirtual 2859	org/json/JSONException:printStackTrace	()V
    //   2485: goto -2241 -> 244
    //   2488: ldc_w 2868
    //   2491: aload 4
    //   2493: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2496: ifeq +125 -> 2621
    //   2499: aload 5
    //   2501: arraylength
    //   2502: iconst_1
    //   2503: if_icmpne +118 -> 2621
    //   2506: new 146	org/json/JSONObject
    //   2509: dup
    //   2510: aload 5
    //   2512: iconst_0
    //   2513: aaload
    //   2514: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2517: ldc_w 906
    //   2520: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2523: astore_1
    //   2524: aload_0
    //   2525: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2528: aload_0
    //   2529: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2532: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2535: invokevirtual 1426	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2538: astore_2
    //   2539: aload_2
    //   2540: ifnull +29 -> 2569
    //   2543: aload_2
    //   2544: instanceof 2148
    //   2547: ifeq +22 -> 2569
    //   2550: aload_2
    //   2551: checkcast 2148	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2554: invokeinterface 2151 1 0
    //   2559: checkcast 2153	com/tencent/biz/webviewplugin/Share
    //   2562: aload_1
    //   2563: putfield 2871	com/tencent/biz/webviewplugin/Share:q	Ljava/lang/String;
    //   2566: goto +19 -> 2585
    //   2569: aload_0
    //   2570: invokespecial 2865	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/share/WebShare;
    //   2573: aload_1
    //   2574: invokevirtual 2873	com/tencent/share/WebShare:b	(Ljava/lang/String;)V
    //   2577: goto +8 -> 2585
    //   2580: astore_1
    //   2581: aload_1
    //   2582: invokevirtual 2859	org/json/JSONException:printStackTrace	()V
    //   2585: aconst_null
    //   2586: ldc_w 865
    //   2589: ldc_w 2875
    //   2592: ldc_w 512
    //   2595: ldc_w 2877
    //   2598: ldc_w 2877
    //   2601: iconst_0
    //   2602: iconst_0
    //   2603: ldc_w 512
    //   2606: ldc_w 512
    //   2609: ldc_w 512
    //   2612: ldc_w 512
    //   2615: invokestatic 1532	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2618: goto -2374 -> 244
    //   2621: ldc_w 2879
    //   2624: aload 4
    //   2626: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2629: ifeq +92 -> 2721
    //   2632: aload 5
    //   2634: arraylength
    //   2635: iconst_1
    //   2636: if_icmpne +85 -> 2721
    //   2639: new 146	org/json/JSONObject
    //   2642: dup
    //   2643: aload 5
    //   2645: iconst_0
    //   2646: aaload
    //   2647: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2650: ldc_w 906
    //   2653: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2656: astore_1
    //   2657: aload_0
    //   2658: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2661: aload_0
    //   2662: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2665: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2668: invokevirtual 1426	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2671: astore_2
    //   2672: aload_2
    //   2673: ifnull +29 -> 2702
    //   2676: aload_2
    //   2677: instanceof 2148
    //   2680: ifeq +22 -> 2702
    //   2683: aload_2
    //   2684: checkcast 2148	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2687: invokeinterface 2151 1 0
    //   2692: checkcast 2153	com/tencent/biz/webviewplugin/Share
    //   2695: aload_1
    //   2696: putfield 2882	com/tencent/biz/webviewplugin/Share:r	Ljava/lang/String;
    //   2699: goto -2455 -> 244
    //   2702: aload_0
    //   2703: invokespecial 2865	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/share/WebShare;
    //   2706: aload_1
    //   2707: invokevirtual 2884	com/tencent/share/WebShare:c	(Ljava/lang/String;)V
    //   2710: goto -2466 -> 244
    //   2713: astore_1
    //   2714: aload_1
    //   2715: invokevirtual 2859	org/json/JSONException:printStackTrace	()V
    //   2718: goto -2474 -> 244
    //   2721: ldc_w 2886
    //   2724: aload 4
    //   2726: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2729: ifeq +125 -> 2854
    //   2732: aload 5
    //   2734: arraylength
    //   2735: iconst_1
    //   2736: if_icmpne +118 -> 2854
    //   2739: new 146	org/json/JSONObject
    //   2742: dup
    //   2743: aload 5
    //   2745: iconst_0
    //   2746: aaload
    //   2747: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2750: ldc_w 906
    //   2753: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2756: astore_1
    //   2757: aload_0
    //   2758: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2761: aload_0
    //   2762: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2765: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2768: invokevirtual 1426	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2771: astore_2
    //   2772: aload_2
    //   2773: ifnull +29 -> 2802
    //   2776: aload_2
    //   2777: instanceof 2148
    //   2780: ifeq +22 -> 2802
    //   2783: aload_2
    //   2784: checkcast 2148	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2787: invokeinterface 2151 1 0
    //   2792: checkcast 2153	com/tencent/biz/webviewplugin/Share
    //   2795: aload_1
    //   2796: putfield 2889	com/tencent/biz/webviewplugin/Share:s	Ljava/lang/String;
    //   2799: goto +19 -> 2818
    //   2802: aload_0
    //   2803: invokespecial 2865	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/share/WebShare;
    //   2806: aload_1
    //   2807: invokevirtual 2891	com/tencent/share/WebShare:d	(Ljava/lang/String;)V
    //   2810: goto +8 -> 2818
    //   2813: astore_1
    //   2814: aload_1
    //   2815: invokevirtual 2859	org/json/JSONException:printStackTrace	()V
    //   2818: aconst_null
    //   2819: ldc_w 865
    //   2822: ldc_w 2875
    //   2825: ldc_w 512
    //   2828: ldc_w 2893
    //   2831: ldc_w 2893
    //   2834: iconst_0
    //   2835: iconst_0
    //   2836: ldc_w 512
    //   2839: ldc_w 512
    //   2842: ldc_w 512
    //   2845: ldc_w 512
    //   2848: invokestatic 1532	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2851: goto -2607 -> 244
    //   2854: ldc_w 2895
    //   2857: aload 4
    //   2859: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2862: ifeq +125 -> 2987
    //   2865: aload 5
    //   2867: arraylength
    //   2868: iconst_1
    //   2869: if_icmpne +118 -> 2987
    //   2872: new 146	org/json/JSONObject
    //   2875: dup
    //   2876: aload 5
    //   2878: iconst_0
    //   2879: aaload
    //   2880: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2883: ldc_w 906
    //   2886: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2889: astore_1
    //   2890: aload_0
    //   2891: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2894: aload_0
    //   2895: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2898: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2901: invokevirtual 1426	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   2904: astore_2
    //   2905: aload_2
    //   2906: ifnull +29 -> 2935
    //   2909: aload_2
    //   2910: instanceof 2148
    //   2913: ifeq +22 -> 2935
    //   2916: aload_2
    //   2917: checkcast 2148	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   2920: invokeinterface 2151 1 0
    //   2925: checkcast 2153	com/tencent/biz/webviewplugin/Share
    //   2928: aload_1
    //   2929: putfield 2898	com/tencent/biz/webviewplugin/Share:t	Ljava/lang/String;
    //   2932: goto +19 -> 2951
    //   2935: aload_0
    //   2936: invokespecial 2865	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/share/WebShare;
    //   2939: aload_1
    //   2940: invokevirtual 2900	com/tencent/share/WebShare:e	(Ljava/lang/String;)V
    //   2943: goto +8 -> 2951
    //   2946: astore_1
    //   2947: aload_1
    //   2948: invokevirtual 2859	org/json/JSONException:printStackTrace	()V
    //   2951: aconst_null
    //   2952: ldc_w 865
    //   2955: ldc_w 2875
    //   2958: ldc_w 512
    //   2961: ldc_w 2902
    //   2964: ldc_w 2902
    //   2967: iconst_0
    //   2968: iconst_0
    //   2969: ldc_w 512
    //   2972: ldc_w 512
    //   2975: ldc_w 512
    //   2978: ldc_w 512
    //   2981: invokestatic 1532	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2984: goto -2740 -> 244
    //   2987: ldc_w 2904
    //   2990: aload 4
    //   2992: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2995: ifeq +125 -> 3120
    //   2998: aload 5
    //   3000: arraylength
    //   3001: iconst_1
    //   3002: if_icmpne +118 -> 3120
    //   3005: new 146	org/json/JSONObject
    //   3008: dup
    //   3009: aload 5
    //   3011: iconst_0
    //   3012: aaload
    //   3013: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3016: ldc_w 906
    //   3019: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3022: astore_1
    //   3023: aload_0
    //   3024: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3027: aload_0
    //   3028: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3031: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3034: invokevirtual 1426	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   3037: astore_2
    //   3038: aload_2
    //   3039: ifnull +29 -> 3068
    //   3042: aload_2
    //   3043: instanceof 2148
    //   3046: ifeq +22 -> 3068
    //   3049: aload_2
    //   3050: checkcast 2148	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebShareInterface
    //   3053: invokeinterface 2151 1 0
    //   3058: checkcast 2153	com/tencent/biz/webviewplugin/Share
    //   3061: aload_1
    //   3062: putfield 2907	com/tencent/biz/webviewplugin/Share:u	Ljava/lang/String;
    //   3065: goto +19 -> 3084
    //   3068: aload_0
    //   3069: invokespecial 2865	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/share/WebShare;
    //   3072: aload_1
    //   3073: invokevirtual 2909	com/tencent/share/WebShare:f	(Ljava/lang/String;)V
    //   3076: goto +8 -> 3084
    //   3079: astore_1
    //   3080: aload_1
    //   3081: invokevirtual 2859	org/json/JSONException:printStackTrace	()V
    //   3084: aconst_null
    //   3085: ldc_w 865
    //   3088: ldc_w 2875
    //   3091: ldc_w 512
    //   3094: ldc_w 2911
    //   3097: ldc_w 2911
    //   3100: iconst_0
    //   3101: iconst_0
    //   3102: ldc_w 512
    //   3105: ldc_w 512
    //   3108: ldc_w 512
    //   3111: ldc_w 512
    //   3114: invokestatic 1532	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3117: goto -2873 -> 244
    //   3120: ldc_w 2913
    //   3123: aload 4
    //   3125: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3128: ifeq +74 -> 3202
    //   3131: aload 5
    //   3133: arraylength
    //   3134: iconst_1
    //   3135: if_icmpne +67 -> 3202
    //   3138: new 146	org/json/JSONObject
    //   3141: dup
    //   3142: aload 5
    //   3144: iconst_0
    //   3145: aaload
    //   3146: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3149: astore_1
    //   3150: aload_1
    //   3151: ldc_w 906
    //   3154: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3157: astore_3
    //   3158: new 2915	com/tencent/mobileqq/jsp/UiApiPlugin$2
    //   3161: dup
    //   3162: aload_0
    //   3163: aload_3
    //   3164: invokespecial 2916	com/tencent/mobileqq/jsp/UiApiPlugin$2:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   3167: astore_2
    //   3168: new 2918	com/tencent/mobileqq/jsp/UiApiPlugin$3
    //   3171: dup
    //   3172: aload_0
    //   3173: aload_3
    //   3174: invokespecial 2919	com/tencent/mobileqq/jsp/UiApiPlugin$3:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   3177: astore_3
    //   3178: aload_0
    //   3179: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3182: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3185: aload_1
    //   3186: aload_2
    //   3187: aload_2
    //   3188: aload_3
    //   3189: invokestatic 2921	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Lorg/json/JSONObject;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnCancelListener;)V
    //   3192: iconst_1
    //   3193: ireturn
    //   3194: astore_1
    //   3195: aload_1
    //   3196: invokevirtual 2859	org/json/JSONException:printStackTrace	()V
    //   3199: goto -2955 -> 244
    //   3202: ldc_w 2923
    //   3205: aload 4
    //   3207: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3210: ifeq +404 -> 3614
    //   3213: aload 5
    //   3215: arraylength
    //   3216: iconst_1
    //   3217: if_icmpne +397 -> 3614
    //   3220: new 146	org/json/JSONObject
    //   3223: dup
    //   3224: aload 5
    //   3226: iconst_0
    //   3227: aaload
    //   3228: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3231: astore_2
    //   3232: aload_2
    //   3233: ldc_w 2925
    //   3236: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3239: astore_3
    //   3240: aload_2
    //   3241: ldc_w 2927
    //   3244: invokevirtual 318	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3247: astore_2
    //   3248: ldc_w 2929
    //   3251: aload_3
    //   3252: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3255: ifeq +76 -> 3331
    //   3258: aload_2
    //   3259: ldc_w 2651
    //   3262: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3265: astore_2
    //   3266: aload_2
    //   3267: invokestatic 2658	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3270: ifeq +51 -> 3321
    //   3273: new 162	android/content/Intent
    //   3276: dup
    //   3277: invokespecial 722	android/content/Intent:<init>	()V
    //   3280: astore_3
    //   3281: aload_3
    //   3282: getstatic 2932	cooperation/troop/TroopFileProxyActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3285: aload_2
    //   3286: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3289: pop
    //   3290: aload_0
    //   3291: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3294: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3297: aload_3
    //   3298: aload_0
    //   3299: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3302: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   3305: invokevirtual 2043	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3308: invokestatic 2935	cooperation/troop/TroopFileProxyActivity:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)V
    //   3311: aload_1
    //   3312: ldc_w 2937
    //   3315: invokevirtual 2758	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3318: goto -3074 -> 244
    //   3321: aload_1
    //   3322: ldc_w 2939
    //   3325: invokevirtual 2758	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3328: goto -3084 -> 244
    //   3331: ldc_w 2941
    //   3334: aload_3
    //   3335: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3338: ifeq +71 -> 3409
    //   3341: aload_2
    //   3342: ldc_w 2651
    //   3345: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3348: astore_2
    //   3349: aload_2
    //   3350: invokestatic 2658	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3353: ifeq +46 -> 3399
    //   3356: invokestatic 2946	cooperation/qzone/QZoneHelper$UserInfo:getInstance	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   3359: astore_3
    //   3360: aload_3
    //   3361: aload_0
    //   3362: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3365: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   3368: invokevirtual 2043	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3371: putfield 2949	cooperation/qzone/QZoneHelper$UserInfo:qzone_uin	Ljava/lang/String;
    //   3374: aload_0
    //   3375: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3378: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3381: aload_3
    //   3382: aload_2
    //   3383: aconst_null
    //   3384: iconst_0
    //   3385: iconst_0
    //   3386: invokestatic 2955	cooperation/qzone/QZoneHelper:forwardToQunFeed	(Landroid/app/Activity;Lcooperation/qzone/QZoneHelper$UserInfo;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   3389: aload_1
    //   3390: ldc_w 2937
    //   3393: invokevirtual 2758	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3396: goto -3152 -> 244
    //   3399: aload_1
    //   3400: ldc_w 2939
    //   3403: invokevirtual 2758	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3406: goto -3162 -> 244
    //   3409: ldc_w 2957
    //   3412: aload_3
    //   3413: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3416: ifeq +66 -> 3482
    //   3419: aload_0
    //   3420: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3423: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3426: astore_3
    //   3427: aload_2
    //   3428: ldc_w 2651
    //   3431: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3434: astore_2
    //   3435: aload_3
    //   3436: ifnull -3192 -> 244
    //   3439: aload_2
    //   3440: invokestatic 2658	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3443: ifeq -3199 -> 244
    //   3446: new 162	android/content/Intent
    //   3449: dup
    //   3450: aload_3
    //   3451: ldc_w 2959
    //   3454: invokespecial 535	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3457: astore 4
    //   3459: aload 4
    //   3461: ldc_w 2061
    //   3464: aload_2
    //   3465: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3468: pop
    //   3469: aload_3
    //   3470: aload 4
    //   3472: invokevirtual 701	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3475: aload_3
    //   3476: invokevirtual 795	android/app/Activity:finish	()V
    //   3479: goto -3235 -> 244
    //   3482: ldc_w 2961
    //   3485: aload_3
    //   3486: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3489: ifeq -3245 -> 244
    //   3492: aload_0
    //   3493: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3496: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3499: astore_3
    //   3500: aload_2
    //   3501: ldc_w 2651
    //   3504: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3507: astore 4
    //   3509: aload_2
    //   3510: ldc_w 2653
    //   3513: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3516: astore_2
    //   3517: aload_3
    //   3518: ifnull -3274 -> 244
    //   3521: aload 4
    //   3523: invokestatic 2658	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3526: ifeq -3282 -> 244
    //   3529: aload_2
    //   3530: invokestatic 2658	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3533: ifeq -3289 -> 244
    //   3536: ldc_w 2660
    //   3539: invokestatic 574	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3542: checkcast 2660	com/tencent/mobileqq/profilecard/api/IProfileCardApi
    //   3545: aload_3
    //   3546: aconst_null
    //   3547: invokeinterface 2664 3 0
    //   3552: astore 5
    //   3554: aload 5
    //   3556: ldc_w 2061
    //   3559: aload 4
    //   3561: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3564: pop
    //   3565: aload 5
    //   3567: ldc_w 2653
    //   3570: aload_2
    //   3571: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3574: pop
    //   3575: aload_3
    //   3576: aload 5
    //   3578: invokevirtual 701	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3581: goto -3337 -> 244
    //   3584: astore_2
    //   3585: aload_2
    //   3586: invokevirtual 970	java/lang/Exception:printStackTrace	()V
    //   3589: aload_1
    //   3590: ldc_w 2939
    //   3593: invokevirtual 2758	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3596: goto -3352 -> 244
    //   3599: astore_2
    //   3600: aload_2
    //   3601: invokevirtual 2859	org/json/JSONException:printStackTrace	()V
    //   3604: aload_1
    //   3605: ldc_w 2939
    //   3608: invokevirtual 2758	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3611: goto -3367 -> 244
    //   3614: ldc_w 2962
    //   3617: aload 4
    //   3619: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3622: ifeq +705 -> 4327
    //   3625: aload 5
    //   3627: arraylength
    //   3628: iconst_1
    //   3629: if_icmpne +698 -> 4327
    //   3632: aload_0
    //   3633: ldc_w 512
    //   3636: putfield 2964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   3639: new 146	org/json/JSONObject
    //   3642: dup
    //   3643: aload 5
    //   3645: iconst_0
    //   3646: aaload
    //   3647: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3650: astore_1
    //   3651: goto +5 -> 3656
    //   3654: aconst_null
    //   3655: astore_1
    //   3656: aload_1
    //   3657: ifnull +651 -> 4308
    //   3660: aload_0
    //   3661: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3664: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3667: astore 4
    //   3669: aload_1
    //   3670: ldc_w 2966
    //   3673: ldc_w 2968
    //   3676: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3679: astore 15
    //   3681: aload_1
    //   3682: ldc_w 2815
    //   3685: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3688: astore 5
    //   3690: aload_1
    //   3691: ldc_w 314
    //   3694: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3697: astore 16
    //   3699: aload_1
    //   3700: ldc_w 2970
    //   3703: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3706: astore 14
    //   3708: aload_1
    //   3709: ldc_w 906
    //   3712: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3715: astore_3
    //   3716: aload_1
    //   3717: ldc_w 732
    //   3720: iconst_m1
    //   3721: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3724: istore 6
    //   3726: new 146	org/json/JSONObject
    //   3729: dup
    //   3730: aload 16
    //   3732: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3735: astore_1
    //   3736: goto +11 -> 3747
    //   3739: new 146	org/json/JSONObject
    //   3742: dup
    //   3743: invokespecial 248	org/json/JSONObject:<init>	()V
    //   3746: astore_1
    //   3747: aload_0
    //   3748: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3751: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   3754: astore 16
    //   3756: aload 16
    //   3758: ifnull +16 -> 3774
    //   3761: aload_1
    //   3762: ldc_w 2972
    //   3765: aload 16
    //   3767: invokevirtual 2973	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   3770: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3773: pop
    //   3774: ldc_w 2975
    //   3777: aload 15
    //   3779: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3782: ifeq +95 -> 3877
    //   3785: new 379	android/os/Bundle
    //   3788: dup
    //   3789: invokespecial 380	android/os/Bundle:<init>	()V
    //   3792: astore_3
    //   3793: aload_3
    //   3794: ldc_w 314
    //   3797: aload_1
    //   3798: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3801: invokevirtual 515	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3804: aload_3
    //   3805: ldc_w 2970
    //   3808: aload 14
    //   3810: invokevirtual 515	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3813: ldc_w 2977
    //   3816: aload 5
    //   3818: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3821: ifeq +24 -> 3845
    //   3824: new 2979	com/tencent/mobileqq/troop/activity/PublicCommentWindow
    //   3827: dup
    //   3828: aload 4
    //   3830: checkcast 2981	com/tencent/mobileqq/app/QBaseActivity
    //   3833: aload_3
    //   3834: invokespecial 2984	com/tencent/mobileqq/troop/activity/PublicCommentWindow:<init>	(Lcom/tencent/mobileqq/app/QBaseActivity;Landroid/os/Bundle;)V
    //   3837: aload 4
    //   3839: invokevirtual 2986	com/tencent/mobileqq/troop/activity/PublicCommentWindow:a	(Landroid/app/Activity;)V
    //   3842: goto -3598 -> 244
    //   3845: ldc_w 2988
    //   3848: aload 5
    //   3850: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3853: ifeq -3609 -> 244
    //   3856: new 2990	com/tencent/mobileqq/troop/activity/TroopBarCommentWindow
    //   3859: dup
    //   3860: aload 4
    //   3862: checkcast 2981	com/tencent/mobileqq/app/QBaseActivity
    //   3865: aload_3
    //   3866: invokespecial 2991	com/tencent/mobileqq/troop/activity/TroopBarCommentWindow:<init>	(Lcom/tencent/mobileqq/app/QBaseActivity;Landroid/os/Bundle;)V
    //   3869: aload 4
    //   3871: invokevirtual 2992	com/tencent/mobileqq/troop/activity/TroopBarCommentWindow:a	(Landroid/app/Activity;)V
    //   3874: goto -3630 -> 244
    //   3877: ldc_w 2968
    //   3880: aload 15
    //   3882: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3885: ifeq +336 -> 4221
    //   3888: new 162	android/content/Intent
    //   3891: dup
    //   3892: invokespecial 722	android/content/Intent:<init>	()V
    //   3895: astore 15
    //   3897: ldc_w 2994
    //   3900: aload 5
    //   3902: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3905: ifeq +38 -> 3943
    //   3908: aload 15
    //   3910: new 2996	android/content/ComponentName
    //   3913: dup
    //   3914: aload_0
    //   3915: invokevirtual 2186	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   3918: ldc_w 2998
    //   3921: invokespecial 2999	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   3924: invokevirtual 3003	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   3927: pop
    //   3928: aload 15
    //   3930: ldc_w 3005
    //   3933: invokestatic 448	java/lang/System:currentTimeMillis	()J
    //   3936: invokevirtual 673	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   3939: pop
    //   3940: goto +150 -> 4090
    //   3943: ldc_w 3007
    //   3946: aload 5
    //   3948: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3951: ifeq +79 -> 4030
    //   3954: aload 15
    //   3956: new 2996	android/content/ComponentName
    //   3959: dup
    //   3960: aload 4
    //   3962: aload 5
    //   3964: invokespecial 2999	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   3967: invokevirtual 3003	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   3970: pop
    //   3971: aload 15
    //   3973: ldc_w 3009
    //   3976: iconst_0
    //   3977: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3980: pop
    //   3981: aload 15
    //   3983: ldc_w 442
    //   3986: invokestatic 448	java/lang/System:currentTimeMillis	()J
    //   3989: invokevirtual 673	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   3992: pop
    //   3993: aload 15
    //   3995: getstatic 3013	cooperation/qqindividuality/QQIndividualityUtils:l	Ljava/lang/String;
    //   3998: iconst_1
    //   3999: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   4002: pop
    //   4003: aload 15
    //   4005: getstatic 3014	cooperation/qqindividuality/QQIndividualityUtils:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   4008: ldc_w 2440
    //   4011: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4014: pop
    //   4015: aload 15
    //   4017: getstatic 3015	cooperation/qqindividuality/QQIndividualityUtils:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4020: ldc_w 2815
    //   4023: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4026: pop
    //   4027: goto +63 -> 4090
    //   4030: ldc_w 3017
    //   4033: aload 5
    //   4035: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4038: ifeq +35 -> 4073
    //   4041: aload 15
    //   4043: new 2996	android/content/ComponentName
    //   4046: dup
    //   4047: aload 4
    //   4049: aload 5
    //   4051: invokespecial 2999	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4054: invokevirtual 3003	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4057: pop
    //   4058: aload 15
    //   4060: ldc_w 3019
    //   4063: ldc_w 2194
    //   4066: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4069: pop
    //   4070: goto +20 -> 4090
    //   4073: aload 15
    //   4075: new 2996	android/content/ComponentName
    //   4078: dup
    //   4079: aload 4
    //   4081: aload 5
    //   4083: invokespecial 2999	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4086: invokevirtual 3003	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4089: pop
    //   4090: aload 15
    //   4092: ldc_w 314
    //   4095: aload_1
    //   4096: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4099: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4102: pop
    //   4103: aload_0
    //   4104: aload 14
    //   4106: putfield 2964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4109: aload 14
    //   4111: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4114: ifeq +13 -> 4127
    //   4117: aload 4
    //   4119: aload 15
    //   4121: invokevirtual 701	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   4124: goto +13911 -> 18035
    //   4127: aload_0
    //   4128: aload 15
    //   4130: iconst_4
    //   4131: invokevirtual 2014	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   4134: aload_3
    //   4135: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4138: ifne +13897 -> 18035
    //   4141: aload_0
    //   4142: aload_3
    //   4143: iconst_1
    //   4144: anewarray 363	java/lang/String
    //   4147: dup
    //   4148: iconst_0
    //   4149: ldc_w 1371
    //   4152: aastore
    //   4153: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4156: goto +13879 -> 18035
    //   4159: aload 4
    //   4161: ldc_w 3020
    //   4164: ldc_w 3021
    //   4167: invokevirtual 737	android/app/Activity:overridePendingTransition	(II)V
    //   4170: ldc_w 3023
    //   4173: invokevirtual 175	java/lang/Class:getName	()Ljava/lang/String;
    //   4176: aload 5
    //   4178: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4181: ifeq -3937 -> 244
    //   4184: aload_0
    //   4185: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4188: ifnonnull +17 -> 4205
    //   4191: aload_0
    //   4192: invokestatic 2027	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4195: putfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4198: aload_0
    //   4199: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4202: invokevirtual 2029	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   4205: aload_0
    //   4206: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4209: invokevirtual 3025	com/tencent/biz/troop/TroopMemberApiClient:c	()V
    //   4212: goto -3968 -> 244
    //   4215: astore_1
    //   4216: aload_3
    //   4217: astore_2
    //   4218: goto +38 -> 4256
    //   4221: ldc_w 3027
    //   4224: aload 15
    //   4226: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4229: ifeq -3985 -> 244
    //   4232: aload 5
    //   4234: ldc_w 3029
    //   4237: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4240: ifeq -3996 -> 244
    //   4243: aload_1
    //   4244: ldc_w 3031
    //   4247: iconst_0
    //   4248: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4251: pop
    //   4252: goto -4008 -> 244
    //   4255: astore_1
    //   4256: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4259: ifeq +24 -> 4283
    //   4262: ldc_w 283
    //   4265: iconst_2
    //   4266: ldc_w 3033
    //   4269: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4272: ldc_w 283
    //   4275: iconst_2
    //   4276: aload_1
    //   4277: invokestatic 1185	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4280: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4283: aload_2
    //   4284: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4287: ifne -4043 -> 244
    //   4290: aload_0
    //   4291: aload_2
    //   4292: iconst_1
    //   4293: anewarray 363	java/lang/String
    //   4296: dup
    //   4297: iconst_0
    //   4298: ldc_w 3035
    //   4301: aastore
    //   4302: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4305: goto -4061 -> 244
    //   4308: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4311: ifeq -4067 -> 244
    //   4314: ldc_w 283
    //   4317: iconst_2
    //   4318: ldc_w 3037
    //   4321: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4324: goto -4080 -> 244
    //   4327: ldc_w 3039
    //   4330: aload 4
    //   4332: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4335: ifeq +2073 -> 6408
    //   4338: aload 5
    //   4340: arraylength
    //   4341: iconst_1
    //   4342: if_icmpne +2066 -> 6408
    //   4345: new 146	org/json/JSONObject
    //   4348: dup
    //   4349: aload 5
    //   4351: iconst_0
    //   4352: aaload
    //   4353: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4356: astore_2
    //   4357: aload_0
    //   4358: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4361: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   4364: astore 14
    //   4366: aload 14
    //   4368: instanceof 532
    //   4371: ifne +5 -> 4376
    //   4374: iconst_1
    //   4375: ireturn
    //   4376: aload_0
    //   4377: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4380: invokevirtual 1431	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   4383: checkcast 1867	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   4386: astore 4
    //   4388: aload_0
    //   4389: iconst_2
    //   4390: invokespecial 1738	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   4393: checkcast 1740	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   4396: astore 5
    //   4398: aload 4
    //   4400: ifnull +1920 -> 6320
    //   4403: aload 5
    //   4405: ifnonnull +6 -> 4411
    //   4408: goto +1912 -> 6320
    //   4411: aload_2
    //   4412: ldc_w 3041
    //   4415: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4418: ifeq +105 -> 4523
    //   4421: aload_2
    //   4422: ldc_w 3043
    //   4425: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4428: ifeq +95 -> 4523
    //   4431: aload_2
    //   4432: ldc_w 3043
    //   4435: invokevirtual 348	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   4438: ifeq +85 -> 4523
    //   4441: aload_2
    //   4442: ldc_w 3041
    //   4445: invokestatic 3045	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   4448: istore 6
    //   4450: aload 5
    //   4452: ifnull +28 -> 4480
    //   4455: aload 5
    //   4457: getfield 3047	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:c	Landroid/view/View;
    //   4460: ifnull +20 -> 4480
    //   4463: aload 5
    //   4465: iload 6
    //   4467: putfield 3048	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_Int	I
    //   4470: aload 5
    //   4472: getfield 3047	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:c	Landroid/view/View;
    //   4475: iload 6
    //   4477: invokevirtual 3049	android/view/View:setBackgroundColor	(I)V
    //   4480: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4483: ifeq +40 -> 4523
    //   4486: new 703	java/lang/StringBuilder
    //   4489: dup
    //   4490: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   4493: astore_1
    //   4494: aload_1
    //   4495: ldc_w 3051
    //   4498: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4501: pop
    //   4502: aload_1
    //   4503: iload 6
    //   4505: invokestatic 3054	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   4508: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4511: pop
    //   4512: ldc_w 283
    //   4515: iconst_2
    //   4516: aload_1
    //   4517: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4520: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4523: aload_2
    //   4524: ldc_w 3056
    //   4527: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4530: ifeq +71 -> 4601
    //   4533: aload_2
    //   4534: ldc_w 3056
    //   4537: invokevirtual 348	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   4540: istore 10
    //   4542: iload 10
    //   4544: ifne +57 -> 4601
    //   4547: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4550: ifeq +37 -> 4587
    //   4553: new 703	java/lang/StringBuilder
    //   4556: dup
    //   4557: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   4560: astore_1
    //   4561: aload_1
    //   4562: ldc_w 3058
    //   4565: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4568: pop
    //   4569: aload_1
    //   4570: iload 10
    //   4572: invokevirtual 1090	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4575: pop
    //   4576: ldc_w 283
    //   4579: iconst_2
    //   4580: aload_1
    //   4581: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4584: invokestatic 978	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4587: aload 5
    //   4589: ifnull +12 -> 4601
    //   4592: aload 5
    //   4594: getfield 3061	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController	Lcom/tencent/mobileqq/widget/WebViewProgressBarController;
    //   4597: iconst_0
    //   4598: invokevirtual 3064	com/tencent/mobileqq/widget/WebViewProgressBarController:a	(Z)V
    //   4601: aload_2
    //   4602: ldc_w 3066
    //   4605: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4608: ifeq +103 -> 4711
    //   4611: aload_2
    //   4612: ldc_w 3066
    //   4615: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4618: istore 6
    //   4620: aload 14
    //   4622: ldc_w 2614
    //   4625: invokevirtual 1463	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4628: checkcast 927	android/widget/TextView
    //   4631: astore_1
    //   4632: aload 14
    //   4634: ldc_w 3067
    //   4637: invokevirtual 1463	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4640: checkcast 1011	android/widget/ImageView
    //   4643: astore 15
    //   4645: aload_1
    //   4646: ifnull +65 -> 4711
    //   4649: aload 15
    //   4651: ifnull +60 -> 4711
    //   4654: iload 6
    //   4656: iconst_1
    //   4657: if_icmpne +41 -> 4698
    //   4660: aload 15
    //   4662: invokevirtual 1448	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   4665: ifnull +18 -> 4683
    //   4668: aload 15
    //   4670: iconst_0
    //   4671: invokevirtual 1049	android/widget/ImageView:setVisibility	(I)V
    //   4674: aload_1
    //   4675: bipush 8
    //   4677: invokevirtual 3068	android/widget/TextView:setVisibility	(I)V
    //   4680: goto +31 -> 4711
    //   4683: aload 15
    //   4685: bipush 8
    //   4687: invokevirtual 1049	android/widget/ImageView:setVisibility	(I)V
    //   4690: aload_1
    //   4691: iconst_0
    //   4692: invokevirtual 3068	android/widget/TextView:setVisibility	(I)V
    //   4695: goto +16 -> 4711
    //   4698: aload_1
    //   4699: bipush 8
    //   4701: invokevirtual 3068	android/widget/TextView:setVisibility	(I)V
    //   4704: aload 15
    //   4706: bipush 8
    //   4708: invokevirtual 1049	android/widget/ImageView:setVisibility	(I)V
    //   4711: aload_2
    //   4712: ldc_w 3070
    //   4715: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4718: ifeq +11 -> 4729
    //   4721: aload_2
    //   4722: ldc_w 3070
    //   4725: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4728: pop
    //   4729: aload_2
    //   4730: ldc_w 3072
    //   4733: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4736: ifeq +83 -> 4819
    //   4739: aload_2
    //   4740: ldc_w 3074
    //   4743: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4746: ifeq +73 -> 4819
    //   4749: aload_2
    //   4750: ldc_w 3076
    //   4753: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4756: ifeq +63 -> 4819
    //   4759: aload_2
    //   4760: ldc_w 3078
    //   4763: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4766: ifeq +53 -> 4819
    //   4769: aload_2
    //   4770: ldc_w 3080
    //   4773: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4776: ifeq +43 -> 4819
    //   4779: aload_2
    //   4780: ldc_w 3072
    //   4783: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4786: pop
    //   4787: aload_2
    //   4788: ldc_w 3074
    //   4791: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4794: pop
    //   4795: aload_2
    //   4796: ldc_w 3076
    //   4799: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4802: pop
    //   4803: aload_2
    //   4804: ldc_w 3078
    //   4807: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4810: pop
    //   4811: aload_2
    //   4812: ldc_w 3080
    //   4815: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4818: pop
    //   4819: aload_2
    //   4820: ldc_w 3082
    //   4823: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4826: ifeq +11 -> 4837
    //   4829: aload_2
    //   4830: ldc_w 3082
    //   4833: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4836: pop
    //   4837: aload 5
    //   4839: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   4842: getfield 3083	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_a_of_type_Boolean	Z
    //   4845: ifne +604 -> 5449
    //   4848: aload_2
    //   4849: ldc_w 3085
    //   4852: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4855: ifeq +594 -> 5449
    //   4858: aload_2
    //   4859: ldc_w 3085
    //   4862: invokestatic 3045	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   4865: istore 7
    //   4867: aload 14
    //   4869: ldc_w 1459
    //   4872: invokevirtual 1463	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4875: astore 15
    //   4877: aload 15
    //   4879: ifnull +570 -> 5449
    //   4882: aload_0
    //   4883: invokevirtual 3087	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebProgressInterface;
    //   4886: ifnull +16 -> 4902
    //   4889: aload_0
    //   4890: invokevirtual 3087	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebProgressInterface;
    //   4893: invokeinterface 3090 1 0
    //   4898: astore_1
    //   4899: goto +17 -> 4916
    //   4902: aload 5
    //   4904: ifnull +13142 -> 18046
    //   4907: aload 5
    //   4909: getfield 3093	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar	Lcom/tencent/mobileqq/widget/WebViewProgressBar;
    //   4912: astore_1
    //   4913: goto +3 -> 4916
    //   4916: iload 7
    //   4918: iconst_m1
    //   4919: if_icmpne +204 -> 5123
    //   4922: aload 15
    //   4924: invokevirtual 3096	android/view/View:getPaddingTop	()I
    //   4927: istore 6
    //   4929: aload 15
    //   4931: invokevirtual 3099	android/view/View:getPaddingBottom	()I
    //   4934: istore 7
    //   4936: aload 15
    //   4938: invokevirtual 3102	android/view/View:getPaddingLeft	()I
    //   4941: istore 8
    //   4943: aload 15
    //   4945: invokevirtual 3105	android/view/View:getPaddingRight	()I
    //   4948: istore 9
    //   4950: aload 15
    //   4952: ldc_w 3106
    //   4955: invokevirtual 3107	android/view/View:setBackgroundResource	(I)V
    //   4958: aload 15
    //   4960: iload 8
    //   4962: iload 6
    //   4964: iload 9
    //   4966: iload 7
    //   4968: invokevirtual 3110	android/view/View:setPadding	(IIII)V
    //   4971: aload_1
    //   4972: ifnull +7 -> 4979
    //   4975: aload_1
    //   4976: invokevirtual 3113	com/tencent/mobileqq/widget/WebViewProgressBar:a	()V
    //   4979: aload 4
    //   4981: invokevirtual 3114	com/tencent/mobileqq/webview/swift/WebViewFragment:getWebTitleBarInterface	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   4984: invokeinterface 3115 1 0
    //   4989: ifnull +460 -> 5449
    //   4992: aload 5
    //   4994: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   4997: getfield 3083	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_a_of_type_Boolean	Z
    //   5000: ifeq +20 -> 5020
    //   5003: aload 4
    //   5005: invokevirtual 3114	com/tencent/mobileqq/webview/swift/WebViewFragment:getWebTitleBarInterface	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   5008: invokeinterface 3115 1 0
    //   5013: iconst_4
    //   5014: invokevirtual 1865	android/view/View:setVisibility	(I)V
    //   5017: goto +94 -> 5111
    //   5020: iconst_0
    //   5021: invokestatic 3119	com/tencent/mobileqq/vas/theme/api/ThemeUtil:isDefaultOrDIYTheme	(Z)Z
    //   5024: ifeq +22 -> 5046
    //   5027: aload 4
    //   5029: invokevirtual 3114	com/tencent/mobileqq/webview/swift/WebViewFragment:getWebTitleBarInterface	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   5032: invokeinterface 3115 1 0
    //   5037: ldc_w 3120
    //   5040: invokevirtual 3107	android/view/View:setBackgroundResource	(I)V
    //   5043: goto +54 -> 5097
    //   5046: aload 4
    //   5048: invokevirtual 3114	com/tencent/mobileqq/webview/swift/WebViewFragment:getWebTitleBarInterface	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   5051: invokeinterface 3115 1 0
    //   5056: invokestatic 1015	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5059: invokevirtual 3121	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   5062: ldc_w 3122
    //   5065: invokevirtual 1853	android/content/res/Resources:getColor	(I)I
    //   5068: invokevirtual 3049	android/view/View:setBackgroundColor	(I)V
    //   5071: iconst_0
    //   5072: invokestatic 1015	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5075: invokevirtual 3121	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   5078: ldc_w 3122
    //   5081: invokevirtual 1853	android/content/res/Resources:getColor	(I)I
    //   5084: aload_0
    //   5085: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   5088: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   5091: invokevirtual 3126	android/app/Activity:getWindow	()Landroid/view/Window;
    //   5094: invokestatic 3131	com/tencent/mobileqq/simpleui/SimpleUIUtil:a	(ZILandroid/view/Window;)V
    //   5097: aload 4
    //   5099: invokevirtual 3114	com/tencent/mobileqq/webview/swift/WebViewFragment:getWebTitleBarInterface	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   5102: invokeinterface 3115 1 0
    //   5107: iconst_0
    //   5108: invokevirtual 1865	android/view/View:setVisibility	(I)V
    //   5111: aload 5
    //   5113: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   5116: iconst_0
    //   5117: putfield 3133	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:i	Z
    //   5120: goto +329 -> 5449
    //   5123: aload 15
    //   5125: iconst_0
    //   5126: invokevirtual 3107	android/view/View:setBackgroundResource	(I)V
    //   5129: aload_2
    //   5130: ldc_w 3135
    //   5133: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5136: ifeq +12915 -> 18051
    //   5139: aload_2
    //   5140: ldc_w 3135
    //   5143: invokestatic 3045	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5146: bipush 24
    //   5148: ishl
    //   5149: istore 6
    //   5151: goto +3 -> 5154
    //   5154: iload 7
    //   5156: iload 6
    //   5158: ior
    //   5159: istore 8
    //   5161: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5164: ifeq +84 -> 5248
    //   5167: new 703	java/lang/StringBuilder
    //   5170: dup
    //   5171: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   5174: astore 16
    //   5176: aload 16
    //   5178: ldc_w 3137
    //   5181: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5184: pop
    //   5185: aload 16
    //   5187: iload 6
    //   5189: invokestatic 3054	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5192: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5195: pop
    //   5196: aload 16
    //   5198: ldc_w 3139
    //   5201: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5204: pop
    //   5205: aload 16
    //   5207: iload 7
    //   5209: invokestatic 3054	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5212: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5215: pop
    //   5216: aload 16
    //   5218: ldc_w 3141
    //   5221: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5224: pop
    //   5225: aload 16
    //   5227: iload 8
    //   5229: invokestatic 3054	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5232: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5235: pop
    //   5236: ldc_w 283
    //   5239: iconst_2
    //   5240: aload 16
    //   5242: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5245: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5248: aload 15
    //   5250: iload 8
    //   5252: invokevirtual 3049	android/view/View:setBackgroundColor	(I)V
    //   5255: aload_1
    //   5256: ifnull +13 -> 5269
    //   5259: aload_1
    //   5260: iload 7
    //   5262: ldc_w 1954
    //   5265: ior
    //   5266: invokevirtual 3144	com/tencent/mobileqq/widget/WebViewProgressBar:setCustomColor	(I)V
    //   5269: aload 5
    //   5271: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   5274: getfield 3145	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_b_of_type_Boolean	Z
    //   5277: ifeq +66 -> 5343
    //   5280: aload 4
    //   5282: invokevirtual 3114	com/tencent/mobileqq/webview/swift/WebViewFragment:getWebTitleBarInterface	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   5285: invokeinterface 3115 1 0
    //   5290: ifnonnull +39 -> 5329
    //   5293: aload 4
    //   5295: invokevirtual 3114	com/tencent/mobileqq/webview/swift/WebViewFragment:getWebTitleBarInterface	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   5298: iconst_1
    //   5299: invokeinterface 3147 2 0
    //   5304: aload 4
    //   5306: invokevirtual 3114	com/tencent/mobileqq/webview/swift/WebViewFragment:getWebTitleBarInterface	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   5309: iconst_1
    //   5310: invokeinterface 3148 2 0
    //   5315: aload 4
    //   5317: invokevirtual 3114	com/tencent/mobileqq/webview/swift/WebViewFragment:getWebTitleBarInterface	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   5320: iconst_0
    //   5321: invokeinterface 3150 2 0
    //   5326: goto +17 -> 5343
    //   5329: aload 4
    //   5331: invokevirtual 3114	com/tencent/mobileqq/webview/swift/WebViewFragment:getWebTitleBarInterface	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   5334: invokeinterface 3115 1 0
    //   5339: iconst_0
    //   5340: invokevirtual 1865	android/view/View:setVisibility	(I)V
    //   5343: aload 4
    //   5345: invokevirtual 3114	com/tencent/mobileqq/webview/swift/WebViewFragment:getWebTitleBarInterface	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   5348: invokeinterface 3115 1 0
    //   5353: ifnull +96 -> 5449
    //   5356: aload_2
    //   5357: ldc_w 3152
    //   5360: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5363: ifeq +46 -> 5409
    //   5366: aload_2
    //   5367: ldc_w 3152
    //   5370: invokestatic 3045	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5373: istore 6
    //   5375: aload 4
    //   5377: invokevirtual 3114	com/tencent/mobileqq/webview/swift/WebViewFragment:getWebTitleBarInterface	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   5380: invokeinterface 3115 1 0
    //   5385: iload 6
    //   5387: invokevirtual 3049	android/view/View:setBackgroundColor	(I)V
    //   5390: iconst_1
    //   5391: iload 6
    //   5393: aload_0
    //   5394: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   5397: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   5400: invokevirtual 3126	android/app/Activity:getWindow	()Landroid/view/Window;
    //   5403: invokestatic 3131	com/tencent/mobileqq/simpleui/SimpleUIUtil:a	(ZILandroid/view/Window;)V
    //   5406: goto +43 -> 5449
    //   5409: aload 4
    //   5411: invokevirtual 3114	com/tencent/mobileqq/webview/swift/WebViewFragment:getWebTitleBarInterface	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   5414: invokeinterface 3115 1 0
    //   5419: iload 8
    //   5421: invokevirtual 3049	android/view/View:setBackgroundColor	(I)V
    //   5424: iconst_1
    //   5425: iload 8
    //   5427: aload_0
    //   5428: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   5431: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   5434: invokevirtual 3126	android/app/Activity:getWindow	()Landroid/view/Window;
    //   5437: invokestatic 3131	com/tencent/mobileqq/simpleui/SimpleUIUtil:a	(ZILandroid/view/Window;)V
    //   5440: aload 5
    //   5442: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   5445: iconst_1
    //   5446: putfield 3133	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:i	Z
    //   5449: aload_2
    //   5450: ldc_w 1734
    //   5453: iconst_m1
    //   5454: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5457: istore 6
    //   5459: iload 6
    //   5461: iflt +106 -> 5567
    //   5464: aload 5
    //   5466: ifnull +101 -> 5567
    //   5469: aload 5
    //   5471: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   5474: astore_1
    //   5475: iconst_1
    //   5476: iload 6
    //   5478: if_icmpne +12581 -> 18059
    //   5481: iconst_1
    //   5482: istore 10
    //   5484: goto +3 -> 5487
    //   5487: aload_1
    //   5488: iload 10
    //   5490: putfield 1748	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:B	Z
    //   5493: aload_0
    //   5494: getfield 2521	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5497: ifeq +25 -> 5522
    //   5500: aload 5
    //   5502: aload 5
    //   5504: getfield 3155	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   5507: getfield 2510	com/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   5510: iconst_0
    //   5511: aload_0
    //   5512: getfield 2521	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5515: aload_0
    //   5516: getfield 2521	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5519: invokevirtual 2524	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Landroid/view/View;ZII)V
    //   5522: aload_0
    //   5523: getfield 2544	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5526: ifeq +21 -> 5547
    //   5529: aload 5
    //   5531: aload_0
    //   5532: getfield 1444	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   5535: iconst_0
    //   5536: aload_0
    //   5537: getfield 2544	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5540: aload_0
    //   5541: getfield 2544	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5544: invokevirtual 2524	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Landroid/view/View;ZII)V
    //   5547: aload 5
    //   5549: aload 5
    //   5551: getfield 3155	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   5554: getfield 2400	com/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   5557: iconst_1
    //   5558: ldc_w 3156
    //   5561: ldc_w 3157
    //   5564: invokevirtual 2524	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Landroid/view/View;ZII)V
    //   5567: aload_2
    //   5568: ldc_w 3159
    //   5571: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5574: ifeq +106 -> 5680
    //   5577: aload_2
    //   5578: ldc_w 3159
    //   5581: invokestatic 3045	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5584: istore 6
    //   5586: iload 6
    //   5588: iconst_m1
    //   5589: if_icmpne +14 -> 5603
    //   5592: aload 5
    //   5594: getfield 3155	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   5597: invokevirtual 3160	com/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI:h	()V
    //   5600: goto +80 -> 5680
    //   5603: aload 5
    //   5605: getfield 3155	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   5608: astore_1
    //   5609: iload 6
    //   5611: ldc_w 1954
    //   5614: ior
    //   5615: istore 7
    //   5617: aload_1
    //   5618: iload 7
    //   5620: invokevirtual 3162	com/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI:d	(I)V
    //   5623: iload 7
    //   5625: istore 6
    //   5627: aload_2
    //   5628: ldc_w 3164
    //   5631: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5634: ifeq +30 -> 5664
    //   5637: aload_2
    //   5638: ldc_w 3164
    //   5641: invokestatic 3045	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5644: istore 8
    //   5646: iload 7
    //   5648: istore 6
    //   5650: iload 8
    //   5652: iconst_m1
    //   5653: if_icmpeq +11 -> 5664
    //   5656: iload 8
    //   5658: ldc_w 1954
    //   5661: ior
    //   5662: istore 6
    //   5664: aload 5
    //   5666: getfield 3155	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   5669: iload 6
    //   5671: invokevirtual 3166	com/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI:f	(I)V
    //   5674: aload_0
    //   5675: iload 6
    //   5677: invokevirtual 3168	com/tencent/mobileqq/jsp/UiApiPlugin:a	(I)V
    //   5680: aload_2
    //   5681: ldc_w 3170
    //   5684: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5687: ifeq +11 -> 5698
    //   5690: aload_2
    //   5691: ldc_w 3170
    //   5694: invokevirtual 3173	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5697: pop
    //   5698: aload_2
    //   5699: ldc_w 3175
    //   5702: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5705: ifeq +56 -> 5761
    //   5708: aload_2
    //   5709: ldc_w 3175
    //   5712: invokevirtual 3173	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5715: ifeq +26 -> 5741
    //   5718: aload 5
    //   5720: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   5723: aload 5
    //   5725: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   5728: getfield 2611	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_a_of_type_Long	J
    //   5731: ldc2_w 3176
    //   5734: land
    //   5735: putfield 2611	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_a_of_type_Long	J
    //   5738: goto +23 -> 5761
    //   5741: aload 5
    //   5743: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   5746: aload 5
    //   5748: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   5751: getfield 2611	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_a_of_type_Long	J
    //   5754: ldc2_w 2622
    //   5757: lor
    //   5758: putfield 2611	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_a_of_type_Long	J
    //   5761: aload_2
    //   5762: ldc_w 3179
    //   5765: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5768: ifeq +20 -> 5788
    //   5771: aload_2
    //   5772: ldc_w 3179
    //   5775: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5778: astore_1
    //   5779: aload 14
    //   5781: checkcast 532	com/tencent/mobileqq/activity/QQBrowserActivity
    //   5784: aload_1
    //   5785: invokevirtual 3181	com/tencent/mobileqq/activity/QQBrowserActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   5788: aload_2
    //   5789: ldc_w 3183
    //   5792: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5795: ifeq +49 -> 5844
    //   5798: aload_2
    //   5799: ldc_w 3183
    //   5802: invokevirtual 348	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   5805: istore 10
    //   5807: sipush 800
    //   5810: istore 6
    //   5812: aload_2
    //   5813: ldc_w 3185
    //   5816: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5819: ifeq +17 -> 5836
    //   5822: aload_2
    //   5823: ldc_w 3185
    //   5826: invokevirtual 3189	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   5829: ldc2_w 3190
    //   5832: dmul
    //   5833: d2i
    //   5834: istore 6
    //   5836: aload_0
    //   5837: iload 10
    //   5839: iload 6
    //   5841: invokevirtual 3193	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZI)V
    //   5844: aload_2
    //   5845: ldc_w 3195
    //   5848: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5851: ifeq +75 -> 5926
    //   5854: aload_2
    //   5855: ldc_w 3195
    //   5858: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5861: istore 6
    //   5863: aload 5
    //   5865: ifnull +61 -> 5926
    //   5868: iload 6
    //   5870: ifne +27 -> 5897
    //   5873: aload 5
    //   5875: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   5878: iconst_0
    //   5879: putfield 3196	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_d_of_type_Boolean	Z
    //   5882: aload 5
    //   5884: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   5887: iconst_1
    //   5888: invokestatic 475	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5891: putfield 3199	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   5894: goto +27 -> 5921
    //   5897: iload 6
    //   5899: iconst_1
    //   5900: if_icmpne +21 -> 5921
    //   5903: aload 5
    //   5905: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   5908: iconst_1
    //   5909: putfield 3196	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_d_of_type_Boolean	Z
    //   5912: aload 5
    //   5914: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   5917: aload_3
    //   5918: putfield 3199	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_a_of_type_JavaLangBoolean	Ljava/lang/Boolean;
    //   5921: aload 5
    //   5923: invokevirtual 3201	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:k	()V
    //   5926: aload_2
    //   5927: ldc_w 3203
    //   5930: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5933: ifeq +28 -> 5961
    //   5936: aload_2
    //   5937: ldc_w 3203
    //   5940: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5943: istore 6
    //   5945: aload 5
    //   5947: ifnull +14 -> 5961
    //   5950: iload 6
    //   5952: iconst_1
    //   5953: if_icmpne +8 -> 5961
    //   5956: aload 5
    //   5958: invokevirtual 3205	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:i	()V
    //   5961: aload_2
    //   5962: ldc_w 3207
    //   5965: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5968: ifeq +19 -> 5987
    //   5971: aload_2
    //   5972: ldc_w 3207
    //   5975: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5978: iconst_1
    //   5979: if_icmpne +8 -> 5987
    //   5982: aload 5
    //   5984: invokevirtual 3209	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:j	()V
    //   5987: aload_2
    //   5988: ldc_w 3211
    //   5991: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5994: ifeq +69 -> 6063
    //   5997: aload_2
    //   5998: ldc_w 3211
    //   6001: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6004: istore 6
    //   6006: aload_0
    //   6007: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6010: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   6013: astore_1
    //   6014: aload_1
    //   6015: ifnull +48 -> 6063
    //   6018: aload_1
    //   6019: instanceof 579
    //   6022: ifeq +41 -> 6063
    //   6025: aload 14
    //   6027: checkcast 579	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   6030: invokevirtual 3215	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:getCurrentWebViewFragment	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   6033: checkcast 3217	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   6036: astore_1
    //   6037: aload_1
    //   6038: ifnull +25 -> 6063
    //   6041: iload 6
    //   6043: iconst_1
    //   6044: if_icmpne +10 -> 6054
    //   6047: aload_1
    //   6048: invokevirtual 3219	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:e	()V
    //   6051: goto +12 -> 6063
    //   6054: iload 6
    //   6056: ifne +7 -> 6063
    //   6059: aload_1
    //   6060: invokevirtual 3221	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:f	()V
    //   6063: aload_2
    //   6064: ldc_w 3223
    //   6067: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6070: ifeq +25 -> 6095
    //   6073: aload_2
    //   6074: ldc_w 3223
    //   6077: iconst_0
    //   6078: invokevirtual 373	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   6081: istore 10
    //   6083: aload 5
    //   6085: ifnull +10 -> 6095
    //   6088: aload 5
    //   6090: iload 10
    //   6092: invokevirtual 3224	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:c	(Z)V
    //   6095: aload_2
    //   6096: ldc_w 3226
    //   6099: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6102: ifeq +41 -> 6143
    //   6105: aload_2
    //   6106: ldc_w 3226
    //   6109: iconst_0
    //   6110: invokevirtual 373	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   6113: istore 10
    //   6115: aload 5
    //   6117: ifnull +26 -> 6143
    //   6120: aload 5
    //   6122: getfield 3155	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI	Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;
    //   6125: getfield 3227	com/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   6128: getfield 3229	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:l	Z
    //   6131: iload 10
    //   6133: if_icmpeq +10 -> 6143
    //   6136: aload 5
    //   6138: iload 10
    //   6140: invokevirtual 3231	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:d	(Z)V
    //   6143: aload_2
    //   6144: ldc_w 3233
    //   6147: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6150: ifeq -5906 -> 244
    //   6153: aload 5
    //   6155: ifnull -5911 -> 244
    //   6158: aload_2
    //   6159: ldc_w 3233
    //   6162: iconst_0
    //   6163: invokevirtual 373	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   6166: ifeq +80 -> 6246
    //   6169: aload 5
    //   6171: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   6174: getfield 3083	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_a_of_type_Boolean	Z
    //   6177: ifne -5933 -> 244
    //   6180: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6183: ifeq +13 -> 6196
    //   6186: ldc_w 283
    //   6189: iconst_4
    //   6190: ldc_w 3235
    //   6193: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6196: aload 5
    //   6198: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   6201: iconst_1
    //   6202: putfield 3083	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_a_of_type_Boolean	Z
    //   6205: aload_0
    //   6206: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6209: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   6212: invokevirtual 3126	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6215: sipush 1024
    //   6218: sipush 1024
    //   6221: invokevirtual 3239	android/view/Window:setFlags	(II)V
    //   6224: aload 4
    //   6226: invokevirtual 3243	com/tencent/mobileqq/webview/swift/WebViewFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   6229: invokestatic 3247	com/tencent/mobileqq/webview/swift/WebViewUIUtils:b	(Landroid/app/Activity;)V
    //   6232: aload 4
    //   6234: invokevirtual 3114	com/tencent/mobileqq/webview/swift/WebViewFragment:getWebTitleBarInterface	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   6237: iconst_0
    //   6238: invokeinterface 3248 2 0
    //   6243: goto -5999 -> 244
    //   6246: aload 5
    //   6248: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   6251: getfield 3083	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_a_of_type_Boolean	Z
    //   6254: ifeq -6010 -> 244
    //   6257: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6260: ifeq +13 -> 6273
    //   6263: ldc_w 283
    //   6266: iconst_4
    //   6267: ldc_w 3250
    //   6270: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6273: aload 5
    //   6275: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   6278: iconst_0
    //   6279: putfield 3083	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_a_of_type_Boolean	Z
    //   6282: aload_0
    //   6283: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6286: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   6289: invokevirtual 3126	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6292: sipush 1024
    //   6295: invokevirtual 3253	android/view/Window:clearFlags	(I)V
    //   6298: aload 4
    //   6300: invokevirtual 3243	com/tencent/mobileqq/webview/swift/WebViewFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   6303: invokestatic 3255	com/tencent/mobileqq/webview/swift/WebViewUIUtils:c	(Landroid/app/Activity;)V
    //   6306: aload 4
    //   6308: invokevirtual 3114	com/tencent/mobileqq/webview/swift/WebViewFragment:getWebTitleBarInterface	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebTitleBarInterface;
    //   6311: iconst_1
    //   6312: invokeinterface 3248 2 0
    //   6317: goto -6073 -> 244
    //   6320: iconst_1
    //   6321: ireturn
    //   6322: astore_1
    //   6323: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6326: ifeq -6082 -> 244
    //   6329: new 703	java/lang/StringBuilder
    //   6332: dup
    //   6333: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   6336: astore_2
    //   6337: aload_2
    //   6338: ldc_w 3257
    //   6341: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6344: pop
    //   6345: aload_2
    //   6346: aload_1
    //   6347: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6350: pop
    //   6351: ldc_w 283
    //   6354: iconst_4
    //   6355: aload_2
    //   6356: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6359: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6362: goto -6118 -> 244
    //   6365: astore_1
    //   6366: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6369: ifeq -6125 -> 244
    //   6372: new 703	java/lang/StringBuilder
    //   6375: dup
    //   6376: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   6379: astore_2
    //   6380: aload_2
    //   6381: ldc_w 3257
    //   6384: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6387: pop
    //   6388: aload_2
    //   6389: aload_1
    //   6390: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6393: pop
    //   6394: ldc_w 283
    //   6397: iconst_4
    //   6398: aload_2
    //   6399: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6402: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6405: goto -6161 -> 244
    //   6408: ldc_w 3259
    //   6411: aload 4
    //   6413: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6416: ifeq +494 -> 6910
    //   6419: aload 5
    //   6421: arraylength
    //   6422: iconst_1
    //   6423: if_icmpgt +487 -> 6910
    //   6426: new 146	org/json/JSONObject
    //   6429: dup
    //   6430: aload 5
    //   6432: iconst_0
    //   6433: aaload
    //   6434: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6437: astore_1
    //   6438: aload_0
    //   6439: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6442: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   6445: instanceof 532
    //   6448: ifne +5 -> 6453
    //   6451: iconst_1
    //   6452: ireturn
    //   6453: new 3261	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo
    //   6456: dup
    //   6457: invokespecial 3262	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:<init>	()V
    //   6460: astore_2
    //   6461: aload_1
    //   6462: ldc_w 3264
    //   6465: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6468: ifeq +18 -> 6486
    //   6471: aload_2
    //   6472: aload_1
    //   6473: ldc_w 3264
    //   6476: invokestatic 3045	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6479: ldc_w 1954
    //   6482: ior
    //   6483: putfield 3265	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_Int	I
    //   6486: aload_1
    //   6487: ldc_w 906
    //   6490: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6493: ifeq +14 -> 6507
    //   6496: aload_2
    //   6497: aload_1
    //   6498: ldc_w 906
    //   6501: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6504: putfield 3266	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6507: aload_1
    //   6508: ldc_w 3268
    //   6511: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6514: ifeq +176 -> 6690
    //   6517: aload_2
    //   6518: new 1807	java/util/ArrayList
    //   6521: dup
    //   6522: invokespecial 2202	java/util/ArrayList:<init>	()V
    //   6525: putfield 3271	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6528: aload_1
    //   6529: ldc_w 3268
    //   6532: invokevirtual 1069	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6535: astore_3
    //   6536: aload_3
    //   6537: invokevirtual 1587	org/json/JSONArray:length	()I
    //   6540: istore 7
    //   6542: iconst_0
    //   6543: istore 6
    //   6545: iload 6
    //   6547: iload 7
    //   6549: if_icmpge +141 -> 6690
    //   6552: aload_3
    //   6553: iload 6
    //   6555: invokevirtual 3274	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6558: astore 4
    //   6560: new 3276	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton
    //   6563: dup
    //   6564: invokespecial 3277	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:<init>	()V
    //   6567: astore 5
    //   6569: aload 4
    //   6571: ldc_w 896
    //   6574: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6577: ifeq +16 -> 6593
    //   6580: aload 5
    //   6582: aload 4
    //   6584: ldc_w 896
    //   6587: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6590: putfield 3278	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6593: aload 4
    //   6595: ldc_w 2245
    //   6598: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6601: ifeq +16 -> 6617
    //   6604: aload 5
    //   6606: aload 4
    //   6608: ldc_w 2245
    //   6611: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6614: putfield 3279	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_a_of_type_Int	I
    //   6617: aload 4
    //   6619: ldc_w 3281
    //   6622: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6625: ifeq +16 -> 6641
    //   6628: aload 5
    //   6630: aload 4
    //   6632: ldc_w 3281
    //   6635: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6638: putfield 3282	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6641: aload 4
    //   6643: ldc_w 1791
    //   6646: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6649: ifeq +20 -> 6669
    //   6652: aload 5
    //   6654: aload 4
    //   6656: ldc_w 1791
    //   6659: invokestatic 3045	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6662: ldc_w 1954
    //   6665: ior
    //   6666: putfield 3283	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_b_of_type_Int	I
    //   6669: aload_2
    //   6670: getfield 3271	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6673: aload 5
    //   6675: invokeinterface 2296 2 0
    //   6680: pop
    //   6681: iload 6
    //   6683: iconst_1
    //   6684: iadd
    //   6685: istore 6
    //   6687: goto -142 -> 6545
    //   6690: aload_1
    //   6691: ldc_w 3285
    //   6694: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6697: ifeq +78 -> 6775
    //   6700: aload_2
    //   6701: new 1807	java/util/ArrayList
    //   6704: dup
    //   6705: invokespecial 2202	java/util/ArrayList:<init>	()V
    //   6708: putfield 3287	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:b	Ljava/util/List;
    //   6711: aload_1
    //   6712: ldc_w 3285
    //   6715: invokevirtual 1069	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6718: astore_1
    //   6719: aload_1
    //   6720: invokevirtual 1587	org/json/JSONArray:length	()I
    //   6723: istore 7
    //   6725: iconst_0
    //   6726: istore 6
    //   6728: iload 6
    //   6730: iload 7
    //   6732: if_icmpge +43 -> 6775
    //   6735: aload_1
    //   6736: iload 6
    //   6738: invokevirtual 3274	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6741: ldc 193
    //   6743: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6746: ifeq +11319 -> 18065
    //   6749: aload_1
    //   6750: iload 6
    //   6752: invokevirtual 3274	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6755: ldc 193
    //   6757: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6760: astore_3
    //   6761: aload_2
    //   6762: getfield 3287	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:b	Ljava/util/List;
    //   6765: aload_3
    //   6766: invokeinterface 2296 2 0
    //   6771: pop
    //   6772: goto +11293 -> 18065
    //   6775: aload_0
    //   6776: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6779: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   6782: astore_1
    //   6783: aload_1
    //   6784: ifnull +11290 -> 18074
    //   6787: aload_1
    //   6788: invokevirtual 2405	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   6791: astore_1
    //   6792: aload_1
    //   6793: ifnull +11281 -> 18074
    //   6796: aload_1
    //   6797: ldc_w 3289
    //   6800: invokevirtual 3292	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   6803: astore_1
    //   6804: aload_1
    //   6805: ifnull +11269 -> 18074
    //   6808: aload_1
    //   6809: instanceof 260
    //   6812: ifeq +11262 -> 18074
    //   6815: aload_1
    //   6816: checkcast 260	com/tencent/biz/webviewplugin/PubAccountUIPlugin
    //   6819: astore_1
    //   6820: goto +3 -> 6823
    //   6823: aload_1
    //   6824: ifnull -6580 -> 244
    //   6827: aload_1
    //   6828: aload_2
    //   6829: invokevirtual 3295	com/tencent/biz/webviewplugin/PubAccountUIPlugin:a	(Lcom/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo;)V
    //   6832: aload_2
    //   6833: getfield 3266	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6836: ifnull -6592 -> 244
    //   6839: aload_1
    //   6840: invokestatic 3297	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lcom/tencent/biz/webviewplugin/PubAccountUIPlugin;)Ljava/lang/String;
    //   6843: astore_1
    //   6844: aload_1
    //   6845: ifnull -6601 -> 244
    //   6848: aload_0
    //   6849: aload_2
    //   6850: getfield 3266	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6853: iconst_1
    //   6854: anewarray 363	java/lang/String
    //   6857: dup
    //   6858: iconst_0
    //   6859: aload_1
    //   6860: aastore
    //   6861: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   6864: goto -6620 -> 244
    //   6867: astore_1
    //   6868: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6871: ifeq -6627 -> 244
    //   6874: new 703	java/lang/StringBuilder
    //   6877: dup
    //   6878: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   6881: astore_2
    //   6882: aload_2
    //   6883: ldc_w 3299
    //   6886: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6889: pop
    //   6890: aload_2
    //   6891: aload_1
    //   6892: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6895: pop
    //   6896: ldc_w 283
    //   6899: iconst_4
    //   6900: aload_2
    //   6901: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6904: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6907: goto -6663 -> 244
    //   6910: ldc_w 3301
    //   6913: aload 4
    //   6915: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6918: ifeq +186 -> 7104
    //   6921: aload 5
    //   6923: arraylength
    //   6924: iconst_1
    //   6925: if_icmpgt +179 -> 7104
    //   6928: new 146	org/json/JSONObject
    //   6931: dup
    //   6932: aload 5
    //   6934: iconst_0
    //   6935: aaload
    //   6936: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6939: astore_1
    //   6940: aload_0
    //   6941: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   6944: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   6947: instanceof 532
    //   6950: ifne +5 -> 6955
    //   6953: iconst_1
    //   6954: ireturn
    //   6955: aload_1
    //   6956: ldc_w 3302
    //   6959: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6962: ifeq -6718 -> 244
    //   6965: aload_1
    //   6966: ldc_w 3302
    //   6969: invokevirtual 348	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   6972: istore 10
    //   6974: aload_1
    //   6975: ldc_w 3304
    //   6978: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6981: ifeq +17 -> 6998
    //   6984: aload_1
    //   6985: ldc_w 3304
    //   6988: invokevirtual 3189	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   6991: ldc2_w 3190
    //   6994: dmul
    //   6995: d2i
    //   6996: istore 6
    //   6998: aload_0
    //   6999: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7002: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7005: astore_1
    //   7006: aload_1
    //   7007: ifnull +11072 -> 18079
    //   7010: aload_1
    //   7011: invokevirtual 2405	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   7014: astore_1
    //   7015: aload_1
    //   7016: ifnull +11063 -> 18079
    //   7019: aload_1
    //   7020: ldc_w 3289
    //   7023: invokevirtual 3292	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   7026: astore_1
    //   7027: aload_1
    //   7028: ifnull +11051 -> 18079
    //   7031: aload_1
    //   7032: instanceof 260
    //   7035: ifeq +11044 -> 18079
    //   7038: aload_1
    //   7039: checkcast 260	com/tencent/biz/webviewplugin/PubAccountUIPlugin
    //   7042: astore_1
    //   7043: goto +3 -> 7046
    //   7046: aload_1
    //   7047: ifnull -6803 -> 244
    //   7050: aload_1
    //   7051: iload 10
    //   7053: iload 6
    //   7055: invokevirtual 3305	com/tencent/biz/webviewplugin/PubAccountUIPlugin:a	(ZI)V
    //   7058: goto -6814 -> 244
    //   7061: astore_1
    //   7062: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7065: ifeq -6821 -> 244
    //   7068: new 703	java/lang/StringBuilder
    //   7071: dup
    //   7072: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   7075: astore_2
    //   7076: aload_2
    //   7077: ldc_w 3307
    //   7080: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7083: pop
    //   7084: aload_2
    //   7085: aload_1
    //   7086: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7089: pop
    //   7090: ldc_w 283
    //   7093: iconst_4
    //   7094: aload_2
    //   7095: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7098: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7101: goto -6857 -> 244
    //   7104: ldc_w 3309
    //   7107: aload 4
    //   7109: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7112: ifeq +236 -> 7348
    //   7115: aload 5
    //   7117: arraylength
    //   7118: iconst_1
    //   7119: if_icmpgt +229 -> 7348
    //   7122: new 146	org/json/JSONObject
    //   7125: dup
    //   7126: aload 5
    //   7128: iconst_0
    //   7129: aaload
    //   7130: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7133: astore_1
    //   7134: aload_0
    //   7135: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7138: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   7141: instanceof 532
    //   7144: ifne +5 -> 7149
    //   7147: iconst_1
    //   7148: ireturn
    //   7149: new 3276	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton
    //   7152: dup
    //   7153: invokespecial 3277	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:<init>	()V
    //   7156: astore_2
    //   7157: aload_1
    //   7158: ldc_w 896
    //   7161: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7164: ifeq +14 -> 7178
    //   7167: aload_2
    //   7168: aload_1
    //   7169: ldc_w 896
    //   7172: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7175: putfield 3278	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7178: aload_1
    //   7179: ldc_w 2245
    //   7182: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7185: ifeq +14 -> 7199
    //   7188: aload_2
    //   7189: aload_1
    //   7190: ldc_w 2245
    //   7193: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7196: putfield 3279	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_a_of_type_Int	I
    //   7199: aload_1
    //   7200: ldc_w 3281
    //   7203: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7206: ifeq +14 -> 7220
    //   7209: aload_2
    //   7210: aload_1
    //   7211: ldc_w 3281
    //   7214: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7217: putfield 3282	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7220: aload_1
    //   7221: ldc_w 1791
    //   7224: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7227: ifeq +18 -> 7245
    //   7230: aload_2
    //   7231: aload_1
    //   7232: ldc_w 1791
    //   7235: invokestatic 3045	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   7238: ldc_w 1954
    //   7241: ior
    //   7242: putfield 3283	com/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton:jdField_b_of_type_Int	I
    //   7245: aload_0
    //   7246: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7249: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7252: astore_1
    //   7253: aload_1
    //   7254: ifnull +10830 -> 18084
    //   7257: aload_1
    //   7258: invokevirtual 2405	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   7261: astore_1
    //   7262: aload_1
    //   7263: ifnull +10821 -> 18084
    //   7266: aload_1
    //   7267: ldc_w 3289
    //   7270: invokevirtual 3292	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   7273: astore_1
    //   7274: aload_1
    //   7275: ifnull +10809 -> 18084
    //   7278: aload_1
    //   7279: instanceof 260
    //   7282: ifeq +10802 -> 18084
    //   7285: aload_1
    //   7286: checkcast 260	com/tencent/biz/webviewplugin/PubAccountUIPlugin
    //   7289: astore_1
    //   7290: goto +3 -> 7293
    //   7293: aload_1
    //   7294: ifnull -7050 -> 244
    //   7297: aload_1
    //   7298: aload_2
    //   7299: invokevirtual 3312	com/tencent/biz/webviewplugin/PubAccountUIPlugin:a	(Lcom/tencent/biz/webviewplugin/PubAccountUIPlugin$PAArticleButton;)V
    //   7302: goto -7058 -> 244
    //   7305: astore_1
    //   7306: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7309: ifeq -7065 -> 244
    //   7312: new 703	java/lang/StringBuilder
    //   7315: dup
    //   7316: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   7319: astore_2
    //   7320: aload_2
    //   7321: ldc_w 3314
    //   7324: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7327: pop
    //   7328: aload_2
    //   7329: aload_1
    //   7330: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7333: pop
    //   7334: ldc_w 283
    //   7337: iconst_4
    //   7338: aload_2
    //   7339: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7342: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7345: goto -7101 -> 244
    //   7348: ldc_w 3316
    //   7351: aload 4
    //   7353: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7356: ifeq +134 -> 7490
    //   7359: aload 5
    //   7361: arraylength
    //   7362: iconst_1
    //   7363: if_icmpgt +127 -> 7490
    //   7366: aload 5
    //   7368: arraylength
    //   7369: iconst_1
    //   7370: if_icmpne +22 -> 7392
    //   7373: new 146	org/json/JSONObject
    //   7376: dup
    //   7377: aload 5
    //   7379: iconst_0
    //   7380: aaload
    //   7381: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7384: ldc_w 3318
    //   7387: iconst_0
    //   7388: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7391: pop
    //   7392: aload_0
    //   7393: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7396: aload_0
    //   7397: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7400: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   7403: invokevirtual 1426	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   7406: astore_1
    //   7407: aload_1
    //   7408: ifnull +22 -> 7430
    //   7411: aload_1
    //   7412: instanceof 3320
    //   7415: ifeq +15 -> 7430
    //   7418: aload_1
    //   7419: checkcast 3320	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebUiMethodInterface
    //   7422: invokeinterface 3322 1 0
    //   7427: goto -7183 -> 244
    //   7430: aload_0
    //   7431: invokespecial 230	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/share/CommonShareHelper;
    //   7434: ifnull -7190 -> 244
    //   7437: aload_0
    //   7438: invokespecial 230	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lcom/tencent/share/CommonShareHelper;
    //   7441: invokevirtual 3323	com/tencent/share/CommonShareHelper:a	()V
    //   7444: goto -7200 -> 244
    //   7447: astore_1
    //   7448: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7451: ifeq -7207 -> 244
    //   7454: new 703	java/lang/StringBuilder
    //   7457: dup
    //   7458: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   7461: astore_2
    //   7462: aload_2
    //   7463: ldc_w 3325
    //   7466: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7469: pop
    //   7470: aload_2
    //   7471: aload_1
    //   7472: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7475: pop
    //   7476: ldc_w 283
    //   7479: iconst_4
    //   7480: aload_2
    //   7481: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7484: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7487: goto -7243 -> 244
    //   7490: ldc_w 3327
    //   7493: aload 4
    //   7495: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7498: ifeq +213 -> 7711
    //   7501: aload 5
    //   7503: arraylength
    //   7504: iconst_1
    //   7505: if_icmpne +206 -> 7711
    //   7508: new 146	org/json/JSONObject
    //   7511: dup
    //   7512: aload 5
    //   7514: iconst_0
    //   7515: aaload
    //   7516: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7519: astore_1
    //   7520: aload_1
    //   7521: ldc_w 2130
    //   7524: iconst_0
    //   7525: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7528: istore 6
    //   7530: aload_1
    //   7531: ldc_w 2137
    //   7534: iconst_0
    //   7535: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7538: istore 7
    //   7540: aload_1
    //   7541: ldc_w 2132
    //   7544: iconst_0
    //   7545: invokevirtual 373	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   7548: istore 10
    //   7550: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7553: ifeq +59 -> 7612
    //   7556: new 703	java/lang/StringBuilder
    //   7559: dup
    //   7560: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   7563: astore_2
    //   7564: aload_2
    //   7565: ldc_w 3329
    //   7568: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7571: pop
    //   7572: aload_2
    //   7573: aload_1
    //   7574: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7577: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7580: pop
    //   7581: aload_2
    //   7582: ldc_w 3331
    //   7585: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7588: pop
    //   7589: aload_2
    //   7590: aload_0
    //   7591: getfield 131	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   7594: invokevirtual 1534	java/lang/Object:toString	()Ljava/lang/String;
    //   7597: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7600: pop
    //   7601: ldc_w 283
    //   7604: iconst_2
    //   7605: aload_2
    //   7606: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7609: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7612: invokestatic 620	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7615: new 162	android/content/Intent
    //   7618: dup
    //   7619: ldc_w 2465
    //   7622: invokespecial 167	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   7625: ldc_w 2130
    //   7628: iload 6
    //   7630: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7633: ldc_w 2132
    //   7636: iload 10
    //   7638: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7641: ldc_w 2137
    //   7644: iload 7
    //   7646: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7649: ldc_w 2139
    //   7652: aload_0
    //   7653: getfield 2143	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Int	I
    //   7656: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7659: ldc_w 2467
    //   7662: invokevirtual 3336	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   7665: goto -7421 -> 244
    //   7668: astore_1
    //   7669: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7672: ifeq -7428 -> 244
    //   7675: new 703	java/lang/StringBuilder
    //   7678: dup
    //   7679: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   7682: astore_2
    //   7683: aload_2
    //   7684: ldc_w 3338
    //   7687: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7690: pop
    //   7691: aload_2
    //   7692: aload_1
    //   7693: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7696: pop
    //   7697: ldc_w 283
    //   7700: iconst_4
    //   7701: aload_2
    //   7702: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7705: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7708: goto -7464 -> 244
    //   7711: ldc_w 3340
    //   7714: aload 4
    //   7716: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7719: ifeq +268 -> 7987
    //   7722: aload 5
    //   7724: arraylength
    //   7725: iconst_1
    //   7726: if_icmpne +261 -> 7987
    //   7729: aload_0
    //   7730: aconst_null
    //   7731: putfield 3342	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   7734: new 146	org/json/JSONObject
    //   7737: dup
    //   7738: aload 5
    //   7740: iconst_0
    //   7741: aaload
    //   7742: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7745: astore_3
    //   7746: aload_3
    //   7747: ldc_w 657
    //   7750: invokevirtual 2677	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   7753: lstore 12
    //   7755: aload_3
    //   7756: ldc_w 3344
    //   7759: bipush 13
    //   7761: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7764: istore 6
    //   7766: aload_3
    //   7767: ldc_w 3346
    //   7770: iconst_0
    //   7771: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7774: istore 7
    //   7776: aload_3
    //   7777: ldc_w 906
    //   7780: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7783: astore_1
    //   7784: aload_0
    //   7785: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7788: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   7791: astore_2
    //   7792: aload_2
    //   7793: ifnull +134 -> 7927
    //   7796: aload_2
    //   7797: invokevirtual 3349	com/tencent/common/app/AppInterface:isLogin	()Z
    //   7800: ifne +6 -> 7806
    //   7803: goto +124 -> 7927
    //   7806: aload_3
    //   7807: ldc_w 2703
    //   7810: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7813: astore_3
    //   7814: aload_3
    //   7815: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7818: ifne +31 -> 7849
    //   7821: aload_3
    //   7822: aload_2
    //   7823: invokevirtual 1672	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   7826: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7829: ifne +20 -> 7849
    //   7832: aload_0
    //   7833: aload_1
    //   7834: iconst_1
    //   7835: anewarray 363	java/lang/String
    //   7838: dup
    //   7839: iconst_0
    //   7840: ldc_w 3351
    //   7843: aastore
    //   7844: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7847: iconst_1
    //   7848: ireturn
    //   7849: aload_0
    //   7850: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7853: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   7856: astore_2
    //   7857: aload_2
    //   7858: ifnull -7614 -> 244
    //   7861: aload_0
    //   7862: aload_1
    //   7863: putfield 3342	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   7866: new 162	android/content/Intent
    //   7869: dup
    //   7870: aload_2
    //   7871: ldc_w 3353
    //   7874: invokespecial 535	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   7877: astore_1
    //   7878: aload_1
    //   7879: ldc_w 1550
    //   7882: bipush 16
    //   7884: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7887: pop
    //   7888: aload_1
    //   7889: ldc_w 3344
    //   7892: iload 6
    //   7894: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7897: pop
    //   7898: aload_1
    //   7899: ldc_w 657
    //   7902: lload 12
    //   7904: invokevirtual 673	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   7907: pop
    //   7908: aload_1
    //   7909: ldc_w 3346
    //   7912: iload 7
    //   7914: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7917: pop
    //   7918: aload_0
    //   7919: aload_1
    //   7920: iconst_5
    //   7921: invokevirtual 2014	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   7924: goto -7680 -> 244
    //   7927: aload_0
    //   7928: aload_1
    //   7929: iconst_1
    //   7930: anewarray 363	java/lang/String
    //   7933: dup
    //   7934: iconst_0
    //   7935: ldc_w 3355
    //   7938: aastore
    //   7939: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7942: iconst_1
    //   7943: ireturn
    //   7944: astore_1
    //   7945: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7948: ifeq -7704 -> 244
    //   7951: new 703	java/lang/StringBuilder
    //   7954: dup
    //   7955: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   7958: astore_2
    //   7959: aload_2
    //   7960: ldc_w 3357
    //   7963: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7966: pop
    //   7967: aload_2
    //   7968: aload_1
    //   7969: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7972: pop
    //   7973: ldc_w 283
    //   7976: iconst_4
    //   7977: aload_2
    //   7978: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7981: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7984: goto -7740 -> 244
    //   7987: ldc_w 3359
    //   7990: aload 4
    //   7992: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7995: ifeq +311 -> 8306
    //   7998: aload 5
    //   8000: arraylength
    //   8001: iconst_1
    //   8002: if_icmpne +304 -> 8306
    //   8005: aload_0
    //   8006: aconst_null
    //   8007: putfield 2964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8010: new 146	org/json/JSONObject
    //   8013: dup
    //   8014: aload 5
    //   8016: iconst_0
    //   8017: aaload
    //   8018: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8021: astore_3
    //   8022: aload_0
    //   8023: aload_3
    //   8024: ldc_w 2703
    //   8027: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   8030: putfield 3361	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   8033: aload_3
    //   8034: ldc_w 3363
    //   8037: iconst_0
    //   8038: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   8041: istore 6
    //   8043: aload_0
    //   8044: aload_3
    //   8045: ldc_w 3365
    //   8048: iconst_0
    //   8049: invokevirtual 373	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   8052: putfield 100	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Boolean	Z
    //   8055: aload_3
    //   8056: ldc_w 906
    //   8059: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   8062: astore_1
    //   8063: aload_0
    //   8064: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8067: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   8070: astore_2
    //   8071: aload_2
    //   8072: ifnull +174 -> 8246
    //   8075: aload_2
    //   8076: invokevirtual 3349	com/tencent/common/app/AppInterface:isLogin	()Z
    //   8079: ifne +6 -> 8085
    //   8082: goto +164 -> 8246
    //   8085: aload_0
    //   8086: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8089: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   8092: astore_2
    //   8093: aload_2
    //   8094: ifnull -7850 -> 244
    //   8097: iload 6
    //   8099: ifne -7855 -> 244
    //   8102: aload_3
    //   8103: ldc_w 382
    //   8106: aload_2
    //   8107: ldc_w 3366
    //   8110: invokevirtual 952	android/app/Activity:getString	(I)Ljava/lang/String;
    //   8113: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8116: astore_3
    //   8117: aload_0
    //   8118: aload_1
    //   8119: putfield 2964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8122: aload_0
    //   8123: getfield 100	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Boolean	Z
    //   8126: ifeq +69 -> 8195
    //   8129: ldc_w 3368
    //   8132: invokestatic 574	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   8135: checkcast 3368	com/tencent/mobileqq/selectmember/api/ISelectMemberApi
    //   8138: aload_2
    //   8139: invokeinterface 3372 2 0
    //   8144: astore_1
    //   8145: aload_1
    //   8146: ldc_w 3374
    //   8149: iconst_1
    //   8150: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8153: pop
    //   8154: aload_1
    //   8155: ldc_w 3376
    //   8158: aload_0
    //   8159: getfield 3361	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   8162: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8165: pop
    //   8166: aload_1
    //   8167: ldc_w 3378
    //   8170: aload_3
    //   8171: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8174: pop
    //   8175: aload_0
    //   8176: aload_1
    //   8177: bipush 7
    //   8179: invokevirtual 2014	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   8182: aload_2
    //   8183: ldc_w 3379
    //   8186: ldc_w 3380
    //   8189: invokevirtual 737	android/app/Activity:overridePendingTransition	(II)V
    //   8192: goto +34 -> 8226
    //   8195: ldc_w 2683
    //   8198: invokestatic 574	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   8201: checkcast 2683	com/tencent/mobileqq/troop/utils/api/ITroopUtilsApi
    //   8204: aload_2
    //   8205: aload_0
    //   8206: getfield 3361	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   8209: bipush 14
    //   8211: invokeinterface 2687 4 0
    //   8216: astore_1
    //   8217: aload_1
    //   8218: ldc_w 3382
    //   8221: aload_3
    //   8222: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8225: pop
    //   8226: aload_0
    //   8227: aload_1
    //   8228: bipush 7
    //   8230: invokevirtual 2014	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   8233: aload_2
    //   8234: ldc_w 3379
    //   8237: ldc_w 3380
    //   8240: invokevirtual 737	android/app/Activity:overridePendingTransition	(II)V
    //   8243: goto -7999 -> 244
    //   8246: aload_0
    //   8247: aload_1
    //   8248: iconst_1
    //   8249: anewarray 363	java/lang/String
    //   8252: dup
    //   8253: iconst_0
    //   8254: ldc_w 3384
    //   8257: aastore
    //   8258: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8261: iconst_1
    //   8262: ireturn
    //   8263: astore_1
    //   8264: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   8267: ifeq -8023 -> 244
    //   8270: new 703	java/lang/StringBuilder
    //   8273: dup
    //   8274: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   8277: astore_2
    //   8278: aload_2
    //   8279: ldc_w 3386
    //   8282: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8285: pop
    //   8286: aload_2
    //   8287: aload_1
    //   8288: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8291: pop
    //   8292: ldc_w 283
    //   8295: iconst_4
    //   8296: aload_2
    //   8297: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8300: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8303: goto -8059 -> 244
    //   8306: ldc_w 3388
    //   8309: aload 4
    //   8311: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8314: ifeq +133 -> 8447
    //   8317: aload 5
    //   8319: arraylength
    //   8320: iconst_1
    //   8321: if_icmpne +126 -> 8447
    //   8324: new 146	org/json/JSONObject
    //   8327: dup
    //   8328: aload 5
    //   8330: iconst_0
    //   8331: aaload
    //   8332: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8335: astore_1
    //   8336: aload_1
    //   8337: ldc_w 3390
    //   8340: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8343: ifeq -8099 -> 244
    //   8346: aload_1
    //   8347: ldc_w 3390
    //   8350: invokevirtual 3173	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   8353: istore 10
    //   8355: aload_0
    //   8356: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8359: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   8362: invokevirtual 219	com/tencent/biz/pubaccount/CustomWebView:getParent	()Landroid/view/ViewParent;
    //   8365: checkcast 1864	android/view/View
    //   8368: astore_1
    //   8369: aload_1
    //   8370: ifnonnull +5 -> 8375
    //   8373: iconst_1
    //   8374: ireturn
    //   8375: aload_1
    //   8376: instanceof 1943
    //   8379: ifne +5 -> 8384
    //   8382: iconst_1
    //   8383: ireturn
    //   8384: aload_0
    //   8385: aload_1
    //   8386: checkcast 1943	com/tencent/biz/ui/RefreshView
    //   8389: putfield 1945	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8392: aload_0
    //   8393: getfield 1945	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8396: iload 10
    //   8398: invokevirtual 3391	com/tencent/biz/ui/RefreshView:a	(Z)V
    //   8401: goto -8157 -> 244
    //   8404: astore_1
    //   8405: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   8408: ifeq -8164 -> 244
    //   8411: new 703	java/lang/StringBuilder
    //   8414: dup
    //   8415: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   8418: astore_2
    //   8419: aload_2
    //   8420: ldc_w 3393
    //   8423: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8426: pop
    //   8427: aload_2
    //   8428: aload_1
    //   8429: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8432: pop
    //   8433: ldc_w 283
    //   8436: iconst_4
    //   8437: aload_2
    //   8438: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8441: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8444: goto -8200 -> 244
    //   8447: ldc_w 3395
    //   8450: aload 4
    //   8452: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8455: ifeq +421 -> 8876
    //   8458: aload 5
    //   8460: arraylength
    //   8461: iconst_1
    //   8462: if_icmpne +414 -> 8876
    //   8465: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8468: ifeq +39 -> 8507
    //   8471: new 703	java/lang/StringBuilder
    //   8474: dup
    //   8475: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   8478: astore_1
    //   8479: aload_1
    //   8480: ldc_w 3397
    //   8483: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8486: pop
    //   8487: aload_1
    //   8488: aload 5
    //   8490: iconst_0
    //   8491: aaload
    //   8492: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8495: pop
    //   8496: ldc_w 283
    //   8499: iconst_1
    //   8500: aload_1
    //   8501: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8504: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8507: new 146	org/json/JSONObject
    //   8510: dup
    //   8511: aload 5
    //   8513: iconst_0
    //   8514: aaload
    //   8515: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8518: astore_1
    //   8519: aload_1
    //   8520: ldc_w 382
    //   8523: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8526: astore_3
    //   8527: aload_1
    //   8528: ldc_w 3281
    //   8531: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8534: astore 4
    //   8536: aload_1
    //   8537: ldc_w 906
    //   8540: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8543: astore_2
    //   8544: aload_2
    //   8545: astore_1
    //   8546: aload_3
    //   8547: invokevirtual 3398	java/lang/String:length	()I
    //   8550: ifle +124 -> 8674
    //   8553: aload_2
    //   8554: astore_1
    //   8555: aload_0
    //   8556: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8559: invokevirtual 1431	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   8562: checkcast 1867	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   8565: astore 5
    //   8567: aload 5
    //   8569: ifnull +93 -> 8662
    //   8572: aload_2
    //   8573: astore_1
    //   8574: aload 5
    //   8576: invokevirtual 3402	com/tencent/mobileqq/webview/swift/WebViewFragment:getUIStyle	()Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   8579: ifnull +83 -> 8662
    //   8582: aload_2
    //   8583: astore_1
    //   8584: aload 5
    //   8586: invokevirtual 3402	com/tencent/mobileqq/webview/swift/WebViewFragment:getUIStyle	()Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   8589: getfield 3405	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:H	Z
    //   8592: ifeq +23 -> 8615
    //   8595: aload_2
    //   8596: astore_1
    //   8597: aload_3
    //   8598: iconst_m1
    //   8599: aload 4
    //   8601: ldc_w 3407
    //   8604: invokevirtual 175	java/lang/Class:getName	()Ljava/lang/String;
    //   8607: aload 5
    //   8609: invokestatic 3412	com/tencent/mobileqq/webview/swift/utils/WebViewJumpUtils:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/WebViewProvider;)V
    //   8612: goto +9477 -> 18089
    //   8615: aload_2
    //   8616: astore_1
    //   8617: aload 5
    //   8619: invokevirtual 3402	com/tencent/mobileqq/webview/swift/WebViewFragment:getUIStyle	()Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   8622: getfield 3415	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:G	Z
    //   8625: ifeq +9464 -> 18089
    //   8628: aload_2
    //   8629: astore_1
    //   8630: new 379	android/os/Bundle
    //   8633: dup
    //   8634: invokespecial 380	android/os/Bundle:<init>	()V
    //   8637: astore 4
    //   8639: aload_2
    //   8640: astore_1
    //   8641: aload 4
    //   8643: ldc_w 3417
    //   8646: aload_3
    //   8647: invokevirtual 515	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   8650: aload_2
    //   8651: astore_1
    //   8652: aload 4
    //   8654: aload 5
    //   8656: invokestatic 3420	com/tencent/mobileqq/webview/swift/utils/WebViewJumpUtils:a	(Landroid/os/Bundle;Lcom/tencent/mobileqq/webview/swift/WebViewProvider;)V
    //   8659: goto +9430 -> 18089
    //   8662: aload_2
    //   8663: astore_1
    //   8664: ldc_w 283
    //   8667: iconst_1
    //   8668: ldc_w 3422
    //   8671: invokestatic 1130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8674: iconst_1
    //   8675: istore 6
    //   8677: aload_2
    //   8678: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8681: ifne -8437 -> 244
    //   8684: new 703	java/lang/StringBuilder
    //   8687: dup
    //   8688: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   8691: astore_1
    //   8692: aload_1
    //   8693: ldc_w 3424
    //   8696: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8699: pop
    //   8700: aload_1
    //   8701: iload 6
    //   8703: invokevirtual 1701	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8706: pop
    //   8707: aload_1
    //   8708: ldc_w 1789
    //   8711: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8714: pop
    //   8715: aload_0
    //   8716: aload_2
    //   8717: iconst_1
    //   8718: anewarray 363	java/lang/String
    //   8721: dup
    //   8722: iconst_0
    //   8723: aload_1
    //   8724: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8727: aastore
    //   8728: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8731: goto -8487 -> 244
    //   8734: astore_3
    //   8735: goto +12 -> 8747
    //   8738: astore_1
    //   8739: aconst_null
    //   8740: astore_2
    //   8741: goto +80 -> 8821
    //   8744: astore_3
    //   8745: aconst_null
    //   8746: astore_2
    //   8747: aload_2
    //   8748: astore_1
    //   8749: ldc_w 283
    //   8752: iconst_1
    //   8753: ldc_w 3426
    //   8756: aload_3
    //   8757: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8760: aload_2
    //   8761: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8764: ifne -8520 -> 244
    //   8767: new 703	java/lang/StringBuilder
    //   8770: dup
    //   8771: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   8774: astore_1
    //   8775: aload_1
    //   8776: ldc_w 3424
    //   8779: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8782: pop
    //   8783: aload_1
    //   8784: iconst_1
    //   8785: invokevirtual 1701	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8788: pop
    //   8789: aload_1
    //   8790: ldc_w 1789
    //   8793: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8796: pop
    //   8797: aload_0
    //   8798: aload_2
    //   8799: iconst_1
    //   8800: anewarray 363	java/lang/String
    //   8803: dup
    //   8804: iconst_0
    //   8805: aload_1
    //   8806: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8809: aastore
    //   8810: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8813: goto -8569 -> 244
    //   8816: astore_3
    //   8817: aload_1
    //   8818: astore_2
    //   8819: aload_3
    //   8820: astore_1
    //   8821: aload_2
    //   8822: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8825: ifne +49 -> 8874
    //   8828: new 703	java/lang/StringBuilder
    //   8831: dup
    //   8832: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   8835: astore_3
    //   8836: aload_3
    //   8837: ldc_w 3424
    //   8840: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8843: pop
    //   8844: aload_3
    //   8845: iconst_1
    //   8846: invokevirtual 1701	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8849: pop
    //   8850: aload_3
    //   8851: ldc_w 1789
    //   8854: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8857: pop
    //   8858: aload_0
    //   8859: aload_2
    //   8860: iconst_1
    //   8861: anewarray 363	java/lang/String
    //   8864: dup
    //   8865: iconst_0
    //   8866: aload_3
    //   8867: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8870: aastore
    //   8871: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8874: aload_1
    //   8875: athrow
    //   8876: ldc_w 1971
    //   8879: aload 4
    //   8881: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8884: ifeq +276 -> 9160
    //   8887: aload 5
    //   8889: arraylength
    //   8890: iconst_1
    //   8891: if_icmpne +269 -> 9160
    //   8894: new 146	org/json/JSONObject
    //   8897: dup
    //   8898: aload 5
    //   8900: iconst_0
    //   8901: aaload
    //   8902: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8905: astore_2
    //   8906: aload_2
    //   8907: ldc_w 3390
    //   8910: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8913: ifeq +92 -> 9005
    //   8916: aload_2
    //   8917: ldc_w 3390
    //   8920: invokevirtual 3173	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   8923: istore 10
    //   8925: aload_2
    //   8926: ldc 187
    //   8928: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8931: astore_1
    //   8932: aload_2
    //   8933: ldc_w 3428
    //   8936: ldc_w 1954
    //   8939: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   8942: istore 6
    //   8944: aload_2
    //   8945: ldc_w 3430
    //   8948: ldc_w 1954
    //   8951: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   8954: istore 7
    //   8956: ldc_w 3432
    //   8959: aload_1
    //   8960: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8963: istore 11
    //   8965: iload 10
    //   8967: aload_0
    //   8968: getfield 125	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_Boolean	Z
    //   8971: if_icmpeq -8727 -> 244
    //   8974: iload 10
    //   8976: ifeq +16 -> 8992
    //   8979: aload_0
    //   8980: iload 11
    //   8982: iload 6
    //   8984: iload 7
    //   8986: invokevirtual 3434	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZII)V
    //   8989: goto +7 -> 8996
    //   8992: aload_0
    //   8993: invokevirtual 3436	com/tencent/mobileqq/jsp/UiApiPlugin:b	()V
    //   8996: aload_0
    //   8997: iload 10
    //   8999: putfield 125	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_Boolean	Z
    //   9002: goto -8758 -> 244
    //   9005: aload_2
    //   9006: ldc_w 3438
    //   9009: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   9012: ifeq -8768 -> 244
    //   9015: aload_0
    //   9016: getfield 1947	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   9019: ifeq -8775 -> 244
    //   9022: aload_0
    //   9023: iconst_0
    //   9024: putfield 1947	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   9027: aload_2
    //   9028: ldc_w 3438
    //   9031: invokevirtual 3173	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   9034: istore 10
    //   9036: invokestatic 620	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9039: invokevirtual 3439	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   9042: astore_1
    //   9043: aload_0
    //   9044: getfield 1953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader	Lcom/tencent/mobileqq/widget/IPullRefreshHeader;
    //   9047: ifnull +53 -> 9100
    //   9050: iload 10
    //   9052: ifeq +23 -> 9075
    //   9055: aload_1
    //   9056: ldc_w 3440
    //   9059: invokevirtual 3441	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   9062: astore_1
    //   9063: aload_2
    //   9064: ldc_w 896
    //   9067: aload_1
    //   9068: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   9071: astore_1
    //   9072: goto +14 -> 9086
    //   9075: aload_1
    //   9076: ldc_w 3442
    //   9079: invokevirtual 3441	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   9082: astore_1
    //   9083: goto -20 -> 9063
    //   9086: aload_0
    //   9087: getfield 1953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader	Lcom/tencent/mobileqq/widget/IPullRefreshHeader;
    //   9090: iload 10
    //   9092: iconst_1
    //   9093: ixor
    //   9094: aload_1
    //   9095: invokeinterface 3445 3 0
    //   9100: aload_0
    //   9101: getfield 1945	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   9104: ifnull -8860 -> 244
    //   9107: aload_0
    //   9108: getfield 1945	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   9111: invokevirtual 3446	com/tencent/biz/ui/RefreshView:b	()V
    //   9114: goto -8870 -> 244
    //   9117: astore_1
    //   9118: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   9121: ifeq -8877 -> 244
    //   9124: new 703	java/lang/StringBuilder
    //   9127: dup
    //   9128: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   9131: astore_2
    //   9132: aload_2
    //   9133: ldc_w 3393
    //   9136: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9139: pop
    //   9140: aload_2
    //   9141: aload_1
    //   9142: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9145: pop
    //   9146: ldc_w 283
    //   9149: iconst_4
    //   9150: aload_2
    //   9151: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9154: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9157: goto -8913 -> 244
    //   9160: ldc_w 3448
    //   9163: aload 4
    //   9165: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9168: ifeq +193 -> 9361
    //   9171: aload 5
    //   9173: arraylength
    //   9174: iconst_1
    //   9175: if_icmpne +186 -> 9361
    //   9178: new 146	org/json/JSONObject
    //   9181: dup
    //   9182: aload 5
    //   9184: iconst_0
    //   9185: aaload
    //   9186: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9189: astore_2
    //   9190: aload_2
    //   9191: ldc_w 3450
    //   9194: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9197: istore 6
    //   9199: aload_2
    //   9200: ldc 193
    //   9202: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9205: astore_1
    //   9206: aload_2
    //   9207: ldc_w 291
    //   9210: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9213: istore 7
    //   9215: aload_0
    //   9216: aload_2
    //   9217: ldc_w 906
    //   9220: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9223: putfield 2964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9226: new 162	android/content/Intent
    //   9229: dup
    //   9230: getstatic 3454	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   9233: ldc_w 3456
    //   9236: invokespecial 535	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   9239: astore_2
    //   9240: aload_2
    //   9241: ldc_w 3458
    //   9244: iload 6
    //   9246: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   9249: pop
    //   9250: aload_2
    //   9251: ldc_w 3460
    //   9254: aload_1
    //   9255: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   9258: pop
    //   9259: aload_2
    //   9260: ldc_w 3462
    //   9263: iload 7
    //   9265: invokevirtual 548	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   9268: pop
    //   9269: aload_2
    //   9270: ldc_w 3464
    //   9273: bipush 6
    //   9275: invokevirtual 3467	android/content/Intent:putExtra	(Ljava/lang/String;B)Landroid/content/Intent;
    //   9278: pop
    //   9279: aload_0
    //   9280: aload_2
    //   9281: bipush 6
    //   9283: invokevirtual 2014	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   9286: goto -9042 -> 244
    //   9289: astore_1
    //   9290: aload_1
    //   9291: invokevirtual 970	java/lang/Exception:printStackTrace	()V
    //   9294: aload_0
    //   9295: getfield 2964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9298: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9301: ifne -9057 -> 244
    //   9304: aload_0
    //   9305: aload_0
    //   9306: getfield 2964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9309: iconst_1
    //   9310: anewarray 363	java/lang/String
    //   9313: dup
    //   9314: iconst_0
    //   9315: ldc_w 3469
    //   9318: aastore
    //   9319: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9322: goto -9078 -> 244
    //   9325: astore_1
    //   9326: aload_1
    //   9327: invokevirtual 2859	org/json/JSONException:printStackTrace	()V
    //   9330: aload_0
    //   9331: getfield 2964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9334: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9337: ifne -9093 -> 244
    //   9340: aload_0
    //   9341: aload_0
    //   9342: getfield 2964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9345: iconst_1
    //   9346: anewarray 363	java/lang/String
    //   9349: dup
    //   9350: iconst_0
    //   9351: ldc_w 3469
    //   9354: aastore
    //   9355: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9358: goto -9114 -> 244
    //   9361: ldc_w 3471
    //   9364: aload 4
    //   9366: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9369: ifeq +241 -> 9610
    //   9372: aload_0
    //   9373: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9376: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   9379: astore_1
    //   9380: aload_0
    //   9381: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9384: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   9387: astore_2
    //   9388: aload_1
    //   9389: ifnull -9145 -> 244
    //   9392: aload_2
    //   9393: ifnull -9149 -> 244
    //   9396: new 146	org/json/JSONObject
    //   9399: dup
    //   9400: aload 5
    //   9402: iconst_0
    //   9403: aaload
    //   9404: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9407: astore 4
    //   9409: aload 4
    //   9411: ldc_w 906
    //   9414: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9417: astore_2
    //   9418: aload 4
    //   9420: ldc_w 2703
    //   9423: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   9426: invokestatic 3475	com/tencent/mobileqq/nearby/NearbyURLSafeUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9429: astore_1
    //   9430: aload 4
    //   9432: ldc_w 3477
    //   9435: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9438: astore_3
    //   9439: aload 4
    //   9441: ldc_w 1075
    //   9444: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   9447: istore 7
    //   9449: aload 4
    //   9451: ldc_w 3479
    //   9454: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   9457: ifeq +8638 -> 18095
    //   9460: aload 4
    //   9462: ldc_w 3479
    //   9465: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   9468: istore 6
    //   9470: goto +3 -> 9473
    //   9473: new 379	android/os/Bundle
    //   9476: dup
    //   9477: invokespecial 380	android/os/Bundle:<init>	()V
    //   9480: astore 4
    //   9482: aload 4
    //   9484: ldc_w 2703
    //   9487: aload_1
    //   9488: invokevirtual 515	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9491: aload_3
    //   9492: ifnull +12 -> 9504
    //   9495: aload 4
    //   9497: ldc_w 3477
    //   9500: aload_3
    //   9501: invokevirtual 515	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9504: aload 4
    //   9506: ldc_w 3481
    //   9509: iload 7
    //   9511: invokevirtual 661	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9514: aload 4
    //   9516: ldc_w 1707
    //   9519: ldc_w 3471
    //   9522: invokevirtual 515	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9525: aload 4
    //   9527: ldc_w 3479
    //   9530: iload 6
    //   9532: invokevirtual 661	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9535: ldc_w 3483
    //   9538: aload_2
    //   9539: aload_0
    //   9540: getfield 121	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver	Lcom/tencent/mobileqq/emosm/OnRemoteRespObserver;
    //   9543: getfield 3488	com/tencent/mobileqq/emosm/OnRemoteRespObserver:key	I
    //   9546: aload 4
    //   9548: invokestatic 3493	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   9551: astore_1
    //   9552: ldc_w 3495
    //   9555: invokestatic 574	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   9558: checkcast 3495	com/tencent/mobileqq/emosm/api/IWebIPCOperatorApi
    //   9561: aload_1
    //   9562: invokeinterface 3498 2 0
    //   9567: goto -9323 -> 244
    //   9570: astore_1
    //   9571: goto +6 -> 9577
    //   9574: astore_1
    //   9575: aconst_null
    //   9576: astore_2
    //   9577: aload_2
    //   9578: ifnull -9334 -> 244
    //   9581: aload_0
    //   9582: aload_2
    //   9583: iconst_1
    //   9584: anewarray 363	java/lang/String
    //   9587: dup
    //   9588: iconst_0
    //   9589: ldc_w 3500
    //   9592: iconst_1
    //   9593: anewarray 355	java/lang/Object
    //   9596: dup
    //   9597: iconst_0
    //   9598: aload_1
    //   9599: aastore
    //   9600: invokestatic 1542	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9603: aastore
    //   9604: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9607: goto -9363 -> 244
    //   9610: ldc_w 3502
    //   9613: aload 4
    //   9615: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9618: ifeq +372 -> 9990
    //   9621: aload_0
    //   9622: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9625: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   9628: astore_1
    //   9629: aload_0
    //   9630: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   9633: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   9636: astore_2
    //   9637: aload_1
    //   9638: ifnull -9394 -> 244
    //   9641: aload_2
    //   9642: ifnull -9398 -> 244
    //   9645: new 146	org/json/JSONObject
    //   9648: dup
    //   9649: aload 5
    //   9651: iconst_0
    //   9652: aaload
    //   9653: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9656: astore 5
    //   9658: aload 5
    //   9660: ldc_w 906
    //   9663: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9666: astore_2
    //   9667: aload 5
    //   9669: ldc_w 2703
    //   9672: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9675: invokestatic 3475	com/tencent/mobileqq/nearby/NearbyURLSafeUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9678: astore_1
    //   9679: aload 5
    //   9681: ldc_w 2701
    //   9684: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9687: astore_3
    //   9688: aload 5
    //   9690: ldc_w 3504
    //   9693: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9696: astore 4
    //   9698: aload_3
    //   9699: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9702: istore 10
    //   9704: iload 10
    //   9706: ifne +5 -> 9711
    //   9709: aload_3
    //   9710: astore_1
    //   9711: aload 5
    //   9713: ldc_w 3477
    //   9716: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9719: astore_3
    //   9720: aload 5
    //   9722: ldc_w 1075
    //   9725: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9728: istore 6
    //   9730: aload 5
    //   9732: ldc_w 3506
    //   9735: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9738: istore 7
    //   9740: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9743: ifeq +44 -> 9787
    //   9746: new 703	java/lang/StringBuilder
    //   9749: dup
    //   9750: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   9753: astore 14
    //   9755: aload 14
    //   9757: ldc_w 3508
    //   9760: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9763: pop
    //   9764: aload 14
    //   9766: aload 5
    //   9768: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   9771: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9774: pop
    //   9775: ldc_w 283
    //   9778: iconst_2
    //   9779: aload 14
    //   9781: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9784: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9787: aload_1
    //   9788: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9791: ifne +135 -> 9926
    //   9794: new 379	android/os/Bundle
    //   9797: dup
    //   9798: invokespecial 380	android/os/Bundle:<init>	()V
    //   9801: astore 5
    //   9803: aload 5
    //   9805: ldc_w 1075
    //   9808: iload 6
    //   9810: invokevirtual 661	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9813: aload 5
    //   9815: ldc_w 2703
    //   9818: aload_1
    //   9819: invokevirtual 515	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9822: aload 5
    //   9824: ldc_w 3510
    //   9827: iload 10
    //   9829: iconst_1
    //   9830: ixor
    //   9831: invokevirtual 502	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   9834: aload 5
    //   9836: ldc_w 1707
    //   9839: ldc_w 3502
    //   9842: invokevirtual 515	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9845: aload 5
    //   9847: ldc_w 3506
    //   9850: iload 7
    //   9852: invokevirtual 661	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9855: aload_3
    //   9856: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9859: ifne +12 -> 9871
    //   9862: aload 5
    //   9864: ldc_w 3477
    //   9867: aload_3
    //   9868: invokevirtual 515	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9871: aload 4
    //   9873: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9876: ifne +13 -> 9889
    //   9879: aload 5
    //   9881: ldc_w 3504
    //   9884: aload 4
    //   9886: invokevirtual 515	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9889: ldc_w 3483
    //   9892: aload_2
    //   9893: aload_0
    //   9894: getfield 121	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver	Lcom/tencent/mobileqq/emosm/OnRemoteRespObserver;
    //   9897: getfield 3488	com/tencent/mobileqq/emosm/OnRemoteRespObserver:key	I
    //   9900: aload 5
    //   9902: invokestatic 3493	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   9905: astore_1
    //   9906: ldc_w 3495
    //   9909: invokestatic 574	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   9912: checkcast 3495	com/tencent/mobileqq/emosm/api/IWebIPCOperatorApi
    //   9915: aload_1
    //   9916: invokeinterface 3498 2 0
    //   9921: aconst_null
    //   9922: astore_1
    //   9923: goto +7 -> 9930
    //   9926: ldc_w 3512
    //   9929: astore_1
    //   9930: goto +33 -> 9963
    //   9933: astore_3
    //   9934: aload_2
    //   9935: astore_1
    //   9936: goto +8 -> 9944
    //   9939: astore_2
    //   9940: aconst_null
    //   9941: astore_1
    //   9942: aload_2
    //   9943: astore_3
    //   9944: ldc_w 3500
    //   9947: iconst_1
    //   9948: anewarray 355	java/lang/Object
    //   9951: dup
    //   9952: iconst_0
    //   9953: aload_3
    //   9954: aastore
    //   9955: invokestatic 1542	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9958: astore_3
    //   9959: aload_1
    //   9960: astore_2
    //   9961: aload_3
    //   9962: astore_1
    //   9963: aload_1
    //   9964: ifnull -9720 -> 244
    //   9967: aload_2
    //   9968: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9971: ifne -9727 -> 244
    //   9974: aload_0
    //   9975: aload_2
    //   9976: iconst_1
    //   9977: anewarray 363	java/lang/String
    //   9980: dup
    //   9981: iconst_0
    //   9982: aload_1
    //   9983: aastore
    //   9984: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9987: goto -9743 -> 244
    //   9990: ldc_w 3514
    //   9993: aload 4
    //   9995: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9998: ifeq +174 -> 10172
    //   10001: new 146	org/json/JSONObject
    //   10004: dup
    //   10005: aload 5
    //   10007: iconst_0
    //   10008: aaload
    //   10009: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10012: astore_1
    //   10013: aload_1
    //   10014: ldc_w 906
    //   10017: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10020: astore_2
    //   10021: aload_1
    //   10022: ldc_w 3390
    //   10025: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   10028: ifeq -9784 -> 244
    //   10031: aload_1
    //   10032: ldc_w 3390
    //   10035: invokevirtual 348	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   10038: istore 10
    //   10040: aload_0
    //   10041: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10044: aload_0
    //   10045: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10048: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   10051: invokevirtual 1426	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   10054: astore_1
    //   10055: aload_1
    //   10056: ifnull +37 -> 10093
    //   10059: aload_1
    //   10060: instanceof 3516
    //   10063: ifeq +30 -> 10093
    //   10066: aload_1
    //   10067: checkcast 3516	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebEventInterface
    //   10070: astore_1
    //   10071: iload 10
    //   10073: ifne +8028 -> 18101
    //   10076: iconst_1
    //   10077: istore 10
    //   10079: goto +3 -> 10082
    //   10082: aload_1
    //   10083: iload 10
    //   10085: invokeinterface 3517 2 0
    //   10090: goto -9846 -> 244
    //   10093: aload_0
    //   10094: iconst_m1
    //   10095: invokespecial 1738	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   10098: checkcast 3519	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting
    //   10101: astore_1
    //   10102: aload_1
    //   10103: ifnull -9859 -> 244
    //   10106: iload 10
    //   10108: ifne +7999 -> 18107
    //   10111: iconst_1
    //   10112: istore 10
    //   10114: goto +3 -> 10117
    //   10117: aload_1
    //   10118: ldc_w 3521
    //   10121: iload 10
    //   10123: invokevirtual 3523	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting:a	(Ljava/lang/String;Z)V
    //   10126: goto -9882 -> 244
    //   10129: astore_1
    //   10130: goto +6 -> 10136
    //   10133: astore_1
    //   10134: aconst_null
    //   10135: astore_2
    //   10136: aload_2
    //   10137: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10140: ifne -9896 -> 244
    //   10143: aload_0
    //   10144: aload_2
    //   10145: iconst_1
    //   10146: anewarray 363	java/lang/String
    //   10149: dup
    //   10150: iconst_0
    //   10151: ldc_w 3500
    //   10154: iconst_1
    //   10155: anewarray 355	java/lang/Object
    //   10158: dup
    //   10159: iconst_0
    //   10160: aload_1
    //   10161: aastore
    //   10162: invokestatic 1542	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10165: aastore
    //   10166: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10169: goto -9925 -> 244
    //   10172: ldc_w 3525
    //   10175: aload 4
    //   10177: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10180: ifeq +174 -> 10354
    //   10183: new 146	org/json/JSONObject
    //   10186: dup
    //   10187: aload 5
    //   10189: iconst_0
    //   10190: aaload
    //   10191: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10194: astore_1
    //   10195: aload_1
    //   10196: ldc_w 906
    //   10199: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10202: astore_2
    //   10203: aload_1
    //   10204: ldc_w 3390
    //   10207: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   10210: ifeq -9966 -> 244
    //   10213: aload_1
    //   10214: ldc_w 3390
    //   10217: invokevirtual 348	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   10220: istore 10
    //   10222: aload_0
    //   10223: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10226: aload_0
    //   10227: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10230: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   10233: invokevirtual 1426	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   10236: astore_1
    //   10237: aload_1
    //   10238: ifnull +37 -> 10275
    //   10241: aload_1
    //   10242: instanceof 3516
    //   10245: ifeq +30 -> 10275
    //   10248: aload_1
    //   10249: checkcast 3516	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebEventInterface
    //   10252: astore_1
    //   10253: iload 10
    //   10255: ifne +7858 -> 18113
    //   10258: iconst_1
    //   10259: istore 10
    //   10261: goto +3 -> 10264
    //   10264: aload_1
    //   10265: iload 10
    //   10267: invokeinterface 3526 2 0
    //   10272: goto -10028 -> 244
    //   10275: aload_0
    //   10276: iconst_m1
    //   10277: invokespecial 1738	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   10280: checkcast 3519	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting
    //   10283: astore_1
    //   10284: aload_1
    //   10285: ifnull -10041 -> 244
    //   10288: iload 10
    //   10290: ifne +7829 -> 18119
    //   10293: iconst_1
    //   10294: istore 10
    //   10296: goto +3 -> 10299
    //   10299: aload_1
    //   10300: ldc_w 3528
    //   10303: iload 10
    //   10305: invokevirtual 3523	com/tencent/mobileqq/webview/swift/component/SwiftBrowserSetting:a	(Ljava/lang/String;Z)V
    //   10308: goto -10064 -> 244
    //   10311: astore_1
    //   10312: goto +6 -> 10318
    //   10315: astore_1
    //   10316: aconst_null
    //   10317: astore_2
    //   10318: aload_2
    //   10319: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10322: ifne -10078 -> 244
    //   10325: aload_0
    //   10326: aload_2
    //   10327: iconst_1
    //   10328: anewarray 363	java/lang/String
    //   10331: dup
    //   10332: iconst_0
    //   10333: ldc_w 3500
    //   10336: iconst_1
    //   10337: anewarray 355	java/lang/Object
    //   10340: dup
    //   10341: iconst_0
    //   10342: aload_1
    //   10343: aastore
    //   10344: invokestatic 1542	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10347: aastore
    //   10348: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10351: goto -10107 -> 244
    //   10354: ldc_w 3530
    //   10357: aload 4
    //   10359: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10362: ifeq +80 -> 10442
    //   10365: new 146	org/json/JSONObject
    //   10368: dup
    //   10369: aload 5
    //   10371: iconst_0
    //   10372: aaload
    //   10373: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10376: astore_1
    //   10377: new 3532	com/tencent/mobileqq/app/SearchWordHistoryManager
    //   10380: dup
    //   10381: invokespecial 3533	com/tencent/mobileqq/app/SearchWordHistoryManager:<init>	()V
    //   10384: aload_1
    //   10385: ldc_w 3535
    //   10388: invokevirtual 1069	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   10391: invokevirtual 3538	com/tencent/mobileqq/app/SearchWordHistoryManager:a	(Lorg/json/JSONArray;)V
    //   10394: goto -10150 -> 244
    //   10397: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10400: ifeq -10156 -> 244
    //   10403: new 703	java/lang/StringBuilder
    //   10406: dup
    //   10407: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   10410: astore_1
    //   10411: aload_1
    //   10412: ldc_w 3540
    //   10415: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10418: pop
    //   10419: aload_1
    //   10420: aload 5
    //   10422: iconst_0
    //   10423: aaload
    //   10424: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10427: pop
    //   10428: ldc_w 283
    //   10431: iconst_2
    //   10432: aload_1
    //   10433: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10436: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10439: goto -10195 -> 244
    //   10442: ldc_w 3542
    //   10445: aload 4
    //   10447: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10450: ifeq +160 -> 10610
    //   10453: new 146	org/json/JSONObject
    //   10456: dup
    //   10457: aload 5
    //   10459: iconst_0
    //   10460: aaload
    //   10461: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10464: ldc_w 906
    //   10467: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10470: astore_1
    //   10471: new 3532	com/tencent/mobileqq/app/SearchWordHistoryManager
    //   10474: dup
    //   10475: invokespecial 3533	com/tencent/mobileqq/app/SearchWordHistoryManager:<init>	()V
    //   10478: astore 4
    //   10480: new 146	org/json/JSONObject
    //   10483: dup
    //   10484: invokespecial 248	org/json/JSONObject:<init>	()V
    //   10487: astore_2
    //   10488: new 1116	org/json/JSONArray
    //   10491: dup
    //   10492: invokespecial 3543	org/json/JSONArray:<init>	()V
    //   10495: astore_3
    //   10496: aload 4
    //   10498: invokevirtual 3546	com/tencent/mobileqq/app/SearchWordHistoryManager:a	()Ljava/util/ArrayList;
    //   10501: astore 4
    //   10503: iconst_0
    //   10504: istore 6
    //   10506: iload 6
    //   10508: aload 4
    //   10510: invokevirtual 3549	java/util/ArrayList:size	()I
    //   10513: if_icmpge +24 -> 10537
    //   10516: aload_3
    //   10517: aload 4
    //   10519: iload 6
    //   10521: invokevirtual 3551	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   10524: invokevirtual 3554	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   10527: pop
    //   10528: iload 6
    //   10530: iconst_1
    //   10531: iadd
    //   10532: istore 6
    //   10534: goto -28 -> 10506
    //   10537: aload_2
    //   10538: ldc_w 3535
    //   10541: aload_3
    //   10542: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   10545: pop
    //   10546: aload_0
    //   10547: aload_1
    //   10548: iconst_1
    //   10549: anewarray 363	java/lang/String
    //   10552: dup
    //   10553: iconst_0
    //   10554: aload_2
    //   10555: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   10558: aastore
    //   10559: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10562: goto -10318 -> 244
    //   10565: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10568: ifeq -10324 -> 244
    //   10571: new 703	java/lang/StringBuilder
    //   10574: dup
    //   10575: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   10578: astore_1
    //   10579: aload_1
    //   10580: ldc_w 3556
    //   10583: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10586: pop
    //   10587: aload_1
    //   10588: aload 5
    //   10590: iconst_0
    //   10591: aaload
    //   10592: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10595: pop
    //   10596: ldc_w 283
    //   10599: iconst_2
    //   10600: aload_1
    //   10601: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10604: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10607: goto -10363 -> 244
    //   10610: ldc_w 3558
    //   10613: aload 4
    //   10615: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10618: ifeq +216 -> 10834
    //   10621: aload_0
    //   10622: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10625: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   10628: astore_2
    //   10629: aload_0
    //   10630: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10633: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   10636: astore_1
    //   10637: aload_2
    //   10638: ifnull -10394 -> 244
    //   10641: aload_1
    //   10642: ifnull -10398 -> 244
    //   10645: new 146	org/json/JSONObject
    //   10648: dup
    //   10649: aload 5
    //   10651: iconst_0
    //   10652: aaload
    //   10653: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10656: astore_3
    //   10657: aload_3
    //   10658: ldc_w 906
    //   10661: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10664: astore_1
    //   10665: new 379	android/os/Bundle
    //   10668: dup
    //   10669: invokespecial 380	android/os/Bundle:<init>	()V
    //   10672: astore 4
    //   10674: aload 4
    //   10676: ldc_w 3560
    //   10679: aload_3
    //   10680: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   10683: invokevirtual 515	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   10686: aload_2
    //   10687: invokevirtual 359	java/lang/Object:getClass	()Ljava/lang/Class;
    //   10690: invokevirtual 175	java/lang/Class:getName	()Ljava/lang/String;
    //   10693: ldc_w 3562
    //   10696: invokestatic 574	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   10699: checkcast 3562	com/tencent/biz/pubaccount/api/IPublicAccountProxy
    //   10702: ldc_w 3564
    //   10705: invokeinterface 3568 2 0
    //   10710: invokevirtual 366	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   10713: istore 10
    //   10715: iload 10
    //   10717: ifeq +63 -> 10780
    //   10720: new 146	org/json/JSONObject
    //   10723: dup
    //   10724: aload 4
    //   10726: ldc_w 3560
    //   10729: invokevirtual 3569	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10732: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10735: ldc_w 3571
    //   10738: ldc_w 512
    //   10741: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10744: astore_3
    //   10745: ldc_w 3573
    //   10748: invokestatic 574	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   10751: checkcast 3573	com/tencent/biz/pubaccount/util/api/IPublicAccountUtil
    //   10754: aconst_null
    //   10755: aload_2
    //   10756: aload_3
    //   10757: invokestatic 3577	com/tencent/biz/pubaccount/subscript/SubscriptUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   10760: invokeinterface 3581 4 0
    //   10765: goto +15 -> 10780
    //   10768: astore_2
    //   10769: ldc_w 283
    //   10772: iconst_2
    //   10773: ldc_w 3583
    //   10776: aload_2
    //   10777: invokestatic 2709	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   10780: aconst_null
    //   10781: astore_2
    //   10782: goto +25 -> 10807
    //   10785: astore_2
    //   10786: goto +6 -> 10792
    //   10789: astore_2
    //   10790: aconst_null
    //   10791: astore_1
    //   10792: ldc_w 3500
    //   10795: iconst_1
    //   10796: anewarray 355	java/lang/Object
    //   10799: dup
    //   10800: iconst_0
    //   10801: aload_2
    //   10802: aastore
    //   10803: invokestatic 1542	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10806: astore_2
    //   10807: aload_2
    //   10808: ifnull -10564 -> 244
    //   10811: aload_1
    //   10812: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10815: ifne -10571 -> 244
    //   10818: aload_0
    //   10819: aload_1
    //   10820: iconst_1
    //   10821: anewarray 363	java/lang/String
    //   10824: dup
    //   10825: iconst_0
    //   10826: aload_2
    //   10827: aastore
    //   10828: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10831: goto -10587 -> 244
    //   10834: ldc_w 3585
    //   10837: aload 4
    //   10839: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10842: ifeq +263 -> 11105
    //   10845: aconst_null
    //   10846: ldc_w 865
    //   10849: ldc_w 867
    //   10852: ldc_w 512
    //   10855: ldc_w 869
    //   10858: ldc_w 3587
    //   10861: iconst_0
    //   10862: iconst_1
    //   10863: iconst_0
    //   10864: aload 5
    //   10866: iconst_0
    //   10867: aaload
    //   10868: ldc_w 512
    //   10871: ldc_w 512
    //   10874: ldc_w 512
    //   10877: invokestatic 876	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   10880: aload_0
    //   10881: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10884: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   10887: astore_2
    //   10888: aload_0
    //   10889: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   10892: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   10895: astore_1
    //   10896: aload_2
    //   10897: ifnull -10653 -> 244
    //   10900: aload_1
    //   10901: ifnull -10657 -> 244
    //   10904: new 146	org/json/JSONObject
    //   10907: dup
    //   10908: aload 5
    //   10910: iconst_0
    //   10911: aaload
    //   10912: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10915: astore 4
    //   10917: aload 4
    //   10919: ldc_w 906
    //   10922: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10925: astore_1
    //   10926: aload 4
    //   10928: ldc_w 297
    //   10931: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10934: astore_3
    //   10935: aload 4
    //   10937: ldc_w 1707
    //   10940: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10943: astore 5
    //   10945: aload 4
    //   10947: ldc_w 272
    //   10950: invokevirtual 318	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   10953: astore 4
    //   10955: ldc_w 869
    //   10958: aload 5
    //   10960: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10963: ifeq +84 -> 11047
    //   10966: aload 4
    //   10968: ifnull +79 -> 11047
    //   10971: aload 4
    //   10973: ldc_w 382
    //   10976: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10979: astore 5
    //   10981: aload 4
    //   10983: ldc_w 3281
    //   10986: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10989: astore 14
    //   10991: aload 4
    //   10993: ldc 193
    //   10995: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10998: astore 4
    //   11000: aload 5
    //   11002: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11005: ifne +27 -> 11032
    //   11008: aload 4
    //   11010: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11013: ifne +19 -> 11032
    //   11016: aload_0
    //   11017: aload_2
    //   11018: aload 5
    //   11020: aload 14
    //   11022: aload_3
    //   11023: aload 4
    //   11025: aload_1
    //   11026: invokespecial 3589	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11029: goto +18 -> 11047
    //   11032: ldc_w 3035
    //   11035: aconst_null
    //   11036: ldc_w 3591
    //   11039: aload_3
    //   11040: invokestatic 863	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11043: astore_2
    //   11044: goto +34 -> 11078
    //   11047: aconst_null
    //   11048: astore_2
    //   11049: goto +29 -> 11078
    //   11052: astore_2
    //   11053: goto +12 -> 11065
    //   11056: astore_2
    //   11057: goto +6 -> 11063
    //   11060: astore_2
    //   11061: aconst_null
    //   11062: astore_1
    //   11063: aconst_null
    //   11064: astore_3
    //   11065: ldc_w 3593
    //   11068: aconst_null
    //   11069: aload_2
    //   11070: invokevirtual 1359	java/lang/Exception:toString	()Ljava/lang/String;
    //   11073: aload_3
    //   11074: invokestatic 863	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11077: astore_2
    //   11078: aload_2
    //   11079: ifnull -10835 -> 244
    //   11082: aload_1
    //   11083: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11086: ifne -10842 -> 244
    //   11089: aload_0
    //   11090: aload_1
    //   11091: iconst_1
    //   11092: anewarray 363	java/lang/String
    //   11095: dup
    //   11096: iconst_0
    //   11097: aload_2
    //   11098: aastore
    //   11099: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11102: goto -10858 -> 244
    //   11105: ldc_w 3595
    //   11108: aload 4
    //   11110: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11113: ifeq +327 -> 11440
    //   11116: aload 5
    //   11118: arraylength
    //   11119: ifle +321 -> 11440
    //   11122: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11125: ifeq +39 -> 11164
    //   11128: new 703	java/lang/StringBuilder
    //   11131: dup
    //   11132: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   11135: astore_1
    //   11136: aload_1
    //   11137: ldc_w 3597
    //   11140: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11143: pop
    //   11144: aload_1
    //   11145: aload 5
    //   11147: iconst_0
    //   11148: aaload
    //   11149: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11152: pop
    //   11153: ldc_w 3599
    //   11156: iconst_2
    //   11157: aload_1
    //   11158: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11161: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11164: new 146	org/json/JSONObject
    //   11167: dup
    //   11168: aload 5
    //   11170: iconst_0
    //   11171: aaload
    //   11172: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11175: ldc 193
    //   11177: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11180: astore_3
    //   11181: aload_3
    //   11182: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11185: ifne -10941 -> 244
    //   11188: aload_3
    //   11189: ldc_w 3601
    //   11192: invokevirtual 3605	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   11195: astore_1
    //   11196: new 2426	java/util/HashMap
    //   11199: dup
    //   11200: invokespecial 3606	java/util/HashMap:<init>	()V
    //   11203: astore_2
    //   11204: aload_1
    //   11205: arraylength
    //   11206: iconst_1
    //   11207: if_icmple -10963 -> 244
    //   11210: aload_1
    //   11211: iconst_1
    //   11212: aaload
    //   11213: ldc_w 3608
    //   11216: invokevirtual 3605	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   11219: astore_1
    //   11220: aload_1
    //   11221: arraylength
    //   11222: istore 7
    //   11224: iconst_0
    //   11225: istore 6
    //   11227: iload 6
    //   11229: iload 7
    //   11231: if_icmpge +49 -> 11280
    //   11234: aload_1
    //   11235: iload 6
    //   11237: aaload
    //   11238: bipush 61
    //   11240: invokevirtual 3611	java/lang/String:indexOf	(I)I
    //   11243: istore 8
    //   11245: iload 8
    //   11247: iconst_m1
    //   11248: if_icmpeq +6877 -> 18125
    //   11251: aload_2
    //   11252: aload_1
    //   11253: iload 6
    //   11255: aaload
    //   11256: iconst_0
    //   11257: iload 8
    //   11259: invokevirtual 3615	java/lang/String:substring	(II)Ljava/lang/String;
    //   11262: aload_1
    //   11263: iload 6
    //   11265: aaload
    //   11266: iload 8
    //   11268: iconst_1
    //   11269: iadd
    //   11270: invokevirtual 3617	java/lang/String:substring	(I)Ljava/lang/String;
    //   11273: invokevirtual 2435	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   11276: pop
    //   11277: goto +6848 -> 18125
    //   11280: aload_3
    //   11281: ldc_w 2065
    //   11284: invokevirtual 460	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11287: ifeq +27 -> 11314
    //   11290: aload_2
    //   11291: ldc_w 667
    //   11294: invokevirtual 3618	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11297: checkcast 363	java/lang/String
    //   11300: astore_1
    //   11301: aload_2
    //   11302: ldc 250
    //   11304: invokevirtual 3618	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11307: checkcast 363	java/lang/String
    //   11310: astore_2
    //   11311: goto +25 -> 11336
    //   11314: aload_2
    //   11315: ldc_w 3376
    //   11318: invokevirtual 3618	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11321: checkcast 363	java/lang/String
    //   11324: astore_1
    //   11325: aload_2
    //   11326: ldc_w 3620
    //   11329: invokevirtual 3618	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11332: checkcast 363	java/lang/String
    //   11335: astore_2
    //   11336: aload_0
    //   11337: aload_1
    //   11338: aload_2
    //   11339: aload_3
    //   11340: invokevirtual 3622	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   11343: ifne -11099 -> 244
    //   11346: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11349: ifeq +13 -> 11362
    //   11352: ldc_w 3599
    //   11355: iconst_2
    //   11356: ldc_w 2743
    //   11359: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11362: aload_0
    //   11363: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11366: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   11369: aload_0
    //   11370: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11373: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   11376: aload_0
    //   11377: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11380: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   11383: aload 5
    //   11385: iconst_0
    //   11386: aaload
    //   11387: iconst_0
    //   11388: iconst_0
    //   11389: invokestatic 2748	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;ZZ)V
    //   11392: goto -11148 -> 244
    //   11395: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11398: ifeq -11154 -> 244
    //   11401: new 703	java/lang/StringBuilder
    //   11404: dup
    //   11405: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   11408: astore_1
    //   11409: aload_1
    //   11410: ldc_w 3624
    //   11413: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11416: pop
    //   11417: aload_1
    //   11418: aload 5
    //   11420: iconst_0
    //   11421: aaload
    //   11422: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11425: pop
    //   11426: ldc_w 3599
    //   11429: iconst_2
    //   11430: aload_1
    //   11431: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11434: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11437: goto -11193 -> 244
    //   11440: ldc_w 3626
    //   11443: aload 4
    //   11445: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11448: ifeq +72 -> 11520
    //   11451: aload 5
    //   11453: arraylength
    //   11454: ifle +66 -> 11520
    //   11457: aload_0
    //   11458: new 146	org/json/JSONObject
    //   11461: dup
    //   11462: aload 5
    //   11464: iconst_0
    //   11465: aaload
    //   11466: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11469: invokevirtual 3628	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;)V
    //   11472: goto -11228 -> 244
    //   11475: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11478: ifeq -11234 -> 244
    //   11481: new 703	java/lang/StringBuilder
    //   11484: dup
    //   11485: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   11488: astore_1
    //   11489: aload_1
    //   11490: ldc_w 3630
    //   11493: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11496: pop
    //   11497: aload_1
    //   11498: aload 5
    //   11500: iconst_0
    //   11501: aaload
    //   11502: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11505: pop
    //   11506: ldc_w 283
    //   11509: iconst_2
    //   11510: aload_1
    //   11511: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11514: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11517: goto -11273 -> 244
    //   11520: ldc_w 3632
    //   11523: aload 4
    //   11525: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11528: ifeq +10 -> 11538
    //   11531: aload_0
    //   11532: invokevirtual 3633	com/tencent/mobileqq/jsp/UiApiPlugin:c	()V
    //   11535: goto -11291 -> 244
    //   11538: ldc_w 3635
    //   11541: aload 4
    //   11543: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11546: ifeq +78 -> 11624
    //   11549: aload 5
    //   11551: arraylength
    //   11552: ifle +72 -> 11624
    //   11555: aload_0
    //   11556: new 146	org/json/JSONObject
    //   11559: dup
    //   11560: aload 5
    //   11562: iconst_0
    //   11563: aaload
    //   11564: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11567: ldc_w 906
    //   11570: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11573: invokevirtual 3636	com/tencent/mobileqq/jsp/UiApiPlugin:b	(Ljava/lang/String;)V
    //   11576: goto -11332 -> 244
    //   11579: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11582: ifeq -11338 -> 244
    //   11585: new 703	java/lang/StringBuilder
    //   11588: dup
    //   11589: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   11592: astore_1
    //   11593: aload_1
    //   11594: ldc_w 3540
    //   11597: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11600: pop
    //   11601: aload_1
    //   11602: aload 5
    //   11604: iconst_0
    //   11605: aaload
    //   11606: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11609: pop
    //   11610: ldc_w 283
    //   11613: iconst_2
    //   11614: aload_1
    //   11615: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11618: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11621: goto -11377 -> 244
    //   11624: ldc_w 3638
    //   11627: aload 4
    //   11629: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11632: ifeq +143 -> 11775
    //   11635: new 146	org/json/JSONObject
    //   11638: dup
    //   11639: aload 5
    //   11641: iconst_0
    //   11642: aaload
    //   11643: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11646: astore_1
    //   11647: aload_0
    //   11648: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11651: invokevirtual 1755	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebViewProviderInterface;
    //   11654: astore_2
    //   11655: aload_2
    //   11656: ifnull -11412 -> 244
    //   11659: aload_2
    //   11660: invokeinterface 1761 1 0
    //   11665: ifnull -11421 -> 244
    //   11668: aload_2
    //   11669: invokeinterface 1761 1 0
    //   11674: aload_1
    //   11675: invokeinterface 3639 2 0
    //   11680: goto -11436 -> 244
    //   11683: astore_1
    //   11684: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11687: ifeq -11443 -> 244
    //   11690: new 703	java/lang/StringBuilder
    //   11693: dup
    //   11694: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   11697: astore_2
    //   11698: aload_2
    //   11699: ldc_w 3641
    //   11702: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11705: pop
    //   11706: aload_2
    //   11707: aload_1
    //   11708: invokevirtual 1359	java/lang/Exception:toString	()Ljava/lang/String;
    //   11711: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11714: pop
    //   11715: ldc_w 283
    //   11718: iconst_2
    //   11719: aload_2
    //   11720: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11723: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11726: goto -11482 -> 244
    //   11729: astore_1
    //   11730: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11733: ifeq -11489 -> 244
    //   11736: new 703	java/lang/StringBuilder
    //   11739: dup
    //   11740: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   11743: astore_2
    //   11744: aload_2
    //   11745: ldc_w 3641
    //   11748: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11751: pop
    //   11752: aload_2
    //   11753: aload_1
    //   11754: invokevirtual 3642	org/json/JSONException:toString	()Ljava/lang/String;
    //   11757: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11760: pop
    //   11761: ldc_w 283
    //   11764: iconst_2
    //   11765: aload_2
    //   11766: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11769: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11772: goto -11528 -> 244
    //   11775: ldc_w 3644
    //   11778: aload 4
    //   11780: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11783: ifeq +204 -> 11987
    //   11786: aload 5
    //   11788: arraylength
    //   11789: ifle +198 -> 11987
    //   11792: new 146	org/json/JSONObject
    //   11795: dup
    //   11796: aload 5
    //   11798: iconst_0
    //   11799: aaload
    //   11800: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11803: ldc_w 906
    //   11806: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11809: astore_1
    //   11810: aload_1
    //   11811: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11814: ifeq +15 -> 11829
    //   11817: ldc_w 283
    //   11820: iconst_1
    //   11821: ldc_w 3646
    //   11824: invokestatic 1130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11827: iconst_1
    //   11828: ireturn
    //   11829: new 146	org/json/JSONObject
    //   11832: dup
    //   11833: invokespecial 248	org/json/JSONObject:<init>	()V
    //   11836: astore_2
    //   11837: new 146	org/json/JSONObject
    //   11840: dup
    //   11841: invokespecial 248	org/json/JSONObject:<init>	()V
    //   11844: astore_3
    //   11845: aload_0
    //   11846: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11849: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   11852: invokevirtual 848	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   11855: ldc_w 849
    //   11858: invokevirtual 854	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   11861: istore 7
    //   11863: iload 7
    //   11865: istore 6
    //   11867: invokestatic 1882	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   11870: iconst_1
    //   11871: if_icmpne +18 -> 11889
    //   11874: iload 7
    //   11876: aload_0
    //   11877: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11880: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   11883: invokestatic 1885	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   11886: iadd
    //   11887: istore 6
    //   11889: aload_3
    //   11890: ldc_w 1801
    //   11893: iload 6
    //   11895: invokevirtual 270	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11898: pop
    //   11899: aload_2
    //   11900: ldc_w 1785
    //   11903: iconst_0
    //   11904: invokevirtual 270	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11907: pop
    //   11908: aload_2
    //   11909: ldc_w 295
    //   11912: ldc_w 3648
    //   11915: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   11918: pop
    //   11919: aload_2
    //   11920: ldc_w 272
    //   11923: aload_3
    //   11924: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   11927: pop
    //   11928: aload_0
    //   11929: aload_1
    //   11930: iconst_1
    //   11931: anewarray 363	java/lang/String
    //   11934: dup
    //   11935: iconst_0
    //   11936: aload_2
    //   11937: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   11940: aastore
    //   11941: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11944: goto -11700 -> 244
    //   11947: astore_1
    //   11948: new 703	java/lang/StringBuilder
    //   11951: dup
    //   11952: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   11955: astore_2
    //   11956: aload_2
    //   11957: ldc_w 3650
    //   11960: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11963: pop
    //   11964: aload_2
    //   11965: aload_1
    //   11966: invokestatic 2810	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   11969: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11972: pop
    //   11973: ldc_w 283
    //   11976: iconst_1
    //   11977: aload_2
    //   11978: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11981: invokestatic 1130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11984: goto -11740 -> 244
    //   11987: ldc_w 3652
    //   11990: aload 4
    //   11992: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11995: ifeq +77 -> 12072
    //   11998: new 146	org/json/JSONObject
    //   12001: dup
    //   12002: aload 5
    //   12004: iconst_0
    //   12005: aaload
    //   12006: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12009: astore_1
    //   12010: aload_1
    //   12011: ldc_w 667
    //   12014: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12017: astore_2
    //   12018: aload_0
    //   12019: aload_1
    //   12020: ldc_w 906
    //   12023: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12026: putfield 3654	com/tencent/mobileqq/jsp/UiApiPlugin:m	Ljava/lang/String;
    //   12029: aload_0
    //   12030: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   12033: ifnonnull +17 -> 12050
    //   12036: aload_0
    //   12037: invokestatic 2027	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   12040: putfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   12043: aload_0
    //   12044: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   12047: invokevirtual 2029	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   12050: aload_0
    //   12051: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   12054: aload_2
    //   12055: new 3656	com/tencent/mobileqq/jsp/UiApiPlugin$4
    //   12058: dup
    //   12059: aload_0
    //   12060: aload_2
    //   12061: invokespecial 3657	com/tencent/mobileqq/jsp/UiApiPlugin$4:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   12064: invokevirtual 3660	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/String;Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi$Callback;)V
    //   12067: goto -11823 -> 244
    //   12070: iconst_1
    //   12071: ireturn
    //   12072: ldc_w 3662
    //   12075: aload 4
    //   12077: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12080: ifeq +456 -> 12536
    //   12083: aload 5
    //   12085: arraylength
    //   12086: iconst_1
    //   12087: if_icmpne +449 -> 12536
    //   12090: new 146	org/json/JSONObject
    //   12093: dup
    //   12094: aload 5
    //   12096: iconst_0
    //   12097: aaload
    //   12098: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12101: astore_3
    //   12102: aload_3
    //   12103: ldc_w 3664
    //   12106: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12109: astore 4
    //   12111: aload_3
    //   12112: ldc_w 3666
    //   12115: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12118: astore_1
    //   12119: aload_1
    //   12120: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12123: ifeq +22 -> 12145
    //   12126: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12129: ifeq +6005 -> 18134
    //   12132: ldc_w 3668
    //   12135: iconst_2
    //   12136: ldc_w 3670
    //   12139: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12142: goto +5992 -> 18134
    //   12145: aload_0
    //   12146: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   12149: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   12152: astore_2
    //   12153: aload_2
    //   12154: ifnull +274 -> 12428
    //   12157: aload_2
    //   12158: invokevirtual 3674	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   12161: ifnonnull +6 -> 12167
    //   12164: goto +264 -> 12428
    //   12167: aload_2
    //   12168: invokevirtual 3674	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   12171: getfield 3677	com/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo:jdField_a_of_type_Int	I
    //   12174: invokestatic 2146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12177: astore_2
    //   12178: aload_3
    //   12179: ldc_w 3363
    //   12182: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   12185: istore 6
    //   12187: iload 6
    //   12189: iconst_1
    //   12190: if_icmpne +188 -> 12378
    //   12193: new 3679	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   12196: dup
    //   12197: invokespecial 3680	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   12200: astore_3
    //   12201: aload_3
    //   12202: getfield 3683	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12205: sipush 1814
    //   12208: invokevirtual 772	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12211: aload_3
    //   12212: getfield 3686	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12215: bipush 48
    //   12217: invokevirtual 772	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12220: aload_1
    //   12221: invokevirtual 3689	java/lang/String:getBytes	()[B
    //   12224: arraylength
    //   12225: bipush 6
    //   12227: iadd
    //   12228: invokestatic 3695	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   12231: astore 4
    //   12233: aload 4
    //   12235: aload_2
    //   12236: invokevirtual 2584	java/lang/Integer:intValue	()I
    //   12239: invokevirtual 3697	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   12242: pop
    //   12243: aload 4
    //   12245: aload_1
    //   12246: invokevirtual 3689	java/lang/String:getBytes	()[B
    //   12249: arraylength
    //   12250: i2s
    //   12251: invokevirtual 3701	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   12254: pop
    //   12255: aload 4
    //   12257: aload_1
    //   12258: invokevirtual 3689	java/lang/String:getBytes	()[B
    //   12261: invokevirtual 3704	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   12264: pop
    //   12265: aload_3
    //   12266: getfield 3708	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12269: aload 4
    //   12271: invokevirtual 3711	java/nio/ByteBuffer:array	()[B
    //   12274: invokestatic 3717	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12277: invokevirtual 3722	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   12280: new 799	mqq/app/NewIntent
    //   12283: dup
    //   12284: aload_0
    //   12285: invokevirtual 2186	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   12288: ldc_w 801
    //   12291: invokespecial 802	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12294: astore_2
    //   12295: new 379	android/os/Bundle
    //   12298: dup
    //   12299: invokespecial 380	android/os/Bundle:<init>	()V
    //   12302: astore 4
    //   12304: aload 4
    //   12306: ldc_w 3666
    //   12309: aload_1
    //   12310: invokevirtual 515	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   12313: aload_2
    //   12314: aload 4
    //   12316: invokevirtual 3723	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   12319: pop
    //   12320: aload_2
    //   12321: ldc_w 807
    //   12324: ldc_w 3725
    //   12327: invokevirtual 810	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12330: pop
    //   12331: aload_2
    //   12332: ldc_w 272
    //   12335: aload_3
    //   12336: invokevirtual 3726	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   12339: invokevirtual 817	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   12342: pop
    //   12343: aload_2
    //   12344: ldc_w 3728
    //   12347: iconst_1
    //   12348: invokevirtual 3729	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12351: pop
    //   12352: aload_2
    //   12353: new 3731	com/tencent/mobileqq/jsp/UiApiPlugin$5
    //   12356: dup
    //   12357: aload_0
    //   12358: invokespecial 3732	com/tencent/mobileqq/jsp/UiApiPlugin$5:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   12361: invokevirtual 826	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   12364: aload_0
    //   12365: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   12368: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   12371: aload_2
    //   12372: invokevirtual 832	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   12375: goto -12131 -> 244
    //   12378: iload 6
    //   12380: ifne -12136 -> 244
    //   12383: aload_0
    //   12384: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   12387: ifnonnull +17 -> 12404
    //   12390: aload_0
    //   12391: invokestatic 2027	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   12394: putfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   12397: aload_0
    //   12398: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   12401: invokevirtual 2029	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   12404: aload_0
    //   12405: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   12408: aload_2
    //   12409: aload_1
    //   12410: aload 4
    //   12412: new 3734	com/tencent/mobileqq/jsp/UiApiPlugin$6
    //   12415: dup
    //   12416: aload_0
    //   12417: aload_2
    //   12418: aload_1
    //   12419: invokespecial 3737	com/tencent/mobileqq/jsp/UiApiPlugin$6:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;)V
    //   12422: invokevirtual 3740	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi$Callback;)V
    //   12425: goto -12181 -> 244
    //   12428: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12431: ifeq +13 -> 12444
    //   12434: ldc_w 3668
    //   12437: iconst_2
    //   12438: ldc_w 3742
    //   12441: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12444: iconst_1
    //   12445: ireturn
    //   12446: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12449: ifeq -12205 -> 244
    //   12452: new 703	java/lang/StringBuilder
    //   12455: dup
    //   12456: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   12459: astore_1
    //   12460: aload_1
    //   12461: ldc_w 3744
    //   12464: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12467: pop
    //   12468: aload_1
    //   12469: aload 5
    //   12471: iconst_0
    //   12472: aaload
    //   12473: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12476: pop
    //   12477: ldc_w 283
    //   12480: iconst_2
    //   12481: aload_1
    //   12482: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12485: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12488: goto -12244 -> 244
    //   12491: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12494: ifeq -12250 -> 244
    //   12497: new 703	java/lang/StringBuilder
    //   12500: dup
    //   12501: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   12504: astore_1
    //   12505: aload_1
    //   12506: ldc_w 3746
    //   12509: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12512: pop
    //   12513: aload_1
    //   12514: aload 5
    //   12516: iconst_0
    //   12517: aaload
    //   12518: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12521: pop
    //   12522: ldc_w 283
    //   12525: iconst_2
    //   12526: aload_1
    //   12527: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12530: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12533: goto -12289 -> 244
    //   12536: ldc_w 3748
    //   12539: aload 4
    //   12541: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12544: ifeq +489 -> 13033
    //   12547: aload 5
    //   12549: arraylength
    //   12550: iconst_1
    //   12551: if_icmpne +482 -> 13033
    //   12554: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12557: ifeq +39 -> 12596
    //   12560: new 703	java/lang/StringBuilder
    //   12563: dup
    //   12564: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   12567: astore_1
    //   12568: aload_1
    //   12569: ldc_w 3750
    //   12572: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12575: pop
    //   12576: aload_1
    //   12577: aload 5
    //   12579: iconst_0
    //   12580: aaload
    //   12581: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12584: pop
    //   12585: ldc_w 3668
    //   12588: iconst_2
    //   12589: aload_1
    //   12590: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12593: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12596: new 146	org/json/JSONObject
    //   12599: dup
    //   12600: aload 5
    //   12602: iconst_0
    //   12603: aaload
    //   12604: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12607: astore_3
    //   12608: aload_3
    //   12609: ldc_w 3664
    //   12612: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12615: astore_2
    //   12616: aload_3
    //   12617: ldc_w 3666
    //   12620: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12623: astore_1
    //   12624: aload_3
    //   12625: ldc_w 3752
    //   12628: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12631: astore_3
    //   12632: aload_1
    //   12633: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12636: ifne +252 -> 12888
    //   12639: aload_3
    //   12640: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12643: ifeq +6 -> 12649
    //   12646: goto +242 -> 12888
    //   12649: aload_0
    //   12650: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   12653: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   12656: astore 4
    //   12658: aload 4
    //   12660: ifnull +209 -> 12869
    //   12663: aload 4
    //   12665: invokevirtual 3674	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   12668: ifnonnull +6 -> 12674
    //   12671: goto +198 -> 12869
    //   12674: aload 4
    //   12676: invokevirtual 3674	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lcom/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo;
    //   12679: getfield 3677	com/tencent/biz/pubaccount/CustomWebView$OpenApiTokenInfo:jdField_a_of_type_Int	I
    //   12682: invokestatic 2146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12685: astore 4
    //   12687: new 3679	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   12690: dup
    //   12691: invokespecial 3680	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   12694: astore 14
    //   12696: aload 14
    //   12698: getfield 3683	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12701: sipush 1814
    //   12704: invokevirtual 772	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12707: aload 14
    //   12709: getfield 3686	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12712: bipush 48
    //   12714: invokevirtual 772	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12717: aload_3
    //   12718: invokevirtual 3689	java/lang/String:getBytes	()[B
    //   12721: arraylength
    //   12722: bipush 6
    //   12724: iadd
    //   12725: invokestatic 3695	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   12728: astore 15
    //   12730: aload 15
    //   12732: aload 4
    //   12734: invokevirtual 2584	java/lang/Integer:intValue	()I
    //   12737: invokevirtual 3697	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   12740: pop
    //   12741: aload 15
    //   12743: aload_3
    //   12744: invokevirtual 3689	java/lang/String:getBytes	()[B
    //   12747: arraylength
    //   12748: i2s
    //   12749: invokevirtual 3701	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   12752: pop
    //   12753: aload 15
    //   12755: aload_3
    //   12756: invokevirtual 3689	java/lang/String:getBytes	()[B
    //   12759: invokevirtual 3704	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   12762: pop
    //   12763: aload 14
    //   12765: getfield 3708	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12768: aload 15
    //   12770: invokevirtual 3711	java/nio/ByteBuffer:array	()[B
    //   12773: invokestatic 3717	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12776: invokevirtual 3722	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   12779: new 799	mqq/app/NewIntent
    //   12782: dup
    //   12783: aload_0
    //   12784: invokevirtual 2186	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   12787: ldc_w 801
    //   12790: invokespecial 802	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12793: astore_3
    //   12794: aload_3
    //   12795: new 379	android/os/Bundle
    //   12798: dup
    //   12799: invokespecial 380	android/os/Bundle:<init>	()V
    //   12802: invokevirtual 3723	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   12805: pop
    //   12806: aload_3
    //   12807: ldc_w 807
    //   12810: ldc_w 3725
    //   12813: invokevirtual 810	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12816: pop
    //   12817: aload_3
    //   12818: ldc_w 272
    //   12821: aload 14
    //   12823: invokevirtual 3726	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   12826: invokevirtual 817	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   12829: pop
    //   12830: aload_3
    //   12831: ldc_w 3728
    //   12834: iconst_1
    //   12835: invokevirtual 3729	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12838: pop
    //   12839: aload_3
    //   12840: new 3754	com/tencent/mobileqq/jsp/UiApiPlugin$7
    //   12843: dup
    //   12844: aload_0
    //   12845: aload 4
    //   12847: aload_1
    //   12848: aload_2
    //   12849: invokespecial 3757	com/tencent/mobileqq/jsp/UiApiPlugin$7:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V
    //   12852: invokevirtual 826	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   12855: aload_0
    //   12856: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   12859: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   12862: aload_3
    //   12863: invokevirtual 832	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   12866: goto -12622 -> 244
    //   12869: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12872: ifeq +5264 -> 18136
    //   12875: ldc_w 3668
    //   12878: iconst_2
    //   12879: ldc_w 3759
    //   12882: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12885: goto +5251 -> 18136
    //   12888: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12891: ifeq +50 -> 12941
    //   12894: new 703	java/lang/StringBuilder
    //   12897: dup
    //   12898: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   12901: astore_2
    //   12902: aload_2
    //   12903: ldc_w 3761
    //   12906: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12909: pop
    //   12910: aload_2
    //   12911: aload_3
    //   12912: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12915: pop
    //   12916: aload_2
    //   12917: ldc_w 3763
    //   12920: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12923: pop
    //   12924: aload_2
    //   12925: aload_1
    //   12926: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12929: pop
    //   12930: ldc_w 3668
    //   12933: iconst_2
    //   12934: aload_2
    //   12935: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12938: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12941: iconst_1
    //   12942: ireturn
    //   12943: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12946: ifeq -12702 -> 244
    //   12949: new 703	java/lang/StringBuilder
    //   12952: dup
    //   12953: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   12956: astore_1
    //   12957: aload_1
    //   12958: ldc_w 3744
    //   12961: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12964: pop
    //   12965: aload_1
    //   12966: aload 5
    //   12968: iconst_0
    //   12969: aaload
    //   12970: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12973: pop
    //   12974: ldc_w 283
    //   12977: iconst_2
    //   12978: aload_1
    //   12979: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12982: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12985: goto -12741 -> 244
    //   12988: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12991: ifeq -12747 -> 244
    //   12994: new 703	java/lang/StringBuilder
    //   12997: dup
    //   12998: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   13001: astore_1
    //   13002: aload_1
    //   13003: ldc_w 3746
    //   13006: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13009: pop
    //   13010: aload_1
    //   13011: aload 5
    //   13013: iconst_0
    //   13014: aaload
    //   13015: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13018: pop
    //   13019: ldc_w 283
    //   13022: iconst_2
    //   13023: aload_1
    //   13024: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13027: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13030: goto -12786 -> 244
    //   13033: ldc_w 3765
    //   13036: aload 4
    //   13038: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13041: ifeq +229 -> 13270
    //   13044: aload_0
    //   13045: new 146	org/json/JSONObject
    //   13048: dup
    //   13049: aload 5
    //   13051: iconst_0
    //   13052: aaload
    //   13053: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13056: ldc_w 906
    //   13059: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13062: putfield 2964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   13065: aload_0
    //   13066: iconst_2
    //   13067: invokespecial 1738	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   13070: checkcast 1740	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   13073: astore_1
    //   13074: aload_1
    //   13075: ifnull -12831 -> 244
    //   13078: aload_1
    //   13079: getfield 1743	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   13082: getfield 3766	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:jdField_d_of_type_Int	I
    //   13085: istore 6
    //   13087: aload_0
    //   13088: getfield 2964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   13091: astore_1
    //   13092: new 703	java/lang/StringBuilder
    //   13095: dup
    //   13096: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   13099: astore_2
    //   13100: aload_2
    //   13101: ldc_w 3768
    //   13104: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13107: pop
    //   13108: aload_2
    //   13109: iload 6
    //   13111: invokevirtual 1701	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13114: pop
    //   13115: aload_2
    //   13116: ldc_w 1789
    //   13119: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13122: pop
    //   13123: aload_0
    //   13124: aload_1
    //   13125: iconst_1
    //   13126: anewarray 363	java/lang/String
    //   13129: dup
    //   13130: iconst_0
    //   13131: aload_2
    //   13132: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13135: aastore
    //   13136: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13139: goto -12895 -> 244
    //   13142: astore_1
    //   13143: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13146: ifeq -12902 -> 244
    //   13149: aload_0
    //   13150: aload_0
    //   13151: getfield 2964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   13154: iconst_1
    //   13155: anewarray 363	java/lang/String
    //   13158: dup
    //   13159: iconst_0
    //   13160: ldc_w 3770
    //   13163: aastore
    //   13164: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13167: new 703	java/lang/StringBuilder
    //   13170: dup
    //   13171: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   13174: astore_2
    //   13175: aload_2
    //   13176: ldc_w 3772
    //   13179: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13182: pop
    //   13183: aload_2
    //   13184: aload_1
    //   13185: invokevirtual 1359	java/lang/Exception:toString	()Ljava/lang/String;
    //   13188: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13191: pop
    //   13192: ldc_w 283
    //   13195: iconst_2
    //   13196: aload_2
    //   13197: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13200: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13203: goto -12959 -> 244
    //   13206: astore_1
    //   13207: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13210: ifeq -12966 -> 244
    //   13213: aload_0
    //   13214: aload_0
    //   13215: getfield 2964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   13218: iconst_1
    //   13219: anewarray 363	java/lang/String
    //   13222: dup
    //   13223: iconst_0
    //   13224: ldc_w 3770
    //   13227: aastore
    //   13228: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13231: new 703	java/lang/StringBuilder
    //   13234: dup
    //   13235: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   13238: astore_2
    //   13239: aload_2
    //   13240: ldc_w 3772
    //   13243: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13246: pop
    //   13247: aload_2
    //   13248: aload_1
    //   13249: invokevirtual 3642	org/json/JSONException:toString	()Ljava/lang/String;
    //   13252: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13255: pop
    //   13256: ldc_w 283
    //   13259: iconst_2
    //   13260: aload_2
    //   13261: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13264: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13267: goto -13023 -> 244
    //   13270: ldc_w 3774
    //   13273: aload 4
    //   13275: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13278: ifeq +147 -> 13425
    //   13281: aload 5
    //   13283: arraylength
    //   13284: iconst_1
    //   13285: if_icmpgt +140 -> 13425
    //   13288: aload 5
    //   13290: arraylength
    //   13291: iconst_1
    //   13292: if_icmpne +4846 -> 18138
    //   13295: new 146	org/json/JSONObject
    //   13298: dup
    //   13299: aload 5
    //   13301: iconst_0
    //   13302: aaload
    //   13303: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13306: astore 4
    //   13308: aload 4
    //   13310: ldc_w 382
    //   13313: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13316: astore_3
    //   13317: aload_3
    //   13318: astore_1
    //   13319: aload 4
    //   13321: ldc_w 1726
    //   13324: invokevirtual 353	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   13327: ifeq +17 -> 13344
    //   13330: aload 4
    //   13332: ldc_w 1726
    //   13335: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13338: astore_2
    //   13339: aload_3
    //   13340: astore_1
    //   13341: goto +3 -> 13344
    //   13344: aload_0
    //   13345: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13348: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13351: astore_3
    //   13352: aload_3
    //   13353: ifnull -13109 -> 244
    //   13356: aload_3
    //   13357: instanceof 579
    //   13360: ifeq -13116 -> 244
    //   13363: aload_3
    //   13364: checkcast 579	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13367: invokevirtual 3215	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:getCurrentWebViewFragment	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13370: checkcast 3217	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13373: iconst_0
    //   13374: aload_1
    //   13375: aload_2
    //   13376: invokevirtual 3777	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:a	(ZLjava/lang/String;Ljava/lang/String;)V
    //   13379: goto -13135 -> 244
    //   13382: astore_1
    //   13383: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13386: ifeq -13142 -> 244
    //   13389: new 703	java/lang/StringBuilder
    //   13392: dup
    //   13393: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   13396: astore_2
    //   13397: aload_2
    //   13398: ldc_w 3779
    //   13401: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13404: pop
    //   13405: aload_2
    //   13406: aload_1
    //   13407: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13410: pop
    //   13411: ldc_w 283
    //   13414: iconst_4
    //   13415: aload_2
    //   13416: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13419: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13422: goto -13178 -> 244
    //   13425: ldc_w 3781
    //   13428: aload 4
    //   13430: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13433: ifeq +277 -> 13710
    //   13436: aload 5
    //   13438: arraylength
    //   13439: iconst_1
    //   13440: if_icmpgt +270 -> 13710
    //   13443: aload 5
    //   13445: arraylength
    //   13446: iconst_1
    //   13447: if_icmpne -13203 -> 244
    //   13450: new 146	org/json/JSONObject
    //   13453: dup
    //   13454: aload 5
    //   13456: iconst_0
    //   13457: aaload
    //   13458: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13461: astore_1
    //   13462: aload_1
    //   13463: ldc_w 3390
    //   13466: iconst_m1
    //   13467: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13470: istore 6
    //   13472: goto +40 -> 13512
    //   13475: astore_2
    //   13476: new 703	java/lang/StringBuilder
    //   13479: dup
    //   13480: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   13483: astore_3
    //   13484: aload_3
    //   13485: ldc_w 3783
    //   13488: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13491: pop
    //   13492: aload_3
    //   13493: aload_2
    //   13494: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13497: pop
    //   13498: ldc_w 283
    //   13501: iconst_1
    //   13502: aload_3
    //   13503: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13506: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13509: iconst_m1
    //   13510: istore 6
    //   13512: aload_1
    //   13513: ldc_w 3481
    //   13516: iconst_m1
    //   13517: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13520: istore 7
    //   13522: goto +40 -> 13562
    //   13525: astore_1
    //   13526: new 703	java/lang/StringBuilder
    //   13529: dup
    //   13530: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   13533: astore_2
    //   13534: aload_2
    //   13535: ldc_w 3785
    //   13538: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13541: pop
    //   13542: aload_2
    //   13543: aload_1
    //   13544: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13547: pop
    //   13548: ldc_w 283
    //   13551: iconst_1
    //   13552: aload_2
    //   13553: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13556: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13559: iconst_m1
    //   13560: istore 7
    //   13562: aload_0
    //   13563: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13566: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13569: astore_1
    //   13570: aload_1
    //   13571: ifnull -13327 -> 244
    //   13574: aload_1
    //   13575: instanceof 579
    //   13578: ifeq -13334 -> 244
    //   13581: aload_1
    //   13582: checkcast 579	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13585: invokevirtual 3215	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:getCurrentWebViewFragment	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13588: checkcast 3217	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13591: astore_1
    //   13592: aload_1
    //   13593: ifnull -13349 -> 244
    //   13596: iload 7
    //   13598: iconst_1
    //   13599: if_icmpne +16 -> 13615
    //   13602: aload_1
    //   13603: iconst_0
    //   13604: putfield 3786	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13607: aload_1
    //   13608: iconst_1
    //   13609: invokevirtual 3787	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:b	(Z)V
    //   13612: goto +18 -> 13630
    //   13615: iload 7
    //   13617: ifne +13 -> 13630
    //   13620: aload_1
    //   13621: iconst_1
    //   13622: putfield 3786	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13625: aload_1
    //   13626: iconst_0
    //   13627: invokevirtual 3787	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:b	(Z)V
    //   13630: iload 6
    //   13632: iconst_1
    //   13633: if_icmpne +16 -> 13649
    //   13636: aload_1
    //   13637: iconst_0
    //   13638: putfield 3786	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13641: aload_1
    //   13642: iconst_1
    //   13643: invokevirtual 3788	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:c	(Z)V
    //   13646: goto -13402 -> 244
    //   13649: iload 6
    //   13651: ifne -13407 -> 244
    //   13654: aload_1
    //   13655: iconst_1
    //   13656: putfield 3786	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13659: aload_1
    //   13660: iconst_0
    //   13661: invokevirtual 3788	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:c	(Z)V
    //   13664: goto -13420 -> 244
    //   13667: astore_1
    //   13668: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13671: ifeq -13427 -> 244
    //   13674: new 703	java/lang/StringBuilder
    //   13677: dup
    //   13678: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   13681: astore_2
    //   13682: aload_2
    //   13683: ldc_w 3790
    //   13686: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13689: pop
    //   13690: aload_2
    //   13691: aload_1
    //   13692: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13695: pop
    //   13696: ldc_w 283
    //   13699: iconst_4
    //   13700: aload_2
    //   13701: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13704: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13707: goto -13463 -> 244
    //   13710: ldc_w 3792
    //   13713: aload 4
    //   13715: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13718: ifeq +175 -> 13893
    //   13721: aload 5
    //   13723: arraylength
    //   13724: iconst_1
    //   13725: if_icmpgt +168 -> 13893
    //   13728: aload 5
    //   13730: arraylength
    //   13731: iconst_1
    //   13732: if_icmpne -13488 -> 244
    //   13735: aload 5
    //   13737: arraylength
    //   13738: iconst_1
    //   13739: if_icmpne -13495 -> 244
    //   13742: new 146	org/json/JSONObject
    //   13745: dup
    //   13746: aload 5
    //   13748: iconst_0
    //   13749: aaload
    //   13750: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13753: ldc_w 3794
    //   13756: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13759: astore_1
    //   13760: aload_0
    //   13761: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   13764: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   13767: astore_2
    //   13768: aload_2
    //   13769: ifnull -13525 -> 244
    //   13772: aload_2
    //   13773: instanceof 579
    //   13776: ifeq -13532 -> 244
    //   13779: aload_2
    //   13780: checkcast 579	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13783: invokevirtual 3215	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:getCurrentWebViewFragment	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13786: checkcast 3217	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13789: astore_3
    //   13790: ldc_w 407
    //   13793: aload_1
    //   13794: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13797: ifeq +25 -> 13822
    //   13800: aload_2
    //   13801: ldc_w 1433
    //   13804: invokevirtual 1434	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13807: checkcast 1436	android/view/inputmethod/InputMethodManager
    //   13810: aload_3
    //   13811: invokevirtual 3797	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   13814: iconst_0
    //   13815: invokevirtual 3801	android/view/inputmethod/InputMethodManager:showSoftInput	(Landroid/view/View;I)Z
    //   13818: pop
    //   13819: goto -13575 -> 244
    //   13822: aload_2
    //   13823: ldc_w 1433
    //   13826: invokevirtual 1434	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13829: checkcast 1436	android/view/inputmethod/InputMethodManager
    //   13832: aload_2
    //   13833: invokevirtual 3126	android/app/Activity:getWindow	()Landroid/view/Window;
    //   13836: invokevirtual 3804	android/view/Window:getDecorView	()Landroid/view/View;
    //   13839: invokevirtual 3808	android/view/View:getWindowToken	()Landroid/os/IBinder;
    //   13842: iconst_0
    //   13843: invokevirtual 3812	android/view/inputmethod/InputMethodManager:hideSoftInputFromWindow	(Landroid/os/IBinder;I)Z
    //   13846: pop
    //   13847: goto -13603 -> 244
    //   13850: astore_1
    //   13851: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13854: ifeq -13610 -> 244
    //   13857: new 703	java/lang/StringBuilder
    //   13860: dup
    //   13861: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   13864: astore_2
    //   13865: aload_2
    //   13866: ldc_w 3814
    //   13869: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13872: pop
    //   13873: aload_2
    //   13874: aload_1
    //   13875: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13878: pop
    //   13879: ldc_w 283
    //   13882: iconst_4
    //   13883: aload_2
    //   13884: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13887: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13890: goto -13646 -> 244
    //   13893: ldc_w 3816
    //   13896: aload 4
    //   13898: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13901: ifeq +103 -> 14004
    //   13904: aload 5
    //   13906: arraylength
    //   13907: iconst_1
    //   13908: if_icmpgt +96 -> 14004
    //   13911: aload 5
    //   13913: arraylength
    //   13914: iconst_1
    //   13915: if_icmpne -13671 -> 244
    //   13918: new 146	org/json/JSONObject
    //   13921: dup
    //   13922: aload 5
    //   13924: iconst_0
    //   13925: aaload
    //   13926: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13929: ldc_w 906
    //   13932: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13935: astore_1
    //   13936: aload_1
    //   13937: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13940: ifne -13696 -> 244
    //   13943: aload_0
    //   13944: aload_1
    //   13945: iconst_1
    //   13946: anewarray 363	java/lang/String
    //   13949: dup
    //   13950: iconst_0
    //   13951: ldc_w 3818
    //   13954: aastore
    //   13955: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13958: goto -13714 -> 244
    //   13961: astore_1
    //   13962: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13965: ifeq -13721 -> 244
    //   13968: new 703	java/lang/StringBuilder
    //   13971: dup
    //   13972: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   13975: astore_2
    //   13976: aload_2
    //   13977: ldc_w 3820
    //   13980: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13983: pop
    //   13984: aload_2
    //   13985: aload_1
    //   13986: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13989: pop
    //   13990: ldc_w 283
    //   13993: iconst_4
    //   13994: aload_2
    //   13995: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13998: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14001: goto -13757 -> 244
    //   14004: ldc_w 3822
    //   14007: aload 4
    //   14009: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14012: ifeq +120 -> 14132
    //   14015: aload 5
    //   14017: arraylength
    //   14018: ifle +114 -> 14132
    //   14021: new 146	org/json/JSONObject
    //   14024: dup
    //   14025: aload 5
    //   14027: iconst_0
    //   14028: aaload
    //   14029: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14032: astore_3
    //   14033: aload_0
    //   14034: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14037: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14040: astore_1
    //   14041: aload_0
    //   14042: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14045: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   14048: astore_2
    //   14049: aload_3
    //   14050: ldc_w 2703
    //   14053: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14056: astore_3
    //   14057: aload_3
    //   14058: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14061: ifne -13817 -> 244
    //   14064: aload_1
    //   14065: ifnull -13821 -> 244
    //   14068: aload_2
    //   14069: ifnull -13825 -> 244
    //   14072: aload_1
    //   14073: new 3824	com/tencent/mobileqq/profilecard/data/AllInOne
    //   14076: dup
    //   14077: aload_3
    //   14078: bipush 90
    //   14080: invokespecial 3826	com/tencent/mobileqq/profilecard/data/AllInOne:<init>	(Ljava/lang/String;I)V
    //   14083: invokestatic 3832	com/tencent/mobileqq/profilecard/utils/ProfileUtils:openProfileCard	(Landroid/content/Context;Lcom/tencent/mobileqq/profilecard/data/AllInOne;)V
    //   14086: goto -13842 -> 244
    //   14089: astore_1
    //   14090: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14093: ifeq -13849 -> 244
    //   14096: new 703	java/lang/StringBuilder
    //   14099: dup
    //   14100: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   14103: astore_2
    //   14104: aload_2
    //   14105: ldc_w 3834
    //   14108: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14111: pop
    //   14112: aload_2
    //   14113: aload_1
    //   14114: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14117: pop
    //   14118: ldc_w 2672
    //   14121: iconst_2
    //   14122: aload_2
    //   14123: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14126: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14129: goto -13885 -> 244
    //   14132: ldc_w 3836
    //   14135: aload 4
    //   14137: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14140: ifeq +102 -> 14242
    //   14143: aload 5
    //   14145: arraylength
    //   14146: ifle +96 -> 14242
    //   14149: new 146	org/json/JSONObject
    //   14152: dup
    //   14153: aload 5
    //   14155: iconst_0
    //   14156: aaload
    //   14157: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14160: ldc_w 3838
    //   14163: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14166: istore 6
    //   14168: aload_0
    //   14169: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14172: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14175: astore_1
    //   14176: aload_1
    //   14177: ifnull -13933 -> 244
    //   14180: aload_1
    //   14181: instanceof 579
    //   14184: ifeq -13940 -> 244
    //   14187: aload_1
    //   14188: checkcast 579	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   14191: iload 6
    //   14193: invokevirtual 3839	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:a	(I)V
    //   14196: goto -13952 -> 244
    //   14199: astore_1
    //   14200: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14203: ifeq -13959 -> 244
    //   14206: new 703	java/lang/StringBuilder
    //   14209: dup
    //   14210: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   14213: astore_2
    //   14214: aload_2
    //   14215: ldc_w 3841
    //   14218: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14221: pop
    //   14222: aload_2
    //   14223: aload_1
    //   14224: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14227: pop
    //   14228: ldc_w 2672
    //   14231: iconst_2
    //   14232: aload_2
    //   14233: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14236: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14239: goto -13995 -> 244
    //   14242: ldc_w 3843
    //   14245: aload 4
    //   14247: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14250: ifeq +271 -> 14521
    //   14253: aload 5
    //   14255: arraylength
    //   14256: ifle +265 -> 14521
    //   14259: new 146	org/json/JSONObject
    //   14262: dup
    //   14263: aload 5
    //   14265: iconst_0
    //   14266: aaload
    //   14267: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14270: astore_3
    //   14271: aload_3
    //   14272: ldc_w 3845
    //   14275: iconst_0
    //   14276: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   14279: iconst_1
    //   14280: if_icmpne +3865 -> 18145
    //   14283: iconst_1
    //   14284: istore 10
    //   14286: goto +3 -> 14289
    //   14289: aload_3
    //   14290: ldc_w 3847
    //   14293: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14296: istore 6
    //   14298: aload_3
    //   14299: ldc_w 3849
    //   14302: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14305: istore 7
    //   14307: aload_3
    //   14308: ldc_w 3851
    //   14311: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14314: istore 8
    //   14316: aload_3
    //   14317: ldc_w 3853
    //   14320: iconst_1
    //   14321: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   14324: iconst_1
    //   14325: if_icmpne +3826 -> 18151
    //   14328: iconst_1
    //   14329: istore 11
    //   14331: goto +3 -> 14334
    //   14334: aload_3
    //   14335: ldc_w 3855
    //   14338: aconst_null
    //   14339: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14342: astore_1
    //   14343: aload_3
    //   14344: ldc_w 3857
    //   14347: aconst_null
    //   14348: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14351: astore_2
    //   14352: aload_3
    //   14353: ldc_w 906
    //   14356: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14359: astore_3
    //   14360: aload_0
    //   14361: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14364: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14367: astore 5
    //   14369: aload_0
    //   14370: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14373: invokevirtual 1431	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   14376: checkcast 1867	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   14379: astore 4
    //   14381: aload_0
    //   14382: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14385: aload 5
    //   14387: invokevirtual 1426	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   14390: astore 5
    //   14392: aload 4
    //   14394: ifnull +35 -> 14429
    //   14397: aload 4
    //   14399: invokevirtual 3861	com/tencent/mobileqq/webview/swift/WebViewFragment:getUIStyleHandler	()Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   14402: ifnull +27 -> 14429
    //   14405: aload 4
    //   14407: invokevirtual 3861	com/tencent/mobileqq/webview/swift/WebViewFragment:getUIStyleHandler	()Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   14410: iload 10
    //   14412: iload 6
    //   14414: iload 7
    //   14416: iload 8
    //   14418: iload 11
    //   14420: aload_1
    //   14421: aload_2
    //   14422: aload_3
    //   14423: invokevirtual 3864	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(ZIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   14426: goto -14182 -> 244
    //   14429: aload 5
    //   14431: ifnull -14187 -> 244
    //   14434: aload 5
    //   14436: instanceof 1776
    //   14439: ifeq -14195 -> 244
    //   14442: aload 5
    //   14444: checkcast 1776	com/tencent/mobileqq/webviewplugin/WebUiUtils$VipComicUiInterface
    //   14447: iload 10
    //   14449: iload 6
    //   14451: iload 7
    //   14453: iload 8
    //   14455: iload 11
    //   14457: aload_1
    //   14458: aload_2
    //   14459: aload_3
    //   14460: aload_0
    //   14461: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14464: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   14467: invokevirtual 1779	java/lang/Object:hashCode	()I
    //   14470: invokeinterface 3867 10 0
    //   14475: goto -14231 -> 244
    //   14478: astore_1
    //   14479: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14482: ifeq -14238 -> 244
    //   14485: new 703	java/lang/StringBuilder
    //   14488: dup
    //   14489: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   14492: astore_2
    //   14493: aload_2
    //   14494: ldc_w 3869
    //   14497: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14500: pop
    //   14501: aload_2
    //   14502: aload_1
    //   14503: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14506: pop
    //   14507: ldc_w 283
    //   14510: iconst_2
    //   14511: aload_2
    //   14512: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14515: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14518: goto -14274 -> 244
    //   14521: ldc_w 3871
    //   14524: aload 4
    //   14526: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14529: ifeq +163 -> 14692
    //   14532: aload 5
    //   14534: arraylength
    //   14535: ifle +157 -> 14692
    //   14538: new 146	org/json/JSONObject
    //   14541: dup
    //   14542: aload 5
    //   14544: iconst_0
    //   14545: aaload
    //   14546: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14549: ldc_w 1707
    //   14552: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14555: istore 6
    //   14557: aload_0
    //   14558: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14561: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   14564: astore_2
    //   14565: aload_2
    //   14566: ifnull -14322 -> 244
    //   14569: iload 6
    //   14571: ifne +10 -> 14581
    //   14574: aload_2
    //   14575: invokevirtual 3874	com/tencent/biz/pubaccount/CustomWebView:reload	()V
    //   14578: goto -14334 -> 244
    //   14581: aload_0
    //   14582: iconst_4
    //   14583: invokevirtual 2856	com/tencent/mobileqq/jsp/UiApiPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   14586: checkcast 3876	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler
    //   14589: astore_1
    //   14590: aload_1
    //   14591: ifnull -14347 -> 244
    //   14594: aload_2
    //   14595: invokevirtual 3879	com/tencent/biz/pubaccount/CustomWebView:getOriginalUrl	()Ljava/lang/String;
    //   14598: astore_2
    //   14599: aload_1
    //   14600: getfield 3882	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:a	Lcom/tencent/biz/webviewplugin/Share;
    //   14603: ifnonnull +28 -> 14631
    //   14606: aload_1
    //   14607: new 2153	com/tencent/biz/webviewplugin/Share
    //   14610: dup
    //   14611: aload_0
    //   14612: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14615: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   14618: aload_0
    //   14619: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14622: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14625: invokespecial 3885	com/tencent/biz/webviewplugin/Share:<init>	(Lmqq/app/AppRuntime;Landroid/app/Activity;)V
    //   14628: putfield 3882	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:a	Lcom/tencent/biz/webviewplugin/Share;
    //   14631: iload 6
    //   14633: iconst_1
    //   14634: if_icmpne +20 -> 14654
    //   14637: aload_1
    //   14638: bipush 6
    //   14640: aload_2
    //   14641: new 379	android/os/Bundle
    //   14644: dup
    //   14645: invokespecial 380	android/os/Bundle:<init>	()V
    //   14648: invokevirtual 3888	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:a	(ILjava/lang/String;Landroid/os/Bundle;)V
    //   14651: goto -14407 -> 244
    //   14654: iload 6
    //   14656: iconst_2
    //   14657: if_icmpne -14413 -> 244
    //   14660: aload_1
    //   14661: bipush 11
    //   14663: aload_2
    //   14664: new 379	android/os/Bundle
    //   14667: dup
    //   14668: invokespecial 380	android/os/Bundle:<init>	()V
    //   14671: invokevirtual 3888	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:a	(ILjava/lang/String;Landroid/os/Bundle;)V
    //   14674: goto -14430 -> 244
    //   14677: astore_1
    //   14678: ldc_w 283
    //   14681: iconst_2
    //   14682: ldc_w 3890
    //   14685: aload_1
    //   14686: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14689: goto -14445 -> 244
    //   14692: ldc_w 3892
    //   14695: aload 4
    //   14697: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14700: ifeq +73 -> 14773
    //   14703: new 162	android/content/Intent
    //   14706: dup
    //   14707: aload_0
    //   14708: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14711: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14714: ldc_w 3894
    //   14717: invokespecial 535	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   14720: astore_1
    //   14721: aload_1
    //   14722: ldc_w 3896
    //   14725: aload 5
    //   14727: iconst_0
    //   14728: aaload
    //   14729: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14732: pop
    //   14733: aload_0
    //   14734: invokestatic 3901	com/tencent/mobileqq/webview/swift/WebViewUtil:a	(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;)I
    //   14737: istore 6
    //   14739: aload_0
    //   14740: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14743: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14746: aload_1
    //   14747: iload 6
    //   14749: bipush 8
    //   14751: ishl
    //   14752: bipush 13
    //   14754: iadd
    //   14755: invokevirtual 552	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   14758: aload_0
    //   14759: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14762: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14765: iconst_0
    //   14766: iconst_0
    //   14767: invokevirtual 737	android/app/Activity:overridePendingTransition	(II)V
    //   14770: goto -14526 -> 244
    //   14773: ldc_w 3903
    //   14776: aload 4
    //   14778: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14781: ifeq +180 -> 14961
    //   14784: new 146	org/json/JSONObject
    //   14787: dup
    //   14788: aload 5
    //   14790: iconst_0
    //   14791: aaload
    //   14792: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14795: astore_2
    //   14796: aload_2
    //   14797: ldc 193
    //   14799: ldc_w 512
    //   14802: invokevirtual 323	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14805: astore_1
    //   14806: aload_0
    //   14807: aload_2
    //   14808: ldc_w 906
    //   14811: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14814: putfield 2588	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   14817: aload_1
    //   14818: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14821: ifeq +53 -> 14874
    //   14824: new 146	org/json/JSONObject
    //   14827: dup
    //   14828: invokespecial 248	org/json/JSONObject:<init>	()V
    //   14831: astore_1
    //   14832: aload_1
    //   14833: ldc_w 291
    //   14836: iconst_m1
    //   14837: invokevirtual 270	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14840: pop
    //   14841: aload_1
    //   14842: ldc_w 272
    //   14845: ldc_w 512
    //   14848: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   14851: pop
    //   14852: aload_0
    //   14853: aload_0
    //   14854: getfield 2588	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   14857: iconst_1
    //   14858: anewarray 363	java/lang/String
    //   14861: dup
    //   14862: iconst_0
    //   14863: aload_1
    //   14864: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14867: aastore
    //   14868: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14871: goto -14627 -> 244
    //   14874: aload_2
    //   14875: ldc_w 644
    //   14878: iconst_0
    //   14879: invokevirtual 647	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   14882: istore 6
    //   14884: new 162	android/content/Intent
    //   14887: dup
    //   14888: invokespecial 722	android/content/Intent:<init>	()V
    //   14891: astore_2
    //   14892: iload 6
    //   14894: ifne +17 -> 14911
    //   14897: aload_2
    //   14898: invokestatic 1015	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   14901: ldc_w 532
    //   14904: invokevirtual 2837	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   14907: pop
    //   14908: goto +14 -> 14922
    //   14911: aload_2
    //   14912: invokestatic 1015	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   14915: ldc_w 649
    //   14918: invokevirtual 2837	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   14921: pop
    //   14922: aload_2
    //   14923: ldc 193
    //   14925: aload_1
    //   14926: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14929: pop
    //   14930: aload_0
    //   14931: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14934: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14937: aload_2
    //   14938: bipush 14
    //   14940: invokevirtual 552	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   14943: goto -14699 -> 244
    //   14946: astore_1
    //   14947: ldc_w 283
    //   14950: iconst_1
    //   14951: ldc_w 3905
    //   14954: aload_1
    //   14955: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14958: goto -14714 -> 244
    //   14961: ldc_w 3907
    //   14964: aload 4
    //   14966: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14969: ifeq +64 -> 15033
    //   14972: new 146	org/json/JSONObject
    //   14975: dup
    //   14976: aload 5
    //   14978: iconst_0
    //   14979: aaload
    //   14980: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14983: ldc_w 272
    //   14986: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14989: astore_1
    //   14990: aload_0
    //   14991: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   14994: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   14997: iconst_m1
    //   14998: new 162	android/content/Intent
    //   15001: dup
    //   15002: invokespecial 722	android/content/Intent:<init>	()V
    //   15005: ldc_w 272
    //   15008: aload_1
    //   15009: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   15012: invokevirtual 792	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   15015: goto -14771 -> 244
    //   15018: astore_1
    //   15019: ldc_w 283
    //   15022: iconst_1
    //   15023: ldc_w 3909
    //   15026: aload_1
    //   15027: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15030: goto -14786 -> 244
    //   15033: ldc_w 3911
    //   15036: aload 4
    //   15038: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15041: ifeq +6 -> 15047
    //   15044: goto -14800 -> 244
    //   15047: ldc_w 3913
    //   15050: aload 4
    //   15052: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15055: ifeq +101 -> 15156
    //   15058: new 146	org/json/JSONObject
    //   15061: dup
    //   15062: aload 5
    //   15064: iconst_0
    //   15065: aaload
    //   15066: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15069: astore_2
    //   15070: aload_2
    //   15071: ldc_w 906
    //   15074: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15077: astore_1
    //   15078: aload_2
    //   15079: ldc_w 3481
    //   15082: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15085: iconst_0
    //   15086: iconst_0
    //   15087: invokestatic 3918	com/tencent/mobileqq/vip/CUKingCardHelper:a	(Ljava/lang/String;ZZ)Lcom/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo;
    //   15090: astore_2
    //   15091: new 146	org/json/JSONObject
    //   15094: dup
    //   15095: invokespecial 248	org/json/JSONObject:<init>	()V
    //   15098: astore_3
    //   15099: aload_3
    //   15100: ldc_w 291
    //   15103: aload_2
    //   15104: getfield 3921	com/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo:jdField_a_of_type_Int	I
    //   15107: invokevirtual 270	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15110: pop
    //   15111: aload_3
    //   15112: ldc 193
    //   15114: aload_2
    //   15115: getfield 3922	com/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15118: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   15121: pop
    //   15122: aload_0
    //   15123: aload_1
    //   15124: iconst_1
    //   15125: anewarray 363	java/lang/String
    //   15128: dup
    //   15129: iconst_0
    //   15130: aload_3
    //   15131: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15134: aastore
    //   15135: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15138: goto -14894 -> 244
    //   15141: astore_1
    //   15142: ldc_w 283
    //   15145: iconst_1
    //   15146: ldc_w 3924
    //   15149: aload_1
    //   15150: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15153: goto -14909 -> 244
    //   15156: ldc_w 3926
    //   15159: aload 4
    //   15161: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15164: ifeq +235 -> 15399
    //   15167: new 146	org/json/JSONObject
    //   15170: dup
    //   15171: aload 5
    //   15173: iconst_0
    //   15174: aaload
    //   15175: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15178: astore_2
    //   15179: aload_2
    //   15180: ldc_w 906
    //   15183: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15186: astore_1
    //   15187: aload_2
    //   15188: ldc 250
    //   15190: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   15193: istore 6
    //   15195: aload_2
    //   15196: ldc_w 3481
    //   15199: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15202: astore_2
    //   15203: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15206: ifeq +51 -> 15257
    //   15209: new 703	java/lang/StringBuilder
    //   15212: dup
    //   15213: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   15216: astore_3
    //   15217: aload_3
    //   15218: ldc_w 3928
    //   15221: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15224: pop
    //   15225: aload_3
    //   15226: iload 6
    //   15228: invokevirtual 1701	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15231: pop
    //   15232: aload_3
    //   15233: ldc_w 3930
    //   15236: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15239: pop
    //   15240: aload_3
    //   15241: aload_2
    //   15242: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15245: pop
    //   15246: ldc_w 283
    //   15249: iconst_2
    //   15250: aload_3
    //   15251: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15254: invokestatic 978	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15257: aload_2
    //   15258: iconst_0
    //   15259: iconst_1
    //   15260: invokestatic 3918	com/tencent/mobileqq/vip/CUKingCardHelper:a	(Ljava/lang/String;ZZ)Lcom/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo;
    //   15263: astore_3
    //   15264: new 146	org/json/JSONObject
    //   15267: dup
    //   15268: invokespecial 248	org/json/JSONObject:<init>	()V
    //   15271: astore 4
    //   15273: aload_3
    //   15274: getfield 3921	com/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo:jdField_a_of_type_Int	I
    //   15277: iconst_1
    //   15278: if_icmpne +33 -> 15311
    //   15281: aload 4
    //   15283: ldc_w 291
    //   15286: iconst_2
    //   15287: invokevirtual 270	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15290: pop
    //   15291: aload_0
    //   15292: aload_1
    //   15293: iconst_1
    //   15294: anewarray 363	java/lang/String
    //   15297: dup
    //   15298: iconst_0
    //   15299: aload 4
    //   15301: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15304: aastore
    //   15305: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15308: goto -15064 -> 244
    //   15311: aload_3
    //   15312: getfield 3921	com/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo:jdField_a_of_type_Int	I
    //   15315: iconst_4
    //   15316: if_icmpne +33 -> 15349
    //   15319: aload 4
    //   15321: ldc_w 291
    //   15324: iconst_0
    //   15325: invokevirtual 270	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15328: pop
    //   15329: aload_0
    //   15330: aload_1
    //   15331: iconst_1
    //   15332: anewarray 363	java/lang/String
    //   15335: dup
    //   15336: iconst_0
    //   15337: aload 4
    //   15339: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15342: aastore
    //   15343: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15346: goto -15102 -> 244
    //   15349: new 3932	com/tencent/mobileqq/vip/CUKingCardDialog
    //   15352: dup
    //   15353: aload_0
    //   15354: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15357: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   15360: aload_0
    //   15361: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15364: invokevirtual 213	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   15367: aload_1
    //   15368: iload 6
    //   15370: aload_2
    //   15371: aload_3
    //   15372: getfield 3921	com/tencent/mobileqq/vip/CUKingCardHelper$CUKingCustomDialogInfo:jdField_a_of_type_Int	I
    //   15375: invokespecial 3935	com/tencent/mobileqq/vip/CUKingCardDialog:<init>	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Ljava/lang/String;ILjava/lang/String;I)V
    //   15378: invokevirtual 3936	com/tencent/mobileqq/vip/CUKingCardDialog:show	()V
    //   15381: goto -15137 -> 244
    //   15384: astore_1
    //   15385: ldc_w 283
    //   15388: iconst_1
    //   15389: ldc_w 3938
    //   15392: aload_1
    //   15393: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15396: goto -15152 -> 244
    //   15399: ldc_w 3940
    //   15402: aload 4
    //   15404: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15407: ifeq +95 -> 15502
    //   15410: new 146	org/json/JSONObject
    //   15413: dup
    //   15414: aload 5
    //   15416: iconst_0
    //   15417: aaload
    //   15418: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15421: astore_2
    //   15422: aload_2
    //   15423: ldc_w 906
    //   15426: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15429: astore_1
    //   15430: aload_2
    //   15431: ldc_w 3481
    //   15434: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15437: astore_2
    //   15438: new 146	org/json/JSONObject
    //   15441: dup
    //   15442: invokespecial 248	org/json/JSONObject:<init>	()V
    //   15445: astore_3
    //   15446: aload_3
    //   15447: ldc_w 291
    //   15450: invokestatic 3943	com/tencent/mobileqq/vip/CUKingCardUtils:a	()I
    //   15453: invokevirtual 270	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15456: pop
    //   15457: aload_3
    //   15458: ldc 193
    //   15460: aload_2
    //   15461: invokestatic 3944	com/tencent/mobileqq/vip/CUKingCardHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   15464: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   15467: pop
    //   15468: aload_0
    //   15469: aload_1
    //   15470: iconst_1
    //   15471: anewarray 363	java/lang/String
    //   15474: dup
    //   15475: iconst_0
    //   15476: aload_3
    //   15477: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15480: aastore
    //   15481: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15484: goto -15240 -> 244
    //   15487: astore_1
    //   15488: ldc_w 283
    //   15491: iconst_1
    //   15492: ldc_w 3924
    //   15495: aload_1
    //   15496: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15499: goto -15255 -> 244
    //   15502: ldc_w 3946
    //   15505: aload 4
    //   15507: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15510: ifeq +129 -> 15639
    //   15513: new 146	org/json/JSONObject
    //   15516: dup
    //   15517: aload 5
    //   15519: iconst_0
    //   15520: aaload
    //   15521: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15524: astore_1
    //   15525: aload_1
    //   15526: ldc_w 3390
    //   15529: invokevirtual 3173	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   15532: istore 10
    //   15534: aload_1
    //   15535: ldc_w 3948
    //   15538: invokevirtual 318	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   15541: astore_1
    //   15542: aload_1
    //   15543: ifnull -15299 -> 244
    //   15546: aload_1
    //   15547: ldc_w 1793
    //   15550: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15553: istore 6
    //   15555: aload_1
    //   15556: ldc_w 1795
    //   15559: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15562: istore 7
    //   15564: new 1797	android/graphics/Rect
    //   15567: dup
    //   15568: iload 6
    //   15570: iload 7
    //   15572: aload_1
    //   15573: ldc_w 1799
    //   15576: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15579: iload 6
    //   15581: iadd
    //   15582: aload_1
    //   15583: ldc_w 1801
    //   15586: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15589: iload 7
    //   15591: iadd
    //   15592: invokespecial 1803	android/graphics/Rect:<init>	(IIII)V
    //   15595: astore_1
    //   15596: aload_0
    //   15597: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15600: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   15603: astore_2
    //   15604: aload_2
    //   15605: instanceof 622
    //   15608: ifeq -15364 -> 244
    //   15611: aload_2
    //   15612: checkcast 622	com/tencent/biz/pubaccount/ecshopassit/EcshopWebActivity
    //   15615: aload_1
    //   15616: iload 10
    //   15618: invokevirtual 3951	com/tencent/biz/pubaccount/ecshopassit/EcshopWebActivity:a	(Landroid/graphics/Rect;Z)V
    //   15621: goto -15377 -> 244
    //   15624: astore_1
    //   15625: ldc_w 283
    //   15628: iconst_1
    //   15629: ldc_w 3953
    //   15632: aload_1
    //   15633: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15636: goto -15392 -> 244
    //   15639: ldc_w 3955
    //   15642: aload 4
    //   15644: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15647: ifeq +57 -> 15704
    //   15650: new 146	org/json/JSONObject
    //   15653: dup
    //   15654: aload 5
    //   15656: iconst_0
    //   15657: aaload
    //   15658: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15661: astore_1
    //   15662: goto +17 -> 15679
    //   15665: astore_1
    //   15666: ldc_w 283
    //   15669: iconst_1
    //   15670: ldc_w 3957
    //   15673: aload_1
    //   15674: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15677: aconst_null
    //   15678: astore_1
    //   15679: aload_1
    //   15680: ifnonnull +5 -> 15685
    //   15683: iconst_1
    //   15684: ireturn
    //   15685: invokestatic 3960	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   15688: new 3962	com/tencent/mobileqq/jsp/UiApiPlugin$8
    //   15691: dup
    //   15692: aload_0
    //   15693: aload_1
    //   15694: invokespecial 3963	com/tencent/mobileqq/jsp/UiApiPlugin$8:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Lorg/json/JSONObject;)V
    //   15697: invokevirtual 1322	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   15700: pop
    //   15701: goto -15457 -> 244
    //   15704: ldc_w 3965
    //   15707: aload 4
    //   15709: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15712: ifeq +195 -> 15907
    //   15715: new 146	org/json/JSONObject
    //   15718: dup
    //   15719: aload 5
    //   15721: iconst_0
    //   15722: aaload
    //   15723: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15726: astore 5
    //   15728: aload_0
    //   15729: aload 5
    //   15731: ldc_w 906
    //   15734: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15737: putfield 3967	com/tencent/mobileqq/jsp/UiApiPlugin:j	Ljava/lang/String;
    //   15740: aload 5
    //   15742: ldc_w 3666
    //   15745: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15748: astore_1
    //   15749: aload 5
    //   15751: ldc_w 3969
    //   15754: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15757: astore_2
    //   15758: aload 5
    //   15760: ldc_w 3971
    //   15763: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15766: astore_3
    //   15767: aload 5
    //   15769: ldc_w 3973
    //   15772: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15775: astore 4
    //   15777: aload 5
    //   15779: ldc_w 3975
    //   15782: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   15785: istore 7
    //   15787: aload_0
    //   15788: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15791: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   15794: astore 5
    //   15796: bipush 16
    //   15798: istore 6
    //   15800: aload_0
    //   15801: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15804: aload_0
    //   15805: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15808: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   15811: invokevirtual 1426	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   15814: astore 14
    //   15816: aload 14
    //   15818: instanceof 3977
    //   15821: ifeq +18 -> 15839
    //   15824: aload 14
    //   15826: checkcast 3977	com/tencent/mobileqq/webview/swift/WebViewPluginContainer
    //   15829: aload_0
    //   15830: bipush 16
    //   15832: invokeinterface 3981 3 0
    //   15837: istore 6
    //   15839: ldc_w 3983
    //   15842: invokestatic 574	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   15845: checkcast 3983	com/tencent/mobileqq/addfriend/api/IAddFriendApi
    //   15848: aload 5
    //   15850: iconst_3
    //   15851: aload_1
    //   15852: aload_2
    //   15853: sipush 3016
    //   15856: iload 7
    //   15858: aload_3
    //   15859: aload 4
    //   15861: aconst_null
    //   15862: aconst_null
    //   15863: aconst_null
    //   15864: invokeinterface 3987 12 0
    //   15869: astore_1
    //   15870: ldc_w 3983
    //   15873: invokestatic 574	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   15876: checkcast 3983	com/tencent/mobileqq/addfriend/api/IAddFriendApi
    //   15879: aload 5
    //   15881: aload_1
    //   15882: iload 6
    //   15884: invokeinterface 3990 4 0
    //   15889: goto -15645 -> 244
    //   15892: astore_1
    //   15893: ldc_w 283
    //   15896: iconst_1
    //   15897: ldc_w 3992
    //   15900: aload_1
    //   15901: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15904: goto -15660 -> 244
    //   15907: ldc_w 3994
    //   15910: aload 4
    //   15912: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15915: ifeq +179 -> 16094
    //   15918: new 146	org/json/JSONObject
    //   15921: dup
    //   15922: aload 5
    //   15924: iconst_0
    //   15925: aaload
    //   15926: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15929: astore_3
    //   15930: aload_3
    //   15931: ldc_w 3996
    //   15934: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15937: astore_1
    //   15938: aload_3
    //   15939: ldc_w 2473
    //   15942: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15945: astore_2
    //   15946: aload_3
    //   15947: ldc_w 2482
    //   15950: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15953: astore_3
    //   15954: aload_1
    //   15955: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15958: ifne +55 -> 16013
    //   15961: new 1545	java/io/File
    //   15964: dup
    //   15965: aload_1
    //   15966: invokespecial 1992	java/io/File:<init>	(Ljava/lang/String;)V
    //   15969: astore_1
    //   15970: aload_1
    //   15971: invokevirtual 2355	java/io/File:exists	()Z
    //   15974: ifne +31 -> 16005
    //   15977: aload_0
    //   15978: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   15981: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   15984: invokevirtual 2318	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   15987: iconst_1
    //   15988: ldc_w 3997
    //   15991: invokestatic 2323	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   15994: iconst_0
    //   15995: invokestatic 981	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   15998: invokevirtual 2326	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   16001: pop
    //   16002: goto -15758 -> 244
    //   16005: aload_0
    //   16006: aload_1
    //   16007: invokevirtual 1994	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/io/File;)V
    //   16010: goto -15766 -> 244
    //   16013: aload_2
    //   16014: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16017: ifne +19 -> 16036
    //   16020: aload_0
    //   16021: aload_2
    //   16022: iconst_0
    //   16023: invokestatic 1060	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   16026: aload_2
    //   16027: invokestatic 2478	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   16030: invokevirtual 3999	com/tencent/mobileqq/jsp/UiApiPlugin:a	([BLjava/lang/String;)V
    //   16033: goto -15789 -> 244
    //   16036: aload_3
    //   16037: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16040: ifne +11 -> 16051
    //   16043: aload_0
    //   16044: aload_3
    //   16045: invokevirtual 4000	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Ljava/lang/String;)V
    //   16048: goto -15804 -> 244
    //   16051: aload_0
    //   16052: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   16055: invokevirtual 1669	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   16058: invokevirtual 2318	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   16061: iconst_1
    //   16062: ldc_w 4001
    //   16065: invokestatic 2323	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   16068: iconst_0
    //   16069: invokestatic 981	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   16072: invokevirtual 2326	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   16075: pop
    //   16076: goto -15832 -> 244
    //   16079: astore_1
    //   16080: ldc_w 283
    //   16083: iconst_1
    //   16084: ldc_w 4003
    //   16087: aload_1
    //   16088: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16091: goto -15847 -> 244
    //   16094: ldc_w 4005
    //   16097: aload 4
    //   16099: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16102: ifeq +44 -> 16146
    //   16105: aload_0
    //   16106: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   16109: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   16112: iconst_m1
    //   16113: new 162	android/content/Intent
    //   16116: dup
    //   16117: invokespecial 722	android/content/Intent:<init>	()V
    //   16120: ldc_w 4007
    //   16123: aload 5
    //   16125: iconst_0
    //   16126: aaload
    //   16127: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   16130: invokevirtual 792	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   16133: aload_0
    //   16134: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   16137: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   16140: invokevirtual 795	android/app/Activity:finish	()V
    //   16143: goto -15899 -> 244
    //   16146: ldc_w 4009
    //   16149: aload 4
    //   16151: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16154: ifeq +13 -> 16167
    //   16157: aload_0
    //   16158: aload 5
    //   16160: iconst_0
    //   16161: aaload
    //   16162: invokevirtual 4010	com/tencent/mobileqq/jsp/UiApiPlugin:d	(Ljava/lang/String;)V
    //   16165: iconst_1
    //   16166: ireturn
    //   16167: ldc_w 4012
    //   16170: aload 4
    //   16172: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16175: ifeq +102 -> 16277
    //   16178: aload 5
    //   16180: arraylength
    //   16181: iconst_1
    //   16182: if_icmpne +95 -> 16277
    //   16185: new 146	org/json/JSONObject
    //   16188: dup
    //   16189: aload 5
    //   16191: iconst_0
    //   16192: aaload
    //   16193: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16196: astore_1
    //   16197: aload_1
    //   16198: ldc_w 906
    //   16201: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16204: astore_2
    //   16205: new 4014	com/tencent/mobileqq/troop/widget/TroopPickerViewHelper
    //   16208: dup
    //   16209: aload_1
    //   16210: ldc_w 4016
    //   16213: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   16216: aload_1
    //   16217: ldc_w 4018
    //   16220: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   16223: aload_1
    //   16224: ldc_w 4020
    //   16227: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   16230: aload_1
    //   16231: ldc_w 4022
    //   16234: invokevirtual 150	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   16237: aload_1
    //   16238: ldc_w 4024
    //   16241: invokevirtual 2677	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   16244: invokespecial 4027	com/tencent/mobileqq/troop/widget/TroopPickerViewHelper:<init>	(IIIIJ)V
    //   16247: aload_0
    //   16248: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   16251: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   16254: new 4029	com/tencent/mobileqq/jsp/UiApiPlugin$9
    //   16257: dup
    //   16258: aload_0
    //   16259: aload_2
    //   16260: invokespecial 4030	com/tencent/mobileqq/jsp/UiApiPlugin$9:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   16263: invokevirtual 4033	com/tencent/mobileqq/troop/widget/TroopPickerViewHelper:a	(Landroid/app/Activity;Lcom/tencent/mobileqq/troop/widget/TroopPickerViewHelper$OnConfirmListener;)V
    //   16266: goto -16022 -> 244
    //   16269: astore_1
    //   16270: aload_1
    //   16271: invokevirtual 2859	org/json/JSONException:printStackTrace	()V
    //   16274: goto -16030 -> 244
    //   16277: ldc_w 4035
    //   16280: aload 4
    //   16282: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16285: ifeq +103 -> 16388
    //   16288: new 146	org/json/JSONObject
    //   16291: dup
    //   16292: aload 5
    //   16294: iconst_0
    //   16295: aaload
    //   16296: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16299: ldc_w 906
    //   16302: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16305: astore_1
    //   16306: new 146	org/json/JSONObject
    //   16309: dup
    //   16310: invokespecial 248	org/json/JSONObject:<init>	()V
    //   16313: astore_2
    //   16314: aload_0
    //   16315: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   16318: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   16321: astore_3
    //   16322: aload_3
    //   16323: ifnonnull +5 -> 16328
    //   16326: iconst_1
    //   16327: ireturn
    //   16328: aload_3
    //   16329: invokestatic 4038	com/tencent/util/LiuHaiUtils:a	(Landroid/app/Activity;)V
    //   16332: aload_2
    //   16333: ldc_w 4040
    //   16336: invokestatic 4042	com/tencent/util/LiuHaiUtils:b	()Z
    //   16339: invokevirtual 264	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   16342: pop
    //   16343: aload_2
    //   16344: ldc_w 4044
    //   16347: getstatic 4045	com/tencent/util/LiuHaiUtils:jdField_a_of_type_Int	I
    //   16350: invokevirtual 270	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   16353: pop
    //   16354: aload_0
    //   16355: aload_1
    //   16356: iconst_1
    //   16357: anewarray 363	java/lang/String
    //   16360: dup
    //   16361: iconst_0
    //   16362: aload_2
    //   16363: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   16366: aastore
    //   16367: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   16370: goto -16126 -> 244
    //   16373: astore_1
    //   16374: ldc_w 283
    //   16377: iconst_1
    //   16378: ldc_w 4047
    //   16381: aload_1
    //   16382: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16385: goto -16141 -> 244
    //   16388: ldc_w 4049
    //   16391: aload 4
    //   16393: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16396: ifeq +136 -> 16532
    //   16399: new 146	org/json/JSONObject
    //   16402: dup
    //   16403: aload 5
    //   16405: iconst_0
    //   16406: aaload
    //   16407: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16410: astore_2
    //   16411: aload_2
    //   16412: ldc_w 4051
    //   16415: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16418: invokestatic 2146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16421: astore_1
    //   16422: aload_2
    //   16423: ldc_w 906
    //   16426: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16429: astore_2
    //   16430: aload_1
    //   16431: invokevirtual 2584	java/lang/Integer:intValue	()I
    //   16434: iconst_1
    //   16435: if_icmpne +10 -> 16445
    //   16438: iconst_1
    //   16439: invokestatic 4054	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:a	(Z)V
    //   16442: goto +15 -> 16457
    //   16445: aload_1
    //   16446: invokevirtual 2584	java/lang/Integer:intValue	()I
    //   16449: iconst_2
    //   16450: if_icmpne +7 -> 16457
    //   16453: iconst_0
    //   16454: invokestatic 4054	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:a	(Z)V
    //   16457: new 146	org/json/JSONObject
    //   16460: dup
    //   16461: invokespecial 248	org/json/JSONObject:<init>	()V
    //   16464: astore_1
    //   16465: aload_1
    //   16466: ldc_w 291
    //   16469: ldc_w 3438
    //   16472: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   16475: pop
    //   16476: invokestatic 4055	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:a	()Z
    //   16479: ifeq +1678 -> 18157
    //   16482: iconst_1
    //   16483: istore 6
    //   16485: goto +3 -> 16488
    //   16488: aload_1
    //   16489: ldc_w 4051
    //   16492: iload 6
    //   16494: invokevirtual 270	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   16497: pop
    //   16498: aload_0
    //   16499: aload_2
    //   16500: iconst_1
    //   16501: anewarray 363	java/lang/String
    //   16504: dup
    //   16505: iconst_0
    //   16506: aload_1
    //   16507: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   16510: aastore
    //   16511: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   16514: goto -16270 -> 244
    //   16517: astore_1
    //   16518: ldc_w 283
    //   16521: iconst_1
    //   16522: ldc_w 4057
    //   16525: aload_1
    //   16526: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16529: goto -16285 -> 244
    //   16532: ldc_w 4059
    //   16535: aload 4
    //   16537: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16540: ifeq +190 -> 16730
    //   16543: new 146	org/json/JSONObject
    //   16546: dup
    //   16547: aload 5
    //   16549: iconst_0
    //   16550: aaload
    //   16551: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16554: astore 4
    //   16556: aload 4
    //   16558: ldc_w 4061
    //   16561: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16564: invokestatic 2146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16567: astore_1
    //   16568: aload 4
    //   16570: ldc_w 4063
    //   16573: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16576: invokestatic 2146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16579: astore_2
    //   16580: aload 4
    //   16582: ldc_w 4065
    //   16585: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16588: invokestatic 2146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16591: astore_3
    //   16592: aload 4
    //   16594: ldc_w 906
    //   16597: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16600: astore 4
    //   16602: new 703	java/lang/StringBuilder
    //   16605: dup
    //   16606: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   16609: astore 5
    //   16611: aload 5
    //   16613: ldc_w 4067
    //   16616: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16619: pop
    //   16620: aload 5
    //   16622: aload_1
    //   16623: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16626: pop
    //   16627: aload 5
    //   16629: ldc_w 4069
    //   16632: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16635: pop
    //   16636: aload 5
    //   16638: aload_2
    //   16639: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16642: pop
    //   16643: aload 5
    //   16645: ldc_w 4071
    //   16648: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16651: pop
    //   16652: aload 5
    //   16654: aload_3
    //   16655: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16658: pop
    //   16659: ldc_w 283
    //   16662: iconst_1
    //   16663: aload 5
    //   16665: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16668: invokestatic 978	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16671: aload_0
    //   16672: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   16675: ifnonnull +17 -> 16692
    //   16678: aload_0
    //   16679: invokestatic 2027	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   16682: putfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   16685: aload_0
    //   16686: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   16689: invokevirtual 2029	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   16692: aload_0
    //   16693: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   16696: aload_1
    //   16697: aload_2
    //   16698: aload_3
    //   16699: new 4073	com/tencent/mobileqq/jsp/UiApiPlugin$10
    //   16702: dup
    //   16703: aload_0
    //   16704: aload 4
    //   16706: invokespecial 4074	com/tencent/mobileqq/jsp/UiApiPlugin$10:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   16709: invokevirtual 4077	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi$Callback;)V
    //   16712: goto -16468 -> 244
    //   16715: astore_1
    //   16716: ldc_w 283
    //   16719: iconst_1
    //   16720: ldc_w 4079
    //   16723: aload_1
    //   16724: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16727: goto -16483 -> 244
    //   16730: ldc_w 4081
    //   16733: aload 4
    //   16735: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16738: ifeq +163 -> 16901
    //   16741: new 146	org/json/JSONObject
    //   16744: dup
    //   16745: aload 5
    //   16747: iconst_0
    //   16748: aaload
    //   16749: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16752: astore_3
    //   16753: aload_3
    //   16754: ldc_w 4083
    //   16757: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16760: invokestatic 2146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16763: astore_1
    //   16764: aload_3
    //   16765: ldc_w 4063
    //   16768: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16771: invokestatic 2146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16774: astore_2
    //   16775: aload_3
    //   16776: ldc_w 2703
    //   16779: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16782: astore_3
    //   16783: new 703	java/lang/StringBuilder
    //   16786: dup
    //   16787: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   16790: astore 4
    //   16792: aload 4
    //   16794: ldc_w 4085
    //   16797: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16800: pop
    //   16801: aload 4
    //   16803: aload_1
    //   16804: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16807: pop
    //   16808: aload 4
    //   16810: ldc_w 4087
    //   16813: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16816: pop
    //   16817: aload 4
    //   16819: aload_2
    //   16820: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16823: pop
    //   16824: aload 4
    //   16826: ldc_w 4089
    //   16829: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16832: pop
    //   16833: aload 4
    //   16835: aload_3
    //   16836: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16839: pop
    //   16840: ldc_w 283
    //   16843: iconst_1
    //   16844: aload 4
    //   16846: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16849: invokestatic 978	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16852: aload_0
    //   16853: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   16856: ifnonnull +17 -> 16873
    //   16859: aload_0
    //   16860: invokestatic 2027	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   16863: putfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   16866: aload_0
    //   16867: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   16870: invokevirtual 2029	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   16873: aload_0
    //   16874: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   16877: aload_1
    //   16878: aload_2
    //   16879: aload_3
    //   16880: invokevirtual 4092	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V
    //   16883: goto -16639 -> 244
    //   16886: astore_1
    //   16887: ldc_w 283
    //   16890: iconst_1
    //   16891: ldc_w 4094
    //   16894: aload_1
    //   16895: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16898: goto -16654 -> 244
    //   16901: ldc_w 4096
    //   16904: aload 4
    //   16906: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16909: ifeq +163 -> 17072
    //   16912: new 146	org/json/JSONObject
    //   16915: dup
    //   16916: aload 5
    //   16918: iconst_0
    //   16919: aaload
    //   16920: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16923: astore_3
    //   16924: aload_3
    //   16925: ldc_w 4083
    //   16928: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16931: invokestatic 2146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16934: astore_1
    //   16935: aload_3
    //   16936: ldc_w 2703
    //   16939: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16942: astore_2
    //   16943: aload_3
    //   16944: ldc_w 4063
    //   16947: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16950: invokestatic 2146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16953: astore_3
    //   16954: new 703	java/lang/StringBuilder
    //   16957: dup
    //   16958: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   16961: astore 4
    //   16963: aload 4
    //   16965: ldc_w 4098
    //   16968: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16971: pop
    //   16972: aload 4
    //   16974: aload_1
    //   16975: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16978: pop
    //   16979: aload 4
    //   16981: ldc_w 4089
    //   16984: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16987: pop
    //   16988: aload 4
    //   16990: aload_2
    //   16991: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16994: pop
    //   16995: aload 4
    //   16997: ldc_w 4087
    //   17000: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17003: pop
    //   17004: aload 4
    //   17006: aload_3
    //   17007: invokevirtual 1000	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   17010: pop
    //   17011: ldc_w 283
    //   17014: iconst_1
    //   17015: aload 4
    //   17017: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17020: invokestatic 978	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   17023: aload_0
    //   17024: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   17027: ifnonnull +17 -> 17044
    //   17030: aload_0
    //   17031: invokestatic 2027	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   17034: putfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   17037: aload_0
    //   17038: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   17041: invokevirtual 2029	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   17044: aload_0
    //   17045: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   17048: aload_1
    //   17049: aload_2
    //   17050: aload_3
    //   17051: invokevirtual 4101	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V
    //   17054: goto -16810 -> 244
    //   17057: astore_1
    //   17058: ldc_w 283
    //   17061: iconst_1
    //   17062: ldc_w 4103
    //   17065: aload_1
    //   17066: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   17069: goto -16825 -> 244
    //   17072: ldc_w 4105
    //   17075: aload 4
    //   17077: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17080: ifeq +266 -> 17346
    //   17083: new 146	org/json/JSONObject
    //   17086: dup
    //   17087: aload 5
    //   17089: iconst_0
    //   17090: aaload
    //   17091: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17094: astore 4
    //   17096: aload 4
    //   17098: ldc_w 4107
    //   17101: iconst_1
    //   17102: invokevirtual 373	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   17105: ifne +40 -> 17145
    //   17108: aload 4
    //   17110: ldc_w 906
    //   17113: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17116: astore_1
    //   17117: ldc_w 4109
    //   17120: invokestatic 574	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   17123: checkcast 4109	com/tencent/mobileqq/kandian/biz/framework/api/IReadInJoyUtils
    //   17126: aload 4
    //   17128: aload_1
    //   17129: new 4111	com/tencent/mobileqq/jsp/UiApiPlugin$11
    //   17132: dup
    //   17133: aload_0
    //   17134: invokespecial 4112	com/tencent/mobileqq/jsp/UiApiPlugin$11:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   17137: invokeinterface 4116 4 0
    //   17142: goto -16898 -> 244
    //   17145: aload 4
    //   17147: ldc_w 1618
    //   17150: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17153: pop
    //   17154: aload 4
    //   17156: ldc_w 1620
    //   17159: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17162: pop
    //   17163: aload 4
    //   17165: ldc_w 1622
    //   17168: invokevirtual 348	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   17171: pop
    //   17172: aload 4
    //   17174: ldc_w 1624
    //   17177: invokevirtual 1628	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   17180: pop2
    //   17181: aload 4
    //   17183: ldc_w 1636
    //   17186: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17189: astore_1
    //   17190: aload 4
    //   17192: ldc_w 1638
    //   17195: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17198: astore_2
    //   17199: aload 4
    //   17201: ldc_w 1640
    //   17204: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17207: astore_3
    //   17208: aload 4
    //   17210: ldc_w 1642
    //   17213: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17216: astore 4
    //   17218: new 2426	java/util/HashMap
    //   17221: dup
    //   17222: invokespecial 3606	java/util/HashMap:<init>	()V
    //   17225: astore 14
    //   17227: aload 14
    //   17229: ldc_w 1636
    //   17232: aload_1
    //   17233: invokeinterface 4117 3 0
    //   17238: pop
    //   17239: aload 14
    //   17241: ldc_w 1638
    //   17244: aload_2
    //   17245: invokeinterface 4117 3 0
    //   17250: pop
    //   17251: aload 14
    //   17253: ldc_w 1640
    //   17256: aload_3
    //   17257: invokeinterface 4117 3 0
    //   17262: pop
    //   17263: aload 14
    //   17265: ldc_w 1642
    //   17268: aload 4
    //   17270: invokeinterface 4117 3 0
    //   17275: pop
    //   17276: aload_0
    //   17277: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   17280: ifnonnull +17 -> 17297
    //   17283: aload_0
    //   17284: invokestatic 2027	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   17287: putfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   17290: aload_0
    //   17291: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   17294: invokevirtual 2029	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   17297: new 4119	com/tencent/mobileqq/jsp/UiApiPlugin$12
    //   17300: dup
    //   17301: aload_0
    //   17302: aload 14
    //   17304: invokespecial 4122	com/tencent/mobileqq/jsp/UiApiPlugin$12:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/util/Map;)V
    //   17307: astore_1
    //   17308: aload_0
    //   17309: getfield 106	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   17312: aload_1
    //   17313: invokevirtual 4125	com/tencent/biz/troop/TroopMemberApiClient:a	(Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi$Callback;)I
    //   17316: istore 6
    //   17318: aload_0
    //   17319: aload 5
    //   17321: iconst_0
    //   17322: aaload
    //   17323: iload 6
    //   17325: invokevirtual 4126	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;I)V
    //   17328: goto -17084 -> 244
    //   17331: astore_1
    //   17332: ldc_w 283
    //   17335: iconst_1
    //   17336: ldc_w 4128
    //   17339: aload_1
    //   17340: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   17343: goto -17099 -> 244
    //   17346: ldc_w 4130
    //   17349: aload 4
    //   17351: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17354: ifeq +265 -> 17619
    //   17357: new 146	org/json/JSONObject
    //   17360: dup
    //   17361: aload 5
    //   17363: iconst_0
    //   17364: aaload
    //   17365: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17368: astore_1
    //   17369: aload_1
    //   17370: ldc_w 1707
    //   17373: invokevirtual 154	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17376: astore_2
    //   17377: aload_0
    //   17378: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   17381: invokevirtual 1431	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   17384: invokeinterface 4136 1 0
    //   17389: sipush 256
    //   17392: invokevirtual 4140	com/tencent/mobileqq/webview/swift/component/SwiftBrowserComponentsProvider:a	(I)Ljava/lang/Object;
    //   17395: checkcast 4142	com/tencent/mobileqq/webview/swift/component/SwiftMiniAIOHandler
    //   17398: astore_3
    //   17399: aload_1
    //   17400: ldc_w 4144
    //   17403: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   17406: istore 6
    //   17408: aload_1
    //   17409: ldc_w 382
    //   17412: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17415: astore 4
    //   17417: aload_1
    //   17418: ldc_w 350
    //   17421: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17424: astore 5
    //   17426: aload_1
    //   17427: ldc_w 4146
    //   17430: invokevirtual 455	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   17433: istore 7
    //   17435: ldc_w 3302
    //   17438: aload_2
    //   17439: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17442: ifeq +46 -> 17488
    //   17445: aload_3
    //   17446: aload 4
    //   17448: invokevirtual 4147	com/tencent/mobileqq/webview/swift/component/SwiftMiniAIOHandler:a	(Ljava/lang/String;)V
    //   17451: aload_3
    //   17452: iload 6
    //   17454: iload 7
    //   17456: aload 5
    //   17458: invokevirtual 4150	com/tencent/mobileqq/webview/swift/component/SwiftMiniAIOHandler:a	(IILjava/lang/String;)V
    //   17461: iload 7
    //   17463: iconst_1
    //   17464: if_icmpne +12 -> 17476
    //   17467: aload_0
    //   17468: iload 6
    //   17470: invokevirtual 4152	com/tencent/mobileqq/jsp/UiApiPlugin:b	(I)V
    //   17473: goto +85 -> 17558
    //   17476: aload_3
    //   17477: invokevirtual 4153	com/tencent/mobileqq/webview/swift/component/SwiftMiniAIOHandler:b	()V
    //   17480: aload_3
    //   17481: iconst_1
    //   17482: invokevirtual 4154	com/tencent/mobileqq/webview/swift/component/SwiftMiniAIOHandler:a	(Z)V
    //   17485: goto +73 -> 17558
    //   17488: ldc_w 4156
    //   17491: aload_2
    //   17492: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17495: ifeq +11 -> 17506
    //   17498: aload_3
    //   17499: iconst_0
    //   17500: invokevirtual 4154	com/tencent/mobileqq/webview/swift/component/SwiftMiniAIOHandler:a	(Z)V
    //   17503: goto +55 -> 17558
    //   17506: ldc_w 4051
    //   17509: aload_2
    //   17510: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17513: ifeq +27 -> 17540
    //   17516: aload_3
    //   17517: aload 4
    //   17519: invokevirtual 4147	com/tencent/mobileqq/webview/swift/component/SwiftMiniAIOHandler:a	(Ljava/lang/String;)V
    //   17522: aload_0
    //   17523: getfield 2125	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser	Lcom/tencent/mobileqq/activity/miniaio/MiniMsgUser;
    //   17526: ifnull +32 -> 17558
    //   17529: aload_0
    //   17530: getfield 2125	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser	Lcom/tencent/mobileqq/activity/miniaio/MiniMsgUser;
    //   17533: aconst_null
    //   17534: invokevirtual 4159	com/tencent/mobileqq/activity/miniaio/MiniMsgUser:onClick	(Landroid/view/View;)V
    //   17537: goto +21 -> 17558
    //   17540: ldc_w 4161
    //   17543: aload_2
    //   17544: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17547: ifeq +11 -> 17558
    //   17550: invokestatic 4166	com/tencent/mobileqq/activity/miniaio/MiniMsgIPCClient:getInstance	()Lcom/tencent/mobileqq/activity/miniaio/MiniMsgIPCClient;
    //   17553: iload 6
    //   17555: invokevirtual 4169	com/tencent/mobileqq/activity/miniaio/MiniMsgIPCClient:clearBusiness	(I)V
    //   17558: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17561: ifeq -17317 -> 244
    //   17564: new 703	java/lang/StringBuilder
    //   17567: dup
    //   17568: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   17571: astore_2
    //   17572: aload_2
    //   17573: ldc_w 4171
    //   17576: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17579: pop
    //   17580: aload_2
    //   17581: aload_1
    //   17582: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   17585: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17588: pop
    //   17589: ldc_w 283
    //   17592: iconst_2
    //   17593: aload_2
    //   17594: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17597: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17600: goto -17356 -> 244
    //   17603: astore_1
    //   17604: ldc_w 283
    //   17607: iconst_1
    //   17608: aload_1
    //   17609: iconst_0
    //   17610: anewarray 355	java/lang/Object
    //   17613: invokestatic 1442	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   17616: goto -17372 -> 244
    //   17619: ldc_w 4173
    //   17622: aload 4
    //   17624: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17627: ifeq +75 -> 17702
    //   17630: iconst_0
    //   17631: new 146	org/json/JSONObject
    //   17634: dup
    //   17635: aload 5
    //   17637: iconst_0
    //   17638: aaload
    //   17639: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17642: ldc_w 906
    //   17645: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17648: new 4175	com/tencent/mobileqq/jsp/UiApiPlugin$13
    //   17651: dup
    //   17652: aload_0
    //   17653: invokespecial 4176	com/tencent/mobileqq/jsp/UiApiPlugin$13:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   17656: invokestatic 4178	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZLjava/lang/String;Lcom/tencent/mobileqq/kandian/biz/fastweb/CallCommentJs;)V
    //   17659: goto -17415 -> 244
    //   17662: astore_1
    //   17663: new 703	java/lang/StringBuilder
    //   17666: dup
    //   17667: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   17670: astore_2
    //   17671: aload_2
    //   17672: ldc_w 4180
    //   17675: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17678: pop
    //   17679: aload_2
    //   17680: aload_1
    //   17681: invokevirtual 1144	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   17684: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17687: pop
    //   17688: ldc_w 283
    //   17691: iconst_1
    //   17692: aload_2
    //   17693: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17696: invokestatic 1130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17699: goto -17455 -> 244
    //   17702: ldc_w 4182
    //   17705: aload 4
    //   17707: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17710: ifeq +86 -> 17796
    //   17713: new 146	org/json/JSONObject
    //   17716: dup
    //   17717: aload 5
    //   17719: iconst_0
    //   17720: aaload
    //   17721: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17724: ldc_w 906
    //   17727: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17730: astore_1
    //   17731: new 146	org/json/JSONObject
    //   17734: dup
    //   17735: aload 5
    //   17737: iconst_0
    //   17738: aaload
    //   17739: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17742: aload_1
    //   17743: aload_0
    //   17744: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   17747: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   17750: invokestatic 4184	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;Landroid/app/Activity;)V
    //   17753: goto -17509 -> 244
    //   17756: astore_1
    //   17757: new 703	java/lang/StringBuilder
    //   17760: dup
    //   17761: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   17764: astore_2
    //   17765: aload_2
    //   17766: ldc_w 4186
    //   17769: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17772: pop
    //   17773: aload_2
    //   17774: aload_1
    //   17775: invokevirtual 1144	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   17778: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17781: pop
    //   17782: ldc_w 283
    //   17785: iconst_1
    //   17786: aload_2
    //   17787: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17790: invokestatic 1130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17793: goto -17549 -> 244
    //   17796: aload 4
    //   17798: ldc_w 4188
    //   17801: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17804: ifeq +10 -> 17814
    //   17807: aload_0
    //   17808: invokevirtual 4189	com/tencent/mobileqq/jsp/UiApiPlugin:a	()V
    //   17811: goto -17567 -> 244
    //   17814: ldc_w 4191
    //   17817: aload 4
    //   17819: invokevirtual 416	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17822: ifeq -17578 -> 244
    //   17825: new 146	org/json/JSONObject
    //   17828: dup
    //   17829: aload 5
    //   17831: iconst_0
    //   17832: aaload
    //   17833: invokespecial 309	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17836: astore_2
    //   17837: aload_2
    //   17838: ldc_w 906
    //   17841: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17844: astore_1
    //   17845: new 4193	com/tencent/hippy/qq/api/OpenHippyInfo
    //   17848: dup
    //   17849: aload_2
    //   17850: invokespecial 4195	com/tencent/hippy/qq/api/OpenHippyInfo:<init>	(Lorg/json/JSONObject;)V
    //   17853: aload_0
    //   17854: getfield 208	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   17857: invokevirtual 237	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   17860: invokevirtual 4198	com/tencent/hippy/qq/api/OpenHippyInfo:openHippy	(Landroid/content/Context;)Z
    //   17863: istore 10
    //   17865: aload_1
    //   17866: astore_2
    //   17867: iload 10
    //   17869: ifeq +54 -> 17923
    //   17872: iconst_0
    //   17873: istore 6
    //   17875: goto +53 -> 17928
    //   17878: astore_2
    //   17879: goto +6 -> 17885
    //   17882: astore_2
    //   17883: aconst_null
    //   17884: astore_1
    //   17885: new 703	java/lang/StringBuilder
    //   17888: dup
    //   17889: invokespecial 704	java/lang/StringBuilder:<init>	()V
    //   17892: astore_3
    //   17893: aload_3
    //   17894: ldc_w 4200
    //   17897: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17900: pop
    //   17901: aload_3
    //   17902: aload_2
    //   17903: invokevirtual 1144	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   17906: invokevirtual 710	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17909: pop
    //   17910: ldc_w 283
    //   17913: iconst_1
    //   17914: aload_3
    //   17915: invokevirtual 716	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17918: invokestatic 1130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17921: aload_1
    //   17922: astore_2
    //   17923: iconst_m1
    //   17924: istore 6
    //   17926: aload_2
    //   17927: astore_1
    //   17928: aload_1
    //   17929: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17932: ifne -17688 -> 244
    //   17935: new 146	org/json/JSONObject
    //   17938: dup
    //   17939: invokespecial 248	org/json/JSONObject:<init>	()V
    //   17942: astore_2
    //   17943: aload_2
    //   17944: ldc_w 4202
    //   17947: iload 6
    //   17949: invokevirtual 270	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   17952: pop
    //   17953: aload_0
    //   17954: aload_1
    //   17955: iconst_1
    //   17956: anewarray 363	java/lang/String
    //   17959: dup
    //   17960: iconst_0
    //   17961: aload_2
    //   17962: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   17965: aastore
    //   17966: invokevirtual 879	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   17969: goto -17725 -> 244
    //   17972: iconst_0
    //   17973: ireturn
    //   17974: astore_1
    //   17975: goto -17731 -> 244
    //   17978: astore_1
    //   17979: goto -17027 -> 952
    //   17982: astore_1
    //   17983: goto -14329 -> 3654
    //   17986: astore_1
    //   17987: goto -14248 -> 3739
    //   17990: astore 16
    //   17992: goto -14218 -> 3774
    //   17995: astore_1
    //   17996: goto -7599 -> 10397
    //   17999: astore_1
    //   18000: goto -7435 -> 10565
    //   18003: astore_1
    //   18004: goto -6609 -> 11395
    //   18007: astore_1
    //   18008: goto -6533 -> 11475
    //   18011: astore_1
    //   18012: goto -6433 -> 11579
    //   18015: astore_1
    //   18016: goto -5946 -> 12070
    //   18019: astore_1
    //   18020: goto -5529 -> 12491
    //   18023: astore_1
    //   18024: goto -5578 -> 12446
    //   18027: astore_1
    //   18028: goto -5040 -> 12988
    //   18031: astore_1
    //   18032: goto -5089 -> 12943
    //   18035: iload 6
    //   18037: sipush 1001
    //   18040: if_icmpeq -13881 -> 4159
    //   18043: goto -13873 -> 4170
    //   18046: aconst_null
    //   18047: astore_1
    //   18048: goto -13132 -> 4916
    //   18051: ldc_w 1954
    //   18054: istore 6
    //   18056: goto -12902 -> 5154
    //   18059: iconst_0
    //   18060: istore 10
    //   18062: goto -12575 -> 5487
    //   18065: iload 6
    //   18067: iconst_1
    //   18068: iadd
    //   18069: istore 6
    //   18071: goto -11343 -> 6728
    //   18074: aconst_null
    //   18075: astore_1
    //   18076: goto -11253 -> 6823
    //   18079: aconst_null
    //   18080: astore_1
    //   18081: goto -11035 -> 7046
    //   18084: aconst_null
    //   18085: astore_1
    //   18086: goto -10793 -> 7293
    //   18089: iconst_0
    //   18090: istore 6
    //   18092: goto -9415 -> 8677
    //   18095: iconst_0
    //   18096: istore 6
    //   18098: goto -8625 -> 9473
    //   18101: iconst_0
    //   18102: istore 10
    //   18104: goto -8022 -> 10082
    //   18107: iconst_0
    //   18108: istore 10
    //   18110: goto -7993 -> 10117
    //   18113: iconst_0
    //   18114: istore 10
    //   18116: goto -7852 -> 10264
    //   18119: iconst_0
    //   18120: istore 10
    //   18122: goto -7823 -> 10299
    //   18125: iload 6
    //   18127: iconst_1
    //   18128: iadd
    //   18129: istore 6
    //   18131: goto -6904 -> 11227
    //   18134: iconst_1
    //   18135: ireturn
    //   18136: iconst_1
    //   18137: ireturn
    //   18138: ldc_w 512
    //   18141: astore_1
    //   18142: goto -4798 -> 13344
    //   18145: iconst_0
    //   18146: istore 10
    //   18148: goto -3859 -> 14289
    //   18151: iconst_0
    //   18152: istore 11
    //   18154: goto -3820 -> 14334
    //   18157: iconst_2
    //   18158: istore 6
    //   18160: goto -1672 -> 16488
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	18163	0	this	UiApiPlugin
    //   0	18163	1	paramJsBridgeListener	JsBridgeListener
    //   0	18163	2	paramString1	String
    //   0	18163	3	paramString2	String
    //   0	18163	4	paramString3	String
    //   0	18163	5	paramVarArgs	String[]
    //   9	18150	6	n	int
    //   4865	12600	7	i1	int
    //   4941	9513	8	i2	int
    //   4948	17	9	i3	int
    //   6	18141	10	bool1	boolean
    //   8963	9190	11	bool2	boolean
    //   290	7613	12	l1	long
    //   680	16623	14	localObject1	Object
    //   3679	9090	15	localObject2	Object
    //   3697	1544	16	localObject3	Object
    //   17990	1	16	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   45	103	204	org/json/JSONException
    //   108	193	204	org/json/JSONException
    //   193	201	204	org/json/JSONException
    //   271	413	416	org/json/JSONException
    //   506	531	592	org/json/JSONException
    //   533	589	592	org/json/JSONException
    //   624	653	832	org/json/JSONException
    //   655	754	832	org/json/JSONException
    //   760	768	832	org/json/JSONException
    //   772	784	832	org/json/JSONException
    //   793	814	832	org/json/JSONException
    //   814	829	832	org/json/JSONException
    //   934	941	944	finally
    //   1194	1211	1214	org/json/JSONException
    //   1253	1261	1344	org/json/JSONException
    //   1265	1272	1344	org/json/JSONException
    //   1274	1339	1344	org/json/JSONException
    //   1383	1391	1425	org/json/JSONException
    //   1395	1402	1425	org/json/JSONException
    //   1404	1420	1425	org/json/JSONException
    //   1464	1472	1544	org/json/JSONException
    //   1476	1483	1544	org/json/JSONException
    //   1485	1539	1544	org/json/JSONException
    //   1583	1591	1624	org/json/JSONException
    //   1595	1602	1624	org/json/JSONException
    //   1604	1619	1624	org/json/JSONException
    //   1663	1671	1704	java/lang/Exception
    //   1675	1682	1704	java/lang/Exception
    //   1684	1699	1704	java/lang/Exception
    //   1985	2046	2185	org/json/JSONException
    //   2048	2119	2185	org/json/JSONException
    //   2121	2133	2185	org/json/JSONException
    //   2136	2182	2185	org/json/JSONException
    //   2243	2276	2330	org/json/JSONException
    //   2280	2303	2330	org/json/JSONException
    //   2303	2319	2330	org/json/JSONException
    //   2323	2327	2330	org/json/JSONException
    //   2356	2377	2380	org/json/JSONException
    //   2406	2439	2480	org/json/JSONException
    //   2443	2466	2480	org/json/JSONException
    //   2469	2477	2480	org/json/JSONException
    //   2506	2539	2580	org/json/JSONException
    //   2543	2566	2580	org/json/JSONException
    //   2569	2577	2580	org/json/JSONException
    //   2639	2672	2713	org/json/JSONException
    //   2676	2699	2713	org/json/JSONException
    //   2702	2710	2713	org/json/JSONException
    //   2739	2772	2813	org/json/JSONException
    //   2776	2799	2813	org/json/JSONException
    //   2802	2810	2813	org/json/JSONException
    //   2872	2905	2946	org/json/JSONException
    //   2909	2932	2946	org/json/JSONException
    //   2935	2943	2946	org/json/JSONException
    //   3005	3038	3079	org/json/JSONException
    //   3042	3065	3079	org/json/JSONException
    //   3068	3076	3079	org/json/JSONException
    //   3138	3192	3194	org/json/JSONException
    //   3220	3318	3584	java/lang/Exception
    //   3321	3328	3584	java/lang/Exception
    //   3331	3396	3584	java/lang/Exception
    //   3399	3406	3584	java/lang/Exception
    //   3409	3435	3584	java/lang/Exception
    //   3439	3479	3584	java/lang/Exception
    //   3482	3517	3584	java/lang/Exception
    //   3521	3581	3584	java/lang/Exception
    //   3220	3318	3599	org/json/JSONException
    //   3321	3328	3599	org/json/JSONException
    //   3331	3396	3599	org/json/JSONException
    //   3399	3406	3599	org/json/JSONException
    //   3409	3435	3599	org/json/JSONException
    //   3439	3479	3599	org/json/JSONException
    //   3482	3517	3599	org/json/JSONException
    //   3521	3581	3599	org/json/JSONException
    //   4109	4124	4215	java/lang/Exception
    //   4127	4156	4215	java/lang/Exception
    //   4159	4170	4215	java/lang/Exception
    //   4170	4205	4215	java/lang/Exception
    //   4205	4212	4215	java/lang/Exception
    //   3660	3726	4255	java/lang/Exception
    //   3726	3736	4255	java/lang/Exception
    //   3739	3747	4255	java/lang/Exception
    //   3747	3756	4255	java/lang/Exception
    //   3761	3774	4255	java/lang/Exception
    //   3774	3842	4255	java/lang/Exception
    //   3845	3874	4255	java/lang/Exception
    //   3877	3940	4255	java/lang/Exception
    //   3943	4027	4255	java/lang/Exception
    //   4030	4070	4255	java/lang/Exception
    //   4073	4090	4255	java/lang/Exception
    //   4090	4109	4255	java/lang/Exception
    //   4221	4252	4255	java/lang/Exception
    //   4345	4374	6322	java/lang/Exception
    //   4376	4398	6322	java/lang/Exception
    //   4411	4450	6322	java/lang/Exception
    //   4455	4480	6322	java/lang/Exception
    //   4480	4523	6322	java/lang/Exception
    //   4523	4542	6322	java/lang/Exception
    //   4547	4587	6322	java/lang/Exception
    //   4592	4601	6322	java/lang/Exception
    //   4601	4645	6322	java/lang/Exception
    //   4660	4680	6322	java/lang/Exception
    //   4683	4695	6322	java/lang/Exception
    //   4698	4711	6322	java/lang/Exception
    //   4711	4729	6322	java/lang/Exception
    //   4729	4819	6322	java/lang/Exception
    //   4819	4837	6322	java/lang/Exception
    //   4837	4877	6322	java/lang/Exception
    //   4882	4899	6322	java/lang/Exception
    //   4907	4913	6322	java/lang/Exception
    //   4922	4971	6322	java/lang/Exception
    //   4975	4979	6322	java/lang/Exception
    //   4979	5017	6322	java/lang/Exception
    //   5020	5043	6322	java/lang/Exception
    //   5046	5097	6322	java/lang/Exception
    //   5097	5111	6322	java/lang/Exception
    //   5111	5120	6322	java/lang/Exception
    //   5123	5151	6322	java/lang/Exception
    //   5161	5248	6322	java/lang/Exception
    //   5248	5255	6322	java/lang/Exception
    //   5259	5269	6322	java/lang/Exception
    //   5269	5326	6322	java/lang/Exception
    //   5329	5343	6322	java/lang/Exception
    //   5343	5406	6322	java/lang/Exception
    //   5409	5449	6322	java/lang/Exception
    //   5449	5459	6322	java/lang/Exception
    //   5469	5475	6322	java/lang/Exception
    //   5487	5522	6322	java/lang/Exception
    //   5522	5547	6322	java/lang/Exception
    //   5547	5567	6322	java/lang/Exception
    //   5567	5586	6322	java/lang/Exception
    //   5592	5600	6322	java/lang/Exception
    //   5603	5609	6322	java/lang/Exception
    //   5617	5623	6322	java/lang/Exception
    //   5627	5646	6322	java/lang/Exception
    //   5664	5680	6322	java/lang/Exception
    //   5680	5698	6322	java/lang/Exception
    //   5698	5738	6322	java/lang/Exception
    //   5741	5761	6322	java/lang/Exception
    //   5761	5788	6322	java/lang/Exception
    //   5788	5807	6322	java/lang/Exception
    //   5812	5836	6322	java/lang/Exception
    //   5836	5844	6322	java/lang/Exception
    //   5844	5863	6322	java/lang/Exception
    //   5873	5894	6322	java/lang/Exception
    //   5903	5921	6322	java/lang/Exception
    //   5921	5926	6322	java/lang/Exception
    //   5926	5945	6322	java/lang/Exception
    //   5956	5961	6322	java/lang/Exception
    //   5961	5987	6322	java/lang/Exception
    //   5987	6014	6322	java/lang/Exception
    //   6018	6037	6322	java/lang/Exception
    //   6047	6051	6322	java/lang/Exception
    //   6059	6063	6322	java/lang/Exception
    //   6063	6083	6322	java/lang/Exception
    //   6088	6095	6322	java/lang/Exception
    //   6095	6115	6322	java/lang/Exception
    //   6120	6143	6322	java/lang/Exception
    //   6143	6153	6322	java/lang/Exception
    //   6158	6196	6322	java/lang/Exception
    //   6196	6243	6322	java/lang/Exception
    //   6246	6273	6322	java/lang/Exception
    //   6273	6317	6322	java/lang/Exception
    //   4345	4374	6365	org/json/JSONException
    //   4376	4398	6365	org/json/JSONException
    //   4411	4450	6365	org/json/JSONException
    //   4455	4480	6365	org/json/JSONException
    //   4480	4523	6365	org/json/JSONException
    //   4523	4542	6365	org/json/JSONException
    //   4547	4587	6365	org/json/JSONException
    //   4592	4601	6365	org/json/JSONException
    //   4601	4645	6365	org/json/JSONException
    //   4660	4680	6365	org/json/JSONException
    //   4683	4695	6365	org/json/JSONException
    //   4698	4711	6365	org/json/JSONException
    //   4711	4729	6365	org/json/JSONException
    //   4729	4819	6365	org/json/JSONException
    //   4819	4837	6365	org/json/JSONException
    //   4837	4877	6365	org/json/JSONException
    //   4882	4899	6365	org/json/JSONException
    //   4907	4913	6365	org/json/JSONException
    //   4922	4971	6365	org/json/JSONException
    //   4975	4979	6365	org/json/JSONException
    //   4979	5017	6365	org/json/JSONException
    //   5020	5043	6365	org/json/JSONException
    //   5046	5097	6365	org/json/JSONException
    //   5097	5111	6365	org/json/JSONException
    //   5111	5120	6365	org/json/JSONException
    //   5123	5151	6365	org/json/JSONException
    //   5161	5248	6365	org/json/JSONException
    //   5248	5255	6365	org/json/JSONException
    //   5259	5269	6365	org/json/JSONException
    //   5269	5326	6365	org/json/JSONException
    //   5329	5343	6365	org/json/JSONException
    //   5343	5406	6365	org/json/JSONException
    //   5409	5449	6365	org/json/JSONException
    //   5449	5459	6365	org/json/JSONException
    //   5469	5475	6365	org/json/JSONException
    //   5487	5522	6365	org/json/JSONException
    //   5522	5547	6365	org/json/JSONException
    //   5547	5567	6365	org/json/JSONException
    //   5567	5586	6365	org/json/JSONException
    //   5592	5600	6365	org/json/JSONException
    //   5603	5609	6365	org/json/JSONException
    //   5617	5623	6365	org/json/JSONException
    //   5627	5646	6365	org/json/JSONException
    //   5664	5680	6365	org/json/JSONException
    //   5680	5698	6365	org/json/JSONException
    //   5698	5738	6365	org/json/JSONException
    //   5741	5761	6365	org/json/JSONException
    //   5761	5788	6365	org/json/JSONException
    //   5788	5807	6365	org/json/JSONException
    //   5812	5836	6365	org/json/JSONException
    //   5836	5844	6365	org/json/JSONException
    //   5844	5863	6365	org/json/JSONException
    //   5873	5894	6365	org/json/JSONException
    //   5903	5921	6365	org/json/JSONException
    //   5921	5926	6365	org/json/JSONException
    //   5926	5945	6365	org/json/JSONException
    //   5956	5961	6365	org/json/JSONException
    //   5961	5987	6365	org/json/JSONException
    //   5987	6014	6365	org/json/JSONException
    //   6018	6037	6365	org/json/JSONException
    //   6047	6051	6365	org/json/JSONException
    //   6059	6063	6365	org/json/JSONException
    //   6063	6083	6365	org/json/JSONException
    //   6088	6095	6365	org/json/JSONException
    //   6095	6115	6365	org/json/JSONException
    //   6120	6143	6365	org/json/JSONException
    //   6143	6153	6365	org/json/JSONException
    //   6158	6196	6365	org/json/JSONException
    //   6196	6243	6365	org/json/JSONException
    //   6246	6273	6365	org/json/JSONException
    //   6273	6317	6365	org/json/JSONException
    //   6426	6451	6867	org/json/JSONException
    //   6453	6486	6867	org/json/JSONException
    //   6486	6507	6867	org/json/JSONException
    //   6507	6542	6867	org/json/JSONException
    //   6552	6593	6867	org/json/JSONException
    //   6593	6617	6867	org/json/JSONException
    //   6617	6641	6867	org/json/JSONException
    //   6641	6669	6867	org/json/JSONException
    //   6669	6681	6867	org/json/JSONException
    //   6690	6725	6867	org/json/JSONException
    //   6735	6772	6867	org/json/JSONException
    //   6775	6783	6867	org/json/JSONException
    //   6787	6792	6867	org/json/JSONException
    //   6796	6804	6867	org/json/JSONException
    //   6808	6820	6867	org/json/JSONException
    //   6827	6844	6867	org/json/JSONException
    //   6848	6864	6867	org/json/JSONException
    //   6928	6953	7061	org/json/JSONException
    //   6955	6974	7061	org/json/JSONException
    //   6974	6998	7061	org/json/JSONException
    //   6998	7006	7061	org/json/JSONException
    //   7010	7015	7061	org/json/JSONException
    //   7019	7027	7061	org/json/JSONException
    //   7031	7043	7061	org/json/JSONException
    //   7050	7058	7061	org/json/JSONException
    //   7122	7147	7305	org/json/JSONException
    //   7149	7178	7305	org/json/JSONException
    //   7178	7199	7305	org/json/JSONException
    //   7199	7220	7305	org/json/JSONException
    //   7220	7245	7305	org/json/JSONException
    //   7245	7253	7305	org/json/JSONException
    //   7257	7262	7305	org/json/JSONException
    //   7266	7274	7305	org/json/JSONException
    //   7278	7290	7305	org/json/JSONException
    //   7297	7302	7305	org/json/JSONException
    //   7366	7392	7447	org/json/JSONException
    //   7392	7407	7447	org/json/JSONException
    //   7411	7427	7447	org/json/JSONException
    //   7430	7444	7447	org/json/JSONException
    //   7508	7612	7668	org/json/JSONException
    //   7612	7665	7668	org/json/JSONException
    //   7729	7792	7944	org/json/JSONException
    //   7796	7803	7944	org/json/JSONException
    //   7806	7847	7944	org/json/JSONException
    //   7849	7857	7944	org/json/JSONException
    //   7861	7924	7944	org/json/JSONException
    //   7927	7942	7944	org/json/JSONException
    //   8005	8071	8263	org/json/JSONException
    //   8075	8082	8263	org/json/JSONException
    //   8085	8093	8263	org/json/JSONException
    //   8102	8192	8263	org/json/JSONException
    //   8195	8226	8263	org/json/JSONException
    //   8226	8243	8263	org/json/JSONException
    //   8246	8261	8263	org/json/JSONException
    //   8324	8369	8404	org/json/JSONException
    //   8375	8382	8404	org/json/JSONException
    //   8384	8401	8404	org/json/JSONException
    //   8546	8553	8734	org/json/JSONException
    //   8555	8567	8734	org/json/JSONException
    //   8574	8582	8734	org/json/JSONException
    //   8584	8595	8734	org/json/JSONException
    //   8597	8612	8734	org/json/JSONException
    //   8617	8628	8734	org/json/JSONException
    //   8630	8639	8734	org/json/JSONException
    //   8641	8650	8734	org/json/JSONException
    //   8652	8659	8734	org/json/JSONException
    //   8664	8674	8734	org/json/JSONException
    //   8465	8507	8738	finally
    //   8507	8544	8738	finally
    //   8465	8507	8744	org/json/JSONException
    //   8507	8544	8744	org/json/JSONException
    //   8546	8553	8816	finally
    //   8555	8567	8816	finally
    //   8574	8582	8816	finally
    //   8584	8595	8816	finally
    //   8597	8612	8816	finally
    //   8617	8628	8816	finally
    //   8630	8639	8816	finally
    //   8641	8650	8816	finally
    //   8652	8659	8816	finally
    //   8664	8674	8816	finally
    //   8749	8760	8816	finally
    //   8894	8974	9117	org/json/JSONException
    //   8979	8989	9117	org/json/JSONException
    //   8992	8996	9117	org/json/JSONException
    //   8996	9002	9117	org/json/JSONException
    //   9005	9050	9117	org/json/JSONException
    //   9055	9063	9117	org/json/JSONException
    //   9063	9072	9117	org/json/JSONException
    //   9075	9083	9117	org/json/JSONException
    //   9086	9100	9117	org/json/JSONException
    //   9100	9114	9117	org/json/JSONException
    //   9178	9286	9289	java/lang/Exception
    //   9178	9286	9325	org/json/JSONException
    //   9418	9470	9570	java/lang/Exception
    //   9473	9491	9570	java/lang/Exception
    //   9495	9504	9570	java/lang/Exception
    //   9504	9567	9570	java/lang/Exception
    //   9396	9418	9574	java/lang/Exception
    //   9667	9704	9933	java/lang/Exception
    //   9711	9787	9933	java/lang/Exception
    //   9787	9871	9933	java/lang/Exception
    //   9871	9889	9933	java/lang/Exception
    //   9889	9921	9933	java/lang/Exception
    //   9645	9667	9939	java/lang/Exception
    //   10021	10055	10129	java/lang/Exception
    //   10059	10071	10129	java/lang/Exception
    //   10082	10090	10129	java/lang/Exception
    //   10093	10102	10129	java/lang/Exception
    //   10117	10126	10129	java/lang/Exception
    //   10001	10021	10133	java/lang/Exception
    //   10203	10237	10311	java/lang/Exception
    //   10241	10253	10311	java/lang/Exception
    //   10264	10272	10311	java/lang/Exception
    //   10275	10284	10311	java/lang/Exception
    //   10299	10308	10311	java/lang/Exception
    //   10183	10203	10315	java/lang/Exception
    //   10720	10765	10768	java/lang/Exception
    //   10665	10715	10785	java/lang/Exception
    //   10769	10780	10785	java/lang/Exception
    //   10645	10665	10789	java/lang/Exception
    //   10935	10966	11052	java/lang/Exception
    //   10971	11029	11052	java/lang/Exception
    //   11032	11044	11052	java/lang/Exception
    //   10926	10935	11056	java/lang/Exception
    //   10904	10926	11060	java/lang/Exception
    //   11635	11655	11683	java/lang/Exception
    //   11659	11680	11683	java/lang/Exception
    //   11635	11655	11729	org/json/JSONException
    //   11659	11680	11729	org/json/JSONException
    //   11792	11827	11947	java/lang/Exception
    //   11829	11863	11947	java/lang/Exception
    //   11867	11889	11947	java/lang/Exception
    //   11889	11944	11947	java/lang/Exception
    //   13044	13074	13142	java/lang/Exception
    //   13078	13139	13142	java/lang/Exception
    //   13044	13074	13206	org/json/JSONException
    //   13078	13139	13206	org/json/JSONException
    //   13288	13317	13382	org/json/JSONException
    //   13319	13339	13382	org/json/JSONException
    //   13344	13352	13382	org/json/JSONException
    //   13356	13379	13382	org/json/JSONException
    //   13462	13472	13475	java/lang/Exception
    //   13512	13522	13525	java/lang/Exception
    //   13443	13462	13667	org/json/JSONException
    //   13462	13472	13667	org/json/JSONException
    //   13476	13509	13667	org/json/JSONException
    //   13512	13522	13667	org/json/JSONException
    //   13526	13559	13667	org/json/JSONException
    //   13562	13570	13667	org/json/JSONException
    //   13574	13592	13667	org/json/JSONException
    //   13602	13612	13667	org/json/JSONException
    //   13620	13630	13667	org/json/JSONException
    //   13636	13646	13667	org/json/JSONException
    //   13654	13664	13667	org/json/JSONException
    //   13728	13768	13850	org/json/JSONException
    //   13772	13819	13850	org/json/JSONException
    //   13822	13847	13850	org/json/JSONException
    //   13918	13958	13961	org/json/JSONException
    //   14021	14064	14089	org/json/JSONException
    //   14072	14086	14089	org/json/JSONException
    //   14149	14176	14199	org/json/JSONException
    //   14180	14196	14199	org/json/JSONException
    //   14259	14283	14478	org/json/JSONException
    //   14289	14328	14478	org/json/JSONException
    //   14334	14392	14478	org/json/JSONException
    //   14397	14426	14478	org/json/JSONException
    //   14434	14475	14478	org/json/JSONException
    //   14538	14565	14677	org/json/JSONException
    //   14574	14578	14677	org/json/JSONException
    //   14581	14590	14677	org/json/JSONException
    //   14594	14631	14677	org/json/JSONException
    //   14637	14651	14677	org/json/JSONException
    //   14660	14674	14677	org/json/JSONException
    //   14784	14871	14946	java/lang/Exception
    //   14874	14892	14946	java/lang/Exception
    //   14897	14908	14946	java/lang/Exception
    //   14911	14922	14946	java/lang/Exception
    //   14922	14943	14946	java/lang/Exception
    //   14972	15015	15018	java/lang/Exception
    //   15058	15138	15141	java/lang/Exception
    //   15167	15257	15384	java/lang/Exception
    //   15257	15308	15384	java/lang/Exception
    //   15311	15346	15384	java/lang/Exception
    //   15349	15381	15384	java/lang/Exception
    //   15410	15484	15487	java/lang/Exception
    //   15513	15542	15624	java/lang/Exception
    //   15546	15621	15624	java/lang/Exception
    //   15650	15662	15665	java/lang/Exception
    //   15715	15796	15892	java/lang/Exception
    //   15800	15816	15892	java/lang/Exception
    //   15816	15839	15892	java/lang/Exception
    //   15839	15889	15892	java/lang/Exception
    //   15918	16002	16079	java/lang/Exception
    //   16005	16010	16079	java/lang/Exception
    //   16013	16033	16079	java/lang/Exception
    //   16036	16048	16079	java/lang/Exception
    //   16051	16076	16079	java/lang/Exception
    //   16185	16266	16269	org/json/JSONException
    //   16288	16322	16373	java/lang/Exception
    //   16328	16370	16373	java/lang/Exception
    //   16399	16442	16517	org/json/JSONException
    //   16445	16457	16517	org/json/JSONException
    //   16457	16482	16517	org/json/JSONException
    //   16488	16514	16517	org/json/JSONException
    //   16543	16692	16715	org/json/JSONException
    //   16692	16712	16715	org/json/JSONException
    //   16741	16873	16886	org/json/JSONException
    //   16873	16883	16886	org/json/JSONException
    //   16912	17044	17057	org/json/JSONException
    //   17044	17054	17057	org/json/JSONException
    //   17083	17142	17331	org/json/JSONException
    //   17145	17297	17331	org/json/JSONException
    //   17297	17328	17331	org/json/JSONException
    //   17357	17461	17603	java/lang/Exception
    //   17467	17473	17603	java/lang/Exception
    //   17476	17485	17603	java/lang/Exception
    //   17488	17503	17603	java/lang/Exception
    //   17506	17537	17603	java/lang/Exception
    //   17540	17558	17603	java/lang/Exception
    //   17558	17600	17603	java/lang/Exception
    //   17630	17659	17662	org/json/JSONException
    //   17713	17753	17756	org/json/JSONException
    //   17845	17865	17878	org/json/JSONException
    //   17825	17845	17882	org/json/JSONException
    //   864	904	17974	org/json/JSONException
    //   1062	1095	17974	java/lang/Throwable
    //   1098	1133	17974	java/lang/Throwable
    //   1136	1165	17974	java/lang/Throwable
    //   1168	1173	17974	java/lang/Throwable
    //   1791	1832	17974	org/json/JSONException
    //   1834	1888	17974	org/json/JSONException
    //   1890	1904	17974	org/json/JSONException
    //   1907	1964	17974	org/json/JSONException
    //   17928	17969	17974	org/json/JSONException
    //   934	941	17978	java/lang/Exception
    //   3639	3651	17982	org/json/JSONException
    //   3726	3736	17986	org/json/JSONException
    //   3747	3756	17990	org/json/JSONException
    //   3761	3774	17990	org/json/JSONException
    //   10365	10394	17995	org/json/JSONException
    //   10453	10503	17999	org/json/JSONException
    //   10506	10528	17999	org/json/JSONException
    //   10537	10562	17999	org/json/JSONException
    //   11164	11224	18003	org/json/JSONException
    //   11234	11245	18003	org/json/JSONException
    //   11251	11277	18003	org/json/JSONException
    //   11280	11311	18003	org/json/JSONException
    //   11314	11336	18003	org/json/JSONException
    //   11336	11362	18003	org/json/JSONException
    //   11362	11392	18003	org/json/JSONException
    //   11457	11472	18007	org/json/JSONException
    //   11555	11576	18011	org/json/JSONException
    //   11998	12050	18015	java/lang/Exception
    //   12050	12067	18015	java/lang/Exception
    //   12090	12142	18019	org/json/JSONException
    //   12145	12153	18019	org/json/JSONException
    //   12157	12164	18019	org/json/JSONException
    //   12167	12187	18019	org/json/JSONException
    //   12193	12375	18019	org/json/JSONException
    //   12383	12404	18019	org/json/JSONException
    //   12404	12425	18019	org/json/JSONException
    //   12428	12444	18019	org/json/JSONException
    //   12090	12142	18023	java/lang/Exception
    //   12145	12153	18023	java/lang/Exception
    //   12157	12164	18023	java/lang/Exception
    //   12167	12187	18023	java/lang/Exception
    //   12193	12375	18023	java/lang/Exception
    //   12383	12404	18023	java/lang/Exception
    //   12404	12425	18023	java/lang/Exception
    //   12428	12444	18023	java/lang/Exception
    //   12596	12646	18027	org/json/JSONException
    //   12649	12658	18027	org/json/JSONException
    //   12663	12671	18027	org/json/JSONException
    //   12674	12866	18027	org/json/JSONException
    //   12869	12885	18027	org/json/JSONException
    //   12888	12941	18027	org/json/JSONException
    //   12596	12646	18031	java/lang/Exception
    //   12649	12658	18031	java/lang/Exception
    //   12663	12671	18031	java/lang/Exception
    //   12674	12866	18031	java/lang/Exception
    //   12869	12885	18031	java/lang/Exception
    //   12888	12941	18031	java/lang/Exception
  }
  
  public void onActivityReady()
  {
    if ((jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (QbSdk.getTbsVersion(this.mRuntime.a()) >= 44001)) {
      f();
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      try
      {
        d();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("error:");
          localStringBuilder2.append(localException.toString());
          QLog.d("UiApiPlugin", 2, localStringBuilder2.toString());
        }
      }
    }
    if ((jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (jdField_a_of_type_AndroidContentBroadcastReceiver != null))
    {
      this.jdField_b_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_JavaLangRefWeakReference);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("put current UiApiPlugin into sUiApiPluginReferences: ");
        localStringBuilder1.append(this.jdField_a_of_type_JavaLangRefWeakReference.toString());
        QLog.d("UiApiPlugin", 2, localStringBuilder1.toString());
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 13)
    {
      if (paramIntent == null) {
        return;
      }
      localObject1 = paramIntent.getStringExtra("result");
      callJs(paramIntent.getStringExtra("callback"), new String[] { localObject1 });
      return;
    }
    Object localObject1 = "?";
    Object localObject2;
    Object localObject4;
    Object localObject5;
    if (paramByte == 3)
    {
      if (paramIntent == null) {
        return;
      }
      localObject2 = paramIntent.getStringExtra("scanResult");
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        localObject4 = paramIntent.getStringExtra("callback_url");
        paramIntent = paramIntent.getStringExtra("name");
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          if (TextUtils.isEmpty(paramIntent)) {
            return;
          }
          localObject4 = ((String)localObject4).split("#");
          localObject5 = new StringBuilder(localObject4[0]);
          if (localObject4[0].contains("?")) {
            localObject1 = "&";
          }
          ((StringBuilder)localObject5).append((String)localObject1);
          ((StringBuilder)localObject5).append(paramIntent);
          ((StringBuilder)localObject5).append("=");
          ((StringBuilder)localObject5).append(URLEncoder.encode((String)localObject2));
          if (localObject4.length > 1)
          {
            ((StringBuilder)localObject5).append("#");
            ((StringBuilder)localObject5).append(localObject4[1]);
          }
          if (this.mRuntime.a() == null) {
            return;
          }
          this.mRuntime.a().loadUrl(((StringBuilder)localObject5).toString());
          return;
        }
        return;
      }
      localObject1 = this.jdField_c_of_type_JavaLangString;
      if (localObject2 == null) {
        paramIntent = "''";
      } else {
        paramIntent = Util.a((String)localObject2);
      }
      callJs((String)localObject1, new String[] { paramIntent });
      return;
    }
    int n = 2;
    int i1 = -1;
    Object localObject3;
    boolean bool1;
    if (paramByte == 17)
    {
      if (paramIntent == null) {
        return;
      }
      paramInt = paramIntent.getIntExtra("ret_code", -1);
      localObject4 = paramIntent.getStringExtra("ocr_result");
      localObject5 = new JSONObject();
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          break label2451;
        }
        paramInt = i1;
        ((JSONObject)localObject5).put("retCode", paramInt);
        localObject2 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject2 = "";
        }
        ((JSONObject)localObject5).put("result", localObject2);
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("scanForOCR CODE_OCRCODE result: ");
        ((StringBuilder)localObject3).append(((JSONObject)localObject5).toString());
        QLog.i("UiApiPlugin", 2, ((StringBuilder)localObject3).toString());
      }
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        localObject3 = paramIntent.getStringExtra("callback_url");
        paramIntent = paramIntent.getStringExtra("name");
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          if (TextUtils.isEmpty(paramIntent)) {
            return;
          }
          localObject3 = ((String)localObject3).split("#");
          localObject4 = new StringBuilder(localObject3[0]);
          if (localObject3[0].contains("?")) {
            localObject1 = "&";
          }
          ((StringBuilder)localObject4).append((String)localObject1);
          ((StringBuilder)localObject4).append(paramIntent);
          ((StringBuilder)localObject4).append("=");
          ((StringBuilder)localObject4).append(URLEncoder.encode(((JSONObject)localObject5).toString()));
          if (localObject3.length > 1)
          {
            ((StringBuilder)localObject4).append("#");
            ((StringBuilder)localObject4).append(localObject3[1]);
          }
          if (this.mRuntime.a() == null) {
            return;
          }
          this.mRuntime.a().loadUrl(((StringBuilder)localObject4).toString());
          return;
        }
        return;
      }
      callJs(this.jdField_d_of_type_JavaLangString, new String[] { ((JSONObject)localObject5).toString() });
    }
    else if (paramByte == 4)
    {
      if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
      {
        if (paramInt == -1)
        {
          if (paramIntent == null) {
            paramIntent = "";
          } else {
            paramIntent = paramIntent.getStringExtra("result");
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("{\"code\":0,\"data\":{\"retcode\":0,\"result\":");
          ((StringBuilder)localObject1).append(paramIntent);
          ((StringBuilder)localObject1).append("}}");
          paramIntent = ((StringBuilder)localObject1).toString();
          callJs(this.jdField_f_of_type_JavaLangString, new String[] { paramIntent });
          return;
        }
        callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{\"code\":-1}" });
      }
    }
    else if (paramByte == 5)
    {
      if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))
      {
        if (paramInt == -1)
        {
          paramInt = paramIntent.getIntExtra("ret", 4);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("select contact ret:");
            ((StringBuilder)localObject1).append(paramInt);
            QLog.d("UiApiPlugin", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("ret", paramInt);
            if (paramInt == 0)
            {
              localObject3 = paramIntent.getStringArrayExtra("openids");
              paramIntent = paramIntent.getIntArrayExtra("types");
              if ((localObject3 != null) && (paramIntent != null) && (localObject3.length == paramIntent.length))
              {
                n = localObject3.length;
                localObject4 = new JSONArray();
                paramInt = 0;
                while (paramInt < n)
                {
                  ((JSONArray)localObject4).put(new JSONObject().put("type", paramIntent[paramInt]).put("openID", localObject3[paramInt]));
                  paramInt += 1;
                }
                ((JSONObject)localObject1).put("contacts", localObject4);
              }
            }
            else
            {
              ((JSONObject)localObject1).put("errMsg", paramIntent.getStringExtra("errMsg"));
            }
            callJs(this.jdField_g_of_type_JavaLangString, new String[] { ((JSONObject)localObject1).toString() });
            return;
          }
          catch (JSONException paramIntent)
          {
            if (QLog.isColorLevel()) {
              QLog.d("UiApiPlugin", 2, "select contact result json exception", paramIntent);
            }
            callJs(this.jdField_g_of_type_JavaLangString, new String[] { "{\"ret\":4}" });
            return;
          }
        }
        callJs(this.jdField_g_of_type_JavaLangString, new String[] { "{\"ret\":3}" });
      }
    }
    else if (paramByte == 7)
    {
      if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
      {
        if (paramInt == -1)
        {
          paramInt = paramIntent.getIntExtra("ret", 0);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("select Member ret:");
            ((StringBuilder)localObject1).append(paramInt);
            QLog.d("UiApiPlugin", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("ret", paramInt);
            if (paramInt == 0)
            {
              ((JSONObject)localObject1).put("selectMore", this.jdField_b_of_type_Boolean);
              ((JSONObject)localObject1).put("uin", this.k);
              ((JSONObject)localObject1).put("uinType", "0");
              localObject3 = new JSONArray();
              if (this.jdField_b_of_type_Boolean)
              {
                paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
                paramInt = 0;
                while (paramInt < paramIntent.size())
                {
                  localObject4 = (ResultRecord)paramIntent.get(paramInt);
                  ((JSONArray)localObject3).put(new JSONObject().put("memUin", ((ResultRecord)localObject4).uin).put("nick", ((ResultRecord)localObject4).name));
                  paramInt += 1;
                }
              }
              localObject4 = paramIntent.getStringExtra("member_uin");
              paramIntent = paramIntent.getStringExtra("member_display_name");
              ((JSONArray)localObject3).put(new JSONObject().put("memUin", localObject4).put("nick", paramIntent));
              ((JSONObject)localObject1).put("selectUins", localObject3);
            }
            else
            {
              ((JSONObject)localObject1).put("errMsg", paramIntent.getStringExtra("errMsg"));
            }
            callJs(this.jdField_f_of_type_JavaLangString, new String[] { ((JSONObject)localObject1).toString() });
            return;
          }
          catch (JSONException paramIntent)
          {
            if (QLog.isColorLevel()) {
              QLog.d("UiApiPlugin", 2, "select contact result json exception", paramIntent);
            }
            callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{\"ret\":3,\"errMsg\":\"Json Parse Error\"}" });
            return;
          }
        }
        callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{\"ret\":1,\"errMsg\":\"User cancle\"}" });
      }
    }
    else if (paramByte == 6)
    {
      if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
      {
        if (paramInt == -1)
        {
          callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{'retcode' : 0}" });
          return;
        }
        paramInt = paramIntent.getIntExtra("retCode", -1);
        paramIntent = this.jdField_f_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("{'retcode' : ");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append("}");
        callJs(paramIntent, new String[] { ((StringBuilder)localObject1).toString() });
      }
    }
    else if ((paramByte != 8) && (paramByte != 9))
    {
      if (paramByte == 10)
      {
        if ((paramInt != -1) && (paramIntent == null)) {
          break label2450;
        }
        TroopGiftUtil.a(this.mRuntime.a(), paramIntent, null);
        a(paramIntent.getStringExtra("troop_uin"), "send_page");
        return;
      }
      if (paramByte == 11)
      {
        localObject1 = null;
        if (paramIntent != null)
        {
          localObject1 = paramIntent.getStringExtra("callback");
          bool1 = paramIntent.getBooleanExtra("isOpenApi", false);
        }
        else
        {
          bool1 = false;
        }
        localObject3 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = this.l;
          boolean bool2 = this.jdField_c_of_type_Boolean;
          localObject3 = localObject1;
          bool1 = bool2;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = localObject1;
            bool1 = bool2;
            if (!bool2)
            {
              if (QLog.isColorLevel()) {
                QLog.w("UiApiPlugin", 2, "groupOrganizationView no callback");
              }
              return;
            }
          }
        }
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
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        n = paramIntent.getIntExtra("ret", 5);
        ((JSONObject)localObject1).put("ret", n);
        localObject4 = paramIntent.getStringExtra("errMsg");
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          ((JSONObject)localObject1).put("errMsg", localObject4);
        }
        if (n != 0) {
          break label2454;
        }
        paramIntent = paramIntent.getStringArrayExtra("result");
        localObject4 = new JSONArray();
        i1 = paramIntent.length;
        paramInt = 0;
        if (paramInt < i1)
        {
          ((JSONArray)localObject4).put(paramIntent[paramInt]);
          paramInt += 1;
          continue;
        }
        ((JSONObject)localObject1).put("openIDArr", localObject4);
      }
      catch (JSONException paramIntent)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("UiApiPlugin", 2, "groupOrganization error", paramIntent);
        if (!bool1) {
          continue;
        }
        callJs4OpenApiIfNeeded("groupOrganizationView", -100, "{ret:4}");
        return;
        callJs((String)localObject3, new String[] { "{ret:4}" });
        return;
      }
      callJs4OpenApiIfNeeded("groupOrganizationView", paramInt, ((JSONObject)localObject1).toString());
      return;
      callJs((String)localObject3, new String[] { ((JSONObject)localObject1).toString() });
      return;
      if (paramByte == 12)
      {
        i1 = paramIntent.getIntExtra("cGroupOption", -1);
        localObject1 = paramIntent.getStringExtra("troop_uin");
        if (paramIntent.getBooleanExtra("isSetFee", false)) {
          paramInt = 4;
        } else if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              if (i1 != 4)
              {
                paramInt = n;
                if (i1 != 5) {
                  paramInt = -1;
                }
              }
              else
              {
                paramInt = 3;
              }
            }
            else {
              paramInt = 5;
            }
          }
          else {
            paramInt = 1;
          }
        }
        else {
          paramInt = 0;
        }
        paramIntent = new JSONObject();
        try
        {
          paramIntent.put("gc", localObject1);
          paramIntent.put("ret", 0);
          paramIntent.put("joinType", paramInt);
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
        }
        callJs(this.m, new String[] { paramIntent.toString() });
        return;
      }
      String str;
      if (paramByte == 15)
      {
        if (!TextUtils.isEmpty(this.i))
        {
          str = this.i;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("{'result' : ");
          if (paramInt == -1) {
            paramIntent = "true";
          } else {
            paramIntent = "false";
          }
          ((StringBuilder)localObject3).append(paramIntent);
          ((StringBuilder)localObject3).append("}");
          callJs(str, new String[] { ((StringBuilder)localObject3).toString() });
        }
      }
      else if (paramByte == 16)
      {
        if (!TextUtils.isEmpty(this.j))
        {
          str = this.j;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("{'result' : ");
          if (paramInt == -1) {
            paramIntent = "true";
          } else {
            paramIntent = "false";
          }
          ((StringBuilder)localObject3).append(paramIntent);
          ((StringBuilder)localObject3).append("}");
          callJs(str, new String[] { ((StringBuilder)localObject3).toString() });
        }
      }
      else if ((paramByte == 117) && (paramInt == 1699))
      {
        str = paramIntent.getStringExtra("arg_callback");
        if (TextUtils.isEmpty(str)) {
          return;
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBiuAndCommentMixApiIRIJBiuAndCommentMixDataManager;
        if (localObject3 != null) {
          ((IRIJBiuAndCommentMixDataManager)localObject3).a();
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBiuAndCommentMixApiIRIJBiuAndCommentMixDataManager = ((IRIJBiuAndCommentMixDataManagerFactory)QRoute.api(IRIJBiuAndCommentMixDataManagerFactory.class)).create();
        ((IUiApiPlugin)QRoute.api(IUiApiPlugin.class)).handleInfoAndRequestForWeb(paramIntent, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBiuAndCommentMixApiIRIJBiuAndCommentMixDataManager, str, new UiApiPlugin.15(this));
        return;
        if (paramInt == -1)
        {
          if (paramIntent == null) {
            return;
          }
          bool1 = paramIntent.getBooleanExtra("key_troop_fee_notify_js_data_changed", false);
          paramIntent = paramIntent.getStringExtra("callback");
          if (bool1) {
            callJs(paramIntent, new String[] { "{}" });
          }
        }
      }
      label2450:
      return;
      label2451:
      break;
      label2454:
      if (bool1) {
        if (n == 0) {
          paramInt = 0;
        } else {
          paramInt = -100;
        }
      }
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
      Activity localActivity = this.mRuntime.a();
      if (localActivity != null) {
        localActivity.finish();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate()
  {
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver);
  }
  
  protected void onDestroy()
  {
    if ((jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("remove current UiApiPlugin from sUiApiPluginReferences: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangRefWeakReference.toString());
        QLog.d("UiApiPlugin", 2, ((StringBuilder)localObject).toString());
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(this.jdField_a_of_type_JavaLangRefWeakReference);
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    b();
    this.jdField_a_of_type_ComTencentBizUiRefreshView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader = null;
    Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    localObject = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    if (localObject != null) {
      ((TroopMemberApiClient)localObject).b();
    }
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
    if (localObject != null)
    {
      ((MiniMsgUser)localObject).onBackground();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.destroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBiuAndCommentMixApiIRIJBiuAndCommentMixDataManager;
    if (localObject != null)
    {
      ((IRIJBiuAndCommentMixDataManager)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBiuAndCommentMixApiIRIJBiuAndCommentMixDataManager = null;
    }
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
  
  public void onDismissOperations()
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity instanceof PublicFragmentActivity)) {
      ((PublicFragmentActivity)localActivity).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin
 * JD-Core Version:    0.7.0.1
 */