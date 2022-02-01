package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class qq_ad_get$QQAdGet$VersionInfo
  extends MessageMicro<VersionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField support_c2s = PBField.initBool(false);
  public final PBBoolField support_dpa = PBField.initBool(false);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "support_c2s", "support_dpa" }, new Object[] { localBoolean, localBoolean }, VersionInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.VersionInfo
 * JD-Core Version:    0.7.0.1
 */