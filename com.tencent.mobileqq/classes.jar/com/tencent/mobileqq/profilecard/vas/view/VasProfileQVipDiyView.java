package com.tencent.mobileqq.profilecard.vas.view;

import android.app.Activity;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipDiyTemplateConfig;
import com.tencent.mobileqq.config.business.qvip.QVipDiyTemplateProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vip.diy.ETTextViewPlus;
import com.tencent.mobileqq.vip.diy.QVipProfileJsonInflaterFactory;
import com.tencent.mobileqq.vip.diy.TemplateLikeView;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.jsoninflate.JsonInflater;
import cooperation.vip.jsoninflate.model.ViewModel;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class VasProfileQVipDiyView
  extends AbsProfileHeaderView
{
  public static final int SPACE_TIP_HEIGHT = 18;
  public static final String TAG = "DIYProfileTemplate.ProfileQVipDiyView";
  private View mAvatarContainer;
  private View.OnClickListener mClickHandler = new VasProfileQVipDiyView.2(this);
  private FrameLayout mHeaderContainer;
  private ViewModel mHeaderViewModel;
  private int mNickNameColor = -16777216;
  private View mNickNameView;
  private ViewGroup mRoot;
  ViewGroup mTipLayout;
  private int mTitleStyle;
  private HeartLayout mVoteHeartLayout;
  private View mVoteView;
  
  public VasProfileQVipDiyView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.mNewVoteAnimHelper = new NewVoteAnimHelper(paramBaseActivity, this.mApp, 3, 1);
  }
  
  private void attachDiyProfileTemplateTipForGuest(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if (!QVipDiyTemplateProcessor.c().a) {}
    while (!ProfileCardUtil.a(this.mApp, this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin)) {
      return;
    }
    ProfileCardUtil.a(this.mApp, this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
    this.mTipLayout = ((RelativeLayout)LayoutInflater.from(paramActivity).inflate(2131562180, paramViewGroup, false));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(350.0F, paramActivity.getResources()), AIOUtils.a(44.0F, paramActivity.getResources()));
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(2, 2131373517);
    localLayoutParams.bottomMargin = AIOUtils.a(4.0F, paramActivity.getResources());
    paramViewGroup.addView(this.mTipLayout, localLayoutParams);
    paramActivity = (TextView)this.mTipLayout.findViewById(2131375413);
    paramViewGroup = (ImageView)this.mTipLayout.findViewById(2131375412);
    paramActivity.setOnClickListener(this.mClickHandler);
    paramViewGroup.setOnClickListener(this.mClickHandler);
    ReportController.b(this.mApp, "dc00898", "", "", "qvip", "0X8009E7A", 0, 0, "", "", "", "");
  }
  
  private void detachDIYProfileTip(ViewGroup paramViewGroup)
  {
    if (this.mTipLayout != null)
    {
      paramViewGroup.removeView(this.mTipLayout);
      this.mTipLayout = null;
    }
  }
  
  private void initHeadUI()
  {
    SLog.e("DIYProfileTemplate.ProfileQVipDiyView", "init head UI");
    this.mAvatarContainer = ((View)this.mHeaderChildMap.get("map_key_profile_diy_nick_container"));
    Object localObject;
    if ((this.mAvatarContainer instanceof FrameLayout))
    {
      AvatarLayout localAvatarLayout = (AvatarLayout)this.mAvatarContainer.findViewById(2131369058);
      localAvatarLayout.setVisibility(0);
      DataTag localDataTag = new DataTag(1, null);
      if (this.mCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        localObject = this.mActivity.getString(2131691276);
        localAvatarLayout.setTag(localDataTag);
        localAvatarLayout.setOnClickListener(this.mOnClickListener);
        localAvatarLayout.setContentDescription((CharSequence)localObject);
        localAvatarLayout.a(0, localAvatarLayout.findViewById(2131363511), false);
        this.mHeaderChildMap.put("map_key_face", localAvatarLayout);
        this.mHeaderChildMap.put("map_key_face_stoke", this.mAvatarContainer.findViewById(2131369060));
        localObject = (ImageView)this.mAvatarContainer.findViewById(2131368891);
        this.mHeaderChildMap.put("map_key_avatar_pendant", localObject);
        ((ImageView)localObject).setVisibility(8);
        ((ImageView)localObject).setTag(localDataTag);
        ((ImageView)localObject).setOnClickListener(this.mOnClickListener);
      }
    }
    else
    {
      this.mNickNameView = ((View)this.mHeaderChildMap.get("map_key_profile_nick_name"));
      if (!(this.mNickNameView instanceof ProfileNameView)) {
        break label332;
      }
      localObject = (ProfileNameView)this.mNickNameView;
      ((ProfileNameView)localObject).setVisibility(0);
      ((ProfileNameView)localObject).setClickable(true);
    }
    for (;;)
    {
      this.mVoteView = ((View)this.mHeaderChildMap.get("map_key_like"));
      if (!(this.mVoteView instanceof TemplateLikeView)) {
        break label378;
      }
      localObject = (TemplateLikeView)this.mVoteView;
      this.mVoteHeartLayout.setVisibility(0);
      this.mHeaderChildMap.put("map_key_like", this.mVoteView);
      ((TemplateLikeView)localObject).setHeartLayout(this.mApp, this.mVoteHeartLayout);
      this.mVoteHeartLayout.setEnabled(false);
      return;
      localObject = this.mActivity.getString(2131691275);
      break;
      label332:
      if ((this.mNickNameView instanceof ETTextViewPlus))
      {
        localObject = (ETTextViewPlus)this.mNickNameView;
        ((ETTextViewPlus)localObject).setTextSize(20.0F);
        ((ETTextViewPlus)localObject).setTextColor(this.mNickNameColor);
        ((ETTextViewPlus)localObject).setVisibility(0);
        ((ETTextViewPlus)localObject).setClickable(true);
      }
    }
    label378:
    this.mVoteHeartLayout.setVisibility(8);
  }
  
  private void updateSticker(ExtensionInfo paramExtensionInfo)
  {
    View localView = (View)this.mHeaderChildMap.get("map_key_profile_diy_avatar_sticker");
    if (localView == null) {
      return;
    }
    if ((paramExtensionInfo != null) && (paramExtensionInfo.isPendantValid()))
    {
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(0);
  }
  
  public int getHorizontalMargin()
  {
    return UIUtils.a(getContext(), 23.0F);
  }
  
  @NonNull
  public int getTitleBarColorResource()
  {
    if (this.mTitleStyle == 0) {
      return 2131166726;
    }
    return 2131166582;
  }
  
  public void initDiyTemplate()
  {
    VasDiyData localVasDiyData = this.mCardInfo.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasDiyData;
    this.mTitleStyle = localVasDiyData.getTitleStyle();
    Object localObject = localVasDiyData.getHeaderJson();
    if ((localObject instanceof JSONObject)) {
      this.mHeaderViewModel = JsonInflater.a(this.mActivity).a((JSONObject)localObject, this.mHeaderContainer, true, new QVipProfileJsonInflaterFactory(this.mHeaderChildMap, localVasDiyData.getUrlPrefix()));
    }
    for (;;)
    {
      initHeadUI();
      onUpdate(this.mCardInfo, false);
      if (!this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin.equals(this.mApp.getCurrentAccountUin())) {
        attachDiyProfileTemplateTipForGuest(this.mActivity, this.mRoot);
      }
      return;
      if ((localObject instanceof JSONArray)) {
        this.mHeaderViewModel = JsonInflater.a(this.mActivity).a((JSONArray)localObject, this.mHeaderContainer, true, new QVipProfileJsonInflaterFactory(this.mHeaderChildMap, localVasDiyData.getUrlPrefix()));
      } else {
        AssertUtils.a("header is illegal", new Object[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.e("DIYProfileTemplate.ProfileQVipDiyView", 1, "profileQvipDiyView destroy");
    if (this.mHeaderViewModel != null) {
      this.mHeaderViewModel.c();
    }
    detachDIYProfileTip(this.mRoot);
  }
  
  public void onInit(ProfileCardInfo paramProfileCardInfo)
  {
    this.mNickNameColor = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasDiyData.getMainColor();
    this.mHeaderContainer = new FrameLayout(this.mActivity);
    int i = getResources().getDimensionPixelSize(2131297098);
    int j = ProfileCardUtil.a(getResources());
    j = (int)this.mScreenHeight - ProfileCardUtil.b(this.mActivity, 18) - i - j;
    i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = j + ImmersiveUtils.getStatusBarHeight(getContext());
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
    addView(this.mHeaderContainer, localLayoutParams);
    this.mVoteHeartLayout = new HeartLayout(this.mActivity);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
    addView(this.mVoteHeartLayout, localLayoutParams);
    this.mVoteHeartLayout.setVisibility(8);
    super.onInit(paramProfileCardInfo);
  }
  
  public void onPause()
  {
    super.onPause();
    this.mHeaderViewModel.e();
  }
  
  public void onResume()
  {
    super.onResume();
    this.mHeaderViewModel.f();
  }
  
  public void onUpdate(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    SLog.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update isNetRet=" + paramBoolean);
    if ((this.mNickNameView == null) || (this.mAvatarContainer == null)) {
      initHeadUI();
    }
    if (this.mAvatarContainer != null)
    {
      SLog.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 头像");
      updateAvatar(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      updateAvatarPendantImage(paramProfileCardInfo, false);
    }
    if (this.mNickNameView != null)
    {
      SLog.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 昵称");
      updateHead(paramProfileCardInfo);
    }
    if (this.mVoteView != null)
    {
      SLog.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 点赞");
      updateLike(paramProfileCardInfo);
    }
  }
  
  public void setProfileArgs(ViewGroup paramViewGroup)
  {
    this.mRoot = paramViewGroup;
  }
  
  public void updateAvatarPendantImage(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    Object localObject = (View)this.mHeaderChildMap.get("map_key_avatar_pendant");
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (!ProfileActivity.AllInOne.g(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        ((ImageView)localObject).setVisibility(4);
        this.mPendantId = 0L;
      }
    }
    else
    {
      return;
    }
    ThreadManager.post(new VasProfileQVipDiyView.1(this, paramProfileCardInfo, (ImageView)localObject, paramBoolean), 8, null, true);
  }
  
  public void updateHead(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = (View)this.mHeaderChildMap.get("map_key_profile_nick_name");
    Object localObject2;
    ProfileActivity.AllInOne localAllInOne;
    if ((localObject1 instanceof ProfileNameView))
    {
      localObject1 = (ProfileNameView)localObject1;
      if (localObject1 != null) {
        ((ProfileNameView)localObject1).a(this.mApp, paramProfileCardInfo);
      }
      if ((((ProfileNameView)localObject1).a() != null) && (((ProfileNameView)localObject1).a().getVisibility() == 0))
      {
        localObject2 = ((ProfileNameView)localObject1).a();
        localAllInOne = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
        localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString;
        if (localObject1 != null)
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject1;
          if (((String)localObject1).length() != 0) {}
        }
        else
        {
          if (!ProfileActivity.AllInOne.a(localAllInOne)) {
            break label212;
          }
        }
      }
      label212:
      for (paramProfileCardInfo = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);; paramProfileCardInfo = " ")
      {
        ((ETTextView)localObject2).setText(paramProfileCardInfo);
        ((ETTextView)localObject2).setTextSize(16.0F);
        localObject1 = this.mActivity.getString(2131691252) + ":";
        ((ETTextView)localObject2).setContentDescription((String)localObject1 + paramProfileCardInfo);
        ((ETTextView)localObject2).setTag(new DataTag(88, ((ETTextView)localObject2).getText().toString()));
        ((ETTextView)localObject2).setOnClickListener(this.mOnClickListener);
        ((ETTextView)localObject2).requestLayout();
        LongClickCopyAction.attachCopyAction((TextView)localObject2);
        return;
      }
    }
    if ((localObject1 instanceof ETTextView))
    {
      localObject2 = (ETTextView)localObject1;
      localAllInOne = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
      localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString;
      if (localObject1 != null)
      {
        paramProfileCardInfo = (ProfileCardInfo)localObject1;
        if (((String)localObject1).length() != 0) {}
      }
      else
      {
        if (!ProfileActivity.AllInOne.a(localAllInOne)) {
          break label382;
        }
      }
      label382:
      for (paramProfileCardInfo = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);; paramProfileCardInfo = " ")
      {
        ((ETTextView)localObject2).setText(paramProfileCardInfo);
        ((ETTextView)localObject2).setTextSize(16.0F);
        localObject1 = this.mActivity.getString(2131691252) + ":";
        ((ETTextView)localObject2).setContentDescription((String)localObject1 + paramProfileCardInfo);
        ((ETTextView)localObject2).setTag(new DataTag(88, ((ETTextView)localObject2).getText().toString()));
        ((ETTextView)localObject2).setOnClickListener(this.mOnClickListener);
        ((ETTextView)localObject2).requestLayout();
        LongClickCopyAction.attachCopyAction((TextView)localObject2);
        return;
      }
    }
    super.updateHead(paramProfileCardInfo);
  }
  
  public void updateLike(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((paramProfileCardInfo.b) && (((TroopManager)localObject).n(paramProfileCardInfo.jdField_a_of_type_JavaLangString))) {}
    do
    {
      return;
      localObject = (View)this.mHeaderChildMap.get("map_key_like");
    } while (!(localObject instanceof VoteViewV2));
    VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject;
    boolean bool1 = isShowZan(paramProfileCardInfo);
    boolean bool2 = TextUtils.equals(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.mApp.getCurrentAccountUin());
    if (bool1)
    {
      localVoteViewV2.setVisibility(0);
      int j;
      int i;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)
      {
        paramProfileCardInfo = this.mActivity.getString(2131691323);
        localObject = null;
        j = 0;
        bool1 = false;
        i = 0;
      }
      for (;;)
      {
        localVoteViewV2.a(bool2, bool1, i, j, this.mNewVoteAnimHelper, false);
        localVoteViewV2.setTag(localObject);
        localVoteViewV2.setOnClickListener(this.mOnClickListener);
        localVoteViewV2.setContentDescription(paramProfileCardInfo);
        return;
        if (this.mNewVoteAnimHelper == null) {
          this.mNewVoteAnimHelper = new NewVoteAnimHelper(this.mActivity, this.mApp, 1, 1);
        }
        i = (int)paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
        j = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
        if (1 == paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
        for (bool1 = true;; bool1 = false)
        {
          this.mNewVoteAnimHelper.a = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
          if (j <= this.mNewVoteAnimHelper.a.size()) {
            this.mNewVoteAnimHelper.a = this.mNewVoteAnimHelper.a.subList(0, j);
          }
          this.mNewVoteAnimHelper.a = PraiseConfigHelper.a(this.mNewVoteAnimHelper.a);
          if (!bool2) {
            break label350;
          }
          localObject = new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
          paramProfileCardInfo = String.format(this.mActivity.getString(2131691321), new Object[] { String.valueOf(i) });
          break;
        }
        label350:
        localObject = new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
        String str = String.format(this.mActivity.getString(2131691234), new Object[] { String.valueOf(i) });
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
          localVoteViewV2.a();
        }
        paramProfileCardInfo = str;
      }
    }
    localVoteViewV2.setVisibility(4);
  }
  
  public void updateLiked(ProfileCardInfo paramProfileCardInfo, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.mHeaderChildMap.get("map_key_like");
    if ((localObject instanceof VoteViewV2))
    {
      localObject = (VoteViewV2)localObject;
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteViewV2)localObject).e;
      }
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteViewV2)localObject).a();
      }
      ((VoteViewV2)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteViewV2)localObject).setContentDescription(String.format(this.mActivity.getString(2131691246), new Object[] { String.valueOf(l) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView
 * JD-Core Version:    0.7.0.1
 */