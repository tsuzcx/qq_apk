package com.tencent.ttpic.openapi.filter;

import java.util.HashMap;
import org.light.CameraController.CameraViewType;
import org.light.CameraController.CmShowCallback;
import org.light.CameraController.DisplayType;
import org.light.CameraController.MorphType;

public abstract interface ICMShowHandle
{
  public abstract void cmShowSetKapuAnimation(String paramString, CameraController.CmShowCallback paramCmShowCallback);
  
  public abstract void cmShowSetKapuCameraViewType(CameraController.CameraViewType paramCameraViewType);
  
  public abstract void cmShowSetKapuDisplayType(CameraController.DisplayType paramDisplayType);
  
  public abstract void cmShowSetKapuModel(HashMap<String, String> paramHashMap, String paramString, CameraController.CmShowCallback paramCmShowCallback);
  
  public abstract void cmShowUpdateKapuMorph(CameraController.MorphType paramMorphType);
  
  public abstract void cmShowUpdateTouchRotate(float[] paramArrayOfFloat);
  
  public abstract void cmShowUpdateTouchScale(float paramFloat);
  
  public abstract void cmShowUpdateViewParams(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.ICMShowHandle
 * JD-Core Version:    0.7.0.1
 */