package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6cf$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_end_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_entrance_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_inner_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_req_context_pb = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_req_range_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_req_recommend_json = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_req_ug_interface_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_req_web = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_article_source = PBField.initEnum(0);
  public final PBEnumField enum_req_video_show_mode = PBField.initEnum(0);
  public oidb_0x6cf.ReqAdvertisePara req_advertise_para = new oidb_0x6cf.ReqAdvertisePara();
  public final PBRepeatField<ByteStringMicro> rpt_bytes_redo_inner_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField<oidb_0x6cf.InnerMsg> rpt_inner_msg_list = PBField.initRepeatMessage(oidb_0x6cf.InnerMsg.class);
  public final PBRepeatMessageField<oidb_0x6cf.PkgInstallInfo> rpt_pkg_install_info = PBField.initRepeatMessage(oidb_0x6cf.PkgInstallInfo.class);
  public final PBRepeatField<Long> rpt_uint64_redo_article_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public oidb_0x6cf.FeedsIdInfo ugc_feeds_info = new oidb_0x6cf.FeedsIdInfo();
  public final PBUInt32Field uint32_entrance_one_day_display_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_has_cache_pre_video = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_ugc = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_column_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_dislike_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_network = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_os = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_recommend_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_sim_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_sub_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_topic_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vertical_video = PBField.initUInt32(0);
  public final PBUInt32Field uint32_want_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_want_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_youngster_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_end_recommend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  public oidb_0x6cf.UserExposeArticle user_expose_article = new oidb_0x6cf.UserExposeArticle();
  
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 58, 64, 74, 80, 112, 120, 128, 138, 144, 154, 162, 170, 176, 184, 192, 202, 208, 216, 224, 234, 242, 248, 256, 264, 272, 282, 306, 322, 328, 336, 346, 354 }, new String[] { "uint64_uin", "uint64_article_id", "bytes_inner_id", "enum_article_source", "uint32_want_count", "uint32_want_type", "req_advertise_para", "rpt_uint64_redo_article_id", "rpt_bytes_redo_inner_id", "uint32_req_source", "uint32_req_dislike_type", "uint32_req_topic_id", "uint32_req_vertical_video", "ugc_feeds_info", "uint32_is_ugc", "bytes_req_web", "bytes_cookie", "rpt_inner_msg_list", "uint32_req_network", "uint32_req_os", "uint32_req_times", "bytes_req_range_cookie", "uint32_req_sub_source", "uint32_req_sim_type", "uint64_end_recommend_seq", "bytes_end_rowkey", "bytes_req_context_pb", "uint32_has_cache_pre_video", "uint32_entrance_one_day_display_count", "uint32_req_column_id", "enum_req_video_show_mode", "rpt_pkg_install_info", "user_expose_article", "bytes_req_ug_interface_data", "uint32_youngster_status", "uint32_req_recommend_flag", "bytes_entrance_cookie", "bytes_req_recommend_json" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, localByteStringMicro8, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro9, localByteStringMicro10 }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody
 * JD-Core Version:    0.7.0.1
 */