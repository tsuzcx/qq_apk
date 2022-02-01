package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowNearbyVideoCommentProto$GetStickReq
  extends MessageMicro<GetStickReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field feed_type = PBField.initUInt64(0L);
  public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "feeds_id", "feed_type" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, GetStickReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.now.NowNearbyVideoCommentProto.GetStickReq
 * JD-Core Version:    0.7.0.1
 */