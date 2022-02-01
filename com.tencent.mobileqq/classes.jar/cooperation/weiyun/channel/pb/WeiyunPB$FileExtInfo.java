package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeiyunPB$FileExtInfo
  extends MessageMicro<FileExtInfo>
{
  public static final int ALBUM_OWNER_UIN_FIELD_NUMBER = 214;
  public static final int APP_DATA_FIELD_NUMBER = 301;
  public static final int APP_NAME_FIELD_NUMBER = 6;
  public static final int BACKUP_FLAG_FIELD_NUMBER = 11;
  public static final int BATCH_ID_FIELD_NUMBER = 210;
  public static final int CAN_ACCEL_FIELD_NUMBER = 203;
  public static final int COMMENT_COUNT_FIELD_NUMBER = 215;
  public static final int COOKIE_NAME_FIELD_NUMBER = 14;
  public static final int COOKIE_VALUE_FIELD_NUMBER = 15;
  public static final int DEV_MAC_FIELD_NUMBER = 1;
  public static final int DEV_NAME_FIELD_NUMBER = 4;
  public static final int DEV_OS_FIELD_NUMBER = 5;
  public static final int DEV_SHOW_TYPE_FIELD_NUMBER = 2;
  public static final int DEV_TYPE_FIELD_NUMBER = 3;
  public static final int EVENT_ID_FIELD_NUMBER = 150;
  public static final int EXT_STATUS_FIELD_NUMBER = 20;
  public static final int FROM_SOURCE_FIELD_NUMBER = 25;
  public static final int GROUP_ID_FIELD_NUMBER = 24;
  public static final int HEIGHT_FIELD_NUMBER = 28;
  public static final int LATITUDE_FIELD_NUMBER = 23;
  public static final int LIKE_COUNT_FIELD_NUMBER = 216;
  public static final int LONGITUDE_FIELD_NUMBER = 22;
  public static final int LONG_TIME_FIELD_NUMBER = 91;
  public static final int MUSIC_DETAIL_INFO_FIELD_NUMBER = 43;
  public static final int NUMBER_FIELD_NUMBER = 211;
  public static final int ORG_FILE_SHA_FIELD_NUMBER = 30;
  public static final int ORG_FILE_SIZE_FIELD_NUMBER = 29;
  public static final int ORIENTATION_FIELD_NUMBER = 31;
  public static final int ORIGIN_PIC_SHA_FIELD_NUMBER = 52;
  public static final int OVERWRITE_FIELD_NUMBER = 501;
  public static final int OWER_INFO_FIELD_NUMBER = 801;
  public static final int TAKE_DEV_TYPE_FIELD_NUMBER = 9;
  public static final int TAKE_TIME_FIELD_NUMBER = 21;
  public static final int THUMB_URL_FIELD_NUMBER = 13;
  public static final int TOTAL_NUM_FIELD_NUMBER = 212;
  public static final int TPLINK_KEY_FIELD_NUMBER = 204;
  public static final int UPLOAD_APPID_FIELD_NUMBER = 51;
  public static final int UPLOAD_IPADDR_FIELD_NUMBER = 401;
  public static final int UPLOAD_NICKNAME_FIELD_NUMBER = 219;
  public static final int UPLOAD_UIN_FIELD_NUMBER = 213;
  public static final int WEIYUN_HOST_FIELD_NUMBER = 201;
  public static final int WEIYUN_PORT_FIELD_NUMBER = 202;
  public static final int WIDTH_FIELD_NUMBER = 27;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field album_owner_uin = PBField.initUInt64(0L);
  public final PBStringField app_data = PBField.initString("");
  public final PBStringField app_name = PBField.initString("");
  public final PBBoolField backup_flag = PBField.initBool(false);
  public final PBStringField batch_id = PBField.initString("");
  public final PBBoolField can_accel = PBField.initBool(false);
  public final PBUInt32Field comment_count = PBField.initUInt32(0);
  public final PBStringField cookie_name = PBField.initString("");
  public final PBStringField cookie_value = PBField.initString("");
  public final PBStringField dev_mac = PBField.initString("");
  public final PBStringField dev_name = PBField.initString("");
  public final PBStringField dev_os = PBField.initString("");
  public final PBInt32Field dev_show_type = PBField.initInt32(0);
  public final PBStringField dev_type = PBField.initString("");
  public final PBStringField event_id = PBField.initString("");
  public final PBInt32Field ext_status = PBField.initInt32(0);
  public final PBInt32Field from_source = PBField.initInt32(0);
  public final PBInt32Field group_id = PBField.initInt32(1);
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBUInt32Field like_count = PBField.initUInt32(0);
  public final PBInt64Field long_time = PBField.initInt64(0L);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
  public WeiyunPB.MusicDetailItem music_detail_info = new WeiyunPB.MusicDetailItem();
  public final PBUInt32Field number = PBField.initUInt32(0);
  public final PBBytesField org_file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field org_file_size = PBField.initUInt64(0L);
  public final PBUInt32Field orientation = PBField.initUInt32(0);
  public final PBBytesField origin_pic_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field overwrite = PBField.initInt32(0);
  public WeiyunPB.DirFileOwnerInfo ower_info = new WeiyunPB.DirFileOwnerInfo();
  public final PBStringField take_dev_type = PBField.initString("");
  public final PBInt64Field take_time = PBField.initInt64(0L);
  public final PBStringField thumb_url = PBField.initString("");
  public final PBUInt32Field total_num = PBField.initUInt32(0);
  public final PBInt64Field tplink_key = PBField.initInt64(0L);
  public final PBUInt32Field upload_appid = PBField.initUInt32(0);
  public final PBStringField upload_ipaddr = PBField.initString("");
  public final PBStringField upload_nickname = PBField.initString("");
  public final PBUInt64Field upload_uin = PBField.initUInt64(0L);
  public final PBStringField weiyun_host = PBField.initString("");
  public final PBInt32Field weiyun_port = PBField.initInt32(0);
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 74, 88, 106, 114, 122, 160, 168, 177, 185, 192, 200, 216, 224, 232, 242, 248, 346, 408, 418, 728, 1202, 1610, 1616, 1624, 1632, 1682, 1688, 1696, 1704, 1712, 1720, 1728, 1754, 2410, 3210, 4008, 6410 }, new String[] { "dev_mac", "dev_show_type", "dev_type", "dev_name", "dev_os", "app_name", "take_dev_type", "backup_flag", "thumb_url", "cookie_name", "cookie_value", "ext_status", "take_time", "longitude", "latitude", "group_id", "from_source", "width", "height", "org_file_size", "org_file_sha", "orientation", "music_detail_info", "upload_appid", "origin_pic_sha", "long_time", "event_id", "weiyun_host", "weiyun_port", "can_accel", "tplink_key", "batch_id", "number", "total_num", "upload_uin", "album_owner_uin", "comment_count", "like_count", "upload_nickname", "app_data", "upload_ipaddr", "overwrite", "ower_info" }, new Object[] { "", Integer.valueOf(0), "", "", "", "", "", Boolean.valueOf(false), "", "", "", Integer.valueOf(0), Long.valueOf(0L), Double.valueOf(0.0D), Double.valueOf(0.0D), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), "", "", Integer.valueOf(0), Boolean.valueOf(false), Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), null }, FileExtInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.FileExtInfo
 * JD-Core Version:    0.7.0.1
 */