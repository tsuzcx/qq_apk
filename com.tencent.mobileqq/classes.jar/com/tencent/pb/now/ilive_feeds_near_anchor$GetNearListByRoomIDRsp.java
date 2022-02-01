package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_near_anchor$GetNearListByRoomIDRsp
  extends MessageMicro<GetNearListByRoomIDRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<ilive_feeds_near_anchor.NearAnchorInfo> anchor_infos = PBField.initRepeatMessage(ilive_feeds_near_anchor.NearAnchorInfo.class);
  public final PBUInt32Field anchor_num = PBField.initUInt32(0);
  public final PBUInt32Field ret = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "ret", "anchor_num", "anchor_infos" }, new Object[] { localInteger, localInteger, null }, GetNearListByRoomIDRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_near_anchor.GetNearListByRoomIDRsp
 * JD-Core Version:    0.7.0.1
 */