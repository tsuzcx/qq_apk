package com.tencent.mobileqq.webview.webso;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WebSoService$WebSoState$WebSo3
  implements Parcelable
{
  public static final Parcelable.Creator<WebSo3> CREATOR = new WebSoService.WebSoState.WebSo3.1();
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public WebSoService$WebSoState$WebSo3()
  {
    this.a = false;
    this.f = "";
    this.g = "0";
  }
  
  protected WebSoService$WebSoState$WebSo3(Parcel paramParcel)
  {
    boolean bool = false;
    this.a = false;
    this.f = "";
    this.g = "0";
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.a = bool;
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
  }
  
  public void a()
  {
    this.a = false;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.g = "0";
    this.f = "";
  }
  
  public String b()
  {
    return String.format("{\"code\":\"%s\",\"type\":\"%s\",\"data\":%s}", new Object[] { this.g, this.f, this.d });
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebSo3{valid=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", eTag='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pageVersion='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jsonData='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uri='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", callbackType='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", code='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByte((byte)this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.WebSoState.WebSo3
 * JD-Core Version:    0.7.0.1
 */