package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGetRsp$AdInfo$AppChannelInfo
  extends MessageMicro<AppChannelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50 }, new String[] { "author_name", "package_size_bytes", "version_name", "permissions_url", "privacy_agreement_url", "app_name" }, new Object[] { "", Long.valueOf(0L), "", "", "", "" }, AppChannelInfo.class);
  public final PBStringField app_name = PBField.initString("");
  public final PBStringField author_name = PBField.initString("");
  public final PBInt64Field package_size_bytes = PBField.initInt64(0L);
  public final PBStringField permissions_url = PBField.initString("");
  public final PBStringField privacy_agreement_url = PBField.initString("");
  public final PBStringField version_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppChannelInfo
 * JD-Core Version:    0.7.0.1
 */