package com.tencent.turingfd.sdk.xq;

public class Andromeda
  implements protected
{
  public final String Cg;
  public final String Gg;
  public final String Hg;
  public final String Ig;
  public final boolean Og;
  public final int Pg;
  public final String Qg;
  public final String Rg;
  public final int vb;
  public final long zg;
  
  public Andromeda(Andromeda.do paramdo)
  {
    this.Og = paramdo.jdField_a_of_type_Boolean;
    this.zg = paramdo.jdField_a_of_type_Long;
    this.Cg = paramdo.jdField_a_of_type_JavaLangString;
    this.vb = paramdo.jdField_a_of_type_Int;
    this.Pg = paramdo.jdField_b_of_type_Int;
    this.Qg = paramdo.jdField_b_of_type_JavaLangString;
    this.Gg = paramdo.c;
    this.Hg = paramdo.d;
    this.Ig = paramdo.e;
    this.Rg = paramdo.f;
  }
  
  public static Andromeda.do a(long paramLong)
  {
    return new Andromeda.do(false, paramLong, null);
  }
  
  public long getErrorCode()
  {
    return this.zg;
  }
  
  public String getFileMd5()
  {
    return this.Hg;
  }
  
  public String getFileName()
  {
    return this.Ig;
  }
  
  public String getFileSha1()
  {
    return this.Gg;
  }
  
  public String getHandleUrl()
  {
    return this.Qg;
  }
  
  public String getPkgName()
  {
    return this.Cg;
  }
  
  public int getRiskCategory()
  {
    return this.Pg;
  }
  
  public String getRiskTips()
  {
    return this.Rg;
  }
  
  public int getSafeLevel()
  {
    return this.vb;
  }
  
  public boolean isSucceed()
  {
    return this.Og;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Andromeda
 * JD-Core Version:    0.7.0.1
 */