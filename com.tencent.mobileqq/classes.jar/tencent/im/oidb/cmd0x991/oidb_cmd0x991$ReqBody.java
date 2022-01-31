package tencent.im.oidb.cmd0x991;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0x991$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_user", "msg_goods" }, new Object[] { null, null }, ReqBody.class);
  public oidb_cmd0x991.Goods msg_goods = new oidb_cmd0x991.Goods();
  public oidb_cmd0x991.User msg_user = new oidb_cmd0x991.User();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x991.oidb_cmd0x991.ReqBody
 * JD-Core Version:    0.7.0.1
 */