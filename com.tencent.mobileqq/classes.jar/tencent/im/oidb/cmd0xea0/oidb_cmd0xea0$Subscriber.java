package tencent.im.oidb.cmd0xea0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xea0$Subscriber
  extends MessageMicro<Subscriber>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "uin", "name", "avatar_url", "jump_url", "avatar_status" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0) }, Subscriber.class);
  public final PBUInt32Field avatar_status = PBField.initUInt32(0);
  public final PBStringField avatar_url = PBField.initString("");
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xea0.oidb_cmd0xea0.Subscriber
 * JD-Core Version:    0.7.0.1
 */