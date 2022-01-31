package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_near_anchor$GetNearAnchorRsp
  extends MessageMicro<GetNearAnchorRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "ret", "anchor_num", "anchor_infos", "allow_repeated", "gender_filter" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, GetNearAnchorRsp.class);
  public final PBUInt32Field allow_repeated = PBField.initUInt32(0);
  public final PBRepeatMessageField<ilive_feeds_near_anchor.NearAnchorInfo> anchor_infos = PBField.initRepeatMessage(ilive_feeds_near_anchor.NearAnchorInfo.class);
  public final PBUInt32Field anchor_num = PBField.initUInt32(0);
  public final PBEnumField gender_filter = PBField.initEnum(0);
  public final PBUInt32Field ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_near_anchor.GetNearAnchorRsp
 * JD-Core Version:    0.7.0.1
 */