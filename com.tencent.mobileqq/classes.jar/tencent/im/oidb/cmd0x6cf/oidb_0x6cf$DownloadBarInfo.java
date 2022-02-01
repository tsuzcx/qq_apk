package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6cf$DownloadBarInfo
  extends MessageMicro<DownloadBarInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_download_button_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_logo_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_open_button_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x6cf.UrlJumpInfo msg_url_jump_info = new oidb_0x6cf.UrlJumpInfo();
  public final PBUInt32Field uint32_appear_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_button_bg_color = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58 }, new String[] { "uint32_appear_time", "bytes_logo_url", "bytes_download_button_text", "bytes_open_button_text", "uint32_button_bg_color", "msg_url_jump_info", "bytes_common_data" }, new Object[] { localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localInteger, null, localByteStringMicro4 }, DownloadBarInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.DownloadBarInfo
 * JD-Core Version:    0.7.0.1
 */