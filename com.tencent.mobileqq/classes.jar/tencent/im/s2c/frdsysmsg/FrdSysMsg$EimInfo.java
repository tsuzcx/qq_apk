package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FrdSysMsg$EimInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_eim_fuin", "str_eim_id", "str_eim_telno", "uint64_group_id" }, new Object[] { Long.valueOf(0L), "", "", Long.valueOf(0L) }, EimInfo.class);
  public final PBStringField str_eim_id = PBField.initString("");
  public final PBStringField str_eim_telno = PBField.initString("");
  public final PBUInt64Field uint64_eim_fuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.frdsysmsg.FrdSysMsg.EimInfo
 * JD-Core Version:    0.7.0.1
 */