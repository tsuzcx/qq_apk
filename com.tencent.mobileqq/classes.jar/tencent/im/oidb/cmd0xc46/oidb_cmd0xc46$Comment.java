package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc46$Comment
  extends MessageMicro<Comment>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_cmd0xc46.AccountLevelInfo account_level_info = new oidb_cmd0xc46.AccountLevelInfo();
  public oidb_cmd0xc46.Activity activity = new oidb_cmd0xc46.Activity();
  public oidb_cmd0xc46.ActivityLevel activity_level = new oidb_cmd0xc46.ActivityLevel();
  public oidb_cmd0xc46.AdRspInfo ad_rsp_info = new oidb_cmd0xc46.AdRspInfo();
  public final PBInt32Field anonymous = PBField.initInt32(0);
  public final PBStringField author_comment = PBField.initString("");
  public final PBStringField author_id = PBField.initString("");
  public final PBUInt32Field author_like = PBField.initUInt32(0);
  public final PBInt32Field author_selection = PBField.initInt32(0);
  public final PBStringField avatar = PBField.initString("");
  public final PBStringField avatar_pendant = PBField.initString("");
  public final PBUInt32Field awesome = PBField.initUInt32(0);
  public final PBUInt32Field comment_app = PBField.initUInt32(0);
  public final PBUInt32Field comment_author = PBField.initUInt32(0);
  public final PBUInt32Field comment_author_like = PBField.initUInt32(0);
  public final PBUInt32Field comment_author_top = PBField.initUInt32(0);
  public final PBStringField comment_id = PBField.initString("");
  public final PBStringField content = PBField.initString("");
  public final PBInt32Field content_source = PBField.initInt32(0);
  public final PBInt32Field create_source = PBField.initInt32(0);
  public final PBInt64Field create_time = PBField.initInt64(0L);
  public final PBInt32Field dislike = PBField.initInt32(0);
  public final PBUInt32Field family_id = PBField.initUInt32(0);
  public final PBStringField first_comment_id = PBField.initString("");
  public final PBUInt32Field follow_status = PBField.initUInt32(0);
  public final PBUInt32Field has_target = PBField.initUInt32(0);
  public final PBStringField homepage = PBField.initString("");
  public final PBUInt32Field is_activity = PBField.initUInt32(0);
  public final PBUInt32Field is_ad = PBField.initUInt32(0);
  public final PBUInt32Field is_anchor = PBField.initUInt32(0);
  public final PBUInt32Field is_approved = PBField.initUInt32(0);
  public final PBUInt32Field is_author_reply = PBField.initUInt32(0);
  public final PBUInt32Field is_delete = PBField.initUInt32(0);
  public final PBUInt32Field is_multi_media = PBField.initUInt32(0);
  public final PBUInt32Field is_star = PBField.initUInt32(0);
  public final PBUInt32Field is_star_comment = PBField.initUInt32(0);
  public final PBStringField jump_schema = PBField.initString("");
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField ks_homepage = PBField.initString("");
  public final PBUInt32Field level = PBField.initUInt32(0);
  public final PBInt32Field like = PBField.initInt32(0);
  public final PBInt32Field like_num = PBField.initInt32(0);
  public final PBRepeatMessageField<oidb_cmd0xc46.LinkData> link_data = PBField.initRepeatMessage(oidb_cmd0xc46.LinkData.class);
  public oidb_cmd0xc46.MediaData media_data = new oidb_cmd0xc46.MediaData();
  public final PBInt32Field myself = PBField.initInt32(0);
  public final PBStringField nick_name = PBField.initString("");
  public final PBBytesField passthrough = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField pic_url = PBField.initString("");
  public final PBInt32Field rank = PBField.initInt32(0);
  public oidb_cmd0xc46.RepliedCommentInfo replied_comment = new oidb_cmd0xc46.RepliedCommentInfo();
  public final PBStringField replied_user_homepage = PBField.initString("");
  public final PBStringField replied_user_id = PBField.initString("");
  public final PBStringField replied_user_nick_name = PBField.initString("");
  public final PBStringField rowkey = PBField.initString("");
  public final PBRepeatMessageField<oidb_cmd0xc46.RptData> rpt_data = PBField.initRepeatMessage(oidb_cmd0xc46.RptData.class);
  public final PBRepeatMessageField<oidb_cmd0xc46.MedalInfo> rpt_medal_info_list = PBField.initRepeatMessage(oidb_cmd0xc46.MedalInfo.class);
  public final PBRepeatMessageField<oidb_cmd0xc46.MediaData> rpt_media_data_list = PBField.initRepeatMessage(oidb_cmd0xc46.MediaData.class);
  public final PBInt64Field score = PBField.initInt64(0L);
  public final PBStringField share_url = PBField.initString("");
  public final PBStringField style_data = PBField.initString("");
  public final PBRepeatMessageField<Comment> sub_comments = PBField.initRepeatMessage(Comment.class);
  public final PBUInt32Field sub_comments_total = PBField.initUInt32(0);
  public oidb_cmd0xc46.UserIdentityIcon user_identity_icon = new oidb_cmd0xc46.UserIdentityIcon();
  public final PBStringField user_title = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56, 64, 72, 80, 88, 98, 106, 114, 120, 130, 136, 146, 152, 160, 170, 242, 250, 258, 266, 272, 320, 330, 336, 344, 354, 362, 368, 378, 386, 392, 402, 408, 416, 424, 432, 442, 450, 456, 466, 474, 482, 488, 496, 506, 512, 520, 528, 536, 544, 554, 562, 570, 594, 602, 618, 624, 642, 650 }, new String[] { "comment_id", "author_id", "create_time", "content", "like", "dislike", "like_num", "anonymous", "author_selection", "rank", "level", "author_comment", "nick_name", "avatar", "myself", "homepage", "awesome", "rowkey", "content_source", "sub_comments_total", "sub_comments", "first_comment_id", "replied_user_id", "replied_user_nick_name", "replied_user_homepage", "has_target", "score", "passthrough", "is_delete", "is_anchor", "pic_url", "jump_url", "is_activity", "rpt_medal_info_list", "activity", "is_multi_media", "media_data", "is_star_comment", "create_source", "is_star", "is_approved", "jump_schema", "rpt_media_data_list", "is_author_reply", "user_title", "ks_homepage", "style_data", "family_id", "is_ad", "ad_rsp_info", "author_like", "follow_status", "comment_author_like", "comment_author", "comment_author_top", "avatar_pendant", "rpt_data", "account_level_info", "link_data", "activity_level", "share_url", "comment_app", "replied_comment", "user_identity_icon" }, new Object[] { "", "", Long.valueOf(0L), "", localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, "", "", "", localInteger, "", localInteger, "", localInteger, localInteger, null, "", "", "", "", localInteger, Long.valueOf(0L), localByteStringMicro, localInteger, localInteger, "", "", localInteger, null, null, localInteger, null, localInteger, localInteger, localInteger, localInteger, "", null, localInteger, "", "", "", localInteger, localInteger, null, localInteger, localInteger, localInteger, localInteger, localInteger, "", null, null, null, null, "", localInteger, null, null }, Comment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Comment
 * JD-Core Version:    0.7.0.1
 */