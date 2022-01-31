package tencent.im.oidb.cmd0x64e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x64e$ReportInfo
  extends MessageMicro<ReportInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_is_gallery = PBField.initBool(false);
  public final PBBytesField bytes_a2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_author_reply_to_comment_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_collect_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comment_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_device_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_first_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gallery_report_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gw_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hot_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_inner_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_origin_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recommend_words = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reply_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_search_tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_server_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_skey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_report_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_feeds_type = PBField.initEnum(0);
  public final PBEnumField enum_fit_type = PBField.initEnum(0);
  public final PBEnumField enum_in_onetree_source = PBField.initEnum(0);
  public final PBEnumField enum_in_videochannel_source = PBField.initEnum(0);
  public final PBEnumField enum_jumpway_which = PBField.initEnum(0);
  public final PBEnumField enum_network_type = PBField.initEnum(0);
  public final PBEnumField enum_op_source = PBField.initEnum(0);
  public final PBEnumField enum_operation = PBField.initEnum(1);
  public final PBEnumField enum_user_state_notify = PBField.initEnum(0);
  public oidb_cmd0x64e.SRTClickInfo msg_srt_click_info = new oidb_cmd0x64e.SRTClickInfo();
  public final PBEnumField operator_platform = PBField.initEnum(1);
  public final PBRepeatMessageField<oidb_cmd0x64e.FeedsReportData> rpt_feeds_report_data_list = PBField.initRepeatMessage(oidb_cmd0x64e.FeedsReportData.class);
  public final PBUInt32Field uint32_a2_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_algorithm_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_article_length = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_current_video_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_folder_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_no_difference_jump = PBField.initUInt32(0);
  public final PBUInt32Field uint32_onetree_video_from_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_play_time_length = PBField.initUInt32(0);
  public final PBUInt32Field uint32_read_article_length = PBField.initUInt32(0);
  public final PBUInt32Field uint32_read_time_length = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_duration = PBField.initUInt32(0);
  public final PBUInt64Field uint64_author_reply_to_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_cuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_reply_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_shared_user_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_source_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_subscribe_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  public final PBBoolField whether_click_in = PBField.initBool(false);
  
  static
  {
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
    ByteStringMicro localByteStringMicro18 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro19 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro20 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 48, 56, 64, 74, 80, 88, 98, 104, 112, 122, 130, 138, 146, 152, 162, 170, 178, 184, 192, 202, 210, 218, 224, 232, 240, 248, 258, 264, 272, 280, 288, 296, 304, 312, 320, 328, 336, 344, 352, 362, 400, 410, 480, 488, 498, 506, 514, 522, 528, 536, 546, 554, 560, 570 }, new String[] { "uint64_uin", "uint32_source", "uint64_source_article_id", "uint32_channel_id", "uint32_algorithm_id", "enum_operation", "uint32_read_time_length", "bytes_collect_url", "enum_op_source", "uint32_strategy_id", "bytes_inner_id", "uint32_play_time_length", "uint64_subscribe_id", "bytes_server_context", "bytes_search_tag_name", "bytes_comment_content", "bytes_comment_id", "uint64_reply_uin", "bytes_reply_id", "bytes_skey", "bytes_a2", "uint32_a2_appid", "uint64_shared_user_id", "bytes_device_id", "rpt_feeds_report_data_list", "bytes_recommend_words", "uint32_folder_status", "uint64_cuin", "uint64_topic_id", "uint64_author_reply_to_uin", "bytes_author_reply_to_comment_content", "uint32_video_duration", "enum_jumpway_which", "enum_network_type", "enum_in_onetree_source", "whether_click_in", "uint32_current_video_time", "operator_platform", "enum_in_videochannel_source", "enum_user_state_notify", "enum_fit_type", "uint64_feeds_id", "enum_feeds_type", "bytes_origin_comment_id", "bool_is_gallery", "bytes_gallery_report_info", "uint32_article_length", "uint32_read_article_length", "bytes_version", "bytes_vid", "bytes_hot_word", "bytes_gw_common_data", "uint32_onetree_video_from_type", "uint32_column_id", "bytes_video_report_info", "msg_srt_click_info", "uint32_no_difference_jump", "bytes_first_rowkey" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L), localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro10, null, localByteStringMicro11, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro12, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro13, Boolean.valueOf(false), localByteStringMicro14, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro15, localByteStringMicro16, localByteStringMicro17, localByteStringMicro18, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro19, null, Integer.valueOf(0), localByteStringMicro20 }, ReportInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.ReportInfo
 * JD-Core Version:    0.7.0.1
 */