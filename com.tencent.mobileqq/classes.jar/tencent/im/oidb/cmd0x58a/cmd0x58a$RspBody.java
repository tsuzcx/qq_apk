package tencent.im.oidb.cmd0x58a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x58a$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_cmd_error_code", "uint32_subcmd", "msg_get_conf_list" }, new Object[] { null, Integer.valueOf(0), null }, RspBody.class);
  public cmd0x58a.CmdErrorCode msg_cmd_error_code = new cmd0x58a.CmdErrorCode();
  public cmd0x58a.GetConfListRsp msg_get_conf_list = new cmd0x58a.GetConfListRsp();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x58a.cmd0x58a.RspBody
 * JD-Core Version:    0.7.0.1
 */