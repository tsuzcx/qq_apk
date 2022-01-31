package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGet$ContextInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "public_id", "article_id", "tribe_tag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, ContextInfo.class);
  public final PBUInt64Field article_id = PBField.initUInt64(0L);
  public final PBUInt64Field public_id = PBField.initUInt64(0L);
  public final PBUInt32Field tribe_tag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.ContextInfo
 * JD-Core Version:    0.7.0.1
 */