package com.tencent.mobileqq.ocr;

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
import ayri;
import ayrt;
import ayru;
import ayti;
import aytj;
import aytk;
import aytl;
import aytm;
import ayvo;
import ayvq;
import behe;
import bisl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;

public class TranslateFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 2;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ayri jdField_a_of_type_Ayri = new ayti(this);
  private ayvo jdField_a_of_type_Ayvo;
  private bisl jdField_a_of_type_Bisl;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private TranslateController jdField_a_of_type_ComTencentMobileqqOcrTranslateController;
  private TranslateResult jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult;
  private OCRBottomTabView jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ayvo jdField_b_of_type_Ayvo;
  private OCRBottomTabView jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  private ScrollView jdField_b_of_type_ComTencentWidgetScrollView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private OCRBottomTabView jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private OCRBottomTabView jdField_d_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  
  private CharSequence a(int paramInt, TranslateResult paramTranslateResult)
  {
    if (paramInt == 1) {
      return paramTranslateResult.d();
    }
    if (paramInt == 2) {
      return paramTranslateResult.b();
    }
    return "";
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.dismiss();
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
        ayrt.a("0X800AB95", 2);
        return;
        b(ayrt.b);
      }
    }
    a(2, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
    ayrt.a("0X800AB95", 1);
  }
  
  private void a(int paramInt, TranslateResult paramTranslateResult)
  {
    int k = 2131710038;
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
      i = 2130841478;
      str = "#00CAFC";
      j = 2131710038;
    }
    for (;;)
    {
      if (paramInt == 2)
      {
        j = 2130841477;
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
          if (ayrt.b != null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TranslateFragment", 2, "src:" + paramTranslateResult.jdField_a_of_type_JavaLangString + ", dst:" + paramTranslateResult.jdField_b_of_type_JavaLangString + ", OCRLanHolder:" + ayrt.b.a());
            }
            ayrt.b.b(paramTranslateResult.jdField_a_of_type_JavaLangString);
            ayrt.b.c(paramTranslateResult.jdField_b_of_type_JavaLangString);
            a(ayrt.b);
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
  
  private void a(ayru paramayru)
  {
    if (paramayru == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder:" + paramayru.a());
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramayru.a(paramayru.jdField_b_of_type_JavaLangString));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramayru.a(paramayru.jdField_c_of_type_JavaLangString));
    if ((paramayru.jdField_b_of_type_JavaUtilList == null) || (paramayru.jdField_b_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    while ((paramayru.jdField_c_of_type_JavaUtilList == null) || (paramayru.jdField_c_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(true);
      Drawable localDrawable = getResources().getDrawable(2130846150);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setClickable(true);
    paramayru = getResources().getDrawable(2130846150);
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramayru);
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString)
  {
    Intent localIntent = new Intent(paramBaseActivity, TranslateFragment.class);
    localIntent.putExtra("TranslateText", paramString);
    PublicFragmentActivity.a(paramBaseActivity, localIntent, TranslateFragment.class);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131692125, 0).a();
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
    b(2131698709);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "requestTranslate, srcLan:" + paramString1 + ", dstLan:" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.a(this.jdField_a_of_type_JavaLangString, paramString1, paramString2);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bisl == null)
    {
      this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, getResources().getDimensionPixelSize(2131299080));
      this.jdField_a_of_type_Bisl.c(paramInt);
    }
    if (!getActivity().isFinishing()) {
      this.jdField_a_of_type_Bisl.show();
    }
  }
  
  private void b(ayru paramayru)
  {
    if (paramayru == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "requestTranslate, lanHolder:" + paramayru.a());
    }
    a(paramayru.jdField_b_of_type_JavaLangString, paramayru.jdField_c_of_type_JavaLangString);
  }
  
  private void c(ayru paramayru)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "showTranslateSrcLanOptions, lanHolder:" + paramayru.a());
    }
    if ((this.jdField_a_of_type_Ayvo != null) && (this.jdField_a_of_type_Ayvo.isShowing())) {
      this.jdField_a_of_type_Ayvo.dismiss();
    }
    if ((this.jdField_b_of_type_Ayvo != null) && (this.jdField_b_of_type_Ayvo.isShowing())) {
      this.jdField_b_of_type_Ayvo.dismiss();
    }
    while ((paramayru.jdField_b_of_type_JavaUtilList == null) || (paramayru.jdField_b_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    while (i < paramayru.jdField_b_of_type_JavaUtilList.size())
    {
      String str = (String)paramayru.jdField_b_of_type_JavaUtilList.get(i);
      if (str.equalsIgnoreCase(paramayru.jdField_b_of_type_JavaLangString)) {
        j = i;
      }
      ayvq localayvq = new ayvq();
      localayvq.jdField_b_of_type_JavaLangString = str;
      localayvq.jdField_a_of_type_JavaLangString = ayrt.a(str);
      localArrayList.add(localayvq);
      i += 1;
    }
    this.jdField_b_of_type_Ayvo = ayvo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, j, new aytj(this, paramayru));
    i = this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    j = AIOUtils.dp2px(75.0F, getResources());
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_Ayvo.showAsDropDown(this.jdField_c_of_type_AndroidWidgetTextView, i - j, 0);
    this.jdField_b_of_type_Ayvo.setOnDismissListener(new aytk(this, paramayru));
  }
  
  private void d(ayru paramayru)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "showTranslateDstLanOptions, lanHolder:" + paramayru.a());
    }
    if ((this.jdField_b_of_type_Ayvo != null) && (this.jdField_b_of_type_Ayvo.isShowing())) {
      this.jdField_b_of_type_Ayvo.dismiss();
    }
    if ((this.jdField_a_of_type_Ayvo != null) && (this.jdField_a_of_type_Ayvo.isShowing())) {
      this.jdField_a_of_type_Ayvo.dismiss();
    }
    while ((paramayru.jdField_c_of_type_JavaUtilList == null) || (paramayru.jdField_c_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if (i < paramayru.jdField_c_of_type_JavaUtilList.size())
    {
      String str = (String)paramayru.jdField_c_of_type_JavaUtilList.get(i);
      if (str.equalsIgnoreCase(paramayru.jdField_b_of_type_JavaLangString)) {}
      for (;;)
      {
        i += 1;
        break;
        if (str.equalsIgnoreCase(paramayru.jdField_c_of_type_JavaLangString)) {
          j = i;
        }
        ayvq localayvq = new ayvq();
        localayvq.jdField_b_of_type_JavaLangString = str;
        localayvq.jdField_a_of_type_JavaLangString = ayrt.a(str);
        localArrayList.add(localayvq);
      }
    }
    this.jdField_a_of_type_Ayvo = ayvo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, j, new aytl(this, paramayru));
    i = this.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    j = AIOUtils.dp2px(75.0F, getResources());
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_Ayvo.showAsDropDown(this.jdField_d_of_type_AndroidWidgetTextView, i - j, 0);
    this.jdField_a_of_type_Ayvo.setOnDismissListener(new aytm(this, paramayru));
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
      c(ayrt.b);
      continue;
      d(ayrt.b);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      continue;
      behe.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()));
      ayrt.a("0X800AB94", 0);
      continue;
      ayrt.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()));
      ayrt.a("0X800AB93", 0);
      continue;
      behe.a(String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()), "TranslateFragment");
      ayrt.a("0X800AB92", 0);
      continue;
      a(this.jdField_a_of_type_Int);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("TranslateText");
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController = new TranslateController(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Ayri);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561556, paramViewGroup, false);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379326));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379322));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131379321));
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)paramLayoutInflater.findViewById(2131379344));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379349));
    this.jdField_b_of_type_ComTencentWidgetScrollView = ((ScrollView)paramLayoutInflater.findViewById(2131379346));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379351));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131365199));
    this.jdField_d_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131366457));
    this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131367216));
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131365248));
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
    paramViewGroup = getResources().getDrawable(2130846148);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
    a(ayrt.b);
    b(ayrt.b);
    boolean bool = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    paramViewGroup = paramLayoutInflater.findViewById(2131372192);
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Ayri);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment
 * JD-Core Version:    0.7.0.1
 */