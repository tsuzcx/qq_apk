package com.tencent.mobileqq.extendfriend.limitchat;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
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
import anod;
import anoe;
import anoj;
import anpe;
import ansl;
import anso;
import ansp;
import ansq;
import ansr;
import anss;
import anst;
import ansu;
import ansv;
import anup;
import aqux;
import arjg;
import arjk;
import arjl;
import awqx;
import babr;
import badq;
import bafb;
import bbmy;
import begr;
import behe;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
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
  implements View.OnClickListener, anso, arjl
{
  private int jdField_a_of_type_Int = 0;
  AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ansp(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anoj jdField_a_of_type_Anoj = new anst(this);
  private ansl jdField_a_of_type_Ansl;
  private ansu jdField_a_of_type_Ansu;
  private anup jdField_a_of_type_Anup;
  arjk jdField_a_of_type_Arjk = null;
  protected bafb a;
  begr jdField_a_of_type_Begr = null;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  public RedTouch a;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ImageView d;
  
  private void a(String paramString)
  {
    bbmy.a(BaseApplication.getContext(), paramString, 0).a();
    j();
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ansu != null) {
      this.jdField_a_of_type_Ansu.removeMessages(ansu.jdField_a_of_type_Int);
    }
    int i = this.jdField_a_of_type_Ansl.a();
    j();
    if (i == 2)
    {
      this.jdField_a_of_type_Ansl.c();
      if (paramBoolean) {
        b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131633223));
      }
    }
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_a_of_type_Bafb == null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app != null)) {
      this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131633220), new anss(this)).setNegativeButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131633219), new ansr(this));
    }
    try
    {
      if ((this.jdField_a_of_type_Bafb != null) && (!this.jdField_a_of_type_Bafb.isShowing())) {
        this.jdField_a_of_type_Bafb.show();
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "match fail dialog error:" + paramString);
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView).a(53).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.f(25);
    }
    arjg.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
  }
  
  private void h()
  {
    int i = this.jdField_a_of_type_Ansl.a();
    if (i == 2)
    {
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return");
      return;
    }
    if (!badq.e(BaseApplication.getContext()))
    {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131633225));
      return;
    }
    this.jdField_a_of_type_Ansl.a(this.jdField_a_of_type_Int);
    if (i == 0)
    {
      this.jdField_a_of_type_Ansl.b();
      if (this.jdField_a_of_type_Ansu != null) {
        this.jdField_a_of_type_Ansu.sendEmptyMessageDelayed(ansu.jdField_a_of_type_Int, 35000L);
      }
      i();
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return : " + i);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.d.setVisibility(0);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  private void k()
  {
    anod localanod = (anod)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(127);
    if (localanod != null) {
      localanod.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.c());
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
  
  public void a(int paramInt, anpe paramanpe, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Ansu != null) {
      this.jdField_a_of_type_Ansu.removeMessages(ansu.jdField_a_of_type_Int);
    }
    if ((paramInt == 0) && (paramanpe != null))
    {
      a(paramanpe, paramString1);
      j();
      if (paramanpe == null) {}
      for (paramanpe = "";; paramanpe = paramanpe.b)
      {
        awqx.b(null, "dc00898", "", paramanpe, "0X80096A6", "0X80096A6", this.jdField_a_of_type_Int, 0, "", "", "", "");
        return;
      }
    }
    if (paramInt == 7)
    {
      j();
      paramString1 = (anoe)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
      paramanpe = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString1.e();
        paramanpe = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramanpe = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131633236);
        }
      }
      a(paramanpe);
      return;
    }
    if (paramInt == 2)
    {
      j();
      paramanpe = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramanpe = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131633223);
      }
      b(paramanpe);
      return;
    }
    j();
    paramanpe = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramanpe = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131633226);
    }
    a(paramanpe);
  }
  
  public void a(anpe paramanpe, String paramString)
  {
    String str1 = paramanpe.b;
    String str2 = paramanpe.c;
    long l = paramanpe.a;
    aqux.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str1, paramString, Long.valueOf(l), str2, this.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    ThreadManager.getSubThreadHandler().post(new ExtendFriendLimitChatMatchFragment.5(this));
  }
  
  public void c()
  {
    awqx.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A696", "0X800A696", 0, 0, "", "", "", "");
    MatchChatMsgListFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Arjk == null) {
      this.jdField_a_of_type_Arjk = new arjk(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Begr == null) {
        this.jdField_a_of_type_Begr = ((begr)behe.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Arjk.a()));
      }
      this.jdField_a_of_type_Begr.show();
      return;
      this.jdField_a_of_type_Arjk.a();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Begr != null) {
      this.jdField_a_of_type_Begr.dismiss();
    }
  }
  
  public void f()
  {
    ansv.a((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131312559), "tvMast.png");
    ansv.a(this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131312426), "tvScreen.png");
    ansv.a(this.jdField_c_of_type_AndroidWidgetImageView, "tvImage.png");
    ansv.a(this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131312252), "tvDecorate.png");
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ansv.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext());
      if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null) {
        this.d.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
      }
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
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131303528: 
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.doOnBackPressed();
      return;
    case 2131303529: 
      h();
      int i = ansl.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      int j = this.jdField_a_of_type_Int;
      awqx.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A68F", "0X800A68F", j + 1, i, "", "", "", "");
      return;
    case 2131304802: 
      c();
      return;
    }
    awqx.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A68D", "0X800A68D", 0, 0, "", "", "", "");
    a(false);
    d();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramBundle = getArguments();
    if (paramBundle != null) {
      this.jdField_a_of_type_Int = paramBundle.getInt("ExtendFriendLimitChatFromeType", 0);
    }
    this.jdField_a_of_type_Ansl = ((ansl)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(292));
    this.jdField_a_of_type_Ansl.a(this);
    this.jdField_a_of_type_Ansu = new ansu(this);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Anoj);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131495174, null));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new ansq(this));
    paramLayoutInflater = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131311553);
    label144:
    int j;
    int m;
    int k;
    if (this.jdField_a_of_type_Int == 1)
    {
      paramViewGroup = (anoe)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264);
      if (paramViewGroup != null) {
        paramViewGroup.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      }
      paramLayoutInflater.setVisibility(0);
      ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303528)).setOnClickListener(this);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131305167);
      if (paramLayoutInflater != null)
      {
        if ((!ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app)) || (this.jdField_a_of_type_Int != 1)) {
          break label880;
        }
        paramLayoutInflater.setVisibility(0);
      }
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131312579));
      this.d = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131312427));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131304151));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131304154));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131304150));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303529));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131304802));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300657));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301804));
      this.jdField_a_of_type_Anup = new anup(1);
      if (this.jdField_a_of_type_Anup.a() != null) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Anup.a());
      }
      j = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      m = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131166070);
      k = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131166073);
      int n = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131166076);
      int i1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131166074);
      int i2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131166068);
      int i3 = a();
      i = i3 - j - m - k - n - i1 - i2;
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "screentHeight " + i3 + " statusHeight " + j + " titleHeight " + m + " tvWireHeight " + n + " tvHeight " + k + " tvLintHeight " + i1 + " btnHeight " + i2 + " leftHeight " + i);
      j = i;
      if (i < 0)
      {
        m = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131166071) + this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131166071);
        j = i + m;
        QLog.i("ExtendFriendLimitChatMatchFragment", 2, "delta " + j);
        if (j <= 0) {
          break label889;
        }
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131312248);
        i = j;
        if (paramLayoutInflater != null)
        {
          paramViewGroup = paramLayoutInflater.getLayoutParams();
          paramViewGroup.height = (k - m);
          paramLayoutInflater.setLayoutParams(paramViewGroup);
        }
      }
    }
    for (int i = j;; i = 0)
    {
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131312252);
      j = i;
      if (paramLayoutInflater != null)
      {
        paramLayoutInflater.setVisibility(8);
        j = i;
      }
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "leftHeight " + j);
      float f = j / 3.0F;
      paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299132);
      paramLayoutInflater = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303529);
      if (paramViewGroup != null)
      {
        paramBundle = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
        paramBundle.setMargins(0, (int)f, 0, 0);
        paramViewGroup.setLayoutParams(paramBundle);
      }
      if (paramLayoutInflater != null)
      {
        paramViewGroup = (RelativeLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
        paramViewGroup.setMargins(0, (int)f, 0, 0);
        paramLayoutInflater.setLayoutParams(paramViewGroup);
      }
      k();
      f();
      b();
      g();
      return this.jdField_a_of_type_AndroidViewViewGroup;
      paramLayoutInflater.setVisibility(8);
      break;
      label880:
      paramLayoutInflater.setVisibility(8);
      break label144;
      label889:
      i = k - j - m;
      j = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131166073) - j;
      if (i > 0)
      {
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131312248);
        if (paramLayoutInflater != null)
        {
          paramViewGroup = paramLayoutInflater.getLayoutParams();
          paramViewGroup.height = i;
          paramLayoutInflater.setLayoutParams(paramViewGroup);
        }
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131312506);
        if (paramLayoutInflater != null)
        {
          paramViewGroup = paramLayoutInflater.getLayoutParams();
          paramViewGroup.height = j;
          paramLayoutInflater.setLayoutParams(paramViewGroup);
        }
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131312426);
        if (paramLayoutInflater != null)
        {
          paramViewGroup = paramLayoutInflater.getLayoutParams();
          paramViewGroup.height = j;
          paramLayoutInflater.setLayoutParams(paramViewGroup);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null)
    {
      ansv.a(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    }
    if (this.jdField_a_of_type_Anup != null)
    {
      this.jdField_a_of_type_Anup.d();
      this.jdField_a_of_type_Anup = null;
    }
    if (this.jdField_a_of_type_Ansu != null)
    {
      this.jdField_a_of_type_Ansu.removeMessages(ansu.jdField_a_of_type_Int);
      this.jdField_a_of_type_Ansu.removeMessages(ansu.b);
    }
    if (this.jdField_a_of_type_Begr != null)
    {
      this.jdField_a_of_type_Begr = null;
      QLog.d("yesyesyes", 2, "filter  on d");
    }
    if (this.jdField_a_of_type_Arjk != null)
    {
      this.jdField_a_of_type_Arjk.c();
      QLog.d("yesyesyes", 2, "filterContentView  on d");
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Anoj);
  }
  
  public void onPause()
  {
    QLog.i("ExtendFriendLimitChatMatchFragment", 2, "onPause");
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    AbstractGifImage.pauseAll();
    a(false);
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    AbstractGifImage.resumeAll();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment
 * JD-Core Version:    0.7.0.1
 */