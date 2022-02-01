package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xc7$RelationalChainChange
  extends MessageMicro<RelationalChainChange>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public submsgtype0xc7.RelationalChainInfo msg_relational_chain_info_new = new submsgtype0xc7.RelationalChainInfo();
  public submsgtype0xc7.RelationalChainInfo msg_relational_chain_info_old = new submsgtype0xc7.RelationalChainInfo();
  public submsgtype0xc7.ToDegradeInfo msg_to_degrade_info = new submsgtype0xc7.ToDegradeInfo();
  public final PBRepeatMessageField<submsgtype0xc7.RelationalChainInfos> rpt_relational_chain_infos = PBField.initRepeatMessage(submsgtype0xc7.RelationalChainInfos.class);
  public final PBRepeatField<Integer> rpt_uint32_feature_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBEnumField uint32_change_type = PBField.initEnum(1);
  public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 162, 800 }, new String[] { "uint64_appid", "uint64_src_uin", "uint64_dst_uin", "uint32_change_type", "msg_relational_chain_info_old", "msg_relational_chain_info_new", "msg_to_degrade_info", "rpt_relational_chain_infos", "rpt_uint32_feature_id" }, new Object[] { localLong, localLong, localLong, Integer.valueOf(1), null, null, null, null, Integer.valueOf(0) }, RelationalChainChange.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange
 * JD-Core Version:    0.7.0.1
 */