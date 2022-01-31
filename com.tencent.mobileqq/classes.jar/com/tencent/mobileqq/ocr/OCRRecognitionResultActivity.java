package com.tencent.mobileqq.ocr;

import agaz;
import agba;
import agbb;
import agbc;
import agbd;
import agbe;
import agbf;
import agbg;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;

public class OCRRecognitionResultActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener
{
  public static final String[] a;
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new agbc(this);
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private OCRObserver jdField_a_of_type_ComTencentMobileqqOcrOCRObserver = new agbf(this);
  private OcrRecogResult jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private View jdField_f_of_type_AndroidViewView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private ImageView g;
  
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
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842914);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131439055));
    this.jdField_a_of_type_ComTencentWidgetScrollView.fullScroll(33);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new agbe(this));
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
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str2 = arrayOfString[i];
      if ((TextUtils.isEmpty(str2)) || (!str1.equals(str2))) {}
    }
    for (;;)
    {
      return bool;
      i += 1;
      break;
      bool = true;
    }
  }
  
  private void b()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(4);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842911);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131439054));
  }
  
  private void b(String paramString)
  {
    paramString = EditPicActivity.a(getActivity(), paramString, false, false, false, true, false, 2, 99, 9);
    paramString.putExtra("babyq_ability", 2L);
    paramString.putExtra("sub_business_id", 105);
    startActivity(paramString);
  }
  
  private boolean b()
  {
    return (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 4);
  }
  
  private void c()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(false);
  }
  
  private void d()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
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
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439048, 0).a();
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
    int i = 0;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.ocrContent))
    {
      i = 1;
      a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.ocrContent);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.goodsPicUrl)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.goodsName)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.goodsDetailUrl))) {}
    for (int j = 1;; j = 0)
    {
      if ((i == 0) && (j == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("OCRRecognitionResultActivity", 2, "hasOcrRet == false && hasJdRet == false, Activity finished.");
        }
        finish();
      }
      ReportController.b(null, "dc00898", "", "", "0X80082CE", "0X80082CE", 0, 0, "", "", "", "");
      setContentView(2130970501);
      this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)findViewById(2131363769));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131362711);
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new agaz(this));
      addObserver(this.jdField_a_of_type_ComTencentMobileqqOcrOCRObserver);
      float f1 = getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370884));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        paramBundle = URLDrawable.URLDrawableOptions.obtain();
        paramBundle.mRequestWidth = getResources().getDisplayMetrics().widthPixels;
        paramBundle.mRequestHeight = getResources().getDisplayMetrics().heightPixels;
        paramBundle = URLDrawable.getDrawable(new File(this.jdField_a_of_type_JavaLangString), paramBundle);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
      }
      this.jdField_e_of_type_AndroidViewView = findViewById(2131361792);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131370886);
      paramBundle = (TextView)findViewById(2131370893);
      if (j != 0)
      {
        ReportController.b(null, "dc00898", "", "", "0X80082DF", "0X80082DF", 0, 0, "", "", "", "");
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370887));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        ImageView localImageView = (ImageView)findViewById(2131370890);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = ((int)(90.0F * f1));
        localURLDrawableOptions.mRequestHeight = ((int)(90.0F * f1));
        localImageView.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.goodsPicUrl, localURLDrawableOptions));
        ((TextView)findViewById(2131366067)).setText(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.goodsName);
        ((TextView)findViewById(2131370891)).setText("¥ " + this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.goodsPrice);
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362702));
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370898));
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366989));
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370899));
        this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131370894));
        this.jdField_b_of_type_AndroidWidgetEditText.setLinkTextColor(-15550475);
        if (a()) {
          this.jdField_b_of_type_AndroidWidgetEditText.setCustomSelectionActionModeCallback(new agbg(this, this.jdField_b_of_type_AndroidWidgetEditText));
        }
        if (!AppSetting.b) {
          break label1084;
        }
        this.jdField_b_of_type_AndroidWidgetEditText.setAutoLinkMask(7);
        label764:
        this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        if (i == 0) {
          break label1095;
        }
        this.jdField_b_of_type_AndroidWidgetEditText.setText(new QQText(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.ocrContent, 8, 16));
        this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(new agba(this));
        paramBundle.setVisibility(0);
        label824:
        this.jdField_b_of_type_AndroidViewView = findViewById(2131370885);
        this.jdField_c_of_type_AndroidViewView = findViewById(2131370892);
        this.jdField_d_of_type_AndroidViewView = findViewById(2131370895);
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131370897));
        if (a()) {
          this.jdField_a_of_type_AndroidWidgetEditText.setCustomSelectionActionModeCallback(new agbg(this, this.jdField_a_of_type_AndroidWidgetEditText));
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setLinkTextColor(-15550475);
        this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        if (!AppSetting.b) {
          break label1116;
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setAutoLinkMask(7);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new agbb(this));
        this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363978));
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
        if (OCRManager.c(this.app.getCurrentAccountUin())) {
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        return true;
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        break;
        label1084:
        this.jdField_b_of_type_AndroidWidgetEditText.setAutoLinkMask(0);
        break label764;
        label1095:
        paramBundle.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetEditText.setEnabled(false);
        c();
        break label824;
        label1116:
        this.jdField_a_of_type_AndroidWidgetEditText.setAutoLinkMask(0);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqOcrOCRObserver);
    super.doOnDestroy();
    this.jdField_b_of_type_AndroidWidgetEditText.setText(null);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(null);
    ThreadManager.postImmediately(new agbd(this, this.jdField_a_of_type_JavaLangString), null, false);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getIntExtra("sub_business_id", -1) == 103))
    {
      if (isInMultiWindow()) {
        QQToast.a(this, 2131438463, 0).a();
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
    }
    a(1);
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
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
        QQToast.a(this, 1, 2131433009, 0).a();
        return;
      }
      if ((this.jdField_c_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 4))
      {
        ReportController.b(null, "dc00898", "", "", "0X80082D3", "0X80082D3", 0, 0, "", "", "", "");
        if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())) {
          break label660;
        }
      }
    }
    label660:
    for (int i = 1;; i = 0)
    {
      Object localObject = a(this.jdField_b_of_type_AndroidWidgetEditText);
      paramView = (View)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramView = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
      }
      int j = i;
      if (!TextUtils.isEmpty(paramView))
      {
        j = i;
        if (!paramView.equals(this.jdField_b_of_type_JavaLangString)) {
          j = 1;
        }
      }
      if (j != 0)
      {
        if (TextUtils.isEmpty(paramView)) {
          break;
        }
        this.jdField_b_of_type_JavaLangString = paramView;
        a(0, "正在翻译...");
        ((OCRHandler)this.app.a(113)).a(paramView);
        return;
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
        if (!TextUtils.isEmpty(paramView))
        {
          localObject = new OCRShareHelper(this, this.app);
          ((OCRShareHelper)localObject).a(paramView);
          ((OCRShareHelper)localObject).a();
        }
        ReportController.b(null, "dc00898", "", "", "0X80082D7", "0X80082D7", 0, 0, "", "", "", "");
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
          QQToast.a(this, 2131438463, 0).a();
          return;
        }
        ReportController.b(null, "dc00898", "", "", "0X80082DB", "0X80082DB", 0, 0, "", "", "", "");
        a(this.jdField_a_of_type_JavaLangString, 103);
        return;
      }
      if ((paramView != this.jdField_e_of_type_AndroidWidgetImageView) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        break;
      }
      ReportController.b(null, "dc00898", "", "", "0X80085CE", "0X80085CE", 0, 0, "", "", "", "");
      a(this.jdField_a_of_type_JavaLangString, 105);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRRecognitionResultActivity
 * JD-Core Version:    0.7.0.1
 */