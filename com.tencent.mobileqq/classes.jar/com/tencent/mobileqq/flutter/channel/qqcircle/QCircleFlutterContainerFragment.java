package com.tencent.mobileqq.flutter.channel.qqcircle;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.qflutter.qqcircle.TencentQQCirclePlugin;
import com.tencent.mobileqq.flutter.container.QFlutterContainerDelegate;
import com.tencent.mobileqq.flutter.container.QFlutterContainerFragment;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleDTParamBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class QCircleFlutterContainerFragment
  extends QFlutterContainerFragment
{
  QCircleBroadcastReceiver jdField_a_of_type_ComTencentMobileqqFlutterChannelQqcircleQCircleBroadcastReceiver;
  private String jdField_a_of_type_JavaLangString = "0";
  
  private void a(View paramView)
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(paramView, "small_world_base");
    VideoReport.setPageParams(paramView, new QCircleDTParamBuilder().setPageSubclass("QCircleFlutterContainerFragment").buildPageParams());
    QLog.i("QCircleFlutterContainerFragment", 1, "reportDaTongRegister  subPage: QCircleFlutterContainerFragment");
  }
  
  @Nullable
  public View a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate != null) && (this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.b()))
    {
      View localView = new View(a());
      localView.setBackgroundColor(0);
      return localView;
    }
    return super.a();
  }
  
  public boolean onBackEvent()
  {
    if ("1".equals(this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    TencentQQCirclePlugin.sendEvent("tencent_qqcircle/back_event", null);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getActivity().getIntent() != null)
    {
      paramBundle = getActivity().getIntent();
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("qcircle_flutter_page_back_behavior");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = "0";
      }
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).setFlutterLauncherParams(paramBundle);
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
    QLog.d("QCircleFlutterContainerFragment", 4, "QCircleFlutterContainerFragment qcircle_flutter_activity_destroy");
    getActivity().sendBroadcast(new Intent("qcircle_flutter_activity_destroy"));
    super.onDestroy();
    getActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelQqcircleQCircleBroadcastReceiver);
  }
  
  public void onResume()
  {
    getActivity().sendBroadcast(new Intent("qcircle_flutter_activity_resume"));
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.qqcircle.QCircleFlutterContainerFragment
 * JD-Core Version:    0.7.0.1
 */