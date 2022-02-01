package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_putinfo$PutinfoHead
  extends MessageMicro<PutinfoHead>
{
  public static final int CMD_CLIENT_REPORT_REQ = 1;
  public static final int CMD_S2C_PUTINFO_REQ = 2;
  public static final int ERR_DECODE_REQUEST = 1;
  public static final int ERR_UNKNOWN = 255;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_config_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_body_type = PBField.initEnum(1);
  public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 58 }, new String[] { "enum_body_type", "uint64_uin", "bytes_appid", "uint64_seq", "uint32_error_no", "bytes_error_msg", "bytes_config_ver" }, new Object[] { Integer.valueOf(1), localLong, localByteStringMicro1, localLong, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, PutinfoHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.longconn.putinfo.hd_video_putinfo.PutinfoHead
 * JD-Core Version:    0.7.0.1
 */