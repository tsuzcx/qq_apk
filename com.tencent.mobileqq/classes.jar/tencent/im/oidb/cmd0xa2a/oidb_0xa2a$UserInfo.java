package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa2a$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField distance = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBUInt32Field score = PBField.initUInt32(0);
  public final PBStringField tag = PBField.initString("");
  public final PBUInt32Field tag_color = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48 }, new String[] { "uin", "nick", "tag", "tag_color", "distance", "score" }, new Object[] { Long.valueOf(0L), "", "", localInteger, "", localInteger }, UserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa2a.oidb_0xa2a.UserInfo
 * JD-Core Version:    0.7.0.1
 */