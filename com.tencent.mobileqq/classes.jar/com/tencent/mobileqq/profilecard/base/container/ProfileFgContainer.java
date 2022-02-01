package com.tencent.mobileqq.profilecard.base.container;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.factory.ProfileComponentFactory;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.cmshow.ProfileCmShowComponent;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;
import com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMediaWallComponent;

public class ProfileFgContainer
  extends AbsProfileComponent<FrameLayout>
{
  private static final String TAG = "ProfileFgContainer";
  private ProfileCmShowComponent mCmShowComponent;
  private ProfileColorScreenComponent mColorScreenComponent;
  private ProfileMediaWallComponent mMediaWallComponent;
  
  public ProfileFgContainer(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void destroyCmShowComponent()
  {
    if (this.mCmShowComponent != null)
    {
      removeComponent(this.mCmShowComponent);
      this.mCmShowComponent.detachFromComponentCenter();
      this.mCmShowComponent = null;
    }
  }
  
  private void destroyColorScreenComponent()
  {
    if (this.mColorScreenComponent != null)
    {
      removeComponent(this.mColorScreenComponent);
      this.mColorScreenComponent.detachFromComponentCenter();
      this.mColorScreenComponent = null;
    }
  }
  
  private void destroyMedalWallComponent()
  {
    if (this.mMediaWallComponent != null)
    {
      removeComponent(this.mMediaWallComponent);
      this.mMediaWallComponent.detachFromComponentCenter();
      this.mMediaWallComponent = null;
    }
  }
  
  private void initCmShowComponent()
  {
    if (this.mCmShowComponent == null)
    {
      this.mCmShowComponent = ((ProfileCmShowComponent)ProfileComponentFactory.create(1020, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mCmShowComponent.setContainerView(this.mViewContainer);
      this.mCmShowComponent.attachToComponentCenter();
      addComponent(this.mCmShowComponent);
    }
  }
  
  private void initColorScreenComponent()
  {
    if (this.mColorScreenComponent == null)
    {
      this.mColorScreenComponent = ((ProfileColorScreenComponent)ProfileComponentFactory.create(1004, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mColorScreenComponent.setContainerView(this.mViewContainer);
      this.mColorScreenComponent.attachToComponentCenter();
      addComponent(this.mColorScreenComponent);
    }
  }
  
  private void initMedalWallComponent()
  {
    if (this.mMediaWallComponent == null)
    {
      this.mMediaWallComponent = ((ProfileMediaWallComponent)ProfileComponentFactory.create(1025, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mMediaWallComponent.setContainerView(this.mViewContainer);
      this.mMediaWallComponent.attachToComponentCenter();
      addComponent(this.mMediaWallComponent);
    }
  }
  
  public String getComponentName()
  {
    return "ProfileFgContainer";
  }
  
  public int getComponentType()
  {
    return 105;
  }
  
  public void onCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    initColorScreenComponent();
    initCmShowComponent();
    initMedalWallComponent();
  }
  
  public void onDestroy()
  {
    destroyColorScreenComponent();
    destroyCmShowComponent();
    destroyMedalWallComponent();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileFgContainer
 * JD-Core Version:    0.7.0.1
 */