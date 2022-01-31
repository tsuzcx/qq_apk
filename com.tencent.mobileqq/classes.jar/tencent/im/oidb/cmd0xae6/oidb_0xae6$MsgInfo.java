package tencent.im.oidb.cmd0xae6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xae6$MsgInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uin", "seq", "pic", "content" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "" }, MsgInfo.class);
  public final PBStringField content = PBField.initString("");
  public final PBStringField pic = PBField.initString("");
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xae6.oidb_0xae6.MsgInfo
 * JD-Core Version:    0.7.0.1
 */