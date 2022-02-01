package com.tencent.mobileqq.kandian.biz.comment.emotion.data;

import android.os.Parcel;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;

public abstract class RIJBaseEmotionInfo
  extends EmoticonInfo
{
  public final String a;
  public final String b;
  public final String c;
  
  public RIJBaseEmotionInfo(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.data.RIJBaseEmotionInfo
 * JD-Core Version:    0.7.0.1
 */