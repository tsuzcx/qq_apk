package com.tencent.mobileqq.ilive.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LiveRoomList$GetFeedsListReq
  extends MessageMicro<GetFeedsListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field page_size = PBField.initUInt32(0);
  public final PBRepeatMessageField<LiveRoomList.KV> penetrate_info = PBField.initRepeatMessage(LiveRoomList.KV.class);
  public final PBStringField recom_info = PBField.initString("");
  public final PBInt32Field source_type = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "page_size", "source_type", "penetrate_info", "recom_info" }, new Object[] { localInteger, localInteger, null, "" }, GetFeedsListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ilive.pb.LiveRoomList.GetFeedsListReq
 * JD-Core Version:    0.7.0.1
 */