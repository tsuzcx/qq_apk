package com.tencent.ttpic.openapi;

import android.graphics.PointF;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PTFaceAttr$Builder
{
  private List<Integer> ageList;
  private int[] autoBrightnessCurve;
  private int[] autoContrastCurve;
  private List<List<PointF>> bodyPoints;
  private int[] curve;
  private byte[] data;
  private Map<String, Long> detectTimes;
  private List<Set<Integer>> expressions;
  private List<float[]> face3DRotationArray;
  private List<float[]> face3DVerticesArray;
  private Map<Integer, FaceActionCounter> faceActionCounter;
  private List<float[]> faceAngles = new ArrayList();
  private double faceAverageL = 60.0D;
  private int faceDetHeight = 0;
  private int faceDetRotation = 0;
  private int faceDetWidth = 0;
  private double faceDetectScale = 1.0D;
  private VideoPreviewFaceOutlineDetector faceDetector;
  private Map<PTFaceAttr.PTExpression, Boolean> faceExpression;
  private List<FaceInfo> faceInfos;
  private List<float[]> faceKitVerticesArray;
  private PointF facePiont2DCenter;
  private List<List<PointF>> facePoint94;
  private List<List<PointF>> facePoints = new ArrayList();
  private List<FaceStatus> faceStatusList;
  private List<int[]> featureIndicesArray;
  private List<Integer> genderList;
  private Pair<Integer, int[]> histogram;
  private List<List<PointF>> irisPoints;
  private boolean isPhoneFlatHorizontal;
  private int lastFaceDetectedPhoneRotation = 0;
  private Frame origFrame;
  private List<Float[]> pointsVis;
  private Map<String, String[]> recordFaceInfo = new HashMap();
  private float[] rgbGain = { 1.0F, 1.0F, 1.0F };
  private int rotation;
  private List<LinkedList<FaceInfo>> shookFaceInfos = new ArrayList();
  private int srcRotation;
  private Frame starMaskFrame;
  private List<PointF> starPoints;
  private long timeStamp;
  private Set<Integer> triggeredExpression = new HashSet();
  
  public Builder ageList(List<Integer> paramList)
  {
    this.ageList = paramList;
    return this;
  }
  
  public Builder autoBrightnessCurve(int[] paramArrayOfInt)
  {
    this.autoBrightnessCurve = paramArrayOfInt;
    return this;
  }
  
  public Builder autoContrastCurve(int[] paramArrayOfInt)
  {
    this.autoContrastCurve = paramArrayOfInt;
    return this;
  }
  
  public Builder bodyPoints(List<List<PointF>> paramList)
  {
    this.bodyPoints = paramList;
    return this;
  }
  
  public PTFaceAttr build()
  {
    return new PTFaceAttr(this);
  }
  
  public Builder curve(int[] paramArrayOfInt)
  {
    this.curve = paramArrayOfInt;
    return this;
  }
  
  public Builder data(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    return this;
  }
  
  public Builder detectTimes(Map paramMap)
  {
    this.detectTimes = paramMap;
    return this;
  }
  
  public Builder expressions(List<Set<Integer>> paramList)
  {
    this.expressions = paramList;
    return this;
  }
  
  public Builder face3DRotationArray(List<float[]> paramList)
  {
    this.face3DRotationArray = paramList;
    return this;
  }
  
  public Builder face3DVerticesArray(List<float[]> paramList)
  {
    this.face3DVerticesArray = paramList;
    return this;
  }
  
  public Builder faceActionCounter(Map<Integer, FaceActionCounter> paramMap)
  {
    this.faceActionCounter = paramMap;
    return this;
  }
  
  public Builder faceAngles(List<float[]> paramList)
  {
    this.faceAngles = paramList;
    return this;
  }
  
  public Builder faceAverageL(double paramDouble)
  {
    this.faceAverageL = paramDouble;
    return this;
  }
  
  public Builder faceDetHeight(int paramInt)
  {
    this.faceDetHeight = paramInt;
    return this;
  }
  
  public Builder faceDetRotation(int paramInt)
  {
    this.faceDetRotation = paramInt;
    return this;
  }
  
  public Builder faceDetWidth(int paramInt)
  {
    this.faceDetWidth = paramInt;
    return this;
  }
  
  public Builder faceDetectScale(double paramDouble)
  {
    this.faceDetectScale = paramDouble;
    return this;
  }
  
  public Builder faceDetector(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector)
  {
    this.faceDetector = paramVideoPreviewFaceOutlineDetector;
    return this;
  }
  
  public Builder faceExpression(Map<PTFaceAttr.PTExpression, Boolean> paramMap)
  {
    this.faceExpression = paramMap;
    return this;
  }
  
  public Builder faceInfoList(List<FaceInfo> paramList)
  {
    this.faceInfos = paramList;
    return this;
  }
  
  public Builder faceKitVerticesArray(List<float[]> paramList)
  {
    this.faceKitVerticesArray = paramList;
    return this;
  }
  
  public Builder facePiont2DCenter(PointF paramPointF)
  {
    this.facePiont2DCenter = paramPointF;
    return this;
  }
  
  public Builder facePoint94(List<List<PointF>> paramList)
  {
    this.facePoint94 = paramList;
    return this;
  }
  
  public Builder facePoints(List<List<PointF>> paramList)
  {
    this.facePoints = paramList;
    return this;
  }
  
  public Builder faceStatusList(List<FaceStatus> paramList)
  {
    this.faceStatusList = paramList;
    return this;
  }
  
  public Builder featureIndicesArray(List<int[]> paramList)
  {
    this.featureIndicesArray = paramList;
    return this;
  }
  
  public Builder genderList(List<Integer> paramList)
  {
    this.genderList = paramList;
    return this;
  }
  
  public Builder histogram(Pair<Integer, int[]> paramPair)
  {
    this.histogram = paramPair;
    return this;
  }
  
  public Builder irisPoints(List<List<PointF>> paramList)
  {
    this.irisPoints = paramList;
    return this;
  }
  
  public Builder isPhoneFlatHorizontal(boolean paramBoolean)
  {
    this.isPhoneFlatHorizontal = paramBoolean;
    return this;
  }
  
  public Builder lastFaceDetectedPhoneRotation(int paramInt)
  {
    this.lastFaceDetectedPhoneRotation = paramInt;
    return this;
  }
  
  public Builder origFrame(Frame paramFrame)
  {
    this.origFrame = paramFrame;
    return this;
  }
  
  public Builder pointsVis(List<Float[]> paramList)
  {
    this.pointsVis = paramList;
    return this;
  }
  
  public Builder recordFaceInfo(Map<String, String[]> paramMap)
  {
    this.recordFaceInfo = paramMap;
    return this;
  }
  
  public Builder rgbGain(float[] paramArrayOfFloat)
  {
    this.rgbGain = paramArrayOfFloat;
    return this;
  }
  
  public Builder rotation(int paramInt)
  {
    this.rotation = paramInt;
    return this;
  }
  
  public Builder shookFaceInfos(List<LinkedList<FaceInfo>> paramList)
  {
    this.shookFaceInfos = paramList;
    return this;
  }
  
  public Builder srcRotation(int paramInt)
  {
    this.srcRotation = paramInt;
    return this;
  }
  
  public Builder starMaskFrame(Frame paramFrame)
  {
    this.starMaskFrame = paramFrame;
    return this;
  }
  
  public Builder starPoints(List<PointF> paramList)
  {
    this.starPoints = paramList;
    return this;
  }
  
  public Builder timeStamp(long paramLong)
  {
    this.timeStamp = paramLong;
    return this;
  }
  
  public Builder triggeredExpression(Set<Integer> paramSet)
  {
    this.triggeredExpression = paramSet;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTFaceAttr.Builder
 * JD-Core Version:    0.7.0.1
 */