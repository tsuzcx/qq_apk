package tencent.im.mobileqq.mobroute;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DomainIp$MobRouteSSOList
  extends MessageMicro<MobRouteSSOList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_timeout", "vec_tcplist", "vec_httplist" }, new Object[] { Integer.valueOf(0), null, null }, MobRouteSSOList.class);
  public final PBUInt32Field uint32_timeout = PBField.initUInt32(0);
  public final PBRepeatMessageField<DomainIp.MobRouteSSOListInfo> vec_httplist = PBField.initRepeatMessage(DomainIp.MobRouteSSOListInfo.class);
  public final PBRepeatMessageField<DomainIp.MobRouteSSOListInfo> vec_tcplist = PBField.initRepeatMessage(DomainIp.MobRouteSSOListInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.mobileqq.mobroute.DomainIp.MobRouteSSOList
 * JD-Core Version:    0.7.0.1
 */