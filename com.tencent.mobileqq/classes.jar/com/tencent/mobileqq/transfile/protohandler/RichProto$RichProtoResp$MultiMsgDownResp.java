package com.tencent.mobileqq.transfile.protohandler;

import java.util.ArrayList;

public class RichProto$RichProtoResp$MultiMsgDownResp
  extends RichProto.RichProtoResp.RespCommon
{
  public int a;
  public String a;
  public ArrayList a;
  public byte[] a;
  public byte[] b;
  
  public RichProto$RichProtoResp$MultiMsgDownResp()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" urlParam:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" msgUkey:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ipList:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append(" resId:");
    localStringBuilder.append(this.jdField_a_of_type_ArrayOfByte);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.MultiMsgDownResp
 * JD-Core Version:    0.7.0.1
 */