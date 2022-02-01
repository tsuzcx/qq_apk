package com.tencent.mobileqq.ecshop.widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.ui.RefreshView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.view.EcshopNewPageWebViewBuilder;
import com.tencent.mobileqq.ecshop.view.EcshopWebview;
import com.tencent.mobileqq.ecshop.view.EcshopWebviewPool;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.AppRuntime;

public class EcshopTabFragment
  extends QPublicBaseFragment
{
  private static final String d = "EcshopTabFragment";
  public int a;
  public String b;
  public EcshopNewPageWebViewBuilder c;
  private EcshopWebview e;
  
  public static AppInterface a()
  {
    AppRuntime localAppRuntime = AppUtils.a().getAppRuntime("modular_web");
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a(View paramView)
  {
    this.e = EcshopWebviewPool.a().a(paramView.getContext(), this.b);
    if ((this.e.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    }
    paramView = (RefreshView)paramView.findViewById(2131432295);
    paramView.setDelayBeforeScrollBack(500L);
    this.e.setOnOverScrollHandler(paramView);
    paramView.addView(this.e, new ViewGroup.LayoutParams(-1, -1));
    this.c = new EcshopTabFragment.1(this, getActivity(), getActivity(), a(), this.e, this.b);
    this.c.setTimeBeforeLoadUrl(System.currentTimeMillis());
    new WebViewDirector(this.c).a(null, a(), null);
    this.e.setWillNotCacheDrawing(false);
    this.e.setDrawingCacheEnabled(true);
    if ((this.e != null) && (!StringUtil.isEmpty(this.b))) {
      this.e.loadUrl(this.b);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "【setData】");
    }
    this.a = paramInt;
    this.b = paramString;
  }
  
  public boolean a(EcshopTabFragment paramEcshopTabFragment)
  {
    boolean bool2 = false;
    if (paramEcshopTabFragment == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.b.equals(paramEcshopTabFragment.b))
    {
      bool1 = bool2;
      if (this.a == paramEcshopTabFragment.a) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131628312, paramViewGroup, false);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    EcshopNewPageWebViewBuilder localEcshopNewPageWebViewBuilder = this.c;
    if (localEcshopNewPageWebViewBuilder != null) {
      localEcshopNewPageWebViewBuilder.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.widget.EcshopTabFragment
 * JD-Core Version:    0.7.0.1
 */