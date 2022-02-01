package com.tencent.pb.apolloactionused;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ApolloActionUsed$EmotionUsedRsp
  extends MessageMicro<EmotionUsedRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField attach_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<ApolloActionUsed.EmuTopo> emtps = PBField.initRepeatMessage(ApolloActionUsed.EmuTopo.class);
  public final PBInt64Field refresh_cycle = PBField.initInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "attach_info", "refresh_cycle", "emtps" }, new Object[] { localByteStringMicro, Long.valueOf(0L), null }, EmotionUsedRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.apolloactionused.ApolloActionUsed.EmotionUsedRsp
 * JD-Core Version:    0.7.0.1
 */