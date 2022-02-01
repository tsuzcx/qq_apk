package com.tencent.mobileqq.webview.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public class WebViewBottomBar
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  WebViewBottomBar.BarAdapter jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar$BarAdapter;
  WebViewBottomBar.OnBottomBarItemListener jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar$OnBottomBarItemListener;
  HashMap<Integer, WebViewBottomBar.RedTouch> jdField_a_of_type_JavaUtilHashMap;
  List<WebViewBottomBar.ViewHolder> jdField_a_of_type_JavaUtilList;
  int jdField_b_of_type_Int;
  List<WebViewBottomBar.BottomItem> jdField_b_of_type_JavaUtilList;
  
  WebViewBottomBar.ViewHolder a(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        WebViewBottomBar.ViewHolder localViewHolder = (WebViewBottomBar.ViewHolder)localIterator.next();
        if (paramInt == localViewHolder.a) {
          return localViewHolder;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewBottomBar
 * JD-Core Version:    0.7.0.1
 */