package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowNearbyVideoCommentProto$GetCommentListNoFilterResp
  extends MessageMicro<GetCommentListNoFilterResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field end_flag = PBField.initUInt64(0L);
  public final PBRepeatMessageField<NowNearbyVideoCommentProto.Comment> lists = PBField.initRepeatMessage(NowNearbyVideoCommentProto.Comment.class);
  public final PBUInt64Field result = PBField.initUInt64(0L);
  public final PBUInt64Field total_num = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "result", "lists", "total_num", "end_flag" }, new Object[] { localLong, null, localLong, localLong }, GetCommentListNoFilterResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.NowNearbyVideoCommentProto.GetCommentListNoFilterResp
 * JD-Core Version:    0.7.0.1
 */