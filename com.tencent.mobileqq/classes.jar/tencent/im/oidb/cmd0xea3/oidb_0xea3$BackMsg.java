package tencent.im.oidb.cmd0xea3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xea3$BackMsg
  extends MessageMicro<BackMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field addition_seq = PBField.initUInt64(0L);
  public final PBBytesField msg = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "addition_seq", "msg" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, BackMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xea3.oidb_0xea3.BackMsg
 * JD-Core Version:    0.7.0.1
 */