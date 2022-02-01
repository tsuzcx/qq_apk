package com.tencent.mobileqq.profilecard.vas.component.header;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipV5View;

public class VasProfileHeaderV5Component
  extends AbsVasProfileHeaderComponent
{
  private static final String TAG = "VasProfileHeaderV5Component";
  private boolean mIsFromArkBabyQ;
  
  public VasProfileHeaderV5Component(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  public String getComponentName()
  {
    return "VasProfileHeaderV5Component";
  }
  
  protected void initHeaderView()
  {
    if (this.mHeaderView == null)
    {
      VasProfileQVipV5View localVasProfileQVipV5View = new VasProfileQVipV5View(this.mActivity, (ProfileCardInfo)this.mData);
      localVasProfileQVipV5View.setProfileArgs(this.mIsFromArkBabyQ);
      localVasProfileQVipV5View.setClickListener(this);
      localVasProfileQVipV5View.onInit(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
      this.mHeaderView = localVasProfileQVipV5View;
      ((FrameLayout)this.mViewContainer).removeAllViews();
      ((FrameLayout)this.mViewContainer).addView(this.mHeaderView);
    }
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    Intent localIntent = paramQBaseActivity.getIntent();
    if (localIntent != null) {
      this.mIsFromArkBabyQ = localIntent.getBooleanExtra("key_from_ark_babyq", false);
    }
    super.onCreate(paramQBaseActivity, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderV5Component
 * JD-Core Version:    0.7.0.1
 */