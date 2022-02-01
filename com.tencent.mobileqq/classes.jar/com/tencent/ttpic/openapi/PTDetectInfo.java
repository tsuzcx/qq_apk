package com.tencent.ttpic.openapi;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.ttpic.facedetect.FaceActionCounterListener;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PTDetectInfo
{
  public AIAttr aiAttr;
  public double audioScaleFactor;
  public List<PointF> bodyPoints;
  public float[] catFaceAngles;
  public List<PointF> catFacePoints;
  public Frame displacementMaskFrame;
  public float[] face3DRotationArray;
  public float[] face3DVerticesArray;
  public Map<Integer, FaceActionCounter> faceActionCounter;
  public float[] faceAngles;
  public FaceActionCounterListener faceDetector;
  public float[] faceKitFaceRotation;
  public float[] faceKitFaceVertices;
  public List<PointF> facePoints;
  public FaceStatus faceStatus;
  public int[] featureIndices;
  public int frameIndex;
  public int gestureTrigger = -1;
  public Map<Integer, Integer> handActionCounter;
  public List<PointF> handPoints;
  public boolean isFreezeInfo = false;
  public boolean needRender;
  public Frame noseOcclusionFrame;
  public float phoneAngle;
  public float[] pointsVis;
  public int randomGroupValue;
  public float realPhoneAngle;
  public ArrayList<RedPacketPosition> redPacketPositions;
  public List<PointF> starPoints;
  public long timestamp;
  public List<PointF> transformPoints;
  public Set<Integer> triggeredExpression;
  
  private PTDetectInfo() {}
  
  public PTDetectInfo(PTDetectInfo.Builder paramBuilder)
  {
    this.facePoints = PTDetectInfo.Builder.access$000(paramBuilder);
    this.faceAngles = PTDetectInfo.Builder.access$100(paramBuilder);
    this.pointsVis = PTDetectInfo.Builder.access$200(paramBuilder);
    this.faceActionCounter = PTDetectInfo.Builder.access$300(paramBuilder);
    this.handPoints = PTDetectInfo.Builder.access$400(paramBuilder);
    this.handActionCounter = PTDetectInfo.Builder.access$500(paramBuilder);
    this.triggeredExpression = PTDetectInfo.Builder.access$600(paramBuilder);
    this.bodyPoints = PTDetectInfo.Builder.access$700(paramBuilder);
    this.catFacePoints = PTDetectInfo.Builder.access$800(paramBuilder);
    this.catFaceAngles = PTDetectInfo.Builder.access$900(paramBuilder);
    this.phoneAngle = PTDetectInfo.Builder.access$1000(paramBuilder);
    this.realPhoneAngle = PTDetectInfo.Builder.access$1100(paramBuilder);
    this.timestamp = PTDetectInfo.Builder.access$1200(paramBuilder);
    this.faceDetector = PTDetectInfo.Builder.access$1300(paramBuilder);
    this.starPoints = PTDetectInfo.Builder.access$1400(paramBuilder);
    this.faceStatus = PTDetectInfo.Builder.access$1500(paramBuilder);
    this.gestureTrigger = PTDetectInfo.Builder.access$1600(paramBuilder);
    this.isFreezeInfo = PTDetectInfo.Builder.access$1700(paramBuilder);
    this.faceKitFaceVertices = PTDetectInfo.Builder.access$1800(paramBuilder);
    this.faceKitFaceRotation = PTDetectInfo.Builder.access$1900(paramBuilder);
    this.face3DVerticesArray = PTDetectInfo.Builder.access$2000(paramBuilder);
    this.face3DRotationArray = PTDetectInfo.Builder.access$2100(paramBuilder);
    this.featureIndices = PTDetectInfo.Builder.access$2200(paramBuilder);
    this.aiAttr = PTDetectInfo.Builder.access$2300(paramBuilder);
    this.noseOcclusionFrame = PTDetectInfo.Builder.access$2400(paramBuilder);
    this.displacementMaskFrame = PTDetectInfo.Builder.access$2500(paramBuilder);
    this.randomGroupValue = PTDetectInfo.Builder.access$2600(paramBuilder);
    this.frameIndex = PTDetectInfo.Builder.access$2700(paramBuilder);
    this.audioScaleFactor = PTDetectInfo.Builder.access$2800(paramBuilder);
    this.redPacketPositions = PTDetectInfo.Builder.access$2900(paramBuilder);
    this.needRender = PTDetectInfo.Builder.access$3000(paramBuilder);
    this.transformPoints = paramBuilder.transformPoints;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTDetectInfo
 * JD-Core Version:    0.7.0.1
 */