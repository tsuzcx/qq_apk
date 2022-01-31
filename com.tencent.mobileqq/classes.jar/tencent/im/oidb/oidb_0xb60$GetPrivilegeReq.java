package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb60$GetPrivilegeReq
  extends MessageMicro<GetPrivilegeReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "appid", "app_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(3) }, GetPrivilegeReq.class);
  public final PBUInt32Field app_type = PBField.initUInt32(3);
  public final PBUInt32Field appid = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb60.GetPrivilegeReq
 * JD-Core Version:    0.7.0.1
 */