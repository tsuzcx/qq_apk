package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowQQLiveHomepageProto$RecommendPageReq
  extends MessageMicro<RecommendPageReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField channel = PBField.initString("");
  public final PBStringField device_id = PBField.initString("");
  public final PBUInt32Field is_need_banner_topic = PBField.initUInt32(0);
  public final PBUInt32Field is_no_public_room = PBField.initUInt32(0);
  public final PBStringField qimei = PBField.initString("");
  public final PBUInt32Field rcmd_col_mode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_update = PBField.initUInt32(0);
  public final PBStringField union_channel = PBField.initString("");
  public final PBRepeatMessageField<NowQQLiveHomepageProto.UserMsgInfo> user_msg_info = PBField.initRepeatMessage(NowQQLiveHomepageProto.UserMsgInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66, 72, 82, 90 }, new String[] { "uint32_last_update", "uint32_index", "uint32_count", "is_need_banner_topic", "user_msg_info", "rcmd_col_mode", "channel", "union_channel", "is_no_public_room", "device_id", "qimei" }, new Object[] { localInteger, localInteger, localInteger, localInteger, null, localInteger, "", "", localInteger, "", "" }, RecommendPageReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RecommendPageReq
 * JD-Core Version:    0.7.0.1
 */