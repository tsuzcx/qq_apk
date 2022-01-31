package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedsProtocol$FollowFeedRsp
  extends MessageMicro<FollowFeedRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field end_flag = PBField.initUInt32(0);
  public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<FeedsProtocol.FeedsInfo> msg_feeds = PBField.initRepeatMessage(FeedsProtocol.FeedsInfo.class);
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBUInt32Field total = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "result", "errmsg", "total", "end_flag", "msg_feeds" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, FollowFeedRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.FollowFeedRsp
 * JD-Core Version:    0.7.0.1
 */