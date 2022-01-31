package com.tencent.mobileqq.ocr;

import actj;
import aibn;
import aicj;
import ajya;
import allt;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apvd;
import aqbe;
import atzv;
import atzx;
import auag;
import auah;
import auai;
import auaj;
import auak;
import aual;
import auam;
import auan;
import auao;
import auap;
import auaq;
import auar;
import auas;
import auat;
import auau;
import aubo;
import aubq;
import audw;
import audx;
import audz;
import axlk;
import axqy;
import ayfx;
import ayga;
import aygc;
import aykk;
import aylf;
import aylg;
import bavw;
import baww;
import bbdh;
import bbfj;
import bcqf;
import bcql;
import bfpc;
import bfyd;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu.ProgressView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class OCRResultActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#12B7F5");
  public static final String[] a;
  protected Dialog a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aual(this);
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new auam(this);
  public EditText a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  public TextView a;
  private atzx jdField_a_of_type_Atzx = new auau(this);
  private aubo jdField_a_of_type_Aubo;
  private aubq jdField_a_of_type_Aubq = new auai(this);
  private audw jdField_a_of_type_Audw;
  public audx a;
  private aygc jdField_a_of_type_Aygc = new auah(this, this);
  private aylg jdField_a_of_type_Aylg = new auat(this);
  bcqf jdField_a_of_type_Bcqf;
  private bfpc jdField_a_of_type_Bfpc;
  protected TextPreviewMenu.ProgressView a;
  ScanSuccessView jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView;
  private TranslateController jdField_a_of_type_ComTencentMobileqqOcrTranslateController;
  private OcrConfig jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig;
  private OcrRecogResult jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult;
  private TranslateResult jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult;
  OCRBottomTabView jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  ParticipleBottomMenuView jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView;
  public ParticipleView a;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  View jdField_b_of_type_AndroidViewView;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  public ImageView b;
  public TextView b;
  public audx b;
  OCRBottomTabView jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  private String jdField_b_of_type_JavaLangString;
  private List<String> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  View jdField_c_of_type_AndroidViewView;
  ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  public TextView c;
  public OCRBottomTabView c;
  private String jdField_c_of_type_JavaLangString;
  private List<String> jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  public ViewGroup d;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  public OCRBottomTabView d;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  private boolean jdField_e_of_type_Boolean;
  ImageView f;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "M3X", "U20", "ZTE C2016", "Lenovo K900", "HUAWEI MT7-CL00", "HUAWEI G7-TL00", "PE-CL00", "Moto X Pro", "X907", "ASUS_Z00ADB", "HUAWEI P7-L07", "XT1581", "M821", "R7c" };
  }
  
  private String a(TextView paramTextView)
  {
    String str1 = null;
    if (paramTextView == null) {
      paramTextView = str1;
    }
    do
    {
      int i;
      int j;
      String str2;
      do
      {
        do
        {
          do
          {
            do
            {
              return paramTextView;
              i = paramTextView.getSelectionStart();
              j = paramTextView.getSelectionEnd();
              str2 = paramTextView.getText().toString();
              paramTextView = str1;
            } while (TextUtils.isEmpty(str2));
            paramTextView = str1;
          } while (i >= j);
          paramTextView = str1;
        } while (i < 0);
        paramTextView = str1;
      } while (j > str2.length());
      str1 = str2.substring(i, j);
      paramTextView = str1;
    } while (!QLog.isColorLevel());
    QLog.d("OCRResultActivity", 2, "getSelectedWord " + str1);
    return str1;
  }
  
  private String a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.getTranslateLanguageName(paramString);
    }
    return OcrConfig.getDefaultLanguageName(paramString);
  }
  
  private List<String> a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.getTranslateSupportLanguages(paramString);
    }
    return OcrConfig.getDefaultSupportLanguages(paramString);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setOnMenuClickListener(new auag(this));
  }
  
  private void a(int paramInt)
  {
    if ((isFinishing()) || ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing()))) {
      return;
    }
    if (this.jdField_a_of_type_Bcqf == null) {
      this.jdField_a_of_type_Bcqf = new bcqf(this, 0, 2131561031, 48);
    }
    this.jdField_a_of_type_Bcqf.c(paramInt);
    this.jdField_a_of_type_Bcqf.c(false);
    this.jdField_a_of_type_Bcqf.show();
  }
  
  public static final void a(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, OCRResultActivity.class);
    localIntent.putExtra("PARAM_BUSI", 0);
    localIntent.putExtra("PARAM_FROM", paramInt);
    localIntent.putExtra("param_ocr_path", paramString);
    localIntent.addFlags(67108864);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  private void a(EditText paramEditText)
  {
    paramEditText.setLinkTextColor(jdField_a_of_type_Int);
    if (AppSetting.jdField_d_of_type_Boolean) {
      paramEditText.setAutoLinkMask(7);
    }
    for (;;)
    {
      paramEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramEditText.addTextChangedListener(new auaj(this));
      if (a()) {
        paramEditText.setCustomSelectionActionModeCallback(new auak(this, paramEditText));
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      return;
      paramEditText.setAutoLinkMask(0);
    }
  }
  
  private void a(OcrRecogResult paramOcrRecogResult)
  {
    if (paramOcrRecogResult == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult = paramOcrRecogResult;
      if (TextUtils.isEmpty(paramOcrRecogResult.language)) {}
      for (Object localObject = "";; localObject = paramOcrRecogResult.language.toLowerCase())
      {
        this.jdField_c_of_type_JavaLangString = ((String)localObject);
        b(this.jdField_c_of_type_JavaLangString);
        if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0)) {
          c((String)this.jdField_b_of_type_JavaUtilList.get(0));
        }
        localObject = paramOcrRecogResult.ocr_languages;
        if (this.jdField_c_of_type_JavaUtilList == null) {
          this.jdField_c_of_type_JavaUtilList = new ArrayList();
        }
        if (localObject == null) {
          break;
        }
        this.jdField_c_of_type_JavaUtilList.clear();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(a(str)))) {
            this.jdField_c_of_type_JavaUtilList.add(str.toLowerCase());
          }
        }
      }
      this.jdField_c_of_type_JavaUtilList.clear();
      if (!TextUtils.isEmpty(paramOcrRecogResult.ocrContent))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(new aykk(paramOcrRecogResult.ocrContent, 8, 16));
        this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
        this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setEnabled(true);
        this.jdField_d_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setEnabled(true);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("OCRResultActivity", 2, String.format("updateOcrResult, ocrLanguage: %s, srcTranslateLang: %s, dstTranslateLang: %s", new Object[] { this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
        return;
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
        this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
        this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setEnabled(false);
        this.jdField_d_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setEnabled(false);
      }
    }
  }
  
  private void a(TranslateResult paramTranslateResult)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult = paramTranslateResult;
    if (paramTranslateResult != null)
    {
      CharSequence localCharSequence = paramTranslateResult.b();
      if (TextUtils.isEmpty(localCharSequence)) {
        break label90;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(localCharSequence);
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
    }
    for (;;)
    {
      c(paramTranslateResult.jdField_b_of_type_JavaLangString);
      b(paramTranslateResult.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("OCRResultActivity", 2, String.format("translateResult, srcTranslateLang: %s, dstTranslateLang: %s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
      }
      return;
      label90:
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!bbfj.g(getApplicationContext()))
    {
      QLog.d("OCRResultActivity", 1, "requestOcr, network error");
      bcql.a(this, 1, 2131692321, 0).a();
      return;
    }
    if (!apvd.a(paramString1))
    {
      QLog.d("OCRResultActivity", 1, "requestOcr, file not exist, picPath:" + paramString1);
      bcql.a(this, 1, 2131699244, 0).a();
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("OCRResultActivity", 1, "requestOcr, in ocr request, " + paramString1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRResultActivity", 2, String.format("requestOcr: %s, language: %s, isFirst: %s, needCompress: %s", new Object[] { this.jdField_d_of_type_JavaLangString, paramString2, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_JavaLangString = paramString1;
    if (paramBoolean1)
    {
      b();
      this.jdField_d_of_type_Boolean = true;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aubo == null)
      {
        this.jdField_a_of_type_Aubo = new aubo(this.app, this.jdField_a_of_type_Aubq, 5);
        this.jdField_a_of_type_Aubo.d();
      }
      this.jdField_a_of_type_Aubo.a(this.jdField_d_of_type_JavaLangString, paramBoolean2, paramString2);
      return;
      a(2131699247);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!bbfj.g(getApplicationContext())) {
      bcql.a(this, 1, 2131692321, 0).a();
    }
    String str;
    do
    {
      do
      {
        return;
        if (this.jdField_c_of_type_Boolean)
        {
          QLog.d("OCRResultActivity", 1, "requestTranslate, in translate request,");
          return;
        }
        str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      } while (TextUtils.isEmpty(str.trim()));
      if ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult == null) || (this.jdField_d_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a(str, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString))) {
        break;
      }
      f();
      a(this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
    } while (!QLog.isColorLevel());
    QLog.d("OCRResultActivity", 2, "requestTranslate, use cache");
    return;
    this.jdField_c_of_type_Boolean = true;
    if (paramBoolean)
    {
      this.jdField_d_of_type_Boolean = true;
      b();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRResultActivity", 2, String.format("requestTranslate, srcLang: %s, dstLang: %s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
      }
      if (this.jdField_d_of_type_Int != 0) {
        break label222;
      }
      if (TextUtils.isEmpty(str)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.a(str, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      return;
      a(2131699268);
    }
    label222:
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.a(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, true);
  }
  
  public static boolean a()
  {
    boolean bool = false;
    String str = bbdh.d();
    int i;
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      if (i < j) {
        if (!str.equals(arrayOfString[i])) {}
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRResultActivity", 2, "isSupportAddContextMenu mode:" + str + ",isSupport: " + bool);
      }
      return bool;
      i += 1;
      break;
      bool = true;
    }
  }
  
  private void b()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_e_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_e_of_type_AndroidWidgetImageView = new ImageView(this);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundColor(-16777216);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(new File(this.jdField_d_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).downloadImediatly();
      this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_e_of_type_AndroidWidgetImageView, localLayoutParams);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = new ScanSuccessView(this);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setShowProgress(false);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(axlk.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, localLayoutParams);
      if (this.jdField_b_of_type_Int == 0) {
        this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(ajya.a(2131707827));
      }
    }
    else if (this.f == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.f = new ImageView(this);
      this.f.setImageResource(2130842692);
      localLayoutParams.leftMargin = actj.a(12.0F, getResources());
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label304;
      }
    }
    label304:
    for (localLayoutParams.topMargin = (ImmersiveUtils.getStatusBarHeight(this) + actj.a(12.0F, getResources()));; localLayoutParams.topMargin = actj.a(12.0F, getResources()))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.f, localLayoutParams);
      this.f.setOnClickListener(new auan(this));
      this.f.bringToFront();
      return;
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(ajya.a(2131707830));
      break;
    }
  }
  
  private void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaLangString = paramString.toLowerCase();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_JavaLangString));
      this.jdField_b_of_type_JavaUtilList = a(this.jdField_a_of_type_JavaLangString);
      if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 1))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setClickable(false);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      while (AppSetting.jdField_d_of_type_Boolean)
      {
        baww.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_JavaLangString, getString(2131699267));
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
        paramString = getResources().getDrawable(2130844793);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramString);
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_e_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_e_of_type_AndroidWidgetImageView);
      this.jdField_e_of_type_AndroidWidgetImageView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = null;
    }
    if (this.f != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.f);
      this.f = null;
    }
  }
  
  private void c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equalsIgnoreCase(this.jdField_b_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      this.jdField_b_of_type_JavaLangString = paramString.toLowerCase();
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_JavaUtilList = a(paramString);
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 1))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      while (AppSetting.jdField_d_of_type_Boolean)
      {
        baww.a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_JavaLangString, getString(2131699267));
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
        paramString = getResources().getDrawable(2130844793);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramString);
      }
    }
  }
  
  private void d()
  {
    g();
    if (this.jdField_b_of_type_Int != 0)
    {
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = 0;
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131166297)));
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      allt.a(this, this.jdField_c_of_type_AndroidViewView);
    }
  }
  
  private void d(String paramString)
  {
    axqy.b(null, "dc00898", "", "", "0X800A161", "0X800A161", 0, 0, "", "0", "0", "");
    if (!bbfj.g(getApplicationContext()))
    {
      QLog.d("OCRResultActivity", 1, "requestExport, network error");
      bcql.a(this, 1, 2131692321, 0).a();
      return;
    }
    if (!apvd.a(paramString))
    {
      QLog.d("OCRResultActivity", 1, "requestExport, file not exist, picPath:" + paramString);
      bcql.a(this, 1, 2131699244, 0).a();
      return;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      QLog.d("OCRResultActivity", 1, "requestExport, in export request, " + paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRResultActivity", 2, String.format("requestExport: %s", new Object[] { this.jdField_d_of_type_JavaLangString }));
    }
    this.jdField_e_of_type_Boolean = true;
    this.jdField_d_of_type_JavaLangString = paramString;
    ((ayga)this.app.a(157)).a(this.jdField_d_of_type_JavaLangString);
  }
  
  private void e()
  {
    g();
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    if (this.jdField_b_of_type_Int != 2)
    {
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = 2;
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.b();
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130838150));
      allt.a(this, this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  private void e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    while (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("OCRResultActivity", 2, "ShareToFriend error, content is empty");
      }
      return;
      if (this.jdField_b_of_type_Int == 0)
      {
        paramString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      }
      else if (this.jdField_b_of_type_Int == 2)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.a();
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult == null) {}
        for (paramString = "";; paramString = this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a()) {
          break;
        }
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    localBundle.putString("forward_text", paramString);
    paramString = new Intent();
    paramString.putExtra("isFromShare", true);
    if (this.jdField_d_of_type_Int == 0) {
      paramString.putExtra("KEY_FROM_OCR", true);
    }
    for (;;)
    {
      paramString.putExtras(localBundle);
      aqbe.a(this, paramString, 21);
      if (this.jdField_d_of_type_Int != 0) {
        break;
      }
      axqy.b(null, "dc00898", "", "", "0X80082EB", "0X80082EB", 0, 0, "", "", "", "");
      return;
      paramString.putExtra("KEY_FROM_TRANSLATE", true);
    }
    axqy.b(null, "dc00898", "", "", "0X8009C84", "0X8009C84", 0, 0, "", "", "", "");
  }
  
  private void f()
  {
    g();
    if (this.jdField_b_of_type_Int != 1)
    {
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131166297)));
      allt.a(this, this.jdField_c_of_type_AndroidViewView);
    }
  }
  
  private void f(String paramString)
  {
    Intent localIntent = EditPicActivity.a(this, paramString, false, false, false, true, false, 2, 99, 9);
    localIntent.putExtra("babyq_ability", 2L);
    localIntent.putExtra("sub_business_id", 103);
    startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("OCRResultActivity", 2, String.format("enterCropPage, path: %s", new Object[] { paramString }));
    }
    axqy.b(null, "dc00898", "", "", "0X80082DB", "0X80082DB", 0, 0, "", "", "", "");
  }
  
  private void g()
  {
    aibn localaibn = aibn.a();
    if ((localaibn.c()) && (localaibn.a())) {
      localaibn.d();
    }
  }
  
  private void h()
  {
    e("");
  }
  
  private void i()
  {
    if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    this.jdField_a_of_type_Bfpc = bfpc.a(this);
    this.jdField_a_of_type_Bfpc.a(2131699250);
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.jdField_a_of_type_Bfpc.a(a(str), str.equalsIgnoreCase(this.jdField_c_of_type_JavaLangString));
    }
    this.jdField_a_of_type_Bfpc.c(2131690596);
    this.jdField_a_of_type_Bfpc.a(new auao(this));
    try
    {
      this.jdField_a_of_type_Bfpc.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Audx != null) && (this.jdField_a_of_type_Audx.isShowing())) {
      this.jdField_a_of_type_Audx.dismiss();
    }
    if ((this.jdField_b_of_type_Audx != null) && (this.jdField_b_of_type_Audx.isShowing())) {
      this.jdField_b_of_type_Audx.dismiss();
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0));
      ArrayList localArrayList = new ArrayList();
      i = 0;
      j = 0;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        String str = (String)this.jdField_a_of_type_JavaUtilList.get(i);
        if (str.equals(this.jdField_b_of_type_JavaLangString)) {}
        for (;;)
        {
          i += 1;
          break;
          audz localaudz = new audz();
          localaudz.jdField_b_of_type_JavaLangString = str;
          localaudz.jdField_a_of_type_JavaLangString = a(str);
          if (str.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {
            j = i;
          }
          localArrayList.add(localaudz);
        }
      }
      this.jdField_b_of_type_Audx = audx.a(this, localArrayList, j, new auap(this));
    } while (this.jdField_b_of_type_Audx == null);
    this.jdField_b_of_type_Audx.setOnDismissListener(new auaq(this));
    int i = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    int j = actj.a(75.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_Audx.showAsDropDown(this.jdField_a_of_type_AndroidWidgetTextView, i - j, 0);
  }
  
  private void k()
  {
    if ((this.jdField_b_of_type_Audx != null) && (this.jdField_b_of_type_Audx.isShowing())) {
      this.jdField_b_of_type_Audx.dismiss();
    }
    if ((this.jdField_a_of_type_Audx != null) && (this.jdField_a_of_type_Audx.isShowing())) {
      this.jdField_a_of_type_Audx.dismiss();
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0));
      ArrayList localArrayList = new ArrayList();
      i = 0;
      j = 0;
      if (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        String str = (String)this.jdField_b_of_type_JavaUtilList.get(i);
        if (str.equals(this.jdField_a_of_type_JavaLangString)) {}
        for (;;)
        {
          i += 1;
          break;
          audz localaudz = new audz();
          localaudz.jdField_b_of_type_JavaLangString = str;
          localaudz.jdField_a_of_type_JavaLangString = a(str);
          if (str.equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)) {
            j = i;
          }
          localArrayList.add(localaudz);
        }
      }
      this.jdField_a_of_type_Audx = audx.a(this, localArrayList, j, new auar(this));
    } while (this.jdField_a_of_type_Audx == null);
    this.jdField_a_of_type_Audx.setOnDismissListener(new auas(this));
    int i = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    int j = actj.a(75.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_Audx.showAsDropDown(this.jdField_b_of_type_AndroidWidgetTextView, i - j, 0);
  }
  
  private void l()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (!bbfj.d(this))
    {
      bcql.a(getApplicationContext(), ajya.a(2131707831), 0).b(getResources().getDimensionPixelSize(2131298865));
      return;
    }
    m();
    ((aylf)this.app.a(161)).a(this.app, str);
    axqy.b(this.app, "dc00898", "", "", "0X800A357", "0X800A357", 2, 0, "", "", "", "");
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView = new TextPreviewMenu.ProgressView(this);
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this);
      if (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null) {
        this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new aicj(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView.setProgressText(ajya.a(2131707833));
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(null);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
  }
  
  protected void a(String paramString)
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), QQBrowserActivity.class);
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "https://docs.qq.com/desktop/m/index.html?_from=1";
      }
      paramString = ayfx.b(str, "s_qq_ocr_save");
      localIntent.putExtra("tdsourcetag", "s_qq_ocr_save");
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
      localIntent.putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
      if (!TeamWorkDocEditBrowserActivity.a(this, paramString, localIntent.getStringExtra("tdsourcetag"))) {
        startActivity(localIntent.putExtra("url", paramString));
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.i("OCRResultActivity", 1, paramString.toString());
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent != null) && (paramIntent.getIntExtra("PARAM_FROM", -1) == 1)) {
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_b_of_type_Audx != null) && (this.jdField_b_of_type_Audx.isShowing())) {
      this.jdField_b_of_type_Audx.dismiss();
    }
    if ((this.jdField_a_of_type_Audx != null) && (this.jdField_a_of_type_Audx.isShowing())) {
      this.jdField_a_of_type_Audx.dismiss();
    }
    if (((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2)) && (this.jdField_d_of_type_Int == 0))
    {
      d();
      return;
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(2131560926);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      bfyd.a(this);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375512));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131377444);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362988));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376014));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131371023));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371002));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377673));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377668));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377661));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377669));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131371019));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377666));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363391));
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363395));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = ((ParticipleView)findViewById(2131372171));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView = ((ParticipleBottomMenuView)findViewById(2131371262));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)findViewById(2131364844));
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)findViewById(2131371263));
    this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)findViewById(2131377660));
    this.jdField_d_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)findViewById(2131365787));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371911));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364721);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131375493);
    allt.a(this, this.jdField_c_of_type_AndroidViewView);
    allt.a(this, this.jdField_d_of_type_AndroidViewViewGroup, true, 0);
    a(this.jdField_a_of_type_AndroidWidgetEditText);
    a();
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("PARAM_BUSI", 0);
    this.jdField_e_of_type_Int = getIntent().getIntExtra("PARAM_FROM", -1);
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController = new TranslateController(this.app);
    if (this.jdField_d_of_type_Int == 1)
    {
      this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("param_ocr_path");
      paramBundle = (TranslateResult)getIntent().getParcelableExtra("param_translate_result");
      f();
      if (paramBundle != null) {
        a(paramBundle);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig = ((atzv)this.app.getManager(228)).a(false);
      addObserver(this.jdField_a_of_type_Atzx);
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
      addObserver(this.jdField_a_of_type_Aygc);
      this.jdField_a_of_type_Audw = new audw(this);
      axqy.b(null, "dc00898", "", "", "0X800A160", "0X800A160", 0, 0, "", "0", "0", "");
      addObserver(this.jdField_a_of_type_Aylg);
      return true;
      a(true);
      continue;
      paramBundle = (OcrRecogResult)getIntent().getParcelableExtra("param_ocr_result");
      this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("param_ocr_path");
      d();
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = actj.a(24.0F, getResources());
      localURLDrawableOptions.mRequestHeight = actj.a(24.0F, getResources());
      URLDrawable localURLDrawable = URLDrawable.getDrawable(new File(this.jdField_d_of_type_JavaLangString), localURLDrawableOptions);
      localURLDrawable.setTag(bavw.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, actj.a(3.0F, getResources())));
      localURLDrawable.setDecodeHandler(bavw.i);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabImage(localURLDrawable);
      if (paramBundle != null) {
        a(paramBundle);
      }
      for (;;)
      {
        axqy.b(null, "dc00898", "", "", "0X80082CE", "0X80082CE", 0, 0, "", "", "", "");
        if (this.jdField_e_of_type_Int != 2) {
          break label881;
        }
        axqy.b(null, "dc00898", "", "", "0X8009C87", "0X8009C87", 2, 0, "", "", "", "");
        break;
        a(this.jdField_d_of_type_JavaLangString, null, true, true);
      }
      label881:
      if (this.jdField_e_of_type_Int == 1) {
        axqy.b(null, "dc00898", "", "", "0X8009C87", "0X8009C87", 1, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Atzx);
    removeObserver(this.jdField_a_of_type_Aylg);
    removeObserver(this.jdField_a_of_type_Aygc);
    if (this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController != null) {
      this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.a();
    }
    n();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getIntExtra("sub_business_id", -1) == 103))
    {
      if (!isInMultiWindow()) {
        break label75;
      }
      bcql.a(this, 2131695574, 0).a();
    }
    for (;;)
    {
      axqy.b(null, "dc00898", "", "", "0X80082DD", "0X80082DD", 0, 0, "", "", "", "");
      return;
      label75:
      a(paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"), this.jdField_c_of_type_JavaLangString, true, false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
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
    case 2131362988: 
    case 2131376014: 
    case 2131371002: 
    case 2131377668: 
    case 2131377661: 
    case 2131364844: 
    case 2131371263: 
    case 2131377660: 
    case 2131377669: 
      do
      {
        return;
        doOnBackPressed();
        return;
        h();
        return;
        i();
        return;
        j();
        return;
        k();
        return;
        f(this.jdField_d_of_type_JavaLangString);
        return;
        l();
        return;
        a(false);
        axqy.b(null, "dc00898", "", "", "0X80082D3", "0X80082D3", 0, 0, "", "", "", "");
        return;
        paramView = this.jdField_a_of_type_JavaLangString;
        b(this.jdField_b_of_type_JavaLangString);
        c(paramView);
        a(false);
        if ((this.jdField_b_of_type_Audx != null) && (this.jdField_b_of_type_Audx.isShowing())) {
          this.jdField_b_of_type_Audx.dismiss();
        }
      } while ((this.jdField_a_of_type_Audx == null) || (!this.jdField_a_of_type_Audx.isShowing()));
      this.jdField_a_of_type_Audx.dismiss();
      return;
    }
    d(this.jdField_d_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity
 * JD-Core Version:    0.7.0.1
 */