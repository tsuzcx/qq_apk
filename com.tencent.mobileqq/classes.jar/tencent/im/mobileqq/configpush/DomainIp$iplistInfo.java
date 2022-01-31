package tencent.im.mobileqq.configpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DomainIp$iplistInfo
  extends MessageMicro<iplistInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "int32_result", "string_dname", "uint32_type", "uint32_ttl", "ServerList_data" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), null }, iplistInfo.class);
  public final PBRepeatMessageField<DomainIp.ServerList> ServerList_data = PBField.initRepeatMessage(DomainIp.ServerList.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBStringField string_dname = PBField.initString("");
  public final PBUInt32Field uint32_ttl = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.mobileqq.configpush.DomainIp.iplistInfo
 * JD-Core Version:    0.7.0.1
 */