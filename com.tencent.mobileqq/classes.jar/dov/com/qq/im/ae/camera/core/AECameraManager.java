package dov.com.qq.im.ae.camera.core;

import aktu;
import akur;
import akwr;
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
import apju;
import babf;
import babg;
import bbsx;
import bbuc;
import bbuf;
import bbui;
import bbuj;
import bbuk;
import bbur;
import blno;
import bmau;
import bmbx;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class AECameraManager
  implements bbsx, bbuj, bbur
{
  private static final int STATE_CLOSED = 0;
  private static final int STATE_OPENED = 2;
  private static final int STATE_OPEN_REQUESTING = 1;
  private static final int STATE_PREVIEWING = 4;
  private static final int STATE_PREVIEW_REQUESTING = 3;
  private static final String TAG = "AECameraManager";
  private int activityOrientation;
  private blno aeCaptureParam;
  private AudioCapture audioCapture;
  private final Handler cameraManagerHandler;
  private int cameraPreviewHeight;
  private int cameraPreviewWidth;
  private final bbuk cameraProxy = new bbuk(null, null);
  private final AtomicInteger cameraState = new AtomicInteger(0);
  private babf darkModeChecker;
  private boolean darkModeEnable;
  private int darkModeHeight;
  private babg darkModeListener;
  private int darkModeWidth;
  private View flashMask;
  private boolean flashSwitcher;
  private aktu focusOperator;
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
    bbui localbbui = new bbui(new Handler(Looper.getMainLooper()), this);
    if (!apju.d()) {
      this.selectedCamera = 2;
    }
    HandlerThread localHandlerThread = new HandlerThread("AECameraManagerHandlerThread");
    localHandlerThread.start();
    this.cameraManagerHandler = new Handler(localHandlerThread.getLooper());
    this.cameraProxy.a(localbbui);
    this.cameraProxy.e(true);
    this.focusOperator = new aktu();
  }
  
  private boolean isCameraCreated()
  {
    return this.cameraState.get() >= 1;
  }
  
  private boolean isCameraPreviewing()
  {
    return this.cameraState.get() >= 3;
  }
  
  private void onCameraSizeSelected(bbuf parambbuf)
  {
    this.cameraPreviewWidth = parambbuf.b;
    this.cameraPreviewHeight = parambbuf.a;
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
    //   26: invokestatic 220	bmbx:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokespecial 160	dov/com/qq/im/ae/camera/core/AECameraManager:isCameraCreated	()Z
    //   33: ifeq +29 -> 62
    //   36: ldc 25
    //   38: ldc 222
    //   40: invokestatic 224	bmbx:d	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   63: getfield 71	dov/com/qq/im/ae/camera/core/AECameraManager:cameraProxy	Lbbuk;
    //   66: aload_0
    //   67: invokevirtual 233	bbuk:a	(Lbbsx;)V
    //   70: aload_0
    //   71: getfield 71	dov/com/qq/im/ae/camera/core/AECameraManager:cameraProxy	Lbbuk;
    //   74: aload_0
    //   75: getfield 73	dov/com/qq/im/ae/camera/core/AECameraManager:selectedCamera	I
    //   78: invokevirtual 235	bbuk:b	(I)V
    //   81: aload_0
    //   82: getfield 80	dov/com/qq/im/ae/camera/core/AECameraManager:cameraState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   85: iconst_2
    //   86: invokevirtual 238	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   89: ldc 25
    //   91: ldc 240
    //   93: invokestatic 220	bmbx:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: getfield 242	dov/com/qq/im/ae/camera/core/AECameraManager:audioCapture	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture;
    //   100: ifnull +10 -> 110
    //   103: aload_0
    //   104: getfield 242	dov/com/qq/im/ae/camera/core/AECameraManager:audioCapture	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture;
    //   107: invokevirtual 247	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:f	()V
    //   110: aload_0
    //   111: getfield 130	dov/com/qq/im/ae/camera/core/AECameraManager:focusOperator	Laktu;
    //   114: ifnull +21 -> 135
    //   117: aload_0
    //   118: getfield 130	dov/com/qq/im/ae/camera/core/AECameraManager:focusOperator	Laktu;
    //   121: astore_3
    //   122: aload_0
    //   123: getfield 73	dov/com/qq/im/ae/camera/core/AECameraManager:selectedCamera	I
    //   126: iconst_1
    //   127: if_icmpne +43 -> 170
    //   130: aload_3
    //   131: iload_2
    //   132: invokevirtual 249	aktu:a	(Z)V
    //   135: aload_0
    //   136: getfield 73	dov/com/qq/im/ae/camera/core/AECameraManager:selectedCamera	I
    //   139: putstatic 252	akrw:a	I
    //   142: invokestatic 257	bmau:a	()Lbmau;
    //   145: ldc_w 259
    //   148: invokevirtual 261	bmau:a	(Ljava/lang/String;)V
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
    //   121	10	3	localaktu	aktu
    //   175	20	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	43	175	finally
    //   62	110	175	finally
    //   110	130	175	finally
    //   130	135	175	finally
    //   135	151	175	finally
  }
  
  private void realStartPreview(SurfaceTexture paramSurfaceTexture, akur paramakur)
  {
    bmbx.b("AECameraManager", "realStartPreview---ENTER, previewTexture=" + paramSurfaceTexture + ", previewSize=" + paramakur);
    this.cameraState.set(3);
    this.aeCaptureParam.i(paramakur.a);
    this.aeCaptureParam.j(paramakur.b);
    if (this.isDynamicResolutionMode) {
      this.cameraProxy.a(new bbuf(paramakur.b, paramakur.a), new bbuf(paramakur.a, paramakur.b), 0, 30, true);
    }
    for (;;)
    {
      this.cameraProxy.a(paramSurfaceTexture, null, this, true);
      this.cameraState.set(4);
      if (this.mListener != null) {
        this.mListener.onCameraPreviewStarted();
      }
      bmbx.b("AECameraManager", "realStartPreview---EXIT");
      bmau.a().a("startCameraPreview-end");
      return;
      this.cameraProxy.a(new bbuf(this.aeCaptureParam.b(), this.aeCaptureParam.c()), new bbuf(this.aeCaptureParam.d(), this.aeCaptureParam.e()), 0, 30, false);
    }
  }
  
  private void setAeCaptureParam(blno paramblno)
  {
    this.aeCaptureParam = paramblno;
  }
  
  private void stopCameraInternal(boolean paramBoolean)
  {
    bmbx.b("AECameraManager", "stopCameraInternal---ENTER, cameraCreated=" + isCameraCreated() + ", forceStop=" + paramBoolean);
    if ((!paramBoolean) && (!isCameraCreated()))
    {
      bmbx.d("AECameraManager", "stopCameraInternal---EXIT, not created, do nothing");
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
    bmbx.b("AECameraManager", "stopCameraInternal---EXIT, normally");
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
  
  public void capturePhoto(File paramFile, int paramInt, boolean paramBoolean, akwr paramakwr, akur paramakur)
  {
    this.cameraManagerHandler.post(new AECameraManager.7(this, paramFile, paramakur, paramakwr, paramInt, paramBoolean));
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
  
  public void init(blno paramblno)
  {
    this.darkModeChecker = new babf();
    setAeCaptureParam(paramblno);
    this.selectedCamera = paramblno.g();
    if ((this.selectedCamera == 1) && (!apju.d())) {
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
    bmau.a().a("AECameraManager", "【CameraProxy notify】eventId=" + paramInt + ", args=" + Arrays.toString(paramVarArgs));
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
                if (!(paramVarArgs[0] instanceof bbuf)) {
                  break;
                }
                onCameraSizeSelected((bbuf)paramVarArgs[0]);
              } while (this.mListener == null);
              this.mListener.onCameraStarted(true, "");
              bmbx.b("AECameraManager", "【Camera Open Success】EVENT_SET_CAMERA_PARAM");
              return;
            } while ((!(paramVarArgs[0] instanceof String)) || (this.mListener == null));
            this.mListener.onCameraStarted(false, (String)paramVarArgs[0]);
            bmbx.d("AECameraManager", "【Camera Open Error】EVENT_SET_CAMERA_PARAM:" + paramVarArgs[0]);
            return;
          } while ((!(paramVarArgs[0] instanceof String)) || (this.mListener == null));
          this.mListener.onCameraStarted(false, (String)paramVarArgs[0]);
          bmbx.d("AECameraManager", "【Camera Open Error】EVENT_CREATE_CAMERA:" + paramVarArgs[0]);
          return;
        } while ((!(paramVarArgs[0] instanceof Integer)) || (this.mListener == null));
        this.mListener.onCameraStarted(false, "[Camera2]openCamera2 error:" + paramVarArgs[0]);
        bmbx.d("AECameraManager", "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + paramVarArgs[0]);
        return;
        if (!(paramVarArgs[0] instanceof bbuf)) {
          break;
        }
        onCameraSizeSelected((bbuf)paramVarArgs[0]);
        if (this.mListener != null)
        {
          this.mListener.onCameraStarted(true, "");
          bmbx.b("AECameraManager", "【Camera2 Open Success】EVENT_CAMERA2_PARAMS");
        }
      } while ((paramVarArgs.length < 2) || (!(paramVarArgs[1] instanceof bbuf)));
      paramObject = (bbuf)paramVarArgs[1];
      this.darkModeWidth = paramObject.a;
      this.darkModeHeight = paramObject.b;
      return;
    } while ((!(paramVarArgs[0] instanceof String)) || (this.mListener == null));
    this.mListener.onCameraStarted(false, "[Camera2]setCamera2 Params error:" + paramVarArgs[0]);
    bmbx.d("AECameraManager", "【Camera2 Open Error】setCamera2 Params error::" + paramVarArgs[0]);
  }
  
  public void onCameraException(Exception paramException)
  {
    if (paramException != null)
    {
      bmbx.a("AECameraManager", "onCameraException---" + paramException.getMessage(), paramException);
      return;
    }
    bmbx.d("AECameraManager", "onCameraException---");
  }
  
  public void onDispatchThreadException(RuntimeException paramRuntimeException)
  {
    if (paramRuntimeException != null)
    {
      bmbx.a("AECameraManager", "onDispatchThreadException---" + paramRuntimeException.getMessage(), paramRuntimeException);
      return;
    }
    bmbx.d("AECameraManager", "onDispatchThreadException---");
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (!this.gotFirstPreviewData)
    {
      this.gotFirstPreviewData = true;
      bmau.a().a("onCameraPreviewFrameData");
    }
    bbuc.a().a(true, paramArrayOfByte);
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
    bmau.a().a("openCamera-begin");
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
    bmbx.b("AECameraManager", "### setCameraManagerListener--- listener=" + paramCameraManagerListener);
    this.mListener = paramCameraManagerListener;
  }
  
  public void setDarkModeChecker(babf parambabf)
  {
    this.darkModeChecker = parambabf;
  }
  
  public void setDarkModeEnable(boolean paramBoolean)
  {
    this.darkModeEnable = paramBoolean;
  }
  
  public void setDarkModeListener(babg parambabg)
  {
    this.darkModeListener = parambabg;
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.isDynamicResolutionMode = paramBoolean;
  }
  
  public void setFocusModeDefault()
  {
    String str = getDefaultFocusMode();
    if ((!bbuc.a().a(str)) && (bbuc.a().a("auto"))) {
      bbuc.a().a(null);
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
    while ((paramInt == 1) && (!apju.d())) {
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
  
  public void startCameraPreview(SurfaceTexture paramSurfaceTexture, akur paramakur)
  {
    bmbx.b("AECameraManager", "startCameraPreview ENTER---previewTexture=" + paramSurfaceTexture + ", previewSize=" + paramakur);
    if ((paramSurfaceTexture == null) || (paramakur == null) || (Math.min(paramakur.a, paramakur.b) <= 0)) {
      return;
    }
    bmau.a().a("startCameraPreview-begin");
    this.cameraManagerHandler.post(new AECameraManager.5(this, paramSurfaceTexture, paramakur));
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
    if (!apju.d())
    {
      bmbx.d("AECameraManager", "toggleCamera---front camera not exists, not support toggle");
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