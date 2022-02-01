package com.tencent.mobileqq.webview.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;

class WebViewBottomBar$BarAdapter
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  
  public WebViewBottomBar.BottomItem a(int paramInt)
  {
    return (WebViewBottomBar.BottomItem)this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.jdField_b_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return a(paramInt).jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = false;
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563049, paramViewGroup, false);
      paramView = new WebViewBottomBar.ViewHolder(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar, localView);
      localView.setTag(paramView);
    }
    else
    {
      localObject = (WebViewBottomBar.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    paramView.jdField_a_of_type_Int = a(paramInt).jdField_a_of_type_Int;
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.jdField_a_of_type_JavaUtilList.contains(paramView)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.jdField_a_of_type_JavaUtilList.add(paramView);
    }
    paramView.a(a(paramInt).jdField_b_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.jdField_b_of_type_JavaUtilList.size() > paramInt)
    {
      paramView.a(a(paramInt).jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.jdField_b_of_type_Int != 0) {
        paramView.b(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.jdField_b_of_type_Int);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.jdField_a_of_type_Int == getItemId(paramInt)) {
      bool = true;
    }
    paramView.a(bool);
    Object localObject = (WebViewBottomBar.RedTouch)this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.jdField_a_of_type_Int));
    if (localObject != null) {
      ((WebViewBottomBar.RedTouch)localObject).a(paramView.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewBottomBar.BarAdapter
 * JD-Core Version:    0.7.0.1
 */