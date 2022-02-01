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
  public int a;
  public long a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer = null;
  public Handler a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateDecelerateInterpolator();
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private Animator.AnimatorListener jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = null;
  private ValueAnimator jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = null;
  Conversation jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
  private OnGrabActivityData.Share jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share = null;
  private BreathEffectView jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView;
  private ConversationHongBaoV2.ShowSharePageTask jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2$ShowSharePageTask;
  public FormalView a;
  public PrepareView a;
  private ProgressViewRed jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed;
  public HongBaoListView a;
  public HongBaoListViewListener a;
  public Runnable a;
  String jdField_a_of_type_JavaLangString = "";
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(12);
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  public int b;
  public long b;
  Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private Animator.AnimatorListener jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = null;
  private ValueAnimator jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator = null;
  String jdField_b_of_type_JavaLangString;
  StringBuilder jdField_b_of_type_JavaLangStringBuilder = new StringBuilder(8);
  public boolean b;
  int jdField_c_of_type_Int = 0;
  public long c;
  private String jdField_c_of_type_JavaLangString = null;
  public boolean c;
  int jdField_d_of_type_Int = 0;
  long jdField_d_of_type_Long;
  public boolean d;
  int jdField_e_of_type_Int = 0;
  long jdField_e_of_type_Long = 0L;
  public boolean e;
  private int jdField_f_of_type_Int = 0;
  private long jdField_f_of_type_Long = -1L;
  boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int = 0;
  private long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int = 0;
  private boolean jdField_j_of_type_Boolean = false;
  private int k = -1;
  
  public ConversationHongBaoV2(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = VersionUtils.e();
    this.jdField_a_of_type_JavaLangRunnable = new ConversationHongBaoV2.1(this);
    this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener = new ConversationHongBaoV2.2(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = paramConversation;
    this.jdField_a_of_type_AndroidAppActivity = paramConversation.a();
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  private void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "cleanListViewContainerBg");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.b() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.b().getBackground() != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.b().getBackground();
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.b().setBackgroundDrawable(null);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cleanListViewContainerBg conversationDrawable = ");
        localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setContentBackground(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  private void B()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recoverListViewContainerBg conversationDrawable = ");
      localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.b().setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setContentBackground(null);
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_Int != 3)
    {
      this.jdField_a_of_type_Int = 3;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showTask,mState updated to STATE_SHUA_YI_SHUA_READY, ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.b();
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.r();
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.b();
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.o();
      }
      m();
      c();
      b();
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
      {
        e(true);
        d(true);
      }
    }
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar.b();
    }
  }
  
  private void E()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "recoverListViewContainerLayoutParams");
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.b();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.addRule(3, 2131377872);
    localLayoutParams.topMargin = 0;
    localView.setLayoutParams(localLayoutParams);
    this.jdField_j_of_type_Boolean = false;
  }
  
  private void F()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "clearTitleAnimation");
    }
    ValueAnimator localValueAnimator = this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    }
    localValueAnimator = this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    }
  }
  
  private void G()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showPrepareViewAnimation mState = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView;
    if ((localObject != null) && (this.jdField_a_of_type_Int == 2))
    {
      ((PrepareView)localObject).b();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1006);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1006, 500L);
    }
  }
  
  private void H()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showRealPreGuide mHongBaoListView = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentWidgetHongBaoListView);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null) {
      return;
    }
    A();
    int m = this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int;
    int n = this.jdField_a_of_type_Int;
    if (n == 3)
    {
      n = AIOUtils.b(100.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.a(m - n);
      return;
    }
    if ((n == 2) || (n == 5) || (n == 4))
    {
      G();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.a(m);
    }
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_Int != 2)
    {
      this.jdField_a_of_type_Int = 2;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showPrepare,mState updated to STATE_YURE, ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
      }
      e();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.r();
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.a();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setComboListener(this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener);
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(8);
      m();
      b();
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
      {
        e(false);
        d(false);
      }
      u();
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
    this.k = (((RelativeLayout.LayoutParams)paramView2.getLayoutParams()).topMargin + paramView2.getHeight());
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.addRule(3, 0);
    paramView2.topMargin = this.k;
    paramView1.setLayoutParams(paramView2);
    this.jdField_j_of_type_Boolean = true;
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, View paramView3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doShowTitleAnim mTitleBarOffset = ");
      localStringBuilder.append(this.k);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (!this.jdField_j_of_type_Boolean) {
      a(paramView2, paramView1);
    }
    if (this.k <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new ConversationHongBaoV2.10(this, paramView2, paramView1, paramView3));
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new ConversationHongBaoV2.11(this, paramView3);
    }
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  @TargetApi(11)
  private void b(View paramView1, View paramView2, View paramView3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doHideTitleAnim mTitleBarOffset = ");
      localStringBuilder.append(this.k);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (!this.jdField_j_of_type_Boolean) {
      a(paramView2, paramView1);
    }
    if (this.k <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new ConversationHongBaoV2.12(this, paramView2, paramView1, paramView3));
      this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new ConversationHongBaoV2.13(this, paramView3, paramView1);
    }
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.start();
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
    Object localObject = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    ((SpringFestivalEntryManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a().id).leftCountDownDuration = paramLong;
    ((SpringFestivalEntryManager)localObject).a();
  }
  
  private void d(long paramLong)
  {
    ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a().id).leftCountDownDuration = paramLong;
  }
  
  private boolean f()
  {
    return ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a().id).leftCountDownDuration > 3000L;
  }
  
  private void x()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.getLayoutParams();
    int i1 = localLayoutParams.topMargin;
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    int m = localView.getHeight();
    int n = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    if (n > 0) {
      m = n;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshRedProgressBarTopMargin,statusTitle.w = ");
      localStringBuilder.append(localView.getWidth());
      localStringBuilder.append(",statusTitle.h = ");
      localStringBuilder.append(localView.getHeight());
      localStringBuilder.append(",statusTitleHeightInNormalState = ");
      localStringBuilder.append(n);
      localStringBuilder.append(",mProgressViewRed cur topMargin = ");
      localStringBuilder.append(i1);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (m != i1)
    {
      localLayoutParams.topMargin = m;
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setLayoutParams(localLayoutParams);
    }
  }
  
  private void y()
  {
    QLog.d("2021_UI_ConversationHongBaoV2", 1, "clearShareData");
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share = null;
  }
  
  private void z()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "markClickedPendantCloseBtn");
    }
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    BaseActivityData localBaseActivityData = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
    UserData.UserDataItem localUserDataItem = localSpringFestivalEntryManager.a(localBaseActivityData.id);
    localUserDataItem.hasClickCloseBtn = true;
    int m = 0;
    if (localBaseActivityData.pendantData != null) {
      m = localBaseActivityData.pendantData.closeType;
    }
    localUserDataItem.pendantCloseType = m;
    localSpringFestivalEntryManager.a();
  }
  
  public ARMapHongBaoListView a()
  {
    return (ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376171);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "stopNormalActivityBreath");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView == null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView = ((BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368239));
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.g();
  }
  
  void a(long paramLong)
  {
    if (this.jdField_c_of_type_Long == paramLong) {
      return;
    }
    this.jdField_c_of_type_Long = paramLong;
    int n = (int)(paramLong / 1000L);
    int m = n / 60;
    n %= 60;
    int i1 = (int)paramLong % 100;
    StringBuilder localStringBuilder = this.jdField_b_of_type_JavaLangStringBuilder;
    localStringBuilder.delete(0, localStringBuilder.length());
    if (m < 10) {
      this.jdField_b_of_type_JavaLangStringBuilder.append("0");
    }
    localStringBuilder = this.jdField_b_of_type_JavaLangStringBuilder;
    localStringBuilder.append(m);
    localStringBuilder.append(":");
    if (n < 10) {
      this.jdField_b_of_type_JavaLangStringBuilder.append("0");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(n);
    this.jdField_b_of_type_JavaLangStringBuilder.append(".");
    if (i1 < 10) {
      this.jdField_b_of_type_JavaLangStringBuilder.append("0");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(i1);
    localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.delete(0, localStringBuilder.length());
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_b_of_type_JavaLangStringBuilder);
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
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
    Object localObject4 = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    Object localObject1 = paramBaseActivityData.pendantData;
    boolean bool = false;
    Object localObject3 = null;
    int m;
    int n;
    if (localObject1 != null)
    {
      localObject3 = paramBaseActivityData.pendantData.pendantImgUrl;
      localObject2 = ((SpringFestivalEntryManager)localObject4).a(paramBaseActivityData.pendantData.pendantImgUrl, "");
      localObject1 = paramBaseActivityData.pendantData.jumpUrl;
      m = paramBaseActivityData.pendantData.closeType;
      n = paramBaseActivityData.pendantData.type;
    }
    else
    {
      localObject2 = null;
      localObject1 = localObject2;
      n = 0;
      m = 0;
    }
    ARMapHongBaoListView localARMapHongBaoListView = (ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376171);
    if (m != 0) {
      bool = true;
    }
    localARMapHongBaoListView.a((Bitmap)localObject2, bool);
    if ((paramBaseActivityData.pendantData != null) && (localObject2 == null)) {
      ((SpringFestivalEntryManager)localObject4).a(new ConversationHongBaoV2.17(this, (String)localObject3, localARMapHongBaoListView, (SpringFestivalEntryManager)localObject4));
    }
    Object localObject2 = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    localObject3 = ((ITaskManager)localObject2).a();
    if ((!((UserData)localObject3).hasClickedHolder) && (!((UserData)localObject3).hasShowedMiniApp) && (n == 1))
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
    e(e());
    localARMapHongBaoListView.setOnPendentClickListener(new ConversationHongBaoV2.18(this, (String)localObject1, localARMapHongBaoListView, (ITaskManager)localObject2, paramBaseActivityData, m));
    D();
  }
  
  public void a(OnGrabActivityData paramOnGrabActivityData)
  {
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    UserData.UserDataItem localUserDataItem = localSpringFestivalEntryManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a().id);
    long l = localUserDataItem.leftCountDownDuration;
    boolean bool3 = localSpringFestivalEntryManager.b();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showShuaYiShuaTask leftCountDownDuration = ");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append(",isPendantShowSwitchOn = ");
      ((StringBuilder)localObject1).append(bool3);
      ((StringBuilder)localObject1).append(",mState = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramOnGrabActivityData.id.equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Int == 3))
    {
      if (QLog.isColorLevel())
      {
        paramOnGrabActivityData = new StringBuilder();
        paramOnGrabActivityData.append("showShuaYiShuaTask return for already STATE_SHUA_YI_SHUA_READY ,taskID = ");
        paramOnGrabActivityData.append(this.jdField_b_of_type_JavaLangString);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, paramOnGrabActivityData.toString());
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share = paramOnGrabActivityData.shareData;
    c();
    this.jdField_b_of_type_JavaLangString = paramOnGrabActivityData.id;
    Object localObject1 = paramOnGrabActivityData.pendantData;
    boolean bool2 = false;
    if (localObject1 != null) {
      m = paramOnGrabActivityData.pendantData.closeType;
    } else {
      m = 0;
    }
    if (m != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(bool1);
    int m = this.jdField_a_of_type_Int;
    if ((m != 3) && (m != 4) && (m != 5))
    {
      e();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setComboListener(this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener);
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(0);
    }
    localObject1 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.bgUrl, "qq_hongbao_formal_bg");
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPortalFormalView;
    Bitmap localBitmap = null;
    ((FormalView)localObject2).setBackground(null, (Bitmap)localObject1);
    localObject1 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.leftCloudImgUrl, "qq_hongbao_cloud_ing_left");
    localObject2 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.rightCloudImgUrl, "qq_hongbao_cloud_ing_right");
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setCloudBmp((Bitmap)localObject1, (Bitmap)localObject2);
    localObject1 = a(localSpringFestivalEntryManager.a().commonData.comboNumberSet);
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setComboNumberList((List)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Int = 2;
    this.jdField_c_of_type_JavaLangString = paramOnGrabActivityData.grabWording;
    this.jdField_a_of_type_JavaLangString = paramOnGrabActivityData.tipBarWording;
    if (l < 0L)
    {
      C();
    }
    else
    {
      if (l == 0L)
      {
        f();
        return;
      }
      b(l);
    }
    localObject2 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.logoImgUrl, "");
    localObject1 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.nameImgUrl, "");
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressLogo((Bitmap)localObject2, false);
    if (localObject2 == null) {
      localSpringFestivalEntryManager.a(new ConversationHongBaoV2.5(this, paramOnGrabActivityData.logoImgUrl, localSpringFestivalEntryManager));
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressNameBitmap((Bitmap)localObject1, null, false);
    if (localObject1 == null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentWidgetHongBaoListView.getResources().getDrawable(2130845415);
      if ((localObject2 instanceof SkinnableBitmapDrawable)) {
        localObject1 = ((SkinnableBitmapDrawable)localObject2).getBitmap();
      } else if ((localObject2 instanceof BitmapDrawable)) {
        localObject1 = ((BitmapDrawable)localObject2).getBitmap();
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressNameBitmap((Bitmap)localObject1, null, false);
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
    localObject2 = this.jdField_a_of_type_ComTencentWidgetHongBaoListView;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Int != 3) {
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
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.q();
    }
    D();
    if (this.jdField_a_of_type_Int == 3)
    {
      A();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1008, 200L);
    }
  }
  
  public void a(OnGrabActivityData paramOnGrabActivityData, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showPrepareCountDown,mState = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(",taskID = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(",prepareCountDownMs = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share = paramOnGrabActivityData.shareData;
    c();
    Object localObject = paramOnGrabActivityData.pendantData;
    boolean bool = false;
    int m;
    if (localObject != null) {
      m = paramOnGrabActivityData.pendantData.closeType;
    } else {
      m = 0;
    }
    if (m != 0) {
      bool = true;
    }
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(bool);
    this.jdField_b_of_type_JavaLangString = paramOnGrabActivityData.id;
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setMode(2);
    localObject = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.bgUrl, "");
    Bitmap localBitmap2 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.logoImgUrl, "");
    Bitmap localBitmap1 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.leftCloudUrl, "");
    Bitmap localBitmap4 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.rightCloudUrl, "");
    Bitmap localBitmap5 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.greetImgUrl, "");
    Bitmap localBitmap3 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.nameImgUrl, "");
    this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setBackground((Bitmap)localObject, localBitmap2, localBitmap1, localBitmap4, localBitmap5, localBitmap3);
    I();
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
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setLogo(localBitmap1, true);
    if ((paramOnGrabActivityData.pendantData != null) && (localBitmap1 == null)) {
      localSpringFestivalEntryManager.a(new ConversationHongBaoV2.14(this, (String)localObject, localSpringFestivalEntryManager));
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setLogo(localBitmap2, localBitmap3);
    if (localBitmap2 == null) {
      localSpringFestivalEntryManager.a(new ConversationHongBaoV2.15(this, paramOnGrabActivityData.previewEntryData.logoImgUrl, localSpringFestivalEntryManager));
    }
    if (localBitmap3 == null) {
      localSpringFestivalEntryManager.a(new ConversationHongBaoV2.16(this, paramOnGrabActivityData.previewEntryData.nameImgUrl, localSpringFestivalEntryManager));
    }
    bool = localSpringFestivalEntryManager.b();
    if (QLog.isColorLevel())
    {
      paramOnGrabActivityData = new StringBuilder();
      paramOnGrabActivityData.append("showPrepareCountDown,mState = ");
      paramOnGrabActivityData.append(this.jdField_a_of_type_Int);
      paramOnGrabActivityData.append(",taskID = ");
      paramOnGrabActivityData.append(this.jdField_b_of_type_JavaLangString);
      paramOnGrabActivityData.append(",isPendantShowSwitchOn = ");
      paramOnGrabActivityData.append(bool);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, paramOnGrabActivityData.toString());
    }
    if (paramLong >= 0L) {
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.a(paramLong);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.a();
    }
    if ((localSpringFestivalEntryManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a().id).hasClickCloseBtn) || (!bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "showPrepareCountDown hide pendant");
      }
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.q();
    }
    D();
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel())
    {
      paramLogoutReason = new StringBuilder();
      paramLogoutReason.append("onLogout mState = ");
      paramLogoutReason.append(this.jdField_a_of_type_Int);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, paramLogoutReason.toString());
    }
    if (this.jdField_a_of_type_Int == -1) {
      return;
    }
    d();
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
    if (this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView == null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView = ((BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368239));
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.a();
  }
  
  public void a(boolean paramBoolean, String paramString, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBrashRequestResult, mState = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(",hit = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",resultTips = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",data = ");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(",mResume = ");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Int != 4)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBrashRequestResult return, mState = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(",hit = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",resultTips = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",data = ");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(",mResume = ");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      QLog.d("2021_UI_ConversationHongBaoV2", 1, localStringBuilder.toString());
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_h_of_type_Int += 1;
        a(this.jdField_a_of_type_AndroidAppActivity, paramBundle);
        this.jdField_h_of_type_Boolean = true;
        paramString = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
        paramString.a(new RedPacketResultData(paramBundle));
        paramString.a(1);
        paramString.e();
      }
    }
    else
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(paramString);
    }
  }
  
  public boolean a()
  {
    int m = this.jdField_a_of_type_Int;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (m != -1)
    {
      HongBaoListView localHongBaoListView = this.jdField_a_of_type_ComTencentWidgetHongBaoListView;
      if (localHongBaoListView == null) {
        return false;
      }
      bool1 = bool2;
      if (localHongBaoListView.mForHongBao)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_i_of_type_Boolean) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "endCountDown");
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "endCountDown mTimerCountDown.cancel");
      }
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      this.jdField_a_of_type_AndroidOsCountDownTimer = null;
    }
    FrameHelperActivity.a(true);
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).d();
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_c_of_type_Int == -this.jdField_d_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Int != 4)
    {
      this.jdField_a_of_type_Int = 4;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startCountDown,mState updated to STATE_SHUA_YI_SHUA_COUNTDOWN, ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setAlpha(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.q();
      D();
      if ((paramLong != -1L) && (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_c_of_type_Int == 0))
      {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSelection(0);
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(-this.jdField_d_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(-this.jdField_d_of_type_Int);
      }
      m();
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.g();
    }
    Object localObject = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    long l1;
    if (paramLong == -1L)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.b(true);
      r();
      long l2 = ((OnGrabActivityData)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a()).playDuration * 1000;
      l1 = l2;
      if (((SpringFestivalEntryManager)localObject).c())
      {
        int m = ((SpringFestivalEntryManager)localObject).a();
        l2 /= m;
        l1 = l2;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("startCountDown SpeedUp countDownDuration = ");
          localStringBuilder.append(l2);
          localStringBuilder.append(", ratio = ");
          localStringBuilder.append(m);
          QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
          l1 = l2;
        }
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.d();
      }
      l1 = paramLong;
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "startCountDown mTimerCountDown.cancel");
      }
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
      ((SpringFestivalEntryManager)localObject).a(2);
    }
    SpringHbHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a());
    localObject = ((SpringFestivalEntryManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a().id);
    this.jdField_f_of_type_Int = ((UserData.UserDataItem)localObject).totalGrabCountForShare;
    this.jdField_g_of_type_Int = ((UserData.UserDataItem)localObject).maxComboCountForShare;
    this.jdField_h_of_type_Int = ((UserData.UserDataItem)localObject).totalHitCountForShare;
    if (this.jdField_f_of_type_Long < 0L)
    {
      this.jdField_f_of_type_Long = ((UserData.UserDataItem)localObject).brushStartTsForReport;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startCountDown brushStartTsForReport = ");
        ((StringBuilder)localObject).append(this.jdField_f_of_type_Long);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
      }
    }
    x();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startCountDown countDownDuration = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(",realCountDownDuration = ");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("，totalGrabCountForShare = ");
    ((StringBuilder)localObject).append(this.jdField_f_of_type_Int);
    ((StringBuilder)localObject).append("，maxComboCountForShare = ");
    ((StringBuilder)localObject).append(this.jdField_g_of_type_Int);
    QLog.d("2021_UI_ConversationHongBaoV2", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_AndroidOsCountDownTimer = new ConversationHongBaoV2.3(this, l1, 40L, ((OnGrabActivityData)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a()).playDuration * 1000);
    this.jdField_a_of_type_AndroidOsCountDownTimer.start();
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
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator;
      if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
      {
        this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
        this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      }
      q();
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator;
      if ((localObject != null) && (!((ValueAnimator)localObject).isRunning()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "showTitle do resetTitle");
        }
        q();
      }
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.b(), this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.c());
  }
  
  public boolean b()
  {
    if (FrameHelperActivity.b())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showPreGuide");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null) {
      return false;
    }
    H();
    return true;
  }
  
  public void c()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ensureInit mState = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_Int == -1)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363339));
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView = ((HongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376171));
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.l();
      localObject1 = this.jdField_a_of_type_ComTencentWidgetHongBaoListView;
      ((HongBaoListView)localObject1).jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 = this;
      ((HongBaoListView)localObject1).jdField_d_of_type_Int = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298280));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
      if ((localObject1 != null) && (((View)localObject1).getBottom() - ((View)localObject1).getTop() != 0))
      {
        m = ((View)localObject1).getBottom() - ((View)localObject1).getTop();
        int n = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("ensureInit statusTitleHeight = ");
          ((StringBuilder)localObject1).append(m);
          ((StringBuilder)localObject1).append(",statusTitleHeightInNormalState = ");
          ((StringBuilder)localObject1).append(n);
          QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject1).toString());
        }
        if (n > 0) {
          m = n;
        }
        localObject1 = this.jdField_a_of_type_ComTencentWidgetHongBaoListView;
        ((HongBaoListView)localObject1).jdField_e_of_type_Int = (((HongBaoListView)localObject1).jdField_d_of_type_Int - m);
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
        localObject1 = this.jdField_a_of_type_ComTencentWidgetHongBaoListView;
        ((HongBaoListView)localObject1).jdField_e_of_type_Int = (((HongBaoListView)localObject1).jdField_d_of_type_Int - AIOUtils.b(50.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      }
      this.jdField_i_of_type_Int = this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_d_of_type_Int;
      this.jdField_j_of_type_Int = this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ensureInit backgroundBannerHeight = ");
        ((StringBuilder)localObject1).append(this.jdField_i_of_type_Int);
        ((StringBuilder)localObject1).append(", bannerHeightWithoutTitlebar = ");
        ((StringBuilder)localObject1).append(this.jdField_j_of_type_Int);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject1).toString());
      }
      this.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298285));
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView = ((BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368239));
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView = new PrepareView(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView = new FormalView(this.jdField_a_of_type_AndroidAppActivity);
      localObject1 = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalFormalView);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed = new ProgressViewRed(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setTextSize(0, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298320));
      int m = (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298281);
      Object localObject2 = new FrameLayout.LayoutParams(-1, m);
      localObject1 = (FrameLayout.LayoutParams)localObject2;
      ((FrameLayout.LayoutParams)localObject1).topMargin = (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_d_of_type_Int - this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int);
      this.jdField_d_of_type_Int = m;
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368243));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ConversationHongBaoV2.4(this));
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.b(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Int = 1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ensureInit,mState updated to STATE_INITED, ");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject2).append(",mProgressViewRed topMargin = ");
        ((StringBuilder)localObject2).append(((FrameLayout.LayoutParams)localObject1).topMargin);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetHongBaoListView;
      if (localObject1 != null)
      {
        ((HongBaoListView)localObject1).jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 = this;
        ((HongBaoListView)localObject1).jdField_d_of_type_Int = this.jdField_i_of_type_Int;
        ((HongBaoListView)localObject1).jdField_e_of_type_Int = this.jdField_j_of_type_Int;
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
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_d_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
      if (localObject == null) {
        return;
      }
      this.jdField_d_of_type_Boolean = false;
      if (!paramBoolean)
      {
        b(((Conversation)localObject).a(), this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.b(), this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.c());
        return;
      }
      localObject = ((Conversation)localObject).a();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.topMargin = (-this.k);
      ((View)localObject).setLayoutParams(localLayoutParams);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.c();
      ((View)localObject).setVisibility(8);
      if (this.jdField_e_of_type_Boolean) {
        ((View)localObject).setAlpha(0.0F);
      }
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Int != 3)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startGestureGuide return,  mState = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    int m = (int)this.jdField_a_of_type_AndroidViewViewGroup.getResources().getDimension(2131298289);
    int n = -this.jdField_a_of_type_ComTencentWidgetHongBaoListView.a();
    Object localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationY", new float[] { n, n + m });
    ((ObjectAnimator)localObject).setDuration(1500L);
    ((ObjectAnimator)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(200L);
    localObjectAnimator1.addListener(new ConversationHongBaoV2.8(this));
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator2.setDuration(500L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.play(localObjectAnimator1).after(1L);
    localAnimatorSet.play(localObjectAnimator2).after(1000L);
    localAnimatorSet.addListener(new ConversationHongBaoV2.9(this));
    localAnimatorSet.start();
    return true;
  }
  
  public void d()
  {
    F();
    b(true);
    B();
    if (this.jdField_a_of_type_Int == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "normalMode return for STATE_EMPTY");
      }
      return;
    }
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "normalMode return for hongbao not shown");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "normalMode");
    }
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
    FrameHelperActivity.a(true);
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.i();
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.m();
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.x();
    m();
    b();
    this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.g();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView);
    this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView = null;
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setHongBaoModeListScrollHeader(null);
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqPortalFormalView);
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed);
    this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    E();
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("normalMode,mState updated to STATE_EMPTY, mState = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
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
    ARMapHongBaoListView localARMapHongBaoListView = (ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376171);
    boolean bool;
    if ((!localARMapHongBaoListView.jdField_a_of_type_Boolean) && (!localARMapHongBaoListView.l)) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSpringFestivalPendantShowing isActivePendantShowing = ");
      localStringBuilder.append(localARMapHongBaoListView.jdField_a_of_type_Boolean);
      localStringBuilder.append(",isPendantShowing = ");
      localStringBuilder.append(localARMapHongBaoListView.l);
      localStringBuilder.append(",result = ");
      localStringBuilder.append(bool);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "hongbaoMode return for STATE_EMPTY");
      }
      return;
    }
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "hongbaoMode return for already show hongbao");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "hongbaoMode");
    }
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.k();
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.x();
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
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
  
  public boolean e()
  {
    return a().a();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Int != 5)
    {
      this.jdField_a_of_type_Int = 5;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showTask,mState updated to STATE_SHUA_YI_SHUA_END, ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
      }
      d();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.g((BaseActivityData)localObject);
    }
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
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
  
  public void g()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBeforeAccountChanged mState = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Int == -1) {
      return;
    }
    d();
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
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
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "postOnResume ");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, 800L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    if (m != 1001)
    {
      if (m != 1002)
      {
        if (m != 1005)
        {
          if (m != 1006)
          {
            if (m == 1008)
            {
              if (QLog.isColorLevel()) {
                QLog.d("2021_UI_ConversationHongBaoV2", 2, "handleMessage MSG_WHAT_SHOW_PREGUIDE ");
              }
              b();
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("2021_UI_ConversationHongBaoV2", 2, "handleMessage MSG_WHAT_PlAYSOUND_RING");
            }
            if (this.jdField_c_of_type_Boolean) {
              ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(4);
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("handleMessage MSG_WHAT_SHOWSHARE pullState = ");
          paramMessage.append(this.jdField_b_of_type_Int);
          paramMessage.append(",mState = ");
          paramMessage.append(this.jdField_a_of_type_Int);
          QLog.d("2021_UI_ConversationHongBaoV2", 2, paramMessage.toString());
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "handleMessage MSG_WHAT_POST_ONRESUME");
        }
        i();
      }
    }
    else
    {
      m();
      c();
    }
    return false;
  }
  
  public void i()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume() mState = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(",delayedShowSharePageTask = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2$ShowSharePageTask);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2$ShowSharePageTask;
    if (localObject != null)
    {
      ((ConversationHongBaoV2.ShowSharePageTask)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2$ShowSharePageTask = null;
    }
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.g();
      this.jdField_i_of_type_Boolean = true;
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      if (((Handler)localObject).hasMessages(1002)) {
        return;
      }
      this.jdField_c_of_type_Boolean = true;
      if (!a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "onResume() return for not showing hongbao");
        }
        return;
      }
      localObject = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      if ((!((SpringFestivalEntryManager)localObject).b()) && (this.jdField_a_of_type_ComTencentWidgetHongBaoListView != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "onResume hideHongbaoPendant");
        }
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.q();
        D();
      }
      FormalView localFormalView = this.jdField_a_of_type_ComTencentMobileqqPortalFormalView;
      if (localFormalView != null) {
        localFormalView.c();
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_f_of_type_Boolean) {
          b();
        }
        this.jdField_a_of_type_Boolean = false;
      }
      int m = this.jdField_a_of_type_Int;
      if (m != 2)
      {
        if (m == 3)
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.b();
          this.jdField_a_of_type_ComTencentWidgetHongBaoListView.o();
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "onResume refreshScheduleTask");
      }
      ((SpringFestivalEntryManager)localObject).c();
      k();
    }
  }
  
  public void j()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAndReportExpose isLeftDrawerOpen = ");
      ((StringBuilder)localObject).append(this.jdField_g_of_type_Boolean);
      ((StringBuilder)localObject).append(",mResume = ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.jdField_g_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      localObject = (ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376171);
      if (((ARMapHongBaoListView)localObject).jdField_a_of_type_Boolean) {
        e(e());
      }
      boolean bool1 = ((ARMapHongBaoListView)localObject).l;
      boolean bool2 = false;
      if (bool1)
      {
        if (this.jdField_a_of_type_Int == 3) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        e(bool1);
      }
      int m = ((BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368239)).a();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkAndReportExpose breathViewState = ");
        ((StringBuilder)localObject).append(m);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
      }
      if ((m == 2) || (m == 1))
      {
        bool1 = bool2;
        if (m == 2) {
          bool1 = true;
        }
        d(bool1);
      }
    }
  }
  
  public void k()
  {
    if (!a()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateState mState = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Int != 4) {
      return;
    }
    Object localObject = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (!FrameHelperActivity.b()))
    {
      ((SpringFestivalEntryManager)localObject).a(2);
      return;
    }
    ((SpringFestivalEntryManager)localObject).d();
    FrameHelperActivity.a(true);
  }
  
  public void l()
  {
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPause() isShowBrushResultPage = ");
      ((StringBuilder)localObject).append(this.jdField_h_of_type_Boolean);
      ((StringBuilder)localObject).append(",mState = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "onPause return for not showing hb");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalFormalView;
    if (localObject != null)
    {
      if (((FormalView)localObject).jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView != null) {
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.setPause(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.g();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView;
    if (localObject != null) {
      ((PrepareView)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetHongBaoListView;
    if (localObject != null) {
      ((HongBaoListView)localObject).p();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView;
    if (localObject != null) {
      ((BreathEffectView)localObject).g();
    }
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsCountDownTimer != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "onPause mTimerCountDown.cancel");
      }
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    k();
    localObject = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    UserData.UserDataItem localUserDataItem = ((SpringFestivalEntryManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a().id);
    localUserDataItem.totalGrabCountForShare = this.jdField_f_of_type_Int;
    localUserDataItem.maxComboCountForShare = this.jdField_g_of_type_Int;
    localUserDataItem.totalHitCountForShare = this.jdField_h_of_type_Int;
    ((SpringFestivalEntryManager)localObject).b();
    if (this.jdField_a_of_type_Int == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setAlpha(255);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.invalidate();
    }
    if (QLog.isColorLevel())
    {
      int m = this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.a();
      int n = this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.getVisibility();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" [dddd] onPause mProgressViewRed alpha = ");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(",visibility = ");
      ((StringBuilder)localObject).append(n);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void n()
  {
    this.jdField_g_of_type_Boolean = true;
    if (!a()) {
      return;
    }
    k();
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.getScrollY() != 0) {
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
    }
    b(true);
    FormalView localFormalView = this.jdField_a_of_type_ComTencentMobileqqPortalFormalView;
    if ((localFormalView != null) && (localFormalView.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.setPause(true);
    }
  }
  
  public void o()
  {
    this.jdField_g_of_type_Boolean = false;
    if (!a()) {
      return;
    }
    k();
    if ((this.jdField_a_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.getScrollY() == 0))
    {
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(-this.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(-this.jdField_d_of_type_Int);
    }
  }
  
  public void p()
  {
    if (!a()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPostThemeChanged mState = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Int != 3) {
      return;
    }
    m();
    c();
  }
  
  @TargetApi(11)
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "resetTitle");
    }
    View localView1 = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    View localView2 = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.c();
    if (localView1 != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
      localLayoutParams.topMargin = 0;
      localView1.setLayoutParams(localLayoutParams);
    }
    if (localView2 != null)
    {
      if (this.jdField_e_of_type_Boolean) {
        localView2.setAlpha(1.0F);
      }
      localView2.setVisibility(0);
    }
  }
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "reportBrushMainPageExpose");
    }
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    Object localObject1 = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    Object localObject2 = ((SpringFestivalEntryManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a().id);
    ((UserData.UserDataItem)localObject2).isAbnormalQuit = true;
    ((UserData.UserDataItem)localObject2).brushStartTsForReport = this.jdField_f_of_type_Long;
    ((SpringFestivalEntryManager)localObject1).a();
    localObject1 = new HashMap();
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
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
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "reportBrushBeginShua");
    }
    HashMap localHashMap = new HashMap();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
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
  
  public void t()
  {
    String str = String.valueOf((System.currentTimeMillis() - this.jdField_f_of_type_Long) / 1000L);
    this.jdField_f_of_type_Long = -1L;
    Object localObject1 = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    ((SpringFestivalEntryManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a().id).isAbnormalQuit = false;
    ((SpringFestivalEntryManager)localObject1).a();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportBrushMainPageQuit duration = ");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(",totalGrabCountForShare = ");
      ((StringBuilder)localObject1).append(this.jdField_f_of_type_Int);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new HashMap();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
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
    ((Map)localObject1).put("ext2", String.valueOf(this.jdField_f_of_type_Int));
    SpringHbReporter.a(ReportConstant.Event.l, 0, 0, (Map)localObject1, "quit");
  }
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "reportStaggerdPeakExpose");
    }
    HashMap localHashMap = new HashMap();
    BaseActivityData localBaseActivityData = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
    if (localBaseActivityData != null) {
      localHashMap.put("active_id", localBaseActivityData.id);
    }
    SpringHbReporter.a(ReportConstant.Event.k, 0, 0, localHashMap, "exp");
  }
  
  public void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "hideNormalActivityPendant");
    }
    ((ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376171)).e();
  }
  
  public void w()
  {
    a().g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2
 * JD-Core Version:    0.7.0.1
 */