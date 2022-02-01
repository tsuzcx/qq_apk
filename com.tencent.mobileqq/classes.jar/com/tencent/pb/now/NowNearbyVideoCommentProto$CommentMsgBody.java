package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class NowNearbyVideoCommentProto$CommentMsgBody
  extends MessageMicro<CommentMsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msgs" }, new Object[] { null }, CommentMsgBody.class);
  public final PBRepeatMessageField<NowNearbyVideoCommentProto.CommentMsg> msgs = PBField.initRepeatMessage(NowNearbyVideoCommentProto.CommentMsg.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsgBody
 * JD-Core Version:    0.7.0.1
 */