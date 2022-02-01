package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqconnect$MobileAppInfo
  extends MessageMicro<MobileAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98 }, new String[] { "android_app_info", "ios_app_info" }, new Object[] { null, null }, MobileAppInfo.class);
  public final PBRepeatMessageField<qqconnect.AndroidAppInfo> android_app_info = PBField.initRepeatMessage(qqconnect.AndroidAppInfo.class);
  public final PBRepeatMessageField<qqconnect.IOSAppInfo> ios_app_info = PBField.initRepeatMessage(qqconnect.IOSAppInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.qqconnect.MobileAppInfo
 * JD-Core Version:    0.7.0.1
 */