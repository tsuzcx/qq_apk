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
  private int A;
  private String B;
  private String C;
  private SurfaceHolder D;
  private OcrControl E;
  private OcrCamera F;
  private volatile boolean G;
  private volatile boolean H;
  private String I;
  private ScanSuccessView J;
  private long K;
  private boolean L = false;
  private ScanOcrActivity.OcrResultCache M;
  private boolean N = false;
  private boolean O = false;
  private View.OnTouchListener P = new ScanOcrActivity.2(this);
  private View.OnClickListener Q = new ScanOcrActivity.5(this);
  public boolean g = false;
  public String h;
  public String i;
  public MaskView j;
  public int k = 0;
  OcrCamera.CameraCallback l = new ScanOcrActivity.6(this);
  SurfaceHolder.Callback m = new ScanOcrActivity.7(this);
  OcrControl.OcrCallback n = new ScanOcrActivity.8(this);
  private ViewGroup o;
  private SurfaceView p;
  private TextView q;
  private ImageView r;
  private ScanOcrView s;
  private View t;
  private View u;
  private ImageView v;
  private TextView w;
  private TextView x;
  private ImageView y;
  private int z;
  
  private void a(int paramInt, OcrRecogResult paramOcrRecogResult, String paramString, long paramLong)
  {
    this.M = null;
    this.I = null;
    this.G = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dealOcrResult ocrResult: ");
      localStringBuilder.append(paramOcrRecogResult);
      QLog.i("Q.ocr.ScanOcrActivity", 2, localStringBuilder.toString());
    }
    if ((paramInt == 0) && (paramOcrRecogResult != null) && (!paramOcrRecogResult.isEmpty()) && ((this.k != 1) || ((!TextUtils.isEmpty(paramOcrRecogResult.ocrContent)) && (!TextUtils.isEmpty(paramOcrRecogResult.ocrContent.trim())))))
    {
      a(paramOcrRecogResult, paramString);
      ReportController.b(null, "dc00898", "", "", "0X80082CC", "0X80082CC", 0, 0, "", "", "", "");
      if (this.k == 1) {
        ReportController.b(null, "dc00898", "", "", "0X8008A1F", "0X8008A1F", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if (this.k == 1) {
        QQToast.makeText(BaseApplicationImpl.getContext(), 1, 2131897085, 0).show();
      } else if (paramInt == 1) {
        QQToast.makeText(BaseApplicationImpl.getContext(), 1, 2131897082, 0).show();
      } else if (paramInt == 0) {
        QQToast.makeText(BaseApplicationImpl.getContext(), 1, 2131897084, 0).show();
      } else {
        QQToast.makeText(BaseApplicationImpl.getContext(), 1, 2131897081, 0).show();
      }
      int i1 = this.z;
      if ((i1 != 0) && (i1 != 4)) {
        finish();
      } else {
        a(false);
      }
      ReportController.b(null, "dc00898", "", "", "0X80082CA", "0X80082CA", 0, 0, "", "", "", "");
      if (this.k == 1) {
        ReportController.b(null, "dc00898", "", "", "0X8008A20", "0X8008A20", 0, 0, "", "", "", "");
      }
    }
    g();
    ThreadManager.post(new ScanOcrActivity.9(this, paramInt), 5, null, false);
    if (paramLong > 0L)
    {
      paramInt = this.z;
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
      if (this.G)
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
        this.o.postDelayed(new ScanOcrActivity.4(this), 200L);
        this.G = true;
        this.I = paramString;
        this.H = paramBoolean;
        localObject = this.E;
        if (!paramBoolean) {
          bool1 = true;
        }
        ((OcrControl)localObject).a(paramString, bool1);
        if (this.z == 1) {
          ReportController.b(null, "dc00898", "", "", "0X80082C8", "0X80082C8", 0, 0, "", "", "", "");
        }
      }
      else
      {
        QQToast.makeText(BaseApplicationImpl.getContext(), 1, 2131897088, 0).show();
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
      ((StringBuilder)localObject).append(this.A);
      QLog.d("Q.ocr.ScanOcrActivity", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.A = 1;
    this.u.setVisibility(4);
    this.t.setVisibility(4);
    this.q.setVisibility(4);
    if (this.k != 1) {
      this.s.a();
    }
    if (paramBoolean1)
    {
      localObject = this.F;
      if (localObject != null) {
        ((OcrCamera)localObject).c();
      }
      this.K = System.currentTimeMillis();
      if (this.k != 1)
      {
        this.s.d();
        this.s.f();
        this.s.e();
        this.r.postDelayed(new ScanOcrActivity.3(this), 600L);
      }
      else
      {
        this.j.setModel(true);
      }
    }
    else
    {
      if (this.k != 1) {
        this.s.setVisibility(4);
      } else {
        this.j.setVisibility(4);
      }
      if (this.N)
      {
        this.r.setVisibility(4);
      }
      else
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        localObject = URLDrawable.getDrawable(new File(paramString), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).downloadImediatly();
        this.r.setVisibility(0);
        this.r.setImageDrawable((Drawable)localObject);
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
    this.G = false;
    this.A = 0;
    this.u.setVisibility(0);
    this.t.setVisibility(0);
    this.r.setVisibility(4);
    if (this.k != 1)
    {
      this.s.a();
    }
    else
    {
      this.j.setVisibility(0);
      this.j.setModel(false);
    }
    g();
    if (!paramBoolean) {
      if (this.p == null)
      {
        e();
      }
      else
      {
        OcrCamera localOcrCamera = this.F;
        if ((localOcrCamera != null) && (this.O))
        {
          localOcrCamera.a();
          this.E.e();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.ScanOcrActivity", 2, "enterScanModel");
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.ScanOcrActivity", 2, "initCameraView");
    }
    this.p = new SurfaceView(this);
    this.p.getHolder().addCallback(this.m);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.o.addView(this.p, 0, localLayoutParams);
  }
  
  private void f()
  {
    if (!this.G) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.J == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.J = new ScanSuccessView(this);
      this.J.setShowProgress(false);
      if (this.k != 1) {
        this.J.setScanText(HardCodeUtil.a(2131910989));
      } else {
        this.J.setScanText(HardCodeUtil.a(2131910991));
      }
      this.J.setBackgroundColor(2130706432);
      this.J.setScale(ScreenUtil.SCREEN_WIDTH);
      this.o.addView(this.J, localLayoutParams);
    }
    if (this.v == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(40.0F, getResources()), AIOUtils.b(40.0F, getResources()));
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = AIOUtils.b(40.0F, getResources());
      this.v = new ImageView(this);
      this.v.setImageResource(2130847216);
      this.v.setOnClickListener(this.Q);
      this.v.setContentDescription(getString(2131887648));
      this.o.addView(this.v, localLayoutParams);
    }
  }
  
  private void g()
  {
    Object localObject = this.J;
    if (localObject != null)
    {
      this.o.removeView((View)localObject);
      this.J = null;
    }
    localObject = this.v;
    if (localObject != null)
    {
      this.o.removeView((View)localObject);
      this.v = null;
    }
  }
  
  public void a(OcrRecogResult paramOcrRecogResult, String paramString)
  {
    if (this.k != 1) {
      return;
    }
    getIntent().putExtra("ocr_result", paramOcrRecogResult.ocrContent);
    getIntent().putExtra("ret_code", 0);
    setResult(-1, getIntent());
    finish();
    overridePendingTransition(0, 2130772018);
  }
  
  public void d()
  {
    OcrCamera localOcrCamera = this.F;
    if ((localOcrCamera != null) && (this.A == 0))
    {
      if ((localOcrCamera.h()) && (this.k != 1)) {
        this.s.a();
      }
      if (this.k == 1) {
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
      this.E.e();
      if (!TextUtils.isEmpty(str))
      {
        a(str, false, true);
        return;
      }
      paramInt1 = this.z;
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
    if (this.A == 1)
    {
      int i1 = this.z;
      if ((i1 == 0) || (i1 == 4))
      {
        this.E.a();
        a(false);
        g();
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
    this.N = getIntent().getBooleanExtra("no_preview_model", false);
    if (!this.N) {
      setTheme(2131952013);
    }
    getWindow().addFlags(128);
    setContentView(2131627614);
    b();
    this.o = ((ViewGroup)findViewById(2131445137));
    this.q = ((TextView)findViewById(2131447443));
    this.r = ((ImageView)findViewById(2131440616));
    this.s = ((ScanOcrView)findViewById(2131445289));
    this.t = findViewById(2131431386);
    this.u = findViewById(2131447479);
    this.w = ((TextView)findViewById(2131436180));
    this.x = ((TextView)findViewById(2131436162));
    this.y = ((ImageView)findViewById(2131446841));
    this.x.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.x.setOnTouchListener(this.P);
    this.y.setOnClickListener(this);
    this.y.setOnTouchListener(this.P);
    this.j = ((MaskView)findViewById(2131437989));
    if ((this.c != null) && (!TextUtils.isEmpty(this.c.tips))) {
      this.B = this.c.tips;
    } else {
      this.B = getResources().getString(2131897090);
    }
    String str = getIntent().getStringExtra("ocr_pic_path");
    this.z = getIntent().getIntExtra("ocr_from_where", -1);
    this.E = new OcrControl(this.d, this.n, this.z);
    this.E.e();
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate imagePath:");
      paramBundle.append(str);
      paramBundle.append(",from:");
      paramBundle.append(this.z);
      QLog.d("Q.ocr.ScanOcrActivity", 2, paramBundle.toString());
    }
    if (isInMultiWindow())
    {
      QQToast.makeText(this, HardCodeUtil.a(2131910992), 0).show();
      finish();
      return true;
    }
    if (this.z == 4)
    {
      this.g = getIntent().getBooleanExtra("scanForResult", false);
      this.h = getIntent().getStringExtra("src");
      this.i = getIntent().getStringExtra("type");
      if (this.g)
      {
        this.j.setIsDisplayRect(true);
        this.k = 1;
        this.q = ((TextView)findViewById(2131447444));
        this.B = getResources().getString(2131897091);
        paramBundle = (RelativeLayout.LayoutParams)this.q.getLayoutParams();
        paramBundle.topMargin = this.j.getPreviewRect().bottom;
        this.q.setLayoutParams(paramBundle);
        this.b.setText(2131915910);
      }
      if (TextUtils.isEmpty(this.h)) {
        paramBundle = "";
      } else {
        paramBundle = this.h;
      }
      ReportController.b(null, "dc00898", "", "", "0X8008A1C", "0X8008A1C", 0, 0, "", "", paramBundle, "");
    }
    int i1 = this.z;
    if ((i1 != 1) && (i1 != 2) && (i1 != 3))
    {
      requestPermissions(new ScanOcrActivity.1(this), 1, new String[] { "android.permission.CAMERA" });
    }
    else if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
    {
      a(str, false, false);
    }
    else
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), 1, 2131897083, 0).show();
      finish();
    }
    if (this.N)
    {
      this.o.setBackgroundColor(0);
      this.r.setVisibility(4);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    OcrControl localOcrControl = this.E;
    if (localOcrControl != null) {
      localOcrControl.f();
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
      this.C = paramIntent;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    OcrCamera localOcrCamera = this.F;
    if (localOcrCamera != null)
    {
      localOcrCamera.c();
      this.F.d();
    }
    this.L = true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (!TextUtils.isEmpty(this.C))
    {
      a(this.C, false, false);
      this.C = null;
      if (this.k == 1) {
        ReportController.b(null, "dc00898", "", "", "0X8008A1E", "0X8008A1E", 0, 0, "", "", "", "");
      }
    }
    this.E.e();
    Object localObject;
    if (this.A == 0)
    {
      if (this.p == null)
      {
        e();
      }
      else
      {
        localObject = this.F;
        if ((localObject != null) && (this.O)) {
          ((OcrCamera)localObject).a();
        }
      }
    }
    else if ((!TextUtils.isEmpty(this.I)) && (this.G) && (this.L))
    {
      if (this.N)
      {
        this.r.setVisibility(4);
      }
      else
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        localObject = URLDrawable.getDrawable(new File(this.I), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).downloadImediatly();
        this.r.setImageDrawable((Drawable)localObject);
        this.r.setVisibility(0);
      }
      localObject = this.M;
      if ((localObject != null) && (this.I.equals(((ScanOcrActivity.OcrResultCache)localObject).c))) {
        a(this.M.a, this.M.b, this.M.c, this.M.d);
      }
    }
    this.L = false;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.O = true;
    a(true);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131436162)
    {
      if (i1 != 2131436180)
      {
        if (i1 == 2131446841) {
          d();
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
      QQToast.makeText(this, HardCodeUtil.a(2131910990), 0).show();
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity
 * JD-Core Version:    0.7.0.1
 */