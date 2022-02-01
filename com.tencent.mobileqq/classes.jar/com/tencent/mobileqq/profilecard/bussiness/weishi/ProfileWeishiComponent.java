package com.tencent.mobileqq.profilecard.bussiness.weishi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.api.IWSMinePanel;
import com.tencent.biz.videostory.widget.view.MineWSPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ProfileWeishiComponent
  extends AbsQQProfileContentComponent
{
  private static final String TAG = "ProfileWeishiComponent";
  private boolean mIsRequestShow;
  private MineWSPanel mWeishiPanel;
  
  public ProfileWeishiComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private static String getCurrentCardUin(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.allInOne != null)) {
      return paramProfileCardInfo.allInOne.uin;
    }
    return "";
  }
  
  private void initWeishiPanel()
  {
    if (this.mWeishiPanel == null) {
      this.mWeishiPanel = new MineWSPanel(this);
    }
  }
  
  private static boolean isProfileMain(ProfileCardInfo paramProfileCardInfo, AppInterface paramAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramProfileCardInfo != null)
    {
      bool1 = bool2;
      if (paramProfileCardInfo.allInOne != null)
      {
        bool1 = bool2;
        if (paramAppInterface != null)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramString)) {
            if (paramProfileCardInfo.allInOne.pa != 0)
            {
              bool1 = bool2;
              if (!TextUtils.equals(paramAppInterface.getCurrentAccountUin(), paramString)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean makeOrRefreshWeishiFeedList(Card paramCard)
  {
    QLog.i("ProfileWeishiComponent", 2, "makeOrRefreshWeishiFeedList");
    Object localObject = this.mWeishiPanel;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localObject == null) {
      return false;
    }
    boolean bool3 = shouldShowWeishiPanel(paramCard, this.mConfigHelper);
    paramCard = new StringBuilder();
    paramCard.append("makeOrRefreshWeishiFeedList mIsRequestShow:");
    paramCard.append(this.mIsRequestShow);
    paramCard.append(", shouldShowWeishiPanel:");
    paramCard.append(bool3);
    QLog.i("ProfileWeishiComponent", 2, paramCard.toString());
    if ((this.mIsRequestShow) && (bool3))
    {
      localObject = (View)this.mViewContainer;
      paramCard = (Card)localObject;
      if (localObject == null)
      {
        paramCard = this.mActivity.getLayoutInflater().inflate(2131625606, null);
        this.mWeishiPanel.a(paramCard);
        this.mWeishiPanel.a(new ProfileWeishiComponent.1(this));
        this.mViewContainer = paramCard;
        QLog.i("ProfileWeishiComponent", 2, "makeOrRefreshWeishiFeedList show weishi panel!");
        bool1 = true;
      }
      localObject = this.mWeishiPanel.b();
      ImageView localImageView = this.mWeishiPanel.a();
      this.mWeishiPanel.d();
      updateItemTheme(paramCard, (TextView)localObject, null, localImageView);
      return bool1;
    }
    bool1 = bool2;
    if (this.mViewContainer != null)
    {
      this.mViewContainer = null;
      bool1 = true;
    }
    QLog.i("ProfileWeishiComponent", 2, "makeOrRefreshWeishiFeedList remove weishi panel!");
    return bool1;
  }
  
  private void requestWeiShiPanelInfo(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBundleExtra("result") != null) && (paramIntent.getBundleExtra("result").getBoolean("key_weishi_switch"))) {
      requestWeishiPanelInfo();
    }
  }
  
  private boolean shouldShowWeishiPanel(Card paramCard, IProfileConfig paramIProfileConfig)
  {
    boolean bool4 = false;
    boolean bool1;
    if ((paramIProfileConfig != null) && (!paramIProfileConfig.isSwitchEnable(11))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2;
    if ((paramCard != null) && (paramCard.switchWeiShi != 1)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileWeishiComponent", 2, String.format("shouldShowWeishiPanelOrNot configEnable:%s,switchEnable:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    boolean bool3 = bool4;
    if (bool1)
    {
      bool3 = bool4;
      if (bool2) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public QBaseActivity getActivity()
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
    if (paramInt1 == 1022)
    {
      requestWeiShiPanelInfo(paramIntent);
      return;
    }
    if ((paramInt2 == -1) && (paramInt1 == 1012)) {
      requestWeiShiPanelInfo(paramIntent);
    }
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    initWeishiPanel();
    requestWeishiPanelInfo();
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshWeishiFeedList(((ProfileCardInfo)this.mData).card);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    String str = getCurrentCardUin((ProfileCardInfo)this.mData);
    boolean bool = isProfileMain((ProfileCardInfo)this.mData, this.mApp, str);
    ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportProfilePageVisitExit(str, bool);
  }
  
  public void onResume()
  {
    super.onResume();
    String str = getCurrentCardUin((ProfileCardInfo)this.mData);
    boolean bool = isProfileMain((ProfileCardInfo)this.mData, this.mApp, str);
    ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportProfilePageVisitEnter(str, bool);
  }
  
  public void requestWeishiPanelInfo()
  {
    String str;
    StringBuilder localStringBuilder;
    if (this.mWeishiPanel != null)
    {
      str = ((ProfileCardInfo)this.mData).allInOne.uin;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[requestWeishiPanelInfo] currentCardUin:");
      localStringBuilder.append(str);
      QLog.i("ProfileWeishiComponent", 2, localStringBuilder.toString());
    }
    try
    {
      Long.parseLong(str);
      if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
        break label156;
      }
      if (!this.mApp.getCurrentAccountUin().equals(str)) {
        break label151;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        boolean bool = false;
        continue;
        bool = true;
      }
    }
    this.mWeishiPanel.a(bool, str);
    this.mWeishiPanel.e();
    return;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestWeishiPanelInfo failed getLong, uin = ");
      localStringBuilder.append(str);
      QLog.e("ProfileWeishiComponent", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.weishi.ProfileWeishiComponent
 * JD-Core Version:    0.7.0.1
 */