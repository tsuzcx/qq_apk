package com.tencent.mobileqq.profilecard.vas.component.header;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
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
    localIntent.putExtra("uin", ((ProfileCardInfo)this.mData).allInOne.uin);
    this.mActivity.startActivityForResult(localIntent, 1004);
    ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X80066C6", 0, 0, "1", "", "", "");
  }
  
  public String getComponentName()
  {
    return "VasProfileHeaderTagComponent";
  }
  
  protected void initHeaderView()
  {
    if (this.mHeaderView == null)
    {
      boolean bool = this.mActivity.getIntent().getBooleanExtra("key_from_extends_friend", false);
      VasProfileTagView localVasProfileTagView = new VasProfileTagView(this.mActivity, (ProfileCardInfo)this.mData);
      localVasProfileTagView.setFromExtendFriend(bool);
      localVasProfileTagView.setProfileArgs(this.mComponentCenter, this.mDelegate);
      localVasProfileTagView.setClickListener(this);
      localVasProfileTagView.onInit(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
      this.mDelegate.getListView().setMotionEventInterceptor(localVasProfileTagView);
      this.mHeaderView = localVasProfileTagView;
      ((FrameLayout)this.mViewContainer).removeAllViews();
      ((FrameLayout)this.mViewContainer).addView(this.mHeaderView);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 1004) {
      return;
    }
    paramIntent = ((FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.mApp.getCurrentAccountUin());
    if (paramIntent != null)
    {
      ((ProfileCardInfo)this.mData).card = paramIntent;
      this.mHeaderView.updateTagCloud((ProfileCardInfo)this.mData);
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (((paramView.getTag() instanceof DataTag)) && (((DataTag)paramView.getTag()).a == 32)) {
      handleTagEditClick();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderTagComponent
 * JD-Core Version:    0.7.0.1
 */