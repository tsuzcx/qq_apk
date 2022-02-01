package com.tencent.mobileqq.flutter.channel.qqcircle;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.qflutter.qqcircle.TencentQQCirclePlugin;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.flutter.container.QFlutterContainerDelegate;
import com.tencent.mobileqq.flutter.container.QFlutterContainerFragment;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;

public class QCircleFlutterContainerFragment
  extends QFlutterContainerFragment
{
  QCircleBroadcastReceiver jdField_a_of_type_ComTencentMobileqqFlutterChannelQqcircleQCircleBroadcastReceiver;
  private String jdField_a_of_type_JavaLangString = "0";
  
  private void a(View paramView)
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      VideoReport.addToDetectionWhitelist(getActivity());
      String str = getActivity().getIntent().getStringExtra("page_name");
      if (TextUtils.equals(str, "QQCirSearchDetailWidget")) {
        str = "pg_xsj_search_page";
      } else if (TextUtils.equals(str, "QQCircleFloatLayer")) {
        str = "pg_xsj_layer_page";
      } else {
        str = "small_world_base";
      }
      VideoReport.setPageId(paramView, str);
      VideoReport.setPageParams(paramView, new QCircleDTParamBuilder().buildPageParams("QCircleFlutterContainerFragment"));
      QLog.i("QCircleFlutterContainerFragment", 1, "reportDaTongRegister  subPage: QCircleFlutterContainerFragment");
      return;
    }
    QLog.e("QCircleFlutterContainerFragment", 1, "reportDaTongRegister  getActivity() == null || getActivity().getIntent() == null");
  }
  
  @Nullable
  public View a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate != null) && (this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.b()))
    {
      View localView = new View(getContext());
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
    if (getQBaseActivity().getIntent() != null)
    {
      paramBundle = getQBaseActivity().getIntent();
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("qcircle_flutter_page_back_behavior");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = "0";
      }
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).setFlutterLauncherParams(paramBundle);
    }
    this.jdField_a_of_type_ComTencentMobileqqFlutterChannelQqcircleQCircleBroadcastReceiver = new QCircleBroadcastReceiver();
    paramBundle = new IntentFilter();
    paramBundle.addAction("action_update_web_user_follow_state");
    getQBaseActivity().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelQqcircleQCircleBroadcastReceiver, paramBundle);
    if ((getActivity() != null) && (getActivity().getIntent() != null) && (TextUtils.equals(getActivity().getIntent().getStringExtra("page_name"), "QQCirEditProfileWidget"))) {
      ((IQQBaseService)QRoute.api(IQQBaseService.class)).attachConditionSearchManager();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    QLog.d("QCircleFlutterContainerFragment", 4, "QCircleFlutterContainerFragment qcircle_flutter_activity_destroy");
    getQBaseActivity().sendBroadcast(new Intent("qcircle_flutter_activity_destroy"));
    super.onDestroy();
    getQBaseActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelQqcircleQCircleBroadcastReceiver);
    if ((getActivity() != null) && (getActivity().getIntent() != null) && (TextUtils.equals(getActivity().getIntent().getStringExtra("page_name"), "QQCirEditProfileWidget"))) {
      ((IQQBaseService)QRoute.api(IQQBaseService.class)).detachConditionSearchManager();
    }
  }
  
  public void onResume()
  {
    getQBaseActivity().sendBroadcast(new Intent("qcircle_flutter_activity_resume"));
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.qqcircle.QCircleFlutterContainerFragment
 * JD-Core Version:    0.7.0.1
 */