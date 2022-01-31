package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeiyunPB$PicVideo2QcloudItem
  extends MessageMicro
{
  public static final int BOOL_AUTO_CREATE_USER_FIELD_NUMBER = 8;
  public static final int IMAGE_TYPE_FIELD_NUMBER = 13;
  public static final int RAW_URL_FIELD_NUMBER = 12;
  public static final int STR_DST_ID_FIELD_NUMBER = 2;
  public static final int STR_FILE_ID_FIELD_NUMBER = 5;
  public static final int STR_FILE_MD5_FIELD_NUMBER = 11;
  public static final int STR_FILE_NAME_FIELD_NUMBER = 9;
  public static final int STR_SRC_ID_FIELD_NUMBER = 1;
  public static final int UINT32_BID_FIELD_NUMBER = 4;
  public static final int UINT32_CHAT_TYPE_FIELD_NUMBER = 3;
  public static final int UINT32_USER_TYPE_FIELD_NUMBER = 10;
  public static final int UINT64_FILE_ID_FIELD_NUMBER = 6;
  public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 56, 64, 74, 80, 90, 98, 104 }, new String[] { "str_src_id", "str_dst_id", "uint32_chat_type", "uint32_bid", "str_file_id", "uint64_file_id", "uint64_file_size", "bool_auto_create_user", "str_file_name", "uint32_user_type", "str_file_md5", "raw_url", "image_type" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(true), "", Integer.valueOf(0), "", "", Integer.valueOf(0) }, PicVideo2QcloudItem.class);
  public final PBBoolField bool_auto_create_user = PBField.initBool(true);
  public final PBInt32Field image_type = PBField.initInt32(0);
  public final PBStringField raw_url = PBField.initString("");
  public final PBStringField str_dst_id = PBField.initString("");
  public final PBStringField str_file_id = PBField.initString("");
  public final PBStringField str_file_md5 = PBField.initString("");
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_src_id = PBField.initString("");
  public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.PicVideo2QcloudItem
 * JD-Core Version:    0.7.0.1
 */