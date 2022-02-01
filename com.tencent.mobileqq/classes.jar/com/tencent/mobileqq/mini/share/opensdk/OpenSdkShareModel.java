package com.tencent.mobileqq.mini.share.opensdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class OpenSdkShareModel
  implements Parcelable
{
  public static final Parcelable.Creator<OpenSdkShareModel> CREATOR = new OpenSdkShareModel.1();
  public String appRichId;
  public String desc;
  public String iconUrl;
  public String imageUrl;
  public String jsonStr;
  public String miniAppAppid;
  public String miniAppPath;
  public String miniAppType;
  public String title;
  public String webPageUrl;
  
  public OpenSdkShareModel() {}
  
  protected OpenSdkShareModel(Parcel paramParcel)
  {
    this.miniAppAppid = paramParcel.readString();
    this.miniAppPath = paramParcel.readString();
    this.webPageUrl = paramParcel.readString();
    this.miniAppType = paramParcel.readString();
    this.title = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.imageUrl = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.appRichId = paramParcel.readString();
    this.jsonStr = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.miniAppAppid);
    paramParcel.writeString(this.miniAppPath);
    paramParcel.writeString(this.webPageUrl);
    paramParcel.writeString(this.miniAppType);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.imageUrl);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.appRichId);
    paramParcel.writeString(this.jsonStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel
 * JD-Core Version:    0.7.0.1
 */