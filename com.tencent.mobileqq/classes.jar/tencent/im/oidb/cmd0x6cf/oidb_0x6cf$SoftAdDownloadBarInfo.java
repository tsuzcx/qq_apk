package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6cf$SoftAdDownloadBarInfo
  extends MessageMicro<SoftAdDownloadBarInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_big_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_small_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sub_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x6cf.UrlJumpInfo msg_url_jump_info = new oidb_0x6cf.UrlJumpInfo();
  public final PBUInt32Field uint32_change_bigger_position = PBField.initUInt32(0);
  public final PBUInt32Field uint32_style = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 56 }, new String[] { "bytes_title", "bytes_sub_title", "bytes_small_icon_url", "bytes_big_icon_url", "uint32_change_bigger_position", "msg_url_jump_info", "uint32_style" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), null, Integer.valueOf(0) }, SoftAdDownloadBarInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.SoftAdDownloadBarInfo
 * JD-Core Version:    0.7.0.1
 */