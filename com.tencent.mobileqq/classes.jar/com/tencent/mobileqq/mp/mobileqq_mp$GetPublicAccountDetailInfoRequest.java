package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$GetPublicAccountDetailInfoRequest
  extends MessageMicro<GetPublicAccountDetailInfoRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  public final PBUInt32Field uin = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
  public final PBStringField versionInfo = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "seqno", "uin", "luin", "version", "versionInfo" }, new Object[] { localInteger, localInteger, Long.valueOf(0L), localInteger, "" }, GetPublicAccountDetailInfoRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest
 * JD-Core Version:    0.7.0.1
 */