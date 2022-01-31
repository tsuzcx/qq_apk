package com.tencent.mobileqq.webview.swift.component;

import akbx;
import akby;
import akbz;
import akca;
import akcb;
import akcc;
import akcd;
import akce;
import akcf;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.app.UniformDownload;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.jsp.X5ApiPlugin;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.webso.SHA1Util;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.comic.utils.QQComicRedTouchManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class SwiftBrowserTBSHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
  implements Handler.Callback
{
  long jdField_a_of_type_Long = 0L;
  public Dialog a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public final QQBrowserActivity a;
  public WebViewFragment a;
  public Boolean a;
  public final Object a;
  public String a;
  public HashSet a;
  Map jdField_a_of_type_JavaUtilMap;
  public MqqHandler a;
  boolean jdField_a_of_type_Boolean = false;
  
  public SwiftBrowserTBSHandler(Activity paramActivity)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = null;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_AndroidAppDialog = null;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_JavaLangString = null;
    if ((paramActivity instanceof QQBrowserActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)paramActivity);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = null;
  }
  
  private static Pair a(String paramString)
  {
    int i = 0;
    int j;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if ((paramString.isHierarchical()) && (AuthorizeConfig.a().h(paramString.getHost())))
      {
        j = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
        i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().heightPixels - (int)UITools.a(BaseApplicationImpl.getApplication(), 54.0F);
      }
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(j), Integer.valueOf(i));
      j = 0;
    }
  }
  
  private String a()
  {
    Object localObject;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.size() > 1))
    {
      if (this.jdField_a_of_type_JavaUtilMap == null)
      {
        localObject = (QQComicRedTouchManager)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web")).getManager(212);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("1113.100803");
        this.jdField_a_of_type_JavaUtilMap = ((QQComicRedTouchManager)localObject).a(localArrayList);
      }
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        break label244;
      }
      localObject = (RedAppInfo)this.jdField_a_of_type_JavaUtilMap.get("1113.100803");
      if ((localObject != null) && (((RedAppInfo)localObject).b() != 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.size() > 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d == 0))
      {
        localObject = (WebViewTabBarData)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.get(4);
        if (localObject != null)
        {
          return ((WebViewTabBarData)localObject).url;
          i = 0;
        }
        else
        {
          return "";
        }
      }
      else
      {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d + 1;
        if (i < this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.size()) {}
        while (i > 0)
        {
          localObject = (WebViewTabBarData)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.get(i);
          if (localObject != null)
          {
            return ((WebViewTabBarData)localObject).url;
            i = -1;
          }
          else
          {
            return "";
          }
        }
        return null;
        label244:
        i = 0;
      }
    }
  }
  
  public static void a(WebView paramWebView, String paramString1, String paramString2)
  {
    Object localObject = a(paramString1);
    int i = ((Integer)((Pair)localObject).first).intValue();
    int j = ((Integer)((Pair)localObject).second).intValue();
    if ((i <= 0) || (j <= 0) || (paramWebView == null) || (paramWebView.getX5WebViewExtension() == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {}
    for (localObject = "";; localObject = SHA1Util.a(paramString2))
    {
      ThreadManager.getUIHandler().post(new akbx(paramString2, paramString1, paramWebView, i, j, (String)localObject));
      return;
    }
  }
  
  private void c()
  {
    if (SwiftWebViewUtils.a())
    {
      String str = a();
      if ((!TextUtils.isEmpty(str)) && (SwiftWebViewUtils.a(str)) && (!str.contains("asyncMode=3")) && (!str.contains("sonic=1"))) {
        ThreadManager.post(new akcf(this, str), 5, null, true);
      }
    }
  }
  
  public Object a(String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null) {
      paramString = null;
    }
    String str;
    do
    {
      do
      {
        return paramString;
        if ("openBrowserList".equals(paramString))
        {
          QLog.d("SwiftBrowserTBSHandler", 1, "XChooserActivity 已在725下架");
          return null;
        }
        if (!"addDownloadTask".equals(paramString)) {
          break;
        }
        if (paramBundle == null) {
          return null;
        }
        str = paramBundle.getString("task_name");
        paramString = paramBundle.getString("task_url");
        paramBundle = paramBundle.getString("appid");
        this.jdField_a_of_type_JavaLangString = paramString;
        paramString = paramBundle;
      } while (paramBundle == null);
      paramString = paramBundle;
    } while (str == null);
    paramString = DownloadManager.a().a(paramBundle);
    Object localObject;
    if (paramString != null)
    {
      paramString = paramString.c;
      localObject = new Bundle();
      ((Bundle)localObject).putString(DownloadConstants.jdField_a_of_type_JavaLangString, paramBundle);
      ((Bundle)localObject).putString(DownloadConstants.i, paramString);
      ((Bundle)localObject).putInt(DownloadConstants.j, 2);
      ((Bundle)localObject).putString(DownloadConstants.k, str);
      ((Bundle)localObject).putBoolean(DownloadConstants.q, false);
      ((Bundle)localObject).putBoolean(DownloadConstants.w, false);
      ((Bundle)localObject).putString(DownloadConstants.l, "_" + paramBundle);
      DownloadApi.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, (Bundle)localObject, 0, null, 0);
      return paramBundle;
    }
    ThreadManager.post(new akbz(this, paramBundle, str), 8, null, true);
    return paramBundle;
    if ("cancelDownloadTask".equals(paramString))
    {
      paramString = paramBundle.getString("download_id");
      if (!DownloadApi.a(paramString)) {
        return Boolean.valueOf(false);
      }
      DownloadApi.a(paramString, "_" + paramString, true);
      return Boolean.valueOf(true);
    }
    if ("queryDownloadTask".equals(paramString))
    {
      paramString = paramBundle.getString("download_id");
      paramString = DownloadManager.a().a(paramString);
      if (paramString == null) {
        return Integer.valueOf(0);
      }
      switch (paramString.a())
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        return Integer.valueOf(0);
      case 10: 
        return Integer.valueOf(5);
      case 4: 
        return Integer.valueOf(3);
      case 2: 
        return Integer.valueOf(1);
      }
      return Integer.valueOf(2);
    }
    if ("installDownloadTask".equals(paramString))
    {
      paramString = paramBundle.getString("download_id");
      paramBundle = DownloadManager.a().a(paramString);
      if ((paramBundle == null) || (paramBundle.a() != 4)) {
        return Boolean.valueOf(false);
      }
      paramBundle = new Bundle();
      paramBundle.putString(DownloadConstants.jdField_a_of_type_JavaLangString, paramString);
      paramBundle.putInt(DownloadConstants.j, 5);
      paramBundle.putBoolean(DownloadConstants.q, false);
      paramBundle.putBoolean(DownloadConstants.w, false);
      DownloadApi.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, paramBundle, 0, null, 0);
      return Boolean.valueOf(true);
    }
    if ("notifyQBiconShine".equals(paramString))
    {
      paramString = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2);
      if (paramString != null)
      {
        paramString.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.u = true;
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserTBSHandler", 2, "QQBrowser has related content.");
        }
      }
    }
    do
    {
      for (;;)
      {
        return null;
        if (!"onNotifyResourceRequestURL".equals(paramString)) {
          break;
        }
        if (paramBundle.containsKey("url"))
        {
          paramString = paramBundle.getString("url");
          if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http")))
          {
            str = Uri.parse(paramString).getQueryParameter("_bid");
            if (!TextUtils.isEmpty(str))
            {
              if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserTBSHandler", 2, "ServiceWorkerOffline Notify Resource RequestURL: " + paramBundle.getString("url"));
              }
              if (this.jdField_a_of_type_JavaUtilHashSet == null) {
                this.jdField_a_of_type_JavaUtilHashSet = new HashSet(6);
              }
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(str))
              {
                this.jdField_a_of_type_JavaUtilHashSet.add(str);
                ThreadManager.getUIHandler().postDelayed(new akca(this, paramString), 5000L);
              }
            }
          }
        }
      }
      if (!"netTimeConsumingReport".equals(paramString)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserTBSHandler", 2, "netTimeConsumingReport start");
      }
    } while (!paramBundle.containsKey("firstbyte"));
    for (;;)
    {
      int i;
      try
      {
        paramString = paramBundle.getString("firstbyte");
        paramBundle = paramBundle.getString("firstscreen");
        if (TextUtils.isEmpty(paramString)) {
          break label1144;
        }
        l1 = Long.parseLong(paramString);
        if (TextUtils.isEmpty(paramBundle)) {
          break label1150;
        }
        l2 = Long.parseLong(paramBundle);
        if (QLog.isColorLevel()) {
          QLog.i("SwiftBrowserTBSHandler", 2, String.format("receive firstByteStr: %s, receive firstScreenStr: %s", new Object[] { paramString, paramBundle }));
        }
        paramBundle = "";
        str = HttpUtil.a();
        i = 0;
        int j = QbSdk.getTbsVersion(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
        long l3 = 0L;
        long l4 = 0L;
        long l5 = 0L;
        localObject = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);
        if (localObject == null) {
          break label1303;
        }
        paramBundle = ((SwiftBrowserStatistics)localObject).jdField_b_of_type_JavaLangString;
        paramString = paramBundle;
        if (!TextUtils.isEmpty(paramBundle))
        {
          paramString = paramBundle;
          if (paramBundle.contains("?")) {
            paramString = paramBundle.substring(0, paramBundle.indexOf("?"));
          }
        }
        paramBundle = String.valueOf(((SwiftBrowserStatistics)localObject).a.b);
        if (!((SwiftBrowserStatistics)localObject).s) {
          break label1156;
        }
        i = 2;
        l3 = ((SwiftBrowserStatistics)localObject).jdField_b_of_type_Long;
        l4 = ((SwiftBrowserStatistics)localObject).c;
        l5 = ((SwiftBrowserStatistics)localObject).n;
        VasWebviewUtil.reportNetworkSpeedTimeFromX5(paramString, paramBundle, i, 0, j, str, l3, l4, l5, l1, l2);
        if (QLog.isColorLevel()) {
          QLog.i("SwiftBrowserTBSHandler", 2, String.format("webview start - click start: %d, loadurl - webview start: %d, first byte - loadurl: %d, first screen - first byte: %d", new Object[] { Long.valueOf(l4 - l3), Long.valueOf(l5 - l4), Long.valueOf(l1 - l5), Long.valueOf(l2 - l1) }));
        }
        QLog.i("SwiftBrowserTBSHandler", 1, "Web_qqbrowser_X5_from_loadUrl_to_FirstByte, cost=" + (l1 - l5));
        QLog.i("SwiftBrowserTBSHandler", 1, "Web_qqbrowser_X5_from_FirstByte_to_FirstScreen, cost=" + (l2 - l1));
      }
      catch (Exception paramString)
      {
        QLog.e("SwiftBrowserTBSHandler", 2, "", paramString);
      }
      break;
      label1144:
      long l1 = 0L;
      continue;
      label1150:
      long l2 = 0L;
      continue;
      label1156:
      boolean bool = SwiftBrowserStatistics.o;
      if (bool)
      {
        i = 1;
      }
      else
      {
        i = 0;
        continue;
        if (!"onUploadLiveLogFinished".equals(paramString)) {
          break;
        }
        bool = paramBundle.getBoolean("result", false);
        QLog.d("SwiftBrowserTBSHandler", 1, "onUploadLiveLogFinished, result: " + bool);
        if ((UiApiPlugin.jdField_a_of_type_AndroidOsResultReceiver == null) || (UiApiPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get() == -1L)) {
          break;
        }
        paramString = new Bundle();
        paramString.putLong("seq", UiApiPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get());
        paramBundle = UiApiPlugin.jdField_a_of_type_AndroidOsResultReceiver;
        if (bool) {}
        for (i = 0;; i = -3)
        {
          paramBundle.send(i, paramString);
          UiApiPlugin.jdField_a_of_type_AndroidOsResultReceiver = null;
          UiApiPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(-1L);
          break;
        }
        label1303:
        paramString = "";
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null)) {
      return;
    }
    Object localObject1 = WebAccelerateHelper.getInstance().getTBSDpcParam();
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (((String)localObject1).charAt(0) == '1') {
        break label322;
      }
      if (!QLog.isColorLevel()) {
        break label432;
      }
      QLog.i("SwiftBrowserTBSHandler", 2, "warning: disable tbs, " + (String)localObject1);
      i = 0;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null) && (i != 0)) {
        if ("CN".equals(Locale.getDefault().getCountry())) {
          if (TbsDownloader.needDownload(BaseApplication.getContext(), false))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TBS_update", 2, "tbs need download");
            }
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a(false);
            label140:
            i = 1;
            label142:
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext == null) {
              break label427;
            }
          }
        }
      }
      label413:
      label420:
      label427:
      for (localObject1 = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);; localObject1 = null)
      {
        if (((localObject1 == null) || (!((SwiftBrowserStatistics)localObject1).e)) && (!QLog.isColorLevel())) {
          break label430;
        }
        int j = QbSdk.getTbsVersion(BaseApplicationImpl.getApplication());
        Object localObject2;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("tbs current webview:");
          if (j == 0)
          {
            localObject2 = "sys";
            label221:
            QLog.d("TBS_update", 2, (String)localObject2);
          }
        }
        else
        {
          if ((localObject1 == null) || (!((SwiftBrowserStatistics)localObject1).e)) {
            break;
          }
          localObject2 = new StringBuilder().append("tbs_cover_");
          if (i == 0) {
            break label420;
          }
          if (j <= 0) {
            break label413;
          }
          localObject1 = "tbs";
        }
        for (;;)
        {
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", (String)localObject1, 0, 1, j, "", "", "", "");
          return;
          QLog.e("SwiftBrowserTBSHandler", 1, "error: no dpc param!");
          label322:
          i = 1;
          break;
          if (!QLog.isColorLevel()) {
            break label140;
          }
          QLog.d("TBS_update", 2, "tbs no need download");
          break label140;
          if (QLog.isColorLevel())
          {
            QLog.d("TBS_update", 2, "tbs loc/tz not match");
            i = 0;
            break label142;
            if (QLog.isColorLevel()) {
              QLog.d("TBS_update", 2, "tbs update disabled");
            }
          }
          i = 0;
          break label142;
          localObject2 = "x5_" + j;
          break label221;
          localObject1 = "sys";
          continue;
          localObject1 = "dis";
        }
      }
      label430:
      break;
      label432:
      i = 0;
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle = null;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
              this.jdField_a_of_type_AndroidAppDialog.dismiss();
            }
          } while (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null);
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
          return;
        } while (this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_Boolean = true;
        c();
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
          paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a();
        }
      } while (paramBundle == null);
      paramBundle = (X5ApiPlugin)paramBundle.a().a("x5");
    } while (paramBundle == null);
    paramBundle.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    VasWebviewUtil.reportVasStatus("WebViewStatus", "x5_preload", "0", 0, 0, paramInt, 0, paramString, "");
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserTBSHandler", 2, "handlePreloadCallback: type=" + paramInt + ", url=" + paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (X5ApiPlugin)((CustomWebView)localObject).a().a("x5");
        if (localObject != null) {
          ((X5ApiPlugin)localObject).a(paramInt, paramString);
        }
      }
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt < 12)
    {
      try
      {
        localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setConnectTimeout(20000);
        localHttpURLConnection.setRequestMethod("GET");
        localHttpURLConnection.connect();
        i = localHttpURLConnection.getResponseCode();
        if ((i != 301) && (i != 302)) {
          break label143;
        }
        paramString = localHttpURLConnection.getHeaderFields().keySet().iterator();
        String str;
        do
        {
          if (!paramString.hasNext()) {
            break;
          }
          str = (String)paramString.next();
        } while (!"location".equalsIgnoreCase(str));
        paramString = localHttpURLConnection.getHeaderField(str);
      }
      catch (Throwable paramString)
      {
        HttpURLConnection localHttpURLConnection;
        int i;
        label143:
        while (QLog.isColorLevel())
        {
          QLog.e("SwiftBrowserTBSHandler", 2, paramString.getMessage());
          return;
          paramString = null;
        }
      }
      if (paramString != null)
      {
        a(MsfSdkUtils.insertMtype("Web", paramString), paramInt + 1);
        return;
        if (i == 200)
        {
          this.jdField_a_of_type_Long = localHttpURLConnection.getContentLength();
          this.jdField_a_of_type_JavaLangString = localHttpURLConnection.getURL().toString();
        }
      }
      localHttpURLConnection.disconnect();
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null)) {
      return;
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {}
    Object localObject;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
          this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
        }
        localObject = DownloadManager.a().a("801097412");
        if ((localObject == null) || (!NetworkUtil.h(BaseApplicationImpl.getApplication()))) {
          break;
        }
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
        this.jdField_a_of_type_JavaLangString = ((DownloadInfo)localObject).c;
        if (paramBoolean)
        {
          paramString = BaseApplicationImpl.getApplication().getResources().getString(2131435459);
          QQToast.a(BaseApplicationImpl.getApplication(), 2, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.b());
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(102));
          return;
        }
      }
      finally {}
      paramString = BaseApplicationImpl.getApplication().getResources().getString(2131435455);
    }
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.isFinishing())
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      ThreadManager.post(new akcb(this), 8, null, true);
      paramString = new akcc(this);
      localObject = new akcd(this);
      if (!NetworkUtil.h(BaseApplicationImpl.getApplication())) {
        break label351;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(102));
      if (!paramBoolean) {
        break label335;
      }
    }
    label335:
    for (paramString = BaseApplicationImpl.getApplication().getResources().getString(2131435459);; paramString = BaseApplicationImpl.getApplication().getResources().getString(2131435455))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.b());
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      break;
    }
    label351:
    if (paramBoolean)
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130841630);
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, localDrawable, BaseApplicationImpl.getApplication().getResources().getString(2131435460), " ", BaseApplicationImpl.getApplication().getResources().getString(2131433682), BaseApplicationImpl.getApplication().getResources().getString(2131435452), paramString, (View.OnClickListener)localObject);
      this.jdField_a_of_type_AndroidAppDialog.show();
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("qb_info", 0);
      if (paramString == null) {
        break label567;
      }
    }
    label567:
    for (paramString = paramString.getString("icon_url", null);; paramString = null)
    {
      localObject = new akce(this);
      if (paramString != null)
      {
        paramString = URLDrawable.getDrawable(paramString);
        paramString.setURLDrawableListener((URLDrawable.URLDrawableListener)localObject);
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(103, paramString));
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, BaseApplicationImpl.getApplication().getResources().getString(2131435454), 2131433682, 2131435452, paramString, (View.OnClickListener)localObject);
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return true;
            paramMessage = (String)paramMessage.obj;
            try
            {
              paramMessage = new JSONObject(paramMessage);
              localObject1 = paramMessage.getJSONObject("icon");
              Object localObject2 = paramMessage.getJSONObject("content");
              paramMessage = ((JSONObject)localObject1).getString("timestamp");
              localObject1 = ((JSONObject)localObject1).getString("url");
              String str = ((JSONObject)localObject2).getString("timestamp");
              localObject2 = ((JSONObject)localObject2).getString("memo");
              Object localObject3 = BaseApplicationImpl.getApplication().getSharedPreferences("qb_info", 0);
              if (localObject3 != null)
              {
                localObject3 = ((SharedPreferences)localObject3).edit();
                ((SharedPreferences.Editor)localObject3).putString("icon_time", paramMessage);
                ((SharedPreferences.Editor)localObject3).putString("icon_url", (String)localObject1);
                ((SharedPreferences.Editor)localObject3).putString("content_time", str);
                ((SharedPreferences.Editor)localObject3).putString("content_memo", (String)localObject2);
                ((SharedPreferences.Editor)localObject3).commit();
                return true;
              }
            }
            catch (Exception paramMessage)
            {
              return true;
            }
          }
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.h));
        paramMessage = (Bundle)paramMessage.obj;
        if (paramMessage != null)
        {
          localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("qb_info", 0);
          if (localObject1 != null)
          {
            paramMessage.putString("param_content_memo", ((SharedPreferences)localObject1).getString("content_memo", null));
            paramMessage.putString("param_icon_path", ((SharedPreferences)localObject1).getString("icon_url", null));
          }
          paramMessage.putString("param_user_agent", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().getUserAgentString());
          paramMessage.putString("param_refer_url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl());
          localObject1 = paramMessage.getString("qb_param_url");
          if ((localObject1 != null) && (((String)localObject1).length() != 0))
          {
            paramMessage.remove("qb_param_url");
            paramMessage.putBoolean("param_isqbdownload", true);
            UniformDownload.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, (String)localObject1, paramMessage);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        return true;
        ThreadManager.post(new akby(this), 8, null, true);
        return true;
        paramMessage = (Drawable)paramMessage.obj;
      } while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) || (paramMessage == null));
      Object localObject1 = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131364070);
      ((ImageView)localObject1).setImageDrawable(null);
      ((ImageView)localObject1).setImageDrawable(paramMessage);
      return true;
      paramMessage = (String)paramMessage.obj;
    } while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) || (paramMessage == null));
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131364073)).setText(paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler
 * JD-Core Version:    0.7.0.1
 */