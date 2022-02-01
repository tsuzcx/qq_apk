package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGet$QQPublicCategoryInfo
  extends MessageMicro<QQPublicCategoryInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "qq_public_category_id", "qq_public_category_level" }, new Object[] { "", Integer.valueOf(0) }, QQPublicCategoryInfo.class);
  public final PBStringField qq_public_category_id = PBField.initString("");
  public final PBUInt32Field qq_public_category_level = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.QQPublicCategoryInfo
 * JD-Core Version:    0.7.0.1
 */