package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeiyunPB$DiskFileDownloadRspItem
  extends MessageMicro<DiskFileDownloadRspItem>
{
  public static final int CHANNEL_COUNT_FIELD_NUMBER = 25;
  public static final int COOKIE_NAME_FIELD_NUMBER = 5;
  public static final int COOKIE_VALUE_FIELD_NUMBER = 6;
  public static final int DOWNLOAD_URL_FIELD_NUMBER = 13;
  public static final int ENCODE_URL_FIELD_NUMBER = 2;
  public static final int FILE_ID_FIELD_NUMBER = 7;
  public static final int FILE_MD5_FIELD_NUMBER = 8;
  public static final int FILE_MTIME_FIELD_NUMBER = 10;
  public static final int INSIDE_DOWNLOAD_IP_FIELD_NUMBER = 11;
  public static final int OUTSIDE_DOWNLOAD_IP_FIELD_NUMBER = 12;
  public static final int RETCODE_FIELD_NUMBER = 1;
  public static final int RETMSG_FIELD_NUMBER = 21;
  public static final int SERVER_NAME_FIELD_NUMBER = 3;
  public static final int SERVER_PORT_FIELD_NUMBER = 4;
  public static final int VIDEO_URL_FIELD_NUMBER = 9;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field channel_count = PBField.initUInt32(0);
  public final PBStringField cookie_name = PBField.initString("");
  public final PBStringField cookie_value = PBField.initString("");
  public final PBStringField download_url = PBField.initString("");
  public final PBBytesField encode_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField file_id = PBField.initString("");
  public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field file_mtime = PBField.initUInt64(0L);
  public final PBStringField inside_download_ip = PBField.initString("");
  public final PBStringField outside_download_ip = PBField.initString("");
  public final PBInt32Field retcode = PBField.initInt32(0);
  public final PBStringField retmsg = PBField.initString("");
  public final PBStringField server_name = PBField.initString("");
  public final PBUInt32Field server_port = PBField.initUInt32(0);
  public final PBStringField video_url = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 74, 80, 90, 98, 106, 170, 200 }, new String[] { "retcode", "encode_url", "server_name", "server_port", "cookie_name", "cookie_value", "file_id", "file_md5", "video_url", "file_mtime", "inside_download_ip", "outside_download_ip", "download_url", "retmsg", "channel_count" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, "", Integer.valueOf(0), "", "", "", localByteStringMicro2, "", Long.valueOf(0L), "", "", "", "", Integer.valueOf(0) }, DiskFileDownloadRspItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.DiskFileDownloadRspItem
 * JD-Core Version:    0.7.0.1
 */