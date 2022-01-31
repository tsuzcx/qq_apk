package tencent.im.oidb.cmd0xb36;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb36$ToastInfo
  extends MessageMicro<ToastInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 58 }, new String[] { "type", "wording", "id", "uins", "expired", "link", "icon" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", "" }, ToastInfo.class);
  public final PBUInt32Field expired = PBField.initUInt32(0);
  public final PBStringField icon = PBField.initString("");
  public final PBUInt64Field id = PBField.initUInt64(0L);
  public final PBStringField link = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ToastInfo
 * JD-Core Version:    0.7.0.1
 */