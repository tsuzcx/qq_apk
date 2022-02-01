package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class group_mgr$LevelInfo
  extends MessageMicro<LevelInfo>
{
  public static final int LEVELS_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "levels" }, new Object[] { null }, LevelInfo.class);
  public final PBRepeatMessageField<group_mgr.LevelInfo.LevelName> levels = PBField.initRepeatMessage(group_mgr.LevelInfo.LevelName.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.hw.group_mgr.LevelInfo
 * JD-Core Version:    0.7.0.1
 */