package com.tencent.mobileqq.ocr;

import agej;
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
import ayxv;
import ayyb;
import ayyd;
import ayzr;
import ayzs;
import ayzt;
import ayzu;
import ayzv;
import azbv;
import azbx;
import behj;
import bhnv;
import bjbs;
import bplg;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ScrollView;
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
  private ayxv jdField_a_of_type_Ayxv = new ayzr(this);
  private azbv jdField_a_of_type_Azbv;
  private bjbs jdField_a_of_type_Bjbs;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private TranslateController jdField_a_of_type_ComTencentMobileqqOcrTranslateController;
  private TranslateResult jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult;
  private OCRBottomTabView jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private azbv jdField_b_of_type_Azbv;
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
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      this.jdField_a_of_type_Bjbs.dismiss();
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
        ayyb.a("0X800AB95", 2);
        return;
        b(ayyb.a);
      }
    }
    a(2, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
    ayyb.a("0X800AB95", 1);
  }
  
  private void a(int paramInt, TranslateResult paramTranslateResult)
  {
    int k = 2131709459;
    int j = -1;
    this.jdField_a_of_type_Int = paramInt;
    String str;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.getVisibility() == 0))
    {
      str = "#000000";
      if (paramInt != 1) {
        break label299;
      }
      i = 2130841436;
      str = "#00CAFC";
      j = 2131709459;
    }
    for (;;)
    {
      if (paramInt == 2)
      {
        j = 2130841435;
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
          if (ayyb.a != null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TranslateFragment", 2, "src:" + paramTranslateResult.jdField_a_of_type_JavaLangString + ", dst:" + paramTranslateResult.jdField_b_of_type_JavaLangString + ", OCRLanHolder:" + ayyb.a.a());
            }
            ayyb.a.a(paramTranslateResult.jdField_a_of_type_JavaLangString);
            ayyb.a.b(paramTranslateResult.jdField_b_of_type_JavaLangString);
            a(ayyb.a);
          }
        }
        return;
        k = i;
        i = j;
        j = k;
      }
      label299:
      i = -1;
    }
  }
  
  private void a(ayyd paramayyd)
  {
    if (paramayyd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder:" + paramayyd.a());
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramayyd.a(paramayyd.jdField_b_of_type_JavaLangString));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramayyd.a(paramayyd.jdField_c_of_type_JavaLangString));
    if ((paramayyd.jdField_b_of_type_JavaUtilList == null) || (paramayyd.jdField_b_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    while ((paramayyd.jdField_c_of_type_JavaUtilList == null) || (paramayyd.jdField_c_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(true);
      Drawable localDrawable = getResources().getDrawable(2130846171);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setClickable(true);
    paramayyd = getResources().getDrawable(2130846171);
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramayyd);
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString)
  {
    Intent localIntent = new Intent(paramBaseActivity, TranslateFragment.class);
    localIntent.putExtra("TranslateText", paramString);
    PublicFragmentActivity.a(paramBaseActivity, localIntent, TranslateFragment.class);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!bhnv.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131691989, 0).a();
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
    b(2131698248);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "requestTranslate, srcLan:" + paramString1 + ", dstLan:" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.a(this.jdField_a_of_type_JavaLangString, paramString1, paramString2);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bjbs == null)
    {
      this.jdField_a_of_type_Bjbs = new bjbs(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, getResources().getDimensionPixelSize(2131299011));
      this.jdField_a_of_type_Bjbs.c(paramInt);
    }
    if (!getActivity().isFinishing()) {
      this.jdField_a_of_type_Bjbs.show();
    }
  }
  
  private void b(ayyd paramayyd)
  {
    if (paramayyd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "requestTranslate, lanHolder:" + paramayyd.a());
    }
    a(paramayyd.jdField_b_of_type_JavaLangString, paramayyd.jdField_c_of_type_JavaLangString);
  }
  
  private void c(ayyd paramayyd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "showTranslateSrcLanOptions, lanHolder:" + paramayyd.a());
    }
    if ((this.jdField_a_of_type_Azbv != null) && (this.jdField_a_of_type_Azbv.isShowing())) {
      this.jdField_a_of_type_Azbv.dismiss();
    }
    if ((this.jdField_b_of_type_Azbv != null) && (this.jdField_b_of_type_Azbv.isShowing())) {
      this.jdField_b_of_type_Azbv.dismiss();
    }
    while ((paramayyd.jdField_b_of_type_JavaUtilList == null) || (paramayyd.jdField_b_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    while (i < paramayyd.jdField_b_of_type_JavaUtilList.size())
    {
      String str = (String)paramayyd.jdField_b_of_type_JavaUtilList.get(i);
      if (str.equalsIgnoreCase(paramayyd.jdField_b_of_type_JavaLangString)) {
        j = i;
      }
      azbx localazbx = new azbx();
      localazbx.jdField_b_of_type_JavaLangString = str;
      localazbx.jdField_a_of_type_JavaLangString = ayyb.a(str);
      localArrayList.add(localazbx);
      i += 1;
    }
    this.jdField_b_of_type_Azbv = azbv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, j, new ayzs(this, paramayyd));
    i = this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    j = agej.a(75.0F, getResources());
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_Azbv.showAsDropDown(this.jdField_c_of_type_AndroidWidgetTextView, i - j, 0);
    this.jdField_b_of_type_Azbv.setOnDismissListener(new ayzt(this, paramayyd));
  }
  
  private void d(ayyd paramayyd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "showTranslateDstLanOptions, lanHolder:" + paramayyd.a());
    }
    if ((this.jdField_b_of_type_Azbv != null) && (this.jdField_b_of_type_Azbv.isShowing())) {
      this.jdField_b_of_type_Azbv.dismiss();
    }
    if ((this.jdField_a_of_type_Azbv != null) && (this.jdField_a_of_type_Azbv.isShowing())) {
      this.jdField_a_of_type_Azbv.dismiss();
    }
    while ((paramayyd.jdField_c_of_type_JavaUtilList == null) || (paramayyd.jdField_c_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if (i < paramayyd.jdField_c_of_type_JavaUtilList.size())
    {
      String str = (String)paramayyd.jdField_c_of_type_JavaUtilList.get(i);
      if (str.equalsIgnoreCase(paramayyd.jdField_b_of_type_JavaLangString)) {}
      for (;;)
      {
        i += 1;
        break;
        if (str.equalsIgnoreCase(paramayyd.jdField_c_of_type_JavaLangString)) {
          j = i;
        }
        azbx localazbx = new azbx();
        localazbx.jdField_b_of_type_JavaLangString = str;
        localazbx.jdField_a_of_type_JavaLangString = ayyb.a(str);
        localArrayList.add(localazbx);
      }
    }
    this.jdField_a_of_type_Azbv = azbv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, j, new ayzu(this, paramayyd));
    i = this.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    j = agej.a(75.0F, getResources());
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_Azbv.showAsDropDown(this.jdField_d_of_type_AndroidWidgetTextView, i - j, 0);
    this.jdField_a_of_type_Azbv.setOnDismissListener(new ayzv(this, paramayyd));
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c(ayyb.a);
      continue;
      d(ayyb.a);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      continue;
      behj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get(), String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()));
      ayyb.a("0X800AB94", 0);
      continue;
      ayyb.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()));
      ayyb.a("0X800AB93", 0);
      continue;
      behj.a(String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()), "TranslateFragment");
      ayyb.a("0X800AB92", 0);
      continue;
      a(this.jdField_a_of_type_Int);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("TranslateText");
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((QQAppInterface)bplg.a());
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController = new TranslateController((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get());
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Ayxv);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561616, paramViewGroup, false);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379260));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379256));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131379255));
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)paramLayoutInflater.findViewById(2131379278));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379283));
    this.jdField_b_of_type_ComTencentWidgetScrollView = ((ScrollView)paramLayoutInflater.findViewById(2131379280));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379285));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131365087));
    this.jdField_d_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131366321));
    this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131367081));
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131365136));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
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
    paramViewGroup = getResources().getDrawable(2130846169);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
    a(ayyb.a);
    b(ayyb.a);
    boolean bool = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    paramViewGroup = paramLayoutInflater.findViewById(2131372035);
    if (bool) {}
    for (int i = 0;; i = 8)
    {
      paramViewGroup.setVisibility(i);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Ayxv);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment
 * JD-Core Version:    0.7.0.1
 */