package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedsProtocol$TopicCfg
  extends MessageMicro<TopicCfg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 810 }, new String[] { "topic_tag", "topic_desc", "topic_name", "topic_parti_num", "topic_type", "topic_pic_url", "jump_url" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", "" }, TopicCfg.class);
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField topic_desc = PBField.initString("");
  public final PBStringField topic_name = PBField.initString("");
  public final PBUInt32Field topic_parti_num = PBField.initUInt32(0);
  public final PBStringField topic_pic_url = PBField.initString("");
  public final PBUInt32Field topic_tag = PBField.initUInt32(0);
  public final PBUInt32Field topic_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.TopicCfg
 * JD-Core Version:    0.7.0.1
 */