package com.tencent.mobileqq.profilecard.base.container;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.component.ProfileHeaderBaseComponent;
import com.tencent.mobileqq.profilecard.base.factory.ProfileComponentFactory;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.widget.PullToZoomHeaderListView;

public class ProfileHeaderContainer
  extends AbsProfileComponent<FrameLayout>
{
  private static final String TAG = "ProfileHeaderContainer";
  private ProfileConfigHelper mConfigHelper;
  private long mCurStyleId;
  private long mCurTemplateVersion;
  private IProfileActivityDelegate mDelegate;
  private AbsProfileHeaderComponent mHeaderComponent;
  private PullToZoomHeaderListView mListView;
  private ViewGroup mRoot;
  
  public ProfileHeaderContainer(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private boolean checkSwitchHeaderComponent(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramProfileCardInfo != null) {
      if ((this.mHeaderComponent != null) && (this.mCurStyleId == paramProfileCardInfo.jdField_a_of_type_Long))
      {
        bool1 = bool2;
        if (this.mCurTemplateVersion == paramProfileCardInfo.b) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void destroyHeaderComponent()
  {
    if (this.mHeaderComponent != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, "destroyHeaderComponent");
      }
      removeComponent(this.mHeaderComponent);
      this.mHeaderComponent.detachFromComponentCenter();
      this.mHeaderComponent = null;
      this.mCurStyleId = 0L;
      this.mCurTemplateVersion = 0L;
    }
  }
  
  private void initHeaderComponent(ProfileCardInfo paramProfileCardInfo)
  {
    if (this.mHeaderComponent == null)
    {
      AbsProfileHeaderComponent localAbsProfileHeaderComponent = (AbsProfileHeaderComponent)ProfileComponentFactory.create(1002, this.mComponentCenter, paramProfileCardInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, String.format("initHeaderComponent headerComponent=%s", new Object[] { localAbsProfileHeaderComponent }));
      }
      if ((localAbsProfileHeaderComponent instanceof ProfileHeaderBaseComponent)) {
        ((ProfileHeaderBaseComponent)localAbsProfileHeaderComponent).setProfileArgs(this.mConfigHelper, this.mListView);
      }
      localAbsProfileHeaderComponent.setProfileRootView(this.mRoot);
      this.mHeaderComponent = localAbsProfileHeaderComponent;
      this.mHeaderComponent.setProfileActivityDelegate(this.mDelegate);
      this.mHeaderComponent.setContainerView(this.mViewContainer);
      this.mHeaderComponent.attachToComponentCenter();
      addComponent(this.mHeaderComponent);
      this.mCurStyleId = paramProfileCardInfo.jdField_a_of_type_Long;
      this.mCurTemplateVersion = paramProfileCardInfo.b;
    }
  }
  
  private void resetHeaderComponent(ProfileCardInfo paramProfileCardInfo)
  {
    if (paramProfileCardInfo.jdField_a_of_type_Long != ProfileCardTemplate.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, "resetHeaderComponent");
      }
      paramProfileCardInfo.jdField_a_of_type_Long = ProfileCardTemplate.jdField_a_of_type_Long;
      paramProfileCardInfo.b = 0L;
      paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      initHeaderComponent(paramProfileCardInfo);
    }
  }
  
  public String getComponentName()
  {
    return "ProfileHeaderContainer";
  }
  
  public int getComponentType()
  {
    return 102;
  }
  
  public AbsProfileHeaderComponent getHeaderComponent()
  {
    return this.mHeaderComponent;
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    int i = 1;
    if (checkSwitchHeaderComponent(paramProfileCardInfo)) {
      destroyHeaderComponent();
    }
    for (;;)
    {
      try
      {
        initHeaderComponent(paramProfileCardInfo);
        return i | super.onDataUpdate(paramProfileCardInfo);
      }
      catch (Exception localException)
      {
        QLog.e("ProfileHeaderContainer", 1, "onDataUpdate init header component fail, reset to default.", localException);
        destroyHeaderComponent();
        resetHeaderComponent(paramProfileCardInfo);
        continue;
      }
      i = 0;
    }
  }
  
  public void onDestroy()
  {
    destroyHeaderComponent();
    super.onDestroy();
  }
  
  public void setProfileArgs(ProfileConfigHelper paramProfileConfigHelper, PullToZoomHeaderListView paramPullToZoomHeaderListView, ViewGroup paramViewGroup)
  {
    this.mConfigHelper = paramProfileConfigHelper;
    this.mListView = paramPullToZoomHeaderListView;
    this.mRoot = paramViewGroup;
  }
  
  public void setProfileHeaderDelegate(IProfileActivityDelegate paramIProfileActivityDelegate)
  {
    this.mDelegate = paramIProfileActivityDelegate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileHeaderContainer
 * JD-Core Version:    0.7.0.1
 */