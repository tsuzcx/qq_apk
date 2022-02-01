package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media$ReqLatestPlayingState
  extends MessageMicro<ReqLatestPlayingState>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "enum_aio_type", "uint64_id", "uint32_version" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Integer.valueOf(0) }, ReqLatestPlayingState.class);
  public final PBEnumField enum_aio_type = PBField.initEnum(1);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.aio.media.aio_media.ReqLatestPlayingState
 * JD-Core Version:    0.7.0.1
 */