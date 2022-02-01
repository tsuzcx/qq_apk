package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_get_record_info_svr$GetRecordInfoReq
  extends MessageMicro<GetRecordInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field filetype = PBField.initUInt32(0);
  public final PBUInt32Field is_ipv6 = PBField.initUInt32(0);
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBStringField vid = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "vid", "platform", "filetype", "is_ipv6" }, new Object[] { "", localInteger, localInteger, localInteger }, GetRecordInfoReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_get_record_info_svr.GetRecordInfoReq
 * JD-Core Version:    0.7.0.1
 */