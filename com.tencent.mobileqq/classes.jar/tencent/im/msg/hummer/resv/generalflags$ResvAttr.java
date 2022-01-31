package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class generalflags$ResvAttr
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_golden_msg_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_kpl_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_shortVideoId = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscription_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFloatField float_sticker_height = PBField.initFloat(0.0F);
  public final PBFloatField float_sticker_width = PBField.initFloat(0.0F);
  public final PBFloatField float_sticker_x = PBField.initFloat(0.0F);
  public final PBFloatField float_sticker_y = PBField.initFloat(0.0F);
  public final PBUInt64Field redbag_msg_sender_uin = PBField.initUInt64(0L);
  public final PBUInt32Field uint32_aio_sync_to_story_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bot_message_class_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_custom_featureid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_diy_font_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_doutu_combo = PBField.initUInt32(0);
  public final PBUInt32Field uint32_doutu_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_face_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_global_group_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_golden_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_holiday_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_love_language_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mobile_custom_font = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nearby_charm_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pendant_diy_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_red_envelope_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_font_effect_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_robot_msg_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_tail_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sticker_rotate = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tail_key = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timed_message = PBField.initUInt32(0);
  public final PBUInt32Field uint32_title_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_sticker_host_msgseq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sticker_host_msguid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sticker_host_time = PBField.initUInt64(0L);
  public final PBUInt64Field want_gift_sender_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 61, 69, 77, 85, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 178, 184, 194, 200, 208, 216, 234, 240, 248, 256, 266, 272, 280, 288 }, new String[] { "uint32_global_group_level", "uint32_nearby_charm_level", "redbag_msg_sender_uin", "uint32_title_id", "uint32_robot_msg_flag", "want_gift_sender_uin", "float_sticker_x", "float_sticker_y", "float_sticker_width", "float_sticker_height", "uint32_sticker_rotate", "uint64_sticker_host_msgseq", "uint64_sticker_host_msguid", "uint64_sticker_host_time", "uint32_mobile_custom_font", "uint32_tail_key", "uint32_show_tail_flag", "uint32_doutu_msg_type", "uint32_doutu_combo", "uint32_custom_featureid", "uint32_golden_msg_type", "bytes_golden_msg_info", "uint32_bot_message_class_id", "bytes_subscription_url", "uint32_pendant_diy_id", "uint32_timed_message", "uint32_holiday_flag", "bytes_kpl_info", "uint32_face_id", "uint32_diy_font_timestamp", "uint32_red_envelope_type", "bytes_shortVideoId", "uint32_req_font_effect_id", "uint32_love_language_flag", "uint32_aio_sync_to_story_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ResvAttr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.resv.generalflags.ResvAttr
 * JD-Core Version:    0.7.0.1
 */