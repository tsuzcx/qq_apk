package com.tencent.mobileqq.onlinestatus.location;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import aobu;
import aobv;
import avwn;
import awao;
import aypj;
import aypu;
import aysp;
import aysq;
import aysr;
import ayss;
import ayst;
import aysu;
import aysv;
import bgmo;
import bgnt;
import bkpg;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.location.ui.LocationMapWidget;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class OnlineStatusLocationFragment
  extends PublicBaseFragment
  implements aobv
{
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aobu jdField_a_of_type_Aobu;
  private aysp jdField_a_of_type_Aysp;
  private LocationMapWidget jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget;
  LocationHeadSetView jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHeadSetView;
  private LatLng jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, aysv> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  private void a()
  {
    Intent localIntent = getActivity().getIntent();
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("uin");
    this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("uinname");
    double d1 = localIntent.getDoubleExtra("Location_Latitude", 0.0D);
    double d2 = localIntent.getDoubleExtra("Location_Longtitude", 0.0D);
    String str = localIntent.getStringExtra("Location_PoiDesc");
    long l = localIntent.getLongExtra("Location_UpdateTime", 0L);
    this.jdField_a_of_type_Aysp = new aysp(d1, d2, str, "");
    this.jdField_a_of_type_Aysp.jdField_a_of_type_Long = l;
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusLocationFragment", 2, new Object[] { "uin:", this.jdField_a_of_type_JavaLangString, " nick:", this.jdField_b_of_type_JavaLangString, " mLocationInfo:", this.jdField_a_of_type_Aysp.toString() });
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget = ((LocationMapWidget)this.jdField_a_of_type_AndroidViewView.findViewById(2131370261));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370268));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHeadSetView = ((LocationHeadSetView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367870));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHeadSetView.setHeadSetClickListener(new ayss(this));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHeadSetView.setImmersiveHeight(ImmersiveUtils.getStatusBarHeight(getActivity()));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379993));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379817));
    Object localObject1 = aypu.a(NetConnInfoCenter.getServerTime(), this.jdField_a_of_type_Aysp.jdField_a_of_type_Long);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Aysp.jdField_a_of_type_JavaLangString + " " + (String)localObject1);
    if (getActivity().app.getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHeadSetView.setTitleText(getResources().getString(2131697603));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getResources().getString(2131697601), new Object[] { "我的" }));
    }
    for (;;)
    {
      if (bkpg.a()) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840536);
      }
      localObject1 = ((aypj)getActivity().app.getManager(369)).a(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusLocationFragment", 2, new Object[] { "mapInfo:", ((aysq)localObject1).toString() });
      }
      Object localObject2 = new LatLng(this.jdField_a_of_type_Aysp.jdField_a_of_type_Double, this.jdField_a_of_type_Aysp.b);
      localObject2 = new avwn(this.jdField_a_of_type_JavaLangString, (LatLng)localObject2, 0.0D);
      avwn localavwn = new avwn(getActivity().app.getCurrentAccountUin(), null, 0.0D);
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget.a(getActivity(), localavwn, (avwn)localObject2, (aysq)localObject1, 20);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ayst(this));
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget.setListener(new aysu(this));
      this.jdField_a_of_type_Aobu = new aobu(getActivity(), (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_Aobu.a(this);
      if (!bgnt.g(getActivity())) {
        QQToast.a(getActivity(), 1, 2131718205, 1).a();
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getResources().getString(2131697601), new Object[] { this.jdField_b_of_type_JavaLangString }));
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHeadSetView.setTitleText(getResources().getString(2131697602));
    }
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (aysv)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((aysv)localObject2).jdField_a_of_type_Long < 4000L) && (((aysv)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((aysv)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((aysv)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new aysv(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((aysv)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_Aobu.a(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Aobu.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((aysv)localObject1).jdField_a_of_type_Long = l;
      ((aysv)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559185, paramViewGroup, false);
    getActivity().overridePendingTransition(2130772037, 17432577);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusLocationFragment", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bgmo.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    aysv localaysv = (aysv)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localaysv;
    if (localaysv == null)
    {
      paramBitmap = new aysv(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget.a(paramString, localBitmap);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget.onDestroy();
    }
    if (this.jdField_a_of_type_Aobu != null) {
      this.jdField_a_of_type_Aobu.d();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget.onPause();
    }
    if (getActivity().isFinishing())
    {
      awao.a();
      ThreadManager.getUIHandler().postDelayed(new OnlineStatusLocationFragment.5(this), 200L);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget != null) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget.onStop();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
    b();
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView = getActivity();
      paramView.requestPermissions(new aysr(this, paramView), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.OnlineStatusLocationFragment
 * JD-Core Version:    0.7.0.1
 */