package tencent.im.group_pro_proto.oidb0xf9c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class common$Category
  extends MessageMicro<Category>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "id", "name" }, new Object[] { Integer.valueOf(0), "" }, Category.class);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.oidb0xf9c.common.Category
 * JD-Core Version:    0.7.0.1
 */