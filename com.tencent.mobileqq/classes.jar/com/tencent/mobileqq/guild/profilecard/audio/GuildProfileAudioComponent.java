package com.tencent.mobileqq.guild.profilecard.audio;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Map;

public class GuildProfileAudioComponent
  extends AbsGuildProfileComponent
  implements View.OnClickListener
{
  private static final String TAG = "GuildProfileAudioComponent";
  private GuildProfileAudioViewModel mAudioViewModel;
  private ViewGroup mLlAudioArea;
  private RelativeLayout mMuteControl;
  private ImageView mMuteControlImage;
  private TextView mMuteControlText;
  private RelativeLayout mRemoveChannelControl;
  private View mTvAudioArea;
  private RelativeLayout mVoiceControl;
  private ImageView mVoiceControlImage;
  private TextView mVoiceControlText;
  
  public GuildProfileAudioComponent(IGuildComponentController paramIGuildComponentController, GuildProfileData paramGuildProfileData)
  {
    super(paramIGuildComponentController, paramGuildProfileData);
  }
  
  private void bindUI()
  {
    this.mLlAudioArea = ((ViewGroup)this.mViewContainer.findViewById(2131434676));
    this.mTvAudioArea = this.mViewContainer.findViewById(2131434738);
    this.mVoiceControl = ((RelativeLayout)this.mViewContainer.findViewById(2131440701));
    this.mVoiceControlText = ((TextView)this.mViewContainer.findViewById(2131440703));
    this.mVoiceControlImage = ((ImageView)this.mViewContainer.findViewById(2131440702));
    this.mMuteControl = ((RelativeLayout)this.mViewContainer.findViewById(2131440694));
    this.mMuteControlText = ((TextView)this.mViewContainer.findViewById(2131440697));
    this.mMuteControlImage = ((ImageView)this.mViewContainer.findViewById(2131440695));
    this.mRemoveChannelControl = ((RelativeLayout)this.mViewContainer.findViewById(2131440698));
    this.mMuteControl.setOnClickListener(this);
    this.mMuteControlText.setOnClickListener(this);
    this.mMuteControlImage.setOnClickListener(this);
    this.mVoiceControl.setOnClickListener(this);
    this.mVoiceControlText.setOnClickListener(this);
    this.mVoiceControlImage.setOnClickListener(this);
    this.mRemoveChannelControl.setOnClickListener(this);
  }
  
  private void bindViewModel()
  {
    this.mAudioViewModel = ((GuildProfileAudioViewModel)ViewModelProviderHelper.a(this.mFragment, GuildProfileAudioViewModel.a).get(GuildProfileAudioViewModel.class));
    this.mAudioViewModel.a(this.mData.getGuildBaseProfileData());
    this.mAudioViewModel.a(this.mApp);
    this.mAudioViewModel.i().observe(this.mFragment, new GuildProfileAudioComponent.1(this));
    this.mAudioViewModel.g().observe(this.mFragment, new GuildProfileAudioComponent.2(this));
    this.mAudioViewModel.f().observe(this.mFragment, new GuildProfileAudioComponent.3(this));
    this.mAudioViewModel.e().observe(this.mFragment, new GuildProfileAudioComponent.4(this));
    this.mAudioViewModel.h().observe(this.mFragment, new GuildProfileAudioComponent.5(this));
  }
  
  private void dismiss()
  {
    getComponentController().a();
  }
  
  private void onClickMuteInGuild(View paramView)
  {
    Object localObject = this.mAudioViewModel.j().a();
    String str1 = ((GuildAudioChannelData)this.mAudioViewModel.e().getValue()).a();
    String str2 = ((GuildAudioChannelData)this.mAudioViewModel.e().getValue()).d();
    boolean bool = ((GuildAudioChannelData)this.mAudioViewModel.e().getValue()).g();
    int i = 1;
    bool ^= true;
    if (QLog.isColorLevel()) {
      QLog.i("GuildProfileAudioComponent", 2, String.format("setUserMuteSeatInGuild, guildId[%s], channelId[%s], tinyId[%s], bMute[%s]", new Object[] { localObject, str1, str2, Boolean.valueOf(bool) }));
    }
    localObject = new HashMap();
    if (bool) {
      i = 2;
    }
    ((HashMap)localObject).put("sgrp_voicechannel_profile_mute_condition", Integer.valueOf(i));
    VideoReport.reportEvent("clck", paramView, (Map)localObject);
    this.mAudioViewModel.c();
  }
  
  private void setDtElement(View paramView1, View paramView2, View paramView3)
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramView1, "em_sgrp_voicechannel_profile_removechannel", null);
    VideoReport.setElementId(paramView2, "em_sgrp_voicechannel_profile_block");
    VideoReport.setElementExposePolicy(paramView2, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(paramView2, ClickPolicy.REPORT_ALL);
    VideoReport.setElementId(paramView3, "em_sgrp_voicechannel_profile_mute");
    VideoReport.setElementExposePolicy(paramView3, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(paramView3, ClickPolicy.REPORT_ALL);
  }
  
  private void showManageProfileCard(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mViewContainer.setVisibility(0);
    this.mLlAudioArea.setVisibility(0);
    this.mTvAudioArea.setVisibility(0);
    this.mVoiceControl.setVisibility(0);
    TextView localTextView;
    int i;
    if (paramBoolean1)
    {
      localTextView = this.mVoiceControlText;
      if (paramBoolean3) {
        i = 2131890243;
      } else {
        i = 2131890244;
      }
      localTextView.setText(i);
      this.mVoiceControlImage.setBackgroundResource(2130840727);
    }
    else
    {
      localTextView = this.mVoiceControlText;
      if (paramBoolean3) {
        i = 2131890264;
      } else {
        i = 2131890265;
      }
      localTextView.setText(i);
      this.mVoiceControlImage.setBackgroundResource(2130840729);
    }
    this.mMuteControl.setVisibility(0);
    if (paramBoolean2)
    {
      localTextView = this.mMuteControlText;
      if (paramBoolean3) {
        i = 2131890268;
      } else {
        i = 2131890269;
      }
      localTextView.setText(i);
      this.mMuteControlImage.setBackgroundResource(2130840730);
    }
    else
    {
      localTextView = this.mMuteControlText;
      if (paramBoolean3) {
        i = 2131890256;
      } else {
        i = 2131890257;
      }
      localTextView.setText(i);
      this.mMuteControlImage.setBackgroundResource(2130840728);
    }
    this.mRemoveChannelControl.setVisibility(0);
  }
  
  private void showMemberProfileCard(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mViewContainer.setVisibility(0);
    this.mLlAudioArea.setVisibility(0);
    this.mTvAudioArea.setVisibility(0);
    this.mVoiceControl.setVisibility(0);
    TextView localTextView;
    int i;
    if (paramBoolean1)
    {
      localTextView = this.mVoiceControlText;
      if (paramBoolean2) {
        i = 2131890243;
      } else {
        i = 2131890244;
      }
      localTextView.setText(i);
      this.mVoiceControlImage.setBackgroundResource(2130840727);
    }
    else
    {
      localTextView = this.mVoiceControlText;
      if (paramBoolean2) {
        i = 2131890264;
      } else {
        i = 2131890265;
      }
      localTextView.setText(i);
      this.mVoiceControlImage.setBackgroundResource(2130840729);
    }
    this.mMuteControl.setVisibility(8);
    this.mRemoveChannelControl.setVisibility(8);
  }
  
  private void showMyselfProfileCard()
  {
    this.mLlAudioArea.setVisibility(8);
    this.mTvAudioArea.setVisibility(8);
    this.mVoiceControl.setVisibility(8);
    this.mMuteControl.setVisibility(8);
    this.mRemoveChannelControl.setVisibility(8);
  }
  
  public String getComponentName()
  {
    return "GuildProfileAudioComponent";
  }
  
  public int getComponentType()
  {
    return 1001;
  }
  
  public int getContentLayoutId()
  {
    return 2131625103;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131440701) && (i != 2131440703) && (i != 2131440702))
    {
      if ((paramView.getId() != 2131440694) && (i != 2131440697) && (i != 2131440695))
      {
        if (paramView.getId() == 2131440698) {
          this.mAudioViewModel.b();
        }
      }
      else {
        onClickMuteInGuild(this.mMuteControl);
      }
    }
    else {
      onClickControlVoice(this.mVoiceControl);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClickControlVoice(View paramView)
  {
    Object localObject = ((GuildAudioChannelData)this.mAudioViewModel.e().getValue()).d();
    boolean bool = ((GuildAudioChannelData)this.mAudioViewModel.e().getValue()).f();
    int i = 1;
    bool ^= true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClickControlVoice, tinyId[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("], bVoiceless[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i("GuildProfileAudioComponent", 2, localStringBuilder.toString());
    }
    localObject = new HashMap();
    if (bool) {
      i = 2;
    }
    ((HashMap)localObject).put("sgrp_voicechannel_profile_block_condition", Integer.valueOf(i));
    VideoReport.reportEvent("clck", paramView, (Map)localObject);
    this.mAudioViewModel.d();
  }
  
  public void onCreate(Fragment paramFragment, AppInterface paramAppInterface, Bundle paramBundle)
  {
    super.onCreate(paramFragment, paramAppInterface, paramBundle);
    bindUI();
  }
  
  public void onDestroy()
  {
    this.mAudioViewModel.a();
  }
  
  public void onInitData(GuildProfileData paramGuildProfileData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInitData viewContainer : ");
      localStringBuilder.append(this.mViewContainer);
      QLog.i("GuildProfileAudioComponent", 1, localStringBuilder.toString());
    }
    if (this.mAudioViewModel == null)
    {
      bindViewModel();
      this.mAudioViewModel.a((GuildAudioChannelData)paramGuildProfileData.getExtras().getParcelable("key_channel_data"));
      setDtElement(this.mRemoveChannelControl, this.mVoiceControl, this.mMuteControl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.audio.GuildProfileAudioComponent
 * JD-Core Version:    0.7.0.1
 */