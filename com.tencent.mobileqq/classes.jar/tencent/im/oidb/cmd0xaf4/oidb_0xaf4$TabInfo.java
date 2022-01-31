package tencent.im.oidb.cmd0xaf4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xaf4$TabInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "type", "name", "desc", "url", "num" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0) }, TabInfo.class);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaf4.oidb_0xaf4.TabInfo
 * JD-Core Version:    0.7.0.1
 */