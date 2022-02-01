package com.tencent.pb.vas.uni_gray_tip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UniGrayTip$FromChannel
  extends MessageMicro<FromChannel>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "channel", "fromUin" }, new Object[] { Integer.valueOf(0), "" }, FromChannel.class);
  public final PBUInt32Field channel = PBField.initUInt32(0);
  public final PBStringField fromUin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.vas.uni_gray_tip.UniGrayTip.FromChannel
 * JD-Core Version:    0.7.0.1
 */