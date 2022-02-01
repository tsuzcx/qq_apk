package com.tencent.mobileqq.msgbackup.data;

public class MsgBackupGetQrRsp$Builder
{
  private int jdField_a_of_type_Int;
  private MsgBackupUserData jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
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
  
  public MsgBackupGetQrRsp a()
  {
    return new MsgBackupGetQrRsp(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData, this.jdField_a_of_type_Int);
  }
  
  public Builder b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.c = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupGetQrRsp.Builder
 * JD-Core Version:    0.7.0.1
 */