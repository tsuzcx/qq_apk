package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class STExploreInfo$STGetMsgReq
  extends MessageMicro<STGetMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "app_type", "eid_list" }, new Object[] { Integer.valueOf(0), null }, STGetMsgReq.class);
  public final PBInt32Field app_type = PBField.initInt32(0);
  public final PBRepeatMessageField<STExploreInfo.STEntryIdInfo> eid_list = PBField.initRepeatMessage(STExploreInfo.STEntryIdInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.apollo.STExploreInfo.STGetMsgReq
 * JD-Core Version:    0.7.0.1
 */