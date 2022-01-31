package com.tencent.mobileqq.fragment;

import advf;
import advg;
import advh;
import advi;
import advm;
import advn;
import advo;
import advp;
import advq;
import advr;
import advs;
import advt;
import advu;
import advv;
import advw;
import advx;
import advy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.RefreshView.OnRefreshListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyActivity.TabInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.nearby.NearPeopleFilters;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.EnterItem;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearby.ipc.NearbyProcObserver;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout.OnActionListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.util.URLUtil;
import com.tencent.widget.ActionSheet;
import cooperation.peak.PeakUtils;
import java.util.ArrayList;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class NearbyHybridFragment
  extends NearbyBaseFragment
  implements Handler.Callback
{
  public static long a;
  public static SosoInterface.SosoLbsInfo a;
  public static final Runnable a;
  public static boolean l;
  protected View.OnClickListener a;
  protected AdapterView.OnItemClickListener a;
  protected FrameLayout a;
  protected LinearLayout a;
  protected TextView a;
  protected RefreshView.OnRefreshListener a;
  public RefreshView a;
  public URLImageView a;
  public NearbyActivity a;
  protected NearbyObserver a;
  public NearbyHybridFragment.NearbyWebViewBuilder a;
  public NearPeopleFilters a;
  public NearbyFragmentEnterAdapter a;
  protected NearbyProcObserver a;
  protected OverCoverFrameLayout.OnActionListener a;
  public OverCoverFrameLayout a;
  protected RedTouch a;
  public CookieManager a;
  public ActionSheet a;
  protected String a;
  protected long b;
  protected View b;
  public LinearLayout b;
  public String b;
  public int c;
  protected long c;
  protected View c;
  public String c;
  public int d;
  protected long d;
  protected View d;
  public String d;
  protected boolean d;
  protected long e;
  protected View e;
  public String e;
  protected boolean g = true;
  protected boolean h;
  protected boolean i;
  protected boolean j;
  protected boolean k;
  protected boolean m;
  
  static
  {
    jdField_a_of_type_JavaLangRunnable = new advf();
  }
  
  public NearbyHybridFragment()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters = new NearPeopleFilters();
    this.jdField_c_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentBizUiRefreshView$OnRefreshListener = new advv(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout$OnActionListener = new advw(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new advy(this);
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new advg(this);
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver = new advn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver = new advo(this);
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString, Object paramObject)
  {
    paramStringBuilder.append("&").append(paramString).append("=").append(paramObject);
  }
  
  private void s()
  {
    if (PeakUtils.a == null)
    {
      PeakUtils.a = new PreloadProcHitSession("nearby_shouye_preload", "com.tencent.mobileqq:peak");
      PeakUtils.a.a();
    }
    ThreadManager.getSubThreadHandler().post(new advt(this));
  }
  
  private void t()
  {
    String str = URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://nearby.qq.com/people_filter/index.html", "_wwv", "4"), "sex", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_a_of_type_Int)), "time", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_b_of_type_Int)), "age", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_c_of_type_Int)), "interest", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_d_of_type_Int)), "profession", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.f)), "country", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_d_of_type_ArrayOfJavaLangString[0])), "strCountry", this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_b_of_type_JavaLangString), "province", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_d_of_type_ArrayOfJavaLangString[1])), "strProvince", this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_c_of_type_JavaLangString), "city", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_d_of_type_ArrayOfJavaLangString[2])), "strCity", this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_d_of_type_JavaLangString), "contellation", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.e));
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    getActivity().startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyHybridFragment", 2, "jump2FilterSettingPage:" + str);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout.c()) {
      return 0;
    }
    return 1;
  }
  
  public NearPeopleFilters a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters;
  }
  
  protected String a()
  {
    Object localObject1 = "";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.jdField_b_of_type_JavaLangString;
    }
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      if (!((String)localObject1).contains("?")) {
        break label218;
      }
    }
    label218:
    for (localObject1 = (String)localObject1 + "&";; localObject1 = (String)localObject1 + "?")
    {
      localObject2 = (String)localObject1 + this.jdField_b_of_type_JavaLangString;
      Object localObject3 = a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = (String)localObject2 + ((StringBuilder)localObject3).toString();
      }
      localObject3 = NearbySPUtil.a();
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = (String)localObject1 + (String)localObject3;
      }
      localObject1 = localObject2;
      if (this.jdField_d_of_type_Long != 0L) {
        localObject1 = (String)localObject2 + "&_t=" + this.jdField_d_of_type_Long;
      }
      if (QLog.isColorLevel()) {
        QLog.d("NearbyHybridFragment.webloading", 2, "getUrl, url=" + (String)localObject1);
      }
      return localObject1;
    }
  }
  
  protected StringBuilder a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      a(localStringBuilder, "sex", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_a_of_type_Int));
      a(localStringBuilder, "time", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_b_of_type_Int));
      a(localStringBuilder, "age", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_c_of_type_Int));
      a(localStringBuilder, "interest", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_d_of_type_Int));
      a(localStringBuilder, "profession", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.f));
      a(localStringBuilder, "country", this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_d_of_type_ArrayOfJavaLangString[0]);
      a(localStringBuilder, "province", this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_d_of_type_ArrayOfJavaLangString[1]);
      a(localStringBuilder, "city", this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_d_of_type_ArrayOfJavaLangString[2]);
      a(localStringBuilder, "contellation", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.e));
      return localStringBuilder;
    }
    return null;
  }
  
  protected ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "key_banner_enter_items", "");
    this.h = false;
    for (;;)
    {
      NearbyFragmentEnterAdapter.EnterItem localEnterItem;
      try
      {
        localObject = new JSONArray((String)localObject);
        int n = 0;
        if (n < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(n);
          localEnterItem = new NearbyFragmentEnterAdapter.EnterItem();
          localEnterItem.jdField_b_of_type_JavaLangString = localJSONObject.optString("iconUrl");
          localEnterItem.jdField_a_of_type_JavaLangString = localJSONObject.optString("jumpUrl");
          localEnterItem.jdField_d_of_type_JavaLangString = localJSONObject.optString("scheme");
          localEnterItem.jdField_e_of_type_JavaLangString = localJSONObject.optString("package");
          localEnterItem.jdField_c_of_type_JavaLangString = localJSONObject.optString("name");
          localEnterItem.jdField_a_of_type_Int = localJSONObject.optInt("id");
          localEnterItem.jdField_c_of_type_Int = localJSONObject.optInt("openapp");
        }
        switch (localEnterItem.jdField_a_of_type_Int)
        {
        case 1: 
          NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "exp_op_button", localEnterItem.jdField_a_of_type_Int);
          localArrayList.add(localEnterItem);
          n += 1;
          continue;
          this.h = true;
          localEnterItem.jdField_b_of_type_Int = 6;
          continue;
          return localArrayList;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NearbyHybridFragment", 2, "getBannerItems:" + localException.toString());
        }
      }
      localEnterItem.jdField_b_of_type_Int = 1;
      continue;
      localEnterItem.jdField_b_of_type_Int = 2;
      continue;
      localEnterItem.jdField_b_of_type_Int = 7;
      continue;
      localEnterItem.jdField_b_of_type_Int = 4;
      continue;
      localEnterItem.jdField_b_of_type_Int = 8;
    }
  }
  
  void a(NearbyAppInterface paramNearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("NearbyHybridFragment", "createWebView", new Object[] { this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, paramNearbyAppInterface });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (paramNearbyAppInterface != null))
      {
        Context localContext = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.getBaseContext();
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder = new NearbyHybridFragment.NearbyWebViewBuilder(this, localContext, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, paramNearbyAppInterface);
        paramNearbyAppInterface = new TouchWebView(localContext);
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a(paramNearbyAppInterface);
        long l1 = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l = (System.currentTimeMillis() - l1);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l) });
        }
        if (QLog.isColorLevel()) {
          QLog.i("NearbyHybridFragment.webloading", 2, "init webView time:" + this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l);
        }
        this.f = true;
      }
      return;
    }
    finally {}
  }
  
  public void a(NearbyFragmentEnterAdapter.EnterItem paramEnterItem)
  {
    if (paramEnterItem.jdField_a_of_type_JavaLangString != null)
    {
      if (!paramEnterItem.jdField_a_of_type_JavaLangString.startsWith("http")) {
        break label62;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramEnterItem.jdField_a_of_type_JavaLangString);
      PublicAccountUtil.a(localIntent, paramEnterItem.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(localIntent);
    }
    label62:
    do
    {
      do
      {
        return;
      } while (!paramEnterItem.jdField_a_of_type_JavaLangString.startsWith("mqqapi"));
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, JumpActivity.class).setData(Uri.parse(paramEnterItem.jdField_a_of_type_JavaLangString)));
        return;
      }
      catch (Exception paramEnterItem) {}
    } while (!QLog.isColorLevel());
    QLog.w("NearbyHybridFragment", 2, "onItemClick exp" + paramEnterItem.toString());
  }
  
  public void a(ilive_feeds_near_anchor.NearAnchorInfo paramNearAnchorInfo)
  {
    int n;
    if ((paramNearAnchorInfo == null) || (paramNearAnchorInfo.jump_type.get() == 1))
    {
      n = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a() + 1;
      this.jdField_a_of_type_JavaLangString = "";
      if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null) {
        this.jdField_a_of_type_JavaLangString = ("&latitude=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + "&longitude=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b);
      }
      if (n != -1)
      {
        paramNearAnchorInfo = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&gender=");
        if (n == 2)
        {
          n = 2;
          this.jdField_a_of_type_JavaLangString = n;
        }
      }
      else
      {
        if ((NowLiveFragment.jdField_b_of_type_JavaLangString == null) || (NowLiveFragment.jdField_b_of_type_JavaLangString.length() <= 0)) {
          break label232;
        }
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie("now.qq.com", "p_skey=" + NowLiveFragment.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.i("NearbyHybridFragment", 2, "now.qq.com pskey : " + NowLiveFragment.jdField_b_of_type_JavaLangString);
        }
        CookieSyncManager.getInstance().sync();
        j();
      }
    }
    label232:
    do
    {
      do
      {
        return;
        n = 1;
        break;
        if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com") != null)
        {
          paramNearAnchorInfo = this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com");
          if (QLog.isColorLevel()) {
            QLog.i("NearbyHybridFragment", 2, "now.qq.com cookie : " + paramNearAnchorInfo);
          }
          if (paramNearAnchorInfo.contains("p_skey"))
          {
            j();
            return;
          }
        }
        NowLiveFragment.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("pskey", "");
        long l1 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getLong("pskey_t", 0L);
        if ((NowLiveFragment.jdField_b_of_type_JavaLangString != null) && (NowLiveFragment.jdField_b_of_type_JavaLangString.length() > 0) && (System.currentTimeMillis() - l1 < 21600000L))
        {
          this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie("now.qq.com", "p_skey=" + NowLiveFragment.jdField_b_of_type_JavaLangString);
          CookieSyncManager.getInstance().sync();
          j();
          return;
        }
        paramNearAnchorInfo = new advh(this);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramNearAnchorInfo, 1000L);
        paramNearAnchorInfo = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(2);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin();
        advi localadvi = new advi(this);
        paramNearAnchorInfo.GetPskey((String)localObject, 16L, new String[] { "now.qq.com" }, localadvi);
        return;
      } while (paramNearAnchorInfo.jump_type.get() != 2);
      paramNearAnchorInfo = String.format("mqqapi://now/openroom?src_type=app&version=1&fromid=10006&roomid=%d&first=1&startsrc=fujin7", new Object[] { Integer.valueOf(paramNearAnchorInfo.root_roomid.get()) });
      Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, JumpActivity.class);
      ((Intent)localObject).setData(Uri.parse(paramNearAnchorInfo));
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity((Intent)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("NearbyHybridFragmentQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "jump from nearby|uri:" + paramNearAnchorInfo);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    this.jdField_d_of_type_Int = paramInt;
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "exp_pub", 1);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void at_()
  {
    super.at_();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  protected NearPeopleFilters b()
  {
    int i1 = 0;
    Object localObject2 = (NearbyDataManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(209);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent();
    if (localObject1 != null) {
      ((NearbyDataManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("filter"));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyHybridFragment", 2, "initNearbyFilter, filterMode=" + ((NearbyDataManager)localObject2).a());
      }
      if (((NearbyDataManager)localObject2).a() == 0) {
        break label376;
      }
      int n = ((Intent)localObject1).getIntExtra("filterGender", 0);
      int i3 = ((Intent)localObject1).getIntExtra("filter_time", 0);
      int i4 = ((Intent)localObject1).getIntExtra("filter_age", 0);
      int i5 = ((Intent)localObject1).getIntExtra("filter_xingzuo", 0);
      int i2 = ((Intent)localObject1).getIntExtra("filter_interest", 0);
      int i6 = ((Intent)localObject1).getIntExtra("filter_career", 0);
      Object localObject3 = ((Intent)localObject1).getStringExtra("filter_location");
      localObject2 = new NearPeopleFilters();
      ((NearPeopleFilters)localObject2).jdField_a_of_type_Int = n;
      ((NearPeopleFilters)localObject2).jdField_b_of_type_Int = i3;
      ((NearPeopleFilters)localObject2).jdField_c_of_type_Int = i4;
      ((NearPeopleFilters)localObject2).e = i5;
      ((NearPeopleFilters)localObject2).f = i6;
      if (i2 >= 0)
      {
        n = i2;
        if (i2 <= NearPeopleFilters.jdField_b_of_type_ArrayOfJavaLangString.length - 1) {}
      }
      else
      {
        n = 0;
      }
      ((NearPeopleFilters)localObject2).jdField_d_of_type_Int = n;
      localObject1 = new String[5];
      localObject1[0] = "0";
      localObject1[1] = "0";
      localObject1[2] = "0";
      localObject1[3] = "0";
      localObject1[4] = "不限";
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break label361;
      }
      try
      {
        localObject3 = ((String)localObject3).split("\\|");
        localObject1 = localObject3;
      }
      catch (Exception localException)
      {
        label297:
        break label297;
      }
      if (localObject1.length < 4) {
        break label361;
      }
      n = i1;
      while (n < 4)
      {
        ((NearPeopleFilters)localObject2).jdField_d_of_type_ArrayOfJavaLangString[n] = localObject1[n];
        n += 1;
      }
      localObject1 = new Intent();
    }
    if (localObject1.length >= 5)
    {
      localObject1 = localObject1[4];
      ((NearPeopleFilters)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
      label361:
      localObject1 = localObject2;
    }
    label376:
    do
    {
      do
      {
        return localObject1;
        localObject1 = "不限";
        break;
        localObject2 = NearPeopleFilters.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject2 = new NearPeopleFilters();
      ((NearPeopleFilters)localObject2).jdField_a_of_type_Int = 0;
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("nearby.heart_beat", 2, "defFilter: filters.gender=" + ((NearPeopleFilters)localObject2).jdField_a_of_type_Int);
    return localObject2;
  }
  
  protected void d()
  {
    QLog.d("NearbyHybridFragment.webloading", 1, "checkLocation");
    long l1 = System.currentTimeMillis() - jdField_a_of_type_Long;
    if ((jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) || (l1 > 180000L))
    {
      l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.w("NearbyHybridFragment.webloading", 2, "send MSG_SHOW_LOADING before startLocation");
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.m = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 500L);
      SosoInterface.a(new advr(this, 0, true, false, 180000L, true, false, "NearbyNowliveTab", l1));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyHybridFragment.webloading", 2, "startLocation useCache timeDiff=" + l1);
    }
    e();
  }
  
  public void e()
  {
    this.jdField_b_of_type_JavaLangString = ("latitude=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + "&longitude=" + jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b);
    this.jdField_c_of_type_JavaLangString = a();
    if (WebSoUtils.b(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyHybridFragment.webloading", 2, "onLocationSucc, hasProxyParam");
      }
      ThreadManager.postImmediately(new advs(this), null, false);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NearbyHybridFragment.webloading", 2, "onLocationSucc, !hasProxyParam:" + this.jdField_c_of_type_JavaLangString);
      }
    }
  }
  
  public void f()
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 2131433023, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDimensionPixelSize(2131558448));
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 0, "开始下载", 0).a();
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", "now.apk");
    UniformDownloadMgr.a().a("http://dldir1.qq.com/huayang/Now/now_52228.apk", localBundle, new advx(this));
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder == null) {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyHybridFragment", 2, "notifyWebViewRefresh: mAbsWebView == null");
      }
    }
    do
    {
      String str;
      do
      {
        return;
        CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a();
        if (localCustomWebView == null) {
          break;
        }
        str = WebViewPlugin.toJsScript("qbrowserPullDown", null, null);
        localCustomWebView.c(str);
      } while (!QLog.isColorLevel());
      QLog.d("NearbyHybridFragment", 2, "notifyWebViewRefresh:" + str);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("NearbyHybridFragment", 2, "notifyWebViewRefresh, webView==null");
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder == null) {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyHybridFragment", 2, "notifyWebViewShow: mAbsWebView == null");
      }
    }
    for (;;)
    {
      return;
      CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a();
      Object localObject;
      if (localCustomWebView != null) {
        localObject = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject).put("hidden", false);
        label52:
        localObject = WebViewPlugin.toJsScript("qbrowserVisibilityChangeV2", (JSONObject)localObject, null);
        localCustomWebView.c((String)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyHybridFragment", 2, "notifyWebViewShow:" + (String)localObject);
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("NearbyHybridFragment", 2, "notifyWebViewShow, webView==null");
        return;
      }
      catch (Exception localException)
      {
        break label52;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label360:
    label362:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return false;
            if (QLog.isColorLevel()) {
              QLog.w("NearbyHybridFragment.webloading", 2, "handleMessage MSG_SHOW_LOADING: isLoadingFinished=" + this.m);
            }
            if ((!this.m) && (this.jdField_c_of_type_AndroidViewView != null))
            {
              if (this.jdField_c_of_type_AndroidViewView != null) {
                this.jdField_c_of_type_AndroidViewView.setVisibility(0);
              }
              if (this.jdField_d_of_type_AndroidViewView != null) {
                this.jdField_d_of_type_AndroidViewView.setVisibility(8);
              }
              if (this.jdField_e_of_type_AndroidViewView != null)
              {
                this.jdField_e_of_type_AndroidViewView.setVisibility(8);
                return false;
                if (paramMessage.what == 5) {
                  if (QLog.isColorLevel()) {
                    QLog.d("NearbyHybridFragment.webloading", 2, "handleMessage attach-locationEnd cost=" + (System.currentTimeMillis() - this.jdField_c_of_type_Long));
                  }
                }
                for (;;)
                {
                  if (!this.j) {
                    break label360;
                  }
                  if (this.jdField_c_of_type_Int != 0) {
                    break label362;
                  }
                  if ((this.h) && (!this.i) && (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null))
                  {
                    this.i = true;
                    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new advu(this), 2000L);
                  }
                  if ((!this.jdField_e_of_type_Boolean) || (this.k)) {
                    break;
                  }
                  this.k = true;
                  this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a(this.jdField_c_of_type_JavaLangString);
                  return false;
                  if (paramMessage.what == 6)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("NearbyHybridFragment.webloading", 2, "handleMessage attach-viewInitEnd cost=" + (System.currentTimeMillis() - this.jdField_c_of_type_Long));
                    }
                  }
                  else if ((paramMessage.what == 1) && (QLog.isColorLevel())) {
                    QLog.d("NearbyHybridFragment.webloading", 2, "handleMessage MSG_INIT");
                  }
                }
              }
            }
          }
        } while (this.jdField_c_of_type_Int != 1);
        if (!NetworkUtil.g(BaseApplicationImpl.getContext())) {
          break;
        }
        if (this.jdField_e_of_type_AndroidViewView != null) {
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        }
        if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      } while (this.jdField_d_of_type_AndroidViewView == null);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      return false;
      if (this.jdField_e_of_type_AndroidViewView != null) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    } while (this.jdField_d_of_type_AndroidViewView == null);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    return false;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder == null) {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyHybridFragment", 2, "notifyWebViewHide: mAbsWebView == null");
      }
    }
    for (;;)
    {
      return;
      CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a();
      Object localObject;
      if (localCustomWebView != null) {
        localObject = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject).put("hidden", true);
        label52:
        localObject = WebViewPlugin.toJsScript("qbrowserVisibilityChangeV2", (JSONObject)localObject, null);
        localCustomWebView.c((String)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyHybridFragment", 2, "notifyWebViewHide:" + (String)localObject);
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("NearbyHybridFragment", 2, "notifyWebViewHide, webView==null");
        return;
      }
      catch (Exception localException)
      {
        break label52;
      }
    }
  }
  
  public void j()
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    String str = NearbyActivity.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_JavaLangString + "&_t=" + System.currentTimeMillis();
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(localIntent);
  }
  
  protected void k()
  {
    l();
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a("我的").a(new advm(this));
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
  }
  
  public void l()
  {
    Object localObject = (NearbyActivity)getActivity();
    if (localObject != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch((Context)localObject, ((NearbyActivity)localObject).rightViewText);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).a();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(9);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject);
    }
  }
  
  public void m()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    Object localObject2 = ((NearbyProcManager)localObject3).a(10);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyHybridFragment", 2, "updateUnReadMsgRedTouch: redTypeInfo==null");
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    Object localObject1 = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.get();
    int n = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get();
    localObject2 = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.get();
    if (QLog.isColorLevel()) {
      QLog.d("NearbyHybridFragment", 2, "updateUnReadMsgRedTouch: redType=" + n + ", numStr=" + (String)localObject1 + ", desc=" + (String)localObject2);
    }
    if ((n != 5) || (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject1 + "条消息通知");
    long l1 = 0L;
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        localObject1 = ((JSONObject)localObject2).optString("faceUrl");
        long l2;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          l2 = ((JSONObject)localObject2).optLong("uin");
          l1 = l2;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!HttpUtil.a((String)localObject1))) {
            break label347;
          }
          localObject2 = getResources().getDrawable(2130839147);
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
          localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.a(1000, 1000));
          ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.k);
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
          NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "exp_msg", 0);
          return;
        }
        catch (Exception localException2)
        {
          break label339;
        }
        localException1 = localException1;
        localObject1 = "";
      }
      label339:
      continue;
      label347:
      if (l1 > 0L)
      {
        localObject1 = String.valueOf(l1);
        this.jdField_d_of_type_JavaLangString = ((String)localObject1);
        localObject1 = ((NearbyProcManager)localObject3).a((String)localObject1, 1, true);
        if (localObject1 != null) {
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap((Bitmap)localObject1);
        } else {
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(getResources().getDrawable(2130839147));
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(getResources().getDrawable(2130839147));
      }
    }
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(getActivity());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131437718);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131437720);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433029);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new advp(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new advq(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder == null) {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyHybridFragment", 2, "notifyWebViewSheetDismiss: mAbsWebView == null");
      }
    }
    do
    {
      String str;
      do
      {
        return;
        CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a();
        if (localCustomWebView == null) {
          break;
        }
        str = WebViewPlugin.toJsScript("closeFilterAndExitSheet", null, null);
        localCustomWebView.c(str);
      } while (!QLog.isColorLevel());
      QLog.d("NearbyHybridFragment", 2, "ActionSheet onDissmiss:" + str);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("NearbyHybridFragment", 2, "ActionSheet onDissmiss, webView==null");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) && ((paramActivity instanceof NearbyActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity = ((NearbyActivity)paramActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters = b();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int == 0) {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyHybridFragment.webloading", 2, "onAttach, mLastTabIndex=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g) });
      }
    }
    super.onCreate(paramBundle);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.g);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.i) });
      }
    }
    this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
    this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
    CookieSyncManager.createInstance(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
    NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), true);
    long l1 = System.currentTimeMillis();
    NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "nearby_enter_time", Long.valueOf(l1));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.w("NearbyHybridFragment.webloading", 2, "onCreateView");
    }
    q();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("NearbyHybridFragment", new Object[] { "onCreateView", Long.valueOf(l1) });
      }
      super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      if (this.g) {
        d();
      }
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        long l2 = System.currentTimeMillis();
        a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
        if (QLog.isColorLevel()) {
          QLog.i("NearbyHybridFragment.webloading", 2, "total createWebView time:" + (System.currentTimeMillis() - l2));
        }
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2130969118, null);
        this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365256));
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout = ((OverCoverFrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365265));
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout.setOnActionListener(this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetOverCoverFrameLayout$OnActionListener);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365271);
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365276));
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365267));
        paramLayoutInflater = a();
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter = new NearbyFragmentEnterAdapter(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.a(paramLayoutInflater);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.a(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365272));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365273));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365274));
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setDelayBeforeScrollBack(800L);
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a.setOnOverScrollHandler(this.jdField_a_of_type_ComTencentBizUiRefreshView);
        paramLayoutInflater = new FrameLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a, 0, paramLayoutInflater);
        if (QLog.isColorLevel()) {
          QLog.i("NearbyHybridFragment.webloading", 2, "webView add to container:" + (System.currentTimeMillis() - l2));
        }
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365268);
        paramLayoutInflater = (URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131366736);
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mPlayGifImage = true;
        paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable("https://qpic.url.cn/feeds_pic/ajNVdqHZLLAyBjp36ialuzyODWtr9VCdVQJo0JTrkib9eDlHdRtvS90g/", paramViewGroup));
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365269);
        this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365270);
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(getString(2131435091)).a(false);
      k();
      this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(this.jdField_a_of_type_ComTencentBizUiRefreshView$OnRefreshListener);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j == 0L))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j = (System.currentTimeMillis() - l1);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.j) });
        }
      }
      if (this.g)
      {
        this.g = false;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
        m();
        this.j = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      }
      return this.jdField_a_of_type_AndroidViewView;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.f) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.b(null);
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.d();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.i("NearbyHybridFragment", 2, "onDestroyView");
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("NearbyHybridFragment", 2, "onHiddenChanged: hidden=" + paramBoolean);
    }
    if (paramBoolean)
    {
      i();
      r();
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)null);
      }
      return;
    }
    h();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.f) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NearbyHybridFragment", 2, "onPause:" + this.jdField_d_of_type_Boolean);
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.f) {}
    String str1;
    String str2;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("NearbyHybridFragment", 2, "onResume:" + this.jdField_d_of_type_Boolean);
        }
        q();
        this.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.b();
        if (!NetworkUtil.g(getActivity())) {
          QQToast.a(getActivity(), 1, "当前网络不可用，请检查网络设置", 0).b(getActivity().getTitleBarHeight());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
        }
        l();
        m();
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
        str1 = ((SharedPreferences)localObject).getString("nearby_now_delete_success_js_param", "");
      } while (TextUtils.isEmpty(str1));
      str2 = ((SharedPreferences)localObject).getString("nearby_now_delete_success_js_callback", "");
    } while (TextUtils.isEmpty(str2));
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a.a(str2, new String[] { str1 });
    Object localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("nearby_now_delete_success_js_param", "");
    ((SharedPreferences.Editor)localObject).remove("nearby_now_delete_success_js_param").commit();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    s();
  }
  
  public void p()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_e_of_type_Long;
    long l3 = System.currentTimeMillis();
    long l4 = this.jdField_c_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.w("NearbyHybridFragment.webloading", 2, "hideWebLoadingView:" + this.m + ", timeCostFromLoad=" + (l1 - l2) + ", timeCostFromAttach=" + (l3 - l4));
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.m = true;
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void q()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("NearbyHybridFragment.duration", 2, "resetUserBrowseTime");
    }
  }
  
  public void r()
  {
    int n = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    long l1 = (System.currentTimeMillis() - this.jdField_b_of_type_Long) / 1000L;
    if (l1 <= 0L) {
      l1 = 1L;
    }
    for (;;)
    {
      ReportController.b(null, "dc00899", "grp_lbs", "", "home", "home_exp", 0, 0, "", String.valueOf(n), "", String.valueOf(l1));
      if (QLog.isColorLevel()) {
        QLog.d("NearbyHybridFragment.duration", 2, "reportUserBroseTime: d2[gender]=" + n + ", d4[duration]=" + l1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment
 * JD-Core Version:    0.7.0.1
 */