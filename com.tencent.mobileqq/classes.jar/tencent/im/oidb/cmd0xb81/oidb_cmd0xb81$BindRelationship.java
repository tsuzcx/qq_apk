package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb81$BindRelationship
  extends MessageMicro<BindRelationship>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field bind_type = PBField.initUInt32(0);
  public final PBRepeatField<Long> rpt_merge_slave = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> rpt_slave = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<oidb_cmd0xb81.UpgcAccountInfo> rpt_upgc_account_info = PBField.initRepeatMessage(oidb_cmd0xb81.UpgcAccountInfo.class);
  public final PBRepeatMessageField<oidb_cmd0xb81.SmallUserInfo> rpt_user_info = PBField.initRepeatMessage(oidb_cmd0xb81.SmallUserInfo.class);
  public final PBUInt32Field uint32_state_ext = PBField.initUInt32(0);
  public final PBUInt64Field uint64_master = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_merge_master = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 40, 104, 112, 120, 802, 818 }, new String[] { "uint64_master", "rpt_slave", "bind_type", "uint32_state_ext", "uint64_merge_master", "rpt_merge_slave", "rpt_upgc_account_info", "rpt_user_info" }, new Object[] { localLong, localLong, localInteger, localInteger, localLong, localLong, null, null }, BindRelationship.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.BindRelationship
 * JD-Core Version:    0.7.0.1
 */