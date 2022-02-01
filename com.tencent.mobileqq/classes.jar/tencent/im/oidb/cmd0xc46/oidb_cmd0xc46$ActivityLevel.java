package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xc46$ActivityLevel
  extends MessageMicro<ActivityLevel>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 82 }, new String[] { "level", "timestamp", "icon" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "" }, ActivityLevel.class);
  public final PBStringField icon = PBField.initString("");
  public final PBInt32Field level = PBField.initInt32(0);
  public final PBInt64Field timestamp = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ActivityLevel
 * JD-Core Version:    0.7.0.1
 */