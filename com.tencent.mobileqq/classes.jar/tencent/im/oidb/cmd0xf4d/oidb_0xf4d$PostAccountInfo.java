package tencent.im.oidb.cmd0xf4d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xf4d$PostAccountInfo
  extends MessageMicro<PostAccountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "uin", "uin_source", "nick_name", "avatar_url" }, new Object[] { "", Integer.valueOf(0), "", "" }, PostAccountInfo.class);
  public final PBStringField avatar_url = PBField.initString("");
  public final PBStringField nick_name = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
  public final PBUInt32Field uin_source = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf4d.oidb_0xf4d.PostAccountInfo
 * JD-Core Version:    0.7.0.1
 */