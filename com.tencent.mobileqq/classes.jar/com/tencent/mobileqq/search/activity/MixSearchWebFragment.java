package com.tencent.mobileqq.search.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import bcan;
import bcao;
import bcap;
import bcaq;
import bieo;
import biur;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
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
  public QuickPinyinEditText a;
  public String a;
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850356));
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#777777"));
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850359));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850367));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCompoundDrawablesWithIntrinsicBounds(SkinEngine.getInstances().getDefaultThemeDrawable(2130850363), null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setPadding(UIUtils.dip2px(getActivity(), 10.0F), this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingRight(), this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingBottom());
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setTextColor(-16777216);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHintTextColor(Color.parseColor("#a6a6a6"));
  }
  
  private void a(Bundle paramBundle)
  {
    View localView;
    if ("1".equals(getIntent().getStringExtra("showloadingbar")))
    {
      this.mUIStyleHandler.mProgressBarController.a(true);
      if ((this.mSwiftTitleUI.titleContainer.getLayoutParams() instanceof RelativeLayout.LayoutParams))
      {
        Object localObject = BaseApplicationImpl.getApplication();
        this.mSwiftTitleUI.titleContainer.setVisibility(8);
        paramBundle = (ViewGroup)this.mSwiftTitleUI.titleContainer.getParent();
        localView = LayoutInflater.from((Context)localObject).inflate(2131561477, null);
        int i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
        localObject = new RelativeLayout.LayoutParams(-1, (int)((Context)localObject).getResources().getDimension(2131299080));
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = i;
        paramBundle.addView(localView, (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)localView.findViewById(2131366280));
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.a = 50;
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(getIntent().getStringExtra("placeholder"));
        this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("searchword");
        this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localView.findViewById(2131368378));
        this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new bcan(this));
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131363845));
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131690697);
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bcao(this));
        if (!"1".equals(getIntent().getStringExtra("hiderightbtn"))) {
          break label508;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        label328:
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369324));
        if (!"1".equals(getIntent().getStringExtra("hideleftarrow"))) {
          break label519;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 8) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bcap(this));
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getViewTreeObserver().addOnGlobalLayoutListener(new bcaq(this));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_JavaLangString.length() > 50) {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.substring(0, 50);
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView);
      a();
      return;
      this.mUIStyleHandler.mProgressBarController.a(false);
      break;
      label508:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label328;
      label519:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 3)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      getWebView().callJs("MixSearchBackClicked", new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("WebLog_WebViewFragment", 1, "callJsOnBackClicked, type = " + paramInt + ", e = " + localJSONException);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString1);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (TextUtils.isEmpty(paramEditable)) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("searchWord", paramEditable.toString());
        getWebView().callJs("MixSearchWordDidChange", new String[] { localJSONObject.toString() });
        return;
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("WebLog_WebViewFragment", 1, "afterTextChanged, searchWord = " + paramEditable.toString() + ", e = " + localJSONException);
        }
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    a(paramBundle);
    return i;
  }
  
  public void doOnBackEvent()
  {
    if (getWebView() != null) {
      a(2);
    }
    super.doOnBackEvent();
    if (!"1".equals(getIntent().getStringExtra("openanimtype"))) {
      getActivity().overridePendingTransition(0, 0);
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText() == null) {
        paramTextView = "";
      }
      for (;;)
      {
        JSONObject localJSONObject;
        if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getHint() == null)
        {
          paramKeyEvent = "";
          localJSONObject = new JSONObject();
        }
        try
        {
          localJSONObject.put("searchWord", paramTextView);
          localJSONObject.put("placeholder", paramKeyEvent);
          getWebView().callJs("MixSearchButtonClicked", new String[] { localJSONObject.toString() });
          paramTextView = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
          if (paramTextView != null) {
            paramTextView.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
          }
          this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
          return true;
          paramTextView = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
          continue;
          paramKeyEvent = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getHint().toString().trim();
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("WebLog_WebViewFragment", 1, "onEditorAction, searchWord = " + paramTextView + ", placeholder = " + paramKeyEvent + ", e = " + localJSONException);
          }
        }
      }
    }
    return false;
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    a();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.MixSearchWebFragment
 * JD-Core Version:    0.7.0.1
 */