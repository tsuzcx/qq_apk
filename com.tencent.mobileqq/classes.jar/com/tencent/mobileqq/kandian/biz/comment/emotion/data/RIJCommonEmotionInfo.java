package com.tencent.mobileqq.kandian.biz.comment.emotion.data;

import android.os.Parcel;
import com.tencent.mobileqq.kandian.biz.comment.emotion.span.IShrinkLength;

public class RIJCommonEmotionInfo
  extends RIJBaseEmotionInfo
  implements IShrinkLength
{
  private final int a;
  
  public RIJCommonEmotionInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super(paramString1, paramString2, paramString3);
    this.type = paramInt1;
    this.a = paramInt2;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.data.RIJCommonEmotionInfo
 * JD-Core Version:    0.7.0.1
 */