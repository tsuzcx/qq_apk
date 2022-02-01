package com.tencent.pb.signature;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class SigActPb$SigauthRsp
  extends MessageMicro<SigauthRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field authfailed_appid = PBField.initInt32(0);
  public final PBBytesField result = PBField.initBytes(ByteStringMicro.EMPTY);
  public SigActPb.SigauthRsp.TipsInfo tips_info = new SigActPb.SigauthRsp.TipsInfo();
  public final PBStringField url = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "result", "url", "tips_info", "authfailed_appid" }, new Object[] { localByteStringMicro, "", null, Integer.valueOf(0) }, SigauthRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.signature.SigActPb.SigauthRsp
 * JD-Core Version:    0.7.0.1
 */