package com.tencent.mobileqq.statistics.storage;

import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;

public class StorageItem
  extends RecyclablePool.Recyclable
{
  public String a;
  public String b;
  public long c;
  public long d;
  public boolean e;
  public long f;
  public long g;
  
  public void recycle()
  {
    super.recycle();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("StorageItem info[size=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",accessTime=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",isFile=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",fileCount=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",dirCount=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",name=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",path=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.storage.StorageItem
 * JD-Core Version:    0.7.0.1
 */