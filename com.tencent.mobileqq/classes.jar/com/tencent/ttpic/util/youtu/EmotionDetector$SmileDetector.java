package com.tencent.ttpic.util.youtu;

import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EmotionDetector$SmileDetector
{
  final int MAX_UPDATE_TIME = 2000;
  final float[] PITCH_LINES = { -0.2F, -0.3F, -0.4F, -0.47F, -0.55F, -0.6F, -0.65F, -0.7F, -0.74F, -0.77F, -0.785F };
  final int[] PITCH_SMILE_GAP = { -3, -5, -8, -13, -17, -22, -28, -35, -43, -48, -54 };
  final int SMILE_THRESHOLD = 40;
  long dectecFrame = 0L;
  private byte[] detectData;
  int faceCount = 0;
  int heightData = 0;
  List<Boolean> isSmiles = new ArrayList();
  long lastDetectTime = 0L;
  int[] leftEyeX;
  int[] leftEyeY;
  float[] pitchs;
  int[] rightEyeX;
  int[] rightEyeY;
  float[] rolls;
  int[] smileValueQueen = { 0, 0, 0, 0, 0 };
  List<Integer> smileValues = new ArrayList();
  int sumSmile = 0;
  int widthData = 0;
  float[] yaws;
  
  private EmotionDetector$SmileDetector(EmotionDetector paramEmotionDetector) {}
  
  private int calculatePitchGap(float paramFloat)
  {
    int k = 0;
    int i = this.PITCH_LINES.length - 1;
    for (;;)
    {
      int j = k;
      if (i >= 0)
      {
        if (paramFloat < this.PITCH_LINES[i]) {
          j = this.PITCH_SMILE_GAP[i];
        }
      }
      else {
        return j;
      }
      i -= 1;
    }
  }
  
  private int calculateSmileValue()
  {
    if (this.dectecFrame > this.smileValueQueen.length) {}
    for (int i = this.smileValueQueen.length; i > 0; i = (int)this.dectecFrame) {
      return this.sumSmile / i;
    }
    return 0;
  }
  
  private boolean checkTimeOut()
  {
    return System.currentTimeMillis() - this.lastDetectTime > 2000L;
  }
  
  private int[] initArraySize(int[] paramArrayOfInt, int paramInt)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt != null)
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= paramInt) {}
    }
    else
    {
      LogUtils.i(EmotionDetector.access$200(), "initArraySize:" + paramInt);
      arrayOfInt = new int[paramInt];
      if (paramArrayOfInt != null) {
        System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramArrayOfInt.length);
      }
    }
    return arrayOfInt;
  }
  
  private void initCoorArray(int paramInt)
  {
    this.leftEyeX = initArraySize(this.leftEyeX, paramInt);
    this.leftEyeY = initArraySize(this.leftEyeY, paramInt);
    this.rightEyeX = initArraySize(this.rightEyeX, paramInt);
    this.rightEyeY = initArraySize(this.rightEyeY, paramInt);
  }
  
  private void initDirections(int paramInt)
  {
    this.pitchs = initFloatArray(this.pitchs, paramInt);
    this.yaws = initFloatArray(this.yaws, paramInt);
    this.rolls = initFloatArray(this.rolls, paramInt);
  }
  
  private float[] initFloatArray(float[] paramArrayOfFloat, int paramInt)
  {
    float[] arrayOfFloat;
    if (paramArrayOfFloat != null)
    {
      arrayOfFloat = paramArrayOfFloat;
      if (paramArrayOfFloat.length >= paramInt) {}
    }
    else
    {
      LogUtils.i(EmotionDetector.access$200(), "initArraySize:" + paramInt);
      arrayOfFloat = new float[paramInt];
      if (paramArrayOfFloat != null) {
        System.arraycopy(paramArrayOfFloat, 0, arrayOfFloat, 0, paramArrayOfFloat.length);
      }
    }
    return arrayOfFloat;
  }
  
  private void resetArray()
  {
    int i = 0;
    while (i < this.smileValueQueen.length)
    {
      this.smileValueQueen[i] = 0;
      i += 1;
    }
    this.sumSmile = 0;
    this.dectecFrame = 0L;
  }
  
  private void setCoorValue(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    initCoorArray(this.faceCount);
    this.leftEyeX[paramInt1] = paramInt2;
    this.leftEyeY[paramInt1] = paramInt3;
    this.rightEyeX[paramInt1] = paramInt4;
    this.rightEyeY[paramInt1] = paramInt5;
  }
  
  private void setFaceDirection(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    initDirections(this.faceCount);
    this.pitchs[paramInt] = paramFloat1;
    this.yaws[paramInt] = paramFloat2;
    this.rolls[paramInt] = paramFloat3;
  }
  
  private void updateSmileValue(int paramInt)
  {
    int i = (int)(this.dectecFrame % this.smileValueQueen.length);
    this.sumSmile -= this.smileValueQueen[i];
    this.sumSmile += paramInt;
    this.smileValueQueen[i] = paramInt;
    this.dectecFrame += 1L;
  }
  
  private void updateTime()
  {
    long l = System.currentTimeMillis();
    if (l - this.lastDetectTime > 2000L) {
      resetArray();
    }
    this.lastDetectTime = l;
  }
  
  private boolean voteSmile()
  {
    int i = this.smileValueQueen.length / 2 + 1;
    int[] arrayOfInt = this.smileValueQueen;
    int m = arrayOfInt.length;
    int j = 0;
    for (;;)
    {
      int k = i;
      if (j < m)
      {
        k = i;
        if (arrayOfInt[j] > 40)
        {
          i -= 1;
          k = i;
          if (i <= 0) {
            k = i;
          }
        }
      }
      else
      {
        if (k > 0) {
          break;
        }
        return true;
      }
      j += 1;
      i = k;
    }
    return false;
  }
  
  public void clear()
  {
    this.detectData = null;
  }
  
  public int detectSmile(boolean paramBoolean)
  {
    if (!EmotionDetector.access$300()) {
      return 0;
    }
    if (paramBoolean)
    {
      this.smileValues.clear();
      this.isSmiles.clear();
    }
    updateTime();
    int m = 0;
    int i = 0;
    int j;
    if (m < this.faceCount)
    {
      int k = EmotionDetector.access$400(this.detectData, this.widthData, this.heightData, this.leftEyeX[m], this.leftEyeY[m], this.rightEyeX[m], this.rightEyeY[m]);
      if (this.pitchs[m] < -0.2D)
      {
        j = calculatePitchGap(this.pitchs[m]);
        label120:
        j = k + j;
        k = j;
        if (j > 100) {
          k = 100;
        }
        j = k;
        if (k < 0) {
          j = 0;
        }
        if ((j <= 40) || (paramBoolean)) {
          break label181;
        }
      }
    }
    for (;;)
    {
      updateSmileValue(j);
      if (checkTimeOut()) {
        resetArray();
      }
      return j;
      j = 0;
      break label120;
      label181:
      this.smileValues.add(Integer.valueOf(j));
      List localList = this.isSmiles;
      boolean bool;
      if (j > 40)
      {
        bool = true;
        label210:
        localList.add(Boolean.valueOf(bool));
        if (j <= i) {
          break label245;
        }
      }
      for (;;)
      {
        m += 1;
        i = j;
        break;
        bool = false;
        break label210;
        label245:
        j = i;
      }
      j = i;
    }
  }
  
  public List<Boolean> getIsSmiles()
  {
    return this.isSmiles;
  }
  
  public int getSmileValue()
  {
    if (checkTimeOut()) {
      resetArray();
    }
    return calculateSmileValue();
  }
  
  public List<Integer> getSmileValues()
  {
    return this.smileValues;
  }
  
  public boolean isCurrentFrameSmile()
  {
    if (this.isSmiles != null)
    {
      Iterator localIterator = this.isSmiles.iterator();
      while (localIterator.hasNext()) {
        if (((Boolean)localIterator.next()).booleanValue()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isSmile()
  {
    if (checkTimeOut()) {
      resetArray();
    }
    return voteSmile();
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    if ((this.detectData == null) || (this.detectData.length < paramArrayOfByte.length)) {
      this.detectData = new byte[paramArrayOfByte.length];
    }
    System.arraycopy(paramArrayOfByte, 0, this.detectData, 0, paramArrayOfByte.length);
  }
  
  public void setEyeLocationByIndex(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.faceCount = (paramInt1 + 1);
    setCoorValue(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.EmotionDetector.SmileDetector
 * JD-Core Version:    0.7.0.1
 */