package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media$ReqCreateRoom
  extends MessageMicro<ReqCreateRoom>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "enum_aio_type", "uint64_id", "str_song_id", "enum_media_type" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), "", Integer.valueOf(1) }, ReqCreateRoom.class);
  public final PBEnumField enum_aio_type = PBField.initEnum(1);
  public final PBEnumField enum_media_type = PBField.initEnum(1);
  public final PBStringField str_song_id = PBField.initString("");
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.aio.media.aio_media.ReqCreateRoom
 * JD-Core Version:    0.7.0.1
 */