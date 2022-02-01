package com.tencent.mobileqq.troop.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class TroopRemarkEditFragment
  extends IphoneTitleBarFragment
{
  public static int a;
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new TroopRemarkEditFragment.1(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopRemarkEditFragment.3(this);
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new TroopRemarkEditFragment.2(this);
  private Button jdField_b_of_type_AndroidWidgetButton;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  static
  {
    jdField_a_of_type_JavaLangString = "param_troopuin";
    jdField_b_of_type_JavaLangString = "param_troopcode";
    c = "param_troopname";
    d = "param_old_troopremark";
    jdField_a_of_type_Int = 60;
  }
  
  private Drawable a()
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(4, this.e);
    if ((localBitmap2 == null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(this.e, 4, true);
    }
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = ImageUtil.c();
    }
    return new BitmapDrawable(localBitmap1);
  }
  
  private void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.e = paramIntent.getStringExtra(jdField_a_of_type_JavaLangString);
    this.f = paramIntent.getStringExtra(c);
    this.h = paramIntent.getStringExtra(d);
    this.g = paramIntent.getStringExtra(jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)a(2131380021));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131374832));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)a(2131374833));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  private void b(EditText paramEditText)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
    if (localInputMethodManager.isActive())
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopRemarkEditFragment", 2, "hideInputMethod()");
      }
      localInputMethodManager.hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setInputType(131072);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCanMultiLine(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonStyle(1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSingleLine(false);
    TroopRemarkEditFragment.5 local5 = new TroopRemarkEditFragment.5(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFilters(new InputFilter[] { local5 });
    if (!TextUtils.isEmpty(this.h))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(this.h);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(this.h.length());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(new TroopRemarkEditFragment.6(this));
  }
  
  private void d()
  {
    hideTitleBar();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {}
    for (int j = 2131167030;; j = 2131167033)
    {
      j = getResources().getColor(j);
      Drawable localDrawable = getResources().getDrawable(2130851150);
      localDrawable.setColorFilter(j, PorterDuff.Mode.SRC_ATOP);
      TextView localTextView = (TextView)a(2131369487);
      localTextView.setTextColor(j);
      localTextView.setBackgroundDrawable(localDrawable);
      localTextView.setContentDescription(getString(2131697702));
      localTextView.setOnClickListener(new TroopRemarkEditFragment.7(this));
      return;
    }
  }
  
  private void e()
  {
    int j = 0;
    if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      j = 1;
    }
    if (j != 0) {
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    }
  }
  
  protected final <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  protected void a()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.titleRoot.setFitsSystemWindows(false);
      this.titleRoot.setPadding(0, 0, 0, 0);
    }
    d();
    c();
    Object localObject = (ImageView)a(2131380022);
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(a());
    }
    localObject = (TextView)a(2131374831);
    if (localObject != null) {
      ((TextView)localObject).setText(String.format("%s %s ", new Object[] { getString(2131699410), this.f }));
    }
  }
  
  void a(EditText paramEditText)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
    try
    {
      localInputMethodManager.showSoftInput(paramEditText, 0);
      return;
    }
    catch (Exception paramEditText)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopRemarkEditFragment", 2, "showInputMethod error");
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity() == null) || (getActivity().app == null)) {
      return;
    }
    a(getActivity().getIntent());
    a();
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_set_new", "", "groupnameRemarks", "exp", 0, 0, this.e, "", "", "");
  }
  
  public int getContentLayoutId()
  {
    return 2131563173;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.postDelayed(new TroopRemarkEditFragment.4(this), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment
 * JD-Core Version:    0.7.0.1
 */