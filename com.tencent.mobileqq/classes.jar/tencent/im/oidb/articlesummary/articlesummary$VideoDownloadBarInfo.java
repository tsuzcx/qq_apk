package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$VideoDownloadBarInfo
  extends MessageMicro<VideoDownloadBarInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public articlesummary.UrlJumpInfo msg_url_jump_info = new articlesummary.UrlJumpInfo();
  public final PBUInt32Field uint32_appear_style = PBField.initUInt32(0);
  public final PBUInt32Field uint32_appear_time = PBField.initUInt32(0);
  public articlesummary.WeishiUGInfo weishiUGInfo = new articlesummary.WeishiUGInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58 }, new String[] { "uint32_appear_style", "uint32_appear_time", "bytes_icon_url", "bytes_icon_text", "msg_url_jump_info", "bytes_common_data", "weishiUGInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null, localByteStringMicro3, null }, VideoDownloadBarInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo
 * JD-Core Version:    0.7.0.1
 */