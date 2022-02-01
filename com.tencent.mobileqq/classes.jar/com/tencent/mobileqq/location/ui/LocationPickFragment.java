package com.tencent.mobileqq.location.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.QFragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.net.ReportLocationHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.os.MqqHandler;

public class LocationPickFragment
  extends QPublicBaseFragment
{
  private static long jdField_a_of_type_Long = 0L;
  private View jdField_a_of_type_AndroidViewView;
  private LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  private LocationPickController jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private PoiSlideBottomPanel jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel;
  
  private void a()
  {
    if (QQUIDelegate.b()) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131373327).setBackgroundResource(2130838979);
    }
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString, CameraPosition paramCameraPosition)
  {
    if (!NetworkUtil.a()) {
      QQToast.a(paramActivity, 2131693874, 0).a();
    }
    while (System.currentTimeMillis() - jdField_a_of_type_Long < 1000L) {
      return;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (MapUtils.a(paramActivity) <= 0)
    {
      QQToast.a(paramActivity, 1, paramActivity.getString(2131694496), 1).a();
      return;
    }
    if (!LocationHandler.a().a.a(paramString, paramInt)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationPickFragment", 2, new Object[] { "[location_fragment]launch: invoked. ", " notSameSession: ", Boolean.valueOf(bool) });
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("FRAGMENT_KEY", "LocationPickFragment");
      localIntent.putExtra("key_last_position", paramCameraPosition.target);
      localIntent.putExtra("key_last_zoom", paramCameraPosition.zoom);
      QPublicFragmentActivity.a(paramActivity, localIntent, LocationPickFragment.class, 0);
      return;
    }
  }
  
  private void b()
  {
    c();
    d();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController = new LocationPickController();
    Intent localIntent = getActivity().getIntent();
    String str = localIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = new LocationRoom.RoomKey(localIntent.getIntExtra("uintype", -1), str);
  }
  
  private void d()
  {
    j();
    Object localObject1 = getActivity();
    this.jdField_a_of_type_AndroidViewView.findViewById(2131373338).setOnClickListener(new LocationPickFragment.2(this, (Activity)localObject1));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131373339).setOnClickListener(new LocationPickFragment.3(this, (Activity)localObject1));
    if (QQUIDelegate.b()) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131373339).setBackgroundResource(2130845660);
    }
    k();
    m();
    Object localObject2 = (XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373325);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = ((MapWidget)this.jdField_a_of_type_AndroidViewView.findViewById(2131370796));
    MapUtils.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget, "地图 你正在共享位置");
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370803);
    MapUtils.a(localImageView, "在地图区回到我的位置");
    Object localObject3 = ((Activity)localObject1).getIntent();
    localObject3 = CameraPosition.fromLatLngZoom((LatLng)((Intent)localObject3).getParcelableExtra("key_last_position"), ((Intent)localObject3).getFloatExtra("key_last_zoom", 0.0F));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickController.a((Activity)localObject1, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey, (CameraPosition)localObject3, this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget, localImageView, this.jdField_a_of_type_AndroidViewView.findViewById(2131373339), this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel, (XListView)localObject2, this.jdField_a_of_type_AndroidViewView.findViewById(2131373329), this.jdField_a_of_type_AndroidViewView.findViewById(2131373312));
    localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131365535);
    localObject2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131373320);
    if (QQUIDelegate.b())
    {
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setBackgroundColor(Color.parseColor("#CC000000"));
      return;
    }
    ((View)localObject1).setVisibility(8);
    ((View)localObject2).setBackgroundColor(Color.parseColor("#7F000000"));
  }
  
  private void j()
  {
    LiuHaiUtils.a(getActivity());
    int i = ImmersiveUtils.getStatusBarHeight(getActivity());
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373320);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    int j;
    if (LiuHaiUtils.jdField_a_of_type_Boolean)
    {
      localView.setPadding(DisplayUtil.a(getActivity(), 20.0F), LiuHaiUtils.jdField_a_of_type_Int, DisplayUtil.a(getActivity(), 20.0F), 0);
      j = localLayoutParams.height;
    }
    for (localLayoutParams.height = (i + LiuHaiUtils.jdField_a_of_type_Int + j);; localLayoutParams.height = (i + localLayoutParams.height))
    {
      localView.setLayoutParams(localLayoutParams);
      return;
      localView.setPadding(DisplayUtil.a(getActivity(), 20.0F), i, DisplayUtil.a(getActivity(), 20.0F), 0);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void k()
  {
    getActivity().getWindow().setSoftInputMode(48);
    View localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131373333);
    View localView2 = localView1.findViewById(2131363942);
    localView2.setVisibility(8);
    ((TextView)localView1.findViewById(2131380584)).setText("查找集合地点");
    EditText localEditText = (EditText)localView1.findViewById(2131366452);
    localEditText.setOnKeyListener(new LocationPickFragment.4(this, localEditText));
    localView2.setOnClickListener(new LocationPickFragment.5(this, localEditText));
    localEditText.setImeOptions(3);
    localEditText.setOnHoverListener(new LocationPickFragment.6(this));
    localEditText.setOnTouchListener(new LocationPickFragment.7(this));
    localView1.findViewById(2131368600).setOnClickListener(new LocationPickFragment.8(this, localEditText));
    View localView3 = localView1.findViewById(2131380584);
    localEditText.addTextChangedListener(new LocationPickFragment.9(this, localView3, localView1.findViewById(2131368600), localView2));
    if (QQUIDelegate.b())
    {
      localEditText.setBackgroundDrawable(getActivity().getResources().getDrawable(2130850251));
      ((TextView)localView3).setTextColor(Color.parseColor("#8E8E93"));
      return;
    }
    localEditText.setBackgroundDrawable(getActivity().getResources().getDrawable(2130850041));
  }
  
  private void l()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)BaseApplication.getContext().getSystemService("input_method");
    if ((localInputMethodManager != null) && (localInputMethodManager.isActive())) {
      localInputMethodManager.hideSoftInputFromWindow(((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366452)).getWindowToken(), 0);
    }
  }
  
  private void m()
  {
    LiuHaiUtils.a(getActivity());
    int i = DisplayUtil.a(getActivity(), 275.0F) - LiuHaiUtils.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel = ((PoiSlideBottomPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131378246));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.setBottomHeight(i);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.setTitleHeightNoDisplay(i);
    View localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131373317);
    localView1.setOnClickListener(new LocationPickFragment.10(this));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.setDragView(localView1);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.findViewById(2131373316);
    View localView2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131373320);
    View localView3 = this.jdField_a_of_type_AndroidViewView.findViewById(2131371030);
    View localView4 = this.jdField_a_of_type_AndroidViewView.findViewById(2131373333);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.setSlidePanelListener(new LocationPickFragment.11(this, localView3, localView2, localView1, localImageView, localView4));
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.e();
      return true;
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.e();
    }
  }
  
  public boolean c()
  {
    getActivity().setResult(0);
    getActivity().overridePendingTransition(0, 2130772045);
    return super.c();
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
      QLog.d("LocationPickFragment", 2, "[location_fragment]onFinish: invoked. this: " + this + " activity: " + getActivity());
    }
    super.i();
    QFragmentActivity localQFragmentActivity = getActivity();
    if (localQFragmentActivity != null) {
      localQFragmentActivity.overridePendingTransition(0, 2130772045);
    }
  }
  
  @SuppressLint({"InflateParams"})
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onCreateView: invoked. this: " + this + " activity: " + getActivity());
    }
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559254, null);
    getActivity().overridePendingTransition(2130772043, 2130772045);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onDestroy: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onPause: invoked. this: " + this + " isFinishing: " + getActivity().isFinishing() + " activity: " + getActivity());
    }
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onPause();
    }
    if (getActivity().isFinishing()) {
      ThreadManager.getUIHandler().postDelayed(new LocationPickFragment.12(this), 200L);
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onResume: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onResume();
    }
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onStart: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onStart();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onStart();
    }
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onStop: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.onStop();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onViewCreated: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onViewCreated(paramView, paramBundle);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView = getActivity();
      paramView.requestPermissions(new LocationPickFragment.1(this, paramView), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    for (;;)
    {
      a();
      return;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment
 * JD-Core Version:    0.7.0.1
 */