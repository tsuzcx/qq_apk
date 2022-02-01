package com.tencent.mobileqq.ocr.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ocr.OCRManager;
import com.tencent.mobileqq.ocr.OCRObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.widget.immersive.ImmersiveUtils;

public class OCRTextSearchActivity
  extends FragmentActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  View jdField_a_of_type_AndroidViewView;
  InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  OCRObserver jdField_a_of_type_ComTencentMobileqqOcrOCRObserver = new OCRTextSearchActivity.1(this);
  public BaseOCRTextSearchFragment.SearchActivityInterface a;
  OCRTextSearchActivity.MyFlingGestureHandler jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$MyFlingGestureHandler;
  private OCRTextSearchActivity.SearchTextWatcher jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$SearchTextWatcher = new OCRTextSearchActivity.SearchTextWatcher(this, null);
  SearchResultFragment jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = null;
  String jdField_a_of_type_JavaLangString;
  View jdField_b_of_type_AndroidViewView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  String jdField_b_of_type_JavaLangString;
  String c;
  
  public OCRTextSearchActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface = new OCRTextSearchActivity.3(this);
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent(paramBaseActivity, OCRTextSearchActivity.class);
    localIntent.putExtra("keyWord", paramString);
    paramBaseActivity.startActivity(localIntent);
    paramBaseActivity.overridePendingTransition(0, 0);
    ThreadPriorityManager.a(false);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText() != null) {}
    for (String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();; str1 = "")
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = this.jdField_a_of_type_AndroidWidgetEditText.getHint().toString();
      }
      str1 = str2.trim();
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_JavaLangString = null;
    c(str1);
    a(true);
    ReportController.b(null, "dc00898", "", "", "0X80082EE", "0X80082EE", 0, 0, "", "", "", "");
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$SearchTextWatcher);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqOcrOCRObserver);
  }
  
  protected void a(int paramInt)
  {
    if (isFinishing()) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        d(1);
        this.jdField_a_of_type_Int = 0;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment == null);
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment.a();
    return;
    c(1);
    this.jdField_a_of_type_Int = 1;
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$SearchTextWatcher);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$SearchTextWatcher);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      a(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
  }
  
  @TargetApi(14)
  protected void b()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131377376));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131377580));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366452));
    this.jdField_a_of_type_AndroidWidgetEditText.setHintTextColor(-1431918938);
    this.jdField_a_of_type_AndroidWidgetEditText.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368600));
    AccessibilityUtil.a(this.jdField_a_of_type_AndroidWidgetEditText, getString(2131691248));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
    localLayoutParams.width = ((int)DisplayUtils.a(this, 22.0F));
    localLayoutParams.height = ((int)DisplayUtils.a(this, 22.0F));
    this.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams(localLayoutParams);
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363942)).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369579));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131377638));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131376997);
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)super.getSystemService("input_method"));
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new OCRTextSearchActivity.2(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131371065);
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  void b(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment != null);
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = new SearchResultFragment();
    FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    localFragmentTransaction.add(2131376997, this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment, "search_result");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  protected void b(String paramString)
  {
    if (paramString.equals(""))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
  }
  
  void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("search_result") == null) {
      b(paramInt);
    }
    FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    localFragmentTransaction.show(this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public void c(String paramString)
  {
    OCRManager localOCRManager = (OCRManager)this.app.getManager(QQManagerFactory.OCR_MANAGER);
    this.c = OCRManager.a(this.app);
    localOCRManager.a(this.c, paramString, SystemClock.elapsedRealtime());
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  void d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("search_result") == null) {
      b(paramInt);
    }
    FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    finish();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$MyFlingGestureHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$MyFlingGestureHandler.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = getSupportFragmentManager();
    setContentView(2131561422);
    b();
    Object localObject = getIntent();
    if (localObject == null) {
      finish();
    }
    do
    {
      return true;
      a();
      a(this.jdField_a_of_type_Int);
      localObject = ((Intent)localObject).getStringExtra("keyWord");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        a((String)localObject);
        c((String)localObject);
        a(true);
        this.jdField_a_of_type_Int = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$MyFlingGestureHandler = new OCRTextSearchActivity.MyFlingGestureHandler(this);
      this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$MyFlingGestureHandler.a(false);
    } while (paramBundle == null);
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = ((SearchResultFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("search_result"));
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqOcrOCRObserver);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("keyWord");
    if (!TextUtils.isEmpty(paramIntent))
    {
      a(paramIntent);
      c(paramIntent);
      a(true);
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Int == 0)
    {
      super.getWindow().setSoftInputMode(36);
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      return;
    }
    super.getWindow().setSoftInputMode(34);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
  }
  
  public void doOnStart()
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrUiOCRTextSearchActivity$MyFlingGestureHandler.onStart();
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
    setResult(-1);
    super.finish();
    overridePendingTransition(0, 2130771991);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
      continue;
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      continue;
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      continue;
      finish();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity
 * JD-Core Version:    0.7.0.1
 */