package tencent.im.oidb.jump_url_check;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class jump_url_check$ActivityInfo
  extends MessageMicro<ActivityInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "item_pkg_name", "item_name" }, new Object[] { "", "" }, ActivityInfo.class);
  public final PBStringField item_name = PBField.initString("");
  public final PBStringField item_pkg_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.jump_url_check.jump_url_check.ActivityInfo
 * JD-Core Version:    0.7.0.1
 */