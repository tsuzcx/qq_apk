package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_mgr$LevelInfo$LevelName
  extends MessageMicro
{
  public static final int LEVEL_FIELD_NUMBER = 1;
  public static final int NAME_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "level", "name" }, new Object[] { Integer.valueOf(0), "" }, LevelName.class);
  public final PBUInt32Field level = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.hw.group_mgr.LevelInfo.LevelName
 * JD-Core Version:    0.7.0.1
 */