package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$ExtraInfo
  extends MessageMicro<ExtraInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_apns_tips = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_card = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sender_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_apns_sound_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_mask = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_state_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_tail_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_new_group_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58, 66, 72, 80, 88, 96 }, new String[] { "bytes_nick", "bytes_group_card", "uint32_level", "uint32_flags", "uint32_group_mask", "uint32_msg_tail_id", "bytes_sender_title", "bytes_apns_tips", "uint64_uin", "uint32_msg_state_flag", "uint32_apns_sound_type", "uint32_new_group_flag" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localInteger, localInteger, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), localInteger, localInteger, localInteger }, ExtraInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.ExtraInfo
 * JD-Core Version:    0.7.0.1
 */