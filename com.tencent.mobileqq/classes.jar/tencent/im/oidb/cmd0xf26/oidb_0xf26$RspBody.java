package tencent.im.oidb.cmd0xf26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xf26$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82, 90, 98 }, new String[] { "wording", "query_rsp", "grant_rsp", "revoke_rsp" }, new Object[] { "", null, null, null }, RspBody.class);
  public oidb_0xf26.GrantRsp grant_rsp = new oidb_0xf26.GrantRsp();
  public oidb_0xf26.QueryRsp query_rsp = new oidb_0xf26.QueryRsp();
  public oidb_0xf26.RevokeRsp revoke_rsp = new oidb_0xf26.RevokeRsp();
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf26.oidb_0xf26.RspBody
 * JD-Core Version:    0.7.0.1
 */