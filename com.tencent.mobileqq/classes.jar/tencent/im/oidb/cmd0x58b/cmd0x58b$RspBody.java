package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x58b$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "msg_cmd_error_code", "uint32_subcmd", "msg_get_conf_info", "msg_get_conf_name_for_push", "msg_get_multi_conf_info" }, new Object[] { null, Integer.valueOf(0), null, null, null }, RspBody.class);
  public cmd0x58b.CmdErrorCode msg_cmd_error_code = new cmd0x58b.CmdErrorCode();
  public cmd0x58b.GetConfInfoRsp msg_get_conf_info = new cmd0x58b.GetConfInfoRsp();
  public cmd0x58b.GetConfNameForPushRsp msg_get_conf_name_for_push = new cmd0x58b.GetConfNameForPushRsp();
  public cmd0x58b.GetMultiConfInfoRsp msg_get_multi_conf_info = new cmd0x58b.GetMultiConfInfoRsp();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x58b.cmd0x58b.RspBody
 * JD-Core Version:    0.7.0.1
 */