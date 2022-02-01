package com.tencent.mobileqq.ocr;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.ocr.api.impl.OCRHandler;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OptionItem;
import com.tencent.mobileqq.qqfavor.api.IFavoriteOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.textpreview.BaseMenuUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class TranslateFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 2;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private OCRObserver jdField_a_of_type_ComTencentMobileqqOcrOCRObserver = new TranslateFragment.1(this);
  private OCRHandler jdField_a_of_type_ComTencentMobileqqOcrApiImplOCRHandler;
  private TranslateResult jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult;
  private TranslateLanguageOptionsView jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
  private OCRBottomTabView jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TranslateLanguageOptionsView jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
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
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      TranslateResult localTranslateResult = this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult;
      if (localTranslateResult != null) {
        a(1, localTranslateResult);
      } else {
        b(OCRPerformUtil.b);
      }
      OCRPerformUtil.a("0X800AB95", 2);
      return;
    }
    a(2, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
    OCRPerformUtil.a("0X800AB95", 1);
  }
  
  private void a(int paramInt, TranslateResult paramTranslateResult)
  {
    this.jdField_a_of_type_Int = paramInt;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
    if ((localObject != null) && (((OCRBottomTabView)localObject).getVisibility() == 0))
    {
      int k = 2131710533;
      String str = "#000000";
      int i = -1;
      int j;
      if (paramInt == 1)
      {
        i = 2130841506;
        localObject = "#00CAFC";
        j = 2131710533;
      }
      else
      {
        localObject = "#000000";
        j = -1;
      }
      if (paramInt == 2)
      {
        i = 2130841505;
        j = k;
        localObject = str;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabImage(getResources().getDrawable(i));
      this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabText(getResources().getString(j));
      this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabTextColor(Color.parseColor((String)localObject));
    }
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
      if (OCRPerformUtil.b != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("src:");
          ((StringBuilder)localObject).append(paramTranslateResult.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(", dst:");
          ((StringBuilder)localObject).append(paramTranslateResult.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject).append(", OCRLanHolder:");
          ((StringBuilder)localObject).append(OCRPerformUtil.b.a());
          QLog.e("TranslateFragment", 2, ((StringBuilder)localObject).toString());
        }
        OCRPerformUtil.b.b(paramTranslateResult.jdField_a_of_type_JavaLangString);
        OCRPerformUtil.b.c(paramTranslateResult.jdField_b_of_type_JavaLangString);
        a(OCRPerformUtil.b);
      }
    }
  }
  
  public static void a(QBaseActivity paramQBaseActivity, String paramString)
  {
    Intent localIntent = new Intent(paramQBaseActivity, TranslateFragment.class);
    localIntent.putExtra("TranslateText", paramString);
    QPublicFragmentActivity.start(paramQBaseActivity, localIntent, TranslateFragment.class);
  }
  
  private void a(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if (paramOCRLanHolder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder is null");
      }
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateTranslateTitle, lanHolder:");
      ((StringBuilder)localObject).append(paramOCRLanHolder.a());
      QLog.d("TranslateFragment", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramOCRLanHolder.a(paramOCRLanHolder.jdField_b_of_type_JavaLangString));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramOCRLanHolder.a(paramOCRLanHolder.jdField_c_of_type_JavaLangString));
    if ((paramOCRLanHolder.jdField_b_of_type_JavaUtilList != null) && (paramOCRLanHolder.jdField_b_of_type_JavaUtilList.size() > 1))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(true);
      localObject = getResources().getDrawable(2130846354);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, (Drawable)localObject);
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    if ((paramOCRLanHolder.jdField_c_of_type_JavaUtilList != null) && (paramOCRLanHolder.jdField_c_of_type_JavaUtilList.size() > 1))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setClickable(true);
      paramOCRLanHolder = getResources().getDrawable(2130846354);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramOCRLanHolder);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131692183, 0).a();
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
    b(2131699090);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestTranslate, srcLan:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", dstLan:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("TranslateFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOcrApiImplOCRHandler;
    if (localObject != null) {
      ((OCRHandler)localObject).a(this.jdField_a_of_type_JavaLangString, paramString1, paramString2);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, getResources().getDimensionPixelSize(2131299168));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    }
    if (!getActivity().isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void b(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if (paramOCRLanHolder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder is null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestTranslate, lanHolder:");
      localStringBuilder.append(paramOCRLanHolder.a());
      QLog.d("TranslateFragment", 2, localStringBuilder.toString());
    }
    a(paramOCRLanHolder.jdField_b_of_type_JavaLangString, paramOCRLanHolder.jdField_c_of_type_JavaLangString);
  }
  
  private void c(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showTranslateSrcLanOptions, lanHolder:");
      ((StringBuilder)localObject).append(paramOCRLanHolder.a());
      QLog.d("TranslateFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing()))
    {
      this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
      return;
    }
    if (paramOCRLanHolder.jdField_b_of_type_JavaUtilList != null)
    {
      if (paramOCRLanHolder.jdField_b_of_type_JavaUtilList.size() == 0) {
        return;
      }
      localObject = new ArrayList();
      int i = 0;
      int j = 0;
      while (i < paramOCRLanHolder.jdField_b_of_type_JavaUtilList.size())
      {
        String str = (String)paramOCRLanHolder.jdField_b_of_type_JavaUtilList.get(i);
        if (str.equalsIgnoreCase(paramOCRLanHolder.jdField_b_of_type_JavaLangString)) {
          j = i;
        }
        TranslateLanguageOptionsView.OptionItem localOptionItem = new TranslateLanguageOptionsView.OptionItem();
        localOptionItem.jdField_b_of_type_JavaLangString = str;
        localOptionItem.jdField_a_of_type_JavaLangString = OCRPerformUtil.a(str);
        ((List)localObject).add(localOptionItem);
        i += 1;
      }
      this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView = TranslateLanguageOptionsView.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (List)localObject, j, new TranslateFragment.2(this, paramOCRLanHolder));
      i = this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
      j = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 75.0F);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.showAsDropDown(this.jdField_c_of_type_AndroidWidgetTextView, i - j, 0);
      this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.setOnDismissListener(new TranslateFragment.3(this, paramOCRLanHolder));
    }
  }
  
  private void d(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showTranslateDstLanOptions, lanHolder:");
      ((StringBuilder)localObject).append(paramOCRLanHolder.a());
      QLog.d("TranslateFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
      return;
    }
    if (paramOCRLanHolder.jdField_c_of_type_JavaUtilList != null)
    {
      if (paramOCRLanHolder.jdField_c_of_type_JavaUtilList.size() == 0) {
        return;
      }
      localObject = new ArrayList();
      int i = 0;
      int j = 0;
      while (i < paramOCRLanHolder.jdField_c_of_type_JavaUtilList.size())
      {
        String str = (String)paramOCRLanHolder.jdField_c_of_type_JavaUtilList.get(i);
        if (!str.equalsIgnoreCase(paramOCRLanHolder.jdField_b_of_type_JavaLangString))
        {
          if (str.equalsIgnoreCase(paramOCRLanHolder.jdField_c_of_type_JavaLangString)) {
            j = i;
          }
          TranslateLanguageOptionsView.OptionItem localOptionItem = new TranslateLanguageOptionsView.OptionItem();
          localOptionItem.jdField_b_of_type_JavaLangString = str;
          localOptionItem.jdField_a_of_type_JavaLangString = OCRPerformUtil.a(str);
          ((List)localObject).add(localOptionItem);
        }
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView = TranslateLanguageOptionsView.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (List)localObject, j, new TranslateFragment.4(this, paramOCRLanHolder));
      i = this.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
      j = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 75.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.showAsDropDown(this.jdField_d_of_type_AndroidWidgetTextView, i - j, 0);
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.setOnDismissListener(new TranslateFragment.5(this, paramOCRLanHolder));
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771993, 2130771991);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = ((QBaseActivity)paramActivity);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131379087) {
      c(OCRPerformUtil.b);
    } else if (i == 2131379083) {
      d(OCRPerformUtil.b);
    } else if (i == 2131379082) {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
    } else if (i != 2131379088) {
      if (i == 2131366495)
      {
        ((IFavoriteOCR)QRoute.api(IFavoriteOCR.class)).favorite(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()));
        OCRPerformUtil.a("0X800AB94", 0);
      }
      else if (i == 2131367183)
      {
        OCRPerformUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()));
        OCRPerformUtil.a("0X800AB93", 0);
      }
      else if (i == 2131365252)
      {
        BaseMenuUtil.copy(String.valueOf(this.jdField_b_of_type_AndroidWidgetTextView.getText()), "TranslateFragment");
        OCRPerformUtil.a("0X800AB92", 0);
      }
      else if (i == 2131365210)
      {
        a(this.jdField_a_of_type_Int);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("TranslateText");
    this.jdField_a_of_type_ComTencentMobileqqOcrApiImplOCRHandler = ((OCRHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(OCRHandler.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqOcrOCRObserver);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = 0;
    paramLayoutInflater = paramLayoutInflater.inflate(2131561521, paramViewGroup, false);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379087));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379083));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131379082));
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)paramLayoutInflater.findViewById(2131379101));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379103));
    this.jdField_b_of_type_ComTencentWidgetScrollView = ((ScrollView)paramLayoutInflater.findViewById(2131379102));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379105));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131365210));
    this.jdField_d_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131366495));
    this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131367183));
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131365252));
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
    paramViewGroup = getResources().getDrawable(2130846352);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
    a(OCRPerformUtil.b);
    b(OCRPerformUtil.b);
    boolean bool = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    paramViewGroup = paramLayoutInflater.findViewById(2131372076);
    if (!bool) {
      i = 8;
    }
    paramViewGroup.setVisibility(i);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqOcrOCRObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment
 * JD-Core Version:    0.7.0.1
 */