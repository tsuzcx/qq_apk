package com.tencent.mobileqq.redtouch;

import agrj;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class RedAppInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new agrj();
  private int jdField_a_of_type_Int;
  private RedDisplayInfo jdField_a_of_type_ComTencentMobileqqRedtouchRedDisplayInfo;
  private String jdField_a_of_type_JavaLangString;
  public ArrayList a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public RedDisplayInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRedtouchRedDisplayInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(RedDisplayInfo paramRedDisplayInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedDisplayInfo = paramRedDisplayInfo;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public void e(int paramInt)
  {
    this.e = paramInt;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public void f(int paramInt)
  {
    this.f = paramInt;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public void g(int paramInt)
  {
    this.g = paramInt;
  }
  
  public int h()
  {
    return this.h;
  }
  
  public void h(int paramInt)
  {
    this.h = paramInt;
  }
  
  public int i()
  {
    return this.i;
  }
  
  public void i(int paramInt)
  {
    this.i = paramInt;
  }
  
  public int j()
  {
    return this.j;
  }
  
  public void j(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.d);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedDisplayInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedAppInfo
 * JD-Core Version:    0.7.0.1
 */