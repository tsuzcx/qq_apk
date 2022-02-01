package tencent.im.oidb.cmd0xf30;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xf30$Action
  extends MessageMicro<Action>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField action_type = PBField.initEnum(0);
  public final PBUInt32Field priority = PBField.initUInt32(0);
  public final PBUInt32Field progress = PBField.initUInt32(0);
  public final PBUInt32Field watch_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "action_type", "progress", "priority", "watch_time" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, Action.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.Action
 * JD-Core Version:    0.7.0.1
 */