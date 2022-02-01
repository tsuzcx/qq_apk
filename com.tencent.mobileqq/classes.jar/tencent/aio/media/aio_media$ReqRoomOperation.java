package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media$ReqRoomOperation
  extends MessageMicro<ReqRoomOperation>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField enum_aio_type = PBField.initEnum(1);
  public final PBEnumField enum_media_type = PBField.initEnum(1);
  public final PBEnumField enum_room_operation = PBField.initEnum(1);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(1);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "enum_aio_type", "uint64_id", "enum_room_operation", "enum_media_type" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, localInteger }, ReqRoomOperation.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.aio.media.aio_media.ReqRoomOperation
 * JD-Core Version:    0.7.0.1
 */