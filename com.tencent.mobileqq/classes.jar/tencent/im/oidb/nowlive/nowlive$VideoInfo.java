package tencent.im.oidb.nowlive;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class nowlive$VideoInfo
  extends MessageMicro<VideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField video_cover_url = PBField.initString("");
  public final PBStringField video_url = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "vid", "video_url", "video_cover_url" }, new Object[] { localByteStringMicro, "", "" }, VideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.nowlive.nowlive.VideoInfo
 * JD-Core Version:    0.7.0.1
 */