package tencent.im.mobileqq.configpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DomainIp$SubCmd_name_Req
  extends MessageMicro<SubCmd_name_Req>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<DomainIp.dnameInfo> dnameInfo = PBField.initRepeatMessage(DomainIp.dnameInfo.class);
  public final PBUInt32Field uint32_qq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uip = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_uip", "uint32_qq", "dnameInfo" }, new Object[] { localInteger, localInteger, null }, SubCmd_name_Req.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.mobileqq.configpush.DomainIp.SubCmd_name_Req
 * JD-Core Version:    0.7.0.1
 */