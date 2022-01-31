package com.tencent.qqmini.sdk.runtime.widget.camera;

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
import bhit;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class GlCameraHolderSurfaceView
  extends GlCameraSurfaceView
  implements Camera.AutoFocusCallback, Camera.PreviewCallback
{
  private static final Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  protected SurfaceTexture a;
  protected Camera.Size a;
  protected Camera a;
  protected Integer a;
  private String jdField_a_of_type_JavaLangString;
  private final AtomicReference<Runnable> jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference();
  protected boolean a;
  protected Integer b;
  protected boolean b;
  
  static
  {
    if (!GlCameraHolderSurfaceView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      jdField_a_of_type_JavaUtilConcurrentExecutor = Executors.newSingleThreadExecutor();
      return;
    }
  }
  
  public GlCameraHolderSurfaceView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GlCameraHolderSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private String a()
  {
    String str = "continuous-video";
    if (Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
      str = "continuous-picture";
    }
    return str;
  }
  
  private void a(String paramString)
  {
    if (!a()) {}
    for (;;)
    {
      return;
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
        Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (localParameters == null) {
          continue;
        }
        String str = localParameters.getFocusMode();
        if (((str != null) && (str.equals(paramString))) || (!a(paramString))) {
          continue;
        }
        localParameters.setFocusMode(paramString);
        try
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
          return;
        }
        catch (Exception paramString)
        {
          QMLog.i("GlCameraHolderSurfaceVi", "setParamsFocusMode", paramString);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QMLog.i("GlCameraHolderSurfaceVi", "setParamsFocusMode", localException);
        }
      }
    }
  }
  
  private boolean a()
  {
    return !bhit.a(bhit.jdField_a_of_type_JavaLangString);
  }
  
  private boolean a(String paramString)
  {
    if ((!c) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (localObject == null) {
          break label64;
        }
        localObject = ((Camera.Parameters)localObject).getSupportedFocusModes();
      }
      catch (Exception paramString)
      {
        boolean bool;
        return false;
      }
      bool = ((List)localObject).contains(paramString);
      if (bool) {
        return true;
      }
      while (localObject == null)
      {
        return false;
        label64:
        localObject = null;
      }
    }
  }
  
  private void f()
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
        this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(i);
      }
      while ((this.jdField_a_of_type_JavaLangInteger != null) && (this.jdField_b_of_type_JavaLangInteger != null))
      {
        return;
        label55:
        if (localCameraInfo.facing == 0) {
          this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(i);
        }
      }
      i += 1;
    }
  }
  
  protected Camera.Size a(List<Camera.Size> paramList1, List<Camera.Size> paramList2, List<Camera.Size> paramList3)
  {
    Object localObject2 = null;
    Object localObject1 = paramList1;
    if (paramList1 == null) {
      localObject1 = Collections.emptyList();
    }
    paramList1 = paramList2;
    if (paramList2 == null) {
      paramList1 = Collections.emptyList();
    }
    paramList2 = paramList3;
    if (paramList3 == null) {
      paramList2 = Collections.emptyList();
    }
    localObject1 = new HashSet((Collection)localObject1);
    HashSet localHashSet = new HashSet(paramList2);
    int i = -1;
    Iterator localIterator = paramList1.iterator();
    paramList1 = null;
    paramList2 = localObject2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList3 = (Camera.Size)localIterator.next();
        if ((((Set)localObject1).contains(paramList3)) && (localHashSet.contains(paramList3)))
        {
          if (paramList3.width * 9 != paramList3.height * 16) {
            break label202;
          }
          if (paramList1 == null) {
            paramList1 = paramList3;
          }
        }
      }
    }
    label138:
    label202:
    for (;;)
    {
      int j = paramList3.width * paramList3.height;
      if (j > i)
      {
        paramList2 = paramList3;
        i = j;
      }
      for (;;)
      {
        break;
        if (paramList3.width * paramList3.height <= paramList1.width * paramList1.height) {
          break label202;
        }
        paramList1 = paramList3;
        break label138;
        if (paramList1 != null) {
          return paramList1;
        }
        return paramList2;
      }
    }
  }
  
  protected void a()
  {
    super.a();
    f();
    setBackgroundColor(0);
  }
  
  protected void a(int paramInt)
  {
    boolean bool;
    Camera.Parameters localParameters;
    Object localObject2;
    Object localObject1;
    if (paramInt == this.jdField_b_of_type_JavaLangInteger.intValue())
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidHardwareCamera = Camera.open(paramInt);
      paramInt = 90;
      if (bhit.a(bhit.g)) {
        paramInt = 270;
      }
      this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(paramInt);
      localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      localObject2 = localParameters.getSupportedFocusModes();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Collections.emptyList();
      }
      if (!((List)localObject1).contains("continuous-picture")) {
        break label234;
      }
      Log.i("GlCameraHolderSurfaceVi", "setupCamera: set focus continuous-picture");
      localParameters.setFocusMode("continuous-picture");
    }
    for (;;)
    {
      List localList = localParameters.getSupportedPreviewSizes();
      this.jdField_a_of_type_AndroidHardwareCamera$Size = a(localList, localParameters.getSupportedVideoSizes(), localParameters.getSupportedPictureSizes());
      localObject2 = this.jdField_a_of_type_AndroidHardwareCamera$Size;
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
      if (this.jdField_a_of_type_Boolean) {
        localParameters.setFlashMode(this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this);
      return;
      bool = false;
      break;
      label234:
      if (((List)localObject1).contains("auto"))
      {
        Log.i("GlCameraHolderSurfaceVi", "setupCamera: set focus auto");
        localParameters.setFocusMode("auto");
      }
    }
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture)
  {
    super.a(paramSurfaceTexture);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    if ((paramSurfaceTexture == null) || (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
      return;
    }
    catch (IOException paramSurfaceTexture)
    {
      Log.w("GlCameraHolderSurfaceVi", "onSurfaceCreate: ", paramSurfaceTexture);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
      this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("GlCameraHolderSurfaceVi", "startPreview: failed auto focus mode", localThrowable);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
      return;
    }
    this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
    this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(null);
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(null);
    }
    catch (IOException localIOException2)
    {
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(null);
      }
      catch (IOException localIOException2)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(null);
            this.jdField_a_of_type_AndroidHardwareCamera.release();
            this.jdField_a_of_type_AndroidHardwareCamera = null;
            return;
            localIOException1 = localIOException1;
            Log.w("GlCameraHolderSurfaceVi", "releaseCamera: ", localIOException1);
            continue;
            localIOException2 = localIOException2;
            Log.w("GlCameraHolderSurfaceVi", "releaseCamera: ", localIOException2);
          }
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            Log.w("GlCameraHolderSurfaceVi", "releaseCamera: ", localIOException3);
          }
        }
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
      return;
    }
    try
    {
      Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      localParameters.setFlashMode(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("GlCameraHolderSurfaceVi", "updateFlashMode exception!", localThrowable);
    }
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    a(a());
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null)) {}
    do
    {
      return;
      System.nanoTime();
      paramArrayOfByte = new GlCameraHolderSurfaceView.1(this, paramArrayOfByte);
    } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.compareAndSet(null, paramArrayOfByte));
    jdField_a_of_type_JavaUtilConcurrentExecutor.execute(paramArrayOfByte);
  }
  
  public void setFlashMode(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setMode(String paramString)
  {
    this.jdField_b_of_type_Boolean = "scanCode".equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.camera.GlCameraHolderSurfaceView
 * JD-Core Version:    0.7.0.1
 */