package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class feeds_info$UGCFeedsInfo
  extends MessageMicro<UGCFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public feeds_info.AccountProfile account_profile = new feeds_info.AccountProfile();
  public final PBBytesField bytes_json_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_json_pic_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rich_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ugc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_ugc_feeds_card_type = PBField.initEnum(0);
  public final PBEnumField enum_ugc_feeds_src = PBField.initEnum(0);
  public feeds_info.BiuMultiLevel msg_at_multi_level = new feeds_info.BiuMultiLevel();
  public final PBRepeatMessageField<feeds_info.UGCPicInfo> msg_ugc_pic_info_list = PBField.initRepeatMessage(feeds_info.UGCPicInfo.class);
  public final PBRepeatMessageField<feeds_info.UGCVideoInfo> msg_ugc_video_info_list = PBField.initRepeatMessage(feeds_info.UGCVideoInfo.class);
  public final PBRepeatMessageField<feeds_info.UGCVoiceInfo> msg_ugc_voice_info_list = PBField.initRepeatMessage(feeds_info.UGCVoiceInfo.class);
  public final PBRepeatMessageField<feeds_info.TagInfo> rpt_msg_tag_info_list = PBField.initRepeatMessage(feeds_info.TagInfo.class);
  public final PBUInt32Field uint32_ugc_feeds_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_cuin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 90, 98, 106, 114, 122, 130, 138, 170, 178, 186, 194, 210 }, new String[] { "enum_ugc_feeds_card_type", "uint64_cuin", "enum_ugc_feeds_src", "uint32_ugc_feeds_type", "msg_ugc_pic_info_list", "msg_ugc_video_info_list", "bytes_ugc_comments", "bytes_json_pic_list", "bytes_json_video_list", "bytes_json_content", "msg_at_multi_level", "rpt_msg_tag_info_list", "bytes_jump_url", "account_profile", "bytes_rich_text", "msg_ugc_voice_info_list" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null, null, localByteStringMicro5, null, localByteStringMicro6, null }, UGCFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.UGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */