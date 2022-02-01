package tencent.im.oidb.cmd0x75f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x75f$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66 }, new String[] { "uint64_appid", "uint32_subcmd", "msg_add_req", "msg_delete_req", "msg_get_list_req", "msg_update_req", "msg_get_one_req", "msg_add_batch_req" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null, null, null, null, null }, ReqBody.class);
  public cmd0x75f.AddBatchReq msg_add_batch_req = new cmd0x75f.AddBatchReq();
  public cmd0x75f.AddReq msg_add_req = new cmd0x75f.AddReq();
  public cmd0x75f.DeleteReq msg_delete_req = new cmd0x75f.DeleteReq();
  public cmd0x75f.GetListReq msg_get_list_req = new cmd0x75f.GetListReq();
  public cmd0x75f.GetOneReq msg_get_one_req = new cmd0x75f.GetOneReq();
  public cmd0x75f.UpdateReq msg_update_req = new cmd0x75f.UpdateReq();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x75f.cmd0x75f.ReqBody
 * JD-Core Version:    0.7.0.1
 */