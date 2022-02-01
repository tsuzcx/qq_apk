package tencent.im.oidb.cmd0x8f6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x8f6$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_subcmd", "msg_get_umc", "msg_dec_umc", "msg_inc_umc" }, new Object[] { Integer.valueOf(0), null, null, null }, ReqBody.class);
  public oidb_cmd0x8f6.DecreaseUnreadMailCountReq msg_dec_umc = new oidb_cmd0x8f6.DecreaseUnreadMailCountReq();
  public oidb_cmd0x8f6.GetUnreadMailCountReq msg_get_umc = new oidb_cmd0x8f6.GetUnreadMailCountReq();
  public oidb_cmd0x8f6.IncUnreadMailCountReq msg_inc_umc = new oidb_cmd0x8f6.IncUnreadMailCountReq();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.ReqBody
 * JD-Core Version:    0.7.0.1
 */