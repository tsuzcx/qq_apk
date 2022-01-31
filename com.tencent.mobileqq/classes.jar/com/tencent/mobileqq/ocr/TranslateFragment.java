package com.tencent.mobileqq.ocr;

import aekt;
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
import avrb;
import avrh;
import avrj;
import avsx;
import avsy;
import avsz;
import avta;
import avtb;
import avvb;
import avvd;
import baja;
import bdee;
import bepp;
import bllv;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
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
  private avrb jdField_a_of_type_Avrb = new avsx(this);
  private avvb jdField_a_of_type_Avvb;
  private bepp jdField_a_of_type_Bepp;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private TranslateController jdField_a_of_type_ComTencentMobileqqOcrTranslateController;
  private TranslateResult jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult;
  private OCRBottomTabView jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private avvb jdField_b_of_type_Avvb;
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
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
      this.jdField_a_of_type_Bepp.dismiss();
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
        avrh.a("0X800AB95", 2);
        return;
        b(avrh.a);
      }
    }
    a(2, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
    avrh.a("0X800AB95", 1);
  }
  
  private void a(int paramInt, TranslateResult paramTranslateResult)
  {
    int k = 2131710962;
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
      i = 2130841135;
      str = "#00CAFC";
      j = 2131710962;
    }
    for (;;)
    {
      if (paramInt == 2)
      {
        j = 2130841134;
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
          if (avrh.a != null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TranslateFragment", 2, "src:" + paramTranslateResult.jdField_a_of_type_JavaLangString + ", dst:" + paramTranslateResult.jdField_b_of_type_JavaLangString + ", OCRLanHolder:" + avrh.a.a());
            }
            avrh.a.a(paramTranslateResult.jdField_a_of_type_JavaLangString);
            avrh.a.b(paramTranslateResult.jdField_b_of_type_JavaLangString);
            a(avrh.a);
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
  
  private void a(avrj paramavrj)
  {
    if (paramavrj == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder:" + paramavrj.a());
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramavrj.a(paramavrj.jdField_b_of_type_JavaLangString));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramavrj.a(paramavrj.jdField_c_of_type_JavaLangString));
    if ((paramavrj.jdField_b_of_type_JavaUtilList == null) || (paramavrj.jdField_b_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    while ((paramavrj.jdField_c_of_type_JavaUtilList == null) || (paramavrj.jdField_c_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(true);
      Drawable localDrawable = getResources().getDrawable(2130845668);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setClickable(true);
    paramavrj = getResources().getDrawable(2130845668);
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramavrj);
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString)
  {
    Intent localIntent = new Intent(paramBaseActivity, TranslateFragment.class);
    localIntent.putExtra("TranslateText", paramString);
    PublicFragmentActivity.a(paramBaseActivity, localIntent, TranslateFragment.class);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!bdee.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131692397, 0).a();
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
    b(2131699614);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "requestTranslate, srcLan:" + paramString1 + ", dstLan:" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.a(this.jdField_a_of_type_JavaLangString, paramString1, paramString2);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bepp == null)
    {
      this.jdField_a_of_type_Bepp = new bepp(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, getResources().getDimensionPixelSize(2131298914));
      this.jdField_a_of_type_Bepp.c(paramInt);
    }
    if (!getActivity().isFinishing()) {
      this.jdField_a_of_type_Bepp.show();
    }
  }
  
  private void b(avrj paramavrj)
  {
    if (paramavrj == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "requestTranslate, lanHolder:" + paramavrj.a());
    }
    a(paramavrj.jdField_b_of_type_JavaLangString, paramavrj.jdField_c_of_type_JavaLangString);
  }
  
  private void c(avrj paramavrj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "showTranslateSrcLanOptions, lanHolder:" + paramavrj.a());
    }
    if ((this.jdField_a_of_type_Avvb != null) && (this.jdField_a_of_type_Avvb.isShowing())) {
      this.jdField_a_of_type_Avvb.dismiss();
    }
    if ((this.jdField_b_of_type_Avvb != null) && (this.jdField_b_of_type_Avvb.isShowing())) {
      this.jdField_b_of_type_Avvb.dismiss();
    }
    while ((paramavrj.jdField_b_of_type_JavaUtilList == null) || (paramavrj.jdField_b_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    while (i < paramavrj.jdField_b_of_type_JavaUtilList.size())
    {
      String str = (String)paramavrj.jdField_b_of_type_JavaUtilList.get(i);
      if (str.equalsIgnoreCase(paramavrj.jdField_b_of_type_JavaLangString)) {
        j = i;
      }
      avvd localavvd = new avvd();
      localavvd.jdField_b_of_type_JavaLangString = str;
      localavvd.jdField_a_of_type_JavaLangString = avrh.a(str);
      localArrayList.add(localavvd);
      i += 1;
    }
    this.jdField_b_of_type_Avvb = avvb.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, j, new avsy(this, paramavrj));
    i = this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    j = aekt.a(75.0F, getResources());
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_Avvb.showAsDropDown(this.jdField_c_of_type_AndroidWidgetTextView, i - j, 0);
    this.jdField_b_of_type_Avvb.setOnDismissListener(new avsz(this, paramavrj));
  }
  
  private void d(avrj paramavrj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, "showTranslateDstLanOptions, lanHolder:" + paramavrj.a());
    }
    if ((this.jdField_b_of_type_Avvb != null) && (this.jdField_b_of_type_Avvb.isShowing())) {
      this.jdField_b_of_type_Avvb.dismiss();
    }
    if ((this.jdField_a_of_type_Avvb != null) && (this.jdField_a_of_type_Avvb.isShowing())) {
      this.jdField_a_of_type_Avvb.dismiss();
    }
    while ((paramavrj.jdField_c_of_type_JavaUtilList == null) || (paramavrj.jdField_c_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if (i < paramavrj.jdField_c_of_type_JavaUtilList.size())
    {
      String str = (String)paramavrj.jdField_c_of_type_JavaUtilList.get(i);
      if (str.equalsIgnoreCase(paramavrj.jdField_b_of_type_JavaLangString)) {}
      for (;;)
      {
        i += 1;
        break;
        if (str.equalsIgnoreCase(paramavrj.jdField_c_of_type_JavaLangString)) {
          j = i;
        }
        avvd localavvd = new avvd();
        localavvd.jdField_b_of_type_JavaLangString = str;
        localavvd.jdField_a_of_type_JavaLangString = avrh.a(str);
        localArrayList.add(localavvd);
      }
    }
    this.jdField_a_of_type_Avvb = avvb.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, j, new avta(this, paramavrj));
    i = this.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    j = aekt.a(75.0F, getResources());
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_Avvb.showAsDropDown(this.jdField_d_of_type_AndroidWidgetTextView, i - j, 0);
    this.jdField_a_of_type_Avvb.setOnDismissListener(new avtb(this, paramavrj));
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
    case 2131378190: 
    default: 
      return;
    case 2131378189: 
      c(avrh.a);
      return;
    case 2131378185: 
      d(avrh.a);
      return;
    case 2131378184: 
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      return;
    case 2131366016: 
      baja.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get(), String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()));
      avrh.a("0X800AB94", 0);
      return;
    case 2131366752: 
      avrh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()));
      avrh.a("0X800AB93", 0);
      return;
    case 2131364855: 
      baja.a(String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()), "TranslateFragment");
      avrh.a("0X800AB92", 0);
      return;
    }
    a(this.jdField_a_of_type_Int);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("TranslateText");
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((QQAppInterface)bllv.a());
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController = new TranslateController((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get());
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Avrb);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561324, paramViewGroup, false);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378189));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378185));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131378184));
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)paramLayoutInflater.findViewById(2131378206));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378211));
    this.jdField_b_of_type_ComTencentWidgetScrollView = ((ScrollView)paramLayoutInflater.findViewById(2131378208));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378213));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131364807));
    this.jdField_d_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131366016));
    this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131366752));
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131364855));
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
    paramViewGroup = getResources().getDrawable(2130845666);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
    a(avrh.a);
    b(avrh.a);
    boolean bool = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    paramViewGroup = paramLayoutInflater.findViewById(2131371337);
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Avrb);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment
 * JD-Core Version:    0.7.0.1
 */