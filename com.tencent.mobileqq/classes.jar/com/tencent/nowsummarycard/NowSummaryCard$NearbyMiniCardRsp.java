package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowSummaryCard$NearbyMiniCardRsp
  extends MessageMicro<NearbyMiniCardRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<NowSummaryCard.MiniCard> mini_card = PBField.initRepeatMessage(NowSummaryCard.MiniCard.class);
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret_code", "err_msg", "mini_card" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, NearbyMiniCardRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.NearbyMiniCardRsp
 * JD-Core Version:    0.7.0.1
 */