package com.tencent.mobileqq.location.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import awpk;
import awpq;
import awqa;
import awql;
import awsk;
import awtd;
import awte;
import awtg;
import awuo;
import bdll;
import bhnv;
import blqj;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.os.MqqHandler;

public class LocationShareFragment
  extends PublicBaseFragment
{
  private static long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private awpk jdField_a_of_type_Awpk;
  private awsk jdField_a_of_type_Awsk;
  private HeadSetView jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  
  private void a()
  {
    boolean bool = true;
    this.jdField_a_of_type_Awsk = new awsk(getActivity().app);
    Object localObject = getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("FROM_KEY", -1);
    awpq.a(getActivity().app).a(i);
    String str = ((Intent)localObject).getStringExtra("uin");
    int j = ((Intent)localObject).getIntExtra("uintype", -1);
    this.jdField_a_of_type_Awpk = new awpk(j, str);
    localObject = this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView;
    awsk localawsk = this.jdField_a_of_type_Awsk;
    awpk localawpk = this.jdField_a_of_type_Awpk;
    if (i == 1) {}
    for (;;)
    {
      ((HeadSetView)localObject).setLocationController(localawsk, localawpk, bool);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370377);
      ((TextView)localObject).setOnClickListener(new awtd(this, j, str));
      if (!blqj.a()) {
        break;
      }
      ((TextView)localObject).setBackgroundResource(2130840572);
      return;
      bool = false;
    }
    ((TextView)localObject).setBackgroundResource(2130840575);
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
    if (awtg.a(paramActivity) <= 0)
    {
      QQToast.a(paramActivity, 1, paramActivity.getString(2131693995), 1).a();
      return;
    }
    awqa localawqa = awpq.a(((BaseActivity)paramActivity).app).a;
    if (!localawqa.a(paramString, paramInt1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareFragment", 2, new Object[] { "[location_fragment]launch: invoked. ", " notSameSession: ", Boolean.valueOf(bool) });
      }
      if (localawqa.a()) {
        break label210;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareFragment", 2, new Object[] { "launch: invoked. not reporting ", " from: ", Integer.valueOf(paramInt2) });
      }
      if (paramInt2 == 1) {
        break;
      }
      awql.a(paramActivity, paramInt1, paramString, paramInt2);
      return;
    }
    b(paramActivity, paramInt1, paramString, paramInt2);
    return;
    label210:
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, new Object[] { "launch: invoked. reporting ", " from: ", Integer.valueOf(paramInt2) });
    }
    if (bool)
    {
      awql.a((BaseActivity)paramActivity, paramInt1, paramString, paramInt2);
      return;
    }
    b(paramActivity, paramInt1, paramString, paramInt2);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = ((MapWidget)this.jdField_a_of_type_AndroidViewView.findViewById(2131370362));
    awtg.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget, "地图 你正在共享位置");
    Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370369);
    awtg.a((View)localObject, "在地图区回到我的位置");
    this.jdField_a_of_type_Awsk.a(getActivity(), this.jdField_a_of_type_Awpk, this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget, this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView.a, (ImageView)localObject, this.jdField_a_of_type_AndroidViewView.findViewById(2131370376), this.jdField_a_of_type_AndroidViewView.findViewById(2131370377), this.jdField_a_of_type_AndroidViewView.findViewById(2131363610));
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131365265);
    if (blqj.a()) {
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      awuo.a(getActivity().app).a(1);
      bdll.b(null, "CliOper", "", "", "0X800A8BA", "0X800A8BA", 0, 0, "", "0", "0", "");
      return;
      ((View)localObject).setVisibility(8);
    }
  }
  
  public static void b(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("FROM_KEY", paramInt2);
    localIntent.putExtra("FRAGMENT_KEY", "LocationShareFragment");
    PublicFragmentActivity.a(paramActivity, localIntent, LocationShareFragment.class);
  }
  
  private void c()
  {
    a();
    b();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
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
      this.jdField_a_of_type_Awsk.a(paramIntent);
    }
    label72:
    label89:
    while (paramInt2 != 1)
    {
      return;
      QQToast.a(getActivity(), 1, 2131693417, 1).a();
      return;
    }
    getActivity().finish();
  }
  
  public boolean onBackEvent()
  {
    getActivity().overridePendingTransition(0, 2130772039);
    FragmentActivity localFragmentActivity = getActivity();
    if (awuo.a(localFragmentActivity.app).a(localFragmentActivity, this.jdField_a_of_type_Awpk)) {
      return super.onBackEvent();
    }
    return true;
  }
  
  @SuppressLint({"InflateParams"})
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onCreateView: invoked. this: " + this + " activity: " + getActivity());
    }
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559183, null);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView = ((HeadSetView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367939));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView.a();
    getActivity().overridePendingTransition(2130772037, 17432577);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onDestroy: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareFragment", 2, "[location_fragment]onFinish: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.overridePendingTransition(0, 2130772039);
    }
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
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity.isFinishing())
    {
      awtg.a();
      ThreadManager.getUIHandler().postDelayed(new LocationShareFragment.4(this, localFragmentActivity), 200L);
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
    awpq localawpq = awpq.a(getActivity().app);
    if ((this.jdField_a_of_type_Awpk != null) && (localawpq.a.a(this.jdField_a_of_type_Awpk))) {
      localawpq.c(this.jdField_a_of_type_Awpk.a(), this.jdField_a_of_type_Awpk.a());
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
    if (!bhnv.a()) {
      awql.a(paramView, i, j, str);
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView.requestPermissions(new awte(this, paramView, j, str, i), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    c();
  }
  
  public boolean overrideFinish()
  {
    boolean bool = super.overrideFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.overridePendingTransition(0, 2130772039);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareFragment
 * JD-Core Version:    0.7.0.1
 */