package com.tencent.mobileqq.webview.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WebViewBottomBar$1
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.d != paramLong)
    {
      WebViewBottomBar localWebViewBottomBar = this.a;
      int i = (int)paramLong;
      localWebViewBottomBar.d = i;
      localWebViewBottomBar.a.notifyDataSetChanged();
      if (this.a.c != null) {
        this.a.c.a(i);
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewBottomBar.1
 * JD-Core Version:    0.7.0.1
 */