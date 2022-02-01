package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_feeds$GroupFeedsMessage
  extends MessageMicro<GroupFeedsMessage>
{
  public static final int MSG_TYPE_ACTIVITY = 23;
  public static final int MSG_TYPE_APP_NOTICES = 17;
  public static final int MSG_TYPE_CHATMSG = 9;
  public static final int MSG_TYPE_COMMENT = 1;
  public static final int MSG_TYPE_COURSE = 20;
  public static final int MSG_TYPE_FEEDS = 0;
  public static final int MSG_TYPE_GAMES = 21;
  public static final int MSG_TYPE_GROUP_ALBUM = 18;
  public static final int MSG_TYPE_MEMO = 5;
  public static final int MSG_TYPE_MSGPIC = 11;
  public static final int MSG_TYPE_MSGVIDEO = 10;
  public static final int MSG_TYPE_NEW_GUIDELINES = 19;
  public static final int MSG_TYPE_NEW_MEMO = 13;
  public static final int MSG_TYPE_NEW_OBJ_STREAM = 22;
  public static final int MSG_TYPE_PIC_VIEW = 15;
  public static final int MSG_TYPE_SHARE = 4;
  public static final int MSG_TYPE_VOTE = 12;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_album_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_app_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_app_open_param = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_batch_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comment_author_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_extra_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_feeds_author_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_feeds_type = PBField.initEnum(0);
  public final PBFixed32Field fixed32_win_height = PBField.initFixed32(0);
  public final PBFixed32Field fixed32_win_width = PBField.initFixed32(0);
  public final PBInt32Field int32_app_id = PBField.initInt32(0);
  public final PBInt32Field int32_photo_num = PBField.initInt32(0);
  public final PBInt32Field int32_vote_status = PBField.initInt32(0);
  public group_feeds.GroupFeedsMessage.MemoCtrlInfo memo_ctrl_info = new group_feeds.GroupFeedsMessage.MemoCtrlInfo();
  public group_feeds.GroupFeedsMessage.ThemeBrief msg_theme_brief = new group_feeds.GroupFeedsMessage.ThemeBrief();
  public group_feeds.GroupFeedsMessage.Vote msg_vote_content = new group_feeds.GroupFeedsMessage.Vote();
  public final PBUInt32Field opt_uint32_ctl_flag = PBField.initUInt32(0);
  public final PBRepeatField<Long> rpt_concern_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<group_feeds.GroupFeedsMessage.MessageContent> rpt_feeds_content = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.MessageContent.class);
  public final PBRepeatField<Integer> rpt_my_vote_option_id_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBRepeatField<Long> rpt_notify_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<group_feeds.GroupFeedsMessage.VoteRecord> rpt_vote_record = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.VoteRecord.class);
  public final PBRepeatMessageField<group_feeds.GroupFeedsMessage.VoteStatistic> rpt_vote_statistic = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.VoteStatistic.class);
  public final PBUInt32Field uint32_NC_feeds_terinal_ctrl = PBField.initUInt32(0);
  public final PBUInt32Field uint32_edu_organization_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
  public final PBRepeatField<Integer> uint32_reported_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 45, 53, 58, 66, 82, 98, 104, 114, 122, 128, 154, 162, 168, 178, 184, 192, 202, 210, 216, 226, 232, 242, 248, 256, 400, 410, 416, 426 }, new String[] { "enum_feeds_type", "rpt_feeds_content", "fixed32_win_width", "fixed32_win_height", "bytes_feeds_author_nickname", "bytes_comment_author_nickname", "bytes_group_nickname", "msg_vote_content", "rpt_my_vote_option_id_list", "rpt_vote_statistic", "rpt_vote_record", "int32_vote_status", "bytes_group_name", "bytes_app_name", "rpt_notify_uin_list", "bytes_app_open_param", "int32_app_id", "uint32_reported_id", "bytes_album_name", "bytes_batch_id", "int32_photo_num", "bytes_msg_resid", "uint32_edu_organization_id", "msg_theme_brief", "uint32_NC_feeds_terinal_ctrl", "rpt_concern_uin", "opt_uint32_ctl_flag", "bytes_extra_data", "uint32_expire_time", "memo_ctrl_info" }, new Object[] { localInteger, null, localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, localInteger, null, null, localInteger, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), localByteStringMicro6, localInteger, localInteger, localByteStringMicro7, localByteStringMicro8, localInteger, localByteStringMicro9, localInteger, null, localInteger, Long.valueOf(0L), localInteger, localByteStringMicro10, localInteger, null }, GroupFeedsMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupFeedsMessage
 * JD-Core Version:    0.7.0.1
 */