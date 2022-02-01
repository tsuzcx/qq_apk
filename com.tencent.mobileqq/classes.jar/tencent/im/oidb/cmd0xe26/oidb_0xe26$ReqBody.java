package tencent.im.oidb.cmd0xe26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe26$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_req_source", "clientInfo" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
  public final PBRepeatMessageField<oidb_0xe26.ClientInfo> clientInfo = PBField.initRepeatMessage(oidb_0xe26.ClientInfo.class);
  public final PBUInt32Field uint32_req_source = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe26.oidb_0xe26.ReqBody
 * JD-Core Version:    0.7.0.1
 */