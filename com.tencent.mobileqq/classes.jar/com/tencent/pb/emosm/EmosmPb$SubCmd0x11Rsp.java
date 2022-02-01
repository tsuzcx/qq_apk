package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class EmosmPb$SubCmd0x11Rsp
  extends MessageMicro<SubCmd0x11Rsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "itemlist" }, new Object[] { null }, SubCmd0x11Rsp.class);
  public final PBRepeatMessageField<EmosmPb.SmallYellowItem> itemlist = PBField.initRepeatMessage(EmosmPb.SmallYellowItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x11Rsp
 * JD-Core Version:    0.7.0.1
 */