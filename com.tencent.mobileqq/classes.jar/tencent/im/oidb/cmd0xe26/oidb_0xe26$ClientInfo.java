package tencent.im.oidb.cmd0xe26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xe26$ClientInfo
  extends MessageMicro<ClientInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "val" }, new Object[] { "", "" }, ClientInfo.class);
  public final PBStringField key = PBField.initString("");
  public final PBStringField val = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe26.oidb_0xe26.ClientInfo
 * JD-Core Version:    0.7.0.1
 */