package com.tencent.protobuf.nearbyPeopleRecommend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.NearbyPeople;

public final class nearbyPeopleRecommend$QueryRspItem
  extends MessageMicro<QueryRspItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_id", "rd_people" }, new Object[] { "", null }, QueryRspItem.class);
  public final PBStringField msg_id = PBField.initString("");
  public final PBRepeatMessageField<oidb_0x8dd.NearbyPeople> rd_people = PBField.initRepeatMessage(oidb_0x8dd.NearbyPeople.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend.QueryRspItem
 * JD-Core Version:    0.7.0.1
 */