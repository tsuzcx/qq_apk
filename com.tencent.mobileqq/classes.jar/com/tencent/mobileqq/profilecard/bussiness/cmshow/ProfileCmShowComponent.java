package com.tencent.mobileqq.profilecard.bussiness.cmshow;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.apollo.profilecard.api.ICmShowProfileComponent;
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
  private ICmShowProfileComponent mProfileCmShowComponentDelegate = (ICmShowProfileComponent)QRoute.api(ICmShowProfileComponent.class);
  
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
    ICmShowProfileComponent localICmShowProfileComponent = this.mProfileCmShowComponentDelegate;
    boolean bool1 = bool2;
    if (localICmShowProfileComponent != null) {
      bool1 = bool2 | localICmShowProfileComponent.onDataUpdate(paramProfileCardInfo);
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 2, "onDestroy");
    }
    ICmShowProfileComponent localICmShowProfileComponent = this.mProfileCmShowComponentDelegate;
    if (localICmShowProfileComponent != null) {
      localICmShowProfileComponent.onDestroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 2, "onPause");
    }
    ICmShowProfileComponent localICmShowProfileComponent = this.mProfileCmShowComponentDelegate;
    if (localICmShowProfileComponent != null) {
      localICmShowProfileComponent.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 2, "onResume");
    }
    ICmShowProfileComponent localICmShowProfileComponent = this.mProfileCmShowComponentDelegate;
    if (localICmShowProfileComponent != null) {
      localICmShowProfileComponent.onResume();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCmShowComponent", 2, "onStop");
    }
    ICmShowProfileComponent localICmShowProfileComponent = this.mProfileCmShowComponentDelegate;
    if (localICmShowProfileComponent != null) {
      localICmShowProfileComponent.onStop();
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
        ((ICmShowProfileComponent)localObject).onWindowFocusGained();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.cmshow.ProfileCmShowComponent
 * JD-Core Version:    0.7.0.1
 */