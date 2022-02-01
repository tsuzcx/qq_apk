package com.tencent.mobileqq.kandian.biz.comment.emotion.data;

import android.os.Parcel;
import com.tencent.mobileqq.kandian.biz.comment.emotion.span.IShrinkLength;

public class RIJCommonEmotionInfo
  extends RIJBaseEmotionInfo
  implements IShrinkLength
{
  private final int d;
  
  public RIJCommonEmotionInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super(paramString1, paramString2, paramString3);
    this.type = paramInt1;
    this.d = paramInt2;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.data.RIJCommonEmotionInfo
 * JD-Core Version:    0.7.0.1
 */