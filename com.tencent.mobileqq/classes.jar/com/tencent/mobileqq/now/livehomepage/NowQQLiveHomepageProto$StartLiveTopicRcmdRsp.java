package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowQQLiveHomepageProto$StartLiveTopicRcmdRsp
  extends MessageMicro<StartLiveTopicRcmdRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField string_errmsg = PBField.initString("");
  public final PBStringField string_topic = PBField.initString("");
  public final PBUInt32Field uint32_member_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_ret", "string_errmsg", "string_topic", "uint32_member_count" }, new Object[] { localInteger, "", "", localInteger }, StartLiveTopicRcmdRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.StartLiveTopicRcmdRsp
 * JD-Core Version:    0.7.0.1
 */