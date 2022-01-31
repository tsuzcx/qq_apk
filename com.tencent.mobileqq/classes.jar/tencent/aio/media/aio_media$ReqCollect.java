package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class aio_media$ReqCollect
  extends MessageMicro<ReqCollect>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_song_id" }, new Object[] { "" }, ReqCollect.class);
  public final PBStringField str_song_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.aio.media.aio_media.ReqCollect
 * JD-Core Version:    0.7.0.1
 */