package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
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
import com.tencent.mobileqq.nearby.home.INearbyTabInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;
import mqq.app.AppRuntime;

public class CommonTabFragment
  extends NearbyBaseFragment
  implements Handler.Callback
{
  public NearbyActivity a;
  public CommonTabFragment.HotChatWebView b;
  public RefreshView c;
  public View d;
  View.OnClickListener e;
  public String f = "";
  
  private void h()
  {
    if (this.e != null) {
      this.aj.a(getString(2131897044)).a(this.e);
    } else {
      this.aj.a("").a(null);
    }
    this.aj.a();
  }
  
  void a(Activity paramActivity, INearbyAppInterface paramINearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("CommonTabFragment", "createWebView", new Object[] { this.b, paramActivity, paramINearbyAppInterface });
      }
      if ((this.a == null) && ((paramActivity instanceof NearbyActivity))) {
        this.a = ((NearbyActivity)paramActivity);
      }
      if ((this.b == null) && (paramActivity != null) && (paramINearbyAppInterface != null))
      {
        this.b = new CommonTabFragment.HotChatWebView(this, paramActivity.getBaseContext(), paramActivity, (AppInterface)paramINearbyAppInterface);
        if (!WebAccelerateHelper.isWebViewCache)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("url", SharedPreUtils.ah(paramActivity, this.k.getCurrentAccountUin()));
          WebAccelerateHelper.getInstance().preGetKey(localIntent, (AppRuntime)paramINearbyAppInterface);
        }
      }
      return;
    }
    finally {}
  }
  
  void a(SosoLbsInfo paramSosoLbsInfo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void a(WebView paramWebView, String paramString)
  {
    if (this.aj != null)
    {
      this.aj.b(false).c(true);
      this.aj.a();
    }
  }
  
  protected void a(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public boolean a(long paramLong, Map<String, Object> paramMap, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.b;
    if (localObject != null) {
      localObject = ((CommonTabFragment.HotChatWebView)localObject).getWebView();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      this.b.b();
      WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)localObject).getPluginEngine();
      if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.a(((CustomWebView)localObject).getUrl(), paramLong, paramMap))) {
        return true;
      }
      int i = paramInt2 >> 8 & 0xFF;
      if (i > 0)
      {
        if ((localObject != null) && (localWebViewPluginEngine != null))
        {
          paramMap = paramIntent;
          if (paramIntent == null) {
            paramMap = new Intent();
          }
          if ((paramMap != null) && (paramMap.hasExtra("entryId")) && (localWebViewPluginEngine.b("card") == null)) {
            localWebViewPluginEngine.a(new String[] { "card" });
          }
          paramIntent = localWebViewPluginEngine.a(i, true);
          if (paramIntent != null)
          {
            paramIntent.onActivityResult(paramMap, (byte)(paramInt2 & 0xFF), paramInt1);
            return true;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.w("CommonTabFragment", 2, "Caution! activity result not handled!");
        }
      }
    }
    return false;
  }
  
  public AbsWebView b()
  {
    return this.b;
  }
  
  public void c()
  {
    if (getBaseActivity() == null) {
      return;
    }
    int j = 0;
    int i = j;
    if (Build.VERSION.SDK_INT >= 23)
    {
      i = j;
      if (getBaseActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        QLog.e("CommonTabFragment", 1, "ACCESS_FINE_LOCATION permission not granted!");
        i = 1;
      }
    }
    if (i == 0)
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new CommonTabFragment.1(this, 3, true, false, 30000L, true, false, "NearbyNowliveTab"));
      return;
    }
    d();
  }
  
  void d()
  {
    if ((!this.n) && (this.am != null))
    {
      if (this.b == null) {
        return;
      }
      long l = 0L;
      if (this.a != null) {
        l = System.currentTimeMillis();
      }
      this.n = true;
      if (!this.b.b)
      {
        this.l.removeMessages(2);
        this.b.a();
      }
      Object localObject = this.c;
      if (localObject != null)
      {
        ((RefreshView)localObject).setDelayBeforeScrollBack(800L);
        this.b.mWebview.setOnOverScrollHandler(this.c);
        this.c.addView(this.b.mWebview, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if (this.b.c)
      {
        localObject = this.d;
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
      }
      localObject = this.a;
      if (localObject != null)
      {
        ((NearbyActivity)localObject).mInitTime = (System.currentTimeMillis() - l);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.a.mInitTime) });
        }
      }
      if (((this.ag instanceof NearbyActivity)) && (this.b != null))
      {
        this.ag.centerView.setClickable(true);
        ((NearbyActivity)this.ag).addTitleOnClick(new CommonTabFragment.2(this));
      }
    }
  }
  
  public void dw_()
  {
    super.dw_();
    if (this.p)
    {
      CommonTabFragment.HotChatWebView localHotChatWebView = this.b;
      if (localHotChatWebView != null) {
        localHotChatWebView.mWebview.reload();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if ((this.q != null) && (this.q.getNeedLoc() == 1))
      {
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("startLocation start");
          paramMessage.append(System.currentTimeMillis());
          QLog.d("CommonTabFragment", 2, paramMessage.toString());
        }
        c();
      }
      else
      {
        d();
      }
    }
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    a(paramActivity, this.k);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    NearbyActivity localNearbyActivity = this.a;
    if ((localNearbyActivity != null) && (localNearbyActivity.mOnCreateMilliTimeStamp == 0L))
    {
      this.a.mOnCreateMilliTimeStamp = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.a.mOnCreateMilliTimeStamp) });
      }
    }
    super.onCreate(paramBundle);
    paramBundle = this.b;
    if (paramBundle != null) {
      paramBundle.a(this.ag.getIntent());
    }
    paramBundle = this.a;
    if ((paramBundle != null) && (paramBundle.onCreateTime == 0L))
    {
      this.a.onCreateTime = (System.currentTimeMillis() - this.a.mOnCreateMilliTimeStamp);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.a.onCreateTime) });
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l;
    if (this.a != null) {
      l = System.currentTimeMillis();
    } else {
      l = 0L;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("CommonTabFragment", new Object[] { "onCreateView", Long.valueOf(l) });
    }
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.am == null)
    {
      this.am = paramLayoutInflater.inflate(2131625499, null);
      this.c = ((RefreshView)this.am.findViewById(2131450066));
      this.d = this.am.findViewById(2131435158);
    }
    this.aj.b(getString(2131892066)).a(false);
    h();
    if ((this.q != null) && (this.q.getNeedLoc() == 1))
    {
      if ((this.m) && (!this.n)) {
        c();
      }
    }
    else {
      d();
    }
    paramLayoutInflater = this.a;
    if ((paramLayoutInflater != null) && (paramLayoutInflater.mViewInflateTime == 0L))
    {
      this.a.mViewInflateTime = (System.currentTimeMillis() - l);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.a.mViewInflateTime) });
      }
    }
    return this.am;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.n) {
      return;
    }
    this.b.d();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.n) {
      return;
    }
    this.b.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.n) {
      return;
    }
    this.b.b();
    if (!NetworkUtil.isNetworkAvailable(getBaseActivity())) {
      QQToast.makeText(getBaseActivity(), 1, HardCodeUtil.a(2131900436), 0).show(getBaseActivity().getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.CommonTabFragment
 * JD-Core Version:    0.7.0.1
 */