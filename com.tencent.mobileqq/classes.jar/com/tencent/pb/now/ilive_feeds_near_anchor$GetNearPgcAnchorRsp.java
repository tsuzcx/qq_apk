package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_near_anchor$GetNearPgcAnchorRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "ret", "anchor_num", "anchor_infos" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, GetNearPgcAnchorRsp.class);
  public final PBRepeatMessageField anchor_infos = PBField.initRepeatMessage(ilive_feeds_near_anchor.NearAnchorInfo.class);
  public final PBUInt32Field anchor_num = PBField.initUInt32(0);
  public final PBUInt32Field ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_near_anchor.GetNearPgcAnchorRsp
 * JD-Core Version:    0.7.0.1
 */