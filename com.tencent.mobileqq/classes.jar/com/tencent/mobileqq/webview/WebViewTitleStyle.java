package com.tencent.mobileqq.webview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WebViewTitleStyle
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewTitleStyle> CREATOR = new WebViewTitleStyle.1();
  public int leftAndRightBtnColor;
  public int statusBarColor;
  public int titleBgColor;
  public int titleColor;
  
  public WebViewTitleStyle() {}
  
  public WebViewTitleStyle(Parcel paramParcel)
  {
    this.statusBarColor = paramParcel.readInt();
    this.titleBgColor = paramParcel.readInt();
    this.titleColor = paramParcel.readInt();
    this.leftAndRightBtnColor = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.statusBarColor);
    paramParcel.writeInt(this.titleBgColor);
    paramParcel.writeInt(this.titleColor);
    paramParcel.writeInt(this.leftAndRightBtnColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebViewTitleStyle
 * JD-Core Version:    0.7.0.1
 */