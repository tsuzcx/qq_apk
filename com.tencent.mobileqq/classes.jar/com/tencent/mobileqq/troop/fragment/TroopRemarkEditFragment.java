package com.tencent.mobileqq.troop.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class TroopRemarkEditFragment
  extends IphoneTitleBarFragment
{
  public static int a = 60;
  public static String a = "param_troopuin";
  public static String b = "param_troopcode";
  public static String c = "param_troopname";
  public static String d = "param_old_troopremark";
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new TroopRemarkEditFragment.1(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private final TroopSettingObserver jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver = new TroopRemarkEditFragment.3(this);
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new TroopRemarkEditFragment.2(this);
  private Button jdField_b_of_type_AndroidWidgetButton;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  private Drawable a()
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(4, this.e);
    if ((localBitmap2 == null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(this.e, 4, true);
    }
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = ImageUtil.f();
    }
    return new BitmapDrawable(localBitmap1);
  }
  
  private void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    this.e = paramIntent.getStringExtra(jdField_a_of_type_JavaLangString);
    this.f = paramIntent.getStringExtra(c);
    this.h = paramIntent.getStringExtra(d);
    this.g = paramIntent.getStringExtra(jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)a(2131379350));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131374367));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)a(2131374368));
  }
  
  private void b()
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (localButton != null) {
      localButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    localButton = this.jdField_b_of_type_AndroidWidgetButton;
    if (localButton != null) {
      localButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
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
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      j = 2131167053;
    } else {
      j = 2131167056;
    }
    int j = getResources().getColor(j);
    Drawable localDrawable = getResources().getDrawable(2130851066);
    localDrawable.setColorFilter(j, PorterDuff.Mode.SRC_ATOP);
    TextView localTextView = (TextView)a(2131369202);
    localTextView.setTextColor(j);
    localTextView.setBackgroundDrawable(localDrawable);
    localTextView.setContentDescription(getString(2131697708));
    localTextView.setOnClickListener(new TroopRemarkEditFragment.7(this));
  }
  
  private void e()
  {
    if ((ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null) ^ true)) {
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
    Object localObject = (ImageView)a(2131379351);
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(a());
    }
    localObject = (TextView)a(2131374366);
    if (localObject != null) {
      ((TextView)localObject).setText(String.format("%s %s ", new Object[] { getString(2131699515), this.f }));
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
      label21:
      break label21;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopRemarkEditFragment", 2, "showInputMethod error");
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (getActivity() != null)
    {
      if (getBaseActivity().app == null) {
        return;
      }
      a(getActivity().getIntent());
      a();
      b();
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver;
      if (paramLayoutInflater != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(paramLayoutInflater);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_set_new", "", "groupnameRemarks", "exp", 0, 0, this.e, "", "", "");
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131562997;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    e();
    ClearableEditText localClearableEditText = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
    if (localClearableEditText != null) {
      localClearableEditText.postDelayed(new TroopRemarkEditFragment.4(this), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment
 * JD-Core Version:    0.7.0.1
 */