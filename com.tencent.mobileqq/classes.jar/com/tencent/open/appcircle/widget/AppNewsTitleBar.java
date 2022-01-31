package com.tencent.open.appcircle.widget;

import aknp;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.smtt.sdk.WebView;
import cooperation.qappcenter.remote.RemoteServiceProxy;

public class AppNewsTitleBar
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aknp(this);
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private RemoteServiceProxy jdField_a_of_type_CooperationQappcenterRemoteRemoteServiceProxy;
  private int jdField_b_of_type_Int;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  
  public AppNewsTitleBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AppNewsTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2130968697, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363240));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131363238));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131363239));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_CooperationQappcenterRemoteRemoteServiceProxy = RemoteServiceProxy.a(String.valueOf(CommonDataAdapter.a().a()));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130839783);
    }
    while (this.jdField_a_of_type_Int != 0) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130839782);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView.canGoBack())) {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.goBack();
    }
    while (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = paramBundle.getInt("leftBtnType");
    this.jdField_b_of_type_Int = paramBundle.getInt("rightBtnType");
    b();
  }
  
  public void a(WebView paramWebView, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
  }
  
  public void setTitle(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.appcircle.widget.AppNewsTitleBar
 * JD-Core Version:    0.7.0.1
 */