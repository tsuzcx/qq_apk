package com.tencent.mobileqq.search.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class MixSearchWebFragment
  extends WebViewFragment
  implements TextWatcher, TextView.OnEditorActionListener
{
  protected Button a;
  protected ImageButton a;
  protected ImageView a;
  protected RelativeLayout a;
  protected QuickPinyinEditText a;
  public String a;
  
  private void a()
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout == null) {
      return;
    }
    localRelativeLayout.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850682));
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#777777"));
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850685));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850694));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCompoundDrawablesWithIntrinsicBounds(SkinEngine.getInstances().getDefaultThemeDrawable(2130850689), null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setPadding(UIUtils.a(getQBaseActivity(), 10.0F), this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingRight(), this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingBottom());
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setTextColor(-16777216);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHintTextColor(Color.parseColor("#a6a6a6"));
  }
  
  private void a(Bundle paramBundle)
  {
    if ("1".equals(getIntent().getStringExtra("showloadingbar"))) {
      getUIStyleHandler().a.a(true);
    } else {
      getUIStyleHandler().a.a(false);
    }
    if ((getSwiftTitleUI().a.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      Object localObject2 = BaseApplicationImpl.getApplication();
      getSwiftTitleUI().a.setVisibility(8);
      Object localObject1 = (ViewGroup)getSwiftTitleUI().a.getParent();
      paramBundle = LayoutInflater.from((Context)localObject2).inflate(2131561427, null);
      int i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
      localObject2 = new RelativeLayout.LayoutParams(-1, (int)((Context)localObject2).getResources().getDimension(2131299168));
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      ((ViewGroup)localObject1).addView(paramBundle, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)paramBundle.findViewById(2131366333));
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
      ((QuickPinyinEditText)localObject1).a = 50;
      ((QuickPinyinEditText)localObject1).setImeOptions(3);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(getIntent().getStringExtra("placeholder"));
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("searchword");
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramBundle.findViewById(2131368340));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new MixSearchWebFragment.2(this));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramBundle.findViewById(2131363868));
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131690728);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new MixSearchWebFragment.3(this));
      if ("1".equals(getIntent().getStringExtra("hiderightbtn"))) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      } else {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramBundle.findViewById(2131369289));
      if ("1".equals(getIntent().getStringExtra("hideleftarrow"))) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      } else {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if ((this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 8) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new MixSearchWebFragment.4(this));
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getViewTreeObserver().addOnGlobalLayoutListener(new MixSearchWebFragment.5(this));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_JavaLangString.length() > 50) {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.substring(0, 50);
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramBundle);
      a();
    }
  }
  
  protected void a(int paramInt)
  {
    if (paramInt >= 1)
    {
      if (paramInt > 3) {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("type", paramInt);
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("callJsOnBackClicked, type = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", e = ");
        localStringBuilder.append(localJSONException);
        QLog.e("WebLog_WebViewFragment", 1, localStringBuilder.toString());
      }
      getWebView().callJs("MixSearchBackClicked", new String[] { localJSONObject.toString() });
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    QuickPinyinEditText localQuickPinyinEditText = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
    if (localQuickPinyinEditText != null)
    {
      localQuickPinyinEditText.setHint(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString1);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (TextUtils.isEmpty(paramEditable)) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("searchWord", paramEditable.toString());
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("afterTextChanged, searchWord = ");
      localStringBuilder.append(paramEditable.toString());
      localStringBuilder.append(", e = ");
      localStringBuilder.append(localJSONException);
      QLog.e("WebLog_WebViewFragment", 1, localStringBuilder.toString());
    }
    getWebView().callJs("MixSearchWordDidChange", new String[] { localJSONObject.toString() });
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnBackEvent()
  {
    if (getWebView() != null) {
      a(2);
    }
    super.doOnBackEvent();
    if (!"1".equals(getIntent().getStringExtra("openanimtype"))) {
      getQBaseActivity().overridePendingTransition(0, 0);
    }
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new MixSearchWebFragment.1(this, this.webViewSurface);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66))) {
      return false;
    }
    paramTextView = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText();
    paramKeyEvent = "";
    if (paramTextView == null) {
      paramTextView = "";
    } else {
      paramTextView = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getHint() != null) {
      paramKeyEvent = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getHint().toString().trim();
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("searchWord", paramTextView);
      localJSONObject.put("placeholder", paramKeyEvent);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEditorAction, searchWord = ");
      localStringBuilder.append(paramTextView);
      localStringBuilder.append(", placeholder = ");
      localStringBuilder.append(paramKeyEvent);
      localStringBuilder.append(", e = ");
      localStringBuilder.append(localJSONException);
      QLog.e("WebLog_WebViewFragment", 1, localStringBuilder.toString());
    }
    getWebView().callJs("MixSearchButtonClicked", new String[] { localJSONObject.toString() });
    paramTextView = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
    if (paramTextView != null) {
      paramTextView.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
    return true;
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    a();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.MixSearchWebFragment
 * JD-Core Version:    0.7.0.1
 */