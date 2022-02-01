package tencent.im.oidb.cmd0xf8c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xf8c$MaterialInfo
  extends MessageMicro<MaterialInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField ChecksumMd5 = PBField.initString("");
  public final PBStringField ChecksumMd5High = PBField.initString("");
  public final PBStringField ChecksumMd5Low = PBField.initString("");
  public final PBStringField ChecksumMd5Mid = PBField.initString("");
  public final PBStringField ChecksumMd5Superlow = PBField.initString("");
  public final PBRepeatMessageField<oidb_cmd0xf8c.MapDynamicFields> DynamicFields = PBField.initRepeatMessage(oidb_cmd0xf8c.MapDynamicFields.class);
  public final PBInt32Field ID = PBField.initInt32(0);
  public final PBStringField Name = PBField.initString("");
  public final PBStringField PackageURL = PBField.initString("");
  public final PBStringField PackageURLHigh = PBField.initString("");
  public final PBStringField PackageURLLow = PBField.initString("");
  public final PBStringField PackageURLMid = PBField.initString("");
  public final PBStringField PackageUrlSuperlow = PBField.initString("");
  public final PBStringField SdkVersion = PBField.initString("");
  public final PBInt32Field ThumbHeight = PBField.initInt32(0);
  public final PBStringField ThumbURL = PBField.initString("");
  public final PBInt32Field ThumbWidth = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138 }, new String[] { "ID", "Name", "SdkVersion", "ThumbURL", "ThumbWidth", "ThumbHeight", "PackageURL", "ChecksumMd5", "PackageURLHigh", "ChecksumMd5High", "PackageURLMid", "ChecksumMd5Mid", "PackageURLLow", "ChecksumMd5Low", "PackageUrlSuperlow", "ChecksumMd5Superlow", "DynamicFields" }, new Object[] { localInteger, "", "", "", localInteger, localInteger, "", "", "", "", "", "", "", "", "", "", null }, MaterialInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c.MaterialInfo
 * JD-Core Version:    0.7.0.1
 */