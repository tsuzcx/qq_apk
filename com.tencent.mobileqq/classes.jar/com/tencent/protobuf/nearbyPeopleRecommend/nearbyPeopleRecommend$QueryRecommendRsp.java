package com.tencent.protobuf.nearbyPeopleRecommend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearbyPeopleRecommend$QueryRecommendRsp
  extends MessageMicro<QueryRecommendRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret_code", "ret_msg", "query_list" }, new Object[] { Integer.valueOf(0), "", null }, QueryRecommendRsp.class);
  public final PBRepeatMessageField<nearbyPeopleRecommend.QueryRspItem> query_list = PBField.initRepeatMessage(nearbyPeopleRecommend.QueryRspItem.class);
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
  public final PBStringField ret_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend.QueryRecommendRsp
 * JD-Core Version:    0.7.0.1
 */