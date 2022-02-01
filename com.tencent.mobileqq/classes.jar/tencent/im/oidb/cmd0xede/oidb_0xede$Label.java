package tencent.im.oidb.cmd0xede;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xede$Label
  extends MessageMicro<Label>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0xede.Color edging_color = new oidb_0xede.Color();
  public final PBEnumField enum_type = PBField.initEnum(1);
  public oidb_0xede.Color text_color = new oidb_0xede.Color();
  public final PBUInt32Field uint32_label_attr = PBField.initUInt32(0);
  public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "bytes_name", "enum_type", "text_color", "edging_color", "uint32_label_attr", "uint32_label_type" }, new Object[] { localByteStringMicro, Integer.valueOf(1), null, null, Integer.valueOf(0), Integer.valueOf(0) }, Label.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xede.oidb_0xede.Label
 * JD-Core Version:    0.7.0.1
 */