package tencent.im.oidb.oidb_comment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_comment$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "app_id", "open_id", "wns_id", "is_majia_number" }, new Object[] { "", "", "", Integer.valueOf(0) }, UserInfo.class);
  public final PBStringField app_id = PBField.initString("");
  public final PBUInt32Field is_majia_number = PBField.initUInt32(0);
  public final PBStringField open_id = PBField.initString("");
  public final PBStringField wns_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_comment.oidb_comment.UserInfo
 * JD-Core Version:    0.7.0.1
 */