package com.tencent.mobileqq.guild.profilecard.manage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.setting.QQGuildMemberFragment;
import com.tencent.mobileqq.guild.setting.QQGuildMemberFragment.OperateMemberResult;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton.OnCheckedChangeListener;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;

public class GuildProfileManageComponent
  extends AbsGuildProfileComponent
  implements View.OnClickListener, GuildSwitchButton.OnCheckedChangeListener
{
  private static final String TAG = "GuildProfileManageComponent";
  private Button mBtnRemoveGuild;
  private QQCustomDialog mDeleteDialog;
  private View mLlManageMyProfile;
  private GuildProfileManageViewModel mManageViewModel;
  private View mRlManageMyProfile;
  private GuildSwitchButton mSwitchSetChannelManager;
  private LinearLayout mSwitchSetChannelll;
  
  public GuildProfileManageComponent(IGuildComponentController paramIGuildComponentController, GuildProfileData paramGuildProfileData)
  {
    super(paramIGuildComponentController, paramGuildProfileData);
  }
  
  private void bindUI()
  {
    this.mBtnRemoveGuild = ((Button)this.mViewContainer.findViewById(2131440699));
    this.mLlManageMyProfile = this.mViewContainer.findViewById(2131434681);
    this.mRlManageMyProfile = this.mViewContainer.findViewById(2131434716);
    this.mSwitchSetChannelManager = ((GuildSwitchButton)this.mViewContainer.findViewById(2131434612));
    this.mSwitchSetChannelll = ((LinearLayout)this.mViewContainer.findViewById(2131434611));
    this.mBtnRemoveGuild.setOnClickListener(this);
    this.mRlManageMyProfile.setOnClickListener(this);
    this.mBtnRemoveGuild.setOnClickListener(this);
    setAccessibilityUI();
  }
  
  private void bindViewModel()
  {
    this.mManageViewModel = ((GuildProfileManageViewModel)ViewModelProviderHelper.a(this.mFragment, GuildProfileManageViewModel.a).get(GuildProfileManageViewModel.class));
    this.mManageViewModel.a(this.mData.getGuildBaseProfileData());
    this.mManageViewModel.a(this.mApp);
    this.mManageViewModel.b().observe(this.mFragment, new GuildProfileManageComponent.1(this));
    this.mManageViewModel.c().observe(this.mFragment, new GuildProfileManageComponent.2(this));
    this.mManageViewModel.d().observe(this.mFragment, new GuildProfileManageComponent.3(this));
    this.mManageViewModel.e().observe(this.mFragment, new GuildProfileManageComponent.4(this));
  }
  
  private void dismiss()
  {
    getComponentController().a();
  }
  
  private void initSwitchSetChannelManager(boolean paramBoolean)
  {
    this.mLlManageMyProfile.setVisibility(0);
    this.mSwitchSetChannelll.setVisibility(0);
    this.mSwitchSetChannelManager.setChecked(paramBoolean);
    this.mSwitchSetChannelManager.setOnCheckedChangeListener(this);
  }
  
  private void onClickRemoveGuild()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuildProfileManageComponent", 2, "onClickRemoveGuild");
    }
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.mBtnRemoveGuild, "em_sgrp_remove_channel", null);
    VideoReport.reportEvent("clck", this.mBtnRemoveGuild, null);
    if (this.mDeleteDialog == null)
    {
      this.mDeleteDialog = DialogUtil.a(this.mFragment.getContext(), 0, "确定移除该用户？", "", new GuildProfileManageComponent.5(this), new GuildProfileManageComponent.6(this));
      this.mDeleteDialog.setCheckBox(BaseApplication.getContext().getString(2131890568), false, null);
      this.mDeleteDialog.findViewById(2131431876).setVisibility(8);
      ((LinearLayout.LayoutParams)this.mDeleteDialog.findViewById(2131436895).getLayoutParams()).topMargin = 0;
      ((CheckBox)this.mDeleteDialog.findViewById(2131447782)).setBackgroundResource(((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).getGuildSettingDrawable());
      TextView localTextView = (TextView)this.mDeleteDialog.findViewById(2131448922);
      localTextView.setTextSize(14.0F);
      localTextView.setTextColor(-7894119);
    }
    ((CheckBox)this.mDeleteDialog.findViewById(2131447782)).setChecked(false);
    this.mDeleteDialog.show();
  }
  
  private void refreshUI()
  {
    String str1 = this.mManageViewModel.f().d();
    int i = this.mManageViewModel.f().g();
    String str2 = this.mManageViewModel.f().c();
    int j = this.mManageViewModel.f().h();
    if (str1.equals(str2))
    {
      this.mBtnRemoveGuild.setVisibility(8);
      this.mLlManageMyProfile.setVisibility(0);
      this.mRlManageMyProfile.setVisibility(0);
      return;
    }
    if (((i == 1) || (i == 2)) && (j == 0))
    {
      this.mBtnRemoveGuild.setVisibility(0);
      if (i == 2)
      {
        initSwitchSetChannelManager(false);
        return;
      }
      this.mLlManageMyProfile.setVisibility(8);
      return;
    }
    if ((i == 2) && (j == 1))
    {
      this.mBtnRemoveGuild.setVisibility(0);
      initSwitchSetChannelManager(true);
      return;
    }
    this.mBtnRemoveGuild.setVisibility(8);
  }
  
  private void setAccessibilityUI()
  {
    if (AppSetting.e)
    {
      this.mSwitchSetChannelManager.setContentDescription(this.mFragment.getString(2131890555));
      this.mSwitchSetChannelManager.setFocusable(true);
    }
  }
  
  private void setResult(QQGuildMemberFragment.OperateMemberResult paramOperateMemberResult)
  {
    if (this.mFragment == null) {
      return;
    }
    Fragment localFragment = this.mFragment.getTargetFragment();
    if ((localFragment instanceof QQGuildMemberFragment))
    {
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("operate_member_result", paramOperateMemberResult);
      paramOperateMemberResult = new Intent();
      paramOperateMemberResult.putExtras(localBundle);
      localFragment.onActivityResult(this.mFragment.getTargetRequestCode(), -1, paramOperateMemberResult);
    }
  }
  
  public String getComponentName()
  {
    return "GuildProfileManageComponent";
  }
  
  public int getComponentType()
  {
    return 1002;
  }
  
  public int getContentLayoutId()
  {
    return 2131625109;
  }
  
  public void onCheckedChanged(GuildSwitchButton paramGuildSwitchButton, boolean paramBoolean)
  {
    GuildSwitchButton localGuildSwitchButton = this.mSwitchSetChannelManager;
    if (paramGuildSwitchButton == localGuildSwitchButton)
    {
      String str;
      if (paramBoolean) {
        str = "em_sgrp_member_mange_admin_set";
      } else {
        str = "em_sgrp_member_mange_admin_cancel";
      }
      VideoReport.setElementId(localGuildSwitchButton, str);
      VideoReport.setElementExposePolicy(this.mSwitchSetChannelManager, ExposurePolicy.REPORT_NONE);
      VideoReport.setElementClickPolicy(this.mSwitchSetChannelManager, ClickPolicy.REPORT_NONE);
      VideoReport.reportEvent("clck", this.mSwitchSetChannelManager, null);
      this.mManageViewModel.a(paramGuildSwitchButton.isChecked());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131434716)
    {
      ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.mRlManageMyProfile, "em_sgrp_edit_profile", null);
      VideoReport.reportEvent("clck", this.mRlManageMyProfile, null);
      if (!QQGuildUIUtil.a())
      {
        ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildProfileSettingFragment(this.mFragment.getActivity(), this.mManageViewModel.f().a());
        dismiss();
      }
    }
    else if (paramView.getId() == 2131440699)
    {
      onClickRemoveGuild();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Fragment paramFragment, AppInterface paramAppInterface, Bundle paramBundle)
  {
    super.onCreate(paramFragment, paramAppInterface, paramBundle);
    bindUI();
  }
  
  public void onDestroy()
  {
    this.mManageViewModel.a();
    dismiss();
  }
  
  public void onInitData(GuildProfileData paramGuildProfileData)
  {
    if (QLog.isColorLevel())
    {
      paramGuildProfileData = new StringBuilder();
      paramGuildProfileData.append("onInitData viewContainer : ");
      paramGuildProfileData.append(this.mViewContainer);
      QLog.i("GuildProfileManageComponent", 1, paramGuildProfileData.toString());
    }
    if (this.mManageViewModel == null)
    {
      bindViewModel();
      refreshUI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileManageComponent
 * JD-Core Version:    0.7.0.1
 */