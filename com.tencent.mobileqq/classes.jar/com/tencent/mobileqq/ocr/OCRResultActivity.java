package com.tencent.mobileqq.ocr;

import Override;
import afur;
import alqc;
import alqy;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
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
import anni;
import apfg;
import atwl;
import aufz;
import ayfa;
import ayfc;
import ayfl;
import ayfm;
import ayfn;
import ayfo;
import ayfp;
import ayfq;
import ayfr;
import ayfs;
import ayft;
import ayfu;
import ayfv;
import ayfw;
import ayfx;
import ayfy;
import ayfz;
import aygt;
import aygv;
import ayjb;
import ayjc;
import ayje;
import bclx;
import bcst;
import bdjg;
import bdjj;
import bdjl;
import bdnt;
import bdoo;
import bdop;
import bgey;
import bgfz;
import bgln;
import bgnt;
import biau;
import bkho;
import bkqt;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
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
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ayfq(this);
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new ayfr(this);
  public EditText a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  public TextView a;
  private ayfc jdField_a_of_type_Ayfc = new ayfz(this);
  private aygt jdField_a_of_type_Aygt;
  private aygv jdField_a_of_type_Aygv = new ayfn(this);
  private ayjb jdField_a_of_type_Ayjb;
  public ayjc a;
  private bdjl jdField_a_of_type_Bdjl = new ayfm(this, this);
  private bdop jdField_a_of_type_Bdop = new ayfy(this);
  biau jdField_a_of_type_Biau;
  private bkho jdField_a_of_type_Bkho;
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
  public ayjc b;
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setOnMenuClickListener(new ayfl(this));
  }
  
  private void a(int paramInt)
  {
    if ((isFinishing()) || ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing()))) {
      return;
    }
    if (this.jdField_a_of_type_Biau == null) {
      this.jdField_a_of_type_Biau = new biau(this, 0, 2131561459, 48);
    }
    this.jdField_a_of_type_Biau.c(paramInt);
    this.jdField_a_of_type_Biau.c(false);
    this.jdField_a_of_type_Biau.show();
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
    if (AppSetting.jdField_c_of_type_Boolean) {
      paramEditText.setAutoLinkMask(7);
    }
    for (;;)
    {
      paramEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramEditText.addTextChangedListener(new ayfo(this));
      if (a()) {
        paramEditText.setCustomSelectionActionModeCallback(new ayfp(this, paramEditText));
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
        this.jdField_a_of_type_AndroidWidgetEditText.setText(new bdnt(paramOcrRecogResult.ocrContent, 8, 16));
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
    if (!bgnt.g(getApplicationContext()))
    {
      QLog.d("OCRResultActivity", 1, "requestOcr, network error");
      QQToast.a(this, 1, 2131691985, 0).a();
      return;
    }
    if (!atwl.a(paramString1))
    {
      QLog.d("OCRResultActivity", 1, "requestOcr, file not exist, picPath:" + paramString1);
      QQToast.a(this, 1, 2131698131, 0).a();
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
      if (this.jdField_a_of_type_Aygt == null)
      {
        this.jdField_a_of_type_Aygt = new aygt(this.app, this.jdField_a_of_type_Aygv, 5);
        this.jdField_a_of_type_Aygt.d();
      }
      this.jdField_a_of_type_Aygt.a(this.jdField_d_of_type_JavaLangString, paramBoolean2, paramString2);
      return;
      a(2131698134);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c())) {
      ImmersiveUtils.a(paramBoolean, getWindow());
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    String str = bgln.d();
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
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(bclx.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, localLayoutParams);
      if (this.jdField_b_of_type_Int == 0) {
        this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(anni.a(2131706588));
      }
    }
    else if (this.f == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.f = new ImageView(this);
      this.f.setImageResource(2130843235);
      localLayoutParams.leftMargin = afur.a(12.0F, getResources());
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label304;
      }
    }
    label304:
    for (localLayoutParams.topMargin = (ImmersiveUtils.getStatusBarHeight(this) + afur.a(12.0F, getResources()));; localLayoutParams.topMargin = afur.a(12.0F, getResources()))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.f, localLayoutParams);
      this.f.setOnClickListener(new ayfs(this));
      this.f.bringToFront();
      return;
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(anni.a(2131706591));
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
      while (AppSetting.jdField_c_of_type_Boolean)
      {
        bgfz.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_JavaLangString, getString(2131698146));
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
        paramString = getResources().getDrawable(2130845625);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramString);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (!bgnt.g(getApplicationContext())) {
      QQToast.a(this, 1, 2131691985, 0).a();
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
      a(2131698147);
    }
    label222:
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.a(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, true);
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
      while (AppSetting.jdField_c_of_type_Boolean)
      {
        bgfz.a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_JavaLangString, getString(2131698146));
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
        paramString = getResources().getDrawable(2130845625);
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
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131166417)));
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setVisibility(8);
      a(false);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      apfg.a(this, this.jdField_c_of_type_AndroidViewView);
    }
  }
  
  private void d(String paramString)
  {
    bcst.b(null, "dc00898", "", "", "0X800A161", "0X800A161", 0, 0, "", "0", "0", "");
    if (!bgnt.g(getApplicationContext()))
    {
      QLog.d("OCRResultActivity", 1, "requestExport, network error");
      QQToast.a(this, 1, 2131691985, 0).a();
      return;
    }
    if (!atwl.a(paramString))
    {
      QLog.d("OCRResultActivity", 1, "requestExport, file not exist, picPath:" + paramString);
      QQToast.a(this, 1, 2131698131, 0).a();
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
    ((bdjj)this.app.a(157)).a(this.jdField_d_of_type_JavaLangString);
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
      a(true);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130838320));
      apfg.a(this, this.jdField_a_of_type_AndroidViewView);
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
      aufz.a(this, paramString, 21);
      if (this.jdField_d_of_type_Int != 0) {
        break;
      }
      bcst.b(null, "dc00898", "", "", "0X80082EB", "0X80082EB", 0, 0, "", "", "", "");
      return;
      paramString.putExtra("KEY_FROM_TRANSLATE", true);
    }
    bcst.b(null, "dc00898", "", "", "0X8009C84", "0X8009C84", 0, 0, "", "", "", "");
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
      a(false);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131166417)));
      apfg.a(this, this.jdField_c_of_type_AndroidViewView);
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
    bcst.b(null, "dc00898", "", "", "0X80082DB", "0X80082DB", 0, 0, "", "", "", "");
  }
  
  private void g()
  {
    alqc localalqc = alqc.a();
    if ((localalqc.c()) && (localalqc.a())) {
      localalqc.d();
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
    this.jdField_a_of_type_Bkho = bkho.a(this);
    this.jdField_a_of_type_Bkho.a(2131698137);
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.jdField_a_of_type_Bkho.a(a(str), str.equalsIgnoreCase(this.jdField_c_of_type_JavaLangString));
    }
    this.jdField_a_of_type_Bkho.c(2131690582);
    this.jdField_a_of_type_Bkho.a(new ayft(this));
    try
    {
      this.jdField_a_of_type_Bkho.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Ayjc != null) && (this.jdField_a_of_type_Ayjc.isShowing())) {
      this.jdField_a_of_type_Ayjc.dismiss();
    }
    if ((this.jdField_b_of_type_Ayjc != null) && (this.jdField_b_of_type_Ayjc.isShowing())) {
      this.jdField_b_of_type_Ayjc.dismiss();
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
          ayje localayje = new ayje();
          localayje.jdField_b_of_type_JavaLangString = str;
          localayje.jdField_a_of_type_JavaLangString = a(str);
          if (str.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {
            j = i;
          }
          localArrayList.add(localayje);
        }
      }
      this.jdField_b_of_type_Ayjc = ayjc.a(this, localArrayList, j, new ayfu(this));
    } while (this.jdField_b_of_type_Ayjc == null);
    this.jdField_b_of_type_Ayjc.setOnDismissListener(new ayfv(this));
    int i = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    int j = afur.a(75.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_Ayjc.showAsDropDown(this.jdField_a_of_type_AndroidWidgetTextView, i - j, 0);
  }
  
  private void k()
  {
    if ((this.jdField_b_of_type_Ayjc != null) && (this.jdField_b_of_type_Ayjc.isShowing())) {
      this.jdField_b_of_type_Ayjc.dismiss();
    }
    if ((this.jdField_a_of_type_Ayjc != null) && (this.jdField_a_of_type_Ayjc.isShowing())) {
      this.jdField_a_of_type_Ayjc.dismiss();
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
          ayje localayje = new ayje();
          localayje.jdField_b_of_type_JavaLangString = str;
          localayje.jdField_a_of_type_JavaLangString = a(str);
          if (str.equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)) {
            j = i;
          }
          localArrayList.add(localayje);
        }
      }
      this.jdField_a_of_type_Ayjc = ayjc.a(this, localArrayList, j, new ayfw(this));
    } while (this.jdField_a_of_type_Ayjc == null);
    this.jdField_a_of_type_Ayjc.setOnDismissListener(new ayfx(this));
    int i = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    int j = afur.a(75.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_Ayjc.showAsDropDown(this.jdField_b_of_type_AndroidWidgetTextView, i - j, 0);
  }
  
  private void l()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (!bgnt.d(this))
    {
      QQToast.a(getApplicationContext(), anni.a(2131706592), 0).b(getResources().getDimensionPixelSize(2131298998));
      return;
    }
    m();
    ((bdoo)this.app.a(161)).a(this.app, str);
    bcst.b(this.app, "dc00898", "", "", "0X800A357", "0X800A357", 2, 0, "", "", "", "");
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView = new TextPreviewMenu.ProgressView(this);
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this);
      if (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null) {
        this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new alqy(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView.setProgressText(anni.a(2131706594));
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
    if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {
      this.jdField_a_of_type_Biau.dismiss();
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
      paramString = bdjg.b(str, "s_qq_ocr_save");
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
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
    if ((this.jdField_b_of_type_Ayjc != null) && (this.jdField_b_of_type_Ayjc.isShowing())) {
      this.jdField_b_of_type_Ayjc.dismiss();
    }
    if ((this.jdField_a_of_type_Ayjc != null) && (this.jdField_a_of_type_Ayjc.isShowing())) {
      this.jdField_a_of_type_Ayjc.dismiss();
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
    setContentView(2131561338);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      bkqt.a(this);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376807));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131378879);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363209));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377358));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131371921));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371900));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131379122));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379117));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379110));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379118));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131371917));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379115));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363624));
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363628));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = ((ParticipleView)findViewById(2131373126));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView = ((ParticipleBottomMenuView)findViewById(2131372166));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)findViewById(2131365167));
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)findViewById(2131372167));
    this.jdField_c_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)findViewById(2131379109));
    this.jdField_d_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)findViewById(2131366128));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372840));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365031);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376788);
    apfg.a(this, this.jdField_c_of_type_AndroidViewView);
    apfg.a(this, this.jdField_d_of_type_AndroidViewViewGroup, true, 0);
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
      this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig = ((ayfa)this.app.getManager(228)).a(false);
      addObserver(this.jdField_a_of_type_Ayfc);
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
      addObserver(this.jdField_a_of_type_Bdjl);
      this.jdField_a_of_type_Ayjb = new ayjb(this);
      bcst.b(null, "dc00898", "", "", "0X800A160", "0X800A160", 0, 0, "", "0", "0", "");
      addObserver(this.jdField_a_of_type_Bdop);
      return true;
      b(true);
      continue;
      paramBundle = (OcrRecogResult)getIntent().getParcelableExtra("param_ocr_result");
      this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("param_ocr_path");
      d();
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = afur.a(24.0F, getResources());
      localURLDrawableOptions.mRequestHeight = afur.a(24.0F, getResources());
      URLDrawable localURLDrawable = URLDrawable.getDrawable(new File(this.jdField_d_of_type_JavaLangString), localURLDrawableOptions);
      localURLDrawable.setTag(bgey.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, afur.a(3.0F, getResources())));
      localURLDrawable.setDecodeHandler(bgey.j);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabImage(localURLDrawable);
      if (paramBundle != null) {
        a(paramBundle);
      }
      for (;;)
      {
        bcst.b(null, "dc00898", "", "", "0X80082CE", "0X80082CE", 0, 0, "", "", "", "");
        if (this.jdField_e_of_type_Int != 2) {
          break label881;
        }
        bcst.b(null, "dc00898", "", "", "0X8009C87", "0X8009C87", 2, 0, "", "", "", "");
        break;
        a(this.jdField_d_of_type_JavaLangString, null, true, true);
      }
      label881:
      if (this.jdField_e_of_type_Int == 1) {
        bcst.b(null, "dc00898", "", "", "0X8009C87", "0X8009C87", 1, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Ayfc);
    removeObserver(this.jdField_a_of_type_Bdop);
    removeObserver(this.jdField_a_of_type_Bdjl);
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
      QQToast.a(this, 2131694622, 0).a();
    }
    for (;;)
    {
      bcst.b(null, "dc00898", "", "", "0X80082DD", "0X80082DD", 0, 0, "", "", "", "");
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      doOnBackPressed();
      continue;
      h();
      continue;
      i();
      continue;
      j();
      continue;
      k();
      continue;
      f(this.jdField_d_of_type_JavaLangString);
      continue;
      l();
      continue;
      b(false);
      bcst.b(null, "dc00898", "", "", "0X80082D3", "0X80082D3", 0, 0, "", "", "", "");
      continue;
      String str = this.jdField_a_of_type_JavaLangString;
      b(this.jdField_b_of_type_JavaLangString);
      c(str);
      b(false);
      if ((this.jdField_b_of_type_Ayjc != null) && (this.jdField_b_of_type_Ayjc.isShowing())) {
        this.jdField_b_of_type_Ayjc.dismiss();
      }
      if ((this.jdField_a_of_type_Ayjc != null) && (this.jdField_a_of_type_Ayjc.isShowing()))
      {
        this.jdField_a_of_type_Ayjc.dismiss();
        continue;
        d(this.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity
 * JD-Core Version:    0.7.0.1
 */