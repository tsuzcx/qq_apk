package com.tencent.trpcprotocol.tianxuan.birthday.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class feeds$GetReply
  extends MessageMicro<GetReply>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "show", "act_id", "rule_id" }, new Object[] { null, "", "" }, GetReply.class);
  public final PBStringField act_id = PBField.initString("");
  public final PBStringField rule_id = PBField.initString("");
  public feeds.Show show = new feeds.Show();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.tianxuan.birthday.feed.feeds.GetReply
 * JD-Core Version:    0.7.0.1
 */