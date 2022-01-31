package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class STGameLogin$STGameTagInfo
  extends MessageMicro<STGameTagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "game_id", "tag_type", "tag_url", "tag_beg_ts", "tag_end_ts" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, STGameTagInfo.class);
  public final PBUInt32Field game_id = PBField.initUInt32(0);
  public final PBUInt32Field tag_beg_ts = PBField.initUInt32(0);
  public final PBUInt32Field tag_end_ts = PBField.initUInt32(0);
  public final PBInt32Field tag_type = PBField.initInt32(0);
  public final PBStringField tag_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.apollo.STGameLogin.STGameTagInfo
 * JD-Core Version:    0.7.0.1
 */