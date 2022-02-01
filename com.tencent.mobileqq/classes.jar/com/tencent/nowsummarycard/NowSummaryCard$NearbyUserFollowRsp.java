package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowSummaryCard$NearbyUserFollowRsp
  extends MessageMicro<NearbyUserFollowRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
  public final PBUInt32Field status = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "ret_code", "err_msg", "status" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, NearbyUserFollowRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowRsp
 * JD-Core Version:    0.7.0.1
 */