package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x6cf$UGDownloadBarInfo
  extends MessageMicro<UGDownloadBarInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x6cf.UrlJumpInfo msg_url_jump_info = new oidb_0x6cf.UrlJumpInfo();
  public oidb_0x6cf.WeishiUGInfo weishiUGInfo = new oidb_0x6cf.WeishiUGInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_title", "bytes_icon_url", "msg_url_jump_info", "weishiUGInfo" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, null }, UGDownloadBarInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UGDownloadBarInfo
 * JD-Core Version:    0.7.0.1
 */