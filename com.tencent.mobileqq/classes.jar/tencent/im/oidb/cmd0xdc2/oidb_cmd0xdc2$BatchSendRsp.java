package tencent.im.oidb.cmd0xdc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.RspBody;

public final class oidb_cmd0xdc2$BatchSendRsp
  extends MessageMicro<BatchSendRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50 }, new String[] { "send_type", "recv_uin", "recv_openid", "err_code", "err_msg", "rsp_body" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), "", null }, BatchSendRsp.class);
  public final PBUInt32Field err_code = PBField.initUInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBStringField recv_openid = PBField.initString("");
  public final PBUInt64Field recv_uin = PBField.initUInt64(0L);
  public oidb_cmd0xb77.RspBody rsp_body = new oidb_cmd0xb77.RspBody();
  public final PBUInt32Field send_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.BatchSendRsp
 * JD-Core Version:    0.7.0.1
 */