package com.tencent.mobileqq.ocr;

import agfd;
import agfe;
import agfh;
import agfi;
import agfj;
import agfk;
import agfl;
import agfm;
import agfn;
import agfo;
import agfp;
import agfq;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;
import com.tencent.mobileqq.ocr.view.TranslatePopupActionSheetMenuDialog;
import com.tencent.mobileqq.ocr.view.TranslatePopupActionSheetMenuDialog.MenuItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class OCRRecognitionResultActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener
{
  public static final String[] a;
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new agfl(this);
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private OCRObserver jdField_a_of_type_ComTencentMobileqqOcrOCRObserver = new agfp(this);
  private OcrControl jdField_a_of_type_ComTencentMobileqqOcrOcrControl;
  private OcrRecogResult jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private View.OnTouchListener jdField_b_of_type_AndroidViewView$OnTouchListener = new agfm(this);
  private View jdField_b_of_type_AndroidViewView;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private String jdField_c_of_type_JavaLangString;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private String jdField_d_of_type_JavaLangString;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private String jdField_e_of_type_JavaLangString;
  private View jdField_f_of_type_AndroidViewView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private String jdField_f_of_type_JavaLangString;
  private ImageView g;
  private ImageView h;
  private ImageView i;
  
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
      int j;
      int k;
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
              j = paramTextView.getSelectionStart();
              k = paramTextView.getSelectionEnd();
              str2 = paramTextView.getText().toString();
              paramTextView = str1;
            } while (TextUtils.isEmpty(str2));
            paramTextView = str1;
          } while (j >= k);
          paramTextView = str1;
        } while (j < 0);
        paramTextView = str1;
      } while (k > str2.length());
      str1 = str2.substring(j, k);
      paramTextView = str1;
    } while (!QLog.isColorLevel());
    QLog.d("OCRRecognitionResultActivity", 2, "getSelectedWord " + str1);
    return str1;
  }
  
  private String a(boolean paramBoolean)
  {
    String str2 = "";
    String str1;
    if (b())
    {
      str1 = str2;
      if (this.jdField_b_of_type_AndroidWidgetEditText != null)
      {
        if (paramBoolean) {
          str2 = a(this.jdField_b_of_type_AndroidWidgetEditText);
        }
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
        }
      }
    }
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (this.jdField_a_of_type_AndroidWidgetEditText == null);
      if (paramBoolean) {
        str2 = a(this.jdField_a_of_type_AndroidWidgetEditText);
      }
      str1 = str2;
    } while (!TextUtils.isEmpty(str2));
    return this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
  }
  
  private void a()
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(4);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842945);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131439080));
    this.jdField_b_of_type_AndroidWidgetEditText.clearFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    this.jdField_a_of_type_ComTencentWidgetScrollView.scrollTo(this.jdField_a_of_type_ComTencentWidgetScrollView.getScrollX(), 0);
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRRecognitionResultActivity", 2, "dismissWaittingDialog, dlgType=" + paramInt + ",currWaitingDlgType=" + this.jdField_a_of_type_Int);
    }
    if ((paramInt != -1) && (this.jdField_a_of_type_Int != paramInt)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) || (isFinishing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRRecognitionResultActivity", 2, "showWaitingDialog, dlgType=" + paramInt + ",currWaitingDlgType=" + this.jdField_a_of_type_Int);
    }
    if ((isFinishing()) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRRecognitionResultActivity", 2, "showWaitingDialog, activity is finishing or dlg showing");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, 0, 2130970590, 17);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new agfo(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 10000L);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(OcrRecogResult paramOcrRecogResult)
  {
    if ((paramOcrRecogResult == null) || (paramOcrRecogResult.isEmpty())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OCRRecognitionResultActivity", 2, "updateData mSelectOcrLanguage:" + this.jdField_d_of_type_JavaLangString + " ocrRecogResult.language:" + paramOcrRecogResult.language);
    }
    if (!TextUtils.isEmpty(paramOcrRecogResult.language)) {
      this.jdField_c_of_type_JavaLangString = paramOcrRecogResult.language;
    }
    this.jdField_d_of_type_JavaLangString = null;
    if ((paramOcrRecogResult.ocr_languages != null) && (!paramOcrRecogResult.ocr_languages.isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList = paramOcrRecogResult.ocr_languages;
    }
    if ((paramOcrRecogResult.dst_translate_languages != null) && (!paramOcrRecogResult.dst_translate_languages.isEmpty())) {
      this.jdField_b_of_type_JavaUtilArrayList = paramOcrRecogResult.dst_translate_languages;
    }
    if ((paramOcrRecogResult.language_descs != null) && (!paramOcrRecogResult.language_descs.isEmpty())) {
      OcrControl.b.putAll(paramOcrRecogResult.language_descs);
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult = paramOcrRecogResult;
    if (!TextUtils.isEmpty(paramOcrRecogResult.ocrContent)) {
      this.jdField_b_of_type_AndroidWidgetEditText.setText(new QQText(paramOcrRecogResult.ocrContent, 8, 16));
    }
    e();
    this.jdField_b_of_type_JavaLangString = null;
  }
  
  private void a(String paramString)
  {
    paramString = EditPicActivity.a(this, paramString, false, false, false, true, false, 2, 99, 9);
    paramString.putExtra("babyq_ability", 2L);
    paramString.putExtra("sub_business_id", 103);
    startActivity(paramString);
  }
  
  private void a(String paramString1, String paramString2) {}
  
  public static boolean a()
  {
    boolean bool = false;
    String str1 = DeviceInfoUtil.e();
    if (QLog.isColorLevel()) {
      QLog.d("OCRRecognitionResultActivity", 2, "isSupportAddContextMenu mode:" + str1);
    }
    if (TextUtils.isEmpty(str1)) {
      return true;
    }
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int k = arrayOfString.length;
    int j = 0;
    if (j < k)
    {
      String str2 = arrayOfString[j];
      if ((TextUtils.isEmpty(str2)) || (!str1.equals(str2))) {}
    }
    for (;;)
    {
      return bool;
      j += 1;
      break;
      bool = true;
    }
  }
  
  private void b()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(4);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842944);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131439079));
    this.jdField_b_of_type_AndroidWidgetEditText.clearFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    this.jdField_a_of_type_ComTencentWidgetScrollView.scrollTo(this.jdField_a_of_type_ComTencentWidgetScrollView.getScrollX(), 0);
  }
  
  private void b(String paramString)
  {
    paramString = EditPicActivity.a(getActivity(), paramString, false, false, false, true, false, 2, 99, 9);
    paramString.putExtra("babyq_ability", 2L);
    paramString.putExtra("sub_business_id", 105);
    startActivity(paramString);
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OCRRecognitionResultActivity", 2, "gotoTranslate dstLanguage: " + paramString2);
    }
    ((OCRHandler)this.app.a(113)).a(paramString1, this.jdField_c_of_type_JavaLangString, paramString2);
  }
  
  private boolean b()
  {
    return (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 4);
  }
  
  private void c()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    if ((this.jdField_c_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 4)) {
      this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(false);
  }
  
  private void c(String paramString)
  {
    if (!NetworkUtil.g(getApplicationContext()))
    {
      QQToast.a(this, 1, 2131433023, 0).a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl = new OcrControl(this.app, new agfe(this), 5);
      this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.d();
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 2, 0, "提取文字中...");
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 400L);
    this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.a(this.jdField_a_of_type_JavaLangString, false, paramString);
  }
  
  private void d()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) || (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      findViewById(2131370881).setVisibility(8);
      if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (TextUtils.equals(this.jdField_c_of_type_JavaLangString.toLowerCase(), "zh"))) {
        break label175;
      }
      findViewById(2131370884).setVisibility(8);
      label94:
      if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (!TextUtils.equals(this.jdField_c_of_type_JavaLangString.toLowerCase(), "zh"))) {
        break label196;
      }
    }
    label175:
    label196:
    for (this.jdField_e_of_type_JavaLangString = "en";; this.jdField_e_of_type_JavaLangString = "zh")
    {
      if (OcrControl.b.containsKey(this.jdField_e_of_type_JavaLangString)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)OcrControl.b.get(this.jdField_e_of_type_JavaLangString));
      }
      return;
      findViewById(2131370881).setVisibility(0);
      break;
      findViewById(2131370884).setVisibility(0);
      this.jdField_e_of_type_JavaLangString = "zh";
      break label94;
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRRecognitionResultActivity", 2, "openOcrFeedBackActionSheet");
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("OCRRecognitionResultActivity", 2, "openOcrFeedBackActionSheet mOcrRecogResult: " + this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult);
      }
      ActionSheet localActionSheet = ActionSheet.a(this);
      localActionSheet.a(2131439092);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (OcrControl.b.containsKey(str))
        {
          localActionSheet.a((CharSequence)OcrControl.b.get(str), TextUtils.equals(str, this.jdField_c_of_type_JavaLangString));
          localArrayList.add(str);
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("OCRRecognitionResultActivity", 2, "openOcrFeedBackActionSheet not support language: " + str);
        }
      }
      localActionSheet.c(2131433029);
      localActionSheet.a(new agfh(this, localArrayList, localActionSheet));
      try
      {
        if (!localActionSheet.isShowing())
        {
          localActionSheet.show();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("OCRRecognitionResultActivity", 2, "openOcrFeedBackActionSheet actionSheet.show exception=" + localException);
      }
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRRecognitionResultActivity", 2, "openTranslateMoreOptions");
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (OcrControl.b.containsKey(str))
      {
        localArrayList.add(a(j, str, (String)OcrControl.b.get(str), TextUtils.equals(str, this.jdField_e_of_type_JavaLangString)));
        j += 1;
      }
      for (;;)
      {
        break;
        if (QLog.isColorLevel()) {
          QLog.i("OCRRecognitionResultActivity", 2, "openTranslateMoreOptions not support language: " + str);
        }
      }
    }
    TranslatePopupActionSheetMenuDialog.a(this, localArrayList, new agfi(this), null, 0, true).showAsDropDown(findViewById(2131370886), 0, AIOUtils.a(6.0F, getResources()));
  }
  
  public TranslatePopupActionSheetMenuDialog.MenuItem a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    TranslatePopupActionSheetMenuDialog.MenuItem localMenuItem = new TranslatePopupActionSheetMenuDialog.MenuItem();
    localMenuItem.jdField_a_of_type_Int = paramInt;
    localMenuItem.jdField_a_of_type_JavaLangString = paramString1;
    localMenuItem.jdField_a_of_type_Boolean = paramBoolean;
    localMenuItem.jdField_b_of_type_JavaLangString = paramString2;
    localMenuItem.jdField_d_of_type_JavaLangString = paramString2;
    return localMenuItem;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRRecognitionResultActivity", 2, "launchPeak, path=" + paramString + ",cropEditType=" + paramInt);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    if ((TextUtils.isEmpty(paramString)) || (!FileUtils.a(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRRecognitionResultActivity", 2, "launchPeak, file is not exist");
      }
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439072, 0).a();
      return;
    }
    if (paramInt == 103) {
      a(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
      return;
      if (paramInt != 105) {
        break;
      }
      b(paramString);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 21) {}
    switch (paramInt2)
    {
    default: 
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X80082D9", "0X80082D9", 0, 0, "", "", "", "");
  }
  
  public void doOnBackPressed()
  {
    setResult(-1);
    finish();
    overridePendingTransition(0, 2131034135);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusDrawable(null);
      this.mSystemBarComp.setStatusBarDrawable(null);
      this.mSystemBarComp.setStatusColor(-15000805);
      this.mSystemBarComp.setStatusBarColor(-15000805);
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult = ((OcrRecogResult)getIntent().getParcelableExtra("param_recog_ret"));
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("param_recog_pic_path");
    if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OCRRecognitionResultActivity", 2, "ocrRecogResult is null, Activity finished.");
      }
      finish();
    }
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.ocr_languages;
    this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.dst_translate_languages;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.language;
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.language_descs != null) && (!this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.language_descs.isEmpty())) {
      OcrControl.b.putAll(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.language_descs);
    }
    int j = 0;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.ocrContent))
    {
      j = 1;
      a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.ocrContent);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.goodsPicUrl)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.goodsName)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.goodsDetailUrl))) {}
    for (int k = 1;; k = 0)
    {
      if ((j == 0) && (k == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("OCRRecognitionResultActivity", 2, "hasOcrRet == false && hasJdRet == false, Activity finished.");
        }
        finish();
      }
      ReportController.b(null, "dc00898", "", "", "0X80082CE", "0X80082CE", 0, 0, "", "", "", "");
      setContentView(2130970513);
      this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)findViewById(2131363793));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131362716);
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new agfd(this));
      addObserver(this.jdField_a_of_type_ComTencentMobileqqOcrOCRObserver);
      float f1 = getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370871));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        paramBundle = URLDrawable.URLDrawableOptions.obtain();
        paramBundle.mRequestWidth = getResources().getDisplayMetrics().widthPixels;
        paramBundle.mRequestHeight = getResources().getDisplayMetrics().heightPixels;
        paramBundle = URLDrawable.getDrawable(new File(this.jdField_a_of_type_JavaLangString), paramBundle);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
      }
      this.jdField_e_of_type_AndroidViewView = findViewById(2131361792);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131370873);
      paramBundle = (TextView)findViewById(2131370880);
      if (k != 0)
      {
        ReportController.b(null, "dc00898", "", "", "0X80082DF", "0X80082DF", 0, 0, "", "", "", "");
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370874));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        ImageView localImageView = (ImageView)findViewById(2131370877);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = ((int)(90.0F * f1));
        localURLDrawableOptions.mRequestHeight = ((int)(90.0F * f1));
        localImageView.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.goodsPicUrl, localURLDrawableOptions));
        ((TextView)findViewById(2131366072)).setText(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.goodsName);
        ((TextView)findViewById(2131370878)).setText("¥ " + this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.goodsPrice);
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362707));
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370889));
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366987));
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370891));
        this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131370882));
        this.jdField_b_of_type_AndroidWidgetEditText.setLinkTextColor(-15550475);
        if (a()) {
          this.jdField_b_of_type_AndroidWidgetEditText.setCustomSelectionActionModeCallback(new agfq(this, this.jdField_b_of_type_AndroidWidgetEditText));
        }
        if (!AppSetting.b) {
          break label1308;
        }
        this.jdField_b_of_type_AndroidWidgetEditText.setAutoLinkMask(7);
        label833:
        this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
        if (j == 0) {
          break label1319;
        }
        this.jdField_b_of_type_AndroidWidgetEditText.setText(new QQText(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.ocrContent, 8, 16));
        this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(new agfj(this));
        paramBundle.setVisibility(0);
        label893:
        this.jdField_b_of_type_AndroidViewView = findViewById(2131370872);
        this.jdField_c_of_type_AndroidViewView = findViewById(2131370879);
        this.jdField_d_of_type_AndroidViewView = findViewById(2131370883);
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131370888));
        if (a()) {
          this.jdField_a_of_type_AndroidWidgetEditText.setCustomSelectionActionModeCallback(new agfq(this, this.jdField_a_of_type_AndroidWidgetEditText));
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setLinkTextColor(-15550475);
        this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
        if (!AppSetting.b) {
          break label1340;
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setAutoLinkMask(7);
        label1001:
        this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new agfk(this));
        this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364003));
        this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.g = ((ImageView)findViewById(2131361846));
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          paramBundle = URLDrawable.URLDrawableOptions.obtain();
          paramBundle.mRequestWidth = ((int)(60.0F * f1));
          paramBundle.mRequestHeight = ((int)(60.0F * f1));
          paramBundle = URLDrawable.getDrawable(new File(this.jdField_a_of_type_JavaLangString), paramBundle);
          this.g.setImageDrawable(paramBundle);
        }
        this.g.setOnClickListener(this);
        this.h = ((ImageView)findViewById(2131370893));
        this.h.setOnClickListener(this);
        this.i = ((ImageView)findViewById(2131365250));
        this.i.setOnClickListener(this);
        boolean bool = OCRManager.c(this.app.getCurrentAccountUin());
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        findViewById(2131370890).setVisibility(8);
        if (!bool) {
          break label1351;
        }
        this.i.setVisibility(0);
        findViewById(2131370894).setVisibility(0);
        this.h.setVisibility(8);
        findViewById(2131370892).setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370885));
        findViewById(2131370881).setOnClickListener(this);
        findViewById(2131370884).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        findViewById(2131370884).setOnClickListener(this);
        e();
        return true;
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        break;
        label1308:
        this.jdField_b_of_type_AndroidWidgetEditText.setAutoLinkMask(0);
        break label833;
        label1319:
        paramBundle.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetEditText.setEnabled(false);
        c();
        break label893;
        label1340:
        this.jdField_a_of_type_AndroidWidgetEditText.setAutoLinkMask(0);
        break label1001;
        label1351:
        this.i.setVisibility(8);
        findViewById(2131370894).setVisibility(8);
        this.h.setVisibility(0);
        findViewById(2131370892).setVisibility(0);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqOcrOCRObserver);
    super.doOnDestroy();
    this.jdField_b_of_type_AndroidWidgetEditText.setText(null);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(null);
    ThreadManager.postImmediately(new agfn(this, this.jdField_a_of_type_JavaLangString), null, false);
    if (this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.e();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getIntExtra("sub_business_id", -1) == 103))
    {
      if (isInMultiWindow()) {
        QQToast.a(this, 2131438483, 0).a();
      }
    }
    else {
      return;
    }
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (!TextUtils.isEmpty(paramIntent))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("ocr_pic_path", paramIntent);
      setResult(-1, localIntent);
      finish();
      overridePendingTransition(0, 2131034135);
      ReportController.b(null, "dc00898", "", "", "0X80082DD", "0X80082DD", 0, 0, "", "", "", "");
      return;
    }
    setResult(-1);
    finish();
    overridePendingTransition(0, 2131034135);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    a(-1);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2131034135);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 0: 
      a(1, "正在加载...");
      return true;
    case 1: 
      a(1);
      return true;
    }
    a(paramMessage.arg1, String.valueOf(paramMessage.obj));
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRRecognitionResultActivity", 2, "onClick " + paramView.getId());
    }
    if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
    {
      paramView = a(true);
      if (!TextUtils.isEmpty(paramView))
      {
        OCRTextSearchActivity.a(this, paramView);
        overridePendingTransition(2131034132, 0);
      }
      ReportController.b(null, "dc00898", "", "", "0X80082D1", "0X80082D1", 0, 0, "", "", "", "");
      return;
    }
    if (paramView == this.jdField_c_of_type_AndroidWidgetImageView)
    {
      if (!NetworkUtil.g(getApplicationContext()))
      {
        QQToast.a(this, 1, 2131433023, 0).a();
        return;
      }
      if ((this.jdField_c_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 4))
      {
        ReportController.b(null, "dc00898", "", "", "0X80082D3", "0X80082D3", 0, 0, "", "", "", "");
        if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())) {
          break label851;
        }
      }
    }
    label391:
    label851:
    for (int j = 1;; j = 0)
    {
      paramView = a(this.jdField_b_of_type_AndroidWidgetEditText);
      if (TextUtils.isEmpty(paramView))
      {
        paramView = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
        ReportController.b(null, "dc00898", "", "", "0X8009104", "0X8009104", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X8009105", "0X8009105", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        int k = j;
        if (!TextUtils.isEmpty(paramView))
        {
          k = j;
          if (!paramView.equals(this.jdField_b_of_type_JavaLangString)) {
            k = 1;
          }
        }
        if (k == 0) {
          break label391;
        }
        if (TextUtils.isEmpty(paramView)) {
          break;
        }
        this.jdField_b_of_type_JavaLangString = paramView;
        a(0, "正在翻译...");
        b(paramView, this.jdField_e_of_type_JavaLangString);
        return;
        ReportController.b(null, "dc00898", "", "", "0X8009106", "0X8009106", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X8009107", "0X8009107", 0, 0, "", "", "", "");
      }
      a();
      return;
      if ((this.jdField_c_of_type_AndroidViewView.getVisibility() != 4) || (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0)) {
        break;
      }
      b();
      ReportController.b(null, "dc00898", "", "", "0X80082D5", "0X80082D5", 0, 0, "", "", "", "");
      return;
      if (paramView == this.jdField_d_of_type_AndroidWidgetImageView)
      {
        paramView = a(false);
        new OCRShareHelper(this, this.app).c(paramView);
        return;
      }
      if (paramView == this.jdField_a_of_type_AndroidWidgetRelativeLayout)
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.moreUrl);
        startActivity(paramView);
        ReportController.b(null, "dc00898", "", "", "0X80082E0", "0X80082E0", 0, 0, "", "", "", "");
        return;
      }
      if (paramView == this.jdField_f_of_type_AndroidViewView)
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.goodsDetailUrl);
        startActivity(paramView);
        ReportController.b(null, "dc00898", "", "", "0X80082E1", "0X80082E1", 0, 0, "", "", "", "");
        return;
      }
      if (paramView == this.jdField_f_of_type_AndroidWidgetImageView)
      {
        doOnBackPressed();
        return;
      }
      if (paramView == this.g)
      {
        if (isInMultiWindow())
        {
          QQToast.a(this, 2131438483, 0).a();
          return;
        }
        ReportController.b(null, "dc00898", "", "", "0X80082DB", "0X80082DB", 0, 0, "", "", "", "");
        a(this.jdField_a_of_type_JavaLangString, 103);
        return;
      }
      if (paramView == this.jdField_e_of_type_AndroidWidgetImageView)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break;
        }
        ReportController.b(null, "dc00898", "", "", "0X80085CE", "0X80085CE", 0, 0, "", "", "", "");
        a(this.jdField_a_of_type_JavaLangString, 105);
        return;
      }
      if (paramView.getId() == 2131370881)
      {
        f();
        return;
      }
      if (paramView.getId() == 2131370884)
      {
        g();
        return;
      }
      if (paramView.getId() == 2131370893)
      {
        paramView = a(false);
        new OCRShareHelper(this, this.app).a(paramView);
        return;
      }
      if (paramView.getId() != 2131365250) {
        break;
      }
      paramView = a(false);
      new OCRShareHelper(this, this.app).a(paramView, this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRRecognitionResultActivity
 * JD-Core Version:    0.7.0.1
 */