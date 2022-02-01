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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
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
  private static int G = 1;
  private static int H = 2;
  private View A;
  private View B;
  private View C;
  private int D;
  private long E = 9223372036854775807L;
  private boolean F = false;
  private int I = G;
  private Handler J = new Handler(Looper.getMainLooper());
  private Runnable K = null;
  private boolean L = false;
  ReadInjoySlideAnimLayout a;
  ReadInJoyXListView b;
  ValueAnimator c;
  ValueAnimator d;
  boolean e;
  boolean f;
  int g;
  int h;
  int i;
  long j = -1L;
  public boolean k = false;
  public ViewTreeObserver.OnGlobalLayoutListener l;
  String m;
  String n;
  int o;
  ReadInJoySkinSlideDownView p;
  boolean q;
  int r;
  Runnable s = new SlideActiveAnimController.8(this);
  SkinPullRefreshHeader t;
  boolean u;
  private int v = 0;
  private Activity w;
  private int x;
  private int y;
  private View z;
  
  public SlideActiveAnimController(int paramInt, Activity paramActivity, ReadInjoySlideAnimLayout paramReadInjoySlideAnimLayout, ReadInJoyXListView paramReadInJoyXListView, View paramView1, View paramView2, Runnable paramRunnable)
  {
    this.x = paramInt;
    this.w = paramActivity;
    this.b = paramReadInJoyXListView;
    this.b.a(new SlideActiveAnimController.1(this));
    this.C = paramActivity.findViewById(2131449311);
    this.z = paramActivity.findViewById(2131446342);
    this.z = paramView1;
    this.A = paramView2;
    this.B = paramActivity.findViewById(2131441430);
    this.a = paramReadInjoySlideAnimLayout;
    this.a.setVisibility(4);
    this.g = paramActivity.getResources().getDimensionPixelSize(2131299643);
    this.i = (this.g * 3);
    this.l = new SlideActiveAnimController.2(this, paramRunnable);
    this.a.getViewTreeObserver().addOnGlobalLayoutListener(this.l);
  }
  
  private void A()
  {
    this.y = 0;
    this.b.springBackOverScrollHeaderView();
    this.b.setTranslationY(0.0F);
    if (z()) {
      q();
    }
  }
  
  private void B()
  {
    F();
    this.e = false;
    this.f = false;
    v();
    C();
    View localView = this.B;
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = this.A;
    if (localView != null)
    {
      localView.setVisibility(0);
      this.A.setTranslationY(0.0F);
    }
    localView = this.C;
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
  
  private void C()
  {
    int i1 = this.a.getHeight();
    this.a.b.setTranslationY(-i1);
    this.a.setVisibility(4);
  }
  
  private boolean D()
  {
    return RefreshRes.g() == 1;
  }
  
  private boolean E()
  {
    return true;
  }
  
  private void F()
  {
    long l1 = System.currentTimeMillis() - this.E;
    this.E = 9223372036854775807L;
    if (l1 > 0L) {
      try
      {
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800A1A6", "0X800A1A6", 0, 0, RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"), "", "", new RIJTransMergeKanDianReport.ReportR5Builder().addInt("duration", (int)l1).build(), false);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject1 = this.w;
    Object localObject2;
    if ((localObject1 instanceof BaseActivity))
    {
      localObject2 = (BaseActivity)localObject1;
      SharedPreUtils.bz((Context)localObject1, ((BaseActivity)localObject2).getCurrentAccountUin());
      localObject2 = ((ReadInJoyRefreshManager)((BaseActivity)localObject2).app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER)).c();
      localObject1 = new RIJTransMergeKanDianReport.ReportR5Builder();
    }
    for (;;)
    {
      try
      {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).addFolderStatus().addTime().addChannelId(paramInt).addKandianMode().addKandianModeNew().addTabSource().addSessionId().addSkinId((String)localObject2).addSkinVoice(0).addRefreshCategory(2).addAntiCheat();
        boolean bool = TextUtils.isEmpty(paramString);
        int i1 = 1;
        if (!bool) {
          break label195;
        }
        paramInt = 0;
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).addString("image_jump", String.valueOf(paramInt));
        if (!paramBoolean) {
          break label200;
        }
        paramInt = i1;
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).addInt("ad_page", paramInt);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800969B", "0X800969B", 0, 0, RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"), "", "", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).build(), false);
      return;
      label195:
      paramInt = 1;
      continue;
      label200:
      paramInt = 0;
    }
  }
  
  public static void a(View paramView)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  private void a(boolean paramBoolean)
  {
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = this.a;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 4;
    }
    localReadInjoySlideAnimLayout.setVisibility(i1);
    this.a.b.setTranslationY(-this.a.getHeight());
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
      this.p = null;
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = (QQAppInterface)((BaseActivity)this.w).getAppInterface();
    this.p = new ReadInJoySkinSlideDownView(this.x, this.w, (QQAppInterface)localObject, paramString1, paramString2, paramInt, new SlideActiveAnimController.3(this), null, new SlideActiveAnimController.4(this));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("makeAndAddPosterView current state id = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(",rootPath = ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(",manager = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("SlideActiveAnimController", 1, ((StringBuilder)localObject).toString());
    this.a.setContentView(this.p);
  }
  
  private void n()
  {
    if (this.a.getVisibility() != 0)
    {
      int i1 = this.a.getHeight();
      this.a.b.setTranslationY(-i1);
    }
  }
  
  private void o()
  {
    View localView = this.B;
    if (localView != null) {
      localView.setVisibility(4);
    }
    this.b.smoothScrollBy(0, 0);
    p();
    this.a.setMessage(false, "");
    this.a.setVisibility(0);
    localView = this.A;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.C;
    if (localView != null) {
      localView.setVisibility(8);
    }
    a(true);
  }
  
  private void p()
  {
    this.a.setDisableContentTouch(true);
    this.a.setEnabled(false);
    this.z.setEnabled(false);
  }
  
  private void q()
  {
    this.a.setDisableContentTouch(false);
    this.a.setEnabled(true);
    this.z.setEnabled(true);
  }
  
  private void r()
  {
    float f1 = this.a.b.getTranslationY();
    ValueAnimator localValueAnimator = this.c;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.c.cancel();
    }
    this.c = ValueAnimator.ofFloat(new float[] { 0.0F, f1 });
    this.c.addUpdateListener(new SlideActiveAnimController.5(this, f1));
    this.c.setDuration(300L);
    this.c.addListener(this);
    this.c.start();
  }
  
  private void s()
  {
    if (this.k)
    {
      if (LiuHaiUtils.b(this.w)) {
        return;
      }
      Object localObject = this.w.getWindow();
      this.r = ((Window)localObject).getAttributes().flags;
      ((Window)localObject).setFlags(1024, 1024);
      localObject = this.w;
      if (((localObject instanceof BaseActivity)) && (((BaseActivity)localObject).mSystemBarComp != null)) {
        ((BaseActivity)this.w).mSystemBarComp.setStatusBarVisible(2, 0);
      }
    }
  }
  
  private void t()
  {
    if (this.k)
    {
      if (LiuHaiUtils.b(this.w)) {
        return;
      }
      Object localObject = this.w.getWindow();
      ((Window)localObject).clearFlags(1024);
      ((Window)localObject).addFlags(this.r);
      localObject = this.w;
      if (((localObject instanceof BaseActivity)) && (((BaseActivity)localObject).mSystemBarComp != null)) {
        ((BaseActivity)this.w).mSystemBarComp.setStatusBarVisible(0, 0);
      }
    }
  }
  
  private void u()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning()) && (this.F)) {
      return;
    }
    if (this.I == H) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim enter");
    }
    if (this.D == 0)
    {
      this.D = this.z.getHeight();
      if (this.D == 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("hideTitleViewAnim return3 : mOriginHeadHeight=");
          ((StringBuilder)localObject).append(this.D);
          QLog.i("SlideActiveAnimController", 1, ((StringBuilder)localObject).toString());
        }
        return;
      }
    }
    this.F = true;
    this.J.postDelayed(this.s, 500L);
    this.d = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.d.addUpdateListener(new SlideActiveAnimController.6(this));
    this.d.addListener(new SlideActiveAnimController.7(this));
    this.d.setDuration(500L);
    this.d.start();
    if (QLog.isColorLevel()) {
      QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim mHeadAnimator start");
    }
  }
  
  private void v()
  {
    if (!this.e)
    {
      if (this.f) {
        return;
      }
      ValueAnimator localValueAnimator = this.d;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
        this.d.cancel();
      }
      this.J.removeCallbacks(this.s);
      int i1 = this.I;
      int i2 = G;
      if (i1 == i2) {
        return;
      }
      this.F = false;
      this.I = i2;
      this.z.setTranslationY(0.0F);
      this.z.setVisibility(0);
      this.z.setAlpha(1.0F);
      t();
    }
  }
  
  private void w()
  {
    if (this.j == -1L) {
      this.j = System.currentTimeMillis();
    }
  }
  
  private void x()
  {
    this.j = -1L;
  }
  
  private boolean y()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.j;
    return (l2 != -1L) && (l1 - l2 >= 300L);
  }
  
  private boolean z()
  {
    return this.p != null;
  }
  
  public void a()
  {
    n();
    this.D = this.z.getHeight();
    this.h = (AIOUtils.b(210.0F, this.w.getResources()) - this.D);
  }
  
  public void a(SkinPullRefreshHeader paramSkinPullRefreshHeader)
  {
    this.L = true;
    this.y = 0;
    v();
  }
  
  public void a(SkinPullRefreshHeader paramSkinPullRefreshHeader, int paramInt1, int paramInt2)
  {
    this.y = paramInt1;
    this.t = paramSkinPullRefreshHeader;
    if ((!this.e) && (!this.f) && (!this.u))
    {
      if (this.L) {
        return;
      }
      if ((D()) && (!z())) {
        return;
      }
      if (paramInt1 >= this.h)
      {
        if (D())
        {
          paramSkinPullRefreshHeader.a(true, HardCodeUtil.a(2131911597));
          this.a.setMessage(true, HardCodeUtil.a(2131911594));
          w();
          this.p.c();
        }
        u();
        return;
      }
      paramInt2 = this.g;
      if (paramInt1 >= paramInt2)
      {
        if (paramInt1 >= this.D - paramInt2) {
          u();
        }
        if (D())
        {
          paramSkinPullRefreshHeader.a(true, HardCodeUtil.a(2131911596));
          this.a.setMessage(true, HardCodeUtil.a(2131911595));
          this.p.b();
        }
      }
      else
      {
        if (D())
        {
          this.a.setMessage(false, "");
          this.a.setVisibility(4);
          paramSkinPullRefreshHeader.a(false, "");
        }
        v();
        x();
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (!D()) {
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
    localStringBuilder.append(this.p);
    QLog.i("SlideActiveAnimController", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setGuideAttrs current state id = ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(",rootPath = ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(",manager = ");
    localStringBuilder.append(this.o);
    QLog.i("SlideActiveAnimController", 1, localStringBuilder.toString());
    if (this.p == null)
    {
      b(paramString1, paramString2, paramInt);
    }
    else if ((!paramString1.equals(this.m)) || (!paramString2.equals(this.n)) || (paramInt != this.o))
    {
      this.p.a();
      this.p = null;
      b(paramString1, paramString2, paramInt);
    }
    this.m = paramString1;
    this.n = paramString2;
    this.o = paramInt;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((D()) && (!z())) {
      return false;
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 2) {
        return false;
      }
    }
    else
    {
      if (this.e) {
        break label90;
      }
      if (this.f) {
        return true;
      }
      boolean bool;
      if (this.b.getTouchMode() == 6) {
        bool = true;
      } else {
        bool = false;
      }
      this.u = bool;
    }
    if (!this.e) {
      return this.f;
    }
    label90:
    return true;
  }
  
  public void b()
  {
    this.e = true;
    this.f = false;
    o();
    this.a.post(this);
  }
  
  public boolean c()
  {
    if (!this.e)
    {
      if (this.f) {
        return true;
      }
      if ((D()) && (!z())) {
        return false;
      }
      if ((D()) && (this.y >= this.h) && (y()))
      {
        this.b.isTouchHolding = false;
        b();
        this.t.a(false, "");
        return true;
      }
      if (this.I == H)
      {
        v();
      }
      else
      {
        localObject = this.d;
        if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
        {
          this.d.cancel();
          v();
        }
      }
      Object localObject = this.t;
      if (localObject != null) {
        ((SkinPullRefreshHeader)localObject).a(false, "");
      }
      return false;
    }
    return true;
  }
  
  public void d()
  {
    this.L = false;
    this.u = false;
    this.y = 0;
  }
  
  public void e()
  {
    this.q = false;
    Object localObject = this.K;
    if (localObject != null)
    {
      this.J.removeCallbacks((Runnable)localObject);
      this.K.run();
      this.K = null;
    }
    A();
    if (!this.f)
    {
      B();
      return;
    }
    q();
    localObject = this.p;
    if (localObject != null) {
      ((ReadInJoySkinSlideDownView)localObject).c();
    }
  }
  
  public void f()
  {
    if (!this.q) {
      F();
    }
    this.L = false;
    ReadInJoySkinSlideDownView localReadInJoySkinSlideDownView = this.p;
    if (localReadInJoySkinSlideDownView != null) {
      localReadInJoySkinSlideDownView.b();
    }
  }
  
  public void g()
  {
    Object localObject = this.K;
    if (localObject != null)
    {
      this.J.removeCallbacks((Runnable)localObject);
      this.K = null;
    }
    localObject = this.p;
    if (localObject != null) {
      ((ReadInJoySkinSlideDownView)localObject).a();
    }
    k();
  }
  
  public boolean h()
  {
    return (D()) || (E());
  }
  
  public void i()
  {
    this.m = null;
    this.n = null;
    this.o = -1;
    j();
    A();
    B();
  }
  
  public void j()
  {
    if (z())
    {
      this.p.a();
      this.p = null;
      this.a.a();
    }
  }
  
  public void k()
  {
    if (this.l == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this.l);
    } else {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this.l);
    }
    this.l = null;
    QLog.d("SlideActiveAnimController", 1, "removeOnGlobalLayoutListener");
  }
  
  public boolean l()
  {
    if (this.e) {
      return true;
    }
    if (this.f)
    {
      B();
      return true;
    }
    return false;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.e = false;
    A();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.e = false;
    this.E = System.currentTimeMillis();
    A();
    if (z())
    {
      paramAnimator = ReadInJoyRefreshManager.b(this.w, 0);
      int i1 = this.x;
      Object localObject = this.p.getJumpUrl();
      boolean bool;
      if ((paramAnimator != null) && (paramAnimator.isAD)) {
        bool = true;
      } else {
        bool = false;
      }
      a(i1, (String)localObject, bool);
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
    this.f = true;
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
  
  public void run()
  {
    this.f = true;
    r();
    u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.SlideActiveAnimController
 * JD-Core Version:    0.7.0.1
 */