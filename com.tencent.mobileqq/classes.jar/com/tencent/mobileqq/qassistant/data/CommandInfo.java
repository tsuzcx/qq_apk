package com.tencent.mobileqq.qassistant.data;

import java.util.List;

public class CommandInfo
{
  public int a;
  public JumpInfo a;
  public RecordInfo a;
  public VoiceAssiatantRespInfo.ConfirmSendInfo a;
  public String a;
  public List<FriendItemInfo> a;
  public boolean a;
  public String b;
  public boolean b;
  
  public CommandInfo()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public CommandInfo(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public CommandInfo(int paramInt, String paramString, JumpInfo paramJumpInfo)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqQassistantDataJumpInfo = paramJumpInfo;
  }
  
  public CommandInfo(int paramInt, String paramString, VoiceAssiatantRespInfo.ConfirmSendInfo paramConfirmSendInfo)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqQassistantDataVoiceAssiatantRespInfo$ConfirmSendInfo = paramConfirmSendInfo;
  }
  
  public CommandInfo(int paramInt, String paramString, List<FriendItemInfo> paramList)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.data.CommandInfo
 * JD-Core Version:    0.7.0.1
 */