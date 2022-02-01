package com.tencent.mobileqq.service.message;

import android.util.SparseArray;

public class DecodeProtoPkgContext
  extends PBDecodeContext
{
  public int a;
  public long a;
  private SparseArray<Object> a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public boolean b = false;
  public int c;
  public long c;
  public boolean c = false;
  public int d;
  public long d;
  public boolean d = false;
  public int e;
  public long e;
  public boolean e;
  public long f;
  public boolean f;
  public boolean g;
  public boolean h = false;
  public boolean i = false;
  
  public DecodeProtoPkgContext(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_e_of_type_Long = -1L;
    this.jdField_f_of_type_Long = -1L;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_g_of_type_Long = paramLong2;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
  }
  
  public Object a(int paramInt)
  {
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    if (localSparseArray != null) {
      return localSparseArray.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.DecodeProtoPkgContext
 * JD-Core Version:    0.7.0.1
 */