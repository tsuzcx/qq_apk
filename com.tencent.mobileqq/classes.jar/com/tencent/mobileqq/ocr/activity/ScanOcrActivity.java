package com.tencent.mobileqq.ocr.activity;

import afow;
import afox;
import afoz;
import afpa;
import afpb;
import afpj;
import afpk;
import afpm;
import android.content.Context;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.ocr.OCRRecognitionResultActivity;
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
import java.io.File;

public class ScanOcrActivity
  extends ScanBaseActivity
  implements View.OnClickListener
{
  public int a;
  private long jdField_a_of_type_Long;
  SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new afpj(this);
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afpa(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new afow(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ScanSuccessView jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView;
  public OcrCamera.CameraCallback a;
  private OcrCamera jdField_a_of_type_ComTencentMobileqqOcrOcrCamera;
  OcrControl.OcrCallback jdField_a_of_type_ComTencentMobileqqOcrOcrControl$OcrCallback = new afpk(this);
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
  private boolean jdField_e_of_type_Boolean;
  
  public ScanOcrActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback = new afpb(this);
  }
  
  private void a(int paramInt, OcrRecogResult paramOcrRecogResult, String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.ocr.ScanOcrActivity", 2, "dealOcrResult ocrResult: " + paramOcrRecogResult);
    }
    if ((paramInt == 0) && (paramOcrRecogResult != null) && (!paramOcrRecogResult.isEmpty()) && ((this.jdField_a_of_type_Int != 1) || ((!TextUtils.isEmpty(paramOcrRecogResult.ocrContent)) && (!TextUtils.isEmpty(paramOcrRecogResult.ocrContent.trim())))))
    {
      a(paramOcrRecogResult, paramString);
      ReportController.b(null, "dc00898", "", "", "0X80082CC", "0X80082CC", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Int == 1) {
        ReportController.b(null, "dc00898", "", "", "0X8008A1F", "0X8008A1F", 0, 0, "", "", "", "");
      }
      f();
      ThreadManager.post(new afpm(this, paramInt), 5, null, false);
      if (paramLong > 0L)
      {
        if (this.jdField_b_of_type_Int != 1) {
          break label384;
        }
        ReportController.b(null, "dc00898", "", "", "0X80082E5", "0X80082E5", 0, 0, String.valueOf(paramLong), "", "", "");
      }
    }
    label238:
    label377:
    while (this.jdField_b_of_type_Int != 0)
    {
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439017, 0).a();
        if ((this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int != 4)) {
          break label377;
        }
        a(false);
      }
      for (;;)
      {
        ReportController.b(null, "dc00898", "", "", "0X80082CA", "0X80082CA", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_Int != 1) {
          break;
        }
        ReportController.b(null, "dc00898", "", "", "0X8008A20", "0X8008A20", 0, 0, "", "", "", "");
        break;
        if (paramInt == 1)
        {
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439019, 0).a();
          break label238;
        }
        if (paramInt == 0)
        {
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439016, 0).a();
          break label238;
        }
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439018, 0).a();
        break label238;
        finish();
      }
    }
    label384:
    ReportController.b(null, "dc00898", "", "", "0X80082E4", "0X80082E4", 0, 0, String.valueOf(paramLong), "", "", "");
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (!NetworkUtil.d(paramContext)) {
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439015, 0).a();
    }
    do
    {
      return;
      Intent localIntent = new Intent(paramContext, ScanOcrActivity.class);
      localIntent.putExtra("ocr_from_where", paramInt);
      localIntent.putExtra("ocr_pic_path", paramString);
      localIntent.addFlags(67108864);
      paramContext.startActivity(localIntent);
    } while (paramInt != 1);
    ReportController.b(null, "dc00898", "", "", "0X80082C7", "0X80082C7", 0, 0, "", "", "", "");
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_c_of_type_Boolean)
        {
          QLog.d("Q.ocr.ScanOcrActivity", 1, "recogPic is inRecog picPath:" + paramString + ",isCrop:" + paramBoolean);
          return;
        }
        if (NetworkUtil.d(this))
        {
          this.jdField_a_of_type_AndroidViewViewGroup.postDelayed(new afoz(this), 200L);
          this.jdField_c_of_type_Boolean = true;
          this.jdField_e_of_type_JavaLangString = paramString;
          this.jdField_d_of_type_Boolean = paramBoolean;
          this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.a(paramString, paramBoolean);
          if (this.jdField_b_of_type_Int == 1) {
            ReportController.b(null, "dc00898", "", "", "0X80082C8", "0X80082C8", 0, 0, "", "", "", "");
          }
        }
        else
        {
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439015, 0).a();
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
      if (this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera != null) {
        this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.c();
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Int != 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.c();
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.e();
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.d();
        this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new afox(this), 600L);
      }
      label178:
      while (QLog.isColorLevel())
      {
        QLog.d("Q.ocr.ScanOcrActivity", 2, "enterPreviewModel isFromCamera:" + paramBoolean1 + ",isCrop:" + paramBoolean2 + ",picPath:" + paramString);
        return;
        this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setModel(true);
      }
    }
    if (this.jdField_a_of_type_Int != 1) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.setVisibility(4);
    }
    for (;;)
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(new File(paramString), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).downloadImediatly();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      a(paramString, paramBoolean2);
      break label178;
      break;
      this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(4);
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
      if (this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.a();
        this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.d();
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
        break label216;
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText("正在提取中...");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(ScreenUtil.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, localLayoutParams);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        break;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(40.0F, getResources()), AIOUtils.a(40.0F, getResources()));
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = AIOUtils.a(40.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842803);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131432998));
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
      return;
      label216:
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText("正在提取密码中...");
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
    if (this.jdField_a_of_type_Int != 1)
    {
      Intent localIntent = new Intent(this, OCRRecognitionResultActivity.class);
      localIntent.putExtra("param_recog_ret", paramOcrRecogResult);
      localIntent.putExtra("param_recog_pic_path", paramString);
      localIntent.addFlags(67108864);
      startActivityForResult(localIntent, 0);
      overridePendingTransition(2131034134, 0);
      return;
    }
    getIntent().putExtra("ocr_result", paramOcrRecogResult.ocrContent);
    getIntent().putExtra("ret_code", 0);
    setResult(-1, getIntent());
    finish();
    overridePendingTransition(0, 2131034135);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera != null) && (this.jdField_c_of_type_Int == 0))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.a()) && (this.jdField_a_of_type_Int != 1)) {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.a();
      }
      if (this.jdField_a_of_type_Int == 1) {
        ReportController.b(null, "dc00898", "", "", "0X8008A1D", "0X8008A1D", 0, 0, "", "", "", "");
      }
    }
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
      this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.a();
      a(false);
      f();
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().addFlags(128);
    setContentView(2130970461);
    a();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131362822));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369716));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370764));
    this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView = ((ScanOcrView)findViewById(2131370765));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370762);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370760);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363227));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370761));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370763));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView = ((MaskView)findViewById(2131365541));
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.tips))) {}
    String str;
    for (this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.tips;; this.jdField_c_of_type_JavaLangString = getResources().getString(2131439010))
    {
      str = getIntent().getStringExtra("ocr_pic_path");
      this.jdField_b_of_type_Int = getIntent().getIntExtra("ocr_from_where", -1);
      this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl = new OcrControl(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl$OcrCallback, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.d();
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.ScanOcrActivity", 2, "onCreate imagePath:" + str + ",from:" + this.jdField_b_of_type_Int);
      }
      if (!isInMultiWindow()) {
        break;
      }
      QQToast.a(this, "该功能无法在分屏模式下使用。", 0).a();
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
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370766));
        this.jdField_c_of_type_JavaLangString = getResources().getString(2131439011);
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        paramBundle.topMargin = this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.a().bottom;
        this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(paramBundle);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131429905);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        paramBundle = "";
        ReportController.b(null, "dc00898", "", "", "0X8008A1C", "0X8008A1C", 0, 0, "", "", paramBundle, "");
      }
    }
    else
    {
      if ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 2) && (this.jdField_b_of_type_Int != 3)) {
        break label653;
      }
      if ((TextUtils.isEmpty(str)) || (!new File(str).exists())) {
        break label631;
      }
      a(str, false, false);
    }
    for (;;)
    {
      return true;
      paramBundle = this.jdField_a_of_type_JavaLangString;
      break;
      label631:
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439020, 0).a();
      finish();
      continue;
      label653:
      a(true);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.e();
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
    if (this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.c();
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
    if (this.jdField_c_of_type_Int == 0) {
      if (this.jdField_a_of_type_AndroidViewSurfaceView == null) {
        d();
      }
    }
    for (;;)
    {
      this.jdField_e_of_type_Boolean = false;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera.a();
        continue;
        if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_c_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
        {
          Object localObject = URLDrawable.URLDrawableOptions.obtain();
          localObject = URLDrawable.getDrawable(new File(this.jdField_e_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject);
          ((URLDrawable)localObject).downloadImediatly();
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache != null) && (this.jdField_e_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache.jdField_a_of_type_JavaLangString))) {
            a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult, this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache.jdField_a_of_type_Long);
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363227: 
      doOnBackPressed();
      return;
    case 2131370761: 
      paramView = new Intent();
      paramView.setClass(this, PhotoListActivity.class);
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ScanOcrActivity.class.getName());
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      paramView.putExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", true);
      startActivity(paramView);
      AlbumUtil.a(this, false, true);
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
      QQToast.a(this, "该功能无法在分屏模式下使用。", 0).a();
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity
 * JD-Core Version:    0.7.0.1
 */