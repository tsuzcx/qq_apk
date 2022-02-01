package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xc85$InteractionDetailInfo
  extends MessageMicro<InteractionDetailInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 808, 816, 824, 834, 842 }, new String[] { "uint32_continuous_record_days", "uint32_send_day_time", "uint32_recv_day_time", "str_send_record", "str_recv_record" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "" }, InteractionDetailInfo.class);
  public final PBStringField str_recv_record = PBField.initString("");
  public final PBStringField str_send_record = PBField.initString("");
  public final PBUInt32Field uint32_continuous_record_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_recv_day_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_send_day_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc85.InteractionDetailInfo
 * JD-Core Version:    0.7.0.1
 */