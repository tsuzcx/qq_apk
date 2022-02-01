package tencent.im.group_pro_proto.group_pro.comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msgTransData$ClientIdentity
  extends MessageMicro<ClientIdentity>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "client_id", "desc" }, new Object[] { Integer.valueOf(0), "" }, ClientIdentity.class);
  public final PBUInt32Field client_id = PBField.initUInt32(0);
  public final PBStringField desc = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.group_pro.comm.msgTransData.ClientIdentity
 * JD-Core Version:    0.7.0.1
 */