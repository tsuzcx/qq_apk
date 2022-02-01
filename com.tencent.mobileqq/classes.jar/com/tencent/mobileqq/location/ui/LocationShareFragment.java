package com.tencent.mobileqq.location.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.QFragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.net.ReportLocationHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class LocationShareFragment
  extends QPublicBaseFragment
{
  private static long jdField_a_of_type_Long = 0L;
  private View jdField_a_of_type_AndroidViewView;
  private LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  private HeadSetView jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView;
  private LocationShareController jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController = new LocationShareController((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    Object localObject = getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("FROM_KEY", -1);
    LocationHandler.a().a(i);
    String str = ((Intent)localObject).getStringExtra("uin");
    int j = ((Intent)localObject).getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = new LocationRoom.RoomKey(j, str);
    localObject = this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView;
    LocationShareController localLocationShareController = this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController;
    LocationRoom.RoomKey localRoomKey = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((HeadSetView)localObject).setLocationController(localLocationShareController, localRoomKey, bool);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370812);
      ((TextView)localObject).setOnClickListener(new LocationShareFragment.1(this, j, str));
      if (!QQUIDelegate.b()) {
        break;
      }
      ((TextView)localObject).setBackgroundResource(2130840777);
      return;
    }
    ((TextView)localObject).setBackgroundResource(2130840780);
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareFragment", 2, new Object[] { "launch: invoked. ", " sLastLaunchTime: ", Long.valueOf(jdField_a_of_type_Long) });
      }
      return;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (MapUtils.a(paramActivity) <= 0)
    {
      QQToast.a(paramActivity, 1, paramActivity.getString(2131694496), 1).a();
      return;
    }
    ReportLocationHandler localReportLocationHandler = LocationHandler.a().a;
    if (!localReportLocationHandler.a(paramString, paramInt1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareFragment", 2, new Object[] { "[location_fragment]launch: invoked. ", " notSameSession: ", Boolean.valueOf(bool) });
      }
      if (localReportLocationHandler.a()) {
        break label203;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareFragment", 2, new Object[] { "launch: invoked. not reporting ", " from: ", Integer.valueOf(paramInt2) });
      }
      if (paramInt2 == 1) {
        break;
      }
      LocationDialogUtil.a(paramActivity, paramInt1, paramString, paramInt2);
      return;
    }
    a(paramActivity, paramInt1, paramString, paramInt2);
    return;
    label203:
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, new Object[] { "launch: invoked. reporting ", " from: ", Integer.valueOf(paramInt2) });
    }
    if (bool)
    {
      LocationDialogUtil.b(paramActivity, paramInt1, paramString, paramInt2);
      return;
    }
    a(paramActivity, paramInt1, paramString, paramInt2);
  }
  
  static void a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("FROM_KEY", paramInt2);
    localIntent.putExtra("FRAGMENT_KEY", "LocationShareFragment");
    if (!(paramContext instanceof Activity)) {
      localIntent.setFlags(268435456);
    }
    QPublicFragmentActivity.a(paramContext, localIntent, LocationShareFragment.class);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = ((MapWidget)this.jdField_a_of_type_AndroidViewView.findViewById(2131370796));
    MapUtils.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget, "地图 你正在共享位置");
    Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370803);
    MapUtils.a((View)localObject, "在地图区回到我的位置");
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey, this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget, this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView.a, (ImageView)localObject, this.jdField_a_of_type_AndroidViewView.findViewById(2131370811), this.jdField_a_of_type_AndroidViewView.findViewById(2131370812), this.jdField_a_of_type_AndroidViewView.findViewById(2131363804));
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131365535);
    if (QQUIDelegate.b()) {
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      ((IFloatMapService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "")).quitFloat(1);
      ReportController.b(null, "CliOper", "", "", "0X800A8BA", "0X800A8BA", 0, 0, "", "0", "0", "");
      return;
      ((View)localObject).setVisibility(8);
    }
  }
  
  private void c()
  {
    a();
    b();
  }
  
  public boolean c()
  {
    getActivity().overridePendingTransition(0, 2130772045);
    QFragmentActivity localQFragmentActivity = getActivity();
    if (((IFloatMapService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "")).enterFloat(localQFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey)) {
      return super.c();
    }
    return true;
  }
  
  public boolean d_()
  {
    return false;
  }
  
  public boolean f()
  {
    return false;
  }
  
  public boolean h()
  {
    boolean bool = super.h();
    QFragmentActivity localQFragmentActivity = getActivity();
    if (localQFragmentActivity != null) {
      localQFragmentActivity.overridePendingTransition(0, 2130772045);
    }
    return bool;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onFinish: invoked. this: " + this + " activity: " + getActivity());
    }
    super.i();
    QFragmentActivity localQFragmentActivity = getActivity();
    if (localQFragmentActivity != null) {
      localQFragmentActivity.overridePendingTransition(0, 2130772045);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.c();
      if (paramInt2 != -1) {
        break label89;
      }
      paramIntent = (LocationRoom.Venue)paramIntent.getParcelableExtra("key_picked_location");
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareFragment", 2, "[venue] share fragment onActivityResult: venue: " + paramIntent);
      }
      if (paramIntent == null) {
        break label72;
      }
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController.a(paramIntent);
    }
    label72:
    label89:
    while (paramInt2 != 1)
    {
      return;
      QQToast.a(getActivity(), 1, 2131693862, 1).a();
      return;
    }
    getActivity().finish();
  }
  
  @SuppressLint({"InflateParams"})
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onCreateView: invoked. this: " + this + " activity: " + getActivity());
    }
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559255, null);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView = ((HeadSetView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368328));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView.a();
    getActivity().overridePendingTransition(2130772043, 17432577);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onDestroy: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onPause: invoked. this: " + this + " isFinishing: " + getActivity().isFinishing() + " activity: " + getActivity());
    }
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.b(false);
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onPause();
    }
    if (getActivity().isFinishing())
    {
      MapUtils.a();
      ThreadManager.getUIHandler().postDelayed(new LocationShareFragment.4(this), 200L);
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onResume: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.b(true);
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onResume();
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView.b();
    LocationHandler localLocationHandler = LocationHandler.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey != null) && (localLocationHandler.a.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey))) {
      localLocationHandler.c(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a());
    }
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onStart: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onStart();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onStart();
    }
    ThreadManager.getSubThreadHandler().post(new LocationShareFragment.3(this));
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onStop: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onStop();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onViewCreated: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onViewCreated(paramView, paramBundle);
    paramView = getActivity();
    paramBundle = paramView.getIntent();
    int i = paramBundle.getIntExtra("FROM_KEY", -1);
    String str = paramBundle.getStringExtra("uin");
    int j = paramBundle.getIntExtra("uintype", -1);
    if (!NetworkUtil.a()) {
      LocationDialogUtil.a(paramView, i, j, str);
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView.requestPermissions(new LocationShareFragment.2(this, paramView, j, str, i), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareFragment
 * JD-Core Version:    0.7.0.1
 */