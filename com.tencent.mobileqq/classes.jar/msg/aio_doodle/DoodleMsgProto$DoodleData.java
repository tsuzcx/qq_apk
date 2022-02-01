package msg.aio_doodle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DoodleMsgProto$DoodleData
  extends MessageMicro<DoodleData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<DoodleMsgProto.LineData> rpt_line_Data = PBField.initRepeatMessage(DoodleMsgProto.LineData.class);
  public final PBUInt32Field uint32_rgba = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32template_id = PBField.initUInt32(0);
  public final PBUInt32Field uint_line_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint_line_id", "uint32template_id", "uint32_rgba", "uint32_time", "rpt_line_Data" }, new Object[] { localInteger, localInteger, localInteger, localInteger, null }, DoodleData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msg.aio_doodle.DoodleMsgProto.DoodleData
 * JD-Core Version:    0.7.0.1
 */