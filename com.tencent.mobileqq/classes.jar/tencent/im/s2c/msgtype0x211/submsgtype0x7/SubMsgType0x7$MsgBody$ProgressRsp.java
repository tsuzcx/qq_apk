package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x7$MsgBody$ProgressRsp
  extends MessageMicro<ProgressRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint32_cmd", "uint64_cookie", "uint32_package_count", "uint32_package_index", "rpt_msg_progressinfo" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null }, ProgressRsp.class);
  public final PBRepeatMessageField<SubMsgType0x7.MsgBody.ProgressRsp.ProgressInfo> rpt_msg_progressinfo = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.ProgressRsp.ProgressInfo.class);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_package_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_package_index = PBField.initUInt32(0);
  public final PBUInt64Field uint64_cookie = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.ProgressRsp
 * JD-Core Version:    0.7.0.1
 */