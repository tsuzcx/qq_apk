package com.tencent.mobileqq.kandian.repo.diandian;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class EntranceIconInfo
  implements Parcelable, IEntranceButtonDataSource
{
  public static final Parcelable.Creator<EntranceIconInfo> CREATOR = new EntranceIconInfo.1();
  public int a;
  public ExtraInfo a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  
  public EntranceIconInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 0;
  }
  
  public EntranceIconInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    boolean bool = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianExtraInfo = ((ExtraInfo)paramParcel.readParcelable(ExtraInfo.class.getClassLoader()));
  }
  
  public static EntranceIconInfo a(int paramInt, String paramString)
  {
    EntranceIconInfo localEntranceIconInfo = new EntranceIconInfo();
    localEntranceIconInfo.jdField_a_of_type_Int = paramInt;
    localEntranceIconInfo.c = paramString;
    return localEntranceIconInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString) ^ true;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean c()
  {
    return TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString) ^ true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EntranceIconInfo {feedsType : ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\nmsgIconUrl :");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\ndefaultIconUrl :");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\njumpSchema :");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\nextraInfo : ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianExtraInfo);
    localStringBuilder.append("\n}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianExtraInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.diandian.EntranceIconInfo
 * JD-Core Version:    0.7.0.1
 */