package com.tencent.mobileqq.ocr;

import actj;
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
import atzx;
import auad;
import auaf;
import aubt;
import aubu;
import aubv;
import aubw;
import aubx;
import audx;
import audz;
import ayle;
import bbfj;
import bcqf;
import bcql;
import bfyd;
import bjal;
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
  private atzx jdField_a_of_type_Atzx = new aubt(this);
  private audx jdField_a_of_type_Audx;
  private bcqf jdField_a_of_type_Bcqf;
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
  private audx jdField_b_of_type_Audx;
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
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      this.jdField_a_of_type_Bcqf.dismiss();
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
        auad.a("0X800AB95", 2);
        return;
        b(auad.a);
      }
    }
    a(2, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
    auad.a("0X800AB95", 1);
  }
  
  private void a(int paramInt, TranslateResult paramTranslateResult)
  {
    int k = 2131710590;
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
      i = 2130841017;
      str = "#00CAFC";
      j = 2131710590;
    }
    for (;;)
    {
      if (paramInt == 2)
      {
        j = 2130841016;
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
          if (auad.a != null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TranslateFragment", 2, "src:" + paramTranslateResult.jdField_a_of_type_JavaLangString + ", dst:" + paramTranslateResult.jdField_b_of_type_JavaLangString + ", OCRLanHolder:" + auad.a.a());
            }
            auad.a.a(paramTranslateResult.jdField_a_of_type_JavaLangString, paramTranslateResult.jdField_b_of_type_JavaLangString);
            a(auad.a);
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
  
  private void a(auaf paramauaf)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramauaf.a(paramauaf.jdField_b_of_type_JavaLangString));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramauaf.a(paramauaf.jdField_c_of_type_JavaLangString));
    if ((paramauaf.jdField_b_of_type_JavaUtilList == null) || (paramauaf.jdField_b_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    while ((paramauaf.jdField_c_of_type_JavaUtilList == null) || (paramauaf.jdField_c_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(true);
      Drawable localDrawable = getResources().getDrawable(2130845299);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setClickable(true);
    paramauaf = getResources().getDrawable(2130845299);
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramauaf);
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString)
  {
    Intent localIntent = new Intent(paramBaseActivity, TranslateFragment.class);
    localIntent.putExtra("TranslateText", paramString);
    PublicFragmentActivity.a(paramBaseActivity, localIntent, TranslateFragment.class);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!bbfj.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131692321, 0).a();
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
    b(2131699268);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.a(this.jdField_a_of_type_JavaLangString, paramString1, paramString2);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bcqf == null)
    {
      this.jdField_a_of_type_Bcqf = new bcqf(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, getResources().getDimensionPixelSize(2131298865));
      this.jdField_a_of_type_Bcqf.c(paramInt);
    }
    if (!getActivity().isFinishing()) {
      this.jdField_a_of_type_Bcqf.show();
    }
  }
  
  private void b(auaf paramauaf)
  {
    a(paramauaf.jdField_b_of_type_JavaLangString, paramauaf.jdField_c_of_type_JavaLangString);
  }
  
  private void c(auaf paramauaf)
  {
    if ((this.jdField_a_of_type_Audx != null) && (this.jdField_a_of_type_Audx.isShowing())) {
      this.jdField_a_of_type_Audx.dismiss();
    }
    if ((this.jdField_b_of_type_Audx != null) && (this.jdField_b_of_type_Audx.isShowing())) {
      this.jdField_b_of_type_Audx.dismiss();
    }
    while ((paramauaf.jdField_b_of_type_JavaUtilList == null) || (paramauaf.jdField_b_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if (i < paramauaf.jdField_b_of_type_JavaUtilList.size())
    {
      String str = (String)paramauaf.jdField_b_of_type_JavaUtilList.get(i);
      if (str.equalsIgnoreCase(paramauaf.jdField_c_of_type_JavaLangString)) {}
      for (;;)
      {
        i += 1;
        break;
        if (str.equalsIgnoreCase(paramauaf.jdField_b_of_type_JavaLangString)) {
          j = i;
        }
        audz localaudz = new audz();
        localaudz.jdField_b_of_type_JavaLangString = str;
        localaudz.jdField_a_of_type_JavaLangString = auad.a(null, str);
        localArrayList.add(localaudz);
      }
    }
    this.jdField_b_of_type_Audx = audx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, j, new aubu(this, paramauaf));
    i = this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    j = actj.a(75.0F, getResources());
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_Audx.showAsDropDown(this.jdField_c_of_type_AndroidWidgetTextView, i - j, 0);
    this.jdField_b_of_type_Audx.setOnDismissListener(new aubv(this, paramauaf));
  }
  
  private void d(auaf paramauaf)
  {
    if ((this.jdField_b_of_type_Audx != null) && (this.jdField_b_of_type_Audx.isShowing())) {
      this.jdField_b_of_type_Audx.dismiss();
    }
    if ((this.jdField_a_of_type_Audx != null) && (this.jdField_a_of_type_Audx.isShowing())) {
      this.jdField_a_of_type_Audx.dismiss();
    }
    while ((paramauaf.jdField_c_of_type_JavaUtilList == null) || (paramauaf.jdField_c_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if (i < paramauaf.jdField_c_of_type_JavaUtilList.size())
    {
      String str = (String)paramauaf.jdField_c_of_type_JavaUtilList.get(i);
      if (str.equalsIgnoreCase(paramauaf.jdField_b_of_type_JavaLangString)) {}
      for (;;)
      {
        i += 1;
        break;
        if (str.equalsIgnoreCase(paramauaf.jdField_c_of_type_JavaLangString)) {
          j = i;
        }
        audz localaudz = new audz();
        localaudz.jdField_b_of_type_JavaLangString = str;
        localaudz.jdField_a_of_type_JavaLangString = auad.a(null, str);
        localArrayList.add(localaudz);
      }
    }
    this.jdField_a_of_type_Audx = audx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, j, new aubw(this, paramauaf));
    i = this.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    j = actj.a(75.0F, getResources());
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_Audx.showAsDropDown(this.jdField_d_of_type_AndroidWidgetTextView, i - j, 0);
    this.jdField_a_of_type_Audx.setOnDismissListener(new aubx(this, paramauaf));
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
      c(auad.a);
      return;
    case 2131377643: 
      d(auad.a);
      return;
    case 2131377642: 
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      return;
    case 2131365929: 
      ayle.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get(), String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()));
      auad.a("0X800AB94", 0);
      return;
    case 2131366634: 
      auad.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()));
      auad.a("0X800AB93", 0);
      return;
    case 2131364774: 
      ayle.a(String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()), "TranslateFragment");
      auad.a("0X800AB92", 0);
      return;
    }
    a(this.jdField_a_of_type_Int);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      bfyd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((QQAppInterface)bjal.a());
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController = new TranslateController((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get());
    getActivity().addObserver(this.jdField_a_of_type_Atzx);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("TranslateText");
    paramBundle = new Intent();
    paramBundle.putExtra("PARAM_FROM", 1);
    getActivity().setResult(1, paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561137, paramViewGroup, false);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131377647));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131377643));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131377648));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131377642));
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)paramLayoutInflater.findViewById(2131377665));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131377670));
    this.jdField_b_of_type_ComTencentWidgetScrollView = ((ScrollView)paramLayoutInflater.findViewById(2131377667));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131377672));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131364728));
    this.jdField_d_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131365929));
    this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131366634));
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131364774));
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
    paramViewGroup = getResources().getDrawable(2130845297);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
    paramViewGroup = getResources().getDrawable(2130845301);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
    a(auad.a);
    b(auad.a);
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Atzx);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment
 * JD-Core Version:    0.7.0.1
 */