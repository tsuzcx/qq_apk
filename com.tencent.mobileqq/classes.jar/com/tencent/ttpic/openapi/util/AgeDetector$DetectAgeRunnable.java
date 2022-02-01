package com.tencent.ttpic.openapi.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.ttpic.facedetect.AgeType;
import com.tencent.ytFaceAttr.YTFaceAttr;
import com.tencent.ytFaceAttr.YTFaceAttr.FaceAttr;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

class AgeDetector$DetectAgeRunnable
  implements Runnable
{
  private byte[] detectData;
  private Vector<AgeDetector.AgeDetectInfo> detectInfos;
  YTFaceAttr.FaceAttr faceAttr;
  int faceCount = 0;
  int heightData = 0;
  private ConcurrentHashMap<Long, AgeDetector.AgeResultInfo> mValueHashMap;
  int widthData = 0;
  YTFaceAttr ytFaceAttr1;
  
  private AgeDetector$DetectAgeRunnable(AgeDetector paramAgeDetector) {}
  
  public void clear()
  {
    if (AgeDetector.access$100(this.this$0))
    {
      AgeDetector.access$202(this.this$0, true);
      return;
    }
    this.detectData = null;
    ConcurrentHashMap localConcurrentHashMap = this.mValueHashMap;
    if (localConcurrentHashMap != null)
    {
      localConcurrentHashMap.clear();
      AgeDetector.access$202(this.this$0, false);
    }
  }
  
  public int getAgeByFaceID(long paramLong)
  {
    ConcurrentHashMap localConcurrentHashMap = this.mValueHashMap;
    if ((localConcurrentHashMap != null) && (localConcurrentHashMap.get(Long.valueOf(paramLong)) != null)) {
      return ((AgeDetector.AgeResultInfo)this.mValueHashMap.get(Long.valueOf(paramLong))).ageResult;
    }
    return AgeType.DEFAULT.value;
  }
  
  public void reset()
  {
    if (AgeDetector.access$100(this.this$0))
    {
      AgeDetector.access$302(this.this$0, true);
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = this.mValueHashMap;
    if (localConcurrentHashMap != null)
    {
      localConcurrentHashMap.clear();
      AgeDetector.access$302(this.this$0, false);
    }
  }
  
  public void run()
  {
    if (AgeDetector.access$400())
    {
      if (this.detectInfos == null) {
        return;
      }
      this.this$0.updateDetectStatus(true);
      if (this.detectData.length != 0)
      {
        AgeDetector.access$502(this.this$0, Bitmap.createBitmap(this.widthData, this.heightData, Bitmap.Config.ARGB_8888));
        AgeDetector.access$500(this.this$0).copyPixelsFromBuffer(ByteBuffer.wrap(this.detectData));
      }
      Iterator localIterator = this.detectInfos.iterator();
      while (localIterator.hasNext())
      {
        AgeDetector.AgeDetectInfo localAgeDetectInfo = (AgeDetector.AgeDetectInfo)localIterator.next();
        if (this.mValueHashMap == null) {
          this.mValueHashMap = new ConcurrentHashMap();
        }
        AgeDetector.AgeResultInfo localAgeResultInfo = (AgeDetector.AgeResultInfo)this.mValueHashMap.get(Long.valueOf(localAgeDetectInfo.faceID));
        if ((localAgeDetectInfo != null) && (localAgeDetectInfo.isInImage) && ((localAgeResultInfo == null) || (localAgeResultInfo.needDetectAge())))
        {
          if (this.ytFaceAttr1 == null) {
            this.ytFaceAttr1 = new YTFaceAttr();
          }
          if (this.faceAttr == null) {
            this.faceAttr = new YTFaceAttr.FaceAttr();
          }
          this.faceAttr.ageRes = AgeType.DEFAULT.value;
          if (this.ytFaceAttr1.predictFaceAttrBitmap(AgeDetector.access$500(this.this$0), localAgeDetectInfo.points, 0, this.faceAttr) == 0)
          {
            localAgeDetectInfo.ageType = this.faceAttr.ageRes;
            Object localObject = localAgeResultInfo;
            if (localAgeResultInfo == null) {
              localObject = new AgeDetector.AgeResultInfo(this.this$0, localAgeDetectInfo.faceID);
            }
            if (AgeDetector.access$600(this.this$0)) {
              ((AgeDetector.AgeResultInfo)localObject).setAgeResult(localAgeDetectInfo.ageType);
            } else {
              ((AgeDetector.AgeResultInfo)localObject).updateAge(localAgeDetectInfo.ageType);
            }
            this.mValueHashMap.put(Long.valueOf(localAgeDetectInfo.faceID), localObject);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("faceID:");
            ((StringBuilder)localObject).append(localAgeDetectInfo.faceID);
            ((StringBuilder)localObject).append(",detected age:");
            ((StringBuilder)localObject).append(localAgeDetectInfo.ageType);
            Log.i("AgeDetector", ((StringBuilder)localObject).toString());
          }
          localAgeDetectInfo.points = null;
        }
      }
      this.detectInfos.clear();
      this.this$0.updateDetectStatus(false);
      if (AgeDetector.access$200(this.this$0)) {
        clear();
      }
      if (AgeDetector.access$300(this.this$0)) {
        reset();
      }
    }
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = this.detectData;
    if ((arrayOfByte == null) || (arrayOfByte.length < paramArrayOfByte.length)) {
      this.detectData = new byte[paramArrayOfByte.length];
    }
    System.arraycopy(paramArrayOfByte, 0, this.detectData, 0, paramArrayOfByte.length);
  }
  
  public void setFaceCount(int paramInt)
  {
    this.faceCount = paramInt;
  }
  
  public void setImgWH(int paramInt1, int paramInt2)
  {
    this.widthData = paramInt1;
    this.heightData = paramInt2;
  }
  
  public void setKeyPointLocationByIndex(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, boolean paramBoolean, long paramLong)
  {
    Object localObject = this.mValueHashMap;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong)) != null) && (!((AgeDetector.AgeResultInfo)this.mValueHashMap.get(Long.valueOf(paramLong))).needDetectAge())) {
      return;
    }
    this.faceCount = (paramInt1 + 1);
    if (this.detectInfos == null) {
      this.detectInfos = new Vector();
    }
    localObject = new AgeDetector.AgeDetectInfo(this.this$0, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramBoolean, paramLong);
    this.detectInfos.add(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.AgeDetector.DetectAgeRunnable
 * JD-Core Version:    0.7.0.1
 */