package com.tencent.mobileqq.profilecard.bussiness.anonymous.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilesetting.CardSettingHandler;
import com.tencent.mobileqq.profilesetting.CardSettingObserver;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.mobileqq.widget.ProfileConfigHelper.OnConfigUpdateListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public class AnonymousManager
  implements ProfileConfigHelper.OnConfigUpdateListener, Manager
{
  private static final String TAG = "AnonymousManager";
  private QQAppInterface mApp;
  private boolean mBusinessSwitch = false;
  private CardSettingObserver mCardSettingObserver = new AnonymousManager.1(this);
  private ProfileConfigHelper mConfigHelper;
  private boolean mConfigSwitch = false;
  private boolean mSettingMeRedPointEnable = false;
  
  public AnonymousManager(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mConfigHelper = new ProfileConfigHelper(paramQQAppInterface, this);
    updateConfigSwitch(this.mConfigHelper.a(13));
    getBusinessSwitch(paramQQAppInterface);
  }
  
  private void getBusinessSwitch(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      CardSettingHandler localCardSettingHandler = (CardSettingHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_SETTING_HANDLER);
      if (localCardSettingHandler != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(42425));
        localCardSettingHandler.a(localArrayList);
        paramQQAppInterface.addObserver(this.mCardSettingObserver);
      }
    }
  }
  
  private void notifySettingMeRedPointChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousManager", 2, String.format("notifySettingMeRedPointChanged mSettingMeRedPointEnable=%s", new Object[] { Boolean.valueOf(this.mSettingMeRedPointEnable) }));
    }
    if (this.mApp != null)
    {
      CardHandler localCardHandler = (CardHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (localCardHandler != null) {
        localCardHandler.notifyUI(115, true, Boolean.valueOf(this.mSettingMeRedPointEnable));
      }
    }
  }
  
  private void updateSettingMeRedPointEnable()
  {
    if ((this.mConfigSwitch) && (this.mBusinessSwitch)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool != this.mSettingMeRedPointEnable)
      {
        this.mSettingMeRedPointEnable = bool;
        notifySettingMeRedPointChanged();
      }
      return;
    }
  }
  
  public boolean getSettingMeRedPointEnable()
  {
    return this.mSettingMeRedPointEnable;
  }
  
  public void onConfigUpdate(int paramInt, String paramString)
  {
    if ((TextUtils.equals(paramString, "profile_switch_config")) && (this.mConfigHelper != null)) {
      updateConfigSwitch(this.mConfigHelper.a(13));
    }
  }
  
  public void onDestroy()
  {
    this.mApp = null;
    if (this.mConfigHelper != null)
    {
      this.mConfigHelper.a();
      this.mConfigHelper = null;
    }
  }
  
  protected void updateBusinessSwitch(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousManager", 2, String.format("updateBusinessSwitch newBusinessSwitch=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
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
      QLog.d("AnonymousManager", 2, String.format("updateConfigSwitch newConfigSwitch=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean != this.mConfigSwitch)
    {
      this.mConfigSwitch = paramBoolean;
      updateSettingMeRedPointEnable();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.manager.AnonymousManager
 * JD-Core Version:    0.7.0.1
 */