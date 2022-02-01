package com.tencent.mobileqq.guild.live.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveRoomCommMgr;
import com.tencent.mobileqq.guild.window.GuildFloatWindowManager;
import com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenReporter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class CloseLiveRoomConfirmFragment
  extends QPublicBaseFragment
{
  private void a()
  {
    Object localObject = getContext().getString(2131890431);
    String str1 = getContext().getString(2131890432);
    String str2 = getContext().getString(2131890433);
    localObject = DialogUtil.a(getContext(), 230, null, (CharSequence)localObject, str1, str2, new CloseLiveRoomConfirmFragment.1(this), new CloseLiveRoomConfirmFragment.2(this));
    ((QQCustomDialog)localObject).setOnDismissListener(new CloseLiveRoomConfirmFragment.3(this));
    ((QQCustomDialog)localObject).show();
  }
  
  private void b()
  {
    QQGuildLiveRoomCommMgr.a().e();
    GuildFloatWindowManager.a.a(GuildLiveChannelFloatWrapper.class.getName());
    FloatingScreenReporter.d();
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131625064, paramViewGroup, false);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onFinish()
  {
    super.onFinish();
    getQBaseActivity().overridePendingTransition(2130772007, 0);
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.CloseLiveRoomConfirmFragment
 * JD-Core Version:    0.7.0.1
 */