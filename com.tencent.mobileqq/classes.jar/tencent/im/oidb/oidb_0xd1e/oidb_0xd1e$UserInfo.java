package tencent.im.oidb.oidb_0xd1e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd1e$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField app_id = PBField.initString("");
  public final PBUInt32Field is_majia_number = PBField.initUInt32(0);
  public final PBStringField open_id = PBField.initString("");
  public final PBUInt32Field user_type = PBField.initUInt32(0);
  public final PBStringField wns_id = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "app_id", "open_id", "wns_id", "is_majia_number", "user_type" }, new Object[] { "", "", "", localInteger, localInteger }, UserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.UserInfo
 * JD-Core Version:    0.7.0.1
 */