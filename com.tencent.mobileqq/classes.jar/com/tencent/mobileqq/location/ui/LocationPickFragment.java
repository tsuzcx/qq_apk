package com.tencent.mobileqq.location.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.location.LocationPickViewModel;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.location.net.ReportLocationHandler;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.os.MqqHandler;

public class LocationPickFragment
  extends QPublicBaseFragment
{
  private static long e;
  private PoiSlideBottomPanel a;
  private MapWidget b;
  private View c;
  private LocationPickController d;
  private LocationPickViewModel f;
  private LocationRoom.RoomKey g;
  
  private void a()
  {
    if (QQUIDelegate.c()) {
      this.c.findViewById(2131440469).setBackgroundResource(2130838958);
    }
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString, CameraPosition paramCameraPosition)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQToast.makeText(paramActivity, 2131891404, 0).show();
      return;
    }
    if (System.currentTimeMillis() - e < 1000L) {
      return;
    }
    e = System.currentTimeMillis();
    if (MapUtils.a(paramActivity) <= 0)
    {
      QQToast.makeText(paramActivity, 1, paramActivity.getString(2131892141), 1).show();
      return;
    }
    boolean bool = LocationShareLocationManager.a().a.a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, new Object[] { "[location_fragment]launch: invoked. ", " notSameSession: ", Boolean.valueOf(bool ^ true) });
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("FRAGMENT_KEY", "LocationPickFragment");
    localIntent.putExtra("key_last_position", paramCameraPosition.target);
    localIntent.putExtra("key_last_zoom", paramCameraPosition.zoom);
    QPublicFragmentActivity.startForResult(paramActivity, localIntent, LocationPickFragment.class, 0);
  }
  
  private void b()
  {
    c();
    d();
  }
  
  private void c()
  {
    Object localObject = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(getActivity());
    this.f = ((LocationPickViewModel)ViewModelProviderHelper.a((ViewModelStoreOwner)localObject, LocationPickViewModel.c).get(LocationPickViewModel.class));
    this.d = new LocationPickController(this.f, (LifeCycleAndViewModelStoreOwner)localObject);
    localObject = getActivity().getIntent();
    String str = ((Intent)localObject).getStringExtra("uin");
    this.g = new LocationRoom.RoomKey(((Intent)localObject).getIntExtra("uintype", -1), str);
  }
  
  private void d()
  {
    e();
    Object localObject1 = getQBaseActivity();
    this.c.findViewById(2131440479).setOnClickListener(new LocationPickFragment.2(this, (QBaseActivity)localObject1));
    this.c.findViewById(2131440480).setOnClickListener(new LocationPickFragment.3(this, (QBaseActivity)localObject1));
    if (QQUIDelegate.c()) {
      this.c.findViewById(2131440480).setBackgroundResource(2130846996);
    }
    f();
    h();
    Object localObject2 = (XListView)this.c.findViewById(2131440468);
    this.b = ((MapWidget)this.c.findViewById(2131437696));
    MapUtils.a(this.b, "地图 你正在共享位置");
    ImageView localImageView = (ImageView)this.c.findViewById(2131437703);
    MapUtils.a(localImageView, "在地图区回到我的位置");
    Object localObject3 = ((QBaseActivity)localObject1).getIntent();
    localObject3 = CameraPosition.fromLatLngZoom((LatLng)((Intent)localObject3).getParcelableExtra("key_last_position"), ((Intent)localObject3).getFloatExtra("key_last_zoom", 0.0F));
    this.d.a((QBaseActivity)localObject1, this.g, (CameraPosition)localObject3, this.b, localImageView, this.c.findViewById(2131440480), this.a, (XListView)localObject2, this.c.findViewById(2131440471), this.c.findViewById(2131440455));
    localObject1 = this.c.findViewById(2131431578);
    localObject2 = this.c.findViewById(2131440463);
    if (QQUIDelegate.c())
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
    LiuHaiUtils.f(getActivity());
    int i = ImmersiveUtils.getStatusBarHeight(getActivity());
    View localView = this.c.findViewById(2131440463);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    if (LiuHaiUtils.b)
    {
      localView.setPadding(DisplayUtil.a(getActivity(), 20.0F), LiuHaiUtils.d, DisplayUtil.a(getActivity(), 20.0F), 0);
      localLayoutParams.height += i + LiuHaiUtils.d;
    }
    else
    {
      localView.setPadding(DisplayUtil.a(getActivity(), 20.0F), i, DisplayUtil.a(getActivity(), 20.0F), 0);
      localLayoutParams.height += i;
    }
    localView.setLayoutParams(localLayoutParams);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void f()
  {
    getActivity().getWindow().setSoftInputMode(48);
    View localView1 = this.c.findViewById(2131440475);
    View localView2 = localView1.findViewById(2131429816);
    localView2.setVisibility(8);
    ((TextView)localView1.findViewById(2131448724)).setText("查找集合地点");
    EditText localEditText = (EditText)localView1.findViewById(2131432634);
    localEditText.setOnKeyListener(new LocationPickFragment.4(this, localEditText));
    localView2.setOnClickListener(new LocationPickFragment.5(this, localEditText));
    localEditText.setImeOptions(3);
    localEditText.setOnHoverListener(new LocationPickFragment.6(this));
    localEditText.setOnTouchListener(new LocationPickFragment.7(this));
    localView1.findViewById(2131435215).setOnClickListener(new LocationPickFragment.8(this, localEditText));
    View localView3 = localView1.findViewById(2131448724);
    localEditText.addTextChangedListener(new LocationPickFragment.9(this, localView3, localView1.findViewById(2131435215), localView2));
    if (QQUIDelegate.c())
    {
      localEditText.setBackgroundDrawable(getActivity().getResources().getDrawable(2130851969));
      ((TextView)localView3).setTextColor(Color.parseColor("#8E8E93"));
      return;
    }
    localEditText.setBackgroundDrawable(getActivity().getResources().getDrawable(2130851724));
  }
  
  private void g()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)BaseApplication.getContext().getSystemService("input_method");
    if ((localInputMethodManager != null) && (localInputMethodManager.isActive())) {
      localInputMethodManager.hideSoftInputFromWindow(((EditText)this.c.findViewById(2131432634)).getWindowToken(), 0);
    }
  }
  
  private void h()
  {
    LiuHaiUtils.f(getActivity());
    int i = DisplayUtil.a(getActivity(), 275.0F) - LiuHaiUtils.d;
    this.a = ((PoiSlideBottomPanel)this.c.findViewById(2131446082));
    this.a.setBottomHeight(i);
    this.a.setTitleHeightNoDisplay(i);
    View localView1 = this.c.findViewById(2131440460);
    localView1.setOnClickListener(new LocationPickFragment.10(this));
    this.a.setDragView(localView1);
    ImageView localImageView = (ImageView)this.a.findViewById(2131440459);
    View localView2 = this.c.findViewById(2131440463);
    View localView3 = this.c.findViewById(2131437941);
    View localView4 = this.c.findViewById(2131440475);
    this.a.setSlidePanelListener(new LocationPickFragment.11(this, localView3, localView2, localView1, localImageView, localView4));
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.a.h()))
    {
      this.a.f();
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
    getActivity().overridePendingTransition(0, 2130772092);
    return super.onBackEvent();
  }
  
  @SuppressLint({"InflateParams"})
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("[location_fragment]onCreateView: invoked. this: ");
      paramViewGroup.append(this);
      paramViewGroup.append(" activity: ");
      paramViewGroup.append(getActivity());
      QLog.d("LocationPickFragment", 2, paramViewGroup.toString());
    }
    this.c = paramLayoutInflater.inflate(2131624874, null);
    getActivity().overridePendingTransition(2130772090, 2130772092);
    paramLayoutInflater = this.c;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[location_fragment]onDestroy: invoked. this: ");
      localStringBuilder.append(this);
      localStringBuilder.append(" activity: ");
      localStringBuilder.append(getActivity());
      QLog.d("LocationPickFragment", 2, localStringBuilder.toString());
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[location_fragment]onFinish: invoked. this: ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" activity: ");
      ((StringBuilder)localObject).append(getActivity());
      QLog.d("LocationPickFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.onFinish();
    Object localObject = getActivity();
    if (localObject != null) {
      ((Activity)localObject).overridePendingTransition(0, 2130772092);
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[location_fragment]onPause: invoked. this: ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" isFinishing: ");
      ((StringBuilder)localObject).append(getActivity().isFinishing());
      ((StringBuilder)localObject).append(" activity: ");
      ((StringBuilder)localObject).append(getActivity());
      QLog.d("LocationPickFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.onPause();
    Object localObject = this.b;
    if (localObject != null) {
      ((MapWidget)localObject).onPause();
    }
    if (getActivity().isFinishing()) {
      ThreadManager.getUIHandler().postDelayed(new LocationPickFragment.12(this), 200L);
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[location_fragment]onResume: invoked. this: ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" activity: ");
      ((StringBuilder)localObject).append(getActivity());
      QLog.d("LocationPickFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.onResume();
    Object localObject = this.b;
    if (localObject != null) {
      ((MapWidget)localObject).onResume();
    }
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[location_fragment]onStart: invoked. this: ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" activity: ");
      ((StringBuilder)localObject).append(getActivity());
      QLog.d("LocationPickFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.onStart();
    Object localObject = this.b;
    if (localObject != null) {
      ((MapWidget)localObject).onStart();
    }
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[location_fragment]onStop: invoked. this: ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" activity: ");
      ((StringBuilder)localObject).append(getActivity());
      QLog.d("LocationPickFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.onStop();
    Object localObject = this.b;
    if (localObject != null) {
      ((MapWidget)localObject).onStop();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[location_fragment]onViewCreated: invoked. this: ");
      localStringBuilder.append(this);
      localStringBuilder.append(" activity: ");
      localStringBuilder.append(getActivity());
      QLog.d("LocationPickFragment", 2, localStringBuilder.toString());
    }
    super.onViewCreated(paramView, paramBundle);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView = getQBaseActivity();
      paramView.requestPermissions(new LocationPickFragment.1(this, paramView), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    else
    {
      b();
    }
    a();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    PoiSlideBottomPanel localPoiSlideBottomPanel = this.a;
    if (localPoiSlideBottomPanel != null) {
      localPoiSlideBottomPanel.f();
    }
  }
  
  public boolean overrideFinish()
  {
    boolean bool = super.overrideFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.overridePendingTransition(0, 2130772092);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment
 * JD-Core Version:    0.7.0.1
 */