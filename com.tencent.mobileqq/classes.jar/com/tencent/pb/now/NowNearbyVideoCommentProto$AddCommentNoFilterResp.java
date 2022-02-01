package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowNearbyVideoCommentProto$AddCommentNoFilterResp
  extends MessageMicro<AddCommentNoFilterResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field comment_id = PBField.initUInt64(0L);
  public final PBUInt64Field result = PBField.initUInt64(0L);
  public final PBBytesField wording = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "result", "comment_id", "wording" }, new Object[] { localLong, localLong, localByteStringMicro }, AddCommentNoFilterResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.NowNearbyVideoCommentProto.AddCommentNoFilterResp
 * JD-Core Version:    0.7.0.1
 */