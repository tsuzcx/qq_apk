package com.tencent.widget;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CameraView
  extends ViewGroup
  implements SurfaceHolder.Callback
{
  protected Camera.Size a;
  protected Camera a;
  SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  protected List a;
  
  public CameraView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public CameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private Camera.Size a(List paramList, int paramInt1, int paramInt2)
  {
    double d2 = paramInt1 / paramInt2;
    Object localObject2;
    if (paramList == null)
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    Iterator localIterator = paramList.iterator();
    label33:
    while (localIterator.hasNext())
    {
      localObject2 = (Camera.Size)localIterator.next();
      if (Math.abs(((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height - d2) <= 0.1D)
      {
        if (Math.abs(((Camera.Size)localObject2).height - paramInt2) >= d1) {
          break label205;
        }
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt2);
        localObject1 = localObject2;
      }
    }
    label205:
    for (;;)
    {
      break label33;
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      d1 = 1.7976931348623157E+308D;
      localIterator = paramList.iterator();
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (Camera.Size)localIterator.next();
      if (Math.abs(paramList.height - paramInt2) < d1) {
        d1 = Math.abs(paramList.height - paramInt2);
      }
      for (;;)
      {
        localObject1 = paramList;
        break;
        paramList = (List)localObject1;
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewSurfaceView = new SurfaceView(paramContext);
    addView(this.jdField_a_of_type_AndroidViewSurfaceView, new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidViewSurfaceHolder = this.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setType(3);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView;
    if ((paramBoolean) && (getChildCount() > 0))
    {
      localView = getChildAt(0);
      paramInt3 -= paramInt1;
      paramInt4 -= paramInt2;
      if (this.jdField_a_of_type_AndroidHardwareCamera$Size == null) {
        break label93;
      }
      paramInt2 = this.jdField_a_of_type_AndroidHardwareCamera$Size.width;
      paramInt1 = this.jdField_a_of_type_AndroidHardwareCamera$Size.height;
    }
    for (;;)
    {
      if (paramInt3 * paramInt1 <= paramInt4 * paramInt2) {}
      for (paramInt3 = paramInt4 * paramInt2 / paramInt1;; paramInt3 = paramInt1 * paramInt3 / paramInt2)
      {
        localView.layout(0, 0, paramInt2, paramInt1);
        return;
      }
      label93:
      paramInt1 = paramInt4;
      paramInt2 = paramInt3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = resolveSize(getSuggestedMinimumWidth(), paramInt1);
    paramInt2 = resolveSize(getSuggestedMinimumHeight(), paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt2 != 0)) {
      this.jdField_a_of_type_AndroidHardwareCamera$Size = a(this.jdField_a_of_type_JavaUtilList, paramInt1, paramInt2);
    }
  }
  
  public void setCamera(Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidHardwareCamera = paramCamera;
    if (this.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_AndroidHardwareCamera.getParameters().getSupportedPreviewSizes();
      requestLayout();
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
      return;
    }
    paramSurfaceHolder = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
    paramSurfaceHolder.setPreviewSize(this.jdField_a_of_type_AndroidHardwareCamera$Size.width, this.jdField_a_of_type_AndroidHardwareCamera$Size.height);
    requestLayout();
    if (Build.VERSION.SDK_INT > 7) {
      this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(90);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setParameters(paramSurfaceHolder);
      this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
      return;
      paramSurfaceHolder.set("orientation", "portrait");
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(paramSurfaceHolder);
      }
      return;
    }
    catch (IOException paramSurfaceHolder)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("CameraView", 2, "IOException caused by setPreviewDisplay()", paramSurfaceHolder);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.widget.CameraView
 * JD-Core Version:    0.7.0.1
 */