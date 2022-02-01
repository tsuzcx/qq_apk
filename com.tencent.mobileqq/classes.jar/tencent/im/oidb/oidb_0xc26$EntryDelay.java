package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xc26$EntryDelay
  extends MessageMicro<EntryDelay>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "em_entry", "uint32_delay" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0) }, EntryDelay.class);
  public final PBEnumField em_entry = PBField.initEnum(1);
  public final PBUInt32Field uint32_delay = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc26.EntryDelay
 * JD-Core Version:    0.7.0.1
 */