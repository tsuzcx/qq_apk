package com.tencent.mobileqq.statistics.storage;

import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;

public class StorageItem
  extends RecyclablePool.Recyclable
{
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public long c;
  public long d;
  
  public void recycle()
  {
    super.recycle();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("StorageItem info[size=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",accessTime=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(",isFile=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",fileCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",dirCount=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",name=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",path=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.storage.StorageItem
 * JD-Core Version:    0.7.0.1
 */