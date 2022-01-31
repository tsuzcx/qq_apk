package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ilive_short_video_label$VideoInfo
  extends MessageMicro<VideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField cover_url = PBField.initString("");
  public final PBStringField url = PBField.initString("");
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "vid", "url", "cover_url" }, new Object[] { localByteStringMicro, "", "" }, VideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.ilive_short_video_label.VideoInfo
 * JD-Core Version:    0.7.0.1
 */