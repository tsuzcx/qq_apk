package com.tencent.mobileqq.mini.widget.media;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import bbua;
import bbub;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.hardware.Camera.Size;>;
import java.util.Set;

public class CameraSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private static final String TAG = "CameraSurfaceView";
  public static int cameraHeight;
  public static int cameraWidth;
  protected static Camera mCamera;
  protected static Camera.Size sCameraSize;
  protected Integer backCameraId;
  CameraSurfaceView.CloseCameraRunnable closeCamera = new CameraSurfaceView.CloseCameraRunnable(this);
  protected Integer frontCameraId;
  protected boolean isBackCameraNow;
  public CameraSurfaceView.CameraSurfaceViewCallBack mCallBack;
  Display mDisplay = null;
  boolean mIsCameraOpened = false;
  boolean mIsSurfaceCreated = false;
  Camera.PreviewCallback mPreviewCallback = null;
  protected WeakReference<WebviewContainer> mWcRef;
  Camera.AutoFocusCallback myAutoFocusCallback = new CameraSurfaceView.1(this);
  CameraSurfaceView.OpenCameraRunnable openCamera = new CameraSurfaceView.OpenCameraRunnable(this);
  public int videoFormat = 17;
  
  static
  {
    if (!CameraSurfaceView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cameraWidth = 320;
      cameraHeight = 240;
      return;
    }
  }
  
  public CameraSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public CameraSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public CameraSurfaceView(Context paramContext, WebviewContainer paramWebviewContainer)
  {
    super(paramContext);
    init();
    this.mWcRef = new WeakReference(paramWebviewContainer);
  }
  
  private void getCameraInfo()
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int j = Camera.getNumberOfCameras();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Camera.getCameraInfo(i, localCameraInfo);
        if (localCameraInfo.facing != 1) {
          break label55;
        }
        this.frontCameraId = Integer.valueOf(i);
      }
      while ((this.frontCameraId != null) && (this.backCameraId != null))
      {
        return;
        label55:
        if (localCameraInfo.facing == 0) {
          this.backCameraId = Integer.valueOf(i);
        }
      }
      i += 1;
    }
  }
  
  private String getDefaultFocusMode()
  {
    String str2 = "continuous-video";
    String str1 = str2;
    if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
    {
      str1 = str2;
      if (Build.VERSION.SDK_INT >= 14) {
        str1 = "continuous-picture";
      }
    }
    return str1;
  }
  
  private Camera.Size getOptimalPreviewSize(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    if (paramList == null) {
      return null;
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Camera.Size)((Iterator)localObject1).next();
      if ((((Camera.Size)localObject2).width == paramInt1) && (((Camera.Size)localObject2).height == paramInt2)) {
        return localObject2;
      }
    }
    double d3 = paramInt1 / paramInt2;
    localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    Iterator localIterator = paramList.iterator();
    double d2;
    if (localIterator.hasNext())
    {
      localObject2 = (Camera.Size)localIterator.next();
      if (((paramInt1 > paramInt2) && (((Camera.Size)localObject2).width > ((Camera.Size)localObject2).height)) || ((paramInt1 < paramInt2) && (((Camera.Size)localObject2).width < ((Camera.Size)localObject2).height)))
      {
        d2 = ((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height;
        label153:
        if (Math.abs(d2 - d3) > 0.05D) {
          break label221;
        }
        if (Math.abs(((Camera.Size)localObject2).height - paramInt2) >= d1) {
          break label313;
        }
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt2);
        localObject1 = localObject2;
      }
    }
    label307:
    label313:
    for (;;)
    {
      break;
      d2 = ((Camera.Size)localObject2).height / ((Camera.Size)localObject2).width;
      break label153;
      label221:
      break;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        d1 = 1.7976931348623157E+308D;
        localIterator = paramList.iterator();
        localObject2 = localObject1;
        if (localIterator.hasNext())
        {
          paramList = (Camera.Size)localIterator.next();
          if (Math.abs(paramList.height - paramInt2) >= d1) {
            break label307;
          }
          d1 = Math.abs(paramList.height - paramInt2);
        }
      }
      for (;;)
      {
        localObject1 = paramList;
        break;
        return localObject2;
        paramList = (List<Camera.Size>)localObject1;
      }
    }
  }
  
  private Camera.Size getSameSize(List<Camera.Size> paramList1, List<Camera.Size> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null))
    {
      paramList2 = null;
      return paramList2;
    }
    HashSet localHashSet = new HashSet(paramList1);
    Iterator localIterator = paramList2.iterator();
    paramList1 = null;
    int i = -1;
    for (;;)
    {
      paramList2 = paramList1;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList2 = (Camera.Size)localIterator.next();
      if (localHashSet.contains(paramList2))
      {
        int j = paramList2.width * paramList2.height;
        if (j > i)
        {
          i = j;
          paramList1 = paramList2;
        }
      }
    }
  }
  
  private void init()
  {
    this.mIsSurfaceCreated = false;
    this.isBackCameraNow = true;
    setBackgroundColor(0);
    getHolder().addCallback(this);
    getCameraInfo();
  }
  
  boolean canFocus()
  {
    return !bbub.d(bbub.a);
  }
  
  public void closeCamera()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSurfaceView", 2, "closeCamera");
    }
    ThreadManagerV2.excute(this.closeCamera, 16, null, true);
  }
  
  public void openCamera()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSurfaceView", 2, "openCamera");
    }
    ThreadManagerV2.excute(this.openCamera, 16, null, true);
  }
  
  public boolean setCameraParameters(Camera.Parameters paramParameters)
  {
    if (paramParameters == null) {
      return false;
    }
    try
    {
      mCamera.setParameters(paramParameters);
      return true;
    }
    catch (Exception paramParameters) {}
    return false;
  }
  
  public void setCameraSurfaceCallBack(CameraSurfaceView.CameraSurfaceViewCallBack paramCameraSurfaceViewCallBack)
  {
    this.mCallBack = paramCameraSurfaceViewCallBack;
  }
  
  public void setDisplay(Display paramDisplay)
  {
    this.mDisplay = paramDisplay;
  }
  
  public boolean setParamsFocusMode(String paramString)
  {
    boolean bool2 = false;
    assert (this.mCallBack != null);
    boolean bool1;
    if (!canFocus()) {
      bool1 = bool2;
    }
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          try
          {
            mCamera.cancelAutoFocus();
            Camera.Parameters localParameters = mCamera.getParameters();
            bool1 = bool2;
            if (localParameters != null)
            {
              String str = localParameters.getFocusMode();
              if ((str != null) && (str.equals(paramString))) {
                return true;
              }
            }
          }
          catch (RuntimeException localRuntimeException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("CameraSurfaceView", 2, "", localRuntimeException);
              }
            }
            bool1 = bool2;
          }
        }
      } while (!bbua.a().a(paramString));
      localRuntimeException.setFocusMode(paramString);
      bool2 = setCameraParameters(localRuntimeException);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("CameraSurfaceView", 2, "[@] setParamsFocusMode isSupportFocus=true  success=" + bool2);
    return bool2;
  }
  
  public void setPreviewCallback(Camera.PreviewCallback paramPreviewCallback)
  {
    this.mPreviewCallback = paramPreviewCallback;
  }
  
  @TargetApi(9)
  public void startPreview()
  {
    if ((this.backCameraId == null) && (this.frontCameraId == null)) {
      if (this.mCallBack != null) {
        this.mCallBack.onStartPreview(false);
      }
    }
    while ((!this.mIsSurfaceCreated) || (this.mIsCameraOpened)) {
      return;
    }
    int i;
    if (mCamera == null)
    {
      if ((!this.isBackCameraNow) || (this.backCameraId == null)) {
        break label370;
      }
      i = this.backCameraId.intValue();
    }
    for (;;)
    {
      try
      {
        mCamera = Camera.open(i);
        i = 90;
        if (bbub.d(bbub.g)) {
          i = 270;
        }
        mCamera.setDisplayOrientation(i);
        localParameters = mCamera.getParameters();
        if (Build.VERSION.SDK_INT <= 10) {
          continue;
        }
        localList = localParameters.getSupportedPreviewSizes();
        sCameraSize = getSameSize(localList, localParameters.getSupportedVideoSizes());
      }
      catch (Exception localException1)
      {
        Camera.Parameters localParameters;
        List localList;
        Camera.Size localSize2;
        Camera.Size localSize1;
        label370:
        localException1.printStackTrace();
        continue;
        Object localObject = null;
        continue;
      }
      localSize2 = sCameraSize;
      localSize1 = localSize2;
      if (localSize2 == null)
      {
        localSize1 = localSize2;
        if (localList != null) {
          localSize1 = (Camera.Size)localList.get(0);
        }
      }
      if (localSize1 != null)
      {
        localParameters.setPreviewSize(localSize1.width, localSize1.height);
        localParameters.setPictureSize(localSize1.width, localSize1.height);
        if (QLog.isColorLevel()) {
          QLog.i("CameraSurfaceView", 2, "previewSize w h " + localSize1.width + " " + localSize1.height);
        }
      }
      if (localParameters.getSupportedFocusModes().contains("continuous-video")) {
        localParameters.setFocusMode("continuous-video");
      }
      localParameters.setFlashMode("auto");
      mCamera.setParameters(localParameters);
      this.videoFormat = localParameters.getPreviewFormat();
      if (mCamera != null) {}
      try
      {
        mCamera.setPreviewDisplay(getHolder());
        if (this.mPreviewCallback != null) {
          mCamera.setPreviewCallback(this.mPreviewCallback);
        }
        mCamera.startPreview();
        mCamera.autoFocus(this.myAutoFocusCallback);
        this.mIsCameraOpened = true;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        this.mIsCameraOpened = false;
        continue;
      }
      if (this.mCallBack == null) {
        break;
      }
      this.mCallBack.onStartPreview(this.mIsCameraOpened);
      return;
      i = this.frontCameraId.intValue();
      this.isBackCameraNow = false;
    }
  }
  
  public void stopPreview(boolean paramBoolean)
  {
    if (mCamera == null) {}
    for (;;)
    {
      return;
      try
      {
        mCamera.setPreviewCallback(null);
        mCamera.stopPreview();
        this.mIsCameraOpened = false;
        if ((!paramBoolean) && (this.mIsSurfaceCreated)) {
          continue;
        }
        try
        {
          mCamera.setPreviewDisplay(null);
          mCamera.release();
          mCamera = null;
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.i("CameraSurfaceView", "surfaceChanged: ");
    if (this.mWcRef == null) {}
    do
    {
      do
      {
        return;
        paramSurfaceHolder = (WebviewContainer)this.mWcRef.get();
      } while (paramSurfaceHolder == null);
      paramSurfaceHolder = paramSurfaceHolder.appBrandRuntime;
    } while ((paramSurfaceHolder == null) || (paramSurfaceHolder.isPause));
    startPreview();
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    Log.i("CameraSurfaceView", "surfaceCreated: ");
    this.mIsSurfaceCreated = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    Log.i("CameraSurfaceView", "surfaceDestroyed: ");
    this.mIsSurfaceCreated = false;
    closeCamera();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.CameraSurfaceView
 * JD-Core Version:    0.7.0.1
 */