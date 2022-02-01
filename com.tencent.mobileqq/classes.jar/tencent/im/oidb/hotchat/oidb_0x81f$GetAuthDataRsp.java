package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x81f$GetAuthDataRsp
  extends MessageMicro<GetAuthDataRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_auth", "rpt_msg_accu_data", "uint64_timestamp" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, GetAuthDataRsp.class);
  public final PBRepeatMessageField<oidb_0x81f.AccuData> rpt_msg_accu_data = PBField.initRepeatMessage(oidb_0x81f.AccuData.class);
  public final PBUInt32Field uint32_auth = PBField.initUInt32(0);
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0x81f.GetAuthDataRsp
 * JD-Core Version:    0.7.0.1
 */