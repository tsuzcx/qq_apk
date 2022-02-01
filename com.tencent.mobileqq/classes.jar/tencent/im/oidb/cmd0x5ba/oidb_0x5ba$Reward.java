package tencent.im.oidb.cmd0x5ba;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x5ba$Reward
  extends MessageMicro<Reward>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<oidb_0x5ba.RewardItem> rpt_rewards = PBField.initRepeatMessage(oidb_0x5ba.RewardItem.class);
  public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myreward_totalcount = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myreward_totalincome = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_myreward_totalincome", "uint32_myreward_totalcount", "uint32_is_end", "rpt_rewards" }, new Object[] { localInteger, localInteger, localInteger, null }, Reward.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5ba.oidb_0x5ba.Reward
 * JD-Core Version:    0.7.0.1
 */