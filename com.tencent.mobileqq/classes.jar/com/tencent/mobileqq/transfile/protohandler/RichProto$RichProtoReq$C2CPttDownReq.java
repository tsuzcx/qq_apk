package com.tencent.mobileqq.transfile.protohandler;

public class RichProto$RichProtoReq$C2CPttDownReq
  extends RichProto.RichProtoReq.ReqCommon
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" uuid:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" storageSource:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" isSelfSend:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" voiceType:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" busiType:").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" downType:").append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.C2CPttDownReq
 * JD-Core Version:    0.7.0.1
 */