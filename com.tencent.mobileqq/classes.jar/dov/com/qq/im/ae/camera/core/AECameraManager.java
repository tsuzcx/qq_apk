package dov.com.qq.im.ae.camera.core;

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
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraOperator;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker.DarkModeListener;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraProxyCallBack;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.AECaptureParam;
import dov.com.qq.im.ae.perf.AELaunchRecorder;
import dov.com.qq.im.ae.util.AEQLog;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class AECameraManager
  implements Observer, CameraExceptionHandler.Callback, CameraProxy.CameraProxyCallBack
{
  private static final int STATE_CLOSED = 0;
  private static final int STATE_OPENED = 2;
  private static final int STATE_OPEN_REQUESTING = 1;
  private static final int STATE_PREVIEWING = 4;
  private static final int STATE_PREVIEW_REQUESTING = 3;
  private static final String TAG = "AECameraManager";
  private int activityOrientation = 0;
  private AECaptureParam aeCaptureParam;
  private AudioCapture audioCapture;
  private final Handler cameraManagerHandler;
  private int cameraPreviewHeight;
  private int cameraPreviewWidth;
  private final CameraProxy cameraProxy = new CameraProxy(null, null);
  private final AtomicInteger cameraState = new AtomicInteger(0);
  private DarkModeChecker darkModeChecker;
  private boolean darkModeEnable;
  private int darkModeHeight;
  private DarkModeChecker.DarkModeListener darkModeListener;
  private int darkModeWidth;
  private View flashMask;
  private boolean flashSwitcher = false;
  private NewFlowCameraOperator focusOperator;
  private boolean gotFirstPreviewData = false;
  private boolean isDynamicResolutionMode = false;
  private int lastBrightMode;
  private int lastBrightness;
  private AECameraManager.CameraManagerListener mListener;
  private boolean manualFocused = false;
  private boolean restoreBright = false;
  private int selectedCamera = 1;
  
  public AECameraManager()
  {
    Object localObject = new CameraExceptionHandler(new Handler(Looper.getMainLooper()), this);
    if (!CameraUtils.d()) {
      this.selectedCamera = 2;
    }
    HandlerThread localHandlerThread = new HandlerThread("AECameraManagerHandlerThread");
    localHandlerThread.start();
    this.cameraManagerHandler = new Handler(localHandlerThread.getLooper());
    this.cameraProxy.a((CameraExceptionHandler)localObject);
    localObject = this.cameraProxy;
    if (!"Google Pixel 4 XL".equals(Build.MANUFACTURER + " " + Build.MODEL)) {}
    for (;;)
    {
      ((CameraProxy)localObject).e(bool);
      this.focusOperator = new NewFlowCameraOperator();
      return;
      bool = false;
    }
  }
  
  private boolean isCameraCreated()
  {
    return this.cameraState.get() >= 1;
  }
  
  private boolean isCameraPreviewing()
  {
    return this.cameraState.get() >= 3;
  }
  
  private void onCameraSizeSelected(CameraControl.CustomSize paramCustomSize)
  {
    this.cameraPreviewWidth = paramCustomSize.b;
    this.cameraPreviewHeight = paramCustomSize.a;
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
    //   4: new 137	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   11: ldc 238
    //   13: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: invokespecial 197	dov/com/qq/im/ae/camera/core/AECameraManager:isCameraCreated	()Z
    //   20: invokevirtual 241	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 246	dov/com/qq/im/ae/util/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokespecial 197	dov/com/qq/im/ae/camera/core/AECameraManager:isCameraCreated	()Z
    //   33: ifeq +29 -> 62
    //   36: ldc 25
    //   38: ldc 248
    //   40: invokestatic 250	dov/com/qq/im/ae/util/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_1
    //   44: ifnull +17 -> 61
    //   47: aload_1
    //   48: aload_0
    //   49: getfield 83	dov/com/qq/im/ae/camera/core/AECameraManager:selectedCamera	I
    //   52: aload_0
    //   53: invokespecial 197	dov/com/qq/im/ae/camera/core/AECameraManager:isCameraCreated	()Z
    //   56: invokeinterface 256 3 0
    //   61: return
    //   62: aload_0
    //   63: getfield 71	dov/com/qq/im/ae/camera/core/AECameraManager:cameraProxy	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   66: aload_0
    //   67: invokevirtual 259	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:a	(Lcom/tencent/mobileqq/shortvideo/common/Observer;)V
    //   70: aload_0
    //   71: getfield 71	dov/com/qq/im/ae/camera/core/AECameraManager:cameraProxy	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   74: aload_0
    //   75: getfield 83	dov/com/qq/im/ae/camera/core/AECameraManager:selectedCamera	I
    //   78: invokevirtual 261	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:b	(I)V
    //   81: aload_0
    //   82: getfield 90	dov/com/qq/im/ae/camera/core/AECameraManager:cameraState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   85: iconst_2
    //   86: invokevirtual 264	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   89: ldc 25
    //   91: ldc_w 266
    //   94: invokestatic 246	dov/com/qq/im/ae/util/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_0
    //   98: getfield 268	dov/com/qq/im/ae/camera/core/AECameraManager:audioCapture	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture;
    //   101: ifnull +10 -> 111
    //   104: aload_0
    //   105: getfield 268	dov/com/qq/im/ae/camera/core/AECameraManager:audioCapture	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture;
    //   108: invokevirtual 273	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:f	()V
    //   111: aload_0
    //   112: getfield 171	dov/com/qq/im/ae/camera/core/AECameraManager:focusOperator	Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraOperator;
    //   115: ifnull +21 -> 136
    //   118: aload_0
    //   119: getfield 171	dov/com/qq/im/ae/camera/core/AECameraManager:focusOperator	Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraOperator;
    //   122: astore_3
    //   123: aload_0
    //   124: getfield 83	dov/com/qq/im/ae/camera/core/AECameraManager:selectedCamera	I
    //   127: iconst_1
    //   128: if_icmpne +43 -> 171
    //   131: aload_3
    //   132: iload_2
    //   133: invokevirtual 275	com/tencent/mobileqq/activity/richmedia/NewFlowCameraOperator:a	(Z)V
    //   136: aload_0
    //   137: getfield 83	dov/com/qq/im/ae/camera/core/AECameraManager:selectedCamera	I
    //   140: putstatic 278	com/tencent/mobileqq/activity/richmedia/FlowCameraConstant:a	I
    //   143: invokestatic 283	dov/com/qq/im/ae/perf/AELaunchRecorder:a	()Ldov/com/qq/im/ae/perf/AELaunchRecorder;
    //   146: ldc_w 285
    //   149: invokevirtual 287	dov/com/qq/im/ae/perf/AELaunchRecorder:a	(Ljava/lang/String;)V
    //   152: aload_1
    //   153: ifnull -92 -> 61
    //   156: aload_1
    //   157: aload_0
    //   158: getfield 83	dov/com/qq/im/ae/camera/core/AECameraManager:selectedCamera	I
    //   161: aload_0
    //   162: invokespecial 197	dov/com/qq/im/ae/camera/core/AECameraManager:isCameraCreated	()Z
    //   165: invokeinterface 256 3 0
    //   170: return
    //   171: iconst_0
    //   172: istore_2
    //   173: goto -42 -> 131
    //   176: astore_3
    //   177: aload_1
    //   178: ifnull +17 -> 195
    //   181: aload_1
    //   182: aload_0
    //   183: getfield 83	dov/com/qq/im/ae/camera/core/AECameraManager:selectedCamera	I
    //   186: aload_0
    //   187: invokespecial 197	dov/com/qq/im/ae/camera/core/AECameraManager:isCameraCreated	()Z
    //   190: invokeinterface 256 3 0
    //   195: aload_3
    //   196: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	AECameraManager
    //   0	197	1	paramCameraOpenCallback	AECameraManager.CameraOpenCallback
    //   1	172	2	bool	boolean
    //   122	10	3	localNewFlowCameraOperator	NewFlowCameraOperator
    //   176	20	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	43	176	finally
    //   62	111	176	finally
    //   111	131	176	finally
    //   131	136	176	finally
    //   136	152	176	finally
  }
  
  private void realStartPreview(SurfaceTexture paramSurfaceTexture, Size paramSize)
  {
    AEQLog.b("AECameraManager", "realStartPreview---ENTER, previewTexture=" + paramSurfaceTexture + ", previewSize=" + paramSize);
    this.cameraState.set(3);
    this.aeCaptureParam.i(paramSize.a);
    this.aeCaptureParam.j(paramSize.b);
    if (this.isDynamicResolutionMode) {
      this.cameraProxy.a(new CameraControl.CustomSize(paramSize.b, paramSize.a), new CameraControl.CustomSize(paramSize.a, paramSize.b), 0, 30, true);
    }
    for (;;)
    {
      this.cameraProxy.a(paramSurfaceTexture, null, this, true);
      this.cameraState.set(4);
      if (this.mListener != null) {
        this.mListener.onCameraPreviewStarted();
      }
      AEQLog.b("AECameraManager", "realStartPreview---EXIT");
      AELaunchRecorder.a().a("startCameraPreview-end");
      return;
      this.cameraProxy.a(new CameraControl.CustomSize(this.aeCaptureParam.b(), this.aeCaptureParam.c()), new CameraControl.CustomSize(this.aeCaptureParam.d(), this.aeCaptureParam.e()), 0, 30, false);
    }
  }
  
  private void setAeCaptureParam(AECaptureParam paramAECaptureParam)
  {
    this.aeCaptureParam = paramAECaptureParam;
  }
  
  private void stopCameraInternal(boolean paramBoolean)
  {
    AEQLog.b("AECameraManager", "stopCameraInternal---ENTER, cameraCreated=" + isCameraCreated() + ", forceStop=" + paramBoolean);
    if ((!paramBoolean) && (!isCameraCreated()))
    {
      AEQLog.d("AECameraManager", "stopCameraInternal---EXIT, not created, do nothing");
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
    AEQLog.b("AECameraManager", "stopCameraInternal---EXIT, normally");
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
  
  public void capturePhoto(File paramFile, int paramInt, boolean paramBoolean, CameraCover.PictureCallback paramPictureCallback, Size paramSize)
  {
    this.cameraManagerHandler.post(new AECameraManager.7(this, paramFile, paramSize, paramPictureCallback, paramInt, paramBoolean));
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
  
  public void init(AECaptureParam paramAECaptureParam)
  {
    this.darkModeChecker = new DarkModeChecker();
    setAeCaptureParam(paramAECaptureParam);
    this.selectedCamera = paramAECaptureParam.g();
    if ((this.selectedCamera == 1) && (!CameraUtils.d())) {
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
    AELaunchRecorder.a().a("AECameraManager", "【CameraProxy notify】eventId=" + paramInt + ", args=" + Arrays.toString(paramVarArgs));
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
                if (!(paramVarArgs[0] instanceof CameraControl.CustomSize)) {
                  break;
                }
                onCameraSizeSelected((CameraControl.CustomSize)paramVarArgs[0]);
              } while (this.mListener == null);
              this.mListener.onCameraStarted(true, "");
              AEQLog.b("AECameraManager", "【Camera Open Success】EVENT_SET_CAMERA_PARAM");
              return;
            } while ((!(paramVarArgs[0] instanceof String)) || (this.mListener == null));
            this.mListener.onCameraStarted(false, (String)paramVarArgs[0]);
            AEQLog.d("AECameraManager", "【Camera Open Error】EVENT_SET_CAMERA_PARAM:" + paramVarArgs[0]);
            return;
          } while ((!(paramVarArgs[0] instanceof String)) || (this.mListener == null));
          this.mListener.onCameraStarted(false, (String)paramVarArgs[0]);
          AEQLog.d("AECameraManager", "【Camera Open Error】EVENT_CREATE_CAMERA:" + paramVarArgs[0]);
          return;
        } while ((!(paramVarArgs[0] instanceof Integer)) || (this.mListener == null));
        this.mListener.onCameraStarted(false, "[Camera2]openCamera2 error:" + paramVarArgs[0]);
        AEQLog.d("AECameraManager", "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + paramVarArgs[0]);
        return;
        if (!(paramVarArgs[0] instanceof CameraControl.CustomSize)) {
          break;
        }
        onCameraSizeSelected((CameraControl.CustomSize)paramVarArgs[0]);
        if (this.mListener != null)
        {
          this.mListener.onCameraStarted(true, "");
          AEQLog.b("AECameraManager", "【Camera2 Open Success】EVENT_CAMERA2_PARAMS");
        }
      } while ((paramVarArgs.length < 2) || (!(paramVarArgs[1] instanceof CameraControl.CustomSize)));
      paramObject = (CameraControl.CustomSize)paramVarArgs[1];
      this.darkModeWidth = paramObject.a;
      this.darkModeHeight = paramObject.b;
      return;
    } while ((!(paramVarArgs[0] instanceof String)) || (this.mListener == null));
    this.mListener.onCameraStarted(false, "[Camera2]setCamera2 Params error:" + paramVarArgs[0]);
    AEQLog.d("AECameraManager", "【Camera2 Open Error】setCamera2 Params error::" + paramVarArgs[0]);
  }
  
  public void onCameraException(Exception paramException)
  {
    if (paramException != null)
    {
      AEQLog.a("AECameraManager", "onCameraException---" + paramException.getMessage(), paramException);
      return;
    }
    AEQLog.d("AECameraManager", "onCameraException---");
  }
  
  public void onDispatchThreadException(RuntimeException paramRuntimeException)
  {
    if (paramRuntimeException != null)
    {
      AEQLog.a("AECameraManager", "onDispatchThreadException---" + paramRuntimeException.getMessage(), paramRuntimeException);
      return;
    }
    AEQLog.d("AECameraManager", "onDispatchThreadException---");
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (!this.gotFirstPreviewData)
    {
      this.gotFirstPreviewData = true;
      AELaunchRecorder.a().a("onCameraPreviewFrameData");
    }
    CameraControl.a().a(true, paramArrayOfByte);
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
    AELaunchRecorder.a().a("openCamera-begin");
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
    AEQLog.b("AECameraManager", "### setCameraManagerListener--- listener=" + paramCameraManagerListener);
    this.mListener = paramCameraManagerListener;
  }
  
  public void setDarkModeChecker(DarkModeChecker paramDarkModeChecker)
  {
    this.darkModeChecker = paramDarkModeChecker;
  }
  
  public void setDarkModeEnable(boolean paramBoolean)
  {
    this.darkModeEnable = paramBoolean;
  }
  
  public void setDarkModeListener(DarkModeChecker.DarkModeListener paramDarkModeListener)
  {
    this.darkModeListener = paramDarkModeListener;
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.isDynamicResolutionMode = paramBoolean;
  }
  
  public void setFocusModeDefault()
  {
    String str = getDefaultFocusMode();
    if ((!CameraControl.a().a(str)) && (CameraControl.a().a("auto"))) {
      CameraControl.a().a(null);
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
    while ((paramInt == 1) && (!CameraUtils.d())) {
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
  
  public void startCameraPreview(SurfaceTexture paramSurfaceTexture, Size paramSize)
  {
    AEQLog.b("AECameraManager", "startCameraPreview ENTER---previewTexture=" + paramSurfaceTexture + ", previewSize=" + paramSize);
    if ((paramSurfaceTexture == null) || (paramSize == null) || (Math.min(paramSize.a, paramSize.b) <= 0)) {
      return;
    }
    AELaunchRecorder.a().a("startCameraPreview-begin");
    this.cameraManagerHandler.post(new AECameraManager.5(this, paramSurfaceTexture, paramSize));
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
    if (!CameraUtils.d())
    {
      AEQLog.d("AECameraManager", "toggleCamera---front camera not exists, not support toggle");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager
 * JD-Core Version:    0.7.0.1
 */