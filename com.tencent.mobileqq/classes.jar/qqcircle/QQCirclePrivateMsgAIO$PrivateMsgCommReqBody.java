package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCirclePrivateMsgAIO$PrivateMsgCommReqBody
  extends MessageMicro<PrivateMsgCommReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_c2c_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_rand = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reply_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64 }, new String[] { "uint64_from_uin", "uint64_to_uin", "uint32_c2c_type", "uint32_service_type", "bytes_pb_reserve", "uint32_msg_seq", "uint32_msg_rand", "uint32_reply_flag" }, new Object[] { localLong, localLong, localInteger, localInteger, localByteStringMicro, localInteger, localInteger, localInteger }, PrivateMsgCommReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCirclePrivateMsgAIO.PrivateMsgCommReqBody
 * JD-Core Version:    0.7.0.1
 */