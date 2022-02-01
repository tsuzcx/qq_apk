package com.tencent.mobileqq.shortvideo.mediadevice;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.Camera2Info;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.Camera2Listener;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.Camera2PictureData;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Utils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class CameraProxy$Camera2Handler
  extends Handler
  implements Camera.AutoFocusCallback
{
  CameraProxy$Camera2Handler(CameraProxy paramCameraProxy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(14)
  private void a(Rect paramRect1, Rect paramRect2, Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS");
    }
    Camera.Parameters localParameters = CameraControl.a().a();
    if ((Build.VERSION.SDK_INT >= 14) && (paramRect1 != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage] focus area = " + paramRect1);
      }
      localParameters.setFocusMode("auto");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new Camera.Area(paramRect1, 1000));
      localParameters.setFocusAreas(localArrayList);
      if ((localParameters.getMaxNumMeteringAreas() > 0) && (paramRect2 != null))
      {
        paramRect1 = new ArrayList(1);
        paramRect1.add(new Camera.Area(new Rect(paramRect2), 1000));
        localParameters.setMeteringAreas(paramRect1);
      }
      CameraControl.a().jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
    }
    paramRect1 = paramAutoFocusCallback;
    if (paramAutoFocusCallback == null) {
      paramRect1 = new CameraProxy.Camera2Handler.1(this);
    }
    CameraControl.a().a(paramRect1);
  }
  
  public String a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[@] getDefaultFocusMode: Build.MANUFACTURER=" + Build.MANUFACTURER + "VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.VERSION.SDK_INT >= 14)) {}
    return "continuous-picture";
  }
  
  public String b()
  {
    String str2 = "continuous-video";
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[@] getRecordingFocusMode: Build.MANUFACTURER=" + Build.MANUFACTURER + "VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
    }
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
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool2 = false;
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      try
      {
        throw new RuntimeException("Unimplemented CameraProxy message=" + paramMessage.what);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[Camera2Handler.handleMessage]", localException);
        }
        return;
        AEQLog.b("CameraProxy", "[handleMessage] OPEN_CAMERA + BEGIN");
        i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage] OPEN_CAMERA");
        }
        i = CameraControl.a().a(i);
        AEQLog.b("CameraProxy", "[handleMessage] OPEN_CAMERA, result = " + i);
        if (i == 5)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(1, new Object[] { Boolean.valueOf(true) });
          return;
        }
        if (i != 0)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(1, new Object[] { "open camera failed:errcode=" + CameraControl.a(i) });
          return;
        }
        if (!CameraControl.a().c())
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(1, new Object[] { "open camera failed, orientation error." });
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(1, new Object[] { Boolean.valueOf(true) });
        this.a.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]CHANGED");
        }
        int k = Integer.parseInt(paramMessage.obj.toString());
        i = paramMessage.arg1;
        j = paramMessage.arg2;
        this.a.jdField_a_of_type_Boolean = false;
        CameraProxy.a(this.a, false);
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[@] surfaceChanged start, format = " + k + ",width = " + i + ",height = " + j);
        }
        if ((this.a.jdField_b_of_type_Int <= 0) || (i <= this.a.jdField_b_of_type_Int)) {
          break label5339;
        }
        i = this.a.jdField_b_of_type_Int;
        if ((this.a.jdField_c_of_type_Int <= 0) || (j <= this.a.jdField_c_of_type_Int)) {
          break label5336;
        }
        j = this.a.jdField_c_of_type_Int;
        localObject7 = CameraControl.a();
        if (Build.VERSION.SDK_INT <= 10) {
          CameraControl.a().b();
        }
        if (this.a.jdField_a_of_type_Int == 1)
        {
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache;
          if (((CameraProxy.ParamCache)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            continue;
          }
          if (!CameraControl.a().e()) {
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed" });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 3)
          {
            if (FlowCameraConstant.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache;
              continue;
            }
            if (FlowCameraConstant.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache;
              continue;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 2)
          {
            if (FlowCameraConstant.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.e;
              continue;
            }
            if (FlowCameraConstant.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.d;
              continue;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed[Camera Kind error:RATIO_SCREEN]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 4)
          {
            if (FlowCameraConstant.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.g;
              continue;
            }
            if (FlowCameraConstant.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.f;
              continue;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 5)
          {
            localObject1 = this.a.h;
            continue;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed[Preview Selector Error]" });
          return;
        }
        localObject6 = null;
        if ((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 3) || (this.a.jdField_a_of_type_Int == 4))
        {
          localObject6 = ((CameraControl)localObject7).c(CodecParam.DST_VIDEO_WIDTH, CodecParam.DST_VIDEO_HEIGHT, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
          localObject5 = localObject6[0];
          localObject6 = localObject6[1];
          if (localObject5 == null) {
            break label5330;
          }
          bool1 = CameraControl.a().a((CameraControl.CustomSize)localObject5);
          break label5342;
          if (!bool1) {
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview size failed" + (String)localObject5 });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 2)
          {
            localObject5 = ((CameraControl)localObject7).a(CodecParam.DST_VIDEO_WIDTH, CodecParam.DST_VIDEO_HEIGHT, i, j);
            bool1 = bool4;
            if (localObject5 == null) {
              break label5350;
            }
            bool1 = CameraControl.a().a((CameraControl.CustomSize)localObject5);
            break label5350;
          }
          if (this.a.jdField_a_of_type_Int != 5) {
            break label5366;
          }
          if ((Build.MANUFACTURER.equals("Xiaomi")) && (Build.MODEL.equals("MI 3")))
          {
            localObject5 = new CameraControl.CustomSize();
            ((CameraControl.CustomSize)localObject5).jdField_a_of_type_Int = 640;
            ((CameraControl.CustomSize)localObject5).jdField_b_of_type_Int = 480;
            bool1 = bool5;
            if (localObject5 == null) {
              break label5358;
            }
            bool1 = CameraControl.a().a((CameraControl.CustomSize)localObject5);
            break label5358;
          }
          localObject5 = ((CameraControl)localObject7).a(480);
          continue;
        }
        if (!CameraControl.a().a(CodecParam.VIDEO_FPS))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview fps failed" });
          return;
        }
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5) && (localObject6 != null) && (!((CameraControl)localObject7).b((CameraControl.CustomSize)localObject6))) {}
        ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_Int = CameraControl.a().a();
        ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = CameraControl.a().a();
        localObject5 = CameraControl.a().b();
        if (localObject5 != null)
        {
          ((CameraProxy.ParamCache)localObject1).jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = ((CameraControl.CustomSize)localObject5);
          ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_Boolean = true;
        }
        localObject5 = CameraControl.a().a();
        ((CameraProxy.ParamCache)localObject1).jdField_b_of_type_Int = localObject5[0];
        ((CameraProxy.ParamCache)localObject1).jdField_c_of_type_Int = localObject5[1];
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 3) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5))
        {
          ((CameraProxy.ParamCache)localObject1).jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = CameraControl.a().b();
          ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_Boolean = true;
        }
        if (this.a.jdField_a_of_type_Int == 4) {
          ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_Boolean = false;
        }
        ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
        Object localObject1 = a();
        if ((!CameraControl.a().a((String)localObject1)) && (!CameraControl.a().a("auto")) && (!CameraControl.a().a(this))) {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(9, new Object[] { HardCodeUtil.a(2131701403) });
        }
        if (!CameraControl.a().c())
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set display orientation failed" });
          return;
          if (!CameraControl.a().a((CameraProxy.ParamCache)localObject1))
          {
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set Camera Params failed" });
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("CameraProxy", 2, "[handleMessage]Set camera param by cache params");
          continue;
        }
      }
      finally
      {
        CameraProxy.WaitDoneBundle.a(paramMessage);
      }
      Object localObject3 = CameraControl.a().a();
      int i = CameraControl.a().a();
      Object localObject5 = CameraControl.a().a();
      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
      continue;
      localObject3 = (Object[])paramMessage.obj;
      localObject5 = (CameraControl.CustomSize)localObject3[0];
      Object localObject7 = (CameraControl.CustomSize)localObject3[1];
      i = ((Integer)localObject3[2]).intValue();
      int j = ((Integer)localObject3[3]).intValue();
      bool2 = ((Boolean)localObject3[4]).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage] SET_PARAMS, , wantedSize = " + localObject5 + " , viewSize = " + localObject7 + " , selectMode = " + i + " , resolutionMode = " + bool2);
      }
      this.a.jdField_a_of_type_Boolean = false;
      CameraProxy.a(this.a, false);
      Object localObject6 = CameraControl.a();
      Object localObject8 = CameraControl.a().jdField_a_of_type_Int + "#" + localObject5 + "#" + localObject7 + "#" + i;
      localObject3 = (CameraProxy.ParamCache)this.a.jdField_a_of_type_JavaUtilMap.get(localObject8);
      if (localObject3 == null)
      {
        localObject3 = new CameraProxy.ParamCache();
        this.a.jdField_a_of_type_JavaUtilMap.put(localObject8, localObject3);
      }
      for (;;)
      {
        for (;;)
        {
          if (!((CameraProxy.ParamCache)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            if (!CameraControl.a().e())
            {
              this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed" });
              CameraProxy.WaitDoneBundle.a(paramMessage);
              return;
            }
            if (!bool2) {}
            for (localObject5 = ((CameraControl)localObject6).a(((CameraControl.CustomSize)localObject5).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject5).jdField_b_of_type_Int, ((CameraControl.CustomSize)localObject7).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject7).jdField_b_of_type_Int);; localObject5 = ((CameraControl)localObject6).b(((CameraControl.CustomSize)localObject5).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject5).jdField_b_of_type_Int, ((CameraControl.CustomSize)localObject7).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject7).jdField_b_of_type_Int))
            {
              localObject7 = localObject5[0];
              localObject5 = localObject5[1];
              if (localObject7 != null) {
                bool1 = CameraControl.a().a((CameraControl.CustomSize)localObject7);
              }
              if (bool1) {
                break;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview size failed" + "" });
              CameraProxy.WaitDoneBundle.a(paramMessage);
              return;
            }
            if (((localObject5 == null) || (((CameraControl)localObject6).b((CameraControl.CustomSize)localObject5))) || (!CameraControl.a().a(j)))
            {
              this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview fps failed" });
              CameraProxy.WaitDoneBundle.a(paramMessage);
              return;
            }
            ((CameraProxy.ParamCache)localObject3).jdField_a_of_type_Int = CameraControl.a().a();
            ((CameraProxy.ParamCache)localObject3).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = CameraControl.a().a();
            localObject5 = CameraControl.a().b();
            if (localObject5 != null)
            {
              ((CameraProxy.ParamCache)localObject3).jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = ((CameraControl.CustomSize)localObject5);
              ((CameraProxy.ParamCache)localObject3).jdField_a_of_type_Boolean = true;
            }
            localObject5 = CameraControl.a().a();
            ((CameraProxy.ParamCache)localObject3).jdField_b_of_type_Int = localObject5[0];
            ((CameraProxy.ParamCache)localObject3).jdField_c_of_type_Int = localObject5[1];
            ((CameraProxy.ParamCache)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
          }
          for (;;)
          {
            localObject3 = a();
            if ((!CameraControl.a().a((String)localObject3)) && (!CameraControl.a().a("auto")) && (!CameraControl.a().a(this))) {
              this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(9, new Object[] { HardCodeUtil.a(2131701400) });
            }
            if (CameraControl.a().c()) {
              break;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set display orientation failed" });
            CameraProxy.WaitDoneBundle.a(paramMessage);
            return;
            if (!CameraControl.a().a((CameraProxy.ParamCache)localObject3))
            {
              this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set Camera Params failed" });
              CameraProxy.WaitDoneBundle.a(paramMessage);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] Set camera param by cache params");
            }
          }
          localObject3 = CameraControl.a().a();
          i = CameraControl.a().a();
          localObject5 = CameraControl.a().a();
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_DEFAULT");
          }
          localObject3 = a();
          if ((CameraControl.a().a((String)localObject3)) || (CameraControl.a().a("auto")) || (CameraControl.a().a(this))) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(9, new Object[] { HardCodeUtil.a(2131701402) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_AUTO");
          }
          if (CameraControl.a().a("auto")) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(9, new Object[] { HardCodeUtil.a(2131701401) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_RECORDING");
          }
          localObject3 = b();
          if (CameraControl.a().a((String)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(9, new Object[] { HardCodeUtil.a(2131701396) });
          break;
          localObject3 = (CameraProxy.FocusData)paramMessage.obj;
          a(((CameraProxy.FocusData)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((CameraProxy.FocusData)localObject3).b, ((CameraProxy.FocusData)localObject3).jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback);
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_SET_SURFACE");
          }
          localObject3 = (SurfaceTexture)paramMessage.obj;
          if (CameraControl.a().a((SurfaceTexture)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview texture failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_SURFACE_HOLDER");
          }
          localObject3 = (SurfaceHolder)paramMessage.obj;
          if (CameraControl.a().a((SurfaceHolder)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set surface holder failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_CALLBACK");
          }
          localObject3 = (Camera.PreviewCallback)paramMessage.obj;
          bool1 = bool3;
          if (paramMessage.arg1 > 0) {
            bool1 = true;
          }
          if (CameraControl.a().a((Camera.PreviewCallback)localObject3, bool1)) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview callback failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START");
          }
          if (!CameraControl.a().a())
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START error");
            }
            AEQLog.b("CameraProxy", "[handleMessage] PREVIEW_START");
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(3, new Object[] { "start preview failed" });
            break;
          }
          localObject3 = CameraControl.a();
          if (((CameraControl)localObject3).jdField_a_of_type_Int != 1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, cameraId = " + ((CameraControl)localObject3).jdField_a_of_type_Int);
          }
          AEQLog.b("CameraProxy", "【Camera 】PREVIEW_START success cameraID:" + ((CameraControl)localObject3).jdField_a_of_type_Int);
          if ((!((CameraControl)localObject3).d()) || (CameraProxy.a(this.a) == null)) {
            break;
          }
          QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, startFaceDetection");
          ((CameraControl)localObject3).a(CameraProxy.a(this.a));
          ((CameraControl)localObject3).c();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH" + paramMessage.arg1);
          }
          localObject3 = CameraControl.a();
          if ((!((CameraControl)localObject3).d()) || (CameraProxy.a(this.a) == null)) {
            break;
          }
          if (paramMessage.arg1 == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH " + ((CameraControl)localObject3).jdField_a_of_type_Int);
            }
            if (((CameraControl)localObject3).jdField_a_of_type_Int != 1) {
              break;
            }
            ((CameraControl)localObject3).a(CameraProxy.a(this.a));
            ((CameraControl)localObject3).c();
            break;
          }
          if (paramMessage.arg1 != 2) {
            break;
          }
          ((CameraControl)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_STOP");
          }
          AEQLog.b("CameraProxy", "【Camera】PREVIEW_STOP success");
          if (!CameraControl.a().b())
          {
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(4, new Object[] { "stop preview failed" });
            break;
          }
          localObject3 = CameraControl.a();
          if ((!((CameraControl)localObject3).d()) || (CameraProxy.a(this.a) == null)) {
            break;
          }
          ((CameraControl)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]RELEASE");
          }
          CameraControl.a().b();
          this.a.jdField_a_of_type_Boolean = true;
          try
          {
            Thread.sleep(50L);
            AEQLog.b("CameraProxy", "【Camera】RELEASE success");
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(11, new Object[] { "camera destory" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]NIGHT_MODE_ON_OFF" + paramMessage.arg1);
            }
            if (paramMessage.arg1 == 1)
            {
              CameraProxy.a(this.a);
              break;
            }
            if (paramMessage.arg1 != 2) {
              break;
            }
            CameraProxy.b(this.a);
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_ON_OFF");
            }
            if (paramMessage.arg1 == 1)
            {
              if (CameraControl.a().a(true)) {
                break;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (CameraControl.a().a(false))) {
              break;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_SWITCH");
            }
            if (paramMessage.arg1 == 0)
            {
              if (CameraControl.a().f()) {
                break;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(6, new Object[] { "switch flash light failed" });
              break;
            }
            if (paramMessage.arg1 == 1)
            {
              if (CameraControl.a().b(true)) {
                break;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (CameraControl.a().b(false))) {
              break;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]PICTURE_TAKE");
            }
            NewFlowCameraReporter.a("received");
            localObject3 = (CameraProxy.TakePictureData)paramMessage.obj;
            localObject5 = CameraControl.a();
            if (!((CameraControl)localObject5).jdField_a_of_type_Boolean)
            {
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[takePicture]Camera is not previewing...");
              }
              CameraProxy.WaitDoneBundle.a(paramMessage);
              return;
            }
            if (((CameraProxy.TakePictureData)localObject3).jdField_a_of_type_JavaIoFile == null)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "take picture error" });
              CameraProxy.WaitDoneBundle.a(paramMessage);
              return;
            }
            ((CameraControl)localObject5).a(((CameraProxy.TakePictureData)localObject3).jdField_a_of_type_JavaIoFile, ((CameraProxy.TakePictureData)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((CameraProxy.TakePictureData)localObject3).jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback, ((CameraProxy.TakePictureData)localObject3).jdField_a_of_type_Int, ((CameraProxy.TakePictureData)localObject3).jdField_a_of_type_Boolean, ((CameraProxy.TakePictureData)localObject3).jdField_b_of_type_Int);
            break;
            i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
            CameraControl.a().b(i);
            break;
            localObject3 = (String)((Object[])(Object[])paramMessage.obj)[0];
            CameraControl.a().b((String)localObject3);
            break;
            AEQLog.b("CameraProxy", "camera2 open in.");
            localObject3 = (Object[])paramMessage.obj;
            i = ((Integer)localObject3[0]).intValue();
            if ((localObject3[1] instanceof Camera2Control.Camera2Listener))
            {
              localObject3 = (Camera2Control.Camera2Listener)localObject3[1];
              if (Camera2Control.a().b())
              {
                Camera2Utils.a(1, "[Camera2] camera2 is opening!");
                CameraProxy.WaitDoneBundle.a(paramMessage);
                return;
              }
              i = Camera2Control.a().a(i, (Camera2Control.Camera2Listener)localObject3);
              if (i == 0) {
                break;
              }
              AEQLog.d("CameraProxy", "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + i);
              this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(13, new Object[] { Integer.valueOf(i) });
              break;
              localObject3 = (SurfaceTexture)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((SurfaceTexture)localObject3);
              AEQLog.b("CameraProxy", "【Camera2】PREVIEW_START");
              break;
              localObject3 = (Camera.PreviewCallback)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((Camera.PreviewCallback)localObject3);
              break;
              Camera2Control.a().e();
              AEQLog.b("CameraProxy", "【Camera2】CAMERA2_RELEASE");
              break;
              localObject7 = (Object[])paramMessage.obj;
              localObject5 = (CameraControl.CustomSize)localObject7[0];
              localObject8 = (CameraControl.CustomSize)localObject7[1];
              bool1 = ((Boolean)localObject7[4]).booleanValue();
              localObject3 = new StringBuilder();
              Camera2Control.a();
              localObject6 = Camera2Control.a + "#" + localObject5 + "#" + localObject8;
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_SET_PARAMS,wantedSize = " + localObject5 + " , viewSize = " + localObject8 + ",resolutionMode:" + bool1);
              }
              localObject3 = (CameraProxy.ParamCamera2Cache)this.a.jdField_b_of_type_JavaUtilMap.get(localObject6);
              if (localObject3 == null)
              {
                localObject3 = new CameraProxy.ParamCamera2Cache();
                this.a.jdField_b_of_type_JavaUtilMap.put(localObject6, localObject3);
                if (!((CameraProxy.ParamCamera2Cache)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
                {
                  localObject6 = Camera2Control.a().a();
                  if (!bool1) {}
                  for (localObject5 = Camera2Utils.a(((CameraControl.CustomSize)localObject5).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject5).jdField_b_of_type_Int, ((CameraControl.CustomSize)localObject8).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject8).jdField_b_of_type_Int, (Camera2Control.Camera2Info)localObject6);; localObject5 = Camera2Utils.b(((CameraControl.CustomSize)localObject5).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject5).jdField_b_of_type_Int, ((CameraControl.CustomSize)localObject8).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject8).jdField_b_of_type_Int, (Camera2Control.Camera2Info)localObject6))
                  {
                    if ((localObject5 == null) || (localObject5.length < 2)) {
                      break label5309;
                    }
                    localObject6 = localObject5[0];
                    localObject5 = localObject5[1];
                    localObject8 = new CameraControl.CustomSize(Math.max(((CameraControl.CustomSize)localObject8).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject8).jdField_b_of_type_Int), Math.min(((CameraControl.CustomSize)localObject8).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject8).jdField_b_of_type_Int));
                    localObject8 = Camera2Control.a().a((CameraControl.CustomSize)localObject8);
                    if (Camera2Control.a().a((CameraControl.CustomSize)localObject6)) {
                      break;
                    }
                    this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(14, new Object[] { "[Camera2]setCamera2 previewSize error!" });
                    CameraProxy.WaitDoneBundle.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().b((CameraControl.CustomSize)localObject5))
                  {
                    this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(14, new Object[] { "[Camera2]setCamera2 pictureSize error!" });
                    CameraProxy.WaitDoneBundle.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().a(((Integer)localObject7[3]).intValue()))
                  {
                    this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(14, new Object[] { "[Camera2]setCamera2 fps error!" });
                    CameraProxy.WaitDoneBundle.a(paramMessage);
                    return;
                  }
                  ((CameraProxy.ParamCamera2Cache)localObject3).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = ((CameraControl.CustomSize)localObject6);
                  ((CameraProxy.ParamCamera2Cache)localObject3).jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = ((CameraControl.CustomSize)localObject5);
                  ((CameraProxy.ParamCamera2Cache)localObject3).c = ((CameraControl.CustomSize)localObject8);
                  ((CameraProxy.ParamCamera2Cache)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
                }
                while (Camera2Control.a().a((CameraProxy.ParamCamera2Cache)localObject3))
                {
                  localObject3 = Camera2Control.a().b();
                  localObject5 = Camera2Control.a().a();
                  this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(14, new Object[] { localObject3, localObject5 });
                  break;
                }
                this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(14, new Object[] { "[Camera2]setCamera2ParamOnce error!" });
                CameraProxy.WaitDoneBundle.a(paramMessage);
                return;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_PICTURE_TAKE");
                }
                localObject3 = (CameraProxy.TakePictureData)paramMessage.obj;
                if (((CameraProxy.TakePictureData)localObject3).jdField_a_of_type_JavaIoFile == null)
                {
                  this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "take picture error" });
                  CameraProxy.WaitDoneBundle.a(paramMessage);
                  return;
                }
                localObject5 = new Camera2Control.Camera2PictureData();
                ((Camera2Control.Camera2PictureData)localObject5).jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback = ((CameraProxy.TakePictureData)localObject3).jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback;
                ((Camera2Control.Camera2PictureData)localObject5).jdField_a_of_type_Boolean = ((CameraProxy.TakePictureData)localObject3).jdField_a_of_type_Boolean;
                ((Camera2Control.Camera2PictureData)localObject5).jdField_a_of_type_Int = ((CameraProxy.TakePictureData)localObject3).jdField_a_of_type_Int;
                ((Camera2Control.Camera2PictureData)localObject5).jdField_a_of_type_JavaIoFile = ((CameraProxy.TakePictureData)localObject3).jdField_a_of_type_JavaIoFile;
                ((Camera2Control.Camera2PictureData)localObject5).jdField_a_of_type_AndroidGraphicsRect = ((CameraProxy.TakePictureData)localObject3).jdField_a_of_type_AndroidGraphicsRect;
                Camera2Control.a().a((Camera2Control.Camera2PictureData)localObject5);
                break;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_STOP_VIDEO");
                }
                Camera2Control.a().c();
                break;
                localObject3 = (CameraProxy.FocusData)paramMessage.obj;
                Camera2Control.a().a((CameraProxy.FocusData)localObject3);
                break;
                i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
                Camera2Control.a().a(i);
                break;
                bool1 = ((Boolean)((Object[])(Object[])paramMessage.obj)[0]).booleanValue();
                Camera2Control.a().a(bool1);
                break;
                Camera2Control.a().a();
                break;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_START_VIDEO");
                }
                Camera2Control.a().b();
                break;
                Camera2Utils.a(2, "[Camera2] error:" + paramMessage.arg1);
                AEQLog.d("CameraProxy", "【Camera2 Open Error】CAMERA2_ERROR_CALLBACK:" + paramMessage.arg1);
                i = paramMessage.arg1;
                switch (i)
                {
                case -203: 
                case -202: 
                case -201: 
                  this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(14, new Object[] { "[Camera2]setCamera2 previewSize error:" + i });
                  break;
                case -105: 
                case -102: 
                  this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(13, new Object[] { Integer.valueOf(i) });
                }
              }
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              continue;
              label5309:
              localObject5 = null;
              localObject6 = null;
              continue;
              continue;
              Object localObject4 = null;
            }
          }
        }
      }
      label5330:
      bool1 = false;
      break label5342;
      label5336:
      continue;
      label5339:
      continue;
      label5342:
      localObject5 = "";
      continue;
      label5350:
      localObject5 = "";
      continue;
      label5358:
      localObject5 = "";
      continue;
      label5366:
      localObject5 = " :[Preview Selector Error]";
      bool1 = bool2;
    }
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[onAutoFocus]success " + paramBoolean);
    }
    paramCamera = a();
    CameraControl.a().a(paramCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.Camera2Handler
 * JD-Core Version:    0.7.0.1
 */