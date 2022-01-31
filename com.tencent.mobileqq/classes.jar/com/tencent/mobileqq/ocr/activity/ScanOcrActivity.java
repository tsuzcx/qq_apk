package com.tencent.mobileqq.ocr.activity;

import aepi;
import alud;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import avwv;
import avxa;
import avxb;
import avxd;
import avxl;
import avxm;
import avxn;
import avxo;
import avxp;
import avxq;
import avxr;
import azkz;
import azqs;
import bdfa;
import bdin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.mobileqq.ocr.view.ScanOcrView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.QQPermissionGrant;

public class ScanOcrActivity
  extends ScanBaseActivity
  implements View.OnClickListener
{
  public int a;
  private long jdField_a_of_type_Long;
  SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new avxp(this);
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new avxn(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new avxm(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private avwv jdField_a_of_type_Avwv;
  public avxa a;
  private avxb jdField_a_of_type_Avxb;
  avxd jdField_a_of_type_Avxd = new avxq(this);
  private avxr jdField_a_of_type_Avxr;
  private ScanSuccessView jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView;
  public MaskView a;
  private ScanOcrView jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView;
  public String a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public String b;
  public boolean b;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private volatile boolean jdField_d_of_type_Boolean;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  
  public ScanOcrActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Avxa = new avxo(this);
  }
  
  private void a(int paramInt, OcrRecogResult paramOcrRecogResult, String paramString, long paramLong)
  {
    this.jdField_a_of_type_Avxr = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.ocr.ScanOcrActivity", 2, "dealOcrResult ocrResult: " + paramOcrRecogResult);
    }
    if ((paramInt == 0) && (paramOcrRecogResult != null) && (!paramOcrRecogResult.isEmpty()) && ((this.jdField_a_of_type_Int != 1) || ((!TextUtils.isEmpty(paramOcrRecogResult.ocrContent)) && (!TextUtils.isEmpty(paramOcrRecogResult.ocrContent.trim())))))
    {
      a(paramOcrRecogResult, paramString);
      azqs.b(null, "dc00898", "", "", "0X80082CC", "0X80082CC", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Int == 1) {
        azqs.b(null, "dc00898", "", "", "0X8008A1F", "0X8008A1F", 0, 0, "", "", "", "");
      }
      f();
      ThreadManager.post(new ScanOcrActivity.9(this, paramInt), 5, null, false);
      if (paramLong > 0L)
      {
        if (this.jdField_b_of_type_Int != 1) {
          break label384;
        }
        azqs.b(null, "dc00898", "", "", "0X80082E5", "0X80082E5", 0, 0, String.valueOf(paramLong), "", "", "");
      }
    }
    label238:
    label377:
    while (this.jdField_b_of_type_Int != 0)
    {
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699604, 0).a();
        if ((this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int != 4)) {
          break label377;
        }
        a(false);
      }
      for (;;)
      {
        azqs.b(null, "dc00898", "", "", "0X80082CA", "0X80082CA", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_Int != 1) {
          break;
        }
        azqs.b(null, "dc00898", "", "", "0X8008A20", "0X8008A20", 0, 0, "", "", "", "");
        break;
        if (paramInt == 1)
        {
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699601, 0).a();
          break label238;
        }
        if (paramInt == 0)
        {
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699603, 0).a();
          break label238;
        }
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699599, 0).a();
        break label238;
        finish();
      }
    }
    label384:
    azqs.b(null, "dc00898", "", "", "0X80082E4", "0X80082E4", 0, 0, String.valueOf(paramLong), "", "", "");
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (this.jdField_c_of_type_Boolean)
        {
          QLog.d("Q.ocr.ScanOcrActivity", 1, "recogPic is inRecog picPath:" + paramString + ",isCrop:" + paramBoolean);
          return;
        }
        if (bdin.d(this))
        {
          this.jdField_a_of_type_AndroidViewViewGroup.postDelayed(new ScanOcrActivity.4(this), 200L);
          this.jdField_c_of_type_Boolean = true;
          this.jdField_e_of_type_JavaLangString = paramString;
          this.jdField_d_of_type_Boolean = paramBoolean;
          avxb localavxb = this.jdField_a_of_type_Avxb;
          if (!paramBoolean) {
            bool = true;
          }
          localavxb.a(paramString, bool);
          if (this.jdField_b_of_type_Int == 1) {
            azqs.b(null, "dc00898", "", "", "0X80082C8", "0X80082C8", 0, 0, "", "", "", "");
          }
        }
        else
        {
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699607, 0).a();
        }
      }
      finally {}
    }
  }
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString)) && (!paramBoolean1))
    {
      QLog.d("Q.ocr.ScanOcrActivity", 1, "enterPreviewModel picPath:" + paramString + ",isFromCamera:" + paramBoolean1 + ",model:" + this.jdField_c_of_type_Int);
      return;
    }
    this.jdField_c_of_type_Int = 1;
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    if (this.jdField_a_of_type_Int != 1) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.a();
    }
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_Avwv != null) {
        this.jdField_a_of_type_Avwv.c();
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Int != 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.c();
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.e();
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.d();
        this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new ScanOcrActivity.3(this), 600L);
      }
      label178:
      while (QLog.isColorLevel())
      {
        QLog.d("Q.ocr.ScanOcrActivity", 2, "enterPreviewModel isFromCamera:" + paramBoolean1 + ",isCrop:" + paramBoolean2 + ",picPath:" + paramString);
        return;
        this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setModel(true);
      }
    }
    if (this.jdField_a_of_type_Int != 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.setVisibility(4);
      label257:
      if (!this.f) {
        break label292;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    for (;;)
    {
      a(paramString, paramBoolean2);
      break label178;
      break;
      this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(4);
      break label257;
      label292:
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(new File(paramString), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).downloadImediatly();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    if (this.jdField_a_of_type_Int != 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.a();
      f();
      if (!paramBoolean)
      {
        if (this.jdField_a_of_type_AndroidViewSurfaceView != null) {
          break label103;
        }
        d();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.ScanOcrActivity", 2, "enterScanModel");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setModel(false);
      break;
      label103:
      if ((this.jdField_a_of_type_Avwv != null) && (this.g))
      {
        this.jdField_a_of_type_Avwv.a();
        this.jdField_a_of_type_Avxb.d();
      }
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.ScanOcrActivity", 2, "initCameraView");
    }
    this.jdField_a_of_type_AndroidViewSurfaceView = new SurfaceView(this);
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().addCallback(this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewSurfaceView, 0, localLayoutParams);
  }
  
  private void e()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = new ScanSuccessView(this);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setShowProgress(false);
      if (this.jdField_a_of_type_Int == 1) {
        break label219;
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(alud.a(2131713908));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(azkz.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, localLayoutParams);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        break;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(aepi.a(40.0F, getResources()), aepi.a(40.0F, getResources()));
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = aepi.a(40.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845181);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131690648));
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
      return;
      label219:
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(alud.a(2131713910));
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = null;
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_b_of_type_AndroidWidgetImageView = null;
    }
  }
  
  public void a(OcrRecogResult paramOcrRecogResult, String paramString)
  {
    if (this.jdField_a_of_type_Int != 1) {
      return;
    }
    getIntent().putExtra("ocr_result", paramOcrRecogResult.ocrContent);
    getIntent().putExtra("ret_code", 0);
    setResult(-1, getIntent());
    finish();
    overridePendingTransition(0, 2130772001);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Avwv != null) && (this.jdField_c_of_type_Int == 0))
    {
      if ((this.jdField_a_of_type_Avwv.a()) && (this.jdField_a_of_type_Int != 1)) {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.a();
      }
      if (this.jdField_a_of_type_Int == 1) {
        azqs.b(null, "dc00898", "", "", "0X8008A1D", "0X8008A1D", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
    {
      String str = null;
      if (paramIntent != null) {
        str = paramIntent.getStringExtra("ocr_pic_path");
      }
      this.jdField_a_of_type_Avxb.d();
      if (!TextUtils.isEmpty(str)) {
        a(str, false, true);
      }
    }
    else
    {
      return;
    }
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 4))
    {
      a(false);
      return;
    }
    finish();
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_c_of_type_Int == 1) && ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 4)))
    {
      this.jdField_a_of_type_Avxb.a();
      a(false);
      f();
      return;
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.f = getIntent().getBooleanExtra("no_preview_model", false);
    if (!this.f) {
      setTheme(2131755154);
    }
    getWindow().addFlags(128);
    setContentView(2131561129);
    a();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376034));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377922));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372250));
    this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView = ((ScanOcrView)findViewById(2131376151));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364824);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377952);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368624));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368606));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377456));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView = ((MaskView)findViewById(2131370100));
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.tips))) {}
    String str;
    for (this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.tips;; this.jdField_c_of_type_JavaLangString = getResources().getString(2131699609))
    {
      str = getIntent().getStringExtra("ocr_pic_path");
      this.jdField_b_of_type_Int = getIntent().getIntExtra("ocr_from_where", -1);
      this.jdField_a_of_type_Avxb = new avxb(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Avxd, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Avxb.d();
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.ScanOcrActivity", 2, "onCreate imagePath:" + str + ",from:" + this.jdField_b_of_type_Int);
      }
      if (!isInMultiWindow()) {
        break;
      }
      QQToast.a(this, alud.a(2131713911), 0).a();
      finish();
      return true;
    }
    if (this.jdField_b_of_type_Int == 4)
    {
      this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("scanForResult", false);
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("src");
      this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("type");
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setIsDisplayRect(true);
        this.jdField_a_of_type_Int = 1;
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377923));
        this.jdField_c_of_type_JavaLangString = getResources().getString(2131699610);
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        paramBundle.topMargin = this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.a().bottom;
        this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(paramBundle);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719397);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        paramBundle = "";
        azqs.b(null, "dc00898", "", "", "0X8008A1C", "0X8008A1C", 0, 0, "", "", paramBundle, "");
      }
    }
    else
    {
      if ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 2) && (this.jdField_b_of_type_Int != 3)) {
        break label710;
      }
      if ((TextUtils.isEmpty(str)) || (!new File(str).exists())) {
        break label688;
      }
      a(str, false, false);
    }
    for (;;)
    {
      if (this.f)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      return true;
      paramBundle = this.jdField_a_of_type_JavaLangString;
      break;
      label688:
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699602, 0).a();
      finish();
      continue;
      label710:
      requestPermissions(new avxl(this), 1, new String[] { "android.permission.CAMERA" });
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Avxb != null) {
      this.jdField_a_of_type_Avxb.e();
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.ScanOcrActivity", 2, String.format("doOnNewIntent filePath=%s", new Object[] { paramIntent }));
    }
    if (!TextUtils.isEmpty(paramIntent)) {
      this.jdField_d_of_type_JavaLangString = paramIntent;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Avwv != null)
    {
      this.jdField_a_of_type_Avwv.c();
      this.jdField_a_of_type_Avwv.d();
    }
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      a(this.jdField_d_of_type_JavaLangString, false, false);
      this.jdField_d_of_type_JavaLangString = null;
      if (this.jdField_a_of_type_Int == 1) {
        azqs.b(null, "dc00898", "", "", "0X8008A1E", "0X8008A1E", 0, 0, "", "", "", "");
      }
    }
    this.jdField_a_of_type_Avxb.d();
    if (this.jdField_c_of_type_Int == 0) {
      if (this.jdField_a_of_type_AndroidViewSurfaceView == null) {
        d();
      }
    }
    label257:
    for (;;)
    {
      this.jdField_e_of_type_Boolean = false;
      return;
      if ((this.jdField_a_of_type_Avwv != null) && (this.g))
      {
        this.jdField_a_of_type_Avwv.a();
        continue;
        if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_c_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
        {
          if (this.f) {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          }
          for (;;)
          {
            if ((this.jdField_a_of_type_Avxr == null) || (!this.jdField_e_of_type_JavaLangString.equals(this.jdField_a_of_type_Avxr.jdField_a_of_type_JavaLangString))) {
              break label257;
            }
            a(this.jdField_a_of_type_Avxr.jdField_a_of_type_Int, this.jdField_a_of_type_Avxr.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult, this.jdField_a_of_type_Avxr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Avxr.jdField_a_of_type_Long);
            break;
            Object localObject = URLDrawable.URLDrawableOptions.obtain();
            localObject = URLDrawable.getDrawable(new File(this.jdField_e_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject);
            ((URLDrawable)localObject).downloadImediatly();
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
        }
      }
    }
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.g = true;
    a(true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368624: 
      doOnBackPressed();
      return;
    case 2131368606: 
      paramView = new Intent();
      paramView.setClass(this, NewPhotoListActivity.class);
      paramView.putExtra("enter_from", 49);
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ScanOcrActivity.class.getName());
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      paramView.putExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", true);
      startActivity(paramView);
      bdfa.anim(this, false, true);
      return;
    }
    c();
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    QLog.i("Q.ocr.ScanOcrActivity", 2, "onMultiWindowModeChanged" + paramBoolean);
    if (isInMultiWindow())
    {
      QQToast.a(this, alud.a(2131713909), 0).a();
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity
 * JD-Core Version:    0.7.0.1
 */