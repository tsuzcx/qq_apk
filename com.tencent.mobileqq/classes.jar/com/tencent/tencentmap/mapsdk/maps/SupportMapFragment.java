package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class SupportMapFragment
  extends ReportV4Fragment
{
  private TencentMap a;
  private MapView b = null;
  private boolean c = false;
  
  public static SupportMapFragment newInstance(Context paramContext)
  {
    SupportMapFragment localSupportMapFragment = new SupportMapFragment();
    localSupportMapFragment.initSosoMap(paramContext);
    return localSupportMapFragment;
  }
  
  public final TencentMap getMap()
  {
    if (this.a == null) {
      this.a = this.b.getMap();
    }
    return this.a;
  }
  
  public void initSosoMap(Context paramContext)
  {
    if (this.b == null) {
      this.b = new MapView(paramContext);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.b == null) {
      this.b = new MapView(getActivity().getBaseContext());
    }
    this.b.setOnTop(this.c);
    paramLayoutInflater = this.b;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.b.onDestroy();
    super.onDestroy();
    this.b = null;
  }
  
  public void onDestroyView()
  {
    this.b.onDestroy();
    super.onDestroyView();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
  }
  
  public void onPause()
  {
    this.b.onPause();
    super.onPause();
  }
  
  public void onResume()
  {
    this.b.onResume();
    super.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    this.b.onStart();
    super.onStart();
  }
  
  public void onStop()
  {
    this.b.onStop();
    super.onStop();
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }
  
  public void setOnTop(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.SupportMapFragment
 * JD-Core Version:    0.7.0.1
 */