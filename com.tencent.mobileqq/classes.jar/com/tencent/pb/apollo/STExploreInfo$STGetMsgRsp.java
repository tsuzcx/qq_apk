package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class STExploreInfo$STGetMsgRsp
  extends MessageMicro<STGetMsgRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "eid_list" }, new Object[] { null }, STGetMsgRsp.class);
  public final PBRepeatMessageField<STExploreInfo.STEntryIdMsg> eid_list = PBField.initRepeatMessage(STExploreInfo.STEntryIdMsg.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.apollo.STExploreInfo.STGetMsgRsp
 * JD-Core Version:    0.7.0.1
 */