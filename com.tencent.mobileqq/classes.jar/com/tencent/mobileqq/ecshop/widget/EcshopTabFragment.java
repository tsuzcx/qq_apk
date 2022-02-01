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
  private static final String b = "EcshopTabFragment";
  public int a;
  public EcshopNewPageWebViewBuilder a;
  private EcshopWebview a;
  public String a;
  
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
    this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebview = EcshopWebviewPool.a().a(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebview.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebview.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebview);
    }
    paramView = (RefreshView)paramView.findViewById(2131366020);
    paramView.setDelayBeforeScrollBack(500L);
    this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebview.setOnOverScrollHandler(paramView);
    paramView.addView(this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebview, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopNewPageWebViewBuilder = new EcshopTabFragment.1(this, getActivity(), getActivity(), a(), this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebview, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopNewPageWebViewBuilder.setTimeBeforeLoadUrl(System.currentTimeMillis());
    new WebViewDirector(this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopNewPageWebViewBuilder).a(null, a(), null);
    this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebview.setWillNotCacheDrawing(false);
    this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebview.setDrawingCacheEnabled(true);
    if ((this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebview != null) && (!StringUtil.a(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebview.loadUrl(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, "【setData】");
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(EcshopTabFragment paramEcshopTabFragment)
  {
    boolean bool2 = false;
    if (paramEcshopTabFragment == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaLangString.equals(paramEcshopTabFragment.jdField_a_of_type_JavaLangString))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Int == paramEcshopTabFragment.jdField_a_of_type_Int) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561894, paramViewGroup, false);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    EcshopNewPageWebViewBuilder localEcshopNewPageWebViewBuilder = this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopNewPageWebViewBuilder;
    if (localEcshopNewPageWebViewBuilder != null) {
      localEcshopNewPageWebViewBuilder.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.widget.EcshopTabFragment
 * JD-Core Version:    0.7.0.1
 */