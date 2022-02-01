package com.tencent.mobileqq.profilecard.vas.component.header;

import android.widget.FrameLayout;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.view.VasProfilePhotoView;

public class VasProfileHeaderPhotoComponent
  extends AbsVasProfileHeaderComponent
{
  private static final String TAG = "VasProfileHeaderPhotoComponent";
  
  public VasProfileHeaderPhotoComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  public String getComponentName()
  {
    return "VasProfileHeaderPhotoComponent";
  }
  
  public boolean hasPhotoWall()
  {
    return true;
  }
  
  protected void initHeaderView()
  {
    if (this.mHeaderView == null)
    {
      VasProfilePhotoView localVasProfilePhotoView = new VasProfilePhotoView(this.mActivity, (ProfileCardInfo)this.mData);
      localVasProfilePhotoView.setClickListener(this);
      localVasProfilePhotoView.onInit(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
      this.mHeaderView = localVasProfilePhotoView;
      ((FrameLayout)this.mViewContainer).removeAllViews();
      ((FrameLayout)this.mViewContainer).addView(this.mHeaderView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderPhotoComponent
 * JD-Core Version:    0.7.0.1
 */