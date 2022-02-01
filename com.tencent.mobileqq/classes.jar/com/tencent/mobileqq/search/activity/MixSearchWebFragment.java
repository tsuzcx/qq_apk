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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class MixSearchWebFragment
  extends WebViewFragment
  implements TextWatcher, TextView.OnEditorActionListener
{
  protected RelativeLayout a;
  protected QuickPinyinEditText b;
  protected Button c;
  protected ImageButton d;
  protected ImageView e;
  public String f;
  
  private void a()
  {
    RelativeLayout localRelativeLayout = this.a;
    if (localRelativeLayout == null) {
      return;
    }
    localRelativeLayout.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852486));
    this.c.setTextColor(Color.parseColor("#777777"));
    this.c.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852489));
    this.b.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852498));
    this.b.setCompoundDrawablesWithIntrinsicBounds(SkinEngine.getInstances().getDefaultThemeDrawable(2130852493), null, null, null);
    this.b.setPadding(UIUtils.a(getQBaseActivity(), 10.0F), this.b.getPaddingTop(), this.b.getPaddingRight(), this.b.getPaddingBottom());
    this.b.setTextColor(-16777216);
    this.b.setHintTextColor(Color.parseColor("#a6a6a6"));
  }
  
  private void a(Bundle paramBundle)
  {
    if ("1".equals(getIntent().getStringExtra("showloadingbar"))) {
      getUIStyleHandler().w.a(true);
    } else {
      getUIStyleHandler().w.a(false);
    }
    if ((getSwiftTitleUI().o.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      Object localObject2 = BaseApplicationImpl.getApplication();
      getSwiftTitleUI().o.setVisibility(8);
      Object localObject1 = (ViewGroup)getSwiftTitleUI().o.getParent();
      paramBundle = LayoutInflater.from((Context)localObject2).inflate(2131627783, null);
      int i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
      localObject2 = new RelativeLayout.LayoutParams(-1, (int)((Context)localObject2).getResources().getDimension(2131299920));
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      ((ViewGroup)localObject1).addView(paramBundle, (ViewGroup.LayoutParams)localObject2);
      this.b = ((QuickPinyinEditText)paramBundle.findViewById(2131432634));
      this.b.setOnEditorActionListener(this);
      this.b.addTextChangedListener(this);
      this.b.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
      localObject1 = this.b;
      ((QuickPinyinEditText)localObject1).a = 50;
      ((QuickPinyinEditText)localObject1).setImeOptions(3);
      this.b.setHint(getIntent().getStringExtra("placeholder"));
      this.f = getIntent().getStringExtra("searchword");
      this.d = ((ImageButton)paramBundle.findViewById(2131435215));
      this.d.setOnClickListener(new MixSearchWebFragment.2(this));
      this.c = ((Button)paramBundle.findViewById(2131429816));
      this.c.setText(2131887648);
      this.c.setOnClickListener(new MixSearchWebFragment.3(this));
      if ("1".equals(getIntent().getStringExtra("hiderightbtn"))) {
        this.c.setVisibility(8);
      } else {
        this.c.setVisibility(0);
      }
      this.e = ((ImageView)paramBundle.findViewById(2131436275));
      if ("1".equals(getIntent().getStringExtra("hideleftarrow"))) {
        this.e.setVisibility(8);
      } else {
        this.e.setVisibility(0);
      }
      if ((this.c.getVisibility() == 8) && (this.e.getVisibility() == 8)) {
        this.c.setVisibility(0);
      }
      this.e.setOnClickListener(new MixSearchWebFragment.4(this));
      this.b.getViewTreeObserver().addOnGlobalLayoutListener(new MixSearchWebFragment.5(this));
      if (!TextUtils.isEmpty(this.f))
      {
        if (this.f.length() > 50) {
          this.f = this.f.substring(0, 50);
        }
        this.b.setText(this.f);
      }
      this.a = ((RelativeLayout)paramBundle);
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
    QuickPinyinEditText localQuickPinyinEditText = this.b;
    if (localQuickPinyinEditText != null)
    {
      localQuickPinyinEditText.setHint(paramString2);
      this.b.setText(paramString1);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (TextUtils.isEmpty(paramEditable)) {
      this.d.setVisibility(8);
    } else {
      this.d.setVisibility(0);
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
    boolean bool = true;
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66)))
    {
      bool = false;
    }
    else
    {
      Object localObject = this.b.getText();
      String str = "";
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = this.b.getText().toString().trim();
      }
      if (this.b.getHint() != null) {
        str = this.b.getHint().toString().trim();
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("searchWord", localObject);
        localJSONObject.put("placeholder", str);
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEditorAction, searchWord = ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", placeholder = ");
        localStringBuilder.append(str);
        localStringBuilder.append(", e = ");
        localStringBuilder.append(localJSONException);
        QLog.e("WebLog_WebViewFragment", 1, localStringBuilder.toString());
      }
      getWebView().callJs("MixSearchButtonClicked", new String[] { localJSONObject.toString() });
      localObject = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
      if (localObject != null) {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(this.b.getWindowToken(), 0);
      }
      this.b.clearFocus();
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    a();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.MixSearchWebFragment
 * JD-Core Version:    0.7.0.1
 */