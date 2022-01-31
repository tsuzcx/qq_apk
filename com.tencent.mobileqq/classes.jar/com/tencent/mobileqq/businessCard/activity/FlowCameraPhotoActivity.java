package com.tencent.mobileqq.businessCard.activity;

import aboa;
import abob;
import aboc;
import abod;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.helpers.CameraHelper;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.businessCard.views.OCRSurfaceView;
import com.tencent.mobileqq.loginwelcome.HighLightMaskView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RectMaskView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class FlowCameraPhotoActivity
  extends BaseActivity
  implements SurfaceHolder.Callback, View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  public long a;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  Handler jdField_a_of_type_AndroidOsHandler;
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public BusinessCardManager a;
  public CardOCRInfo a;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new abod(this);
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  RectMaskView jdField_a_of_type_ComTencentMobileqqWidgetRectMaskView;
  public String a;
  boolean jdField_a_of_type_Boolean;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  boolean jdField_b_of_type_Boolean = true;
  Button jdField_c_of_type_AndroidWidgetButton;
  boolean jdField_c_of_type_Boolean;
  public boolean d = false;
  public boolean e = false;
  boolean f = false;
  
  public FlowCameraPhotoActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo = null;
  }
  
  private void a(Bundle paramBundle)
  {
    a(getIntent());
    this.e = getIntent().getBooleanExtra("extra_return_result", false);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager = ((BusinessCardManager)this.app.getManager(111));
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_FlowCameraPhotoActivity", 2, "doShowGuide");
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131369816);
    if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager != null) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(2)))
    {
      HighLightMaskView localHighLightMaskView = (HighLightMaskView)findViewById(2131369817);
      Rect localRect = new Rect();
      this.jdField_a_of_type_AndroidWidgetButton.getGlobalVisibleRect(localRect);
      localHighLightMaskView.setCircleSrc(localRect.left + this.jdField_a_of_type_AndroidWidgetButton.getWidth() / 2.0F, localRect.top + this.jdField_a_of_type_AndroidWidgetButton.getHeight() / 2.0F, 38.0F * DeviceInfoUtil.a());
      localRelativeLayout.setVisibility(0);
      localRelativeLayout.setOnClickListener(new aboa(this));
      return;
    }
    localRelativeLayout.setVisibility(8);
  }
  
  void a()
  {
    super.setContentView(2130970248);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131363420));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131369000);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131369007));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131368623));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131369815));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  void a(Intent paramIntent)
  {
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    boolean bool = paramIntent.getBooleanExtra("is_upload_photo", false);
    if (QLog.isColorLevel()) {
      QLog.i("BusinessCard_FlowCameraPhotoActivity", 2, "initData isUploadPhoto: " + bool);
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      if (bool)
      {
        this.jdField_a_of_type_JavaLangString = ((String)localArrayList.get(0));
        this.jdField_a_of_type_Int = 1;
      }
      return;
    }
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(File paramFile, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_FlowCameraPhotoActivity", 2, "enterPicturePreviewMode");
    }
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    if (findViewById(2131369812) == null) {
      ((ViewStub)findViewById(2131369811)).setVisibility(0);
    }
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = findViewById(2131369812);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370172));
    }
    try
    {
      paramFile = URLDrawable.getDrawable(paramFile, URLDrawable.URLDrawableOptions.obtain());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramFile);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetRectMaskView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetRectMaskView.setVisibility(8);
      }
      paramFile = (Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131370173);
      Button localButton = (Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131370174);
      paramFile.setVisibility(8);
      localButton.setVisibility(8);
      if ((paramFile.getParent() instanceof RelativeLayout)) {
        ((RelativeLayout)paramFile.getParent()).setVisibility(8);
      }
      if (paramBoolean) {
        CameraHelper.a().d();
      }
      if (!this.d) {
        f();
      }
      return;
    }
    catch (Exception paramFile)
    {
      for (;;)
      {
        paramFile.printStackTrace();
      }
    }
  }
  
  void b()
  {
    this.jdField_c_of_type_AndroidWidgetButton.setText(2131436095);
    this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(getString(2131436095));
    if (this.jdField_a_of_type_JavaLangString != null) {
      a(new File(this.jdField_a_of_type_JavaLangString), false);
    }
  }
  
  protected void c()
  {
    this.jdField_c_of_type_AndroidWidgetButton.setText(2131436096);
    this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(getString(2131436096));
    OCRSurfaceView localOCRSurfaceView = new OCRSurfaceView(this);
    localOCRSurfaceView.setZOrderOnTop(false);
    Object localObject = localOCRSurfaceView.getHolder();
    ((SurfaceHolder)localObject).setFormat(-2);
    ((SurfaceHolder)localObject).addCallback(this);
    ((SurfaceHolder)localObject).setType(3);
    localObject = getResources().getDisplayMetrics();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject).heightPixels);
    localLayoutParams.gravity = 51;
    this.jdField_a_of_type_ComTencentMobileqqWidgetRectMaskView = new RectMaskView(this);
    int i = (((DisplayMetrics)localObject).widthPixels - 20) * 600 / 1000;
    this.jdField_a_of_type_ComTencentMobileqqWidgetRectMaskView.setRect(10, (((DisplayMetrics)localObject).heightPixels - i) / 2, ((DisplayMetrics)localObject).widthPixels - 10, (((DisplayMetrics)localObject).heightPixels + i) / 2);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(10, (((DisplayMetrics)localObject).heightPixels - i) / 2, ((DisplayMetrics)localObject).widthPixels - 10, (i + ((DisplayMetrics)localObject).heightPixels) / 2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRectMaskView.setText(getString(2131437072), 17);
    CameraHelper.a().a(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localOCRSurfaceView, 0, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetRectMaskView);
    this.jdField_c_of_type_Boolean = true;
  }
  
  void d()
  {
    if (!isFinishing())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在识别");
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Int == 1)
      {
        setResult(0);
        if (!isFinishing()) {
          finish();
        }
        return;
      }
      g();
      return;
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    a();
    a(paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
    CameraHelper.a().a();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent);
  }
  
  @TargetApi(9)
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Int == 0)
    {
      if (!this.f) {
        c();
      }
      return;
    }
    b();
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Boolean))
    {
      h();
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard_FlowCameraPhotoActivity", 2, " request ocr : " + this.jdField_a_of_type_JavaLangString);
      }
      d();
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aboc(this), 15000L);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo = null;
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.c(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Int == 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_FlowCameraPhotoActivity", 2, "exitPicturePreviewMode");
    }
    CameraHelper.a().c();
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRectMaskView.setVisibility(0);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369007: 
      do
      {
        return;
      } while ((!Utils.a()) || (!this.jdField_c_of_type_Boolean));
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      paramView = new File(AppConstants.aJ + this.app.getCurrentAccountUin() + "/" + "business_card_photo/");
      if (!paramView.exists()) {
        paramView.mkdirs();
      }
      this.jdField_a_of_type_JavaLangString = BusinessCardUtils.a(this.app);
      paramView = new File(this.jdField_a_of_type_JavaLangString);
      CameraHelper.a().a(paramView, new abob(this), this.jdField_a_of_type_AndroidGraphicsRect);
      return;
    case 2131368623: 
      setResult(0);
      if (!isFinishing()) {
        finish();
      }
      ReportController.b(this.app, "CliOper", "", "", "0X80064E0", "0X80064E0", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      e();
      g();
      ReportController.b(this.app, "CliOper", "", "", "0X80064DF", "0X80064DF", 0, 0, "", "", "", "");
      return;
    }
    e();
    this.d = false;
    BusinessCardUtils.a(this.app, this);
    ReportController.b(this.app, "CliOper", "", "", "0X80064DE", "0X80064DE", 0, 0, "", "", "", "");
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_FlowCameraPhotoActivity", 2, "surfaceChanged :format=" + paramInt1 + ",width=" + paramInt2 + ",height=" + paramInt3);
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_FlowCameraPhotoActivity", 2, "surfaceCreated");
    }
    this.f = CameraHelper.a().a();
    if (!this.f)
    {
      if (!isFinishing())
      {
        QQToast.a(this, getString(2131433732), 1).a();
        if (this.jdField_a_of_type_Int == 0) {
          finish();
        }
      }
      return;
    }
    CameraHelper.a().b();
    CameraHelper.a().a(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder.removeCallback(this);
    CameraHelper.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_FlowCameraPhotoActivity", 2, "surfaceDestroyed");
    }
    this.f = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity
 * JD-Core Version:    0.7.0.1
 */