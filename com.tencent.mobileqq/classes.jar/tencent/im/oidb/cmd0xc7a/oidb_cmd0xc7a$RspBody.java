package tencent.im.oidb.cmd0xc7a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc7a$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 90 }, new String[] { "wording", "next_req_duration", "get_uin_info_rsp" }, new Object[] { "", Integer.valueOf(0), null }, RspBody.class);
  public oidb_cmd0xc7a.GetUinInfoRsp get_uin_info_rsp = new oidb_cmd0xc7a.GetUinInfoRsp();
  public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a.RspBody
 * JD-Core Version:    0.7.0.1
 */