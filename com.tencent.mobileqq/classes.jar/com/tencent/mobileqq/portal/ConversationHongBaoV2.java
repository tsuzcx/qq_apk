package com.tencent.mobileqq.portal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar;
import com.tencent.mobileqq.activity.springfestival.entry.ITaskManager;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback;
import com.tencent.mobileqq.activity.springfestival.entry.helper.SpringHbHelper;
import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;
import com.tencent.mobileqq.activity.springfestival.entry.model.CommonData;
import com.tencent.mobileqq.activity.springfestival.entry.model.EntryConfigBean;
import com.tencent.mobileqq.activity.springfestival.entry.model.OnGrabActivityData;
import com.tencent.mobileqq.activity.springfestival.entry.model.OnGrabActivityData.Share;
import com.tencent.mobileqq.activity.springfestival.entry.model.PendantData;
import com.tencent.mobileqq.activity.springfestival.entry.model.PreviewEntryData;
import com.tencent.mobileqq.activity.springfestival.entry.model.RedPacketResultData;
import com.tencent.mobileqq.activity.springfestival.entry.model.UserData;
import com.tencent.mobileqq.activity.springfestival.entry.model.UserData.UserDataItem;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.HongBaoListView;
import com.tencent.widget.HongBaoListViewListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;

public class ConversationHongBaoV2
  implements Handler.Callback
{
  ImageView A;
  AtomicBoolean B = new AtomicBoolean(false);
  public Runnable C = new ConversationHongBaoV2.1(this);
  public HongBaoListViewListener D = new ConversationHongBaoV2.2(this);
  String E;
  private boolean F;
  private int G = 0;
  private int H = 0;
  private int I = 0;
  private boolean J = false;
  private OnGrabActivityData.Share K = null;
  private long L = -1L;
  private ConversationHongBaoV2.ShowSharePageTask M;
  private boolean N = false;
  private FrameLayout O;
  private ProgressViewRed P;
  private Activity Q;
  private ViewGroup R;
  private BreathEffectView S;
  private String T = null;
  private int U = 0;
  private int V = 0;
  private int W = -1;
  private Interpolator X = new AccelerateDecelerateInterpolator();
  private ValueAnimator Y = null;
  private Animator.AnimatorListener Z = null;
  public FormalView a;
  private ValueAnimator aa = null;
  private Animator.AnimatorListener ab = null;
  private boolean ac = false;
  private long ad;
  private Drawable ae;
  public PrepareView b;
  public HongBaoListView c;
  public long d = 0L;
  public int e = -1;
  public long f = -1L;
  public Handler g = new Handler(Looper.getMainLooper(), this);
  public boolean h = false;
  public int i = 0;
  public long j = 0L;
  public boolean k = true;
  public boolean l;
  public boolean m = true;
  public boolean n = VersionUtils.e();
  int o = 0;
  int p = 0;
  Conversation q;
  int r = 0;
  long s;
  CountDownTimer t = null;
  long u = 0L;
  Handler v = new Handler(ThreadManager.getFileThreadLooper(), this);
  StringBuilder w = new StringBuilder(12);
  StringBuilder x = new StringBuilder(8);
  String y = "";
  boolean z = true;
  
  public ConversationHongBaoV2(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.q = paramConversation;
    this.Q = paramConversation.P();
    this.R = paramViewGroup;
  }
  
  private boolean D()
  {
    return ((SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).c(this.q.ab.c().id).leftCountDownDuration > 3000L;
  }
  
  private void E()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.P.getLayoutParams();
    int i3 = localLayoutParams.topMargin;
    View localView = this.q.B();
    int i1 = localView.getHeight();
    int i2 = this.q.i();
    if (i2 > 0) {
      i1 = i2;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshRedProgressBarTopMargin,statusTitle.w = ");
      localStringBuilder.append(localView.getWidth());
      localStringBuilder.append(",statusTitle.h = ");
      localStringBuilder.append(localView.getHeight());
      localStringBuilder.append(",statusTitleHeightInNormalState = ");
      localStringBuilder.append(i2);
      localStringBuilder.append(",mProgressViewRed cur topMargin = ");
      localStringBuilder.append(i3);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (i1 != i3)
    {
      localLayoutParams.topMargin = i1;
      this.P.setLayoutParams(localLayoutParams);
    }
  }
  
  private void F()
  {
    QLog.d("2021_UI_ConversationHongBaoV2", 1, "clearShareData");
    this.G = 0;
    this.H = 0;
    this.I = 0;
    this.K = null;
  }
  
  private void G()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "markClickedPendantCloseBtn");
    }
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    BaseActivityData localBaseActivityData = this.q.ab.c();
    UserData.UserDataItem localUserDataItem = localSpringFestivalEntryManager.c(localBaseActivityData.id);
    localUserDataItem.hasClickCloseBtn = true;
    int i1 = 0;
    if (localBaseActivityData.pendantData != null) {
      i1 = localBaseActivityData.pendantData.closeType;
    }
    localUserDataItem.pendantCloseType = i1;
    localSpringFestivalEntryManager.b();
  }
  
  private void H()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "cleanListViewContainerBg");
    }
    if ((this.q.C() != null) && (this.q.C().getBackground() != null))
    {
      this.ae = this.q.C().getBackground();
      this.q.C().setBackgroundDrawable(null);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cleanListViewContainerBg conversationDrawable = ");
        localStringBuilder.append(this.ae);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
      }
      this.c.setContentBackground(this.ae);
    }
  }
  
  private void I()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recoverListViewContainerBg conversationDrawable = ");
      localStringBuilder.append(this.ae);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (this.ae != null)
    {
      this.q.C().setBackgroundDrawable(this.ae);
      this.c.setContentBackground(null);
    }
  }
  
  private void J()
  {
    if (this.e != 3)
    {
      this.e = 3;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showTask,mState updated to STATE_SHUA_YI_SHUA_READY, ");
        localStringBuilder.append(this.e);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
      }
      this.a.b();
      this.P.setVisibility(8);
      this.c.s();
      if (this.k)
      {
        this.S.b();
        this.c.p();
      }
      p();
      o();
      b();
      if ((!this.F) && (this.l))
      {
        e(true);
        d(true);
      }
    }
  }
  
  private void K()
  {
    if (this.q.al != null) {
      this.q.al.d();
    }
  }
  
  private void L()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "recoverListViewContainerLayoutParams");
    }
    View localView = this.q.C();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.addRule(3, 2131446351);
    localLayoutParams.topMargin = 0;
    localView.setLayoutParams(localLayoutParams);
    this.ac = false;
  }
  
  private void M()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "clearTitleAnimation");
    }
    ValueAnimator localValueAnimator = this.Y;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.Y.removeAllListeners();
    }
    localValueAnimator = this.aa;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.aa.removeAllListeners();
    }
  }
  
  private void N()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showPrepareViewAnimation mState = ");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    if ((localObject != null) && (this.e == 2))
    {
      ((PrepareView)localObject).b();
      this.g.removeMessages(1006);
      this.g.sendEmptyMessageDelayed(1006, 500L);
    }
  }
  
  private void O()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showRealPreGuide mHongBaoListView = ");
      localStringBuilder.append(this.c);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (this.c == null) {
      return;
    }
    H();
    int i1 = this.c.C;
    int i2 = this.e;
    if (i2 == 3)
    {
      i2 = AIOUtils.b(100.0F, this.Q.getResources());
      this.c.a(i1 - i2);
      return;
    }
    if ((i2 == 2) || (i2 == 5) || (i2 == 4))
    {
      N();
      this.c.a(i1);
    }
  }
  
  private void P()
  {
    if (this.e != 2)
    {
      this.e = 2;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showPrepare,mState updated to STATE_YURE, ");
        localStringBuilder.append(this.e);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
      }
      f();
      this.c.s();
      this.S.a();
      this.c.setComboListener(this.D);
      this.b.setVisibility(0);
      this.a.setVisibility(8);
      this.P.setVisibility(8);
      p();
      b();
      if ((!this.F) && (this.l))
      {
        e(false);
        d(false);
      }
      x();
    }
  }
  
  private List<PortalManager.ComboNumber> a(Set<Integer> paramSet)
  {
    if (paramSet != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramSet.iterator();
      for (;;)
      {
        paramSet = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramSet = (Integer)localIterator.next();
        PortalManager.ComboNumber localComboNumber = new PortalManager.ComboNumber();
        localComboNumber.number = paramSet.intValue();
        localArrayList.add(localComboNumber);
      }
    }
    paramSet = null;
    return paramSet;
  }
  
  private void a(View paramView1, View paramView2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "initTitleAnim");
    }
    this.W = (((RelativeLayout.LayoutParams)paramView2.getLayoutParams()).topMargin + paramView2.getHeight());
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.addRule(3, 0);
    paramView2.topMargin = this.W;
    paramView1.setLayoutParams(paramView2);
    this.ac = true;
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, View paramView3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doShowTitleAnim mTitleBarOffset = ");
      localStringBuilder.append(this.W);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (!this.ac) {
      a(paramView2, paramView1);
    }
    if (this.W <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.Y == null)
    {
      this.Y = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.Y.setDuration(300L);
      this.Y.setInterpolator(this.X);
      this.Y.addUpdateListener(new ConversationHongBaoV2.10(this, paramView2, paramView1, paramView3));
      this.Z = new ConversationHongBaoV2.11(this, paramView3);
    }
    this.Y.removeAllListeners();
    this.Y.cancel();
    this.Y.addListener(this.Z);
    this.Y.start();
  }
  
  @TargetApi(11)
  private void b(View paramView1, View paramView2, View paramView3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doHideTitleAnim mTitleBarOffset = ");
      localStringBuilder.append(this.W);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (!this.ac) {
      a(paramView2, paramView1);
    }
    if (this.W <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.aa == null)
    {
      this.aa = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.aa.setDuration(300L);
      this.aa.setInterpolator(this.X);
      this.aa.addUpdateListener(new ConversationHongBaoV2.12(this, paramView2, paramView1, paramView3));
      this.ab = new ConversationHongBaoV2.13(this, paramView3, paramView1);
    }
    this.aa.removeAllListeners();
    this.aa.cancel();
    this.aa.addListener(this.ab);
    this.aa.start();
  }
  
  private void c(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveActivityLeftCountDownDuration duration = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    ((SpringFestivalEntryManager)localObject).c(this.q.ab.c().id).leftCountDownDuration = paramLong;
    ((SpringFestivalEntryManager)localObject).b();
  }
  
  private void d(long paramLong)
  {
    ((SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).c(this.q.ab.c().id).leftCountDownDuration = paramLong;
  }
  
  public ARMapHongBaoListView A()
  {
    return (ARMapHongBaoListView)this.R.findViewById(2131444377);
  }
  
  public boolean B()
  {
    return A().e();
  }
  
  public void C()
  {
    A().h();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "stopNormalActivityBreath");
    }
    if (this.S == null) {
      this.S = ((BreathEffectView)this.R.findViewById(2131435107));
    }
    this.S.g();
  }
  
  void a(long paramLong)
  {
    if (this.j == paramLong) {
      return;
    }
    this.j = paramLong;
    int i2 = (int)(paramLong / 1000L);
    int i1 = i2 / 60;
    i2 %= 60;
    int i3 = (int)paramLong % 100;
    StringBuilder localStringBuilder = this.x;
    localStringBuilder.delete(0, localStringBuilder.length());
    if (i1 < 10) {
      this.x.append("0");
    }
    localStringBuilder = this.x;
    localStringBuilder.append(i1);
    localStringBuilder.append(":");
    if (i2 < 10) {
      this.x.append("0");
    }
    this.x.append(i2);
    this.x.append(".");
    if (i3 < 10) {
      this.x.append("0");
    }
    this.x.append(i3);
    localStringBuilder = this.w;
    localStringBuilder.delete(0, localStringBuilder.length());
    this.w.append(this.y);
    this.w.append(this.x);
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    Object localObject = this.q.ab.c();
    if (localObject != null) {
      paramBundle.putString("active_id", ((BaseActivityData)localObject).id);
    }
    localObject = new Intent();
    ((Intent)localObject).putExtras(paramBundle);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showNewResultActivity, data ");
      localStringBuilder.append(paramBundle);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
    QPublicTransFragmentActivity.a(paramActivity, (Intent)localObject, RedPacketShowerFragment.class);
  }
  
  public void a(BaseActivityData paramBaseActivityData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "showNormalActivityPendant");
    }
    Object localObject4 = (SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    Object localObject1 = paramBaseActivityData.pendantData;
    boolean bool = false;
    Object localObject3 = null;
    int i1;
    int i2;
    if (localObject1 != null)
    {
      localObject3 = paramBaseActivityData.pendantData.pendantImgUrl;
      localObject2 = ((SpringFestivalEntryManager)localObject4).a(paramBaseActivityData.pendantData.pendantImgUrl, "");
      localObject1 = paramBaseActivityData.pendantData.jumpUrl;
      i1 = paramBaseActivityData.pendantData.closeType;
      i2 = paramBaseActivityData.pendantData.type;
    }
    else
    {
      localObject2 = null;
      localObject1 = localObject2;
      i2 = 0;
      i1 = 0;
    }
    ARMapHongBaoListView localARMapHongBaoListView = (ARMapHongBaoListView)this.R.findViewById(2131444377);
    if (i1 != 0) {
      bool = true;
    }
    localARMapHongBaoListView.a((Bitmap)localObject2, bool);
    if ((paramBaseActivityData.pendantData != null) && (localObject2 == null)) {
      ((SpringFestivalEntryManager)localObject4).a(new ConversationHongBaoV2.17(this, (String)localObject3, localARMapHongBaoListView, (SpringFestivalEntryManager)localObject4));
    }
    Object localObject2 = (SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    localObject3 = ((ITaskManager)localObject2).a();
    if ((!((UserData)localObject3).hasClickedHolder) && (!((UserData)localObject3).hasShowedMiniApp) && (i2 == 1))
    {
      localARMapHongBaoListView.c();
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "[showNormalActivityPendant] 吊坠动画展示");
      }
    }
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("[showNormalActivityPendant] 初始化 userData.hasClickedHolder = ");
      ((StringBuilder)localObject4).append(((UserData)localObject3).hasClickedHolder);
      ((StringBuilder)localObject4).append(" userData.hasShowedMiniApp = ");
      ((StringBuilder)localObject4).append(((UserData)localObject3).hasShowedMiniApp);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject4).toString());
    }
    e(B());
    localARMapHongBaoListView.setOnPendentClickListener(new ConversationHongBaoV2.18(this, (String)localObject1, localARMapHongBaoListView, (ITaskManager)localObject2, paramBaseActivityData, i1));
    K();
  }
  
  public void a(OnGrabActivityData paramOnGrabActivityData)
  {
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    UserData.UserDataItem localUserDataItem = localSpringFestivalEntryManager.c(this.q.ab.c().id);
    long l1 = localUserDataItem.leftCountDownDuration;
    boolean bool3 = localSpringFestivalEntryManager.h();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showShuaYiShuaTask leftCountDownDuration = ");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append(",isPendantShowSwitchOn = ");
      ((StringBuilder)localObject1).append(bool3);
      ((StringBuilder)localObject1).append(",mState = ");
      ((StringBuilder)localObject1).append(this.e);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramOnGrabActivityData.id.equals(this.E)) && (this.e == 3))
    {
      if (QLog.isColorLevel())
      {
        paramOnGrabActivityData = new StringBuilder();
        paramOnGrabActivityData.append("showShuaYiShuaTask return for already STATE_SHUA_YI_SHUA_READY ,taskID = ");
        paramOnGrabActivityData.append(this.E);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, paramOnGrabActivityData.toString());
      }
      return;
    }
    this.K = paramOnGrabActivityData.shareData;
    c();
    this.E = paramOnGrabActivityData.id;
    Object localObject1 = paramOnGrabActivityData.pendantData;
    boolean bool2 = false;
    if (localObject1 != null) {
      i1 = paramOnGrabActivityData.pendantData.closeType;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.c.z.a(bool1);
    int i1 = this.e;
    if ((i1 != 3) && (i1 != 4) && (i1 != 5))
    {
      f();
      this.c.setComboListener(this.D);
      this.b.setVisibility(8);
      this.a.setVisibility(0);
    }
    localObject1 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.bgUrl, "qq_hongbao_formal_bg");
    Object localObject2 = this.a;
    Bitmap localBitmap = null;
    ((FormalView)localObject2).setBackground(null, (Bitmap)localObject1);
    localObject1 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.leftCloudImgUrl, "qq_hongbao_cloud_ing_left");
    localObject2 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.rightCloudImgUrl, "qq_hongbao_cloud_ing_right");
    this.a.setCloudBmp((Bitmap)localObject1, (Bitmap)localObject2);
    localObject1 = a(localSpringFestivalEntryManager.d().commonData.comboNumberSet);
    this.a.setComboNumberList((List)localObject1);
    this.a.b = 2;
    this.T = paramOnGrabActivityData.grabWording;
    this.y = paramOnGrabActivityData.tipBarWording;
    if (l1 < 0L)
    {
      J();
    }
    else
    {
      if (l1 == 0L)
      {
        h();
        return;
      }
      b(l1);
    }
    localObject2 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.logoImgUrl, "");
    localObject1 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.nameImgUrl, "");
    this.a.setProgressLogo((Bitmap)localObject2, false);
    if (localObject2 == null) {
      localSpringFestivalEntryManager.a(new ConversationHongBaoV2.5(this, paramOnGrabActivityData.logoImgUrl, localSpringFestivalEntryManager));
    }
    this.a.setProgressNameBitmap((Bitmap)localObject1, null, false);
    if (localObject1 == null)
    {
      localObject2 = this.c.getResources().getDrawable(2130846871);
      if ((localObject2 instanceof SkinnableBitmapDrawable)) {
        localObject1 = ((SkinnableBitmapDrawable)localObject2).getBitmap();
      } else if ((localObject2 instanceof BitmapDrawable)) {
        localObject1 = ((BitmapDrawable)localObject2).getBitmap();
      }
      this.a.setProgressNameBitmap((Bitmap)localObject1, null, false);
      localSpringFestivalEntryManager.a(new ConversationHongBaoV2.6(this, paramOnGrabActivityData.nameImgUrl, localSpringFestivalEntryManager));
    }
    if (paramOnGrabActivityData.pendantData != null)
    {
      localObject1 = paramOnGrabActivityData.pendantData.pendantImgUrl;
      localBitmap = localSpringFestivalEntryManager.a(paramOnGrabActivityData.pendantData.pendantImgUrl, "");
    }
    else
    {
      localObject1 = null;
    }
    localObject2 = this.c;
    boolean bool1 = bool2;
    if (this.e != 3) {
      bool1 = true;
    }
    ((HongBaoListView)localObject2).setLogo(localBitmap, bool1);
    if ((paramOnGrabActivityData.pendantData != null) && (localBitmap == null)) {
      localSpringFestivalEntryManager.a(new ConversationHongBaoV2.7(this, (String)localObject1, localSpringFestivalEntryManager));
    }
    if ((localUserDataItem.hasClickCloseBtn) || (!bool3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "showShuaYiShuaTask hide pendant");
      }
      this.c.r();
    }
    K();
    if (this.e == 3)
    {
      H();
      this.g.sendEmptyMessageDelayed(1008, 200L);
    }
  }
  
  public void a(OnGrabActivityData paramOnGrabActivityData, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showPrepareCountDown,mState = ");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(",taskID = ");
      ((StringBuilder)localObject).append(this.E);
      ((StringBuilder)localObject).append(",prepareCountDownMs = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    this.K = paramOnGrabActivityData.shareData;
    c();
    Object localObject = paramOnGrabActivityData.pendantData;
    boolean bool = false;
    int i1;
    if (localObject != null) {
      i1 = paramOnGrabActivityData.pendantData.closeType;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      bool = true;
    }
    this.c.z.a(bool);
    this.E = paramOnGrabActivityData.id;
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    this.b.setMode(2);
    localObject = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.bgUrl, "");
    Bitmap localBitmap2 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.logoImgUrl, "");
    Bitmap localBitmap1 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.leftCloudUrl, "");
    Bitmap localBitmap4 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.rightCloudUrl, "");
    Bitmap localBitmap5 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.greetImgUrl, "");
    Bitmap localBitmap3 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.nameImgUrl, "");
    this.b.setBackground((Bitmap)localObject, localBitmap2, localBitmap1, localBitmap4, localBitmap5, localBitmap3);
    P();
    localObject = paramOnGrabActivityData.pendantData;
    localBitmap1 = null;
    if (localObject != null)
    {
      localBitmap1 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.pendantData.pendantImgUrl, "");
      localObject = paramOnGrabActivityData.pendantData.pendantImgUrl;
    }
    else
    {
      localObject = null;
    }
    this.c.setLogo(localBitmap1, true);
    if ((paramOnGrabActivityData.pendantData != null) && (localBitmap1 == null)) {
      localSpringFestivalEntryManager.a(new ConversationHongBaoV2.14(this, (String)localObject, localSpringFestivalEntryManager));
    }
    this.b.setLogo(localBitmap2, localBitmap3);
    if (localBitmap2 == null) {
      localSpringFestivalEntryManager.a(new ConversationHongBaoV2.15(this, paramOnGrabActivityData.previewEntryData.logoImgUrl, localSpringFestivalEntryManager));
    }
    if (localBitmap3 == null) {
      localSpringFestivalEntryManager.a(new ConversationHongBaoV2.16(this, paramOnGrabActivityData.previewEntryData.nameImgUrl, localSpringFestivalEntryManager));
    }
    bool = localSpringFestivalEntryManager.h();
    if (QLog.isColorLevel())
    {
      paramOnGrabActivityData = new StringBuilder();
      paramOnGrabActivityData.append("showPrepareCountDown,mState = ");
      paramOnGrabActivityData.append(this.e);
      paramOnGrabActivityData.append(",taskID = ");
      paramOnGrabActivityData.append(this.E);
      paramOnGrabActivityData.append(",isPendantShowSwitchOn = ");
      paramOnGrabActivityData.append(bool);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, paramOnGrabActivityData.toString());
    }
    if (paramLong >= 0L) {
      this.b.a(paramLong);
    } else {
      this.b.a();
    }
    if ((localSpringFestivalEntryManager.c(this.q.ab.c().id).hasClickCloseBtn) || (!bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "showPrepareCountDown hide pendant");
      }
      this.c.r();
    }
    K();
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel())
    {
      paramLogoutReason = new StringBuilder();
      paramLogoutReason.append("onLogout mState = ");
      paramLogoutReason.append(this.e);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, paramLogoutReason.toString());
    }
    if (this.e == -1) {
      return;
    }
    e();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showNormalActivityBreath isRed = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (this.S == null) {
      this.S = ((BreathEffectView)this.R.findViewById(2131435107));
    }
    if (paramBoolean)
    {
      this.S.b();
      return;
    }
    this.S.a();
  }
  
  public void a(boolean paramBoolean, String paramString, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBrashRequestResult, mState = ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(",hit = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",resultTips = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",data = ");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(",mResume = ");
      localStringBuilder.append(this.l);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (this.e != 4)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBrashRequestResult return, mState = ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(",hit = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",resultTips = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",data = ");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(",mResume = ");
      localStringBuilder.append(this.l);
      QLog.d("2021_UI_ConversationHongBaoV2", 1, localStringBuilder.toString());
      return;
    }
    if (paramBoolean)
    {
      if (this.l)
      {
        this.I += 1;
        a(this.Q, paramBundle);
        this.J = true;
        paramString = (SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
        paramString.a(new RedPacketResultData(paramBundle));
        paramString.a(1);
        paramString.o();
      }
    }
    else
    {
      this.d = System.currentTimeMillis();
      this.a.a(paramString);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "endCountDown");
    }
    if (this.t != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "endCountDown mTimerCountDown.cancel");
      }
      this.t.cancel();
      this.t = null;
    }
    FrameHelperActivity.b(true);
    this.r = 0;
    this.d = 0L;
    this.s = 0L;
    ((SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).n();
    if (this.c.w == -this.p)
    {
      this.c.setSpringbackOffset(0);
      this.c.springBackTo(0);
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startCountDown , countDownDuration = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",mState = ");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    if (this.e != 4)
    {
      this.e = 4;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startCountDown,mState updated to STATE_SHUA_YI_SHUA_COUNTDOWN, ");
        ((StringBuilder)localObject).append(this.e);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
      }
      this.P.setAlpha(0);
      this.P.setVisibility(0);
      this.c.r();
      K();
      if ((paramLong != -1L) && (this.c.w == 0))
      {
        this.c.setSelection(0);
        this.c.setSpringbackOffset(-this.p);
        this.c.springBackTo(-this.p);
      }
      p();
      this.S.g();
    }
    Object localObject = (SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    long l1;
    if (paramLong == -1L)
    {
      this.a.b(true);
      u();
      long l2 = ((OnGrabActivityData)this.q.ab.c()).playDuration * 1000;
      l1 = l2;
      if (((SpringFestivalEntryManager)localObject).j())
      {
        int i1 = ((SpringFestivalEntryManager)localObject).k();
        l2 /= i1;
        l1 = l2;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("startCountDown SpeedUp countDownDuration = ");
          localStringBuilder.append(l2);
          localStringBuilder.append(", ratio = ");
          localStringBuilder.append(i1);
          QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
          l1 = l2;
        }
      }
    }
    else
    {
      if (!this.a.a) {
        this.a.d();
      }
      l1 = paramLong;
    }
    if (this.t != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "startCountDown mTimerCountDown.cancel");
      }
      this.t.cancel();
    }
    if ((this.k) && (this.l)) {
      ((SpringFestivalEntryManager)localObject).a(2);
    }
    SpringHbHelper.a().a(this.q.s());
    localObject = ((SpringFestivalEntryManager)localObject).c(this.q.ab.c().id);
    this.G = ((UserData.UserDataItem)localObject).totalGrabCountForShare;
    this.H = ((UserData.UserDataItem)localObject).maxComboCountForShare;
    this.I = ((UserData.UserDataItem)localObject).totalHitCountForShare;
    if (this.L < 0L)
    {
      this.L = ((UserData.UserDataItem)localObject).brushStartTsForReport;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startCountDown brushStartTsForReport = ");
        ((StringBuilder)localObject).append(this.L);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
      }
    }
    E();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startCountDown countDownDuration = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(",realCountDownDuration = ");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("，totalGrabCountForShare = ");
    ((StringBuilder)localObject).append(this.G);
    ((StringBuilder)localObject).append("，maxComboCountForShare = ");
    ((StringBuilder)localObject).append(this.H);
    QLog.d("2021_UI_ConversationHongBaoV2", 1, ((StringBuilder)localObject).toString());
    this.t = new ConversationHongBaoV2.3(this, l1, 40L, ((OnGrabActivityData)this.q.ab.c()).playDuration * 1000);
    this.t.start();
  }
  
  @TargetApi(11)
  public void b(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showTitle direct = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",mTitleIsVisible = ");
      ((StringBuilder)localObject).append(this.m);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = this.Y;
      if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
      {
        this.Y.removeAllListeners();
        this.Y.cancel();
      }
      t();
      this.m = true;
      return;
    }
    if (this.m)
    {
      localObject = this.Y;
      if ((localObject != null) && (!((ValueAnimator)localObject).isRunning()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "showTitle do resetTitle");
        }
        t();
      }
      return;
    }
    this.m = true;
    a(this.q.B(), this.q.C(), this.q.D());
  }
  
  public void c()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ensureInit mState = ");
      ((StringBuilder)localObject1).append(this.e);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.e == -1)
    {
      this.O = ((FrameLayout)this.R.findViewById(2131429217));
      this.c = ((HongBaoListView)this.R.findViewById(2131444377));
      this.c.m();
      localObject1 = this.c;
      ((HongBaoListView)localObject1).m = this;
      ((HongBaoListView)localObject1).B = ((int)this.Q.getResources().getDimension(2131298981));
      localObject1 = this.q.B();
      if ((localObject1 != null) && (((View)localObject1).getBottom() - ((View)localObject1).getTop() != 0))
      {
        i1 = ((View)localObject1).getBottom() - ((View)localObject1).getTop();
        int i2 = this.q.i();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("ensureInit statusTitleHeight = ");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append(",statusTitleHeightInNormalState = ");
          ((StringBuilder)localObject1).append(i2);
          QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject1).toString());
        }
        if (i2 > 0) {
          i1 = i2;
        }
        localObject1 = this.c;
        ((HongBaoListView)localObject1).C = (((HongBaoListView)localObject1).B - i1);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ensureInit title = ");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject2).toString());
        }
        localObject1 = this.c;
        ((HongBaoListView)localObject1).C = (((HongBaoListView)localObject1).B - AIOUtils.b(50.0F, this.Q.getResources()));
      }
      this.U = this.c.B;
      this.V = this.c.C;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ensureInit backgroundBannerHeight = ");
        ((StringBuilder)localObject1).append(this.U);
        ((StringBuilder)localObject1).append(", bannerHeightWithoutTitlebar = ");
        ((StringBuilder)localObject1).append(this.V);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject1).toString());
      }
      this.o = ((int)this.Q.getResources().getDimension(2131298986));
      this.S = ((BreathEffectView)this.R.findViewById(2131435107));
      this.b = new PrepareView(this.Q);
      this.a = new FormalView(this.Q);
      localObject1 = new ViewGroup.LayoutParams(-1, -1);
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.b.setVisibility(8);
      this.O.addView(this.b);
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.a.setVisibility(8);
      this.O.addView(this.a);
      this.P = new ProgressViewRed(this.Q);
      this.P.setVisibility(8);
      this.P.setTextSize(0, this.Q.getResources().getDimension(2131299021));
      int i1 = (int)this.Q.getResources().getDimension(2131298982);
      Object localObject2 = new FrameLayout.LayoutParams(-1, i1);
      localObject1 = (FrameLayout.LayoutParams)localObject2;
      ((FrameLayout.LayoutParams)localObject1).topMargin = (this.c.B - this.c.C);
      this.p = i1;
      this.P.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.O.addView(this.P);
      this.A = ((ImageView)this.R.findViewById(2131435111));
      this.A.setOnClickListener(new ConversationHongBaoV2.4(this));
      this.a.b(this.R);
      this.e = 1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ensureInit,mState updated to STATE_INITED, ");
        ((StringBuilder)localObject2).append(this.e);
        ((StringBuilder)localObject2).append(",mProgressViewRed topMargin = ");
        ((StringBuilder)localObject2).append(((FrameLayout.LayoutParams)localObject1).topMargin);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      localObject1 = this.c;
      if (localObject1 != null)
      {
        ((HongBaoListView)localObject1).m = this;
        ((HongBaoListView)localObject1).B = this.U;
        ((HongBaoListView)localObject1).C = this.V;
      }
    }
  }
  
  @TargetApi(11)
  public void c(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideTitle direct = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",mTitleIsVisible = ");
      ((StringBuilder)localObject).append(this.m);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    if (this.m)
    {
      localObject = this.q;
      if (localObject == null) {
        return;
      }
      this.m = false;
      if (!paramBoolean)
      {
        b(((Conversation)localObject).B(), this.q.C(), this.q.D());
        return;
      }
      localObject = ((Conversation)localObject).B();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.topMargin = (-this.W);
      ((View)localObject).setLayoutParams(localLayoutParams);
      localObject = this.q.D();
      ((View)localObject).setVisibility(8);
      if (this.n) {
        ((View)localObject).setAlpha(0.0F);
      }
      this.m = false;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportBreathLightExpose isRedLight = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    HashMap localHashMap = new HashMap();
    Object localObject = this.q.ab.c();
    if (localObject != null)
    {
      localHashMap.put("active_id", ((BaseActivityData)localObject).id);
      if (paramBoolean) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      localHashMap.put("refer", localObject);
    }
    SpringHbReporter.a(ReportConstant.Event.j, 0, 0, localHashMap, "exp");
  }
  
  public boolean d()
  {
    int i1 = this.e;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i1 != -1)
    {
      HongBaoListView localHongBaoListView = this.c;
      if (localHongBaoListView == null) {
        return false;
      }
      bool1 = bool2;
      if (localHongBaoListView.mForHongBao)
      {
        bool1 = bool2;
        if (this.c.p) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void e()
  {
    M();
    b(true);
    I();
    if (this.e == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "normalMode return for STATE_EMPTY");
      }
      return;
    }
    if (!d())
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "normalMode return for hongbao not shown");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "normalMode");
    }
    this.c.setSpringbackOffset(0);
    this.c.springBackTo(0);
    FrameHelperActivity.b(true);
    this.c.j();
    this.c.n();
    this.q.I();
    p();
    b();
    this.S.g();
    this.O.removeView(this.b);
    this.b = null;
    this.c.setHongBaoModeListScrollHeader(null);
    this.a.a(this.R);
    this.O.removeView(this.a);
    this.a = null;
    this.O.removeView(this.P);
    this.P = null;
    this.g.removeCallbacks(this.C);
    L();
    this.f = -1L;
    this.e = -1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("normalMode,mState updated to STATE_EMPTY, mState = ");
      localStringBuilder.append(this.e);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportPendantExpose isSpreadFlower = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    HashMap localHashMap = new HashMap();
    Object localObject = this.q.ab.c();
    if (localObject != null)
    {
      localHashMap.put("active_id", ((BaseActivityData)localObject).id);
      localHashMap.put("refer", String.valueOf(((BaseActivityData)localObject).type));
    }
    if (paramBoolean) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    localHashMap.put("op_via", localObject);
    SpringHbReporter.a(ReportConstant.Event.i, 0, 0, localHashMap, "exp");
  }
  
  public void f()
  {
    if (this.e == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "hongbaoMode return for STATE_EMPTY");
      }
      return;
    }
    if (d())
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "hongbaoMode return for already show hongbao");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "hongbaoMode");
    }
    this.c.l();
    this.q.I();
  }
  
  public void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportPendantClick isSpreadFlower = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    HashMap localHashMap = new HashMap();
    Object localObject = this.q.ab.c();
    if (localObject != null)
    {
      localHashMap.put("active_id", ((BaseActivityData)localObject).id);
      localHashMap.put("refer", String.valueOf(((BaseActivityData)localObject).type));
    }
    if (paramBoolean) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    localHashMap.put("op_via", localObject);
    SpringHbReporter.a(ReportConstant.Event.i, 0, 0, localHashMap, "clk");
  }
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportPendantCloseBtnClick isSpreadFlower = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    HashMap localHashMap = new HashMap();
    Object localObject = this.q.ab.c();
    if (localObject != null)
    {
      localHashMap.put("active_id", ((BaseActivityData)localObject).id);
      localHashMap.put("refer", String.valueOf(((BaseActivityData)localObject).type));
    }
    if (paramBoolean) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    localHashMap.put("op_via", localObject);
    SpringHbReporter.a(ReportConstant.Event.i, 0, 0, localHashMap, "close");
  }
  
  public boolean g()
  {
    if (FrameHelperActivity.G())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showPreGuide");
        localStringBuilder.append(this.e);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (this.c == null) {
      return false;
    }
    O();
    return true;
  }
  
  public void h()
  {
    if (this.e != 5)
    {
      this.e = 5;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showTask,mState updated to STATE_SHUA_YI_SHUA_END, ");
        ((StringBuilder)localObject).append(this.e);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
      }
      e();
      Object localObject = this.q.ab.c();
      this.q.ab.g((BaseActivityData)localObject);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1001)
    {
      if (i1 != 1002)
      {
        if (i1 != 1005)
        {
          if (i1 != 1006)
          {
            if (i1 == 1008)
            {
              if (QLog.isColorLevel()) {
                QLog.d("2021_UI_ConversationHongBaoV2", 2, "handleMessage MSG_WHAT_SHOW_PREGUIDE ");
              }
              g();
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("2021_UI_ConversationHongBaoV2", 2, "handleMessage MSG_WHAT_PlAYSOUND_RING");
            }
            if (this.l) {
              ((SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(4);
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("handleMessage MSG_WHAT_SHOWSHARE pullState = ");
          paramMessage.append(this.i);
          paramMessage.append(",mState = ");
          paramMessage.append(this.e);
          QLog.d("2021_UI_ConversationHongBaoV2", 2, paramMessage.toString());
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "handleMessage MSG_WHAT_POST_ONRESUME");
        }
        k();
      }
    }
    else
    {
      p();
      o();
    }
    return false;
  }
  
  public void i()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBeforeAccountChanged mState = ");
      localStringBuilder.append(this.e);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (this.e == -1) {
      return;
    }
    e();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "postOnResume ");
    }
    this.g.sendEmptyMessageDelayed(1002, 800L);
  }
  
  public void k()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume() mState = ");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(",delayedShowSharePageTask = ");
      ((StringBuilder)localObject).append(this.M);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.M;
    if (localObject != null)
    {
      ((ConversationHongBaoV2.ShowSharePageTask)localObject).a();
      this.M = null;
    }
    if (this.J)
    {
      this.J = false;
      this.q.ab.k();
      this.N = true;
    }
    localObject = this.g;
    if (localObject != null)
    {
      if (((Handler)localObject).hasMessages(1002)) {
        return;
      }
      this.l = true;
      if (!d())
      {
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "onResume() return for not showing hongbao");
        }
        return;
      }
      localObject = (SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      if ((!((SpringFestivalEntryManager)localObject).h()) && (this.c != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "onResume hideHongbaoPendant");
        }
        this.c.r();
        K();
      }
      FormalView localFormalView = this.a;
      if (localFormalView != null) {
        localFormalView.c();
      }
      if (this.h)
      {
        if (this.z) {
          g();
        }
        this.h = false;
      }
      int i1 = this.e;
      if (i1 != 2)
      {
        if (i1 == 3)
        {
          this.S.b();
          this.c.p();
        }
      }
      else {
        this.S.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "onResume refreshScheduleTask");
      }
      ((SpringFestivalEntryManager)localObject).m();
      m();
    }
  }
  
  public void l()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAndReportExpose isLeftDrawerOpen = ");
      ((StringBuilder)localObject).append(this.F);
      ((StringBuilder)localObject).append(",mResume = ");
      ((StringBuilder)localObject).append(this.l);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.F) && (this.l))
    {
      localObject = (ARMapHongBaoListView)this.R.findViewById(2131444377);
      if (((ARMapHongBaoListView)localObject).b) {
        e(B());
      }
      boolean bool1 = ((ARMapHongBaoListView)localObject).y;
      boolean bool2 = false;
      if (bool1)
      {
        if (this.e == 3) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        e(bool1);
      }
      int i1 = ((BreathEffectView)this.R.findViewById(2131435107)).getCurDisplayState();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkAndReportExpose breathViewState = ");
        ((StringBuilder)localObject).append(i1);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
      }
      if ((i1 == 2) || (i1 == 1))
      {
        bool1 = bool2;
        if (i1 == 2) {
          bool1 = true;
        }
        d(bool1);
      }
    }
  }
  
  public void m()
  {
    if (!d()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateState mState = ");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    if (this.e != 4) {
      return;
    }
    Object localObject = (SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    if ((this.l) && (this.k) && (!FrameHelperActivity.G()))
    {
      ((SpringFestivalEntryManager)localObject).a(2);
      return;
    }
    ((SpringFestivalEntryManager)localObject).n();
    FrameHelperActivity.b(true);
  }
  
  public void n()
  {
    this.l = false;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPause() isShowBrushResultPage = ");
      ((StringBuilder)localObject).append(this.J);
      ((StringBuilder)localObject).append(",mState = ");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    if (!d())
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "onPause return for not showing hb");
      }
      return;
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((FormalView)localObject).c != null) {
        this.a.c.setPause(true);
      }
      this.a.g();
    }
    localObject = this.b;
    if (localObject != null) {
      ((PrepareView)localObject).c();
    }
    localObject = this.c;
    if (localObject != null) {
      ((HongBaoListView)localObject).q();
    }
    localObject = this.S;
    if (localObject != null) {
      ((BreathEffectView)localObject).g();
    }
    if ((this.J) && (this.t != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "onPause mTimerCountDown.cancel");
      }
      this.t.cancel();
    }
    this.g.removeCallbacks(this.C);
    this.g.post(this.C);
    m();
    localObject = (SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    UserData.UserDataItem localUserDataItem = ((SpringFestivalEntryManager)localObject).c(this.q.ab.c().id);
    localUserDataItem.totalGrabCountForShare = this.G;
    localUserDataItem.maxComboCountForShare = this.H;
    localUserDataItem.totalHitCountForShare = this.I;
    ((SpringFestivalEntryManager)localObject).e();
    if (this.e == 4)
    {
      this.P.setAlpha(255);
      this.P.setVisibility(0);
      this.P.invalidate();
    }
    if (QLog.isColorLevel())
    {
      int i1 = this.P.getProgressViewAlpha();
      int i2 = this.P.getVisibility();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" [dddd] onPause mProgressViewRed alpha = ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(",visibility = ");
      ((StringBuilder)localObject).append(i2);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean o()
  {
    if (this.e != 3)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startGestureGuide return,  mState = ");
        ((StringBuilder)localObject).append(this.e);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    int i1 = (int)this.R.getResources().getDimension(2131298990);
    int i2 = -this.c.getComputeScrollOffset();
    Object localObject = ObjectAnimator.ofFloat(this.A, "translationY", new float[] { i2, i2 + i1 });
    ((ObjectAnimator)localObject).setDuration(1500L);
    ((ObjectAnimator)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.A, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(200L);
    localObjectAnimator1.addListener(new ConversationHongBaoV2.8(this));
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.A, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator2.setDuration(500L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.play(localObjectAnimator1).after(1L);
    localAnimatorSet.play(localObjectAnimator2).after(1000L);
    localAnimatorSet.addListener(new ConversationHongBaoV2.9(this));
    localAnimatorSet.start();
    return true;
  }
  
  public void p()
  {
    this.g.removeMessages(1001);
    this.A.clearAnimation();
    this.A.setVisibility(8);
  }
  
  public void q()
  {
    this.F = true;
    if (!d()) {
      return;
    }
    m();
    this.c.setSpringbackOffset(0);
    if (this.c.getScrollY() != 0) {
      this.c.springBackTo(0);
    }
    b(true);
    FormalView localFormalView = this.a;
    if ((localFormalView != null) && (localFormalView.c != null)) {
      this.a.c.setPause(true);
    }
  }
  
  public void r()
  {
    this.F = false;
    if (!d()) {
      return;
    }
    m();
    if ((this.e == 4) && (this.c.getScrollY() == 0))
    {
      this.c.setSpringbackOffset(-this.p);
      this.c.springBackTo(-this.p);
    }
  }
  
  public void s()
  {
    if (!d()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPostThemeChanged mState = ");
      localStringBuilder.append(this.e);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (this.e != 3) {
      return;
    }
    p();
    o();
  }
  
  @TargetApi(11)
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "resetTitle");
    }
    View localView1 = this.q.B();
    View localView2 = this.q.D();
    if (localView1 != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
      localLayoutParams.topMargin = 0;
      localView1.setLayoutParams(localLayoutParams);
    }
    if (localView2 != null)
    {
      if (this.n) {
        localView2.setAlpha(1.0F);
      }
      localView2.setVisibility(0);
    }
  }
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "reportBrushMainPageExpose");
    }
    this.L = System.currentTimeMillis();
    Object localObject1 = (SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    Object localObject2 = ((SpringFestivalEntryManager)localObject1).c(this.q.ab.c().id);
    ((UserData.UserDataItem)localObject2).isAbnormalQuit = true;
    ((UserData.UserDataItem)localObject2).brushStartTsForReport = this.L;
    ((SpringFestivalEntryManager)localObject1).b();
    localObject1 = new HashMap();
    localObject2 = this.q.ab.c();
    if (localObject2 != null)
    {
      localObject2 = ((BaseActivityData)localObject2).id;
      ((Map)localObject1).put("active_id", localObject2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportBrushMainPageExpose isAbnormalQuit true, id = ");
        localStringBuilder.append((String)localObject2);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
      }
    }
    SpringHbReporter.a(ReportConstant.Event.l, 0, 0, (Map)localObject1, "exp");
  }
  
  public void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "reportBrushBeginShua");
    }
    HashMap localHashMap = new HashMap();
    Object localObject = this.q.ab.c();
    if (localObject != null)
    {
      localObject = ((BaseActivityData)localObject).id;
      localHashMap.put("active_id", localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportBrushBeginShua, id = ");
        localStringBuilder.append((String)localObject);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
      }
    }
    SpringHbReporter.a(ReportConstant.Event.l, 0, 0, localHashMap, "beginshua");
  }
  
  public void w()
  {
    String str = String.valueOf((System.currentTimeMillis() - this.L) / 1000L);
    this.L = -1L;
    Object localObject1 = (SpringFestivalEntryManager)this.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    ((SpringFestivalEntryManager)localObject1).c(this.q.ab.c().id).isAbnormalQuit = false;
    ((SpringFestivalEntryManager)localObject1).b();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportBrushMainPageQuit duration = ");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(",totalGrabCountForShare = ");
      ((StringBuilder)localObject1).append(this.G);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new HashMap();
    Object localObject2 = this.q.ab.c();
    if (localObject2 != null)
    {
      localObject2 = ((BaseActivityData)localObject2).id;
      ((Map)localObject1).put("active_id", localObject2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportBrushMainPageExpose isAbnormalQuit false, id = ");
        localStringBuilder.append((String)localObject2);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
      }
    }
    ((Map)localObject1).put("ext1", str);
    ((Map)localObject1).put("ext2", String.valueOf(this.G));
    SpringHbReporter.a(ReportConstant.Event.l, 0, 0, (Map)localObject1, "quit");
  }
  
  public void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "reportStaggerdPeakExpose");
    }
    HashMap localHashMap = new HashMap();
    BaseActivityData localBaseActivityData = this.q.ab.c();
    if (localBaseActivityData != null) {
      localHashMap.put("active_id", localBaseActivityData.id);
    }
    SpringHbReporter.a(ReportConstant.Event.k, 0, 0, localHashMap, "exp");
  }
  
  public void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "hideNormalActivityPendant");
    }
    ((ARMapHongBaoListView)this.R.findViewById(2131444377)).f();
  }
  
  public boolean z()
  {
    ARMapHongBaoListView localARMapHongBaoListView = (ARMapHongBaoListView)this.R.findViewById(2131444377);
    boolean bool;
    if ((!localARMapHongBaoListView.b) && (!localARMapHongBaoListView.y)) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSpringFestivalPendantShowing isActivePendantShowing = ");
      localStringBuilder.append(localARMapHongBaoListView.b);
      localStringBuilder.append(",isPendantShowing = ");
      localStringBuilder.append(localARMapHongBaoListView.y);
      localStringBuilder.append(",result = ");
      localStringBuilder.append(bool);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2
 * JD-Core Version:    0.7.0.1
 */