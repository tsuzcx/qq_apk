package com.tencent.open.agent.entity;

import com.tencent.open.model.VirtualInfo;

public class VirtualAccountInfo
{
  public long a;
  public String a;
  public boolean a;
  public String b;
  
  public VirtualAccountInfo(VirtualInfo paramVirtualInfo)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramVirtualInfo.b;
    this.b = paramVirtualInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Long = paramVirtualInfo.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.entity.VirtualAccountInfo
 * JD-Core Version:    0.7.0.1
 */