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
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.detail.api.IReadInJoyArticleDetailActivity;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.qroute.QRoute;
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
  protected int a;
  protected long a;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  public volatile AppInterface a;
  public BrowserAppInterface a;
  public Object a;
  protected String a;
  boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private int jdField_b_of_type_Int;
  protected long b;
  protected String b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  protected String c;
  private boolean jdField_c_of_type_Boolean = true;
  private long jdField_d_of_type_Long = 0L;
  protected String d;
  private boolean jdField_d_of_type_Boolean = false;
  private long e;
  protected String e;
  
  public ReadInJoyArticleDetailActivity()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.mFragmentClass = ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.class;
  }
  
  private RIJTransMergeKanDianReport.ReportR5Builder a(long paramLong1, int paramInt1, long paramLong2, String paramString, int paramInt2)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.a();
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
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = a(this.jdField_e_of_type_Long, this.jdField_c_of_type_Int, this.jdField_b_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append((paramLong2 - paramLong1) / 1000L);
    localReportR5Builder.addStringNotThrow("read_duration", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramLong1 / 1000L);
    localReportR5Builder.addStringNotThrow("read_begin_timestamp", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramLong2 / 1000L);
    localReportR5Builder.addStringNotThrow("read_end_timestamp", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[reportReadArticleDuration], r5 = ");
    ((StringBuilder)localObject).append(localReportR5Builder.build());
    QLog.i("ReadInJoyArticleDetail", 1, ((StringBuilder)localObject).toString());
    localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    ((IPublicAccountReportUtils)localObject).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009781", "0X8009781", 0, 0, localStringBuilder.toString(), "", "", localReportR5Builder.build(), false);
  }
  
  private void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = a(this.jdField_e_of_type_Long, this.jdField_c_of_type_Int, this.jdField_b_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[reportArticleExposure], r5 = ");
    ((StringBuilder)localObject).append(localReportR5Builder);
    QLog.i("ReadInJoyArticleDetail", 1, ((StringBuilder)localObject).toString());
    localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    ((IPublicAccountReportUtils)localObject).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8005899", "0X8005899", 0, 0, localStringBuilder.toString(), "", "", localReportR5Builder.build(), false);
  }
  
  private void d()
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
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_JavaLangString, new ReadInJoyArticleDetailActivity.4(this));
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
    return paramString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString);
  }
  
  public byte[] a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder;
      if (this.jdField_a_of_type_ArrayOfByte == null)
      {
        boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
        if (!bool)
        {
          try
          {
            this.jdField_a_of_type_JavaLangObject.wait(500L);
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
          if (this.jdField_a_of_type_ArrayOfByte == null) {
            this.jdField_a_of_type_JavaLangString = null;
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
      return this.jdField_a_of_type_ArrayOfByte;
    }
  }
  
  @TargetApi(14)
  public void b()
  {
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if ((localWebViewFragment instanceof ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment))
    {
      ((ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment)localWebViewFragment).a();
      return;
    }
    QLog.e("ReadInJoyArticleDetail", 1, "setWebViewVisibility error curFragment error");
  }
  
  public void c()
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
        if ((!SystemUtil.b()) && (!SystemUtil.d()))
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
          if ((!SystemUtil.b()) && (!SystemUtil.d()))
          {
            this.mSystemBarComp.setStatusBarColor(-7829368);
            return;
          }
          this.mSystemBarComp.setStatusBarColor(-7829368);
          this.mSystemBarComp.setStatusBarDarkMode(true);
          return;
        }
        if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
        {
          a(true);
          this.mSystemBarComp.setStatusBarColor(-1);
          return;
        }
        if (!SystemUtil.d())
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
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof BrowserAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    ThreadManager.getSubThreadHandler().post(new ReadInJoyArticleDetailActivity.1(this));
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ThreadManager.getSubThreadHandler().post(new ReadInJoyArticleDetailActivity.3(this));
    TroopMemberApiClient localTroopMemberApiClient = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    if (localTroopMemberApiClient != null) {
      localTroopMemberApiClient.b();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    long l = this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    if ((l > 0L) && (this.jdField_b_of_type_Long > 0L))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("start to report article read info:");
        ((StringBuilder)localObject).append(RIJTransMergeKanDianReport.a(this.jdField_e_of_type_JavaLangString, this.jdField_e_of_type_Long, 0));
        QLog.d("ReadInJoyArticleDetail", 2, ((StringBuilder)localObject).toString());
      }
      if (ReadinjoyReportUtils.a(this.jdField_a_of_type_Int)) {
        localObject = "0X8009359";
      } else {
        localObject = "0X80066FB";
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, Long.toString(l / 1000L), Long.toString(this.jdField_b_of_type_Long), Integer.toString(this.jdField_c_of_type_Int), RIJTransMergeKanDianReport.a(this.jdField_e_of_type_JavaLangString, this.jdField_e_of_type_Long, 0), false);
    }
    Object localObject = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = this.jdField_b_of_type_Long;
    localReportInfo.mChannelId = this.jdField_a_of_type_Int;
    localReportInfo.mAlgorithmId = ((int)this.jdField_e_of_type_Long);
    localReportInfo.mStrategyId = this.jdField_c_of_type_Int;
    localReportInfo.mOperation = 9;
    localReportInfo.mReadTimeLength = ((int)(l / 1000L));
    localReportInfo.mInnerId = this.jdField_e_of_type_JavaLangString;
    ((List)localObject).add(localReportInfo);
    ThreadManager.getSubThreadHandler().post(new ReadInJoyArticleDetailActivity.2(this, (List)localObject));
    localObject = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    if (localObject != null) {
      ((TroopMemberApiClient)localObject).i();
    }
    a(this.jdField_d_of_type_Boolean, this.jdField_c_of_type_Long, this.jdField_d_of_type_Long);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    c();
    d();
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
    this.jdField_b_of_type_JavaLangString = localBundle.getString("url");
    boolean bool = false;
    this.jdField_b_of_type_Boolean = localBundle.getBoolean("ip_connect", false);
    this.jdField_a_of_type_JavaLangString = localBundle.getString("read_in_joy_from_cache");
    Object localObject = PreloadManager.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_c_of_type_JavaLangString = localBundle.getString("preload_iamge_url");
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("from_native", false);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(this.jdField_a_of_type_JavaLangString)))
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
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      QLog.d("ReadInJoyArticleDetail", 2, "initModel url empty");
      return;
    }
    this.jdField_d_of_type_JavaLangString = localBundle.getString("subscribename");
    if (this.jdField_d_of_type_JavaLangString == null) {
      this.jdField_d_of_type_JavaLangString = "";
    }
    paramBundle = String.valueOf(53);
    localObject = localBundle.getString("from");
    if (localObject != null) {
      paramBundle = (Bundle)localObject;
    }
    this.jdField_b_of_type_Int = Integer.valueOf(paramBundle).intValue();
    this.jdField_b_of_type_Long = localBundle.getLong("articleid", -1L);
    this.jdField_e_of_type_JavaLangString = localBundle.getString("row_key", "");
    this.jdField_a_of_type_Int = localBundle.getInt("channelid", -1);
    this.jdField_c_of_type_Int = localBundle.getInt("strategyid", -1);
    this.jdField_e_of_type_Long = localBundle.getLong("algorithmid", -1L);
    this.jdField_a_of_type_Long = localBundle.getLong("recommendSeq", -1L);
    if (localBundle.getInt("article_source", 0) == 1) {
      bool = true;
    }
    this.jdField_d_of_type_Boolean = bool;
    if (!localIntent.hasExtra("big_brother_source_key")) {
      localIntent.putExtra("big_brother_source_key", RIJJumpUtils.a(this.jdField_a_of_type_Int));
    }
    b(this.jdField_d_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity
 * JD-Core Version:    0.7.0.1
 */