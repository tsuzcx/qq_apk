package com.tencent.mobileqq.microapp.widget.media;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager.a;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class CameraSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  protected static Camera a = null;
  public static int h = 320;
  public static int i = 240;
  boolean b = false;
  boolean c = false;
  public ApkgConfigManager.a d;
  protected WeakReference e;
  Camera.AutoFocusCallback f = new a(this);
  Camera.PreviewCallback g = null;
  CameraSurfaceView.b j = new CameraSurfaceView.b(this);
  CameraSurfaceView.a k = new CameraSurfaceView.a(this);
  
  public CameraSurfaceView(Context paramContext, WebviewContainer paramWebviewContainer)
  {
    super(paramContext);
    b();
    this.e = new WeakReference(paramWebviewContainer);
  }
  
  private Camera.Size a(List paramList, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    if (paramList == null) {
      return null;
    }
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Camera.Size)((Iterator)localObject2).next();
      if ((((Camera.Size)localObject3).width == paramInt1) && (((Camera.Size)localObject3).height == paramInt2)) {
        return localObject3;
      }
    }
    double d1 = paramInt1;
    double d2 = paramInt2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    double d5 = d1 / d2;
    Object localObject3 = paramList.iterator();
    double d4 = 1.7976931348623157E+308D;
    d1 = 1.7976931348623157E+308D;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (Camera.Size)((Iterator)localObject3).next();
      double d3;
      if (((paramInt1 > paramInt2) && (((Camera.Size)localObject2).width > ((Camera.Size)localObject2).height)) || ((paramInt1 < paramInt2) && (((Camera.Size)localObject2).width < ((Camera.Size)localObject2).height)))
      {
        d2 = ((Camera.Size)localObject2).width;
        d3 = ((Camera.Size)localObject2).height;
        Double.isNaN(d2);
        Double.isNaN(d3);
      }
      else
      {
        d2 = ((Camera.Size)localObject2).height;
        d3 = ((Camera.Size)localObject2).width;
        Double.isNaN(d2);
        Double.isNaN(d3);
      }
      if ((Math.abs(d2 / d3 - d5) <= 0.05D) && (Math.abs(((Camera.Size)localObject2).height - paramInt2) < d1))
      {
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt2);
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject3 = paramList.iterator();
      d1 = d4;
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        paramList = (Camera.Size)((Iterator)localObject3).next();
        if (Math.abs(paramList.height - paramInt2) < d1)
        {
          d1 = Math.abs(paramList.height - paramInt2);
          localObject1 = paramList;
        }
      }
    }
    return localObject2;
  }
  
  private String f()
  {
    if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.VERSION.SDK_INT >= 14)) {
      return "continuous-picture";
    }
    return "continuous-video";
  }
  
  public void a(ApkgConfigManager.a parama)
  {
    this.d = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    Camera localCamera = a;
    if (localCamera == null) {
      return;
    }
    try
    {
      localCamera.setPreviewCallback(null);
      a.stopPreview();
      this.b = false;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    if ((paramBoolean) || (!this.c)) {
      try
      {
        a.setPreviewDisplay(null);
        a.release();
        a = null;
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
  }
  
  boolean a()
  {
    return CameraCompatibleList.isFoundProduct(CameraCompatibleList.KEY_NOT_FOCUS_MODEL) ^ true;
  }
  
  public boolean a(Camera.Parameters paramParameters)
  {
    if (paramParameters == null) {
      return false;
    }
    try
    {
      a.setParameters(paramParameters);
      return true;
    }
    catch (Exception paramParameters) {}
    return false;
  }
  
  public boolean a(String paramString)
  {
    if ((!l) && (this.d == null)) {
      throw new AssertionError();
    }
    if (!a()) {
      return false;
    }
    try
    {
      a.cancelAutoFocus();
    }
    catch (RuntimeException localRuntimeException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CameraSurfaceView", 2, "", localRuntimeException);
      }
    }
    Camera.Parameters localParameters = a.getParameters();
    if (localParameters == null) {
      return false;
    }
    String str = localParameters.getFocusMode();
    if ((str != null) && (str.equals(paramString))) {
      return true;
    }
    if (CameraAbility.a().a(paramString))
    {
      localParameters.setFocusMode(paramString);
      boolean bool = a(localParameters);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("[@] setParamsFocusMode isSupportFocus=true  success=");
        paramString.append(bool);
        QLog.d("CameraSurfaceView", 2, paramString.toString());
      }
      return bool;
    }
    return false;
  }
  
  void b()
  {
    this.c = false;
    getHolder().addCallback(this);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSurfaceView", 2, "openCamera");
    }
    ThreadManagerV2.excute(this.j, 16, null, true);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSurfaceView", 2, "closeCamera");
    }
    ThreadManagerV2.excute(this.k, 16, null, true);
  }
  
  @TargetApi(9)
  public void e()
  {
    if (this.c)
    {
      if (this.b) {
        return;
      }
      if (a == null) {
        try
        {
          a = Camera.open(0);
          int m = 90;
          if (CameraCompatibleList.isFoundProduct(CameraCompatibleList.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL)) {
            m = 270;
          }
          a.setDisplayOrientation(m);
          Camera.Parameters localParameters = a.getParameters();
          Camera.Size localSize = a(localParameters.getSupportedPreviewSizes(), h, i);
          if (localSize != null)
          {
            localParameters.setPreviewSize(localSize.width, localSize.height);
            localParameters.setPictureSize(localSize.width, localSize.height);
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("previewSize w h ");
              localStringBuilder.append(localSize.width);
              localStringBuilder.append("   ");
              localStringBuilder.append(localSize.height);
              QLog.i("CameraSurfaceView", 2, localStringBuilder.toString());
            }
          }
          if (localParameters.getSupportedFocusModes().contains("continuous-video")) {
            localParameters.setFocusMode("continuous-video");
          }
          localParameters.setFlashMode("auto");
          a.setParameters(localParameters);
          localParameters.getPreviewFormat();
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
      }
      Camera localCamera = a;
      if (localCamera != null) {
        try
        {
          localCamera.setPreviewDisplay(getHolder());
          if (this.g != null) {
            a.setPreviewCallback(this.g);
          }
          a.startPreview();
          a.autoFocus(this.f);
          this.b = true;
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          this.b = false;
        }
      }
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    paramSurfaceHolder = this.e;
    if (paramSurfaceHolder == null) {
      return;
    }
    paramSurfaceHolder = (WebviewContainer)paramSurfaceHolder.get();
    if (paramSurfaceHolder == null) {
      return;
    }
    paramSurfaceHolder = paramSurfaceHolder.appBrandRuntime;
    if (paramSurfaceHolder == null) {
      return;
    }
    if (paramSurfaceHolder.j) {
      return;
    }
    e();
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.c = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.c = false;
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.CameraSurfaceView
 * JD-Core Version:    0.7.0.1
 */