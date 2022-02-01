package com.tencent.mobileqq.identification;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import androidx.annotation.RequiresApi;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraOperator;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qqconnectface.api.ICamera;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.view.CaptureListener;
import com.tencent.mobileqq.richmedia.capture.view.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.OutPreviewCallback;
import com.tencent.mobileqq.richmedia.capture.view.SizeListener;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

@RequiresApi(api=17)
public class IdentificationCamera
  implements ICamera, Observer
{
  public static final CameraProxy a = new CameraProxy(null, null);
  protected int b = 2;
  protected NewFlowCameraOperator c;
  public CaptureParam d;
  protected CaptureListener e;
  protected SizeListener f;
  
  public Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = new StackBlurManager(paramBitmap).process(15);
    if (localBitmap == null)
    {
      QLog.e("IdentificationCamera", 1, "blurManager.process return null");
      return null;
    }
    int i = CameraControl.a().o();
    paramBitmap = new Matrix();
    paramBitmap.setRotate(i);
    localBitmap = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramBitmap, false);
    paramBitmap.reset();
    paramBitmap.postScale(-1.0F, 1.0F);
    return Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramBitmap, false);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IdentificationCamera", 2, "openCamera");
    }
    a.a(this);
    a.b(this.b);
    NewFlowCameraOperator localNewFlowCameraOperator = this.c;
    if (localNewFlowCameraOperator != null)
    {
      int i = this.b;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      localNewFlowCameraOperator.a(bool);
    }
    com.tencent.mobileqq.activity.richmedia.FlowCameraConstant.b = this.b;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    NewFlowCameraOperator localNewFlowCameraOperator = this.c;
    if (localNewFlowCameraOperator != null) {
      localNewFlowCameraOperator.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, OutPreviewCallback paramOutPreviewCallback, boolean paramBoolean)
  {
    a.a(new CameraControl.CustomSize(this.d.a, this.d.b), new CameraControl.CustomSize(this.d.c, this.d.d), 0, 30, false);
    a.a(paramSurfaceTexture, paramSurfaceHolder, new IdentificationCamera.1(this, paramOutPreviewCallback), paramBoolean);
  }
  
  public void a(CaptureListener paramCaptureListener)
  {
    this.e = paramCaptureListener;
  }
  
  public void a(CaptureParam paramCaptureParam)
  {
    this.d = paramCaptureParam;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCaptureParam : ");
    localStringBuilder.append(paramCaptureParam);
    QLog.d("IdentificationCamera", 1, localStringBuilder.toString());
    this.b = paramCaptureParam.e;
    if ((this.b == 1) && (!CameraUtils.d())) {
      this.b = 2;
    }
    this.c = new NewFlowCameraOperator();
    QmcfManager.getInstance().setCameraMode(this.b);
  }
  
  public void a(SizeListener paramSizeListener)
  {
    this.f = paramSizeListener;
  }
  
  public void a(boolean paramBoolean)
  {
    a.d(paramBoolean);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IdentificationCamera", 2, "stopCamera");
    }
    a.a(false);
    a.b(false);
    a.b(this);
    CameraHelper.a(this.b);
  }
  
  public boolean c()
  {
    return CameraUtils.d();
  }
  
  public Camera d()
  {
    return CameraControl.a().d;
  }
  
  public int e()
  {
    return CameraControl.a().g;
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" notify : eventId = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" ; sender = ");
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append(" ; args = ");
      ((StringBuilder)localObject).append(Arrays.toString(paramVarArgs));
      QLog.d("IdentificationCamera", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 13)
        {
          if (paramInt != 14) {
            return;
          }
          if ((paramVarArgs[0] instanceof CameraControl.CustomSize))
          {
            paramObject = (CameraControl.CustomSize)paramVarArgs[0];
            localObject = this.f;
            if (localObject != null) {
              ((SizeListener)localObject).a(paramObject.a, paramObject.b);
            }
            paramObject = this.e;
            if (paramObject != null) {
              paramObject.a(true, "");
            }
            if ((paramVarArgs.length >= 2) && ((paramVarArgs[1] instanceof CameraControl.CustomSize))) {
              paramObject = (CameraControl.CustomSize)paramVarArgs[1];
            }
          }
          else if ((paramVarArgs[0] instanceof String))
          {
            paramObject = this.e;
            if (paramObject != null)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("[Camera2]setCamera2 Params error:");
              ((StringBuilder)localObject).append(paramVarArgs[0]);
              paramObject.a(false, ((StringBuilder)localObject).toString());
            }
          }
        }
        else if ((paramVarArgs[0] instanceof Integer))
        {
          paramObject = this.e;
          if (paramObject != null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[Camera2]openCamera2 error:");
            ((StringBuilder)localObject).append(paramVarArgs[0]);
            paramObject.a(false, ((StringBuilder)localObject).toString());
          }
        }
      }
      else if ((paramVarArgs[0] instanceof CameraControl.CustomSize))
      {
        paramObject = (CameraControl.CustomSize)paramVarArgs[0];
        paramVarArgs = this.f;
        if (paramVarArgs != null) {
          paramVarArgs.a(paramObject.a, paramObject.b);
        }
        paramObject = this.e;
        if (paramObject != null) {
          paramObject.a(true, "");
        }
      }
      else if ((paramVarArgs[0] instanceof String))
      {
        paramObject = this.e;
        if (paramObject != null) {
          paramObject.a(false, (String)paramVarArgs[0]);
        }
      }
    }
    else if ((paramVarArgs[0] instanceof String))
    {
      paramObject = this.e;
      if (paramObject != null) {
        paramObject.a(false, (String)paramVarArgs[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationCamera
 * JD-Core Version:    0.7.0.1
 */