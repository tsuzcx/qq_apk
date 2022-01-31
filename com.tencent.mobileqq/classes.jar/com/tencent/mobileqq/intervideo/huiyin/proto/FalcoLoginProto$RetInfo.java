package com.tencent.mobileqq.intervideo.huiyin.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FalcoLoginProto$RetInfo
  extends MessageMicro<RetInfo>
{
  public static final int ERR_CODE_FIELD_NUMBER = 1;
  public static final int ERR_MSG_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "err_code", "err_msg" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
  public final PBUInt32Field err_code = PBField.initUInt32(0);
  public final PBStringField err_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huiyin.proto.FalcoLoginProto.RetInfo
 * JD-Core Version:    0.7.0.1
 */