package com.tencent.ttpic.filament;

import android.graphics.PointF;
import com.google.android.filament.Camera;
import com.google.android.filament.FilamentJNI;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.ttpic.ar.sensor.representation.Matrix;
import com.tencent.ttpic.ar.sensor.representation.Vector4f;
import com.tencent.ttpic.model.ArFrameInfo;
import com.tencent.ttpic.model.ArFrameInfo.Plane;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.model.GLBItemJava;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ARManager
{
  private static final boolean ENABLE_TOUCH = false;
  private ArFrameInfo arFrameInfo;
  private int deviceOrientation = 0;
  private FilamentJNI filamentJNI;
  private List<GLBItemJava> glbList;
  private Map<Long, HitDragInfo> hitAssetMap = new HashMap();
  private boolean isAR3DMaterial;
  private boolean isAssetHit;
  private boolean isIninted;
  private boolean isTracked = false;
  private float[] midPoint = { 0.0F, 0.0F, 0.0F };
  private boolean touched;
  
  public ARManager(List<GLBItemJava> paramList, boolean paramBoolean)
  {
    this.isAR3DMaterial = paramBoolean;
    this.glbList = paramList;
  }
  
  private void clearNotHitAssets(long[] paramArrayOfLong1, long[] paramArrayOfLong2, Map<Long, HitDragInfo> paramMap)
  {
    int j = 0;
    HashSet localHashSet = new HashSet();
    int k = paramArrayOfLong2.length;
    int i = 0;
    while (i < k)
    {
      localHashSet.add(Long.valueOf(paramArrayOfLong2[i]));
      i += 1;
    }
    k = paramArrayOfLong1.length;
    i = j;
    while (i < k)
    {
      long l = paramArrayOfLong1[i];
      if (!localHashSet.contains(Long.valueOf(l))) {
        paramMap.remove(Long.valueOf(l));
      }
      i += 1;
    }
  }
  
  private Vector4f projectPoint(float[] paramArrayOfFloat, double[] paramArrayOfDouble)
  {
    paramArrayOfDouble = AlgoUtils.double2FloatArray(paramArrayOfDouble);
    float[] arrayOfFloat = new float[4];
    Matrix.multiplyMV(arrayOfFloat, paramArrayOfDouble, paramArrayOfFloat);
    return new Vector4f(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
  }
  
  private Vector4f unprojectPoint(PointF paramPointF, double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = AlgoUtils.double2FloatArray(paramArrayOfDouble);
    paramArrayOfDouble = new float[16];
    Matrix.invertM(paramArrayOfDouble, 0, arrayOfFloat, 0);
    float f1 = paramPointF.x / paramInt1;
    float f2 = paramPointF.y / paramInt2;
    paramPointF = new float[4];
    Matrix.multiplyMV(paramPointF, paramArrayOfDouble, new float[] { f1 * 2.0F - 1.0F, (1.0F - f2) * 2.0F - 1.0F, 0.9961997F, 1.0F });
    return new Vector4f(paramPointF[0] / paramPointF[3], paramPointF[1] / paramPointF[3], paramPointF[2] / paramPointF[3], paramPointF[3] / paramPointF[3]);
  }
  
  public void addTouchPoint(PointF paramPointF, int paramInt1, int paramInt2) {}
  
  public void arTracked()
  {
    this.isTracked = true;
  }
  
  public void changeViewMatrix(AIAttr paramAIAttr)
  {
    if (this.isAR3DMaterial)
    {
      this.arFrameInfo = ((ArFrameInfo)paramAIAttr.getRealtimeData(AEDetectorType.AR_DETECT.value));
      if (this.arFrameInfo != null)
      {
        paramAIAttr = this.filamentJNI.getCamera();
        paramAIAttr.setModelMatrix(this.arFrameInfo.cameraModelMatrix);
        float[] arrayOfFloat = new float[16];
        Matrix.multiplyMM(arrayOfFloat, this.arFrameInfo.projectionMatrix, new float[] { 0.9998477F, 0.01745241F, 0.0F, 0.0F, -0.01745241F, 0.9998477F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F });
        paramAIAttr.setCustomProjection(this.arFrameInfo.float2double(arrayOfFloat), paramAIAttr.getNear(), paramAIAttr.getCullingFar());
        this.filamentJNI.showArShadowPlane(((ArFrameInfo.Plane)this.arFrameInfo.planeList.get(0)).arbitraryPoint, ((ArFrameInfo.Plane)this.arFrameInfo.planeList.get(0)).normal);
      }
    }
  }
  
  public void getCurDeviceOrientation(PTFaceAttr paramPTFaceAttr)
  {
    switch (paramPTFaceAttr.getRotation())
    {
    default: 
      this.deviceOrientation = 0;
      return;
    case 90: 
      this.deviceOrientation = 1;
      return;
    case 180: 
      this.deviceOrientation = 2;
      return;
    }
    this.deviceOrientation = 3;
  }
  
  public void initArModleStatus()
  {
    if ((this.isAR3DMaterial) && (!this.isIninted))
    {
      this.isIninted = true;
      if (this.filamentJNI != null)
      {
        this.filamentJNI.setHitTestAfterUnprojection(this.midPoint);
        this.filamentJNI.setFilamentAssetScale(((GLBItemJava)this.glbList.get(0)).scale[0], ((GLBItemJava)this.glbList.get(0)).scaleRange);
      }
    }
  }
  
  public boolean isAR3DMaterial()
  {
    return this.isAR3DMaterial;
  }
  
  public boolean isArTracked()
  {
    return (this.isAR3DMaterial) && (!this.isTracked);
  }
  
  public void setArModelScale(float paramFloat)
  {
    if (!this.isAR3DMaterial) {}
    do
    {
      return;
      paramFloat = (paramFloat - 1.0F) / 2.0F;
    } while (this.filamentJNI == null);
    float[] arrayOfFloat = ((GLBItemJava)this.glbList.get(0)).scaleRange;
    this.filamentJNI.setFilamentAssetScale(paramFloat + 1.0F, arrayOfFloat);
  }
  
  public void setDownEventUnProjectionPoint(ArrayList<float[]> paramArrayList)
  {
    if (this.filamentJNI == null) {}
    float[] arrayOfFloat;
    do
    {
      return;
      while (!paramArrayList.hasNext())
      {
        this.filamentJNI.rotateArModelToFront(this.deviceOrientation);
        this.isAssetHit = false;
        paramArrayList = paramArrayList.iterator();
      }
      arrayOfFloat = (float[])paramArrayList.next();
    } while (this.filamentJNI.getHitTestFilamentAssets(arrayOfFloat).length <= 0);
    this.isAssetHit = true;
  }
  
  public void setFilamentJNI(FilamentJNI paramFilamentJNI)
  {
    this.filamentJNI = paramFilamentJNI;
  }
  
  public void setScreenMidPoint(float[] paramArrayOfFloat)
  {
    this.midPoint = paramArrayOfFloat;
  }
  
  public void setUnProjectionHitPoint(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (!this.isAR3DMaterial) {}
    do
    {
      return;
      if ((!paramBoolean) && (this.filamentJNI != null)) {
        this.filamentJNI.setHitTestAfterUnprojection(paramArrayOfFloat);
      }
    } while (this.filamentJNI == null);
    this.filamentJNI.setHitTestAfterUnprojection(paramArrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filament.ARManager
 * JD-Core Version:    0.7.0.1
 */