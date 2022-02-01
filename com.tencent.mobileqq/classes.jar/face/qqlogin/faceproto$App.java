package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class faceproto$App
  extends MessageMicro<App>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "AppID", "OpenID", "Sign", "Time" }, new Object[] { Integer.valueOf(0), "", "", "" }, App.class);
  public final PBUInt32Field AppID = PBField.initUInt32(0);
  public final PBStringField OpenID = PBField.initString("");
  public final PBStringField Sign = PBField.initString("");
  public final PBStringField Time = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     face.qqlogin.faceproto.App
 * JD-Core Version:    0.7.0.1
 */