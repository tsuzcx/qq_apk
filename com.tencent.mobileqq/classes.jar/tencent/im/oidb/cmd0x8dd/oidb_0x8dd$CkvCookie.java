package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8dd$CkvCookie
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_index", "uint32_uin", "uint32_end" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, CkvCookie.class);
  public final PBUInt32Field uint32_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.CkvCookie
 * JD-Core Version:    0.7.0.1
 */