package com.tencent.protofile.getopenid;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetOpenidProto$GetOpenidEntry
  extends MessageMicro<GetOpenidEntry>
{
  public static final int ID_FIELD_NUMBER = 2;
  public static final int OPENID_FIELD_NUMBER = 3;
  public static final int TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "type", "id", "openid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "" }, GetOpenidEntry.class);
  public final PBUInt64Field id = PBField.initUInt64(0L);
  public final PBStringField openid = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidEntry
 * JD-Core Version:    0.7.0.1
 */