package tencent.aio.media;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media$ReqReportDownloadFail
  extends MessageMicro<ReqReportDownloadFail>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_song_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_song_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_aio_type = PBField.initEnum(1);
  public final PBRepeatField<ByteStringMicro> rpt_bytes_singer = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBStringField str_song_id = PBField.initString("");
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "enum_aio_type", "uint64_id", "str_song_id", "bytes_song_name", "rpt_bytes_singer", "bytes_song_url" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ReqReportDownloadFail.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.aio.media.aio_media.ReqReportDownloadFail
 * JD-Core Version:    0.7.0.1
 */