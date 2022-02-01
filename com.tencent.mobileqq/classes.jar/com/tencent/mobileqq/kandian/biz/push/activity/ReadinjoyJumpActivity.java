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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.MultiVideoHelper;
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
  private static Runnable k;
  private int a = 0;
  private long b = -1L;
  private AbsBaseArticleInfo c = null;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private WebViewProgressBar g;
  private WebViewProgressBarController h;
  private Runnable i = new ReadinjoyJumpActivity.1(this);
  private ReadInJoyObserver j = new ReadinjoyJumpActivity.2(this);
  
  public static void a(Context paramContext, Intent paramIntent, long paramLong)
  {
    if (k != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(k);
    }
    long l = paramIntent.getLongExtra("jump_article_param_ids", -1L);
    paramIntent.removeExtra("jump_article_param_ids");
    k = new ReadinjoyJumpActivity.4(l, paramIntent, paramContext);
    if (l != -1L) {
      ThreadManager.getSubThreadHandler().postDelayed(k, paramLong);
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
    this.g = ((WebViewProgressBar)this.mContentView.findViewById(2131440738));
    this.h = new WebViewProgressBarController();
    this.h.a(this.g);
    this.g.setController(this.h);
    this.h.a((byte)0);
  }
  
  public static boolean b(Intent paramIntent)
  {
    return paramIntent.hasExtra("daily_lock_screen_flag");
  }
  
  private void c()
  {
    BaseActivity localBaseActivity;
    int m;
    Intent localIntent;
    label146:
    try
    {
      localBaseActivity = getBaseActivity();
      if ((localBaseActivity != null) && (!this.f))
      {
        if (this.c == null)
        {
          localBaseActivity.finish();
          return;
        }
        this.e = true;
        this.f = true;
        m = ReadinjoyJumpUtils.a(this.c);
        if (m != 0)
        {
          if (m != 2) {
            break label254;
          }
          localIntent = ReadinjoyJumpUtils.a(localBaseActivity, this.c);
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
      MultiVideoHelper.a(localBaseActivity, localIntent);
    }
    else
    {
      localBaseActivity.startActivity(localIntent);
      break label254;
      localObject2 = ReadinjoyJumpUtils.b(localBaseActivity, this.c);
      ((Intent)localObject2).putExtra("from_native", true);
      if (!((Intent)localObject2).getBooleanExtra("is_native_fast_web", false)) {
        this.e = false;
      }
      localBaseActivity.startActivity((Intent)localObject2);
      if (RIJWebArticleUtil.a.e()) {
        localBaseActivity.overridePendingTransition(2130771999, 0);
      } else {
        localBaseActivity.overridePendingTransition(0, 0);
      }
    }
    label254:
    ReadInJoyLogicEngine.a().a(this.c.mArticleID, System.currentTimeMillis());
    this.c.invalidateProteusTemplateBean();
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("algorithm_id", this.c.mAlgorithmID);
      ((JSONObject)localObject2).put("rowkey", this.c.innerUniqueID);
      RIJKanDianTabReport.a(false, (JSONObject)localObject2);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.a);
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(this.c.mArticleID);
    ((StringBuilder)localObject4).append("");
    localObject4 = ((StringBuilder)localObject4).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c.mStrategyId);
    localStringBuilder.append("");
    PublicAccountReportUtils.a(null, "", "0X80094C3", "0X80094C3", 0, 0, (String)localObject3, (String)localObject4, localStringBuilder.toString(), ((JSONObject)localObject2).toString(), false);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(", needFinfishActivity : ");
    ((StringBuilder)localObject2).append(this.e);
    QLog.d("ReadinjoyJumpActivity", 1, new Object[] { "do dump action, type : ", Integer.valueOf(m), ((StringBuilder)localObject2).toString() });
    if (this.e) {
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
    if (this.d) {
      return;
    }
    a();
    if (this.leftView != null)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setText(HardCodeUtil.a(2131901576));
      this.leftView.setBackgroundResource(2130851519);
    }
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      if (ThemeUtil.isInNightMode(ReadInJoyUtils.b())) {
        getTitleBarView().setBackgroundColor(Color.parseColor("#888888"));
      } else {
        getTitleBarView().setBackgroundColor(-1);
      }
    }
    this.d = true;
  }
  
  private void e()
  {
    this.h.a((byte)2);
    if (this.mContentView != null) {
      this.mContentView.findViewById(2131432600).setVisibility(0);
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
          if ((!SystemUtil.d()) && (!SystemUtil.g()))
          {
            localSystemBarCompact.setStatusBarColor(-7829368);
            return;
          }
          localSystemBarCompact.setStatusBarColor(-7829368);
          localSystemBarCompact.setStatusBarDarkMode(true);
          return;
        }
        if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
        {
          ((PublicFragmentActivity)localObject).getWindow().getDecorView().setSystemUiVisibility(9216);
          localSystemBarCompact.setStatusBarColor(-1);
          return;
        }
        if (!SystemUtil.g())
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
    localStringBuilder.append(this.e);
    QLog.d("ReadinjoyJumpActivity", 2, localStringBuilder.toString());
    if (this.e) {
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
    this.b = getBaseActivity().getIntent().getLongExtra("jump_article_param_ids", -1L);
    paramLayoutInflater = getBaseActivity().getIntent();
    int m = 0;
    this.a = paramLayoutInflater.getIntExtra("jump_activity_launch_from", 0);
    if (this.b == -1L)
    {
      getBaseActivity().finish();
      return;
    }
    paramLayoutInflater = new JSONObject();
    RIJKanDianTabReport.a(false, paramLayoutInflater);
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("");
    paramViewGroup.append(this.a);
    paramViewGroup = paramViewGroup.toString();
    paramBundle = new StringBuilder();
    paramBundle.append(this.b);
    paramBundle.append("");
    PublicAccountReportUtils.a(null, "", "0X80094C1", "0X80094C1", 0, 0, paramViewGroup, paramBundle.toString(), "", paramLayoutInflater.toString(), false);
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append("param_article_id : ");
    paramLayoutInflater.append(this.b);
    QLog.d("ReadinjoyJumpActivity", 1, paramLayoutInflater.toString());
    if (getBaseActivity().getIntent().getBooleanExtra("daily_lock_screen_param", false)) {
      m = DailyModeConfigHandler.j();
    }
    int n = m;
    if (this.a == 0) {
      n = getBaseActivity().getIntent().getIntExtra("arg_channel_cover_id", m);
    }
    this.c = ReadInJoyLogicEngine.a().b(n, this.b);
    if (this.c == null)
    {
      ThreadManager.getUIHandler().postDelayed(this.i, 60000L);
      ReadInJoyLogicEngineEventDispatcher.a().a(this.j);
    }
    RIJDtReportHelper.a.a(getBaseActivity());
  }
  
  protected int getContentLayoutId()
  {
    return 2131626269;
  }
  
  public boolean onBackEvent()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    JSONObject localJSONObject = new JSONObject();
    RIJKanDianTabReport.a(false, localJSONObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("");
    PublicAccountReportUtils.a(null, "", "0X80094C2", "0X80094C2", 0, 0, localStringBuilder.toString(), (String)localObject, "", localJSONObject.toString(), false);
    this.e = true;
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.j);
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
    if (this.e)
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(this.j);
      getBaseActivity().finish();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStop, needFinfish : ");
    localStringBuilder.append(this.e);
    QLog.d("ReadinjoyJumpActivity", 2, localStringBuilder.toString());
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.c != null) && (!this.f)) {
      ThreadManager.getSubThreadHandler().post(new ReadinjoyJumpActivity.3(this));
    }
    if ((!paramBoolean) && (this.f) && (this.e)) {
      getBaseActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.activity.ReadinjoyJumpActivity
 * JD-Core Version:    0.7.0.1
 */