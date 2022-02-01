package tencent.im.oidb.cmd0x921;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x921$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_subcmd", "msg_get_at_all_remain" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public cmd0x921.GetAtAllRemainRsp msg_get_at_all_remain = new cmd0x921.GetAtAllRemainRsp();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x921.cmd0x921.RspBody
 * JD-Core Version:    0.7.0.1
 */