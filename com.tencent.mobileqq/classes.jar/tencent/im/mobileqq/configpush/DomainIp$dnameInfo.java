package tencent.im.mobileqq.configpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DomainIp$dnameInfo
  extends MessageMicro<dnameInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 24 }, new String[] { "string_dname", "uint32_type" }, new Object[] { "", Integer.valueOf(0) }, dnameInfo.class);
  public final PBStringField string_dname = PBField.initString("");
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.mobileqq.configpush.DomainIp.dnameInfo
 * JD-Core Version:    0.7.0.1
 */