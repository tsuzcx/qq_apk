package tencent.im.oidb.cmd0x44c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x44c$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_subcmd", "msg_modify_conf_info_req" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
  public cmd0x44c.ModifyConfInfoReq msg_modify_conf_info_req = new cmd0x44c.ModifyConfInfoReq();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x44c.cmd0x44c.ReqBody
 * JD-Core Version:    0.7.0.1
 */