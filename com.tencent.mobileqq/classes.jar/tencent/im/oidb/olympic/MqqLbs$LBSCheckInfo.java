package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MqqLbs$LBSCheckInfo
  extends MessageMicro<LBSCheckInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint32_fake_period", "uint32_fake_times", "rpt_msg_lbs_fake_info", "rpt_msg_cheat_app", "uint32_root_jailbreak" }, new Object[] { Integer.valueOf(60), Integer.valueOf(0), null, null, Integer.valueOf(0) }, LBSCheckInfo.class);
  public final PBRepeatMessageField<MqqLbs.CheatApp> rpt_msg_cheat_app = PBField.initRepeatMessage(MqqLbs.CheatApp.class);
  public final PBRepeatMessageField<MqqLbs.LBSFakeInfo> rpt_msg_lbs_fake_info = PBField.initRepeatMessage(MqqLbs.LBSFakeInfo.class);
  public final PBUInt32Field uint32_fake_period = PBField.initUInt32(60);
  public final PBUInt32Field uint32_fake_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_root_jailbreak = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.olympic.MqqLbs.LBSCheckInfo
 * JD-Core Version:    0.7.0.1
 */