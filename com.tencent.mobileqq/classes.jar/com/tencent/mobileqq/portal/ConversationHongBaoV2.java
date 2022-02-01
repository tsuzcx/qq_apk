package com.tencent.mobileqq.portal;

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
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "cleanListViewContainerBg conversationDrawable = " + this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setContentBackground(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  private void B()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "recoverListViewContainerBg conversationDrawable = " + this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "showTask,mState updated to STATE_SHUA_YI_SHUA_READY, " + this.jdField_a_of_type_Int);
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
    localLayoutParams.addRule(3, 2131378458);
    localLayoutParams.topMargin = 0;
    localView.setLayoutParams(localLayoutParams);
    this.jdField_j_of_type_Boolean = false;
  }
  
  private void F()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "clearTitleAnimation");
    }
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    }
    if (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator != null)
    {
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    }
  }
  
  private void G()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "showPrepareViewAnimation mState = " + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView != null) && (this.jdField_a_of_type_Int == 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.b();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1006);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1006, 500L);
    }
  }
  
  private void H()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "showRealPreGuide mHongBaoListView = " + this.jdField_a_of_type_ComTencentWidgetHongBaoListView);
    }
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null) {}
    int m;
    do
    {
      return;
      A();
      m = this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int;
      if (this.jdField_a_of_type_Int == 3)
      {
        int n = AIOUtils.a(100.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.a(m - n);
        return;
      }
    } while ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 5) && (this.jdField_a_of_type_Int != 4));
    G();
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.a(m);
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_Int != 2)
    {
      this.jdField_a_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "showPrepare,mState updated to STATE_YURE, " + this.jdField_a_of_type_Int);
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
    ArrayList localArrayList = null;
    if (paramSet != null)
    {
      localArrayList = new ArrayList();
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        Integer localInteger = (Integer)paramSet.next();
        PortalManager.ComboNumber localComboNumber = new PortalManager.ComboNumber();
        localComboNumber.number = localInteger.intValue();
        localArrayList.add(localComboNumber);
      }
    }
    return localArrayList;
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
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "doShowTitleAnim mTitleBarOffset = " + this.k);
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
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "doHideTitleAnim mTitleBarOffset = " + this.k);
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
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "saveActivityLeftCountDownDuration duration = " + paramLong);
    }
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    localSpringFestivalEntryManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a().id).leftCountDownDuration = paramLong;
    localSpringFestivalEntryManager.a();
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
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "refreshRedProgressBarTopMargin,statusTitle.w = " + localView.getWidth() + ",statusTitle.h = " + localView.getHeight() + ",statusTitleHeightInNormalState = " + n + ",mProgressViewRed cur topMargin = " + i1);
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
    return (ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376667);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "stopNormalActivityBreath");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView == null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView = ((BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368491));
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
    this.jdField_b_of_type_JavaLangStringBuilder.delete(0, this.jdField_b_of_type_JavaLangStringBuilder.length());
    if (m < 10) {
      this.jdField_b_of_type_JavaLangStringBuilder.append("0");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(m).append(":");
    if (n < 10) {
      this.jdField_b_of_type_JavaLangStringBuilder.append("0");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(n);
    this.jdField_b_of_type_JavaLangStringBuilder.append(".");
    if (i1 < 10) {
      this.jdField_b_of_type_JavaLangStringBuilder.append("0");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(i1);
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
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
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "showNewResultActivity, data " + paramBundle);
    }
    ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
    QPublicTransFragmentActivity.b(paramActivity, (Intent)localObject, RedPacketShowerFragment.class);
  }
  
  public void a(BaseActivityData paramBaseActivityData)
  {
    Object localObject1 = null;
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "showNormalActivityPendant");
    }
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    Object localObject2;
    String str;
    int n;
    int m;
    if (paramBaseActivityData.pendantData != null)
    {
      localObject1 = paramBaseActivityData.pendantData.pendantImgUrl;
      localObject2 = localSpringFestivalEntryManager.a(paramBaseActivityData.pendantData.pendantImgUrl, "");
      str = paramBaseActivityData.pendantData.jumpUrl;
      n = paramBaseActivityData.pendantData.closeType;
      m = paramBaseActivityData.pendantData.type;
    }
    for (;;)
    {
      ARMapHongBaoListView localARMapHongBaoListView = (ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376667);
      if (n != 0) {
        bool = true;
      }
      localARMapHongBaoListView.a((Bitmap)localObject2, bool);
      if ((paramBaseActivityData.pendantData != null) && (localObject2 == null)) {
        localSpringFestivalEntryManager.a(new ConversationHongBaoV2.17(this, (String)localObject1, localARMapHongBaoListView, localSpringFestivalEntryManager));
      }
      localObject1 = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      localObject2 = ((ITaskManager)localObject1).a();
      if ((!((UserData)localObject2).hasClickedHolder) && (!((UserData)localObject2).hasShowedMiniApp) && (m == 1))
      {
        localARMapHongBaoListView.c();
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "[showNormalActivityPendant] 吊坠动画展示");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "[showNormalActivityPendant] 初始化 userData.hasClickedHolder = " + ((UserData)localObject2).hasClickedHolder + " userData.hasShowedMiniApp = " + ((UserData)localObject2).hasShowedMiniApp);
      }
      e(e());
      localARMapHongBaoListView.setOnPendentClickListener(new ConversationHongBaoV2.18(this, str, localARMapHongBaoListView, (ITaskManager)localObject1, paramBaseActivityData, n));
      D();
      return;
      m = 0;
      n = 0;
      str = null;
      localObject2 = null;
    }
  }
  
  public void a(OnGrabActivityData paramOnGrabActivityData)
  {
    boolean bool2 = true;
    Bitmap localBitmap = null;
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    UserData.UserDataItem localUserDataItem = localSpringFestivalEntryManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a().id);
    long l = localUserDataItem.leftCountDownDuration;
    boolean bool3 = localSpringFestivalEntryManager.b();
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "showShuaYiShuaTask leftCountDownDuration = " + l + ",isPendantShowSwitchOn = " + bool3 + ",mState = " + this.jdField_a_of_type_Int);
    }
    if ((paramOnGrabActivityData.id.equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Int == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "showShuaYiShuaTask return for already STATE_SHUA_YI_SHUA_READY ,taskID = " + this.jdField_b_of_type_JavaLangString);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share = paramOnGrabActivityData.shareData;
    c();
    this.jdField_b_of_type_JavaLangString = paramOnGrabActivityData.id;
    if (paramOnGrabActivityData.pendantData != null) {}
    for (int m = paramOnGrabActivityData.pendantData.closeType;; m = 0)
    {
      boolean bool1;
      label214:
      Object localObject1;
      Object localObject2;
      if (m != 0)
      {
        bool1 = true;
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(bool1);
        if ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_Int != 5))
        {
          e();
          this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setComboListener(this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener);
          this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(0);
        }
        localObject1 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.bgUrl, "qq_hongbao_formal_bg");
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setBackground(null, (Bitmap)localObject1);
        localObject1 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.leftCloudImgUrl, "qq_hongbao_cloud_ing_left");
        localObject2 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.rightCloudImgUrl, "qq_hongbao_cloud_ing_right");
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setCloudBmp((Bitmap)localObject1, (Bitmap)localObject2);
        localObject1 = a(localSpringFestivalEntryManager.a().commonData.comboNumberSet);
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setComboNumberList((List)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Int = 2;
        this.jdField_c_of_type_JavaLangString = paramOnGrabActivityData.grabWording;
        this.jdField_a_of_type_JavaLangString = paramOnGrabActivityData.tipBarWording;
        if (l >= 0L) {
          break label701;
        }
        C();
        label405:
        localObject2 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.logoImgUrl, "");
        localObject1 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.nameImgUrl, "");
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressLogo((Bitmap)localObject2, false);
        if (localObject2 == null) {
          localSpringFestivalEntryManager.a(new ConversationHongBaoV2.5(this, paramOnGrabActivityData.logoImgUrl, localSpringFestivalEntryManager));
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressNameBitmap((Bitmap)localObject1, null, false);
        if (localObject1 == null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentWidgetHongBaoListView.getResources().getDrawable(2130845542);
          if (!(localObject2 instanceof SkinnableBitmapDrawable)) {
            break label722;
          }
          localObject1 = ((SkinnableBitmapDrawable)localObject2).getBitmap();
        }
      }
      label514:
      label701:
      label722:
      label754:
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressNameBitmap((Bitmap)localObject1, null, false);
        localSpringFestivalEntryManager.a(new ConversationHongBaoV2.6(this, paramOnGrabActivityData.nameImgUrl, localSpringFestivalEntryManager));
        if (paramOnGrabActivityData.pendantData != null)
        {
          localObject1 = paramOnGrabActivityData.pendantData.pendantImgUrl;
          localBitmap = localSpringFestivalEntryManager.a(paramOnGrabActivityData.pendantData.pendantImgUrl, "");
        }
        for (;;)
        {
          localObject2 = this.jdField_a_of_type_ComTencentWidgetHongBaoListView;
          if (this.jdField_a_of_type_Int != 3) {}
          for (bool1 = bool2;; bool1 = false)
          {
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
            if (this.jdField_a_of_type_Int != 3) {
              break;
            }
            A();
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1008, 200L);
            return;
            bool1 = false;
            break label214;
            if (l == 0L)
            {
              f();
              return;
            }
            b(l);
            break label405;
            if (!(localObject2 instanceof BitmapDrawable)) {
              break label754;
            }
            localObject1 = ((BitmapDrawable)localObject2).getBitmap();
            break label514;
          }
          localObject1 = null;
        }
      }
    }
  }
  
  public void a(OnGrabActivityData paramOnGrabActivityData, long paramLong)
  {
    String str = null;
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "showPrepareCountDown,mState = " + this.jdField_a_of_type_Int + ",taskID = " + this.jdField_b_of_type_JavaLangString + ",prepareCountDownMs = " + paramLong);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelOnGrabActivityData$Share = paramOnGrabActivityData.shareData;
    c();
    if (paramOnGrabActivityData.pendantData != null) {}
    for (int m = paramOnGrabActivityData.pendantData.closeType;; m = 0)
    {
      if (m != 0) {
        bool = true;
      }
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(bool);
      this.jdField_b_of_type_JavaLangString = paramOnGrabActivityData.id;
      SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setMode(2);
      Bitmap localBitmap1 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.bgUrl, "");
      Bitmap localBitmap2 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.logoImgUrl, "");
      Bitmap localBitmap4 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.leftCloudUrl, "");
      Bitmap localBitmap5 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.rightCloudUrl, "");
      Bitmap localBitmap6 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.greetImgUrl, "");
      Bitmap localBitmap3 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.previewEntryData.nameImgUrl, "");
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setBackground(localBitmap1, localBitmap2, localBitmap4, localBitmap5, localBitmap6, localBitmap3);
      I();
      if (paramOnGrabActivityData.pendantData != null)
      {
        localBitmap1 = localSpringFestivalEntryManager.a(paramOnGrabActivityData.pendantData.pendantImgUrl, "");
        str = paramOnGrabActivityData.pendantData.pendantImgUrl;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setLogo(localBitmap1, true);
        if ((paramOnGrabActivityData.pendantData != null) && (localBitmap1 == null)) {
          localSpringFestivalEntryManager.a(new ConversationHongBaoV2.14(this, str, localSpringFestivalEntryManager));
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setLogo(localBitmap2, localBitmap3);
        if (localBitmap2 == null) {
          localSpringFestivalEntryManager.a(new ConversationHongBaoV2.15(this, paramOnGrabActivityData.previewEntryData.logoImgUrl, localSpringFestivalEntryManager));
        }
        if (localBitmap3 == null) {
          localSpringFestivalEntryManager.a(new ConversationHongBaoV2.16(this, paramOnGrabActivityData.previewEntryData.nameImgUrl, localSpringFestivalEntryManager));
        }
        bool = localSpringFestivalEntryManager.b();
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "showPrepareCountDown,mState = " + this.jdField_a_of_type_Int + ",taskID = " + this.jdField_b_of_type_JavaLangString + ",isPendantShowSwitchOn = " + bool);
        }
        if (paramLong >= 0L) {
          this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.a(paramLong);
        }
        for (;;)
        {
          if ((localSpringFestivalEntryManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a().id).hasClickCloseBtn) || (!bool))
          {
            if (QLog.isColorLevel()) {
              QLog.d("2021_UI_ConversationHongBaoV2", 2, "showPrepareCountDown hide pendant");
            }
            this.jdField_a_of_type_ComTencentWidgetHongBaoListView.q();
          }
          D();
          return;
          this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.a();
        }
        localBitmap1 = null;
      }
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "onLogout mState = " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int == -1) {
      return;
    }
    d();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "showNormalActivityBreath isRed = " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView == null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView = ((BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368491));
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
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "onBrashRequestResult, mState = " + this.jdField_a_of_type_Int + ",hit = " + paramBoolean + ",resultTips = " + paramString + ",data = " + paramBundle + ",mResume = " + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Int != 4) {
      QLog.d("2021_UI_ConversationHongBaoV2", 1, "onBrashRequestResult return, mState = " + this.jdField_a_of_type_Int + ",hit = " + paramBoolean + ",resultTips = " + paramString + ",data = " + paramBundle + ",mResume = " + this.jdField_c_of_type_Boolean);
    }
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
    } while (!this.jdField_c_of_type_Boolean);
    this.jdField_h_of_type_Int += 1;
    a(this.jdField_a_of_type_AndroidAppActivity, paramBundle);
    this.jdField_h_of_type_Boolean = true;
    paramString = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    paramString.a(new RedPacketResultData(paramBundle));
    paramString.a(1);
    paramString.e();
    return;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(paramString);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Int == -1) || (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null)) {}
    while ((!this.jdField_a_of_type_ComTencentWidgetHongBaoListView.mForHongBao) || (!this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_i_of_type_Boolean)) {
      return false;
    }
    return true;
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
    FrameHelperActivity.b(true);
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
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "startCountDown , countDownDuration = " + paramLong + ",mState = " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int != 4)
    {
      this.jdField_a_of_type_Int = 4;
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "startCountDown,mState updated to STATE_SHUA_YI_SHUA_COUNTDOWN, " + this.jdField_a_of_type_Int);
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
    long l2;
    if (paramLong == -1L)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.b(true);
      r();
      l2 = ((OnGrabActivityData)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a()).playDuration * 1000;
      l1 = l2;
      if (((SpringFestivalEntryManager)localObject).c())
      {
        int m = ((SpringFestivalEntryManager)localObject).a();
        l2 /= m;
        l1 = l2;
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "startCountDown SpeedUp countDownDuration = " + l2 + ", ratio = " + m);
        }
      }
    }
    for (long l1 = l2;; l1 = paramLong)
    {
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
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "startCountDown brushStartTsForReport = " + this.jdField_f_of_type_Long);
        }
      }
      x();
      QLog.d("2021_UI_ConversationHongBaoV2", 1, "startCountDown countDownDuration = " + paramLong + ",realCountDownDuration = " + l1 + "，totalGrabCountForShare = " + this.jdField_f_of_type_Int + "，maxComboCountForShare = " + this.jdField_g_of_type_Int);
      this.jdField_a_of_type_AndroidOsCountDownTimer = new ConversationHongBaoV2.3(this, l1, 40L, ((OnGrabActivityData)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a()).playDuration * 1000);
      this.jdField_a_of_type_AndroidOsCountDownTimer.start();
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.d();
      }
    }
  }
  
  @TargetApi(11)
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "showTitle direct = " + paramBoolean + ",mTitleIsVisible = " + this.jdField_d_of_type_Boolean);
    }
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
      {
        this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
        this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      }
      q();
      this.jdField_d_of_type_Boolean = true;
    }
    do
    {
      return;
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
    } while ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null) || (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()));
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "showTitle do resetTitle");
    }
    q();
    return;
    this.jdField_d_of_type_Boolean = true;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.b(), this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.c());
  }
  
  public boolean b()
  {
    if (FrameHelperActivity.b()) {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "showPreGuide" + this.jdField_a_of_type_Int);
      }
    }
    while (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null) {
      return false;
    }
    H();
    return true;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "ensureInit mState = " + this.jdField_a_of_type_Int);
    }
    int m;
    if (this.jdField_a_of_type_Int == -1)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363407));
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView = ((HongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376667));
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.l();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 = this;
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298285));
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
      if ((localObject == null) || (((View)localObject).getBottom() - ((View)localObject).getTop() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "ensureInit title = " + localObject);
        }
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int = (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_d_of_type_Int - AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        this.jdField_i_of_type_Int = this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_d_of_type_Int;
        this.jdField_j_of_type_Int = this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "ensureInit backgroundBannerHeight = " + this.jdField_i_of_type_Int + ", bannerHeightWithoutTitlebar = " + this.jdField_j_of_type_Int);
        }
        this.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298290));
        this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView = ((BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368491));
        this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView = new PrepareView(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView = new FormalView(this.jdField_a_of_type_AndroidAppActivity);
        localObject = new ViewGroup.LayoutParams(-1, -1);
        this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView);
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalFormalView);
        this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed = new ProgressViewRed(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setTextSize(0, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298325));
        m = (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298286);
        localObject = new FrameLayout.LayoutParams(-1, m);
        ((FrameLayout.LayoutParams)localObject).topMargin = (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_d_of_type_Int - this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int);
        this.jdField_d_of_type_Int = m;
        this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368495));
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ConversationHongBaoV2.4(this));
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.b(this.jdField_a_of_type_AndroidViewViewGroup);
        this.jdField_a_of_type_Int = 1;
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "ensureInit,mState updated to STATE_INITED, " + this.jdField_a_of_type_Int + ",mProgressViewRed topMargin = " + ((FrameLayout.LayoutParams)localObject).topMargin);
        }
        label613:
        return;
      }
      m = ((View)localObject).getBottom() - ((View)localObject).getTop();
      int n = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "ensureInit statusTitleHeight = " + m + ",statusTitleHeightInNormalState = " + n);
      }
      if (n <= 0) {
        break label737;
      }
      m = n;
    }
    label737:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int = (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_d_of_type_Int - m);
      break;
      if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null) {
        break label613;
      }
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 = this;
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_d_of_type_Int = this.jdField_i_of_type_Int;
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int = this.jdField_j_of_type_Int;
      return;
    }
  }
  
  @TargetApi(11)
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "hideTitle direct = " + paramBoolean + ",mTitleIsVisible = " + this.jdField_d_of_type_Boolean);
    }
    if ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation == null)) {
      return;
    }
    this.jdField_d_of_type_Boolean = false;
    if (!paramBoolean)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.b(), this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.c());
      return;
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.topMargin = (-this.k);
    localView.setLayoutParams(localLayoutParams);
    localView = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.c();
    localView.setVisibility(8);
    if (this.jdField_e_of_type_Boolean) {
      localView.setAlpha(0.0F);
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Int != 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "startGestureGuide return,  mState = " + this.jdField_a_of_type_Int);
      }
      return false;
    }
    int m = (int)this.jdField_a_of_type_AndroidViewViewGroup.getResources().getDimension(2131298294);
    int n = -this.jdField_a_of_type_ComTencentWidgetHongBaoListView.a();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationY", new float[] { n, n + m });
    localObjectAnimator1.setDuration(1500L);
    localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator2.setDuration(200L);
    localObjectAnimator2.addListener(new ConversationHongBaoV2.8(this));
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator3.setDuration(500L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1);
    localAnimatorSet.play(localObjectAnimator2).after(1L);
    localAnimatorSet.play(localObjectAnimator3).after(1000L);
    localAnimatorSet.addListener(new ConversationHongBaoV2.9(this));
    localAnimatorSet.start();
    return true;
  }
  
  public void d()
  {
    F();
    b(true);
    B();
    if (this.jdField_a_of_type_Int == -1) {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "normalMode return for STATE_EMPTY");
      }
    }
    do
    {
      do
      {
        return;
        if (a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "normalMode return for hongbao not shown");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "normalMode");
      }
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
      FrameHelperActivity.b(true);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.i();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.m();
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.y();
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
    } while (!QLog.isColorLevel());
    QLog.d("2021_UI_ConversationHongBaoV2", 2, "normalMode,mState updated to STATE_EMPTY, mState = " + this.jdField_a_of_type_Int);
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "reportBreathLightExpose isRedLight = " + paramBoolean);
    }
    HashMap localHashMap = new HashMap();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
    if (localObject != null)
    {
      localHashMap.put("active_id", ((BaseActivityData)localObject).id);
      if (!paramBoolean) {
        break label101;
      }
    }
    label101:
    for (localObject = "2";; localObject = "1")
    {
      localHashMap.put("refer", localObject);
      SpringHbReporter.a(ReportConstant.Event.j, 0, 0, localHashMap, "exp");
      return;
    }
  }
  
  public boolean d()
  {
    ARMapHongBaoListView localARMapHongBaoListView = (ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376667);
    if ((localARMapHongBaoListView.jdField_a_of_type_Boolean) || (localARMapHongBaoListView.l)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "isSpringFestivalPendantShowing isActivePendantShowing = " + localARMapHongBaoListView.jdField_a_of_type_Boolean + ",isPendantShowing = " + localARMapHongBaoListView.l + ",result = " + bool);
      }
      return bool;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Int == -1) {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "hongbaoMode return for STATE_EMPTY");
      }
    }
    do
    {
      return;
      if (!a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("2021_UI_ConversationHongBaoV2", 2, "hongbaoMode return for already show hongbao");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "hongbaoMode");
    }
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.k();
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.y();
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "reportPendantExpose isSpreadFlower = " + paramBoolean);
    }
    HashMap localHashMap = new HashMap();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
    if (localObject != null)
    {
      localHashMap.put("active_id", ((BaseActivityData)localObject).id);
      localHashMap.put("refer", String.valueOf(((BaseActivityData)localObject).type));
    }
    if (paramBoolean) {}
    for (localObject = "2";; localObject = "1")
    {
      localHashMap.put("op_via", localObject);
      SpringHbReporter.a(ReportConstant.Event.i, 0, 0, localHashMap, "exp");
      return;
    }
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
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "showTask,mState updated to STATE_SHUA_YI_SHUA_END, " + this.jdField_a_of_type_Int);
      }
      d();
      BaseActivityData localBaseActivityData = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.g(localBaseActivityData);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "reportPendantClick isSpreadFlower = " + paramBoolean);
    }
    HashMap localHashMap = new HashMap();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
    if (localObject != null)
    {
      localHashMap.put("active_id", ((BaseActivityData)localObject).id);
      localHashMap.put("refer", String.valueOf(((BaseActivityData)localObject).type));
    }
    if (paramBoolean) {}
    for (localObject = "2";; localObject = "1")
    {
      localHashMap.put("op_via", localObject);
      SpringHbReporter.a(ReportConstant.Event.i, 0, 0, localHashMap, "clk");
      return;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "onBeforeAccountChanged mState = " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int == -1) {
      return;
    }
    d();
  }
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "reportPendantCloseBtnClick isSpreadFlower = " + paramBoolean);
    }
    HashMap localHashMap = new HashMap();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
    if (localObject != null)
    {
      localHashMap.put("active_id", ((BaseActivityData)localObject).id);
      localHashMap.put("refer", String.valueOf(((BaseActivityData)localObject).type));
    }
    if (paramBoolean) {}
    for (localObject = "2";; localObject = "1")
    {
      localHashMap.put("op_via", localObject);
      SpringHbReporter.a(ReportConstant.Event.i, 0, 0, localHashMap, "close");
      return;
    }
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
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      m();
      c();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "handleMessage MSG_WHAT_POST_ONRESUME");
      }
      i();
      continue;
      if (QLog.isColorLevel())
      {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "handleMessage MSG_WHAT_SHOWSHARE pullState = " + this.jdField_b_of_type_Int + ",mState = " + this.jdField_a_of_type_Int);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "handleMessage MSG_WHAT_SHOW_PREGUIDE ");
        }
        b();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, "handleMessage MSG_WHAT_PlAYSOUND_RING");
        }
        if (this.jdField_c_of_type_Boolean) {
          ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(4);
        }
      }
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "onResume() mState = " + this.jdField_a_of_type_Int + ",delayedShowSharePageTask = " + this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2$ShowSharePageTask);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2$ShowSharePageTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2$ShowSharePageTask.a();
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2$ShowSharePageTask = null;
    }
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.g();
      this.jdField_i_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_AndroidOsHandler == null) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1002))) {}
    do
    {
      return;
      this.jdField_c_of_type_Boolean = true;
      if (a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("2021_UI_ConversationHongBaoV2", 2, "onResume() return for not showing hongbao");
    return;
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    if ((!localSpringFestivalEntryManager.b()) && (this.jdField_a_of_type_ComTencentWidgetHongBaoListView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "onResume hideHongbaoPendant");
      }
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.q();
      D();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.c();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_f_of_type_Boolean) {
        b();
      }
      this.jdField_a_of_type_Boolean = false;
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "onResume refreshScheduleTask");
      }
      localSpringFestivalEntryManager.c();
      k();
      return;
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.a();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.b();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.o();
    }
  }
  
  public void j()
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "checkAndReportExpose isLeftDrawerOpen = " + this.jdField_g_of_type_Boolean + ",mResume = " + this.jdField_c_of_type_Boolean);
    }
    if ((!this.jdField_g_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      ARMapHongBaoListView localARMapHongBaoListView = (ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376667);
      if (localARMapHongBaoListView.jdField_a_of_type_Boolean) {
        e(e());
      }
      if (localARMapHongBaoListView.l)
      {
        if (this.jdField_a_of_type_Int != 3) {
          break label190;
        }
        bool1 = true;
        e(bool1);
      }
      int m = ((BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368491)).a();
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "checkAndReportExpose breathViewState = " + m);
      }
      if ((m == 2) || (m == 1)) {
        if (m != 2) {
          break label195;
        }
      }
    }
    label190:
    label195:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      d(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void k()
  {
    if (!a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "updateState mState = " + this.jdField_a_of_type_Int);
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_b_of_type_Boolean) || (FrameHelperActivity.b()))
    {
      localSpringFestivalEntryManager.d();
      FrameHelperActivity.b(true);
      return;
    }
    localSpringFestivalEntryManager.a(2);
  }
  
  public void l()
  {
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "onPause() isShowBrushResultPage = " + this.jdField_h_of_type_Boolean + ",mState = " + this.jdField_a_of_type_Int);
    }
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "onPause return for not showing hb");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView != null) {
          this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.setPause(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.g();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView != null) {
        this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.c();
      }
      if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView != null) {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.p();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView != null) {
        this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.g();
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
      SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      UserData.UserDataItem localUserDataItem = localSpringFestivalEntryManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a().id);
      localUserDataItem.totalGrabCountForShare = this.jdField_f_of_type_Int;
      localUserDataItem.maxComboCountForShare = this.jdField_g_of_type_Int;
      localUserDataItem.totalHitCountForShare = this.jdField_h_of_type_Int;
      localSpringFestivalEntryManager.b();
      if (this.jdField_a_of_type_Int == 4)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setAlpha(255);
        this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.invalidate();
      }
    } while (!QLog.isColorLevel());
    int m = this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.a();
    int n = this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.getVisibility();
    QLog.d("2021_UI_ConversationHongBaoV2", 2, " [dddd] onPause mProgressViewRed alpha = " + m + ",visibility = " + n);
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
    if (!a()) {}
    do
    {
      return;
      k();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
      if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.getScrollY() != 0) {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
      }
      b(true);
    } while ((this.jdField_a_of_type_ComTencentMobileqqPortalFormalView == null) || (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView == null));
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.setPause(true);
  }
  
  public void o()
  {
    this.jdField_g_of_type_Boolean = false;
    if (!a()) {}
    do
    {
      return;
      k();
    } while ((this.jdField_a_of_type_Int != 4) || (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.getScrollY() != 0));
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(-this.jdField_d_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(-this.jdField_d_of_type_Int);
  }
  
  public void p()
  {
    if (!a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "onPostThemeChanged mState = " + this.jdField_a_of_type_Int);
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
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
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "reportBrushMainPageExpose isAbnormalQuit true, id = " + (String)localObject2);
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
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "reportBrushBeginShua, id = " + (String)localObject);
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
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "reportBrushMainPageQuit duration = " + str + ",totalGrabCountForShare = " + this.jdField_f_of_type_Int);
    }
    localObject1 = new HashMap();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a();
    if (localObject2 != null)
    {
      localObject2 = ((BaseActivityData)localObject2).id;
      ((Map)localObject1).put("active_id", localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "reportBrushMainPageExpose isAbnormalQuit false, id = " + (String)localObject2);
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
    ((ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376667)).e();
  }
  
  public void w()
  {
    a().g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2
 * JD-Core Version:    0.7.0.1
 */