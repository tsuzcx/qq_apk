package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class faceroam_sso$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "ret", "errmsg", "sub_cmd", "rspcmd_0x01", "rspcmd_0x02" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), null, null }, RspBody.class);
  public final PBStringField errmsg = PBField.initString("");
  public final PBInt64Field ret = PBField.initInt64(0L);
  public faceroam_sso.RspUserInfo rspcmd_0x01 = new faceroam_sso.RspUserInfo();
  public faceroam_sso.RspDeleteItem rspcmd_0x02 = new faceroam_sso.RspDeleteItem();
  public final PBUInt32Field sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.faceroam_sso.faceroam_sso.RspBody
 * JD-Core Version:    0.7.0.1
 */