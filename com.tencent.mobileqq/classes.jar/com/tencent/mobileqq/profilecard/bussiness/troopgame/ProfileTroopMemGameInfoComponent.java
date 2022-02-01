package com.tencent.mobileqq.profilecard.bussiness.troopgame;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileGameInfo;
import com.tencent.mobileqq.profile.ProfileGameInfo.UserHeroInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.container.ProfileContentContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils.Companion;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfig;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.TroopGameCardUtil;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.text.NumberFormat;
import java.util.ArrayList;

public class ProfileTroopMemGameInfoComponent
  extends AbsProfileContentComponent
  implements AbsListView.OnScrollListener
{
  private static final String TAG = "ProfileTroopMemGameInfoComponent";
  private boolean gameCardInfoPrepared = false;
  private boolean hasReport = false;
  private Handler mHandler;
  private boolean mHasScrollToTroopMemGame;
  private boolean mInit = false;
  private ProfileGameInfo mProfileGameInfo;
  private boolean mScrollToTroopMemGame;
  protected TroopBusinessObserver mTroopBusinessObserver = new ProfileTroopMemGameInfoComponent.1(this);
  
  public ProfileTroopMemGameInfoComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private boolean checkGrayTroop()
  {
    boolean bool2;
    if ((this.mData == null) || (!((ProfileCardInfo)this.mData).b) || (TextUtils.isEmpty(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString)))
    {
      bool2 = false;
      return bool2;
    }
    TroopGameCardConfig localTroopGameCardConfig = (TroopGameCardConfig)QConfigManager.a().a(695);
    if ((localTroopGameCardConfig != null) && (localTroopGameCardConfig.a(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ProfileTroopMemGameInfoComponent", 2, "checkGrayTroop. isGrayTroop = " + bool1);
      return bool1;
    }
  }
  
  private boolean checkIsHwTroop()
  {
    if (this.mApp == null) {
      return false;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).b(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString);
    return (localTroopInfo != null) && (localTroopInfo.isHomeworkTroop());
  }
  
  private boolean checkTroopGameCardSwitch()
  {
    if (!checkGrayTroop()) {
      return false;
    }
    if (StudyModeManager.a()) {
      return false;
    }
    if (this.mApp == null) {
      return false;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).b(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString);
    if (localTroopInfo == null) {
      return false;
    }
    return localTroopInfo.isTroopGameCardEnabled();
  }
  
  private boolean checkTroopMemberGameCardSwitch()
  {
    if (!checkGrayTroop()) {
      return false;
    }
    if (this.mApp == null) {
      return false;
    }
    TroopMemberInfo localTroopMemberInfo = ((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).a(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if (localTroopMemberInfo == null) {
      return false;
    }
    return (localTroopMemberInfo.cmduinFlagEx3Grocery & 1L) == 0L;
  }
  
  private void layoutAvatarListView()
  {
    int i;
    ArrayList localArrayList;
    Object localObject1;
    Object localObject2;
    int j;
    if (this.mProfileGameInfo.bestHeroList == null)
    {
      i = 0;
      localArrayList = new ArrayList(3);
      localObject1 = (URLImageView)((View)this.mViewContainer).findViewById(2131377347);
      localObject2 = (URLImageView)((View)this.mViewContainer).findViewById(2131377348);
      Object localObject3 = (URLImageView)((View)this.mViewContainer).findViewById(2131377349);
      localArrayList.add(localObject1);
      localArrayList.add(localObject2);
      localArrayList.add(localObject3);
      localObject1 = new ArrayList(3);
      localObject2 = (ImageView)((View)this.mViewContainer).findViewById(2131377350);
      localObject3 = (ImageView)((View)this.mViewContainer).findViewById(2131377351);
      ImageView localImageView = (ImageView)((View)this.mViewContainer).findViewById(2131377352);
      ((ArrayList)localObject1).add(localObject2);
      ((ArrayList)localObject1).add(localObject3);
      ((ArrayList)localObject1).add(localImageView);
      j = 0;
      label184:
      if (j >= 3) {
        return;
      }
      if (j < i) {
        break label243;
      }
      ((URLImageView)localArrayList.get(j)).setVisibility(8);
      ((ImageView)((ArrayList)localObject1).get(j)).setVisibility(8);
    }
    for (;;)
    {
      j += 1;
      break label184;
      i = this.mProfileGameInfo.bestHeroList.size();
      break;
      label243:
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ViewUtils.b(20.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ViewUtils.b(20.0F);
      localObject2 = URLDrawable.getDrawable(((ProfileGameInfo.UserHeroInfo)this.mProfileGameInfo.bestHeroList.get(j)).heroIcon, (URLDrawable.URLDrawableOptions)localObject2);
      if (localObject2 != null)
      {
        int k = ViewUtils.b(20.0F);
        ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.a(k, k));
        ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.p);
        ((URLImageView)localArrayList.get(j)).setImageDrawable((Drawable)localObject2);
      }
      ((URLImageView)localArrayList.get(j)).setVisibility(0);
      localObject2 = TroopGameCardUtil.a(TroopGameCardUtil.g(((ProfileGameInfo.UserHeroInfo)this.mProfileGameInfo.bestHeroList.get(j)).skilledLevel));
      if (localObject2 != null)
      {
        ((ImageView)((ArrayList)localObject1).get(j)).setImageBitmap((Bitmap)localObject2);
        ((ImageView)((ArrayList)localObject1).get(j)).setVisibility(0);
      }
    }
  }
  
  private void layoutCardViewBg(boolean paramBoolean)
  {
    ImageView localImageView = (ImageView)((View)this.mViewContainer).findViewById(2131367704);
    Bitmap localBitmap = TroopGameCardUtil.a(TroopGameCardUtil.a(paramBoolean));
    if (localBitmap != null) {
      localImageView.setImageBitmap(localBitmap);
    }
  }
  
  private void layoutGameInfoTextView(int paramInt, boolean paramBoolean)
  {
    TextView localTextView1 = (TextView)((View)this.mViewContainer).findViewById(2131379730);
    localTextView1.setText(String.valueOf(this.mProfileGameInfo.gamesTotal));
    TextView localTextView2 = (TextView)((View)this.mViewContainer).findViewById(2131372077);
    localTextView2.setText(String.valueOf(this.mProfileGameInfo.mvpTotal));
    TextView localTextView3 = (TextView)((View)this.mViewContainer).findViewById(2131381952);
    try
    {
      Object localObject1 = NumberFormat.getPercentInstance();
      ((NumberFormat)localObject1).setMaximumFractionDigits(2);
      localTextView3.setText(((NumberFormat)localObject1).format(this.mProfileGameInfo.seasonWinRate));
      localObject1 = (TextView)((View)this.mViewContainer).findViewById(2131367978);
      Object localObject2 = TroopGameCardUtil.h(this.mProfileGameInfo.bestOccupation);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
      if (paramBoolean)
      {
        localTextView1.setTextColor(-1);
        localTextView2.setTextColor(-1);
        localTextView3.setTextColor(-1);
        ((TextView)localObject1).setTextColor(-1);
        localTextView1 = (TextView)((View)this.mViewContainer).findViewById(2131379729);
        localTextView2 = (TextView)((View)this.mViewContainer).findViewById(2131372076);
        localTextView3 = (TextView)((View)this.mViewContainer).findViewById(2131381951);
        localObject1 = (TextView)((View)this.mViewContainer).findViewById(2131367977);
        localObject2 = (TextView)((View)this.mViewContainer).findViewById(2131367976);
        localTextView1.setTextColor(Color.parseColor("#98989F"));
        localTextView2.setTextColor(Color.parseColor("#98989F"));
        localTextView3.setTextColor(Color.parseColor("#98989F"));
        ((TextView)localObject1).setTextColor(Color.parseColor("#98989F"));
        ((TextView)localObject2).setTextColor(Color.parseColor("#98989F"));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void layoutGradeIconView(int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt / 100000 >= 8)
    {
      localObject1 = (ImageView)((View)this.mViewContainer).findViewById(2131378405);
      localObject2 = TroopGameCardUtil.a(TroopGameCardUtil.e(paramInt));
      if (localObject2 != null) {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
      localObject1 = (TextView)((View)this.mViewContainer).findViewById(2131378411);
      localObject2 = this.mActivity.getString(2131693376, new Object[] { String.valueOf(paramInt % 10000) });
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
      if (paramBoolean) {
        ((TextView)localObject1).setTextColor(-1);
      }
    }
    for (;;)
    {
      localObject1 = (ImageView)((View)this.mViewContainer).findViewById(2131376462);
      localObject2 = TroopGameCardUtil.a(TroopGameCardUtil.d(paramInt));
      if (localObject2 != null) {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
      localObject1 = (TextView)((View)this.mViewContainer).findViewById(2131376466);
      localObject2 = TroopGameCardUtil.c(paramInt);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
      if (paramBoolean) {
        ((TextView)localObject1).setTextColor(-1);
      }
      return;
      localObject1 = (ImageView)((View)this.mViewContainer).findViewById(2131376465);
      localObject2 = TroopGameCardUtil.a(TroopGameCardUtil.e(paramInt));
      if (localObject2 != null) {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
      localObject1 = (ImageView)((View)this.mViewContainer).findViewById(2131376464);
      localObject2 = TroopGameCardUtil.a(TroopGameCardUtil.f(paramInt));
      if (localObject2 != null) {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
    }
  }
  
  private boolean layoutTitleView(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    TextView localTextView = (TextView)((View)this.mViewContainer).findViewById(2131367737);
    Object localObject = getGenderName(paramProfileCardInfo);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      localObject = HardCodeUtil.a(2131708464);
    }
    localTextView.setText(String.format("%s%s", new Object[] { localObject, this.mActivity.getString(2131693417) }));
    updateItemTheme((View)this.mViewContainer, localTextView, null, null);
    paramProfileCardInfo = (TextView)((View)this.mViewContainer).findViewById(2131367705);
    localObject = ((View)this.mViewContainer).findViewById(2131367721);
    if (paramBoolean) {
      paramProfileCardInfo.setTextColor(Color.parseColor("#98989F"));
    }
    if ((this.mProfileGameInfo == null) || (this.mProfileGameInfo.isEmpty()))
    {
      ((View)localObject).setVisibility(8);
      return true;
    }
    paramProfileCardInfo.setText(2131693350);
    ((View)localObject).setVisibility(0);
    return false;
  }
  
  private boolean makeOrRefreshEntry(ProfileCardInfo paramProfileCardInfo)
  {
    if (!this.mInit)
    {
      initNetRequest();
      return false;
    }
    boolean bool2 = false | makeOrRefreshGameCardInfoView((ProfileCardInfo)this.mData);
    boolean bool1;
    if ((this.mViewContainer != null) && (((View)this.mViewContainer).getVisibility() == 0))
    {
      bool1 = true;
      if (bool2)
      {
        if (!((ProfileCardInfo)this.mData).b) {
          break label188;
        }
        TroopReportor.a("Grp_mber", "mber_card", "game_switch", 0, 0, new String[] { ((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString });
        label97:
        if (this.mDelegate != null) {
          this.mDelegate.notifyCardUpdate();
        }
      }
      if (bool1) {
        break label200;
      }
      if (this.mViewContainer != null) {
        break label195;
      }
      bool1 = true;
      label126:
      if (this.mViewContainer != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemGameInfoComponent", 2, new Object[] { "bShow = false. mViewContainer removeAllViews. mViewContainer=%s", this.mViewContainer });
        }
        ((ViewGroup)this.mViewContainer).removeAllViews();
      }
      this.mViewContainer = null;
      bool2 |= bool1;
    }
    label188:
    label195:
    label200:
    for (;;)
    {
      return bool2;
      bool1 = false;
      break;
      reportGameCard();
      break label97;
      bool1 = false;
      break label126;
    }
  }
  
  private boolean makeOrRefreshGameCardInfoView(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    boolean bool2;
    if ((this.mActivity == null) || (!this.gameCardInfoPrepared) || (paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!shouldShowGameCard()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemGameInfoComponent", 2, "makeOrRefreshGameCardInfoView. Not showing game info. gameCardInfoPrepared = " + this.gameCardInfoPrepared + ", init = " + this.mInit);
      }
      if (this.mViewContainer != null) {
        bool1 = true;
      }
      if (this.mViewContainer != null) {
        ((View)this.mViewContainer).setVisibility(8);
      }
      bool2 = bool1;
      return bool2;
    }
    if (this.mViewContainer == null) {
      this.mViewContainer = this.mActivity.getLayoutInflater().inflate(2131561723, null);
    }
    for (bool1 = true;; bool1 = false)
    {
      if ((this.mApp != null) && (ThemeUtil.isInNightMode(this.mApp))) {}
      for (;;)
      {
        bool2 = bool1;
        if (layoutTitleView(paramProfileCardInfo, bool3)) {
          break;
        }
        int i = this.mProfileGameInfo.mGrade;
        layoutCardViewBg(bool3);
        layoutGradeIconView(i, bool3);
        layoutGameInfoTextView(i, bool3);
        layoutAvatarListView();
        ((View)this.mViewContainer).setVisibility(0);
        return bool1;
        bool3 = false;
      }
    }
  }
  
  private boolean personalGameCardSwitchEnabled()
  {
    boolean bool2 = true;
    if ((this.mData == null) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.mApp == null))
    {
      bool1 = false;
      return bool1;
    }
    boolean bool4 = StudyModeManager.a();
    boolean bool3 = this.mConfigHelper.a(14);
    if (ProfileSettingUtils.a.a(42505, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard, this.mApp) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemGameInfoComponent", 2, "personalGameCardSwitchEnabled. wzGameCardSwitchEnable = " + bool1 + ", wzGameCardConfigEnable = " + bool3);
      }
      if ((!bool4) && (bool1))
      {
        bool1 = bool2;
        if (bool3) {
          break;
        }
      }
      return false;
    }
  }
  
  private void reportGameCard()
  {
    if ((this.mData != null) && (!((ProfileCardInfo)this.mData).b) && (ProfileCardMoreInfoView.a((View)this.mViewContainer)) && (!this.hasReport))
    {
      ReportController.b(this.mApp, "dc00898", "", "", "0X800B5EF", "0X800B5EF", 0, 0, "0", "0", "", "");
      this.hasReport = true;
    }
  }
  
  private void requestGameCardInfo(String paramString1, String paramString2)
  {
    boolean bool;
    if ((!NetworkUtil.g(this.mActivity)) || (this.mApp == null)) {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder().append("requestGameCardInfo.isNetworkAvailable = false, mApp is null: ");
        if (this.mApp != null) {
          break label61;
        }
        bool = true;
        QLog.d("ProfileTroopMemGameInfoComponent", 2, bool);
      }
    }
    label61:
    TroopHandler localTroopHandler;
    do
    {
      return;
      bool = false;
      break;
      localTroopHandler = (TroopHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    } while (localTroopHandler == null);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemGameInfoComponent", 2, "requestGameCardInfo.getTroopMemberGameCard");
    }
    localTroopHandler.f(String.valueOf(paramString1), String.valueOf(paramString2));
  }
  
  private void scrollToTroopMemGame()
  {
    if (this.mHandler != null) {
      this.mHandler.postDelayed(new ProfileTroopMemGameInfoComponent.3(this), 1000L);
    }
  }
  
  private boolean shouldShowGameCard()
  {
    boolean bool1 = false;
    if (this.mData == null) {}
    boolean bool2;
    do
    {
      do
      {
        do
        {
          return bool1;
        } while (StudyModeManager.a());
        if (!((ProfileCardInfo)this.mData).b) {
          break;
        }
        bool2 = shouldShowTroopMemberGameCard();
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("ProfileTroopMemGameInfoComponent", 2, "shouldShowGameCard. shouldShowTroopMemberGameCard = " + bool2);
      return bool2;
      bool2 = personalGameCardSwitchEnabled();
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("ProfileTroopMemGameInfoComponent", 2, "shouldShowGameCard. personalGameCardSwitchEnabled = " + bool2);
    return bool2;
  }
  
  private boolean shouldShowTroopMemberGameCard()
  {
    if ((this.mData == null) || (!((ProfileCardInfo)this.mData).b)) {
      return false;
    }
    if (checkIsHwTroop()) {
      return false;
    }
    if (checkTroopGameCardSwitch()) {
      return checkTroopMemberGameCardSwitch();
    }
    return personalGameCardSwitchEnabled();
  }
  
  private void updateData()
  {
    ProfileContentContainer localProfileContentContainer = (ProfileContentContainer)this.mComponentCenter.getComponent(103);
    if (localProfileContentContainer != null) {
      localProfileContentContainer.onDataUpdate((ProfileCardInfo)this.mData);
    }
    if ((this.mScrollToTroopMemGame) && (!this.mHasScrollToTroopMemGame))
    {
      this.mHasScrollToTroopMemGame = true;
      scrollToTroopMemGame();
    }
  }
  
  public void checkAndUpdateTroopInfo(TroopInfo paramTroopInfo)
  {
    ProfileActivity.AllInOne localAllInOne = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    if ((localAllInOne != null) && (paramTroopInfo != null) && (ProfileActivity.f(localAllInOne.jdField_a_of_type_Int)) && (TextUtils.isEmpty(localAllInOne.d)))
    {
      localAllInOne.d = paramTroopInfo.troopcode;
      localAllInOne.c = paramTroopInfo.troopuin;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileTroopMemGameInfoComponent", 2, String.format("checkAndUpdateTroopInfo troop[%s, %s]", new Object[] { paramTroopInfo.troopuin, paramTroopInfo.troopcode }));
      }
    }
  }
  
  public String getComponentName()
  {
    return "ProfileTroopMemGameInfoComponent";
  }
  
  public int getComponentType()
  {
    return 1028;
  }
  
  public String getGenderName(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject;
    if (this.mActivity == null) {
      localObject = "他";
    }
    do
    {
      String str;
      do
      {
        return localObject;
        str = this.mActivity.getString(2131699475);
        localObject = str;
      } while (paramProfileCardInfo == null);
      localObject = str;
    } while (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.shGender == 1) {
      return this.mActivity.getString(2131699474);
    }
    return this.mActivity.getString(2131699475);
  }
  
  public String getProfileContentKey()
  {
    return "map_key_troop_mem_game_info";
  }
  
  public void initNetRequest()
  {
    if (this.mInit) {}
    do
    {
      return;
      if ((this.mData != null) && (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ProfileTroopMemGameInfoComponent", 2, "initNetRequest.mData is not ready");
    return;
    if (!StudyModeManager.a()) {
      if (checkTroopGameCardSwitch())
      {
        if (QLog.isColorLevel()) {
          QLog.e("ProfileTroopMemGameInfoComponent", 2, "initNetRequest.checkTroopGameCardSwitch = true");
        }
        if (!checkIsHwTroop()) {
          requestTroopMemberInfo();
        }
      }
    }
    for (;;)
    {
      this.mInit = true;
      return;
      boolean bool = personalGameCardSwitchEnabled();
      if (bool) {
        requestGameCardInfo("0", ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileTroopMemGameInfoComponent", 2, "initNetRequest.personalSwitch = " + bool);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemGameInfoComponent", 2, "initNetRequest.studyMode = true");
        }
      }
    }
  }
  
  public void onCreate(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    if ((this.mActivity == null) || (this.mApp == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemGameInfoComponent", 2, "onCreate: mActivity == null || mApp == null");
      }
      return;
    }
    this.mActivity.addObserver(this.mTroopBusinessObserver);
    checkAndUpdateTroopInfo(((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).b(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString));
    this.gameCardInfoPrepared = false;
    this.hasReport = false;
    if (this.mDelegate != null) {
      this.mDelegate.addProfileScrollListener(this);
    }
    paramBaseActivity = this.mActivity.getIntent();
    if (paramBaseActivity != null) {
      this.mScrollToTroopMemGame = paramBaseActivity.getBooleanExtra("profile_scroll_to_wangzhe", false);
    }
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshEntry((ProfileCardInfo)this.mData) | bool;
  }
  
  public void onDestroy()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    if (this.mActivity != null) {
      this.mActivity.removeObserver(this.mTroopBusinessObserver);
    }
    if (this.mDelegate != null) {
      this.mDelegate.removeProfileScrollListener(this);
    }
    super.onDestroy();
  }
  
  public void onResume()
  {
    this.hasReport = false;
    reportGameCard();
    super.onResume();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (ProfileCardMoreInfoView.a((View)this.mViewContainer))) {
      ((View)this.mViewContainer).post(new ProfileTroopMemGameInfoComponent.2(this));
    }
  }
  
  public void requestTroopMemberInfo()
  {
    if (!NetworkUtil.g(this.mActivity)) {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemGameInfoComponent", 2, "requestTroopMemberInfo.isNetworkAvailable = false");
      }
    }
    do
    {
      do
      {
        return;
        if (this.mApp != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProfileTroopMemGameInfoComponent", 2, "requestTroopMemberInfo mApp is null");
      return;
      Object localObject = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
      TroopHandler localTroopHandler = (TroopHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      localObject = ((TroopManager)localObject).b(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString);
      checkAndUpdateTroopInfo((TroopInfo)localObject);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemGameInfoComponent", 2, "requestTroopMemberInfo.getMemberGameCardSwitch");
        }
        localTroopHandler.b(((ProfileCardInfo)this.mData).jdField_a_of_type_JavaLangString, Long.parseLong(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ProfileTroopMemGameInfoComponent", 2, "requestTroopMemberInfo.getTroopMemberCardInfo troopInfo null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troopgame.ProfileTroopMemGameInfoComponent
 * JD-Core Version:    0.7.0.1
 */