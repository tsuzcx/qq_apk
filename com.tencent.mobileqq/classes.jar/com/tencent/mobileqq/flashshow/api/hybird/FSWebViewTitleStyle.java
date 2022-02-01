package com.tencent.mobileqq.flashshow.api.hybird;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.webview.WebViewTitleStyle;

public class FSWebViewTitleStyle
  extends WebViewTitleStyle
{
  public static final Parcelable.Creator<FSWebViewTitleStyle> CREATOR = new FSWebViewTitleStyle.1();
  public int a;
  
  public FSWebViewTitleStyle() {}
  
  protected FSWebViewTitleStyle(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.hybird.FSWebViewTitleStyle
 * JD-Core Version:    0.7.0.1
 */