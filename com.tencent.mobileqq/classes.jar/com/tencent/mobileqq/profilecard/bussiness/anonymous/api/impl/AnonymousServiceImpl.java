package com.tencent.mobileqq.profilecard.bussiness.anonymous.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfigListener;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.api.IAnonymousService;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousHandler;
import com.tencent.mobileqq.profilesetting.CardSettingObserver;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class AnonymousServiceImpl
  implements IProfileConfigListener, IAnonymousService
{
  private static final String TAG = "AnonymousServiceImpl";
  public AppRuntime mApp;
  private boolean mBusinessSwitch = false;
  private CardSettingObserver mCardSettingObserver = new AnonymousServiceImpl.1(this);
  private IProfileConfig mConfigHelper;
  private boolean mConfigSwitch = false;
  private boolean mSettingMeRedPointEnable = false;
  
  private void getBusinessSwitch(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(42425));
      if (((IProfileSettingApi)QRoute.api(IProfileSettingApi.class)).reqGetCardDisplaySetting(paramAppInterface, localArrayList)) {
        paramAppInterface.addObserver(this.mCardSettingObserver);
      }
    }
  }
  
  private void notifySettingMeRedPointChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousServiceImpl", 2, String.format("notifySettingMeRedPointChanged mSettingMeRedPointEnable=%s", new Object[] { Boolean.valueOf(this.mSettingMeRedPointEnable) }));
    }
    Object localObject = this.mApp;
    if (localObject != null)
    {
      localObject = (AnonymousHandler)((AppInterface)localObject).getBusinessHandler(AnonymousHandler.class.getName());
      if (localObject != null) {
        ((AnonymousHandler)localObject).notifyUI(5, true, Boolean.valueOf(this.mSettingMeRedPointEnable));
      }
    }
  }
  
  private void updateSettingMeRedPointEnable()
  {
    boolean bool;
    if ((this.mConfigSwitch) && (this.mBusinessSwitch)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool != this.mSettingMeRedPointEnable)
    {
      this.mSettingMeRedPointEnable = bool;
      notifySettingMeRedPointChanged();
    }
  }
  
  public boolean getSettingMeRedPointEnable()
  {
    return this.mSettingMeRedPointEnable;
  }
  
  public void onConfigUpdate(int paramInt, String paramString) {}
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mConfigHelper = ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).createProfileConfig((AppInterface)this.mApp, this);
    updateConfigSwitch(this.mConfigHelper.isSwitchEnable(13));
    getBusinessSwitch((AppInterface)paramAppRuntime);
  }
  
  public void onDestroy()
  {
    this.mApp = null;
    IProfileConfig localIProfileConfig = this.mConfigHelper;
    if (localIProfileConfig != null)
    {
      localIProfileConfig.destroy();
      this.mConfigHelper = null;
    }
  }
  
  protected void updateBusinessSwitch(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousServiceImpl", 2, String.format("updateBusinessSwitch newBusinessSwitch=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean != this.mBusinessSwitch)
    {
      this.mBusinessSwitch = paramBoolean;
      updateSettingMeRedPointEnable();
    }
  }
  
  protected void updateConfigSwitch(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousServiceImpl", 2, String.format("updateConfigSwitch newConfigSwitch=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean != this.mConfigSwitch)
    {
      this.mConfigSwitch = paramBoolean;
      updateSettingMeRedPointEnable();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.api.impl.AnonymousServiceImpl
 * JD-Core Version:    0.7.0.1
 */