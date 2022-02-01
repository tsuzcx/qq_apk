package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class NowQQLiveHomepageProto$BannerItem
  extends MessageMicro<BannerItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "string_image_desc", "string_image_title", "string_image_url", "string_jump_url" }, new Object[] { "", "", "", "" }, BannerItem.class);
  public final PBStringField string_image_desc = PBField.initString("");
  public final PBStringField string_image_title = PBField.initString("");
  public final PBStringField string_image_url = PBField.initString("");
  public final PBStringField string_jump_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.BannerItem
 * JD-Core Version:    0.7.0.1
 */