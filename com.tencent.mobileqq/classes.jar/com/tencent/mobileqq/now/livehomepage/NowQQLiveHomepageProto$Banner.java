package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class NowQQLiveHomepageProto$Banner
  extends MessageMicro<Banner>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_banner_item" }, new Object[] { null }, Banner.class);
  public final PBRepeatMessageField<NowQQLiveHomepageProto.BannerItem> rpt_banner_item = PBField.initRepeatMessage(NowQQLiveHomepageProto.BannerItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.Banner
 * JD-Core Version:    0.7.0.1
 */