package com.tencent.mobileqq.search.fragment.searchresult;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import bccp;
import bccq;
import bccr;
import bcjs;
import bieb;
import biur;
import blfw;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TopEdgeGestureLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import opg;
import org.json.JSONObject;
import ptj;
import zdl;

public class KDSearchResultFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bccr jdField_a_of_type_Bccr;
  private biur jdField_a_of_type_Biur;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private QuickPinyinEditText jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
  public WebViewProgressBar a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "https://so.html5.qq.com/page/real" };
  private int jdField_b_of_type_Int = -1;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  
  public static Intent a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    Activity localActivity = (Activity)paramContext;
    if (localActivity != null)
    {
      int i = localActivity.getIntent().getIntExtra("fromType", -1);
      localIntent.putExtra("search_from", i);
      if (i == 26) {
        localIntent.addFlags(603979776);
      }
    }
    localIntent.putExtra("magic_code", 15453);
    localIntent.putExtra("url", paramString2);
    localIntent.putExtra("keyword", paramString1);
    localIntent.setClass(paramContext, PublicFragmentActivityForTool.class);
    localIntent.putExtra("public_fragment_class", KDSearchResultFragment.class.getName());
    return localIntent;
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramIntent = paramIntent.getExtras();
      if (paramIntent.containsKey("keyword"))
      {
        this.jdField_a_of_type_JavaLangString = paramIntent.getString("url");
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          this.jdField_b_of_type_JavaLangString = paramIntent.getString("keyword");
        }
      }
      if (TextUtils.isEmpty(paramIntent.getString("keyword")))
      {
        BaseApplication.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
        getActivity().finish();
        return;
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(this.jdField_b_of_type_JavaLangString);
    c(true);
  }
  
  private void a(View paramView)
  {
    try
    {
      paramView.setBackgroundResource(2130838912);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("KDSearchResultFragment", 1, "doOnCreate, e = " + QLog.getStackTraceString(localException));
      try
      {
        paramView.setBackgroundResource(2130850034);
        return;
      }
      catch (Error paramView)
      {
        QLog.e("KDSearchResultFragment", 1, "doOnCreate, e = " + QLog.getStackTraceString(paramView));
      }
    }
  }
  
  private boolean a()
  {
    QLog.d("KDSearchResultFragment", 2, "ajaxInfo:" + this.c + "url:" + this.jdField_a_of_type_ArrayOfJavaLangString.length);
    if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl())) || (this.c == 0) || (!this.jdField_a_of_type_Boolean)) {}
    for (;;)
    {
      return false;
      String str2 = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        Object localObject = "";
        try
        {
          String str1 = this.jdField_a_of_type_ArrayOfJavaLangString[i];
          localObject = str1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
          i += 1;
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (str2.startsWith((String)localObject))) {
          return true;
        }
      }
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = new JSONObject(paramString);
      boolean bool1 = bool2;
      if (paramString.has("code"))
      {
        int i = paramString.getInt("code");
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private void b()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(this.jdField_b_of_type_JavaLangString);
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getInputExtras(true).putInt("QUICK_SEARCH", 1);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131690697);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Biur = new biur();
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_Biur);
    this.jdField_a_of_type_Biur.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
    this.jdField_a_of_type_Bccr = new bccp(this, getActivity(), getActivity(), a(), this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_Bccr.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new bieb(this.jdField_a_of_type_Bccr).a(null, opg.a(), null);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setWillNotCacheDrawing(false);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setDrawingCacheEnabled(true);
  }
  
  private void c(boolean paramBoolean)
  {
    if (!a())
    {
      d();
      return;
    }
    if (paramBoolean) {
      e();
    }
    String str = "window.updateSearchWord({\n        query : '" + this.jdField_b_of_type_JavaLangString + "', \n        url: '" + this.jdField_a_of_type_JavaLangString + "' \n})";
    QLog.d("KDSearchResultFragment", 2, "jsUpdate: " + str);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.evaluateJavascript(str, new bccq(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVisibility(8);
    ThreadManager.getUIHandler().postDelayed(new KDSearchResultFragment.2(this), 200L);
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
          break label54;
        }
        return (AppInterface)localObject;
      }
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
    label54:
    return null;
  }
  
  public void a()
  {
    if ((getActivity().mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getActivity().getWindow().addFlags(67108864);
      ImmersiveUtils.a(getActivity().getWindow(), getActivity().isClearCoverLayer);
      if (getActivity().mSystemBarComp == null) {
        getActivity().mSystemBarComp = new SystemBarCompact(getActivity(), true, -1);
      }
      getActivity().mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(getActivity().app)) {
        break label151;
      }
      if ((!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme())) {
        getActivity().mSystemBarComp.setStatusBarColor(-7829368);
      }
    }
    else
    {
      return;
    }
    getActivity().mSystemBarComp.setStatusBarColor(-7829368);
    getActivity().mSystemBarComp.setStatusBarDarkMode(true);
    return;
    label151:
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme()))
    {
      a(true);
      getActivity().mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!SystemUtil.isFlyme())
    {
      getActivity().mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    getActivity().mSystemBarComp.setStatusBarColor(-1);
    getActivity().mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  @TargetApi(23)
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getActivity().getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public void initSideFling(Context paramContext, FlingHandler paramFlingHandler)
  {
    if ((paramFlingHandler != null) && ((paramFlingHandler instanceof FlingGestureHandler)))
    {
      paramFlingHandler = (FlingGestureHandler)paramFlingHandler;
      paramFlingHandler.setTopLayout(new TopEdgeGestureLayout(paramContext));
      paramFlingHandler.mTopLayout.setInterceptScrollLRFlag(true);
      paramFlingHandler.mTopLayout.setInterceptScrollRLFlag(true);
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null) {
      paramActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent == null) || (paramInt1 != 10)) {
      return;
    }
    a(paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
    }
    for (;;)
    {
      return true;
      getActivity().finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      UniteSearchActivity.b(getActivity(), "", 26, 10);
      continue;
      onBackEvent();
      continue;
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
      getActivity().finish();
      if (paramView.getId() == 2131369326) {
        if (a() != null)
        {
          bcjs.a(null, new ReportModelDC02528().module("search_box_back").action("clk_search_box_back").ver2("kandian").session_id(a().getCurrentAccountUin()));
        }
        else
        {
          bcjs.a(null, new ReportModelDC02528().module("search_box_back").action("clk_search_box_back").ver2("kandian"));
          continue;
          UniteSearchActivity.b(getActivity(), this.jdField_b_of_type_JavaLangString, 26, 10);
          continue;
          if (a() != null) {
            bcjs.a(null, new ReportModelDC02528().module("search_box_bt_resultpage").action("clk_search_box_bt").ver2("kandian").session_id(a().getCurrentAccountUin()));
          } else {
            bcjs.a(null, new ReportModelDC02528().module("search_box_bt_resultpage").action("clk_search_box_bt").ver2("kandian"));
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent();
    Bundle localBundle = paramBundle.getExtras();
    int i = paramBundle.getIntExtra("magic_code", 0);
    if (i == 15453) {
      bool = true;
    }
    zdl.a(bool, "you must use the function:CheckArithHWResultFragment.open() to open this page!!!! :" + i);
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("url");
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("keyword");
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("search_from", -1);
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("searchbox_style", -1);
    this.c = localBundle.getInt("search_ajax_switch");
    this.jdField_a_of_type_ArrayOfJavaLangString = localBundle.getStringArray("url_prefix");
    ptj.a.a(getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561474, paramViewGroup, false);
    paramViewGroup = paramLayoutInflater.findViewById(2131376947);
    if (this.jdField_b_of_type_Int == 1)
    {
      paramLayoutInflater.findViewById(2131377163).setVisibility(8);
      paramBundle = paramLayoutInflater.findViewById(2131377164);
      paramBundle.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)paramLayoutInflater.findViewById(2131366281));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramLayoutInflater.findViewById(2131368379));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131364028));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369326));
      if (blfw.a())
      {
        paramBundle.setAlpha(0.4F);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846012);
      }
      b(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)paramLayoutInflater.findViewById(2131372509));
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((TouchWebView)paramLayoutInflater.findViewById(2131381355));
      paramBundle = paramLayoutInflater.findViewById(2131381145);
      paramBundle.setBackgroundColor(1996488704);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label381;
      }
      paramBundle.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVisibility(0);
      a(paramViewGroup);
      c();
      b();
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        getActivity().getWindow().addFlags(67108864);
        int i = getResources().getColor(2131167084);
        paramBundle = new SystemBarCompact(getActivity(), true, i);
        paramBundle.setStatusDrawable(getResources().getDrawable(2130846157));
        paramBundle.init();
        paramViewGroup.setFitsSystemWindows(true);
        paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
        ImmersiveUtils.a(getActivity().getWindow(), true);
      }
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        a();
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)paramLayoutInflater.findViewById(2131366280));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramLayoutInflater.findViewById(2131368378));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131363845));
      b(false);
      break;
      label381:
      paramBundle.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bccr != null) {
      this.jdField_a_of_type_Bccr.c();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Bccr != null) {
      this.jdField_a_of_type_Bccr.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Bccr != null) {
      this.jdField_a_of_type_Bccr.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchresult.KDSearchResultFragment
 * JD-Core Version:    0.7.0.1
 */