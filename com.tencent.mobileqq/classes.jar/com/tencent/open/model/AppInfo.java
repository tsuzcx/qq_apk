package com.tencent.open.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.qqconnect.Appinfo;

public class AppInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AppInfo> CREATOR = new AppInfo.1();
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "";
  
  public AppInfo(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  protected AppInfo(Parcel paramParcel)
  {
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public AppInfo(qqconnect.Appinfo paramAppinfo)
  {
    this.jdField_a_of_type_Boolean = false;
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
    int i = this.jdField_b_of_type_Int;
    if (i != 100)
    {
      switch (i)
      {
      default: 
        return HardCodeUtil.a(2131700835);
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
        return "";
      case 2: 
        return HardCodeUtil.a(2131700836);
      case 1: 
        return HardCodeUtil.a(2131700837);
      }
      return HardCodeUtil.a(2131700834);
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
    localStringBuilder.append("mId=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mName='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type='");
    localStringBuilder.append(a());
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.model.AppInfo
 * JD-Core Version:    0.7.0.1
 */