package com.tencent.mobileqq.profilecard.bussiness.weishi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.api.IWSMinePanel;
import com.tencent.biz.videostory.widget.view.MineWSPanel;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.vas.misc.DiyMoreInfoViewHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.qphone.base.util.QLog;

public class ProfileWeishiComponent
  extends AbsProfileContentComponent
{
  private static final String TAG = "ProfileWeishiComponent";
  private boolean mIsRequestShow;
  private MineWSPanel mWeishiPanel;
  
  public ProfileWeishiComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void initWeishiPanel()
  {
    if (this.mWeishiPanel == null) {
      this.mWeishiPanel = new MineWSPanel(this);
    }
  }
  
  private boolean makeOrRefreshWeishiFeedList(Card paramCard)
  {
    boolean bool1 = true;
    QLog.i("ProfileWeishiComponent", 2, "makeOrRefreshWeishiFeedList");
    if (this.mWeishiPanel == null) {
      return false;
    }
    boolean bool2 = shouldShowWeishiPanel(paramCard, this.mConfigHelper);
    QLog.i("ProfileWeishiComponent", 2, "makeOrRefreshWeishiFeedList mIsRequestShow:" + this.mIsRequestShow + ", shouldShowWeishiPanel:" + bool2);
    if ((!this.mIsRequestShow) || (!bool2))
    {
      if (this.mViewContainer == null) {
        break label221;
      }
      this.mViewContainer = null;
    }
    label221:
    for (bool1 = true;; bool1 = false)
    {
      QLog.i("ProfileWeishiComponent", 2, "makeOrRefreshWeishiFeedList remove weishi panel!");
      return bool1;
      Object localObject;
      if ((View)this.mViewContainer == null)
      {
        localObject = this.mDiyHelper.getDiyView(getProfileContentKey());
        paramCard = (Card)localObject;
        if (localObject == null)
        {
          paramCard = this.mActivity.getLayoutInflater().inflate(2131559702, null);
          this.mWeishiPanel.a(paramCard);
          this.mWeishiPanel.a(new ProfileWeishiComponent.1(this));
        }
        this.mViewContainer = paramCard;
        QLog.i("ProfileWeishiComponent", 2, "makeOrRefreshWeishiFeedList show weishi panel!");
      }
      for (;;)
      {
        paramCard = this.mWeishiPanel.a();
        localObject = this.mWeishiPanel.a();
        this.mWeishiPanel.b();
        updateItemTheme(paramCard, null, (ImageView)localObject);
        return bool1;
        bool1 = false;
      }
    }
  }
  
  private void requestWeiShiPanelInfo(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBundleExtra("result") != null) && (paramIntent.getBundleExtra("result").getBoolean("key_weishi_switch"))) {
      requestWeishiPanelInfo();
    }
  }
  
  private boolean shouldShowWeishiPanel(Card paramCard, ProfileConfigHelper paramProfileConfigHelper)
  {
    boolean bool1;
    if ((paramProfileConfigHelper == null) || (paramProfileConfigHelper.a(11)))
    {
      bool1 = true;
      if ((paramCard == null) || (paramCard.switchWeiShi == 1)) {
        break label82;
      }
    }
    label82:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileWeishiComponent", 2, String.format("shouldShowWeishiPanelOrNot configEnable:%s,switchEnable:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if ((!bool1) || (!bool2)) {
        break label88;
      }
      return true;
      bool1 = false;
      break;
    }
    label88:
    return false;
  }
  
  public BaseActivity getActivity()
  {
    return this.mActivity;
  }
  
  public String getComponentName()
  {
    return "ProfileWeishiComponent";
  }
  
  public int getComponentType()
  {
    return 1016;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_mine_weishi";
  }
  
  public void initOrRefreshWeiShiPanel(boolean paramBoolean)
  {
    QLog.i("ProfileWeishiComponent", 2, "initOrRefreshWeishiPanel");
    if (this.mWeishiPanel == null) {
      this.mWeishiPanel = new MineWSPanel(this);
    }
    this.mIsRequestShow = paramBoolean;
    if (this.mDelegate != null) {
      this.mDelegate.notifyCardUpdate();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1022) {
      requestWeiShiPanelInfo(paramIntent);
    }
    while ((paramInt2 != -1) || (paramInt1 != 1012)) {
      return;
    }
    requestWeiShiPanelInfo(paramIntent);
  }
  
  public void onCreate(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    initWeishiPanel();
    requestWeishiPanelInfo();
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshWeishiFeedList(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard) | bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportProfilePageVisitExit((ProfileCardInfo)this.mData, this.mApp);
  }
  
  public void onResume()
  {
    super.onResume();
    ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportProfilePageVisitEnter((ProfileCardInfo)this.mData, this.mApp);
  }
  
  public void requestWeishiPanelInfo()
  {
    String str;
    if (this.mWeishiPanel != null)
    {
      str = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      QLog.i("ProfileWeishiComponent", 2, "[requestWeishiPanelInfo] currentCardUin:" + str);
    }
    for (;;)
    {
      try
      {
        Long.parseLong(str);
        if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          break label141;
        }
        if (!this.mApp.getCurrentAccountUin().equals(str)) {
          continue;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ProfileWeishiComponent", 2, "requestWeishiPanelInfo failed getLong, uin = " + str);
        return;
      }
      this.mWeishiPanel.a(bool, str);
      this.mWeishiPanel.c();
      return;
      boolean bool = false;
      continue;
      label141:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.weishi.ProfileWeishiComponent
 * JD-Core Version:    0.7.0.1
 */