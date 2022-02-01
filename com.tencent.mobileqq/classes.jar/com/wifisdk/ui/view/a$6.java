package com.wifisdk.ui.view;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.wifisdk.ui.api.RProxy.string;
import wf7.hc.b;

class a$6
  implements hc.b
{
  boolean uZ = true;
  
  a$6(a parama) {}
  
  public void aa(String paramString)
  {
    a.r(this.uU).setVisibility(0);
    a.s(this.uU).setVisibility(8);
    a.t(this.uU).setVisibility(8);
    a.r(this.uU).setText(RProxy.string.tmsdk_wifi_banner_btn_install);
  }
  
  public void ay(int paramInt)
  {
    a.r(this.uU).setVisibility(0);
    a.s(this.uU).setVisibility(8);
    a.t(this.uU).setVisibility(8);
  }
  
  public void onProgress(int paramInt)
  {
    if (this.uZ)
    {
      this.uZ = false;
      a.r(this.uU).setVisibility(8);
      a.s(this.uU).setVisibility(0);
      a.t(this.uU).setVisibility(0);
    }
    TextView localTextView = a.t(this.uU);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("%");
    localTextView.setText(localStringBuilder.toString());
    a.s(this.uU).setProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.wifisdk.ui.view.a.6
 * JD-Core Version:    0.7.0.1
 */