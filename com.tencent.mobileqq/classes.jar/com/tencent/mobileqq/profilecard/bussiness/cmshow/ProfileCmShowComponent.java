package com.tencent.mobileqq.profilecard.bussiness.cmshow;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.apollo.profilecard.api.IProfileCmShowComponentDelegate;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ProfileCmShowComponent
  extends AbsQQProfileComponent<FrameLayout>
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
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 2, "onCreate");
    }
    paramQBaseActivity = this.mProfileCmShowComponentDelegate;
    if (paramQBaseActivity != null) {
      paramQBaseActivity.onCreate(this.mActivity, (View)this.mViewContainer, paramBundle, (ProfileCardInfo)this.mData, this.mConfigHelper);
    }
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 2, "onDataUpdate");
    }
    boolean bool2 = super.onDataUpdate(paramProfileCardInfo);
    IProfileCmShowComponentDelegate localIProfileCmShowComponentDelegate = this.mProfileCmShowComponentDelegate;
    boolean bool1 = bool2;
    if (localIProfileCmShowComponentDelegate != null) {
      bool1 = bool2 | localIProfileCmShowComponentDelegate.onDataUpdate(paramProfileCardInfo);
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 2, "onDestroy");
    }
    IProfileCmShowComponentDelegate localIProfileCmShowComponentDelegate = this.mProfileCmShowComponentDelegate;
    if (localIProfileCmShowComponentDelegate != null) {
      localIProfileCmShowComponentDelegate.onDestroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 2, "onPause");
    }
    IProfileCmShowComponentDelegate localIProfileCmShowComponentDelegate = this.mProfileCmShowComponentDelegate;
    if (localIProfileCmShowComponentDelegate != null) {
      localIProfileCmShowComponentDelegate.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 2, "onResume");
    }
    IProfileCmShowComponentDelegate localIProfileCmShowComponentDelegate = this.mProfileCmShowComponentDelegate;
    if (localIProfileCmShowComponentDelegate != null) {
      localIProfileCmShowComponentDelegate.onResume();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 2, "onStop");
    }
    IProfileCmShowComponentDelegate localIProfileCmShowComponentDelegate = this.mProfileCmShowComponentDelegate;
    if (localIProfileCmShowComponentDelegate != null) {
      localIProfileCmShowComponentDelegate.onStop();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onWindowFocusChanged isFocused=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ProfileCmShowComponent", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = this.mProfileCmShowComponentDelegate;
      if (localObject != null) {
        ((IProfileCmShowComponentDelegate)localObject).onWindowFocusGained();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.cmshow.ProfileCmShowComponent
 * JD-Core Version:    0.7.0.1
 */