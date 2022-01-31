package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class faceroam_sso$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "comm", "uint64_uin", "uint32_sub_cmd", "reqcmd_0x01", "reqcmd_0x02" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), null, null }, ReqBody.class);
  public faceroam_sso.PlatInfo comm = new faceroam_sso.PlatInfo();
  public faceroam_sso.ReqUserInfo reqcmd_0x01 = new faceroam_sso.ReqUserInfo();
  public faceroam_sso.ReqDeleteItem reqcmd_0x02 = new faceroam_sso.ReqDeleteItem();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.faceroam_sso.faceroam_sso.ReqBody
 * JD-Core Version:    0.7.0.1
 */