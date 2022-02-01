package tencent.im.oidb.cmd0xf4d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xf4d$PostAccountInfo
  extends MessageMicro<PostAccountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField avatar_url = PBField.initString("");
  public final PBUInt32Field identity_status = PBField.initUInt32(0);
  public final PBStringField nick_name = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
  public final PBUInt32Field uin_source = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40 }, new String[] { "uin", "uin_source", "nick_name", "avatar_url", "identity_status" }, new Object[] { "", localInteger, "", "", localInteger }, PostAccountInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf4d.oidb_0xf4d.PostAccountInfo
 * JD-Core Version:    0.7.0.1
 */