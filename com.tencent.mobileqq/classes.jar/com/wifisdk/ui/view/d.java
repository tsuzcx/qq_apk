package com.wifisdk.ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.wifisdk.TMSDKFreeWifiInfo;
import com.wifisdk.ui.api.RProxy.id;
import com.wifisdk.ui.api.RProxy.layout;
import com.wifisdk.ui.api.RProxy.string;
import wf7.ht;

public class d
{
  private Handler mHandler;
  private ListView uH;
  private Context vA;
  private String vB;
  private TextView vC;
  private ImageView vD;
  private TextView vE;
  private TextView vF;
  private TextView vG;
  private LinearLayout vH;
  
  public d(Context paramContext, ListView paramListView)
  {
    this.vA = paramContext.getApplicationContext();
    this.vB = this.vA.getString(RProxy.string.tmsdk_wifi_connection_success);
    this.mHandler = new Handler(Looper.getMainLooper(), new d.a(this, null));
    this.uH = paramListView;
  }
  
  private void fT()
  {
    if (this.uH.getHeaderViewsCount() > 0) {
      this.uH.removeHeaderView(this.vH);
    }
    if (this.vH == null)
    {
      this.vH = new LinearLayout(this.vA);
      this.vH.setOrientation(1);
      Object localObject = (RelativeLayout)LayoutInflater.from(this.vA).inflate(RProxy.layout.wifi_sdk_list_item_header, null);
      ((TextView)((ViewGroup)localObject).findViewById(RProxy.id.tmsdk_wifi_list_header_text)).setText("当前WiFi");
      this.vH.addView((View)localObject);
      localObject = LayoutInflater.from(this.vA).inflate(RProxy.layout.wifi_sdk_list_view_item, null);
      this.vC = ((TextView)((View)localObject).findViewById(RProxy.id.tmsdk_wifi_tv));
      this.vD = ((ImageView)((View)localObject).findViewById(RProxy.id.tmsdk_wifi_wifi_icon));
      this.vF = ((TextView)((View)localObject).findViewById(RProxy.id.tmsdk_wifi_description));
      this.vE = ((TextView)((View)localObject).findViewById(RProxy.id.tmsdk_wifi_latency_layout));
      this.vF.setVisibility(0);
      this.vG = ((TextView)((View)localObject).findViewById(RProxy.id.tmsdk_wifi_connect));
      this.vG.setVisibility(8);
      this.vH.addView((View)localObject, new LinearLayout.LayoutParams(-1, -1));
    }
    for (;;)
    {
      this.uH.addHeaderView(this.vH);
      return;
      if (this.vE != null) {
        this.vE.setVisibility(8);
      }
    }
  }
  
  public void a(TMSDKFreeWifiInfo paramTMSDKFreeWifiInfo)
  {
    this.mHandler.obtainMessage(2, paramTMSDKFreeWifiInfo).sendToTarget();
  }
  
  public void a(ht paramht) {}
  
  public void b(TMSDKFreeWifiInfo paramTMSDKFreeWifiInfo)
  {
    this.mHandler.obtainMessage(4, paramTMSDKFreeWifiInfo).sendToTarget();
  }
  
  public void fS()
  {
    this.mHandler.sendEmptyMessage(1);
  }
  
  public void onDestroy()
  {
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    this.uH = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.wifisdk.ui.view.d
 * JD-Core Version:    0.7.0.1
 */