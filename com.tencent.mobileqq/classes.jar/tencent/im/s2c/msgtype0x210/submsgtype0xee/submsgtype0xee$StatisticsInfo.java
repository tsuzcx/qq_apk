package tencent.im.s2c.msgtype0x210.submsgtype0xee;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xee$StatisticsInfo
  extends MessageMicro<StatisticsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_folder_status = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_strategy_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_algorithm_id", "uint64_strategy_id", "uint64_folder_status" }, new Object[] { localLong, localLong, localLong }, StatisticsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.StatisticsInfo
 * JD-Core Version:    0.7.0.1
 */