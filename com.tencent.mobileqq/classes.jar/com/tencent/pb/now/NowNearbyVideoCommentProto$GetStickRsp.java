package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowNearbyVideoCommentProto$GetStickRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "result", "err_msg", "value", "total_num" }, new Object[] { Integer.valueOf(0), "", null, Long.valueOf(0L) }, GetStickRsp.class);
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt64Field total_num = PBField.initUInt64(0L);
  public final PBRepeatMessageField value = PBField.initRepeatMessage(NowNearbyVideoCommentProto.Comment.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.NowNearbyVideoCommentProto.GetStickRsp
 * JD-Core Version:    0.7.0.1
 */