package com.tencent.qqcamerakit.capture;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.qqcamerakit.capture.camera.CameraControl;
import com.tencent.qqcamerakit.capture.camera2.Camera2Control;
import com.tencent.qqcamerakit.capture.cameraextend.FocusOperator;
import com.tencent.qqcamerakit.capture.cameraextend.FocusOperator.CameraFocusParams;
import com.tencent.qqcamerakit.capture.cameraextend.FrontFlashImpl;
import com.tencent.qqcamerakit.capture.camerastrategy.CameraAPIStrategy;
import com.tencent.qqcamerakit.common.FileUtils;
import com.tencent.qqcamerakit.common.Observer;
import com.tencent.qqcamerakit.common.QLog;

public class CameraManager
  implements CameraProxy.PictureCallback
{
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private CameraHandler jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler;
  private CameraObservable jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable;
  private CameraProxy.PictureCallback jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$PictureCallback;
  private FrontFlashImpl jdField_a_of_type_ComTencentQqcamerakitCaptureCameraextendFrontFlashImpl;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  protected CameraManager(Handler paramHandler, boolean paramBoolean)
  {
    if (jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Camera Handler Thread");
      jdField_a_of_type_AndroidOsHandlerThread.start();
    }
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable = new CameraObservable(paramHandler);
    CameraAPIStrategy.a(paramBoolean);
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler = new CameraHandler(jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable);
  }
  
  private void a(CameraSize paramCameraSize, String paramString, int paramInt, CameraProxy.PictureCallback paramPictureCallback)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$PictureCallback = paramPictureCallback;
    FileUtils.a(paramString);
    paramPictureCallback = new CameraHandler.TakePictureData();
    paramPictureCallback.jdField_a_of_type_JavaLangString = paramString;
    paramPictureCallback.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize = paramCameraSize;
    paramPictureCallback.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$PictureCallback = this;
    paramPictureCallback.jdField_b_of_type_Int = a();
    paramPictureCallback.jdField_a_of_type_Int = paramInt;
    int i;
    if (CameraAPIStrategy.jdField_a_of_type_Boolean) {
      i = 1010;
    } else {
      i = 301;
    }
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.obtainMessage(i, paramPictureCallback).sendToTarget();
    if (QLog.a()) {
      QLog.d("CameraProxy", 2, new Object[] { "takePicture, file = ", paramString, ", orientation = ", Integer.valueOf(paramInt) });
    }
  }
  
  private void a(Exception paramException)
  {
    if (QLog.a()) {
      QLog.d("CameraProxy", 2, new Object[] { "onDispatchThreadException, ", paramException });
    }
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable.a(11, -2, "", new Object[] { paramException });
  }
  
  private void b(SurfaceTexture paramSurfaceTexture, CameraPreviewCallBack paramCameraPreviewCallBack)
  {
    try
    {
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.obtainMessage(1002, new Object[] { paramSurfaceTexture, paramCameraPreviewCallBack }).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      a(paramSurfaceTexture);
    }
  }
  
  private void c()
  {
    try
    {
      if (CameraAPIStrategy.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.obtainMessage(1031).sendToTarget();
        return;
      }
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.obtainMessage(101).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      a(localRuntimeException);
    }
  }
  
  protected int a()
  {
    if (CameraAPIStrategy.jdField_a_of_type_Boolean)
    {
      Camera2Control.a();
      return Camera2Control.jdField_a_of_type_Int;
    }
    return CameraControl.a().jdField_b_of_type_Int;
  }
  
  public Object a()
  {
    if (CameraAPIStrategy.jdField_a_of_type_Boolean) {
      return Camera2Control.a().a();
    }
    return CameraControl.a().a();
  }
  
  public void a()
  {
    try
    {
      if (CameraAPIStrategy.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.obtainMessage(1032).sendToTarget();
        return;
      }
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.obtainMessage(103).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      a(localRuntimeException);
    }
  }
  
  protected void a(int paramInt)
  {
    try
    {
      boolean bool = QLog.a();
      int i = 1;
      if (bool) {
        QLog.d("CameraProxy", 2, new Object[] { "cameraCreate, cameraCreate has created, ", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
      this.jdField_a_of_type_Boolean = true;
      bool = CameraAPIStrategy.jdField_a_of_type_Boolean;
      if (bool) {
        i = 1001;
      }
      try
      {
        this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.obtainMessage(i, paramInt, 0).sendToTarget();
      }
      catch (RuntimeException localRuntimeException)
      {
        a(localRuntimeException);
      }
      return;
    }
    finally {}
  }
  
  protected void a(Activity paramActivity, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraextendFrontFlashImpl = new FrontFlashImpl(paramActivity);
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraextendFrontFlashImpl.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(Matrix paramMatrix, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2)
  {
    FocusOperator.CameraFocusParams localCameraFocusParams = new FocusOperator.CameraFocusParams();
    localCameraFocusParams.jdField_a_of_type_Float = paramFloat1;
    localCameraFocusParams.jdField_b_of_type_Float = paramFloat2;
    localCameraFocusParams.jdField_a_of_type_Int = paramInt2;
    localCameraFocusParams.jdField_b_of_type_Int = paramInt3;
    localCameraFocusParams.c = ((paramInt1 + 45) / 90 * 90);
    a(localCameraFocusParams, paramMatrix, new CameraManager.1(this, paramCameraAutoFocusCallBack));
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.obtainMessage(201, paramSurfaceTexture).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      a(paramSurfaceTexture);
    }
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture, CameraPreviewCallBack paramCameraPreviewCallBack)
  {
    if (CameraAPIStrategy.jdField_a_of_type_Boolean)
    {
      if (paramSurfaceTexture == null)
      {
        this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.a(3, 40, "[Camera2]no surface", new Object[0]);
        return;
      }
      b(paramSurfaceTexture, paramCameraPreviewCallBack);
      return;
    }
    if (paramSurfaceTexture != null) {
      a(paramSurfaceTexture, paramCameraPreviewCallBack, true);
    }
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture, CameraPreviewCallBack paramCameraPreviewCallBack, boolean paramBoolean)
  {
    if (paramSurfaceTexture != null) {
      a(paramSurfaceTexture);
    }
    if (paramCameraPreviewCallBack != null) {
      a(paramCameraPreviewCallBack, paramBoolean);
    }
    try
    {
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      a(paramSurfaceTexture);
    }
  }
  
  protected void a(CameraPreviewCallBack paramCameraPreviewCallBack, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        CameraHandler localCameraHandler = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler;
        if (paramBoolean)
        {
          i = 1;
          localCameraHandler.obtainMessage(203, i, 0, paramCameraPreviewCallBack).sendToTarget();
          return;
        }
      }
      catch (RuntimeException paramCameraPreviewCallBack)
      {
        a(paramCameraPreviewCallBack);
        return;
      }
      int i = 0;
    }
  }
  
  protected void a(CameraSize paramCameraSize1, CameraSize paramCameraSize2, CameraSize paramCameraSize3, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (CameraAPIStrategy.jdField_a_of_type_Boolean)
        {
          i = 1005;
          this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.obtainMessage(i, new Object[] { paramCameraSize1, paramCameraSize2, paramCameraSize3, Integer.valueOf(paramInt) }).sendToTarget();
          return;
        }
      }
      catch (RuntimeException paramCameraSize1)
      {
        a(paramCameraSize1);
        return;
      }
      int i = 3;
    }
  }
  
  protected void a(CameraSize paramCameraSize, boolean paramBoolean, String paramString, int paramInt, CameraProxy.PictureCallback paramPictureCallback)
  {
    if (this.b) {
      c(true);
    }
    if ((!paramBoolean) && (!CameraAPIStrategy.jdField_a_of_type_Boolean))
    {
      a(new FocusOperator.CameraFocusParams(true), null, new CameraManager.2(this, paramCameraSize, paramString, paramInt, paramPictureCallback));
      return;
    }
    a(paramCameraSize, paramString, paramInt, paramPictureCallback);
  }
  
  public void a(FocusOperator.CameraFocusParams paramCameraFocusParams, Matrix paramMatrix, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack)
  {
    for (;;)
    {
      try
      {
        if (CameraAPIStrategy.jdField_a_of_type_Boolean)
        {
          i = 1030;
          paramCameraFocusParams.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$CameraAutoFocusCallBack = paramCameraAutoFocusCallBack;
        }
        else
        {
          paramCameraFocusParams.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$CameraAutoFocusCallBack = paramCameraAutoFocusCallBack;
          if (!paramCameraFocusParams.a()) {
            break label106;
          }
          paramCameraFocusParams.jdField_a_of_type_AndroidGraphicsRect = FocusOperator.a(paramMatrix, paramCameraFocusParams.jdField_a_of_type_Float, paramCameraFocusParams.jdField_b_of_type_Float, paramCameraFocusParams.jdField_a_of_type_Int, paramCameraFocusParams.jdField_b_of_type_Int, 1.0F);
          paramCameraFocusParams.jdField_b_of_type_AndroidGraphicsRect = FocusOperator.a(paramMatrix, paramCameraFocusParams.jdField_a_of_type_Float, paramCameraFocusParams.jdField_b_of_type_Float, paramCameraFocusParams.jdField_a_of_type_Int, paramCameraFocusParams.jdField_b_of_type_Int, 1.5F);
          break label106;
        }
        this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.obtainMessage(i, paramCameraFocusParams).sendToTarget();
        return;
      }
      catch (RuntimeException paramCameraFocusParams)
      {
        a(paramCameraFocusParams);
        return;
      }
      label106:
      int i = 102;
    }
  }
  
  protected void a(Observer paramObserver)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable.a(paramObserver, new int[] { 1, 2, 3, 4, 5, 6, 8, 9, 10 });
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$PictureCallback != null)
    {
      if (this.b) {
        c(false);
      }
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$PictureCallback.a(paramString);
      if (!CameraAPIStrategy.jdField_a_of_type_Boolean) {
        try
        {
          this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.obtainMessage(204).sendToTarget();
          return;
        }
        catch (RuntimeException paramString)
        {
          a(paramString);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    try
    {
      if (!CameraAPIStrategy.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.sendEmptyMessage(205);
        if (paramBoolean)
        {
          this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.a(3500L, "stop preview");
          return;
        }
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      a(localRuntimeException);
    }
  }
  
  public void b()
  {
    try
    {
      if (CameraAPIStrategy.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.obtainMessage(1021).sendToTarget();
        return;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      a(localRuntimeException);
    }
  }
  
  public void b(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (CameraAPIStrategy.jdField_a_of_type_Boolean)
        {
          i = 1040;
          this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.obtainMessage(i, paramInt, 0).sendToTarget();
          return;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        a(localRuntimeException);
        return;
      }
      int i = 601;
    }
  }
  
  protected void b(Observer paramObserver)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable.a(paramObserver);
  }
  
  protected void b(boolean paramBoolean)
  {
    try
    {
      if (QLog.a()) {
        QLog.d("CameraProxy", 2, new Object[] { "cameraDestroyed, cameraCreate has created, ", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
      boolean bool = this.jdField_a_of_type_Boolean;
      if (!bool) {
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      try
      {
        if (CameraAPIStrategy.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.obtainMessage(1003).sendToTarget();
        }
        else
        {
          this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.sendEmptyMessage(2);
          if (paramBoolean) {
            this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler.a(3500L, "release camera");
          }
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        a(localRuntimeException);
      }
      return;
    }
    finally {}
  }
  
  protected void c(boolean paramBoolean)
  {
    int i = a();
    int j = 1;
    if (i == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraextendFrontFlashImpl;
      if ((localObject != null) && (((FrontFlashImpl)localObject).jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraextendFrontFlashImpl.a(paramBoolean);
        return;
      }
    }
    if (CameraAPIStrategy.jdField_a_of_type_Boolean) {
      i = 1050;
    } else {
      i = 401;
    }
    Object localObject = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler;
    if (!paramBoolean) {
      j = 2;
    }
    ((CameraHandler)localObject).obtainMessage(i, j, 0).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.CameraManager
 * JD-Core Version:    0.7.0.1
 */