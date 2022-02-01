package com.tencent.mobileqq.troop.activity;

import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.theme.SkinnableBitmapDrawable;

public class AudioRecordFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  protected CommonRecordSoundPanel a;
  protected View b;
  protected QQAppInterface c;
  protected RelativeLayout d;
  protected View e;
  protected AudioInfo f = null;
  protected RelativeLayout g = null;
  public String h = null;
  public int i = 0;
  public String j = null;
  public String k = null;
  protected boolean l = true;
  protected Handler m = new AudioRecordFragment.2(this);
  
  protected void a(Resources paramResources, View paramView)
  {
    paramResources = paramResources.getDrawable(2130852413);
    if ((paramResources instanceof BitmapDrawable)) {
      paramResources = ((BitmapDrawable)paramResources).getBitmap();
    } else if ((paramResources instanceof SkinnableBitmapDrawable)) {
      paramResources = ((SkinnableBitmapDrawable)paramResources).getBitmap();
    } else {
      paramResources = null;
    }
    paramResources = new BitmapDrawable(paramResources);
    paramResources.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    paramResources.setDither(true);
    paramView.setBackgroundDrawable(paramResources);
  }
  
  public boolean onBackEvent()
  {
    boolean bool = this.a.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onBackEvent() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    this.a.b();
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131447813) && (this.l))
    {
      getBaseActivity().setResult(0);
      getBaseActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = paramLayoutInflater.inflate(2131625949, null);
    this.c = getBaseActivity().app;
    this.g = ((RelativeLayout)this.b.findViewById(2131445137));
    this.i = getArguments().getInt("audio_max_length", 60000);
    boolean bool = getArguments().getBoolean("auto_start", false);
    this.h = getArguments().getString("from");
    paramViewGroup = this.h;
    if ((paramViewGroup != null) && (paramViewGroup.equals("publish")))
    {
      this.j = getArguments().getString("bid");
      this.k = getArguments().getString("fromflag");
    }
    this.l = getArguments().getBoolean("click_space_cancel", true);
    this.d = ((RelativeLayout)this.b.findViewById(2131428845));
    a(getResources(), this.d);
    ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).stopRecord("audio record");
    this.a = ((CommonRecordSoundPanel)paramLayoutInflater.inflate(2131625892, null));
    this.a.setPresenter(((IAudioPanelPresenterCreater)QRoute.api(IAudioPanelPresenterCreater.class)).createCommonRecordSoundPanelPresenter(this.a));
    this.d.addView(this.a);
    this.a.a(this.c, getBaseActivity(), this.m, 1, bool);
    this.a.e();
    this.a.setTimeOutTime(this.i);
    this.e = this.b.findViewById(2131447813);
    this.e.setOnClickListener(this);
    paramLayoutInflater = AnimationUtils.loadAnimation(getBaseActivity(), 2130771996);
    paramLayoutInflater.setAnimationListener(new AudioRecordFragment.1(this));
    this.g.startAnimation(paramLayoutInflater);
    paramLayoutInflater = this.b;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    boolean bool = this.a.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onDestroy() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    this.a.d();
    ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).startRecord("audio record");
  }
  
  public void onFinish()
  {
    getBaseActivity().overridePendingTransition(0, 0);
  }
  
  public void onPause()
  {
    super.onPause();
    boolean bool = this.a.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onPause() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AudioRecordFragment
 * JD-Core Version:    0.7.0.1
 */