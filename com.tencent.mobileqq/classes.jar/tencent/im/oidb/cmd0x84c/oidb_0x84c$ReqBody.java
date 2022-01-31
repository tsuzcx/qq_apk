package tencent.im.oidb.cmd0x84c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x84c$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "collect_adcode_req", "collect_task_req", "collect_all_req", "query_count_req" }, new Object[] { null, null, null, null }, ReqBody.class);
  public oidb_0x84c.CollectAdcodeReq collect_adcode_req = new oidb_0x84c.CollectAdcodeReq();
  public oidb_0x84c.CollectAllReq collect_all_req = new oidb_0x84c.CollectAllReq();
  public oidb_0x84c.CollectTaskReq collect_task_req = new oidb_0x84c.CollectTaskReq();
  public oidb_0x84c.QueryCountReq query_count_req = new oidb_0x84c.QueryCountReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x84c.oidb_0x84c.ReqBody
 * JD-Core Version:    0.7.0.1
 */