package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class NowQQLiveHomepageProto$RcmdFollowItem
  extends MessageMicro<RcmdFollowItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "string_name", "string_id", "string_head_img_url", "string_description" }, new Object[] { "", "", "", "" }, RcmdFollowItem.class);
  public final PBStringField string_description = PBField.initString("");
  public final PBStringField string_head_img_url = PBField.initString("");
  public final PBStringField string_id = PBField.initString("");
  public final PBStringField string_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RcmdFollowItem
 * JD-Core Version:    0.7.0.1
 */