package com.tencent.mobileqq.webview.swift;

import aknd;
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
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.ui.WebViewTopTabHelper;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import org.json.JSONObject;

public class SwitchFragmentTitleBarUI
  extends SwiftIphoneTitleBarUI
{
  public SwitchFragmentTitleBarUI(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
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
    int i = -1;
    if (paramSubTabParam != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView = new WebViewTopTabView(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonNum(paramSubTabParam.jdField_b_of_type_Int, paramSubTabParam.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonText(paramSubTabParam.jdField_a_of_type_ArrayOfJavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(2130846352, 2130846356, 2130846360);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(2131494321);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(10);
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.q);
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView, new RelativeLayout.LayoutParams(-2, -1));
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a.getIntent().getBooleanExtra("topTabSwitchFragment", false))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setOnCheckedChangeListener(new aknd(this));
        if (((QQBrowserActivity)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a).jdField_b_of_type_Int != -1) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setSelectedTab(((QQBrowserActivity)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a).jdField_b_of_type_Int);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabHelper != null) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabHelper.a(paramSubTabParam.jdField_b_of_type_JavaLangString, true);
        }
        localTouchWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a();
        if ((localTouchWebView != null) && (!TextUtils.isEmpty(paramSubTabParam.jdField_a_of_type_JavaLangString)))
        {
          str = "ok";
          if (!TextUtils.isEmpty(paramSubTabParam.jdField_b_of_type_JavaLangString)) {
            break label337;
          }
          str = "the subTabCallback isEmpty";
          localJSONObject = new JSONObject();
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          TouchWebView localTouchWebView;
          String str;
          JSONObject localJSONObject;
          localJSONObject.put("code", i);
          localJSONObject.put("message", str);
          localTouchWebView.a(paramSubTabParam.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
          return;
          localException1 = localException1;
          localException1.printStackTrace();
          continue;
          this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setSelectedTab(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a.getIntent().getIntExtra("topTabSelectIndex", 0));
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
        }
        label337:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwitchFragmentTitleBarUI
 * JD-Core Version:    0.7.0.1
 */