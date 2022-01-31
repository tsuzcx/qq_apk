package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hummer_commelem$MsgElemInfo_servtype2
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_poke_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_vaspoke_minver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_vaspoke_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_double_hit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_poke_strength = PBField.initUInt32(0);
  public final PBUInt32Field uint32_poke_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vaspoke_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 56 }, new String[] { "uint32_poke_type", "bytes_poke_summary", "uint32_double_hit", "uint32_vaspoke_id", "bytes_vaspoke_name", "bytes_vaspoke_minver", "uint32_poke_strength" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, MsgElemInfo_servtype2.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype2
 * JD-Core Version:    0.7.0.1
 */