package tencent.im.oidb.recheck_flag_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class recheck_flag_info$RecheckFlagInfo
  extends MessageMicro<RecheckFlagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_has_redtouch = PBField.initBool(false);
  public final PBRepeatMessageField<recheck_flag_info.RecheckFlagItem> rpt_recheck_list = PBField.initRepeatMessage(recheck_flag_info.RecheckFlagItem.class);
  public final PBUInt32Field uint32_recheck_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_fuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_uin", "uint64_fuin", "bool_has_redtouch", "uint32_recheck_num", "rpt_recheck_list" }, new Object[] { localLong, localLong, Boolean.valueOf(false), Integer.valueOf(0), null }, RecheckFlagInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.recheck_flag_info.recheck_flag_info.RecheckFlagInfo
 * JD-Core Version:    0.7.0.1
 */