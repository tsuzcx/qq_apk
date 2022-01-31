package com.tencent.mobileqq.transfile;

import java.util.HashMap;

public class NetResp
{
  public int a;
  public long a;
  public NetReq a;
  public String a;
  public HashMap a;
  public byte[] a;
  public int b;
  public long b;
  public int c;
  public long c;
  public int d;
  public long d;
  public int e;
  long e = 0L;
  long f;
  public long g;
  public long h;
  public long i;
  public long j;
  
  public NetResp(NetReq paramNetReq)
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = paramNetReq;
    this.f = System.currentTimeMillis();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, HashMap paramHashMap)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.putAll(paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NetResp
 * JD-Core Version:    0.7.0.1
 */