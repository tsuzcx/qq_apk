package com.tencent.trpcprotocol.tianxuan.birthday.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class feeds$DressRequest
  extends MessageMicro<DressRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "act_id", "rule_id", "qzone_share" }, new Object[] { "", "", Boolean.valueOf(false) }, DressRequest.class);
  public final PBStringField act_id = PBField.initString("");
  public final PBBoolField qzone_share = PBField.initBool(false);
  public final PBStringField rule_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.tianxuan.birthday.feed.feeds.DressRequest
 * JD-Core Version:    0.7.0.1
 */