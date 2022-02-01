package com.tencent.mobileqq.flutter.channel.qqcircle;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import atig;
import atii;
import atio;
import com.tencent.mobileqq.flutter.container.QFlutterContainerFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;

public class QCircleFlutterContainerFragment
  extends QFlutterContainerFragment
{
  QCircleBroadcastReceiver jdField_a_of_type_ComTencentMobileqqFlutterChannelQqcircleQCircleBroadcastReceiver;
  SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  
  private void a()
  {
    int i = getResources().getColor(2131166253);
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(i);
      ImmersiveUtils.a(true, getActivity().getWindow());
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = getActivity().mSystemBarComp;
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact == null)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getActivity(), true, i);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(i);
    ImmersiveUtils.a(true, getActivity().getWindow());
  }
  
  private void a(View paramView)
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(paramView, "small_world_base");
    VideoReport.setPageParams(paramView, new QCircleDTParamBuilder().setPageSubclass("QCircleFlutterContainerFragment").buildPageParams());
    QLog.i("QCircleFlutterContainerFragment", 1, "reportDaTongRegister  subPage: QCircleFlutterContainerFragment");
  }
  
  public boolean onBackEvent()
  {
    atig localatig = atii.a().a("tencent_qqcircle");
    if (!(localatig instanceof atio))
    {
      QLog.e("QCircleFlutterContainerFragment", 1, "[onBackEvent] channel=" + localatig);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleFlutterContainerFragment", 2, "[onBackEvent] dispatch to flutter");
    }
    ((atio)localatig).a("tencent_qqcircle/back_event", null);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getActivity().getIntent() != null) {
      atio.a(getActivity().getIntent().getByteArrayExtra("report_session"));
    }
    this.jdField_a_of_type_ComTencentMobileqqFlutterChannelQqcircleQCircleBroadcastReceiver = new QCircleBroadcastReceiver();
    paramBundle = new IntentFilter();
    paramBundle.addAction("action_update_web_user_follow_state");
    getActivity().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelQqcircleQCircleBroadcastReceiver, paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelQqcircleQCircleBroadcastReceiver);
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.qqcircle.QCircleFlutterContainerFragment
 * JD-Core Version:    0.7.0.1
 */