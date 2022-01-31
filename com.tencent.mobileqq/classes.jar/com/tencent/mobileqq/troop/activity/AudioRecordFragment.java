package com.tencent.mobileqq.troop.activity;

import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import azdg;
import azdh;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

public class AudioRecordFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  public int a;
  protected Handler a;
  protected View a;
  protected RelativeLayout a;
  public CommonRecordSoundPanel a;
  protected QQAppInterface a;
  public AudioInfo a;
  public String a;
  public View b;
  public RelativeLayout b;
  public String b;
  public String c;
  
  public AudioRecordFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new azdh(this);
  }
  
  protected void a(Resources paramResources, View paramView)
  {
    paramResources = paramResources.getDrawable(2130849167);
    if ((paramResources instanceof BitmapDrawable)) {
      paramResources = ((BitmapDrawable)paramResources).getBitmap();
    }
    for (;;)
    {
      paramResources = new BitmapDrawable(paramResources);
      paramResources.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      paramResources.setDither(true);
      paramView.setBackgroundDrawable(paramResources);
      return;
      if ((paramResources instanceof SkinnableBitmapDrawable)) {
        paramResources = ((SkinnableBitmapDrawable)paramResources).getBitmap();
      } else {
        paramResources = null;
      }
    }
  }
  
  public boolean onBackEvent()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    getActivity().setResult(0);
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559709, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375491));
    this.jdField_a_of_type_Int = getArguments().getInt("audio_max_length", 60000);
    boolean bool = getArguments().getBoolean("auto_start", false);
    this.jdField_a_of_type_JavaLangString = getArguments().getString("from");
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("publish")))
    {
      this.jdField_b_of_type_JavaLangString = getArguments().getString("bid");
      this.c = getArguments().getString("fromflag");
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362850));
    a(getResources(), this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)paramLayoutInflater.inflate(2131559661, null));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_AndroidOsHandler, 1, bool);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377646);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    paramLayoutInflater = AnimationUtils.loadAnimation(getActivity(), 2130771979);
    paramLayoutInflater.setAnimationListener(new azdg(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(paramLayoutInflater);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.e();
  }
  
  public void onFinish()
  {
    getActivity().overridePendingTransition(0, 0);
  }
  
  public void onPause()
  {
    super.onPause();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AudioRecordFragment
 * JD-Core Version:    0.7.0.1
 */