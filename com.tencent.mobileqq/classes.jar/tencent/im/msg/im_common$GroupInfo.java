package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_common$GroupInfo
  extends MessageMicro<GroupInfo>
{
  public static final int GROUP_ID_FIELD_NUMBER = 1;
  public static final int GROUP_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_id", "group_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1) }, GroupInfo.class);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBEnumField group_type = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_common.GroupInfo
 * JD-Core Version:    0.7.0.1
 */