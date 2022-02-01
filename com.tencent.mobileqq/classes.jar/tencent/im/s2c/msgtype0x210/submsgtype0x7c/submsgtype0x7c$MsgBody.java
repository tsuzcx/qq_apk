package tencent.im.s2c.msgtype0x210.submsgtype0x7c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x7c$MsgBody
  extends MessageMicro<MsgBody>
{
  public static final int INT32_CMD_FIELD_NUMBER = 2;
  public static final int RPT_STRING_CMD_EXT_FIELD_NUMBER = 3;
  public static final int RPT_STRING_SEQ_EXT_FIELD_NUMBER = 5;
  public static final int UINT64_SEQ_FIELD_NUMBER = 4;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_cmd = PBField.initInt32(0);
  public final PBRepeatField<String> rpt_string_cmd_ext = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> rpt_string_seq_ext = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "uint64_uin", "int32_cmd", "rpt_string_cmd_ext", "uint64_seq", "rpt_string_seq_ext" }, new Object[] { localLong, Integer.valueOf(0), "", localLong, "" }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x7c.submsgtype0x7c.MsgBody
 * JD-Core Version:    0.7.0.1
 */