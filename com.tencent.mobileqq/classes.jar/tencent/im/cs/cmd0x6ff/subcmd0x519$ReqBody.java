package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x519$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 282 }, new String[] { "uint32_sub_cmd", "msg_crm_common_head", "msg_get_navigation_menu_req" }, new Object[] { Integer.valueOf(0), null, null }, ReqBody.class);
  public subcmd0x519.CRMMsgHead msg_crm_common_head = new subcmd0x519.CRMMsgHead();
  public subcmd0x519.GetNavigationMenuReqBody msg_get_navigation_menu_req = new subcmd0x519.GetNavigationMenuReqBody();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x519.ReqBody
 * JD-Core Version:    0.7.0.1
 */