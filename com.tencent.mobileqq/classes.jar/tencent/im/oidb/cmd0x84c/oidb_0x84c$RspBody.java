package tencent.im.oidb.cmd0x84c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x84c$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "collect_adcode_rsp", "collect_task_rsp", "collect_all_rsp", "query_count_rsp" }, new Object[] { null, null, null, null }, RspBody.class);
  public oidb_0x84c.CollectAdcodeRsp collect_adcode_rsp = new oidb_0x84c.CollectAdcodeRsp();
  public oidb_0x84c.CollectAllRsp collect_all_rsp = new oidb_0x84c.CollectAllRsp();
  public oidb_0x84c.CollectTaskRsp collect_task_rsp = new oidb_0x84c.CollectTaskRsp();
  public oidb_0x84c.QueryCountRsp query_count_rsp = new oidb_0x84c.QueryCountRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x84c.oidb_0x84c.RspBody
 * JD-Core Version:    0.7.0.1
 */