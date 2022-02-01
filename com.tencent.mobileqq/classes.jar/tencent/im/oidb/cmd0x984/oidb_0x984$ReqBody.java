package tencent.im.oidb.cmd0x984;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x984$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_subcmd", "msg_read_report_req" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
  public oidb_0x984.ReadReportReq msg_read_report_req = new oidb_0x984.ReadReportReq();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x984.oidb_0x984.ReqBody
 * JD-Core Version:    0.7.0.1
 */