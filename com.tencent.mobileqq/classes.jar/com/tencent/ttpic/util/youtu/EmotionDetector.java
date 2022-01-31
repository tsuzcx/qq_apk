package com.tencent.ttpic.util.youtu;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.ttpic.model.EmotionInfo;
import com.tencent.ttpic.openapi.PTEmotionAttr;
import com.tencent.ttpic.util.SoInfo;
import java.util.List;

public class EmotionDetector
{
  public static final int SLEFT_EYE_INDEX = 43;
  public static final int SRIGHT_EYE_INDEX = 53;
  private static final String TAG = EmotionDetector.class.getSimpleName();
  private static boolean isInitial = false;
  private static int sMaxFaceCount = 1;
  private float[] mDistanceSquare;
  private int[] mFaceIndex;
  private int mMinIndex = -1;
  private EmotionDetector.SmileDetector mSmileDetector;
  
  private void addFaceArr(int paramInt1, int paramInt2, float paramFloat)
  {
    if ((this.mFaceIndex == null) || (this.mDistanceSquare == null) || (paramInt2 >= this.mFaceIndex.length)) {}
    do
    {
      return;
      this.mFaceIndex[paramInt1] = paramInt2;
      this.mDistanceSquare[paramInt1] = paramFloat;
    } while ((this.mMinIndex != -1) && (paramFloat >= this.mDistanceSquare[this.mMinIndex]));
    this.mMinIndex = paramInt2;
  }
  
  private void addFaceEye2Detect(int paramInt, EmotionInfo paramEmotionInfo)
  {
    if (paramEmotionInfo != null)
    {
      PointF localPointF1 = paramEmotionInfo.leftEye;
      PointF localPointF2 = paramEmotionInfo.rightEye;
      this.mSmileDetector.setEyeLocationByIndex(paramInt, (int)localPointF1.x, (int)localPointF1.y, (int)localPointF2.x, (int)localPointF2.y);
      EmotionDetector.SmileDetector.access$100(this.mSmileDetector, paramInt, paramEmotionInfo.angles[0], paramEmotionInfo.angles[1], paramEmotionInfo.angles[1]);
    }
  }
  
