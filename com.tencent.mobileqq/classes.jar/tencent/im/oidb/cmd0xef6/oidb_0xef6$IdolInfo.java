package tencent.im.oidb.cmd0xef6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xef6$IdolInfo
  extends MessageMicro<IdolInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 58, 64, 72 }, new String[] { "name", "alias", "avatar", "desc", "gender", "idol_id", "pic", "score", "rank" }, new Object[] { "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0) }, IdolInfo.class);
  public final PBRepeatField<String> alias = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField avatar = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public final PBUInt32Field idol_id = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBStringField pic = PBField.initString("");
  public final PBUInt32Field rank = PBField.initUInt32(0);
  public final PBUInt64Field score = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xef6.oidb_0xef6.IdolInfo
 * JD-Core Version:    0.7.0.1
 */