package com.tencent.protofile.oidb_0xe21;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_0xe21$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 82 }, new String[] { "result_code", "rpt_consume_report_item", "task_config", "ad_report_rsp" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
  public oidb_0xe21.ADReportRsp ad_report_rsp = new oidb_0xe21.ADReportRsp();
  public final PBInt32Field result_code = PBField.initInt32(0);
  public oidb_0xe21.ConsumeReportItem rpt_consume_report_item = new oidb_0xe21.ConsumeReportItem();
  public oidb_0xe21.TaskConfig task_config = new oidb_0xe21.TaskConfig();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.protofile.oidb_0xe21.oidb_0xe21.RspBody
 * JD-Core Version:    0.7.0.1
 */