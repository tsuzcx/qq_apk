package com.tencent.mobileqq.transfile;

public class FileMsg$StepBaseInfo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public int c;
  public long c;
  public int d;
  
  public FileMsg$StepBaseInfo()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 9001;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Long = 9223372036854775807L;
  }
  
  public long a()
  {
    long l = 0L;
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Long != 0L)) {
      l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    }
    while ((this.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_Long == 0L)) {
      return l;
    }
    return 612345L;
  }
  
  public String a()
  {
    if (a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append("elapsed:" + a());
      localStringBuilder.append(",tryCount:" + this.jdField_b_of_type_Int);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    return "{}";
  }
  
  public String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Long > 0L)
      {
        localStringBuilder.append("1");
        localStringBuilder.append("_");
      }
    }
    for (;;)
    {
      if ((!(this instanceof FileMsg.StepTransInfo)) && (!this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Int > 0))
      {
        this.d += this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = 0;
      }
      localStringBuilder.append(this.jdField_c_of_type_Int).append("_");
      localStringBuilder.append(this.d).append("_");
      localStringBuilder.append(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long);
      return localStringBuilder.toString();
      localStringBuilder.append("-1");
      break;
      localStringBuilder.append("0").append("_");
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 9001;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 0;
    this.d = 0;
    this.jdField_c_of_type_Long = 9223372036854775807L;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Long != 0L) || (this.jdField_b_of_type_Long != 0L);
  }
  
  public String toString()
  {
    return "result:" + this.jdField_a_of_type_Boolean + " startTime:" + this.jdField_a_of_type_Long + " finishTime:" + this.jdField_b_of_type_Long + " errCode:" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileMsg.StepBaseInfo
 * JD-Core Version:    0.7.0.1
 */