package com.wifisdk.ui.view;

import android.widget.ProgressBar;
import android.widget.TextView;
import wf7.hc.b;

class WifiCommonView$1
  implements hc.b
{
  boolean uZ = true;
  
  WifiCommonView$1(WifiCommonView paramWifiCommonView) {}
  
  public void aa(String paramString)
  {
    WifiCommonView.a(this.vz).setVisibility(0);
    WifiCommonView.b(this.vz).setVisibility(8);
    WifiCommonView.c(this.vz).setVisibility(8);
  }
  
  public void ay(int paramInt)
  {
    WifiCommonView.a(this.vz).setVisibility(0);
    WifiCommonView.b(this.vz).setVisibility(8);
    WifiCommonView.c(this.vz).setVisibility(8);
  }
  
  public void onProgress(int paramInt)
  {
    if (this.uZ)
    {
      this.uZ = false;
      WifiCommonView.a(this.vz).setVisibility(8);
      WifiCommonView.b(this.vz).setVisibility(0);
      WifiCommonView.c(this.vz).setVisibility(0);
    }
    TextView localTextView = WifiCommonView.c(this.vz);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("%");
    localTextView.setText(localStringBuilder.toString());
    WifiCommonView.b(this.vz).setProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.wifisdk.ui.view.WifiCommonView.1
 * JD-Core Version:    0.7.0.1
 */