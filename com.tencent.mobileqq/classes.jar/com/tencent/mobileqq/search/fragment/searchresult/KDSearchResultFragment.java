package com.tencent.mobileqq.search.fragment.searchresult;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import aylb;
import aylc;
import befe;
import bewj;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.app.AppRuntime;
import nur;
import xqq;

public class KDSearchResultFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private aylc jdField_a_of_type_Aylc;
  private bewj jdField_a_of_type_Bewj;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private QuickPinyinEditText jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
  public WebViewProgressBar a;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public static Intent a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("magic_code", 15453);
    localIntent.putExtra("url", paramString2);
    localIntent.putExtra("keyword", paramString1);
    localIntent.setClass(paramContext, PublicFragmentActivityForTool.class);
    localIntent.putExtra("public_fragment_class", KDSearchResultFragment.class.getName());
    return localIntent;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(this.b);
  }
  
  private void a(View paramView)
  {
    try
    {
      paramView.setBackgroundResource(2130838593);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("KDSearchResultFragment", 1, "doOnCreate, e = " + QLog.getStackTraceString(localException));
      try
      {
        paramView.setBackgroundResource(2130849461);
        return;
      }
      catch (Error paramView)
      {
        QLog.e("KDSearchResultFragment", 1, "doOnCreate, e = " + QLog.getStackTraceString(paramView));
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getInputExtras(true).putInt("QUICK_SEARCH", 1);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131690648);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Bewj = new bewj();
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_Bewj);
    this.jdField_a_of_type_Bewj.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
    this.jdField_a_of_type_Aylc = new aylb(this, getActivity(), getActivity(), a(), this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_Aylc.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new befe(this.jdField_a_of_type_Aylc).a(null, nur.a(), null);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setWillNotCacheDrawing(false);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setDrawingCacheEnabled(true);
  }
  
  public AppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
        if (!(localObject instanceof AppInterface)) {
          break label53;
        }
        return (AppInterface)localObject;
      }
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
    label53:
    return null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367817: 
      UniteSearchActivity.a(getActivity(), "", 26);
      getActivity().finish();
      return;
    case 2131363522: 
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
      getActivity().finish();
      return;
    }
    UniteSearchActivity.a(getActivity(), this.b, 26);
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent();
    int i = paramBundle.getIntExtra("magic_code", 0);
    if (i == 15453) {
      bool = true;
    }
    xqq.a(bool, "you must use the function:CheckArithHWResultFragment.open() to open this page!!!! :" + i);
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("url");
    this.b = paramBundle.getStringExtra("keyword");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561263, paramViewGroup, false);
    paramViewGroup = paramLayoutInflater.findViewById(2131376034);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((TouchWebView)paramLayoutInflater.findViewById(2131380142));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)paramLayoutInflater.findViewById(2131365851));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramLayoutInflater.findViewById(2131367817));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131363522));
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)paramLayoutInflater.findViewById(2131371664));
    paramBundle = paramLayoutInflater.findViewById(2131379933);
    paramBundle.setBackgroundColor(1996488704);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      paramBundle.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVisibility(0);
      a(paramViewGroup);
      b();
      c();
      a();
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        getActivity().getWindow().addFlags(67108864);
        int i = getResources().getColor(2131166959);
        paramBundle = new SystemBarCompact(getActivity(), true, i);
        paramBundle.setStatusDrawable(getResources().getDrawable(2130845746));
        paramBundle.init();
        paramViewGroup.setFitsSystemWindows(true);
        paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
        ImmersiveUtils.a(getActivity().getWindow(), true);
      }
      return paramLayoutInflater;
      paramBundle.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aylc != null) {
      this.jdField_a_of_type_Aylc.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Aylc != null) {
      this.jdField_a_of_type_Aylc.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aylc != null) {
      this.jdField_a_of_type_Aylc.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchresult.KDSearchResultFragment
 * JD-Core Version:    0.7.0.1
 */