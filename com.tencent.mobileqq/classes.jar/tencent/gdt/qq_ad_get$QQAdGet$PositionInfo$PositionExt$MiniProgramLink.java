package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGet$PositionInfo$PositionExt$MiniProgramLink
  extends MessageMicro<MiniProgramLink>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "app_id", "page_path", "schema_link", "user_name" }, new Object[] { "", "", "", "" }, MiniProgramLink.class);
  public final PBStringField app_id = PBField.initString("");
  public final PBStringField page_path = PBField.initString("");
  public final PBStringField schema_link = PBField.initString("");
  public final PBStringField user_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.MiniProgramLink
 * JD-Core Version:    0.7.0.1
 */