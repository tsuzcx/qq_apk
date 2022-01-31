package tencent.im.oidb.cmd0x6b5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6b5$Player
  extends MessageMicro<Player>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_tips = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_amount = PBField.initInt32(0);
  public final PBInt32Field int32_index = PBField.initInt32(0);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_uin", "uint64_time", "int32_amount", "int32_index", "bytes_tips" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, Player.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6b5.oidb_0x6b5.Player
 * JD-Core Version:    0.7.0.1
 */