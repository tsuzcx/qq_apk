package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;

class HalfSizeWebviewDialog$3
  implements View.OnClickListener
{
  HalfSizeWebviewDialog$3(HalfSizeWebviewDialog paramHalfSizeWebviewDialog) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.e.canGoBack())
    {
      this.a.dismiss();
    }
    else
    {
      HalfSizeWebviewDialog localHalfSizeWebviewDialog = this.a;
      localHalfSizeWebviewDialog.n -= 1;
      HalfSizeWebviewDialog.a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.dialog.HalfSizeWebviewDialog.3
 * JD-Core Version:    0.7.0.1
 */