package com.tencent.mobileqq.vas.adv.common.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class adv_report$RewardReportInfo
  extends MessageMicro<RewardReportInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field nonce = PBField.initInt32(0);
  public final PBBytesField reward_item = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field reward_type = PBField.initInt32(0);
  public final PBStringField signature = PBField.initString("");
  public final PBUInt64Field time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "reward_type", "reward_item", "time", "nonce", "signature" }, new Object[] { localInteger, localByteStringMicro, Long.valueOf(0L), localInteger, "" }, RewardReportInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.common.pb.adv_report.RewardReportInfo
 * JD-Core Version:    0.7.0.1
 */