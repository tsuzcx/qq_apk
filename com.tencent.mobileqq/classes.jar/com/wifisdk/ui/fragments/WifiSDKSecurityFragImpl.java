package com.wifisdk.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wifisdk.ui.api.RProxy.id;
import com.wifisdk.ui.api.RProxy.layout;
import com.wifisdk.ui.view.c;
import wf7.hs;
import wf7.hv;

public class WifiSDKSecurityFragImpl
  extends BaseFragmentImpl
{
  private static final String TAG = WifiSDKSecurityFragImpl.class.getSimpleName();
  private View tp;
  private hs tw;
  private c tx;
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.tp = LayoutInflater.from(this.to).inflate(RProxy.layout.wifi_sdk_security_check_view, null);
    ((TextView)this.tp.findViewById(RProxy.id.tmsdk_wifi_title_back_text)).setOnClickListener(new WifiSDKSecurityFragImpl.1(this));
    this.tx = new c(this.to, this.tp);
    this.tw = new hs(this.to);
    this.tw.a(this.tx);
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater = paramLayoutInflater.getIntegerArrayList("uiapi_k100");
      this.tw.r(paramLayoutInflater);
    }
    return this.tp;
  }
  
  public void onDestroy()
  {
    hv.fD().onDestroy();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.wifisdk.ui.fragments.WifiSDKSecurityFragImpl
 * JD-Core Version:    0.7.0.1
 */