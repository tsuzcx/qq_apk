package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowNearbyVideoCommentProto$GetCommentsResp
  extends MessageMicro<GetCommentsResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "value" }, new Object[] { Long.valueOf(0L), null }, GetCommentsResp.class);
  public final PBUInt64Field result = PBField.initUInt64(0L);
  public final PBRepeatMessageField<NowNearbyVideoCommentProto.Comment> value = PBField.initRepeatMessage(NowNearbyVideoCommentProto.Comment.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.NowNearbyVideoCommentProto.GetCommentsResp
 * JD-Core Version:    0.7.0.1
 */