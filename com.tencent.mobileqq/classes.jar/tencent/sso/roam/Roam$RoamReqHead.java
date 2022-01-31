package tencent.sso.roam;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Roam$RoamReqHead
  extends MessageMicro<RoamReqHead>
{
  public static final int CLIENT_PLAT_ID_FIELD_NUMBER = 2;
  public static final int CLIENT_VER_FIELD_NUMBER = 3;
  public static final int OS_VER_FIELD_NUMBER = 4;
  public static final int PROTOCOL_VER_FIELD_NUMBER = 1;
  public static final int UIN_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "protocol_ver", "client_plat_id", "client_ver", "os_ver", "uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Long.valueOf(0L) }, RoamReqHead.class);
  public final PBInt32Field client_plat_id = PBField.initInt32(0);
  public final PBStringField client_ver = PBField.initString("");
  public final PBStringField os_ver = PBField.initString("");
  public final PBInt32Field protocol_ver = PBField.initInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.sso.roam.Roam.RoamReqHead
 * JD-Core Version:    0.7.0.1
 */