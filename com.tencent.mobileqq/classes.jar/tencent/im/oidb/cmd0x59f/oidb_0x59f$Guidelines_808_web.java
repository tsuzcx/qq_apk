package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x59f$Guidelines_808_web
  extends MessageMicro<Guidelines_808_web>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_friends_recomm_flag", "uint32_groups_recomm_flag", "str_web_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, Guidelines_808_web.class);
  public final PBStringField str_web_url = PBField.initString("");
  public final PBUInt32Field uint32_friends_recomm_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_groups_recomm_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_808_web
 * JD-Core Version:    0.7.0.1
 */