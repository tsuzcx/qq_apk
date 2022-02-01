package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_get_record_info_svr$GetRecordInfoRsp
  extends MessageMicro<GetRecordInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "record_info" }, new Object[] { Integer.valueOf(0), null }, GetRecordInfoRsp.class);
  public ilive_get_record_info_svr.RecordInfo record_info = new ilive_get_record_info_svr.RecordInfo();
  public final PBUInt32Field result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_get_record_info_svr.GetRecordInfoRsp
 * JD-Core Version:    0.7.0.1
 */