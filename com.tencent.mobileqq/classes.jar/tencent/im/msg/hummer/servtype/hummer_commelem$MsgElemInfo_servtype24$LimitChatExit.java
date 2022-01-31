package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hummer_commelem$MsgElemInfo_servtype24$LimitChatExit
  extends MessageMicro<LimitChatExit>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_exit_method", "uint64_match_ts" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, LimitChatExit.class);
  public final PBUInt32Field uint32_exit_method = PBField.initUInt32(0);
  public final PBUInt64Field uint64_match_ts = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatExit
 * JD-Core Version:    0.7.0.1
 */