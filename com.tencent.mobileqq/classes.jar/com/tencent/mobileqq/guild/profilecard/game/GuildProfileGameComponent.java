package com.tencent.mobileqq.guild.profilecard.game;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.widget.GloryOfKingRecordView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;

public class GuildProfileGameComponent
  extends AbsGuildProfileComponent
{
  private static final String TAG = "GuildProfileGameComponent";
  private GuildProfileGameViewModel mGameViewModel;
  private GloryOfKingRecordView mGloryOfKingRecordView;
  private ImageView mIvGameingAvatar;
  private RelativeLayout mRlGameing;
  private TextView mTvGameingDesc;
  private TextView mTvGameingLabel;
  private TextView mTvGameingName;
  
  public GuildProfileGameComponent(IGuildComponentController paramIGuildComponentController, GuildProfileData paramGuildProfileData)
  {
    super(paramIGuildComponentController, paramGuildProfileData);
  }
  
  private void bindUI()
  {
    this.mTvGameingLabel = ((TextView)this.mViewContainer.findViewById(2131434745));
    this.mRlGameing = ((RelativeLayout)this.mViewContainer.findViewById(2131434713));
    this.mIvGameingAvatar = ((ImageView)this.mViewContainer.findViewById(2131434615));
    this.mTvGameingName = ((TextView)this.mViewContainer.findViewById(2131434746));
    this.mTvGameingDesc = ((TextView)this.mViewContainer.findViewById(2131434744));
  }
  
  private void dtViewReport(View paramView, String paramString, boolean paramBoolean)
  {
    VideoReport.setElementId(paramView, paramString);
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
    if (paramBoolean) {
      paramString = "clck";
    } else {
      paramString = "imp";
    }
    VideoReport.reportEvent(paramString, paramView, null);
  }
  
  private void initGloryOfKingView()
  {
    if (this.mGloryOfKingRecordView == null)
    {
      this.mGloryOfKingRecordView = new GloryOfKingRecordView(this.mFragment.getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = ViewUtils.dip2px(11.0F);
      localLayoutParams.leftMargin = ViewUtils.dip2px(16.0F);
      localLayoutParams.rightMargin = localLayoutParams.leftMargin;
      this.mViewContainer.addView(this.mGloryOfKingRecordView, 3, localLayoutParams);
    }
    dtViewReport(this.mRlGameing, "em_sgrp_record", false);
  }
  
  private void initViewModel(GuildProfileData paramGuildProfileData)
  {
    this.mGameViewModel = ((GuildProfileGameViewModel)GuildProfileGameViewModel.a.create(GuildProfileGameViewModel.class));
    this.mGameViewModel.a(paramGuildProfileData.getGuildBaseProfileData());
    this.mGameViewModel.a(this.mApp);
    this.mGameViewModel.b().observe(this.mFragment, new GuildProfileGameComponent.1(this));
    this.mGameViewModel.c().observe(this.mFragment, new GuildProfileGameComponent.2(this));
  }
  
  private void showGameingUI(GuildProfileGameingData paramGuildProfileGameingData)
  {
    this.mTvGameingLabel.setVisibility(0);
    this.mRlGameing.setVisibility(0);
    Object localObject = paramGuildProfileGameingData.a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      int i = ViewUtils.dpToPx(50.0F);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = i;
      localURLDrawableOptions.mRequestHeight = i;
      localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      this.mIvGameingAvatar.setVisibility(0);
      this.mIvGameingAvatar.setImageDrawable((Drawable)localObject);
    }
    localObject = paramGuildProfileGameingData.b();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.mTvGameingName.setVisibility(0);
      this.mTvGameingName.setText((CharSequence)localObject);
    }
    paramGuildProfileGameingData = paramGuildProfileGameingData.c();
    if (!TextUtils.isEmpty(paramGuildProfileGameingData))
    {
      this.mTvGameingDesc.setVisibility(0);
      this.mTvGameingDesc.setText(paramGuildProfileGameingData);
    }
    dtViewReport(this.mRlGameing, "em_sgrp_playing", false);
  }
  
  public String getComponentName()
  {
    return "GuildProfileGameComponent";
  }
  
  public int getComponentType()
  {
    return 1003;
  }
  
  public int getContentLayoutId()
  {
    return 2131625105;
  }
  
  public void onCreate(Fragment paramFragment, AppInterface paramAppInterface, Bundle paramBundle)
  {
    super.onCreate(paramFragment, paramAppInterface, paramBundle);
    bindUI();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mGameViewModel.a();
  }
  
  public void onInitData(GuildProfileData paramGuildProfileData)
  {
    super.onInitData(paramGuildProfileData);
    initViewModel(paramGuildProfileData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.game.GuildProfileGameComponent
 * JD-Core Version:    0.7.0.1
 */