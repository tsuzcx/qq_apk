package com.tencent.qqmini.miniapp.widget.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import com.tencent.qqmini.miniapp.util.CameraCompatibleList;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.hardware.Camera.Size;>;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class GlCameraHolderSurfaceView
  extends GlCameraSurfaceView
  implements Camera.AutoFocusCallback, Camera.PreviewCallback
{
  private static final Executor EXECUTOR = ;
  private static final String TAG = "GlCameraHolderSurfaceVi";
  protected Integer backCameraId;
  protected Camera camera;
  protected Camera.Size cameraSize;
  private String flashMode;
  protected Integer frontCameraId;
  protected boolean isBackCameraNow;
  protected boolean isScanMode;
  protected SurfaceTexture mPreviewSt;
  private final AtomicReference<Runnable> task = new AtomicReference();
  
  public GlCameraHolderSurfaceView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GlCameraHolderSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean canFocus()
  {
    return CameraCompatibleList.isFoundProduct(CameraCompatibleList.KEY_NOT_FOCUS_MODEL) ^ true;
  }
  
  private void getCameraInfo()
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int j = Camera.getNumberOfCameras();
    int i = 0;
    while (i < j)
    {
      Camera.getCameraInfo(i, localCameraInfo);
      if (localCameraInfo.facing == 1) {
        this.frontCameraId = Integer.valueOf(i);
      } else if (localCameraInfo.facing == 0) {
        this.backCameraId = Integer.valueOf(i);
      }
      if ((this.frontCameraId != null) && (this.backCameraId != null)) {
        return;
      }
      i += 1;
    }
  }
  
  private String getDefaultFocusMode()
  {
    if (Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
      return "continuous-picture";
    }
    return "continuous-video";
  }
  
  private boolean isSupportFocus(String paramString)
  {
    Object localObject;
    label39:
    do
    {
      try
      {
        localObject = this.camera.getParameters();
        if (localObject == null) {
          break label39;
        }
        localObject = ((Camera.Parameters)localObject).getSupportedFocusModes();
      }
      catch (Exception paramString)
      {
        boolean bool;
        return false;
      }
      bool = ((List)localObject).contains(paramString);
      return bool;
      localObject = null;
    } while (localObject != null);
    return false;
  }
  
  private void setParamsFocusMode(String paramString)
  {
    if (!canFocus()) {
      return;
    }
    try
    {
      this.camera.cancelAutoFocus();
    }
    catch (Exception localException)
    {
      QMLog.i("GlCameraHolderSurfaceVi", "setParamsFocusMode", localException);
    }
    Camera.Parameters localParameters = this.camera.getParameters();
    if (localParameters == null) {
      return;
    }
    String str = localParameters.getFocusMode();
    if ((str != null) && (str.equals(paramString))) {
      return;
    }
    if (!isSupportFocus(paramString)) {
      return;
    }
    localParameters.setFocusMode(paramString);
    try
    {
      this.camera.setParameters(localParameters);
      return;
    }
    catch (Exception paramString)
    {
      QMLog.i("GlCameraHolderSurfaceVi", "setParamsFocusMode", paramString);
    }
  }
  
  protected Camera.Size getSameSize(List<Camera.Size> paramList1, List<Camera.Size> paramList2, List<Camera.Size> paramList3)
  {
    Object localObject = paramList1;
    if (paramList1 == null) {
      localObject = Collections.emptyList();
    }
    paramList1 = paramList2;
    if (paramList2 == null) {
      paramList1 = Collections.emptyList();
    }
    paramList2 = paramList3;
    if (paramList3 == null) {
      paramList2 = Collections.emptyList();
    }
    HashSet localHashSet1 = new HashSet((Collection)localObject);
    HashSet localHashSet2 = new HashSet(paramList2);
    Iterator localIterator = paramList1.iterator();
    paramList2 = null;
    paramList1 = null;
    int i = -1;
    while (localIterator.hasNext())
    {
      paramList3 = (Camera.Size)localIterator.next();
      if ((localHashSet1.contains(paramList3)) && (localHashSet2.contains(paramList3)))
      {
        localObject = paramList2;
        if (paramList3.width * 9 == paramList3.height * 16) {
          if (paramList2 != null)
          {
            localObject = paramList2;
            if (paramList3.width * paramList3.height <= paramList2.width * paramList2.height) {}
          }
          else
          {
            localObject = paramList3;
          }
        }
        int j = paramList3.width * paramList3.height;
        paramList2 = (List<Camera.Size>)localObject;
        if (j > i)
        {
          paramList1 = paramList3;
          i = j;
          paramList2 = (List<Camera.Size>)localObject;
        }
      }
    }
    if (paramList2 != null) {
      return paramList2;
    }
    return paramList1;
  }
  
  protected void init()
  {
    super.init();
    getCameraInfo();
    setBackgroundColor(0);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    setParamsFocusMode(getDefaultFocusMode());
  }
  
  protected void onCameraSurfaceCreate(SurfaceTexture paramSurfaceTexture)
  {
    super.onCameraSurfaceCreate(paramSurfaceTexture);
    this.mPreviewSt = null;
    if (paramSurfaceTexture != null)
    {
      Camera localCamera = this.camera;
      if (localCamera == null) {
        return;
      }
      try
      {
        localCamera.setPreviewTexture(paramSurfaceTexture);
        this.mPreviewSt = paramSurfaceTexture;
        return;
      }
      catch (IOException paramSurfaceTexture)
      {
        Log.w("GlCameraHolderSurfaceVi", "onSurfaceCreate: ", paramSurfaceTexture);
      }
    }
  }
  
  protected void onCodeRead(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCodeRead: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.isScanMode);
    Log.i("GlCameraHolderSurfaceVi", localStringBuilder.toString());
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.isScanMode)
    {
      if (this.task.get() != null) {
        return;
      }
      System.nanoTime();
      paramArrayOfByte = new GlCameraHolderSurfaceView.1(this, paramArrayOfByte);
      if (this.task.compareAndSet(null, paramArrayOfByte)) {
        EXECUTOR.execute(paramArrayOfByte);
      }
    }
  }
  
  protected void releaseCamera()
  {
    Camera localCamera = this.camera;
    if (localCamera == null) {
      return;
    }
    localCamera.stopPreview();
    this.camera.setPreviewCallback(null);
    try
    {
      this.camera.setPreviewDisplay(null);
    }
    catch (IOException localIOException1)
    {
      Log.w("GlCameraHolderSurfaceVi", "releaseCamera: ", localIOException1);
    }
    try
    {
      this.camera.setPreviewTexture(null);
    }
    catch (IOException localIOException2)
    {
      Log.w("GlCameraHolderSurfaceVi", "releaseCamera: ", localIOException2);
    }
    try
    {
      this.camera.setPreviewDisplay(null);
    }
    catch (IOException localIOException3)
    {
      Log.w("GlCameraHolderSurfaceVi", "releaseCamera: ", localIOException3);
    }
    this.camera.release();
    this.camera = null;
  }
  
  public void setFlashMode(String paramString)
  {
    this.flashMode = paramString;
  }
  
  public void setMode(String paramString)
  {
    this.isScanMode = "scanCode".equals(paramString);
  }
  
  protected void setupCamera(int paramInt)
  {
    boolean bool;
    if (paramInt == this.backCameraId.intValue()) {
      bool = true;
    } else {
      bool = false;
    }
    this.isBackCameraNow = bool;
    this.camera = Camera.open(paramInt);
    paramInt = 90;
    if (CameraCompatibleList.isFoundProduct(CameraCompatibleList.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL)) {
      paramInt = 270;
    }
    this.camera.setDisplayOrientation(paramInt);
    Camera.Parameters localParameters = this.camera.getParameters();
    Object localObject2 = localParameters.getSupportedFocusModes();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Collections.emptyList();
    }
    if (((List)localObject1).contains("continuous-picture"))
    {
      Log.i("GlCameraHolderSurfaceVi", "setupCamera: set focus continuous-picture");
      localParameters.setFocusMode("continuous-picture");
    }
    else if (((List)localObject1).contains("auto"))
    {
      Log.i("GlCameraHolderSurfaceVi", "setupCamera: set focus auto");
      localParameters.setFocusMode("auto");
    }
    List localList = localParameters.getSupportedPreviewSizes();
    this.cameraSize = getSameSize(localList, localParameters.getSupportedVideoSizes(), localParameters.getSupportedPictureSizes());
    localObject2 = this.cameraSize;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (localList != null) {
        localObject1 = (Camera.Size)localList.get(0);
      }
    }
    if (localObject1 != null)
    {
      localParameters.setPreviewSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
      localParameters.setPictureSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
    }
    if (this.isBackCameraNow) {
      localParameters.setFlashMode(this.flashMode);
    }
    this.camera.setParameters(localParameters);
    this.camera.setPreviewCallback(this);
  }
  
  public void startPreview()
  {
    this.camera.startPreview();
    try
    {
      this.camera.cancelAutoFocus();
      this.camera.autoFocus(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("GlCameraHolderSurfaceVi", "startPreview: failed auto focus mode", localThrowable);
    }
  }
  
  public void stopPreview()
  {
    Camera localCamera = this.camera;
    if (localCamera != null) {
      localCamera.stopPreview();
    }
  }
  
  public void updateFlashMode()
  {
    Object localObject = this.camera;
    if (localObject == null) {
      return;
    }
    try
    {
      localObject = ((Camera)localObject).getParameters();
      ((Camera.Parameters)localObject).setFlashMode(this.flashMode);
      this.camera.setParameters((Camera.Parameters)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("GlCameraHolderSurfaceVi", "updateFlashMode exception!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.GlCameraHolderSurfaceView
 * JD-Core Version:    0.7.0.1
 */