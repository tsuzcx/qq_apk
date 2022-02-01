package com.tencent.mobileqq.profilecard.vas.component.header;

import android.widget.FrameLayout;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileGameView;

public class VasProfileHeaderGameComponent
  extends AbsVasProfileHeaderComponent
{
  private static final String TAG = "VasProfileHeaderGameComponent";
  
  public VasProfileHeaderGameComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  public String getComponentName()
  {
    return "VasProfileHeaderGameComponent";
  }
  
  protected void initHeaderView()
  {
    if (this.mHeaderView == null)
    {
      VasProfileGameView localVasProfileGameView = new VasProfileGameView(this.mActivity, (ProfileCardInfo)this.mData);
      localVasProfileGameView.setClickListener(this);
      localVasProfileGameView.onInit(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
      this.mHeaderView = localVasProfileGameView;
      ((FrameLayout)this.mViewContainer).removeAllViews();
      ((FrameLayout)this.mViewContainer).addView(this.mHeaderView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderGameComponent
 * JD-Core Version:    0.7.0.1
 */