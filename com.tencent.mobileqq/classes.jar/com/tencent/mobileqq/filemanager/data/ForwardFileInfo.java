package com.tencent.mobileqq.filemanager.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aonv;
import java.util.ArrayList;

public class ForwardFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ForwardFileInfo> CREATOR = new aonv();
  public int a;
  private long jdField_a_of_type_Long;
  private WeiYunFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  
  public ForwardFileInfo()
  {
    a("");
    b("");
    d("");
    b(-1L);
    c("");
    b(this.jdField_b_of_type_Int);
    e("");
  }
  
  private ForwardFileInfo(Parcel paramParcel)
  {
    b(paramParcel.readInt());
    b(paramParcel.readLong());
    d(paramParcel.readLong());
    a(paramParcel.readString());
    b(paramParcel.readString());
    c(paramParcel.readString());
    c(paramParcel.readInt());
    d(paramParcel.readString());
    a(paramParcel.readLong());
    d(paramParcel.readInt());
    c(paramParcel.readLong());
    e(paramParcel.readString());
    f(paramParcel.readString());
    a(paramParcel.readInt());
    a((WeiYunFileInfo)paramParcel.readParcelable(WeiYunFileInfo.class.getClassLoader()));
    a(paramParcel.readArrayList(Long.class.getClassLoader()));
  }
  
  private boolean a(ForwardFileInfo paramForwardFileInfo)
  {
    return (d().equals(paramForwardFileInfo.d())) && (d() == paramForwardFileInfo.d()) && (b() == paramForwardFileInfo.b());
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public WeiYunFileInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<Long> a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo = paramWeiYunFileInfo;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(ArrayList<Long> paramArrayList)
  {
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public long c()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long d()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
  }
  
  public void d(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void e(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof ForwardFileInfo))) {
      return false;
    }
    return a((ForwardFileInfo)paramObject);
  }
  
  public String f()
  {
    return this.f;
  }
  
  public void f(String paramString)
  {
    this.f = paramString;
  }
  
  public int hashCode()
  {
    return (d() + d()).hashCode();
  }
  
  public String toString()
  {
    return "type[" + this.jdField_b_of_type_Int + "], cloudTYpe[" + this.jdField_c_of_type_Int + "], sessionId[" + this.jdField_a_of_type_Long + "], uniseq[" + this.jdField_b_of_type_Long + "], uuid[" + this.jdField_b_of_type_JavaLangString + "], fileId[" + this.jdField_c_of_type_JavaLangString + "], weiYunSrcType[" + this.jdField_d_of_type_Int + "], uuidTroopFile[" + this.jdField_e_of_type_JavaLangString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(b());
    paramParcel.writeLong(b());
    paramParcel.writeLong(d());
    paramParcel.writeString(a());
    paramParcel.writeString(b());
    paramParcel.writeString(c());
    paramParcel.writeInt(c());
    paramParcel.writeString(d());
    paramParcel.writeLong(a());
    paramParcel.writeInt(d());
    paramParcel.writeLong(c());
    paramParcel.writeString(e());
    paramParcel.writeString(f());
    paramParcel.writeInt(a());
    paramParcel.writeParcelable(a(), paramInt);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.ForwardFileInfo
 * JD-Core Version:    0.7.0.1
 */