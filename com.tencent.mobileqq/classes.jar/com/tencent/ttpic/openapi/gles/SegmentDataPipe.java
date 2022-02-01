package com.tencent.ttpic.openapi.gles;

import android.graphics.PointF;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SegmentDataPipe
{
  public static final int BUFFER_BUSY = 1;
  public static final int BUFFER_FREE = 0;
  public static final int BUFFER_READY = 2;
  public static final String FACE_DETECT_TIME = "sdk_face_detect_time";
  public static final String SEGMENT_TIME = "sdk_background_detect_time";
  public static final String TAG = "SegmentDataPipe";
  private static float[] sMtxIdentity = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public List<float[]> allFaceAngles;
  public List<List<PointF>> allFacePoints;
  public List<List<PointF>> allIrisPoints;
  public List<Float[]> allPointsVis;
  public int[] autoBrightnessCurve;
  public int[] autoContrastCurve;
  public int[] curve;
  public Map<String, Long> detectTimes = new HashMap();
  public List<Set<Integer>> expressions = new ArrayList();
  public List<float[]> face3DRotationArray = new ArrayList();
  public List<float[]> face3DVerticesArray = new ArrayList();
  public Map<Integer, FaceActionCounter> faceActionCounter;
  public double faceAverageL = 60.0D;
  public List<FaceInfo> faceInfos;
  public List<float[]> faceKitVerticesArray = new ArrayList();
  public PointF facePiont2DCenter = new PointF(0.0F, 0.0F);
  public List<FaceStatus> faceStatus;
  public List<int[]> featureIndicesArray = new ArrayList();
  public Pair<Integer, int[]> histogram;
  public byte[] mData;
  public Frame mMaskFrame = new Frame();
  public Frame mTexFrame = new Frame();
  public AtomicInteger mTextureDataFlag = new AtomicInteger(0);
  public long mTimestamp;
  public Set<Integer> mTriggeredExpressionType = new HashSet();
  public Map<String, String[]> recordFaceInfo = new HashMap();
  public float[] rgbGain = { 1.0F, 1.0F, 1.0F };
  public Frame starMaskFrame;
  public List<PointF> starPoints;
  
  public int getTexureCurrentStatus()
  {
    return this.mTextureDataFlag.getAndAdd(0);
  }
  
  public void getTransformMatrix(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length == 16)
    {
      float[] arrayOfFloat = sMtxIdentity;
      System.arraycopy(arrayOfFloat, 0, paramArrayOfFloat, 0, arrayOfFloat.length);
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public boolean isBusy()
  {
    return this.mTextureDataFlag.get() == 1;
  }
  
  public boolean isReady()
  {
    return this.mTextureDataFlag.get() == 2;
  }
  
  public void makeBusy()
  {
    this.mTextureDataFlag.getAndSet(1);
  }
  
  public void makeDataReady()
  {
    this.mTextureDataFlag.getAndSet(2);
  }
  
  public void makeFree()
  {
    this.mTextureDataFlag.getAndSet(0);
  }
  
  public void release()
  {
    this.mTexFrame.clear();
    this.mMaskFrame.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.gles.SegmentDataPipe
 * JD-Core Version:    0.7.0.1
 */