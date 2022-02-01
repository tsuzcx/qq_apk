package com.tencent.pb.signature;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SigActPb$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public SigActPb.SigauthReq auth_req = new SigActPb.SigauthReq();
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public SigActPb.Platform plf = new SigActPb.Platform();
  public SigActPb.SigactReq req = new SigActPb.SigactReq();
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBUInt32Field source = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "cmd", "seq", "plf", "req", "auth_req", "source" }, new Object[] { localInteger, Long.valueOf(0L), null, null, null, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.signature.SigActPb.ReqBody
 * JD-Core Version:    0.7.0.1
 */