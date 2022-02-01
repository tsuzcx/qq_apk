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
import bcie;
import bcif;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager.a;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class CameraSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  protected static Camera a;
  public static int h;
  public static int i;
  boolean b = false;
  boolean c = false;
  public ApkgConfigManager.a d;
  protected WeakReference e;
  Camera.AutoFocusCallback f = new a(this);
  Camera.PreviewCallback g = null;
  CameraSurfaceView.b j = new CameraSurfaceView.b(this);
  CameraSurfaceView.a k = new CameraSurfaceView.a(this);
  
  static
  {
    if (!CameraSurfaceView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      l = bool;
      a = null;
      h = 320;
      i = 240;
      return;
    }
  }
  
  public CameraSurfaceView(Context paramContext, WebviewContainer paramWebviewContainer)
  {
    super(paramContext);
    b();
    this.e = new WeakReference(paramWebviewContainer);
  }
  
  private Camera.Size a(List paramList, int paramInt1, int paramInt2)
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
        paramList = (List)localObject1;
      }
    }
  }
  
  private String f()
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
  
  public void a(ApkgConfigManager.a parama)
  {
    this.d = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    if (a == null) {}
    for (;;)
    {
      return;
      try
      {
        a.setPreviewCallback(null);
        a.stopPreview();
        this.b = false;
        if ((!paramBoolean) && (this.c)) {
          continue;
        }
        try
        {
          a.setPreviewDisplay(null);
          a.release();
          a = null;
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
  
  boolean a()
  {
    return !bcif.d(bcif.a);
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
    boolean bool2 = false;
    if ((!l) && (this.d == null)) {
      throw new AssertionError();
    }
    boolean bool1;
    if (!a()) {
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
            a.cancelAutoFocus();
            Camera.Parameters localParameters = a.getParameters();
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
      } while (!bcie.a().a(paramString));
      localRuntimeException.setFocusMode(paramString);
      bool2 = a(localRuntimeException);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("CameraSurfaceView", 2, "[@] setParamsFocusMode isSupportFocus=true  success=" + bool2);
    return bool2;
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
    if ((!this.c) || (this.b)) {}
    do
    {
      return;
      if (a == null) {}
      try
      {
        a = Camera.open(0);
        int m = 90;
        if (bcif.d(bcif.g)) {
          m = 270;
        }
        a.setDisplayOrientation(m);
        Camera.Parameters localParameters = a.getParameters();
        Camera.Size localSize = a(localParameters.getSupportedPreviewSizes(), h, i);
        if (localSize != null)
        {
          localParameters.setPreviewSize(localSize.width, localSize.height);
          localParameters.setPictureSize(localSize.width, localSize.height);
          if (QLog.isColorLevel()) {
            QLog.i("CameraSurfaceView", 2, "previewSize w h " + localSize.width + "   " + localSize.height);
          }
        }
        if (localParameters.getSupportedFocusModes().contains("continuous-video")) {
          localParameters.setFocusMode("continuous-video");
        }
        localParameters.setFlashMode("auto");
        a.setParameters(localParameters);
        localParameters.getPreviewFormat();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    } while (a == null);
    try
    {
      a.setPreviewDisplay(getHolder());
      if (this.g != null) {
        a.setPreviewCallback(this.g);
      }
      a.startPreview();
      a.autoFocus(this.f);
      this.b = true;
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      this.b = false;
      return;
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.e == null) {}
    do
    {
      do
      {
        return;
        paramSurfaceHolder = (WebviewContainer)this.e.get();
      } while (paramSurfaceHolder == null);
      paramSurfaceHolder = paramSurfaceHolder.appBrandRuntime;
    } while ((paramSurfaceHolder == null) || (paramSurfaceHolder.j));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.CameraSurfaceView
 * JD-Core Version:    0.7.0.1
 */