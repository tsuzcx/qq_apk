package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WtTicketPromise;

public class NowLiveFragment
  extends NearbyBaseFragment
  implements View.OnClickListener
{
  static String i = "";
  private static boolean x = false;
  private static final Runnable y = new NowLiveFragment.6();
  public View a;
  public NearbyActivity b;
  public RefreshView c;
  ArrayList<Rect> d = new ArrayList();
  boolean e = false;
  public NowLiveFragment.NowLiveWebView f;
  public String g = "";
  CookieManager h;
  String r = "https://now.qq.com/qq/nearby/live.html?_wv=16777219&_bid=2452&from=50036";
  String s = "https://now.qq.com/qq/nearby/user.html?_wv=3&_bid=2452&from=50036";
  String t = "https://now.qq.com/qq/nearby/help.html?_wv=3&_bid=2452&from=50036";
  String[] u = { HardCodeUtil.a(2131905486), HardCodeUtil.a(2131905485), HardCodeUtil.a(2131905484) };
  int[] v = { 2130842232, 2130842233, 2130842231 };
  PopupMenuDialog w;
  
  void a(Activity paramActivity, INearbyAppInterface paramINearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("NowLiveFragment", "createWebView", new Object[] { this.f, paramActivity, paramINearbyAppInterface });
      }
      if ((this.b == null) && ((paramActivity instanceof NearbyActivity))) {
        this.b = ((NearbyActivity)paramActivity);
      }
      if ((this.f == null) && (paramActivity != null) && (paramINearbyAppInterface != null))
      {
        this.f = new NowLiveFragment.NowLiveWebView(this, paramActivity.getBaseContext(), paramActivity, (AppInterface)paramINearbyAppInterface);
        if (!WebAccelerateHelper.isWebViewCache)
        {
          paramActivity = new Intent();
          paramActivity.putExtra("url", NearbyActivity.nearByTabUrl);
          WebAccelerateHelper.getInstance().preGetKey(paramActivity, (AppRuntime)paramINearbyAppInterface);
        }
      }
      return;
    }
    finally {}
  }
  
  void a(SosoLbsInfo paramSosoLbsInfo)
  {
    int j = this.k.getNearbyProcManager().b() + 1;
    if (paramSosoLbsInfo != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("&latitude=");
      ((StringBuilder)localObject1).append(paramSosoLbsInfo.mLocation.mLat02);
      ((StringBuilder)localObject1).append("&longitude=");
      ((StringBuilder)localObject1).append(paramSosoLbsInfo.mLocation.mLon02);
      this.g = ((StringBuilder)localObject1).toString();
      localObject1 = paramSosoLbsInfo.mLocation.city;
      paramSosoLbsInfo = paramSosoLbsInfo.mLocation.province;
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramSosoLbsInfo)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.g);
        ((StringBuilder)localObject2).append("&city=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&province=");
        ((StringBuilder)localObject2).append(paramSosoLbsInfo);
        this.g = ((StringBuilder)localObject2).toString();
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("NowLiveFragment", 2, "onLocFinish, city or province is empty");
      }
    }
    if (j != -1)
    {
      paramSosoLbsInfo = new StringBuilder();
      paramSosoLbsInfo.append(this.g);
      paramSosoLbsInfo.append("&gender=");
      if (j == 2) {
        j = 2;
      } else {
        j = 1;
      }
      paramSosoLbsInfo.append(j);
      this.g = paramSosoLbsInfo.toString();
    }
    paramSosoLbsInfo = i;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.length() > 0))
    {
      paramSosoLbsInfo = this.h;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("p_skey=");
      ((StringBuilder)localObject1).append(i);
      paramSosoLbsInfo.setCookie("now.qq.com", ((StringBuilder)localObject1).toString());
      if (QLog.isColorLevel())
      {
        paramSosoLbsInfo = new StringBuilder();
        paramSosoLbsInfo.append("now.qq.com pskey : ");
        paramSosoLbsInfo.append(i);
        QLog.i("NowLiveFragment", 2, paramSosoLbsInfo.toString());
      }
      CookieSyncManager.getInstance().sync();
      h();
      return;
    }
    if (this.h.getCookie("now.qq.com") != null)
    {
      paramSosoLbsInfo = this.h.getCookie("now.qq.com");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("now.qq.com cookie : ");
        ((StringBuilder)localObject1).append(paramSosoLbsInfo);
        QLog.i("NowLiveFragment", 2, ((StringBuilder)localObject1).toString());
      }
      if (paramSosoLbsInfo.contains("p_skey"))
      {
        h();
        return;
      }
    }
    i = this.ag.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("pskey", "");
    long l = this.ag.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getLong("pskey_t", 0L);
    paramSosoLbsInfo = i;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.length() > 0) && (System.currentTimeMillis() - l < 21600000L))
    {
      paramSosoLbsInfo = this.h;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("p_skey=");
      ((StringBuilder)localObject1).append(i);
      paramSosoLbsInfo.setCookie("now.qq.com", ((StringBuilder)localObject1).toString());
      CookieSyncManager.getInstance().sync();
      h();
      return;
    }
    paramSosoLbsInfo = new NowLiveFragment.2(this);
    this.l.postDelayed(paramSosoLbsInfo, 2000L);
    paramSosoLbsInfo = (TicketManager)this.k.getManager(2);
    Object localObject1 = this.k.getCurrentAccountUin();
    Object localObject2 = new NowLiveFragment.3(this);
    paramSosoLbsInfo.getPskey((String)localObject1, 16L, new String[] { "now.qq.com" }, (WtTicketPromise)localObject2);
  }
  
  public AbsWebView b()
  {
    return this.f;
  }
  
  public void c()
  {
    if (getBaseActivity() == null) {
      return;
    }
    int k = 0;
    int j = k;
    if (Build.VERSION.SDK_INT >= 23)
    {
      j = k;
      if (getBaseActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        QLog.e("NowLiveFragment", 1, "ACCESS_FINE_LOCATION permission not granted!");
        j = 1;
      }
    }
    if (j == 0)
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new NowLiveFragment.1(this, 3, true, false, 300000L, true, false, "NearbyNowliveTab"));
      return;
    }
    h();
  }
  
  public void d()
  {
    Object localObject = this.aj.a(HardCodeUtil.a(2131905488));
    int j = 0;
    ((TitlebarStatus)localObject).a(false).a(this).a();
    localObject = new ArrayList();
    while (j < this.u.length)
    {
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.id = j;
      String[] arrayOfString = this.u;
      localMenuItem.title = arrayOfString[j];
      localMenuItem.contentDescription = arrayOfString[j];
      localMenuItem.iconId = this.v[j];
      ((List)localObject).add(localMenuItem);
      j += 1;
    }
    this.w = PopupMenuDialog.build(this.ag, (List)localObject, new NowLiveFragment.5(this));
  }
  
  public void dw_()
  {
    super.dw_();
    Object localObject = this.f.getWebView();
    if (localObject != null)
    {
      String str = WebViewPlugin.toJsScript("onPageSelected", null, null);
      ((CustomWebView)localObject).callJs(str);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPageSelected:");
        ((StringBuilder)localObject).append(str);
        QLog.d("NowLiveFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("NowLiveFragment", 2, "onPageSelected, webView==null");
    }
  }
  
  void h()
  {
    if (!this.n)
    {
      if (this.am == null) {
        return;
      }
      long l = 0L;
      if (this.b != null) {
        l = System.currentTimeMillis();
      }
      this.n = true;
      if (!this.f.b) {
        this.f.a();
      }
      Object localObject = this.c;
      if (localObject != null)
      {
        ((RefreshView)localObject).setDelayBeforeScrollBack(800L);
        this.f.mWebview.setOnOverScrollHandler(this.c);
        this.c.addView(this.f.mWebview, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if (this.f.c)
      {
        localObject = this.a;
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
      }
      localObject = this.b;
      if (localObject != null)
      {
        ((NearbyActivity)localObject).mNowInitTime = (System.currentTimeMillis() - l);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.b.mNowInitTime) });
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.l.sendMessage(paramMessage);
      return false;
    }
    if (paramMessage.what != 1) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("startLocation start");
      paramMessage.append(System.currentTimeMillis());
      QLog.d("NowLiveFragment", 2, paramMessage.toString());
    }
    c();
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    a(paramActivity, this.k);
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if ((j != 2131436194) && (j != 2131436211)) {
      return;
    }
    paramView = this.w;
    if (paramView != null)
    {
      if (!paramView.isShowing())
      {
        this.w.showAtLocation(this.am, 53, this.ag.getResources().getDimensionPixelSize(2131299620), this.ag.getResources().getDimensionPixelSize(2131299921) + this.ag.getResources().getDimensionPixelSize(2131299097));
        return;
      }
      this.w.dismiss();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.h = CookieManager.getInstance();
    this.h.setAcceptCookie(true);
    CookieSyncManager.createInstance(this.ag);
    paramBundle = this.f;
    if (paramBundle != null) {
      paramBundle.a(this.ag.getIntent());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l;
    if (this.b != null)
    {
      l = System.currentTimeMillis();
      this.b.mNowOnCreateMilliTimeStamp = l;
    }
    else
    {
      l = 0L;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("NowLiveFragment", new Object[] { "mNowOnCreateMilliTimeStamp", Long.valueOf(l) });
    }
    NearbyActivity localNearbyActivity = this.b;
    if ((localNearbyActivity != null) && (localNearbyActivity.mNowOnCreateTime == 0L))
    {
      this.b.mNowOnCreateTime = (System.currentTimeMillis() - this.b.mNowOnCreateMilliTimeStamp);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.b.mNowOnCreateTime) });
      }
    }
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.am == null)
    {
      this.am = paramLayoutInflater.inflate(2131625499, null);
      this.a = this.am.findViewById(2131435158);
      this.c = ((RefreshView)this.am.findViewById(2131450066));
    }
    paramLayoutInflater = this.ag.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("nearByTabUrl", "");
    if (QLog.isColorLevel()) {
      QLog.i("NearbyActivity.nearByTabUrl frg", 4, paramLayoutInflater);
    }
    if (!paramLayoutInflater.equals(""))
    {
      NearbyActivity.nearByTabUrl = paramLayoutInflater;
      this.r = this.ag.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("menuCell_startLive", "");
      this.s = this.ag.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("menuCell_personalCenter", "");
      this.t = this.ag.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("menuCell_help", "");
    }
    this.aj.b(getString(2131892066)).a(false);
    this.c.setOnRefreshListener(new NowLiveFragment.4(this));
    if ((this.m) && (!this.n)) {
      c();
    }
    d();
    paramLayoutInflater = this.b;
    if ((paramLayoutInflater != null) && (paramLayoutInflater.mNowViewInflateTime == 0L))
    {
      this.b.mNowViewInflateTime = (System.currentTimeMillis() - l);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.b.mNowViewInflateTime) });
      }
    }
    if (!this.e)
    {
      paramLayoutInflater = new Rect();
      paramLayoutInflater.top = 0;
      paramLayoutInflater.bottom = ((int)(this.ag.getResources().getDisplayMetrics().density * 315.0F));
      this.d.add(paramLayoutInflater);
    }
    return this.am;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.n) {
      return;
    }
    this.f.d();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.n) {
      return;
    }
    this.f.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.n) {
      return;
    }
    this.f.b();
    if (!NetworkUtil.isNetworkAvailable(getBaseActivity())) {
      QQToast.makeText(getBaseActivity(), 1, HardCodeUtil.a(2131905490), 0).show(getBaseActivity().getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NowLiveFragment
 * JD-Core Version:    0.7.0.1
 */