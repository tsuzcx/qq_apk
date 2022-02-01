package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VideoWriteRequest
  extends MessageMicro<VideoWriteRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 58 }, new String[] { "gid", "categoryId", "matchId", "operType", "targetUin", "roomTitle", "roomCover" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), "", "" }, VideoWriteRequest.class);
  public final PBUInt32Field categoryId = PBField.initUInt32(0);
  public final PBUInt64Field gid = PBField.initUInt64(0L);
  public final PBStringField matchId = PBField.initString("");
  public final PBUInt32Field operType = PBField.initUInt32(0);
  public final PBStringField roomCover = PBField.initString("");
  public final PBStringField roomTitle = PBField.initString("");
  public final PBUInt64Field targetUin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.aio.media.VideoWriteRequest
 * JD-Core Version:    0.7.0.1
 */