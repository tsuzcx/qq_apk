package com.tencent.mobileqq.kandian.biz.push.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadinjoyJumpUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IMultiVideoHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.MultiVideoConfigHandler;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule.FastWebContentGetCallback;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadinjoyJumpActivity
  extends IphoneTitleBarFragment
  implements FastWebModule.FastWebContentGetCallback
{
  private static Runnable jdField_b_of_type_JavaLangRunnable;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadinjoyJumpActivity.2(this);
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = null;
  private WebViewProgressBar jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
  private WebViewProgressBarController jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadinjoyJumpActivity.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  public static void a(Context paramContext, Intent paramIntent, long paramLong)
  {
    if (jdField_b_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(jdField_b_of_type_JavaLangRunnable);
    }
    long l = paramIntent.getLongExtra("jump_article_param_ids", -1L);
    paramIntent.removeExtra("jump_article_param_ids");
    jdField_b_of_type_JavaLangRunnable = new ReadinjoyJumpActivity.4(l, paramIntent, paramContext);
    if (l != -1L) {
      ThreadManager.getSubThreadHandler().postDelayed(jdField_b_of_type_JavaLangRunnable, paramLong);
    }
    paramContext = new StringBuilder();
    paramContext.append("jump activity, ids : ");
    paramContext.append(l);
    paramContext.append(", delay : ");
    paramContext.append(paramLong);
    QLog.d("ReadinjoyJumpActivity", 1, paramContext.toString());
  }
  
  public static boolean a(Intent paramIntent)
  {
    return paramIntent.hasExtra("jump_article_param_ids");
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)this.mContentView.findViewById(2131373133));
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController = new WebViewProgressBarController();
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)0);
  }
  
  public static boolean b(Intent paramIntent)
  {
    return paramIntent.hasExtra("daily_lock_screen_flag");
  }
  
  private void c()
  {
    BaseActivity localBaseActivity;
    int i;
    Intent localIntent;
    label146:
    try
    {
      localBaseActivity = getBaseActivity();
      if ((localBaseActivity != null) && (!this.c))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null)
        {
          localBaseActivity.finish();
          return;
        }
        this.jdField_b_of_type_Boolean = true;
        this.c = true;
        i = ReadinjoyJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
        if (i != 0)
        {
          if (i != 2) {
            break label264;
          }
          localIntent = ReadinjoyJumpUtils.a(localBaseActivity, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
          localIntent.putExtra("VIDEO_FROM_TYPE", 27);
          localObject2 = localIntent.getExtras();
        }
      }
    }
    finally {}
    try
    {
      bool = MultiVideoConfigHandler.a(((Bundle)localObject2).getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(((Bundle)localObject2).getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(((Bundle)localObject2).getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(((Bundle)localObject2).getString("VIDEO_TIME")).intValue());
    }
    catch (Exception localException)
    {
      break label146;
    }
    boolean bool = false;
    if (bool)
    {
      localIntent = new Intent();
      localIntent.putExtras((Bundle)localObject2);
      ((IMultiVideoHelper)QRoute.api(IMultiVideoHelper.class)).start(localBaseActivity, localIntent);
    }
    else
    {
      localBaseActivity.startActivity(localIntent);
      break label264;
      localObject2 = ReadinjoyJumpUtils.b(localBaseActivity, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      ((Intent)localObject2).putExtra("from_native", true);
      if (!((Intent)localObject2).getBooleanExtra("is_native_fast_web", false)) {
        this.jdField_b_of_type_Boolean = false;
      }
      localBaseActivity.startActivity((Intent)localObject2);
      if (RIJWebArticleUtil.a.d()) {
        localBaseActivity.overridePendingTransition(2130771996, 0);
      } else {
        localBaseActivity.overridePendingTransition(0, 0);
      }
    }
    label264:
    ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.invalidateProteusTemplateBean();
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("algorithm_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID);
      ((JSONObject)localObject2).put("rowkey", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
      RIJKanDianTabReport.a(false, (JSONObject)localObject2);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_Int);
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID);
    ((StringBuilder)localObject4).append("");
    localObject4 = ((StringBuilder)localObject4).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId);
    localStringBuilder.append("");
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X80094C3", "0X80094C3", 0, 0, (String)localObject3, (String)localObject4, localStringBuilder.toString(), ((JSONObject)localObject2).toString(), false);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(", needFinfishActivity : ");
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_Boolean);
    QLog.d("ReadinjoyJumpActivity", 1, new Object[] { "do dump action, type : ", Integer.valueOf(i), ((StringBuilder)localObject2).toString() });
    if (this.jdField_b_of_type_Boolean) {
      localBaseActivity.finish();
    }
    return;
  }
  
  public static boolean c(Intent paramIntent)
  {
    return paramIntent.hasExtra("kan_dian_lock_screen_flag");
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a();
    if (this.leftView != null)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setText(HardCodeUtil.a(2131712934));
      this.leftView.setBackgroundResource(2130849814);
    }
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      if (ThemeUtil.isInNightMode(ReadInJoyUtils.a())) {
        getTitleBarView().setBackgroundColor(Color.parseColor("#888888"));
      } else {
        getTitleBarView().setBackgroundColor(-1);
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)2);
    if (this.mContentView != null) {
      this.mContentView.findViewById(2131366301).setVisibility(0);
    }
    QLog.d("ReadinjoyJumpActivity", 1, "show error page!");
  }
  
  public void a()
  {
    Object localObject = getBaseActivity();
    if ((localObject != null) && ((localObject instanceof PublicFragmentActivity)))
    {
      localObject = (PublicFragmentActivity)localObject;
      SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)localObject).mSystemBarComp;
      if ((localSystemBarCompact != null) && (needImmersive()) && (needStatusTrans()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (ThemeUtil.isInNightMode(((PublicFragmentActivity)localObject).getAppRuntime()))
        {
          if ((!SystemUtil.b()) && (!SystemUtil.d()))
          {
            localSystemBarCompact.setStatusBarColor(-7829368);
            return;
          }
          localSystemBarCompact.setStatusBarColor(-7829368);
          localSystemBarCompact.setStatusBarDarkMode(true);
          return;
        }
        if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
        {
          ((PublicFragmentActivity)localObject).getWindow().getDecorView().setSystemUiVisibility(9216);
          localSystemBarCompact.setStatusBarColor(-1);
          return;
        }
        if (!SystemUtil.d())
        {
          localSystemBarCompact.setStatusBarColor(-2368549);
          return;
        }
        localSystemBarCompact.setStatusBarColor(-1);
        localSystemBarCompact.setStatusBarDarkMode(true);
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, FastWebArticleInfo paramFastWebArticleInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get fastWeb info resp, isSucc : ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(", useWeb : ");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(", data : ");
    localStringBuilder.append(paramFastWebArticleInfo);
    localStringBuilder.append(", needFinfish : ");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    QLog.d("ReadinjoyJumpActivity", 2, localStringBuilder.toString());
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if ((paramBoolean1) && (getBaseActivity() != null))
    {
      c();
      return;
    }
    e();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    getBaseActivity().getWindow().setFlags(16777216, 16777216);
    b();
    this.jdField_a_of_type_Long = getBaseActivity().getIntent().getLongExtra("jump_article_param_ids", -1L);
    paramLayoutInflater = getBaseActivity().getIntent();
    int i = 0;
    this.jdField_a_of_type_Int = paramLayoutInflater.getIntExtra("jump_activity_launch_from", 0);
    if (this.jdField_a_of_type_Long == -1L)
    {
      getBaseActivity().finish();
      return;
    }
    paramLayoutInflater = new JSONObject();
    RIJKanDianTabReport.a(false, paramLayoutInflater);
    paramViewGroup = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    paramBundle = new StringBuilder();
    paramBundle.append("");
    paramBundle.append(this.jdField_a_of_type_Int);
    paramBundle = paramBundle.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("");
    paramViewGroup.publicAccountReportClickEvent(null, "", "0X80094C1", "0X80094C1", 0, 0, paramBundle, localStringBuilder.toString(), "", paramLayoutInflater.toString(), false);
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append("param_article_id : ");
    paramLayoutInflater.append(this.jdField_a_of_type_Long);
    QLog.d("ReadinjoyJumpActivity", 1, paramLayoutInflater.toString());
    if (getBaseActivity().getIntent().getBooleanExtra("daily_lock_screen_param", false)) {
      i = DailyModeConfigHandler.b();
    }
    int j = i;
    if (this.jdField_a_of_type_Int == 0) {
      j = getBaseActivity().getIntent().getIntExtra("arg_channel_cover_id", i);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ReadInJoyLogicEngine.a().b(j, this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null)
    {
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    }
    RIJDtReportHelper.a.a(getBaseActivity());
  }
  
  protected int getContentLayoutId()
  {
    return 2131560222;
  }
  
  public boolean onBackEvent()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    JSONObject localJSONObject = new JSONObject();
    RIJKanDianTabReport.a(false, localJSONObject);
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("");
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X80094C2", "0X80094C2", 0, 0, localStringBuilder.toString(), (String)localObject, "", localJSONObject.toString(), false);
    this.jdField_b_of_type_Boolean = true;
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    d();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_b_of_type_Boolean)
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
      getBaseActivity().finish();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStop, needFinfish : ");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    QLog.d("ReadinjoyJumpActivity", 2, localStringBuilder.toString());
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (!this.c)) {
      ThreadManager.getSubThreadHandler().post(new ReadinjoyJumpActivity.3(this));
    }
    if ((!paramBoolean) && (this.c) && (this.jdField_b_of_type_Boolean)) {
      getBaseActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.activity.ReadinjoyJumpActivity
 * JD-Core Version:    0.7.0.1
 */