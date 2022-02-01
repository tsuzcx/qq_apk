package com.tencent.mobileqq.emosm.emosearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpic.HotPicData;

public class EmotionSearchItem
  extends HotPicData
  implements Parcelable
{
  public static final Parcelable.Creator<EmotionSearchItem> CREATOR = new EmotionSearchItem.1();
  
  public EmotionSearchItem() {}
  
  protected EmotionSearchItem(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getEmoMd5()
  {
    return this.md5;
  }
  
  public String getEmoURL()
  {
    return this.url;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem
 * JD-Core Version:    0.7.0.1
 */