package tencent.im.oidb.cmd0xf26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xf26$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 82, 90, 98 }, new String[] { "appid", "app_type", "query_req", "grant_req", "revoke_req" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null }, ReqBody.class);
  public final PBUInt32Field app_type = PBField.initUInt32(0);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public oidb_0xf26.GrantReq grant_req = new oidb_0xf26.GrantReq();
  public oidb_0xf26.QueryReq query_req = new oidb_0xf26.QueryReq();
  public oidb_0xf26.RevokeReq revoke_req = new oidb_0xf26.RevokeReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf26.oidb_0xf26.ReqBody
 * JD-Core Version:    0.7.0.1
 */