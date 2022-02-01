package com.tencent.mobileqq.webview.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WebViewBottomBar$ViewHolder
{
  int jdField_a_of_type_Int;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  
  public WebViewBottomBar$ViewHolder(WebViewBottomBar paramWebViewBottomBar, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370804));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370811));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371508));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377432));
    this.c = ((TextView)paramView.findViewById(2131376331));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(paramInt);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setSelected(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    ColorStateList localColorStateList = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar.a.getResources().getColorStateList(paramInt);
    if (localColorStateList != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewBottomBar.ViewHolder
 * JD-Core Version:    0.7.0.1
 */