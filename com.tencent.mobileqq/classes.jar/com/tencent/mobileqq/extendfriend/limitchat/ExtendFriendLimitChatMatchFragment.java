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
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExpandDTParamBuilder;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.extendfriend.bean.TagInfo;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendApolloGuideDialogFragment;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.wiget.CompletePersonalDataDialog;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedBannerView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSignalBombDialog;
import com.tencent.mobileqq.extendfriend.wiget.HeadsPanelAnimationView;
import com.tencent.mobileqq.extendfriend.wiget.MatchingView;
import com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew.onTagClickListner;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.matchchat.MatchFilterContentView;
import com.tencent.mobileqq.matchchat.MatchFilterContentView.CloseListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class ExtendFriendLimitChatMatchFragment
  extends PublicBaseFragment
  implements View.OnClickListener, ExtendFriendLimitChatManager.LimitChatMatchListener, HorseRaceLampVew.onTagClickListner, MatchFilterContentView.CloseListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new ExtendFriendLimitChatMatchFragment.2(this);
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ExtendFriendLimitChatMatchFragment.1(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new ExtendFriendLimitChatMatchFragment.3(this);
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  TagInfo jdField_a_of_type_ComTencentMobileqqExtendfriendBeanTagInfo = null;
  private ExtendFriendApolloGuideDialogFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendApolloGuideDialogFragment;
  private ExtendFriendLimitChatManager jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager;
  private ExtendFriendLimitChatMatchFragment.LimitChatHandler jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$LimitChatHandler;
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new ExtendFriendLimitChatMatchFragment.10(this);
  private CompletePersonalDataDialog jdField_a_of_type_ComTencentMobileqqExtendfriendWigetCompletePersonalDataDialog;
  private ExtendFriendFeedBannerView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView;
  protected HeadsPanelAnimationView a;
  private MatchingView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView;
  private SignalBombAnimationView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView;
  private HorseRaceLampVew jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew;
  MatchFilterContentView jdField_a_of_type_ComTencentMobileqqMatchchatMatchFilterContentView = null;
  protected RedTouch a;
  protected QQCustomDialog a;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  
  private void a(int paramInt)
  {
    Object localObject = (ExtendFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if ((this.jdField_a_of_type_Int != 1) && (localObject != null) && (((ExtendFriendManager)localObject).e() == 1))
    {
      localObject = ((ExtendFriendManager)localObject).a();
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        i();
        return;
      }
      j();
      return;
    }
    j();
  }
  
  private void a(View paramView)
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(paramView, "chat_tab");
    VideoReport.setPageParams(paramView, new ExpandDTParamBuilder().a());
    QLog.i("ExtendFriendLimitChatMatchFragment", 1, "reportDaTongRegister");
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app != null)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698759), new ExtendFriendLimitChatMatchFragment.7(this)).setNegativeButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698758), new ExtendFriendLimitChatMatchFragment.6(this));
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
        localQQCustomDialog.setPositiveButton((String)localObject, new ExtendFriendLimitChatMatchFragment.4(this));
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
      m();
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
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$LimitChatHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$LimitChatHandler.removeMessages(ExtendFriendLimitChatMatchFragment.LimitChatHandler.jdField_a_of_type_Int);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.a();
    n();
    if (i == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.c();
      if (paramBoolean) {
        a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698760));
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
        w();
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698794), 1).a();
      }
      if (a()) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
    }
    else
    {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845317);
    return;
    label90:
    if (!paramBoolean2) {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698715), 1).a();
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845314);
    h();
  }
  
  private void b(int paramInt)
  {
    if (b())
    {
      c(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendApolloGuideDialogFragment = ExtendFriendApolloGuideDialogFragment.a(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendApolloGuideDialogFragment.show(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getFragmentManager(), "ExtendFriendApolloGuideDialogFragment");
    }
  }
  
  private void b(View paramView)
  {
    if (paramView != null)
    {
      paramView.setAlpha(1.0F);
      paramView.setScaleX(1.0F);
      paramView.setScaleY(1.0F);
    }
  }
  
  private void b(TagInfo paramTagInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.a() == 2)
    {
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return");
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
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.a(paramTagInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$LimitChatHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$LimitChatHandler.sendEmptyMessageDelayed(ExtendFriendLimitChatMatchFragment.LimitChatHandler.jdField_a_of_type_Int, 35000L);
      }
      c(paramTagInfo);
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "startMatching IN STATE_MATCHING return : " + i);
  }
  
  private void b(boolean paramBoolean)
  {
    ReportController.b(null, "dc00898", "", "", "0X800AE9C", "0X800AE9C", 0, 0, "", "", "", "");
    ExtendFriendHandler localExtendFriendHandler = (ExtendFriendHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localExtendFriendHandler != null) {
      localExtendFriendHandler.a();
    }
    a(false, paramBoolean);
  }
  
  private boolean b()
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    while (((Build.VERSION.SDK_INT >= 17) && (getActivity().isDestroyed())) || ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendApolloGuideDialogFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendApolloGuideDialogFragment.getDialog() != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendApolloGuideDialogFragment.getDialog().isShowing())) || (!isVisible()) || (!isResumed()) || (!SignalBombHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app)) || (this.jdField_b_of_type_Int == -1) || (!this.jdField_a_of_type_Boolean) || (SharedPreUtils.E(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApplication(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin()) != 0)) {
      return false;
    }
    return true;
  }
  
  private void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B442", "0X800B442", 1, 0, "", "", "", "");
      return;
    case 4: 
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B442", "0X800B442", 3, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B442", "0X800B442", 2, 0, "", "", "", "");
  }
  
  private void c(TagInfo paramTagInfo)
  {
    String str = "#" + this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698785);
    Object localObject = str;
    if (paramTagInfo != null)
    {
      localObject = str;
      if (!TextUtils.isEmpty(paramTagInfo.jdField_a_of_type_JavaLangString)) {
        localObject = "# " + paramTagInfo.jdField_a_of_type_JavaLangString;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.a((String)localObject);
    }
    paramTagInfo = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365294);
    localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371086);
    a(paramTagInfo, this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView, (View)localObject);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setLineCount(3);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setLineMarginDp(8);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setItemHorMarginDp(20);
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, null, false, "chat_tab");
    int k = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    int m = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297328);
    int n = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297311);
    int i1 = (int)DisplayUtils.a(this.jdField_a_of_type_AndroidViewViewGroup.getContext(), 160.0F);
    int i2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297307);
    int i = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297306);
    int i3 = a();
    int j = i3 - k - m - n - i1 - i2 - i;
    i = j;
    if (j < 0) {
      i = 0;
    }
    QLog.i("ExtendFriendLimitChatMatchFragment", 2, "screentHeight " + i3 + " statusHeight " + k + " titleHeight " + m + " headPanelHeight " + n + " horseHeight " + i1 + " btnHeight " + i2 + "leftHeight " + i);
    float f1 = i;
    float f2 = i;
    float f3 = i;
    float f4 = i;
    Object localObject2 = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371085);
    Object localObject1 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370376);
    if (localObject2 != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
      localLayoutParams.setMargins(0, (int)(f1 * 0.17F), 0, 0);
      ((RelativeLayout)localObject2).setLayoutParams(localLayoutParams);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null)
    {
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, (int)(f2 * 0.14F), 0, 0);
      ((RelativeLayout.LayoutParams)localObject2).height = i1;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    if (localObject1 != null)
    {
      localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, (int)(f3 * 0.22F), 0, 0);
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).setMargins(0, (int)(f4 * 0.18F), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setLineCount(4);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setLineMarginDp(21);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setItemHorMarginDp(16);
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView.setVisibility(8);
    int k = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    int m = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297328);
    int n = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297311);
    int i1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297312);
    int i2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimensionPixelSize(2131297307);
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
    Object localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371085);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370376);
    if (localObject != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.setMargins(0, (int)(f1 * 0.21F), 0, 0);
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)(f2 * 0.16F), 0, 0);
      ((RelativeLayout.LayoutParams)localObject).height = i1;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (localTextView != null)
    {
      localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)(f3 * 0.2F), 0, 0);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView).b(53).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.g(25);
    }
    MatchChatMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApplication() == null)) {}
    while (SharedPreUtils.E(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApplication(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin()) != 0) {
      return;
    }
    ((IQQAvatarHandlerService)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getRuntimeService(IQQAvatarHandlerService.class, "")).getApolloHead(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin());
  }
  
  private void m()
  {
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365294)).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.setVisibility(8);
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.b();
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "handleOutOfMatchCountResult");
    }
    n();
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      QLog.d("ExtendFriendLimitChatMatchFragment", 1, "handleOutOfMatchCountResult return");
      return;
    }
    Object localObject = (ExtendFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localObject != null)
    {
      if (!((ExtendFriendManager)localObject).a()) {
        break label189;
      }
      localObject = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (localObject != null)
      {
        String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698754);
        ((QQCustomDialog)localObject).setMessage(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698795));
        ((QQCustomDialog)localObject).setPositiveButton(str, new ExtendFriendLimitChatMatchFragment.8(this));
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
        m();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ExtendFriendLimitChatMatchFragment", 1, "match handleOutOfMatchCountResult error:" + localThrowable);
        continue;
      }
      label189:
      t();
    }
  }
  
  private void p()
  {
    Object localObject = (ExtendFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    int i;
    if (localObject != null)
    {
      i = (int)((ExtendFriendManager)localObject).c();
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(BaseApplication.getContext().getResources().getString(2131698783), new Object[] { Integer.valueOf(i) }));
      localObject = ((ExtendFriendManager)localObject).a();
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
  
  private void q()
  {
    int i = (int)((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
    if ((this.jdField_a_of_type_Long > 0L) && (i > 0))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("duration", i + "");
      localHashMap.put("ext_int1", "2");
      ExpandReportUtils.a("exit#all_page#view", true, -1L, -1L, localHashMap, true, true);
      this.jdField_a_of_type_Long = 0L;
    }
  }
  
  private void r()
  {
    ExtendFriendHandler localExtendFriendHandler = (ExtendFriendHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localExtendFriendHandler != null) {
      localExtendFriendHandler.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentUin());
    }
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "requestLeftMatchCountAndTaskInfo");
    }
    ExtendFriendHandler localExtendFriendHandler = (ExtendFriendHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localExtendFriendHandler != null) {
      localExtendFriendHandler.a(false, false);
    }
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "showCompletePersonalInfoDialog");
    }
    ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localExtendFriendManager != null)
    {
      int k = (int)localExtendFriendManager.a();
      int j = k - (int)localExtendFriendManager.b();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetCompletePersonalDataDialog.a(k, i, localExtendFriendManager.a());
      ReportController.b(null, "dc00898", "", "", "0X800B089", "0X800B089", localExtendFriendManager.b(), 0, "", "", "", "");
    }
  }
  
  private void u()
  {
    SignalBombHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new ExtendFriendLimitChatMatchFragment.11(this), 1);
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!SignalBombHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app)))
    {
      SignalBombHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, true);
      ExtendFriendSignalBombDialog.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new ExtendFriendLimitChatMatchFragment.12(this));
    }
    ExtendFriendManager localExtendFriendManager;
    do
    {
      return;
      if (!SignalBombHelper.a())
      {
        u();
        return;
      }
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app == null))
      {
        QLog.e("ExtendFriendLimitChatMatchFragment", 2, "openSignalBtn mActivity finish");
        return;
      }
      a(true, false);
      localExtendFriendManager = (ExtendFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    } while (localExtendFriendManager == null);
    localExtendFriendManager.c(true);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$LimitChatHandler.sendEmptyMessageDelayed(ExtendFriendLimitChatMatchFragment.LimitChatHandler.c, ExtendFriendLimitChatMatchFragment.LimitChatHandler.d);
    localExtendFriendManager.h();
    ReportController.b(null, "dc00898", "", "", "0X800AE9D", "0X800AE9D", 0, 0, "", "", "", "");
  }
  
  private void w()
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
  
  private void x()
  {
    QLog.d("ExtendFriendLimitChatMatchFragment", 2, "clearSignalPushWait");
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (localExtendFriendManager != null) {
        localExtendFriendManager.c(false);
      }
    }
  }
  
  private void y()
  {
    QLog.d("ExtendFriendLimitChatMatchFragment", 2, "checkNeedPush");
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      SignalBombHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
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
  
  public void a(int paramInt, MatchInfo paramMatchInfo, String paramString1, String paramString2)
  {
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "onMatchResult result" + paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$LimitChatHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$LimitChatHandler.removeMessages(ExtendFriendLimitChatMatchFragment.LimitChatHandler.jdField_a_of_type_Int);
    }
    if ((paramInt == 0) && (paramMatchInfo != null))
    {
      LimitChatUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramMatchInfo, paramString1, ExtendFriendLimitChatManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app), 10000, this.jdField_a_of_type_Int);
      n();
      p();
      if (paramMatchInfo == null) {}
      for (paramMatchInfo = "";; paramMatchInfo = paramMatchInfo.b)
      {
        ReportController.b(null, "dc00898", "", paramMatchInfo, "0X80096A6", "0X80096A6", this.jdField_a_of_type_Int, 0, "", "", "", "");
        return;
      }
    }
    if (paramInt == 7)
    {
      n();
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
      n();
      paramMatchInfo = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramMatchInfo = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698760);
      }
      a(paramMatchInfo);
      return;
    }
    if (paramInt == 8)
    {
      n();
      paramMatchInfo = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramMatchInfo = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698812);
      }
      a(paramMatchInfo, true);
      return;
    }
    if (paramInt == 9)
    {
      o();
      return;
    }
    if (paramInt == 13)
    {
      n();
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
      {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      }
      m();
      return;
    }
    n();
    paramMatchInfo = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramMatchInfo = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698762);
    }
    a(paramMatchInfo, false);
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
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new ExtendFriendLimitChatMatchFragment.5(this, paramMatchingView, paramView1));
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void a(TagInfo paramTagInfo)
  {
    if (paramTagInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanTagInfo = paramTagInfo;
      b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanTagInfo);
      HashMap localHashMap = new HashMap();
      localHashMap.put("label_content", paramTagInfo.jdField_a_of_type_JavaLangString);
      ExpandReportUtils.a("click#chat_tab#chat_label", true, -1L, -1L, localHashMap, true, true);
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
    } while ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView == null) || (!ExtendFriendLimitChatResourceUtil.b()));
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
    ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A696", "0X800A696", 0, 0, "", "", "", "");
    MatchChatMsgListFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMatchchatMatchFilterContentView == null) {
      this.jdField_a_of_type_ComTencentMobileqqMatchchatMatchFilterContentView = new MatchFilterContentView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqMatchchatMatchFilterContentView.a()));
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
      this.jdField_a_of_type_ComTencentMobileqqMatchchatMatchFilterContentView.a();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
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
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 2130772003);
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
      t();
      s();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanTagInfo = null;
      b(null);
      int i = ExtendFriendLimitChatManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      int j = this.jdField_a_of_type_Int + 1;
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A68F", "0X800A68F", j, i, "", "", "", "");
      HashMap localHashMap = new HashMap();
      localHashMap.put("frompage", String.valueOf(j));
      ExpandReportUtils.a("click#chat_tab#match_btn", true, -1L, -1L, localHashMap, true, true);
      continue;
      e();
      continue;
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A68D", "0X800A68D", 0, 0, "", "", "", "");
      ExpandReportUtils.a("click#chat_tab#choice_btn", true, -1L, -1L, null, true, true);
      a(false);
      f();
      continue;
      if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        v();
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
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager = ((ExtendFriendLimitChatManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$LimitChatHandler = new ExtendFriendLimitChatMatchFragment.LimitChatHandler(this);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131561222, null));
    paramLayoutInflater = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379451);
    if (this.jdField_a_of_type_Int == 1)
    {
      paramLayoutInflater.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setClickable(false);
      ((ExtendFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f();
      paramLayoutInflater = (ExtendFriendHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(true, true);
      }
      ExtendFriendManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      paramLayoutInflater = (ExtendFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      }
      ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370375)).setOnClickListener(this);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372298);
      if (paramLayoutInflater != null)
      {
        if ((!ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app)) || (this.jdField_a_of_type_Int != 1)) {
          break label589;
        }
        paramLayoutInflater.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371084));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew = ((HorseRaceLampVew)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368537));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370376));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370377));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew.setTagClickListner(this);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371918));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366974));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378179));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView = ((SignalBombAnimationView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378178));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368322));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView = new HeadsPanelAnimationView(1);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView.a() != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView = ((MatchingView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371092));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView = ((ExtendFriendFeedBannerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366680));
      a(this.jdField_a_of_type_Int);
      r();
      s();
      d();
      k();
      l();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetCompletePersonalDataDialog = new CompletePersonalDataDialog(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      if (this.jdField_a_of_type_Int != 1) {
        a(this.jdField_a_of_type_AndroidViewViewGroup);
      }
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramLayoutInflater.setVisibility(8);
      break;
      label589:
      paramLayoutInflater.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Int == 1) {
      ((ExtendFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).g();
    }
    x();
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView.d();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetSignalBombAnimationView.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$LimitChatHandler != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$LimitChatHandler.removeMessages(ExtendFriendLimitChatMatchFragment.LimitChatHandler.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment$LimitChatHandler.removeMessages(ExtendFriendLimitChatMatchFragment.LimitChatHandler.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMatchchatMatchFilterContentView != null) {
      this.jdField_a_of_type_ComTencentMobileqqMatchchatMatchFilterContentView.c();
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "qq_kuolie", "0X800AA93", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
    if (this.jdField_a_of_type_Int == 1) {
      q();
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    b(this.jdField_b_of_type_Int);
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
    m();
    c();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.jdField_c_of_type_Boolean) {
      a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetCompletePersonalDataDialog.isShowing()) {
      s();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.jdField_a_of_type_Int == 1) && (!this.jdField_b_of_type_Boolean)) {
      this.jdField_b_of_type_Boolean = SignalBombHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment
 * JD-Core Version:    0.7.0.1
 */