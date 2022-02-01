package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQCircleNotify$UserCertifyMessage
  extends MessageMicro<UserCertifyMessage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field msgType = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "msgType", "body" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, UserCertifyMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleNotify.UserCertifyMessage
 * JD-Core Version:    0.7.0.1
 */