package tencent.im.oidb.cmd0x6b6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6b6$TmpMsgToken
  extends MessageMicro<TmpMsgToken>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field c2c_type = PBField.initUInt32(0);
  public final PBUInt32Field service_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "buf", "c2c_type", "service_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, TmpMsgToken.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6b6.oidb_0x6b6.TmpMsgToken
 * JD-Core Version:    0.7.0.1
 */