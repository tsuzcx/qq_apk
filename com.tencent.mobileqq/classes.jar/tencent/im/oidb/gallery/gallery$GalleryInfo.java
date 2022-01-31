package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.gallery.dislike.dislikeInfo.DisLikeInfo;

public final class gallery$GalleryInfo
  extends MessageMicro<GalleryInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_is_show_damping = PBField.initBool(false);
  public final PBBoolField bool_show_web_conf = PBField.initBool(false);
  public final PBBytesField bytes_ad_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comments_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_common_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_debug = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_from_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gallery_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pos_ad_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_publisher_head_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_publisher_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_publisher_openid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_report_exdata = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_row_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_source_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subject = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_summary_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public gallery.TComicInfo comic_info = new gallery.TComicInfo();
  public final PBUInt64Field feeds_id = PBField.initUInt64(0L);
  public final PBDoubleField final_score = PBField.initDouble(0.0D);
  public final PBUInt32Field first_pic_height = PBField.initUInt32(0);
  public final PBUInt32Field first_pic_width = PBField.initUInt32(0);
  public final PBInt32Field int32_bid = PBField.initInt32(0);
  public final PBInt32Field int32_info_type = PBField.initInt32(0);
  public final PBInt32Field int32_pic_desc = PBField.initInt32(0);
  public final PBInt32Field int32_reason = PBField.initInt32(0);
  public final PBStringField kuaibao_jump_app_url = PBField.initString("");
  public final PBStringField kuaibao_jump_url = PBField.initString("");
  public gallery.PictureInfo msg_big_summary_pic = new gallery.PictureInfo();
  public gallery.ClassInfo msg_class_info = new gallery.ClassInfo();
  public gallery.PictureInfo msg_sig_summary_pic = new gallery.PictureInfo();
  public final PBRepeatMessageField<gallery.PictureInfo> msg_three_summary_pic = PBField.initRepeatMessage(gallery.PictureInfo.class);
  public final PBDoubleField quality_mean_score = PBField.initDouble(0.0D);
  public final PBDoubleField read_end_rate = PBField.initDouble(0.0D);
  public final PBDoubleField read_to_next_rate = PBField.initDouble(0.0D);
  public final PBDoubleField read_wilson_score = PBField.initDouble(0.0D);
  public final PBDoubleField recall_score = PBField.initDouble(0.0D);
  public final PBRepeatMessageField<dislikeInfo.DisLikeInfo> rpt_dislike_list = PBField.initRepeatMessage(dislikeInfo.DisLikeInfo.class);
  public final PBRepeatMessageField<gallery.ExtTag> rpt_ext_tag = PBField.initRepeatMessage(gallery.ExtTag.class);
  public final PBRepeatMessageField<gallery.PictureInfo> rpt_msg_pic_info = PBField.initRepeatMessage(gallery.PictureInfo.class);
  public final PBRepeatMessageField<gallery.PictureInfo> rpt_msg_summary_pic = PBField.initRepeatMessage(gallery.PictureInfo.class);
  public final PBRepeatMessageField<gallery.TagInfo> rpt_msg_tag_info = PBField.initRepeatMessage(gallery.TagInfo.class);
  public final PBStringField seq_id = PBField.initString("");
  public gallery.SocialInfo social_info = new gallery.SocialInfo();
  public final PBStringField str_icon_url = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBStringField str_web_conf_id = PBField.initString("");
  public final PBStringField str_web_url = PBField.initString("");
  public final PBUInt32Field uint32_end_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_account_derelict = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_attention_puin = PBField.initUInt32(0);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_display_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_pic_count = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_publisher_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_source = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_source_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sub_source = PBField.initUInt64(0L);
  
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50, 58, 66, 72, 80, 88, 96, 106, 114, 120, 128, 136, 144, 154, 162, 170, 242, 250, 258, 266, 274, 394, 402, 410, 416, 426, 434, 482, 488, 496, 504, 512, 522, 530, 538, 544, 554, 560, 570, 578, 584, 594, 602, 610, 618, 626, 8002, 8009, 8017, 8026, 8033, 8041, 8049, 8057, 8064, 8072, 16010 }, new String[] { "bytes_row_key", "uint64_article_id", "bytes_publisher_openid", "uint64_publisher_uin", "bytes_publisher_name", "bytes_subject", "bytes_summary_pic_url", "rpt_msg_summary_pic", "uint64_source", "uint64_sub_source", "uint64_create_time", "uint64_pic_count", "rpt_msg_pic_info", "bytes_report_exdata", "uint64_display_type", "uint64_source_article_id", "int32_pic_desc", "int32_bid", "bytes_pid", "bytes_from_url", "rpt_ext_tag", "msg_class_info", "rpt_msg_tag_info", "msg_big_summary_pic", "msg_sig_summary_pic", "msg_three_summary_pic", "bytes_source_url", "bytes_gallery_url", "bytes_comments_url", "int32_reason", "bytes_reason", "rpt_dislike_list", "bytes_cookies", "uint32_end_flag", "uint32_is_account_derelict", "uint32_is_attention_puin", "bool_show_web_conf", "str_web_url", "str_icon_url", "str_name", "bool_is_show_damping", "str_web_conf_id", "int32_info_type", "kuaibao_jump_url", "kuaibao_jump_app_url", "feeds_id", "comic_info", "bytes_publisher_head_url", "bytes_common_desc", "bytes_pos_ad_info", "bytes_ad_cookie", "bytes_debug", "recall_score", "final_score", "seq_id", "read_to_next_rate", "read_end_rate", "read_wilson_score", "quality_mean_score", "first_pic_width", "first_pic_height", "social_info" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, localByteStringMicro6, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, null, null, null, null, null, null, localByteStringMicro9, localByteStringMicro10, localByteStringMicro11, Integer.valueOf(0), localByteStringMicro12, null, localByteStringMicro13, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), "", "", "", Boolean.valueOf(false), "", Integer.valueOf(0), "", "", Long.valueOf(0L), null, localByteStringMicro14, localByteStringMicro15, localByteStringMicro16, localByteStringMicro17, localByteStringMicro18, Double.valueOf(0.0D), Double.valueOf(0.0D), "", Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D), Integer.valueOf(0), Integer.valueOf(0), null }, GalleryInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.gallery.gallery.GalleryInfo
 * JD-Core Version:    0.7.0.1
 */