package tencent.im.oidb.oidb_0x8e7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8e7$ZanLimitInfo
  extends MessageMicro<ZanLimitInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<oidb_0x8e7.UserZanInfo> rpt_msg_user_zan_info = PBField.initRepeatMessage(oidb_0x8e7.UserZanInfo.class);
  public final PBUInt64Field uint64_can_free_zan_user_limit = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_free_zan_total_limit = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_free_zan_user = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_level = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_price = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint64_level", "uint64_can_free_zan_user_limit", "uint64_free_zan_user", "uint64_free_zan_total_limit", "uint64_price", "rpt_msg_user_zan_info" }, new Object[] { localLong, localLong, localLong, localLong, localLong, null }, ZanLimitInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ZanLimitInfo
 * JD-Core Version:    0.7.0.1
 */