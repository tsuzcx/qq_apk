package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GroupOpenSysMsg$Sender
  extends MessageMicro<Sender>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uin", "nick", "avatar", "url" }, new Object[] { Long.valueOf(0L), "", "", "" }, Sender.class);
  public final PBStringField avatar = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.GroupOpenSysMsg.Sender
 * JD-Core Version:    0.7.0.1
 */