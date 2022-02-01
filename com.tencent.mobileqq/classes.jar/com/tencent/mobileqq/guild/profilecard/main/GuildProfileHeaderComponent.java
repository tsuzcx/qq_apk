package com.tencent.mobileqq.guild.profilecard.main;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.api.IQQGuildJubaoApi;
import com.tencent.mobileqq.guild.data.QQGuildDTConstant;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller.IGuildComponentController.IDelegateCallback;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.RoundRectImageView;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class GuildProfileHeaderComponent
  extends AbsGuildProfileComponent
  implements View.OnClickListener
{
  private static final String TAG = "GuildProfileHeaderComponent";
  private GuildProfileHeaderViewModel mHeaderVModel;
  private RoundRectImageView mIvAvatar;
  private ImageView mIvMore;
  private View mLlBaseInfo;
  private View mLlProfileHeaderContainer;
  private ActionSheet mSheetMore;
  private TextView mTvName;
  private TextView mTvPersonInfo;
  
  public GuildProfileHeaderComponent(IGuildComponentController paramIGuildComponentController, GuildProfileData paramGuildProfileData)
  {
    super(paramIGuildComponentController, paramGuildProfileData);
  }
  
  private void bindUI()
  {
    this.mIvMore = ((ImageView)this.mViewContainer.findViewById(2131434711));
    this.mIvAvatar = ((RoundRectImageView)this.mViewContainer.findViewById(2131438057));
    this.mTvName = ((TextView)this.mViewContainer.findViewById(2131438056));
    this.mTvPersonInfo = ((TextView)this.mViewContainer.findViewById(2131434759));
    this.mLlProfileHeaderContainer = this.mViewContainer.findViewById(2131434686);
    this.mLlBaseInfo = this.mViewContainer.findViewById(2131434684);
    this.mTvName.getPaint().setFakeBoldText(true);
    this.mIvMore.setOnClickListener(this);
  }
  
  private void bindViewModel()
  {
    this.mHeaderVModel = ((GuildProfileHeaderViewModel)ViewModelProviderHelper.a(this.mFragment, GuildProfileHeaderViewModel.a).get(GuildProfileHeaderViewModel.class));
    this.mHeaderVModel.a(this.mData.getGuildBaseProfileData());
    this.mHeaderVModel.a(this.mApp);
    this.mHeaderVModel.b().observe(this.mFragment, new -..Lambda.GuildProfileHeaderComponent.SUJJuwpH09bgc_vA_G8YIwobInI(this));
    this.mHeaderVModel.c().observe(this.mFragment, new -..Lambda.GuildProfileHeaderComponent.6T_aXjDup3cnx92UJK34dZGCZbQ(this));
  }
  
  private void concatPersonInfo(GuildHeaderData paramGuildHeaderData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramGuildHeaderData.c();
    if (i == 1) {
      localStringBuilder.append("男 ");
    } else if (i == 2) {
      localStringBuilder.append("女 ");
    }
    i = paramGuildHeaderData.d();
    if (i > 0)
    {
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
    }
    String str = paramGuildHeaderData.e();
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append(str);
    }
    long l = paramGuildHeaderData.f();
    if (l > 0L)
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(" | ");
      }
      localStringBuilder.append("加入频道");
      localStringBuilder.append(l);
      localStringBuilder.append("天");
    }
    else if (l == 0L)
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(" | ");
      }
      localStringBuilder.append("刚刚加入频道");
    }
    paramGuildHeaderData = localStringBuilder.toString();
    if (TextUtils.isEmpty(paramGuildHeaderData))
    {
      this.mLlBaseInfo.setVisibility(8);
      return;
    }
    this.mLlBaseInfo.setVisibility(0);
    this.mTvPersonInfo.setText(paramGuildHeaderData);
  }
  
  private void dismiss()
  {
    getComponentController().a();
  }
  
  private String getLiveChannelContentId(QBaseActivity paramQBaseActivity, String paramString1, String paramString2)
  {
    paramQBaseActivity = ((IGPSService)paramQBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelInfo(paramString1);
    long l;
    if (paramQBaseActivity != null) {
      l = paramQBaseActivity.getLiveRoomId();
    } else {
      l = 0L;
    }
    paramQBaseActivity = new StringBuilder();
    paramQBaseActivity.append("channel_id=");
    paramQBaseActivity.append(paramString1);
    paramQBaseActivity.append("|tinyid=");
    paramQBaseActivity.append(paramString2);
    paramString1 = paramQBaseActivity.toString();
    paramQBaseActivity = paramString1;
    if (l != 0L)
    {
      paramQBaseActivity = new StringBuilder();
      paramQBaseActivity.append(paramString1);
      paramQBaseActivity.append("|roomid=");
      paramQBaseActivity.append(l);
      paramQBaseActivity = paramQBaseActivity.toString();
    }
    return paramQBaseActivity;
  }
  
  private int getReportUserMasterType()
  {
    if (this.mHeaderVModel.d().d().equals(this.mHeaderVModel.d().c())) {
      return 1;
    }
    return 0;
  }
  
  private void handleReportClick(QBaseActivity paramQBaseActivity, View paramView)
  {
    if (this.mHeaderVModel.d() == null)
    {
      QLog.i("GuildProfileHeaderComponent", 2, "mData is null.");
      return;
    }
    GuildBaseProfileData localGuildBaseProfileData = this.mHeaderVModel.d();
    int i = localGuildBaseProfileData.e();
    Object localObject;
    if (i == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("roomid=");
      ((StringBuilder)localObject).append(localGuildBaseProfileData.i());
      ((StringBuilder)localObject).append("|tinyid=");
      ((StringBuilder)localObject).append(localGuildBaseProfileData.c());
      localObject = ((StringBuilder)localObject).toString();
      ((IQQGuildJubaoApi)QRoute.api(IQQGuildJubaoApi.class)).reportGuild(paramQBaseActivity, localGuildBaseProfileData.a(), localGuildBaseProfileData.i(), 25090, localGuildBaseProfileData.c(), (String)localObject);
    }
    else if (i == 2)
    {
      localObject = getLiveChannelContentId(paramQBaseActivity, localGuildBaseProfileData.i(), localGuildBaseProfileData.c());
      ((IQQGuildJubaoApi)QRoute.api(IQQGuildJubaoApi.class)).reportGuild(paramQBaseActivity, localGuildBaseProfileData.a(), localGuildBaseProfileData.i(), 25098, localGuildBaseProfileData.c(), (String)localObject);
    }
    else
    {
      ((IQQGuildJubaoApi)QRoute.api(IQQGuildJubaoApi.class)).reportGuild(paramQBaseActivity, localGuildBaseProfileData.a(), localGuildBaseProfileData.i(), localGuildBaseProfileData.c());
    }
    dismiss();
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramView, "em_sgrp_report", null);
    VideoReport.reportEvent("clck", paramView, null);
  }
  
  private void refreshUI(GuildHeaderData paramGuildHeaderData)
  {
    setAvatar(paramGuildHeaderData.a());
    this.mTvName.setText(paramGuildHeaderData.b());
    concatPersonInfo(paramGuildHeaderData);
    paramGuildHeaderData = this.mHeaderVModel.d().d();
    int i = this.mHeaderVModel.d().g();
    String str = this.mHeaderVModel.d().c();
    int j = this.mHeaderVModel.d().h();
    if (paramGuildHeaderData.equals(str))
    {
      QQGuildUIUtil.a(false, 0, this.mLlProfileHeaderContainer, this.mFragment.getResources());
      this.mIvMore.setVisibility(8);
      return;
    }
    if (((i == 1) || (i == 2)) && (j == 0)) {
      return;
    }
    if ((i == 2) && (j == 1)) {
      return;
    }
    QQGuildUIUtil.a(false, 0, this.mLlProfileHeaderContainer, this.mFragment.getResources());
  }
  
  private void setAvatar(String paramString)
  {
    paramString = ((IQQGuildAvatarApi)this.mApp.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(paramString, 0, true);
    this.mIvAvatar.setBackgroundDrawable(paramString);
  }
  
  private void setDtPage(View paramView, boolean paramBoolean)
  {
    VideoReport.setPageId(paramView, "pg_sgrp_profile");
    HashMap localHashMap = new HashMap();
    localHashMap.put("pgid", "pg_sgrp_profile");
    if (this.mHeaderVModel.d() == null)
    {
      localHashMap.put("sgrp_user_type", Integer.valueOf(QQGuildDTConstant.a(this.mHeaderVModel.d().g())));
      localHashMap.put("sgrp_user_master", Integer.valueOf(getReportUserMasterType()));
      localHashMap.put("sgrp_profile_scene", Integer.valueOf(this.mHeaderVModel.d().f()));
      localHashMap.put("sgrp_channel_id", this.mHeaderVModel.d().a());
      localHashMap.put("sgrp_profile_userid", this.mHeaderVModel.d().c());
    }
    VideoReport.setPageParams(paramView, new PageParams(localHashMap));
    String str;
    if (paramBoolean) {
      str = "pgin";
    } else {
      str = "pgout";
    }
    VideoReport.reportEvent(str, paramView, localHashMap);
  }
  
  private void showMoreView()
  {
    if (this.mSheetMore == null)
    {
      this.mSheetMore = ActionSheet.create(this.mFragment.getContext());
      this.mSheetMore.addButton(2131890556, 7, 2131434725);
      this.mSheetMore.getActionContentView().setBackgroundColor(2131166203);
      this.mSheetMore.setOnButtonClickListener(new -..Lambda.GuildProfileHeaderComponent.qmnzxDJenwcLFemaLvrxU_H1YEM(this));
      this.mSheetMore.addCancelButton(this.mFragment.getResources().getString(2131887648));
    }
    this.mSheetMore.show();
  }
  
  public String getComponentName()
  {
    return "GuildProfileHeaderComponent";
  }
  
  public int getComponentType()
  {
    return 1000;
  }
  
  public int getContentLayoutId()
  {
    return 2131625107;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131434711) {
      showMoreView();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Fragment paramFragment, AppInterface paramAppInterface, Bundle paramBundle)
  {
    super.onCreate(paramFragment, paramAppInterface, paramBundle);
    if (QLog.isColorLevel())
    {
      paramFragment = new StringBuilder();
      paramFragment.append("onCreate viewContainer : ");
      paramFragment.append(this.mViewContainer);
      QLog.i("GuildProfileHeaderComponent", 1, paramFragment.toString());
    }
    bindUI();
  }
  
  public void onDestroy()
  {
    setDtPage(getComponentController().getDelegate().a(), false);
    GuildProfileHeaderViewModel localGuildProfileHeaderViewModel = this.mHeaderVModel;
    if (localGuildProfileHeaderViewModel != null) {
      localGuildProfileHeaderViewModel.a();
    }
    dismiss();
  }
  
  public void onInitData(GuildProfileData paramGuildProfileData)
  {
    if (QLog.isColorLevel())
    {
      paramGuildProfileData = new StringBuilder();
      paramGuildProfileData.append("onInitData viewContainer : ");
      paramGuildProfileData.append(this.mViewContainer);
      QLog.i("GuildProfileHeaderComponent", 1, paramGuildProfileData.toString());
    }
    if (this.mHeaderVModel == null)
    {
      bindViewModel();
      setDtPage(this.mComponentController.getDelegate().a(), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.main.GuildProfileHeaderComponent
 * JD-Core Version:    0.7.0.1
 */