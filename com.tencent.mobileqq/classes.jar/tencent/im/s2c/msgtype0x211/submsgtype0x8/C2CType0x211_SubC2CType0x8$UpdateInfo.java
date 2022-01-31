package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class C2CType0x211_SubC2CType0x8$UpdateInfo
  extends MessageMicro
{
  public static final int MSG_USER_FIELD_NUMBER = 2;
  public static final int TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "msg_user" }, new Object[] { Integer.valueOf(1), null }, UpdateInfo.class);
  public C2CType0x211_SubC2CType0x8.UserProfile msg_user = new C2CType0x211_SubC2CType0x8.UserProfile();
  public final PBEnumField type = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.UpdateInfo
 * JD-Core Version:    0.7.0.1
 */