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
  public static final CameraProxy a;
  protected int a;
  protected NewFlowCameraOperator a;
  protected CaptureListener a;
  public CaptureParam a;
  protected SizeListener a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = new CameraProxy(null, null);
  }
  
  public IdentificationCamera()
  {
    this.jdField_a_of_type_Int = 2;
  }
  
  public int a()
  {
    return CameraControl.a().jdField_a_of_type_Int;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = new StackBlurManager(paramBitmap).process(15);
    if (localBitmap == null)
    {
      QLog.e("IdentificationCamera", 1, "blurManager.process return null");
      return null;
    }
    int i = CameraControl.a().b();
    paramBitmap = new Matrix();
    paramBitmap.setRotate(i);
    localBitmap = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramBitmap, false);
    paramBitmap.reset();
    paramBitmap.postScale(-1.0F, 1.0F);
    return Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramBitmap, false);
  }
  
  public Camera a()
  {
    return CameraControl.a().jdField_a_of_type_AndroidHardwareCamera;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IdentificationCamera", 2, "openCamera");
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(this);
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(this.jdField_a_of_type_Int);
    NewFlowCameraOperator localNewFlowCameraOperator = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
    if (localNewFlowCameraOperator != null)
    {
      int i = this.jdField_a_of_type_Int;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      localNewFlowCameraOperator.a(bool);
    }
    com.tencent.mobileqq.activity.richmedia.FlowCameraConstant.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    NewFlowCameraOperator localNewFlowCameraOperator = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
    if (localNewFlowCameraOperator != null) {
      localNewFlowCameraOperator.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, OutPreviewCallback paramOutPreviewCallback, boolean paramBoolean)
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraControl.CustomSize(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureParam.b), new CameraControl.CustomSize(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureParam.c, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureParam.d), 0, 30, false);
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(paramSurfaceTexture, paramSurfaceHolder, new IdentificationCamera.1(this, paramOutPreviewCallback), paramBoolean);
  }
  
  public void a(CaptureListener paramCaptureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureListener = paramCaptureListener;
  }
  
  public void a(CaptureParam paramCaptureParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureParam = paramCaptureParam;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCaptureParam : ");
    localStringBuilder.append(paramCaptureParam);
    QLog.d("IdentificationCamera", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Int = paramCaptureParam.e;
    if ((this.jdField_a_of_type_Int == 1) && (!CameraUtils.d())) {
      this.jdField_a_of_type_Int = 2;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator = new NewFlowCameraOperator();
    QmcfManager.getInstance().setCameraMode(this.jdField_a_of_type_Int);
  }
  
  public void a(SizeListener paramSizeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSizeListener = paramSizeListener;
  }
  
  public void a(boolean paramBoolean)
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.d(paramBoolean);
  }
  
  public boolean a()
  {
    return CameraUtils.d();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IdentificationCamera", 2, "stopCamera");
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(false);
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(false);
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(this);
    CameraHelper.a(this.jdField_a_of_type_Int);
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
            localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSizeListener;
            if (localObject != null) {
              ((SizeListener)localObject).a(paramObject.jdField_a_of_type_Int, paramObject.b);
            }
            paramObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureListener;
            if (paramObject != null) {
              paramObject.a(true, "");
            }
            if ((paramVarArgs.length >= 2) && ((paramVarArgs[1] instanceof CameraControl.CustomSize))) {
              paramObject = (CameraControl.CustomSize)paramVarArgs[1];
            }
          }
          else if ((paramVarArgs[0] instanceof String))
          {
            paramObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureListener;
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
          paramObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureListener;
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
        paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSizeListener;
        if (paramVarArgs != null) {
          paramVarArgs.a(paramObject.jdField_a_of_type_Int, paramObject.b);
        }
        paramObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureListener;
        if (paramObject != null) {
          paramObject.a(true, "");
        }
      }
      else if ((paramVarArgs[0] instanceof String))
      {
        paramObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureListener;
        if (paramObject != null) {
          paramObject.a(false, (String)paramVarArgs[0]);
        }
      }
    }
    else if ((paramVarArgs[0] instanceof String))
    {
      paramObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureListener;
      if (paramObject != null) {
        paramObject.a(false, (String)paramVarArgs[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationCamera
 * JD-Core Version:    0.7.0.1
 */