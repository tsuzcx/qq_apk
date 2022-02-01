package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class aio_media$SongExtendedReqParam
  extends MessageMicro<SongExtendedReqParam>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_need_lyric = PBField.initBool(false);
  public final PBBoolField bool_need_url = PBField.initBool(false);
  public final PBStringField str_song_id = PBField.initString("");
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "str_song_id", "bool_need_url", "bool_need_lyric" }, new Object[] { "", localBoolean, localBoolean }, SongExtendedReqParam.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.aio.media.aio_media.SongExtendedReqParam
 * JD-Core Version:    0.7.0.1
 */