package com.tencent.mobileqq.msgbackup.data;

public class MsgBackupQryStateRsp$Builder
{
  private int jdField_a_of_type_Int;
  private MsgBackupUserData jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(MsgBackupUserData paramMsgBackupUserData)
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData = paramMsgBackupUserData;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public MsgBackupQryStateRsp a()
  {
    return new MsgBackupQryStateRsp(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData, this.jdField_b_of_type_Int);
  }
  
  public Builder b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupQryStateRsp.Builder
 * JD-Core Version:    0.7.0.1
 */