package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bdmq;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EntryModel
  implements Parcelable
{
  public static final Parcelable.Creator<EntryModel> CREATOR = new bdmq();
  public int a;
  public long a;
  public String a;
  public Map<String, String> a;
  public boolean a;
  private String b;
  
  public EntryModel(int paramInt, long paramLong, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = UUID.randomUUID().toString();
  }
  
  private EntryModel(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.b = paramParcel.readString();
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
      }
      paramParcel.readMap(this.jdField_a_of_type_JavaUtilMap, Map.class.getClassLoader());
      return;
    }
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
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.b);
      paramParcel.writeMap(this.jdField_a_of_type_JavaUtilMap);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.EntryModel
 * JD-Core Version:    0.7.0.1
 */