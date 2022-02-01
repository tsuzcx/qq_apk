package com.tencent.tmassistant.appinfo.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class AppDetailReqParam
  implements Parcelable
{
  public static final Parcelable.Creator<AppDetailReqParam> CREATOR = new b();
  public List<AppParam> apps = new ArrayList();
  public String biz = "";
  
  public AppDetailReqParam() {}
  
  protected AppDetailReqParam(Parcel paramParcel)
  {
    this.apps = paramParcel.createTypedArrayList(AppParam.CREATOR);
    this.biz = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.apps);
    paramParcel.writeString(this.biz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.appinfo.data.AppDetailReqParam
 * JD-Core Version:    0.7.0.1
 */