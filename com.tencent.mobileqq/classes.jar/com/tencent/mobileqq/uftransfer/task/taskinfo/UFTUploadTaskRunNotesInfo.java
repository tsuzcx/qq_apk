package com.tencent.mobileqq.uftransfer.task.taskinfo;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.uftransfer.utility.UFTTransferUtility;
import com.tencent.mobileqq.uftransfer.utility.UFTTransferUtility.UrlHostInfo;

public class UFTUploadTaskRunNotesInfo
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long;
  private long e;
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l;
  
  public UFTUploadTaskRunNotesInfo()
  {
    a();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public ExcitingTransferUploadResultRp a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if ((localObject != null) && ((localObject instanceof ExcitingTransferUploadResultRp))) {
      return (ExcitingTransferUploadResultRp)localObject;
    }
    return null;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = 0L;
    this.h = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.j = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangObject = null;
    this.k = 0L;
    this.l = 0L;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = UFTTransferUtility.a(paramString);
    this.jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
    this.jdField_c_of_type_Int = paramString.jdField_a_of_type_Int;
    this.jdField_d_of_type_Int = paramString.jdField_b_of_type_Int;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
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
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long c()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public long d()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public void d(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
  }
  
  public long e()
  {
    return this.e;
  }
  
  public void e(long paramLong)
  {
    this.e = paramLong;
  }
  
  public long f()
  {
    return this.f;
  }
  
  public void f(long paramLong)
  {
    this.f = paramLong;
  }
  
  public long g()
  {
    return this.g;
  }
  
  public void g(long paramLong)
  {
    this.g = paramLong;
  }
  
  public long h()
  {
    return this.h;
  }
  
  public void h(long paramLong)
  {
    this.h = paramLong;
  }
  
  public long i()
  {
    return this.j;
  }
  
  public void i(long paramLong)
  {
    this.j = paramLong;
  }
  
  public long j()
  {
    return this.i;
  }
  
  public void j(long paramLong)
  {
    this.i = paramLong;
  }
  
  public long k()
  {
    return this.k;
  }
  
  public void k(long paramLong)
  {
    this.k = paramLong;
  }
  
  public long l()
  {
    return this.l;
  }
  
  public void l(long paramLong)
  {
    this.l = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo
 * JD-Core Version:    0.7.0.1
 */