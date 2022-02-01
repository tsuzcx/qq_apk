package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$UGCFeedsInfo
  extends MessageMicro<UGCFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public feeds_info.AccountProfile account_profile = new feeds_info.AccountProfile();
  public final PBBytesField bytes_json_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_json_pic_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ugc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_ugc_feeds_card_type = PBField.initEnum(0);
  public final PBEnumField enum_ugc_feeds_src = PBField.initEnum(0);
  public articlesummary.BiuMultiLevel msg_at_multi_level = new articlesummary.BiuMultiLevel();
  public final PBRepeatMessageField<articlesummary.UGCPicInfo> msg_ugc_pic_info_list = PBField.initRepeatMessage(articlesummary.UGCPicInfo.class);
  public final PBRepeatMessageField<articlesummary.UGCVideoInfo> msg_ugc_video_info_list = PBField.initRepeatMessage(articlesummary.UGCVideoInfo.class);
  public final PBRepeatMessageField<articlesummary.UGCVoiceInfo> msg_ugc_voice_info_list = PBField.initRepeatMessage(articlesummary.UGCVoiceInfo.class);
  public final PBUInt64Field uint64_cuin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 114, 122, 130, 138, 178, 186, 210 }, new String[] { "enum_ugc_feeds_card_type", "uint64_cuin", "enum_ugc_feeds_src", "msg_ugc_pic_info_list", "msg_ugc_video_info_list", "bytes_ugc_comments", "bytes_json_pic_list", "bytes_json_video_list", "bytes_json_content", "msg_at_multi_level", "bytes_jump_url", "account_profile", "msg_ugc_voice_info_list" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null, localByteStringMicro5, null, null }, UGCFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.UGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */