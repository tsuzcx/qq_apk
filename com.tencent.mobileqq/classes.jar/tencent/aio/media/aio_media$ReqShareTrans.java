package tencent.aio.media;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media$ReqShareTrans
  extends MessageMicro<ReqShareTrans>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_cut_song = PBField.initBool(false);
  public final PBBytesField bytes_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_song_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_song_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_aio_type = PBField.initEnum(1);
  public final PBRepeatField<ByteStringMicro> rpt_bytes_singer = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBStringField str_song_id = PBField.initString("");
  public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
  public final PBUInt32Field uint32_share_appid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sharer_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56, 66, 72, 80, 90 }, new String[] { "enum_aio_type", "uint64_id", "uint32_share_appid", "bytes_song_name", "rpt_bytes_singer", "bytes_song_url", "bool_cut_song", "str_song_id", "uint32_duration", "uint64_sharer_uin", "bytes_cover" }, new Object[] { Integer.valueOf(1), localLong, localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Boolean.valueOf(false), "", localInteger, localLong, localByteStringMicro4 }, ReqShareTrans.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.aio.media.aio_media.ReqShareTrans
 * JD-Core Version:    0.7.0.1
 */