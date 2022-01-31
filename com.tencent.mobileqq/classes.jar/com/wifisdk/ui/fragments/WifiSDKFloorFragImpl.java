package com.wifisdk.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wifisdk.ui.api.RProxy.color;
import com.wifisdk.ui.api.RProxy.id;
import com.wifisdk.ui.api.RProxy.layout;
import com.wifisdk.ui.api.RProxy.string;
import com.wifisdk.ui.view.WifiCommonView;
import wf7.hk;
import wf7.hv;

public class WifiSDKFloorFragImpl
  extends BaseFragmentImpl
{
  private View tp;
  private WifiCommonView tq;
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    hv.fD().aB(6);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (!this.tq.fQ()) {
      hk.az(500178);
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    hk.az(500172);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.tp = LayoutInflater.from(this.to).inflate(RProxy.layout.wifi_sdk_floor_view, null);
    ((TextView)this.tp.findViewById(RProxy.id.tmsdk_wifi_title_back_text)).setOnClickListener(new WifiSDKFloorFragImpl.1(this));
    ((TextView)this.tp.findViewById(RProxy.id.tmsdk_wifi_title_text)).setText(this.to.getString(RProxy.string.tmsdk_wifi_floor_main_title));
    this.tq = ((WifiCommonView)this.tp.findViewById(RProxy.id.tmsdk_wifi_floor_content));
    this.tq.setBackgroundDrawable(new ColorDrawable(this.to.getResources().getColor(RProxy.color.tmsdk_wifi_bg_color)));
    this.tq.c(this.to, 1);
    this.tq.fR();
    return this.tp;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    hv.fD().onDestroy();
    this.tq.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    hv.fD().aB(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.wifisdk.ui.fragments.WifiSDKFloorFragImpl
 * JD-Core Version:    0.7.0.1
 */