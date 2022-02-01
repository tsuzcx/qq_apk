package com.tencent.protobuf.nearbyPeopleRecommend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearbyPeopleRecommend$QueryRecommendReq
  extends MessageMicro<QueryRecommendReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_qq_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public nearbyPeopleRecommend.LBSInfo lbs_info = new nearbyPeopleRecommend.LBSInfo();
  public final PBRepeatMessageField<nearbyPeopleRecommend.QueryReqItem> query_list = PBField.initRepeatMessage(nearbyPeopleRecommend.QueryReqItem.class);
  public final PBInt32Field source = PBField.initInt32(0);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_version = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "lbs_info", "source", "query_list", "uint32_client_version", "uint32_client_type", "bytes_qq_version" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, QueryRecommendReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend.QueryRecommendReq
 * JD-Core Version:    0.7.0.1
 */