package com.tencent.mobileqq.webview.ui;

import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;

class WebViewBottomBar$RedTouch
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  
  public void a(int paramInt)
  {
    a(paramInt, this.jdField_a_of_type_Boolean);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.a(paramInt);
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    int j = this.jdField_a_of_type_Int;
    int i = 4;
    if (j == 1)
    {
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.a.containsKey(Integer.valueOf(paramInt)))) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.a.remove(Integer.valueOf(paramInt));
      }
      if (this.jdField_a_of_type_Boolean)
      {
        ((WebViewBottomBar.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((WebViewBottomBar.ViewHolder)localObject).c.setVisibility(8);
      }
      localObject = ((WebViewBottomBar.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView;
      paramInt = i;
      if (this.jdField_a_of_type_Boolean) {
        paramInt = 0;
      }
      ((ImageView)localObject).setVisibility(paramInt);
      return;
    }
    if (j == 3)
    {
      if (paramInt <= 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.a.containsKey(Integer.valueOf(paramInt))) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.a.remove(Integer.valueOf(paramInt));
        }
        ((WebViewBottomBar.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      paramInt = Integer.parseInt(this.jdField_a_of_type_JavaLangString);
      if (paramInt <= 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.a.containsKey(Integer.valueOf(((WebViewBottomBar.ViewHolder)localObject).jdField_a_of_type_Int))) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.a.remove(Integer.valueOf(((WebViewBottomBar.ViewHolder)localObject).jdField_a_of_type_Int));
        }
        ((WebViewBottomBar.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
      }
      ((WebViewBottomBar.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      ((WebViewBottomBar.ViewHolder)localObject).c.setVisibility(8);
      ((WebViewBottomBar.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      ((WebViewBottomBar.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
      return;
    }
    if (j == 2)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        ((WebViewBottomBar.ViewHolder)localObject).c.setVisibility(8);
        return;
      }
      ((WebViewBottomBar.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      ((WebViewBottomBar.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      ((WebViewBottomBar.ViewHolder)localObject).c.setText(this.jdField_a_of_type_JavaLangString);
      ((WebViewBottomBar.ViewHolder)localObject).c.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewBottomBar.RedTouch
 * JD-Core Version:    0.7.0.1
 */