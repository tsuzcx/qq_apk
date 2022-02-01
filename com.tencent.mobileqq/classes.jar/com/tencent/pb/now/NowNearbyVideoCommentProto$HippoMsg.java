package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowNearbyVideoCommentProto$HippoMsg
  extends MessageMicro<HippoMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field action = PBField.initUInt32(0);
  public NowNearbyVideoCommentProto.AddCommentReq comm = new NowNearbyVideoCommentProto.AddCommentReq();
  public final PBUInt64Field comm_id = PBField.initUInt64(0L);
  public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40 }, new String[] { "uid", "comm", "action", "feeds_id", "comm_id" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L) }, HippoMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.now.NowNearbyVideoCommentProto.HippoMsg
 * JD-Core Version:    0.7.0.1
 */