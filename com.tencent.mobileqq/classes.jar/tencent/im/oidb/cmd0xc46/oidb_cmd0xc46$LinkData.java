package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc46$LinkData
  extends MessageMicro<LinkData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "wording", "icon", "url", "type" }, new Object[] { "", "", "", Integer.valueOf(0) }, LinkData.class);
  public final PBStringField icon = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.LinkData
 * JD-Core Version:    0.7.0.1
 */