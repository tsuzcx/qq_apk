package com.tencent.mobileqq.ocr.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.ocr.OcrCamera;
import com.tencent.mobileqq.ocr.OcrCamera.CameraCallback;
import com.tencent.mobileqq.ocr.OcrControl;
import com.tencent.mobileqq.ocr.OcrControl.OcrCallback;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.mobileqq.ocr.view.ScanOcrView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import mqq.app.QQPermissionGrant;

public class ScanOcrActivity
  extends ScanBaseActivity
  implements View.OnClickListener
{
  public int a;
  private long jdField_a_of_type_Long;
  SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new ScanOcrActivity.7(this);
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ScanOcrActivity.5(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ScanOcrActivity.2(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ScanSuccessView jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView;
  OcrCamera.CameraCallback jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback = new ScanOcrActivity.6(this);
  private OcrCamera jdField_a_of_type_ComTencentMobileqqOcrOcrCamera;
  OcrControl.OcrCallback jdField_a_of_type_ComTencentMobileqqOcrOcrControl$OcrCallback = new ScanOcrActivity.8(this);
  private OcrControl jdField_a_of_type_ComTencentMobileqqOcrOcrControl;
  private ScanOcrActivity.OcrResultCache jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache;
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
  private boolean jdField_e_of_type_Boolean = false;
  private boolean f = false;
  private boolean g = false;
  
  public ScanOcrActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(int paramInt, OcrRecogResult paramOcrRecogResult, String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dealOcrResult ocrResult: ");
      localStringBuilder.append(paramOcrRecogResult);
      QLog.i("Q.ocr.ScanOcrActivity", 2, localStringBuilder.toString());
    }
    if ((paramInt == 0) && (paramOcrRecogResult != null) && (!paramOcrRecogResult.isEmpty()) && ((this.jdField_a_of_type_Int != 1) || ((!TextUtils.isEmpty(paramOcrRecogResult.ocrContent)) && (!TextUtils.isEmpty(paramOcrRecogResult.ocrContent.trim())))))
    {
      a(paramOcrRecogResult, paramString);
      ReportController.b(null, "dc00898", "", "", "0X80082CC", "0X80082CC", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Int == 1) {
        ReportController.b(null, "dc00898", "", "", "0X8008A1F", "0X8008A1F", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if (this.jdField_a_of_type_Int == 1) {
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699076, 0).a();
      } else if (paramInt == 1) {
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699073, 0).a();
      } else if (paramInt == 0) {
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699075, 0).a();
      } else {
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699072, 0).a();
      }
      int i = this.jdField_b_of_type_Int;
      if ((i != 0) && (i != 4)) {
        finish();
      } else {
        a(false);
      }
      ReportController.b(null, "dc00898", "", "", "0X80082CA", "0X80082CA", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Int == 1) {
        ReportController.b(null, "dc00898", "", "", "0X8008A20", "0X8008A20", 0, 0, "", "", "", "");
      }
    }
    f();
    ThreadManager.post(new ScanOcrActivity.9(this, paramInt), 5, null, false);
    if (paramLong > 0L)
    {
      paramInt = this.jdField_b_of_type_Int;
      if (paramInt == 1)
      {
        ReportController.b(null, "dc00898", "", "", "0X80082E5", "0X80082E5", 0, 0, String.valueOf(paramLong), "", "", "");
        return;
      }
      if (paramInt == 0) {
        ReportController.b(null, "dc00898", "", "", "0X80082E4", "0X80082E4", 0, 0, String.valueOf(paramLong), "", "", "");
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject;
      if (this.jdField_c_of_type_Boolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("recogPic is inRecog picPath:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(",isCrop:");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("Q.ocr.ScanOcrActivity", 1, ((StringBuilder)localObject).toString());
        return;
      }
      boolean bool2 = NetworkUtil.isNetSupport(this);
      boolean bool1 = false;
      if (bool2)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.postDelayed(new ScanOcrActivity.4(this), 200L);
        this.jdField_c_of_type_Boolean = true;
        this.jdField_e_of_type_JavaLangString = paramString;
        this.jdField_d_of_type_Boolean = paramBoolean;
        localObject = this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl;
        if (!paramBoolean) {
          bool1 = true;
        }
        ((OcrControl)localObject).a(paramString, bool1);
        if (this.jdField_b_of_type_Int == 1) {
          ReportController.b(null, "dc00898", "", "", "0X80082C8", "0X80082C8", 0, 0, "", "", "", "");
        }
      }
      else
      {
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699079, 0).a();
      }
      return;
    }
    finally {}
  }
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) && (!paramBoolean1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterPreviewModel picPath:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",isFromCamera:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",model:");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      QLog.d("Q.ocr.ScanOcrActivity", 1, ((StringBuilder)localObject).toString());
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera;
      if (localObject != null) {
        ((OcrCamera)localObject).c();
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Int != 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.c();
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.e();
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.d();
        this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new ScanOcrActivity.3(this), 600L);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setModel(true);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Int != 1) {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.setVisibility(4);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(4);
      }
      if (this.f)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      else
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        localObject = URLDrawable.getDrawable(new File(paramString), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).downloadImediatly();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      a(paramString, paramBoolean2);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterPreviewModel isFromCamera:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",isCrop:");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(",picPath:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.ocr.ScanOcrActivity", 2, ((StringBuilder)localObject).toString());
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
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setModel(false);
    }
    f();
    if (!paramBoolean) {
      if (this.jdField_a_of_type_AndroidViewSurfaceView == null)
      {
        d();
      }
      else
      {
        OcrCamera localOcrCamera = this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera;
        if ((localOcrCamera != null) && (this.g))
        {
          localOcrCamera.a();
          this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.d();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.ScanOcrActivity", 2, "enterScanModel");
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
      if (this.jdField_a_of_type_Int != 1) {
        this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(HardCodeUtil.a(2131713438));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(HardCodeUtil.a(2131713440));
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(ScreenUtil.SCREEN_WIDTH);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, localLayoutParams);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(40.0F, getResources()), AIOUtils.b(40.0F, getResources()));
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = AIOUtils.b(40.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845746);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131690728));
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
    }
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = null;
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView((View)localObject);
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
    overridePendingTransition(0, 2130772015);
  }
  
  public void c()
  {
    OcrCamera localOcrCamera = this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera;
    if ((localOcrCamera != null) && (this.jdField_c_of_type_Int == 0))
    {
      if ((localOcrCamera.a()) && (this.jdField_a_of_type_Int != 1)) {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.a();
      }
      if (this.jdField_a_of_type_Int == 1) {
        ReportController.b(null, "dc00898", "", "", "0X8008A1D", "0X8008A1D", 0, 0, "", "", "", "");
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
    {
      String str = null;
      if (paramIntent != null) {
        str = paramIntent.getStringExtra("ocr_pic_path");
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.d();
      if (!TextUtils.isEmpty(str))
      {
        a(str, false, true);
        return;
      }
      paramInt1 = this.jdField_b_of_type_Int;
      if ((paramInt1 != 0) && (paramInt1 != 4))
      {
        finish();
        return;
      }
      a(false);
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_c_of_type_Int == 1)
    {
      int i = this.jdField_b_of_type_Int;
      if ((i == 0) || (i == 4))
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.a();
        a(false);
        f();
        return;
      }
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.f = getIntent().getBooleanExtra("no_preview_model", false);
    if (!this.f) {
      setTheme(2131755320);
    }
    getWindow().addFlags(128);
    setContentView(2131561258);
    a();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376809));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378768));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373036));
    this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView = ((ScanOcrView)findViewById(2131376929));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365220);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131378798);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369187));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378319));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView = ((MaskView)findViewById(2131370711));
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.tips))) {
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.tips;
    } else {
      this.jdField_c_of_type_JavaLangString = getResources().getString(2131699081);
    }
    String str = getIntent().getStringExtra("ocr_pic_path");
    this.jdField_b_of_type_Int = getIntent().getIntExtra("ocr_from_where", -1);
    this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl = new OcrControl(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl$OcrCallback, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.d();
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate imagePath:");
      paramBundle.append(str);
      paramBundle.append(",from:");
      paramBundle.append(this.jdField_b_of_type_Int);
      QLog.d("Q.ocr.ScanOcrActivity", 2, paramBundle.toString());
    }
    if (isInMultiWindow())
    {
      QQToast.a(this, HardCodeUtil.a(2131713441), 0).a();
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
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378769));
        this.jdField_c_of_type_JavaLangString = getResources().getString(2131699082);
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        paramBundle.topMargin = this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.a().bottom;
        this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(paramBundle);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718412);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramBundle = "";
      } else {
        paramBundle = this.jdField_a_of_type_JavaLangString;
      }
      ReportController.b(null, "dc00898", "", "", "0X8008A1C", "0X8008A1C", 0, 0, "", "", paramBundle, "");
    }
    int i = this.jdField_b_of_type_Int;
    if ((i != 1) && (i != 2) && (i != 3))
    {
      requestPermissions(new ScanOcrActivity.1(this), 1, new String[] { "android.permission.CAMERA" });
    }
    else if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
    {
      a(str, false, false);
    }
    else
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699074, 0).a();
      finish();
    }
    if (this.f)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    OcrControl localOcrControl = this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl;
    if (localOcrControl != null) {
      localOcrControl.e();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
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
  
  protected void doOnPause()
  {
    super.doOnPause();
    OcrCamera localOcrCamera = this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera;
    if (localOcrCamera != null)
    {
      localOcrCamera.c();
      this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.d();
    }
    this.jdField_e_of_type_Boolean = true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      a(this.jdField_d_of_type_JavaLangString, false, false);
      this.jdField_d_of_type_JavaLangString = null;
      if (this.jdField_a_of_type_Int == 1) {
        ReportController.b(null, "dc00898", "", "", "0X8008A1E", "0X8008A1E", 0, 0, "", "", "", "");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.d();
    Object localObject;
    if (this.jdField_c_of_type_Int == 0)
    {
      if (this.jdField_a_of_type_AndroidViewSurfaceView == null)
      {
        d();
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera;
        if ((localObject != null) && (this.g)) {
          ((OcrCamera)localObject).a();
        }
      }
    }
    else if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_c_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
    {
      if (this.f)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      else
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        localObject = URLDrawable.getDrawable(new File(this.jdField_e_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).downloadImediatly();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache;
      if ((localObject != null) && (this.jdField_e_of_type_JavaLangString.equals(((ScanOcrActivity.OcrResultCache)localObject).jdField_a_of_type_JavaLangString))) {
        a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult, this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache.jdField_a_of_type_Long);
      }
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.g = true;
    a(true);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131369187)
    {
      if (i != 2131369202)
      {
        if (i == 2131378319) {
          c();
        }
      }
      else {
        doOnBackPressed();
      }
    }
    else
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this, NewPhotoListActivity.class);
      localIntent.putExtra("enter_from", 49);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ScanOcrActivity.class.getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      localIntent.putExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", true);
      startActivity(localIntent);
      AlbumUtil.anim(this, false, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMultiWindowModeChanged");
    localStringBuilder.append(paramBoolean);
    QLog.i("Q.ocr.ScanOcrActivity", 2, localStringBuilder.toString());
    if (isInMultiWindow())
    {
      QQToast.a(this, HardCodeUtil.a(2131713439), 0).a();
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity
 * JD-Core Version:    0.7.0.1
 */