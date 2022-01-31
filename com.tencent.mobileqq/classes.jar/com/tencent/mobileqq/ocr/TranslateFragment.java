package com.tencent.mobileqq.ocr;

import actn;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import atzv;
import auab;
import auad;
import aubr;
import aubs;
import aubt;
import aubu;
import aubv;
import audv;
import audx;
import aylc;
import bbev;
import bcpq;
import bcpw;
import bfxm;
import bizu;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public class TranslateFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 2;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atzv jdField_a_of_type_Atzv = new aubr(this);
  private audv jdField_a_of_type_Audv;
  private bcpq jdField_a_of_type_Bcpq;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private TranslateController jdField_a_of_type_ComTencentMobileqqOcrTranslateController;
  private TranslateResult jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult;
  private OCRBottomTabView jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private audv jdField_b_of_type_Audv;
  private OCRBottomTabView jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  private ScrollView jdField_b_of_type_ComTencentWidgetScrollView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private OCRBottomTabView jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private OCRBottomTabView jdField_d_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  
  private CharSequence a(int paramInt, TranslateResult paramTranslateResult)
  {
    if (paramInt == 1) {
      return paramTranslateResult.b();
    }
    if (paramInt == 2) {
      return paramTranslateResult.a();
    }
    return "";
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
      this.jdField_a_of_type_Bcpq.dismiss();
    }
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      if (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null) {
        a(1, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
      }
      for (;;)
      {
        auab.a("0X800AB95", 2);
        return;
        b(auab.a);
      }
    }
    a(2, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
    auab.a("0X800AB95", 1);
  }
  
  private void a(int paramInt, TranslateResult paramTranslateResult)
  {
    int k = 2131710579;
    int j = -1;
    this.jdField_a_of_type_Int = paramInt;
    String str;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.getVisibility() == 0))
    {
      str = "#000000";
      if (paramInt != 1) {
        break label293;
      }
      i = 2130841020;
      str = "#00CAFC";
      j = 2131710579;
    }
    for (;;)
    {
      if (paramInt == 2)
      {
        j = 2130841019;
        str = "#000000";
        i = k;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabImage(getResources().getDrawable(j));
        this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabText(getResources().getString(i));
        this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabTextColor(Color.parseColor(str));
        if (paramTranslateResult != null)
        {
          if (paramInt == 2)
          {
            this.jdField_a_of_type_ComTencentWidgetScrollView.setVisibility(0);
            this.jdField_b_of_type_ComTencentWidgetScrollView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(a(paramInt, paramTranslateResult));
          }
          if (paramInt == 1)
          {
            this.jdField_b_of_type_ComTencentWidgetScrollView.setVisibility(0);
            this.jdField_a_of_type_ComTencentWidgetScrollView.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(a(paramInt, paramTranslateResult));
          }
          if (auab.a != null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TranslateFragment", 2, "src:" + paramTranslateResult.jdField_a_of_type_JavaLangString + ", dst:" + paramTranslateResult.jdField_b_of_type_JavaLangString + ", OCRLanHolder:" + auab.a.a());
            }
            auab.a.a(paramTranslateResult.jdField_a_of_type_JavaLangString, paramTranslateResult.jdField_b_of_type_JavaLangString);
            a(auab.a);
          }
        }
        return;
        k = i;
        i = j;
        j = k;
      }
      label293:
      i = -1;
    }
  }
  
  private void a(auad paramauad)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramauad.a(paramauad.jdField_b_of_type_JavaLangString));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramauad.a(paramauad.jdField_c_of_type_JavaLangString));
    if ((paramauad.jdField_b_of_type_JavaUtilList == null) || (paramauad.jdField_b_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    while ((paramauad.jdField_c_of_type_JavaUtilList == null) || (paramauad.jdField_c_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(true);
      Drawable localDrawable = getResources().getDrawable(2130845297);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setClickable(true);
    paramauad = getResources().getDrawable(2130845297);
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramauad);
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString)
  {
    Intent localIntent = new Intent(paramBaseActivity, TranslateFragment.class);
    localIntent.putExtra("TranslateText", paramString);
    PublicFragmentActivity.a(paramBaseActivity, localIntent, TranslateFragment.class);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!bbev.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131692321, 0).a();
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.d("TranslateFragment", 1, "requestTranslate, mInputTransText null");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("TranslateFragment", 1, "requestTranslate, in translate request,");
      return;
    }
    b(2131699258);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.a(this.jdField_a_of_type_JavaLangString, paramString1, paramString2);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bcpq == null)
    {
      this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, getResources().getDimensionPixelSize(2131298865));
      this.jdField_a_of_type_Bcpq.c(paramInt);
    }
    if (!getActivity().isFinishing()) {
      this.jdField_a_of_type_Bcpq.show();
    }
  }
  
  private void b(auad paramauad)
  {
    a(paramauad.jdField_b_of_type_JavaLangString, paramauad.jdField_c_of_type_JavaLangString);
  }
  
  private void c(auad paramauad)
  {
    if ((this.jdField_a_of_type_Audv != null) && (this.jdField_a_of_type_Audv.isShowing())) {
      this.jdField_a_of_type_Audv.dismiss();
    }
    if ((this.jdField_b_of_type_Audv != null) && (this.jdField_b_of_type_Audv.isShowing())) {
      this.jdField_b_of_type_Audv.dismiss();
    }
    while ((paramauad.jdField_b_of_type_JavaUtilList == null) || (paramauad.jdField_b_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if (i < paramauad.jdField_b_of_type_JavaUtilList.size())
    {
      String str = (String)paramauad.jdField_b_of_type_JavaUtilList.get(i);
      if (str.equalsIgnoreCase(paramauad.jdField_c_of_type_JavaLangString)) {}
      for (;;)
      {
        i += 1;
        break;
        if (str.equalsIgnoreCase(paramauad.jdField_b_of_type_JavaLangString)) {
          j = i;
        }
        audx localaudx = new audx();
        localaudx.jdField_b_of_type_JavaLangString = str;
        localaudx.jdField_a_of_type_JavaLangString = auab.a(null, str);
        localArrayList.add(localaudx);
      }
    }
    this.jdField_b_of_type_Audv = audv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, j, new aubs(this, paramauad));
    i = this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    j = actn.a(75.0F, getResources());
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_Audv.showAsDropDown(this.jdField_c_of_type_AndroidWidgetTextView, i - j, 0);
    this.jdField_b_of_type_Audv.setOnDismissListener(new aubt(this, paramauad));
  }
  
  private void d(auad paramauad)
  {
    if ((this.jdField_b_of_type_Audv != null) && (this.jdField_b_of_type_Audv.isShowing())) {
      this.jdField_b_of_type_Audv.dismiss();
    }
    if ((this.jdField_a_of_type_Audv != null) && (this.jdField_a_of_type_Audv.isShowing())) {
      this.jdField_a_of_type_Audv.dismiss();
    }
    while ((paramauad.jdField_c_of_type_JavaUtilList == null) || (paramauad.jdField_c_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if (i < paramauad.jdField_c_of_type_JavaUtilList.size())
    {
      String str = (String)paramauad.jdField_c_of_type_JavaUtilList.get(i);
      if (str.equalsIgnoreCase(paramauad.jdField_b_of_type_JavaLangString)) {}
      for (;;)
      {
        i += 1;
        break;
        if (str.equalsIgnoreCase(paramauad.jdField_c_of_type_JavaLangString)) {
          j = i;
        }
        audx localaudx = new audx();
        localaudx.jdField_b_of_type_JavaLangString = str;
        localaudx.jdField_a_of_type_JavaLangString = auab.a(null, str);
        localArrayList.add(localaudx);
      }
    }
    this.jdField_a_of_type_Audv = audv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, j, new aubu(this, paramauad));
    i = this.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    j = actn.a(75.0F, getResources());
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_Audv.showAsDropDown(this.jdField_d_of_type_AndroidWidgetTextView, i - j, 0);
    this.jdField_a_of_type_Audv.setOnDismissListener(new aubv(this, paramauad));
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771979, 2130771977);
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(1);
    if (Build.VERSION.SDK_INT >= 19) {
      paramActivity.getWindow().addFlags(134217728);
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramActivity);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131377648: 
    default: 
      return;
    case 2131377647: 
      c(auab.a);
      return;
    case 2131377643: 
      d(auab.a);
      return;
    case 2131377642: 
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      return;
    case 2131365929: 
      aylc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get(), String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()));
      auab.a("0X800AB94", 0);
      return;
    case 2131366634: 
      auab.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()));
      auab.a("0X800AB93", 0);
      return;
    case 2131364775: 
      aylc.a(String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()), "TranslateFragment");
      auab.a("0X800AB92", 0);
      return;
    }
    a(this.jdField_a_of_type_Int);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      bfxm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((QQAppInterface)bizu.a());
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController = new TranslateController((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get());
    getActivity().addObserver(this.jdField_a_of_type_Atzv);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("TranslateText");
    paramBundle = new Intent();
    paramBundle.putExtra("PARAM_FROM", 1);
    getActivity().setResult(1, paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561138, paramViewGroup, false);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131377647));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131377643));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131377648));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131377642));
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)paramLayoutInflater.findViewById(2131377665));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131377670));
    this.jdField_b_of_type_ComTencentWidgetScrollView = ((ScrollView)paramLayoutInflater.findViewById(2131377667));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131377672));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131364729));
    this.jdField_d_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131365929));
    this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131366634));
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131364775));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#03081A"));
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#03081A"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabTextColor(-16777216);
    this.jdField_d_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabTextColor(-16777216);
    this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabTextColor(-16777216);
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    paramViewGroup = getResources().getDrawable(2130845295);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
    paramViewGroup = getResources().getDrawable(2130845299);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
    a(auab.a);
    b(auab.a);
    boolean bool = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    paramViewGroup = paramLayoutInflater.findViewById(2131371024);
    if (bool) {}
    for (int i = 0;; i = 8)
    {
      paramViewGroup.setVisibility(i);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Atzv);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment
 * JD-Core Version:    0.7.0.1
 */