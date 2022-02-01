package tencent.im.oidb.cmd0x75f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x75f$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66 }, new String[] { "uint64_appid", "uint32_subcmd", "msg_add_rsp", "msg_delete_rsp", "msg_get_list_rsp", "msg_update_rsp", "msg_get_one_rsp", "msg_add_batch_rsp" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null, null, null, null, null }, RspBody.class);
  public cmd0x75f.AddBatchRsp msg_add_batch_rsp = new cmd0x75f.AddBatchRsp();
  public cmd0x75f.AddRsp msg_add_rsp = new cmd0x75f.AddRsp();
  public cmd0x75f.DeleteRsp msg_delete_rsp = new cmd0x75f.DeleteRsp();
  public cmd0x75f.GetListRsp msg_get_list_rsp = new cmd0x75f.GetListRsp();
  public cmd0x75f.GetOneRsp msg_get_one_rsp = new cmd0x75f.GetOneRsp();
  public cmd0x75f.UpdateRsp msg_update_rsp = new cmd0x75f.UpdateRsp();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x75f.cmd0x75f.RspBody
 * JD-Core Version:    0.7.0.1
 */