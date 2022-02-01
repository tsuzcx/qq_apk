package com.tencent.mobileqq.msgbackup.data;

public class MsgBackupQryStateRsp
{
  private int jdField_a_of_type_Int;
  private MsgBackupUserData jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public MsgBackupQryStateRsp(int paramInt1, String paramString1, String paramString2, MsgBackupUserData paramMsgBackupUserData, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData = paramMsgBackupUserData;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public MsgBackupUserData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--MsgBackupQryStateRsp--");
    localStringBuilder.append(",state:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",token:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",encryptKey:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",userData:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData);
    localStringBuilder.append(",bizType:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupQryStateRsp
 * JD-Core Version:    0.7.0.1
 */