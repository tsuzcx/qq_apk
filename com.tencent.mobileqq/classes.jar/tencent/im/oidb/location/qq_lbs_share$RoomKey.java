package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_lbs_share$RoomKey
  extends MessageMicro<RoomKey>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField aio_type = PBField.initEnum(1);
  public final PBUInt64Field id1 = PBField.initUInt64(0L);
  public final PBUInt64Field id2 = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "aio_type", "id1", "id2" }, new Object[] { Integer.valueOf(1), localLong, localLong }, RoomKey.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.location.qq_lbs_share.RoomKey
 * JD-Core Version:    0.7.0.1
 */