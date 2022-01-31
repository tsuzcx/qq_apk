package com.tencent.mobileqq.filemanager.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aonr;
import apck;
import java.io.File;
import java.io.FileNotFoundException;

public class FileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FileInfo> CREATOR = new aonr();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String d;
  private String e;
  
  public FileInfo()
  {
    e("");
    d("");
    a(0L);
    b(System.currentTimeMillis());
    b("");
    b(-1);
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
    b(paramParcel.readInt());
    c(paramParcel.readString());
    a(paramParcel.readString());
  }
  
  public FileInfo(String paramString)
  {
    if (paramString == null) {
      throw new FileNotFoundException("file path is null!");
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      throw new FileNotFoundException("file not exist!");
    }
    b(paramString.isDirectory());
    e(paramString.getAbsolutePath());
    d(paramString.getName());
    a(paramString.length());
    b(paramString.lastModified());
    b(apck.a(this.jdField_b_of_type_JavaLangString));
    c("");
    a("");
  }
  
  public static FileInfo a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    File localFile;
    do
    {
      return null;
      localFile = new File(paramString);
    } while ((!localFile.exists()) || (localFile.length() == 0L));
    try
    {
      paramString = new FileInfo(paramString);
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  private boolean a(FileInfo paramFileInfo)
  {
    return (a() == paramFileInfo.a()) && (b() == paramFileInfo.b()) && (c().equals(paramFileInfo.c()));
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.e;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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
    this.jdField_b_of_type_Boolean = paramBoolean;
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
    return this.d;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_JavaLangString;
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
    return (d() + a() + b()).hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileInfo
 * JD-Core Version:    0.7.0.1
 */