package com.tencent.mobileqq.webview.webso;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WebSoService$WebSoState$WebSo3
  implements Parcelable
{
  public static final Parcelable.Creator<WebSo3> CREATOR = new WebSoService.WebSoState.WebSo3.1();
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public WebSoService$WebSoState$WebSo3()
  {
    this.jdField_a_of_type_Boolean = false;
    this.e = "";
    this.f = "0";
  }
  
  protected WebSoService$WebSoState$WebSo3(Parcel paramParcel)
  {
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    this.e = "";
    this.f = "0";
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebSo3{valid=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", eTag='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pageVersion='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jsonData='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uri='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", callbackType='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", code='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.WebSoState.WebSo3
 * JD-Core Version:    0.7.0.1
 */