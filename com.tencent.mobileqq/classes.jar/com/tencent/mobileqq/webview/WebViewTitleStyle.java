package com.tencent.mobileqq.webview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WebViewTitleStyle
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewTitleStyle> CREATOR = new WebViewTitleStyle.1();
  public int b;
  public int c;
  public int d;
  public int e;
  
  public WebViewTitleStyle() {}
  
  public WebViewTitleStyle(Parcel paramParcel)
  {
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebViewTitleStyle
 * JD-Core Version:    0.7.0.1
 */