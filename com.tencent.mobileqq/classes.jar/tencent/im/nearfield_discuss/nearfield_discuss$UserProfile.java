package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearfield_discuss$UserProfile
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_uin", "int32_face_id", "int32_sex", "int32_age", "str_nick" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, UserProfile.class);
  public final PBInt32Field int32_age = PBField.initInt32(0);
  public final PBInt32Field int32_face_id = PBField.initInt32(0);
  public final PBInt32Field int32_sex = PBField.initInt32(0);
  public final PBStringField str_nick = PBField.initString("");
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.nearfield_discuss.nearfield_discuss.UserProfile
 * JD-Core Version:    0.7.0.1
 */