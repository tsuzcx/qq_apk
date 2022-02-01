package com.tencent.pb.apollomsgextend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ApolloMsgExtend$ThreeDBaseInfo
  extends MessageMicro<ThreeDBaseInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field action_type = PBField.initUInt32(0);
  public final PBBytesField bytes_action_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_peer_status = PBField.initInt32(0);
  public final PBInt32Field int32_sender_status = PBField.initInt32(0);
  public final PBUInt32Field uint32_action_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint32_action_id", "action_type", "bytes_action_name", "int32_sender_status", "int32_peer_status" }, new Object[] { localInteger, localInteger, localByteStringMicro, localInteger, localInteger }, ThreeDBaseInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.apollomsgextend.ApolloMsgExtend.ThreeDBaseInfo
 * JD-Core Version:    0.7.0.1
 */