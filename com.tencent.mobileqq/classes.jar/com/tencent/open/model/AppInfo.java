package com.tencent.open.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anvx;
import bjpo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.qqconnect.Appinfo;

public class AppInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AppInfo> CREATOR = new bjpo();
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "";
  
  public AppInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public AppInfo(qqconnect.Appinfo paramAppinfo)
  {
    if (paramAppinfo.appid.has()) {
      this.jdField_a_of_type_Int = paramAppinfo.appid.get();
    }
    if (paramAppinfo.app_name.has()) {
      this.jdField_a_of_type_JavaLangString = paramAppinfo.app_name.get();
    }
    if (paramAppinfo.app_type.has()) {
      this.jdField_b_of_type_Int = paramAppinfo.app_type.get();
    }
    if (paramAppinfo.icon_url.has()) {
      this.jdField_b_of_type_JavaLangString = paramAppinfo.icon_url.get();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      return anvx.a(2131700116);
    case 0: 
      return anvx.a(2131700115);
    case 1: 
      return anvx.a(2131700117);
    case 2: 
      return "ARK应用";
    case 3: 
      return "";
    case 4: 
      return "";
    case 5: 
      return "";
    case 6: 
      return "";
    case 7: 
      return "";
    case 8: 
      return "";
    case 9: 
      return "";
    }
    return "";
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AppInfo{");
    localStringBuilder.append("mId=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mName='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuilder.append(", type='").append(a()).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.model.AppInfo
 * JD-Core Version:    0.7.0.1
 */