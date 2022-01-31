package tencent.im.oidb.cmd0x985;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x985$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_subcmd", "msg_get_read_list_req" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
  public oidb_0x985.GetReadListReq msg_get_read_list_req = new oidb_0x985.GetReadListReq();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x985.oidb_0x985.ReqBody
 * JD-Core Version:    0.7.0.1
 */