package tencent.im.oidb.cmd0xf3c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xf3c$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field active_num = PBField.initUInt64(0L);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBBytesField icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField rank_entrance = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field rank_num = PBField.initUInt64(0L);
  public final PBBytesField rank_text = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "group_code", "active_num", "rank_num", "rank_entrance", "rank_text", "icon" }, new Object[] { localLong, localLong, localLong, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf3c.oidb_0xf3c.RspBody
 * JD-Core Version:    0.7.0.1
 */