package com.tencent.pb.apolloactionused;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ApolloActionUsed$EmotionUsedReq
  extends MessageMicro<EmotionUsedReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField attach_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field pkgid = PBField.initInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uin", "attach_info", "pkgid" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, EmotionUsedReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.apolloactionused.ApolloActionUsed.EmotionUsedReq
 * JD-Core Version:    0.7.0.1
 */