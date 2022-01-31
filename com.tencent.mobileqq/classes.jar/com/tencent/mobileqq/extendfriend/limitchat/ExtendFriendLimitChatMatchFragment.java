package com.tencent.mobileqq.extendfriend.limitchat;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Bundle;
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
import aoeo;
import aoep;
import aoeu;
import aofp;
import aogi;
import aoix;
import aoja;
import aojb;
import aojc;
import aojd;
import aoje;
import aojf;
import aojg;
import aolc;
import aolo;
import arqn;
import asfj;
import asfn;
import asfo;
import axqw;
import bbcv;
import bbev;
import bbgg;
import bcpw;
import bfol;
import bfoy;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.wiget.MatchingView;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.os.MqqHandler;

public class ExtendFriendLimitChatMatchFragment
  extends PublicBaseFragment
  implements View.OnClickListener, aoja, aolo, asfo
{
  private int jdField_a_of_type_Int = 0;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aojb(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aoeu jdField_a_of_type_Aoeu = new aojf(this);
  public aogi a;
  private aoix jdField_a_of_type_Aoix;
  private aojg jdField_a_of_type_Aojg;
  public aolc a;
  asfn jdField_a_of_type_Asfn = null;
  protected bbgg a;
  bfol jdField_a_of_type_Bfol = null;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private MatchingView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView;
  private HorseRaceLampVew jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew;
  public RedTouch a;
  private String jdField_a_of_type_JavaLangString = "";
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ExtendFriendLimitChatMatchFragment()
  {
    this.jdField_a_of_type_Aogi = null;
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
    bcpw.a(BaseApplication.getContext(), paramString, 0).a();
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
    }
    i();
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aojg != null) {
      this.jdField_a_of_type_Aojg.removeMessages(aojg.jdField_a_of_type_Int);
    }
    int i = this.jdField_a_of_type_Aoix.a();
    j();
    if (i == 2)
    {
      this.jdField_a_of_type_Aoix.b();
      if (paramBoolean) {
        b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698960));
      }
    }
  }
  
  private void b(aogi paramaogi)
  {
    if (this.jdField_a_of_type_Aoix.a() == 2)
    {
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return");
      return;
    }
    if (!bbev.e(BaseApplication.getContext()))
    {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698962));
      return;
    }
    this.jdField_a_of_type_Aoix.a(this.jdField_a_of_type_Int);
    int i = this.jdField_a_of_type_Aoix.a();
    if (i == 0)
    {
      this.jdField_a_of_type_Aoix.a(paramaogi);
      if (this.jdField_a_of_type_Aojg != null) {
        this.jdField_a_of_type_Aojg.sendEmptyMessageDelayed(aojg.jdField_a_of_type_Int, 35000L);
      }
      c(paramaogi);
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return : " + i);
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_a_of_type_Bbgg == null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app != null)) {
      this.jdField_a_of_type_Bbgg = bbcv.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698957), new aoje(this)).setNegativeButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698956), new aojd(this));
    }
    try
    {
      if ((this.jdField_a_of_type_Bbgg != null) && (!this.jdField_a_of_type_Bbgg.isShowing())) {
        this.jdField_a_of_type_Bbgg.show();
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "match fail dialog error:" + paramString);
    }
  }
  
  private void c(aogi paramaogi)
  {
    String str = "#" + this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698985);
    Object localObject = str;
    if (paramaogi != null)
    {
      localObject = str;
      if (!TextUtils.isEmpty(paramaogi.jdField_a_of_type_JavaLangString)) {
        localObject = "# " + paramaogi.jdField_a_of_type_JavaLangString;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.a((String)localObject);
    }
    paramaogi = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364692);
    localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369826);
    a(paramaogi, this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView, (View)localObject);
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView).a(53).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.f(25);
    }
    asfj.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
  }
  
  private void i()
  {
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364692)).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.setVisibility(8);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.b();
  }
  
  private void k()
  {
    aoeo localaoeo = (aoeo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(127);
    if (localaoeo != null) {
      localaoeo.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.c());
    }
  }
  
  int a()
  {
    return ((WindowManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("window")).getDefaultDisplay().getHeight();
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(int paramInt, aofp paramaofp, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Aojg != null) {
      this.jdField_a_of_type_Aojg.removeMessages(aojg.jdField_a_of_type_Int);
    }
    if ((paramInt == 0) && (paramaofp != null))
    {
      a(paramaofp, paramString1);
      j();
      if (paramaofp == null) {}
      for (paramaofp = "";; paramaofp = paramaofp.b)
      {
        axqw.b(null, "dc00898", "", paramaofp, "0X80096A6", "0X80096A6", this.jdField_a_of_type_Int, 0, "", "", "", "");
        return;
      }
    }
    if (paramInt == 7)
    {
      j();
      paramString1 = (aoep)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
      paramaofp = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString1.e();
        paramaofp = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramaofp = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698973);
        }
      }
      a(paramaofp);
      return;
    }
    if (paramInt == 2)
    {
      j();
      paramaofp = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramaofp = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698960);
      }
      b(paramaofp);
      return;
    }
    j();
    paramaofp = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramaofp = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698963);
    }
    a(paramaofp);
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
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new aojc(this, paramMatchingView, paramView1));
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void a(aofp paramaofp, String paramString)
  {
    String str1 = paramaofp.b;
    String str2 = paramaofp.c;
    long l = paramaofp.a;
    arqn.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str1, paramString, Long.valueOf(l), str2, this.jdField_a_of_type_Int);
  }
  
  public void a(aogi paramaogi)
  {
    if (paramaogi != null)
    {
      this.jdField_a_of_type_Aogi = paramaogi;
      b(this.jdField_a_of_type_Aogi);
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "ONTAG CLICK WITH NULL INFO");
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
    ThreadManager.getSubThreadHandler().post(new ExtendFriendLimitChatMatchFragment.5(this));
  }
  
  public void e()
  {
    axqw.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A696", "0X800A696", 0, 0, "", "", "", "");
    MatchChatMsgListFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Asfn == null) {
      this.jdField_a_of_type_Asfn = new asfn(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bfol == null) {
        this.jdField_a_of_type_Bfol = ((bfol)bfoy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Asfn.a()));
      }
      this.jdField_a_of_type_Bfol.show();
      return;
      this.jdField_a_of_type_Asfn.a();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bfol != null) {
      this.jdField_a_of_type_Bfol.dismiss();
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
    default: 
      return;
    case 2131369196: 
      onBackEvent();
      return;
    case 2131369197: 
      this.jdField_a_of_type_Aogi = null;
      b(null);
      int i = aoix.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      int j = this.jdField_a_of_type_Int;
      axqw.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A68F", "0X800A68F", j + 1, i, "", "", "", "");
      return;
    case 2131370463: 
      e();
      return;
    }
    axqw.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A68D", "0X800A68D", 0, 0, "", "", "", "");
    a(false);
    f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramBundle = getArguments();
    if (paramBundle != null) {
      this.jdField_a_of_type_Int = paramBundle.getInt("ExtendFriendLimitChatFromeType", 0);
    }
    this.jdField_a_of_type_Aoix = ((aoix)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(292));
    this.jdField_a_of_type_Aoix.a(this);
    this.jdField_a_of_type_Aojg = new aojg(this);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Aoeu);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131560749, null));
    paramLayoutInflater = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377369);
    if (this.jdField_a_of_type_Int == 1)
    {
      paramViewGroup = (aoep)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
      if (paramViewGroup != null) {
        paramViewGroup.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      }
      paramLayoutInflater.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setClickable(false);
      ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369196)).setOnClickListener(this);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370840);
      if (paramLayoutInflater != null)
      {
        if ((!ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app)) || (this.jdField_a_of_type_Int != 1)) {
          break label712;
        }
        paramLayoutInflater.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369824));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew = ((HorseRaceLampVew)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367623));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369197));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setTagClickListner(this);
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370463));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366259));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367414));
      this.jdField_a_of_type_Aolc = new aolc(1);
      if (this.jdField_a_of_type_Aolc.a() != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Aolc.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView = ((MatchingView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369832));
      int k = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      int m = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297154);
      int n = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297144);
      int i1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297145);
      int i2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297143);
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
      paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364692);
      paramLayoutInflater = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369197);
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
      k();
      d();
      h();
      return this.jdField_a_of_type_AndroidViewViewGroup;
      paramLayoutInflater.setVisibility(8);
      break;
      label712:
      paramLayoutInflater.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aolc != null)
    {
      this.jdField_a_of_type_Aolc.d();
      this.jdField_a_of_type_Aolc = null;
    }
    if (this.jdField_a_of_type_Aojg != null)
    {
      this.jdField_a_of_type_Aojg.removeMessages(aojg.jdField_a_of_type_Int);
      this.jdField_a_of_type_Aojg.removeMessages(aojg.b);
    }
    if (this.jdField_a_of_type_Bfol != null) {
      this.jdField_a_of_type_Bfol = null;
    }
    if (this.jdField_a_of_type_Asfn != null) {
      this.jdField_a_of_type_Asfn.c();
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Aoeu);
    axqw.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800AA93", "qq_kuolie", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
  }
  
  public void onPause()
  {
    QLog.i("ExtendFriendLimitChatMatchFragment", 2, "onPause");
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    AbstractGifImage.pauseAll();
    a(false);
    b();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    AbstractGifImage.resumeAll();
    i();
    c();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment
 * JD-Core Version:    0.7.0.1
 */