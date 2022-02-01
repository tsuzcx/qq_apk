package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class generalflags$ResvAttr
  extends MessageMicro<ResvAttr>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_golden_msg_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_confess_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_msg_busi_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hudong_mark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_kpl_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_message_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_oac_msg_extend = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pass_through = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pb_ptt_waveform = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_robot_general_trans = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_service_msg_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_shortVideoId = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscription_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_upload_image_to_qzone_param = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_user_vip_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_yuheng_task_msg_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFloatField float_sticker_height = PBField.initFloat(0.0F);
  public final PBFloatField float_sticker_width = PBField.initFloat(0.0F);
  public final PBFloatField float_sticker_x = PBField.initFloat(0.0F);
  public final PBFloatField float_sticker_y = PBField.initFloat(0.0F);
  public generalflags.PassThrough pass_through = new generalflags.PassThrough();
  public final PBUInt64Field redbag_msg_sender_uin = PBField.initUInt64(0L);
  public final PBRepeatField<Integer> rpt_uint32_custom_featureid = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_aio_sync_to_story_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_auto_reply = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bot_message_class_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comment_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_custom_featureid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_device_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_diy_font_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_doutu_combo = PBField.initUInt32(0);
  public final PBUInt32Field uint32_doutu_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_face_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_global_group_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_golden_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gray_name_plate = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_info_flag_ex3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_info_flag_ex4 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_member_flag_ex2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_rich_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_ringtone_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_savedb_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_holiday_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_important_msg_enum = PBField.initUInt32(0);
  public final PBUInt32Field uint32_important_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_kings_honor_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_love_language_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mobile_custom_font = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_flag_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_info_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nameplate = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nameplate_vip_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nearby_charm_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pendant_diy_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_red_envelope_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_font_effect_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_is_bigclub_hidden = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rich_card_name_ver = PBField.initUInt32(0);
  public final PBUInt32Field uint32_robot_msg_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_msg_remind_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_in_msg_list = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_tail_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sticker_rotate = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tail_key = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timed_message = PBField.initUInt32(0);
  public final PBUInt32Field uint32_title_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_troop_pobing_template = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unsafe_msg_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upload_image_to_qzone_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_bigclub_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_bigclub_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vip_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vip_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_comment_location = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sticker_host_msgseq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sticker_host_msguid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sticker_host_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_subfont_id = PBField.initUInt64(0L);
  public final PBUInt64Field want_gift_sender_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    Float localFloat = Float.valueOf(0.0F);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro14 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro15 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro16 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro17 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 61, 69, 77, 85, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 178, 184, 194, 200, 208, 216, 234, 240, 248, 256, 266, 272, 280, 288, 296, 314, 322, 328, 336, 344, 352, 376, 384, 392, 402, 408, 416, 426, 432, 440, 448, 456, 464, 472, 482, 488, 496, 506, 512, 522, 528, 536, 544, 554, 560, 568, 576, 586, 592, 600, 608, 616, 626, 632, 640, 648, 658, 666, 674, 16002 }, new String[] { "uint32_global_group_level", "uint32_nearby_charm_level", "redbag_msg_sender_uin", "uint32_title_id", "uint32_robot_msg_flag", "want_gift_sender_uin", "float_sticker_x", "float_sticker_y", "float_sticker_width", "float_sticker_height", "uint32_sticker_rotate", "uint64_sticker_host_msgseq", "uint64_sticker_host_msguid", "uint64_sticker_host_time", "uint32_mobile_custom_font", "uint32_tail_key", "uint32_show_tail_flag", "uint32_doutu_msg_type", "uint32_doutu_combo", "uint32_custom_featureid", "uint32_golden_msg_type", "bytes_golden_msg_info", "uint32_bot_message_class_id", "bytes_subscription_url", "uint32_pendant_diy_id", "uint32_timed_message", "uint32_holiday_flag", "bytes_kpl_info", "uint32_face_id", "uint32_diy_font_timestamp", "uint32_red_envelope_type", "bytes_shortVideoId", "uint32_req_font_effect_id", "uint32_love_language_flag", "uint32_aio_sync_to_story_flag", "uint32_upload_image_to_qzone_flag", "bytes_upload_image_to_qzone_param", "bytes_group_confess_sig", "uint64_subfont_id", "uint32_msg_flag_type", "rpt_uint32_custom_featureid", "uint32_rich_card_name_ver", "uint32_msg_info_flag", "uint32_service_msg_type", "uint32_service_msg_remind_type", "bytes_service_msg_name", "uint32_vip_type", "uint32_vip_level", "bytes_pb_ptt_waveform", "uint32_user_bigclub_level", "uint32_user_bigclub_flag", "uint32_nameplate", "uint32_auto_reply", "uint32_req_is_bigclub_hidden", "uint32_show_in_msg_list", "bytes_oac_msg_extend", "uint32_group_member_flag_ex2", "uint32_group_ringtone_id", "bytes_robot_general_trans", "uint32_troop_pobing_template", "bytes_hudong_mark", "uint32_group_info_flag_ex3", "uint32_comment_flag", "uint64_comment_location", "bytes_pass_through", "uint32_group_savedb_flag", "uint32_nameplate_vip_type", "uint32_gray_name_plate", "bytes_user_vip_info", "uint32_important_msg_type", "uint32_important_msg_enum", "uint32_device_type", "uint32_unsafe_msg_flag", "bytes_group_msg_busi_buf", "uint32_group_info_flag_ex4", "uint32_kings_honor_level", "uint32_group_rich_flag", "bytes_yuheng_task_msg_buf", "bytes_tag_name", "bytes_message_ext", "pass_through" }, new Object[] { localInteger, localInteger, localLong, localInteger, localInteger, localLong, localFloat, localFloat, localFloat, localFloat, localInteger, localLong, localLong, localLong, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, localInteger, localInteger, localInteger, localByteStringMicro3, localInteger, localInteger, localInteger, localByteStringMicro4, localInteger, localInteger, localInteger, localInteger, localByteStringMicro5, localByteStringMicro6, localLong, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro7, localInteger, localInteger, localByteStringMicro8, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro9, localInteger, localInteger, localByteStringMicro10, localInteger, localByteStringMicro11, localInteger, localInteger, localLong, localByteStringMicro12, localInteger, localInteger, localInteger, localByteStringMicro13, localInteger, localInteger, localInteger, localInteger, localByteStringMicro14, localInteger, localInteger, localInteger, localByteStringMicro15, localByteStringMicro16, localByteStringMicro17, null }, ResvAttr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.hummer.resv.generalflags.ResvAttr
 * JD-Core Version:    0.7.0.1
 */