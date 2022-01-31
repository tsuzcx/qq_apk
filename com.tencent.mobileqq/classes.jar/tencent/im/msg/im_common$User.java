package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_common$User
  extends MessageMicro<User>
{
  public static final int APP_ID_FIELD_NUMBER = 2;
  public static final int APP_TYPE_FIELD_NUMBER = 4;
  public static final int CLIENT_IP_FIELD_NUMBER = 5;
  public static final int EQUIP_KEY_FIELD_NUMBER = 10;
  public static final int INSTANCE_ID_FIELD_NUMBER = 3;
  public static final int LANGUAGE_FIELD_NUMBER = 9;
  public static final int PLATFORM_ID_FIELD_NUMBER = 8;
  public static final int STR_PHONE_NUMBER_FIELD_NUMBER = 7;
  public static final int UIN_FIELD_NUMBER = 1;
  public static final int VERSION_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field app_id = PBField.initUInt32(0);
  public final PBUInt32Field app_type = PBField.initUInt32(0);
  public final PBFixed32Field client_ip = PBField.initFixed32(0);
  public final PBBytesField equip_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field instance_id = PBField.initUInt32(0);
  public final PBUInt32Field language = PBField.initUInt32(0);
  public final PBUInt32Field platform_id = PBField.initUInt32(0);
  public final PBStringField str_phone_number = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 45, 48, 58, 64, 72, 82 }, new String[] { "uin", "app_id", "instance_id", "app_type", "client_ip", "version", "str_phone_number", "platform_id", "language", "equip_key" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, User.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_common.User
 * JD-Core Version:    0.7.0.1
 */