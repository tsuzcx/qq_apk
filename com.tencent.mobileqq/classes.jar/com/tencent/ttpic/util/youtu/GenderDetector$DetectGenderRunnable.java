package com.tencent.ttpic.util.youtu;

import android.util.Log;
import com.tencent.ttpic.facedetect.GenderType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class GenderDetector$DetectGenderRunnable
  implements Runnable
{
  private byte[] detectData;
  int faceCount = 0;
  long[] faceIDs;
  private List<GenderDetector.GenderParams> gender;
  int heightData = 0;
  boolean[] isInOutImageArr;
  int[] leftEyeX;
  int[] leftEyeY;
  int[] rightEyeX;
  int[] rightEyeY;
  int widthData = 0;
  
  private GenderDetector$DetectGenderRunnable(GenderDetector paramGenderDetector) {}
  
  private List<GenderDetector.GenderParams> getGender()
  {
    return this.gender;
  }
  
  private Map<Long, GenderDetector.GenderParams> getGenderMap()
  {
    if (this.gender == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = new ArrayList(this.gender).iterator();
    while (localIterator.hasNext())
    {
      GenderDetector.GenderParams localGenderParams = (GenderDetector.GenderParams)localIterator.next();
      if (localGenderParams != null) {
        localHashMap.put(Long.valueOf(localGenderParams.faceID), localGenderParams);
      }
    }
    return localHashMap;
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
      Log.i("GenderDetector", "int[]initArraySize:" + paramInt);
      arrayOfInt = new int[paramInt];
      if (paramArrayOfInt != null) {
        System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramArrayOfInt.length);
      }
    }
    return arrayOfInt;
  }
  
  private long[] initArraySize(long[] paramArrayOfLong, int paramInt)
  {
    long[] arrayOfLong;
    if (paramArrayOfLong != null)
    {
      arrayOfLong = paramArrayOfLong;
      if (paramArrayOfLong.length >= paramInt) {}
    }
    else
    {
      Log.i("GenderDetector", "long[]initArraySize:" + paramInt);
      arrayOfLong = new long[paramInt];
      if (paramArrayOfLong != null) {
        System.arraycopy(paramArrayOfLong, 0, arrayOfLong, 0, paramArrayOfLong.length);
      }
    }
    return arrayOfLong;
  }
  
  private boolean[] initArraySize(boolean[] paramArrayOfBoolean, int paramInt)
  {
    boolean[] arrayOfBoolean;
    if (paramArrayOfBoolean != null)
    {
      arrayOfBoolean = paramArrayOfBoolean;
      if (paramArrayOfBoolean.length >= paramInt) {}
    }
    else
    {
      Log.i("GenderDetector", "boolean[]initArraySize:" + paramInt);
      arrayOfBoolean = new boolean[paramInt];
      if (paramArrayOfBoolean != null) {
        System.arraycopy(paramArrayOfBoolean, 0, arrayOfBoolean, 0, paramArrayOfBoolean.length);
      }
    }
    return arrayOfBoolean;
  }
  
  private void initCoorArray(int paramInt)
  {
    this.leftEyeX = initArraySize(this.leftEyeX, paramInt);
    this.leftEyeY = initArraySize(this.leftEyeY, paramInt);
    this.rightEyeX = initArraySize(this.rightEyeX, paramInt);
    this.rightEyeY = initArraySize(this.rightEyeY, paramInt);
    this.faceIDs = initArraySize(this.faceIDs, paramInt);
    this.isInOutImageArr = initArraySize(this.isInOutImageArr, paramInt);
  }
  
  private void setCoorValue(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong)
  {
    initCoorArray(this.faceCount);
    this.leftEyeX[paramInt1] = paramInt2;
    this.leftEyeY[paramInt1] = paramInt3;
    this.rightEyeX[paramInt1] = paramInt4;
    this.rightEyeY[paramInt1] = paramInt5;
    this.faceIDs[paramInt1] = paramLong;
    this.isInOutImageArr[paramInt1] = paramBoolean;
  }
  
  public void clear()
  {
    if (GenderDetector.access$200(this.this$0)) {
      GenderDetector.access$302(this.this$0, true);
    }
    do
    {
      return;
      this.detectData = null;
      this.isInOutImageArr = null;
      this.leftEyeX = null;
      this.leftEyeY = null;
      this.rightEyeX = null;
      this.rightEyeY = null;
    } while (this.gender == null);
    this.gender.clear();
    GenderDetector.access$302(this.this$0, false);
  }
  
  public boolean isEmptyArray()
  {
    return (this.isInOutImageArr == null) || (this.leftEyeX == null) || (this.leftEyeY == null) || (this.rightEyeY == null) || (this.rightEyeX == null);
  }
  
  public boolean isOutOfRange(int paramInt)
  {
    return (this.isInOutImageArr.length <= paramInt) || (this.leftEyeY.length <= paramInt) || (this.leftEyeX.length <= paramInt) || (this.rightEyeX.length <= paramInt) || (this.rightEyeY.length <= paramInt);
  }
  
  public void reset()
  {
    if (GenderDetector.access$200(this.this$0)) {
      GenderDetector.access$402(this.this$0, true);
    }
    while (this.gender == null) {
      return;
    }
    this.gender.clear();
    GenderDetector.access$402(this.this$0, false);
  }
  
  public void run()
  {
    if (!GenderDetector.access$500()) {}
    label464:
    do
    {
      return;
      GenderDetector.access$202(this.this$0, true);
      int k = this.faceCount;
      int i;
      if ((this.gender == null) || (k > this.gender.size()))
      {
        if (this.gender == null) {
          this.gender = new ArrayList();
        }
        i = k - this.gender.size();
        while (i > 0)
        {
          this.gender.add(new GenderDetector.GenderParams(this.this$0));
          i -= 1;
        }
      }
      int j = 0;
      if (j < k)
      {
        if ((isEmptyArray()) || (isOutOfRange(j)) || (this.isInOutImageArr[j] == 0) || (this.leftEyeX[j] == 0) || (this.leftEyeY[j] == 0) || (this.rightEyeX[j] == 0) || (this.rightEyeY[j] == 0)) {
          break label551;
        }
        i = this.this$0.detectGender(this.detectData, this.widthData, this.heightData, this.leftEyeX[j], this.leftEyeY[j], this.rightEyeX[j], this.rightEyeY[j]);
        if (j < this.gender.size()) {}
      }
      else
      {
        if (k >= this.gender.size()) {
          break label774;
        }
        i = this.gender.size();
        while ((i > k) && (i > 0))
        {
          this.gender.remove(i - 1);
          i -= 1;
        }
      }
      if (this.gender.get(j) == null) {
        this.gender.set(j, new GenderDetector.GenderParams(this.this$0));
      }
      ((GenderDetector.GenderParams)this.gender.get(j)).isInImage = true;
      ((GenderDetector.GenderParams)this.gender.get(j)).setLeftEye(this.leftEyeX[j], this.leftEyeY[j]);
      ((GenderDetector.GenderParams)this.gender.get(j)).setRightEye(this.rightEyeX[j], this.rightEyeY[j]);
      ((GenderDetector.GenderParams)this.gender.get(j)).faceID = this.faceIDs[j];
      this.leftEyeX[j] = 0;
      this.leftEyeY[j] = 0;
      this.rightEyeX[j] = 0;
      this.rightEyeY[j] = 0;
      GenderDetector.GenderParams localGenderParams = (GenderDetector.GenderParams)this.gender.get(j);
      if (i == 1)
      {
        i = GenderType.FEMALE.value;
        localGenderParams.genderType = i;
        Log.i("TAG", "gender is 1:" + ((GenderDetector.GenderParams)this.gender.get(j)).genderType);
      }
      for (;;)
      {
        j += 1;
        break;
        if (i == 0)
        {
          i = GenderType.MALE.value;
          break label464;
        }
        i = ((GenderDetector.GenderParams)this.gender.get(j)).genderType;
        break label464;
        ((GenderDetector.GenderParams)this.gender.get(j)).isInImage = false;
        if (this.gender.get(j) == null) {
          this.gender.set(j, new GenderDetector.GenderParams(this.this$0));
        }
        ((GenderDetector.GenderParams)this.gender.get(j)).setLeftEye(this.leftEyeX[j], this.leftEyeY[j]);
        ((GenderDetector.GenderParams)this.gender.get(j)).setRightEye(this.rightEyeX[j], this.rightEyeY[j]);
        ((GenderDetector.GenderParams)this.gender.get(j)).genderType = GenderType.DEFAULT.value;
        ((GenderDetector.GenderParams)this.gender.get(j)).faceID = this.faceIDs[j];
        this.leftEyeX[j] = 0;
        this.leftEyeY[j] = 0;
        this.rightEyeX[j] = 0;
        this.rightEyeY[j] = 0;
        Log.i("TAG", "gender is 2:" + ((GenderDetector.GenderParams)this.gender.get(j)).genderType);
      }
      GenderDetector.access$202(this.this$0, false);
      if (GenderDetector.access$300(this.this$0)) {
        clear();
      }
    } while (!GenderDetector.access$400(this.this$0));
    label551:
    reset();
    label774:
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    if ((this.detectData == null) || (this.detectData.length < paramArrayOfByte.length)) {
      this.detectData = new byte[paramArrayOfByte.length];
    }
    System.arraycopy(paramArrayOfByte, 0, this.detectData, 0, paramArrayOfByte.length);
  }
  
  public void setEyeLocationByIndex(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong)
  {
    this.faceCount = (paramInt1 + 1);
    setCoorValue(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean, paramLong);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.GenderDetector.DetectGenderRunnable
 * JD-Core Version:    0.7.0.1
 */