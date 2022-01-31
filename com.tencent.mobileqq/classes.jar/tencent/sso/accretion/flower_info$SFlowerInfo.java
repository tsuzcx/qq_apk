package tencent.sso.accretion;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class flower_info$SFlowerInfo
  extends MessageMicro<SFlowerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "send_uin", "recv_uin", "flower_url", "num" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0) }, SFlowerInfo.class);
  public final PBStringField flower_url = PBField.initString("");
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBUInt64Field recv_uin = PBField.initUInt64(0L);
  public final PBUInt64Field send_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.sso.accretion.flower_info.SFlowerInfo
 * JD-Core Version:    0.7.0.1
 */