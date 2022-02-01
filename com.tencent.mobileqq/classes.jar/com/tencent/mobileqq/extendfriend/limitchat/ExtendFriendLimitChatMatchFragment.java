package com.tencent.mobileqq.extendfriend.limitchat;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import asfs;
import asfu;
import asgf;
import ashh;
import ashw;
import askk;
import askp;
import askq;
import askr;
import asks;
import askt;
import asku;
import askv;
import askw;
import askx;
import asky;
import askz;
import asla;
import aslb;
import aslj;
import asnc;
import asnv;
import asoh;
import aspa;
import avsr;
import awie;
import awii;
import awij;
import bcst;
import bglp;
import bgnt;
import bgpa;
import bkho;
import bkif;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.wiget.MatchingView;
import com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import mqq.os.MqqHandler;
import muf;

public class ExtendFriendLimitChatMatchFragment
  extends PublicBaseFragment
  implements View.OnClickListener, askp, aspa, awij
{
  private int jdField_a_of_type_Int = 0;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new askt(this);
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new askq(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asgf jdField_a_of_type_Asgf = new askz(this);
  public ashw a;
  private askk jdField_a_of_type_Askk;
  private asla jdField_a_of_type_Asla;
  private asnc jdField_a_of_type_Asnc;
  public asoh a;
  awii jdField_a_of_type_Awii = null;
  protected bgpa a;
  bkho jdField_a_of_type_Bkho = null;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private MatchingView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView;
  private SignalBombAnimationView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView;
  private HorseRaceLampVew jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew;
  public RedTouch a;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public ExtendFriendLimitChatMatchFragment()
  {
    this.jdField_a_of_type_Ashw = null;
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      paramView.setAlpha(1.0F);
      paramView.setScaleX(1.0F);
      paramView.setScaleY(1.0F);
    }
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_a_of_type_Bgpa == null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app != null)) {
      this.jdField_a_of_type_Bgpa = bglp.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697926), new askx(this)).setNegativeButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697925), new askw(this));
    }
    try
    {
      if ((this.jdField_a_of_type_Bgpa != null) && (!this.jdField_a_of_type_Bgpa.isShowing())) {
        this.jdField_a_of_type_Bgpa.show();
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "match fail dialog error:" + paramString);
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    bgpa localbgpa;
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      localbgpa = bglp.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (localbgpa != null)
      {
        Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697922);
        if (paramBoolean)
        {
          localObject = localbgpa.getMessageTextView();
          if (localObject != null) {
            ((TextView)localObject).setGravity(17);
          }
          localbgpa.setTitle(2131697971);
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697921);
        }
        localbgpa.setMessage(paramString);
        localbgpa.setPositiveButton((String)localObject, new asku(this));
      }
    }
    try
    {
      localbgpa.show();
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
      {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      }
      j();
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("ExtendFriendLimitChatMatchFragment", 2, "match handleFailAndQuitDialog error:" + paramString);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Asla != null) {
      this.jdField_a_of_type_Asla.removeMessages(asla.jdField_a_of_type_Int);
    }
    int i = this.jdField_a_of_type_Askk.a();
    k();
    if (i == 2)
    {
      this.jdField_a_of_type_Askk.b();
      if (paramBoolean) {
        a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697927));
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean1);
      if (!paramBoolean1) {
        break label90;
      }
      if (!paramBoolean2)
      {
        s();
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131697959), 1).a();
      }
      if (a()) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
    }
    else
    {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845179);
    return;
    label90:
    if (!paramBoolean2) {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131697901), 1).a();
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845176);
    h();
  }
  
  private void b(ashw paramashw)
  {
    if (this.jdField_a_of_type_Askk.a() == 2)
    {
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return");
      return;
    }
    if (!bgnt.e(BaseApplication.getContext()))
    {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697928), false);
      return;
    }
    this.jdField_a_of_type_Askk.a(this.jdField_a_of_type_Int);
    int i = this.jdField_a_of_type_Askk.a();
    if (i == 0)
    {
      this.jdField_a_of_type_Askk.a(paramashw);
      if (this.jdField_a_of_type_Asla != null) {
        this.jdField_a_of_type_Asla.sendEmptyMessageDelayed(asla.jdField_a_of_type_Int, 35000L);
      }
      c(paramashw);
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return : " + i);
  }
  
  private void b(boolean paramBoolean)
  {
    bcst.b(null, "dc00898", "", "", "0X800AE9C", "0X800AE9C", 0, 0, "", "", "", "");
    asfs localasfs = (asfs)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(127);
    if (localasfs != null) {
      localasfs.a();
    }
    a(false, paramBoolean);
  }
  
  private void c(ashw paramashw)
  {
    String str = "#" + this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697951);
    Object localObject = str;
    if (paramashw != null)
    {
      localObject = str;
      if (!TextUtils.isEmpty(paramashw.jdField_a_of_type_JavaLangString)) {
        localObject = "# " + paramashw.jdField_a_of_type_JavaLangString;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.a((String)localObject);
    }
    paramashw = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364999);
    localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370549);
    a(paramashw, this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView, (View)localObject);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView).a(53).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.f(25);
    }
    awie.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
  }
  
  private void j()
  {
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364999)).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.setVisibility(8);
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.b();
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "handleOutOfMatchCountResult");
    }
    k();
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      QLog.d("ExtendFriendLimitChatMatchFragment", 1, "handleOutOfMatchCountResult return");
      return;
    }
    Object localObject = (asfu)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
    if (localObject != null)
    {
      if (!((asfu)localObject).a()) {
        break label188;
      }
      localObject = bglp.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (localObject != null)
      {
        String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697921);
        ((bgpa)localObject).setMessage(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697960));
        ((bgpa)localObject).setPositiveButton(str, new asky(this));
      }
    }
    for (;;)
    {
      try
      {
        ((bgpa)localObject).show();
        if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
        {
          this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
          this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
        }
        j();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ExtendFriendLimitChatMatchFragment", 1, "match handleOutOfMatchCountResult error:" + localThrowable);
        continue;
      }
      label188:
      p();
    }
  }
  
  private void m()
  {
    Object localObject = (asfu)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
    int i;
    if (localObject != null)
    {
      i = (int)((asfu)localObject).c();
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(BaseApplication.getContext().getResources().getString(2131697949), new Object[] { Integer.valueOf(i) }));
      localObject = ((asfu)localObject).a();
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendLimitChatMatchFragment", 2, "updateTodayLeftMatchCountView leftMatchCount = " + i);
      }
      return;
      i = 0;
    }
  }
  
  private void n()
  {
    asfs localasfs = (asfs)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(127);
    if (localasfs != null) {
      localasfs.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.c());
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "requestLeftMatchCountAndTaskInfo");
    }
    asfs localasfs = (asfs)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(127);
    if (localasfs != null) {
      localasfs.a(false, false);
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "showCompletePersonalInfoDialog");
    }
    asfu localasfu = (asfu)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
    if (localasfu != null)
    {
      int k = (int)localasfu.a();
      int j = k - (int)localasfu.b();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      this.jdField_a_of_type_Asnc.a(k, i, localasfu.a());
      bcst.b(null, "dc00898", "", "", "0X800B089", "0X800B089", localasfu.b(), 0, "", "", "", "");
    }
  }
  
  private void q()
  {
    aslj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new askr(this), 1);
  }
  
  private void r()
  {
    if (!aslj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app))
    {
      aslj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, true);
      asnv.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new asks(this));
    }
    asfu localasfu;
    do
    {
      return;
      if (!aslj.a())
      {
        q();
        return;
      }
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app == null))
      {
        QLog.e("ExtendFriendLimitChatMatchFragment", 2, "openSignalBtn mActivity finish");
        return;
      }
      a(true, false);
      localasfu = (asfu)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
    } while (localasfu == null);
    localasfu.c(true);
    this.jdField_a_of_type_Asla.sendEmptyMessageDelayed(asla.c, asla.d);
    localasfu.g();
    bcst.b(null, "dc00898", "", "", "0X800AE9D", "0X800AE9D", 0, 0, "", "", "", "");
  }
  
  private void s()
  {
    Vibrator localVibrator;
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      localVibrator = (Vibrator)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("vibrator");
      if (localVibrator != null)
      {
        if (Build.VERSION.SDK_INT <= 25) {
          break label55;
        }
        localVibrator.vibrate(VibrationEffect.createOneShot(50, -1));
      }
    }
    return;
    label55:
    localVibrator.vibrate(50);
  }
  
  private void t()
  {
    QLog.d("ExtendFriendLimitChatMatchFragment", 2, "clearSignalPushWait");
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      asfu localasfu = (asfu)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
      if (localasfu != null) {
        localasfu.c(false);
      }
    }
  }
  
  private void u()
  {
    QLog.d("ExtendFriendLimitChatMatchFragment", 2, "checkNeedPush");
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      aslj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "checkNeedPush activity finish");
  }
  
  int a()
  {
    return ((WindowManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("window")).getDefaultDisplay().getHeight();
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(int paramInt, ashh paramashh, String paramString1, String paramString2)
  {
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "onMatchResult result" + paramInt);
    if (this.jdField_a_of_type_Asla != null) {
      this.jdField_a_of_type_Asla.removeMessages(asla.jdField_a_of_type_Int);
    }
    if ((paramInt == 0) && (paramashh != null))
    {
      a(paramashh, paramString1);
      k();
      m();
      if (paramashh == null) {}
      for (paramashh = "";; paramashh = paramashh.b)
      {
        bcst.b(null, "dc00898", "", paramashh, "0X80096A6", "0X80096A6", this.jdField_a_of_type_Int, 0, "", "", "", "");
        return;
      }
    }
    if (paramInt == 7)
    {
      k();
      paramString1 = (asfu)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
      paramashh = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString1.e();
        paramashh = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramashh = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697939);
        }
      }
      a(paramashh, false);
      return;
    }
    if (paramInt == 2)
    {
      k();
      paramashh = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramashh = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697927);
      }
      a(paramashh);
      return;
    }
    if (paramInt == 8)
    {
      k();
      paramashh = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramashh = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697970);
      }
      a(paramashh, true);
      return;
    }
    if (paramInt == 9)
    {
      l();
      return;
    }
    k();
    paramashh = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramashh = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697929);
    }
    a(paramashh, false);
  }
  
  public void a(View paramView1, MatchingView paramMatchingView, View paramView2)
  {
    if ((paramView1 == null) || (paramMatchingView == null) || (paramView2 == null)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView1, "scaleX", new float[] { 1.0F, 0.0F });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView1, "scaleY", new float[] { 1.0F, 0.0F });
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView1, "alpha", new float[] { 1.0F, 0.0F });
      ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(paramMatchingView, "alpha", new float[] { 0.0F, 1.0F });
      ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(paramView2, "scaleX", new float[] { 0.0F, 1.0F });
      paramView2 = ObjectAnimator.ofFloat(paramView2, "scaleY", new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4, localObjectAnimator5, paramView2 });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new askv(this, paramMatchingView, paramView1));
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void a(ashh paramashh, String paramString)
  {
    String str1 = paramashh.b;
    String str2 = paramashh.c;
    long l = paramashh.a;
    avsr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str1, paramString, Long.valueOf(l), str2, this.jdField_a_of_type_Int);
  }
  
  public void a(ashw paramashw)
  {
    if (paramashw != null)
    {
      this.jdField_a_of_type_Ashw = paramashw;
      b(this.jdField_a_of_type_Ashw);
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "ONTAG CLICK WITH NULL INFO");
  }
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT <= 20) {
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "startSingalBombAnim NOT SURPORT");
    }
    do
    {
      return false;
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "startSingalBombAnim Build.VERSION.SDK_INT " + Build.VERSION.SDK_INT);
    } while ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView == null) || (!aslb.b()));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.a();
    this.jdField_b_of_type_Boolean = true;
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.a();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.b();
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "startRuningHorse with null view");
  }
  
  public void d()
  {
    ThreadManager.getSubThreadHandler().post(new ExtendFriendLimitChatMatchFragment.8(this));
  }
  
  public void e()
  {
    bcst.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A696", "0X800A696", 0, 0, "", "", "", "");
    MatchChatMsgListFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Awii == null) {
      this.jdField_a_of_type_Awii = new awii(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bkho == null) {
        this.jdField_a_of_type_Bkho = ((bkho)bkif.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Awii.a()));
      }
      this.jdField_a_of_type_Bkho.show();
      return;
      this.jdField_a_of_type_Awii.a();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bkho != null) {
      this.jdField_a_of_type_Bkho.dismiss();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.b();
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.setVisibility(4);
    }
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 2130772001);
      }
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      onBackEvent();
      continue;
      p();
      o();
      continue;
      this.jdField_a_of_type_Ashw = null;
      b(null);
      int i = askk.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      int j = this.jdField_a_of_type_Int;
      bcst.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A68F", "0X800A68F", j + 1, i, "", "", "", "");
      continue;
      e();
      continue;
      bcst.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A68D", "0X800A68D", 0, 0, "", "", "", "");
      a(false);
      f();
      continue;
      if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        r();
      } else {
        b(false);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramBundle = getArguments();
    if (paramBundle != null) {
      this.jdField_a_of_type_Int = paramBundle.getInt("ExtendFriendLimitChatFromeType", 0);
    }
    this.jdField_a_of_type_Askk = ((askk)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(292));
    this.jdField_a_of_type_Askk.a(this);
    this.jdField_a_of_type_Asla = new asla(this);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Asgf);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131561156, null));
    paramLayoutInflater = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378796);
    if (this.jdField_a_of_type_Int == 1)
    {
      paramLayoutInflater.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setClickable(false);
      ((asfu)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264)).e();
      paramLayoutInflater = (asfs)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(127);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(true, true);
      }
      asfu.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      paramLayoutInflater = (asfu)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      }
      ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369841)).setOnClickListener(this);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371728);
      if (paramLayoutInflater != null)
      {
        if ((!ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app)) || (this.jdField_a_of_type_Int != 1)) {
          break label887;
        }
        paramLayoutInflater.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370547));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew = ((HorseRaceLampVew)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368074));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369842));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369843));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new muf());
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setTagClickListner(this);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371348));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366603));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377573));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView = ((SignalBombAnimationView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377572));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367865));
      this.jdField_a_of_type_Asoh = new asoh(1);
      if (this.jdField_a_of_type_Asoh.a() != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Asoh.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView = ((MatchingView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370555));
      int k = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      int m = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297234);
      int n = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297217);
      int i1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297218);
      int i2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297213);
      int i3 = a();
      int j = i3 - k - m - n - i1 - i2;
      int i = j;
      if (j < 0) {
        i = 0;
      }
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "screentHeight " + i3 + " statusHeight " + k + " titleHeight " + m + " headPanelHeight " + n + " horseHeight " + i1 + " btnHeight " + i2 + "leftHeight " + i);
      float f1 = i;
      float f2 = i;
      float f3 = i;
      paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370548);
      paramLayoutInflater = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369842);
      if (paramViewGroup != null)
      {
        paramBundle = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
        paramBundle.setMargins(0, (int)(f1 * 0.21F), 0, 0);
        paramViewGroup.setLayoutParams(paramBundle);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null)
      {
        paramViewGroup = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.getLayoutParams();
        paramViewGroup.setMargins(0, (int)(f2 * 0.16F), 0, 0);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setLayoutParams(paramViewGroup);
      }
      if (paramLayoutInflater != null)
      {
        paramViewGroup = (RelativeLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
        paramViewGroup.setMargins(0, (int)(f3 * 0.2F), 0, 0);
        paramLayoutInflater.setLayoutParams(paramViewGroup);
      }
      n();
      o();
      d();
      i();
      this.jdField_a_of_type_Asnc = new asnc(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramLayoutInflater.setVisibility(8);
      break;
      label887:
      paramLayoutInflater.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Int == 1) {
      ((asfu)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264)).f();
    }
    t();
    super.onDestroy();
    if (this.jdField_a_of_type_Asoh != null)
    {
      this.jdField_a_of_type_Asoh.d();
      this.jdField_a_of_type_Asoh = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.c();
    }
    if (this.jdField_a_of_type_Asla != null)
    {
      this.jdField_a_of_type_Asla.removeMessages(asla.jdField_a_of_type_Int);
      this.jdField_a_of_type_Asla.removeMessages(asla.b);
    }
    if (this.jdField_a_of_type_Bkho != null) {
      this.jdField_a_of_type_Bkho = null;
    }
    if (this.jdField_a_of_type_Awii != null) {
      this.jdField_a_of_type_Awii.c();
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Asgf);
    bcst.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "qq_kuolie", "0X800AA93", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
  }
  
  public void onPause()
  {
    QLog.i("ExtendFriendLimitChatMatchFragment", 2, "onPause");
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    AbstractGifImage.pauseAll();
    a(false);
    b();
    if (this.jdField_b_of_type_Boolean)
    {
      h();
      this.jdField_b_of_type_Boolean = true;
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    AbstractGifImage.resumeAll();
    j();
    c();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.jdField_b_of_type_Boolean) {
      a();
    }
    if (this.jdField_a_of_type_Asnc.isShowing()) {
      o();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.jdField_a_of_type_Int == 1) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Boolean = aslj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment
 * JD-Core Version:    0.7.0.1
 */