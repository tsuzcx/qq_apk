package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.ui.WebViewTopTabHelper;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import org.json.JSONObject;

@KeepClassConstructor
public class QzoneSwitchFragmentTitleBarUI
  extends SwiftIphoneTitleBarUI
{
  public QzoneSwitchFragmentTitleBarUI(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    super(paramSwiftBrowserUIStyleHandler);
  }
  
  public int a(RadioGroup paramRadioGroup)
  {
    if ((paramRadioGroup != null) && ((paramRadioGroup instanceof WebViewTopTabView)))
    {
      int i = 0;
      while (i < paramRadioGroup.getChildCount())
      {
        if (((RadioButton)paramRadioGroup.getChildAt(i)).isChecked()) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void a(SwiftIphoneTitleBarUI.SubTabParam paramSubTabParam)
  {
    if (paramSubTabParam != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView = new WebViewTopTabView(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonNum(paramSubTabParam.jdField_b_of_type_Int, paramSubTabParam.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonText(paramSubTabParam.jdField_a_of_type_ArrayOfJavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(2130851213, 2130851214, 2130851215);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(2131167381);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(10);
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.v);
      int i = -1;
      try
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView, new RelativeLayout.LayoutParams(-2, -1));
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a.getIntent().getBooleanExtra("topTabSwitchFragment", false))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setOnCheckedChangeListener(new QzoneSwitchFragmentTitleBarUI.1(this));
        if (((QQBrowserActivity)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a).oldTabSelectIndex != -1) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setSelectedTab(((QQBrowserActivity)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a).oldTabSelectIndex);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setSelectedTab(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a.getIntent().getIntExtra("topTabSelectIndex", 0));
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabHelper.a(paramSubTabParam.jdField_b_of_type_JavaLangString, true);
      }
      TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a();
      if ((localTouchWebView != null) && (!TextUtils.isEmpty(paramSubTabParam.jdField_a_of_type_JavaLangString)))
      {
        String str;
        if (TextUtils.isEmpty(paramSubTabParam.jdField_b_of_type_JavaLangString))
        {
          str = "the subTabCallback isEmpty";
        }
        else
        {
          str = "ok";
          i = 0;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("code", i);
          localJSONObject.put("message", str);
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        localTouchWebView.callJs(paramSubTabParam.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.QzoneSwitchFragmentTitleBarUI
 * JD-Core Version:    0.7.0.1
 */