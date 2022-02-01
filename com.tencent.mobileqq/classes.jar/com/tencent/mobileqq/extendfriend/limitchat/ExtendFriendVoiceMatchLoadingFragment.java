package com.tencent.mobileqq.extendfriend.limitchat;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.extendfriend.bean.TagInfo;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.wiget.MatchingView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.LiuHaiUtils;
import java.util.HashMap;
import java.util.Map;

public class ExtendFriendVoiceMatchLoadingFragment
  extends PublicBaseFragment
  implements View.OnClickListener, ExtendFriendLimitChatManager.LimitChatMatchListener
{
  private int jdField_a_of_type_Int = 2;
  private long jdField_a_of_type_Long;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TagInfo jdField_a_of_type_ComTencentMobileqqExtendfriendBeanTagInfo;
  private ExtendFriendLimitChatManager jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager;
  private ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendVoiceMatchLoadingFragment$LimitChatHandler;
  private MatchingView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView;
  protected QQCustomDialog a;
  private int b;
  
  public ExtendFriendVoiceMatchLoadingFragment()
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  private void a()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanTagInfo);
    int i = this.jdField_a_of_type_Int + 1;
    ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A68F", "0X800A68F", i, this.jdField_b_of_type_Int, "", "", "", "");
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", String.valueOf(i));
    ExpandReportUtils.a("click#chat_tab#match_btn", true, -1L, -1L, localHashMap, true, true);
  }
  
  private void a(TagInfo paramTagInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.a() == 2)
    {
      QLog.i("ExtendFriendVoiceMatchLoadingFragment", 2, "startMatching IN STATE_MATCHING return");
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698761), false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.a(this.jdField_a_of_type_Int);
    int i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.a();
    if (i == 0)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.a(paramTagInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendVoiceMatchLoadingFragment$LimitChatHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendVoiceMatchLoadingFragment$LimitChatHandler.sendEmptyMessageDelayed(ExtendFriendLimitChatMatchFragment.LimitChatHandler.jdField_a_of_type_Int, 35000L);
      }
      c();
      return;
    }
    QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "startMatching IN STATE_MATCHING return : " + i);
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app != null)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698759), new ExtendFriendVoiceMatchLoadingFragment.3(this)).setNegativeButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698758), new ExtendFriendVoiceMatchLoadingFragment.2(this));
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
      QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "match fail dialog error:" + paramString);
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    QQCustomDialog localQQCustomDialog;
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (localQQCustomDialog != null)
      {
        Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698755);
        if (paramBoolean)
        {
          localObject = localQQCustomDialog.getMessageTextView();
          if (localObject != null) {
            ((TextView)localObject).setGravity(17);
          }
          localQQCustomDialog.setTitle(2131698813);
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698754);
        }
        localQQCustomDialog.setMessage(paramString);
        localQQCustomDialog.setPositiveButton((String)localObject, new ExtendFriendVoiceMatchLoadingFragment.4(this));
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
      f();
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "match handleFailAndQuitDialog error:" + paramString);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendVoiceMatchLoadingFragment$LimitChatHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendVoiceMatchLoadingFragment$LimitChatHandler.removeMessages(ExtendFriendLimitChatMatchFragment.LimitChatHandler.jdField_a_of_type_Int);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.a();
    d();
    if (i == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.c();
      if (paramBoolean) {
        a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698760));
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceMatchLoadingFragment", 2, "handleOutOfMatchCountResult");
    }
    d();
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      QLog.d("ExtendFriendVoiceMatchLoadingFragment", 1, "handleOutOfMatchCountResult return");
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
    if (localQQCustomDialog != null)
    {
      String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698754);
      localQQCustomDialog.setMessage(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698795));
      localQQCustomDialog.setPositiveButton(str, new ExtendFriendVoiceMatchLoadingFragment.1(this));
    }
    try
    {
      localQQCustomDialog.show();
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
      {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      }
      f();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ExtendFriendVoiceMatchLoadingFragment", 1, "match handleOutOfMatchCountResult error:" + localThrowable);
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.a("# 语音连麦");
    }
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371086);
    a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView, localImageView);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.b();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.a();
  }
  
  private void f() {}
  
  public void a(int paramInt, MatchInfo paramMatchInfo, String paramString1, String paramString2)
  {
    QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "onMatchResult result" + paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendVoiceMatchLoadingFragment$LimitChatHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendVoiceMatchLoadingFragment$LimitChatHandler.removeMessages(ExtendFriendLimitChatMatchFragment.LimitChatHandler.jdField_a_of_type_Int);
    }
    if ((paramInt == 0) && (paramMatchInfo != null))
    {
      LimitChatUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramMatchInfo, paramString1, this.jdField_b_of_type_Int, 10000, this.jdField_a_of_type_Int);
      d();
      if (paramMatchInfo == null) {}
      for (paramString1 = "";; paramString1 = paramMatchInfo.jdField_b_of_type_JavaLangString)
      {
        ReportController.b(null, "dc00898", "", paramString1, "0X80096A6", "0X80096A6", this.jdField_a_of_type_Int, 0, "", "", "", "");
        paramString1 = new HashMap();
        paramString1.put("duration", String.valueOf((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L));
        paramString1.put("to_uid", paramMatchInfo.jdField_b_of_type_JavaLangString);
        paramString1.put("match_type", "1");
        paramString1.put("dating_purpose", String.valueOf(paramMatchInfo.jdField_b_of_type_Int));
        paramString1.put("choose_condition", String.valueOf(this.jdField_b_of_type_Int + 1));
        ExpandReportUtils.a("success#match_page#match_inline", true, -1L, -1L, paramString1, true, true);
        QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "before finish on success");
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
        QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "after finish on success");
        return;
      }
    }
    paramMatchInfo = new HashMap();
    paramMatchInfo.put("failed_reason", paramString2);
    paramMatchInfo.put("match_type", "1");
    ExpandReportUtils.a("failed#match_page#match_inline", true, -1L, -1L, paramMatchInfo, true, true);
    if (paramInt == 7)
    {
      d();
      paramString1 = (ExtendFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      paramMatchInfo = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString1.g();
        paramMatchInfo = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramMatchInfo = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698772);
        }
      }
      a(paramMatchInfo, false);
      return;
    }
    if (paramInt == 2)
    {
      d();
      paramMatchInfo = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramMatchInfo = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698760);
      }
      a(paramMatchInfo);
      return;
    }
    if (paramInt == 8)
    {
      d();
      paramMatchInfo = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramMatchInfo = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698812);
      }
      a(paramMatchInfo, true);
      return;
    }
    if (paramInt == 9)
    {
      b();
      return;
    }
    if (paramInt == 13)
    {
      d();
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
      {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      }
      f();
      return;
    }
    d();
    paramMatchInfo = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramMatchInfo = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698762);
    }
    a(paramMatchInfo, false);
  }
  
  public void a(MatchingView paramMatchingView, View paramView)
  {
    if ((paramMatchingView == null) || (paramView == null)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramMatchingView, "alpha", new float[] { 0.0F, 1.0F });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.0F });
      paramView = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, paramView });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new ExtendFriendVoiceMatchLoadingFragment.5(this, paramMatchingView));
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
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
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    LiuHaiUtils.a(paramActivity);
  }
  
  public boolean onBackEvent()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    return true;
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
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager = ((ExtendFriendLimitChatManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendVoiceMatchLoadingFragment$LimitChatHandler = new ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler(this);
    paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (paramBundle != null) {
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("intent_sex_key", 0);
    }
    ExtendFriendLimitChatManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanTagInfo = new TagInfo();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanTagInfo.jdField_a_of_type_Int = 10000;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131561247, null));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView = ((MatchingView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371092));
    ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370375)).setOnClickListener(this);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372298);
    if (paramLayoutInflater != null)
    {
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app)) {
        break label152;
      }
      paramLayoutInflater.setVisibility(0);
    }
    for (;;)
    {
      if (LiuHaiUtils.b())
      {
        paramLayoutInflater = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379451);
        paramViewGroup = (RelativeLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
        paramViewGroup.topMargin = LiuHaiUtils.jdField_a_of_type_Int;
        paramLayoutInflater.setLayoutParams(paramViewGroup);
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendVoiceMatchLoadingFragment$LimitChatHandler.sendMessage(this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendVoiceMatchLoadingFragment$LimitChatHandler.obtainMessage(ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler.d));
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      label152:
      paramLayoutInflater.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendVoiceMatchLoadingFragment$LimitChatHandler != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendVoiceMatchLoadingFragment$LimitChatHandler.removeMessages(ExtendFriendLimitChatMatchFragment.LimitChatHandler.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendVoiceMatchLoadingFragment$LimitChatHandler.removeMessages(ExtendFriendLimitChatMatchFragment.LimitChatHandler.jdField_b_of_type_Int);
    }
    ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "qq_kuolie", "0X800AA93", 0, 0, "", "", "语音连麦", "");
  }
  
  public void onPause()
  {
    super.onPause();
    a(false);
  }
  
  public void onResume()
  {
    super.onResume();
    ExpandReportUtils.a("expose#match_page#view", true, -1L, -1L, null, true, true);
    f();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendVoiceMatchLoadingFragment
 * JD-Core Version:    0.7.0.1
 */