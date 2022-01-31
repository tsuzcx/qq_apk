package com.tencent.mobileqq.location.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import atpq;
import atpw;
import atqg;
import atro;
import atrw;
import atry;
import atrz;
import atsa;
import atsb;
import atsc;
import atsd;
import atse;
import atsf;
import atsg;
import atsh;
import attk;
import bdin;
import bibv;
import bnle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.os.MqqHandler;
import xin;

public class LocationPickFragment
  extends PublicBaseFragment
{
  private static long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private atpq jdField_a_of_type_Atpq;
  private atro jdField_a_of_type_Atro;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private PoiSlideBottomPanel jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel;
  
  private void a()
  {
    if (bibv.a()) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131372150).setBackgroundResource(2130838592);
    }
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString, CameraPosition paramCameraPosition)
  {
    if (!bdin.a()) {
      QQToast.a(paramActivity, 2131694129, 0).a();
    }
    while (System.currentTimeMillis() - jdField_a_of_type_Long < 1000L) {
      return;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (attk.a(paramActivity) <= 0)
    {
      QQToast.a(paramActivity, 1, paramActivity.getString(2131694807), 1).a();
      return;
    }
    if (!atpw.a(((BaseActivity)paramActivity).app).a.a(paramString, paramInt)) {}
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
      PublicFragmentActivity.a(paramActivity, localIntent, LocationPickFragment.class, 0);
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
    this.jdField_a_of_type_Atro = new atro(getActivity().app);
    Intent localIntent = getActivity().getIntent();
    String str = localIntent.getStringExtra("uin");
    this.jdField_a_of_type_Atpq = new atpq(localIntent.getIntExtra("uintype", -1), str);
  }
  
  private void d()
  {
    e();
    Object localObject1 = getActivity();
    this.jdField_a_of_type_AndroidViewView.findViewById(2131372161).setOnClickListener(new atsa(this, (Activity)localObject1));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131372162).setOnClickListener(new atsb(this, (Activity)localObject1));
    if (bibv.a()) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131372162).setBackgroundResource(2130844967);
    }
    f();
    h();
    Object localObject2 = (XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372148);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = ((MapWidget)this.jdField_a_of_type_AndroidViewView.findViewById(2131369824));
    attk.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget, "地图 你正在共享位置");
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369829);
    attk.a(localImageView, "在地图区回到我的位置");
    Object localObject3 = ((Activity)localObject1).getIntent();
    localObject3 = CameraPosition.fromLatLngZoom((LatLng)((Intent)localObject3).getParcelableExtra("key_last_position"), ((Intent)localObject3).getFloatExtra("key_last_zoom", 0.0F));
    this.jdField_a_of_type_Atro.a((Activity)localObject1, this.jdField_a_of_type_Atpq, (CameraPosition)localObject3, this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget, localImageView, this.jdField_a_of_type_AndroidViewView.findViewById(2131372162), this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel, (XListView)localObject2, this.jdField_a_of_type_AndroidViewView.findViewById(2131372152), this.jdField_a_of_type_AndroidViewView.findViewById(2131372135));
    localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131364985);
    localObject2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131372143);
    if (bibv.a())
    {
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setBackgroundColor(Color.parseColor("#CC000000"));
      return;
    }
    ((View)localObject1).setVisibility(8);
    ((View)localObject2).setBackgroundColor(Color.parseColor("#7F000000"));
  }
  
  private void e()
  {
    bnle.a(getActivity());
    int i = ImmersiveUtils.getStatusBarHeight(getActivity());
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372143);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    int j;
    if (bnle.jdField_a_of_type_Boolean)
    {
      localView.setPadding(xin.b(getActivity(), 20.0F), bnle.jdField_a_of_type_Int, xin.b(getActivity(), 20.0F), 0);
      j = localLayoutParams.height;
    }
    for (localLayoutParams.height = (i + bnle.jdField_a_of_type_Int + j);; localLayoutParams.height = (i + localLayoutParams.height))
    {
      localView.setLayoutParams(localLayoutParams);
      return;
      localView.setPadding(xin.b(getActivity(), 20.0F), i, xin.b(getActivity(), 20.0F), 0);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void f()
  {
    getActivity().getWindow().setSoftInputMode(48);
    View localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131372156);
    View localView2 = localView1.findViewById(2131363522);
    localView2.setVisibility(8);
    ((TextView)localView1.findViewById(2131378988)).setText("查找集合地点");
    EditText localEditText = (EditText)localView1.findViewById(2131365851);
    localEditText.setOnKeyListener(new atsc(this, localEditText));
    localView2.setOnClickListener(new atsd(this, localEditText));
    localEditText.setImeOptions(3);
    localEditText.setOnHoverListener(new atse(this));
    localEditText.setOnTouchListener(new atsf(this));
    localView1.findViewById(2131367817).setOnClickListener(new atsg(this, localEditText));
    View localView3 = localView1.findViewById(2131378988);
    localEditText.addTextChangedListener(new atsh(this, localView3, localView1.findViewById(2131367817), localView2));
    if (bibv.a())
    {
      ((TextView)localView3).setTextColor(Color.parseColor("#8E8E93"));
      localEditText.setTextColor(Color.parseColor("#FFFFFF"));
    }
  }
  
  private void g()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
    if ((localInputMethodManager != null) && (localInputMethodManager.isActive())) {
      localInputMethodManager.hideSoftInputFromWindow(((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131365851)).getWindowToken(), 0);
    }
  }
  
  private void h()
  {
    bnle.a(getActivity());
    int i = xin.b(getActivity(), 275.0F) - bnle.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel = ((PoiSlideBottomPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131376829));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.setBottomHeight(i);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.setTitleHeightNoDisplay(i);
    View localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131372140);
    localView1.setOnClickListener(new atry(this));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.setDragView(localView1);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.findViewById(2131372139);
    View localView2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131372143);
    View localView3 = this.jdField_a_of_type_AndroidViewView.findViewById(2131370053);
    View localView4 = this.jdField_a_of_type_AndroidViewView.findViewById(2131372156);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.setSlidePanelListener(new atrz(this, localView3, localView2, localView1, localImageView, localView4));
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.e();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    getActivity().setResult(0);
    getActivity().overridePendingTransition(0, 2130772038);
    return super.onBackEvent();
  }
  
  @SuppressLint({"InflateParams"})
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onCreateView: invoked. this: " + this + " activity: " + getActivity());
    }
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559113, null);
    getActivity().overridePendingTransition(2130772036, 2130772038);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onDestroy: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[location_fragment]onFinish: invoked. this: " + this + " activity: " + getActivity());
    }
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.overridePendingTransition(0, 2130772038);
    }
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
      paramView.requestPermissions(new atrw(this, paramView), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    for (;;)
    {
      a();
      return;
      b();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.e();
    }
  }
  
  public boolean overrideFinish()
  {
    boolean bool = super.overrideFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.overridePendingTransition(0, 2130772038);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment
 * JD-Core Version:    0.7.0.1
 */