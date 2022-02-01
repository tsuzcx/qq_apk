package com.tencent.mobileqq.profilecard.base.container;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.factory.ProfileComponentFactory;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.vas.component.background.AbsVasProfileBackgroundComponent;

public class ProfileBgContainer
  extends AbsProfileComponent<FrameLayout>
{
  private static final String TAG = "ProfileBgContainer";
  private AbsVasProfileBackgroundComponent mBgComponent;
  private long mCurStyleId;
  
  public ProfileBgContainer(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private boolean checkSwitchHeaderComponent(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramProfileCardInfo != null) {
      if (this.mBgComponent != null)
      {
        bool1 = bool2;
        if (this.mCurStyleId == paramProfileCardInfo.a) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void destroyBgComponent()
  {
    if (this.mBgComponent != null)
    {
      removeComponent(this.mBgComponent);
      this.mBgComponent.detachFromComponentCenter();
      this.mBgComponent = null;
      this.mCurStyleId = 0L;
    }
  }
  
  private void initBgComponent()
  {
    if (this.mBgComponent == null)
    {
      this.mBgComponent = ((AbsVasProfileBackgroundComponent)ProfileComponentFactory.create(1003, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mBgComponent.setContainerView(this.mViewContainer);
      this.mBgComponent.attachToComponentCenter();
      addComponent(this.mBgComponent);
      this.mCurStyleId = ((ProfileCardInfo)this.mData).a;
    }
  }
  
  public String getComponentName()
  {
    return "ProfileBgContainer";
  }
  
  public int getComponentType()
  {
    return 104;
  }
  
  public void onCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    initBgComponent();
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    int i = 0;
    if (checkSwitchHeaderComponent(paramProfileCardInfo))
    {
      destroyBgComponent();
      initBgComponent();
      i = 1;
    }
    return i | super.onDataUpdate(paramProfileCardInfo);
  }
  
  public void onDestroy()
  {
    destroyBgComponent();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileBgContainer
 * JD-Core Version:    0.7.0.1
 */