package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6cf$AppAdInfo
  extends MessageMicro<AppAdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_app_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_app_download_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_app_open_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_clipboard_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_bundle = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_schema = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "bytes_icon_url", "bytes_name", "uint32_jump_type", "bytes_jump_url", "bytes_jump_bundle", "bytes_jump_schema", "bytes_app_download_wording", "bytes_app_open_wording", "bytes_app_desc", "bytes_clipboard_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9 }, AppAdInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AppAdInfo
 * JD-Core Version:    0.7.0.1
 */