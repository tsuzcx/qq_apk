package com.tencent.mobileqq.kandian.biz.search.searchresult;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import com.google.gson.Gson;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.base.view.widget.TopEdgeGestureLayout;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.search.constants.IKDSearchResultFragmentConst;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class KDSearchResultFragment
  extends PublicBaseFragment
  implements View.OnClickListener, IKDSearchResultFragmentConst
{
  private int jdField_a_of_type_Int = -1;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private KDSearchResultWebviewBuilder jdField_a_of_type_ComTencentMobileqqKandianBizSearchSearchresultKDSearchResultWebviewBuilder;
  private QuickPinyinEditText jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
  protected WebViewProgressBar a;
  private WebViewProgressBarController jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, String> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean = false;
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
    localIntent.putExtra("search_header", (String)((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySpValue("KDSearchResultHeader", ""));
    return localIntent;
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getExtras() == null) {
        return;
      }
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
        getBaseActivity().finish();
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(this.jdField_b_of_type_JavaLangString);
        c(true);
      }
    }
  }
  
  private void a(View paramView)
  {
    try
    {
      paramView.setBackgroundResource(2130838740);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("doOnCreate, e = ");
      localStringBuilder2.append(QLog.getStackTraceString(localException));
      QLog.e("KDSearchResultFragment", 1, localStringBuilder2.toString());
      try
      {
        paramView.setBackgroundResource(2130850359);
        return;
      }
      catch (Error paramView)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("doOnCreate, e = ");
        localStringBuilder1.append(QLog.getStackTraceString(paramView));
        QLog.e("KDSearchResultFragment", 1, localStringBuilder1.toString());
      }
    }
  }
  
  private boolean a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ajaxInfo:");
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append("url:");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ArrayOfJavaLangString.length);
    QLog.d("KDSearchResultFragment", 2, ((StringBuilder)localObject1).toString());
    if (this.jdField_b_of_type_JavaLangString != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((TouchWebView)localObject1).getUrl())) && (this.c != 0))
      {
        if (!this.jdField_a_of_type_Boolean) {
          return false;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
        int i = 0;
        for (;;)
        {
          Object localObject2 = this.jdField_a_of_type_ArrayOfJavaLangString;
          if (i >= localObject2.length) {
            break;
          }
          localObject2 = localObject2[i];
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject1).startsWith((String)localObject2))) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
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
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131690728);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController = new WebViewProgressBarController();
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSearchSearchresultKDSearchResultWebviewBuilder = new KDSearchResultFragment.2(this, getBaseActivity(), getBaseActivity(), a(), this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSearchSearchresultKDSearchResultWebviewBuilder.setTimeBeforeLoadUrl(System.currentTimeMillis());
    new WebViewDirector(this.jdField_a_of_type_ComTencentMobileqqKandianBizSearchSearchresultKDSearchResultWebviewBuilder).a(null, a(), null);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("window.updateSearchWord({\n        query : '");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append("', \n        url: '");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("' \n})");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jsUpdate: ");
    localStringBuilder.append((String)localObject);
    QLog.d("KDSearchResultFragment", 2, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.evaluateJavascript((String)localObject, new KDSearchResultFragment.4(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = false;
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_JavaLangString, localMap);
      QLog.e("kd_search_header", 2, this.jdField_a_of_type_JavaUtilMap.toString());
      return;
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVisibility(8);
    ThreadManager.getUIHandler().postDelayed(new KDSearchResultFragment.3(this), 200L);
  }
  
  public AppInterface a()
  {
    Object localObject3 = BaseApplicationImpl.getApplication();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
      if ((localObject3 instanceof ToolAppRuntime))
      {
        localObject3 = ((AppRuntime)localObject3).getAppRuntime("modular_web");
        localObject1 = localObject2;
        if ((localObject3 instanceof AppInterface)) {
          return (AppInterface)localObject3;
        }
      }
      else
      {
        localObject1 = localObject2;
        if ((localObject3 instanceof QQAppInterface)) {
          localObject1 = (QQAppInterface)localObject3;
        }
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    if ((getBaseActivity().mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getBaseActivity().getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getBaseActivity().getWindow(), getBaseActivity().isClearCoverLayer);
      if (getBaseActivity().mSystemBarComp == null) {
        getBaseActivity().mSystemBarComp = new SystemBarCompact(getBaseActivity(), true, -1);
      }
      getBaseActivity().mSystemBarComp.init();
      if (ThemeUtil.isInNightMode(getBaseActivity().app))
      {
        if ((!SystemUtil.b()) && (!SystemUtil.d()))
        {
          getBaseActivity().mSystemBarComp.setStatusBarColor(-7829368);
          return;
        }
        getBaseActivity().mSystemBarComp.setStatusBarColor(-7829368);
        getBaseActivity().mSystemBarComp.setStatusBarDarkMode(true);
        return;
      }
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        a(true);
        getBaseActivity().mSystemBarComp.setStatusBarColor(-1);
        return;
      }
      if (!SystemUtil.d())
      {
        getBaseActivity().mSystemBarComp.setStatusBarColor(-2368549);
        return;
      }
      getBaseActivity().mSystemBarComp.setStatusBarColor(-1);
      getBaseActivity().mSystemBarComp.setStatusBarDarkMode(true);
    }
  }
  
  @TargetApi(23)
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(0);
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
    if (paramIntent != null)
    {
      if (paramInt1 != 10) {
        return;
      }
      a(paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
    }
    else
    {
      getBaseActivity().finish();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131369291: 
      onBackEvent();
      return;
    case 2131368340: 
    case 2131368341: 
      UniteSearchActivity.b(getBaseActivity(), "", 26, 10);
      return;
    case 2131366333: 
    case 2131366334: 
      UniteSearchActivity.b(getBaseActivity(), this.jdField_b_of_type_JavaLangString, 26, 10);
      return;
    case 2131364050: 
      if (a() != null)
      {
        UniteSearchReportController.a(null, new ReportModelDC02528().module("search_box_bt_resultpage").action("clk_search_box_bt").ver2("kandian").session_id(a().getCurrentAccountUin()));
        return;
      }
      UniteSearchReportController.a(null, new ReportModelDC02528().module("search_box_bt_resultpage").action("clk_search_box_bt").ver2("kandian"));
      return;
    }
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
    getBaseActivity().finish();
    if (paramView.getId() == 2131369291)
    {
      if (a() != null)
      {
        UniteSearchReportController.a(null, new ReportModelDC02528().module("search_box_back").action("clk_search_box_back").ver2("kandian").session_id(a().getCurrentAccountUin()));
        return;
      }
      UniteSearchReportController.a(null, new ReportModelDC02528().module("search_box_back").action("clk_search_box_back").ver2("kandian"));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getBaseActivity().getIntent();
    Bundle localBundle = paramBundle.getExtras();
    boolean bool = false;
    int i = paramBundle.getIntExtra("magic_code", 0);
    if (i == 15453) {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("you must use the function:CheckArithHWResultFragment.open() to open this page!!!! :");
    localStringBuilder.append(i);
    AssertUtils.assertTrue(bool, localStringBuilder.toString());
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("url");
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("keyword");
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("search_from", -1);
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("searchbox_style", -1);
    this.c = localBundle.getInt("search_ajax_switch");
    this.jdField_a_of_type_ArrayOfJavaLangString = localBundle.getStringArray("url_prefix");
    paramBundle = localBundle.getString("search_header");
    this.jdField_a_of_type_JavaUtilMap = ((Map)new Gson().fromJson(paramBundle, new KDSearchResultFragment.1(this).getType()));
    RIJDtReportHelper.a.a(getBaseActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561424, paramViewGroup, false);
    paramViewGroup = paramLayoutInflater.findViewById(2131376809);
    if (this.jdField_b_of_type_Int == 1)
    {
      paramLayoutInflater.findViewById(2131377027).setVisibility(8);
      paramBundle = paramLayoutInflater.findViewById(2131377028);
      paramBundle.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)paramLayoutInflater.findViewById(2131366334));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramLayoutInflater.findViewById(2131368341));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131364050));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369291));
      if (ThemeImageWrapper.isNightMode())
      {
        paramBundle.setAlpha(0.4F);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846206);
      }
      b(true);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)paramLayoutInflater.findViewById(2131366333));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramLayoutInflater.findViewById(2131368340));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131363868));
      b(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)paramLayoutInflater.findViewById(2131372396));
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((TouchWebView)paramLayoutInflater.findViewById(2131381034));
    paramBundle = paramLayoutInflater.findViewById(2131380845);
    paramBundle.setBackgroundColor(1996488704);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      paramBundle.setVisibility(0);
    } else {
      paramBundle.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVisibility(0);
    a(paramViewGroup);
    c();
    b();
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getBaseActivity().getWindow().addFlags(67108864);
      int i = getResources().getColor(2131167114);
      paramBundle = new SystemBarCompact(getBaseActivity(), true, i);
      paramBundle.setStatusDrawable(getResources().getDrawable(2130846361));
      paramBundle.init();
      paramViewGroup.setFitsSystemWindows(true);
      paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
      ImmersiveUtils.clearCoverForStatus(getBaseActivity().getWindow(), true);
    }
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {
      a();
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    KDSearchResultWebviewBuilder localKDSearchResultWebviewBuilder = this.jdField_a_of_type_ComTencentMobileqqKandianBizSearchSearchresultKDSearchResultWebviewBuilder;
    if (localKDSearchResultWebviewBuilder != null) {
      localKDSearchResultWebviewBuilder.c();
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
    KDSearchResultWebviewBuilder localKDSearchResultWebviewBuilder = this.jdField_a_of_type_ComTencentMobileqqKandianBizSearchSearchresultKDSearchResultWebviewBuilder;
    if (localKDSearchResultWebviewBuilder != null) {
      localKDSearchResultWebviewBuilder.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    KDSearchResultWebviewBuilder localKDSearchResultWebviewBuilder = this.jdField_a_of_type_ComTencentMobileqqKandianBizSearchSearchresultKDSearchResultWebviewBuilder;
    if (localKDSearchResultWebviewBuilder != null) {
      localKDSearchResultWebviewBuilder.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.searchresult.KDSearchResultFragment
 * JD-Core Version:    0.7.0.1
 */