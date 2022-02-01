package tencent.im.oidb.cmd0xaee;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xaee$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "group_code", "list_req", "admin_req" }, new Object[] { Long.valueOf(0L), null, null }, ReqBody.class);
  public Oidb_0xaee.AdminReq admin_req = new Oidb_0xaee.AdminReq();
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public Oidb_0xaee.ListReq list_req = new Oidb_0xaee.ListReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaee.Oidb_0xaee.ReqBody
 * JD-Core Version:    0.7.0.1
 */