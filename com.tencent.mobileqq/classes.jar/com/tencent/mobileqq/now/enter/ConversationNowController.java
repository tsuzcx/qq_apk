package com.tencent.mobileqq.now.enter;

import afmu;
import afmv;
import afmw;
import afmx;
import afmy;
import afmz;
import afna;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.now.enter.widget.HongBao2018ListView;
import com.tencent.mobileqq.now.enter.widget.HongbaoListViewEventCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ConversationNowController
  implements Handler.Callback, HongbaoListViewEventCallback
{
  protected final int a;
  protected long a;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new afmu(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateDecelerateInterpolator();
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Animator.AnimatorListener jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener;
  private ValueAnimator jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private HongBao2018ListView jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView;
  public WeakReferenceHandler a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new afmy(this);
  private String jdField_a_of_type_JavaLangString;
  protected boolean a;
  protected final int b;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Animator.AnimatorListener jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener;
  private ValueAnimator jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator;
  private WeakReferenceHandler jdField_b_of_type_ComTencentUtilWeakReferenceHandler;
  protected boolean b;
  protected final int c;
  public boolean c;
  protected int d;
  public boolean d;
  protected int e;
  private boolean e;
  protected int f;
  private boolean f;
  private int g = 0;
  private int h;
  private int i;
  private int j = -1;
  private int k;
  private int l;
  
  public ConversationNowController(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 2;
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = VersionUtils.e();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363941));
    this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView = ((HongBao2018ListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363948));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(16908307);
    this.jdField_e_of_type_Int = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 10.0F);
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int n = (int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131558448);
    if (ImmersiveUtils.isSupporImmersive() == 1) {}
    for (int m = ImmersiveUtils.a(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());; m = 0)
    {
      this.k = (m + n);
      this.l = (this.k + (int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131559469));
      this.h = ((int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131559470));
      this.i = ((int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131559471));
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1003);
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1003);
      return;
    }
  }
  
  private void a(View paramView1, View paramView2)
  {
    this.j = (((RelativeLayout.LayoutParams)paramView2.getLayoutParams()).topMargin + paramView2.getHeight());
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.addRule(3, 0);
    paramView2.topMargin = this.j;
    paramView1.setLayoutParams(paramView2);
    this.jdField_f_of_type_Boolean = true;
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, View paramView3)
  {
    if (!this.jdField_f_of_type_Boolean) {
      a(paramView2, paramView1);
    }
    if (this.j <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new afmv(this, paramView2, paramView1, paramView3));
      this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new afmw(this, paramView3);
    }
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  @TargetApi(11)
  private void b(View paramView1, View paramView2, View paramView3)
  {
    if (!this.jdField_f_of_type_Boolean) {
      a(paramView2, paramView1);
    }
    if (this.j <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new afmz(this, paramView2, paramView1, paramView3));
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new afna(this, paramView3, paramView1);
    }
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  private void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationNowController", 2, new Object[] { "[showPullRefreshBanner] isFake=", Boolean.valueOf(paramBoolean) });
    }
    if (((paramBoolean) && (this.g == 2)) || ((!paramBoolean) && (this.g == 1))) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() == null))
    {
      m = (int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131559469);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, m);
      localLayoutParams.topMargin = this.k;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
      this.l = (m + this.k);
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup == null)
    {
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130969144, null));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131365334));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131365335));
    }
    if (paramBoolean) {}
    for (int m = 2;; m = 1)
    {
      b(m);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setNewYearOverScrollHeader(null);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setNewYearOverScrollHeader(this.jdField_b_of_type_AndroidViewViewGroup);
      return;
    }
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationNowController", 2, new Object[] { "[hidePullRefreshBanner] mBannerMode=", Integer.valueOf(this.g) });
    }
    if ((this.g == 1) || (this.g == 2)) {
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setNewYearOverScrollHeader(null);
    }
  }
  
  private void o()
  {
    switch (this.g)
    {
    default: 
      return;
    case 3: 
      e();
      return;
    }
    d(false);
    h();
  }
  
  public void a()
  {
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("ConversationNowController", 2, "[swithNormalMode] enter:" + bool + ",bannerMode:" + this.g);
    }
    if (this.g == 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationNowController", 2, "normalMode");
    }
    a(0);
    n();
    b(0);
    this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.b();
    if (((this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.jdField_a_of_type_ComTencentWidgetOverScrollViewListener == null)) && (this.jdField_a_of_type_ComTencentMobileqqActivityConversation != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConversationNowController", 2, "[swithNormalMode] set overscroll status");
      }
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setOverScrollListener(this.jdField_a_of_type_ComTencentMobileqqActivityConversation);
    }
    this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setEnableTouch(true);
    this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.a(false, false);
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(null);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationNowController", 2, "springBackPromptly, offset=" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.springBackTo(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(HongBao2018ListView paramHongBao2018ListView)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(HongBao2018ListView paramHongBao2018ListView, boolean paramBoolean)
  {
    int m;
    if (this.g == 1)
    {
      m = -paramHongBao2018ListView.getScrollY();
      if (m > 0) {
        break label19;
      }
    }
    label19:
    label240:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (m >= this.h) {
              break;
            }
            if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            }
          } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityConversation != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.i))
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setText("正在刷新...");
            return;
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setText("下拉刷新");
          return;
          if ((m >= this.i) && ((m < this.i) || (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView == null) || (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.a()))) {
            break label240;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityConversation == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityConversation.i)) {
            break;
          }
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          }
        } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText("正在刷新...");
        return;
        if (this.jdField_a_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText("释放立即刷新");
        }
      } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("继续下拉进入全民闯关");
      return;
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("继续下拉进入全民闯关");
  }
  
  public void a(String paramString)
  {
    QLog.d("ConversationNowController", 1, "[showNowRefreshEntrance] ,url:" + paramString);
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131364912);
      if (localView == null) {}
    }
    try
    {
      localView.setBackgroundResource(2130839539);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setHongbaoEventCallback(this);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.c();
      e(false);
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("ConversationNowController", 1, "[showNowRefreshEntrance] frame.setBackgroundResource oom=", localOutOfMemoryError);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ConversationNowController", 1, "[showNowRefreshEntrance] frame.setBackgroundResource error=", localException);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.g == 1)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label58;
        }
      }
    }
    label58:
    for (String str = "刷新成功";; str = "刷新失败")
    {
      localTextView.setText(str);
      return;
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityConversation == null)) {}
    while (this.g == 0) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_d_of_type_Int = 0;
    if (this.g == 0) {}
    this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.a(false, false);
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setBannerMode(this.g);
    if ((this.g == 1) || (this.g == 2))
    {
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setCanEnterActive(true);
      return;
    }
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setCanEnterActive(false);
  }
  
  public void b(HongBao2018ListView paramHongBao2018ListView)
  {
    this.jdField_a_of_type_Boolean = false;
    if ((this.g == 1) || (this.g == 2))
    {
      m = -paramHongBao2018ListView.getScrollY();
      if (m <= 0) {
        return;
      }
      if (((m >= this.h) && (m <= this.i)) || ((m > this.i) && (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView != null) && (!this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.a()))) {
        if (this.g == 1)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.i) {
            break label293;
          }
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if (this.jdField_b_of_type_AndroidWidgetTextView != null)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetTextView.setText("正在刷新...");
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(paramHongBao2018ListView);
        }
      }
    }
    label291:
    label293:
    for (int m = 1;; m = 0)
    {
      a(-this.h);
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null)) {
          break label291;
        }
        paramHongBao2018ListView = (NowEnterManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(264);
        if (paramHongBao2018ListView == null) {
          break;
        }
        int n = paramHongBao2018ListView.a();
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a("dc00899").b("Grp_AIO").c("year_icon").d("scroll_down").a(new String[] { String.valueOf(n) }).a(new String[] { String.valueOf(m) }).a();
        return;
        a(0);
        m = 0;
        continue;
        if (m < this.h) {
          a(0);
        }
        m = 0;
      }
      break;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int m = 2;; m = 1)
    {
      this.jdField_d_of_type_Int = m;
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.a(true, paramBoolean);
      return;
    }
  }
  
  public void c()
  {
    this.jdField_f_of_type_Int += 1;
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
    QLog.d("ConversationNowController", 1, new Object[] { "[addPendantShowReport] times:", Integer.valueOf(this.jdField_f_of_type_Int), " lastTime:", Long.valueOf(this.jdField_a_of_type_Long) });
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityConversation != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label104;
      }
      QLog.d("ConversationNowController", 1, "[addPendantShowReport] uin null");
    }
    label104:
    do
    {
      return;
      if (this.jdField_f_of_type_Int < 10) {
        break;
      }
      int m = this.jdField_f_of_type_Int;
      this.jdField_f_of_type_Int = 0;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityConversation == null);
    QLog.d("ConversationNowController", 1, "[addPendantShowReport] real report");
    return;
    QLog.d("ConversationNowController", 1, "[addPendantShowReport] not report, just save to sp");
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
      {
        this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
        this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      }
      g();
      this.jdField_c_of_type_Boolean = true;
    }
    while (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ConversationNowController", 2, "[showTitle]");
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.d());
  }
  
  public void d()
  {
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void d(boolean paramBoolean)
  {
    if ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityConversation == null)) {
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("ConversationNowController", 2, "[hideTitle]");
    }
    if (!paramBoolean)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.d());
      return;
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.topMargin = (-this.j);
    localView.setLayoutParams(localLayoutParams);
    localView = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.d();
    localView.setVisibility(8);
    if (this.jdField_d_of_type_Boolean) {
      localView.setAlpha(0.0F);
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationNowController", 2, "[retainCountdownBanner]");
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationNowController", 2, "[onActivePendantClick]");
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(3, 100L);
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      long l1 = ((NowHongbaoPushManager)localQQAppInterface.getManager(265)).a(3);
      ReportController.b(localQQAppInterface, "dc00899", "Grp_AIO", "", "year_icon", "upicon_click", 0, 0, l1 + "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.i("now_enter.pendant", 2, "report Pendant click, pushId=" + l1);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("now_enter.pendant", 2, "report Pendant click, exception:" + localException);
    }
  }
  
  @TargetApi(11)
  public void g()
  {
    View localView1 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b();
    View localView2 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.d();
    if (localView1 != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
      localLayoutParams.topMargin = 0;
      localView1.setLayoutParams(localLayoutParams);
    }
    if (localView2 != null)
    {
      if (this.jdField_d_of_type_Boolean) {
        localView2.setAlpha(1.0F);
      }
      localView2.setVisibility(0);
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationNowController", 2, "[hideList]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      QLog.e("ConversationNowController", 1, "[hideList] mActivity null");
    }
    do
    {
      return;
      if ((this.g == 0) || (!this.jdField_e_of_type_Boolean))
      {
        QLog.e("ConversationNowController", 1, new Object[] { "[hideList] mCanEnterActivity=", Boolean.valueOf(this.jdField_e_of_type_Boolean) });
        return;
      }
      m = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().heightPixels - this.k;
      int n = m - Math.abs(this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.getScrollY()) + this.i;
      float f2 = n / m;
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      long l1 = (f1 * 500.0F);
      localObject1 = new AnimationSet(false);
      Object localObject2 = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, 0.0F, 0, n);
      ((TranslateAnimation)localObject2).setDuration(l1);
      ((TranslateAnimation)localObject2).setInterpolator(new AccelerateInterpolator());
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(l1);
      ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
      ((AnimationSet)localObject1).addAnimation(localAlphaAnimation);
      ((AnimationSet)localObject1).setFillAfter(true);
      localObject2 = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject2).setDuration(l1);
      ((AlphaAnimation)localObject2).setFillAfter(true);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.postDelayed(new afmx(this), l1);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.a(false);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.startAnimation((Animation)localObject1);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.clearAnimation();
        this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject2);
      }
      localObject1 = (NowEnterManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(264);
    } while (localObject1 == null);
    int m = ((NowEnterManager)localObject1).a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {}
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;; localObject1 = null)
    {
      new ReportTask((QQAppInterface)localObject1).a("dc00899").b("Grp_AIO").c("year_icon").d("scroll_down").a(new String[] { String.valueOf(m) }).a(new String[] { "2" }).a();
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConversationNowController", 2, new Object[] { "handleMessage msg.what:", Integer.valueOf(paramMessage.what) });
      }
      return false;
      o();
    }
  }
  
  public void i()
  {
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ConversationNowController", 2, "onResume enter");
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 0L);
  }
  
  public void j()
  {
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("ConversationNowController", 2, "onPause enter");
    }
  }
  
  public void k()
  {
    QLog.d("ConversationNowController", 1, "onAfterAccountChanged");
  }
  
  public void l()
  {
    QLog.d("ConversationNowController", 1, "onBeforeAccountChanged:");
    a();
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationNowController", 2, "onDestory enter");
    }
    a();
    this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.now.enter.ConversationNowController
 * JD-Core Version:    0.7.0.1
 */