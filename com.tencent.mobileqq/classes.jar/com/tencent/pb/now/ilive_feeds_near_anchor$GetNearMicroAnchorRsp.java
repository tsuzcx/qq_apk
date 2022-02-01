package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_near_anchor$GetNearMicroAnchorRsp
  extends MessageMicro<GetNearMicroAnchorRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field micro_anchor_num = PBField.initUInt32(0);
  public final PBRepeatMessageField<ilive_feeds_near_anchor.NearMicroAnchor> micro_infos = PBField.initRepeatMessage(ilive_feeds_near_anchor.NearMicroAnchor.class);
  public final PBUInt32Field ret = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "ret", "micro_infos", "micro_anchor_num" }, new Object[] { localInteger, null, localInteger }, GetNearMicroAnchorRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_near_anchor.GetNearMicroAnchorRsp
 * JD-Core Version:    0.7.0.1
 */