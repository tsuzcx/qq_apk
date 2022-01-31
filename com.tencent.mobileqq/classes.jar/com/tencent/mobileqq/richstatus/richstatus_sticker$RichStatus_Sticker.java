package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class richstatus_sticker$RichStatus_Sticker
  extends MessageMicro<RichStatus_Sticker>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "sticker_info" }, new Object[] { null }, RichStatus_Sticker.class);
  public final PBRepeatMessageField<richstatus_sticker.StickerInfo> sticker_info = PBField.initRepeatMessage(richstatus_sticker.StickerInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.richstatus_sticker.RichStatus_Sticker
 * JD-Core Version:    0.7.0.1
 */