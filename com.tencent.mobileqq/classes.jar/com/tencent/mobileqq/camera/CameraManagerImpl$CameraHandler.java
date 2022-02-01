package com.tencent.mobileqq.camera;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.AutoFocusMoveCallback;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.OnZoomChangeListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class CameraManagerImpl$CameraHandler
  extends Handler
{
  private String b = "Q.camera.CameraManagerImpl.CameraHandler";
  
  CameraManagerImpl$CameraHandler(CameraManagerImpl paramCameraManagerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(16)
  private void a(Camera paramCamera, Object paramObject)
  {
    paramCamera.setAutoFocusMoveCallback((Camera.AutoFocusMoveCallback)paramObject);
  }
  
  @TargetApi(14)
  private void a(Object paramObject)
  {
    try
    {
      CameraManagerImpl.a(this.a).setPreviewTexture((SurfaceTexture)paramObject);
      return;
    }
    catch (IOException paramObject)
    {
      QLog.e(this.b, 2, "Could not set preview texture", paramObject);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      i = paramMessage.what;
      if (i == 1) {
        break label1188;
      }
      if (i == 2) {
        break label1141;
      }
      if (i == 3) {
        break label1084;
      }
      if (i == 4) {
        break label1047;
      }
      if (i == 5) {
        break label1010;
      }
      if (i == 501) {
        break label993;
      }
      if (i == 502) {
        break label952;
      }
      switch (i)
      {
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        int i;
        Object localObject1;
        Object localObject2;
        String str1;
        label952:
        label993:
        label1010:
        label1141:
        String str2;
        label1047:
        label1084:
        localRuntimeException.printStackTrace();
        label1188:
        QLog.e(this.b, 2, localRuntimeException, new Object[0]);
        if ((paramMessage.what != 2) && (CameraManagerImpl.a(this.a) != null)) {
          QLog.e(this.b, 1, "mCamera != null, but RuntimeException");
        }
        try
        {
          CameraManagerImpl.a(this.a).release();
        }
        catch (Exception localException2)
        {
          label1490:
          String str3;
          StringBuilder localStringBuilder;
          break label1490;
        }
        QLog.e(this.b, 2, "Fail to release the camera.");
        CameraManagerImpl.a(this.a, null);
        if (paramMessage.obj != null)
        {
          str3 = this.b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("相机已经打开，运行时异常 ");
          ((StringBuilder)localObject2).append(paramMessage.what);
          QLog.w(str3, 1, ((StringBuilder)localObject2).toString());
          if ((paramMessage.obj instanceof CameraManager.CameraOpenErrorCallback))
          {
            ((CameraManager.CameraOpenErrorCallback)paramMessage.obj).b(paramMessage.arg1);
            return;
          }
          if ((paramMessage.obj instanceof CameraManagerImpl.AFCallbackForward)) {
            ((CameraManagerImpl.AFCallbackForward)paramMessage.obj).onAutoFocus(false, CameraManagerImpl.a(this.a));
          }
        }
        else
        {
          localObject2 = this.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("相机参数设置错误, 请尝试重启机器 ");
          localStringBuilder.append(paramMessage.what);
          QLog.w((String)localObject2, 1, localStringBuilder.toString());
          throw str3;
          if (CameraManagerImpl.a(this.a) == null)
          {
            if (paramMessage.what == 1)
            {
              QLog.e(this.b, 1, "mCamera == null Since Camera is disabled");
              if ((paramMessage.obj != null) && ((paramMessage.obj instanceof CameraManager.CameraOpenErrorCallback))) {
                ((CameraManager.CameraOpenErrorCallback)paramMessage.obj).a(paramMessage.arg1);
              }
              return;
            }
            QLog.e(this.b, 1, "mCamera == null, Cannot handle message, 相机运行异常，请尝试重启机器");
            throw str3;
          }
        }
        return;
        switch (i)
        {
        }
        switch (i)
        {
        }
        switch (i)
        {
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Invalid CameraProxy message=");
    ((StringBuilder)localObject1).append(paramMessage.what);
    throw new RuntimeException(((StringBuilder)localObject1).toString());
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "[handleMessage] SET_ERROR_CALLBACK");
    }
    if (CameraManagerImpl.a(this.a) != null)
    {
      CameraManagerImpl.a(this.a).setErrorCallback((Camera.ErrorCallback)paramMessage.obj);
      return;
      if (QLog.isColorLevel())
      {
        QLog.d(this.b, 2, "[handleMessage] STOP_FACE_DETECTION");
        return;
        if (!QLog.isColorLevel()) {
          break label1841;
        }
        QLog.d(this.b, 2, "[handleMessage] START_FACE_DETECTION");
        return;
        if (!QLog.isColorLevel()) {
          break label1842;
        }
        QLog.d(this.b, 2, "[handleMessage] SET_FACE_DETECTION_LISTENER");
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] SET_ZOOM_CHANGE_LISTENER");
        }
        if (CameraManagerImpl.a(this.a) == null) {
          break label1843;
        }
        CameraManagerImpl.a(this.a).setZoomChangeListener((Camera.OnZoomChangeListener)paramMessage.obj);
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] SET_AUTO_FOCUS_MOVE_CALLBACK");
        }
        if (CameraManagerImpl.a(this.a) == null) {
          break label1844;
        }
        a(CameraManagerImpl.a(this.a), paramMessage.obj);
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] CANCEL_AUTO_FOCUS");
        }
        if (CameraManagerImpl.a(this.a) == null) {
          break label1845;
        }
        CameraManagerImpl.a(this.a).cancelAutoFocus();
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] AUTO_FOCUS");
        }
        if (CameraManagerImpl.a(this.a) == null) {
          break label1846;
        }
        CameraManagerImpl.a(this.a).autoFocus((Camera.AutoFocusCallback)paramMessage.obj);
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] REFRESH_PARAMETERS");
        }
        CameraManagerImpl.a(this.a, true);
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] GET_PARAMETERS");
        }
        if ((CameraManagerImpl.a(this.a) == null) || (!CameraManagerImpl.c(this.a))) {
          break label1847;
        }
        CameraManagerImpl.b(this.a, CameraManagerImpl.a(this.a).getParameters());
        CameraManagerImpl.a(this.a, false);
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] SET_PARAMETERS");
        }
        if (CameraManagerImpl.a(this.a) == null) {
          break label1848;
        }
        CameraManagerImpl.a(this.a, true);
        CameraManagerImpl.b(this.a).unflatten((String)paramMessage.obj);
        CameraManagerImpl.a(this.a).setParameters(CameraManagerImpl.b(this.a));
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] SET_ONE_SHOT_PREVIEW_CALlBACK");
        }
        if (CameraManagerImpl.a(this.a) == null) {
          break label1849;
        }
        CameraManagerImpl.a(this.a).setOneShotPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
        return;
        if (QLog.isColorLevel())
        {
          localObject1 = this.b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[handleMessage] SET_PREVIEW_CALLBACK, obj = ");
          ((StringBuilder)localObject2).append(paramMessage.obj);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        if (CameraManagerImpl.a(this.a) == null) {
          break label1850;
        }
        CameraManagerImpl.a(this.a).setPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] SET_PREVIEW_DISPLAY");
        }
        try
        {
          if (CameraManagerImpl.a(this.a) != null) {
            CameraManagerImpl.a(this.a).setPreviewDisplay((SurfaceHolder)paramMessage.obj);
          }
          return;
        }
        catch (IOException localIOException1)
        {
          throw new RuntimeException(localIOException1);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] ADD_CALLBACK_BUFFER");
        }
        if (CameraManagerImpl.a(this.a) == null) {
          break label1851;
        }
        CameraManagerImpl.a(this.a).addCallbackBuffer((byte[])paramMessage.obj);
        return;
        if (QLog.isColorLevel())
        {
          str1 = this.b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[handleMessage] SET_PREVIEW_CALLBACK_WITH_BUFFER, obj = ");
          ((StringBuilder)localObject2).append(paramMessage.obj);
          QLog.d(str1, 2, ((StringBuilder)localObject2).toString());
        }
        if (CameraManagerImpl.a(this.a) == null) {
          break label1852;
        }
        CameraManagerImpl.a(this.a).setPreviewCallbackWithBuffer((Camera.PreviewCallback)paramMessage.obj);
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] STOP_PREVIEW");
        }
        try
        {
          if (CameraManagerImpl.a(this.a) == null) {
            break label1853;
          }
          CameraManagerImpl.a(this.a).stopPreview();
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] START_PREVIEW_ASYNC");
        }
        if (CameraManagerImpl.a(this.a) == null) {
          break label1854;
        }
        CameraManagerImpl.a(this.a).startPreview();
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] SET_PREVIEW_TEXTURE_ASYNC");
        }
        a(paramMessage.obj);
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] SET_DISPLAY_ORIENTATION");
        }
        if (CameraManagerImpl.a(this.a) == null) {
          break label1855;
        }
        CameraManagerImpl.a(this.a).setDisplayOrientation(paramMessage.arg1);
        return;
        if (!QLog.isColorLevel()) {
          break label1856;
        }
        QLog.d(this.b, 2, "[handleMessage] ENABLE_SHUTTER_SOUND");
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] LOCK");
        }
        if (CameraManagerImpl.a(this.a) == null) {
          break label1857;
        }
        CameraManagerImpl.a(this.a).lock();
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] UNLOCK");
        }
        if (CameraManagerImpl.a(this.a) == null) {
          break label1858;
        }
        CameraManagerImpl.a(this.a).unlock();
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] RECONNECT");
        }
        CameraManagerImpl.a(this.a, null);
        try
        {
          if (CameraManagerImpl.a(this.a) == null) {
            return;
          }
          CameraManagerImpl.a(this.a).reconnect();
          return;
        }
        catch (IOException localIOException2)
        {
          CameraManagerImpl.a(this.a, localIOException2);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "[handleMessage] RELEASE");
        }
        if (CameraManagerImpl.a(this.a) != null) {
          CameraManagerImpl.a(this.a).release();
        }
        CameraManagerImpl.a(this.a, null);
        return;
        if (QLog.isColorLevel())
        {
          str2 = this.b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[handleMessage] OPEN_CAMERA ");
          ((StringBuilder)localObject2).append(paramMessage.arg1);
          QLog.d(str2, 2, ((StringBuilder)localObject2).toString());
        }
        CameraManagerImpl.a(this.a, Camera.open(paramMessage.arg1));
        if (CameraManagerImpl.a(this.a) != null)
        {
          CameraManagerImpl.a(this.a, true);
          if (CameraManagerImpl.b(this.a) == null)
          {
            CameraManagerImpl.a(this.a, CameraManagerImpl.a(this.a).getParameters());
            if (QLog.isColorLevel())
            {
              str2 = this.b;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[handleMessage] OPEN_CAMERA, parameter = ");
              ((StringBuilder)localObject2).append(CameraManagerImpl.b(this.a));
              QLog.d(str2, 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
        else if (paramMessage.obj != null)
        {
          ((CameraManager.CameraOpenErrorCallback)paramMessage.obj).b(paramMessage.arg1);
        }
        if (QLog.isColorLevel())
        {
          str2 = this.b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[handleMessage] OPEN_CAMERA, open result mCamera = ");
          ((StringBuilder)localObject2).append(CameraManagerImpl.a(this.a));
          QLog.d(str2, 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    else
    {
      return;
    }
    return;
    label1841:
    return;
    label1842:
    return;
    label1843:
    return;
    label1844:
    return;
    label1845:
    return;
    label1846:
    return;
    label1847:
    return;
    label1848:
    return;
    label1849:
    return;
    label1850:
    return;
    label1851:
    return;
    label1852:
    return;
    label1853:
    return;
    label1854:
    return;
    label1855:
    return;
    label1856:
    return;
    label1857:
    return;
    label1858:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.CameraHandler
 * JD-Core Version:    0.7.0.1
 */