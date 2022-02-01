package com.tencent.mobileqq.profilecard.vas.component.header;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VasProfileHeaderTagComponent
  extends AbsVasProfileHeaderComponent
{
  private static final String TAG = "VasProfileHeaderTagComponent";
  
  public VasProfileHeaderTagComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void handleTagEditClick()
  {
    Intent localIntent = new Intent(this.mActivity, ProfileLabelEditorActivity.class);
    localIntent.putExtra("uin", ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
    this.mActivity.startActivityForResult(localIntent, 1004);
    ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X80066C6", 0, 0, "1", "", "", "");
  }
  
  public String getComponentName()
  {
    return "VasProfileHeaderTagComponent";
  }
  
  public void initHeaderView()
  {
    if (this.mHeaderView == null)
    {
      VasProfileTagView localVasProfileTagView = new VasProfileTagView(this.mActivity, (ProfileCardInfo)this.mData);
      localVasProfileTagView.setProfileArgs(this.mComponentCenter);
      localVasProfileTagView.setClickListener(this);
      localVasProfileTagView.onInit();
      this.mHeaderView = localVasProfileTagView;
      ((FrameLayout)this.mViewContainer).removeAllViews();
      ((FrameLayout)this.mViewContainer).addView(this.mHeaderView);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
      paramIntent = ((FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.mApp.getCurrentAccountUin());
    } while (paramIntent == null);
    ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard = paramIntent;
    this.mHeaderView.updateTagCloud((ProfileCardInfo)this.mData);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if ((paramView.getTag() instanceof DataTag)) {
      switch (((DataTag)paramView.getTag()).a)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      handleTagEditClick();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderTagComponent
 * JD-Core Version:    0.7.0.1
 */