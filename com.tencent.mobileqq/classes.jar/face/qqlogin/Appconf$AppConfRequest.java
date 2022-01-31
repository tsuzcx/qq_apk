package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Appconf$AppConfRequest
  extends MessageMicro<AppConfRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "AppID", "Platform", "QQVersion", "YtSDKEnv", "TmpKey" }, new Object[] { Integer.valueOf(0), "", "", "", "" }, AppConfRequest.class);
  public final PBUInt32Field AppID = PBField.initUInt32(0);
  public final PBStringField Platform = PBField.initString("");
  public final PBStringField QQVersion = PBField.initString("");
  public final PBStringField TmpKey = PBField.initString("");
  public final PBStringField YtSDKEnv = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     face.qqlogin.Appconf.AppConfRequest
 * JD-Core Version:    0.7.0.1
 */