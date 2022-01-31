package com.tencent.mobileqq.webview.webso;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bbed;

public class WebSoService$WebSoState$WebSo3
  implements Parcelable
{
  public static final Parcelable.Creator<WebSo3> CREATOR = new bbed();
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e = "";
  public String f = "0";
  
  public WebSoService$WebSoState$WebSo3() {}
  
  public WebSoService$WebSoState$WebSo3(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.b = paramParcel.readString();
      this.c = paramParcel.readString();
      this.d = paramParcel.readString();
      this.e = paramParcel.readString();
      this.f = paramParcel.readString();
      return;
    }
  }
  
  public String a()
  {
    return String.format("{\"code\":\"%s\",\"type\":\"%s\",\"data\":%s}", new Object[] { this.f, this.e, this.c });
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.f = "0";
    this.e = "";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "WebSo3{valid=" + this.jdField_a_of_type_Boolean + ", eTag='" + this.jdField_a_of_type_JavaLangString + '\'' + ", pageVersion='" + this.b + '\'' + ", jsonData='" + this.c + '\'' + ", uri='" + this.d + '\'' + ", callbackType='" + this.e + '\'' + ", code='" + this.f + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeString(this.b);
      paramParcel.writeString(this.c);
      paramParcel.writeString(this.d);
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.f);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.WebSoState.WebSo3
 * JD-Core Version:    0.7.0.1
 */