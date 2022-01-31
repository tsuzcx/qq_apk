package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class STExploreInfo$STEntryIdMsg
  extends MessageMicro<STEntryIdMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "entry_id", "msg_info", "next_req_ts" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, STEntryIdMsg.class);
  public final PBInt32Field entry_id = PBField.initInt32(0);
  public final PBRepeatMessageField<STExploreInfo.STMsgInfo> msg_info = PBField.initRepeatMessage(STExploreInfo.STMsgInfo.class);
  public final PBUInt32Field next_req_ts = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.apollo.STExploreInfo.STEntryIdMsg
 * JD-Core Version:    0.7.0.1
 */