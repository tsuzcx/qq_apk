package tencent.im.longconn.longmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LongMsg$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_subcmd", "rpt_msg_up_rsp", "rpt_msg_down_rsp", "rpt_msg_del_rsp" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
  public final PBRepeatMessageField<LongMsg.MsgDeleteRsp> rpt_msg_del_rsp = PBField.initRepeatMessage(LongMsg.MsgDeleteRsp.class);
  public final PBRepeatMessageField<LongMsg.MsgDownRsp> rpt_msg_down_rsp = PBField.initRepeatMessage(LongMsg.MsgDownRsp.class);
  public final PBRepeatMessageField<LongMsg.MsgUpRsp> rpt_msg_up_rsp = PBField.initRepeatMessage(LongMsg.MsgUpRsp.class);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.longconn.longmsg.LongMsg.RspBody
 * JD-Core Version:    0.7.0.1
 */