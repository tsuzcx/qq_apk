package com.tencent.trpcprotocol.tianxuan.birthday.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class feeds$Show
  extends MessageMicro<Show>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "title", "bg_img", "head_img", "shuoshuo_img", "bday_icon_img", "more_deco_url" }, new Object[] { "", "", "", "", "", "" }, Show.class);
  public final PBStringField bday_icon_img = PBField.initString("");
  public final PBStringField bg_img = PBField.initString("");
  public final PBStringField head_img = PBField.initString("");
  public final PBStringField more_deco_url = PBField.initString("");
  public final PBStringField shuoshuo_img = PBField.initString("");
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.tianxuan.birthday.feed.feeds.Show
 * JD-Core Version:    0.7.0.1
 */