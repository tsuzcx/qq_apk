package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x7$MsgBody$ProgressReq
  extends MessageMicro
{
  public static final int ProgressReq_Falg_All = 65535;
  public static final int ProgressReq_Falg_AllSession = 16;
  public static final int ProgressReq_Falg_FileName = 2;
  public static final int ProgressReq_Falg_FileSize = 1;
  public static final int ProgressReq_Falg_Time = 4;
  public static final int ProgressReq_Falg_UpdateSession = 32;
  public static final int ProgressReq_QueryInfo = 1;
  public static final int ProgressReq_QueryList = 0;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_cmd", "uint64_cookie", "uint32_infoflag", "rpt_uint64_sessionid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, ProgressReq.class);
  public final PBRepeatField rpt_uint64_sessionid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_infoflag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_cookie = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.ProgressReq
 * JD-Core Version:    0.7.0.1
 */