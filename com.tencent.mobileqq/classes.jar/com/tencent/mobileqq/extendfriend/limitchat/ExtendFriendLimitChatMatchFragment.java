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
import apwv;
import apwx;
import apxc;
import apyc;
import apyr;
import aqbb;
import aqbg;
import aqbh;
import aqbi;
import aqbj;
import aqbk;
import aqbl;
import aqbm;
import aqbn;
import aqcz;
import aqef;
import aqer;
import athk;
import atwl;
import atwp;
import atwq;
import azmj;
import bdcd;
import bdee;
import bdfq;
import bhpy;
import bhql;
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
  implements View.OnClickListener, aqbg, aqer, atwq
{
  private int jdField_a_of_type_Int = 0;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aqbh(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private apxc jdField_a_of_type_Apxc = new aqbm(this);
  public apyr a;
  private aqbb jdField_a_of_type_Aqbb;
  private aqbn jdField_a_of_type_Aqbn;
  public aqef a;
  atwp jdField_a_of_type_Atwp = null;
  protected bdfq a;
  bhpy jdField_a_of_type_Bhpy = null;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private MatchingView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView;
  private HorseRaceLampVew jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew;
  public RedTouch a;
  private String jdField_a_of_type_JavaLangString = "";
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ExtendFriendLimitChatMatchFragment()
  {
    this.jdField_a_of_type_Apyr = null;
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
    if ((this.jdField_a_of_type_Bdfq == null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app != null)) {
      this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131699290), new aqbl(this)).setNegativeButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131699289), new aqbk(this));
    }
    try
    {
      if ((this.jdField_a_of_type_Bdfq != null) && (!this.jdField_a_of_type_Bdfq.isShowing())) {
        this.jdField_a_of_type_Bdfq.show();
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
    bdfq localbdfq;
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      localbdfq = bdcd.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (localbdfq != null)
      {
        Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131699273);
        if (paramBoolean)
        {
          localObject = localbdfq.getMessageTextView();
          if (localObject != null) {
            ((TextView)localObject).setGravity(17);
          }
          localbdfq.setTitle(2131699343);
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131699272);
        }
        localbdfq.setMessage(paramString);
        localbdfq.setPositiveButton((String)localObject, new aqbi(this));
      }
    }
    try
    {
      localbdfq.show();
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
      {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      }
      i();
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
    if (this.jdField_a_of_type_Aqbn != null) {
      this.jdField_a_of_type_Aqbn.removeMessages(aqbn.jdField_a_of_type_Int);
    }
    int i = this.jdField_a_of_type_Aqbb.a();
    j();
    if (i == 2)
    {
      this.jdField_a_of_type_Aqbb.b();
      if (paramBoolean) {
        a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131699293));
      }
    }
  }
  
  private void b(apyr paramapyr)
  {
    if (this.jdField_a_of_type_Aqbb.a() == 2)
    {
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return");
      return;
    }
    if (!bdee.e(BaseApplication.getContext()))
    {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131699295), false);
      return;
    }
    this.jdField_a_of_type_Aqbb.a(this.jdField_a_of_type_Int);
    int i = this.jdField_a_of_type_Aqbb.a();
    if (i == 0)
    {
      this.jdField_a_of_type_Aqbb.a(paramapyr);
      if (this.jdField_a_of_type_Aqbn != null) {
        this.jdField_a_of_type_Aqbn.sendEmptyMessageDelayed(aqbn.jdField_a_of_type_Int, 35000L);
      }
      c(paramapyr);
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return : " + i);
  }
  
  private void c(apyr paramapyr)
  {
    String str = "#" + this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131699320);
    Object localObject = str;
    if (paramapyr != null)
    {
      localObject = str;
      if (!TextUtils.isEmpty(paramapyr.jdField_a_of_type_JavaLangString)) {
        localObject = "# " + paramapyr.jdField_a_of_type_JavaLangString;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.a((String)localObject);
    }
    paramapyr = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364770);
    localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370089);
    a(paramapyr, this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView, (View)localObject);
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView).a(53).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.f(25);
    }
    atwl.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
  }
  
  private void i()
  {
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364770)).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.setVisibility(8);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.b();
  }
  
  private void k()
  {
    apwv localapwv = (apwv)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(127);
    if (localapwv != null) {
      localapwv.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.c());
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
  
  public void a(int paramInt, apyc paramapyc, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Aqbn != null) {
      this.jdField_a_of_type_Aqbn.removeMessages(aqbn.jdField_a_of_type_Int);
    }
    if ((paramInt == 0) && (paramapyc != null))
    {
      a(paramapyc, paramString1);
      j();
      if (paramapyc == null) {}
      for (paramapyc = "";; paramapyc = paramapyc.b)
      {
        azmj.b(null, "dc00898", "", paramapyc, "0X80096A6", "0X80096A6", this.jdField_a_of_type_Int, 0, "", "", "", "");
        return;
      }
    }
    if (paramInt == 7)
    {
      j();
      paramString1 = (apwx)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
      paramapyc = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString1.e();
        paramapyc = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramapyc = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131699308);
        }
      }
      a(paramapyc, false);
      return;
    }
    if (paramInt == 2)
    {
      j();
      paramapyc = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramapyc = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131699293);
      }
      a(paramapyc);
      return;
    }
    if (paramInt == 8)
    {
      j();
      paramapyc = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramapyc = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131699342);
      }
      a(paramapyc, true);
      return;
    }
    j();
    paramapyc = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramapyc = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131699296);
    }
    a(paramapyc, false);
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
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new aqbj(this, paramMatchingView, paramView1));
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void a(apyc paramapyc, String paramString)
  {
    String str1 = paramapyc.b;
    String str2 = paramapyc.c;
    long l = paramapyc.a;
    athk.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str1, paramString, Long.valueOf(l), str2, this.jdField_a_of_type_Int);
  }
  
  public void a(apyr paramapyr)
  {
    if (aqcz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      QLog.d("ExtendFriendLimitChatMatchFragment", 1, "onTagClick-> campus is not verify");
      return;
    }
    azmj.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "qq_kuolie", "0X800AA95", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
    if (paramapyr != null)
    {
      this.jdField_a_of_type_Apyr = paramapyr;
      b(this.jdField_a_of_type_Apyr);
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
    ThreadManager.getSubThreadHandler().post(new ExtendFriendLimitChatMatchFragment.6(this));
  }
  
  public void e()
  {
    azmj.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A696", "0X800A696", 0, 0, "", "", "", "");
    MatchChatMsgListFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Atwp == null) {
      this.jdField_a_of_type_Atwp = new atwp(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bhpy == null) {
        this.jdField_a_of_type_Bhpy = ((bhpy)bhql.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Atwp.a()));
      }
      this.jdField_a_of_type_Bhpy.show();
      return;
      this.jdField_a_of_type_Atwp.a();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bhpy != null) {
      this.jdField_a_of_type_Bhpy.dismiss();
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
    case 2131369429: 
      onBackEvent();
      return;
    case 2131369430: 
      if (aqcz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        QLog.d("ExtendFriendLimitChatMatchFragment", 1, "limit_chat_match_start_button-> campus is not verify");
        return;
      }
      this.jdField_a_of_type_Apyr = null;
      b(null);
      int i = aqbb.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      int j = this.jdField_a_of_type_Int;
      azmj.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A68F", "0X800A68F", j + 1, i, "", "", "", "");
      return;
    case 2131370768: 
      e();
      return;
    }
    azmj.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A68D", "0X800A68D", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_Aqbb = ((aqbb)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(292));
    this.jdField_a_of_type_Aqbb.a(this);
    this.jdField_a_of_type_Aqbn = new aqbn(this);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Apxc);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131560929, null));
    paramLayoutInflater = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377903);
    if (this.jdField_a_of_type_Int == 1)
    {
      paramViewGroup = (apwx)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
      if (paramViewGroup != null) {
        paramViewGroup.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      }
      paramLayoutInflater.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setClickable(false);
      ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369429)).setOnClickListener(this);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371150);
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
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370087));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew = ((HorseRaceLampVew)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367752));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369430));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setTagClickListner(this);
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370768));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366350));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367543));
      this.jdField_a_of_type_Aqef = new aqef(1);
      if (this.jdField_a_of_type_Aqef.a() != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Aqef.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView = ((MatchingView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370095));
      int k = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      int m = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297171);
      int n = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297161);
      int i1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297162);
      int i2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297160);
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
      paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364770);
      paramLayoutInflater = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369430);
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
    if (this.jdField_a_of_type_Aqef != null)
    {
      this.jdField_a_of_type_Aqef.d();
      this.jdField_a_of_type_Aqef = null;
    }
    if (this.jdField_a_of_type_Aqbn != null)
    {
      this.jdField_a_of_type_Aqbn.removeMessages(aqbn.jdField_a_of_type_Int);
      this.jdField_a_of_type_Aqbn.removeMessages(aqbn.b);
    }
    if (this.jdField_a_of_type_Bhpy != null) {
      this.jdField_a_of_type_Bhpy = null;
    }
    if (this.jdField_a_of_type_Atwp != null) {
      this.jdField_a_of_type_Atwp.c();
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Apxc);
    azmj.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "qq_kuolie", "0X800AA93", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment
 * JD-Core Version:    0.7.0.1
 */