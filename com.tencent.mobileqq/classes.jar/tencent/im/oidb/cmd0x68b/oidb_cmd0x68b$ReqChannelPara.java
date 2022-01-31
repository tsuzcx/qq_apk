package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$ReqChannelPara
  extends MessageMicro<ReqChannelPara>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_device_brand_and_model = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_device_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_push_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_lbs_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_manufacturer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_set_top_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sso_service_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x68b.ChannelLocationInfo msg_channel_location_info = new oidb_cmd0x68b.ChannelLocationInfo();
  public final PBRepeatField<Long> rpt_curr_article_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<ByteStringMicro> rpt_curr_article_rowkey = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField<oidb_cmd0x68b.DailyArticleInfo> rpt_daily_article_info = PBField.initRepeatMessage(oidb_cmd0x68b.DailyArticleInfo.class);
  public final PBRepeatMessageField<oidb_cmd0x68b.InnerMsg> rpt_inner_msg_list = PBField.initRepeatMessage(oidb_cmd0x68b.InnerMsg.class);
  public final PBRepeatMessageField<oidb_cmd0x68b.PkgInstallInfo> rpt_pkg_install_info = PBField.initRepeatMessage(oidb_cmd0x68b.PkgInstallInfo.class);
  public final PBRepeatMessageField<oidb_cmd0x68b.SubscribeMsg> rpt_subscribe_msg_list = PBField.initRepeatMessage(oidb_cmd0x68b.SubscribeMsg.class);
  public final PBRepeatField<Long> rpt_subscription_article_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_is_support_gallery = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_support_packinfo = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_support_video_with_small_picture = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_support_without_picture = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_force_set_top = PBField.initUInt32(0);
  public final PBUInt32Field uint32_privacy_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_article_list = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_channel_list = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_deleted_article_list = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_is_disp_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_media_specs = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_merged_video = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_neisou_article_list = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_picture_list = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_picture_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_recommend_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_video_list = PBField.initUInt32(0);
  public final PBUInt32Field uint32_residence_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_times_one_day = PBField.initUInt32(0);
  public final PBUInt32Field uint32_youngster_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_begin_recommend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_cur_feeds_refresh_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_end_recommend_seq = PBField.initUInt64(0L);
  public oidb_cmd0x68b.UserExposeArticle user_expose_article = new oidb_cmd0x68b.UserExposeArticle();
  public oidb_cmd0x68b.UserReadArticle user_read_article = new oidb_cmd0x68b.UserReadArticle();
  
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 88, 96, 104, 112, 120, 128, 136, 144, 154, 160, 170, 176, 184, 194, 200, 208, 216, 226, 232, 240, 248, 256, 274, 282, 290, 298, 306, 314, 322, 330, 336, 346, 352, 362, 368, 376, 386, 392 }, new String[] { "uint64_channel_id", "uint32_req_channel_list", "uint64_begin_recommend_seq", "uint64_end_recommend_seq", "uint32_req_article_list", "uint32_req_deleted_article_list", "rpt_curr_article_list", "uint32_req_recommend_flag", "rpt_subscription_article_list", "uint32_req_video_list", "uint32_req_picture_list", "uint32_need_force_set_top", "bytes_set_top_cookie", "uint32_req_neisou_article_list", "bytes_device_id", "uint32_update_times", "uint32_req_merged_video", "rpt_subscribe_msg_list", "uint32_is_support_without_picture", "uint32_req_media_specs", "uint32_is_support_video_with_small_picture", "rpt_inner_msg_list", "uint32_req_is_disp_timestamp", "uint32_is_support_gallery", "uint32_req_picture_number", "uint32_is_support_packinfo", "bytes_lbs_data", "bytes_group_push_context", "rpt_curr_article_rowkey", "bytes_manufacturer", "bytes_device_brand_and_model", "rpt_pkg_install_info", "rpt_daily_article_info", "msg_channel_location_info", "uint32_privacy_status", "user_read_article", "uint64_cur_feeds_refresh_seq", "bytes_sso_service_data", "uint32_update_times_one_day", "uint32_residence_time", "user_expose_article", "uint32_youngster_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, null, null, null, Integer.valueOf(0), null, Long.valueOf(0L), localByteStringMicro8, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, ReqChannelPara.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqChannelPara
 * JD-Core Version:    0.7.0.1
 */