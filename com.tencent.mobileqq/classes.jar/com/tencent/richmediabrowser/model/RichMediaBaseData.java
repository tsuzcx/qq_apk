package com.tencent.richmediabrowser.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.richmediabrowser.model.pic.PictureData;
import com.tencent.richmediabrowser.model.video.VideoData;

public abstract class RichMediaBaseData
  implements Parcelable
{
  public static final Parcelable.Creator<RichMediaBaseData> CREATOR = new RichMediaBaseData.1();
  public String filePath;
  public int fileType;
  public String id;
  public boolean isLocal;
  public int progress;
  public int status;
  public String url;
  
  public static RichMediaBaseData newInstance(String paramString)
  {
    if (PictureData.class.getSimpleName().equals(paramString)) {
      return new PictureData();
    }
    if (VideoData.class.getSimpleName().equals(paramString)) {
      return new VideoData();
    }
    throw new ClassNotFoundException();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public abstract int getType();
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.url = paramParcel.readString();
    this.fileType = paramParcel.readInt();
    this.status = paramParcel.readInt();
    this.progress = paramParcel.readInt();
  }
  
  public void updateProgress(int paramInt)
  {
    this.progress = paramInt;
  }
  
  public void updateStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(getClass().getSimpleName());
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.fileType);
    paramParcel.writeInt(this.status);
    paramParcel.writeInt(this.progress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.model.RichMediaBaseData
 * JD-Core Version:    0.7.0.1
 */