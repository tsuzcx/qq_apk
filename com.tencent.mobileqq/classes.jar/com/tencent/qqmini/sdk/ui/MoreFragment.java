package com.tencent.qqmini.sdk.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bdyf;
import bdyn;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class MoreFragment
  extends MiniBaseFragment
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_f_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_g_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_h_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_i_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private LinearLayout j;
  
  private Intent a()
  {
    return getActivity().getIntent();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = a().getStringExtra("miniAppID");
    a().getStringExtra("miniAppName");
    boolean bool = a().getBooleanExtra("isOpenMonitorPanel", false);
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    Object localObject;
    label77:
    label104:
    label125:
    int k;
    if (bool)
    {
      localObject = "Pref.Off";
      localTextView.setText((CharSequence)localObject);
      bool = a().getBooleanExtra("debugEnable", false);
      localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      if (!bool) {
        break label542;
      }
      localObject = "Debug.Off";
      localTextView.setText((CharSequence)localObject);
      if (!a().getBooleanExtra("showShareQQ", false)) {
        break label548;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!a().getBooleanExtra("showShareQzone", false)) {
        break label560;
      }
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!a().getBooleanExtra("showShareWeChatFriends", false)) {
        break label572;
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label146:
      if (!a().getBooleanExtra("showShareWeChatMoment", false)) {
        break label584;
      }
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label167:
      if (!a().getBooleanExtra("showDebug", false)) {
        break label596;
      }
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label188:
      if (!a().getBooleanExtra("showMonitor", false)) {
        break label608;
      }
      this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label209:
      if (!a().getBooleanExtra("showDetail", false)) {
        break label620;
      }
      this.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label230:
      if (!a().getBooleanExtra("showComplaint", false)) {
        break label632;
      }
      this.j.setVisibility(0);
      label251:
      if (!a().getBooleanExtra("addShortcut", false)) {
        break label644;
      }
      this.jdField_h_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label272:
      k = a().getIntExtra("showBackHome", 0);
      if (k != -1) {
        break label656;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      localObject = getArguments();
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = ((MiniAppInfo)((Bundle)localObject).getParcelable("key_mini_app_info"));
      }
      this.jdField_a_of_type_Int = a().getIntExtra("key_mini_app_version_type", -1);
      this.jdField_c_of_type_Boolean = a().getBooleanExtra("key_mini_app_is_game", false);
      this.jdField_a_of_type_Boolean = a().getBooleanExtra("isFromShareButton", false);
      this.jdField_b_of_type_Boolean = a().getBooleanExtra("isLandscape", false);
      if ("dark".equalsIgnoreCase(a().getStringExtra("menuStyle")))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(0.86F);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
      if ("1108291530".equals(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      return;
      localObject = "Pref.On";
      break;
      label542:
      localObject = "Debug.On";
      break label77;
      label548:
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label104;
      label560:
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label125;
      label572:
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label146;
      label584:
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label167;
      label596:
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label188;
      label608:
      this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label209;
      label620:
      this.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label230;
      label632:
      this.j.setVisibility(8);
      break label251;
      label644:
      this.jdField_h_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label272;
      label656:
      if (k == 1)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
      }
      else if (k == 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      }
    }
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new bdyf(this, paramInt, paramBundle));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int m = -1;
    int k;
    if (paramView.getId() == 2131296648) {
      k = 0;
    }
    for (;;)
    {
      a(k, null);
      return;
      if (paramView.getId() == 2131304652)
      {
        k = 1;
      }
      else if (paramView.getId() == 2131304653)
      {
        k = 5;
      }
      else if (paramView.getId() == 2131304654)
      {
        k = 6;
      }
      else if (paramView.getId() == 2131304655)
      {
        k = 7;
      }
      else if (paramView.getId() == 2131304625)
      {
        k = 2;
      }
      else if (paramView.getId() == 2131304650)
      {
        k = 3;
      }
      else
      {
        k = m;
        if (paramView.getId() != 2131304627)
        {
          k = m;
          if (paramView.getId() == 2131304629) {
            k = m;
          }
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_b_of_type_Int = getActivity().getResources().getDisplayMetrics().heightPixels;
    this.jdField_c_of_type_Int = bdyn.d(getActivity());
    paramLayoutInflater = paramLayoutInflater.inflate(2131493734, paramViewGroup, false);
    if (paramLayoutInflater == null)
    {
      getActivity().finish();
      return null;
    }
    paramLayoutInflater.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304616));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription("回到首页");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304652));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setContentDescription("分享到QQ");
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304653));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setContentDescription("分享到QQ空间");
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304654));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131304635));
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setContentDescription("分享到微信");
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304655));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131304636));
    this.jdField_e_of_type_AndroidWidgetLinearLayout.setContentDescription("分享到朋友圈");
    this.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304625));
    this.jdField_f_of_type_AndroidWidgetLinearLayout.setContentDescription("调试开关");
    this.jdField_f_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304650));
    this.jdField_g_of_type_AndroidWidgetLinearLayout.setContentDescription("性能开关");
    this.jdField_g_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304614));
    this.jdField_h_of_type_AndroidWidgetLinearLayout.setContentDescription("添加到桌面");
    this.jdField_h_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_i_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304627));
    this.jdField_i_of_type_AndroidWidgetLinearLayout.setContentDescription("关于小程序");
    this.jdField_i_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.j = ((LinearLayout)paramLayoutInflater.findViewById(2131304620));
    this.j.setContentDescription("举报");
    this.j.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304629));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("取消");
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304658));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304624));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131310251));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304637));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304659));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304638));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304667));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304624));
    a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    b();
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MoreFragment
 * JD-Core Version:    0.7.0.1
 */