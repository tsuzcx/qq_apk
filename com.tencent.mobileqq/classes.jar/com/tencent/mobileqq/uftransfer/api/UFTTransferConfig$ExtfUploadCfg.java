package com.tencent.mobileqq.uftransfer.api;

public class UFTTransferConfig$ExtfUploadCfg
{
  private int jdField_a_of_type_Int = 3;
  private long jdField_a_of_type_Long = 10485760L;
  private int jdField_b_of_type_Int = 524288;
  private long jdField_b_of_type_Long = 7000L;
  private int jdField_c_of_type_Int = 200;
  private long jdField_c_of_type_Long = 21000L;
  private int jdField_d_of_type_Int = 27;
  private long jdField_d_of_type_Long = 120000L;
  private int e = 10;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long c()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public int d()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public long d()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public void d(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public void e(int paramInt)
  {
    this.e = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtfUploadCfg{muliFileSizeLimit=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", maxChannelNum=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", pieceSize=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", maxEachHostTotalUseCount=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", maxEachHostErrorCount=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", maxEachHostParallelUseCount=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", connectTimeout=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", dataTimeout=");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", totoalDataTimeout=");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.ExtfUploadCfg
 * JD-Core Version:    0.7.0.1
 */