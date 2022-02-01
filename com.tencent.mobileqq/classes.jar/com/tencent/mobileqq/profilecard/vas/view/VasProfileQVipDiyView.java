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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.config.business.qvip.QVipDiyTemplateConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipDiyTemplateProcessor;
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
  
  public VasProfileQVipDiyView(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramQBaseActivity, paramProfileCardInfo);
    this.mNewVoteAnimHelper = new NewVoteAnimHelper(paramQBaseActivity, this.mApp, 3, 1);
  }
  
  private void attachDiyProfileTemplateTipForGuest(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if (!QVipDiyTemplateProcessor.c().a) {
      return;
    }
    if (!ProfileCardUtil.a(this.mApp, this.mCardInfo.card.uin)) {
      return;
    }
    ProfileCardUtil.a(this.mApp, this.mCardInfo.card.uin);
    this.mTipLayout = ((RelativeLayout)LayoutInflater.from(paramActivity).inflate(2131562017, paramViewGroup, false));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(350.0F, paramActivity.getResources()), AIOUtils.b(44.0F, paramActivity.getResources()));
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(2, 2131373096);
    localLayoutParams.bottomMargin = AIOUtils.b(4.0F, paramActivity.getResources());
    paramViewGroup.addView(this.mTipLayout, localLayoutParams);
    paramActivity = (TextView)this.mTipLayout.findViewById(2131374931);
    paramViewGroup = (ImageView)this.mTipLayout.findViewById(2131374930);
    paramActivity.setOnClickListener(this.mClickHandler);
    paramViewGroup.setOnClickListener(this.mClickHandler);
    ReportController.b(this.mApp, "dc00898", "", "", "qvip", "0X8009E7A", 0, 0, "", "", "", "");
  }
  
  private void detachDIYProfileTip(ViewGroup paramViewGroup)
  {
    ViewGroup localViewGroup = this.mTipLayout;
    if (localViewGroup != null)
    {
      paramViewGroup.removeView(localViewGroup);
      this.mTipLayout = null;
    }
  }
  
  private void initHeadUI()
  {
    SLog.e("DIYProfileTemplate.ProfileQVipDiyView", "init head UI");
    this.mAvatarContainer = ((View)this.mHeaderChildMap.get("map_key_profile_diy_nick_container"));
    Object localObject = this.mAvatarContainer;
    if ((localObject instanceof FrameLayout))
    {
      AvatarLayout localAvatarLayout = (AvatarLayout)((View)localObject).findViewById(2131368780);
      localAvatarLayout.setVisibility(0);
      DataTag localDataTag = new DataTag(1, null);
      if (this.mCardInfo.allInOne.pa == 0) {
        localObject = this.mActivity.getString(2131691197);
      } else {
        localObject = this.mActivity.getString(2131691196);
      }
      localAvatarLayout.setTag(localDataTag);
      localAvatarLayout.setOnClickListener(this.mOnClickListener);
      localAvatarLayout.setContentDescription((CharSequence)localObject);
      localAvatarLayout.a(0, localAvatarLayout.findViewById(2131363438), false);
      this.mHeaderChildMap.put("map_key_face", localAvatarLayout);
      this.mHeaderChildMap.put("map_key_face_stoke", this.mAvatarContainer.findViewById(2131368782));
      localObject = (ImageView)this.mAvatarContainer.findViewById(2131368617);
      this.mHeaderChildMap.put("map_key_avatar_pendant", localObject);
      ((ImageView)localObject).setVisibility(8);
      ((ImageView)localObject).setTag(localDataTag);
      ((ImageView)localObject).setOnClickListener(this.mOnClickListener);
    }
    this.mNickNameView = ((View)this.mHeaderChildMap.get("map_key_profile_nick_name"));
    localObject = this.mNickNameView;
    if ((localObject instanceof ProfileNameView))
    {
      localObject = (ProfileNameView)localObject;
      ((ProfileNameView)localObject).setVisibility(0);
      ((ProfileNameView)localObject).setClickable(true);
    }
    else if ((localObject instanceof ETTextViewPlus))
    {
      localObject = (ETTextViewPlus)localObject;
      ((ETTextViewPlus)localObject).setTextSize(20.0F);
      ((ETTextViewPlus)localObject).setTextColor(this.mNickNameColor);
      ((ETTextViewPlus)localObject).setVisibility(0);
      ((ETTextViewPlus)localObject).setClickable(true);
    }
    this.mVoteView = ((View)this.mHeaderChildMap.get("map_key_like"));
    localObject = this.mVoteView;
    if ((localObject instanceof TemplateLikeView))
    {
      localObject = (TemplateLikeView)localObject;
      this.mVoteHeartLayout.setVisibility(0);
      this.mHeaderChildMap.put("map_key_like", this.mVoteView);
      ((TemplateLikeView)localObject).setHeartLayout(this.mApp, this.mVoteHeartLayout);
      this.mVoteHeartLayout.setEnabled(false);
      return;
    }
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
      return 2131166742;
    }
    return 2131166597;
  }
  
  public void initDiyTemplate()
  {
    VasDiyData localVasDiyData = (VasDiyData)this.mCardInfo.getBusinessInfo(VasDiyData.class);
    this.mTitleStyle = localVasDiyData.getTitleStyle();
    Object localObject = localVasDiyData.getHeaderJson();
    if ((localObject instanceof JSONObject)) {
      this.mHeaderViewModel = JsonInflater.a(this.mActivity).a((JSONObject)localObject, this.mHeaderContainer, true, new QVipProfileJsonInflaterFactory(this.mHeaderChildMap, localVasDiyData.getUrlPrefix()));
    } else if ((localObject instanceof JSONArray)) {
      this.mHeaderViewModel = JsonInflater.a(this.mActivity).a((JSONArray)localObject, this.mHeaderContainer, true, new QVipProfileJsonInflaterFactory(this.mHeaderChildMap, localVasDiyData.getUrlPrefix()));
    } else {
      AssertUtils.fail("header is illegal", new Object[0]);
    }
    initHeadUI();
    onUpdate(this.mCardInfo, false);
    if (!this.mCardInfo.card.uin.equals(this.mApp.getCurrentAccountUin())) {
      attachDiyProfileTemplateTipForGuest(this.mActivity, this.mRoot);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.e("DIYProfileTemplate.ProfileQVipDiyView", 1, "profileQvipDiyView destroy");
    ViewModel localViewModel = this.mHeaderViewModel;
    if (localViewModel != null) {
      localViewModel.c();
    }
    detachDIYProfileTip(this.mRoot);
  }
  
  public void onInit(ProfileCardInfo paramProfileCardInfo)
  {
    this.mNickNameColor = ((VasDiyData)paramProfileCardInfo.getBusinessInfo(VasDiyData.class)).getMainColor();
    this.mHeaderContainer = new FrameLayout(this.mActivity);
    int i = getResources().getDimensionPixelSize(2131297080);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("自定义资料卡update isNetRet=");
    localStringBuilder.append(paramBoolean);
    SLog.d("DIYProfileTemplate.ProfileQVipDiyView", localStringBuilder.toString());
    if ((this.mNickNameView == null) || (this.mAvatarContainer == null)) {
      initHeadUI();
    }
    if (this.mAvatarContainer != null)
    {
      SLog.d("DIYProfileTemplate.ProfileQVipDiyView", "自定义资料卡update 头像");
      updateAvatar(paramProfileCardInfo.allInOne);
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
      if (!ProfilePAUtils.isPaTypeHasUin(paramProfileCardInfo.allInOne))
      {
        ((ImageView)localObject).setVisibility(4);
        this.mPendantId = 0L;
        return;
      }
      ThreadManager.post(new VasProfileQVipDiyView.1(this, paramProfileCardInfo, (ImageView)localObject, paramBoolean), 8, null, true);
    }
  }
  
  public void updateHead(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = (View)this.mHeaderChildMap.get("map_key_profile_nick_name");
    boolean bool = localObject2 instanceof ProfileNameView;
    Object localObject1 = " ";
    Object localObject3;
    if (bool)
    {
      localObject2 = (ProfileNameView)localObject2;
      if (localObject2 != null) {
        ((ProfileNameView)localObject2).a(this.mApp, paramProfileCardInfo);
      }
      if ((((ProfileNameView)localObject2).a() != null) && (((ProfileNameView)localObject2).a().getVisibility() == 0))
      {
        localObject2 = ((ProfileNameView)localObject2).a();
        localObject3 = paramProfileCardInfo.allInOne;
        paramProfileCardInfo = paramProfileCardInfo.profileName.a.a;
        if ((paramProfileCardInfo != null) && (paramProfileCardInfo.length() != 0)) {
          break label130;
        }
        paramProfileCardInfo = (ProfileCardInfo)localObject1;
        if (ProfilePAUtils.isPaTypeShowAccount((AllInOne)localObject3)) {
          paramProfileCardInfo = String.valueOf(((AllInOne)localObject3).uin);
        }
        label130:
        ((ETTextView)localObject2).setText(paramProfileCardInfo);
        ((ETTextView)localObject2).setTextSize(16.0F);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.mActivity.getString(2131691173));
        ((StringBuilder)localObject1).append(":");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(paramProfileCardInfo);
        ((ETTextView)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
        ((ETTextView)localObject2).setTag(new DataTag(88, ((ETTextView)localObject2).getText().toString()));
        ((ETTextView)localObject2).setOnClickListener(this.mOnClickListener);
        ((ETTextView)localObject2).requestLayout();
        LongClickCopyAction.attachCopyAction((TextView)localObject2);
      }
    }
    else
    {
      if ((localObject2 instanceof ETTextView))
      {
        localObject2 = (ETTextView)localObject2;
        localObject3 = paramProfileCardInfo.allInOne;
        paramProfileCardInfo = paramProfileCardInfo.profileName.a.a;
        if ((paramProfileCardInfo != null) && (paramProfileCardInfo.length() != 0)) {
          break label326;
        }
        paramProfileCardInfo = (ProfileCardInfo)localObject1;
        if (ProfilePAUtils.isPaTypeShowAccount((AllInOne)localObject3)) {
          paramProfileCardInfo = String.valueOf(((AllInOne)localObject3).uin);
        }
        label326:
        ((ETTextView)localObject2).setText(paramProfileCardInfo);
        ((ETTextView)localObject2).setTextSize(16.0F);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.mActivity.getString(2131691173));
        ((StringBuilder)localObject1).append(":");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(paramProfileCardInfo);
        ((ETTextView)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
        ((ETTextView)localObject2).setTag(new DataTag(88, ((ETTextView)localObject2).getText().toString()));
        ((ETTextView)localObject2).setOnClickListener(this.mOnClickListener);
        ((ETTextView)localObject2).requestLayout();
        LongClickCopyAction.attachCopyAction((TextView)localObject2);
        return;
      }
      super.updateHead(paramProfileCardInfo);
    }
  }
  
  public void updateLike(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((paramProfileCardInfo.isTroopMemberCard) && (((TroopManager)localObject1).m(paramProfileCardInfo.troopUin))) {
      return;
    }
    localObject1 = (View)this.mHeaderChildMap.get("map_key_like");
    if ((localObject1 instanceof VoteViewV2))
    {
      VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject1;
      boolean bool1 = isShowZan(paramProfileCardInfo);
      boolean bool2 = TextUtils.equals(paramProfileCardInfo.allInOne.uin, this.mApp.getCurrentAccountUin());
      if (bool1)
      {
        localVoteViewV2.setVisibility(0);
        int j;
        int i;
        if (paramProfileCardInfo.card == null)
        {
          paramProfileCardInfo = null;
          localObject1 = this.mActivity.getString(2131691244);
          bool1 = false;
          j = 0;
          i = 0;
        }
        else
        {
          if (this.mNewVoteAnimHelper == null) {
            this.mNewVoteAnimHelper = new NewVoteAnimHelper(this.mActivity, this.mApp, 1, 1);
          }
          j = (int)paramProfileCardInfo.card.lVoteCount;
          i = paramProfileCardInfo.card.iVoteIncrement;
          if (1 == paramProfileCardInfo.card.bVoted) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          this.mNewVoteAnimHelper.a = paramProfileCardInfo.card.getLastPraiseInfoList();
          if (i <= this.mNewVoteAnimHelper.a.size()) {
            this.mNewVoteAnimHelper.a = this.mNewVoteAnimHelper.a.subList(0, i);
          }
          this.mNewVoteAnimHelper.a = PraiseConfigHelper.a(this.mNewVoteAnimHelper.a);
          Object localObject2;
          if (bool2)
          {
            localObject2 = new DataTag(10, paramProfileCardInfo.card);
            localObject1 = String.format(this.mActivity.getString(2131691242), new Object[] { String.valueOf(j) });
          }
          else
          {
            DataTag localDataTag = new DataTag(10, paramProfileCardInfo.card);
            String str = String.format(this.mActivity.getString(2131691155), new Object[] { String.valueOf(j) });
            localObject1 = str;
            localObject2 = localDataTag;
            if (paramProfileCardInfo.card.bAvailVoteCnt == 0)
            {
              localVoteViewV2.a();
              localObject2 = localDataTag;
              localObject1 = str;
            }
          }
          paramProfileCardInfo = (ProfileCardInfo)localObject2;
        }
        localVoteViewV2.a(bool2, bool1, j, i, this.mNewVoteAnimHelper, false);
        localVoteViewV2.setTag(paramProfileCardInfo);
        localVoteViewV2.setOnClickListener(this.mOnClickListener);
        localVoteViewV2.setContentDescription((CharSequence)localObject1);
        return;
      }
      localVoteViewV2.setVisibility(4);
    }
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
      if ((paramProfileCardInfo.card != null) && (paramProfileCardInfo.card.bAvailVoteCnt == 0)) {
        ((VoteViewV2)localObject).a();
      }
      ((VoteViewV2)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteViewV2)localObject).setContentDescription(String.format(this.mActivity.getString(2131691167), new Object[] { String.valueOf(l) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView
 * JD-Core Version:    0.7.0.1
 */