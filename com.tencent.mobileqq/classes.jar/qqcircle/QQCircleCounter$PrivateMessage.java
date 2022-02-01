package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleCounter$PrivateMessage
  extends MessageMicro<PrivateMessage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField attachInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field timestamp = PBField.initUInt32(0);
  public final PBStringField uID = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "uID", "timestamp", "attachInfo" }, new Object[] { "", Integer.valueOf(0), localByteStringMicro }, PrivateMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleCounter.PrivateMessage
 * JD-Core Version:    0.7.0.1
 */