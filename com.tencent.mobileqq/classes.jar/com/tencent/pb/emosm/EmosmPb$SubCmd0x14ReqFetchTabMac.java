package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class EmosmPb$SubCmd0x14ReqFetchTabMac
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 29, 32 }, new String[] { "fixed32_timestamp_ios", "int32_segment_flag_ios", "fixed32_timestamp_android", "int32_segment_flag_android" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x14ReqFetchTabMac.class);
  public final PBFixed32Field fixed32_timestamp_android = PBField.initFixed32(0);
  public final PBFixed32Field fixed32_timestamp_ios = PBField.initFixed32(0);
  public final PBInt32Field int32_segment_flag_android = PBField.initInt32(0);
  public final PBInt32Field int32_segment_flag_ios = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x14ReqFetchTabMac
 * JD-Core Version:    0.7.0.1
 */