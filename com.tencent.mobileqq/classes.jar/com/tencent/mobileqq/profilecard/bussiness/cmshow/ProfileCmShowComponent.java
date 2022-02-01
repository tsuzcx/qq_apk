package com.tencent.mobileqq.profilecard.bussiness.cmshow;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.apollo.api.ui.IProfileCmShowComponentDelegate;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.qroute.QRoute;

public class ProfileCmShowComponent
  extends AbsProfileComponent<FrameLayout>
{
  private static final String TAG = "ProfileCmShowComponent";
  private IProfileCmShowComponentDelegate mProfileCmShowComponentDelegate = (IProfileCmShowComponentDelegate)QRoute.api(IProfileCmShowComponentDelegate.class);
  
  public ProfileCmShowComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  public String getComponentName()
  {
    return "ProfileCmShowComponent";
  }
  
  public int getComponentType()
  {
    return 1020;
  }
  
  public void onCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 0, "onCreate");
    }
    if (this.mProfileCmShowComponentDelegate != null) {
      this.mProfileCmShowComponentDelegate.onCreate((FriendProfileCardActivity)paramBaseActivity, (View)this.mViewContainer, paramBundle);
    }
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 0, "onDataUpdate");
    }
    boolean bool2 = super.onDataUpdate(paramProfileCardInfo);
    boolean bool1 = bool2;
    if (this.mProfileCmShowComponentDelegate != null) {
      bool1 = bool2 | this.mProfileCmShowComponentDelegate.onDataUpdate(paramProfileCardInfo);
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 0, "onDestroy");
    }
    if (this.mProfileCmShowComponentDelegate != null) {
      this.mProfileCmShowComponentDelegate.onDestroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 0, "onPause");
    }
    if (this.mProfileCmShowComponentDelegate != null) {
      this.mProfileCmShowComponentDelegate.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 0, "onResume");
    }
    if (this.mProfileCmShowComponentDelegate != null) {
      this.mProfileCmShowComponentDelegate.onResume();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 0, "onStop");
    }
    if (this.mProfileCmShowComponentDelegate != null) {
      this.mProfileCmShowComponentDelegate.onStop();
    }
  }
  
  public void onWindowFocusGained()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 0, "onWindowFocusGained");
    }
    if (this.mProfileCmShowComponentDelegate != null) {
      this.mProfileCmShowComponentDelegate.onWindowFocusGained();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.cmshow.ProfileCmShowComponent
 * JD-Core Version:    0.7.0.1
 */