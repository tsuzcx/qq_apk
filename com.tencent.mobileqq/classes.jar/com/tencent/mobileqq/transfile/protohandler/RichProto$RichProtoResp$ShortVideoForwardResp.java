package com.tencent.mobileqq.transfile.protohandler;

import java.util.ArrayList;

public class RichProto$RichProtoResp$ShortVideoForwardResp
  extends RichProto.RichProtoResp.RespCommon
{
  public int a;
  public long a;
  public String a;
  public ArrayList a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  
  public RichProto$RichProtoResp$ShortVideoForwardResp()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" isExist:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" fileId:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" mUkey:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" firstIpInIntFormat:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" mIpList:").append(this.jdField_a_of_type_JavaUtilArrayList.toString());
    localStringBuilder.append(" isUseBdh:").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(" startOffset:").append(this.jdField_b_of_type_Long);
    localStringBuilder.append("videoAttr:").append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoForwardResp
 * JD-Core Version:    0.7.0.1
 */