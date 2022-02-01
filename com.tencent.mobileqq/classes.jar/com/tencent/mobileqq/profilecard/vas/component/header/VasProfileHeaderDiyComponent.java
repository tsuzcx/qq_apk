package com.tencent.mobileqq.profilecard.vas.component.header;

import android.widget.FrameLayout;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView;

public class VasProfileHeaderDiyComponent
  extends AbsVasProfileHeaderComponent
{
  private static final String TAG = "VasProfileHeaderDiyComponent";
  
  public VasProfileHeaderDiyComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  public String getComponentName()
  {
    return "VasProfileHeaderDiyComponent";
  }
  
  public void initHeaderView()
  {
    if (this.mHeaderView == null)
    {
      VasProfileQVipDiyView localVasProfileQVipDiyView = new VasProfileQVipDiyView(this.mActivity, (ProfileCardInfo)this.mData);
      localVasProfileQVipDiyView.setProfileArgs(this.mRootView);
      localVasProfileQVipDiyView.setClickListener(this);
      localVasProfileQVipDiyView.onInit();
      localVasProfileQVipDiyView.initDiyTemplate();
      this.mHeaderView = localVasProfileQVipDiyView;
      ((FrameLayout)this.mViewContainer).removeAllViews();
      ((FrameLayout)this.mViewContainer).addView(this.mHeaderView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderDiyComponent
 * JD-Core Version:    0.7.0.1
 */