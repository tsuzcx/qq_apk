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
import avqz;
import avrb;
import avts;
import avtv;
import avtw;
import avtx;
import avty;
import avtz;
import azmj;
import bcvq;
import bdah;
import bdcq;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;

public class OCRTextSearchActivity
  extends FragmentActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  View jdField_a_of_type_AndroidViewView;
  public InputMethodManager a;
  public EditText a;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  avrb jdField_a_of_type_Avrb = new avtv(this);
  public avts a;
  public avty a;
  private avtz jdField_a_of_type_Avtz = new avtz(this, null);
  public SearchResultFragment a;
  String jdField_a_of_type_JavaLangString;
  View jdField_b_of_type_AndroidViewView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  String jdField_b_of_type_JavaLangString;
  public String c;
  
  public OCRTextSearchActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = null;
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
    this.jdField_a_of_type_Avts = new avtx(this);
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
    bdah.a(false);
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
    azmj.b(null, "dc00898", "", "", "0X80082EE", "0X80082EE", 0, 0, "", "", "", "");
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Avtz);
    this.app.addObserver(this.jdField_a_of_type_Avrb);
  }
  
  public void a(int paramInt)
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
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_Avtz);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Avtz);
  }
  
  public void a(boolean paramBoolean)
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
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131376000));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131376171));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365849));
    this.jdField_a_of_type_AndroidWidgetEditText.setHintTextColor(-1431918938);
    this.jdField_a_of_type_AndroidWidgetEditText.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367807));
    bcvq.a(this.jdField_a_of_type_AndroidWidgetEditText, getString(2131691211));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
    localLayoutParams.width = ((int)bdcq.a(this, 22.0F));
    localLayoutParams.height = ((int)bdcq.a(this, 22.0F));
    this.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams(localLayoutParams);
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363520)).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368697));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131376225));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131375671);
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)super.getSystemService("input_method"));
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new avtw(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370067);
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void b(int paramInt)
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
    localFragmentTransaction.add(2131375671, this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment, "search_result");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public void b(String paramString)
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
    avqz localavqz = (avqz)this.app.getManager(228);
    this.c = avqz.a(this.app);
    localavqz.a(this.c, paramString, SystemClock.elapsedRealtime());
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
  
  public void doOnBackPressed()
  {
    finish();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_Avty != null) {
      this.jdField_a_of_type_Avty.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = getSupportFragmentManager();
    setContentView(2131561113);
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
      this.jdField_a_of_type_Avty = new avty(this);
      this.jdField_a_of_type_Avty.a(false);
    } while (paramBundle == null);
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = ((SearchResultFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("search_result"));
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Avrb);
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
    this.jdField_a_of_type_Avty.onStart();
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
    setResult(-1);
    super.finish();
    overridePendingTransition(0, 2130771989);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367807: 
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
      return;
    case 2131376000: 
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      return;
    case 2131365849: 
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      return;
    }
    finish();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity
 * JD-Core Version:    0.7.0.1
 */