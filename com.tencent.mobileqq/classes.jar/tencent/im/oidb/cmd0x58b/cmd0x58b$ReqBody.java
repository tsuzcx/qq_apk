package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x58b$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_subcmd", "msg_get_conf_info", "msg_get_conf_name_for_push", "msg_get_multi_conf_info" }, new Object[] { Integer.valueOf(0), null, null, null }, ReqBody.class);
  public cmd0x58b.GetConfInfoReq msg_get_conf_info = new cmd0x58b.GetConfInfoReq();
  public cmd0x58b.GetConfNameForPushReq msg_get_conf_name_for_push = new cmd0x58b.GetConfNameForPushReq();
  public cmd0x58b.GetMultiConfInfoReq msg_get_multi_conf_info = new cmd0x58b.GetMultiConfInfoReq();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x58b.cmd0x58b.ReqBody
 * JD-Core Version:    0.7.0.1
 */