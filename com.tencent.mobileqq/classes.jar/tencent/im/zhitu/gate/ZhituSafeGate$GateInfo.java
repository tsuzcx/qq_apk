package tencent.im.zhitu.gate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ZhituSafeGate$GateInfo
  extends MessageMicro<GateInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_bytes_other = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_state = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_state", "bytes_bytes_other" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GateInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.zhitu.gate.ZhituSafeGate.GateInfo
 * JD-Core Version:    0.7.0.1
 */