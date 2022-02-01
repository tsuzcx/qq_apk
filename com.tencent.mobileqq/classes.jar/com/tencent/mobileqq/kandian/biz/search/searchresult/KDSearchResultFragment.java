package com.tencent.mobileqq.kandian.biz.search.searchresult;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.view.widget.TopEdgeGestureLayout;
import com.tencent.mobileqq.kandian.biz.search.constants.IKDSearchResultFragmentConst;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.HuichuanConfigManager;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.intercept.SogouInterceptController;
import com.tencent.mobileqq.search.util.intercept.bean.SogouInterceptRuleListHolder;
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
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class KDSearchResultFragment
  extends PublicBaseFragment
  implements View.OnClickListener, IKDSearchResultFragmentConst
{
  protected WebViewProgressBar a;
  private KDSearchResultWebviewBuilder b;
  private int c = -1;
  private int d = -1;
  private String e;
  private String f;
  private TouchWebView g;
  private QuickPinyinEditText h;
  private ImageButton i;
  private Button j;
  private Button k;
  private ImageView l;
  private WebViewProgressBarController m;
  private int n;
  private String[] o = { "https://so.html5.qq.com/page/real" };
  private boolean p = false;
  private Map<String, String> q;
  
  public static Intent a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    Activity localActivity = (Activity)paramContext;
    if (localActivity != null)
    {
      int i1 = localActivity.getIntent().getIntExtra("fromType", -1);
      localIntent.putExtra("search_from", i1);
      if (i1 == 26) {
        localIntent.addFlags(603979776);
      }
    }
    localIntent.putExtra("magic_code", 15453);
    localIntent.putExtra("url", paramString2);
    localIntent.putExtra("intercept_rule", HuichuanConfigManager.a().d());
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("big_brother_source_key", "biz_src_kandian_search_download");
    localIntent.setClass(paramContext, PublicFragmentActivityForTool.class);
    localIntent.putExtra("public_fragment_class", KDSearchResultFragment.class.getName());
    localIntent.putExtra("search_header", (String)RIJSPUtils.b("KDSearchResultHeader", ""));
    return localIntent;
  }
  
  private String a(String paramString)
  {
    String str2 = SearchUtils.d(paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = SogouInterceptController.a().b(paramString);
    }
    return str1;
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
        this.e = paramIntent.getString("url");
        if (!TextUtils.isEmpty(this.e)) {
          this.f = paramIntent.getString("keyword");
        }
      }
      if (!TextUtils.isEmpty(this.e))
      {
        this.h.setText(this.f);
        c(true);
      }
    }
  }
  
  private void a(View paramView)
  {
    try
    {
      paramView.setBackgroundResource(2130838959);
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
        paramView.setBackgroundResource(2130852150);
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
  
  private void a(String paramString1, String paramString2)
  {
    if (b() != null)
    {
      UniteSearchReportController.a(null, new ReportModelDC02528().module(paramString1).action(paramString2).ver2("kandian").session_id(b().getCurrentAccountUin()));
      return;
    }
    UniteSearchReportController.a(null, new ReportModelDC02528().module(paramString1).action(paramString2).ver2("kandian"));
  }
  
  private void b(boolean paramBoolean)
  {
    this.h.setFocusable(false);
    this.h.setOnClickListener(this);
    this.h.setImeOptions(3);
    this.h.addTextChangedListener(new KDSearchResultFragment.2(this));
    this.h.getInputExtras(true).putInt("QUICK_SEARCH", 1);
    this.i.setOnClickListener(this);
    this.i.setVisibility(0);
    if (paramBoolean)
    {
      this.k.setOnClickListener(this);
      this.l.setOnClickListener(this);
      return;
    }
    this.j.setVisibility(0);
    this.j.setText(2131887648);
    this.j.setOnClickListener(this);
  }
  
  private boolean b(String paramString)
  {
    return (SearchUtils.c(paramString)) || (!TextUtils.isEmpty(SogouInterceptController.a().c(paramString)));
  }
  
  @Nullable
  private Map<String, String> c(String paramString)
  {
    if (this.q != null)
    {
      HashMap localHashMap = new HashMap();
      if (SearchUtils.f(paramString))
      {
        localHashMap.putAll(this.q);
        return localHashMap;
      }
      paramString = (String)this.q.get("Q-UA2");
      String str = (String)this.q.get("conn");
      if (!TextUtils.isEmpty(paramString)) {
        localHashMap.put("Q-UA2", paramString);
      }
      paramString = localHashMap;
      if (!TextUtils.isEmpty(str))
      {
        localHashMap.put("conn", str);
        return localHashMap;
      }
    }
    else
    {
      paramString = null;
    }
    return paramString;
  }
  
  private void c()
  {
    e();
    this.h.setText(this.f);
  }
  
  private void c(boolean paramBoolean)
  {
    if (!f())
    {
      e();
      return;
    }
    if (paramBoolean) {
      g();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("window.updateSearchWord({\n        query : '");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append("', \n        url: '");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append("' \n})");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jsUpdate: ");
    localStringBuilder.append((String)localObject);
    QLog.d("KDSearchResultFragment", 2, localStringBuilder.toString());
    this.g.evaluateJavascript((String)localObject, new KDSearchResultFragment.5(this));
  }
  
  private void d()
  {
    this.m = new WebViewProgressBarController();
    this.a.setController(this.m);
    this.m.a(this.a);
    this.a.setVisibility(8);
    this.b = new KDSearchResultFragment.3(this, getBaseActivity(), getBaseActivity(), b(), this.g);
    this.b.setTimeBeforeLoadUrl(System.currentTimeMillis());
    new WebViewDirector(this.b).a(null, b(), null);
    this.g.setWillNotCacheDrawing(false);
    this.g.setDrawingCacheEnabled(true);
  }
  
  private boolean d(String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = new JSONObject(paramString);
      boolean bool1 = bool2;
      if (paramString.has("code"))
      {
        int i1 = paramString.getInt("code");
        bool1 = bool2;
        if (i1 == 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private void e()
  {
    this.p = false;
    Map localMap = c(this.e);
    if (localMap != null)
    {
      this.g.loadUrl(this.e, localMap);
      QLog.e("kd_search_header", 2, localMap.toString());
      return;
    }
    this.g.loadUrl(this.e);
  }
  
  private boolean f()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ajaxInfo:");
    ((StringBuilder)localObject1).append(this.n);
    ((StringBuilder)localObject1).append("url:");
    ((StringBuilder)localObject1).append(this.o.length);
    QLog.d("KDSearchResultFragment", 2, ((StringBuilder)localObject1).toString());
    if (this.f != null)
    {
      localObject1 = this.g;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((TouchWebView)localObject1).getUrl())) && (this.n != 0))
      {
        if (!this.p) {
          return false;
        }
        localObject1 = this.g.getUrl();
        int i1 = 0;
        for (;;)
        {
          Object localObject2 = this.o;
          if (i1 >= localObject2.length) {
            break;
          }
          localObject2 = localObject2[i1];
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject1).startsWith((String)localObject2))) {
            return true;
          }
          i1 += 1;
        }
      }
    }
    return false;
  }
  
  private void g()
  {
    this.g.setVisibility(8);
    ThreadManager.getUIHandler().postDelayed(new KDSearchResultFragment.4(this), 200L);
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
        if ((!SystemUtil.d()) && (!SystemUtil.g()))
        {
          getBaseActivity().mSystemBarComp.setStatusBarColor(-7829368);
          return;
        }
        getBaseActivity().mSystemBarComp.setStatusBarColor(-7829368);
        getBaseActivity().mSystemBarComp.setStatusBarDarkMode(true);
        return;
      }
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
      {
        a(true);
        getBaseActivity().mSystemBarComp.setStatusBarColor(-1);
        return;
      }
      if (!SystemUtil.g())
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
  
  public AppInterface b()
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
    if (this.g.canGoBack())
    {
      this.a.setVisibility(8);
      this.g.goBack();
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
    case 2131436277: 
      onBackEvent();
      return;
    case 2131435215: 
    case 2131435216: 
      UniteSearchActivity.b(getBaseActivity(), "", 26, 10);
      return;
    case 2131432634: 
    case 2131432635: 
      a("search_result_page", "search_box_click");
      UniteSearchActivity.b(getBaseActivity(), this.f, 26, 10);
      return;
    case 2131430008: 
      a("search_box_bt_resultpage", "clk_search_box_bt");
      return;
    }
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.h.getWindowToken(), 0);
    getBaseActivity().finish();
    if (paramView.getId() == 2131436277) {
      a("search_box_back", "clk_search_box_back");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getBaseActivity().getIntent();
    Bundle localBundle = paramBundle.getExtras();
    boolean bool = false;
    int i1 = paramBundle.getIntExtra("magic_code", 0);
    if (i1 == 15453) {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("you must use the function:CheckArithHWResultFragment.open() to open this page!!!! :");
    localStringBuilder.append(i1);
    AssertUtils.assertTrue(bool, localStringBuilder.toString());
    this.e = paramBundle.getStringExtra("url");
    this.f = paramBundle.getStringExtra("keyword");
    this.c = paramBundle.getIntExtra("search_from", -1);
    this.d = paramBundle.getIntExtra("searchbox_style", -1);
    this.n = localBundle.getInt("search_ajax_switch");
    this.o = localBundle.getStringArray("url_prefix");
    SogouInterceptRuleListHolder.a(localBundle.getString("intercept_rule"));
    paramBundle = localBundle.getString("search_header");
    this.q = ((Map)new Gson().fromJson(paramBundle, new KDSearchResultFragment.1(this).getType()));
    RIJDtReportHelper.a.a(getBaseActivity());
    a("search_result_page", "search_box_expose");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131627780, paramViewGroup, false);
    paramViewGroup = paramLayoutInflater.findViewById(2131445137);
    if (this.d == 1)
    {
      paramLayoutInflater.findViewById(2131445393).setVisibility(8);
      paramBundle = paramLayoutInflater.findViewById(2131445394);
      paramBundle.setVisibility(0);
      this.h = ((QuickPinyinEditText)paramLayoutInflater.findViewById(2131432635));
      this.i = ((ImageButton)paramLayoutInflater.findViewById(2131435216));
      this.k = ((Button)paramLayoutInflater.findViewById(2131430008));
      this.l = ((ImageView)paramLayoutInflater.findViewById(2131436277));
      if (ThemeImageWrapper.isNightMode())
      {
        paramBundle.setAlpha(0.4F);
        this.l.setImageResource(2130847676);
      }
      b(true);
    }
    else
    {
      this.h = ((QuickPinyinEditText)paramLayoutInflater.findViewById(2131432634));
      this.i = ((ImageButton)paramLayoutInflater.findViewById(2131435215));
      this.j = ((Button)paramLayoutInflater.findViewById(2131429816));
      b(false);
    }
    this.a = ((WebViewProgressBar)paramLayoutInflater.findViewById(2131439916));
    this.g = ((TouchWebView)paramLayoutInflater.findViewById(2131450045));
    paramBundle = paramLayoutInflater.findViewById(2131449822);
    paramBundle.setBackgroundColor(1996488704);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      paramBundle.setVisibility(0);
    } else {
      paramBundle.setVisibility(8);
    }
    this.g.setVisibility(0);
    a(paramViewGroup);
    d();
    c();
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getBaseActivity().getWindow().addFlags(67108864);
      int i1 = getResources().getColor(2131168092);
      paramBundle = new SystemBarCompact(getBaseActivity(), true, i1);
      paramBundle.setStatusDrawable(getResources().getDrawable(2130847834));
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
    KDSearchResultWebviewBuilder localKDSearchResultWebviewBuilder = this.b;
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
    KDSearchResultWebviewBuilder localKDSearchResultWebviewBuilder = this.b;
    if (localKDSearchResultWebviewBuilder != null) {
      localKDSearchResultWebviewBuilder.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    KDSearchResultWebviewBuilder localKDSearchResultWebviewBuilder = this.b;
    if (localKDSearchResultWebviewBuilder != null) {
      localKDSearchResultWebviewBuilder.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.searchresult.KDSearchResultFragment
 * JD-Core Version:    0.7.0.1
 */