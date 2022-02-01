package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x791$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_result", "msg_get_reddot_res", "msg_set_reddot_res", "msg_set_reddot_appids_res" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
  public oidb_0x791.GetRedDotRes msg_get_reddot_res = new oidb_0x791.GetRedDotRes();
  public oidb_0x791.SetRotDotAppidsRes msg_set_reddot_appids_res = new oidb_0x791.SetRotDotAppidsRes();
  public oidb_0x791.SetRedDotRes msg_set_reddot_res = new oidb_0x791.SetRedDotRes();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x791.oidb_0x791.RspBody
 * JD-Core Version:    0.7.0.1
 */