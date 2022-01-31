package com.tencent.mobileqq.service.message;

import android.util.SparseArray;

public class DecodeProtoPkgContext
  extends PBDecodeContext
{
  public int a;
  public long a;
  private SparseArray a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public long c;
  public boolean c;
  public long d;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g = true;
  public boolean h;
  
  public DecodeProtoPkgContext(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.e = paramLong2;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
  }
  
  public Object a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.DecodeProtoPkgContext
 * JD-Core Version:    0.7.0.1
 */