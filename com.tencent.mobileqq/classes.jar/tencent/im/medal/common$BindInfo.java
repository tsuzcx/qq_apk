package tencent.im.medal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class common$BindInfo
  extends MessageMicro<BindInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint64_fri_uin", "str_fri_nick", "uint64_time", "uint32_bind_status" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), Integer.valueOf(0) }, BindInfo.class);
  public final PBStringField str_fri_nick = PBField.initString("");
  public final PBUInt32Field uint32_bind_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_fri_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.medal.common.BindInfo
 * JD-Core Version:    0.7.0.1
 */