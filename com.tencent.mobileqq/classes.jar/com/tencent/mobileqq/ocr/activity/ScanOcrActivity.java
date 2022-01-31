package com.tencent.mobileqq.ocr.activity;

import actj;
import ajya;
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
import aubi;
import aubn;
import aubo;
import aubq;
import auby;
import aubz;
import auca;
import aucb;
import aucc;
import aucd;
import auce;
import axlk;
import axqy;
import bbbx;
import bbfj;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.mobileqq.ocr.view.ScanOcrView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.QQPermissionGrant;

public class ScanOcrActivity
  extends ScanBaseActivity
  implements View.OnClickListener
{
  public int a;
  private long jdField_a_of_type_Long;
  SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new aucc(this);
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new auca(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aubz(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private aubi jdField_a_of_type_Aubi;
  public aubn a;
  private aubo jdField_a_of_type_Aubo;
  aubq jdField_a_of_type_Aubq = new aucd(this);
  private auce jdField_a_of_type_Auce;
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
    this.jdField_a_of_type_Aubn = new aucb(this);
  }
  
  private void a(int paramInt, OcrRecogResult paramOcrRecogResult, String paramString, long paramLong)
  {
    this.jdField_a_of_type_Auce = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.ocr.ScanOcrActivity", 2, "dealOcrResult ocrResult: " + paramOcrRecogResult);
    }
    if ((paramInt == 0) && (paramOcrRecogResult != null) && (!paramOcrRecogResult.isEmpty()) && ((this.jdField_a_of_type_Int != 1) || ((!TextUtils.isEmpty(paramOcrRecogResult.ocrContent)) && (!TextUtils.isEmpty(paramOcrRecogResult.ocrContent.trim())))))
    {
      a(paramOcrRecogResult, paramString);
      axqy.b(null, "dc00898", "", "", "0X80082CC", "0X80082CC", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Int == 1) {
        axqy.b(null, "dc00898", "", "", "0X8008A1F", "0X8008A1F", 0, 0, "", "", "", "");
      }
      f();
      ThreadManager.post(new ScanOcrActivity.9(this, paramInt), 5, null, false);
      if (paramLong > 0L)
      {
        if (this.jdField_b_of_type_Int != 1) {
          break label384;
        }
        axqy.b(null, "dc00898", "", "", "0X80082E5", "0X80082E5", 0, 0, String.valueOf(paramLong), "", "", "");
      }
    }
    label238:
    label377:
    while (this.jdField_b_of_type_Int != 0)
    {
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        bcql.a(BaseApplicationImpl.getContext(), 1, 2131699246, 0).a();
        if ((this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int != 4)) {
          break label377;
        }
        a(false);
      }
      for (;;)
      {
        axqy.b(null, "dc00898", "", "", "0X80082CA", "0X80082CA", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_Int != 1) {
          break;
        }
        axqy.b(null, "dc00898", "", "", "0X8008A20", "0X8008A20", 0, 0, "", "", "", "");
        break;
        if (paramInt == 1)
        {
          bcql.a(BaseApplicationImpl.getContext(), 1, 2131699243, 0).a();
          break label238;
        }
        if (paramInt == 0)
        {
          bcql.a(BaseApplicationImpl.getContext(), 1, 2131699245, 0).a();
          break label238;
        }
        bcql.a(BaseApplicationImpl.getContext(), 1, 2131699241, 0).a();
        break label238;
        finish();
      }
    }
    label384:
    axqy.b(null, "dc00898", "", "", "0X80082E4", "0X80082E4", 0, 0, String.valueOf(paramLong), "", "", "");
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
        if (bbfj.d(this))
        {
          this.jdField_a_of_type_AndroidViewViewGroup.postDelayed(new ScanOcrActivity.4(this), 200L);
          this.jdField_c_of_type_Boolean = true;
          this.jdField_e_of_type_JavaLangString = paramString;
          this.jdField_d_of_type_Boolean = paramBoolean;
          aubo localaubo = this.jdField_a_of_type_Aubo;
          if (!paramBoolean) {
            bool = true;
          }
          localaubo.a(paramString, bool);
          if (this.jdField_b_of_type_Int == 1) {
            axqy.b(null, "dc00898", "", "", "0X80082C8", "0X80082C8", 0, 0, "", "", "", "");
          }
        }
        else
        {
          bcql.a(BaseApplicationImpl.getContext(), 1, 2131699249, 0).a();
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
      if (this.jdField_a_of_type_Aubi != null) {
        this.jdField_a_of_type_Aubi.c();
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
      if ((this.jdField_a_of_type_Aubi != null) && (this.g))
      {
        this.jdField_a_of_type_Aubi.a();
        this.jdField_a_of_type_Aubo.d();
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
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(ajya.a(2131713524));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(axlk.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, localLayoutParams);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        break;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(actj.a(40.0F, getResources()), actj.a(40.0F, getResources()));
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = actj.a(40.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844745);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131690596));
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
      return;
      label219:
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(ajya.a(2131713526));
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
    if ((this.jdField_a_of_type_Aubi != null) && (this.jdField_c_of_type_Int == 0))
    {
      if ((this.jdField_a_of_type_Aubi.a()) && (this.jdField_a_of_type_Int != 1)) {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.a();
      }
      if (this.jdField_a_of_type_Int == 1) {
        axqy.b(null, "dc00898", "", "", "0X8008A1D", "0X8008A1D", 0, 0, "", "", "", "");
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
      this.jdField_a_of_type_Aubo.d();
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
      this.jdField_a_of_type_Aubo.a();
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
      setTheme(2131755150);
    }
    getWindow().addFlags(128);
    setContentView(2131560928);
    a();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131375493));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377334));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371911));
    this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView = ((ScanOcrView)findViewById(2131375607));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364744);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377365);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368429));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368412));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376888));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView = ((MaskView)findViewById(2131369817));
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.tips))) {}
    String str;
    for (this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.tips;; this.jdField_c_of_type_JavaLangString = getResources().getString(2131699251))
    {
      str = getIntent().getStringExtra("ocr_pic_path");
      this.jdField_b_of_type_Int = getIntent().getIntExtra("ocr_from_where", -1);
      this.jdField_a_of_type_Aubo = new aubo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Aubq, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Aubo.d();
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.ScanOcrActivity", 2, "onCreate imagePath:" + str + ",from:" + this.jdField_b_of_type_Int);
      }
      if (!isInMultiWindow()) {
        break;
      }
      bcql.a(this, ajya.a(2131713527), 0).a();
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
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377335));
        this.jdField_c_of_type_JavaLangString = getResources().getString(2131699252);
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        paramBundle.topMargin = this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.a().bottom;
        this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(paramBundle);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718909);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        paramBundle = "";
        axqy.b(null, "dc00898", "", "", "0X8008A1C", "0X8008A1C", 0, 0, "", "", paramBundle, "");
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
      bcql.a(BaseApplicationImpl.getContext(), 1, 2131699244, 0).a();
      finish();
      continue;
      label710:
      requestPermissions(new auby(this), 1, new String[] { "android.permission.CAMERA" });
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Aubo != null) {
      this.jdField_a_of_type_Aubo.e();
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
    if (this.jdField_a_of_type_Aubi != null)
    {
      this.jdField_a_of_type_Aubi.c();
      this.jdField_a_of_type_Aubi.d();
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
        axqy.b(null, "dc00898", "", "", "0X8008A1E", "0X8008A1E", 0, 0, "", "", "", "");
      }
    }
    this.jdField_a_of_type_Aubo.d();
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
      if ((this.jdField_a_of_type_Aubi != null) && (this.g))
      {
        this.jdField_a_of_type_Aubi.a();
        continue;
        if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_c_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
        {
          if (this.f) {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          }
          for (;;)
          {
            if ((this.jdField_a_of_type_Auce == null) || (!this.jdField_e_of_type_JavaLangString.equals(this.jdField_a_of_type_Auce.jdField_a_of_type_JavaLangString))) {
              break label257;
            }
            a(this.jdField_a_of_type_Auce.jdField_a_of_type_Int, this.jdField_a_of_type_Auce.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult, this.jdField_a_of_type_Auce.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Auce.jdField_a_of_type_Long);
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
    case 2131368429: 
      doOnBackPressed();
      return;
    case 2131368412: 
      paramView = new Intent();
      paramView.setClass(this, PhotoListActivity.class);
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ScanOcrActivity.class.getName());
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      paramView.putExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", true);
      startActivity(paramView);
      bbbx.a(this, false, true);
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
      bcql.a(this, ajya.a(2131713525), 0).a();
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity
 * JD-Core Version:    0.7.0.1
 */