package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class oidb_0xeb7$SignInStatusBase
  extends MessageMicro<SignInStatusBase>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "status", "currentTimeStamp" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, SignInStatusBase.class);
  public final PBInt64Field currentTimeStamp = PBField.initInt64(0L);
  public final PBEnumField status = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.SignInStatusBase
 * JD-Core Version:    0.7.0.1
 */