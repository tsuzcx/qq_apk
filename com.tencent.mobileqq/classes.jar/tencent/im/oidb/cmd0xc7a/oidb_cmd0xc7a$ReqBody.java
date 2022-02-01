package tencent.im.oidb.cmd0xc7a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc7a$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "cmd", "get_uin_info_req" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public oidb_cmd0xc7a.GetUinInfoReq get_uin_info_req = new oidb_cmd0xc7a.GetUinInfoReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a.ReqBody
 * JD-Core Version:    0.7.0.1
 */