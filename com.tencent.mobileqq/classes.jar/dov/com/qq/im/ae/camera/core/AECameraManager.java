package dov.com.qq.im.ae.camera.core;

import alrq;
import alsn;
import alun;
import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import aqmy;
import bbho;
import bbhp;
import bczs;
import bdax;
import bdba;
import bdbd;
import bdbe;
import bdbf;
import bdbm;
import bnax;
import bnqe;
import bnrh;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class AECameraManager
  implements bczs, bdbe, bdbm
{
  private static final int STATE_CLOSED = 0;
  private static final int STATE_OPENED = 2;
  private static final int STATE_OPEN_REQUESTING = 1;
  private static final int STATE_PREVIEWING = 4;
  private static final int STATE_PREVIEW_REQUESTING = 3;
  private static final String TAG = "AECameraManager";
  private int activityOrientation;
  private bnax aeCaptureParam;
  private AudioCapture audioCapture;
  private final Handler cameraManagerHandler;
  private int cameraPreviewHeight;
  private int cameraPreviewWidth;
  private final bdbf cameraProxy = new bdbf(null, null);
  private final AtomicInteger cameraState = new AtomicInteger(0);
  private bbho darkModeChecker;
  private boolean darkModeEnable;
  private int darkModeHeight;
  private bbhp darkModeListener;
  private int darkModeWidth;
  private View flashMask;
  private boolean flashSwitcher;
  private alrq focusOperator;
  private boolean gotFirstPreviewData;
  private boolean isDynamicResolutionMode;
  private int lastBrightMode;
  private int lastBrightness;
  private AECameraManager.CameraManagerListener mListener;
  private boolean manualFocused;
  private boolean restoreBright;
  private int selectedCamera = 1;
  
  public AECameraManager()
  {
    bdbd localbdbd = new bdbd(new Handler(Looper.getMainLooper()), this);
    if (!aqmy.d()) {
      this.selectedCamera = 2;
    }
    HandlerThread localHandlerThread = new HandlerThread("AECameraManagerHandlerThread");
    localHandlerThread.start();
    this.cameraManagerHandler = new Handler(localHandlerThread.getLooper());
    this.cameraProxy.a(localbdbd);
    this.cameraProxy.e(true);
    this.focusOperator = new alrq();
  }
  
  private boolean isCameraCreated()
  {
    return this.cameraState.get() >= 1;
  }
  
  private boolean isCameraPreviewing()
  {
    return this.cameraState.get() >= 3;
  }
  
  private void onCameraSizeSelected(bdba parambdba)
  {
    this.cameraPreviewWidth = parambdba.b;
    this.cameraPreviewHeight = parambdba.a;
    if (this.mListener != null) {
      this.mListener.onCameraPreviewSizeChanged(this.cameraPreviewWidth, this.cameraPreviewHeight);
    }
  }
  
  /* Error */
  private void openCameraInternal(AECameraManager.CameraOpenCallback paramCameraOpenCallback)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 25
    //   4: new 201	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   11: ldc 204
    //   13: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: invokespecial 160	dov/com/qq/im/ae/camera/core/AECameraManager:isCameraCreated	()Z
    //   20: invokevirtual 211	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 220	bnrh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokespecial 160	dov/com/qq/im/ae/camera/core/AECameraManager:isCameraCreated	()Z
    //   33: ifeq +29 -> 62
    //   36: ldc 25
    //   38: ldc 222
    //   40: invokestatic 224	bnrh:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_1
    //   44: ifnull +17 -> 61
    //   47: aload_1
    //   48: aload_0
    //   49: getfield 73	dov/com/qq/im/ae/camera/core/AECameraManager:selectedCamera	I
    //   52: aload_0
    //   53: invokespecial 160	dov/com/qq/im/ae/camera/core/AECameraManager:isCameraCreated	()Z
    //   56: invokeinterface 230 3 0
    //   61: return
    //   62: aload_0
    //   63: getfield 71	dov/com/qq/im/ae/camera/core/AECameraManager:cameraProxy	Lbdbf;
    //   66: aload_0
    //   67: invokevirtual 233	bdbf:a	(Lbczs;)V
    //   70: aload_0
    //   71: getfield 71	dov/com/qq/im/ae/camera/core/AECameraManager:cameraProxy	Lbdbf;
    //   74: aload_0
    //   75: getfield 73	dov/com/qq/im/ae/camera/core/AECameraManager:selectedCamera	I
    //   78: invokevirtual 235	bdbf:b	(I)V
    //   81: aload_0
    //   82: getfield 80	dov/com/qq/im/ae/camera/core/AECameraManager:cameraState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   85: iconst_2
    //   86: invokevirtual 238	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   89: ldc 25
    //   91: ldc 240
    //   93: invokestatic 220	bnrh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: getfield 242	dov/com/qq/im/ae/camera/core/AECameraManager:audioCapture	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture;
    //   100: ifnull +10 -> 110
    //   103: aload_0
    //   104: getfield 242	dov/com/qq/im/ae/camera/core/AECameraManager:audioCapture	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture;
    //   107: invokevirtual 247	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:f	()V
    //   110: aload_0
    //   111: getfield 130	dov/com/qq/im/ae/camera/core/AECameraManager:focusOperator	Lalrq;
    //   114: ifnull +21 -> 135
    //   117: aload_0
    //   118: getfield 130	dov/com/qq/im/ae/camera/core/AECameraManager:focusOperator	Lalrq;
    //   121: astore_3
    //   122: aload_0
    //   123: getfield 73	dov/com/qq/im/ae/camera/core/AECameraManager:selectedCamera	I
    //   126: iconst_1
    //   127: if_icmpne +43 -> 170
    //   130: aload_3
    //   131: iload_2
    //   132: invokevirtual 249	alrq:a	(Z)V
    //   135: aload_0
    //   136: getfield 73	dov/com/qq/im/ae/camera/core/AECameraManager:selectedCamera	I
    //   139: putstatic 252	alps:a	I
    //   142: invokestatic 257	bnqe:a	()Lbnqe;
    //   145: ldc_w 259
    //   148: invokevirtual 261	bnqe:a	(Ljava/lang/String;)V
    //   151: aload_1
    //   152: ifnull -91 -> 61
    //   155: aload_1
    //   156: aload_0
    //   157: getfield 73	dov/com/qq/im/ae/camera/core/AECameraManager:selectedCamera	I
    //   160: aload_0
    //   161: invokespecial 160	dov/com/qq/im/ae/camera/core/AECameraManager:isCameraCreated	()Z
    //   164: invokeinterface 230 3 0
    //   169: return
    //   170: iconst_0
    //   171: istore_2
    //   172: goto -42 -> 130
    //   175: astore_3
    //   176: aload_1
    //   177: ifnull +17 -> 194
    //   180: aload_1
    //   181: aload_0
    //   182: getfield 73	dov/com/qq/im/ae/camera/core/AECameraManager:selectedCamera	I
    //   185: aload_0
    //   186: invokespecial 160	dov/com/qq/im/ae/camera/core/AECameraManager:isCameraCreated	()Z
    //   189: invokeinterface 230 3 0
    //   194: aload_3
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	AECameraManager
    //   0	196	1	paramCameraOpenCallback	AECameraManager.CameraOpenCallback
    //   1	171	2	bool	boolean
    //   121	10	3	localalrq	alrq
    //   175	20	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	43	175	finally
    //   62	110	175	finally
    //   110	130	175	finally
    //   130	135	175	finally
    //   135	151	175	finally
  }
  
  private void realStartPreview(SurfaceTexture paramSurfaceTexture, alsn paramalsn)
  {
    bnrh.b("AECameraManager", "realStartPreview---ENTER, previewTexture=" + paramSurfaceTexture + ", previewSize=" + paramalsn);
    this.cameraState.set(3);
    this.aeCaptureParam.i(paramalsn.a);
    this.aeCaptureParam.j(paramalsn.b);
    if (this.isDynamicResolutionMode) {
      this.cameraProxy.a(new bdba(paramalsn.b, paramalsn.a), new bdba(paramalsn.a, paramalsn.b), 0, 30, true);
    }
    for (;;)
    {
      this.cameraProxy.a(paramSurfaceTexture, null, this, true);
      this.cameraState.set(4);
      if (this.mListener != null) {
        this.mListener.onCameraPreviewStarted();
      }
      bnrh.b("AECameraManager", "realStartPreview---EXIT");
      bnqe.a().a("startCameraPreview-end");
      return;
      this.cameraProxy.a(new bdba(this.aeCaptureParam.b(), this.aeCaptureParam.c()), new bdba(this.aeCaptureParam.d(), this.aeCaptureParam.e()), 0, 30, false);
    }
  }
  
  private void setAeCaptureParam(bnax parambnax)
  {
    this.aeCaptureParam = parambnax;
  }
  
  private void stopCameraInternal(boolean paramBoolean)
  {
    bnrh.b("AECameraManager", "stopCameraInternal---ENTER, cameraCreated=" + isCameraCreated() + ", forceStop=" + paramBoolean);
    if ((!paramBoolean) && (!isCameraCreated()))
    {
      bnrh.d("AECameraManager", "stopCameraInternal---EXIT, not created, do nothing");
      return;
    }
    this.cameraProxy.a(false);
    this.cameraProxy.b(false);
    this.cameraState.set(0);
    if (this.audioCapture != null) {
      this.audioCapture.g();
    }
    this.cameraProxy.b(this);
    this.cameraProxy.b(PeakAppInterface.a);
    bnrh.b("AECameraManager", "stopCameraInternal---EXIT, normally");
  }
  
  private void turnFrontFlash(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.flashMask == null) {
        this.flashMask = new View(paramActivity);
      }
      this.flashMask.setBackgroundColor(-1);
      this.flashMask.setAlpha(0.7F);
      if (this.flashMask.getParent() != null) {
        ((ViewGroup)this.flashMask.getParent()).removeView(this.flashMask);
      }
      paramActivity.addContentView(this.flashMask, new ViewGroup.LayoutParams(-1, -1));
    }
    do
    {
      try
      {
        this.lastBrightMode = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness_mode");
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness_mode", 0);
        this.lastBrightness = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness");
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness", 255);
        this.restoreBright = true;
        return;
      }
      catch (Exception paramActivity)
      {
        do
        {
          this.lastBrightMode = 1;
          this.lastBrightness = 100;
        } while (!QLog.isColorLevel());
        QLog.e("AECameraManager", 2, "turn FrontFlash Error ", paramActivity);
        paramActivity.printStackTrace();
        return;
      }
      if (this.restoreBright)
      {
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness", this.lastBrightness);
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness_mode", this.lastBrightMode);
        this.restoreBright = false;
      }
    } while ((this.flashMask == null) || (this.flashMask.getParent() == null));
    ((ViewGroup)this.flashMask.getParent()).removeView(this.flashMask);
  }
  
  public void cameraStopPreview()
  {
    this.cameraManagerHandler.post(new AECameraManager.6(this));
  }
  
  public void capturePhoto(File paramFile, int paramInt, boolean paramBoolean, alun paramalun, alsn paramalsn)
  {
    this.cameraManagerHandler.post(new AECameraManager.7(this, paramFile, paramalsn, paramalun, paramInt, paramBoolean));
  }
  
  public void changeCamera(int paramInt, AECameraManager.CameraOpenCallback paramCameraOpenCallback)
  {
    this.cameraManagerHandler.post(new AECameraManager.4(this, paramInt, paramCameraOpenCallback));
  }
  
  public int getActivityOrientation()
  {
    return this.activityOrientation;
  }
  
  public int getAnotherCamera()
  {
    return (this.selectedCamera + 1) % 2;
  }
  
  public Handler getCameraHandler()
  {
    if (this.cameraProxy == null) {
      return null;
    }
    return this.cameraProxy.a();
  }
  
  public String getDefaultFocusMode()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AECameraManager", 2, "[@] getDefaultFocusMode: Build.MANUFACTURER=" + Build.MANUFACTURER + "VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.VERSION.SDK_INT >= 14)) {}
    return "continuous-picture";
  }
  
  public int getSelectedCamera()
  {
    return this.selectedCamera;
  }
  
  public void init(bnax parambnax)
  {
    this.darkModeChecker = new bbho();
    setAeCaptureParam(parambnax);
    this.selectedCamera = parambnax.g();
    if ((this.selectedCamera == 1) && (!aqmy.d())) {
      this.selectedCamera = 2;
    }
  }
  
  public boolean isFlashEnabled()
  {
    return this.flashSwitcher;
  }
  
  public boolean isFrontCamera()
  {
    return this.selectedCamera == 1;
  }
  
  public boolean isSupportCamera2()
  {
    return this.cameraProxy.b;
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    bnqe.a().a("AECameraManager", "【CameraProxy notify】eventId=" + paramInt + ", args=" + Arrays.toString(paramVarArgs));
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!(paramVarArgs[0] instanceof bdba)) {
                  break;
                }
                onCameraSizeSelected((bdba)paramVarArgs[0]);
              } while (this.mListener == null);
              this.mListener.onCameraStarted(true, "");
              bnrh.b("AECameraManager", "【Camera Open Success】EVENT_SET_CAMERA_PARAM");
              return;
            } while ((!(paramVarArgs[0] instanceof String)) || (this.mListener == null));
            this.mListener.onCameraStarted(false, (String)paramVarArgs[0]);
            bnrh.d("AECameraManager", "【Camera Open Error】EVENT_SET_CAMERA_PARAM:" + paramVarArgs[0]);
            return;
          } while ((!(paramVarArgs[0] instanceof String)) || (this.mListener == null));
          this.mListener.onCameraStarted(false, (String)paramVarArgs[0]);
          bnrh.d("AECameraManager", "【Camera Open Error】EVENT_CREATE_CAMERA:" + paramVarArgs[0]);
          return;
        } while ((!(paramVarArgs[0] instanceof Integer)) || (this.mListener == null));
        this.mListener.onCameraStarted(false, "[Camera2]openCamera2 error:" + paramVarArgs[0]);
        bnrh.d("AECameraManager", "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + paramVarArgs[0]);
        return;
        if (!(paramVarArgs[0] instanceof bdba)) {
          break;
        }
        onCameraSizeSelected((bdba)paramVarArgs[0]);
        if (this.mListener != null)
        {
          this.mListener.onCameraStarted(true, "");
          bnrh.b("AECameraManager", "【Camera2 Open Success】EVENT_CAMERA2_PARAMS");
        }
      } while ((paramVarArgs.length < 2) || (!(paramVarArgs[1] instanceof bdba)));
      paramObject = (bdba)paramVarArgs[1];
      this.darkModeWidth = paramObject.a;
      this.darkModeHeight = paramObject.b;
      return;
    } while ((!(paramVarArgs[0] instanceof String)) || (this.mListener == null));
    this.mListener.onCameraStarted(false, "[Camera2]setCamera2 Params error:" + paramVarArgs[0]);
    bnrh.d("AECameraManager", "【Camera2 Open Error】setCamera2 Params error::" + paramVarArgs[0]);
  }
  
  public void onCameraException(Exception paramException)
  {
    if (paramException != null)
    {
      bnrh.a("AECameraManager", "onCameraException---" + paramException.getMessage(), paramException);
      return;
    }
    bnrh.d("AECameraManager", "onCameraException---");
  }
  
  public void onDispatchThreadException(RuntimeException paramRuntimeException)
  {
    if (paramRuntimeException != null)
    {
      bnrh.a("AECameraManager", "onDispatchThreadException---" + paramRuntimeException.getMessage(), paramRuntimeException);
      return;
    }
    bnrh.d("AECameraManager", "onDispatchThreadException---");
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (!this.gotFirstPreviewData)
    {
      this.gotFirstPreviewData = true;
      bnqe.a().a("onCameraPreviewFrameData");
    }
    bdax.a().a(true, paramArrayOfByte);
    if (this.darkModeEnable)
    {
      int k = this.cameraPreviewWidth;
      int m = this.cameraPreviewHeight;
      int j = m;
      int i = k;
      if (this.darkModeWidth > 0)
      {
        j = m;
        i = k;
        if (this.darkModeHeight > 0)
        {
          i = this.darkModeHeight;
          j = this.darkModeWidth;
        }
      }
      this.darkModeChecker.a(paramArrayOfByte, i, j, this.darkModeListener);
    }
  }
  
  public void openCamera(AECameraManager.CameraOpenCallback paramCameraOpenCallback)
  {
    bnqe.a().a("openCamera-begin");
    this.cameraManagerHandler.post(new AECameraManager.1(this, paramCameraOpenCallback));
  }
  
  public void refreshDarkModeTimer()
  {
    if (this.darkModeChecker != null) {
      this.darkModeChecker.a();
    }
  }
  
  public void requestCameraFocus(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.cameraManagerHandler.post(new AECameraManager.8(this, paramFloat1, paramFloat2, paramInt1, paramInt2));
  }
  
  public boolean requestFocusBeforeTakePicture()
  {
    return (this.flashSwitcher) && (!this.manualFocused);
  }
  
  public void setActivityOrientation(int paramInt)
  {
    this.activityOrientation = paramInt;
  }
  
  public void setAudioCapture(AudioCapture paramAudioCapture)
  {
    this.audioCapture = paramAudioCapture;
  }
  
  public void setCameraManagerListener(AECameraManager.CameraManagerListener paramCameraManagerListener)
  {
    bnrh.b("AECameraManager", "### setCameraManagerListener--- listener=" + paramCameraManagerListener);
    this.mListener = paramCameraManagerListener;
  }
  
  public void setDarkModeChecker(bbho parambbho)
  {
    this.darkModeChecker = parambbho;
  }
  
  public void setDarkModeEnable(boolean paramBoolean)
  {
    this.darkModeEnable = paramBoolean;
  }
  
  public void setDarkModeListener(bbhp parambbhp)
  {
    this.darkModeListener = parambbhp;
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.isDynamicResolutionMode = paramBoolean;
  }
  
  public void setFocusModeDefault()
  {
    String str = getDefaultFocusMode();
    if ((!bdax.a().a(str)) && (bdax.a().a("auto"))) {
      bdax.a().a(null);
    }
  }
  
  public void setFocusModeRecording()
  {
    this.cameraManagerHandler.post(new AECameraManager.11(this));
  }
  
  public void setFocusOperatorMatrix(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.focusOperator != null) {
      this.focusOperator.a(paramInt2, paramInt1, paramInt3, paramInt4);
    }
  }
  
  public void setSelectedCamera(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1)) {}
    while ((paramInt == 1) && (!aqmy.d())) {
      return;
    }
    this.cameraManagerHandler.post(new AECameraManager.12(this, paramInt));
  }
  
  public void setSupportCamera2(boolean paramBoolean)
  {
    this.cameraProxy.e(paramBoolean);
  }
  
  public void setZoom(int paramInt)
  {
    this.cameraManagerHandler.post(new AECameraManager.10(this, paramInt));
  }
  
  public void startCameraPreview(SurfaceTexture paramSurfaceTexture, alsn paramalsn)
  {
    bnrh.b("AECameraManager", "startCameraPreview ENTER---previewTexture=" + paramSurfaceTexture + ", previewSize=" + paramalsn);
    if ((paramSurfaceTexture == null) || (paramalsn == null) || (Math.min(paramalsn.a, paramalsn.b) <= 0)) {
      return;
    }
    bnqe.a().a("startCameraPreview-begin");
    this.cameraManagerHandler.post(new AECameraManager.5(this, paramSurfaceTexture, paramalsn));
  }
  
  public void stopCamera(boolean paramBoolean)
  {
    this.cameraManagerHandler.post(new AECameraManager.2(this, paramBoolean));
  }
  
  public void stopRecordVideo()
  {
    this.cameraManagerHandler.post(new AECameraManager.9(this));
  }
  
  public void switchFlash(boolean paramBoolean)
  {
    this.flashSwitcher = paramBoolean;
  }
  
  public void toggleCamera(AECameraManager.CameraOpenCallback paramCameraOpenCallback)
  {
    if (!aqmy.d())
    {
      bnrh.d("AECameraManager", "toggleCamera---front camera not exists, not support toggle");
      paramCameraOpenCallback.onOpenResult(this.selectedCamera, false);
      return;
    }
    this.cameraManagerHandler.post(new AECameraManager.3(this, paramCameraOpenCallback));
  }
  
  public void turnFlash(Activity paramActivity, boolean paramBoolean)
  {
    if (this.selectedCamera == 1)
    {
      turnFrontFlash(paramActivity, paramBoolean);
      return;
    }
    this.cameraProxy.c(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager
 * JD-Core Version:    0.7.0.1
 */