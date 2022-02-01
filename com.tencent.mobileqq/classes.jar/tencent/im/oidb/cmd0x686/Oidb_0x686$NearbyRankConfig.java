package tencent.im.oidb.cmd0x686;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x686$NearbyRankConfig
  extends MessageMicro<NearbyRankConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_rank_sw", "rpt_msg_title_configs" }, new Object[] { Integer.valueOf(0), null }, NearbyRankConfig.class);
  public final PBRepeatMessageField<Oidb_0x686.RankTitleConfig> rpt_msg_title_configs = PBField.initRepeatMessage(Oidb_0x686.RankTitleConfig.class);
  public final PBUInt32Field uint32_rank_sw = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig
 * JD-Core Version:    0.7.0.1
 */