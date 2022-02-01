package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowSummaryCard$GiftInfo
  extends MessageMicro<GiftInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField gift_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field open_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "open_flag", "gift_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GiftInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.GiftInfo
 * JD-Core Version:    0.7.0.1
 */