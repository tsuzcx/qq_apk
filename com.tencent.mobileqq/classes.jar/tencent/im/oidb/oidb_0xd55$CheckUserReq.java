package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd55$CheckUserReq
  extends MessageMicro<CheckUserReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "openid", "need_check_same_user" }, new Object[] { "", Integer.valueOf(0) }, CheckUserReq.class);
  public final PBUInt32Field need_check_same_user = PBField.initUInt32(0);
  public final PBStringField openid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd55.CheckUserReq
 * JD-Core Version:    0.7.0.1
 */