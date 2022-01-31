package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_get_record_info_svr$RecordInfo
  extends MessageMicro<RecordInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "record_video_url", "cmd5", "record_duration", "file_format", "vid_state" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RecordInfo.class);
  public final PBStringField cmd5 = PBField.initString("");
  public final PBUInt32Field file_format = PBField.initUInt32(0);
  public final PBUInt32Field record_duration = PBField.initUInt32(0);
  public final PBStringField record_video_url = PBField.initString("");
  public final PBUInt32Field vid_state = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.ilive_get_record_info_svr.RecordInfo
 * JD-Core Version:    0.7.0.1
 */