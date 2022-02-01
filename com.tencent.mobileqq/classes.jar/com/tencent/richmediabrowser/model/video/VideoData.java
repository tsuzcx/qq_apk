package com.tencent.richmediabrowser.model.video;

import android.os.Parcel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

public class VideoData
  extends RichMediaBaseData
{
  public boolean isAutoPlay = false;
  public boolean isMutePlay = false;
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getType()
  {
    return 2;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    super.readFromParcel(paramParcel);
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.isAutoPlay = bool1;
      if (paramParcel.readInt() != 1) {
        break label43;
      }
    }
    label43:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.isMutePlay = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    if (this.isAutoPlay)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.isMutePlay) {
        break label42;
      }
    }
    label42:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.model.video.VideoData
 * JD-Core Version:    0.7.0.1
 */