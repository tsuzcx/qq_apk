package com.tencent.mobileqq.extendfriend.limitchat;

import amsu;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
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
import arhg;
import arhi;
import arht;
import ariy;
import arjn;
import arjr;
import armn;
import arms;
import armt;
import armu;
import armv;
import armw;
import armx;
import army;
import armz;
import arna;
import arnb;
import arnc;
import arnd;
import arne;
import arnf;
import arno;
import arpo;
import arqh;
import arqt;
import arrm;
import auyo;
import avod;
import avoh;
import avoi;
import bcef;
import bfur;
import bfyz;
import bjnw;
import bjon;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.FriendListHandler;
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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import mqq.os.MqqHandler;
import mun;

public class ExtendFriendLimitChatMatchFragment
  extends PublicBaseFragment
  implements View.OnClickListener, arms, arrm, avoi
{
  private int jdField_a_of_type_Int = 0;
  private amsu jdField_a_of_type_Amsu = new army(this);
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new armx(this);
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new armt(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private arht jdField_a_of_type_Arht = new armu(this);
  public arjn a;
  private arjr jdField_a_of_type_Arjr;
  private armn jdField_a_of_type_Armn;
  private arne jdField_a_of_type_Arne;
  private arpo jdField_a_of_type_Arpo;
  public arqt a;
  avoh jdField_a_of_type_Avoh = null;
  bjnw jdField_a_of_type_Bjnw = null;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private MatchingView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView;
  private SignalBombAnimationView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView;
  private HorseRaceLampVew jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew;
  public RedTouch a;
  protected QQCustomDialog a;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  
  public ExtendFriendLimitChatMatchFragment()
  {
    this.jdField_a_of_type_Arjn = null;
  }
  
  private void a(int paramInt)
  {
    if (b())
    {
      b(paramInt);
      this.jdField_a_of_type_Arjr = arjr.a(paramInt);
      this.jdField_a_of_type_Arjr.show(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getFragmentManager(), "ExtendFriendApolloGuideDialogFragment");
    }
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
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app != null)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698190), new arnc(this)).setNegativeButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698189), new arnb(this));
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
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
    QQCustomDialog localQQCustomDialog;
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      localQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (localQQCustomDialog != null)
      {
        Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698186);
        if (paramBoolean)
        {
          localObject = localQQCustomDialog.getMessageTextView();
          if (localObject != null) {
            ((TextView)localObject).setGravity(17);
          }
          localQQCustomDialog.setTitle(2131698235);
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698185);
        }
        localQQCustomDialog.setMessage(paramString);
        localQQCustomDialog.setPositiveButton((String)localObject, new armz(this));
      }
    }
    try
    {
      localQQCustomDialog.show();
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
      {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      }
      k();
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
    if (this.jdField_a_of_type_Arne != null) {
      this.jdField_a_of_type_Arne.removeMessages(arne.jdField_a_of_type_Int);
    }
    int i = this.jdField_a_of_type_Armn.a();
    l();
    if (i == 2)
    {
      this.jdField_a_of_type_Armn.b();
      if (paramBoolean) {
        a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698191));
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
        t();
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698223), 1).a();
      }
      if (a()) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
    }
    else
    {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845081);
    return;
    label90:
    if (!paramBoolean2) {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698146), 1).a();
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845078);
    h();
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      bcef.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B442", "0X800B442", 1, 0, "", "", "", "");
      return;
    case 4: 
      bcef.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B442", "0X800B442", 3, 0, "", "", "", "");
      return;
    }
    bcef.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B442", "0X800B442", 2, 0, "", "", "", "");
  }
  
  private void b(arjn paramarjn)
  {
    if (this.jdField_a_of_type_Armn.a() == 2)
    {
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return");
      return;
    }
    if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext()))
    {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698192), false);
      return;
    }
    this.jdField_a_of_type_Armn.a(this.jdField_a_of_type_Int);
    int i = this.jdField_a_of_type_Armn.a();
    if (i == 0)
    {
      this.jdField_a_of_type_Armn.a(paramarjn);
      if (this.jdField_a_of_type_Arne != null) {
        this.jdField_a_of_type_Arne.sendEmptyMessageDelayed(arne.jdField_a_of_type_Int, 35000L);
      }
      c(paramarjn);
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return : " + i);
  }
  
  private void b(boolean paramBoolean)
  {
    bcef.b(null, "dc00898", "", "", "0X800AE9C", "0X800AE9C", 0, 0, "", "", "", "");
    arhg localarhg = (arhg)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(127);
    if (localarhg != null) {
      localarhg.a();
    }
    a(false, paramBoolean);
  }
  
  private boolean b()
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    while (((Build.VERSION.SDK_INT >= 17) && (getActivity().isDestroyed())) || ((this.jdField_a_of_type_Arjr != null) && (this.jdField_a_of_type_Arjr.getDialog() != null) && (this.jdField_a_of_type_Arjr.getDialog().isShowing())) || (!isVisible()) || (!isResumed()) || (!arno.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app)) || (this.jdField_b_of_type_Int == -1) || (!this.jdField_a_of_type_Boolean) || (bfyz.E(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApplication(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin()) != 0)) {
      return false;
    }
    return true;
  }
  
  private void c(arjn paramarjn)
  {
    String str = "#" + this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698215);
    Object localObject = str;
    if (paramarjn != null)
    {
      localObject = str;
      if (!TextUtils.isEmpty(paramarjn.jdField_a_of_type_JavaLangString)) {
        localObject = "# " + paramarjn.jdField_a_of_type_JavaLangString;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.a((String)localObject);
    }
    paramarjn = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365073);
    localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370622);
    a(paramarjn, this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView, (View)localObject);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView).a(53).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.f(25);
    }
    avod.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApplication() == null)) {}
    while (bfyz.E(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApplication(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin()) != 0) {
      return;
    }
    ((FriendListHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(1)).getApolloHead(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin());
  }
  
  private void k()
  {
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365073)).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.setVisibility(8);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.b();
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "handleOutOfMatchCountResult");
    }
    l();
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      QLog.d("ExtendFriendLimitChatMatchFragment", 1, "handleOutOfMatchCountResult return");
      return;
    }
    Object localObject = (arhi)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
    if (localObject != null)
    {
      if (!((arhi)localObject).a()) {
        break label189;
      }
      localObject = bfur.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (localObject != null)
      {
        String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698185);
        ((QQCustomDialog)localObject).setMessage(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698224));
        ((QQCustomDialog)localObject).setPositiveButton(str, new arnd(this));
      }
    }
    for (;;)
    {
      try
      {
        ((QQCustomDialog)localObject).show();
        if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
        {
          this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
          this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
        }
        k();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ExtendFriendLimitChatMatchFragment", 1, "match handleOutOfMatchCountResult error:" + localThrowable);
        continue;
      }
      label189:
      q();
    }
  }
  
  private void n()
  {
    Object localObject = (arhi)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
    int i;
    if (localObject != null)
    {
      i = (int)((arhi)localObject).c();
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(BaseApplication.getContext().getResources().getString(2131698213), new Object[] { Integer.valueOf(i) }));
      localObject = ((arhi)localObject).a();
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
  
  private void o()
  {
    arhg localarhg = (arhg)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(127);
    if (localarhg != null) {
      localarhg.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentUin());
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "requestLeftMatchCountAndTaskInfo");
    }
    arhg localarhg = (arhg)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(127);
    if (localarhg != null) {
      localarhg.a(false, false);
    }
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "showCompletePersonalInfoDialog");
    }
    arhi localarhi = (arhi)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
    if (localarhi != null)
    {
      int k = (int)localarhi.a();
      int j = k - (int)localarhi.b();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      this.jdField_a_of_type_Arpo.a(k, i, localarhi.a());
      bcef.b(null, "dc00898", "", "", "0X800B089", "0X800B089", localarhi.b(), 0, "", "", "", "");
    }
  }
  
  private void r()
  {
    arno.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new armv(this), 1);
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!arno.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app)))
    {
      arno.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, true);
      arqh.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new armw(this));
    }
    arhi localarhi;
    do
    {
      return;
      if (!arno.a())
      {
        r();
        return;
      }
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app == null))
      {
        QLog.e("ExtendFriendLimitChatMatchFragment", 2, "openSignalBtn mActivity finish");
        return;
      }
      a(true, false);
      localarhi = (arhi)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
    } while (localarhi == null);
    localarhi.c(true);
    this.jdField_a_of_type_Arne.sendEmptyMessageDelayed(arne.c, arne.d);
    localarhi.g();
    bcef.b(null, "dc00898", "", "", "0X800AE9D", "0X800AE9D", 0, 0, "", "", "", "");
  }
  
  private void t()
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
  
  private void u()
  {
    QLog.d("ExtendFriendLimitChatMatchFragment", 2, "clearSignalPushWait");
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      arhi localarhi = (arhi)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
      if (localarhi != null) {
        localarhi.c(false);
      }
    }
  }
  
  private void v()
  {
    QLog.d("ExtendFriendLimitChatMatchFragment", 2, "checkNeedPush");
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      arno.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
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
  
  public void a(int paramInt, ariy paramariy, String paramString1, String paramString2)
  {
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "onMatchResult result" + paramInt);
    if (this.jdField_a_of_type_Arne != null) {
      this.jdField_a_of_type_Arne.removeMessages(arne.jdField_a_of_type_Int);
    }
    if ((paramInt == 0) && (paramariy != null))
    {
      a(paramariy, paramString1);
      l();
      n();
      if (paramariy == null) {}
      for (paramariy = "";; paramariy = paramariy.b)
      {
        bcef.b(null, "dc00898", "", paramariy, "0X80096A6", "0X80096A6", this.jdField_a_of_type_Int, 0, "", "", "", "");
        return;
      }
    }
    if (paramInt == 7)
    {
      l();
      paramString1 = (arhi)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
      paramariy = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString1.e();
        paramariy = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramariy = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698203);
        }
      }
      a(paramariy, false);
      return;
    }
    if (paramInt == 2)
    {
      l();
      paramariy = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramariy = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698191);
      }
      a(paramariy);
      return;
    }
    if (paramInt == 8)
    {
      l();
      paramariy = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramariy = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698234);
      }
      a(paramariy, true);
      return;
    }
    if (paramInt == 9)
    {
      m();
      return;
    }
    if (paramInt == 13)
    {
      l();
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
      {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      }
      k();
      return;
    }
    l();
    paramariy = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramariy = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698193);
    }
    a(paramariy, false);
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
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new arna(this, paramMatchingView, paramView1));
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void a(ariy paramariy, String paramString)
  {
    String str1 = paramariy.b;
    String str2 = paramariy.c;
    long l = paramariy.a;
    auyo.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str1, paramString, Long.valueOf(l), str2, this.jdField_a_of_type_Int);
  }
  
  public void a(arjn paramarjn)
  {
    if (paramarjn != null)
    {
      this.jdField_a_of_type_Arjn = paramarjn;
      b(this.jdField_a_of_type_Arjn);
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
    } while ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView == null) || (!arnf.b()));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.a();
    this.jdField_c_of_type_Boolean = true;
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
    ThreadManager.getSubThreadHandler().post(new ExtendFriendLimitChatMatchFragment.9(this));
  }
  
  public void e()
  {
    bcef.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A696", "0X800A696", 0, 0, "", "", "", "");
    MatchChatMsgListFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Avoh == null) {
      this.jdField_a_of_type_Avoh = new avoh(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bjnw == null) {
        this.jdField_a_of_type_Bjnw = ((bjnw)bjon.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Avoh.a()));
      }
      this.jdField_a_of_type_Bjnw.show();
      return;
      this.jdField_a_of_type_Avoh.a();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bjnw != null) {
      this.jdField_a_of_type_Bjnw.dismiss();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.b();
      this.jdField_c_of_type_Boolean = false;
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
      q();
      p();
      continue;
      this.jdField_a_of_type_Arjn = null;
      b(null);
      int i = armn.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      int j = this.jdField_a_of_type_Int;
      bcef.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A68F", "0X800A68F", j + 1, i, "", "", "", "");
      continue;
      e();
      continue;
      bcef.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A68D", "0X800A68D", 0, 0, "", "", "", "");
      a(false);
      f();
      continue;
      if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        s();
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
    this.jdField_a_of_type_Armn = ((armn)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(292));
    this.jdField_a_of_type_Armn.a(this);
    this.jdField_a_of_type_Arne = new arne(this);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Arht);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Amsu);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131561067, null));
    paramLayoutInflater = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378727);
    if (this.jdField_a_of_type_Int == 1)
    {
      paramLayoutInflater.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setClickable(false);
      ((arhi)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264)).e();
      paramLayoutInflater = (arhg)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(127);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(true, true);
      }
      arhi.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      paramLayoutInflater = (arhi)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      }
      ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369933)).setOnClickListener(this);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371801);
      if (paramLayoutInflater != null)
      {
        if ((!ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app)) || (this.jdField_a_of_type_Int != 1)) {
          break label891;
        }
        paramLayoutInflater.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370620));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew = ((HorseRaceLampVew)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368175));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369934));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369935));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new mun());
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setTagClickListner(this);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371423));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366680));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377495));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView = ((SignalBombAnimationView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377494));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367966));
      this.jdField_a_of_type_Arqt = new arqt(1);
      if (this.jdField_a_of_type_Arqt.a() != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Arqt.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView = ((MatchingView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370628));
      int k = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      int m = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297301);
      int n = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297284);
      int i1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297285);
      int i2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297280);
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
      paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370621);
      paramLayoutInflater = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369934);
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
      o();
      p();
      d();
      i();
      j();
      this.jdField_a_of_type_Arpo = new arpo(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramLayoutInflater.setVisibility(8);
      break;
      label891:
      paramLayoutInflater.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Int == 1) {
      ((arhi)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264)).f();
    }
    u();
    super.onDestroy();
    if (this.jdField_a_of_type_Arqt != null)
    {
      this.jdField_a_of_type_Arqt.d();
      this.jdField_a_of_type_Arqt = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.c();
    }
    if (this.jdField_a_of_type_Arne != null)
    {
      this.jdField_a_of_type_Arne.removeMessages(arne.jdField_a_of_type_Int);
      this.jdField_a_of_type_Arne.removeMessages(arne.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_Bjnw != null) {
      this.jdField_a_of_type_Bjnw = null;
    }
    if (this.jdField_a_of_type_Avoh != null) {
      this.jdField_a_of_type_Avoh.c();
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Arht);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Amsu);
    bcef.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "qq_kuolie", "0X800AA93", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    a(this.jdField_b_of_type_Int);
  }
  
  public void onPause()
  {
    QLog.i("ExtendFriendLimitChatMatchFragment", 2, "onPause");
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    AbstractGifImage.pauseAll();
    a(false);
    b();
    if (this.jdField_c_of_type_Boolean)
    {
      h();
      this.jdField_c_of_type_Boolean = true;
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    AbstractGifImage.resumeAll();
    k();
    c();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.jdField_c_of_type_Boolean) {
      a();
    }
    if (this.jdField_a_of_type_Arpo.isShowing()) {
      p();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.jdField_a_of_type_Int == 1) && (!this.jdField_b_of_type_Boolean)) {
      this.jdField_b_of_type_Boolean = arno.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment
 * JD-Core Version:    0.7.0.1
 */