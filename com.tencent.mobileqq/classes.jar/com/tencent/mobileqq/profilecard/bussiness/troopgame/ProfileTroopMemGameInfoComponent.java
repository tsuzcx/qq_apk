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
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils.Companion;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfig;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameHandler;
import com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver;
import com.tencent.mobileqq.troop.troopgame.data.ProfileGameInfo;
import com.tencent.mobileqq.troop.troopgame.data.ProfileGameInfo.UserHeroInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.text.NumberFormat;
import java.util.ArrayList;

public class ProfileTroopMemGameInfoComponent
  extends AbsQQProfileContentComponent
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
  protected TroopGameObserver mTroopGameObserver = new ProfileTroopMemGameInfoComponent.1(this);
  
  public ProfileTroopMemGameInfoComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private boolean checkGrayTroop()
  {
    Object localObject = this.mData;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (((ProfileCardInfo)this.mData).isTroopMemberCard)
      {
        if (TextUtils.isEmpty(((ProfileCardInfo)this.mData).troopUin)) {
          return false;
        }
        localObject = (TroopGameCardConfig)QConfigManager.a().a(695);
        bool1 = bool3;
        if (localObject != null)
        {
          bool1 = bool3;
          if (((TroopGameCardConfig)localObject).a(((ProfileCardInfo)this.mData).troopUin)) {
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkGrayTroop. isGrayTroop = ");
          ((StringBuilder)localObject).append(bool1);
          QLog.d("ProfileTroopMemGameInfoComponent", 2, ((StringBuilder)localObject).toString());
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  private boolean checkIsHwTroop()
  {
    if (this.mApp == null) {
      return false;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).b(((ProfileCardInfo)this.mData).troopUin);
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
    TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).b(((ProfileCardInfo)this.mData).troopUin);
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
    TroopMemberInfo localTroopMemberInfo = ((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).a(((ProfileCardInfo)this.mData).troopUin, ((ProfileCardInfo)this.mData).allInOne.uin);
    if (localTroopMemberInfo == null) {
      return false;
    }
    return (localTroopMemberInfo.cmduinFlagEx3Grocery & 1L) == 0L;
  }
  
  private void layoutAvatarListView()
  {
    int i;
    if (this.mProfileGameInfo.bestHeroList == null) {
      i = 0;
    } else {
      i = this.mProfileGameInfo.bestHeroList.size();
    }
    ArrayList localArrayList = new ArrayList(3);
    Object localObject1 = (URLImageView)((View)this.mViewContainer).findViewById(2131376800);
    Object localObject2 = (URLImageView)((View)this.mViewContainer).findViewById(2131376801);
    Object localObject3 = (URLImageView)((View)this.mViewContainer).findViewById(2131376802);
    localArrayList.add(localObject1);
    localArrayList.add(localObject2);
    localArrayList.add(localObject3);
    localObject1 = new ArrayList(3);
    localObject2 = (ImageView)((View)this.mViewContainer).findViewById(2131376803);
    localObject3 = (ImageView)((View)this.mViewContainer).findViewById(2131376804);
    ImageView localImageView = (ImageView)((View)this.mViewContainer).findViewById(2131376805);
    ((ArrayList)localObject1).add(localObject2);
    ((ArrayList)localObject1).add(localObject3);
    ((ArrayList)localObject1).add(localImageView);
    int j = 0;
    while (j < 3)
    {
      if (j >= i)
      {
        ((URLImageView)localArrayList.get(j)).setVisibility(8);
        ((ImageView)((ArrayList)localObject1).get(j)).setVisibility(8);
      }
      else
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ViewUtils.b(20.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ViewUtils.b(20.0F);
        localObject2 = URLDrawable.getDrawable(((ProfileGameInfo.UserHeroInfo)this.mProfileGameInfo.bestHeroList.get(j)).heroIcon, (URLDrawable.URLDrawableOptions)localObject2);
        if (localObject2 != null)
        {
          int k = ViewUtils.b(20.0F);
          ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.a(k, k));
          ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.n);
          ((URLImageView)localArrayList.get(j)).setImageDrawable((Drawable)localObject2);
        }
        ((URLImageView)localArrayList.get(j)).setVisibility(0);
        localObject2 = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getGameSkilledLevelIconPath(((ProfileGameInfo.UserHeroInfo)this.mProfileGameInfo.bestHeroList.get(j)).skilledLevel);
        localObject2 = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap((String)localObject2);
        if (localObject2 != null)
        {
          ((ImageView)((ArrayList)localObject1).get(j)).setImageBitmap((Bitmap)localObject2);
          ((ImageView)((ArrayList)localObject1).get(j)).setVisibility(0);
        }
      }
      j += 1;
    }
  }
  
  private void layoutCardViewBg(boolean paramBoolean)
  {
    ImageView localImageView = (ImageView)((View)this.mViewContainer).findViewById(2131367457);
    Object localObject = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getMemberGameCardBgImagePath(paramBoolean);
    localObject = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap((String)localObject);
    if (localObject != null) {
      localImageView.setImageBitmap((Bitmap)localObject);
    }
  }
  
  private void layoutGameInfoTextView(int paramInt, boolean paramBoolean)
  {
    TextView localTextView1 = (TextView)((View)this.mViewContainer).findViewById(2131379069);
    localTextView1.setText(String.valueOf(this.mProfileGameInfo.gamesTotal));
    TextView localTextView2 = (TextView)((View)this.mViewContainer).findViewById(2131371672);
    localTextView2.setText(String.valueOf(this.mProfileGameInfo.mvpTotal));
    TextView localTextView3 = (TextView)((View)this.mViewContainer).findViewById(2131381155);
    try
    {
      NumberFormat localNumberFormat = NumberFormat.getPercentInstance();
      localNumberFormat.setMaximumFractionDigits(2);
      localTextView3.setText(localNumberFormat.format(this.mProfileGameInfo.seasonWinRate));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    TextView localTextView4 = (TextView)((View)this.mViewContainer).findViewById(2131367734);
    Object localObject = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getOccupationTypeText(this.mProfileGameInfo.bestOccupation);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localTextView4.setText((CharSequence)localObject);
    }
    if (paramBoolean)
    {
      localTextView1.setTextColor(-1);
      localTextView2.setTextColor(-1);
      localTextView3.setTextColor(-1);
      localTextView4.setTextColor(-1);
      localTextView1 = (TextView)((View)this.mViewContainer).findViewById(2131379068);
      localTextView2 = (TextView)((View)this.mViewContainer).findViewById(2131371671);
      localTextView3 = (TextView)((View)this.mViewContainer).findViewById(2131381154);
      localTextView4 = (TextView)((View)this.mViewContainer).findViewById(2131367733);
      localObject = (TextView)((View)this.mViewContainer).findViewById(2131367732);
      localTextView1.setTextColor(Color.parseColor("#98989F"));
      localTextView2.setTextColor(Color.parseColor("#98989F"));
      localTextView3.setTextColor(Color.parseColor("#98989F"));
      localTextView4.setTextColor(Color.parseColor("#98989F"));
      ((TextView)localObject).setTextColor(Color.parseColor("#98989F"));
    }
  }
  
  private void layoutGradeIconView(int paramInt, boolean paramBoolean)
  {
    if (paramInt / 100000 >= 8)
    {
      localObject1 = (ImageView)((View)this.mViewContainer).findViewById(2131377819);
      localObject2 = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getGameGradeStarImagePathById(paramInt);
      localObject2 = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap((String)localObject2);
      if (localObject2 != null) {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
      localObject1 = (TextView)((View)this.mViewContainer).findViewById(2131377825);
      localObject2 = this.mActivity.getString(2131693331, new Object[] { String.valueOf(paramInt % 10000) });
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
      if (paramBoolean) {
        ((TextView)localObject1).setTextColor(-1);
      }
    }
    else
    {
      localObject1 = (ImageView)((View)this.mViewContainer).findViewById(2131375977);
      localObject2 = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getGameGradeStarImagePathById(paramInt);
      localObject2 = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap((String)localObject2);
      if (localObject2 != null) {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
      localObject1 = (ImageView)((View)this.mViewContainer).findViewById(2131375976);
      localObject2 = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getGameGradeNumberIconPathById(paramInt);
      localObject2 = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap((String)localObject2);
      if (localObject2 != null) {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
    }
    Object localObject1 = (ImageView)((View)this.mViewContainer).findViewById(2131375974);
    Object localObject2 = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getGameGradeIconPathById(paramInt);
    localObject2 = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap((String)localObject2);
    if (localObject2 != null) {
      ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
    }
    localObject1 = (TextView)((View)this.mViewContainer).findViewById(2131375978);
    localObject2 = ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getGradeDescById(paramInt);
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((TextView)localObject1).setText((CharSequence)localObject2);
    }
    if (paramBoolean) {
      ((TextView)localObject1).setTextColor(-1);
    }
  }
  
  private boolean layoutTitleView(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    Object localObject2 = (TextView)((View)this.mViewContainer).findViewById(2131367496);
    Object localObject1 = getGenderName(paramProfileCardInfo);
    if (paramProfileCardInfo.allInOne.pa == 0) {
      localObject1 = HardCodeUtil.a(2131708470);
    }
    ((TextView)localObject2).setText(String.format("%s%s", new Object[] { localObject1, this.mActivity.getString(2131693372) }));
    updateItemTheme((View)this.mViewContainer, (TextView)localObject2, null, null);
    paramProfileCardInfo = (TextView)((View)this.mViewContainer).findViewById(2131367458);
    localObject1 = ((View)this.mViewContainer).findViewById(2131367478);
    if (paramBoolean) {
      paramProfileCardInfo.setTextColor(Color.parseColor("#98989F"));
    }
    localObject2 = this.mProfileGameInfo;
    if ((localObject2 != null) && (!((ProfileGameInfo)localObject2).isEmpty()))
    {
      paramProfileCardInfo.setText(2131693305);
      ((View)localObject1).setVisibility(0);
      return false;
    }
    ((View)localObject1).setVisibility(8);
    return true;
  }
  
  private boolean makeOrRefreshEntry(ProfileCardInfo paramProfileCardInfo)
  {
    if (!this.mInit)
    {
      initNetRequest();
      return false;
    }
    boolean bool3 = makeOrRefreshGameCardInfoView((ProfileCardInfo)this.mData) | false;
    boolean bool1;
    if ((this.mViewContainer != null) && (((View)this.mViewContainer).getVisibility() == 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool3)
    {
      if (((ProfileCardInfo)this.mData).isTroopMemberCard) {
        TroopReportor.a("Grp_mber", "mber_card", "game_switch", 0, 0, new String[] { ((ProfileCardInfo)this.mData).troopUin });
      } else {
        reportGameCard();
      }
      if (this.mDelegate != null) {
        this.mDelegate.notifyCardUpdate();
      }
    }
    boolean bool2 = bool3;
    if (!bool1)
    {
      if (this.mViewContainer == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = bool3 | bool1;
      if (this.mViewContainer != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemGameInfoComponent", 2, new Object[] { "bShow = false. mViewContainer removeAllViews. mViewContainer=%s", this.mViewContainer });
        }
        ((ViewGroup)this.mViewContainer).removeAllViews();
      }
      this.mViewContainer = null;
    }
    return bool2;
  }
  
  private boolean makeOrRefreshGameCardInfoView(ProfileCardInfo paramProfileCardInfo)
  {
    QBaseActivity localQBaseActivity = this.mActivity;
    boolean bool1 = true;
    boolean bool2 = true;
    if ((localQBaseActivity != null) && (this.gameCardInfoPrepared) && (paramProfileCardInfo != null) && (paramProfileCardInfo.allInOne != null) && (shouldShowGameCard()))
    {
      if (this.mViewContainer == null)
      {
        this.mViewContainer = this.mActivity.getLayoutInflater().inflate(2131561566, null);
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      if ((this.mApp == null) || (!ThemeUtil.isInNightMode(this.mApp))) {
        bool2 = false;
      }
      if (layoutTitleView(paramProfileCardInfo, bool2)) {
        return bool1;
      }
      int i = this.mProfileGameInfo.mGrade;
      layoutCardViewBg(bool2);
      layoutGradeIconView(i, bool2);
      layoutGameInfoTextView(i, bool2);
      layoutAvatarListView();
      ((View)this.mViewContainer).setVisibility(0);
      return bool1;
    }
    if (QLog.isColorLevel())
    {
      paramProfileCardInfo = new StringBuilder();
      paramProfileCardInfo.append("makeOrRefreshGameCardInfoView. Not showing game info. gameCardInfoPrepared = ");
      paramProfileCardInfo.append(this.gameCardInfoPrepared);
      paramProfileCardInfo.append(", init = ");
      paramProfileCardInfo.append(this.mInit);
      QLog.d("ProfileTroopMemGameInfoComponent", 2, paramProfileCardInfo.toString());
    }
    if (this.mViewContainer == null) {
      bool1 = false;
    }
    if (this.mViewContainer != null) {
      ((View)this.mViewContainer).setVisibility(8);
    }
    return bool1;
  }
  
  private boolean personalGameCardSwitchEnabled()
  {
    Object localObject = this.mData;
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (localObject != null)
    {
      bool2 = bool3;
      if (((ProfileCardInfo)this.mData).card != null)
      {
        if (this.mApp == null) {
          return false;
        }
        boolean bool4 = StudyModeManager.a();
        boolean bool5 = this.mConfigHelper.isSwitchEnable(14);
        boolean bool1;
        if (ProfileSettingUtils.a.a(42505, ((ProfileCardInfo)this.mData).card, this.mQQAppInterface) == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("personalGameCardSwitchEnabled. wzGameCardSwitchEnable = ");
          ((StringBuilder)localObject).append(bool1);
          ((StringBuilder)localObject).append(", wzGameCardConfigEnable = ");
          ((StringBuilder)localObject).append(bool5);
          QLog.d("ProfileTroopMemGameInfoComponent", 2, ((StringBuilder)localObject).toString());
        }
        bool2 = bool3;
        if (!bool4)
        {
          bool2 = bool3;
          if (bool1)
          {
            bool2 = bool3;
            if (bool5) {
              bool2 = true;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  private void reportGameCard()
  {
    if ((this.mData != null) && (!((ProfileCardInfo)this.mData).isTroopMemberCard) && (ProfileUtils.isVisible((View)this.mViewContainer)) && (!this.hasReport))
    {
      ReportController.b(this.mApp, "dc00898", "", "", "0X800B5EF", "0X800B5EF", 0, 0, "0", "0", "", "");
      this.hasReport = true;
    }
  }
  
  private void requestGameCardInfo(String paramString1, String paramString2)
  {
    if ((NetworkUtil.isNetworkAvailable(this.mActivity)) && (this.mApp != null))
    {
      ITroopGameHandler localITroopGameHandler = (ITroopGameHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.TROOP_GAME_HANDLER);
      if (localITroopGameHandler != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemGameInfoComponent", 2, "requestGameCardInfo.getTroopMemberGameCard");
        }
        localITroopGameHandler.a(String.valueOf(paramString1), String.valueOf(paramString2));
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("requestGameCardInfo.isNetworkAvailable = false, mApp is null: ");
      boolean bool;
      if (this.mApp == null) {
        bool = true;
      } else {
        bool = false;
      }
      paramString1.append(bool);
      QLog.d("ProfileTroopMemGameInfoComponent", 2, paramString1.toString());
    }
  }
  
  private void scrollToTroopMemGame()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.postDelayed(new ProfileTroopMemGameInfoComponent.3(this), 1000L);
    }
  }
  
  private boolean shouldShowGameCard()
  {
    if (this.mData == null) {
      return false;
    }
    if (StudyModeManager.a()) {
      return false;
    }
    StringBuilder localStringBuilder;
    if (((ProfileCardInfo)this.mData).isTroopMemberCard)
    {
      bool = shouldShowTroopMemberGameCard();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("shouldShowGameCard. shouldShowTroopMemberGameCard = ");
        localStringBuilder.append(bool);
        QLog.d("ProfileTroopMemGameInfoComponent", 2, localStringBuilder.toString());
      }
      return bool;
    }
    boolean bool = personalGameCardSwitchEnabled();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldShowGameCard. personalGameCardSwitchEnabled = ");
      localStringBuilder.append(bool);
      QLog.d("ProfileTroopMemGameInfoComponent", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private boolean shouldShowTroopMemberGameCard()
  {
    if (this.mData != null)
    {
      if (!((ProfileCardInfo)this.mData).isTroopMemberCard) {
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
    return false;
  }
  
  private void updateData()
  {
    if (this.mDelegate != null) {
      this.mDelegate.notifyCardUpdate();
    }
    if ((this.mScrollToTroopMemGame) && (!this.mHasScrollToTroopMemGame))
    {
      this.mHasScrollToTroopMemGame = true;
      scrollToTroopMemGame();
    }
  }
  
  public void checkAndUpdateTroopInfo(TroopInfo paramTroopInfo)
  {
    AllInOne localAllInOne = ((ProfileCardInfo)this.mData).allInOne;
    if ((localAllInOne != null) && (paramTroopInfo != null) && (ProfilePAUtils.isFromTroopMemberCard(localAllInOne.pa)) && (TextUtils.isEmpty(localAllInOne.troopUin)))
    {
      localAllInOne.troopUin = paramTroopInfo.troopcode;
      localAllInOne.troopCode = paramTroopInfo.troopuin;
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
    if (this.mActivity == null) {
      return "他";
    }
    String str = this.mActivity.getString(2131699580);
    Object localObject = str;
    if (paramProfileCardInfo != null)
    {
      localObject = str;
      if (paramProfileCardInfo.card != null)
      {
        if (paramProfileCardInfo.card.shGender == 1) {
          paramProfileCardInfo = this.mActivity.getString(2131699579);
        } else {
          paramProfileCardInfo = this.mActivity.getString(2131699580);
        }
        localObject = paramProfileCardInfo;
      }
    }
    return localObject;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_troop_game_info";
  }
  
  public void initNetRequest()
  {
    if (this.mInit) {
      return;
    }
    if ((this.mData != null) && (((ProfileCardInfo)this.mData).allInOne != null) && (((ProfileCardInfo)this.mData).card != null))
    {
      if (!StudyModeManager.a())
      {
        if (checkTroopGameCardSwitch())
        {
          if (QLog.isColorLevel()) {
            QLog.e("ProfileTroopMemGameInfoComponent", 2, "initNetRequest.checkTroopGameCardSwitch = true");
          }
          if (!checkIsHwTroop()) {
            requestTroopMemberInfo();
          }
        }
        else
        {
          boolean bool = personalGameCardSwitchEnabled();
          if (bool) {
            requestGameCardInfo("0", ((ProfileCardInfo)this.mData).allInOne.uin);
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("initNetRequest.personalSwitch = ");
            localStringBuilder.append(bool);
            QLog.d("ProfileTroopMemGameInfoComponent", 2, localStringBuilder.toString());
          }
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemGameInfoComponent", 2, "initNetRequest.studyMode = true");
      }
      this.mInit = true;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ProfileTroopMemGameInfoComponent", 2, "initNetRequest.mData is not ready");
    }
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    if ((this.mActivity != null) && (this.mApp != null))
    {
      this.mActivity.addObserver(this.mTroopGameObserver);
      checkAndUpdateTroopInfo(((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).b(((ProfileCardInfo)this.mData).troopUin));
      this.gameCardInfoPrepared = false;
      this.hasReport = false;
      if (this.mDelegate != null) {
        this.mDelegate.addProfileScrollListener(this);
      }
      paramQBaseActivity = this.mActivity.getIntent();
      if (paramQBaseActivity != null) {
        this.mScrollToTroopMemGame = paramQBaseActivity.getBooleanExtra("profile_scroll_to_wangzhe", false);
      }
      this.mHandler = new Handler(Looper.getMainLooper());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemGameInfoComponent", 2, "onCreate: mActivity == null || mApp == null");
    }
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshEntry((ProfileCardInfo)this.mData);
  }
  
  public void onDestroy()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    if (this.mActivity != null) {
      this.mActivity.removeObserver(this.mTroopGameObserver);
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
    if ((paramInt == 0) && (ProfileUtils.isVisible((View)this.mViewContainer))) {
      ((View)this.mViewContainer).post(new ProfileTroopMemGameInfoComponent.2(this));
    }
  }
  
  public void requestTroopMemberInfo()
  {
    if (!NetworkUtil.isNetworkAvailable(this.mActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemGameInfoComponent", 2, "requestTroopMemberInfo.isNetworkAvailable = false");
      }
      return;
    }
    if (this.mApp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemGameInfoComponent", 2, "requestTroopMemberInfo mApp is null");
      }
      return;
    }
    Object localObject = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
    ITroopGameHandler localITroopGameHandler = (ITroopGameHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.TROOP_GAME_HANDLER);
    localObject = ((TroopManager)localObject).b(((ProfileCardInfo)this.mData).troopUin);
    checkAndUpdateTroopInfo((TroopInfo)localObject);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemGameInfoComponent", 2, "requestTroopMemberInfo.getMemberGameCardSwitch");
      }
      localITroopGameHandler.a(((ProfileCardInfo)this.mData).troopUin, Long.parseLong(((ProfileCardInfo)this.mData).allInOne.uin));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ProfileTroopMemGameInfoComponent", 2, "requestTroopMemberInfo.getTroopMemberCardInfo troopInfo null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troopgame.ProfileTroopMemGameInfoComponent
 * JD-Core Version:    0.7.0.1
 */