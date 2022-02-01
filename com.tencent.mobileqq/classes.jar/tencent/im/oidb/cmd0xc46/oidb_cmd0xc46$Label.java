package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc46$Label
  extends MessageMicro<Label>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field show_arbitration = PBField.initUInt32(0);
  public final PBUInt32Field show_block = PBField.initUInt32(0);
  public final PBUInt32Field show_delete = PBField.initUInt32(0);
  public final PBUInt32Field show_sink = PBField.initUInt32(0);
  public final PBUInt32Field show_top = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "show_delete", "show_top", "show_sink", "show_block", "show_arbitration" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger }, Label.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Label
 * JD-Core Version:    0.7.0.1
 */