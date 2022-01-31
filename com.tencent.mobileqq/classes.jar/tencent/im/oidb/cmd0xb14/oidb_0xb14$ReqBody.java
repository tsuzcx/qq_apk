package tencent.im.oidb.cmd0xb14;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb14$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "type", "group_id", "uins" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBRepeatField uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb14.oidb_0xb14.ReqBody
 * JD-Core Version:    0.7.0.1
 */