package com.tencent.ttpic.openapi;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.ttpic.facedetect.FaceActionCounterListener;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PTDetectInfo$Builder
{
  private AIAttr aiAttr;
  private List<PointF> bodyPoints;
  private Map<Integer, FaceActionCounter> faceActionCounter;
  private float[] faceAngles;
  private FaceActionCounterListener faceDetector;
  private float[] faceKitFaceRotation;
  private float[] faceKitFaceVertices;
  private List<PointF> facePoints;
  private FaceStatus faceStatus;
  private int[] featureIndices;
  private int gestureTrigger = -1;
  private Map<Integer, Integer> handActionCounter;
  private List<PointF> handPoints;
  private boolean isFreezeInfo = false;
  private Frame noseOcclusionFrame;
  private float phoneAngle;
  private float[] pointsVis;
  private float realPhoneAngle;
  private List<PointF> starPoints;
  private long timestamp;
  private Set<Integer> triggeredExpression;
  
  public Builder aiAttr(AIAttr paramAIAttr)
  {
    this.aiAttr = paramAIAttr;
    return this;
  }
  
  public Builder bodyPoints(List<PointF> paramList)
  {
    this.bodyPoints = paramList;
    return this;
  }
  
  public PTDetectInfo build()
  {
    return new PTDetectInfo(this);
  }
  
  public Builder faceActionCounter(Map<Integer, FaceActionCounter> paramMap)
  {
    this.faceActionCounter = paramMap;
    return this;
  }
  
  public Builder faceAngles(float[] paramArrayOfFloat)
  {
    this.faceAngles = paramArrayOfFloat;
    return this;
  }
  
  public Builder faceDetector(FaceActionCounterListener paramFaceActionCounterListener)
  {
    this.faceDetector = paramFaceActionCounterListener;
    return this;
  }
  
  public Builder faceKitFaceRotation(float[] paramArrayOfFloat)
  {
    this.faceKitFaceRotation = paramArrayOfFloat;
    return this;
  }
  
  public Builder faceKitFaceVertices(float[] paramArrayOfFloat)
  {
    this.faceKitFaceVertices = paramArrayOfFloat;
    return this;
  }
  
  public Builder facePoints(List<PointF> paramList)
  {
    this.facePoints = paramList;
    return this;
  }
  
  public Builder faceStatus(FaceStatus paramFaceStatus)
  {
    this.faceStatus = paramFaceStatus;
    return this;
  }
  
  public Builder featureIndices(int[] paramArrayOfInt)
  {
    this.featureIndices = paramArrayOfInt;
    return this;
  }
  
  public Builder gestureTrigger(int paramInt)
  {
    this.gestureTrigger = paramInt;
    return this;
  }
  
  public Builder handActionCounter(Map<Integer, Integer> paramMap)
  {
    this.handActionCounter = paramMap;
    return this;
  }
  
  public Builder handPoints(List<PointF> paramList)
  {
    this.handPoints = paramList;
    return this;
  }
  
  public Builder isFreezeInfo(boolean paramBoolean)
  {
    this.isFreezeInfo = paramBoolean;
    return this;
  }
  
  public Builder noseOcclusionFrame(Frame paramFrame)
  {
    this.noseOcclusionFrame = paramFrame;
    return this;
  }
  
  public Builder phoneAngle(float paramFloat)
  {
    this.phoneAngle = paramFloat;
    return this;
  }
  
  public Builder pointsVis(Float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0)) {
      return this;
    }
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      arrayOfFloat[i] = Float.parseFloat(paramArrayOfFloat[i].toString());
      i += 1;
    }
    this.pointsVis = arrayOfFloat;
    return this;
  }
  
  public Builder realPhoneAngle(float paramFloat)
  {
    this.realPhoneAngle = paramFloat;
    return this;
  }
  
  public Builder starPoints(List<PointF> paramList)
  {
    this.starPoints = paramList;
    return this;
  }
  
  public Builder timestamp(long paramLong)
  {
    this.timestamp = paramLong;
    return this;
  }
  
  public Builder triggeredExpression(Set<Integer> paramSet)
  {
    this.triggeredExpression = paramSet;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTDetectInfo.Builder
 * JD-Core Version:    0.7.0.1
 */