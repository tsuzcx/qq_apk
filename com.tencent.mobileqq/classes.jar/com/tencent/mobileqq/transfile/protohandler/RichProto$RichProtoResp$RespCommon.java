package com.tencent.mobileqq.transfile.protohandler;

public class RichProto$RichProtoResp$RespCommon
{
  public int c = -1;
  public int d;
  public int e;
  public boolean e;
  public int f;
  public boolean f;
  public String g;
  public String h;
  
  public RichProto$RichProtoResp$RespCommon()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" errCode:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" errStr:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" reason:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" succCnt:");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(" failCnt");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(" isSendByQuickHttp");
    localStringBuilder.append(this.jdField_e_of_type_Boolean);
    localStringBuilder.append(" isAllowRetry");
    localStringBuilder.append(this.jdField_f_of_type_Boolean);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
 * JD-Core Version:    0.7.0.1
 */