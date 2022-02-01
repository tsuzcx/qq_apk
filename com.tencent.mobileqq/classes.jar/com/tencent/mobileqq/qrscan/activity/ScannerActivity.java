package com.tencent.mobileqq.qrscan.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.nearby.api.INearbyFakeActivityUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qrscan.IQRScanResultProcessor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.QRResultHandler;
import com.tencent.mobileqq.qrscan.QrImageScan;
import com.tencent.mobileqq.qrscan.QrImageScan.FileDecodeListener;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.qrscan.api.IQRScanMainProcService;
import com.tencent.mobileqq.qrscan.inject.QRScanProcessorFactory;
import com.tencent.mobileqq.qrscan.ipc.PreCallUpToolProc;
import com.tencent.mobileqq.qrscan.utils.QRUtils;
import com.tencent.mobileqq.qrscan.utils.Util;
import com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView;
import com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.ImageData;
import com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.MultiSelectListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@RoutePage(desc="扫一扫识别中转页", path="/qrscan/scanner")
public class ScannerActivity
  extends QBaseActivity
{
  public static final int MSG_SHOW_PROGRESS = 1;
  protected static final String TAG = "IQRScanConst_ScannerActivity";
  public static boolean mFirstEnterAR = true;
  AppRuntime app;
  private boolean isFirstCreate = true;
  private long mClickTime;
  private QrImageScan.FileDecodeListener mFileDecodeListener = new ScannerActivity.1(this);
  private OnQRHandleResultCallback mHandleResultCallback = new ScannerActivity.2(this);
  private boolean mHasARBack = false;
  private boolean mHasGetResult = false;
  public boolean mHasStartedAR = false;
  private QQProgressDialog mLoadingProgress;
  private ScannerMultiResultSelectView.MultiSelectListener mMultiSelectListener = new ScannerActivity.5(this);
  private PreCallUpToolProc mPreCallUpToolProc;
  private boolean mProgressShowing;
  private QrImageScan mQrImageScan;
  private ScannerMultiResultSelectView mScannerMultiResultSelectView;
  public ScannerParams mScannerParams;
  private boolean mToolProcExist;
  private Handler.Callback mUiCallBack = new ScannerActivity.4(this);
  private Handler mUiHandler;
  private String photoPathForMd5 = null;
  private View progressBar;
  List<IQRScanResultProcessor> qrResultProcessors = new ArrayList();
  private long start_time = -1L;
  
  private JSONObject buildQRReportParams()
  {
    Object localObject4 = getIntent();
    Object localObject3 = this.photoPathForMd5;
    Object localObject2 = null;
    if ((localObject4 == null) && (TextUtils.isEmpty((CharSequence)localObject3))) {
      return null;
    }
    Object localObject1 = localObject2;
    if (localObject4 != null)
    {
      localObject1 = localObject2;
      if (((Intent)localObject4).hasExtra("report_params"))
      {
        localObject4 = ((Intent)localObject4).getStringExtra("report_params");
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject1 = new JSONObject((String)localObject4);
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new JSONObject();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((JSONObject)localObject2).put("type", 9);
      } else {
        ((JSONObject)localObject2).put("type", 8);
      }
    }
    if ((TextUtils.isEmpty(((JSONObject)localObject2).optString("md5"))) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (new File((String)localObject3).exists()))
    {
      long l = System.currentTimeMillis();
      localObject1 = Util.a((String)localObject3);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((JSONObject)localObject2).put("md5", ((String)localObject1).toUpperCase());
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("buildQRReportParams md5:");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(" cost:");
        ((StringBuilder)localObject3).append(System.currentTimeMillis() - l);
        QLog.d("IQRScanConst_ScannerActivity", 2, ((StringBuilder)localObject3).toString());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("buildQRReportParams params:");
      ((StringBuilder)localObject1).append(((JSONObject)localObject2).toString());
      QLog.d("IQRScanConst_ScannerActivity", 2, ((StringBuilder)localObject1).toString());
    }
    return localObject2;
  }
  
  private void destroyQRScanResultProcessors()
  {
    Iterator localIterator = this.qrResultProcessors.iterator();
    while (localIterator.hasNext()) {
      ((IQRScanResultProcessor)localIterator.next()).c();
    }
    this.qrResultProcessors.clear();
  }
  
  private void handleActivityResultDefault(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 2)
    {
      if (paramInt1 != 3) {
        if (paramInt1 != 10)
        {
          if (this.mHasGetResult) {
            finish();
          }
        }
        else
        {
          this.mHasARBack = true;
          switch (paramInt2)
          {
          default: 
            if (QLog.isColorLevel()) {
              QLog.d("IQRScanConst_ScannerActivity", 2, "doOnActivityResult default finish.");
            }
            break;
          case 13: 
            this.photoPathForMd5 = null;
            if (paramIntent.hasExtra("filePath")) {
              this.photoPathForMd5 = paramIntent.getStringExtra("filePath");
            }
            this.mScannerParams.d = this.photoPathForMd5;
            paramInt1 = paramIntent.getIntExtra("detectType", 1);
            String str = paramIntent.getStringExtra("scannerResult");
            paramIntent = paramIntent.getStringExtra("scannerType");
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("doOnActivityResult  scannerResult:");
              localStringBuilder.append(str);
              localStringBuilder.append(" scannerType：");
              localStringBuilder.append(paramIntent);
              localStringBuilder.append(" photoPathForMd5:");
              localStringBuilder.append(this.photoPathForMd5);
              QLog.d("IQRScanConst_ScannerActivity", 2, localStringBuilder.toString());
            }
            if (paramInt1 == 2)
            {
              finish();
              return;
            }
            handleScannerResult(paramInt1, paramIntent, str, 3);
            return;
          case 12: 
            finish();
            overridePendingTransition(0, 0);
            return;
          case 11: 
            finish();
            return;
          }
          finish();
        }
      }
    }
    else {
      finish();
    }
  }
  
  private void handleDecodeFile(String paramString, int paramInt)
  {
    if (this.mQrImageScan == null) {
      this.mQrImageScan = new QrImageScan(this, this.mFileDecodeListener);
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = 3;
    }
    this.mScannerParams.d = paramString;
    this.photoPathForMd5 = paramString;
    this.mQrImageScan.a(paramString, i);
  }
  
  private boolean handlePreScanResult()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlePreResult detectType:");
      ((StringBuilder)localObject).append(this.mScannerParams.h);
      ((StringBuilder)localObject).append(" preResult:");
      ((StringBuilder)localObject).append(this.mScannerParams.i);
      ((StringBuilder)localObject).append(" preScanResult:");
      ((StringBuilder)localObject).append(this.mScannerParams.j);
      QLog.d("IQRScanConst_ScannerActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.mScannerParams.j != null) && (this.mScannerParams.j.f()))
    {
      handleScannerResult(this.mScannerParams.j, this.mScannerParams.h);
      return true;
    }
    if (!TextUtils.isEmpty(this.mScannerParams.i))
    {
      localObject = null;
      try
      {
        JSONObject localJSONObject = new JSONObject(this.mScannerParams.i);
        localObject = localJSONObject;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      int k = this.mScannerParams.h;
      int i;
      if ((QRUtils.a(k)) && (localObject != null)) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if ((QRUtils.b(k)) && (localObject != null)) {
        j = 1;
      } else {
        j = 0;
      }
      if (i != 0)
      {
        handleScannerResult(1, ((JSONObject)localObject).optString("scannerType"), ((JSONObject)localObject).optString("scannerResult"), k);
        return true;
      }
      if (j != 0)
      {
        String str = ((JSONObject)localObject).optString("strMini");
        handleScannerResult(2, ((JSONObject)localObject).optString("type"), str, k);
        return true;
      }
    }
    return false;
  }
  
  private void handleScannerResult(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.mHasGetResult = true;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleScannerResult scannerResult:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("  scannerType:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" resultType:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" reqType:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("IQRScanConst_ScannerActivity", 1, ((StringBuilder)localObject).toString());
    }
    String str = paramString2.trim();
    if (this.mScannerParams.a)
    {
      Util.a(this.app);
      setResult(-1, getIntent().putExtra("scanResult", str));
      finish();
      return;
    }
    if ((paramInt1 & 0x1) == 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 2;
    }
    paramString2 = null;
    Iterator localIterator = this.qrResultProcessors.iterator();
    while (localIterator.hasNext())
    {
      localObject = (IQRScanResultProcessor)localIterator.next();
      if (((IQRScanResultProcessor)localObject).a(paramInt1, str, paramString1, this.mScannerParams))
      {
        bool2 = ((IQRScanResultProcessor)localObject).b(str, paramString1, this.mScannerParams);
        paramString1 = (String)localObject;
        bool1 = true;
        break label252;
      }
    }
    boolean bool1 = false;
    boolean bool2 = false;
    paramString1 = paramString2;
    label252:
    if (paramString1 == null) {
      paramString1 = "null";
    } else {
      paramString1 = paramString1.a();
    }
    QLog.d("IQRScanConst_ScannerActivity", 1, String.format("handleScannerResult intercepted=%b processor=%s handle=%b", new Object[] { Boolean.valueOf(bool1), paramString1, Boolean.valueOf(bool2) }));
    if (!bool1)
    {
      QRResultHandler.a(this.app, this, str);
      finish();
    }
  }
  
  private void handleScannerResult(ScannerResult paramScannerResult, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleScannerResult requestType:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" scannerResult:");
      ((StringBuilder)localObject).append(paramScannerResult);
      QLog.d("IQRScanConst_ScannerActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramScannerResult == null) {
      return;
    }
    if (paramScannerResult.a())
    {
      showMultiResultSelectPage(paramScannerResult, paramInt);
      return;
    }
    if (paramScannerResult.h())
    {
      paramScannerResult = paramScannerResult.b();
      if (paramScannerResult != null) {
        handleScannerResult(1, ((StringBuilder)paramScannerResult.second).toString(), ((StringBuilder)paramScannerResult.first).toString(), paramInt);
      }
    }
    else if (paramScannerResult.g())
    {
      localObject = paramScannerResult.c();
      handleScannerResult(2, paramScannerResult.d(), (String)localObject, paramInt);
    }
  }
  
  private void initQRScanResultProcessors()
  {
    if (this.qrResultProcessors.isEmpty())
    {
      List localList = new QRScanProcessorFactory().a(this.app, this.mHandleResultCallback);
      this.qrResultProcessors.addAll(localList);
    }
  }
  
  private void initQrData()
  {
    this.mScannerParams = new ScannerParams();
    Object localObject = getIntent();
    this.mScannerParams.b = ((Intent)localObject).getStringExtra("from");
    if ("addcontacts".equals(this.mScannerParams.b))
    {
      StatisticCollector.getInstance(getApplicationContext()).reportButtonClick(this.app, "", "addfriend_QR", 1);
    }
    else if ("ImagePreviewActivity".equals(this.mScannerParams.b))
    {
      StatisticCollector.getInstance(getApplicationContext()).reportButtonClick(this.app, "", "bigpicture_QR", 1);
    }
    else if ("Conversation".equals(this.mScannerParams.b))
    {
      this.mScannerParams.f = true;
      StatisticCollector.getInstance(getApplicationContext()).reportButtonClick(this.app, "", "bulb_QR", 1);
    }
    else if (TextUtils.isEmpty(this.mScannerParams.b))
    {
      StatisticCollector.getInstance(getApplicationContext()).reportButtonClick(this.app, "", "find_QR", 1);
    }
    else if ("publicAccountNew".equals(this.mScannerParams.b))
    {
      ((Intent)localObject).putExtra("scanForResult", true);
    }
    else if ("QRDisplayActivity".equals(this.mScannerParams.b))
    {
      this.mScannerParams.f = true;
    }
    this.mScannerParams.e = ((Intent)localObject).getBooleanExtra("fromPicQRDecode", false);
    this.mScannerParams.h = ((Intent)localObject).getIntExtra("detectType", 3);
    this.mScannerParams.i = ((Intent)localObject).getStringExtra("preResult");
    this.mScannerParams.j = ((ScannerResult)((Intent)localObject).getParcelableExtra("preScanResult"));
    this.mScannerParams.g = super.getPackageManager().hasSystemFeature("android.hardware.camera");
    this.mScannerParams.c = ((Intent)localObject).getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    ScannerParams localScannerParams = this.mScannerParams;
    localScannerParams.d = localScannerParams.c;
    this.mScannerParams.a = ((Intent)localObject).getBooleanExtra("scanForResult", false);
    this.progressBar = findViewById(2131445292);
    ViewCompat.setImportantForAccessibility(this.progressBar, 2);
    this.start_time = ((Intent)localObject).getLongExtra("start_time", -1L);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mScannerParams: ");
    ((StringBuilder)localObject).append(this.mScannerParams.toString());
    QLog.i("IQRScanConst_ScannerActivity", 1, ((StringBuilder)localObject).toString());
  }
  
  private void showMultiResultSelectPage(ScannerResult paramScannerResult, int paramInt)
  {
    if (this.mScannerMultiResultSelectView == null)
    {
      this.mScannerMultiResultSelectView = new ScannerMultiResultSelectView(this);
      this.mScannerMultiResultSelectView.setMultiSelectListener(this.mMultiSelectListener);
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131445294);
    ScannerMultiResultSelectView.ImageData localImageData = new ScannerMultiResultSelectView.ImageData();
    localImageData.d = this.mScannerParams.d;
    this.mScannerMultiResultSelectView.a(localRelativeLayout, paramScannerResult, paramInt, localImageData, 2);
    Util.a(this.app);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doLaunchAr()
  {
    QLog.d("IQRScanConst_ScannerActivity", 2, String.format("doLaunchAr", new Object[0]));
    Object localObject = this.mPreCallUpToolProc;
    if (localObject != null)
    {
      ((PreCallUpToolProc)localObject).a();
      this.mPreCallUpToolProc = null;
    }
    localObject = (IWebProcessManagerService)this.app.getRuntimeService(IWebProcessManagerService.class, "");
    if (localObject != null) {
      ((IWebProcessManagerService)localObject).startWebProcess(-1, null);
    }
    localObject = new Intent(this, WebProcessReceiver.class);
    ((Intent)localObject).setAction("action_download_tbs");
    sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    ((IQRScanAbilityApi)QRoute.api(IQRScanAbilityApi.class)).launchAR(this, this.app, this.mScannerParams.b, this.mClickTime, this.mToolProcExist, mFirstEnterAR, this.start_time);
    mFirstEnterAR = false;
    this.mHasStartedAR = true;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnActivityResult requestCode:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", resultCode:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("IQRScanConst_ScannerActivity", 2, ((StringBuilder)localObject).toString());
    }
    hideProgress();
    Iterator localIterator = this.qrResultProcessors.iterator();
    while (localIterator.hasNext())
    {
      localObject = (IQRScanResultProcessor)localIterator.next();
      if (((IQRScanResultProcessor)localObject).a(paramInt1, paramInt2, paramIntent))
      {
        bool2 = ((IQRScanResultProcessor)localObject).b(paramInt1, paramInt2, paramIntent);
        bool1 = true;
        break label135;
      }
    }
    Object localObject = null;
    boolean bool1 = false;
    boolean bool2 = false;
    label135:
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((IQRScanResultProcessor)localObject).a();
    }
    QLog.d("IQRScanConst_ScannerActivity", 1, String.format("handleActivityResult intercepted=%b processor=%s handle=%b", new Object[] { Boolean.valueOf(bool1), localObject, Boolean.valueOf(bool2) }));
    if (!bool1) {
      handleActivityResultDefault(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_ScannerActivity", 2, "onCreate");
    }
    this.mNeedStatusTrans = true;
    int i = 0;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131627997);
    this.app = getAppRuntime();
    initQrData();
    initQRScanResultProcessors();
    this.mHasARBack = false;
    this.mHasGetResult = false;
    this.mUiHandler = new Handler(this.mUiCallBack);
    if (paramBundle != null)
    {
      boolean bool = paramBundle.getBoolean("hansSavedState", false);
      i = bool;
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("hansSavedState : ");
        paramBundle.append(bool);
        QLog.d("IQRScanConst_ScannerActivity", 2, paramBundle.toString());
        i = bool;
      }
    }
    else if (getIntent().getBooleanExtra("from_+", false))
    {
      ReportController.b(null, "dc00898", "", "", "0X80085A9", "0X80085A9", 0, 0, "", "", "", "");
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X80085AA", "0X80085AA", 0, 0, "", "", this.mScannerParams.b, "");
    }
    if ((TextUtils.isEmpty(this.mScannerParams.c)) && (i == 0)) {
      launchAr();
    }
    if (this.app.isLogin())
    {
      paramBundle = (IQRScanMainProcService)this.app.getRuntimeService(IQRScanMainProcService.class, "");
      if (paramBundle != null) {
        paramBundle.onScannerCreate(getApplicationContext(), this.mScannerParams);
      }
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy mHasARBack:");
      ((StringBuilder)localObject).append(this.mHasARBack);
      ((StringBuilder)localObject).append("  mHasStartedAR:");
      ((StringBuilder)localObject).append(this.mHasStartedAR);
      QLog.d("IQRScanConst_ScannerActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.mHasStartedAR) || (this.mHasARBack))
    {
      if ("com.tencent.ark.scan".equals(this.mScannerParams.b))
      {
        localObject = new Intent("com.tencent.mobileqq.ark.api.scanResultAction");
        ((Intent)localObject).putExtra("com.tencent.ark.scanResultData", "");
        ((Intent)localObject).putExtra("com.tencent.ark.scanResultType", "");
        sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      }
      localObject = this.app;
      if ((localObject != null) && (((AppRuntime)localObject).isLogin()))
      {
        localObject = (IQRScanMainProcService)this.app.getRuntimeService(IQRScanMainProcService.class, "");
        if (localObject != null) {
          ((IQRScanMainProcService)localObject).onScannerDestroy();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("IQRScanConst_ScannerActivity", 2, "doOnDestroy in onScannerDestroy");
      }
    }
    Object localObject = this.mQrImageScan;
    if (localObject != null)
    {
      ((QrImageScan)localObject).a();
      this.mQrImageScan = null;
    }
    localObject = this.mPreCallUpToolProc;
    if (localObject != null)
    {
      ((PreCallUpToolProc)localObject).a();
      this.mPreCallUpToolProc = null;
    }
    localObject = this.mLoadingProgress;
    if (localObject != null)
    {
      ((QQProgressDialog)localObject).dismiss();
      this.mLoadingProgress = null;
    }
    localObject = this.mUiHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.mUiHandler = null;
    }
    destroyQRScanResultProcessors();
    super.doOnDestroy();
    QRUtils.a(this);
    this.app = null;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_ScannerActivity", 2, "doOnNewIntent");
    }
    super.doOnNewIntent(paramIntent);
    this.mScannerParams.c = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_ScannerActivity", 2, "onPause");
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_ScannerActivity", 2, "onResume");
    }
    super.doOnResume();
    if (!TextUtils.isEmpty(this.mScannerParams.c))
    {
      ScannerParams localScannerParams = this.mScannerParams;
      localScannerParams.d = localScannerParams.c;
      this.progressBar.setVisibility(0);
      if (!handlePreScanResult()) {
        handleDecodeFile(this.mScannerParams.c, this.mScannerParams.h);
      }
      this.mScannerParams.c = null;
    }
    if ((QLog.isColorLevel()) && (this.isFirstCreate) && (this.start_time > 0L))
    {
      QLog.d("IQRScanConst_ScannerActivity", 2, new Object[] { Long.valueOf(System.currentTimeMillis() - this.start_time) });
      this.isFirstCreate = false;
    }
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_ScannerActivity", 2, "doOnSaveInstanceState");
    }
    paramBundle.putBoolean("hansSavedState", true);
    super.doOnSaveInstanceState(paramBundle);
  }
  
  protected void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_ScannerActivity", 2, "doOnStop");
    }
    super.doOnStop();
    hideProgress();
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_ScannerActivity", 2, "finish");
    }
    super.finish();
  }
  
  public void hideProgress()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("hideProgress  mProgressShowing:");
      localStringBuilder1.append(this.mProgressShowing);
      QLog.d("IQRScanConst_ScannerActivity", 2, localStringBuilder1.toString());
    }
    try
    {
      if (this.mUiHandler != null) {
        this.mUiHandler.removeMessages(1);
      }
      if ((this.mLoadingProgress != null) && (this.mLoadingProgress.isShowing())) {
        this.mLoadingProgress.dismiss();
      }
      this.mProgressShowing = false;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("hide init check progress:");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("IQRScanConst_ScannerActivity", 2, localStringBuilder2.toString());
      }
      localException.printStackTrace();
    }
  }
  
  public void launchAr()
  {
    long l = System.currentTimeMillis();
    this.mClickTime = System.currentTimeMillis();
    this.mToolProcExist = ((INearbyFakeActivityUtils)QRoute.api(INearbyFakeActivityUtils.class)).isNearbyProcessExist();
    Object localObject = this.mUiHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(1);
      this.mUiHandler.sendEmptyMessageDelayed(1, 1000L);
    }
    if (this.mPreCallUpToolProc == null) {
      this.mPreCallUpToolProc = new PreCallUpToolProc(this);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchAr time pre: ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    QLog.d("IQRScanConst_ScannerActivity", 2, ((StringBuilder)localObject).toString());
    this.mPreCallUpToolProc.a("qr", 5000L, new ScannerActivity.3(this, l));
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void showProgress()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showProgress mProgressShowing:");
      localStringBuilder.append(this.mProgressShowing);
      QLog.d("IQRScanConst_ScannerActivity", 2, localStringBuilder.toString());
    }
    if (this.mProgressShowing) {
      return;
    }
    try
    {
      if (this.mLoadingProgress == null)
      {
        this.mLoadingProgress = new QQProgressDialog(this, getTitleBarHeight());
        this.mLoadingProgress.a(HardCodeUtil.a(2131914189));
        this.mLoadingProgress.c(false);
      }
      this.mProgressShowing = true;
      this.mLoadingProgress.show();
      return;
    }
    catch (Exception localException)
    {
      label106:
      break label106;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_ScannerActivity", 2, "");
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startActivity  mHasGetResult:");
      localStringBuilder.append(this.mHasGetResult);
      QLog.d("IQRScanConst_ScannerActivity", 2, localStringBuilder.toString());
    }
    super.startActivity(paramIntent);
    if (this.mHasGetResult) {
      finish();
    }
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startActivity2  mHasGetResult:");
      localStringBuilder.append(this.mHasGetResult);
      QLog.d("IQRScanConst_ScannerActivity", 2, localStringBuilder.toString());
    }
    super.startActivity(paramIntent, paramBundle);
    if (this.mHasGetResult) {
      finish();
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startActivityForResult requestCode:");
      localStringBuilder.append(paramInt);
      QLog.d("IQRScanConst_ScannerActivity", 2, localStringBuilder.toString());
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.ScannerActivity
 * JD-Core Version:    0.7.0.1
 */