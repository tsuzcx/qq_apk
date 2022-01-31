package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0x59f$ContactBindInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "mobile", "nation_code" }, new Object[] { "", "" }, ContactBindInfo.class);
  public final PBStringField mobile = PBField.initString("");
  public final PBStringField nation_code = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x59f.oidb_0x59f.ContactBindInfo
 * JD-Core Version:    0.7.0.1
 */