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
  public static int a;
  private static HandlerThread b;
  private CameraHandler c;
  private CameraObservable d;
  private FrontFlashImpl e;
  private CameraProxy.PictureCallback f;
  private volatile boolean g = false;
  private boolean h = false;
  
  protected CameraManager(Handler paramHandler, boolean paramBoolean)
  {
    if (b == null)
    {
      b = new HandlerThread("Camera Handler Thread");
      b.start();
    }
    this.d = new CameraObservable(paramHandler);
    CameraAPIStrategy.a(paramBoolean);
    this.c = new CameraHandler(b.getLooper(), this.d);
  }
  
  private void a(CameraSize paramCameraSize, String paramString, int paramInt, CameraProxy.PictureCallback paramPictureCallback)
  {
    this.f = paramPictureCallback;
    FileUtils.a(paramString);
    paramPictureCallback = new CameraHandler.TakePictureData();
    paramPictureCallback.a = paramString;
    paramPictureCallback.b = paramCameraSize;
    paramPictureCallback.c = this;
    paramPictureCallback.e = c();
    paramPictureCallback.d = paramInt;
    int i;
    if (CameraAPIStrategy.a) {
      i = 1010;
    } else {
      i = 301;
    }
    this.c.obtainMessage(i, paramPictureCallback).sendToTarget();
    if (QLog.a()) {
      QLog.d("CameraProxy", 2, new Object[] { "takePicture, file = ", paramString, ", orientation = ", Integer.valueOf(paramInt) });
    }
  }
  
  private void a(Exception paramException)
  {
    if (QLog.a()) {
      QLog.d("CameraProxy", 2, new Object[] { "onDispatchThreadException, ", paramException });
    }
    this.d.a(11, -2, "", new Object[] { paramException });
  }
  
  private void b(SurfaceTexture paramSurfaceTexture, CameraPreviewCallBack paramCameraPreviewCallBack)
  {
    try
    {
      this.c.obtainMessage(1002, new Object[] { paramSurfaceTexture, paramCameraPreviewCallBack }).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      a(paramSurfaceTexture);
    }
  }
  
  private void e()
  {
    try
    {
      if (CameraAPIStrategy.a)
      {
        this.c.obtainMessage(1031).sendToTarget();
        return;
      }
      this.c.obtainMessage(101).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      a(localRuntimeException);
    }
  }
  
  public void a()
  {
    try
    {
      if (CameraAPIStrategy.a)
      {
        this.c.obtainMessage(1032).sendToTarget();
        return;
      }
      this.c.obtainMessage(103).sendToTarget();
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
        QLog.d("CameraProxy", 2, new Object[] { "cameraCreate, cameraCreate has created, ", Boolean.valueOf(this.g) });
      }
      this.g = true;
      bool = CameraAPIStrategy.a;
      if (bool) {
        i = 1001;
      }
      try
      {
        this.c.obtainMessage(i, paramInt, 0).sendToTarget();
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
    this.e = new FrontFlashImpl(paramActivity);
    this.e.a = paramBoolean;
  }
  
  public void a(Matrix paramMatrix, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2)
  {
    FocusOperator.CameraFocusParams localCameraFocusParams = new FocusOperator.CameraFocusParams();
    localCameraFocusParams.a = paramFloat1;
    localCameraFocusParams.b = paramFloat2;
    localCameraFocusParams.c = paramInt2;
    localCameraFocusParams.d = paramInt3;
    localCameraFocusParams.e = ((paramInt1 + 45) / 90 * 90);
    a(localCameraFocusParams, paramMatrix, new CameraManager.1(this, paramCameraAutoFocusCallBack));
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.c.obtainMessage(201, paramSurfaceTexture).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      a(paramSurfaceTexture);
    }
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture, CameraPreviewCallBack paramCameraPreviewCallBack)
  {
    if (CameraAPIStrategy.a)
    {
      if (paramSurfaceTexture == null)
      {
        this.c.a(3, 40, "[Camera2]no surface", new Object[0]);
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
      this.c.obtainMessage(204).sendToTarget();
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
        CameraHandler localCameraHandler = this.c;
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
  
  protected void a(CameraSize paramCameraSize1, CameraSize paramCameraSize2, CameraSize paramCameraSize3, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      Object[] arrayOfObject;
      try
      {
        if (CameraAPIStrategy.a)
        {
          i = 1005;
          arrayOfObject = new Object[5];
          arrayOfObject[0] = paramCameraSize1;
          arrayOfObject[1] = paramCameraSize2;
          arrayOfObject[2] = paramCameraSize3;
          arrayOfObject[3] = Integer.valueOf(paramInt1);
          if (!CameraAPIStrategy.a) {
            break label95;
          }
          arrayOfObject[4] = Integer.valueOf(paramInt2);
          a = paramInt3;
          this.c.obtainMessage(i, arrayOfObject).sendToTarget();
          return;
        }
      }
      catch (RuntimeException paramCameraSize1)
      {
        a(paramCameraSize1);
        return;
      }
      int i = 3;
      continue;
      label95:
      arrayOfObject[4] = paramString;
    }
  }
  
  protected void a(CameraSize paramCameraSize, boolean paramBoolean, String paramString, int paramInt, CameraProxy.PictureCallback paramPictureCallback)
  {
    if (this.h) {
      c(true);
    }
    if ((!paramBoolean) && (!CameraAPIStrategy.a))
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
        if (CameraAPIStrategy.a)
        {
          i = 1030;
          paramCameraFocusParams.g = paramCameraAutoFocusCallBack;
        }
        else
        {
          paramCameraFocusParams.g = paramCameraAutoFocusCallBack;
          if (!paramCameraFocusParams.a()) {
            break label106;
          }
          paramCameraFocusParams.h = FocusOperator.a(paramMatrix, paramCameraFocusParams.a, paramCameraFocusParams.b, paramCameraFocusParams.c, paramCameraFocusParams.d, 1.0F);
          paramCameraFocusParams.i = FocusOperator.a(paramMatrix, paramCameraFocusParams.a, paramCameraFocusParams.b, paramCameraFocusParams.c, paramCameraFocusParams.d, 1.5F);
          break label106;
        }
        this.c.obtainMessage(i, paramCameraFocusParams).sendToTarget();
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
    this.d.a(paramObserver, new int[] { 1, 2, 3, 4, 5, 6, 8, 9, 10 });
  }
  
  public void a(String paramString)
  {
    if (this.f != null)
    {
      if (this.h) {
        c(false);
      }
      this.f.a(paramString);
      if (!CameraAPIStrategy.a) {
        try
        {
          this.c.obtainMessage(204).sendToTarget();
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
      if (!CameraAPIStrategy.a)
      {
        this.c.sendEmptyMessage(205);
        if (paramBoolean)
        {
          this.c.a(3500L, "stop preview");
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
      if (CameraAPIStrategy.a)
      {
        this.c.obtainMessage(1021).sendToTarget();
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
        if (CameraAPIStrategy.a)
        {
          i = 1040;
          this.c.obtainMessage(i, paramInt, 0).sendToTarget();
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
    this.d.a(paramObserver);
  }
  
  protected void b(boolean paramBoolean)
  {
    try
    {
      if (QLog.a()) {
        QLog.d("CameraProxy", 2, new Object[] { "cameraDestroyed, cameraCreate has created, ", Boolean.valueOf(this.g) });
      }
      boolean bool = this.g;
      if (!bool) {
        return;
      }
      this.g = false;
      try
      {
        if (CameraAPIStrategy.a)
        {
          this.c.obtainMessage(1003).sendToTarget();
        }
        else
        {
          this.c.sendEmptyMessage(2);
          if (paramBoolean) {
            this.c.a(3500L, "release camera");
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
  
  protected int c()
  {
    if (CameraAPIStrategy.a)
    {
      Camera2Control.a();
      return Camera2Control.b;
    }
    return CameraControl.a().d;
  }
  
  protected void c(boolean paramBoolean)
  {
    int i = c();
    int j = 1;
    if (i == 1)
    {
      localObject = this.e;
      if ((localObject != null) && (((FrontFlashImpl)localObject).a))
      {
        this.e.a(paramBoolean);
        return;
      }
    }
    if (CameraAPIStrategy.a) {
      i = 1050;
    } else {
      i = 401;
    }
    Object localObject = this.c;
    if (!paramBoolean) {
      j = 2;
    }
    ((CameraHandler)localObject).obtainMessage(i, j, 0).sendToTarget();
  }
  
  public Object d()
  {
    if (CameraAPIStrategy.a) {
      return Camera2Control.a().o();
    }
    return CameraControl.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.CameraManager
 * JD-Core Version:    0.7.0.1
 */