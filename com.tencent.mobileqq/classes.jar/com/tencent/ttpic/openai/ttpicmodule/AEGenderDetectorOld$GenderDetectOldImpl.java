package com.tencent.ttpic.openai.ttpicmodule;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.openapi.initializer.TNNGenderDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class AEGenderDetectorOld$GenderDetectOldImpl
{
  private Bitmap detectData;
  int faceCount = 0;
  long[] faceIDs;
  private List<AEGenderDetectorOld.GenderParams> gender;
  int heightData = 0;
  boolean[] isInOutImageArr;
  int[] recth;
  int[] rectw;
  int[] rectx;
  int[] recty;
  int widthData = 0;
  
  private AEGenderDetectorOld$GenderDetectOldImpl(AEGenderDetectorOld paramAEGenderDetectorOld) {}
  
  private List<AEGenderDetectorOld.GenderParams> getGender()
  {
    return this.gender;
  }
  
  private Map<Long, AEGenderDetectorOld.GenderParams> getGenderMap()
  {
    if (this.gender == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = new ArrayList(this.gender).iterator();
    while (localIterator.hasNext())
    {
      AEGenderDetectorOld.GenderParams localGenderParams = (AEGenderDetectorOld.GenderParams)localIterator.next();
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
    this.rectx = initArraySize(this.rectx, paramInt);
    this.recty = initArraySize(this.recty, paramInt);
    this.rectw = initArraySize(this.rectw, paramInt);
    this.recth = initArraySize(this.recth, paramInt);
    this.faceIDs = initArraySize(this.faceIDs, paramInt);
    this.isInOutImageArr = initArraySize(this.isInOutImageArr, paramInt);
  }
  
  private void setCoorValue(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong)
  {
    initCoorArray(this.faceCount);
    this.rectx[paramInt1] = paramInt2;
    this.recty[paramInt1] = paramInt3;
    this.rectw[paramInt1] = paramInt4;
    this.recth[paramInt1] = paramInt5;
    this.faceIDs[paramInt1] = paramLong;
    this.isInOutImageArr[paramInt1] = paramBoolean;
  }
  
  public void clear()
  {
    if (AEGenderDetectorOld.access$200(this.this$0)) {
      AEGenderDetectorOld.access$302(this.this$0, true);
    }
    do
    {
      return;
      BitmapUtils.recycle(this.detectData);
      this.isInOutImageArr = null;
      this.rectx = null;
      this.recty = null;
      this.rectw = null;
      this.recth = null;
    } while (this.gender == null);
    this.gender.clear();
    AEGenderDetectorOld.access$302(this.this$0, false);
  }
  
  public void detect()
  {
    if (!AEGenderDetectorOld.access$500()) {}
    label564:
    do
    {
      return;
      AEGenderDetectorOld.access$202(this.this$0, true);
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
          this.gender.add(new AEGenderDetectorOld.GenderParams(this.this$0));
          i -= 1;
        }
      }
      int j = 0;
      Object localObject;
      if (j < k)
      {
        if ((isEmptyArray()) || (isOutOfRange(j)) || (this.isInOutImageArr[j] == 0) || (this.rectx[j] == 0) || (this.recty[j] == 0) || (this.rectw[j] == 0) || (this.recth[j] == 0)) {
          break label564;
        }
        localObject = FeatureManager.Features.RAPID_NET_GENDER_DETECT.retrieveGenderInfo(this.detectData, this.rectx[j], this.recty[j], this.rectw[j], this.recth[j]);
        if (localObject != null) {}
      }
      for (;;)
      {
        j += 1;
        break;
        i = Float.valueOf(localObject[0]).intValue();
        if (j >= this.gender.size())
        {
          if (k >= this.gender.size()) {
            break label789;
          }
          i = this.gender.size();
          while ((i > k) && (i > 0))
          {
            this.gender.remove(i - 1);
            i -= 1;
          }
        }
        if (this.gender.get(j) == null) {
          this.gender.set(j, new AEGenderDetectorOld.GenderParams(this.this$0));
        }
        ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).isInImage = true;
        ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).setRectXY(this.rectx[j], this.recty[j]);
        ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).setRectWH(this.rectw[j], this.recth[j]);
        ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).faceID = this.faceIDs[j];
        this.rectx[j] = 0;
        this.recty[j] = 0;
        this.rectw[j] = 0;
        this.recth[j] = 0;
        localObject = (AEGenderDetectorOld.GenderParams)this.gender.get(j);
        if (i == 0) {
          i = GenderType.FEMALE.value;
        }
        for (;;)
        {
          ((AEGenderDetectorOld.GenderParams)localObject).genderType = i;
          Log.i("TAG", "gender is 1:" + ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).genderType);
          break;
          if (i == 1) {
            i = GenderType.MALE.value;
          } else {
            i = ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).genderType;
          }
        }
        ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).isInImage = false;
        if (this.gender.get(j) == null) {
          this.gender.set(j, new AEGenderDetectorOld.GenderParams(this.this$0));
        }
        ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).setRectXY(this.rectx[j], this.recty[j]);
        ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).setRectWH(this.rectw[j], this.recth[j]);
        ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).genderType = GenderType.DEFAULT.value;
        ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).faceID = this.faceIDs[j];
        this.rectx[j] = 0;
        this.recty[j] = 0;
        this.rectw[j] = 0;
        this.recth[j] = 0;
        Log.i("TAG", "gender is 2:" + ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).genderType);
      }
      AEGenderDetectorOld.access$202(this.this$0, false);
      if (AEGenderDetectorOld.access$300(this.this$0)) {
        clear();
      }
    } while (!AEGenderDetectorOld.access$400(this.this$0));
    label789:
    reset();
  }
  
  public boolean isEmptyArray()
  {
    return (this.isInOutImageArr == null) || (this.rectx == null) || (this.recty == null) || (this.rectw == null) || (this.recth == null);
  }
  
  public boolean isOutOfRange(int paramInt)
  {
    return (this.isInOutImageArr.length <= paramInt) || (this.rectx.length <= paramInt) || (this.recty.length <= paramInt) || (this.rectw.length <= paramInt) || (this.recth.length <= paramInt);
  }
  
  public void reset()
  {
    if (AEGenderDetectorOld.access$200(this.this$0)) {
      AEGenderDetectorOld.access$402(this.this$0, true);
    }
    while (this.gender == null) {
      return;
    }
    this.gender.clear();
    AEGenderDetectorOld.access$402(this.this$0, false);
  }
  
  public void setData(Bitmap paramBitmap)
  {
    this.detectData = paramBitmap.copy(Bitmap.Config.ARGB_8888, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openai.ttpicmodule.AEGenderDetectorOld.GenderDetectOldImpl
 * JD-Core Version:    0.7.0.1
 */