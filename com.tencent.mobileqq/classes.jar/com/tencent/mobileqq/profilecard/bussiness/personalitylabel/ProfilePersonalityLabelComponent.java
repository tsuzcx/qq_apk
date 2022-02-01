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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelObserver;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.vas.misc.DiyMoreInfoViewHelper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

public class ProfilePersonalityLabelComponent
  extends AbsProfileContentComponent
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
    Object localObject2 = (ProfilePersonalityLabelInfo)((ProfileCardInfo)this.mData).a(ProfilePersonalityLabelInfo.class);
    boolean bool7 = ProfileActivity.AllInOne.i(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool8 = Utils.b(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    boolean bool2;
    label91:
    boolean bool3;
    label119:
    boolean bool4;
    label165:
    boolean bool5;
    if ((this.mConfigHelper != null) && (!this.mConfigHelper.a(3)))
    {
      bool1 = true;
      if ((paramCard == null) || (localObject2 != null)) {
        break label338;
      }
      bool2 = true;
      if ((paramCard == null) || (localObject2 == null) || (((ProfilePersonalityLabelInfo)localObject2).getSize() != 0) || (((ProfilePersonalityLabelInfo)localObject2).remainCount > 0)) {
        break label344;
      }
      bool3 = true;
      if ((paramCard == null) || (localObject2 == null) || (((ProfilePersonalityLabelInfo)localObject2).getSize() != 0) || (Utils.a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.mApp.getCurrentAccountUin()))) {
        break label350;
      }
      bool4 = true;
      if ((paramCard == null) || (localObject2 == null) || (((ProfilePersonalityLabelInfo)localObject2).isCloseByUser != 1)) {
        break label356;
      }
      bool5 = true;
      label186:
      if ((!bool7) && (!bool8) && (!bool1) && (!bool2) && (!bool3) && (!bool4) && (!bool5)) {
        break label362;
      }
    }
    label338:
    label344:
    label350:
    label356:
    label362:
    for (boolean bool6 = true;; bool6 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfilePersonalityLabelComponent", 2, String.format("makeOrRefreshPersonalityLabel shouldNotShow=%s isStrangerInContact=%s isBabyQ=%s configDisable=%s dataIsNull=%s dataIsEmpty=%s dataIsEmptyForGuest=%s closeByUser=%s", new Object[] { Boolean.valueOf(bool6), Boolean.valueOf(bool7), Boolean.valueOf(bool8), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5) }));
      }
      if ((paramCard != null) && (!bool6)) {
        break label368;
      }
      if (this.mViewContainer == null) {
        break label564;
      }
      this.mViewContainer = null;
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label91;
      bool3 = false;
      break label119;
      bool4 = false;
      break label165;
      bool5 = false;
      break label186;
    }
    label368:
    Object localObject1;
    if (this.mViewContainer == null)
    {
      localObject1 = (ProfileCardFavorShowView)this.mDiyHelper.getDiyView(getProfileContentKey());
      paramCard = (Card)localObject1;
      if (localObject1 == null)
      {
        localObject1 = new PersonalityLabelBoard(this.mActivity, this.mApp, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        paramCard = new ProfileCardFavorShowView(this.mActivity);
        paramCard.setTitle(HardCodeUtil.a(2131708413));
        paramCard.setVisibility(8);
        paramCard.addView((View)localObject1);
      }
      this.mViewContainer = paramCard;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      paramCard = (ProfileCardFavorShowView)this.mViewContainer;
      localObject1 = (PersonalityLabelBoard)paramCard.a(0);
      ((PersonalityLabelBoard)localObject1).setNick(ProfileCardMoreInfoView.a((ProfileCardInfo)this.mData));
      ((PersonalityLabelBoard)localObject1).a((ProfilePersonalityLabelInfo)localObject2, paramBoolean, false);
      ((PersonalityLabelBoard)localObject1).setPersonalityLabelComponent(this);
      localObject2 = new DataTag(86, paramCard.a(0));
      paramCard.b.setTag(localObject2);
      paramCard.b.setOnClickListener(this);
      updatePersonalityLabelTheme(paramCard, (PersonalityLabelBoard)localObject1);
      return bool1;
    }
    label564:
    return false;
  }
  
  private void scrollToPhotoWall()
  {
    if (this.mHandler != null) {
      this.mHandler.postDelayed(new ProfilePersonalityLabelComponent.3(this), 1000L);
    }
  }
  
  private void updatePersonalityLabelTheme(ProfileCardFavorShowView paramProfileCardFavorShowView, PersonalityLabelBoard paramPersonalityLabelBoard)
  {
    updateItemTheme(paramProfileCardFavorShowView.jdField_a_of_type_AndroidWidgetTextView, null, paramProfileCardFavorShowView.jdField_a_of_type_AndroidWidgetImageView);
    int i = -16777216;
    for (;;)
    {
      try
      {
        localObject = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
        if ((localObject != null) && (((ProfileCardTemplate)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (((ProfileCardTemplate)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
        {
          localObject = ((ProfileCardTemplate)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("commonItemContentColor");
          if (localObject == null) {
            break label386;
          }
          if ((localObject instanceof ColorStateList)) {
            localObject = (ColorStateList)localObject;
          }
        }
      }
      catch (Exception localException1)
      {
        boolean bool2;
        localObject = null;
        QLog.e("ProfilePersonalityLabelComponent", 1, "updatePersonalityLabelTheme fail.", localException1);
        continue;
        int j = 0;
        continue;
        int k = 0;
        continue;
        boolean bool1 = false;
        continue;
        paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setBackgroundResource(2130839577);
        continue;
        paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTextColor(i);
        continue;
        paramPersonalityLabelBoard.setTextColors(ColorStateList.valueOf(i));
        return;
      }
      try
      {
        if (paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView == null) {
          break label379;
        }
        j = paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.a();
        i = j;
      }
      catch (Exception localException2)
      {
        continue;
        label379:
        i = -16777216;
        continue;
      }
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_Long != ProfileCardTemplate.jdField_a_of_type_Long)
      {
        j = 1;
        if (j != 0) {
          paramProfileCardFavorShowView.setClickable(true);
        }
        bool2 = ThemeUtil.isInNightMode(this.mApp);
        if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null) {
          continue;
        }
        k = 1;
        if ((bool2) || (k != 0)) {
          continue;
        }
        bool1 = true;
        paramPersonalityLabelBoard.setIsNormalTheme(bool1);
        if (paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView != null)
        {
          if (j == 0) {
            continue;
          }
          paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setBackgroundDrawable(null);
          if (localObject == null) {
            continue;
          }
          paramPersonalityLabelBoard.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTextColor((ColorStateList)localObject);
        }
        if ((bool2) && (j != 0)) {
          updateItemTheme(paramPersonalityLabelBoard.jdField_a_of_type_AndroidWidgetTextView, paramPersonalityLabelBoard.jdField_a_of_type_AndroidWidgetButton, null);
        }
        if (localObject == null) {
          continue;
        }
        paramPersonalityLabelBoard.setTextColors((ColorStateList)localObject);
        return;
        if (!(localObject instanceof String)) {
          break label386;
        }
        localObject = (String)localObject;
        if (!((String)localObject).startsWith("#")) {
          break label386;
        }
        Color.parseColor((String)localObject);
        localObject = null;
        continue;
        localObject = this.mActivity.getResources().getColorStateList(2131167033);
      }
      label386:
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
      paramIntent = (ProfilePersonalityLabelInfo)((ProfileCardInfo)this.mData).a(ProfilePersonalityLabelInfo.class);
      if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (paramIntent != null) && (paramIntent.unreadCount > 0))
      {
        paramIntent.unreadCount = 0;
        if (this.mViewContainer != null) {
          ((PersonalityLabelBoard)((ProfileCardFavorShowView)this.mViewContainer).a(0)).a(paramIntent, false, false);
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
  
  public void onCreate(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    this.mApp.addObserver(this.mPersonalityLabelObserver);
    initModifyDetailReceiver();
    paramBaseActivity = this.mActivity.getIntent();
    if (paramBaseActivity != null) {
      this.mScrollToPersonalityLabel = paramBaseActivity.getBooleanExtra("profile_scroll_to_personality_label", false);
    }
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool1 = super.onDataUpdate(paramProfileCardInfo);
    boolean bool2 = makeOrRefreshPersonalityLabel(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard, ((ProfileCardInfo)this.mData).d);
    if ((this.mScrollToPersonalityLabel) && (!this.mHasScrollToPersonalityLabel))
    {
      this.mHasScrollToPersonalityLabel = true;
      scrollToPhotoWall();
    }
    return bool2 | bool1;
  }
  
  public void onDestroy()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
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
      ((PersonalityLabelBoard)((ProfileCardFavorShowView)this.mViewContainer).a(0)).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent
 * JD-Core Version:    0.7.0.1
 */