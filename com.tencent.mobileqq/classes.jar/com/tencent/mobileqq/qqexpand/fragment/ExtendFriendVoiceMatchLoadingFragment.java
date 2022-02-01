package com.tencent.mobileqq.qqexpand.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.bean.match.TagInfo;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager.LimitChatMatchListener;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.MatchingView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import java.util.HashMap;
import java.util.Map;

public class ExtendFriendVoiceMatchLoadingFragment
  extends PublicBaseFragment
  implements View.OnClickListener, ExtendFriendLimitChatManager.LimitChatMatchListener
{
  private final int jdField_a_of_type_Int = 2;
  private long jdField_a_of_type_Long;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TagInfo jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchTagInfo;
  private ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendVoiceMatchLoadingFragment$LimitChatHandler;
  private ExtendFriendLimitChatManager jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendLimitChatManager;
  private MatchingView jdField_a_of_type_ComTencentMobileqqQqexpandWidgetMatchingView;
  protected QQCustomDialog a;
  private int b;
  
  public ExtendFriendVoiceMatchLoadingFragment()
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  private void a()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchTagInfo);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68F", "0X800A68F", 3, this.jdField_b_of_type_Int, "", "", "", "");
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", String.valueOf(3));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_tab#match_btn", true, -1L, -1L, localHashMap, true, true);
  }
  
  private void a(TagInfo paramTagInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendLimitChatManager.a() == 2)
    {
      QLog.i("ExtendFriendVoiceMatchLoadingFragment", 2, "startMatching IN STATE_MATCHING return");
      return;
    }
    if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext()))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698837), false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendLimitChatManager.a(2);
    int i = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendLimitChatManager.a();
    if (i == 0)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendLimitChatManager.a(paramTagInfo);
      paramTagInfo = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendVoiceMatchLoadingFragment$LimitChatHandler;
      if (paramTagInfo != null) {
        paramTagInfo.sendEmptyMessageDelayed(ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler.jdField_a_of_type_Int, 35000L);
      }
      c();
      return;
    }
    paramTagInfo = new StringBuilder();
    paramTagInfo.append("startMatching IN STATE_MATCHING return : ");
    paramTagInfo.append(i);
    QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, paramTagInfo.toString());
  }
  
  private void a(String paramString)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a((Context)localObject, 230).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698835), new ExtendFriendVoiceMatchLoadingFragment.3(this)).setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698834), new ExtendFriendVoiceMatchLoadingFragment.2(this));
      }
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
    }
    catch (Throwable paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("match fail dialog error:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localObject != null) && (!((BaseActivity)localObject).isFinishing()))
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230);
      if (localQQCustomDialog != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698830);
        if (paramBoolean)
        {
          localObject = localQQCustomDialog.getMessageTextView();
          if (localObject != null) {
            ((TextView)localObject).setGravity(17);
          }
          localQQCustomDialog.setTitle(2131698889);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698829);
        }
        localQQCustomDialog.setMessage(paramString);
        localQQCustomDialog.setPositiveButton((String)localObject, new ExtendFriendVoiceMatchLoadingFragment.4(this));
        try
        {
          localQQCustomDialog.show();
        }
        catch (Throwable paramString)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("match handleFailAndQuitDialog error:");
          ((StringBuilder)localObject).append(paramString);
          QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, ((StringBuilder)localObject).toString());
        }
      }
      paramString = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
      if (paramString != null)
      {
        paramString.cancel();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      }
      f();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler localLimitChatHandler = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendVoiceMatchLoadingFragment$LimitChatHandler;
    if (localLimitChatHandler != null) {
      localLimitChatHandler.removeMessages(ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler.jdField_a_of_type_Int);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendLimitChatManager.a();
    d();
    if (i == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendLimitChatManager.c();
      if (paramBoolean) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698836));
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceMatchLoadingFragment", 2, "handleOutOfMatchCountResult");
    }
    d();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localObject1 != null) && (!((BaseActivity)localObject1).isFinishing()))
    {
      localObject1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230);
      if (localObject1 != null)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698829);
        ((QQCustomDialog)localObject1).setMessage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698871));
        ((QQCustomDialog)localObject1).setPositiveButton((String)localObject2, new ExtendFriendVoiceMatchLoadingFragment.1(this));
        try
        {
          ((QQCustomDialog)localObject1).show();
        }
        catch (Throwable localThrowable)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("match handleOutOfMatchCountResult error:");
          ((StringBuilder)localObject2).append(localThrowable);
          QLog.e("ExtendFriendVoiceMatchLoadingFragment", 1, ((StringBuilder)localObject2).toString());
        }
      }
      AnimatorSet localAnimatorSet = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
      if (localAnimatorSet != null)
      {
        localAnimatorSet.cancel();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      }
      f();
      return;
    }
    QLog.d("ExtendFriendVoiceMatchLoadingFragment", 1, "handleOutOfMatchCountResult return");
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetMatchingView;
    if (localObject != null) {
      ((MatchingView)localObject).a("# 语音连麦");
    }
    localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(1912930339);
    a(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetMatchingView, (View)localObject);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetMatchingView.b();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetMatchingView.a();
  }
  
  private void f() {}
  
  public void a(int paramInt, MatchInfo paramMatchInfo, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onMatchResult result");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendVoiceMatchLoadingFragment$LimitChatHandler;
    if (localObject != null) {
      ((ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler)localObject).removeMessages(ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler.jdField_a_of_type_Int);
    }
    if ((paramInt == 0) && (paramMatchInfo != null))
    {
      LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramMatchInfo, paramString1, this.jdField_b_of_type_Int, 10000, 2);
      d();
      if (paramMatchInfo == null) {
        paramString1 = "";
      } else {
        paramString1 = paramMatchInfo.jdField_b_of_type_JavaLangString;
      }
      ReportController.b(null, "dc00898", "", paramString1, "0X80096A6", "0X80096A6", 2, 0, "", "", "", "");
      paramString1 = new HashMap();
      paramString1.put("duration", String.valueOf((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L));
      paramString1.put("to_uid", paramMatchInfo.jdField_b_of_type_JavaLangString);
      paramString1.put("match_type", "1");
      paramString1.put("source_id", String.valueOf(paramMatchInfo.jdField_b_of_type_Int));
      paramString1.put("choose_condition", String.valueOf(this.jdField_b_of_type_Int + 1));
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("success#match_page#match_inline", true, -1L, -1L, paramString1, true, true);
      QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "before finish on success");
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "after finish on success");
      return;
    }
    paramMatchInfo = new HashMap();
    paramMatchInfo.put("failed_reason", paramString2);
    paramMatchInfo.put("match_type", "1");
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("failed#match_page#match_inline", true, -1L, -1L, paramMatchInfo, true, true);
    if (paramInt == 7)
    {
      d();
      paramMatchInfo = (IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramMatchInfo.h();
        paramMatchInfo = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramMatchInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698848);
        }
      }
      else
      {
        paramMatchInfo = paramString2;
      }
      a(paramMatchInfo, false);
      return;
    }
    if (paramInt == 2)
    {
      d();
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698836);
      }
      a(paramString2);
      return;
    }
    if (paramInt == 8)
    {
      d();
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698888);
      }
      a(paramString2, true);
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
      paramMatchInfo = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
      if (paramMatchInfo != null)
      {
        paramMatchInfo.cancel();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      }
      f();
      return;
    }
    d();
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698838);
    }
    a(paramString2, false);
  }
  
  public void a(MatchingView paramMatchingView, View paramView)
  {
    if (paramMatchingView != null)
    {
      if (paramView == null) {
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 1912930333) {
      return;
    }
    onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.w("ExtendFriendVoiceMatchLoadingFragment", 1, "can't find app!!");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendLimitChatManager = ((ExtendFriendLimitChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendLimitChatManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendVoiceMatchLoadingFragment$LimitChatHandler = new ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler(this);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if (paramBundle != null) {
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("intent_sex_key", 0);
    }
    ExtendFriendLimitChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchTagInfo = new TagInfo();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchTagInfo.jdField_a_of_type_Int = 10000;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(1912995847, null));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetMatchingView = ((MatchingView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(1912930343));
    ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(1912930333)).setOnClickListener(this);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(1912930344);
    if (paramLayoutInflater != null) {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        paramLayoutInflater.setVisibility(0);
      } else {
        paramLayoutInflater.setVisibility(8);
      }
    }
    if (LiuHaiUtils.b())
    {
      paramLayoutInflater = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(1912930366);
      paramViewGroup = (RelativeLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
      paramViewGroup.topMargin = LiuHaiUtils.jdField_a_of_type_Int;
      paramLayoutInflater.setLayoutParams(paramViewGroup);
    }
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendVoiceMatchLoadingFragment$LimitChatHandler;
    paramLayoutInflater.sendMessage(paramLayoutInflater.obtainMessage(ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler.d));
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler localLimitChatHandler = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendVoiceMatchLoadingFragment$LimitChatHandler;
    if (localLimitChatHandler != null)
    {
      localLimitChatHandler.removeMessages(ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendVoiceMatchLoadingFragment$LimitChatHandler.removeMessages(ExtendFriendVoiceMatchLoadingFragment.LimitChatHandler.jdField_b_of_type_Int);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_kuolie", "0X800AA93", 0, 0, "", "", "语音连麦", "");
  }
  
  public void onPause()
  {
    super.onPause();
    a(false);
  }
  
  public void onResume()
  {
    super.onResume();
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#match_page#view", true, -1L, -1L, null, true, true);
    f();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendVoiceMatchLoadingFragment
 * JD-Core Version:    0.7.0.1
 */