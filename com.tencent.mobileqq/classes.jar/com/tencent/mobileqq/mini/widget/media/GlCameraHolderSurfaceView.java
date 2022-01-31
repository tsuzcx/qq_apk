package com.tencent.mobileqq.mini.widget.media;

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
import axhp;
import axhq;
import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.MultiFormatReader;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
  private final MultiFormatReader multiFormatReader = new MultiFormatReader();
  private final AtomicReference<Runnable> task = new AtomicReference();
  
  public GlCameraHolderSurfaceView(Context paramContext)
  {
    super(paramContext);
    paramContext = new HashMap();
    paramContext.put(DecodeHintType.TRY_HARDER, Boolean.valueOf(true));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(BarcodeFormat.CODABAR);
    localArrayList.add(BarcodeFormat.CODE_39);
    localArrayList.add(BarcodeFormat.CODE_93);
    localArrayList.add(BarcodeFormat.CODE_128);
    localArrayList.add(BarcodeFormat.EAN_8);
    localArrayList.add(BarcodeFormat.EAN_13);
    localArrayList.add(BarcodeFormat.ITF);
    localArrayList.add(BarcodeFormat.UPC_A);
    localArrayList.add(BarcodeFormat.UPC_E);
    localArrayList.add(BarcodeFormat.UPC_EAN_EXTENSION);
    paramContext.put(DecodeHintType.POSSIBLE_FORMATS, localArrayList);
    this.multiFormatReader.setHints(paramContext);
  }
  
  public GlCameraHolderSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new HashMap();
    paramContext.put(DecodeHintType.TRY_HARDER, Boolean.valueOf(true));
    paramAttributeSet = new ArrayList();
    paramAttributeSet.add(BarcodeFormat.CODABAR);
    paramAttributeSet.add(BarcodeFormat.CODE_39);
    paramAttributeSet.add(BarcodeFormat.CODE_93);
    paramAttributeSet.add(BarcodeFormat.CODE_128);
    paramAttributeSet.add(BarcodeFormat.EAN_8);
    paramAttributeSet.add(BarcodeFormat.EAN_13);
    paramAttributeSet.add(BarcodeFormat.ITF);
    paramAttributeSet.add(BarcodeFormat.UPC_A);
    paramAttributeSet.add(BarcodeFormat.UPC_E);
    paramAttributeSet.add(BarcodeFormat.UPC_EAN_EXTENSION);
    paramContext.put(DecodeHintType.POSSIBLE_FORMATS, paramAttributeSet);
    this.multiFormatReader.setHints(paramContext);
  }
  
  private boolean canFocus()
  {
    return !axhq.d(axhq.a);
  }
  
  private void getCameraInfo()
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
        this.frontCameraId = Integer.valueOf(i);
      }
      while ((this.frontCameraId != null) && (this.backCameraId != null))
      {
        return;
        label55:
        if (localCameraInfo.facing == 0) {
          this.backCameraId = Integer.valueOf(i);
        }
      }
      i += 1;
    }
  }
  
  private String getDefaultFocusMode()
  {
    String str = "continuous-video";
    if (Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
      str = "continuous-picture";
    }
    return str;
  }
  
  private void setParamsFocusMode(String paramString)
  {
    if (!canFocus()) {}
    for (;;)
    {
      return;
      try
      {
        this.camera.cancelAutoFocus();
        Camera.Parameters localParameters = this.camera.getParameters();
        if (localParameters == null) {
          continue;
        }
        String str = localParameters.getFocusMode();
        if (((str != null) && (str.equals(paramString))) || (!axhp.a().a(paramString))) {
          continue;
        }
        localParameters.setFocusMode(paramString);
        try
        {
          this.camera.setParameters(localParameters);
          return;
        }
        catch (Exception paramString)
        {
          QLog.i("GlCameraHolderSurfaceVi", 2, "setParamsFocusMode", paramString);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.i("GlCameraHolderSurfaceVi", 2, "setParamsFocusMode", localException);
        }
      }
    }
  }
  
  protected Camera.Size getSameSize(List<Camera.Size> paramList1, List<Camera.Size> paramList2, List<Camera.Size> paramList3)
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
    if ((paramSurfaceTexture == null) || (this.camera == null)) {
      return;
    }
    try
    {
      this.camera.setPreviewTexture(paramSurfaceTexture);
      this.mPreviewSt = paramSurfaceTexture;
      return;
    }
    catch (IOException paramSurfaceTexture)
    {
      Log.w("GlCameraHolderSurfaceVi", "onSurfaceCreate: ", paramSurfaceTexture);
    }
  }
  
  protected void onCodeRead(String paramString)
  {
    Log.i("GlCameraHolderSurfaceVi", "onCodeRead: " + paramString + " " + this.isScanMode);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((!this.isScanMode) || (this.task.get() != null)) {}
    do
    {
      return;
      paramArrayOfByte = new GlCameraHolderSurfaceView.1(this, paramArrayOfByte, System.nanoTime());
    } while (!this.task.compareAndSet(null, paramArrayOfByte));
    EXECUTOR.execute(paramArrayOfByte);
  }
  
  protected void releaseCamera()
  {
    if (this.camera == null) {
      return;
    }
    this.camera.stopPreview();
    this.camera.setPreviewCallback(null);
    try
    {
      this.camera.setPreviewDisplay(null);
    }
    catch (IOException localIOException2)
    {
      try
      {
        this.camera.setPreviewTexture(null);
      }
      catch (IOException localIOException2)
      {
        try
        {
          for (;;)
          {
            this.camera.setPreviewDisplay(null);
            this.camera.release();
            this.camera = null;
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
    Camera.Parameters localParameters;
    Object localObject2;
    Object localObject1;
    if (paramInt == this.backCameraId.intValue())
    {
      bool = true;
      this.isBackCameraNow = bool;
      this.camera = Camera.open(paramInt);
      paramInt = 90;
      if (axhq.d(axhq.g)) {
        paramInt = 270;
      }
      this.camera.setDisplayOrientation(paramInt);
      localParameters = this.camera.getParameters();
      localObject2 = localParameters.getSupportedFocusModes();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Collections.emptyList();
      }
      if (!((List)localObject1).contains("continuous-picture")) {
        break label235;
      }
      Log.i("GlCameraHolderSurfaceVi", "setupCamera: set focus continuous-picture");
      localParameters.setFocusMode("continuous-picture");
    }
    for (;;)
    {
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
      return;
      bool = false;
      break;
      label235:
      if (((List)localObject1).contains("auto"))
      {
        Log.i("GlCameraHolderSurfaceVi", "setupCamera: set focus auto");
        localParameters.setFocusMode("auto");
      }
    }
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
    if (this.camera != null) {
      this.camera.stopPreview();
    }
  }
  
  public void updateFlashMode()
  {
    if (this.camera == null) {
      return;
    }
    try
    {
      Camera.Parameters localParameters = this.camera.getParameters();
      localParameters.setFlashMode(this.flashMode);
      this.camera.setParameters(localParameters);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GlCameraHolderSurfaceVi", 1, "updateFlashMode exception!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.GlCameraHolderSurfaceView
 * JD-Core Version:    0.7.0.1
 */