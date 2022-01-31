package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeiyunPB$QqSdkFileUploadMsgRsp
  extends MessageMicro<QqSdkFileUploadMsgRsp>
{
  public static final int CHANNEL_COUNT_FIELD_NUMBER = 25;
  public static final int CHECK_KEY_FIELD_NUMBER = 7;
  public static final int DUP_ITEM_FIELD_NUMBER = 21;
  public static final int FILENAME_FIELD_NUMBER = 2;
  public static final int FILE_CTIME_FIELD_NUMBER = 3;
  public static final int FILE_EXIST_FIELD_NUMBER = 8;
  public static final int FILE_ID_FIELD_NUMBER = 1;
  public static final int FILE_KEY_FIELD_NUMBER = 10;
  public static final int FILE_MTIME_FIELD_NUMBER = 23;
  public static final int FILE_VERSION_FIELD_NUMBER = 9;
  public static final int FLOW_FILE_SIZE_FIELD_NUMBER = 40;
  public static final int INSIDE_UPLOAD_IP_FIELD_NUMBER = 11;
  public static final int LIB_ID_FIELD_NUMBER = 16;
  public static final int NEED_ADD_EVERY_DAY_FIELD_NUMBER = 30;
  public static final int OUTSIDE_UPLOAD_IP_FIELD_NUMBER = 12;
  public static final int PDIR_KEY_FIELD_NUMBER = 101;
  public static final int PDIR_MTIME_FIELD_NUMBER = 4;
  public static final int PPDIR_KEY_FIELD_NUMBER = 100;
  public static final int REMAIN_FLOW_SIZE_FIELD_NUMBER = 50;
  public static final int SERVER_NAME_FIELD_NUMBER = 5;
  public static final int SERVER_PORT_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field channel_count = PBField.initUInt32(0);
  public final PBBytesField check_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public WeiyunPB.DirFileDupItem dup_item = new WeiyunPB.DirFileDupItem();
  public final PBUInt64Field file_ctime = PBField.initUInt64(0L);
  public final PBBoolField file_exist = PBField.initBool(false);
  public final PBStringField file_id = PBField.initString("");
  public final PBBytesField file_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field file_mtime = PBField.initUInt64(0L);
  public final PBUInt32Field file_version = PBField.initUInt32(0);
  public final PBStringField filename = PBField.initString("");
  public final PBInt64Field flow_file_size = PBField.initInt64(0L);
  public final PBStringField inside_upload_ip = PBField.initString("");
  public final PBUInt32Field lib_id = PBField.initUInt32(0);
  public final PBBoolField need_add_every_day = PBField.initBool(false);
  public final PBStringField outside_upload_ip = PBField.initString("");
  public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field pdir_mtime = PBField.initUInt64(0L);
  public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field remain_flow_size = PBField.initInt64(0L);
  public final PBStringField server_name = PBField.initString("");
  public final PBUInt32Field server_port = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 58, 64, 72, 82, 90, 98, 128, 170, 184, 200, 240, 320, 400, 802, 810 }, new String[] { "file_id", "filename", "file_ctime", "pdir_mtime", "server_name", "server_port", "check_key", "file_exist", "file_version", "file_key", "inside_upload_ip", "outside_upload_ip", "lib_id", "dup_item", "file_mtime", "channel_count", "need_add_every_day", "flow_file_size", "remain_flow_size", "ppdir_key", "pdir_key" }, new Object[] { "", "", Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), localByteStringMicro1, Boolean.valueOf(false), Integer.valueOf(0), localByteStringMicro2, "", "", Integer.valueOf(0), null, Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4 }, QqSdkFileUploadMsgRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.QqSdkFileUploadMsgRsp
 * JD-Core Version:    0.7.0.1
 */