package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_mgr$GroupCommInfo
  extends MessageMicro<GroupCommInfo>
{
  public static final int GROUP_CLASS_FIELD_NUMBER = 4;
  public static final int GROUP_NAME_FIELD_NUMBER = 2;
  public static final int GROUP_OPTION_FIELD_NUMBER = 1;
  public static final int GROUP_SIZE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field group_class = PBField.initUInt32(0);
  public final PBStringField group_name = PBField.initString("");
  public final PBUInt32Field group_option = PBField.initUInt32(0);
  public final PBUInt32Field group_size = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "group_option", "group_name", "group_size", "group_class" }, new Object[] { localInteger, "", localInteger, localInteger }, GroupCommInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.hw.group_mgr.GroupCommInfo
 * JD-Core Version:    0.7.0.1
 */