package com.tencent.protobuf.nearbyReportSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class NearbyReportSvr$TempChatRsp
  extends MessageMicro<TempChatRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "ret_msg" }, new Object[] { Integer.valueOf(0), "" }, TempChatRsp.class);
  public final PBInt32Field ret_code = PBField.initInt32(0);
  public final PBStringField ret_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protobuf.nearbyReportSvr.NearbyReportSvr.TempChatRsp
 * JD-Core Version:    0.7.0.1
 */