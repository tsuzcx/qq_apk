package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x388$PicSize
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_original", "uint32_thumb", "uint32_high" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PicSize.class);
  public final PBUInt32Field uint32_high = PBField.initUInt32(0);
  public final PBUInt32Field uint32_original = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388.PicSize
 * JD-Core Version:    0.7.0.1
 */