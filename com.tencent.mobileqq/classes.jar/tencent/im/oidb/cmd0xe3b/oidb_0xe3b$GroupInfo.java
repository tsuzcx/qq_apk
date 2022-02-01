package tencent.im.oidb.cmd0xe3b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe3b$GroupInfo
  extends MessageMicro<GroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Long> rpt_uint64_group_manager = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_group_total_person = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_group_id", "uint32_group_type", "uint32_group_total_person", "rpt_uint64_group_manager" }, new Object[] { localLong, localInteger, localInteger, localLong }, GroupInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe3b.oidb_0xe3b.GroupInfo
 * JD-Core Version:    0.7.0.1
 */