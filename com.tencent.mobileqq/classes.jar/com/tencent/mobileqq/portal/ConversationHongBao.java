package com.tencent.mobileqq.portal;

import agls;
import aglt;
import aglu;
import aglv;
import aglw;
import aglx;
import agly;
import aglz;
import agma;
import agmb;
import agmc;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.HongBaoListView;
import com.tencent.widget.HongBaoListViewListener;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Constants.LogoutReason;

public class ConversationHongBao
  implements Handler.Callback
{
  int jdField_a_of_type_Int = 0;
  public long a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer = null;
  public Handler a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateDecelerateInterpolator();
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  private Animator.AnimatorListener jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener;
  private ValueAnimator jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator;
  public Conversation a;
  private BreathEffectView jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView;
  public FormalView a;
  public PrepareView a;
  private ProgressViewRed jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed;
  public HongBaoListView a;
  public HongBaoListViewListener a;
  public Runnable a;
  String jdField_a_of_type_JavaLangString = "";
  public StringBuilder a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  public int b;
  public long b;
  Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private Animator.AnimatorListener jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener;
  private ValueAnimator jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator;
  private String jdField_b_of_type_JavaLangString;
  public StringBuilder b;
  public boolean b;
  public int c;
  public long c;
  public boolean c;
  public int d;
  public long d;
  public boolean d;
  public int e;
  public long e;
  public boolean e;
  private int f;
  public boolean f;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int h = -1;
  
  public ConversationHongBao(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRunnable = new agls(this);
    this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener = new aglv(this);
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(12);
    this.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder(8);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = VersionUtils.e();
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_a_of_type_AndroidAppActivity = paramConversation.a();
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  private void a(int paramInt)
  {
    Object localObject1;
    int i;
    long l;
    if (((this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 4) || (this.jdField_d_of_type_Int == 5)) && (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_JavaUtilList;
      i = this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Int;
      l = this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Long;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConversationHongBao", 2, "loopIcon logoList=" + localObject1 + ", index=" + paramInt + ", mState=" + this.jdField_d_of_type_Int + ", mode=" + i + ", scrollTime=" + l);
      }
      if ((localObject1 == null) || (((List)localObject1).size() <= paramInt) || (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (i != 3))
      {
        return;
        if ((this.jdField_d_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView != null))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.jdField_a_of_type_JavaUtilList;
          i = this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.jdField_a_of_type_Int;
          l = this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.jdField_a_of_type_Long;
        }
      }
      else
      {
        Object localObject3 = (PortalManager.LogoConfig)((List)localObject1).get(paramInt);
        Bundle localBundle = new Bundle();
        Bitmap localBitmap;
        Object localObject4;
        if (localObject3 != null)
        {
          localBitmap = PortalManager.a(((PortalManager.LogoConfig)localObject3).logoImageMD5, "hb_busi_logo_path");
          localObject4 = ((PortalManager.LogoConfig)localObject3).nameMD5;
          if (this.jdField_d_of_type_Int != 2) {
            break label400;
          }
        }
        label400:
        for (Object localObject2 = "hb_yure_busi_name_path";; localObject2 = "hb_name_path")
        {
          localObject2 = PortalManager.a((String)localObject4, (String)localObject2);
          localObject4 = PortalManager.a(((PortalManager.LogoConfig)localObject3).greetImageMD5, null);
          localObject3 = PortalManager.a(((PortalManager.LogoConfig)localObject3).padantImageMD5, "hb_busi_logo_path");
          localBundle.putParcelable("logoBitmap", localBitmap);
          localBundle.putParcelable("nameBitmap", (Parcelable)localObject2);
          localBundle.putParcelable("greetBitmap", (Parcelable)localObject4);
          localBundle.putParcelable("pandantBitmap", (Parcelable)localObject3);
          i = paramInt + 1;
          paramInt = i;
          if (i >= ((List)localObject1).size()) {
            paramInt = 0;
          }
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
          Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1003, localBundle).sendToTarget();
          localObject1 = Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 1004, paramInt, 0, null);
          this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, l);
          return;
        }
      }
      i = -1;
      localObject1 = null;
      l = 3000L;
    }
  }
  
  private void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ConversationHongBao", 2, "updateIcon greetBitmap=" + paramBitmap3 + ", pandantBitmap=" + paramBitmap4 + ", mState=" + this.jdField_d_of_type_Int);
    }
    if (this.jdField_d_of_type_Int == 2) {
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setLogo(paramBitmap1, paramBitmap2);
    }
    if ((this.jdField_d_of_type_Int == 4) || (this.jdField_d_of_type_Int == 5))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressLogo(paramBitmap1, true);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressNameBitmap(paramBitmap2, null, true);
    }
    paramBitmap1 = this.jdField_a_of_type_ComTencentWidgetHongBaoListView;
    if (this.jdField_d_of_type_Int != 3) {}
    for (;;)
    {
      paramBitmap1.setLogo(paramBitmap4, bool);
      if (paramBitmap3 != null) {}
      return;
      bool = false;
    }
  }
  
  private void a(View paramView1, View paramView2)
  {
    this.h = (((RelativeLayout.LayoutParams)paramView2.getLayoutParams()).topMargin + paramView2.getHeight());
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.addRule(3, 0);
    paramView2.topMargin = this.h;
    paramView1.setLayoutParams(paramView2);
    this.jdField_g_of_type_Boolean = true;
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, View paramView3)
  {
    if (!this.jdField_g_of_type_Boolean) {
      a(paramView2, paramView1);
    }
    if (this.h <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new agmb(this, paramView2, paramView1, paramView3));
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new agmc(this, paramView3);
    }
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationHongBao", 2, "startLoopIcon, forceStart=" + paramBoolean);
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!paramBoolean)) {
      return;
    }
    p();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 1004, 0, 0, null).sendToTarget();
  }
  
  @TargetApi(11)
  private void b(View paramView1, View paramView2, View paramView3)
  {
    if (!this.jdField_g_of_type_Boolean) {
      a(paramView2, paramView1);
    }
    if (this.h <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new aglt(this, paramView2, paramView1, paramView3));
      this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new aglu(this, paramView3, paramView1);
    }
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  private void p()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1004);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView != null) && (this.jdField_d_of_type_Int == 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.b();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1006);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1006, 500L);
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_f_of_type_Int;
      if (this.jdField_d_of_type_Int == 3)
      {
        int j = AIOUtils.a(100.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.b(i - j);
        return;
      }
    } while ((this.jdField_d_of_type_Int != 2) && (this.jdField_d_of_type_Int != 5) && (this.jdField_d_of_type_Int != 4));
    q();
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.b(i);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      this.jdField_a_of_type_AndroidOsCountDownTimer = null;
    }
    FrameHelperActivity.a(true);
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    ((PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78)).d();
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_d_of_type_Int == -this.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_e_of_type_Long == paramLong) {
      return;
    }
    this.jdField_e_of_type_Long = paramLong;
    int j = (int)(paramLong / 1000L);
    int i = j / 60;
    j %= 60;
    int k = (int)paramLong % 100;
    this.jdField_b_of_type_JavaLangStringBuilder.delete(0, this.jdField_b_of_type_JavaLangStringBuilder.length());
    if (i < 10) {
      this.jdField_b_of_type_JavaLangStringBuilder.append("0");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(i).append(":");
    if (j < 10) {
      this.jdField_b_of_type_JavaLangStringBuilder.append("0");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(j);
    this.jdField_b_of_type_JavaLangStringBuilder.append(".");
    if (k < 10) {
      this.jdField_b_of_type_JavaLangStringBuilder.append("0");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(k);
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_b_of_type_JavaLangStringBuilder);
  }
  
  public void a(long paramLong1, int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Bitmap paramBitmap7, List paramList, String paramString, long paramLong2, boolean paramBoolean, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "showPrepare, " + this.jdField_d_of_type_Int + ", " + paramLong1 + ", " + paramString + ", " + paramLong2 + ", " + paramBoolean);
    }
    if ((this.jdField_c_of_type_Long == paramLong1) && (!paramBoolean) && (paramLong2 <= 0L)) {
      return;
    }
    b();
    this.jdField_c_of_type_Long = paramLong1;
    this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setMode(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.jdField_a_of_type_Long = paramLong3;
    this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setBackground(paramBitmap1, paramBitmap2, paramBitmap4, paramBitmap5, paramBitmap6, paramBitmap7);
    if (this.jdField_d_of_type_Int != 2)
    {
      this.jdField_d_of_type_Int = 2;
      d();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.s();
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.a();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setComboListener(this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener);
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(8);
      k();
      a();
      if (this.jdField_d_of_type_Boolean)
      {
        paramBitmap1 = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
        if (paramBitmap1 != null) {
          paramBitmap1.g();
        }
      }
    }
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(paramInt);
    if (paramInt == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setLogoConfigList(paramList);
      a(true, this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Long);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.a(paramString);
      if (paramLong2 < 0L) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.a(paramLong2);
      return;
      p();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setLogo(paramBitmap3, true);
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setLogo(paramBitmap2, paramBitmap7);
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.a();
  }
  
  public void a(long paramLong1, int paramInt1, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong2, boolean paramBoolean, int paramInt2, Bitmap paramBitmap4, Bitmap paramBitmap5, List paramList1, List paramList2, Bitmap paramBitmap6, long paramLong3, Bitmap paramBitmap7, Bitmap paramBitmap8)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "showTask, " + this.jdField_d_of_type_Int + ", " + paramLong1 + ", " + paramLong2 + ", " + paramBoolean + ", " + paramInt2);
    }
    if ((this.jdField_c_of_type_Long == paramLong1) && (!paramBoolean) && (((this.jdField_d_of_type_Int == 3) && (paramLong2 == -1L)) || ((this.jdField_d_of_type_Int == 5) && (paramLong2 == 0L)))) {
      return;
    }
    b();
    this.jdField_c_of_type_Long = paramLong1;
    if ((this.jdField_d_of_type_Int != 3) && (this.jdField_d_of_type_Int != 4) && (this.jdField_d_of_type_Int != 5))
    {
      d();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setComboListener(this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener);
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setBackground(null, paramBitmap1);
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setCloudBmp(paramBitmap4, paramBitmap5);
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setLogoConfigList(paramList1);
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setComboNumberList(paramList2);
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Long = paramLong3;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString4;
    if (paramLong2 < 0L) {
      if (this.jdField_d_of_type_Int != 3)
      {
        this.jdField_d_of_type_Int = 3;
        HongbaoShowerActivity.a();
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.b();
        this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.s();
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.c();
          this.jdField_a_of_type_ComTencentWidgetHongBaoListView.p();
        }
        a();
        p();
        if (this.jdField_d_of_type_Boolean)
        {
          paramBitmap1 = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
          if (paramBitmap1 != null) {
            paramBitmap1.g();
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(paramInt1);
      if (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Int != 3) {
        break;
      }
      a(true, this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Long);
      return;
      if (paramLong2 == 0L)
      {
        if (this.jdField_d_of_type_Int != 5)
        {
          this.jdField_d_of_type_Int = 5;
          this.jdField_b_of_type_Boolean = true;
          paramBitmap1 = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
          if ((paramBitmap1 != null) && (!paramBitmap1.d())) {
            this.jdField_b_of_type_Boolean = false;
          }
          this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
          this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
          this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.e();
          this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(8);
          if (this.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentWidgetHongBaoListView.s();
          }
          k();
          a();
          p();
          this.jdField_a_of_type_ComTencentWidgetHongBaoListView.q();
          a(false);
          this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressLogo(paramBitmap2, false);
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(paramInt2, paramString2, paramString3);
      }
      else
      {
        b(paramLong2);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setSmallIcon(paramBitmap7, paramBitmap8);
    }
    p();
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressLogo(paramBitmap2, false);
    paramBitmap1 = this.jdField_a_of_type_ComTencentWidgetHongBaoListView;
    if (this.jdField_d_of_type_Int != 3) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramBitmap1.setLogo(paramBitmap3, paramBoolean);
      if (paramBitmap6 == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressNameBitmap(paramBitmap6, null, false);
      return;
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if (this.jdField_d_of_type_Int == -1) {
      return;
    }
    c();
  }
  
  @TargetApi(11)
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
      {
        this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
        this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      }
      o();
      this.jdField_e_of_type_Boolean = true;
    }
    while (this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c());
  }
  
  public void a(boolean paramBoolean, String paramString, PortalManager.ResultData paramResultData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "onBrashRequestResult, " + this.jdField_d_of_type_Int + ", " + paramBoolean + ", " + paramString + ", " + paramResultData + ", " + this.jdField_d_of_type_Boolean);
    }
    if (paramBoolean) {
      if (this.jdField_d_of_type_Boolean)
      {
        PortalManager.a(this.jdField_a_of_type_AndroidAppActivity, paramResultData);
        paramString = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
        if (paramString != null)
        {
          paramString.b(1);
          paramString.e();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqPortalFormalView != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Int == 3) && (this.jdField_d_of_type_Int == 4))
        {
          p();
          this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressLogo(paramResultData.b, false);
          this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressNameBitmap(paramResultData.c, null, false);
        }
      }
    }
    while (this.jdField_d_of_type_Int != 4) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(paramString);
  }
  
  public boolean a()
  {
    if ((this.jdField_d_of_type_Int == -1) || (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null)) {}
    while ((!this.jdField_a_of_type_ComTencentWidgetHongBaoListView.mForHongBao) || (!this.jdField_a_of_type_ComTencentWidgetHongBaoListView.i)) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if (this.jdField_d_of_type_Int == -1)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363964));
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView = ((HongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363972));
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao = this;
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131559584));
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
      if ((localObject == null) || (((View)localObject).getBottom() - ((View)localObject).getTop() == 0))
      {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_f_of_type_Int = (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int - AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int;
        this.jdField_g_of_type_Int = this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_f_of_type_Int;
        this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131559597));
        this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView = ((BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363979));
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
        this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setTextSize(0, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131559596));
        i = (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131559588);
        localObject = new FrameLayout.LayoutParams(-1, i);
        ((FrameLayout.LayoutParams)localObject).topMargin = (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int - this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_f_of_type_Int);
        this.jdField_b_of_type_Int = i;
        this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363973));
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aglx(this));
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(this.jdField_a_of_type_AndroidViewViewGroup);
        this.jdField_d_of_type_Int = 1;
      }
    }
    while (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null) {
      for (;;)
      {
        Object localObject;
        int i;
        return;
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_f_of_type_Int = (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int - (((View)localObject).getBottom() - ((View)localObject).getTop()));
      }
    }
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao = this;
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int = this.jdField_f_of_type_Int;
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_f_of_type_Int = this.jdField_g_of_type_Int;
  }
  
  public void b(long paramLong)
  {
    PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
    long[] arrayOfLong = localPortalManager.a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("startCountDown");
      if (arrayOfLong == null) {
        break label78;
      }
    }
    label78:
    for (String str = Arrays.toString(arrayOfLong);; str = "null")
    {
      QLog.d("PortalManager", 2, str);
      if (arrayOfLong != null) {
        break;
      }
      return;
    }
    if (this.jdField_d_of_type_Int != 4)
    {
      this.jdField_d_of_type_Int = 4;
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setAlpha(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(0);
      FrameHelperActivity.a(false);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.r();
      if ((paramLong != -1L) && (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_d_of_type_Int == 0))
      {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSelection(0);
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(-this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(-this.jdField_b_of_type_Int);
      }
      k();
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.e();
      p();
    }
    if (paramLong == -1L)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.b(true);
      a(true, this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Long);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
        this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      }
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
        localPortalManager.b(2);
      }
      this.jdField_a_of_type_AndroidOsCountDownTimer = new aglw(this, arrayOfLong[1], 40L, arrayOfLong);
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
    if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityConversation == null)) {
      return;
    }
    this.jdField_e_of_type_Boolean = false;
    if (!paramBoolean)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c());
      return;
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.topMargin = (-this.h);
    localView.setLayoutParams(localLayoutParams);
    localView = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c();
    localView.setVisibility(8);
    if (this.jdField_f_of_type_Boolean) {
      localView.setAlpha(0.0F);
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    if (FrameHelperActivity.a()) {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "showPreGuide" + this.jdField_d_of_type_Int);
      }
    }
    while (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null) {
      return false;
    }
    r();
    return true;
  }
  
  public void c()
  {
    a(true);
    if (this.jdField_d_of_type_Int == -1) {}
    while (!a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "normalMode");
    }
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
    FrameHelperActivity.a(true);
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.k();
    k();
    a();
    this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.e();
    this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    p();
    this.jdField_c_of_type_Long = -1L;
    this.jdField_d_of_type_Int = 1;
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "startGestureGuide, " + this.jdField_d_of_type_Int);
    }
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      return false;
    }
    AnimationSet localAnimationSet = new AnimationSet(false);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setStartOffset(1L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setAnimationListener(new agly(this));
    int i = (int)this.jdField_a_of_type_AndroidViewViewGroup.getResources().getDimension(2131559600);
    int j = -this.jdField_a_of_type_ComTencentWidgetHongBaoListView.b();
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "startGestureGuide, " + j + "," + i);
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, j, 0, i + j);
    localTranslateAnimation.setDuration(1500L);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new aglz(this));
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setAnimationListener(new agma(this));
    localAnimationSet.addAnimation(localAlphaAnimation);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
    return true;
  }
  
  public void d()
  {
    if (this.jdField_d_of_type_Int == -1) {}
    while (a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "hongbaoMode");
    }
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.m();
  }
  
  public void e()
  {
    this.jdField_c_of_type_Boolean = true;
    if (!a()) {
      return;
    }
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView != null) {
        switch (this.jdField_d_of_type_Int)
        {
        }
      }
      break;
    }
    for (;;)
    {
      i();
      return;
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.c();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.p();
      break;
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.a();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.c();
    }
  }
  
  public void f()
  {
    if (this.jdField_d_of_type_Int == -1) {
      return;
    }
    c();
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, 800L);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationHongBao", 2, "onResume()");
    }
    if ((this.jdField_a_of_type_AndroidOsHandler == null) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1002))) {}
    do
    {
      return;
      this.jdField_d_of_type_Boolean = true;
    } while (!a());
    if (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.c();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        b();
      }
      this.jdField_a_of_type_Boolean = false;
    }
    switch (this.jdField_d_of_type_Int)
    {
    }
    for (;;)
    {
      i();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
      if (localPortalManager == null) {
        break;
      }
      localPortalManager.b();
      localPortalManager.g();
      return;
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.jdField_a_of_type_Int == 3))
      {
        a(true, this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.jdField_a_of_type_Long);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.c();
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.p();
        if ((this.jdField_a_of_type_ComTencentMobileqqPortalFormalView != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Int == 3)) {
          a(true, this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_Long);
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Bitmap localBitmap1 = null;
    Bitmap localBitmap2;
    Bitmap localBitmap3;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1001: 
      k();
      c();
      return false;
    case 1002: 
      h();
      return false;
    case 1003: 
      paramMessage = (Bundle)paramMessage.obj;
      if (paramMessage != null)
      {
        localBitmap1 = (Bitmap)paramMessage.getParcelable("logoBitmap");
        localBitmap2 = (Bitmap)paramMessage.getParcelable("nameBitmap");
        localBitmap3 = (Bitmap)paramMessage.getParcelable("greetBitmap");
        paramMessage = (Bitmap)paramMessage.getParcelable("pandantBitmap");
      }
      break;
    }
    for (;;)
    {
      a(localBitmap1, localBitmap2, localBitmap3, paramMessage);
      return false;
      a(paramMessage.arg1);
      return false;
      if ((this.jdField_e_of_type_Int == 0) || (this.jdField_d_of_type_Int != 5)) {
        break;
      }
      this.jdField_e_of_type_Int = 0;
      ((PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78)).a(this.jdField_a_of_type_AndroidAppActivity);
      return false;
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      paramMessage = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getAppInterface().getManager(78);
      if (paramMessage == null) {
        break;
      }
      paramMessage.b(4);
      return false;
      paramMessage = null;
      localBitmap3 = null;
      localBitmap2 = null;
    }
  }
  
  public void i()
  {
    if (!a()) {
      return;
    }
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      return;
    }
    PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
    if ((!this.jdField_d_of_type_Boolean) || (!this.jdField_c_of_type_Boolean) || (FrameHelperActivity.a()))
    {
      localPortalManager.d();
      FrameHelperActivity.a(true);
      return;
    }
    FrameHelperActivity.a(false);
    localPortalManager.b(2);
  }
  
  public void j()
  {
    this.jdField_d_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("ConversationHongBao", 2, "onPause()");
    }
    if (!a()) {
      return;
    }
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
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.q();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.e();
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    p();
    i();
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "stopGestureGuide, " + this.jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void l()
  {
    if (!a()) {}
    do
    {
      return;
      i();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
      if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.getScrollY() != 0) {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
      }
      a(true);
    } while ((this.jdField_a_of_type_ComTencentMobileqqPortalFormalView == null) || (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView == null));
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.setPause(true);
  }
  
  public void m()
  {
    if (!a()) {
      return;
    }
    i();
  }
  
  public void n()
  {
    if (!a()) {
      return;
    }
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      return;
    }
    c();
  }
  
  @TargetApi(11)
  public void o()
  {
    View localView1 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
    View localView2 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c();
    if (localView1 != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
      localLayoutParams.topMargin = 0;
      localView1.setLayoutParams(localLayoutParams);
    }
    if (localView2 != null)
    {
      if (this.jdField_f_of_type_Boolean) {
        localView2.setAlpha(1.0F);
      }
      localView2.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBao
 * JD-Core Version:    0.7.0.1
 */