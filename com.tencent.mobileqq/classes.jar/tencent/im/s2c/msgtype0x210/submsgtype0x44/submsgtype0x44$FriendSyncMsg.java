package tencent.im.s2c.msgtype0x210.submsgtype0x44;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x44$FriendSyncMsg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "uint64_uin", "uint64_fuin", "uint32_processtype", "uint32_time", "uint32_processflag", "uint32_sourceid", "uint32_sourcesubid", "rpt_str_wording" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, FriendSyncMsg.class);
  public final PBRepeatField rpt_str_wording = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field uint32_processflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_processtype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sourceid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sourcesubid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_fuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.FriendSyncMsg
 * JD-Core Version:    0.7.0.1
 */