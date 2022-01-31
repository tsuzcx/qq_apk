package com.tencent.qqmini.sdk.core.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bgkt;

public class FileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FileInfo> CREATOR = new bgkt();
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public FileInfo()
  {
    e("");
    d("");
    a(0L);
    b(System.currentTimeMillis());
    b("");
    c("");
    a("");
  }
  
  private FileInfo(Parcel paramParcel)
  {
    e(paramParcel.readString());
    d(paramParcel.readString());
    a(paramParcel.readLong());
    b(paramParcel.readLong());
    b(paramParcel.readString());
    c(paramParcel.readString());
    a(paramParcel.readString());
  }
  
  private boolean a(FileInfo paramFileInfo)
  {
    return (a() == paramFileInfo.a()) && (b() == paramFileInfo.b()) && (a().equals(paramFileInfo.a()));
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public void d(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof FileInfo))) {
      return false;
    }
    return a((FileInfo)paramObject);
  }
  
  public int hashCode()
  {
    return (b() + a() + b()).hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.FileInfo
 * JD-Core Version:    0.7.0.1
 */