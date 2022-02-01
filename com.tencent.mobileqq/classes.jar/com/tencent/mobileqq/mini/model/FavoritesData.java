package com.tencent.mobileqq.mini.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

public class FavoritesData
  implements Parcelable
{
  public static final Parcelable.Creator<FavoritesData> CREATOR = new FavoritesData.1();
  protected static final String TAG = "FavoritesData";
  public int action;
  public String bizDataList;
  public String entryPath;
  protected MiniAppInfo miniAppInfo;
  public String picPath;
  public String summary;
  public String title;
  
  protected FavoritesData() {}
  
  public FavoritesData(Parcel paramParcel)
  {
    this.title = paramParcel.readString();
    this.summary = paramParcel.readString();
    this.picPath = paramParcel.readString();
    this.miniAppInfo = ((MiniAppInfo)paramParcel.readParcelable(MiniAppInfo.class.getClassLoader()));
    this.action = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getMiniAppId()
  {
    return this.miniAppInfo.appId;
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.miniAppInfo;
  }
  
  public String getMiniAppName()
  {
    return this.miniAppInfo.name;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.summary);
    paramParcel.writeString(this.picPath);
    paramParcel.writeParcelable(this.miniAppInfo, 0);
    paramParcel.writeInt(this.action);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.model.FavoritesData
 * JD-Core Version:    0.7.0.1
 */