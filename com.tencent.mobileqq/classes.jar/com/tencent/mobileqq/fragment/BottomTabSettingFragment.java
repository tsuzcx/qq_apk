package com.tencent.mobileqq.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetCircleSwitchRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.widget.QQToast;
import common.config.service.QzoneConfig;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;

public class BottomTabSettingFragment
  extends IphoneTitleBarFragment
{
  private int jdField_a_of_type_Int;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private BottomTabSettingFragment.BottomTabListAdapter jdField_a_of_type_ComTencentMobileqqFragmentBottomTabSettingFragment$BottomTabListAdapter;
  private final HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private static int a()
  {
    boolean bool1 = QzoneConfig.isShowQQCircleMainTabEntrance(StudyModeManager.a());
    boolean bool2 = ReadInJoyHelper.m();
    if (bool1) {
      return 2;
    }
    if (bool2) {
      return 1;
    }
    return 0;
  }
  
  public static String a(Resources paramResources)
  {
    if (paramResources == null) {
      return "";
    }
    switch (a())
    {
    default: 
      return paramResources.getString(2131690766);
    case 1: 
      return paramResources.getString(2131693569);
    }
    return paramResources.getString(2131697845);
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), getResources().getString(2131690766));
    if (!ReadInJoyHelper.j()) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), getResources().getString(2131693569));
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), getResources().getString(2131697845));
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqFragmentBottomTabSettingFragment$BottomTabListAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqFragmentBottomTabSettingFragment$BottomTabListAdapter.notifyDataSetChanged();
      }
      QQToast.a(getActivity(), 2, 2131695013, 2000).a();
      return;
      b(true);
      a(false);
      ReportController.b(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "kandian_clk", 0, 0, "", "", "", "");
      continue;
      b(false);
      a(false);
      ReportController.b(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "no_display_clk", 0, 0, "", "", "", "");
      continue;
      b(false);
      a(true);
      ReportController.b(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "littleworld_clk", 0, 0, "", "", "", "");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    String str;
    if (StudyModeManager.a())
    {
      str = "qqcircle_show_entrance_on_main_tab_on_children_mode";
      if (!paramBoolean) {
        break label53;
      }
    }
    label53:
    for (Object localObject = "1";; localObject = "0")
    {
      localObject = new QCircleSetCircleSwitchRequest("qqcircle", str, (String)localObject);
      VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new BottomTabSettingFragment.1(this, paramBoolean, str));
      return;
      str = "qqcircle_show_entrance_on_main_tab";
      break;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i;
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    QQAppInterface localQQAppInterface;
    String str1;
    if (paramBoolean)
    {
      i = 1;
      ReadInJoyHelper.d(i);
      ReadInJoyHelper.a(paramBoolean);
      ReadInJoyHelper.a(true);
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (!paramBoolean) {
        break label90;
      }
      str1 = "0X8008236";
      label47:
      if (!paramBoolean) {
        break label96;
      }
    }
    label90:
    label96:
    for (String str2 = "0X8008236";; str2 = "0X8008235")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(localQQAppInterface, "CliOper", "", "", str1, str2, 0, 1, "", "", "", "", false);
      return;
      i = 0;
      break;
      str1 = "0X8008235";
      break label47;
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getResources().getText(2131690767));
    a();
    this.jdField_a_of_type_Int = a();
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.mContentView.findViewById(2131363841));
    this.jdField_a_of_type_ComTencentMobileqqFragmentBottomTabSettingFragment$BottomTabListAdapter = new BottomTabSettingFragment.BottomTabListAdapter(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFragmentBottomTabSettingFragment$BottomTabListAdapter);
  }
  
  protected int getContentLayoutId()
  {
    return 2131560838;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.BottomTabSettingFragment
 * JD-Core Version:    0.7.0.1
 */