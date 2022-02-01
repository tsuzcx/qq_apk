package msg.aio_doodle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DoodleMsgProto$LineData
  extends MessageMicro<LineData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 24 }, new String[] { "float_X", "float_Y", "uint64_tickcount" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Long.valueOf(0L) }, LineData.class);
  public final PBFloatField float_X = PBField.initFloat(0.0F);
  public final PBFloatField float_Y = PBField.initFloat(0.0F);
  public final PBUInt64Field uint64_tickcount = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msg.aio_doodle.DoodleMsgProto.LineData
 * JD-Core Version:    0.7.0.1
 */