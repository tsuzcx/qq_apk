package com.tencent.mobileqq.webview;

import akmk;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WebViewTitleStyle
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new akmk();
  public int a;
  public int b;
  public int c;
  public int d;
  
  public WebViewTitleStyle() {}
  
  public WebViewTitleStyle(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebViewTitleStyle
 * JD-Core Version:    0.7.0.1
 */