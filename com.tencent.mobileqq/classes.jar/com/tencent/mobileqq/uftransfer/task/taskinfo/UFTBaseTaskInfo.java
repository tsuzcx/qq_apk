package com.tencent.mobileqq.uftransfer.task.taskinfo;

import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;

public class UFTBaseTaskInfo
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final UFTFileLocalInfo jdField_a_of_type_ComTencentMobileqqUftransferApiUFTFileLocalInfo = new UFTFileLocalInfo();
  private final UFTTransferConfig jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  
  public UFTBaseTaskInfo(long paramLong, int paramInt, UFTTransferConfig paramUFTTransferConfig, boolean paramBoolean)
  {
    UFTTransferConfig localUFTTransferConfig = paramUFTTransferConfig;
    if (paramUFTTransferConfig == null) {
      localUFTTransferConfig = new UFTTransferConfig(paramBoolean);
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig = localUFTTransferConfig;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public UFTFileLocalInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTFileLocalInfo;
  }
  
  public UFTTransferConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTransferConfig;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo
 * JD-Core Version:    0.7.0.1
 */