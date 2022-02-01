package com.tencent.mobileqq.profilecard.vas.component.header;

import android.widget.FrameLayout;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView;

public class VasProfileHeaderWZRYComponent
  extends AbsVasProfileHeaderComponent
{
  private static final String TAG = "VasProfileHeaderWZRYComponent";
  
  public VasProfileHeaderWZRYComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  public String getComponentName()
  {
    return "VasProfileHeaderWZRYComponent";
  }
  
  protected void initHeaderView()
  {
    if (this.mHeaderView == null)
    {
      VasProfileWZRYView localVasProfileWZRYView = new VasProfileWZRYView(this.mActivity, (ProfileCardInfo)this.mData);
      localVasProfileWZRYView.setClickListener(this);
      localVasProfileWZRYView.onInit(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
      this.mHeaderView = localVasProfileWZRYView;
      ((FrameLayout)this.mViewContainer).removeAllViews();
      ((FrameLayout)this.mViewContainer).addView(this.mHeaderView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderWZRYComponent
 * JD-Core Version:    0.7.0.1
 */