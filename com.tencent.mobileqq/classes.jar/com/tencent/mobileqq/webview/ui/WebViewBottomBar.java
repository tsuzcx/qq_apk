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
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        WebViewBottomBar.ViewHolder localViewHolder = (WebViewBottomBar.ViewHolder)((Iterator)localObject).next();
        if (paramInt == localViewHolder.a) {
          return localViewHolder;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewBottomBar
 * JD-Core Version:    0.7.0.1
 */