  public static int detectSmile(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (isInitial) {
      return detectSmileByBitmap(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return -1;
  }
  
  public static int detectSmile(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (isInitial) {
      return detectSmileByRGBA(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
    return -1;
  }
  
  @SoInfo(libName="expression_ttpic")
  private static native int detectSmileByBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  @SoInfo(libName="expression_ttpic")
  private static native int detectSmileByRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  private float distanceSquare2Point(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return f1 * f1 + f2 * f2;
  }
  
  private void initFaceArray()
  {
    if ((this.mFaceIndex == null) || (this.mFaceIndex.length < sMaxFaceCount))
    {
      this.mFaceIndex = new int[sMaxFaceCount];
      this.mDistanceSquare = new float[sMaxFaceCount];
    }
    int i = 0;
    while (i < this.mFaceIndex.length)
    {
      this.mFaceIndex[i] = 0;
      this.mDistanceSquare[i] = 0.0F;
      i += 1;
    }
    this.mMinIndex = -1;
  }
  
  private boolean isOutImage(EmotionInfo paramEmotionInfo, int paramInt)
  {
    boolean bool = false;
    if ((paramEmotionInfo == null) || (paramEmotionInfo.leftEye.x < 5.0F) || (paramEmotionInfo.rightEye.x > paramInt - 5) || (paramEmotionInfo.leftEye.y < 5.0F) || (paramEmotionInfo.rightEye.y < 5.0F) || (paramEmotionInfo.angles[0] < -0.75D)) {
      bool = true;
    }
    return bool;
  }
  
  @SoInfo(libName="expression_ttpic")
  private static native int nClassNativeInit();
  
  public static int nativeInit()
  {
    return nClassNativeInit();
  }
  
  private void updateFaceArr(int paramInt, float paramFloat)
  {
    if ((this.mFaceIndex == null) || (this.mDistanceSquare == null)) {}
    do
    {
      return;
      if (this.mMinIndex == -1) {
        break;
      }
    } while (this.mDistanceSquare[this.mMinIndex] >= paramFloat);
    this.mFaceIndex[this.mMinIndex] = paramInt;
    this.mDistanceSquare[this.mMinIndex] = paramFloat;
    updateMinFace();
    return;
    this.mFaceIndex[0] = paramInt;
    this.mMinIndex = 0;
  }
  
  private void updateMinFace()
  {
    if ((this.mFaceIndex == null) || (this.mDistanceSquare == null) || (this.mMinIndex < 0) || (this.mMinIndex >= this.mDistanceSquare.length)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mFaceIndex.length)
      {
        if (this.mDistanceSquare[i] < this.mDistanceSquare[this.mMinIndex]) {
          this.mMinIndex = i;
        }
        i += 1;
      }
    }
  }
  
  public void destroy()
  {
    if (this.mSmileDetector != null) {
      this.mSmileDetector.clear();
    }
  }
  
  public Object detectSmile(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<EmotionInfo> paramList)
  {
    int m = 0;
    int i = 0;
    PTEmotionAttr localPTEmotionAttr = new PTEmotionAttr();
    if ((!isInitial) || (paramArrayOfByte == null) || (paramList == null) || (paramList.size() <= 0)) {
      return localPTEmotionAttr;
    }
    if (this.mSmileDetector == null) {
      this.mSmileDetector = new EmotionDetector.SmileDetector(this, null);
    }
    this.mSmileDetector.setData(paramArrayOfByte);
    this.mSmileDetector.setImgWH(paramInt1, paramInt2);
    int k;
    if (paramList.size() <= sMaxFaceCount)
    {
      paramInt2 = 0;
      k = paramInt2;
      if (i < paramList.size())
      {
        paramArrayOfByte = (EmotionInfo)paramList.get(i);
        if (isOutImage(paramArrayOfByte, paramInt1)) {}
        for (;;)
        {
          i += 1;
          break;
          addFaceEye2Detect(i, paramArrayOfByte);
          paramInt2 = 1;
        }
      }
    }
    else
    {
      initFaceArray();
      paramInt2 = 0;
      i = 0;
      k = paramInt2;
      int j = i;
      if (i < sMaxFaceCount)
      {
        k = paramInt2;
        j = i;
        if (paramInt2 < paramList.size())
        {
          if (isOutImage((EmotionInfo)paramList.get(paramInt2), paramInt1)) {}
          do
          {
            paramInt2 += 1;
            break;
            addFaceArr(i, paramInt2, distanceSquare2Point(((EmotionInfo)paramList.get(paramInt2)).leftFace, ((EmotionInfo)paramList.get(paramInt2)).rightFace));
            j = i + 1;
            i = j;
          } while (paramInt2 < paramList.size());
          k = paramInt2;
        }
      }
      if ((j >= sMaxFaceCount) && (k < paramList.size()))
      {
        if (isOutImage((EmotionInfo)paramList.get(k), paramInt1)) {}
        for (;;)
        {
          k += 1;
          break;
          updateFaceArr(k, distanceSquare2Point(((EmotionInfo)paramList.get(k)).leftFace, ((EmotionInfo)paramList.get(k)).rightFace));
        }
      }
      paramInt1 = 0;
      paramInt2 = m;
      for (;;)
      {
        k = paramInt1;
        if (paramInt2 >= j) {
          break;
        }
        addFaceEye2Detect(paramInt2, (EmotionInfo)paramList.get(this.mFaceIndex[paramInt2]));
        paramInt2 += 1;
        paramInt1 = 1;
      }
    }
    if (k != 0)
    {
      localPTEmotionAttr.setValue(this.mSmileDetector.detectSmile());
      localPTEmotionAttr.setSmile(this.mSmileDetector.isSmile());
    }
    return localPTEmotionAttr;
  }
  
  public int getSmileValue()
  {
    if (this.mSmileDetector == null) {
      return 0;
    }
    return this.mSmileDetector.getSmileValue();
  }
  
  public boolean init()
  {
    isInitial = true;
    return true;
  }
  
  public boolean isSmile()
  {
    if (this.mSmileDetector != null) {
      return this.mSmileDetector.isSmile();
    }
    return false;
  }
  
  public void setMaxFaceCount(int paramInt)
  {
    sMaxFaceCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.EmotionDetector
 * JD-Core Version:    0.7.0.1
 */