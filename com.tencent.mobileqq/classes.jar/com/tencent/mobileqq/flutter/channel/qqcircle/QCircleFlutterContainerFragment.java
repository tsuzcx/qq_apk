package com.tencent.mobileqq.flutter.channel.qqcircle;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import aumv;
import com.qflutter.qqcircle.TencentQQCirclePlugin;
import com.tencent.mobileqq.flutter.container.QFlutterContainerFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;

public class QCircleFlutterContainerFragment
  extends QFlutterContainerFragment
{
  QCircleBroadcastReceiver a;
  
  private void a(View paramView)
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(paramView, "small_world_base");
    VideoReport.setPageParams(paramView, new QCircleDTParamBuilder().setPageSubclass("QCircleFlutterContainerFragment").buildPageParams());
    QLog.i("QCircleFlutterContainerFragment", 1, "reportDaTongRegister  subPage: QCircleFlutterContainerFragment");
  }
  
  public boolean onBackEvent()
  {
    TencentQQCirclePlugin.sendEvent("tencent_qqcircle/back_event", null);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getActivity().getIntent() != null) {
      aumv.a(getActivity().getIntent().getByteArrayExtra("report_session"));
    }
    this.a = new QCircleBroadcastReceiver();
    paramBundle = new IntentFilter();
    paramBundle.addAction("action_update_web_user_follow_state");
    getActivity().registerReceiver(this.a, paramBundle);
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
    getActivity().unregisterReceiver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.qqcircle.QCircleFlutterContainerFragment
 * JD-Core Version:    0.7.0.1
 */