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
  public cmd0x8a1.TypeValues type_value_info = new cmd0x8a1.TypeValues();
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_check_limit_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_conf_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_class = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_class_ext = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_face = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_face_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_open_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_option = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_type_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_create_flag = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 88, 96, 106, 114, 122, 130, 138, 146, 154, 162, 168, 176, 186, 192 }, new String[] { "uint32_group_code", "uint64_owner_uin", "uint32_group_option", "uint32_group_class", "uint32_group_class_ext", "uint32_group_face", "uint32_app_id", "uint32_group_size", "uint64_create_flag", "string_group_name", "uint32_conf_uin", "uint32_check_limit_flag", "string_group_memo", "string_group_finger_memo", "string_group_rich_finger_memo", "string_question", "string_answer", "string_sign", "msg_client_info", "msg_group_geo_info", "uint32_group_type_flag", "uint32_group_face_flag", "type_value_info", "uint32_group_open_appid" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, Long.valueOf(0L), localByteStringMicro1, localInteger, localInteger, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, null, null, localInteger, localInteger, null, localInteger }, CreateGroupInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8a1.cmd0x8a1.CreateGroupInfo
 * JD-Core Version:    0.7.0.1
 */