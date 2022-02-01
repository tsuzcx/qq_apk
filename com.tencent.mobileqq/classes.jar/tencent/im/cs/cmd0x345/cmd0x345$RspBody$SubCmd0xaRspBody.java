package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x345$RspBody$SubCmd0xaRspBody
  extends MessageMicro<SubCmd0xaRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint64_uin", "uint64_disscus_uin", "str_file_id", "str_session_info", "str_ret_msg" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", "", "" }, SubCmd0xaRspBody.class);
  public final PBStringField str_file_id = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBStringField str_session_info = PBField.initString("");
  public final PBUInt64Field uint64_disscus_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0xaRspBody
 * JD-Core Version:    0.7.0.1
 */