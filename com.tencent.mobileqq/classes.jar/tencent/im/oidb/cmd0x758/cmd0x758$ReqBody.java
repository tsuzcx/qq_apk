package tencent.im.oidb.cmd0x758;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x758$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56 }, new String[] { "uint64_join_group_code", "be_invited_uin_info", "string_msg", "uint32_main_source_id", "uint32_sub_source_id", "string_verify_token", "uint32_verify_type" }, new Object[] { Long.valueOf(0L), null, "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatMessageField<cmd0x758.InviteUinInfo> be_invited_uin_info = PBField.initRepeatMessage(cmd0x758.InviteUinInfo.class);
  public final PBStringField string_msg = PBField.initString("");
  public final PBStringField string_verify_token = PBField.initString("");
  public final PBUInt32Field uint32_main_source_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_source_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_verify_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_join_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x758.cmd0x758.ReqBody
 * JD-Core Version:    0.7.0.1
 */