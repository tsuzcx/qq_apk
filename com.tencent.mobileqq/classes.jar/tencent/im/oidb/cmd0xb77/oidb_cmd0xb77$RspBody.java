package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb77$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "wording", "jump_result", "jump_url", "uint32_level", "uint32_sub_level", "develop_msg" }, new Object[] { "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "" }, RspBody.class);
  public final PBStringField develop_msg = PBField.initString("");
  public final PBUInt32Field jump_result = PBField.initUInt32(0);
  public final PBStringField jump_url = PBField.initString("");
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_level = PBField.initUInt32(0);
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.RspBody
 * JD-Core Version:    0.7.0.1
 */