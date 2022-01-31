package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SummaryCardBusiEntry$VisitorCountReq
  extends MessageMicro<VisitorCountReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "requireuin", "operuin", "mod", "reportFlag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VisitorCountReq.class);
  public final PBInt32Field mod = PBField.initInt32(0);
  public final PBUInt32Field operuin = PBField.initUInt32(0);
  public final PBInt32Field reportFlag = PBField.initInt32(0);
  public final PBUInt32Field requireuin = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.profilecard.SummaryCardBusiEntry.VisitorCountReq
 * JD-Core Version:    0.7.0.1
 */