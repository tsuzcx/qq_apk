package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_putinfo$CmdReportClientInfoReqBody
  extends MessageMicro<CmdReportClientInfoReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_app_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_client_system_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_device_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_mobile_rom_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public hd_video_putinfo.MobileHardWareValue msg_device_info = new hd_video_putinfo.MobileHardWareValue();
  public hd_video_putinfo.VideoHardWareInfo msg_video_info = new hd_video_putinfo.VideoHardWareInfo();
  public final PBUInt32Field uint32_instid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mobile_os_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mobile_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_open_general_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sharp_sdk_ver = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 72, 80, 90 }, new String[] { "uint32_mobile_type", "uint32_mobile_os_info", "uint32_instid", "bytes_client_system_info", "bytes_device_info", "msg_device_info", "msg_video_info", "bytes_mobile_rom_info", "uint32_sharp_sdk_ver", "uint32_open_general_info", "bytes_app_version" }, new Object[] { localInteger, localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, null, null, localByteStringMicro3, localInteger, localInteger, localByteStringMicro4 }, CmdReportClientInfoReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.longconn.putinfo.hd_video_putinfo.CmdReportClientInfoReqBody
 * JD-Core Version:    0.7.0.1
 */