package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class NowQQLiveHomepageProto$LiveAnchorList
  extends MessageMicro<LiveAnchorList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_live_anchor" }, new Object[] { null }, LiveAnchorList.class);
  public final PBRepeatMessageField<NowQQLiveHomepageProto.LiveAnchorItem> rpt_live_anchor = PBField.initRepeatMessage(NowQQLiveHomepageProto.LiveAnchorItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.LiveAnchorList
 * JD-Core Version:    0.7.0.1
 */