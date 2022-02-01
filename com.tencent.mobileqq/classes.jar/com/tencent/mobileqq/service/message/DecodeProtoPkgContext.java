package com.tencent.mobileqq.service.message;

import android.util.SparseArray;

public class DecodeProtoPkgContext
  extends PBDecodeContext
{
  public long a;
  public long b;
  public long c;
  public long d;
  public int e;
  public int f;
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  public boolean j = false;
  public boolean k = false;
  public boolean l = false;
  public boolean m = true;
  public boolean n = false;
  public boolean o = false;
  public int p;
  public int q;
  public long r = -1L;
  public long s = -1L;
  public String t;
  public int u = 0;
  public long v;
  private SparseArray<Object> z;
  
  public DecodeProtoPkgContext(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.a = paramLong1;
    this.x = paramLong2;
    this.g = paramBoolean1;
    this.h = paramBoolean2;
    this.i = paramBoolean3;
    this.j = paramBoolean4;
  }
  
  public Object a(int paramInt)
  {
    SparseArray localSparseArray = this.z;
    if (localSparseArray != null) {
      return localSparseArray.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.z == null) {
      this.z = new SparseArray();
    }
    this.z.put(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.DecodeProtoPkgContext
 * JD-Core Version:    0.7.0.1
 */