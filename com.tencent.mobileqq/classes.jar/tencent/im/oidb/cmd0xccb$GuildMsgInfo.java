package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xccb$GuildMsgInfo
  extends MessageMicro<GuildMsgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "msg_seq", "roam_flag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, GuildMsgInfo.class);
  public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
  public final PBUInt32Field roam_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xccb.GuildMsgInfo
 * JD-Core Version:    0.7.0.1
 */