package tencent.im.oidb.cmd0x9db;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x9db$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int RPT_UINT64_ID_FIELD_NUMBER = 2;
  public static final int UINT32_SEQUENCE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_sequence", "rpt_uint64_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, ReqBody.class);
  public final PBRepeatField<Long> rpt_uint64_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9db.cmd0x9db.ReqBody
 * JD-Core Version:    0.7.0.1
 */