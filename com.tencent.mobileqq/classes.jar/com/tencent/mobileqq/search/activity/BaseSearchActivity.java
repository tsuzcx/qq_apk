package com.tencent.mobileqq.search.activity;

import ahrt;
import ahru;
import ahrv;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.util.SearchStatisticsConstants;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public abstract class BaseSearchActivity
  extends FragmentActivity
  implements TextWatcher, TextView.OnEditorActionListener
{
  public static int b;
  public int a;
  protected Button a;
  protected ImageButton a;
  protected ImageView a;
  protected BaseSearchActivity.CancelReceiver a;
  protected BaseSearchFragment a;
  public QuickPinyinEditText a;
  protected boolean a;
  protected ImageButton b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public String d;
  
  static
  {
    jdField_b_of_type_Int = -1;
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)super.findViewById(2131368322));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(a());
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    if ("1".equals(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.search_input_type.name(), "0"))) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setInputType(524321);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getInputExtras(true).putInt("QUICK_SEARCH", 1);
      }
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131368323));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new ahrt(this));
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131370344));
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131368321));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131433015);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ahru(this));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131371260));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ahrv(this));
      return;
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setInputType(524289);
    }
  }
  
  protected int a()
  {
    return 2130970596;
  }
  
  public abstract BaseSearchFragment a();
  
  public String a()
  {
    return "搜索";
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "cancelType-3 ResultModule:" + SearchStatisticsConstants.a());
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E13", "0X8005E13", 0, 0, "3", "", SearchStatisticsConstants.a(), "");
    a(this, new Intent("com.tencent.mobileqq.search.cancel"));
    jdField_b_of_type_Int = 0;
    finish();
  }
  
  protected void a(String paramString)
  {
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment.a(paramString);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    for (;;)
    {
      paramEditable = paramEditable.trim();
      if (!paramEditable.equals(this.jdField_b_of_type_JavaLangString)) {
        com.tencent.mobileqq.search.util.SearchUtils.b = 0L;
      }
      a(paramEditable);
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    jdField_b_of_type_Int = -1;
    super.doOnCreate(paramBundle);
    super.setContentView(a());
    paramBundle = super.findViewById(2131362840);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      paramBundle.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_Int = super.getIntent().getIntExtra("extra_key_fts_type", 0);
    c();
    this.jdField_b_of_type_JavaLangString = super.getIntent().getStringExtra("keyword");
    paramBundle = super.getSupportFragmentManager();
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment = a();
    paramBundle = paramBundle.beginTransaction();
    paramBundle.replace(2131371266, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment);
    paramBundle.commit();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(this.jdField_b_of_type_JavaLangString.length());
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment.a(this.jdField_b_of_type_JavaLangString);
      b();
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchActivityBaseSearchActivity$CancelReceiver = new BaseSearchActivity.CancelReceiver(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.search.cancel");
    super.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqSearchActivityBaseSearchActivity$CancelReceiver, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchActivityBaseSearchActivity$CancelReceiver != null)
      {
        super.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqSearchActivityBaseSearchActivity$CancelReceiver);
        this.jdField_a_of_type_ComTencentMobileqqSearchActivityBaseSearchActivity$CancelReceiver = null;
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusable(false);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusableInTouchMode(false);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getParent() != null) {
          ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText);
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(null);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          localError.printStackTrace();
        }
      }
      com.tencent.mobileqq.search.util.SearchUtils.a = null;
      jdField_b_of_type_Int = -1;
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
      }
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.jdField_a_of_type_Boolean = false;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      paramTextView = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
      if (!TextUtils.isEmpty(paramTextView)) {
        a(paramTextView);
      }
      b();
      return true;
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.BaseSearchActivity
 * JD-Core Version:    0.7.0.1
 */