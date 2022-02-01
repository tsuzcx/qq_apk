package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowSummaryCard$InterestTagInfo
  extends MessageMicro<InterestTagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field flag = PBField.initUInt32(0);
  public final PBBytesField tag_info = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "flag", "tag_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, InterestTagInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.InterestTagInfo
 * JD-Core Version:    0.7.0.1
 */