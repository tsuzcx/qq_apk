package com.tencent.mobileqq.profilecard.base.container;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;

public class ProfileHeaderContainer
  extends AbsQQProfileContainer
{
  private static final String TAG = "ProfileHeaderContainer";
  private long mCurStyleId;
  private long mCurTemplateVersion;
  private AbsProfileHeaderComponent mHeaderComponent;
  
  public ProfileHeaderContainer(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private boolean checkSwitchHeaderComponent(ProfileCardInfo paramProfileCardInfo)
  {
    return (paramProfileCardInfo != null) && ((this.mHeaderComponent == null) || (this.mCurStyleId != paramProfileCardInfo.curUseStyleId) || (this.mCurTemplateVersion != paramProfileCardInfo.curUseTemplateVersion));
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
      AbsProfileHeaderComponent localAbsProfileHeaderComponent = (AbsProfileHeaderComponent)ProfileUtils.create(1002, this.mComponentCenter, paramProfileCardInfo, this.mDelegate);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, String.format("initHeaderComponent headerComponent=%s", new Object[] { localAbsProfileHeaderComponent }));
      }
      this.mHeaderComponent = localAbsProfileHeaderComponent;
      this.mHeaderComponent.setContainerView(this.mViewContainer);
      this.mHeaderComponent.attachToComponentCenter();
      addComponent(this.mHeaderComponent);
      this.mCurStyleId = paramProfileCardInfo.curUseStyleId;
      this.mCurTemplateVersion = paramProfileCardInfo.curUseTemplateVersion;
    }
  }
  
  private void resetHeaderComponent(ProfileCardInfo paramProfileCardInfo)
  {
    if (paramProfileCardInfo.curUseStyleId != ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, "resetHeaderComponent");
      }
      paramProfileCardInfo.curUseStyleId = ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID;
      paramProfileCardInfo.curUseTemplateVersion = 0L;
      paramProfileCardInfo.currentTemplate = null;
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
    boolean bool = checkSwitchHeaderComponent(paramProfileCardInfo);
    int i = 1;
    if (bool)
    {
      destroyHeaderComponent();
      try
      {
        initHeaderComponent(paramProfileCardInfo);
      }
      catch (Exception localException)
      {
        QLog.e("ProfileHeaderContainer", 1, "onDataUpdate init header component fail, reset to default.", localException);
        destroyHeaderComponent();
        resetHeaderComponent(paramProfileCardInfo);
      }
    }
    else
    {
      i = 0;
    }
    return super.onDataUpdate(paramProfileCardInfo) | i;
  }
  
  public void onDestroy()
  {
    destroyHeaderComponent();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileHeaderContainer
 * JD-Core Version:    0.7.0.1
 */