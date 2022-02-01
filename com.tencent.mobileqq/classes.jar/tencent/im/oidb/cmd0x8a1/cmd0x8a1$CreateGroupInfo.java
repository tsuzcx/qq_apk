package tencent.im.oidb.cmd0x8a1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x8a1$CreateGroupInfo
  extends MessageMicro<CreateGroupInfo>
{
  public static final int MSG_CLIENT_INFO_FIELD_NUMBER = 19;
  public static final int MSG_GROUP_GEO_INFO_FIELD_NUMBER = 20;
  public static final int STRING_ANSWER_FIELD_NUMBER = 17;
  public static final int STRING_GROUP_FINGER_MEMO_FIELD_NUMBER = 14;
  public static final int STRING_GROUP_MEMO_FIELD_NUMBER = 13;
  public static final int STRING_GROUP_NAME_FIELD_NUMBER = 10;
  public static final int STRING_GROUP_RICH_FINGER_MEMO_FIELD_NUMBER = 15;
  public static final int STRING_QUESTION_FIELD_NUMBER = 16;
  public static final int STRING_SIGN_FIELD_NUMBER = 18;
  public static final int UINT32_APP_ID_FIELD_NUMBER = 7;
  public static final int UINT32_CHECK_LIMIT_FLAG_FIELD_NUMBER = 12;
  public static final int UINT32_CONF_UIN_FIELD_NUMBER = 11;
  public static final int UINT32_GROUP_CLASS_EXT_FIELD_NUMBER = 5;
  public static final int UINT32_GROUP_CLASS_FIELD_NUMBER = 4;
  public static final int UINT32_GROUP_CODE_FIELD_NUMBER = 1;
  public static final int UINT32_GROUP_FACE_FIELD_NUMBER = 6;
  public static final int UINT32_GROUP_FACE_FLAG_FIELD_NUMBER = 22;
  public static final int UINT32_GROUP_OPTION_FIELD_NUMBER = 3;
  public static final int UINT32_GROUP_SIZE_FIELD_NUMBER = 8;
  public static final int UINT32_GROUP_TYPE_FLAG_FIELD_NUMBER = 21;
  public static final int UINT64_CREATE_FLAG_FIELD_NUMBER = 9;
  public static final int UINT64_OWNER_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public cmd0x8a1.ClientInfo msg_client_info = new cmd0x8a1.ClientInfo();
  public cmd0x8a1.GroupGeoInfo msg_group_geo_info = new cmd0x8a1.GroupGeoInfo();
  public final PBBytesField string_answer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_rich_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_question = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_sign = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_check_limit_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_conf_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_class = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_class_ext = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_face = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_face_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_option = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_type_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_create_flag = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 88, 96, 106, 114, 122, 130, 138, 146, 154, 162, 168, 176 }, new String[] { "uint32_group_code", "uint64_owner_uin", "uint32_group_option", "uint32_group_class", "uint32_group_class_ext", "uint32_group_face", "uint32_app_id", "uint32_group_size", "uint64_create_flag", "string_group_name", "uint32_conf_uin", "uint32_check_limit_flag", "string_group_memo", "string_group_finger_memo", "string_group_rich_finger_memo", "string_question", "string_answer", "string_sign", "msg_client_info", "msg_group_geo_info", "uint32_group_type_flag", "uint32_group_face_flag" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, null, null, Integer.valueOf(0), Integer.valueOf(0) }, CreateGroupInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8a1.cmd0x8a1.CreateGroupInfo
 * JD-Core Version:    0.7.0.1
 */