package tencent.im.mobileqq.configpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DomainIp$SubCmd_name_Rsp
  extends MessageMicro<SubCmd_name_Rsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<DomainIp.iplistInfo> iplistInfo = PBField.initRepeatMessage(DomainIp.iplistInfo.class);
  public final PBRepeatMessageField<DomainIp.iplistInfo> iplistInfoV6 = PBField.initRepeatMessage(DomainIp.iplistInfo.class);
  public final PBUInt32Field uint32_qq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uip = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_uip", "uint32_qq", "iplistInfo", "iplistInfoV6" }, new Object[] { localInteger, localInteger, null, null }, SubCmd_name_Rsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.mobileqq.configpush.DomainIp.SubCmd_name_Rsp
 * JD-Core Version:    0.7.0.1
 */