package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class subcmd0x51b$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_cmd", "msg_get_single_roam_msg_rep", "msg_get_single_cluster_msg_rep", "msg_del_single_cluster_msg_rep" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
  public final PBInt32Field int32_cmd = PBField.initInt32(0);
  public subcmd0x51b.DelSingleClusterMsgRsp msg_del_single_cluster_msg_rep = new subcmd0x51b.DelSingleClusterMsgRsp();
  public subcmd0x51b.GetSingleClusterMsgRsp msg_get_single_cluster_msg_rep = new subcmd0x51b.GetSingleClusterMsgRsp();
  public subcmd0x51b.GetSingleRoamMsgRsp msg_get_single_roam_msg_rep = new subcmd0x51b.GetSingleRoamMsgRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x51b.RspBody
 * JD-Core Version:    0.7.0.1
 */