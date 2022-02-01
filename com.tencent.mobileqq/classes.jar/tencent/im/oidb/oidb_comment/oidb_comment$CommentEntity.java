package tencent.im.oidb.oidb_comment;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_comment$CommentEntity
  extends MessageMicro<CommentEntity>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFloatField abuse_score = PBField.initFloat(0.0F);
  public final PBStringField app_id = PBField.initString("");
  public final PBUInt32Field author_like = PBField.initUInt32(0);
  public final PBUInt64Field author_puin = PBField.initUInt64(0L);
  public final PBEnumField author_top_status = PBField.initEnum(2);
  public final PBUInt32Field awesome = PBField.initUInt32(0);
  public final PBInt32Field ban_hot_flag = PBField.initInt32(0);
  public final PBBytesField business_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField comment_content = PBField.initString("");
  public final PBStringField comment_id = PBField.initString("");
  public final PBInt64Field comment_score = PBField.initInt64(0L);
  public final PBInt32Field comment_source = PBField.initInt32(0);
  public final PBInt32Field comment_status = PBField.initInt32(0);
  public final PBUInt32Field comment_type = PBField.initUInt32(0);
  public final PBStringField content_center_rowkey = PBField.initString("");
  public final PBInt32Field create_source = PBField.initInt32(0);
  public final PBInt64Field create_time = PBField.initInt64(0L);
  public final PBInt32Field dislike_num = PBField.initInt32(0);
  public final PBUInt32Field family_id = PBField.initUInt32(0);
  public final PBUInt64Field feeds_id = PBField.initUInt64(0L);
  public final PBStringField first_comment_id = PBField.initString("");
  public final PBBytesField gif_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field is_anonymous = PBField.initInt32(0);
  public final PBUInt32Field is_author_delete = PBField.initUInt32(0);
  public final PBUInt32Field is_author_reply = PBField.initUInt32(0);
  public final PBBoolField is_dislike = PBField.initBool(false);
  public final PBBoolField is_like = PBField.initBool(false);
  public final PBUInt32Field is_multi_media = PBField.initUInt32(0);
  public final PBInt32Field is_selection = PBField.initInt32(0);
  public final PBInt32Field is_sofa = PBField.initInt32(0);
  public final PBInt32Field is_unsorting = PBField.initInt32(0);
  public final PBInt32Field like_num = PBField.initInt32(0);
  public final PBRepeatMessageField<oidb_comment.LinkData> link_data = PBField.initRepeatMessage(oidb_comment.LinkData.class);
  public oidb_comment.MediaData media_data = new oidb_comment.MediaData();
  public final PBStringField model_detail = PBField.initString("");
  public final PBStringField original_unique_key = PBField.initString("");
  public final PBStringField replied_comment_id = PBField.initString("");
  public final PBUInt64Field replied_puin = PBField.initUInt64(0L);
  public final PBUInt32Field replied_user_create_src = PBField.initUInt32(0);
  public final PBStringField rowkey = PBField.initString("");
  public final PBRepeatMessageField<oidb_comment.RptData> rpt_data = PBField.initRepeatMessage(oidb_comment.RptData.class);
  public final PBRepeatMessageField<oidb_comment.MediaData> rpt_media_data_list = PBField.initRepeatMessage(oidb_comment.MediaData.class);
  public final PBFloatField spam_score = PBField.initFloat(0.0F);
  public final PBStringField unique_id = PBField.initString("");
  public final PBInt64Field update_time = PBField.initInt64(0L);
  public oidb_comment.UserInfo user_info = new oidb_comment.UserInfo();
  public oidb_comment.VerifyInfo verify_info = new oidb_comment.VerifyInfo();
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 64, 72, 80, 88, 98, 104, 112, 120, 130, 136, 170, 178, 184, 192, 200, 250, 256, 266, 328, 413, 421, 488, 498, 506, 514, 520, 528, 536, 544, 552, 562, 570, 578, 584, 594, 602, 610, 616, 624, 802 }, new String[] { "comment_id", "comment_type", "author_puin", "create_time", "update_time", "comment_content", "comment_status", "like_num", "is_anonymous", "is_selection", "is_unsorting", "gif_info", "is_sofa", "dislike_num", "comment_source", "business_info", "create_source", "unique_id", "rowkey", "ban_hot_flag", "is_like", "is_dislike", "first_comment_id", "replied_puin", "replied_comment_id", "comment_score", "spam_score", "abuse_score", "is_multi_media", "media_data", "user_info", "rpt_media_data_list", "is_author_reply", "awesome", "family_id", "author_like", "author_top_status", "rpt_data", "original_unique_key", "link_data", "is_author_delete", "content_center_rowkey", "verify_info", "model_detail", "feeds_id", "replied_user_create_src", "app_id" }, new Object[] { "", localInteger, localLong, localLong, localLong, "", localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro1, localInteger, localInteger, localInteger, localByteStringMicro2, localInteger, "", "", localInteger, localBoolean, localBoolean, "", localLong, "", localLong, Float.valueOf(0.0F), Float.valueOf(0.0F), localInteger, null, null, null, localInteger, localInteger, localInteger, localInteger, Integer.valueOf(2), null, "", null, localInteger, "", null, "", localLong, localInteger, "" }, CommentEntity.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_comment.oidb_comment.CommentEntity
 * JD-Core Version:    0.7.0.1
 */