package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc46$UserIdentityIcon
  extends MessageMicro<UserIdentityIcon>
{
  public static final int Certified = 1;
  public static final int UPOwner = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "identity_type", "icon_url", "summary" }, new Object[] { Integer.valueOf(0), "", "" }, UserIdentityIcon.class);
  public final PBStringField icon_url = PBField.initString("");
  public final PBUInt32Field identity_type = PBField.initUInt32(0);
  public final PBStringField summary = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.UserIdentityIcon
 * JD-Core Version:    0.7.0.1
 */