package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SummaryCardBusiEntry$VisitorCountRsp
  extends MessageMicro<VisitorCountRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "requireuin", "totalLike", "totalView", "hotValue", "redValue", "hotDiff" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VisitorCountRsp.class);
  public final PBUInt32Field hotDiff = PBField.initUInt32(0);
  public final PBUInt32Field hotValue = PBField.initUInt32(0);
  public final PBUInt32Field redValue = PBField.initUInt32(0);
  public final PBUInt32Field requireuin = PBField.initUInt32(0);
  public final PBUInt32Field totalLike = PBField.initUInt32(0);
  public final PBUInt32Field totalView = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.profilecard.SummaryCardBusiEntry.VisitorCountRsp
 * JD-Core Version:    0.7.0.1
 */