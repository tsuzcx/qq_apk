package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqconnect$MobileAppInfo
  extends MessageMicro<MobileAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 106, 112, 122, 130, 138, 146 }, new String[] { "android_app_info", "ios_app_info", "face_info", "universal_link_allow_time", "callback_url", "callback_addr", "callback_url_test", "callback_addr_test" }, new Object[] { null, null, null, Long.valueOf(0L), "", "", "", "" }, MobileAppInfo.class);
  public final PBRepeatMessageField<qqconnect.AndroidAppInfo> android_app_info = PBField.initRepeatMessage(qqconnect.AndroidAppInfo.class);
  public final PBStringField callback_addr = PBField.initString("");
  public final PBStringField callback_addr_test = PBField.initString("");
  public final PBStringField callback_url = PBField.initString("");
  public final PBStringField callback_url_test = PBField.initString("");
  public qqconnect.FaceInfo face_info = new qqconnect.FaceInfo();
  public final PBRepeatMessageField<qqconnect.IOSAppInfo> ios_app_info = PBField.initRepeatMessage(qqconnect.IOSAppInfo.class);
  public final PBUInt64Field universal_link_allow_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.qqconnect.MobileAppInfo
 * JD-Core Version:    0.7.0.1
 */