package tencent.im.oidb.cmd0xf26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xf26$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field app_type = PBField.initUInt32(0);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public oidb_0xf26.GrantReq grant_req = new oidb_0xf26.GrantReq();
  public final PBStringField openid = PBField.initString("");
  public final PBStringField openkey = PBField.initString("");
  public oidb_0xf26.QueryReq query_req = new oidb_0xf26.QueryReq();
  public oidb_0xf26.RevokeReq revoke_req = new oidb_0xf26.RevokeReq();
  public final PBUInt32Field source_from = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 82, 90, 98 }, new String[] { "appid", "app_type", "source_from", "openid", "openkey", "query_req", "grant_req", "revoke_req" }, new Object[] { localInteger, localInteger, localInteger, "", "", null, null, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf26.oidb_0xf26.ReqBody
 * JD-Core Version:    0.7.0.1
 */