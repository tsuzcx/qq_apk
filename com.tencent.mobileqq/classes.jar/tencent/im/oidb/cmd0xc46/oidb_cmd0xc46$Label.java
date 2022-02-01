package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc46$Label
  extends MessageMicro<Label>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "show_delete", "show_top", "show_sink" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Label.class);
  public final PBUInt32Field show_delete = PBField.initUInt32(0);
  public final PBUInt32Field show_sink = PBField.initUInt32(0);
  public final PBUInt32Field show_top = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Label
 * JD-Core Version:    0.7.0.1
 */