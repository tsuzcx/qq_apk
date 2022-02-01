package tencent.im.oidb.cmd0x6e7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6e7$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "uint64_group_code", "str_app_src", "str_version", "uint64_number", "combine_key" }, new Object[] { Long.valueOf(0L), "", "", Long.valueOf(0L), null }, ReqBody.class);
  public oidb_0x6e7.CombineKey combine_key = new oidb_0x6e7.CombineKey();
  public final PBStringField str_app_src = PBField.initString("");
  public final PBStringField str_version = PBField.initString("");
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_number = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6e7.oidb_0x6e7.ReqBody
 * JD-Core Version:    0.7.0.1
 */