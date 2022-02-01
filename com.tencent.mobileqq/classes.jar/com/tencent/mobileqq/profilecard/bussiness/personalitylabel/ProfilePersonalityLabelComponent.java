package com.tencent.mobileqq.profilecard.bussiness.personalitylabel;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelObserver;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.utils.ProfileNameUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

public class ProfilePersonalityLabelComponent
  extends AbsQQProfileContentComponent
  implements View.OnClickListener
{
  private static final String TAG = "ProfilePersonalityLabelComponent";
  private Handler mHandler;
  private boolean mHasScrollToPersonalityLabel;
  private BroadcastReceiver mModifyDetailReceiver;
  private PersonalityLabelObserver mPersonalityLabelObserver = new ProfilePersonalityLabelComponent.1(this);
  private boolean mScrollToPersonalityLabel;
  
  public ProfilePersonalityLabelComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void destroyModifyDetailReceiver()
  {
    if (this.mModifyDetailReceiver != null)
    {
      this.mActivity.unregisterReceiver(this.mModifyDetailReceiver);
      this.mModifyDetailReceiver = null;
    }
  }
  
  private void initModifyDetailReceiver()
  {
    if (this.mModifyDetailReceiver == null)
    {
      this.mModifyDetailReceiver = new ProfilePersonalityLabelComponent.2(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.card.modify_personality_label");
      localIntentFilter.setPriority(2147483647);
      this.mActivity.registerReceiver(this.mModifyDetailReceiver, localIntentFilter);
    }
  }
  
  private boolean makeOrRefreshPersonalityLabel(Card paramCard, boolean paramBoolean)
  {
    if (this.mApp == null) {
      return false;
    }
    Object localObject1 = (ProfilePersonalityLabelInfo)((ProfileCardInfo)this.mData).getBusinessInfo(ProfilePersonalityLabelInfo.class);
    boolean bool8 = ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo)this.mData).allInOne);
    boolean bool9 = Utils.b(((ProfileCardInfo)this.mData).allInOne.uin);
    Object localObject2 = this.mConfigHelper;
    boolean bool7 = true;
    boolean bool1;
    if ((localObject2 != null) && (!this.mConfigHelper.isSwitchEnable(3))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((paramCard != null) && (localObject1 == null)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if ((paramCard != null) && (localObject1 != null) && (((ProfilePersonalityLabelInfo)localObject1).getSize() == 0) && (((ProfilePersonalityLabelInfo)localObject1).remainCount <= 0)) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool4;
    if ((paramCard != null) && (localObject1 != null) && (((ProfilePersonalityLabelInfo)localObject1).getSize() == 0) && (!Utils.a(((ProfileCardInfo)this.mData).allInOne.uin, this.mApp.getCurrentAccountUin()))) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    boolean bool5;
    if ((paramCard != null) && (localObject1 != null) && (((ProfilePersonalityLabelInfo)localObject1).isCloseByUser == 1)) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    boolean bool6;
    if ((!bool8) && (!bool9) && (!bool1) && (!bool2) && (!bool3) && (!bool4) && (!bool5)) {
      bool6 = false;
    } else {
      bool6 = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfilePersonalityLabelComponent", 2, String.format("makeOrRefreshPersonalityLabel shouldNotShow=%s isStrangerInContact=%s isBabyQ=%s configDisable=%s dataIsNull=%s dataIsEmpty=%s dataIsEmptyForGuest=%s closeByUser=%s", new Object[] { Boolean.valueOf(bool6), Boolean.valueOf(bool8), Boolean.valueOf(bool9), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5) }));
    }
    if ((paramCard != null) && (!bool6))
    {
      if (this.mViewContainer == null)
      {
        paramCard = new PersonalityLabelBoard(this.mActivity, this.mQQAppInterface, ((ProfileCardInfo)this.mData).allInOne.uin);
        localObject2 = new ProfileContentTitleView(this.mActivity);
        ((ProfileContentTitleView)localObject2).setTitle(HardCodeUtil.a(2131708419));
        ((ProfileContentTitleView)localObject2).addContentView(paramCard);
        this.mViewContainer = localObject2;
        bool1 = bool7;
      }
      else
      {
        bool1 = false;
      }
      paramCard = (ProfileContentTitleView)this.mViewContainer;
      localObject2 = (PersonalityLabelBoard)paramCard.getContentView();
      ((PersonalityLabelBoard)localObject2).setNick(ProfileNameUtils.getCurCardName((ProfileCardInfo)this.mData));
      ((PersonalityLabelBoard)localObject2).a((ProfilePersonalityLabelInfo)localObject1, paramBoolean, false);
      ((PersonalityLabelBoard)localObject2).setPersonalityLabelComponent(this);
      localObject1 = new DataTag(86, paramCard.getContentView());
      paramCard.mTitleContainer.setTag(localObject1);
      paramCard.mTitleContainer.setOnClickListener(this);
      updatePersonalityLabelTheme(paramCard, (PersonalityLabelBoard)localObject2);
      return bool1;
    }
    if (this.mViewContainer != null)
    {
      this.mViewContainer = null;
      return true;
    }
    return false;
  }
  
  private void scrollToPhotoWall()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.postDelayed(new ProfilePersonalityLabelComponent.3(this), 1000L);
    }
  }
  
  private void updatePersonalityLabelTheme(ProfileContentTitleView paramProfileContentTitleView, PersonalityLabelBoard paramPersonalityLabelBoard)
  {
    boolean bool1 = true;
    updateItemTheme(paramProfileContentTitleView, true);
    int i = -16777216;
    for (;;)
    {
      try
      {
        localObject = ((ProfileCardInfo)this.mData).currentTemplate;
        if ((localObject != null) && (((ProfileCardTemplate)localObject).templateAttr != null) && (((ProfileCardTemplate)localObject).templateAttr.size() > 0))
        {
          localObject = ((ProfileCardTemplate)localObject).templateAttr.get("commonItemContentColor");
          if (localObject == null) {
            break label376;
          }
          if ((localObject instanceof ColorStateList))
          {
            localObject = (ColorStateList)localObject;
          }
          else
          {
            if (!(localObject instanceof String)) {
              break label376;
            }
            localObject = (String)localObject;
            if (!((String)localObject).startsWith("#")) {
              break label376;
            }
            Color.parseColor((String)localObject);
            break label376;
          }
        }
        else
        {
          localObject = this.mActivity.getResources().getColorStateList(2131167056);
        }
        try
        {
          if (paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView != null) {
            i = paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.a();
          }
        }
        catch (Exception localException1) {}
        QLog.e("ProfilePersonalityLabelComponent", 1, "updatePersonalityLabelTheme fail.", localException2);
      }
      catch (Exception localException2)
      {
        localObject = null;
      }
      i = -16777216;
      int j;
      if (((ProfileCardInfo)this.mData).curUseStyleId != ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        paramProfileContentTitleView.setClickable(true);
      }
      boolean bool2 = ThemeUtil.isInNightMode(this.mApp);
      int k;
      if (((ProfileCardInfo)this.mData).currentTemplate != null) {
        k = 1;
      } else {
        k = 0;
      }
      if ((bool2) || (k != 0)) {
        bool1 = false;
      }
      paramPersonalityLabelBoard.setIsNormalTheme(bool1);
      if (paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView != null)
      {
        if (j != 0) {
          paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setBackgroundDrawable(null);
        } else {
          paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setBackgroundResource(2130839435);
        }
        if (localObject != null) {
          paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTextColor((ColorStateList)localObject);
        } else {
          paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTextColor(i);
        }
      }
      if ((bool2) && (j != 0)) {
        updateItemTheme(null, paramPersonalityLabelBoard.jdField_a_of_type_AndroidWidgetTextView, paramPersonalityLabelBoard.jdField_a_of_type_AndroidWidgetButton, null, null, null, paramProfileContentTitleView.mContentContainer);
      }
      if (localObject != null)
      {
        paramPersonalityLabelBoard.setTextColors((ColorStateList)localObject);
        return;
      }
      paramPersonalityLabelBoard.setTextColors(ColorStateList.valueOf(i));
      return;
      label376:
      Object localObject = null;
    }
  }
  
  public String getComponentName()
  {
    return "ProfilePersonalityLabelComponent";
  }
  
  public int getComponentType()
  {
    return 1010;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_personality_label";
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1029)
    {
      paramIntent = (ProfilePersonalityLabelInfo)((ProfileCardInfo)this.mData).getBusinessInfo(ProfilePersonalityLabelInfo.class);
      if ((((ProfileCardInfo)this.mData).allInOne.pa == 0) && (paramIntent != null) && (paramIntent.unreadCount > 0))
      {
        paramIntent.unreadCount = 0;
        if (this.mViewContainer != null) {
          ((PersonalityLabelBoard)((ProfileContentTitleView)this.mViewContainer).getContentView()).a(paramIntent, false, false);
        }
      }
      if (paramInt2 == -1) {
        ((PersonalityLabelHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).a(this.mApp.getCurrentAccountUin(), 0);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof DataTag))
    {
      DataTag localDataTag = (DataTag)paramView.getTag();
      if ((localDataTag.jdField_a_of_type_Int == 86) && ((localDataTag.jdField_a_of_type_JavaLangObject instanceof PersonalityLabelBoard))) {
        ((PersonalityLabelBoard)localDataTag.jdField_a_of_type_JavaLangObject).a(false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    this.mApp.addObserver(this.mPersonalityLabelObserver);
    initModifyDetailReceiver();
    paramQBaseActivity = this.mActivity.getIntent();
    if (paramQBaseActivity != null) {
      this.mScrollToPersonalityLabel = paramQBaseActivity.getBooleanExtra("profile_scroll_to_personality_label", false);
    }
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool1 = super.onDataUpdate(paramProfileCardInfo);
    boolean bool2 = makeOrRefreshPersonalityLabel(((ProfileCardInfo)this.mData).card, ((ProfileCardInfo)this.mData).isNetRet);
    if ((this.mScrollToPersonalityLabel) && (!this.mHasScrollToPersonalityLabel))
    {
      this.mHasScrollToPersonalityLabel = true;
      scrollToPhotoWall();
    }
    return bool1 | bool2;
  }
  
  public void onDestroy()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    this.mApp.removeObserver(this.mPersonalityLabelObserver);
    destroyModifyDetailReceiver();
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mViewContainer != null) {
      ((PersonalityLabelBoard)((ProfileContentTitleView)this.mViewContainer).getContentView()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent
 * JD-Core Version:    0.7.0.1
 */