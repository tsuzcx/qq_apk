package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class HwConfigPersistentPB$HwEndPointPB
  extends MessageMicro<HwEndPointPB>
{
  public static final int INT32_PORT_FIELD_NUMBER = 2;
  public static final int INT64_TIMESTAMPE_FIELD_NUMBER = 3;
  public static final int STRING_HOST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "string_host", "int32_port", "int64_timestampe" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L) }, HwEndPointPB.class);
  public final PBInt32Field int32_port = PBField.initInt32(0);
  public final PBInt64Field int64_timestampe = PBField.initInt64(0L);
  public final PBStringField string_host = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwEndPointPB
 * JD-Core Version:    0.7.0.1
 */