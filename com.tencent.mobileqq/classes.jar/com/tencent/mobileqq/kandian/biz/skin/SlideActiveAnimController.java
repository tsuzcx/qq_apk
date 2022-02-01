package com.tencent.mobileqq.kandian.biz.skin;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInjoySlideAnimLayout;
import com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.SkinPullRefreshHeader;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class SlideActiveAnimController
  extends D8SafeAnimatorListener
  implements Runnable
{
  private static int j = 1;
  private static int k = 2;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = -1L;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  public ViewTreeObserver.OnGlobalLayoutListener a;
  ReadInjoySlideAnimLayout jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout;
  SkinPullRefreshHeader jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshSkinPullRefreshHeader;
  ReadInJoyXListView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView;
  ReadInJoySkinSlideDownView jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView;
  Runnable jdField_a_of_type_JavaLangRunnable = new SlideActiveAnimController.8(this);
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 9223372036854775807L;
  ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private View jdField_b_of_type_AndroidViewView;
  private Runnable jdField_b_of_type_JavaLangRunnable = null;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  public boolean c;
  int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = false;
  private int h;
  private int i;
  private int l = j;
  
  public SlideActiveAnimController(int paramInt, Activity paramActivity, ReadInjoySlideAnimLayout paramReadInjoySlideAnimLayout, ReadInJoyXListView paramReadInJoyXListView, View paramView1, View paramView2, Runnable paramRunnable)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_g_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView = paramReadInJoyXListView;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.a(new SlideActiveAnimController.1(this));
    this.jdField_d_of_type_AndroidViewView = paramActivity.findViewById(2131380365);
    this.jdField_a_of_type_AndroidViewView = paramActivity.findViewById(2131377865);
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_c_of_type_AndroidViewView = paramActivity.findViewById(2131373756);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout = paramReadInjoySlideAnimLayout;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.setVisibility(4);
    this.jdField_a_of_type_Int = paramActivity.getResources().getDimensionPixelSize(2131298921);
    this.jdField_c_of_type_Int = (this.jdField_a_of_type_Int * 3);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new SlideActiveAnimController.2(this, paramRunnable);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity;
    Object localObject2;
    if ((localObject1 instanceof BaseActivity))
    {
      localObject2 = (BaseActivity)localObject1;
      SharedPreUtils.p((Context)localObject1, ((BaseActivity)localObject2).getCurrentAccountUin());
      localObject2 = ((ReadInJoyRefreshManager)((BaseActivity)localObject2).app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER)).a();
      localObject1 = new RIJTransMergeKanDianReport.ReportR5Builder();
    }
    for (;;)
    {
      try
      {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).addFolderStatus().addTime().addChannelId(paramInt).addKandianMode().addKandianModeNew().addTabSource().addSessionId().addSkinId((String)localObject2).addSkinVoice(0).addRefreshCategory(2).addAntiCheat();
        boolean bool = TextUtils.isEmpty(paramString);
        int m = 1;
        if (!bool) {
          break label210;
        }
        paramInt = 0;
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).addString("image_jump", String.valueOf(paramInt));
        if (!paramBoolean) {
          break label215;
        }
        paramInt = m;
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).addInt("ad_page", paramInt);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800969B", "0X800969B", 0, 0, RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"), "", "", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).build(), false);
      return;
      label210:
      paramInt = 1;
      continue;
      label215:
      paramInt = 0;
    }
  }
  
  public static void a(View paramView)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  private void a(boolean paramBoolean)
  {
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout;
    int m;
    if (paramBoolean) {
      m = 0;
    } else {
      m = 4;
    }
    localReadInjoySlideAnimLayout.setVisibility(m);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.a.setTranslationY(-this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.getHeight());
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    if (paramString == null) {
      return false;
    }
    paramString = new File(paramString);
    boolean bool1 = bool2;
    if (paramString.exists())
    {
      bool1 = bool2;
      if (paramString.isDirectory()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(String paramString1, String paramString2, int paramInt)
  {
    if (!a(paramString2))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView = null;
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = (QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView = new ReadInJoySkinSlideDownView(this.jdField_g_of_type_Int, this.jdField_a_of_type_AndroidAppActivity, (QQAppInterface)localObject, paramString1, paramString2, paramInt, new SlideActiveAnimController.3(this), null, new SlideActiveAnimController.4(this));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("makeAndAddPosterView current state id = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(",rootPath = ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(",manager = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("SlideActiveAnimController", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.setContentView(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView);
  }
  
  private boolean d()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    return (l2 != -1L) && (l1 - l2 >= 300L);
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView != null;
  }
  
  private boolean f()
  {
    return RefreshRes.b() == 1;
  }
  
  private boolean g()
  {
    return true;
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.getVisibility() != 0)
    {
      int m = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.getHeight();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.a.setTranslationY(-m);
    }
  }
  
  private void k()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.smoothScrollBy(0, 0);
    l();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.setMessage(false, "");
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.setVisibility(0);
    localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.jdField_d_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
    a(true);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.setDisableContentTouch(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.setEnabled(false);
    this.jdField_a_of_type_AndroidViewView.setEnabled(false);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.setDisableContentTouch(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
  }
  
  private void n()
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.a.getTranslationY();
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, f1 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new SlideActiveAnimController.5(this, f1));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void o()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity)) {
        return;
      }
      Object localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
      this.jdField_e_of_type_Int = ((Window)localObject).getAttributes().flags;
      ((Window)localObject).setFlags(1024, 1024);
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      if (((localObject instanceof BaseActivity)) && (((BaseActivity)localObject).mSystemBarComp != null)) {
        ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusBarVisible(2, 0);
      }
    }
  }
  
  private void p()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity)) {
        return;
      }
      Object localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
      ((Window)localObject).clearFlags(1024);
      ((Window)localObject).addFlags(this.jdField_e_of_type_Int);
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      if (((localObject instanceof BaseActivity)) && (((BaseActivity)localObject).mSystemBarComp != null)) {
        ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusBarVisible(0, 0);
      }
    }
  }
  
  private void q()
  {
    Object localObject = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning()) && (this.jdField_f_of_type_Boolean)) {
      return;
    }
    if (this.l == k) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim enter");
    }
    if (this.i == 0)
    {
      this.i = this.jdField_a_of_type_AndroidViewView.getHeight();
      if (this.i == 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("hideTitleViewAnim return3 : mOriginHeadHeight=");
          ((StringBuilder)localObject).append(this.i);
          QLog.i("SlideActiveAnimController", 1, ((StringBuilder)localObject).toString());
        }
        return;
      }
    }
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new SlideActiveAnimController.6(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new SlideActiveAnimController.7(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(500L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    if (QLog.isColorLevel()) {
      QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim mHeadAnimator start");
    }
  }
  
  private void r()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
      ValueAnimator localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
        this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      int m = this.l;
      int n = j;
      if (m == n) {
        return;
      }
      this.jdField_f_of_type_Boolean = false;
      this.l = n;
      this.jdField_a_of_type_AndroidViewView.setTranslationY(0.0F);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
      p();
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_Long == -1L) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  private void u()
  {
    this.h = 0;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.springBackOverScrollHeaderView();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setTranslationY(0.0F);
    if (e()) {
      m();
    }
  }
  
  private void v()
  {
    x();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    r();
    w();
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null)
    {
      localView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setTranslationY(0.0F);
    }
    localView = this.jdField_d_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
  
  private void w()
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.getHeight();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.a.setTranslationY(-m);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.setVisibility(4);
  }
  
  private void x()
  {
    long l1 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
    this.jdField_b_of_type_Long = 9223372036854775807L;
    if (l1 > 0L) {
      try
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800A1A6", "0X800A1A6", 0, 0, RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"), "", "", new RIJTransMergeKanDianReport.ReportR5Builder().addInt("duration", (int)l1).build(), false);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    j();
    this.i = this.jdField_a_of_type_AndroidViewView.getHeight();
    this.jdField_b_of_type_Int = (AIOUtils.b(210.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - this.i);
  }
  
  public void a(SkinPullRefreshHeader paramSkinPullRefreshHeader)
  {
    this.jdField_g_of_type_Boolean = true;
    this.h = 0;
    r();
  }
  
  public void a(SkinPullRefreshHeader paramSkinPullRefreshHeader, int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshSkinPullRefreshHeader = paramSkinPullRefreshHeader;
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (!this.jdField_e_of_type_Boolean))
    {
      if (this.jdField_g_of_type_Boolean) {
        return;
      }
      if ((f()) && (!e())) {
        return;
      }
      if (paramInt1 >= this.jdField_b_of_type_Int)
      {
        if (f())
        {
          paramSkinPullRefreshHeader.a(true, HardCodeUtil.a(2131714066));
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.setMessage(true, HardCodeUtil.a(2131714063));
          s();
          this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView.c();
        }
        q();
        return;
      }
      paramInt2 = this.jdField_a_of_type_Int;
      if (paramInt1 >= paramInt2)
      {
        if (paramInt1 >= this.i - paramInt2) {
          q();
        }
        if (f())
        {
          paramSkinPullRefreshHeader.a(true, HardCodeUtil.a(2131714065));
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.setMessage(true, HardCodeUtil.a(2131714064));
          this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView.b();
        }
      }
      else
      {
        if (f())
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.setMessage(false, "");
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.setVisibility(4);
          paramSkinPullRefreshHeader.a(false, "");
        }
        r();
        t();
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (!f()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setGuideAttrs id = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",rootPath = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",manager = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",guideView = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView);
    QLog.i("SlideActiveAnimController", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setGuideAttrs current state id = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",rootPath = ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",manager = ");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    QLog.i("SlideActiveAnimController", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView == null)
    {
      b(paramString1, paramString2, paramInt);
    }
    else if ((!paramString1.equals(this.jdField_a_of_type_JavaLangString)) || (!paramString2.equals(this.jdField_b_of_type_JavaLangString)) || (paramInt != this.jdField_d_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView = null;
      b(paramString1, paramString2, paramInt);
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        return true;
      }
      if ((f()) && (!e())) {
        return false;
      }
      if ((f()) && (this.h >= this.jdField_b_of_type_Int) && (d()))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.isTouchHolding = false;
        b();
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshSkinPullRefreshHeader.a(false, "");
        return true;
      }
      if (this.l == k)
      {
        r();
      }
      else
      {
        localObject = this.jdField_b_of_type_AndroidAnimationValueAnimator;
        if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
        {
          this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
          r();
        }
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshSkinPullRefreshHeader;
      if (localObject != null) {
        ((SkinPullRefreshHeader)localObject).a(false, "");
      }
      return false;
    }
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((f()) && (!e())) {
      return false;
    }
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if (m != 2) {
        return false;
      }
    }
    else
    {
      if (this.jdField_a_of_type_Boolean) {
        break label90;
      }
      if (this.jdField_b_of_type_Boolean) {
        return true;
      }
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.a() == 6) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_e_of_type_Boolean = bool;
    }
    if (!this.jdField_a_of_type_Boolean) {
      return this.jdField_b_of_type_Boolean;
    }
    label90:
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    k();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.post(this);
  }
  
  public boolean b()
  {
    return (f()) || (g());
  }
  
  public void c()
  {
    this.jdField_g_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.h = 0;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      v();
      return true;
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_d_of_type_Boolean = false;
    Object localObject = this.jdField_b_of_type_JavaLangRunnable;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)localObject);
      this.jdField_b_of_type_JavaLangRunnable.run();
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    u();
    if (!this.jdField_b_of_type_Boolean)
    {
      v();
      return;
    }
    m();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView;
    if (localObject != null) {
      ((ReadInJoySkinSlideDownView)localObject).c();
    }
  }
  
  public void e()
  {
    if (!this.jdField_d_of_type_Boolean) {
      x();
    }
    this.jdField_g_of_type_Boolean = false;
    ReadInJoySkinSlideDownView localReadInJoySkinSlideDownView = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView;
    if (localReadInJoySkinSlideDownView != null) {
      localReadInJoySkinSlideDownView.b();
    }
  }
  
  public void f()
  {
    Object localObject = this.jdField_b_of_type_JavaLangRunnable;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)localObject);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView;
    if (localObject != null) {
      ((ReadInJoySkinSlideDownView)localObject).a();
    }
    i();
  }
  
  public void g()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_d_of_type_Int = -1;
    h();
    u();
    v();
  }
  
  public void h()
  {
    if (e())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView = null;
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.a();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInjoySlideAnimLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
    QLog.d("SlideActiveAnimController", 1, "removeOnGlobalLayoutListener");
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_Boolean = false;
    u();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    u();
    if (e())
    {
      paramAnimator = ReadInJoyRefreshManager.b(this.jdField_a_of_type_AndroidAppActivity, 0);
      int m = this.jdField_g_of_type_Int;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinSlideDownView.a();
      boolean bool;
      if ((paramAnimator != null) && (paramAnimator.isAD)) {
        bool = true;
      } else {
        bool = false;
      }
      a(m, (String)localObject, bool);
      if ((paramAnimator != null) && (paramAnimator.isAD) && (paramAnimator.adExposureReports != null) && (paramAnimator.adExposureReports.size() > 0)) {
        try
        {
          localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
          long l1 = paramAnimator.adId.longValue();
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.trace_info.aid.set(l1);
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(paramAnimator.getUrls(paramAnimator.adExposureReports));
          GdtC2SReporter.a(0, 1, (qq_ad_get.QQAdGetRsp.AdInfo)localObject);
          return;
        }
        catch (NumberFormatException paramAnimator)
        {
          paramAnimator.printStackTrace();
        }
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
  
  public void run()
  {
    this.jdField_b_of_type_Boolean = true;
    n();
    q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.SlideActiveAnimController
 * JD-Core Version:    0.7.0.1
 */