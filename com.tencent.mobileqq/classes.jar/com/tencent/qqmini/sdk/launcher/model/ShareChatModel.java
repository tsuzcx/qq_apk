package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import besi;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShareChatModel
  implements Parcelable
{
  public static final Parcelable.Creator<ShareChatModel> CREATOR = new besi();
  public int a;
  public long a;
  public String a;
  public Map<String, String> a;
  private String b;
  
  public ShareChatModel(int paramInt, long paramLong, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = UUID.randomUUID().toString();
  }
  
  private ShareChatModel(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    paramParcel.readMap(this.jdField_a_of_type_JavaUtilMap, Map.class.getClassLoader());
  }
  
  public String a()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeMap(this.jdField_a_of_type_JavaUtilMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.ShareChatModel
 * JD-Core Version:    0.7.0.1
 */