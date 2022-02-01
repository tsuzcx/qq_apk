package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class VideoWriteReply
  extends MessageMicro<VideoWriteReply>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "result", "errmsg", "jumpUrl" }, new Object[] { Integer.valueOf(0), "", "" }, VideoWriteReply.class);
  public final PBStringField errmsg = PBField.initString("");
  public final PBStringField jumpUrl = PBField.initString("");
  public final PBUInt32Field result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.aio.media.VideoWriteReply
 * JD-Core Version:    0.7.0.1
 */