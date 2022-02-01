package tencent.im.oidb.cmd0xef7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xef7$IdolInfo
  extends MessageMicro<IdolInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<String> alias = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField avatar = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public final PBUInt32Field idol_id = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48 }, new String[] { "name", "alias", "avatar", "desc", "gender", "idol_id" }, new Object[] { "", "", "", "", localInteger, localInteger }, IdolInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xef7.oidb_0xef7.IdolInfo
 * JD-Core Version:    0.7.0.1
 */