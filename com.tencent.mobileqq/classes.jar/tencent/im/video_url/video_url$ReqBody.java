package tencent.im.video_url;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class video_url$ReqBody
  extends MessageMicro
{
  public static final int BYTES_MACHINE_INFO_FIELD_NUMBER = 3;
  public static final int BYTES_MOBILEQ_VER_FIELD_NUMBER = 6;
  public static final int BYTES_SHARE_URL_FIELD_NUMBER = 1;
  public static final int UINT32_CUR_PLAY_TIME_FIELD_NUMBER = 5;
  public static final int UINT32_NETWORK_TYPE_FIELD_NUMBER = 4;
  public static final int UINT32_PLATFORM_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_machine_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_mobileQ_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_cur_play_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "bytes_share_url", "uint32_platform_type", "bytes_machine_info", "uint32_network_type", "uint32_cur_play_time", "bytes_mobileQ_ver" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.video_url.video_url.ReqBody
 * JD-Core Version:    0.7.0.1
 */