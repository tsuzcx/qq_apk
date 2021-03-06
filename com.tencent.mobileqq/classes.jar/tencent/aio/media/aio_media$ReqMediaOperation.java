package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media$ReqMediaOperation
  extends MessageMicro<ReqMediaOperation>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField enum_aio_type = PBField.initEnum(1);
  public final PBEnumField enum_cut_type = PBField.initEnum(1);
  public final PBEnumField enum_operation = PBField.initEnum(1);
  public final PBEnumField enum_play_mode = PBField.initEnum(1);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(1);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "enum_aio_type", "uint64_id", "enum_operation", "enum_play_mode", "enum_cut_type" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, localInteger, localInteger }, ReqMediaOperation.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.aio.media.aio_media.ReqMediaOperation
 * JD-Core Version:    0.7.0.1
 */