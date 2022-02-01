package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedsProtocol$TextFeed
  extends MessageMicro<TextFeed>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 56, 64, 72, 80, 90, 98, 106, 114, 120, 130 }, new String[] { "user_info", "create_time", "feed_type", "feed_source", "feeds_id", "rpt_msg_rich_title", "is_listen", "view_times", "is_like", "like_num", "share_url", "lbs_info", "share_main_title", "share_subheading", "comment_num", "text" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null, "", "", Integer.valueOf(0), "" }, TextFeed.class);
  public final PBUInt32Field comment_num = PBField.initUInt32(0);
  public final PBUInt32Field create_time = PBField.initUInt32(0);
  public final PBUInt32Field feed_source = PBField.initUInt32(0);
  public final PBUInt32Field feed_type = PBField.initUInt32(0);
  public final PBStringField feeds_id = PBField.initString("");
  public final PBUInt32Field is_like = PBField.initUInt32(0);
  public final PBUInt32Field is_listen = PBField.initUInt32(0);
  public FeedsProtocol.LbsInfo lbs_info = new FeedsProtocol.LbsInfo();
  public final PBUInt32Field like_num = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedsProtocol.RichTitleElement> rpt_msg_rich_title = PBField.initRepeatMessage(FeedsProtocol.RichTitleElement.class);
  public final PBStringField share_main_title = PBField.initString("");
  public final PBStringField share_subheading = PBField.initString("");
  public final PBStringField share_url = PBField.initString("");
  public final PBStringField text = PBField.initString("");
  public FeedsProtocol.UserInfo user_info = new FeedsProtocol.UserInfo();
  public final PBUInt32Field view_times = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.TextFeed
 * JD-Core Version:    0.7.0.1
 */