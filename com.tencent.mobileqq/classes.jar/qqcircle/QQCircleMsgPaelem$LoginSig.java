package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleMsgPaelem$LoginSig
  extends MessageMicro<LoginSig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_type", "bytes_sig", "uint32_app_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, LoginSig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleMsgPaelem.LoginSig
 * JD-Core Version:    0.7.0.1
 */