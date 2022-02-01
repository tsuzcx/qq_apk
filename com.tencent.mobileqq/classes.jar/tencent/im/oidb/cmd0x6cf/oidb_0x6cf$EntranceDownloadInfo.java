package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6cf$EntranceDownloadInfo
  extends MessageMicro<EntranceDownloadInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_column_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_entrance_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_small_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sub_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x6cf.UrlJumpInfo msg_url_jump_info = new oidb_0x6cf.UrlJumpInfo();
  public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_use_gif = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 58, 66, 74, 82 }, new String[] { "bytes_icon_url", "bytes_small_icon_url", "uint32_is_use_gif", "msg_url_jump_info", "bytes_common_data", "uint32_column_id", "bytes_column_name", "bytes_sub_text", "bytes_entrance_cookie", "bytes_rowkey" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localInteger, null, localByteStringMicro3, localInteger, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, EntranceDownloadInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.EntranceDownloadInfo
 * JD-Core Version:    0.7.0.1
 */