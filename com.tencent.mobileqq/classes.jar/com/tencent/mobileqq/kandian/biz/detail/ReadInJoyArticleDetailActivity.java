package com.tencent.mobileqq.kandian.biz.detail;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.detail.api.IReadInJoyArticleDetailActivity;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ReadInJoyArticleDetailActivity
  extends QQBrowserActivity
  implements IReadInJoyArticleDetailActivity
{
  protected String a = null;
  protected String b;
  protected String c;
  protected String d;
  protected long e;
  protected long f;
  protected String g;
  protected int h;
  TroopMemberApiClient i = null;
  public Object j = new Object();
  public volatile AppInterface k;
  public BrowserAppInterface l;
  boolean m;
  private long n = 0L;
  private long o = 0L;
  private int p;
  private int q;
  private long r;
  private boolean s;
  private boolean t = true;
  private boolean u = false;
  private byte[] v = null;
  
  public ReadInJoyArticleDetailActivity()
  {
    this.mFragmentClass = ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.class;
  }
  
  private RIJTransMergeKanDianReport.ReportR5Builder a(long paramLong1, int paramInt1, long paramLong2, String paramString, int paramInt2)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong1);
    localReportR5Builder.addStringNotThrow("algorithm_id", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt1);
    localReportR5Builder.addStringNotThrow("strategy_id", localStringBuilder.toString());
    localReportR5Builder.addStringNotThrow("feeds_channel_entrance", "1");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong2);
    localReportR5Builder.addStringNotThrow("mp_article_id", localStringBuilder.toString());
    localReportR5Builder.addStringNotThrow("rowkey", paramString);
    localReportR5Builder.addStringNotThrow("channel_id", paramInt2);
    localReportR5Builder.addStringNotThrow("is_wechat", "1");
    return localReportR5Builder;
  }
  
  private void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (!paramBoolean) {
      return;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = a(this.r, this.q, this.f, this.g, this.h);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append((paramLong2 - paramLong1) / 1000L);
    localReportR5Builder.addStringNotThrow("read_duration", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong1 / 1000L);
    localReportR5Builder.addStringNotThrow("read_begin_timestamp", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong2 / 1000L);
    localReportR5Builder.addStringNotThrow("read_end_timestamp", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[reportReadArticleDuration], r5 = ");
    localStringBuilder.append(localReportR5Builder.build());
    QLog.i("ReadInJoyArticleDetail", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.f);
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8009781", "0X8009781", 0, 0, localStringBuilder.toString(), "", "", localReportR5Builder.build(), false);
  }
  
  private void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = a(this.r, this.q, this.f, this.g, this.h);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[reportArticleExposure], r5 = ");
    localStringBuilder.append(localReportR5Builder);
    QLog.i("ReadInJoyArticleDetail", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.f);
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8005899", "0X8005899", 0, 0, localStringBuilder.toString(), "", "", localReportR5Builder.build(), false);
  }
  
  private void e()
  {
    if ((getIntent() != null) && (!getIntent().getBooleanExtra("from_native", false))) {
      return;
    }
    getMainLooper();
    Looper.myQueue().addIdleHandler(new ReadInJoyArticleDetailActivity.5(this));
  }
  
  public Intent a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, ReadInJoyArticleDetailActivity.class);
    paramBundle.remove("click_time");
    paramBundle.remove("available_memory");
    return localIntent;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("请求开始时间");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("ReadInJoyArticleDetail", 2, localStringBuilder.toString());
    }
    this.i.b(this.a, new ReadInJoyArticleDetailActivity.4(this));
  }
  
  @TargetApi(23)
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public boolean a(String paramString)
  {
    return paramString.equalsIgnoreCase(this.a);
  }
  
  public byte[] b()
  {
    synchronized (this.j)
    {
      StringBuilder localStringBuilder;
      if (this.v == null)
      {
        boolean bool = TextUtils.isEmpty(this.a);
        if (!bool)
        {
          try
          {
            this.j.wait(500L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("等待结束时间时");
            localStringBuilder.append(System.currentTimeMillis());
            QLog.d("ReadInJoyArticleDetail", 2, localStringBuilder.toString());
          }
          if (this.v == null) {
            this.a = null;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("返回结果时间");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.d("ReadInJoyArticleDetail", 2, localStringBuilder.toString());
      }
      return this.v;
    }
  }
  
  @TargetApi(14)
  public void c()
  {
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if ((localWebViewFragment instanceof ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment))
    {
      ((ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment)localWebViewFragment).a();
      return;
    }
    QLog.e("ReadInJoyArticleDetail", 1, "setWebViewVisibility error curFragment error");
  }
  
  public void d()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (ThemeUtil.isInNightMode(getAppRuntime()))
      {
        if ((!SystemUtil.d()) && (!SystemUtil.g()))
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
        }
        else
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
          this.mSystemBarComp.setStatusBarDarkMode(true);
        }
        this.mSystemBarComp.init();
        if (ThemeUtil.isInNightMode(getAppRuntime()))
        {
          if ((!SystemUtil.d()) && (!SystemUtil.g()))
          {
            this.mSystemBarComp.setStatusBarColor(-7829368);
            return;
          }
          this.mSystemBarComp.setStatusBarColor(-7829368);
          this.mSystemBarComp.setStatusBarDarkMode(true);
          return;
        }
        if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
        {
          a(true);
          this.mSystemBarComp.setStatusBarColor(-1);
          return;
        }
        if (!SystemUtil.g())
        {
          this.mSystemBarComp.setStatusBarColor(-2368549);
          return;
        }
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 == 2)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005438", "0X8005438", 0, 0, "", "", "", "");
        QfavBuilder.a(this, paramIntent);
      }
    }
    else if (paramInt2 == 1) {
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    this.k = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    if ((this.k != null) && ((this.k instanceof BrowserAppInterface))) {
      this.l = ((BrowserAppInterface)this.k);
    }
    ThreadManager.getSubThreadHandler().post(new ReadInJoyArticleDetailActivity.1(this));
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ThreadManager.getSubThreadHandler().post(new ReadInJoyArticleDetailActivity.3(this));
    TroopMemberApiClient localTroopMemberApiClient = this.i;
    if (localTroopMemberApiClient != null) {
      localTroopMemberApiClient.f();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.o = System.currentTimeMillis();
    long l1 = this.o - this.n;
    if ((l1 > 0L) && (this.f > 0L))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("start to report article read info:");
        ((StringBuilder)localObject).append(RIJTransMergeKanDianReport.a(this.g, this.r, 0));
        QLog.d("ReadInJoyArticleDetail", 2, ((StringBuilder)localObject).toString());
      }
      if (ReadinjoyReportUtils.d(this.h)) {
        localObject = "0X8009359";
      } else {
        localObject = "0X80066FB";
      }
      PublicAccountReportUtils.a(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, Long.toString(l1 / 1000L), Long.toString(this.f), Integer.toString(this.q), RIJTransMergeKanDianReport.a(this.g, this.r, 0), false);
    }
    Object localObject = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = this.f;
    localReportInfo.mChannelId = this.h;
    localReportInfo.mAlgorithmId = ((int)this.r);
    localReportInfo.mStrategyId = this.q;
    localReportInfo.mOperation = 9;
    localReportInfo.mReadTimeLength = ((int)(l1 / 1000L));
    localReportInfo.mInnerId = this.g;
    ((List)localObject).add(localReportInfo);
    ThreadManager.getSubThreadHandler().post(new ReadInJoyArticleDetailActivity.2(this, (List)localObject));
    localObject = this.i;
    if (localObject != null) {
      ((TroopMemberApiClient)localObject).m();
    }
    a(this.u, this.n, this.o);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.n = System.currentTimeMillis();
    d();
    e();
  }
  
  @TargetApi(12)
  protected void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    Bundle localBundle = localIntent.getExtras();
    if (localBundle == null)
    {
      finish();
      return;
    }
    this.b = localBundle.getString("url");
    boolean bool = false;
    this.s = localBundle.getBoolean("ip_connect", false);
    this.a = localBundle.getString("read_in_joy_from_cache");
    Object localObject = PreloadManager.d(this.b);
    this.c = localBundle.getString("preload_iamge_url");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate,url=");
    localStringBuilder.append(this.b);
    QLog.d("ReadInJoyArticleDetail", 1, localStringBuilder.toString());
    this.m = localBundle.getBoolean("from_native", false);
    if (this.m) {
      this.t = false;
    }
    if (this.i == null)
    {
      this.i = TroopMemberApiClient.a();
      this.i.e();
    }
    if ((!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(this.a)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("在onCreate中执行操作的时间时");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("ReadInJoyArticleDetail", 2, ((StringBuilder)localObject).toString());
      }
      a();
    }
    localIntent.putExtra("web_color_note_type", 1);
    super.onCreate(paramBundle);
    if (this.b == null)
    {
      QLog.d("ReadInJoyArticleDetail", 2, "initModel url empty");
      return;
    }
    this.d = localBundle.getString("subscribename");
    if (this.d == null) {
      this.d = "";
    }
    paramBundle = String.valueOf(53);
    localObject = localBundle.getString("from");
    if (localObject != null) {
      paramBundle = (Bundle)localObject;
    }
    this.p = Integer.valueOf(paramBundle).intValue();
    this.f = localBundle.getLong("articleid", -1L);
    this.g = localBundle.getString("row_key", "");
    this.h = localBundle.getInt("channelid", -1);
    this.q = localBundle.getInt("strategyid", -1);
    this.r = localBundle.getLong("algorithmid", -1L);
    this.e = localBundle.getLong("recommendSeq", -1L);
    if (localBundle.getInt("article_source", 0) == 1) {
      bool = true;
    }
    this.u = bool;
    if (!localIntent.hasExtra("big_brother_source_key")) {
      localIntent.putExtra("big_brother_source_key", RIJJumpUtils.a(this.h));
    }
    b(this.u);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity
 * JD-Core Version:    0.7.0.1
 */