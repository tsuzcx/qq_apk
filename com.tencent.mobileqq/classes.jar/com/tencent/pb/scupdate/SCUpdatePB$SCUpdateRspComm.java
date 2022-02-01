package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class SCUpdatePB$SCUpdateRspComm
  extends MessageMicro<SCUpdateRspComm>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "polltime", "cookie" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, SCUpdateRspComm.class);
  public final PBInt64Field cookie = PBField.initInt64(0L);
  public final PBInt32Field polltime = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.scupdate.SCUpdatePB.SCUpdateRspComm
 * JD-Core Version:    0.7.0.1
 */