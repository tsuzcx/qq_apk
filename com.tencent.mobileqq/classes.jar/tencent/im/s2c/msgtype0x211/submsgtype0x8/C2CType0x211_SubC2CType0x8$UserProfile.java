package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class C2CType0x211_SubC2CType0x8$UserProfile
  extends MessageMicro<UserProfile>
{
  public static final int BYTES_EXTRA_FIELD_NUMBER = 11;
  public static final int BYTES_TIP_FIELD_NUMBER = 10;
  public static final int BYTES_TMP_TALK_SIG_FIELD_NUMBER = 6;
  public static final int INT32_AGE_FIELD_NUMBER = 4;
  public static final int INT32_FACE_ID_FIELD_NUMBER = 2;
  public static final int INT32_IP_FIELD_NUMBER = 8;
  public static final int INT32_PORT_FIELD_NUMBER = 9;
  public static final int INT32_SEX_FIELD_NUMBER = 3;
  public static final int MSG_RESULT_FIELD_NUMBER = 7;
  public static final int STR_NICK_FIELD_NUMBER = 5;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_extra = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tip = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tmp_talk_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_age = PBField.initInt32(0);
  public final PBInt32Field int32_face_id = PBField.initInt32(0);
  public final PBInt32Field int32_ip = PBField.initInt32(0);
  public final PBInt32Field int32_port = PBField.initInt32(0);
  public final PBInt32Field int32_sex = PBField.initInt32(0);
  public C2CType0x211_SubC2CType0x8.JudgeResult msg_result = new C2CType0x211_SubC2CType0x8.JudgeResult();
  public final PBStringField str_nick = PBField.initString("");
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 64, 72, 82, 90 }, new String[] { "uint64_uin", "int32_face_id", "int32_sex", "int32_age", "str_nick", "bytes_tmp_talk_sig", "msg_result", "int32_ip", "int32_port", "bytes_tip", "bytes_extra" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro1, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, UserProfile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.UserProfile
 * JD-Core Version:    0.7.0.1
 */