package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb81$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_client_type", "msg_get_user_info_req" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
  public oidb_cmd0xb81.GetUserInfoReq msg_get_user_info_req = new oidb_cmd0xb81.GetUserInfoReq();
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.ReqBody
 * JD-Core Version:    0.7.0.1
 */