package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FrdSysMsg$GroupInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_group_uin", "str_group_name", "str_group_nick" }, new Object[] { Long.valueOf(0L), "", "" }, GroupInfo.class);
  public final PBStringField str_group_name = PBField.initString("");
  public final PBStringField str_group_nick = PBField.initString("");
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.frdsysmsg.FrdSysMsg.GroupInfo
 * JD-Core Version:    0.7.0.1
 */