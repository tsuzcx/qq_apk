package com.tencent.mobileqq.msgbackup.data;

public class MsgBackupPushData$Builder
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public MsgBackupPushData a()
  {
    return new MsgBackupPushData(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupPushData.Builder
 * JD-Core Version:    0.7.0.1
 */