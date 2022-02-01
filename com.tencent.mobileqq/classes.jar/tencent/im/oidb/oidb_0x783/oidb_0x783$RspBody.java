package tencent.im.oidb.oidb_0x783;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x783$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 29, 34 }, new String[] { "uint32_result", "str_errmsg", "uint32_server_time", "rpt_remark_infos" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0x783.RemarkInfo> rpt_remark_infos = PBField.initRepeatMessage(oidb_0x783.RemarkInfo.class);
  public final PBStringField str_errmsg = PBField.initString("");
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBFixed32Field uint32_server_time = PBField.initFixed32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x783.oidb_0x783.RspBody
 * JD-Core Version:    0.7.0.1
 */