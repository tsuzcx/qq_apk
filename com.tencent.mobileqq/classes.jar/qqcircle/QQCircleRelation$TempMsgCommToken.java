package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleRelation$TempMsgCommToken
  extends MessageMicro<TempMsgCommToken>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_srv_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time_stamp = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_time_stamp", "uint32_expire_time", "bytes_srv_data" }, new Object[] { localInteger, localInteger, localByteStringMicro }, TempMsgCommToken.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRelation.TempMsgCommToken
 * JD-Core Version:    0.7.0.1
 */