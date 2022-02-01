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
    if (this.a.jdField_a_of_type_Int != paramLong)
    {
      WebViewBottomBar localWebViewBottomBar = this.a;
      int i = (int)paramLong;
      localWebViewBottomBar.jdField_a_of_type_Int = i;
      localWebViewBottomBar.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar$BarAdapter.notifyDataSetChanged();
      if (this.a.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar$OnBottomBarItemListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar$OnBottomBarItemListener.a(i);
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewBottomBar.1
 * JD-Core Version:    0.7.0.1
 */