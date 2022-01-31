package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ExtendFriendSquareInfo$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_feedback_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rsp_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_msg_stranger_info = PBField.initRepeatMessage(ExtendFriendSquareInfo.StrangerInfo.class);
  public final PBUInt32Field uint32_friend_max_votes = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_profile_complete = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_show_card = PBField.initUInt32(0);
  public final PBUInt32Field uint32_over = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56, 66, 72, 80, 106 }, new String[] { "uint64_uin", "uint32_over", "bytes_rsp_page_cookies", "uint32_total_count", "rpt_msg_stranger_info", "uint32_is_profile_complete", "uint32_is_show_card", "bytes_cover_url", "uint32_gender", "uint32_friend_max_votes", "bytes_feedback_context" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.extendfriend.ExtendFriendSquareInfo.RspBody
 * JD-Core Version:    0.7.0.1
 */