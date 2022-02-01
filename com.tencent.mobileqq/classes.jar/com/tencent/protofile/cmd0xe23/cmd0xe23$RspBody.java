package com.tencent.protofile.cmd0xe23;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class cmd0xe23$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "result_code", "rpt_consume_info_item", "task_config" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
  public final PBInt32Field result_code = PBField.initInt32(0);
  public cmd0xe23.GetConsumeInfoItem rpt_consume_info_item = new cmd0xe23.GetConsumeInfoItem();
  public cmd0xe23.TaskConfig task_config = new cmd0xe23.TaskConfig();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protofile.cmd0xe23.cmd0xe23.RspBody
 * JD-Core Version:    0.7.0.1
 */