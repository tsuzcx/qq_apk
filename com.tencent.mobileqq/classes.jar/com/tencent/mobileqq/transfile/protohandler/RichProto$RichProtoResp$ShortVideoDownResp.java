package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import java.util.ArrayList;

public class RichProto$RichProtoResp$ShortVideoDownResp
  extends RichProto.RichProtoResp.RespCommon
{
  public int a;
  public String a;
  public ArrayList a;
  public byte[] a;
  public String b;
  public byte[] b;
  public String c;
  
  public RichProto$RichProtoResp$ShortVideoDownResp()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" mUkey:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" mIpList:").append(this.jdField_a_of_type_JavaUtilArrayList.toString());
    localStringBuilder.append(" md5:").append(HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
    localStringBuilder.append(" aesKey:").append(HexUtil.bytes2HexStr(this.b));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoDownResp
 * JD-Core Version:    0.7.0.1
 */