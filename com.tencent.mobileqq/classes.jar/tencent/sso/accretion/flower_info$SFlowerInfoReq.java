package tencent.sso.accretion;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class flower_info$SFlowerInfoReq
  extends MessageMicro<SFlowerInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50 }, new String[] { "uin", "queryuin", "version", "platform", "type", "key" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "5.4.0", Integer.valueOf(0), Integer.valueOf(0), "" }, SFlowerInfoReq.class);
  public final PBStringField key = PBField.initString("");
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBUInt64Field queryuin = PBField.initUInt64(0L);
  public final PBEnumField type = PBField.initEnum(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBStringField version = PBField.initString("5.4.0");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.sso.accretion.flower_info.SFlowerInfoReq
 * JD-Core Version:    0.7.0.1
 */