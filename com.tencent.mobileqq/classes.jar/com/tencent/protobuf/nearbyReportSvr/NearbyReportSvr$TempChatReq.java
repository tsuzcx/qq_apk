package com.tencent.protobuf.nearbyReportSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NearbyReportSvr$TempChatReq
  extends MessageMicro<TempChatReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public NearbyReportSvr.CommonData common_data = new NearbyReportSvr.CommonData();
  public final PBStringField ext = PBField.initString("");
  public NearbyReportSvr.Location location = new NearbyReportSvr.Location();
  public final PBStringField msg_content = PBField.initString("");
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  public final PBUInt64Field receiver = PBField.initUInt64(0L);
  public final PBUInt64Field send_time = PBField.initUInt64(0L);
  public final PBUInt64Field sender = PBField.initUInt64(0L);
  public final PBUInt64Field src = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66, 74 }, new String[] { "sender", "receiver", "send_time", "msg_type", "msg_content", "src", "ext", "location", "common_data" }, new Object[] { localLong, localLong, localLong, Integer.valueOf(0), "", localLong, "", null, null }, TempChatReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.nearbyReportSvr.NearbyReportSvr.TempChatReq
 * JD-Core Version:    0.7.0.1
 */