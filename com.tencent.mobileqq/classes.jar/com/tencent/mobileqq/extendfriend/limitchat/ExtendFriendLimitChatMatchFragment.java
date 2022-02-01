package com.tencent.mobileqq.extendfriend.limitchat;

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
import anvi;
import aslm;
import aslo;
import aslz;
import asne;
import asnt;
import asnx;
import asqt;
import asqy;
import asqz;
import asra;
import asrb;
import asrc;
import asrd;
import asre;
import asrf;
import asrg;
import asrh;
import asri;
import asrj;
import asrk;
import asrl;
import asru;
import astu;
import asun;
import asuz;
import asvs;
import aweo;
import awui;
import awum;
import awun;
import bdla;
import bhdj;
import bhhr;
import bkzi;
import bkzz;
import com.tencent.beacon.event.UserAction;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import mvl;

public class ExtendFriendLimitChatMatchFragment
  extends PublicBaseFragment
  implements View.OnClickListener, asqy, asvs, awun
{
  private int jdField_a_of_type_Int = 0;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new asrd(this);
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new asqz(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anvi jdField_a_of_type_Anvi = new asre(this);
  private aslz jdField_a_of_type_Aslz = new asra(this);
  public asnt a;
  private asnx jdField_a_of_type_Asnx;
  private asqt jdField_a_of_type_Asqt;
  private asrk jdField_a_of_type_Asrk;
  private astu jdField_a_of_type_Astu;
  public asuz a;
  awum jdField_a_of_type_Awum = null;
  bkzi jdField_a_of_type_Bkzi = null;
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
    this.jdField_a_of_type_Asnt = null;
  }
  
  private void a(int paramInt)
  {
    if (b())
    {
      b(paramInt);
      this.jdField_a_of_type_Asnx = asnx.a(paramInt);
      this.jdField_a_of_type_Asnx.show(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getFragmentManager(), "ExtendFriendApolloGuideDialogFragment");
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
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698476), new asri(this)).setNegativeButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698475), new asrh(this));
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
      localQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (localQQCustomDialog != null)
      {
        Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698472);
        if (paramBoolean)
        {
          localObject = localQQCustomDialog.getMessageTextView();
          if (localObject != null) {
            ((TextView)localObject).setGravity(17);
          }
          localQQCustomDialog.setTitle(2131698521);
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698471);
        }
        localQQCustomDialog.setMessage(paramString);
        localQQCustomDialog.setPositiveButton((String)localObject, new asrf(this));
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
    if (this.jdField_a_of_type_Asrk != null) {
      this.jdField_a_of_type_Asrk.removeMessages(asrk.jdField_a_of_type_Int);
    }
    int i = this.jdField_a_of_type_Asqt.a();
    l();
    if (i == 2)
    {
      this.jdField_a_of_type_Asqt.b();
      if (paramBoolean) {
        a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698477));
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
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698509), 1).a();
      }
      if (a()) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
    }
    else
    {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845155);
    return;
    label90:
    if (!paramBoolean2) {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698432), 1).a();
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845152);
    h();
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B442", "0X800B442", 1, 0, "", "", "", "");
      return;
    case 4: 
      bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B442", "0X800B442", 3, 0, "", "", "", "");
      return;
    }
    bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B442", "0X800B442", 2, 0, "", "", "", "");
  }
  
  private void b(asnt paramasnt)
  {
    if (this.jdField_a_of_type_Asqt.a() == 2)
    {
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return");
      return;
    }
    if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext()))
    {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698478), false);
      return;
    }
    this.jdField_a_of_type_Asqt.a(this.jdField_a_of_type_Int);
    int i = this.jdField_a_of_type_Asqt.a();
    if (i == 0)
    {
      this.jdField_a_of_type_Asqt.a(paramasnt);
      if (this.jdField_a_of_type_Asrk != null) {
        this.jdField_a_of_type_Asrk.sendEmptyMessageDelayed(asrk.jdField_a_of_type_Int, 35000L);
      }
      c(paramasnt);
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return : " + i);
  }
  
  private void b(boolean paramBoolean)
  {
    bdla.b(null, "dc00898", "", "", "0X800AE9C", "0X800AE9C", 0, 0, "", "", "", "");
    aslm localaslm = (aslm)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localaslm != null) {
      localaslm.a();
    }
    a(false, paramBoolean);
  }
  
  private boolean b()
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    while (((Build.VERSION.SDK_INT >= 17) && (getActivity().isDestroyed())) || ((this.jdField_a_of_type_Asnx != null) && (this.jdField_a_of_type_Asnx.getDialog() != null) && (this.jdField_a_of_type_Asnx.getDialog().isShowing())) || (!isVisible()) || (!isResumed()) || (!asru.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app)) || (this.jdField_b_of_type_Int == -1) || (!this.jdField_a_of_type_Boolean) || (bhhr.E(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApplication(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin()) != 0)) {
      return false;
    }
    return true;
  }
  
  private void c(asnt paramasnt)
  {
    String str = "#" + this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698501);
    Object localObject = str;
    if (paramasnt != null)
    {
      localObject = str;
      if (!TextUtils.isEmpty(paramasnt.jdField_a_of_type_JavaLangString)) {
        localObject = "# " + paramasnt.jdField_a_of_type_JavaLangString;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.a((String)localObject);
    }
    paramasnt = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365157);
    localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370805);
    a(paramasnt, this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView, (View)localObject);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView).b(53).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.g(25);
    }
    awui.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApplication() == null)) {}
    while (bhhr.E(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApplication(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin()) != 0) {
      return;
    }
    ((FriendListHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getApolloHead(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin());
  }
  
  private void k()
  {
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365157)).setVisibility(0);
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
    Object localObject = (aslo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localObject != null)
    {
      if (!((aslo)localObject).a()) {
        break label189;
      }
      localObject = bhdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (localObject != null)
      {
        String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698471);
        ((QQCustomDialog)localObject).setMessage(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698510));
        ((QQCustomDialog)localObject).setPositiveButton(str, new asrj(this));
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
    Object localObject = (aslo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    int i;
    if (localObject != null)
    {
      i = (int)((aslo)localObject).c();
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(BaseApplication.getContext().getResources().getString(2131698499), new Object[] { Integer.valueOf(i) }));
      localObject = ((aslo)localObject).a();
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
    aslm localaslm = (aslm)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localaslm != null) {
      localaslm.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentUin());
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "requestLeftMatchCountAndTaskInfo");
    }
    aslm localaslm = (aslm)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localaslm != null) {
      localaslm.a(false, false);
    }
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "showCompletePersonalInfoDialog");
    }
    aslo localaslo = (aslo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localaslo != null)
    {
      int k = (int)localaslo.a();
      int j = k - (int)localaslo.b();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      this.jdField_a_of_type_Astu.a(k, i, localaslo.a());
      bdla.b(null, "dc00898", "", "", "0X800B089", "0X800B089", localaslo.b(), 0, "", "", "", "");
    }
  }
  
  private void r()
  {
    asru.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new asrb(this), 1);
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!asru.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app)))
    {
      asru.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, true);
      asun.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new asrc(this));
    }
    aslo localaslo;
    do
    {
      return;
      if (!asru.a())
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
      localaslo = (aslo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    } while (localaslo == null);
    localaslo.c(true);
    this.jdField_a_of_type_Asrk.sendEmptyMessageDelayed(asrk.c, asrk.d);
    localaslo.g();
    bdla.b(null, "dc00898", "", "", "0X800AE9D", "0X800AE9D", 0, 0, "", "", "", "");
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
      aslo localaslo = (aslo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (localaslo != null) {
        localaslo.c(false);
      }
    }
  }
  
  private void v()
  {
    QLog.d("ExtendFriendLimitChatMatchFragment", 2, "checkNeedPush");
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      asru.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
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
  
  public void a(int paramInt, asne paramasne, String paramString1, String paramString2)
  {
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "onMatchResult result" + paramInt);
    if (this.jdField_a_of_type_Asrk != null) {
      this.jdField_a_of_type_Asrk.removeMessages(asrk.jdField_a_of_type_Int);
    }
    if ((paramInt == 0) && (paramasne != null))
    {
      aweo.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramasne, paramString1, this.jdField_a_of_type_Int);
      l();
      n();
      if (paramasne == null) {}
      for (paramasne = "";; paramasne = paramasne.b)
      {
        bdla.b(null, "dc00898", "", paramasne, "0X80096A6", "0X80096A6", this.jdField_a_of_type_Int, 0, "", "", "", "");
        return;
      }
    }
    if (paramInt == 7)
    {
      l();
      paramString1 = (aslo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      paramasne = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString1.e();
        paramasne = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramasne = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698489);
        }
      }
      a(paramasne, false);
      return;
    }
    if (paramInt == 2)
    {
      l();
      paramasne = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramasne = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698477);
      }
      a(paramasne);
      return;
    }
    if (paramInt == 8)
    {
      l();
      paramasne = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramasne = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698520);
      }
      a(paramasne, true);
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
    paramasne = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramasne = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698479);
    }
    a(paramasne, false);
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
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new asrg(this, paramMatchingView, paramView1));
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void a(asnt paramasnt)
  {
    if (paramasnt != null)
    {
      this.jdField_a_of_type_Asnt = paramasnt;
      b(this.jdField_a_of_type_Asnt);
      HashMap localHashMap = new HashMap();
      localHashMap.put("label_content", paramasnt.jdField_a_of_type_JavaLangString);
      UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#chat_tab#chat_label", true, -1L, -1L, localHashMap, true, true);
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 1, "ONTAG CLICK WITH NULL INFO");
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
    } while ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView == null) || (!asrl.b()));
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
    bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A696", "0X800A696", 0, 0, "", "", "", "");
    MatchChatMsgListFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Awum == null) {
      this.jdField_a_of_type_Awum = new awum(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bkzi == null) {
        this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Awum.a()));
      }
      this.jdField_a_of_type_Bkzi.show();
      return;
      this.jdField_a_of_type_Awum.a();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bkzi != null) {
      this.jdField_a_of_type_Bkzi.dismiss();
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
      this.jdField_a_of_type_Asnt = null;
      b(null);
      int i = asqt.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      int j = this.jdField_a_of_type_Int + 1;
      bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A68F", "0X800A68F", j, i, "", "", "", "");
      HashMap localHashMap = new HashMap();
      localHashMap.put("frompage", String.valueOf(j));
      UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#chat_tab#match_btn", true, -1L, -1L, localHashMap, true, true);
      continue;
      e();
      continue;
      bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A68D", "0X800A68D", 0, 0, "", "", "", "");
      UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#chat_tab#choice_btn", true, -1L, -1L, null, true, true);
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
    this.jdField_a_of_type_Asqt = ((asqt)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER));
    this.jdField_a_of_type_Asqt.a(this);
    this.jdField_a_of_type_Asrk = new asrk(this);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Aslz);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Anvi);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131561128, null));
    paramLayoutInflater = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379020);
    if (this.jdField_a_of_type_Int == 1)
    {
      paramLayoutInflater.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setClickable(false);
      ((aslo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).e();
      paramLayoutInflater = (aslm)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(true, true);
      }
      aslo.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      paramLayoutInflater = (aslo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      }
      ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370103)).setOnClickListener(this);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371991);
      if (paramLayoutInflater != null)
      {
        if ((!ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app)) || (this.jdField_a_of_type_Int != 1)) {
          break label892;
        }
        paramLayoutInflater.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370803));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew = ((HorseRaceLampVew)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368319));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370104));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370105));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new mvl());
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setTagClickListner(this);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371608));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366792));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377768));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView = ((SignalBombAnimationView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377767));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368102));
      this.jdField_a_of_type_Asuz = new asuz(1);
      if (this.jdField_a_of_type_Asuz.a() != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Asuz.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView = ((MatchingView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370811));
      int k = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      int m = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297302);
      int n = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297285);
      int i1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297286);
      int i2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297281);
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
      paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370804);
      paramLayoutInflater = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370104);
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
      this.jdField_a_of_type_Astu = new astu(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramLayoutInflater.setVisibility(8);
      break;
      label892:
      paramLayoutInflater.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Int == 1) {
      ((aslo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f();
    }
    u();
    super.onDestroy();
    if (this.jdField_a_of_type_Asuz != null)
    {
      this.jdField_a_of_type_Asuz.d();
      this.jdField_a_of_type_Asuz = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.c();
    }
    if (this.jdField_a_of_type_Asrk != null)
    {
      this.jdField_a_of_type_Asrk.removeMessages(asrk.jdField_a_of_type_Int);
      this.jdField_a_of_type_Asrk.removeMessages(asrk.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_Bkzi != null) {
      this.jdField_a_of_type_Bkzi = null;
    }
    if (this.jdField_a_of_type_Awum != null) {
      this.jdField_a_of_type_Awum.c();
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Aslz);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Anvi);
    bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "qq_kuolie", "0X800AA93", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
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
    if (this.jdField_a_of_type_Astu.isShowing()) {
      p();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.jdField_a_of_type_Int == 1) && (!this.jdField_b_of_type_Boolean)) {
      this.jdField_b_of_type_Boolean = asru.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment
 * JD-Core Version:    0.7.0.1
 */