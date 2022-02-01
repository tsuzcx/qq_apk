package com.tencent.protofile.cmd0xe23;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xe23$GetConsumeInfoItem
  extends MessageMicro<GetConsumeInfoItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field continue_finish_day = PBField.initUInt32(0);
  public final PBUInt32Field current_progress = PBField.initUInt32(0);
  public final PBUInt32Field need_record = PBField.initUInt32(0);
  public final PBUInt64Field next_request_time = PBField.initUInt64(0L);
  public final PBUInt32Field today_ad_count = PBField.initUInt32(0);
  public final PBUInt32Field total_progress = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 32, 40, 48, 56 }, new String[] { "current_progress", "total_progress", "need_record", "next_request_time", "continue_finish_day", "today_ad_count" }, new Object[] { localInteger, localInteger, localInteger, Long.valueOf(0L), localInteger, localInteger }, GetConsumeInfoItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.cmd0xe23.cmd0xe23.GetConsumeInfoItem
 * JD-Core Version:    0.7.0.1
 */