package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowQQLiveHomepageProto$TopicRcmdRsp
  extends MessageMicro<TopicRcmdRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_ret", "string_errmsg", "string_offical_topics", "string_hot_topics" }, new Object[] { Integer.valueOf(0), "", "", "" }, TopicRcmdRsp.class);
  public final PBStringField string_errmsg = PBField.initString("");
  public final PBRepeatField<String> string_hot_topics = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> string_offical_topics = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.TopicRcmdRsp
 * JD-Core Version:    0.7.0.1
 */