package com.tencent.ttpic.util.youtu;

import android.graphics.PointF;
import android.util.Log;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.facedetect.FaceDetector.DETECT_TYPE;
import com.tencent.ttpic.facedetect.FaceInfo;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.RetrieveDataManager;
import com.tencent.ttpic.util.RetrieveDataManager.DATA_TYPE;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class VideoPreviewFaceOutlineDetector
  extends FaceDetector
{
  private static final PointF POINT_ZERO = new PointF();
  private static final String TAG = VideoPreviewFaceOutlineDetector.class.getSimpleName();
  private static final VideoPreviewFaceOutlineDetector mVideoPreviewFaceOutlineDetector = new VideoPreviewFaceOutlineDetector();
  private int mDetectType = FaceDetector.DETECT_TYPE.DETECT_TYPE_NONE.value;
  private VideoFaceDetector mFaceDetect;
  private String mPath;
  
  private float getFakeFaceValues(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 0.0F;
    case 1: 
      return 0.18F + new Random().nextFloat() * 0.12F;
    case 2: 
      return new Random().nextFloat();
    case 4: 
      return new Random().nextFloat() * 0.2F + 0.8F;
    }
    return new Random().nextFloat() * 0.2F + 0.8F;
  }
  
  public static VideoPreviewFaceOutlineDetector getInstance()
  {
    return mVideoPreviewFaceOutlineDetector;
  }
  
  public void destroy()
  {
    super.destroy();
    synchronized (mDetectLock)
    {
      if (this.mFaceDetect != null)
      {
        this.mDetectType = FaceDetector.DETECT_TYPE.DETECT_TYPE_NONE.value;
        this.mFaceDetect.destroy();
        this.mFaceDetect = null;
      }
      return;
    }
  }
  
  public void doFaceDetect(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != paramInt1 * paramInt2 * 4)) {
      return;
    }
    synchronized (mDetectLock)
    {
      if (this.mFaceDetect != null) {
        this.mFaceDetect.doFaceDetect(paramArrayOfByte, paramInt1, paramInt2);
      }
      return;
    }
  }
  
  public void doFaceDetectByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != paramInt1 * paramInt2)) {
      return;
    }
    synchronized (mDetectLock)
    {
      if (this.mFaceDetect != null) {
        this.mFaceDetect.doFaceDetectByY(paramArrayOfByte, paramInt1, paramInt2);
      }
      return;
    }
  }
  
  public void doTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.mFaceDetect == null)
    {
      long l = System.currentTimeMillis();
      init();
      Log.d("fdinit", "fdinit : " + (System.currentTimeMillis() - l) + "ms");
    }
    if (this.mFaceDetect == null) {
      return;
    }
    this.mTrackFrameCount += 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfByte != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfByte.length == paramInt1 * paramInt2 * 4) {
        localObject1 = this.mFaceDetect.doTrack(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    updatePointsAndAngles((FaceStatus[])localObject1);
    this.mExpressionDetectorObject.addFaces(this.faceInfos);
    updateActionCount();
    updateActionStatusChanged();
  }
  
  public byte[] doTrackByTexture(int paramInt1, final int paramInt2, final int paramInt3)
  {
    BenchUtil.benchStart("gpu2cpu");
    final byte[] arrayOfByte = RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, paramInt1, paramInt2, paramInt3);
    BenchUtil.benchEnd("gpu2cpu");
    BenchUtil.benchStart("doTrack");
    doTrack(arrayOfByte, paramInt2, paramInt3);
    BenchUtil.benchEnd("doTrack");
    if (needDetectFace()) {
      postJob(new Runnable()
      {
        public void run()
        {
          BenchUtil.benchStart("faceDetect");
          VideoPreviewFaceOutlineDetector.this.doFaceDetect(arrayOfByte, paramInt2, paramInt3);
          BenchUtil.benchEnd("faceDetect");
        }
      });
    }
    return arrayOfByte;
  }
  
  public void doTrackProcesesByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.mFaceDetect == null)
    {
      long l = System.currentTimeMillis();
      init();
      Log.d("fdinit", "fdinit : " + (System.currentTimeMillis() - l) + "ms");
    }
    if (this.mFaceDetect == null) {
      return;
    }
    this.mTrackFrameCount += 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfByte != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfByte.length == paramInt1 * paramInt2) {
        localObject1 = this.mFaceDetect.doTrackByY(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    updatePointsAndAngles((FaceStatus[])localObject1);
    updateActionCount();
    updateActionStatusChanged();
  }
  
  public RetrieveDataManager.DATA_TYPE getDataType()
  {
    return RetrieveDataManager.DATA_TYPE.RGBA;
  }
  
  public List<LinkedList<FaceInfo>> getFaceInfos()
  {
    return this.mExpressionDetectorObject.mShookQueueList;
  }
  
  public float getFaceValues(int paramInt1, int paramInt2)
  {
    return getFakeFaceValues(paramInt2);
  }
  
  public void init()
  {
    super.init();
    if (this.mFaceDetect == null) {
      synchronized (mDetectLock)
      {
        VideoFaceDetector localVideoFaceDetector = this.mFaceDetect;
        if (localVideoFaceDetector == null) {}
        try
        {
          this.mFaceDetect = new VideoFaceDetector(this.mPath);
          this.mFaceDetect.init();
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            this.mFaceDetect = null;
          }
        }
      }
    }
  }
  
  public boolean needDetectFaceValue()
  {
    return this.mDetectType != FaceDetector.DETECT_TYPE.DETECT_TYPE_NONE.value;
  }
  
  public void setFaceValueDetectType(int paramInt)
  {
    this.mDetectType = paramInt;
  }
  
  public void setModelPath(String paramString)
  {
    this.mPath = paramString;
  }
  
  public void setRefine(boolean paramBoolean)
  {
    if (this.mFaceDetect != null) {
      this.mFaceDetect.nativeSetRefine(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector
 * JD-Core Version:    0.7.0.1
 */