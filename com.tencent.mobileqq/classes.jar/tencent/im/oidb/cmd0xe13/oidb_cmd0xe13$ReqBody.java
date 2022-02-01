package tencent.im.oidb.cmd0xe13;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xe13$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_report_info", "uint32_seq" }, new Object[] { null, Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatMessageField<oidb_cmd0xe13.ReportInfo> msg_report_info = PBField.initRepeatMessage(oidb_cmd0xe13.ReportInfo.class);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe13.oidb_cmd0xe13.ReqBody
 * JD-Core Version:    0.7.0.1
 */