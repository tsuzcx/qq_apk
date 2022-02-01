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
  private float[] arShaderPlanOffset;
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
  
  public ARManager(List<GLBItemJava> paramList, boolean paramBoolean, float[] paramArrayOfFloat)
  {
    this.isAR3DMaterial = paramBoolean;
    this.arShaderPlanOffset = paramArrayOfFloat;
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
      if ((this.arFrameInfo != null) && (!this.arFrameInfo.planeList.isEmpty()))
      {
        paramAIAttr = this.filamentJNI.getCamera();
        paramAIAttr.setModelMatrix(this.arFrameInfo.cameraModelMatrix);
        float[] arrayOfFloat = new float[16];
        Matrix.multiplyMM(arrayOfFloat, this.arFrameInfo.projectionMatrix, new float[] { 0.9998477F, 0.01745241F, 0.0F, 0.0F, -0.01745241F, 0.9998477F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F });
        paramAIAttr.setCustomProjection(this.arFrameInfo.float2double(arrayOfFloat), paramAIAttr.getNear(), paramAIAttr.getCullingFar());
        paramAIAttr = this.filamentJNI;
        float f1 = ((ArFrameInfo.Plane)this.arFrameInfo.planeList.get(0)).arbitraryPoint[0];
        float f2 = this.arShaderPlanOffset[0];
        float f3 = ((ArFrameInfo.Plane)this.arFrameInfo.planeList.get(0)).arbitraryPoint[1];
        float f4 = this.arShaderPlanOffset[1];
        float f5 = ((ArFrameInfo.Plane)this.arFrameInfo.planeList.get(0)).arbitraryPoint[2];
        float f6 = this.arShaderPlanOffset[2];
        arrayOfFloat = ((ArFrameInfo.Plane)this.arFrameInfo.planeList.get(0)).normal;
        paramAIAttr.showArShadowPlane(new float[] { f1 + f2, f3 + f4, f5 + f6 }, arrayOfFloat);
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
        int i = 0;
        if (i < this.glbList.size())
        {
          GLBItemJava localGLBItemJava = (GLBItemJava)this.glbList.get(i);
          if (localGLBItemJava.arTranslateType == 1) {
            this.filamentJNI.setHitTestAfterUnprojection(i, new float[] { this.midPoint[0] + localGLBItemJava.translate[0], this.midPoint[1] + localGLBItemJava.translate[1], this.midPoint[2] + localGLBItemJava.translate[2] });
          }
          for (;;)
          {
            this.filamentJNI.setFilamentAssetScale(i, localGLBItemJava.scale[0], localGLBItemJava.scaleRange);
            i += 1;
            break;
            this.filamentJNI.setHitTestAfterUnprojection(i, this.midPoint);
          }
        }
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
  
  public void setArModelRotate(float[] paramArrayOfFloat)
  {
    if (!this.isAR3DMaterial) {}
    for (;;)
    {
      return;
      if (this.filamentJNI != null)
      {
        int i = 0;
        while (i < this.glbList.size())
        {
          this.filamentJNI.setFilamentAssetRotate(i, paramArrayOfFloat);
          i += 1;
        }
      }
    }
  }
  
  public void setArModelScale(float paramFloat)
  {
    if (!this.isAR3DMaterial) {}
    for (;;)
    {
      return;
      paramFloat = (paramFloat - 1.0F) / 2.0F;
      if (this.filamentJNI != null)
      {
        int i = 0;
        while (i < this.glbList.size())
        {
          float[] arrayOfFloat = ((GLBItemJava)this.glbList.get(i)).scaleRange;
          this.filamentJNI.setFilamentAssetScale(i, 1.0F + paramFloat, arrayOfFloat);
          i += 1;
        }
      }
    }
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
    for (;;)
    {
      return;
      if (this.filamentJNI != null)
      {
        int i = 0;
        while (i < this.glbList.size())
        {
          GLBItemJava localGLBItemJava = (GLBItemJava)this.glbList.get(i);
          if (localGLBItemJava.arTranslateType == 1)
          {
            int j = 0;
            while (j < 3)
            {
              paramArrayOfFloat[j] += localGLBItemJava.translate[j];
              j += 1;
            }
          }
          this.filamentJNI.setHitTestAfterUnprojection(i, paramArrayOfFloat);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.ARManager
 * JD-Core Version:    0.7.0.1
 */