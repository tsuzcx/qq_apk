package com.tencent.pb.signature;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SigActPb$SigactReq
  extends MessageMicro<SigactReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field actid = PBField.initInt32(0);
  public final PBInt32Field acttype = PBField.initInt32(0);
  public final PBUInt64Field uin_disable = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin_disable", "actid", "acttype" }, new Object[] { Long.valueOf(0L), localInteger, localInteger }, SigactReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.signature.SigActPb.SigactReq
 * JD-Core Version:    0.7.0.1
 */