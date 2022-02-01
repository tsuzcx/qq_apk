package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class articlesummary$PackJumpInfo
  extends MessageMicro<PackJumpInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "enum_style", "str_wording", "str_url" }, new Object[] { Integer.valueOf(1), "", "" }, PackJumpInfo.class);
  public final PBEnumField enum_style = PBField.initEnum(1);
  public final PBStringField str_url = PBField.initString("");
  public final PBStringField str_wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo
 * JD-Core Version:    0.7.0.1
 */